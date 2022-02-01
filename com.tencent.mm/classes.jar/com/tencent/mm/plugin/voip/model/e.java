package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.voip.c.c;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

@TargetApi(16)
public final class e
{
  public static int EMethodGetQosPara;
  public static int NKa;
  public static short[] SizeFormat2WH;
  public static int VFMT_HEVC_HW;
  public static int VFMT_i264;
  public static int frameID;
  private static String path;
  private static int streamqueuesize;
  public static final String[] supportedH264HwCodecPrefixes;
  public String ENCODING;
  public LinkedList<cir> Frb;
  public LinkedList<Integer> Frc;
  public int Frd;
  private byte[] NJW;
  private byte[] NJX;
  private ByteBuffer NJY;
  a NJZ;
  l NJk;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public boolean isRuning;
  public long kVp;
  public long mGeneratedIdx;
  int mPrevResolution;
  int mProfileCfg;
  int m_CapH;
  int m_CapW;
  int m_br_kbps;
  int m_framerate;
  int m_height;
  int m_width;
  protected MediaFormat mediaFormat;
  private BufferedOutputStream outputStream;
  public int tQK;
  private aa tQL;
  private byte[] tQM;
  private MediaMuxer tQN;
  private int tQO;
  private boolean tQP;
  private BufferedOutputStream tQQ;
  g tQR;
  public int tQS;
  public int tQT;
  public int tQU;
  public int tQV;
  
  static
  {
    AppMethodBeat.i(177015);
    streamqueuesize = 100;
    frameID = 0;
    path = b.aSL();
    VFMT_i264 = 18;
    VFMT_HEVC_HW = 19;
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK", "OMX.sprd" };
    NKa = 60;
    EMethodGetQosPara = 25;
    AppMethodBeat.o(177015);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    AppMethodBeat.i(114837);
    this.tQK = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.NJW = null;
    this.NJX = null;
    this.tQM = null;
    this.NJY = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.kVp = 0L;
    this.NJk = null;
    this.Frb = new LinkedList();
    this.Frc = new LinkedList();
    this.tQR = null;
    this.tQS = 0;
    this.tQT = 8;
    this.tQU = 0;
    this.tQV = 0;
    this.Frd = 0;
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
    this.NJZ = new a();
    this.tQL = null;
    this.tQT = 8;
    this.tQS = 0;
    this.tQU = 0;
    this.tQK = 0;
    paramString = new cir();
    paramString.TpA = 1L;
    paramString.TpB = 24;
    paramString.TpC = 1L;
    paramString.TpD = 24;
    paramString.TpE = 0L;
    paramString.TpF = 0;
    this.Frb.add(paramString);
    this.Frc.add(Integer.valueOf(0));
    this.tQM = null;
    this.NJY = null;
    this.tQV = 0;
    this.Frd = 0;
    this.kVp = 0L;
    AppMethodBeat.o(114837);
  }
  
