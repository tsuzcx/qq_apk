package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

@TargetApi(16)
public final class e
{
  public static int EMethodGetQosPara = 25;
  public static short[] SizeFormat2WH;
  public static int VFMT_HEVC_HW;
  public static int VFMT_i264;
  public static int frameID;
  private static String path;
  private static int streamqueuesize = 100;
  private static final String[] supportedH264HwCodecPrefixes;
  public String ENCODING;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public boolean isRuning;
  public int kJZ;
  private byte[] kKa;
  private MediaMuxer kKb;
  private BufferedOutputStream kKc;
  g kKd;
  public int kKe;
  public int kKf;
  public int kKg;
  public int kKh;
  public long mGeneratedIdx;
  private boolean mMuxerStarted;
  int mPrevResolution;
  int mProfileCfg;
  private int mTrackIndex;
  int m_CapH;
  int m_CapW;
  int m_br_kbps;
  int m_framerate;
  int m_height;
  int m_width;
  MediaCodec mediaCodec;
  protected MediaFormat mediaFormat;
  private BufferedOutputStream outputStream;
  k ttm;
  public LinkedList<aug> tup;
  public LinkedList<Integer> tuq;
  public int tur;
  e.a tus;
  
  static
  {
    frameID = 0;
    path = com.tencent.mm.compatible.util.e.eQz;
    VFMT_i264 = 18;
    VFMT_HEVC_HW = 19;
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK" };
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    AppMethodBeat.i(4345);
    this.kJZ = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.kKa = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.ttm = null;
    this.tup = new LinkedList();
    this.tuq = new LinkedList();
    this.kKd = null;
    this.kKe = 0;
    this.kKf = 8;
    this.kKg = 0;
    this.kKh = 0;
    this.tur = 0;
    this.isRuning = false;
    this.encLen = 0;
    this.mPrevResolution = 8;
    this.m_width = paramInt1;
    this.m_height = paramInt2;
    this.m_CapW = paramInt1;
    this.m_CapH = paramInt2;
    this.ENCODING = paramString;
    this.m_framerate = paramInt3;
    this.m_br_kbps = paramInt4;
    this.mProfileCfg = paramInt5;
    frameID = 0;
    this.mGeneratedIdx = 0L;
    this.tus = new e.a(this);
    this.mediaCodec = null;
    this.kKf = 8;
    this.kKe = 0;
    this.kKg = 0;
    this.kJZ = 0;
    paramString = new aug();
    paramString.xjc = 1L;
    paramString.xjd = 24;
    paramString.xje = 1L;
    paramString.xjf = 24;
    paramString.xjg = 0L;
    paramString.xjh = 0;
    this.tup.add(paramString);
    this.tuq.add(Integer.valueOf(0));
    this.kKa = null;
    this.kKh = 0;
    this.tur = 0;
    AppMethodBeat.o(4345);
  }
  
  @SuppressLint({"NewApi"})
  private void StopEncoder()
  {
    AppMethodBeat.i(4346);
    try
    {
      if (this.mediaCodec != null)
      {
        this.mediaCodec.stop();
        this.mediaCodec.release();
      }
      AppMethodBeat.o(4346);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
      AppMethodBeat.o(4346);
    }
  }
  
