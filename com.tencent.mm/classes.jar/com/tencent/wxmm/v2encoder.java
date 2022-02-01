package com.tencent.wxmm;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

public class v2encoder
{
  public static int EMethodGetQosPara = 0;
  public static final int EMethodGetRemoteHW = 26;
  public static final int ENUM_AVCEncCfgERROR = 2003;
  public static final int ENUM_AVCEncCreateERROR = 2002;
  public static final int ENUM_AVCEncERROR = 2004;
  public static final int ENUM_AVCEncNotFound = 2001;
  public static final int ENUM_AVCEncOK = 2000;
  public static final boolean SAVEVIDEOSTREAM = true;
  public static short[] SizeFormat2WH;
  private static final String TAG = "v2encoder";
  public static final int VFMT_420SP = 7;
  public static final int VFMT_HEVC_HW = 19;
  public static final int VFMT_ROTATE = 32;
  public static final int VFMT_i264 = 18;
  public static final byte enumCODEC_Vcodec2_hw = 4;
  public static final byte enumCODEC_f264 = 1;
  public static final byte enumCODEC_i264 = 8;
  public static final byte enumCODEC_vcodec2 = 16;
  public static int frameID;
  private static String path;
  private static int streamqueuesize;
  private static final String[] supportedH264HwCodecPrefixes;
  public String ENCODING;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public boolean isRuning;
  public long mGeneratedIdx;
  int mPrevResolution;
  int mProfileCfg;
  public v2service mProtocol;
  int m_CapH;
  int m_CapW;
  int m_br_kbps;
  int m_framerate;
  int m_height;
  int m_width;
  private MediaCodec mediaCodec;
  protected MediaFormat mediaFormat;
  private BufferedOutputStream outputStream;
  v2stqos stQoS;
  
  static
  {
    AppMethodBeat.i(40791);
    streamqueuesize = 100;
    frameID = 0;
    path = Environment.getExternalStorageDirectory().getAbsolutePath();
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi" };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(40791);
  }
  