  private int K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114844);
    if ((paramArrayOfByte != null) && (this.NJk.NMi != null))
    {
      int i = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = VFMT_HEVC_HW;
      }
      paramInt1 = this.NJk.NMi.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
      if (paramInt1 >= 0) {
        this.Frd = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114844);
      return paramInt1;
      MakeIFrame();
      paramInt1 = this.Frd;
      this.Frd = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.tQK = 2008;
        paramInt1 = -this.tQK;
        Log.e("MicroMsg.AvcEncoder", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(paramInt1)));
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void MakeIFrame()
  {
    AppMethodBeat.i(233711);
    if (this.tQL != null)
    {
      Log.v("MicroMsg.AvcEncoder", "steve: Sync frame request soon!");
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      try
      {
        this.tQL.setParameters(localBundle);
        AppMethodBeat.o(233711);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AvcEncoder", "make I failed, just ignored, exception: ".concat(String.valueOf(localException)));
      }
    }
    AppMethodBeat.o(233711);
  }
  
  @SuppressLint({"NewApi"})
  private boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(114843);
    try
    {
      if (this.tQL != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        Log.v("MicroMsg.AvcEncoder", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.tQL.setParameters(localBundle);
        AppMethodBeat.o(114843);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AvcEncoder", "steve: setRates failed:".concat(String.valueOf(localException)));
      AppMethodBeat.o(114843);
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private void StopEncoder()
  {
    AppMethodBeat.i(114838);
    try
    {
      if (this.tQL != null)
      {
        this.tQL.stop();
        this.tQL.release();
      }
      AppMethodBeat.o(114838);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AvcEncoder", localException, "StopEncoder error:" + localException.toString(), new Object[0]);
      AppMethodBeat.o(114838);
    }
  }
  
  private static boolean a(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool2 = false;
    AppMethodBeat.i(114835);
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
          Log.d("MicroMsg.AvcEncoder", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
        }
      }
      else
      {
        AppMethodBeat.o(114835);
        return bool1;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(114833);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool2 = bool3;
      if (8 <= this.tQT)
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
                Log.i("MicroMsg.AvcEncoder", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.tQT + ", MIME:" + paramString);
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
    AppMethodBeat.o(114833);
    return bool2;
  }
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(114834);
    bool2 = false;
    bool1 = bool2;
    if (d.qV(23))
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
          Log.e("MicroMsg.AvcEncoder", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
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
        Log.i("MicroMsg.AvcEncoder", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      Log.i("MicroMsg.AvcEncoder", "best profile: " + paramString.profile + ", best level: " + paramString.level);
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
    AppMethodBeat.o(114834);
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  private int cNw()
  {
    AppMethodBeat.i(114836);
    if (this.tQL != null) {
      StopEncoder();
    }
    String str1 = this.ENCODING;
    int m = MediaCodecList.getCodecCount();
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    int j;
    label59:
    int k;
    if (i < m)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString1 = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        if (j < arrayOfString1.length) {
          if (arrayOfString1[j].equalsIgnoreCase(str1))
          {
            String str2 = localMediaCodecInfo.getName();
            String[] arrayOfString2 = supportedH264HwCodecPrefixes;
            int n = arrayOfString2.length;
            k = 0;
            label97:
            if (k < n) {
              if (str2.startsWith(arrayOfString2[k])) {
                Log.i("MicroMsg.AvcEncoder", "steve : H.264 HW encoder found:".concat(String.valueOf(str2)));
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label211;
      }
      Log.e("MicroMsg.AvcEncoder", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.tQK = 2001;
      i = -this.tQK;
      AppMethodBeat.o(114836);
      return i;
      k += 1;
      break label97;
      j += 1;
      break label59;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label211:
    Log.i("MicroMsg.AvcEncoder", "steve: found HW codec: " + localMediaCodecInfo.getName());
    Log.i("MicroMsg.AvcEncoder", "licaguo: InitHWEncoder width = " + this.m_width + " height = " + this.m_height);
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    label446:
    label464:
    boolean bool;
    if (d.qX(30))
    {
      this.mediaFormat.setInteger("color-format", 20);
      Log.i("MicroMsg.AvcEncoder", "licaguo InitHWEncoder with csp YUV420PP");
      this.mediaFormat.setInteger("stride", this.m_width);
      this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
      this.mediaFormat.setInteger("frame-rate", this.m_framerate);
      this.mediaFormat.setInteger("i-frame-interval", 4);
      str1 = this.mediaFormat.getString("mime");
      this.tQS = 1;
      if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.qV(23)))
      {
        if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x1) == 0)) {
          break label655;
        }
        i = 1;
        if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x4) == 0)) {
          break label660;
        }
        j = 1;
        bool = a(localMediaCodecInfo, str1);
        if ((j == 0) || (!bool)) {
          break label665;
        }
        this.mediaFormat.setInteger("profile", 8);
        this.mediaFormat.setInteger("level", 256);
        bool = true;
      }
    }
    for (;;)
    {
      label511:
      if (bool) {}
      for (this.tQS = this.mediaFormat.getInteger("profile");; this.tQS = 1)
      {
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try
        {
          this.tQL = aa.t(str1, false);
          Log.i("MicroMsg.AvcEncoder", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.tQS);
          this.tQL.a(this.mediaFormat, null, 1);
          this.tQL.start();
          this.tQR = new g();
          AppMethodBeat.o(114836);
          return 2000;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.AvcEncoder", localException, "InitHWEncoder error:" + localException.toString(), new Object[0]);
          this.tQK = 2002;
          i = -this.tQK;
          AppMethodBeat.o(114836);
          return i;
        }
        this.mediaFormat.setInteger("color-format", 21);
        Log.i("MicroMsg.AvcEncoder", "licaguo InitHWEncoder with csp YUV420SP, aka NV12");
        break;
        label655:
        i = 0;
        break label446;
        label660:
        j = 0;
        break label464;
        label665:
        if (i != 0)
        {
          this.mediaFormat.setInteger("profile", 1);
          this.mediaFormat.setInteger("level", 256);
          bool = true;
          break label511;
        }
        if (localMediaCodecInfo == null) {
          break label785;
        }
        bool = a(localMediaCodecInfo, str1, this.tQT);
        break label511;
      }
      label785:
      bool = false;
    }
  }
  
  private static String ce(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114840);
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
    AppMethodBeat.o(114840);
    return str1;
  }
  
  private static ArrayList<Integer> ci(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114841);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = ce(paramArrayOfByte);
    String str = ce(new byte[] { 0, 0, 0, 1 });
    Log.d("MicroMsg.AvcEncoder", "parent: " + paramArrayOfByte + ", child:" + str);
    for (;;)
    {
      int j = paramArrayOfByte.indexOf(str, i);
      if (j == -1) {
        break;
      }
      Log.d("MicroMsg.AvcEncoder", "vps/sps/pps start: " + i + ", nextStartIdx:" + j);
      i = str.length() + j;
      localArrayList.add(Integer.valueOf(j / 2));
    }
    AppMethodBeat.o(114841);
    return localArrayList;
  }
  
  private long computePresentationTime(long paramLong)
  {
    AppMethodBeat.i(233716);
    int i = Math.min(Math.max(this.m_framerate, 15), 30);
    if ((paramLong == 0L) || (this.kVp == 0L)) {}
    for (this.kVp = 132L;; this.kVp = (1000000 / i + paramLong))
    {
      paramLong = this.kVp;
      AppMethodBeat.o(233716);
      return paramLong;
      paramLong = this.kVp;
    }
  }
  
  public final void DoQosSvrCtrl()
  {
    AppMethodBeat.i(233709);
    int k;
    if ((this.NJk != null) && (this.NJk.NMi != null))
    {
      if ((this.NJk != null) && (this.NJk.NMi != null) && (this.NJk.NMi.setAppCmd(EMethodGetQosPara, this.NJZ.s2p, this.NJZ.s2p.length) >= 0))
      {
        Object localObject = this.NJZ;
        ByteBuffer localByteBuffer = ByteBuffer.wrap(((a)localObject).s2p);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        ((a)localObject).iKbps = localByteBuffer.getShort();
        ((a)localObject).cFps = localByteBuffer.get();
        ((a)localObject).cIPeriod = localByteBuffer.get();
        ((a)localObject).cRSLevel = localByteBuffer.get();
        ((a)localObject).cQPmin = localByteBuffer.get();
        ((a)localObject).cQPmax = localByteBuffer.get();
        ((a)localObject).cHPPMaxLyr = localByteBuffer.get();
        ((a)localObject).cSwitch = localByteBuffer.get();
        ((a)localObject).cResolution = localByteBuffer.get();
        ((a)localObject).cRsvd1 = localByteBuffer.get();
        ((a)localObject).cRsvd2 = localByteBuffer.get();
        ((a)localObject).cSkipFlag = localByteBuffer.get();
        ((a)localObject).cIReqFlag = localByteBuffer.get();
        ((a)localObject).NKb = localByteBuffer.getShort();
        ((a)localObject).NKc = localByteBuffer.getShort();
        localObject = c.NXF;
        c.eA(this.NJZ.NKb, this.NJZ.NKc);
      }
      k = this.NJZ.iKbps;
      if (this.tQS != 8) {
        break label501;
      }
    }
    label501:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (i == 0)
      {
        double d = Math.max(Math.min(this.NJk.NMi.NRD, 30), 0) * 1.0D / 100.0D;
        j = (int)(k * (d + 1.0D));
      }
      if (this.m_br_kbps != j)
      {
        SetBitRate(j);
        Log.i("MicroMsg.AvcEncoder", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + j + ", tuneRatio:" + this.NJk.NMi.NRD);
        this.m_br_kbps = j;
      }
      if ((1 == this.NJZ.cIReqFlag) && (frameID > 0))
      {
        MakeIFrame();
        Log.i("MicroMsg.AvcEncoder", "steve[QoS]: Force I Frame! frameID: " + frameID);
      }
      if (this.NJZ.cFps != this.m_framerate) {
        this.m_framerate = this.NJZ.cFps;
      }
      AppMethodBeat.o(233709);
      return;
    }
  }
  
  /* Error */
  public final int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 692
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore 7
    //   9: aconst_null
    //   10: astore 15
    //   12: iload_2
    //   13: aload_0
    //   14: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   17: if_icmpne +11 -> 28
    //   20: iload_3
    //   21: aload_0
    //   22: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   25: if_icmpeq +33 -> 58
    //   28: aload_0
    //   29: iload_2
    //   30: putfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   33: aload_0
    //   34: iload_3
    //   35: putfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   43: aload_0
    //   44: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   47: imul
    //   48: iconst_3
    //   49: imul
    //   50: iconst_2
    //   51: idiv
    //   52: invokestatic 696	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   55: putfield 154	com/tencent/mm/plugin/voip/model/e:NJY	Ljava/nio/ByteBuffer;
    //   58: aload_0
    //   59: getfield 154	com/tencent/mm/plugin/voip/model/e:NJY	Ljava/nio/ByteBuffer;
    //   62: ifnonnull +23 -> 85
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   70: aload_0
    //   71: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   74: imul
    //   75: iconst_3
    //   76: imul
    //   77: iconst_2
    //   78: idiv
    //   79: invokestatic 696	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   82: putfield 154	com/tencent/mm/plugin/voip/model/e:NJY	Ljava/nio/ByteBuffer;
    //   85: ldc_w 263
    //   88: new 328	java/lang/StringBuilder
    //   91: dup
    //   92: ldc_w 698
    //   95: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: getfield 197	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   102: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 700
    //   108: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   115: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: iload 7
    //   126: istore 6
    //   128: aload 15
    //   130: astore 14
    //   132: aload_0
    //   133: getfield 204	com/tencent/mm/plugin/voip/model/e:NJZ	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   136: getfield 654	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   139: ifne +419 -> 558
    //   142: iload 7
    //   144: istore 6
    //   146: aload 15
    //   148: astore 14
    //   150: aload_0
    //   151: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   154: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   157: ifnull +401 -> 558
    //   160: iconst_1
    //   161: istore 6
    //   163: bipush 30
    //   165: invokestatic 474	com/tencent/mm/compatible/util/d:qX	(I)Z
    //   168: ifeq +9 -> 177
    //   171: iconst_0
    //   172: istore 6
    //   174: iconst_1
    //   175: istore 5
    //   177: iload 5
    //   179: ifeq +275 -> 454
    //   182: invokestatic 706	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   185: lstore 12
    //   187: aload_0
    //   188: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   191: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   194: aload_1
    //   195: aload_1
    //   196: invokevirtual 709	java/nio/ByteBuffer:capacity	()I
    //   199: aload_0
    //   200: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   203: aload_0
    //   204: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   207: iload 4
    //   209: aload_0
    //   210: getfield 154	com/tencent/mm/plugin/voip/model/e:NJY	Ljava/nio/ByteBuffer;
    //   213: iload 6
    //   215: invokevirtual 713	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess3	(Ljava/nio/ByteBuffer;IIIILjava/nio/ByteBuffer;I)I
    //   218: istore 4
    //   220: iload 4
    //   222: ifge +34 -> 256
    //   225: ldc_w 263
    //   228: ldc_w 715
    //   231: iload 4
    //   233: invokestatic 268	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   236: invokevirtual 272	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_0
    //   243: invokevirtual 718	com/tencent/mm/plugin/voip/model/e:eWp	()V
    //   246: ldc_w 692
    //   249: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: sipush -2010
    //   255: ireturn
    //   256: getstatic 724	com/tencent/mm/plugin/voip/video/render/j:OeL	Lcom/tencent/mm/plugin/voip/video/render/j;
    //   259: astore_1
    //   260: iconst_0
    //   261: lload 12
    //   263: invokestatic 727	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   266: invokestatic 731	com/tencent/mm/plugin/voip/video/render/j:ba	(IJ)V
    //   269: aload_0
    //   270: getfield 154	com/tencent/mm/plugin/voip/model/e:NJY	Ljava/nio/ByteBuffer;
    //   273: astore_1
    //   274: iload 5
    //   276: ifeq +184 -> 460
    //   279: aload_0
    //   280: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   283: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   286: getfield 734	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   289: istore 6
    //   291: iload 5
    //   293: ifeq +173 -> 466
    //   296: aload_0
    //   297: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   300: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   303: getfield 737	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   306: istore 7
    //   308: aload_0
    //   309: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   312: iload 6
    //   314: if_icmpne +12 -> 326
    //   317: aload_0
    //   318: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   321: iload 7
    //   323: if_icmpeq +194 -> 517
    //   326: ldc_w 263
    //   329: new 328	java/lang/StringBuilder
    //   332: dup
    //   333: ldc_w 739
    //   336: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   339: iload_2
    //   340: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: ldc_w 741
    //   346: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: iload_3
    //   350: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: ldc_w 743
    //   356: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_0
    //   360: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   363: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: ldc_w 741
    //   369: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   376: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_0
    //   386: iload 6
    //   388: putfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   391: aload_0
    //   392: iload 7
    //   394: putfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   397: aload_0
    //   398: aload_0
    //   399: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   402: aload_0
    //   403: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   406: imul
    //   407: iconst_3
    //   408: imul
    //   409: iconst_1
    //   410: ishr
    //   411: putfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   414: aload_0
    //   415: invokespecial 745	com/tencent/mm/plugin/voip/model/e:cNw	()I
    //   418: istore_2
    //   419: iload_2
    //   420: istore 6
    //   422: iload_2
    //   423: ifge +98 -> 521
    //   426: ldc_w 263
    //   429: ldc_w 747
    //   432: iload_2
    //   433: invokestatic 268	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   436: invokevirtual 272	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   439: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload_0
    //   443: invokevirtual 718	com/tencent/mm/plugin/voip/model/e:eWp	()V
    //   446: ldc_w 692
    //   449: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: iload_2
    //   453: ireturn
    //   454: iconst_0
    //   455: istore 4
    //   457: goto -183 -> 274
    //   460: iload_2
    //   461: istore 6
    //   463: goto -172 -> 291
    //   466: iload_3
    //   467: istore 7
    //   469: goto -161 -> 308
    //   472: astore 14
    //   474: ldc_w 263
    //   477: new 328	java/lang/StringBuilder
    //   480: dup
    //   481: ldc_w 749
    //   484: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: aload 14
    //   489: invokevirtual 435	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   492: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: aload_0
    //   502: sipush 2003
    //   505: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   508: aload_0
    //   509: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   512: ineg
    //   513: istore_2
    //   514: goto -95 -> 419
    //   517: iload 4
    //   519: istore 6
    //   521: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   524: bipush 100
    //   526: if_icmpgt +415 -> 941
    //   529: aload_0
    //   530: getfield 751	com/tencent/mm/plugin/voip/model/e:tQQ	Ljava/io/BufferedOutputStream;
    //   533: ifnull +408 -> 941
    //   536: aload_0
    //   537: getfield 751	com/tencent/mm/plugin/voip/model/e:tQQ	Ljava/io/BufferedOutputStream;
    //   540: aload_1
    //   541: invokevirtual 755	java/nio/ByteBuffer:array	()[B
    //   544: aload_1
    //   545: invokevirtual 758	java/nio/ByteBuffer:arrayOffset	()I
    //   548: aload_0
    //   549: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   552: invokevirtual 764	java/io/BufferedOutputStream:write	([BII)V
    //   555: aload_1
    //   556: astore 14
    //   558: aload 14
    //   560: ifnull +1855 -> 2415
    //   563: aload_0
    //   564: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   567: ifnull +1848 -> 2415
    //   570: aload_0
    //   571: iconst_0
    //   572: putfield 179	com/tencent/mm/plugin/voip/model/e:tQV	I
    //   575: invokestatic 769	java/lang/System:currentTimeMillis	()J
    //   578: lstore 12
    //   580: ldc_w 263
    //   583: new 328	java/lang/StringBuilder
    //   586: dup
    //   587: ldc_w 771
    //   590: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   593: aload_0
    //   594: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   597: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: ldc_w 773
    //   603: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   609: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: ldc_w 775
    //   615: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: lload 12
    //   620: invokevirtual 778	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   623: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_0
    //   630: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   633: invokevirtual 782	com/tencent/mm/compatible/deviceinfo/aa:avj	()[Ljava/nio/ByteBuffer;
    //   636: astore 15
    //   638: aload_0
    //   639: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   642: invokevirtual 785	com/tencent/mm/compatible/deviceinfo/aa:avk	()[Ljava/nio/ByteBuffer;
    //   645: astore_1
    //   646: aload_0
    //   647: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   650: ldc2_w 786
    //   653: invokevirtual 791	com/tencent/mm/compatible/deviceinfo/aa:EX	(J)I
    //   656: istore_2
    //   657: iload_2
    //   658: iflt +77 -> 735
    //   661: aload_0
    //   662: aload_0
    //   663: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   666: invokespecial 793	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   669: lstore 12
    //   671: aload 14
    //   673: invokevirtual 797	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   676: aload_0
    //   677: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   680: invokevirtual 803	java/nio/Buffer:limit	(I)Ljava/nio/Buffer;
    //   683: pop
    //   684: aload 15
    //   686: iload_2
    //   687: aaload
    //   688: astore 15
    //   690: aload 15
    //   692: invokevirtual 806	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   695: pop
    //   696: aload 15
    //   698: aload 14
    //   700: invokevirtual 810	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   703: pop
    //   704: aload 14
    //   706: invokevirtual 806	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   709: pop
    //   710: aload_0
    //   711: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   714: iload_2
    //   715: aload_0
    //   716: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   719: lload 12
    //   721: iconst_0
    //   722: invokevirtual 813	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   725: aload_0
    //   726: aload_0
    //   727: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   730: lconst_1
    //   731: ladd
    //   732: putfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   735: new 815	android/media/MediaCodec$BufferInfo
    //   738: dup
    //   739: invokespecial 816	android/media/MediaCodec$BufferInfo:<init>	()V
    //   742: astore 14
    //   744: aload_0
    //   745: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   748: aload 14
    //   750: aload_0
    //   751: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   754: i2l
    //   755: invokevirtual 819	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   758: istore_3
    //   759: iload 6
    //   761: istore_2
    //   762: iload_3
    //   763: istore 7
    //   765: iload_3
    //   766: bipush 254
    //   768: if_icmpne +246 -> 1014
    //   771: aload_0
    //   772: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   775: invokevirtual 823	com/tencent/mm/compatible/deviceinfo/aa:avi	()Landroid/media/MediaFormat;
    //   778: astore 15
    //   780: ldc_w 263
    //   783: ldc_w 825
    //   786: aload 15
    //   788: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   791: invokevirtual 272	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   794: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   797: iload 6
    //   799: istore_2
    //   800: iload_3
    //   801: istore 7
    //   803: aload 15
    //   805: ldc_w 482
    //   808: invokevirtual 828	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   811: ifeq +203 -> 1014
    //   814: iload 6
    //   816: istore_2
    //   817: iload_3
    //   818: istore 7
    //   820: aload 15
    //   822: ldc_w 482
    //   825: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   828: i2d
    //   829: aload_0
    //   830: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   833: sipush 1000
    //   836: imul
    //   837: i2d
    //   838: ldc2_w 829
    //   841: dmul
    //   842: dcmpl
    //   843: ifle +171 -> 1014
    //   846: ldc_w 263
    //   849: new 328	java/lang/StringBuilder
    //   852: dup
    //   853: ldc_w 832
    //   856: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   859: aload 15
    //   861: ldc_w 482
    //   864: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   867: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   870: ldc_w 834
    //   873: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: aload_0
    //   877: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   880: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   883: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: aload_0
    //   890: sipush 2007
    //   893: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   896: aload_0
    //   897: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   900: istore_2
    //   901: iload_2
    //   902: ineg
    //   903: istore_2
    //   904: ldc_w 692
    //   907: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   910: iload_2
    //   911: ireturn
    //   912: astore 14
    //   914: ldc_w 263
    //   917: new 328	java/lang/StringBuilder
    //   920: dup
    //   921: ldc_w 836
    //   924: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   927: aload 14
    //   929: invokevirtual 336	java/lang/Exception:toString	()Ljava/lang/String;
    //   932: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: aload_1
    //   942: astore 14
    //   944: goto -386 -> 558
    //   947: aload_0
    //   948: getfield 838	com/tencent/mm/plugin/voip/model/e:tQP	Z
    //   951: ifeq +23 -> 974
    //   954: aload 15
    //   956: ifnull +18 -> 974
    //   959: aload_0
    //   960: getfield 840	com/tencent/mm/plugin/voip/model/e:tQN	Landroid/media/MediaMuxer;
    //   963: aload_0
    //   964: getfield 842	com/tencent/mm/plugin/voip/model/e:tQO	I
    //   967: aload 15
    //   969: aload 14
    //   971: invokevirtual 848	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   974: aload 14
    //   976: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   979: istore_2
    //   980: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   983: iconst_1
    //   984: iadd
    //   985: putstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   988: aload_0
    //   989: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   992: iload 7
    //   994: iconst_0
    //   995: invokevirtual 855	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   998: aload_0
    //   999: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1002: aload 14
    //   1004: aload_0
    //   1005: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   1008: i2l
    //   1009: invokevirtual 819	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1012: istore 7
    //   1014: iload_2
    //   1015: istore 6
    //   1017: iload 7
    //   1019: iflt +1378 -> 2397
    //   1022: aload_1
    //   1023: iload 7
    //   1025: aaload
    //   1026: astore 15
    //   1028: aload 14
    //   1030: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1033: newarray byte
    //   1035: astore 16
    //   1037: aload 15
    //   1039: aload 16
    //   1041: invokevirtual 860	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1044: pop
    //   1045: aload_0
    //   1046: getfield 862	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   1049: ifnull +16 -> 1065
    //   1052: aload_0
    //   1053: getfield 862	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   1056: aload 16
    //   1058: iconst_0
    //   1059: aload 16
    //   1061: arraylength
    //   1062: invokevirtual 764	java/io/BufferedOutputStream:write	([BII)V
    //   1065: aload 14
    //   1067: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1070: iconst_2
    //   1071: if_icmpne +557 -> 1628
    //   1074: aload 16
    //   1076: invokestatic 864	com/tencent/mm/plugin/voip/model/e:ci	([B)Ljava/util/ArrayList;
    //   1079: astore 17
    //   1081: new 866	com/tencent/mm/protocal/protobuf/ciq
    //   1084: dup
    //   1085: invokespecial 867	com/tencent/mm/protocal/protobuf/ciq:<init>	()V
    //   1088: astore 18
    //   1090: iconst_0
    //   1091: istore 10
    //   1093: iconst_0
    //   1094: istore 11
    //   1096: iconst_0
    //   1097: istore 6
    //   1099: iconst_0
    //   1100: istore 4
    //   1102: iconst_0
    //   1103: istore_2
    //   1104: iconst_0
    //   1105: istore_3
    //   1106: aload 17
    //   1108: invokevirtual 869	java/util/ArrayList:size	()I
    //   1111: iconst_3
    //   1112: if_icmpne +331 -> 1443
    //   1115: aload_0
    //   1116: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1119: ldc 248
    //   1121: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1124: ifeq +319 -> 1443
    //   1127: aload 17
    //   1129: iconst_0
    //   1130: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1133: checkcast 233	java/lang/Integer
    //   1136: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1139: iconst_4
    //   1140: iadd
    //   1141: istore 8
    //   1143: aload 17
    //   1145: iconst_1
    //   1146: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1149: checkcast 233	java/lang/Integer
    //   1152: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1155: iconst_4
    //   1156: iadd
    //   1157: istore 6
    //   1159: aload 17
    //   1161: iconst_2
    //   1162: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1165: checkcast 233	java/lang/Integer
    //   1168: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1171: iconst_4
    //   1172: iadd
    //   1173: istore_2
    //   1174: iload 6
    //   1176: iload 8
    //   1178: isub
    //   1179: iconst_4
    //   1180: isub
    //   1181: istore 9
    //   1183: iload_2
    //   1184: iload 6
    //   1186: isub
    //   1187: iconst_4
    //   1188: isub
    //   1189: istore 4
    //   1191: aload 14
    //   1193: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1196: iload_2
    //   1197: isub
    //   1198: istore_3
    //   1199: aload 18
    //   1201: aload 16
    //   1203: iload 8
    //   1205: iload 9
    //   1207: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1210: putfield 884	com/tencent/mm/protocal/protobuf/ciq:Tpz	Lcom/tencent/mm/cd/b;
    //   1213: aload_0
    //   1214: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1217: ifnonnull +14 -> 1231
    //   1220: aload_0
    //   1221: aload 14
    //   1223: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1226: newarray byte
    //   1228: putfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1231: aload_0
    //   1232: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1235: ifnull +43 -> 1278
    //   1238: aload 14
    //   1240: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1243: aload_0
    //   1244: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1247: arraylength
    //   1248: if_icmple +14 -> 1262
    //   1251: aload_0
    //   1252: aload 14
    //   1254: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1257: newarray byte
    //   1259: putfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1262: aload 16
    //   1264: iconst_0
    //   1265: aload_0
    //   1266: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1269: iconst_0
    //   1270: aload 14
    //   1272: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1275: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1278: ldc_w 263
    //   1281: new 328	java/lang/StringBuilder
    //   1284: dup
    //   1285: ldc_w 890
    //   1288: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1291: iload 6
    //   1293: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: ldc_w 892
    //   1299: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: iload 4
    //   1304: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1307: ldc_w 894
    //   1310: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: iload_2
    //   1314: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: ldc_w 892
    //   1320: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: iload_3
    //   1324: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1327: ldc_w 896
    //   1330: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: iload 8
    //   1335: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1338: ldc_w 892
    //   1341: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: iload 9
    //   1346: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1349: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1352: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1355: aload_0
    //   1356: getfield 173	com/tencent/mm/plugin/voip/model/e:tQS	I
    //   1359: iconst_1
    //   1360: if_icmpeq +201 -> 1561
    //   1363: aload_0
    //   1364: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1367: aload 16
    //   1369: invokevirtual 900	com/tencent/mm/plugin/voip/model/g:cw	([B)Z
    //   1372: ifeq +189 -> 1561
    //   1375: aload_0
    //   1376: aload_0
    //   1377: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1380: getfield 903	com/tencent/mm/plugin/voip/model/g:NKf	I
    //   1383: putfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1386: aload_0
    //   1387: iconst_1
    //   1388: putfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1391: ldc_w 263
    //   1394: new 328	java/lang/StringBuilder
    //   1397: dup
    //   1398: ldc_w 905
    //   1401: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1404: aload_0
    //   1405: getfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1408: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1411: ldc_w 907
    //   1414: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: aload_0
    //   1418: getfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1421: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1424: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1427: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1430: aload_0
    //   1431: invokespecial 745	com/tencent/mm/plugin/voip/model/e:cNw	()I
    //   1434: istore_2
    //   1435: ldc_w 692
    //   1438: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1441: iload_2
    //   1442: ireturn
    //   1443: iload 11
    //   1445: istore 9
    //   1447: iload 10
    //   1449: istore 8
    //   1451: aload 17
    //   1453: invokevirtual 869	java/util/ArrayList:size	()I
    //   1456: iconst_2
    //   1457: if_icmpne -244 -> 1213
    //   1460: aload 17
    //   1462: iconst_0
    //   1463: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1466: checkcast 233	java/lang/Integer
    //   1469: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1472: iconst_4
    //   1473: iadd
    //   1474: istore 6
    //   1476: aload 17
    //   1478: iconst_1
    //   1479: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1482: checkcast 233	java/lang/Integer
    //   1485: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1488: iconst_4
    //   1489: iadd
    //   1490: istore_2
    //   1491: iload_2
    //   1492: iload 6
    //   1494: isub
    //   1495: iconst_4
    //   1496: isub
    //   1497: istore 4
    //   1499: aload 14
    //   1501: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1504: iload_2
    //   1505: isub
    //   1506: istore_3
    //   1507: iload 11
    //   1509: istore 9
    //   1511: iload 10
    //   1513: istore 8
    //   1515: goto -302 -> 1213
    //   1518: astore_1
    //   1519: ldc_w 263
    //   1522: new 328	java/lang/StringBuilder
    //   1525: dup
    //   1526: ldc_w 909
    //   1529: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1532: aload_1
    //   1533: invokevirtual 435	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1536: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1545: aload_0
    //   1546: sipush 2005
    //   1549: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1552: aload_0
    //   1553: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1556: ineg
    //   1557: istore_2
    //   1558: goto -123 -> 1435
    //   1561: aload 18
    //   1563: iconst_4
    //   1564: putfield 912	com/tencent/mm/protocal/protobuf/ciq:Tpw	I
    //   1567: aload 18
    //   1569: aload 16
    //   1571: iload 6
    //   1573: iload 4
    //   1575: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1578: putfield 915	com/tencent/mm/protocal/protobuf/ciq:Tpx	Lcom/tencent/mm/cd/b;
    //   1581: aload 18
    //   1583: aload 16
    //   1585: iload_2
    //   1586: iload_3
    //   1587: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1590: putfield 918	com/tencent/mm/protocal/protobuf/ciq:Tpy	Lcom/tencent/mm/cd/b;
    //   1593: aload 18
    //   1595: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   1598: arraylength
    //   1599: istore_2
    //   1600: aload_0
    //   1601: aload 18
    //   1603: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   1606: aload 14
    //   1608: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1611: iload_2
    //   1612: invokespecial 923	com/tencent/mm/plugin/voip/model/e:K	([BII)I
    //   1615: istore_2
    //   1616: iload_2
    //   1617: ifge -670 -> 947
    //   1620: ldc_w 692
    //   1623: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1626: iload_2
    //   1627: ireturn
    //   1628: aload_0
    //   1629: getfield 173	com/tencent/mm/plugin/voip/model/e:tQS	I
    //   1632: iconst_1
    //   1633: if_icmpeq +126 -> 1759
    //   1636: aload_0
    //   1637: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1640: aload 16
    //   1642: invokevirtual 926	com/tencent/mm/plugin/voip/model/g:cx	([B)Z
    //   1645: ifeq +114 -> 1759
    //   1648: aload_0
    //   1649: aload_0
    //   1650: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1653: getfield 903	com/tencent/mm/plugin/voip/model/g:NKf	I
    //   1656: putfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1659: aload_0
    //   1660: iconst_1
    //   1661: putfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1664: ldc_w 263
    //   1667: new 328	java/lang/StringBuilder
    //   1670: dup
    //   1671: ldc_w 905
    //   1674: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1677: aload_0
    //   1678: getfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1681: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1684: ldc_w 907
    //   1687: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: aload_0
    //   1691: getfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1694: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1697: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1700: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1703: aload_0
    //   1704: invokespecial 745	com/tencent/mm/plugin/voip/model/e:cNw	()I
    //   1707: istore_2
    //   1708: ldc_w 692
    //   1711: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1714: iload_2
    //   1715: ireturn
    //   1716: astore_1
    //   1717: ldc_w 263
    //   1720: new 328	java/lang/StringBuilder
    //   1723: dup
    //   1724: ldc_w 909
    //   1727: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1730: aload_1
    //   1731: invokevirtual 435	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1734: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1740: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1743: aload_0
    //   1744: sipush 2005
    //   1747: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1750: aload_0
    //   1751: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1754: ineg
    //   1755: istore_2
    //   1756: goto -48 -> 1708
    //   1759: aload 14
    //   1761: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1764: ifeq +74 -> 1838
    //   1767: aload 14
    //   1769: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1772: iconst_1
    //   1773: if_icmpeq +65 -> 1838
    //   1776: aload_0
    //   1777: sipush 2009
    //   1780: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1783: aload_0
    //   1784: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1787: ineg
    //   1788: istore_2
    //   1789: ldc_w 263
    //   1792: new 328	java/lang/StringBuilder
    //   1795: dup
    //   1796: ldc_w 928
    //   1799: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1802: aload 14
    //   1804: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1807: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1810: ldc_w 892
    //   1813: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: aload 14
    //   1818: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1821: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1824: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1827: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1830: ldc_w 692
    //   1833: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1836: iload_2
    //   1837: ireturn
    //   1838: aload 14
    //   1840: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1843: iconst_1
    //   1844: if_icmpne +605 -> 2449
    //   1847: aload_0
    //   1848: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1851: arraylength
    //   1852: newarray byte
    //   1854: astore 17
    //   1856: aload 16
    //   1858: iconst_0
    //   1859: aload 17
    //   1861: iconst_0
    //   1862: aload_0
    //   1863: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1866: arraylength
    //   1867: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1870: aload 17
    //   1872: aload_0
    //   1873: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1876: invokestatic 934	java/util/Arrays:equals	([B[B)Z
    //   1879: ifeq +174 -> 2053
    //   1882: aload_0
    //   1883: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1886: arraylength
    //   1887: istore_2
    //   1888: ldc_w 263
    //   1891: ldc_w 936
    //   1894: iconst_1
    //   1895: anewarray 4	java/lang/Object
    //   1898: dup
    //   1899: iconst_0
    //   1900: iload_2
    //   1901: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1904: aastore
    //   1905: invokestatic 939	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1908: iconst_4
    //   1909: invokestatic 942	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1912: astore 17
    //   1914: aload 17
    //   1916: aload 14
    //   1918: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1921: iconst_4
    //   1922: isub
    //   1923: iload_2
    //   1924: isub
    //   1925: invokevirtual 944	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1928: pop
    //   1929: aload 17
    //   1931: getstatic 947	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1934: invokevirtual 608	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1937: invokevirtual 755	java/nio/ByteBuffer:array	()[B
    //   1940: iconst_0
    //   1941: aload 16
    //   1943: iload_2
    //   1944: iconst_4
    //   1945: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1948: new 949	com/tencent/mm/protocal/protobuf/cip
    //   1951: dup
    //   1952: invokespecial 950	com/tencent/mm/protocal/protobuf/cip:<init>	()V
    //   1955: astore 17
    //   1957: aload 17
    //   1959: aload 16
    //   1961: iload_2
    //   1962: aload 14
    //   1964: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1967: iload_2
    //   1968: isub
    //   1969: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1972: putfield 953	com/tencent/mm/protocal/protobuf/cip:Tps	Lcom/tencent/mm/cd/b;
    //   1975: aload 17
    //   1977: iconst_1
    //   1978: putfield 956	com/tencent/mm/protocal/protobuf/cip:Tpt	I
    //   1981: aload 17
    //   1983: aload_0
    //   1984: getfield 167	com/tencent/mm/plugin/voip/model/e:Frb	Ljava/util/LinkedList;
    //   1987: putfield 959	com/tencent/mm/protocal/protobuf/cip:Tpu	Ljava/util/LinkedList;
    //   1990: aload_0
    //   1991: getfield 169	com/tencent/mm/plugin/voip/model/e:Frc	Ljava/util/LinkedList;
    //   1994: iconst_0
    //   1995: aload 14
    //   1997: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   2000: iload_2
    //   2001: isub
    //   2002: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2005: invokevirtual 963	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   2008: pop
    //   2009: aload 17
    //   2011: aload_0
    //   2012: getfield 169	com/tencent/mm/plugin/voip/model/e:Frc	Ljava/util/LinkedList;
    //   2015: putfield 966	com/tencent/mm/protocal/protobuf/cip:Tpv	Ljava/util/LinkedList;
    //   2018: aload 17
    //   2020: invokevirtual 967	com/tencent/mm/protocal/protobuf/cip:toByteArray	()[B
    //   2023: arraylength
    //   2024: istore_2
    //   2025: aload_0
    //   2026: aload 17
    //   2028: invokevirtual 967	com/tencent/mm/protocal/protobuf/cip:toByteArray	()[B
    //   2031: aload 14
    //   2033: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   2036: iload_2
    //   2037: invokespecial 923	com/tencent/mm/plugin/voip/model/e:K	([BII)I
    //   2040: istore_2
    //   2041: iload_2
    //   2042: ifge -1095 -> 947
    //   2045: ldc_w 692
    //   2048: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2051: iload_2
    //   2052: ireturn
    //   2053: aload_0
    //   2054: getfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   2057: ifnonnull +11 -> 2068
    //   2060: aload_0
    //   2061: bipush 100
    //   2063: newarray byte
    //   2065: putfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   2068: aload 14
    //   2070: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   2073: bipush 100
    //   2075: if_icmple +331 -> 2406
    //   2078: bipush 100
    //   2080: istore_2
    //   2081: aload 16
    //   2083: iconst_0
    //   2084: aload_0
    //   2085: getfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   2088: iconst_0
    //   2089: iload_2
    //   2090: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2093: aload_0
    //   2094: getfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   2097: invokestatic 864	com/tencent/mm/plugin/voip/model/e:ci	([B)Ljava/util/ArrayList;
    //   2100: astore 17
    //   2102: aload 17
    //   2104: invokevirtual 869	java/util/ArrayList:size	()I
    //   2107: iconst_3
    //   2108: if_icmpne +341 -> 2449
    //   2111: aload_0
    //   2112: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   2115: ldc_w 493
    //   2118: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2121: ifeq +328 -> 2449
    //   2124: aload 17
    //   2126: iconst_0
    //   2127: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2130: checkcast 233	java/lang/Integer
    //   2133: invokevirtual 875	java/lang/Integer:intValue	()I
    //   2136: istore_3
    //   2137: aload 17
    //   2139: iconst_1
    //   2140: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2143: checkcast 233	java/lang/Integer
    //   2146: invokevirtual 875	java/lang/Integer:intValue	()I
    //   2149: istore 4
    //   2151: aload 17
    //   2153: iconst_2
    //   2154: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2157: checkcast 233	java/lang/Integer
    //   2160: invokevirtual 875	java/lang/Integer:intValue	()I
    //   2163: istore_2
    //   2164: iload 4
    //   2166: iload_3
    //   2167: isub
    //   2168: istore 6
    //   2170: iload_2
    //   2171: iload 4
    //   2173: isub
    //   2174: istore 8
    //   2176: ldc_w 263
    //   2179: ldc_w 969
    //   2182: iconst_5
    //   2183: anewarray 4	java/lang/Object
    //   2186: dup
    //   2187: iconst_0
    //   2188: iload_3
    //   2189: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2192: aastore
    //   2193: dup
    //   2194: iconst_1
    //   2195: iload 4
    //   2197: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2200: aastore
    //   2201: dup
    //   2202: iconst_2
    //   2203: iload_2
    //   2204: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2207: aastore
    //   2208: dup
    //   2209: iconst_3
    //   2210: iload 6
    //   2212: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2215: aastore
    //   2216: dup
    //   2217: iconst_4
    //   2218: iload 8
    //   2220: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2223: aastore
    //   2224: invokestatic 971	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2227: aload_0
    //   2228: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2231: arraylength
    //   2232: iload 6
    //   2234: iload 8
    //   2236: iadd
    //   2237: if_icmpge +14 -> 2251
    //   2240: aload_0
    //   2241: iload 6
    //   2243: iload 8
    //   2245: iadd
    //   2246: newarray byte
    //   2248: putfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2251: aload 16
    //   2253: iload_3
    //   2254: aload_0
    //   2255: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2258: iconst_0
    //   2259: iload 6
    //   2261: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2264: aload 16
    //   2266: iload 8
    //   2268: aload_0
    //   2269: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2272: iload 6
    //   2274: iload 8
    //   2276: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2279: new 866	com/tencent/mm/protocal/protobuf/ciq
    //   2282: dup
    //   2283: invokespecial 867	com/tencent/mm/protocal/protobuf/ciq:<init>	()V
    //   2286: astore 17
    //   2288: aload 17
    //   2290: iconst_4
    //   2291: putfield 912	com/tencent/mm/protocal/protobuf/ciq:Tpw	I
    //   2294: aload 17
    //   2296: aload 16
    //   2298: iload_3
    //   2299: iconst_4
    //   2300: iadd
    //   2301: iload 6
    //   2303: iconst_4
    //   2304: isub
    //   2305: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   2308: putfield 915	com/tencent/mm/protocal/protobuf/ciq:Tpx	Lcom/tencent/mm/cd/b;
    //   2311: aload 17
    //   2313: aload 16
    //   2315: iload 4
    //   2317: iconst_4
    //   2318: iadd
    //   2319: iload 8
    //   2321: iconst_4
    //   2322: isub
    //   2323: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   2326: putfield 918	com/tencent/mm/protocal/protobuf/ciq:Tpy	Lcom/tencent/mm/cd/b;
    //   2329: aload 17
    //   2331: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   2334: arraylength
    //   2335: istore_3
    //   2336: aload_0
    //   2337: aload 17
    //   2339: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   2342: iconst_2
    //   2343: iload_3
    //   2344: invokespecial 923	com/tencent/mm/plugin/voip/model/e:K	([BII)I
    //   2347: pop
    //   2348: goto -440 -> 1908
    //   2351: astore_1
    //   2352: ldc_w 263
    //   2355: aload_1
    //   2356: new 328	java/lang/StringBuilder
    //   2359: dup
    //   2360: ldc_w 973
    //   2363: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2366: aload_1
    //   2367: invokevirtual 336	java/lang/Exception:toString	()Ljava/lang/String;
    //   2370: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2376: iconst_0
    //   2377: anewarray 4	java/lang/Object
    //   2380: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2383: aload_0
    //   2384: sipush 2004
    //   2387: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2390: aload_0
    //   2391: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2394: ineg
    //   2395: istore 6
    //   2397: ldc_w 692
    //   2400: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2403: iload 6
    //   2405: ireturn
    //   2406: aload 14
    //   2408: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   2411: istore_2
    //   2412: goto -331 -> 2081
    //   2415: aload_0
    //   2416: getfield 179	com/tencent/mm/plugin/voip/model/e:tQV	I
    //   2419: istore_2
    //   2420: aload_0
    //   2421: iload_2
    //   2422: iconst_1
    //   2423: iadd
    //   2424: putfield 179	com/tencent/mm/plugin/voip/model/e:tQV	I
    //   2427: iload_2
    //   2428: iconst_5
    //   2429: if_icmple -32 -> 2397
    //   2432: aload_0
    //   2433: sipush 2006
    //   2436: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2439: aload_0
    //   2440: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2443: ineg
    //   2444: istore 6
    //   2446: goto -49 -> 2397
    //   2449: iconst_0
    //   2450: istore_2
    //   2451: goto -543 -> 1908
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2454	0	this	e
    //   0	2454	1	paramByteBuffer	ByteBuffer
    //   0	2454	2	paramInt1	int
    //   0	2454	3	paramInt2	int
    //   0	2454	4	paramInt3	int
    //   0	2454	5	paramBoolean	boolean
    //   126	2319	6	i	int
    //   7	1017	7	j	int
    //   1141	1182	8	k	int
    //   1181	329	9	m	int
    //   1091	421	10	n	int
    //   1094	414	11	i1	int
    //   185	535	12	l	long
    //   130	19	14	localObject1	Object
    //   472	16	14	localException1	Exception
    //   556	193	14	localObject2	Object
    //   912	16	14	localException2	Exception
    //   942	1465	14	localByteBuffer	ByteBuffer
    //   10	1028	15	localObject3	Object
    //   1035	1279	16	arrayOfByte	byte[]
    //   1079	1259	17	localObject4	Object
    //   1088	514	18	localciq	com.tencent.mm.protocal.protobuf.ciq
    // Exception table:
    //   from	to	target	type
    //   414	419	472	java/lang/Exception
    //   536	555	912	java/lang/Exception
    //   1430	1435	1518	java/lang/Exception
    //   1703	1708	1716	java/lang/Exception
    //   570	657	2351	java/lang/Exception
    //   661	684	2351	java/lang/Exception
    //   690	735	2351	java/lang/Exception
    //   735	759	2351	java/lang/Exception
    //   771	797	2351	java/lang/Exception
    //   803	814	2351	java/lang/Exception
    //   820	901	2351	java/lang/Exception
    //   947	954	2351	java/lang/Exception
    //   959	974	2351	java/lang/Exception
    //   974	1014	2351	java/lang/Exception
    //   1028	1065	2351	java/lang/Exception
    //   1065	1090	2351	java/lang/Exception
    //   1106	1174	2351	java/lang/Exception
    //   1191	1213	2351	java/lang/Exception
    //   1213	1231	2351	java/lang/Exception
    //   1231	1262	2351	java/lang/Exception
    //   1262	1278	2351	java/lang/Exception
    //   1278	1430	2351	java/lang/Exception
    //   1451	1491	2351	java/lang/Exception
    //   1499	1507	2351	java/lang/Exception
    //   1519	1558	2351	java/lang/Exception
    //   1561	1616	2351	java/lang/Exception
    //   1628	1703	2351	java/lang/Exception
    //   1717	1756	2351	java/lang/Exception
    //   1759	1830	2351	java/lang/Exception
    //   1838	1908	2351	java/lang/Exception
    //   1908	2041	2351	java/lang/Exception
    //   2053	2068	2351	java/lang/Exception
    //   2068	2078	2351	java/lang/Exception
    //   2081	2164	2351	java/lang/Exception
    //   2176	2251	2351	java/lang/Exception
    //   2251	2348	2351	java/lang/Exception
    //   2406	2412	2351	java/lang/Exception
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 976
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore 5
    //   9: aconst_null
    //   10: astore 14
    //   12: iload_2
    //   13: aload_0
    //   14: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   17: if_icmpne +11 -> 28
    //   20: iload_3
    //   21: aload_0
    //   22: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   25: if_icmpeq +32 -> 57
    //   28: aload_0
    //   29: iload_2
    //   30: putfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   33: aload_0
    //   34: iload_3
    //   35: putfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   43: aload_0
    //   44: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   47: imul
    //   48: iconst_3
    //   49: imul
    //   50: iconst_2
    //   51: idiv
    //   52: newarray byte
    //   54: putfield 152	com/tencent/mm/plugin/voip/model/e:tQM	[B
    //   57: aload_0
    //   58: getfield 152	com/tencent/mm/plugin/voip/model/e:tQM	[B
    //   61: ifnonnull +22 -> 83
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   69: aload_0
    //   70: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   73: imul
    //   74: iconst_3
    //   75: imul
    //   76: iconst_2
    //   77: idiv
    //   78: newarray byte
    //   80: putfield 152	com/tencent/mm/plugin/voip/model/e:tQM	[B
    //   83: ldc_w 263
    //   86: new 328	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 698
    //   93: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 197	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   100: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: ldc_w 700
    //   106: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   113: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: iload 5
    //   124: istore_2
    //   125: aload 14
    //   127: astore 13
    //   129: aload_0
    //   130: getfield 204	com/tencent/mm/plugin/voip/model/e:NJZ	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   133: getfield 654	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   136: ifne +363 -> 499
    //   139: iload 5
    //   141: istore_2
    //   142: aload 14
    //   144: astore 13
    //   146: aload_0
    //   147: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   150: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   153: ifnull +346 -> 499
    //   156: aload_0
    //   157: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   160: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   163: aload_1
    //   164: aload_1
    //   165: arraylength
    //   166: aload_0
    //   167: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   170: aload_0
    //   171: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   174: iload 4
    //   176: aload_0
    //   177: getfield 152	com/tencent/mm/plugin/voip/model/e:tQM	[B
    //   180: invokevirtual 980	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess	([BIIII[B)I
    //   183: istore_3
    //   184: iload_3
    //   185: ifge +33 -> 218
    //   188: ldc_w 263
    //   191: ldc_w 982
    //   194: iload_3
    //   195: invokestatic 268	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   198: invokevirtual 272	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload_0
    //   205: invokevirtual 718	com/tencent/mm/plugin/voip/model/e:eWp	()V
    //   208: ldc_w 976
    //   211: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: sipush -2010
    //   217: ireturn
    //   218: aload_0
    //   219: getfield 152	com/tencent/mm/plugin/voip/model/e:tQM	[B
    //   222: astore_1
    //   223: aload_0
    //   224: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   227: aload_0
    //   228: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   231: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   234: getfield 734	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   237: if_icmpne +20 -> 257
    //   240: aload_0
    //   241: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   244: aload_0
    //   245: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   248: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   251: getfield 737	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   254: if_icmpeq +209 -> 463
    //   257: ldc_w 263
    //   260: new 328	java/lang/StringBuilder
    //   263: dup
    //   264: ldc_w 739
    //   267: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   274: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   277: getfield 734	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   280: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc_w 741
    //   286: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   293: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   296: getfield 737	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   299: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: ldc_w 743
    //   305: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_0
    //   309: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   312: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: ldc_w 741
    //   318: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   325: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_0
    //   335: aload_0
    //   336: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   339: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   342: getfield 734	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   345: putfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   348: aload_0
    //   349: aload_0
    //   350: getfield 162	com/tencent/mm/plugin/voip/model/e:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   353: getfield 246	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   356: getfield 737	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   359: putfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   362: aload_0
    //   363: aload_0
    //   364: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   367: aload_0
    //   368: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   371: imul
    //   372: iconst_3
    //   373: imul
    //   374: iconst_1
    //   375: ishr
    //   376: putfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   379: aload_0
    //   380: invokespecial 745	com/tencent/mm/plugin/voip/model/e:cNw	()I
    //   383: istore_2
    //   384: iload_2
    //   385: istore_3
    //   386: iload_2
    //   387: ifge +76 -> 463
    //   390: ldc_w 263
    //   393: ldc_w 747
    //   396: iload_2
    //   397: invokestatic 268	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   400: invokevirtual 272	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   403: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: invokevirtual 718	com/tencent/mm/plugin/voip/model/e:eWp	()V
    //   410: ldc_w 976
    //   413: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: iload_2
    //   417: ireturn
    //   418: astore 13
    //   420: ldc_w 263
    //   423: new 328	java/lang/StringBuilder
    //   426: dup
    //   427: ldc_w 749
    //   430: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   433: aload 13
    //   435: invokevirtual 435	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   438: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload_0
    //   448: sipush 2003
    //   451: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   454: aload_0
    //   455: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   458: ineg
    //   459: istore_2
    //   460: goto -76 -> 384
    //   463: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   466: bipush 100
    //   468: if_icmpgt +348 -> 816
    //   471: aload_0
    //   472: getfield 751	com/tencent/mm/plugin/voip/model/e:tQQ	Ljava/io/BufferedOutputStream;
    //   475: ifnull +341 -> 816
    //   478: aload_0
    //   479: getfield 751	com/tencent/mm/plugin/voip/model/e:tQQ	Ljava/io/BufferedOutputStream;
    //   482: aload_0
    //   483: getfield 152	com/tencent/mm/plugin/voip/model/e:tQM	[B
    //   486: iconst_0
    //   487: aload_0
    //   488: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   491: invokevirtual 764	java/io/BufferedOutputStream:write	([BII)V
    //   494: aload_1
    //   495: astore 13
    //   497: iload_3
    //   498: istore_2
    //   499: aload 13
    //   501: ifnull +1791 -> 2292
    //   504: aload_0
    //   505: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   508: ifnull +1784 -> 2292
    //   511: aload_0
    //   512: iconst_0
    //   513: putfield 179	com/tencent/mm/plugin/voip/model/e:tQV	I
    //   516: aload_0
    //   517: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   520: invokevirtual 782	com/tencent/mm/compatible/deviceinfo/aa:avj	()[Ljava/nio/ByteBuffer;
    //   523: astore 14
    //   525: aload_0
    //   526: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   529: invokevirtual 785	com/tencent/mm/compatible/deviceinfo/aa:avk	()[Ljava/nio/ByteBuffer;
    //   532: astore_1
    //   533: aload_0
    //   534: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   537: ldc2_w 786
    //   540: invokevirtual 791	com/tencent/mm/compatible/deviceinfo/aa:EX	(J)I
    //   543: istore_3
    //   544: iload_3
    //   545: iflt +63 -> 608
    //   548: aload_0
    //   549: aload_0
    //   550: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   553: invokespecial 793	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   556: lstore 11
    //   558: aload 14
    //   560: iload_3
    //   561: aaload
    //   562: astore 14
    //   564: aload 14
    //   566: invokevirtual 806	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   569: pop
    //   570: aload 14
    //   572: aload 13
    //   574: iconst_0
    //   575: aload_0
    //   576: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   579: invokevirtual 985	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   582: pop
    //   583: aload_0
    //   584: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   587: iload_3
    //   588: aload_0
    //   589: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   592: lload 11
    //   594: iconst_0
    //   595: invokevirtual 813	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   598: aload_0
    //   599: aload_0
    //   600: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   603: lconst_1
    //   604: ladd
    //   605: putfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   608: new 815	android/media/MediaCodec$BufferInfo
    //   611: dup
    //   612: invokespecial 816	android/media/MediaCodec$BufferInfo:<init>	()V
    //   615: astore 13
    //   617: aload_0
    //   618: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   621: aload 13
    //   623: aload_0
    //   624: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   627: i2l
    //   628: invokevirtual 819	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   631: istore 4
    //   633: iload_2
    //   634: istore_3
    //   635: iload 4
    //   637: istore 6
    //   639: iload 4
    //   641: bipush 254
    //   643: if_icmpne +248 -> 891
    //   646: aload_0
    //   647: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   650: invokevirtual 823	com/tencent/mm/compatible/deviceinfo/aa:avi	()Landroid/media/MediaFormat;
    //   653: astore 14
    //   655: ldc_w 263
    //   658: ldc_w 825
    //   661: aload 14
    //   663: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   666: invokevirtual 272	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   669: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: iload_2
    //   673: istore_3
    //   674: iload 4
    //   676: istore 6
    //   678: aload 14
    //   680: ldc_w 482
    //   683: invokevirtual 828	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   686: ifeq +205 -> 891
    //   689: iload_2
    //   690: istore_3
    //   691: iload 4
    //   693: istore 6
    //   695: aload 14
    //   697: ldc_w 482
    //   700: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   703: i2d
    //   704: aload_0
    //   705: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   708: sipush 1000
    //   711: imul
    //   712: i2d
    //   713: ldc2_w 829
    //   716: dmul
    //   717: dcmpl
    //   718: ifle +173 -> 891
    //   721: ldc_w 263
    //   724: new 328	java/lang/StringBuilder
    //   727: dup
    //   728: ldc_w 832
    //   731: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   734: aload 14
    //   736: ldc_w 482
    //   739: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   742: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: ldc_w 834
    //   748: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload_0
    //   752: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   755: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   758: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload_0
    //   765: sipush 2007
    //   768: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   771: aload_0
    //   772: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   775: istore_2
    //   776: iload_2
    //   777: ineg
    //   778: istore_2
    //   779: ldc_w 976
    //   782: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   785: iload_2
    //   786: ireturn
    //   787: astore 13
    //   789: ldc_w 263
    //   792: new 328	java/lang/StringBuilder
    //   795: dup
    //   796: ldc_w 836
    //   799: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   802: aload 13
    //   804: invokevirtual 336	java/lang/Exception:toString	()Ljava/lang/String;
    //   807: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   816: iload_3
    //   817: istore_2
    //   818: aload_1
    //   819: astore 13
    //   821: goto -322 -> 499
    //   824: aload_0
    //   825: getfield 838	com/tencent/mm/plugin/voip/model/e:tQP	Z
    //   828: ifeq +23 -> 851
    //   831: aload 14
    //   833: ifnull +18 -> 851
    //   836: aload_0
    //   837: getfield 840	com/tencent/mm/plugin/voip/model/e:tQN	Landroid/media/MediaMuxer;
    //   840: aload_0
    //   841: getfield 842	com/tencent/mm/plugin/voip/model/e:tQO	I
    //   844: aload 14
    //   846: aload 13
    //   848: invokevirtual 848	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   851: aload 13
    //   853: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   856: istore_3
    //   857: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   860: iconst_1
    //   861: iadd
    //   862: putstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   865: aload_0
    //   866: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   869: iload 6
    //   871: iconst_0
    //   872: invokevirtual 855	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   875: aload_0
    //   876: getfield 206	com/tencent/mm/plugin/voip/model/e:tQL	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   879: aload 13
    //   881: aload_0
    //   882: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   885: i2l
    //   886: invokevirtual 819	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   889: istore 6
    //   891: iload_3
    //   892: istore_2
    //   893: iload 6
    //   895: iflt +1380 -> 2275
    //   898: aload_1
    //   899: iload 6
    //   901: aaload
    //   902: astore 14
    //   904: aload 13
    //   906: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   909: newarray byte
    //   911: astore 15
    //   913: aload 14
    //   915: aload 15
    //   917: invokevirtual 860	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   920: pop
    //   921: aload_0
    //   922: getfield 862	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   925: ifnull +16 -> 941
    //   928: aload_0
    //   929: getfield 862	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   932: aload 15
    //   934: iconst_0
    //   935: aload 15
    //   937: arraylength
    //   938: invokevirtual 764	java/io/BufferedOutputStream:write	([BII)V
    //   941: aload 13
    //   943: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   946: iconst_2
    //   947: if_icmpne +557 -> 1504
    //   950: aload 15
    //   952: invokestatic 864	com/tencent/mm/plugin/voip/model/e:ci	([B)Ljava/util/ArrayList;
    //   955: astore 16
    //   957: new 866	com/tencent/mm/protocal/protobuf/ciq
    //   960: dup
    //   961: invokespecial 867	com/tencent/mm/protocal/protobuf/ciq:<init>	()V
    //   964: astore 17
    //   966: iconst_0
    //   967: istore 9
    //   969: iconst_0
    //   970: istore 10
    //   972: iconst_0
    //   973: istore 5
    //   975: iconst_0
    //   976: istore 4
    //   978: iconst_0
    //   979: istore_3
    //   980: iconst_0
    //   981: istore_2
    //   982: aload 16
    //   984: invokevirtual 869	java/util/ArrayList:size	()I
    //   987: iconst_3
    //   988: if_icmpne +331 -> 1319
    //   991: aload_0
    //   992: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   995: ldc 248
    //   997: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1000: ifeq +319 -> 1319
    //   1003: aload 16
    //   1005: iconst_0
    //   1006: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1009: checkcast 233	java/lang/Integer
    //   1012: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1015: iconst_4
    //   1016: iadd
    //   1017: istore 7
    //   1019: aload 16
    //   1021: iconst_1
    //   1022: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1025: checkcast 233	java/lang/Integer
    //   1028: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1031: iconst_4
    //   1032: iadd
    //   1033: istore 5
    //   1035: aload 16
    //   1037: iconst_2
    //   1038: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1041: checkcast 233	java/lang/Integer
    //   1044: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1047: iconst_4
    //   1048: iadd
    //   1049: istore_3
    //   1050: iload 5
    //   1052: iload 7
    //   1054: isub
    //   1055: iconst_4
    //   1056: isub
    //   1057: istore 8
    //   1059: iload_3
    //   1060: iload 5
    //   1062: isub
    //   1063: iconst_4
    //   1064: isub
    //   1065: istore 4
    //   1067: aload 13
    //   1069: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1072: iload_3
    //   1073: isub
    //   1074: istore_2
    //   1075: aload 17
    //   1077: aload 15
    //   1079: iload 7
    //   1081: iload 8
    //   1083: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1086: putfield 884	com/tencent/mm/protocal/protobuf/ciq:Tpz	Lcom/tencent/mm/cd/b;
    //   1089: aload_0
    //   1090: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1093: ifnonnull +14 -> 1107
    //   1096: aload_0
    //   1097: aload 13
    //   1099: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1102: newarray byte
    //   1104: putfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1107: aload_0
    //   1108: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1111: ifnull +43 -> 1154
    //   1114: aload 13
    //   1116: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1119: aload_0
    //   1120: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1123: arraylength
    //   1124: if_icmple +14 -> 1138
    //   1127: aload_0
    //   1128: aload 13
    //   1130: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1133: newarray byte
    //   1135: putfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1138: aload 15
    //   1140: iconst_0
    //   1141: aload_0
    //   1142: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1145: iconst_0
    //   1146: aload 13
    //   1148: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1151: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1154: ldc_w 263
    //   1157: new 328	java/lang/StringBuilder
    //   1160: dup
    //   1161: ldc_w 890
    //   1164: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1167: iload 5
    //   1169: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: ldc_w 892
    //   1175: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload 4
    //   1180: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1183: ldc_w 894
    //   1186: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: iload_3
    //   1190: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1193: ldc_w 892
    //   1196: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: iload_2
    //   1200: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1203: ldc_w 896
    //   1206: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: iload 7
    //   1211: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1214: ldc_w 892
    //   1217: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: iload 8
    //   1222: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1231: aload_0
    //   1232: getfield 173	com/tencent/mm/plugin/voip/model/e:tQS	I
    //   1235: iconst_1
    //   1236: if_icmpeq +201 -> 1437
    //   1239: aload_0
    //   1240: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1243: aload 15
    //   1245: invokevirtual 900	com/tencent/mm/plugin/voip/model/g:cw	([B)Z
    //   1248: ifeq +189 -> 1437
    //   1251: aload_0
    //   1252: aload_0
    //   1253: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1256: getfield 903	com/tencent/mm/plugin/voip/model/g:NKf	I
    //   1259: putfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1262: aload_0
    //   1263: iconst_1
    //   1264: putfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1267: ldc_w 263
    //   1270: new 328	java/lang/StringBuilder
    //   1273: dup
    //   1274: ldc_w 905
    //   1277: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1280: aload_0
    //   1281: getfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1284: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1287: ldc_w 907
    //   1290: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: aload_0
    //   1294: getfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1297: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1300: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1306: aload_0
    //   1307: invokespecial 745	com/tencent/mm/plugin/voip/model/e:cNw	()I
    //   1310: istore_2
    //   1311: ldc_w 976
    //   1314: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1317: iload_2
    //   1318: ireturn
    //   1319: iload 10
    //   1321: istore 8
    //   1323: iload 9
    //   1325: istore 7
    //   1327: aload 16
    //   1329: invokevirtual 869	java/util/ArrayList:size	()I
    //   1332: iconst_2
    //   1333: if_icmpne -244 -> 1089
    //   1336: aload 16
    //   1338: iconst_0
    //   1339: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1342: checkcast 233	java/lang/Integer
    //   1345: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1348: iconst_4
    //   1349: iadd
    //   1350: istore 5
    //   1352: aload 16
    //   1354: iconst_1
    //   1355: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1358: checkcast 233	java/lang/Integer
    //   1361: invokevirtual 875	java/lang/Integer:intValue	()I
    //   1364: iconst_4
    //   1365: iadd
    //   1366: istore_3
    //   1367: iload_3
    //   1368: iload 5
    //   1370: isub
    //   1371: iconst_4
    //   1372: isub
    //   1373: istore 4
    //   1375: aload 13
    //   1377: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1380: iload_3
    //   1381: isub
    //   1382: istore_2
    //   1383: iload 10
    //   1385: istore 8
    //   1387: iload 9
    //   1389: istore 7
    //   1391: goto -302 -> 1089
    //   1394: astore_1
    //   1395: ldc_w 263
    //   1398: new 328	java/lang/StringBuilder
    //   1401: dup
    //   1402: ldc_w 909
    //   1405: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1408: aload_1
    //   1409: invokevirtual 435	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1412: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1421: aload_0
    //   1422: sipush 2005
    //   1425: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1428: aload_0
    //   1429: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1432: ineg
    //   1433: istore_2
    //   1434: goto -123 -> 1311
    //   1437: aload 17
    //   1439: iconst_4
    //   1440: putfield 912	com/tencent/mm/protocal/protobuf/ciq:Tpw	I
    //   1443: aload 17
    //   1445: aload 15
    //   1447: iload 5
    //   1449: iload 4
    //   1451: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1454: putfield 915	com/tencent/mm/protocal/protobuf/ciq:Tpx	Lcom/tencent/mm/cd/b;
    //   1457: aload 17
    //   1459: aload 15
    //   1461: iload_3
    //   1462: iload_2
    //   1463: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1466: putfield 918	com/tencent/mm/protocal/protobuf/ciq:Tpy	Lcom/tencent/mm/cd/b;
    //   1469: aload 17
    //   1471: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   1474: arraylength
    //   1475: istore_2
    //   1476: aload_0
    //   1477: aload 17
    //   1479: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   1482: aload 13
    //   1484: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1487: iload_2
    //   1488: invokespecial 923	com/tencent/mm/plugin/voip/model/e:K	([BII)I
    //   1491: istore_2
    //   1492: iload_2
    //   1493: ifge -669 -> 824
    //   1496: ldc_w 976
    //   1499: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1502: iload_2
    //   1503: ireturn
    //   1504: aload_0
    //   1505: getfield 173	com/tencent/mm/plugin/voip/model/e:tQS	I
    //   1508: iconst_1
    //   1509: if_icmpeq +126 -> 1635
    //   1512: aload_0
    //   1513: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1516: aload 15
    //   1518: invokevirtual 926	com/tencent/mm/plugin/voip/model/g:cx	([B)Z
    //   1521: ifeq +114 -> 1635
    //   1524: aload_0
    //   1525: aload_0
    //   1526: getfield 171	com/tencent/mm/plugin/voip/model/e:tQR	Lcom/tencent/mm/plugin/voip/model/g;
    //   1529: getfield 903	com/tencent/mm/plugin/voip/model/g:NKf	I
    //   1532: putfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1535: aload_0
    //   1536: iconst_1
    //   1537: putfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1540: ldc_w 263
    //   1543: new 328	java/lang/StringBuilder
    //   1546: dup
    //   1547: ldc_w 905
    //   1550: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1553: aload_0
    //   1554: getfield 175	com/tencent/mm/plugin/voip/model/e:tQT	I
    //   1557: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1560: ldc_w 907
    //   1563: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload_0
    //   1567: getfield 177	com/tencent/mm/plugin/voip/model/e:tQU	I
    //   1570: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1579: aload_0
    //   1580: invokespecial 745	com/tencent/mm/plugin/voip/model/e:cNw	()I
    //   1583: istore_2
    //   1584: ldc_w 976
    //   1587: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1590: iload_2
    //   1591: ireturn
    //   1592: astore_1
    //   1593: ldc_w 263
    //   1596: new 328	java/lang/StringBuilder
    //   1599: dup
    //   1600: ldc_w 909
    //   1603: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1606: aload_1
    //   1607: invokevirtual 435	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1610: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1616: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1619: aload_0
    //   1620: sipush 2005
    //   1623: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1626: aload_0
    //   1627: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1630: ineg
    //   1631: istore_2
    //   1632: goto -48 -> 1584
    //   1635: aload 13
    //   1637: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1640: ifeq +74 -> 1714
    //   1643: aload 13
    //   1645: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1648: iconst_1
    //   1649: if_icmpeq +65 -> 1714
    //   1652: aload_0
    //   1653: sipush 2009
    //   1656: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1659: aload_0
    //   1660: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   1663: ineg
    //   1664: istore_2
    //   1665: ldc_w 263
    //   1668: new 328	java/lang/StringBuilder
    //   1671: dup
    //   1672: ldc_w 928
    //   1675: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1678: aload 13
    //   1680: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1683: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1686: ldc_w 892
    //   1689: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: aload 13
    //   1694: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1697: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1700: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1703: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1706: ldc_w 976
    //   1709: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1712: iload_2
    //   1713: ireturn
    //   1714: iconst_0
    //   1715: istore_3
    //   1716: iload_3
    //   1717: istore_2
    //   1718: aload 13
    //   1720: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1723: iconst_1
    //   1724: if_icmpne +64 -> 1788
    //   1727: aload_0
    //   1728: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1731: arraylength
    //   1732: newarray byte
    //   1734: astore 16
    //   1736: aload 15
    //   1738: iconst_0
    //   1739: aload 16
    //   1741: iconst_0
    //   1742: aload_0
    //   1743: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1746: arraylength
    //   1747: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1750: aload 16
    //   1752: aload_0
    //   1753: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1756: invokestatic 934	java/util/Arrays:equals	([B[B)Z
    //   1759: ifeq +174 -> 1933
    //   1762: aload_0
    //   1763: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   1766: arraylength
    //   1767: istore_2
    //   1768: ldc_w 263
    //   1771: ldc_w 936
    //   1774: iconst_1
    //   1775: anewarray 4	java/lang/Object
    //   1778: dup
    //   1779: iconst_0
    //   1780: iload_2
    //   1781: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1784: aastore
    //   1785: invokestatic 939	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1788: iconst_4
    //   1789: invokestatic 942	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1792: astore 16
    //   1794: aload 16
    //   1796: aload 13
    //   1798: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1801: iconst_4
    //   1802: isub
    //   1803: iload_2
    //   1804: isub
    //   1805: invokevirtual 944	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1808: pop
    //   1809: aload 16
    //   1811: getstatic 947	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1814: invokevirtual 608	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1817: invokevirtual 755	java/nio/ByteBuffer:array	()[B
    //   1820: iconst_0
    //   1821: aload 15
    //   1823: iload_2
    //   1824: iconst_4
    //   1825: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1828: new 949	com/tencent/mm/protocal/protobuf/cip
    //   1831: dup
    //   1832: invokespecial 950	com/tencent/mm/protocal/protobuf/cip:<init>	()V
    //   1835: astore 16
    //   1837: aload 16
    //   1839: aload 15
    //   1841: iload_2
    //   1842: aload 13
    //   1844: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1847: iload_2
    //   1848: isub
    //   1849: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   1852: putfield 953	com/tencent/mm/protocal/protobuf/cip:Tps	Lcom/tencent/mm/cd/b;
    //   1855: aload 16
    //   1857: iconst_1
    //   1858: putfield 956	com/tencent/mm/protocal/protobuf/cip:Tpt	I
    //   1861: aload 16
    //   1863: aload_0
    //   1864: getfield 167	com/tencent/mm/plugin/voip/model/e:Frb	Ljava/util/LinkedList;
    //   1867: putfield 959	com/tencent/mm/protocal/protobuf/cip:Tpu	Ljava/util/LinkedList;
    //   1870: aload_0
    //   1871: getfield 169	com/tencent/mm/plugin/voip/model/e:Frc	Ljava/util/LinkedList;
    //   1874: iconst_0
    //   1875: aload 13
    //   1877: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1880: iload_2
    //   1881: isub
    //   1882: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1885: invokevirtual 963	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1888: pop
    //   1889: aload 16
    //   1891: aload_0
    //   1892: getfield 169	com/tencent/mm/plugin/voip/model/e:Frc	Ljava/util/LinkedList;
    //   1895: putfield 966	com/tencent/mm/protocal/protobuf/cip:Tpv	Ljava/util/LinkedList;
    //   1898: aload 16
    //   1900: invokevirtual 967	com/tencent/mm/protocal/protobuf/cip:toByteArray	()[B
    //   1903: arraylength
    //   1904: istore_2
    //   1905: aload_0
    //   1906: aload 16
    //   1908: invokevirtual 967	com/tencent/mm/protocal/protobuf/cip:toByteArray	()[B
    //   1911: aload 13
    //   1913: getfield 851	android/media/MediaCodec$BufferInfo:flags	I
    //   1916: iload_2
    //   1917: invokespecial 923	com/tencent/mm/plugin/voip/model/e:K	([BII)I
    //   1920: istore_2
    //   1921: iload_2
    //   1922: ifge -1098 -> 824
    //   1925: ldc_w 976
    //   1928: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1931: iload_2
    //   1932: ireturn
    //   1933: aload_0
    //   1934: getfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   1937: ifnonnull +11 -> 1948
    //   1940: aload_0
    //   1941: bipush 100
    //   1943: newarray byte
    //   1945: putfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   1948: aload 13
    //   1950: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   1953: bipush 100
    //   1955: if_icmple +328 -> 2283
    //   1958: bipush 100
    //   1960: istore_2
    //   1961: aload 15
    //   1963: iconst_0
    //   1964: aload_0
    //   1965: getfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   1968: iconst_0
    //   1969: iload_2
    //   1970: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1973: aload_0
    //   1974: getfield 150	com/tencent/mm/plugin/voip/model/e:NJX	[B
    //   1977: invokestatic 864	com/tencent/mm/plugin/voip/model/e:ci	([B)Ljava/util/ArrayList;
    //   1980: astore 16
    //   1982: iload_3
    //   1983: istore_2
    //   1984: aload 16
    //   1986: invokevirtual 869	java/util/ArrayList:size	()I
    //   1989: iconst_3
    //   1990: if_icmpne -202 -> 1788
    //   1993: iload_3
    //   1994: istore_2
    //   1995: aload_0
    //   1996: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1999: ldc_w 493
    //   2002: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2005: ifeq -217 -> 1788
    //   2008: aload 16
    //   2010: iconst_0
    //   2011: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2014: checkcast 233	java/lang/Integer
    //   2017: invokevirtual 875	java/lang/Integer:intValue	()I
    //   2020: istore_3
    //   2021: aload 16
    //   2023: iconst_1
    //   2024: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2027: checkcast 233	java/lang/Integer
    //   2030: invokevirtual 875	java/lang/Integer:intValue	()I
    //   2033: istore 4
    //   2035: aload 16
    //   2037: iconst_2
    //   2038: invokevirtual 872	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2041: checkcast 233	java/lang/Integer
    //   2044: invokevirtual 875	java/lang/Integer:intValue	()I
    //   2047: istore_2
    //   2048: iload 4
    //   2050: iload_3
    //   2051: isub
    //   2052: istore 5
    //   2054: iload_2
    //   2055: iload 4
    //   2057: isub
    //   2058: istore 7
    //   2060: ldc_w 263
    //   2063: ldc_w 969
    //   2066: iconst_5
    //   2067: anewarray 4	java/lang/Object
    //   2070: dup
    //   2071: iconst_0
    //   2072: iload_3
    //   2073: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2076: aastore
    //   2077: dup
    //   2078: iconst_1
    //   2079: iload 4
    //   2081: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2084: aastore
    //   2085: dup
    //   2086: iconst_2
    //   2087: iload_2
    //   2088: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2091: aastore
    //   2092: dup
    //   2093: iconst_3
    //   2094: iload 5
    //   2096: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2099: aastore
    //   2100: dup
    //   2101: iconst_4
    //   2102: iload 7
    //   2104: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2107: aastore
    //   2108: invokestatic 971	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2111: aload_0
    //   2112: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2115: arraylength
    //   2116: iload 5
    //   2118: iload 7
    //   2120: iadd
    //   2121: if_icmpge +14 -> 2135
    //   2124: aload_0
    //   2125: iload 5
    //   2127: iload 7
    //   2129: iadd
    //   2130: newarray byte
    //   2132: putfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2135: aload 15
    //   2137: iload_3
    //   2138: aload_0
    //   2139: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2142: iconst_0
    //   2143: iload 5
    //   2145: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2148: aload 15
    //   2150: iload 7
    //   2152: aload_0
    //   2153: getfield 148	com/tencent/mm/plugin/voip/model/e:NJW	[B
    //   2156: iload 5
    //   2158: iload 7
    //   2160: invokestatic 888	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2163: new 866	com/tencent/mm/protocal/protobuf/ciq
    //   2166: dup
    //   2167: invokespecial 867	com/tencent/mm/protocal/protobuf/ciq:<init>	()V
    //   2170: astore 16
    //   2172: aload 16
    //   2174: iconst_4
    //   2175: putfield 912	com/tencent/mm/protocal/protobuf/ciq:Tpw	I
    //   2178: aload 16
    //   2180: aload 15
    //   2182: iload_3
    //   2183: iconst_4
    //   2184: iadd
    //   2185: iload 5
    //   2187: iconst_4
    //   2188: isub
    //   2189: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   2192: putfield 915	com/tencent/mm/protocal/protobuf/ciq:Tpx	Lcom/tencent/mm/cd/b;
    //   2195: aload 16
    //   2197: aload 15
    //   2199: iload 4
    //   2201: iconst_4
    //   2202: iadd
    //   2203: iload 7
    //   2205: iconst_4
    //   2206: isub
    //   2207: invokestatic 880	com/tencent/mm/cd/b:S	([BII)Lcom/tencent/mm/cd/b;
    //   2210: putfield 918	com/tencent/mm/protocal/protobuf/ciq:Tpy	Lcom/tencent/mm/cd/b;
    //   2213: aload 16
    //   2215: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   2218: arraylength
    //   2219: istore_3
    //   2220: aload_0
    //   2221: aload 16
    //   2223: invokevirtual 921	com/tencent/mm/protocal/protobuf/ciq:toByteArray	()[B
    //   2226: iconst_2
    //   2227: iload_3
    //   2228: invokespecial 923	com/tencent/mm/plugin/voip/model/e:K	([BII)I
    //   2231: pop
    //   2232: goto -444 -> 1788
    //   2235: astore_1
    //   2236: ldc_w 263
    //   2239: new 328	java/lang/StringBuilder
    //   2242: dup
    //   2243: ldc_w 836
    //   2246: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2249: aload_1
    //   2250: invokevirtual 336	java/lang/Exception:toString	()Ljava/lang/String;
    //   2253: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2259: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2262: aload_0
    //   2263: sipush 2004
    //   2266: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2269: aload_0
    //   2270: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2273: ineg
    //   2274: istore_2
    //   2275: ldc_w 976
    //   2278: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2281: iload_2
    //   2282: ireturn
    //   2283: aload 13
    //   2285: getfield 858	android/media/MediaCodec$BufferInfo:size	I
    //   2288: istore_2
    //   2289: goto -328 -> 1961
    //   2292: aload_0
    //   2293: getfield 179	com/tencent/mm/plugin/voip/model/e:tQV	I
    //   2296: istore_3
    //   2297: aload_0
    //   2298: iload_3
    //   2299: iconst_1
    //   2300: iadd
    //   2301: putfield 179	com/tencent/mm/plugin/voip/model/e:tQV	I
    //   2304: iload_3
    //   2305: iconst_5
    //   2306: if_icmple -31 -> 2275
    //   2309: aload_0
    //   2310: sipush 2006
    //   2313: putfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2316: aload_0
    //   2317: getfield 138	com/tencent/mm/plugin/voip/model/e:tQK	I
    //   2320: ineg
    //   2321: istore_2
    //   2322: goto -47 -> 2275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2325	0	this	e
    //   0	2325	1	paramArrayOfByte	byte[]
    //   0	2325	2	paramInt1	int
    //   0	2325	3	paramInt2	int
    //   0	2325	4	paramInt3	int
    //   7	2182	5	i	int
    //   637	263	6	j	int
    //   1017	1190	7	k	int
    //   1057	329	8	m	int
    //   967	421	9	n	int
    //   970	414	10	i1	int
    //   556	37	11	l	long
    //   127	18	13	localObject1	Object
    //   418	16	13	localException1	Exception
    //   495	127	13	localObject2	Object
    //   787	16	13	localException2	Exception
    //   819	1465	13	arrayOfByte1	byte[]
    //   10	904	14	localObject3	Object
    //   911	1287	15	arrayOfByte2	byte[]
    //   955	1267	16	localObject4	Object
    //   964	514	17	localciq	com.tencent.mm.protocal.protobuf.ciq
    // Exception table:
    //   from	to	target	type
    //   379	384	418	java/lang/Exception
    //   478	494	787	java/lang/Exception
    //   1306	1311	1394	java/lang/Exception
    //   1579	1584	1592	java/lang/Exception
    //   511	544	2235	java/lang/Exception
    //   548	558	2235	java/lang/Exception
    //   564	608	2235	java/lang/Exception
    //   608	633	2235	java/lang/Exception
    //   646	672	2235	java/lang/Exception
    //   678	689	2235	java/lang/Exception
    //   695	776	2235	java/lang/Exception
    //   824	831	2235	java/lang/Exception
    //   836	851	2235	java/lang/Exception
    //   851	891	2235	java/lang/Exception
    //   904	941	2235	java/lang/Exception
    //   941	966	2235	java/lang/Exception
    //   982	1050	2235	java/lang/Exception
    //   1067	1089	2235	java/lang/Exception
    //   1089	1107	2235	java/lang/Exception
    //   1107	1138	2235	java/lang/Exception
    //   1138	1154	2235	java/lang/Exception
    //   1154	1306	2235	java/lang/Exception
    //   1327	1367	2235	java/lang/Exception
    //   1375	1383	2235	java/lang/Exception
    //   1395	1434	2235	java/lang/Exception
    //   1437	1492	2235	java/lang/Exception
    //   1504	1579	2235	java/lang/Exception
    //   1593	1632	2235	java/lang/Exception
    //   1635	1706	2235	java/lang/Exception
    //   1718	1788	2235	java/lang/Exception
    //   1788	1921	2235	java/lang/Exception
    //   1933	1948	2235	java/lang/Exception
    //   1948	1958	2235	java/lang/Exception
    //   1961	1982	2235	java/lang/Exception
    //   1984	1993	2235	java/lang/Exception
    //   1995	2048	2235	java/lang/Exception
    //   2060	2135	2235	java/lang/Exception
    //   2135	2232	2235	java/lang/Exception
    //   2283	2289	2235	java/lang/Exception
  }
  
  public final void eWp()
  {
    AppMethodBeat.i(114839);
    this.isRuning = false;
    try
    {
      StopEncoder();
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
      }
      if (this.tQQ != null)
      {
        this.tQQ.flush();
        this.tQQ.close();
      }
      if (this.tQN != null)
      {
        this.tQN.stop();
        this.tQN.release();
      }
      AppMethodBeat.o(114839);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AvcEncoder", " error:" + localException.toString());
      AppMethodBeat.o(114839);
    }
  }
  
  final class a
  {
    public short NKb;
    public short NKc;
    public byte cFps;
    public byte cHPPMaxLyr;
    public byte cIPeriod;
    public byte cIReqFlag;
    public byte cQPmax;
    public byte cQPmin;
    public byte cRSLevel;
    public byte cResolution;
    public byte cRsvd1;
    public byte cRsvd2;
    public byte cSkipFlag;
    public byte cSwitch;
    public short iKbps;
    public byte[] s2p;
    
    public a()
    {
      AppMethodBeat.i(114832);
      this.s2p = new byte[18];
      AppMethodBeat.o(114832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.e
 * JD-Core Version:    0.7.0.1
 */