  private static boolean a(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool2 = false;
    AppMethodBeat.i(4343);
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    String[] arrayOfString = supportedH264HwCodecPrefixes;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramMediaCodecInfo.startsWith(arrayOfString[i]))
        {
          bool1 = true;
          ab.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
        }
      }
      else
      {
        AppMethodBeat.o(4343);
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(140139);
    bool2 = false;
    bool1 = bool2;
    if (d.fv(23))
    {
      for (;;)
      {
        try
        {
          paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
          bool1 = bool2;
          if (paramMediaCodecInfo == null) {
            continue;
          }
          paramMediaCodecInfo = paramMediaCodecInfo.profileLevels;
          bool1 = bool2;
          if (paramMediaCodecInfo == null) {
            continue;
          }
          paramString = new MediaCodecInfo.CodecProfileLevel();
          paramString.level = 0;
          paramString.profile = 0;
          int k = paramMediaCodecInfo.length;
          i = 0;
          if (i >= k) {
            continue;
          }
          Object localObject = paramMediaCodecInfo[i];
          m = localObject.profile;
          n = localObject.level;
          bool1 = false;
          switch (m)
          {
          }
        }
        catch (Exception paramMediaCodecInfo)
        {
          int i;
          int m;
          int n;
          boolean bool3;
          ab.e("MeidaCodec[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
          bool1 = bool2;
          continue;
          int j = 0;
          continue;
          j = 1;
          continue;
        }
        if (j != 0)
        {
          bool3 = true;
          bool1 = bool3;
          if (m >= paramString.profile)
          {
            bool1 = bool3;
            if (n >= paramString.level)
            {
              bool1 = bool3;
              if (m <= paramInt)
              {
                paramString.profile = m;
                paramString.level = n;
                bool1 = bool3;
              }
            }
          }
        }
        ab.i("MeidaCodec[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      ab.i("MeidaCodec[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
      bool1 = bool2;
      if (paramString.profile > 0)
      {
        bool1 = bool2;
        if (paramString.level >= 256)
        {
          this.mediaFormat.setInteger("profile", paramString.profile);
          this.mediaFormat.setInteger("level", 256);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(140139);
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  private boolean b(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(4341);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool2 = bool3;
      if (8 <= this.kKf)
      {
        String str = paramMediaCodecInfo.getName();
        String[] arrayOfString = supportedH264HwCodecPrefixes;
        int k = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= k) {
            break;
          }
          bool2 = bool1;
          if (str.startsWith(arrayOfString[i]))
          {
            bool2 = bool1;
            try
            {
              MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramMediaCodecInfo.getCapabilitiesForType(paramString).profileLevels;
              bool2 = bool1;
              int m = arrayOfCodecProfileLevel.length;
              int j = 0;
              for (;;)
              {
                bool2 = bool1;
                if (j >= m) {
                  break;
                }
                MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[j];
                bool3 = bool1;
                bool2 = bool1;
                if (localCodecProfileLevel.profile == 8) {
                  bool3 = true;
                }
                bool2 = bool3;
                ab.d("MeidaCodec[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.kKf + ", MIME:" + paramString);
                j += 1;
                bool1 = bool3;
              }
              i += 1;
            }
            catch (Exception localException) {}
          }
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(4341);
    return bool2;
  }
  
  @SuppressLint({"NewApi"})
  private int bhm()
  {
    boolean bool1 = false;
    AppMethodBeat.i(4344);
    if (this.mediaCodec != null) {
      StopEncoder();
    }
    String str = this.ENCODING;
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    int j;
    if (i < k)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        label60:
        if (j < arrayOfString.length) {
          if (arrayOfString[j].equalsIgnoreCase(str)) {
            ab.d("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(localMediaCodecInfo.getName())));
          }
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label169;
      }
      ab.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.kJZ = 2001;
      i = -this.kJZ;
      AppMethodBeat.o(4344);
      return i;
      j += 1;
      break label60;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label169:
    ab.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 4);
    str = this.mediaFormat.getString("mime");
    this.kKe = 1;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.fv(23)))
    {
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x1) == 0)) {
        break label517;
      }
      i = 1;
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x4) == 0)) {
        break label522;
      }
      j = 1;
      label351:
      boolean bool2 = b(localMediaCodecInfo, str);
      if ((j == 0) || (!bool2)) {
        break label527;
      }
      this.mediaFormat.setInteger("profile", 8);
      this.mediaFormat.setInteger("level", 256);
      bool1 = true;
      label398:
      if (!bool1) {
        break label583;
      }
    }
    label517:
    label522:
    label527:
    label583:
    for (this.kKe = this.mediaFormat.getInteger("profile");; this.kKe = 1)
    {
      this.mediaFormat.setInteger("bitrate-mode", 2);
      try
      {
        this.mediaCodec = MediaCodec.createEncoderByType(str);
        ab.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.kKe);
        this.mediaCodec.configure(this.mediaFormat, null, null, 1);
        this.mediaCodec.start();
        this.kKd = new g();
        AppMethodBeat.o(4344);
        return 2000;
      }
      catch (Exception localException)
      {
        ab.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
        this.kJZ = 2002;
        i = -this.kJZ;
        AppMethodBeat.o(4344);
      }
      i = 0;
      break;
      j = 0;
      break label351;
      if (i != 0)
      {
        this.mediaFormat.setInteger("profile", 1);
        this.mediaFormat.setInteger("level", 256);
        bool1 = true;
        break label398;
      }
      if (localMediaCodecInfo == null) {
        break label398;
      }
      bool1 = a(localMediaCodecInfo, str, this.kKf);
      break label398;
    }
    return i;
  }
  
  private static String bn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4348);
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0".concat(String.valueOf(str3));
      }
      str1 = str1 + str2;
      i += 1;
    }
    AppMethodBeat.o(4348);
    return str1;
  }
  
  private static ArrayList<Integer> bo(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4349);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = bn(paramArrayOfByte);
    String str = bn(new byte[] { 0, 0, 0, 1 });
    ab.d("MeidaCodec[HWEnc]", "parent: " + paramArrayOfByte + ", child:" + str);
    for (;;)
    {
      int j = paramArrayOfByte.indexOf(str, i);
      if (j == -1) {
        break;
      }
      ab.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + j);
      i = str.length() + j;
      localArrayList.add(Integer.valueOf(j / 2));
    }
    AppMethodBeat.o(4349);
    return localArrayList;
  }
  
  private int y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155781);
    if ((paramArrayOfByte != null) && (this.ttm.tvj != null))
    {
      int i = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = VFMT_HEVC_HW;
      }
      i = this.ttm.tvj.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
      if (i >= 0)
      {
        this.tur = 0;
        ab.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(155781);
      return paramInt1;
      paramInt1 = this.tur;
      this.tur = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.kJZ = 2008;
        paramInt1 = -this.kJZ;
        ab.e("MeidaCodec[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(paramInt1)));
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public final boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(4351);
    try
    {
      if (this.mediaCodec != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        ab.v("MeidaCodec[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.mediaCodec.setParameters(localBundle);
        AppMethodBeat.o(4351);
        return true;
      }
    }
    catch (Exception localException)
    {
      ab.e("MeidaCodec[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
      AppMethodBeat.o(4351);
    }
    return false;
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(4350);
    int i = 0;
    if ((paramInt1 != this.m_CapW) || (paramInt2 != this.m_CapH))
    {
      this.m_CapW = paramInt1;
      this.m_CapH = paramInt2;
    }
    if (this.kKa == null) {
      this.kKa = new byte[this.m_CapW * this.m_CapH * 3 / 2];
    }
    ab.d("MeidaCodec[HWEnc]", "steve: m_framerate: " + this.m_framerate + ", m_br_kbps:" + this.m_br_kbps);
    if (this.tus.cSkipFlag == 0)
    {
      this.ttm.tvj.videoHWProcess(paramArrayOfByte, paramArrayOfByte.length, this.m_CapW, this.m_CapH, paramInt3, this.kKa);
      paramArrayOfByte = this.kKa;
      if ((this.m_width != this.ttm.tvj.field_HWEncW) || (this.m_height != this.ttm.tvj.field_HWEncH))
      {
        ab.d("MeidaCodec[HWEnc]", "restart encoder! clipWH:" + this.ttm.tvj.field_HWEncW + "x" + this.ttm.tvj.field_HWEncH + ", wh:" + this.m_width + "x" + this.m_height);
        this.m_width = this.ttm.tvj.field_HWEncW;
        this.m_height = this.ttm.tvj.field_HWEncH;
        this.encLen = (this.m_width * this.m_height * 3 >> 1);
        try
        {
          paramInt2 = bhm();
          paramInt1 = paramInt2;
          if (paramInt2 >= 0) {
            break label381;
          }
          ab.e("MeidaCodec[HWEnc]", "mediacodec init failed, stop HW encoding! ret: ".concat(String.valueOf(paramInt2)));
          cLN();
          AppMethodBeat.o(4350);
          return paramInt2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ab.e("MeidaCodec[HWEnc]", "mediacodec init error: " + localException1.getMessage());
            this.kJZ = 2003;
            paramInt2 = -this.kJZ;
          }
        }
      }
      else
      {
        paramInt1 = 0;
      }
      label381:
      if ((frameID > 100) || (this.kKc == null)) {}
    }
    for (;;)
    {
      try
      {
        this.kKc.write(this.kKa, 0, this.encLen);
        if ((paramArrayOfByte == null) || (this.mediaCodec == null)) {
          break label1823;
        }
        ByteBuffer[] arrayOfByteBuffer;
        continue;
      }
      catch (Exception localException2)
      {
        try
        {
          this.kKh = 0;
          l = System.currentTimeMillis();
          ab.d("MeidaCodec[HWEnc]", "steve: put YUV into encoder, size:" + this.encLen + ", idx:" + frameID + ", time:" + l);
          localObject1 = this.mediaCodec.getInputBuffers();
          arrayOfByteBuffer = this.mediaCodec.getOutputBuffers();
          paramInt2 = this.mediaCodec.dequeueInputBuffer(-1L);
          if (paramInt2 >= 0)
          {
            l = this.mGeneratedIdx * 1000000L / 15L;
            localObject1 = localObject1[paramInt2];
            ((ByteBuffer)localObject1).clear();
            ((ByteBuffer)localObject1).put(paramArrayOfByte, 0, this.encLen);
            this.mediaCodec.queueInputBuffer(paramInt2, 0, this.encLen, l + 132L, 0);
            this.mGeneratedIdx += 1L;
          }
          paramArrayOfByte = new MediaCodec.BufferInfo();
          j = this.mediaCodec.dequeueOutputBuffer(paramArrayOfByte, this.TIMEOUT_USEC);
          if (j != -2) {
            break label1859;
          }
          localObject1 = this.mediaCodec.getOutputFormat();
          ab.i("MeidaCodec[HWEnc]", "steve: encoder output format changed: ".concat(String.valueOf(localObject1)));
          if ((!((MediaFormat)localObject1).containsKey("bitrate")) || (((MediaFormat)localObject1).getInteger("bitrate") <= this.m_br_kbps * 1000 * 1.5D)) {
            break label1859;
          }
          ab.e("MeidaCodec[HWEnc]", "steve: bitrate NOT match!! real:" + ((MediaFormat)localObject1).getInteger("bitrate") + ", target:" + this.m_br_kbps);
          this.kJZ = 2007;
          paramInt1 = this.kJZ;
          paramInt1 = -paramInt1;
          AppMethodBeat.o(4350);
          return paramInt1;
        }
        catch (Exception paramArrayOfByte)
        {
          long l;
          Object localObject1;
          int j;
          ab.e("MeidaCodec[HWEnc]", " error:" + paramArrayOfByte.toString());
          this.kJZ = 2004;
          paramInt1 = -this.kJZ;
        }
        localException2 = localException2;
        ab.e("MeidaCodec[HWEnc]", " error:" + localException2.toString());
      }
      if ((this.mMuxerStarted) && (localObject1 != null)) {
        this.kKb.writeSampleData(this.mTrackIndex, (ByteBuffer)localObject1, paramArrayOfByte);
      }
      paramInt1 = paramArrayOfByte.flags;
      frameID += 1;
      this.mediaCodec.releaseOutputBuffer(j, false);
      j = this.mediaCodec.dequeueOutputBuffer(paramArrayOfByte, this.TIMEOUT_USEC);
      label1823:
      label1859:
      for (;;)
      {
        if (j >= 0)
        {
          localObject1 = localException2[j];
          byte[] arrayOfByte = new byte[paramArrayOfByte.size];
          ((ByteBuffer)localObject1).get(arrayOfByte);
          if (this.outputStream != null) {
            this.outputStream.write(arrayOfByte, 0, arrayOfByte.length);
          }
          if (paramArrayOfByte.flags == 2)
          {
            localObject2 = bo(arrayOfByte);
            auf localauf = new auf();
            int n = 0;
            int i1 = 0;
            i = 0;
            paramInt3 = 0;
            paramInt2 = 0;
            paramInt1 = 0;
            int k;
            int m;
            if ((((ArrayList)localObject2).size() == 3) && (this.ENCODING.equalsIgnoreCase("video/hevc")))
            {
              k = ((Integer)((ArrayList)localObject2).get(0)).intValue() + 4;
              i = ((Integer)((ArrayList)localObject2).get(1)).intValue() + 4;
              paramInt2 = ((Integer)((ArrayList)localObject2).get(2)).intValue() + 4;
              m = i - k - 4;
              paramInt3 = paramInt2 - i - 4;
              paramInt1 = paramArrayOfByte.size - paramInt2;
              localauf.xjb = b.z(arrayOfByte, k, m);
            }
            for (;;)
            {
              ab.d("MeidaCodec[HWEnc]", "sps start: " + i + ", len:" + paramInt3 + ", pps start:" + paramInt2 + ", len:" + paramInt1 + ", vps start: " + k + ", len:" + m);
              if ((this.kKe != 1) && (this.kKd.bp(arrayOfByte)))
              {
                this.kKg = this.kKd.tuv;
                this.kKf = 1;
                ab.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.kKf + ", checkCodeForBSlice:" + this.kKg);
                try
                {
                  paramInt1 = bhm();
                  AppMethodBeat.o(4350);
                  return paramInt1;
                  m = i1;
                  k = n;
                  if (((ArrayList)localObject2).size() == 2)
                  {
                    i = ((Integer)((ArrayList)localObject2).get(0)).intValue() + 4;
                    paramInt2 = ((Integer)((ArrayList)localObject2).get(1)).intValue() + 4;
                    paramInt3 = paramInt2 - i - 4;
                    paramInt1 = paramArrayOfByte.size - paramInt2;
                    m = i1;
                    k = n;
                  }
                }
                catch (Exception paramArrayOfByte)
                {
                  for (;;)
                  {
                    ab.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + paramArrayOfByte.getMessage());
                    this.kJZ = 2005;
                    paramInt1 = -this.kJZ;
                  }
                }
              }
            }
            localauf.xiY = 4;
            localauf.xiZ = b.z(arrayOfByte, i, paramInt3);
            localauf.xja = b.z(arrayOfByte, paramInt2, paramInt1);
            paramInt1 = localauf.toByteArray().length;
            paramInt1 = y(localauf.toByteArray(), paramArrayOfByte.flags, paramInt1);
            if (paramInt1 >= 0) {
              break;
            }
            AppMethodBeat.o(4350);
            return paramInt1;
          }
          if ((this.kKe != 1) && (this.kKd.bq(arrayOfByte)))
          {
            this.kKg = this.kKd.tuv;
            this.kKf = 1;
            ab.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.kKf + ", checkCodeForBSlice:" + this.kKg);
            try
            {
              paramInt1 = bhm();
              AppMethodBeat.o(4350);
              return paramInt1;
            }
            catch (Exception paramArrayOfByte)
            {
              for (;;)
              {
                ab.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + paramArrayOfByte.getMessage());
                this.kJZ = 2005;
                paramInt1 = -this.kJZ;
              }
            }
          }
          if ((paramArrayOfByte.flags != 0) && (paramArrayOfByte.flags != 1))
          {
            this.kJZ = 2009;
            paramInt1 = -this.kJZ;
            ab.i("MeidaCodec[HWEnc]", "steve:unknown frame error!!! type:" + paramArrayOfByte.flags + ", len:" + paramArrayOfByte.size);
            AppMethodBeat.o(4350);
            return paramInt1;
          }
          Object localObject2 = ByteBuffer.allocate(4);
          ((ByteBuffer)localObject2).putInt(paramArrayOfByte.size - 4);
          System.arraycopy(((ByteBuffer)localObject2).order(ByteOrder.BIG_ENDIAN).array(), 0, arrayOfByte, 0, 4);
          l = System.currentTimeMillis();
          ab.d("MeidaCodec[HWEnc]", " type:" + paramArrayOfByte.flags + ", size:" + paramArrayOfByte.size + ", idx:" + frameID + ", time:" + l);
          localObject2 = new aue();
          ((aue)localObject2).xiU = b.z(arrayOfByte, 0, paramArrayOfByte.size);
          ((aue)localObject2).xiV = 1;
          ((aue)localObject2).xiW = this.tup;
          this.tuq.set(0, Integer.valueOf(paramArrayOfByte.size));
          ((aue)localObject2).xiX = this.tuq;
          paramInt1 = ((aue)localObject2).toByteArray().length;
          paramInt1 = y(((aue)localObject2).toByteArray(), paramArrayOfByte.flags, paramInt1);
          if (paramInt1 >= 0) {
            break;
          }
          AppMethodBeat.o(4350);
          return paramInt1;
        }
        for (;;)
        {
          AppMethodBeat.o(4350);
          return paramInt1;
          paramInt2 = this.kKh;
          this.kKh = (paramInt2 + 1);
          if (paramInt2 > 5)
          {
            this.kJZ = 2006;
            paramInt1 = -this.kJZ;
          }
        }
      }
      paramArrayOfByte = null;
      paramInt1 = i;
    }
  }
  
  public final void cLN()
  {
    AppMethodBeat.i(4347);
    this.isRuning = false;
    try
    {
      StopEncoder();
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
      }
      if (this.kKc != null)
      {
        this.kKc.flush();
        this.kKc.close();
      }
      if (this.kKb != null)
      {
        this.kKb.stop();
        this.kKb.release();
      }
      AppMethodBeat.o(4347);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
      AppMethodBeat.o(4347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.e
 * JD-Core Version:    0.7.0.1
 */