  public v2encoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, v2service paramv2service)
  {
    AppMethodBeat.i(40780);
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mediaCodec = null;
    this.mProfileCfg = 1;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.isRuning = false;
    this.encLen = 0;
    this.mPrevResolution = 8;
    this.m_width = paramInt1;
    this.m_height = paramInt2;
    this.m_CapW = paramInt1;
    this.m_CapH = paramInt2;
    this.mProtocol = paramv2service;
    this.m_framerate = paramInt3;
    this.m_br_kbps = paramInt4;
    this.mProfileCfg = paramInt5;
    frameID = 0;
    this.mGeneratedIdx = 0L;
    this.stQoS = new v2stqos();
    AppMethodBeat.o(40780);
  }
  
  private void NV21ToNV12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(40790);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      AppMethodBeat.o(40790);
      return;
    }
    int k = paramInt1 * paramInt2;
    if (paramInt3 == 0)
    {
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, k);
      paramInt1 = j;
      while (paramInt1 < k / 2)
      {
        paramArrayOfByte2[(k + paramInt1)] = paramArrayOfByte1[(k + paramInt1 + 1)];
        paramArrayOfByte2[(k + paramInt1 + 1)] = paramArrayOfByte1[(k + paramInt1)];
        paramInt1 += 2;
      }
    }
    paramInt1 = 0;
    for (;;)
    {
      paramInt2 = i;
      if (paramInt1 >= k) {
        break;
      }
      paramArrayOfByte2[paramInt1] = paramArrayOfByte1[(k - 1 - paramInt1)];
      paramInt1 += 1;
    }
    while (paramInt2 < k / 2)
    {
      paramArrayOfByte2[(k + paramInt2)] = paramArrayOfByte1[(k / 2 + k - 1 - paramInt2)];
      paramInt2 += 1;
    }
    AppMethodBeat.o(40790);
  }
  
  @SuppressLint({"NewApi"})
  private void StopEncoder()
  {
    AppMethodBeat.i(40783);
    try
    {
      if (this.mediaCodec != null)
      {
        this.mediaCodec.stop();
        this.mediaCodec.release();
      }
      AppMethodBeat.o(40783);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder(" error523:").append(localException.toString());
      AppMethodBeat.o(40783);
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean SupportAvcCodec(String paramString, int paramInt)
  {
    AppMethodBeat.i(40775);
    boolean bool2 = false;
    boolean bool1 = false;
    if (Build.VERSION.SDK_INT >= 18)
    {
      int i = MediaCodecList.getCodecCount() - 1;
      for (;;)
      {
        bool2 = bool1;
        if (i < 0) {
          break;
        }
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        new StringBuilder("codecInfo : ").append(localMediaCodecInfo.getName());
        bool2 = bool1;
        if (localMediaCodecInfo.isEncoder())
        {
          String[] arrayOfString1 = localMediaCodecInfo.getSupportedTypes();
          String str = localMediaCodecInfo.getName();
          int j = 0;
          for (;;)
          {
            bool2 = bool1;
            if (j >= arrayOfString1.length) {
              break;
            }
            bool2 = bool1;
            if (arrayOfString1[j].equalsIgnoreCase(paramString))
            {
              String[] arrayOfString2 = supportedH264HwCodecPrefixes;
              int n = arrayOfString2.length;
              int k = 0;
              for (;;)
              {
                bool2 = bool1;
                if (k >= n) {
                  break;
                }
                bool2 = bool1;
                if (str.startsWith(arrayOfString2[k]))
                {
                  bool2 = bool1;
                  try
                  {
                    MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType(paramString).profileLevels;
                    bool2 = bool1;
                    int i1 = arrayOfCodecProfileLevel.length;
                    int m = 0;
                    for (;;)
                    {
                      bool2 = bool1;
                      if (m >= i1) {
                        break;
                      }
                      MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[m];
                      boolean bool3 = bool1;
                      bool2 = bool1;
                      if (localCodecProfileLevel.profile == paramInt) {
                        bool3 = true;
                      }
                      bool2 = bool3;
                      new StringBuilder("steve : supported profiles:").append(localCodecProfileLevel.profile).append(", MIME:").append(paramString);
                      m += 1;
                      bool1 = bool3;
                    }
                    k += 1;
                  }
                  catch (Exception localException) {}
                }
                bool1 = bool2;
              }
            }
            j += 1;
            bool1 = bool2;
          }
        }
        i -= 1;
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(40775);
    return bool2;
  }
  
  private long computePresentationTime(long paramLong)
  {
    return 132L + 1000000L * paramLong / 15L;
  }
  
  private void createfile(String paramString)
  {
    AppMethodBeat.i(40782);
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      this.outputStream = new BufferedOutputStream(new FileOutputStream(paramString));
      AppMethodBeat.o(40782);
      return;
    }
    catch (Exception paramString)
    {
      new StringBuilder(" error510:").append(paramString.toString());
      AppMethodBeat.o(40782);
    }
  }
  
  private boolean isRecognizedProfile(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(40776);
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        new StringBuilder("selectCodec one : ").append(i).append(arrayOfString);
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString))
          {
            paramString = localMediaCodecInfo.getName();
            new StringBuilder("selectCodec two : ").append(j).append(paramString);
            AppMethodBeat.o(40776);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(40776);
    return null;
  }
  
  @SuppressLint({"NewApi"})
  private void trySetBitRateMode(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(40778);
    try
    {
      if (Build.VERSION.SDK_INT > 21)
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(this.ENCODING);
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.getEncoderCapabilities();
          if (paramMediaCodecInfo != null)
          {
            if (paramMediaCodecInfo.isBitrateModeSupported(2))
            {
              this.mediaFormat.setInteger("bitrate-mode", 2);
              AppMethodBeat.o(40778);
              return;
            }
            if (paramMediaCodecInfo.isBitrateModeSupported(1)) {
              this.mediaFormat.setInteger("bitrate-mode", 1);
            }
          }
        }
      }
      AppMethodBeat.o(40778);
      return;
    }
    catch (Exception paramMediaCodecInfo)
    {
      new StringBuilder("trySetBitRateMode error: ").append(paramMediaCodecInfo.getMessage());
      AppMethodBeat.o(40778);
    }
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    int i = 0;
    AppMethodBeat.i(40777);
    if (Build.VERSION.SDK_INT >= 23) {}
    for (;;)
    {
      try
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(this.ENCODING);
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.profileLevels;
          if (paramMediaCodecInfo != null)
          {
            MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
            localCodecProfileLevel.level = 0;
            localCodecProfileLevel.profile = 0;
            int j = paramMediaCodecInfo.length;
            if (i < j)
            {
              Object localObject = paramMediaCodecInfo[i];
              int k = localObject.profile;
              int m = localObject.level;
              new StringBuilder("profile: ").append(k).append(", level: ").append(m);
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            new StringBuilder("best profile: ").append(localCodecProfileLevel.profile).append(", best level: ").append(localCodecProfileLevel.level);
            if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
            {
              this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
              this.mediaFormat.setInteger("level", 256);
            }
          }
        }
        AppMethodBeat.o(40777);
        return;
      }
      catch (Exception paramMediaCodecInfo)
      {
        new StringBuilder("trySetProfile error: ").append(paramMediaCodecInfo.getMessage());
      }
      AppMethodBeat.o(40777);
      return;
      label272:
      i += 1;
    }
  }
  
  public int DoMediacodecEnc(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(40785);
    Object localObject1 = null;
    new StringBuilder("steve: m_framerate: ").append(this.m_framerate).append(", m_br_kbps:").append(this.m_br_kbps).append(" cwh ").append(this.m_CapW).append(this.m_CapH).append(" ewh ").append(this.m_width).append(this.m_height);
    int i = j;
    Object localObject2;
    if (this.stQoS.cSkipFlag == 0)
    {
      localObject2 = new byte[this.m_CapW * this.m_CapH * 3 / 2];
      NV21ToNV12(paramArrayOfByte, (byte[])localObject2, this.m_width, this.m_height, paramInt & 0x20);
      this.encLen = (this.m_width * this.m_height * 3 >> 1);
      if (this.m_width == this.m_width)
      {
        localObject1 = localObject2;
        i = j;
        if (this.m_height == this.m_height) {}
      }
      else
      {
        this.encLen = (this.m_width * this.m_height * 3 >> 1);
        try
        {
          paramInt = StartEncoder();
          if (paramInt < 0)
          {
            UninitHWEncoder();
            AppMethodBeat.o(40785);
            return paramInt;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            new StringBuilder("mediacodec init error: ").append(paramArrayOfByte.getMessage());
            paramInt = -2003;
          }
          i = paramInt;
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 != null) {
      try
      {
        long l1 = System.currentTimeMillis();
        localObject2 = this.mediaCodec.getInputBuffers();
        paramArrayOfByte = this.mediaCodec.getOutputBuffers();
        paramInt = this.mediaCodec.dequeueInputBuffer(-1L);
        if (paramInt >= 0)
        {
          long l2 = computePresentationTime(this.mGeneratedIdx);
          localObject2 = localObject2[paramInt];
          ((ByteBuffer)localObject2).clear();
          ((ByteBuffer)localObject2).put((byte[])localObject1, 0, this.encLen);
          this.mediaCodec.queueInputBuffer(paramInt, 0, this.encLen, l2, 0);
          this.mGeneratedIdx += 1L;
        }
        localObject1 = new MediaCodec.BufferInfo();
        j = this.mediaCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, this.TIMEOUT_USEC);
        new StringBuilder("put YUV into encoder, size:").append(this.encLen).append(", idx:").append(frameID).append(", time:").append(l1).append("outbuf: ").append(j);
        paramInt = i;
        for (i = j; i >= 0; i = this.mediaCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, this.TIMEOUT_USEC))
        {
          new StringBuilder("Get H264 Buffer Success! flag = ").append(((MediaCodec.BufferInfo)localObject1).flags).append(", enc size = ").append(((MediaCodec.BufferInfo)localObject1).size).append(",pts = ").append(((MediaCodec.BufferInfo)localObject1).presentationTimeUs);
          localObject2 = paramArrayOfByte[i];
          byte[] arrayOfByte = new byte[((MediaCodec.BufferInfo)localObject1).size];
          ((ByteBuffer)localObject2).get(arrayOfByte);
          if (this.outputStream != null) {
            this.outputStream.write(arrayOfByte, 0, arrayOfByte.length);
          }
          putH2645Data(arrayOfByte, ((MediaCodec.BufferInfo)localObject1).flags, arrayOfByte.length);
          new StringBuilder("Protobuf  ").append(((MediaCodec.BufferInfo)localObject1).size).append(" : ").append(arrayOfByte.length);
          paramInt = ((MediaCodec.BufferInfo)localObject1).flags;
          frameID += 1;
          this.mediaCodec.releaseOutputBuffer(i, false);
        }
        AppMethodBeat.o(40785);
      }
      catch (Exception paramArrayOfByte)
      {
        new StringBuilder(" error495:").append(paramArrayOfByte.toString());
        paramInt = -2004;
      }
    }
    for (;;)
    {
      return paramInt;
      paramInt = i;
    }
  }
  
  public void DoQosSvrCtrl()
  {
    AppMethodBeat.i(40786);
    if (this.mProtocol != null)
    {
      if (this.mProtocol.setAppCmd(EMethodGetQosPara, this.stQoS.s2p, this.stQoS.s2p.length) >= 0)
      {
        this.stQoS.parseS2PData();
        this.stQoS.printS2P();
      }
      if (this.stQoS.iKbps != this.m_br_kbps)
      {
        SetBitRate(this.m_br_kbps);
        this.m_br_kbps = this.stQoS.iKbps;
        new StringBuilder("steve[QoS]: Update BR! frameID: ").append(frameID).append(", new_br: ").append(this.m_br_kbps);
      }
      if (1 == this.stQoS.cIReqFlag)
      {
        MakeIFrame();
        new StringBuilder("steve[QoS]: Force I Frame! frameID: ").append(frameID);
      }
      if (this.stQoS.cFps != this.m_framerate) {
        this.m_framerate = this.stQoS.cFps;
      }
    }
    AppMethodBeat.o(40786);
  }
  
  public int InitHWEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(40781);
    if (paramBoolean) {}
    for (Object localObject = "video/avc";; localObject = "video/hevc")
    {
      this.ENCODING = ((String)localObject);
      localObject = new byte[4];
      localObject[0] = 0;
      this.mProtocol.setAppCmd(26, (byte[])localObject, 4);
      new StringBuilder("InitHWEncoder remoteHW: ").append(localObject[0]).append(localObject[1]).append(localObject[2]).append(localObject[3]);
      if (!paramBoolean) {
        break;
      }
      if (((localObject[0] & 0x1) != 0) || ((localObject[0] & 0x8) != 0)) {
        break label137;
      }
      AppMethodBeat.o(40781);
      return -2;
    }
    if (((localObject[0] & 0x10) == 0) && ((localObject[0] & 0x4) == 0))
    {
      AppMethodBeat.o(40781);
      return -3;
    }
    label137:
    int i;
    try
    {
      i = StartEncoder();
      if (i < 0)
      {
        AppMethodBeat.o(40781);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new StringBuilder("mediacodec init error: ").append(localException.getMessage());
        i = -2003;
      }
      createfile(path + "/AVLog/mediacodec.h264");
      AppMethodBeat.o(40781);
    }
    return i;
  }
  
  @SuppressLint({"NewApi"})
  public void MakeIFrame()
  {
    AppMethodBeat.i(40788);
    if (this.mediaCodec != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      this.mediaCodec.setParameters(localBundle);
    }
    AppMethodBeat.o(40788);
  }
  
  @SuppressLint({"NewApi"})
  public boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(40787);
    try
    {
      if (this.mediaCodec != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("video-bitrate", paramInt * 1000);
        this.mediaCodec.setParameters(localBundle);
        AppMethodBeat.o(40787);
        return true;
      }
    }
    catch (Exception localException)
    {
      new StringBuilder("steve: setRates failed:").append(localException);
      AppMethodBeat.o(40787);
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public int StartEncoder()
  {
    AppMethodBeat.i(40779);
    if (this.mediaCodec != null) {
      StopEncoder();
    }
    MediaCodecInfo localMediaCodecInfo = selectCodec(this.ENCODING);
    if (localMediaCodecInfo == null)
    {
      new StringBuilder("steve: Unable to find an appropriate codec for ").append(this.ENCODING);
      AppMethodBeat.o(40779);
      return -2001;
    }
    new StringBuilder("steve: found HW codec: ").append(localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 1);
    String str = this.mediaFormat.getString("mime");
    int i;
    if (this.ENCODING.equalsIgnoreCase("video/avc"))
    {
      if ((this.mProfileCfg & 0x4) == 0) {
        break label287;
      }
      i = 1;
      if ((Build.VERSION.SDK_INT < 23) || (i == 0)) {
        break label292;
      }
      if (SupportAvcCodec(str, 8)) {
        this.mediaFormat.setInteger("profile", 8);
      }
    }
    for (;;)
    {
      this.mediaFormat.setInteger("bitrate-mode", 2);
      try
      {
        this.mediaCodec = MediaCodec.createEncoderByType(str);
        new StringBuilder("steve: mediaFormat: ").append(this.mediaFormat);
        this.mediaCodec.configure(this.mediaFormat, null, null, 1);
        this.mediaCodec.start();
        AppMethodBeat.o(40779);
        return 2000;
      }
      catch (Exception localException)
      {
        label287:
        new StringBuilder(" error392:").append(localException.toString());
        AppMethodBeat.o(40779);
      }
      i = 0;
      break;
      label292:
      if (localMediaCodecInfo != null) {
        trySetProfile(localMediaCodecInfo);
      }
    }
    return -2002;
  }
  
  public void UninitHWEncoder()
  {
    AppMethodBeat.i(40784);
    this.isRuning = false;
    try
    {
      StopEncoder();
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
      }
      AppMethodBeat.o(40784);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder(" error401:").append(localException.toString());
      AppMethodBeat.o(40784);
    }
  }
  
  public void putH2645Data(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40789);
    if ((paramArrayOfByte != null) && (this.mProtocol != null))
    {
      int i = 18;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = 19;
      }
      this.mProtocol.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
    }
    AppMethodBeat.o(40789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wxmm.v2encoder
 * JD-Core Version:    0.7.0.1
 */