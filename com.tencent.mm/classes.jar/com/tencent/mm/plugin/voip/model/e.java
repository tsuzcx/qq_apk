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
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

@TargetApi(16)
public final class e
{
  public static int EMethodGetQosPara;
  public static short[] SizeFormat2WH;
  public static int VFMT_HEVC_HW;
  public static int VFMT_i264;
  public static int frameID;
  private static String path;
  private static int streamqueuesize;
  public static final String[] supportedH264HwCodecPrefixes;
  l Ayh;
  private byte[] Azn;
  private ByteBuffer Azo;
  public LinkedList<biz> Azp;
  public LinkedList<Integer> Azq;
  public int Azr;
  a Azs;
  public String ENCODING;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public long gSc;
  public boolean isRuning;
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
  public int otc;
  private z otd;
  private byte[] ote;
  private MediaMuxer otf;
  private int otg;
  private boolean oth;
  private BufferedOutputStream oti;
  g otj;
  public int otk;
  public int otl;
  public int otm;
  public int otn;
  private BufferedOutputStream outputStream;
  
  static
  {
    AppMethodBeat.i(177015);
    streamqueuesize = 100;
    frameID = 0;
    path = b.aph();
    VFMT_i264 = 18;
    VFMT_HEVC_HW = 19;
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK", "OMX.sprd" };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(177015);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    AppMethodBeat.i(114837);
    this.otc = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.Azn = null;
    this.ote = null;
    this.Azo = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.gSc = 0L;
    this.Ayh = null;
    this.Azp = new LinkedList();
    this.Azq = new LinkedList();
    this.otj = null;
    this.otk = 0;
    this.otl = 8;
    this.otm = 0;
    this.otn = 0;
    this.Azr = 0;
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
    this.Azs = new a();
    this.otd = null;
    this.otl = 8;
    this.otk = 0;
    this.otm = 0;
    this.otc = 0;
    paramString = new biz();
    paramString.EXQ = 1L;
    paramString.EXR = 24;
    paramString.EXS = 1L;
    paramString.EXT = 24;
    paramString.EXU = 0L;
    paramString.EXV = 0;
    this.Azp.add(paramString);
    this.Azq.add(Integer.valueOf(0));
    this.ote = null;
    this.Azo = null;
    this.otn = 0;
    this.Azr = 0;
    this.gSc = 0L;
    AppMethodBeat.o(114837);
  }
  
  private int C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114844);
    if ((paramArrayOfByte != null) && (this.Ayh.ABJ != null))
    {
      int i = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = VFMT_HEVC_HW;
      }
      i = this.Ayh.ABJ.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
      if (i >= 0)
      {
        this.Azr = 0;
        ac.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114844);
      return paramInt1;
      paramInt1 = this.Azr;
      this.Azr = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.otc = 2008;
        paramInt1 = -this.otc;
        ac.e("MeidaCodec[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(paramInt1)));
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(114843);
    try
    {
      if (this.otd != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        ac.v("MeidaCodec[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.otd.setParameters(localBundle);
        AppMethodBeat.o(114843);
        return true;
      }
    }
    catch (Exception localException)
    {
      ac.e("MeidaCodec[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
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
      if (this.otd != null)
      {
        this.otd.stop();
        this.otd.release();
      }
      AppMethodBeat.o(114838);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
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
          ac.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
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
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(114834);
    bool2 = false;
    bool1 = bool2;
    if (d.kZ(23))
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
          ac.e("MeidaCodec[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
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
        ac.i("MeidaCodec[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      ac.i("MeidaCodec[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
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
  private boolean b(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(114833);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool2 = bool3;
      if (8 <= this.otl)
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
                ac.i("MeidaCodec[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.otl + ", MIME:" + paramString);
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
  
  private static String bE(byte[] paramArrayOfByte)
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
  
  private static ArrayList<Integer> bF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114841);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = bE(paramArrayOfByte);
    String str = bE(new byte[] { 0, 0, 0, 1 });
    ac.d("MeidaCodec[HWEnc]", "parent: " + paramArrayOfByte + ", child:" + str);
    for (;;)
    {
      int j = paramArrayOfByte.indexOf(str, i);
      if (j == -1) {
        break;
      }
      ac.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + j);
      i = str.length() + j;
      localArrayList.add(Integer.valueOf(j / 2));
    }
    AppMethodBeat.o(114841);
    return localArrayList;
  }
  
  @SuppressLint({"NewApi"})
  private int bVq()
  {
    AppMethodBeat.i(114836);
    if (this.otd != null) {
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
                ac.i("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(str2)));
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label209;
      }
      ac.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.otc = 2001;
      i = -this.otc;
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
    label209:
    ac.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 4);
    str1 = this.mediaFormat.getString("mime");
    this.otk = 1;
    label391:
    boolean bool;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.kZ(23)))
    {
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x1) == 0)) {
        break label557;
      }
      i = 1;
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x4) == 0)) {
        break label562;
      }
      j = 1;
      bool = b(localMediaCodecInfo, str1);
      if ((j == 0) || (!bool)) {
        break label567;
      }
      this.mediaFormat.setInteger("profile", 8);
      this.mediaFormat.setInteger("level", 256);
      bool = true;
    }
    for (;;)
    {
      label438:
      if (bool) {}
      for (this.otk = this.mediaFormat.getInteger("profile");; this.otk = 1)
      {
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try
        {
          this.otd = z.q(str1, false);
          ac.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.otk);
          this.otd.a(this.mediaFormat, null, 1);
          this.otd.start();
          this.otj = new g();
          AppMethodBeat.o(114836);
          return 2000;
        }
        catch (Exception localException)
        {
          label557:
          ac.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
          this.otc = 2002;
          i = -this.otc;
          AppMethodBeat.o(114836);
          return i;
        }
        i = 0;
        break;
        label562:
        j = 0;
        break label391;
        label567:
        if (i != 0)
        {
          this.mediaFormat.setInteger("profile", 1);
          this.mediaFormat.setInteger("level", 256);
          bool = true;
          break label438;
        }
        if (localMediaCodecInfo == null) {
          break label680;
        }
        bool = a(localMediaCodecInfo, str1, this.otl);
        break label438;
      }
      label680:
      bool = false;
    }
  }
  
  private long computePresentationTime(long paramLong)
  {
    AppMethodBeat.i(208210);
    int i = Math.min(Math.max(this.m_framerate, 15), 30);
    if ((paramLong == 0L) || (this.gSc == 0L)) {}
    for (this.gSc = 132L;; this.gSc = (1000000 / i + paramLong))
    {
      paramLong = this.gSc;
      AppMethodBeat.o(208210);
      return paramLong;
      paramLong = this.gSc;
    }
  }
  
  public final void DoQosSvrCtrl()
  {
    AppMethodBeat.i(208209);
    Object localObject;
    int k;
    if ((this.Ayh != null) && (this.Ayh.ABJ != null))
    {
      if (this.Ayh.ABJ.setAppCmd(EMethodGetQosPara, this.Azs.s2p, this.Azs.s2p.length) >= 0)
      {
        localObject = this.Azs;
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
        localObject = this.Azs;
        ac.d("MeidaCodec[HWEnc]", "raw S2P:" + ((a)localObject).s2p);
        ac.d("MeidaCodec[HWEnc]", "-S2P- iKbps:" + ((a)localObject).iKbps + ", fps:" + ((a)localObject).cFps + ", IP:" + ((a)localObject).cIPeriod + ", RS:" + ((a)localObject).cRSLevel + ", QPMin:" + ((a)localObject).cQPmin + ", QPMax:" + ((a)localObject).cQPmax + ", HPP:" + ((a)localObject).cHPPMaxLyr + ", SWitch:" + ((a)localObject).cSwitch + ", Reso:" + ((a)localObject).cResolution + ", Rsvd1:" + ((a)localObject).cRsvd1 + ", Rsvd2:" + ((a)localObject).cRsvd2 + ", Skip:" + ((a)localObject).cSkipFlag + ", IReq:" + ((a)localObject).cIReqFlag);
      }
      k = this.Azs.iKbps;
      if (this.otk != 8) {
        break label704;
      }
    }
    label704:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (i == 0)
      {
        double d = Math.max(Math.min(this.Ayh.ABJ.AHb, 30), 0) * 1.0D / 100.0D;
        j = (int)(k * (d + 1.0D));
      }
      if (this.m_br_kbps != j)
      {
        SetBitRate(j);
        ac.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + j + ", tuneRatio:" + this.Ayh.ABJ.AHb);
        this.m_br_kbps = j;
      }
      if ((1 == this.Azs.cIReqFlag) && (frameID > 0))
      {
        if (this.otd != null)
        {
          ac.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
          localObject = new Bundle();
          ((Bundle)localObject).putInt("request-sync", 0);
          this.otd.setParameters((Bundle)localObject);
        }
        ac.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
      }
      if (this.Azs.cFps != this.m_framerate) {
        this.m_framerate = this.Azs.cFps;
      }
      AppMethodBeat.o(208209);
      return;
    }
  }
  
  /* Error */
  public final int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 680
    //   3: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   22: if_icmpeq +33 -> 55
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   40: aload_0
    //   41: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   44: imul
    //   45: iconst_3
    //   46: imul
    //   47: iconst_2
    //   48: idiv
    //   49: invokestatic 684	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   52: putfield 148	com/tencent/mm/plugin/voip/model/e:Azo	Ljava/nio/ByteBuffer;
    //   55: aload_0
    //   56: getfield 148	com/tencent/mm/plugin/voip/model/e:Azo	Ljava/nio/ByteBuffer;
    //   59: ifnonnull +23 -> 82
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   67: aload_0
    //   68: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   71: imul
    //   72: iconst_3
    //   73: imul
    //   74: iconst_2
    //   75: idiv
    //   76: invokestatic 684	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   79: putfield 148	com/tencent/mm/plugin/voip/model/e:Azo	Ljava/nio/ByteBuffer;
    //   82: ldc 254
    //   84: new 256	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 686
    //   91: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 191	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   98: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc_w 688
    //   104: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 193	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   111: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 198	com/tencent/mm/plugin/voip/model/e:Azs	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   124: getfield 626	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   127: ifne +1797 -> 1924
    //   130: aload_0
    //   131: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   134: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   137: ifnull +1787 -> 1924
    //   140: aload_0
    //   141: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   144: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   147: aload_1
    //   148: aload_1
    //   149: invokevirtual 691	java/nio/ByteBuffer:capacity	()I
    //   152: aload_0
    //   153: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   156: aload_0
    //   157: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   160: iload 4
    //   162: aload_0
    //   163: getfield 148	com/tencent/mm/plugin/voip/model/e:Azo	Ljava/nio/ByteBuffer;
    //   166: invokevirtual 695	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess2	(Ljava/nio/ByteBuffer;IIIILjava/nio/ByteBuffer;)I
    //   169: pop
    //   170: aload_0
    //   171: getfield 148	com/tencent/mm/plugin/voip/model/e:Azo	Ljava/nio/ByteBuffer;
    //   174: astore_1
    //   175: aload_0
    //   176: getfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   179: aload_0
    //   180: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   183: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   186: getfield 698	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   189: if_icmpne +20 -> 209
    //   192: aload_0
    //   193: getfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   196: aload_0
    //   197: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   200: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   203: getfield 701	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   206: if_icmpeq +206 -> 412
    //   209: ldc 254
    //   211: new 256	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 703
    //   218: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   225: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   228: getfield 698	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   231: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 705
    //   237: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   244: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   247: getfield 701	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   250: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 707
    //   256: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   263: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 705
    //   269: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: getfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   276: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: aload_0
    //   287: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   290: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   293: getfield 698	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   296: putfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   304: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   307: getfield 701	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   310: putfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   313: aload_0
    //   314: aload_0
    //   315: getfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   318: aload_0
    //   319: getfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   322: imul
    //   323: iconst_3
    //   324: imul
    //   325: iconst_1
    //   326: ishr
    //   327: putfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   330: aload_0
    //   331: invokespecial 709	com/tencent/mm/plugin/voip/model/e:bVq	()I
    //   334: istore_2
    //   335: iload_2
    //   336: istore_3
    //   337: iload_2
    //   338: ifge +76 -> 414
    //   341: ldc 254
    //   343: ldc_w 711
    //   346: iload_2
    //   347: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   350: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   353: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_0
    //   357: invokevirtual 714	com/tencent/mm/plugin/voip/model/e:ehl	()V
    //   360: ldc_w 680
    //   363: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: iload_2
    //   367: ireturn
    //   368: astore 13
    //   370: ldc 254
    //   372: new 256	java/lang/StringBuilder
    //   375: dup
    //   376: ldc_w 716
    //   379: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: aload 13
    //   384: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   387: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_0
    //   397: sipush 2003
    //   400: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   403: aload_0
    //   404: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   407: ineg
    //   408: istore_2
    //   409: goto -74 -> 335
    //   412: iconst_0
    //   413: istore_3
    //   414: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   417: bipush 100
    //   419: if_icmpgt +394 -> 813
    //   422: aload_0
    //   423: getfield 718	com/tencent/mm/plugin/voip/model/e:oti	Ljava/io/BufferedOutputStream;
    //   426: ifnull +387 -> 813
    //   429: aload_0
    //   430: getfield 718	com/tencent/mm/plugin/voip/model/e:oti	Ljava/io/BufferedOutputStream;
    //   433: aload_0
    //   434: getfield 148	com/tencent/mm/plugin/voip/model/e:Azo	Ljava/nio/ByteBuffer;
    //   437: invokevirtual 722	java/nio/ByteBuffer:array	()[B
    //   440: iconst_0
    //   441: aload_0
    //   442: getfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   445: invokevirtual 728	java/io/BufferedOutputStream:write	([BII)V
    //   448: iload_3
    //   449: istore_2
    //   450: aload_1
    //   451: ifnull +1440 -> 1891
    //   454: aload_0
    //   455: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   458: ifnull +1433 -> 1891
    //   461: aload_0
    //   462: iconst_0
    //   463: putfield 173	com/tencent/mm/plugin/voip/model/e:otn	I
    //   466: invokestatic 734	java/lang/System:currentTimeMillis	()J
    //   469: lstore 11
    //   471: ldc 254
    //   473: new 256	java/lang/StringBuilder
    //   476: dup
    //   477: ldc_w 736
    //   480: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: aload_0
    //   484: getfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   487: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   490: ldc_w 738
    //   493: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   499: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: ldc_w 740
    //   505: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: lload 11
    //   510: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   513: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: aload_0
    //   520: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   523: invokevirtual 747	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   526: astore 13
    //   528: aload_0
    //   529: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   532: invokevirtual 750	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   535: astore_1
    //   536: aload_0
    //   537: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   540: ldc2_w 751
    //   543: invokevirtual 756	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   546: istore_3
    //   547: iload_3
    //   548: iflt +60 -> 608
    //   551: aload_0
    //   552: aload_0
    //   553: getfield 152	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   556: invokespecial 758	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   559: lstore 11
    //   561: aload 13
    //   563: iload_3
    //   564: aaload
    //   565: astore 13
    //   567: aload 13
    //   569: invokevirtual 762	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   572: pop
    //   573: aload 13
    //   575: aload_0
    //   576: getfield 148	com/tencent/mm/plugin/voip/model/e:Azo	Ljava/nio/ByteBuffer;
    //   579: invokevirtual 766	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   582: pop
    //   583: aload_0
    //   584: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   587: iload_3
    //   588: aload_0
    //   589: getfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   592: lload 11
    //   594: iconst_0
    //   595: invokevirtual 769	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   598: aload_0
    //   599: aload_0
    //   600: getfield 152	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   603: lconst_1
    //   604: ladd
    //   605: putfield 152	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   608: new 771	android/media/MediaCodec$BufferInfo
    //   611: dup
    //   612: invokespecial 772	android/media/MediaCodec$BufferInfo:<init>	()V
    //   615: astore 13
    //   617: aload_0
    //   618: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   621: aload 13
    //   623: aload_0
    //   624: getfield 140	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   627: i2l
    //   628: invokevirtual 776	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   631: istore 4
    //   633: iload_2
    //   634: istore_3
    //   635: iload 4
    //   637: istore 6
    //   639: iload 4
    //   641: bipush 254
    //   643: if_icmpne +242 -> 885
    //   646: aload_0
    //   647: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   650: invokevirtual 780	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   653: astore 14
    //   655: ldc 254
    //   657: ldc_w 782
    //   660: aload 14
    //   662: invokestatic 325	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   665: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   668: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: iload_2
    //   672: istore_3
    //   673: iload 4
    //   675: istore 6
    //   677: aload 14
    //   679: ldc_w 497
    //   682: invokevirtual 785	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   685: ifeq +200 -> 885
    //   688: iload_2
    //   689: istore_3
    //   690: iload 4
    //   692: istore 6
    //   694: aload 14
    //   696: ldc_w 497
    //   699: invokevirtual 516	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   702: i2d
    //   703: aload_0
    //   704: getfield 193	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   707: sipush 1000
    //   710: imul
    //   711: i2d
    //   712: ldc2_w 786
    //   715: dmul
    //   716: dcmpl
    //   717: ifle +168 -> 885
    //   720: ldc 254
    //   722: new 256	java/lang/StringBuilder
    //   725: dup
    //   726: ldc_w 789
    //   729: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: aload 14
    //   734: ldc_w 497
    //   737: invokevirtual 516	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   740: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: ldc_w 791
    //   746: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_0
    //   750: getfield 193	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   753: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload_0
    //   763: sipush 2007
    //   766: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   769: aload_0
    //   770: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   773: istore_2
    //   774: iload_2
    //   775: ineg
    //   776: istore_2
    //   777: ldc_w 680
    //   780: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   783: iload_2
    //   784: ireturn
    //   785: astore 13
    //   787: ldc 254
    //   789: new 256	java/lang/StringBuilder
    //   792: dup
    //   793: ldc_w 336
    //   796: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   799: aload 13
    //   801: invokevirtual 337	java/lang/Exception:toString	()Ljava/lang/String;
    //   804: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: iload_3
    //   814: istore_2
    //   815: goto -365 -> 450
    //   818: aload_0
    //   819: getfield 793	com/tencent/mm/plugin/voip/model/e:oth	Z
    //   822: ifeq +23 -> 845
    //   825: aload 14
    //   827: ifnull +18 -> 845
    //   830: aload_0
    //   831: getfield 795	com/tencent/mm/plugin/voip/model/e:otf	Landroid/media/MediaMuxer;
    //   834: aload_0
    //   835: getfield 797	com/tencent/mm/plugin/voip/model/e:otg	I
    //   838: aload 14
    //   840: aload 13
    //   842: invokevirtual 803	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   845: aload 13
    //   847: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   850: istore_3
    //   851: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   854: iconst_1
    //   855: iadd
    //   856: putstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   859: aload_0
    //   860: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   863: iload 6
    //   865: iconst_0
    //   866: invokevirtual 810	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   869: aload_0
    //   870: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   873: aload 13
    //   875: aload_0
    //   876: getfield 140	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   879: i2l
    //   880: invokevirtual 776	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   883: istore 6
    //   885: iload_3
    //   886: istore_2
    //   887: iload 6
    //   889: iflt +994 -> 1883
    //   892: aload_1
    //   893: iload 6
    //   895: aaload
    //   896: astore 14
    //   898: aload 13
    //   900: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   903: newarray byte
    //   905: astore 15
    //   907: aload 14
    //   909: aload 15
    //   911: invokevirtual 815	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   914: pop
    //   915: aload_0
    //   916: getfield 817	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   919: ifnull +16 -> 935
    //   922: aload_0
    //   923: getfield 817	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   926: aload 15
    //   928: iconst_0
    //   929: aload 15
    //   931: arraylength
    //   932: invokevirtual 728	java/io/BufferedOutputStream:write	([BII)V
    //   935: aload 13
    //   937: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   940: iconst_2
    //   941: if_icmpne +489 -> 1430
    //   944: aload 15
    //   946: invokestatic 819	com/tencent/mm/plugin/voip/model/e:bF	([B)Ljava/util/ArrayList;
    //   949: astore 16
    //   951: new 821	com/tencent/mm/protocal/protobuf/biy
    //   954: dup
    //   955: invokespecial 822	com/tencent/mm/protocal/protobuf/biy:<init>	()V
    //   958: astore 17
    //   960: iconst_0
    //   961: istore 9
    //   963: iconst_0
    //   964: istore 10
    //   966: iconst_0
    //   967: istore 5
    //   969: iconst_0
    //   970: istore 4
    //   972: iconst_0
    //   973: istore_3
    //   974: iconst_0
    //   975: istore_2
    //   976: aload 16
    //   978: invokevirtual 824	java/util/ArrayList:size	()I
    //   981: iconst_3
    //   982: if_icmpne +264 -> 1246
    //   985: aload_0
    //   986: getfield 138	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   989: ldc 242
    //   991: invokevirtual 246	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   994: ifeq +252 -> 1246
    //   997: aload 16
    //   999: iconst_0
    //   1000: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1003: checkcast 227	java/lang/Integer
    //   1006: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1009: iconst_4
    //   1010: iadd
    //   1011: istore 7
    //   1013: aload 16
    //   1015: iconst_1
    //   1016: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1019: checkcast 227	java/lang/Integer
    //   1022: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1025: iconst_4
    //   1026: iadd
    //   1027: istore 5
    //   1029: aload 16
    //   1031: iconst_2
    //   1032: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1035: checkcast 227	java/lang/Integer
    //   1038: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1041: iconst_4
    //   1042: iadd
    //   1043: istore_3
    //   1044: iload 5
    //   1046: iload 7
    //   1048: isub
    //   1049: iconst_4
    //   1050: isub
    //   1051: istore 8
    //   1053: iload_3
    //   1054: iload 5
    //   1056: isub
    //   1057: iconst_4
    //   1058: isub
    //   1059: istore 4
    //   1061: aload 13
    //   1063: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1066: iload_3
    //   1067: isub
    //   1068: istore_2
    //   1069: aload 17
    //   1071: aload 15
    //   1073: iload 7
    //   1075: iload 8
    //   1077: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1080: putfield 840	com/tencent/mm/protocal/protobuf/biy:EXP	Lcom/tencent/mm/bw/b;
    //   1083: ldc 254
    //   1085: new 256	java/lang/StringBuilder
    //   1088: dup
    //   1089: ldc_w 842
    //   1092: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1095: iload 5
    //   1097: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1100: ldc_w 844
    //   1103: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: iload 4
    //   1108: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1111: ldc_w 846
    //   1114: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: iload_3
    //   1118: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1121: ldc_w 844
    //   1124: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: iload_2
    //   1128: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1131: ldc_w 848
    //   1134: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: iload 7
    //   1139: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1142: ldc_w 844
    //   1145: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: iload 8
    //   1150: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1159: aload_0
    //   1160: getfield 167	com/tencent/mm/plugin/voip/model/e:otk	I
    //   1163: iconst_1
    //   1164: if_icmpeq +199 -> 1363
    //   1167: aload_0
    //   1168: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1171: aload 15
    //   1173: invokevirtual 852	com/tencent/mm/plugin/voip/model/g:bG	([B)Z
    //   1176: ifeq +187 -> 1363
    //   1179: aload_0
    //   1180: aload_0
    //   1181: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1184: getfield 855	com/tencent/mm/plugin/voip/model/g:Azv	I
    //   1187: putfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1190: aload_0
    //   1191: iconst_1
    //   1192: putfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1195: ldc 254
    //   1197: new 256	java/lang/StringBuilder
    //   1200: dup
    //   1201: ldc_w 857
    //   1204: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1207: aload_0
    //   1208: getfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1211: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1214: ldc_w 859
    //   1217: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: aload_0
    //   1221: getfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1224: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1227: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1230: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1233: aload_0
    //   1234: invokespecial 709	com/tencent/mm/plugin/voip/model/e:bVq	()I
    //   1237: istore_2
    //   1238: ldc_w 680
    //   1241: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1244: iload_2
    //   1245: ireturn
    //   1246: iload 10
    //   1248: istore 8
    //   1250: iload 9
    //   1252: istore 7
    //   1254: aload 16
    //   1256: invokevirtual 824	java/util/ArrayList:size	()I
    //   1259: iconst_2
    //   1260: if_icmpne -177 -> 1083
    //   1263: aload 16
    //   1265: iconst_0
    //   1266: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1269: checkcast 227	java/lang/Integer
    //   1272: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1275: iconst_4
    //   1276: iadd
    //   1277: istore 5
    //   1279: aload 16
    //   1281: iconst_1
    //   1282: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1285: checkcast 227	java/lang/Integer
    //   1288: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1291: iconst_4
    //   1292: iadd
    //   1293: istore_3
    //   1294: iload_3
    //   1295: iload 5
    //   1297: isub
    //   1298: iconst_4
    //   1299: isub
    //   1300: istore 4
    //   1302: aload 13
    //   1304: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1307: iload_3
    //   1308: isub
    //   1309: istore_2
    //   1310: iload 10
    //   1312: istore 8
    //   1314: iload 9
    //   1316: istore 7
    //   1318: goto -235 -> 1083
    //   1321: astore_1
    //   1322: ldc 254
    //   1324: new 256	java/lang/StringBuilder
    //   1327: dup
    //   1328: ldc_w 861
    //   1331: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1334: aload_1
    //   1335: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1338: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1344: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1347: aload_0
    //   1348: sipush 2005
    //   1351: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1354: aload_0
    //   1355: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1358: ineg
    //   1359: istore_2
    //   1360: goto -122 -> 1238
    //   1363: aload 17
    //   1365: iconst_4
    //   1366: putfield 864	com/tencent/mm/protocal/protobuf/biy:EXM	I
    //   1369: aload 17
    //   1371: aload 15
    //   1373: iload 5
    //   1375: iload 4
    //   1377: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1380: putfield 867	com/tencent/mm/protocal/protobuf/biy:EXN	Lcom/tencent/mm/bw/b;
    //   1383: aload 17
    //   1385: aload 15
    //   1387: iload_3
    //   1388: iload_2
    //   1389: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1392: putfield 870	com/tencent/mm/protocal/protobuf/biy:EXO	Lcom/tencent/mm/bw/b;
    //   1395: aload 17
    //   1397: invokevirtual 873	com/tencent/mm/protocal/protobuf/biy:toByteArray	()[B
    //   1400: arraylength
    //   1401: istore_2
    //   1402: aload_0
    //   1403: aload 17
    //   1405: invokevirtual 873	com/tencent/mm/protocal/protobuf/biy:toByteArray	()[B
    //   1408: aload 13
    //   1410: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1413: iload_2
    //   1414: invokespecial 875	com/tencent/mm/plugin/voip/model/e:C	([BII)I
    //   1417: istore_2
    //   1418: iload_2
    //   1419: ifge -601 -> 818
    //   1422: ldc_w 680
    //   1425: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1428: iload_2
    //   1429: ireturn
    //   1430: aload_0
    //   1431: getfield 167	com/tencent/mm/plugin/voip/model/e:otk	I
    //   1434: iconst_1
    //   1435: if_icmpeq +124 -> 1559
    //   1438: aload_0
    //   1439: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1442: aload 15
    //   1444: invokevirtual 878	com/tencent/mm/plugin/voip/model/g:bH	([B)Z
    //   1447: ifeq +112 -> 1559
    //   1450: aload_0
    //   1451: aload_0
    //   1452: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1455: getfield 855	com/tencent/mm/plugin/voip/model/g:Azv	I
    //   1458: putfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1461: aload_0
    //   1462: iconst_1
    //   1463: putfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1466: ldc 254
    //   1468: new 256	java/lang/StringBuilder
    //   1471: dup
    //   1472: ldc_w 857
    //   1475: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1478: aload_0
    //   1479: getfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1482: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1485: ldc_w 859
    //   1488: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: aload_0
    //   1492: getfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1495: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1498: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1504: aload_0
    //   1505: invokespecial 709	com/tencent/mm/plugin/voip/model/e:bVq	()I
    //   1508: istore_2
    //   1509: ldc_w 680
    //   1512: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1515: iload_2
    //   1516: ireturn
    //   1517: astore_1
    //   1518: ldc 254
    //   1520: new 256	java/lang/StringBuilder
    //   1523: dup
    //   1524: ldc_w 861
    //   1527: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1530: aload_1
    //   1531: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1534: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1543: aload_0
    //   1544: sipush 2005
    //   1547: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1550: aload_0
    //   1551: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1554: ineg
    //   1555: istore_2
    //   1556: goto -47 -> 1509
    //   1559: aload 13
    //   1561: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1564: ifeq +73 -> 1637
    //   1567: aload 13
    //   1569: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1572: iconst_1
    //   1573: if_icmpeq +64 -> 1637
    //   1576: aload_0
    //   1577: sipush 2009
    //   1580: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1583: aload_0
    //   1584: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1587: ineg
    //   1588: istore_2
    //   1589: ldc 254
    //   1591: new 256	java/lang/StringBuilder
    //   1594: dup
    //   1595: ldc_w 880
    //   1598: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1601: aload 13
    //   1603: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1606: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1609: ldc_w 844
    //   1612: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: aload 13
    //   1617: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1620: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1623: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1626: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1629: ldc_w 680
    //   1632: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1635: iload_2
    //   1636: ireturn
    //   1637: iconst_4
    //   1638: invokestatic 883	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1641: astore 16
    //   1643: aload 16
    //   1645: aload 13
    //   1647: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1650: iconst_4
    //   1651: isub
    //   1652: invokevirtual 885	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1655: pop
    //   1656: aload 16
    //   1658: getstatic 888	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1661: invokevirtual 580	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1664: invokevirtual 722	java/nio/ByteBuffer:array	()[B
    //   1667: iconst_0
    //   1668: aload 15
    //   1670: iconst_0
    //   1671: iconst_4
    //   1672: invokestatic 892	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1675: invokestatic 734	java/lang/System:currentTimeMillis	()J
    //   1678: lstore 11
    //   1680: ldc 254
    //   1682: new 256	java/lang/StringBuilder
    //   1685: dup
    //   1686: ldc_w 894
    //   1689: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1692: aload 13
    //   1694: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1697: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1700: ldc_w 896
    //   1703: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1706: aload 13
    //   1708: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1711: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1714: ldc_w 738
    //   1717: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   1723: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: ldc_w 740
    //   1729: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: lload 11
    //   1734: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1737: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1740: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1743: new 898	com/tencent/mm/protocal/protobuf/bix
    //   1746: dup
    //   1747: invokespecial 899	com/tencent/mm/protocal/protobuf/bix:<init>	()V
    //   1750: astore 16
    //   1752: aload 16
    //   1754: aload 15
    //   1756: iconst_0
    //   1757: aload 13
    //   1759: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1762: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1765: putfield 902	com/tencent/mm/protocal/protobuf/bix:EXI	Lcom/tencent/mm/bw/b;
    //   1768: aload 16
    //   1770: iconst_1
    //   1771: putfield 905	com/tencent/mm/protocal/protobuf/bix:EXJ	I
    //   1774: aload 16
    //   1776: aload_0
    //   1777: getfield 161	com/tencent/mm/plugin/voip/model/e:Azp	Ljava/util/LinkedList;
    //   1780: putfield 908	com/tencent/mm/protocal/protobuf/bix:EXK	Ljava/util/LinkedList;
    //   1783: aload_0
    //   1784: getfield 163	com/tencent/mm/plugin/voip/model/e:Azq	Ljava/util/LinkedList;
    //   1787: iconst_0
    //   1788: aload 13
    //   1790: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1793: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1796: invokevirtual 912	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1799: pop
    //   1800: aload 16
    //   1802: aload_0
    //   1803: getfield 163	com/tencent/mm/plugin/voip/model/e:Azq	Ljava/util/LinkedList;
    //   1806: putfield 915	com/tencent/mm/protocal/protobuf/bix:EXL	Ljava/util/LinkedList;
    //   1809: aload 16
    //   1811: invokevirtual 916	com/tencent/mm/protocal/protobuf/bix:toByteArray	()[B
    //   1814: arraylength
    //   1815: istore_2
    //   1816: aload_0
    //   1817: aload 16
    //   1819: invokevirtual 916	com/tencent/mm/protocal/protobuf/bix:toByteArray	()[B
    //   1822: aload 13
    //   1824: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1827: iload_2
    //   1828: invokespecial 875	com/tencent/mm/plugin/voip/model/e:C	([BII)I
    //   1831: istore_2
    //   1832: iload_2
    //   1833: ifge -1015 -> 818
    //   1836: ldc_w 680
    //   1839: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1842: iload_2
    //   1843: ireturn
    //   1844: astore_1
    //   1845: ldc 254
    //   1847: new 256	java/lang/StringBuilder
    //   1850: dup
    //   1851: ldc_w 336
    //   1854: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1857: aload_1
    //   1858: invokevirtual 337	java/lang/Exception:toString	()Ljava/lang/String;
    //   1861: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1867: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1870: aload_0
    //   1871: sipush 2004
    //   1874: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1877: aload_0
    //   1878: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1881: ineg
    //   1882: istore_2
    //   1883: ldc_w 680
    //   1886: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1889: iload_2
    //   1890: ireturn
    //   1891: aload_0
    //   1892: getfield 173	com/tencent/mm/plugin/voip/model/e:otn	I
    //   1895: istore_3
    //   1896: aload_0
    //   1897: iload_3
    //   1898: iconst_1
    //   1899: iadd
    //   1900: putfield 173	com/tencent/mm/plugin/voip/model/e:otn	I
    //   1903: iload_3
    //   1904: iconst_5
    //   1905: if_icmple -22 -> 1883
    //   1908: aload_0
    //   1909: sipush 2006
    //   1912: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1915: aload_0
    //   1916: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1919: ineg
    //   1920: istore_2
    //   1921: goto -38 -> 1883
    //   1924: iconst_0
    //   1925: istore_2
    //   1926: aload 13
    //   1928: astore_1
    //   1929: goto -1479 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1932	0	this	e
    //   0	1932	1	paramByteBuffer	ByteBuffer
    //   0	1932	2	paramInt1	int
    //   0	1932	3	paramInt2	int
    //   0	1932	4	paramInt3	int
    //   967	407	5	i	int
    //   637	257	6	j	int
    //   1011	306	7	k	int
    //   1051	262	8	m	int
    //   961	354	9	n	int
    //   964	347	10	i1	int
    //   469	1264	11	l	long
    //   7	1	13	localObject1	Object
    //   368	15	13	localException1	Exception
    //   526	96	13	localObject2	Object
    //   785	1142	13	localException2	Exception
    //   653	255	14	localMediaFormat	MediaFormat
    //   905	850	15	arrayOfByte	byte[]
    //   949	869	16	localObject3	Object
    //   958	446	17	localbiy	com.tencent.mm.protocal.protobuf.biy
    // Exception table:
    //   from	to	target	type
    //   330	335	368	java/lang/Exception
    //   429	448	785	java/lang/Exception
    //   1233	1238	1321	java/lang/Exception
    //   1504	1509	1517	java/lang/Exception
    //   461	547	1844	java/lang/Exception
    //   551	561	1844	java/lang/Exception
    //   567	608	1844	java/lang/Exception
    //   608	633	1844	java/lang/Exception
    //   646	671	1844	java/lang/Exception
    //   677	688	1844	java/lang/Exception
    //   694	774	1844	java/lang/Exception
    //   818	825	1844	java/lang/Exception
    //   830	845	1844	java/lang/Exception
    //   845	885	1844	java/lang/Exception
    //   898	935	1844	java/lang/Exception
    //   935	960	1844	java/lang/Exception
    //   976	1044	1844	java/lang/Exception
    //   1061	1083	1844	java/lang/Exception
    //   1083	1233	1844	java/lang/Exception
    //   1254	1294	1844	java/lang/Exception
    //   1302	1310	1844	java/lang/Exception
    //   1322	1360	1844	java/lang/Exception
    //   1363	1418	1844	java/lang/Exception
    //   1430	1504	1844	java/lang/Exception
    //   1518	1556	1844	java/lang/Exception
    //   1559	1629	1844	java/lang/Exception
    //   1637	1832	1844	java/lang/Exception
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 918
    //   3: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   22: if_icmpeq +32 -> 54
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   40: aload_0
    //   41: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   44: imul
    //   45: iconst_3
    //   46: imul
    //   47: iconst_2
    //   48: idiv
    //   49: newarray byte
    //   51: putfield 146	com/tencent/mm/plugin/voip/model/e:ote	[B
    //   54: aload_0
    //   55: getfield 146	com/tencent/mm/plugin/voip/model/e:ote	[B
    //   58: ifnonnull +22 -> 80
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   66: aload_0
    //   67: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   70: imul
    //   71: iconst_3
    //   72: imul
    //   73: iconst_2
    //   74: idiv
    //   75: newarray byte
    //   77: putfield 146	com/tencent/mm/plugin/voip/model/e:ote	[B
    //   80: ldc 254
    //   82: new 256	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 686
    //   89: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 191	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   96: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 688
    //   102: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 193	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   109: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: getfield 198	com/tencent/mm/plugin/voip/model/e:Azs	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   122: getfield 626	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   125: ifne +2184 -> 2309
    //   128: aload_0
    //   129: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   132: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   135: ifnull +2174 -> 2309
    //   138: aload_0
    //   139: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   142: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   145: aload_1
    //   146: aload_1
    //   147: arraylength
    //   148: aload_0
    //   149: getfield 187	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   152: aload_0
    //   153: getfield 189	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   156: iload 4
    //   158: aload_0
    //   159: getfield 146	com/tencent/mm/plugin/voip/model/e:ote	[B
    //   162: invokevirtual 922	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess	([BIIII[B)I
    //   165: pop
    //   166: aload_0
    //   167: getfield 146	com/tencent/mm/plugin/voip/model/e:ote	[B
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   175: aload_0
    //   176: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   179: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   182: getfield 698	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   185: if_icmpne +20 -> 205
    //   188: aload_0
    //   189: getfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   192: aload_0
    //   193: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   196: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   199: getfield 701	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   202: if_icmpeq +206 -> 408
    //   205: ldc 254
    //   207: new 256	java/lang/StringBuilder
    //   210: dup
    //   211: ldc_w 703
    //   214: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   221: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   224: getfield 698	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   227: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: ldc_w 705
    //   233: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   240: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   243: getfield 701	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   246: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 707
    //   252: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: getfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   259: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 705
    //   265: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   272: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: aload_0
    //   283: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   286: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   289: getfield 698	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   292: putfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 156	com/tencent/mm/plugin/voip/model/e:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   300: getfield 240	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   303: getfield 701	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   306: putfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 183	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   314: aload_0
    //   315: getfield 185	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   318: imul
    //   319: iconst_3
    //   320: imul
    //   321: iconst_1
    //   322: ishr
    //   323: putfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   326: aload_0
    //   327: invokespecial 709	com/tencent/mm/plugin/voip/model/e:bVq	()I
    //   330: istore_2
    //   331: iload_2
    //   332: istore_3
    //   333: iload_2
    //   334: ifge +76 -> 410
    //   337: ldc 254
    //   339: ldc_w 711
    //   342: iload_2
    //   343: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   346: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_0
    //   353: invokevirtual 714	com/tencent/mm/plugin/voip/model/e:ehl	()V
    //   356: ldc_w 918
    //   359: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: iload_2
    //   363: ireturn
    //   364: astore 13
    //   366: ldc 254
    //   368: new 256	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 716
    //   375: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: aload 13
    //   380: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   383: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_0
    //   393: sipush 2003
    //   396: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   399: aload_0
    //   400: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   403: ineg
    //   404: istore_2
    //   405: goto -74 -> 331
    //   408: iconst_0
    //   409: istore_3
    //   410: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   413: bipush 100
    //   415: if_icmpgt +392 -> 807
    //   418: aload_0
    //   419: getfield 718	com/tencent/mm/plugin/voip/model/e:oti	Ljava/io/BufferedOutputStream;
    //   422: ifnull +385 -> 807
    //   425: aload_0
    //   426: getfield 718	com/tencent/mm/plugin/voip/model/e:oti	Ljava/io/BufferedOutputStream;
    //   429: aload_0
    //   430: getfield 146	com/tencent/mm/plugin/voip/model/e:ote	[B
    //   433: iconst_0
    //   434: aload_0
    //   435: getfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   438: invokevirtual 728	java/io/BufferedOutputStream:write	([BII)V
    //   441: iload_3
    //   442: istore_2
    //   443: aload_1
    //   444: ifnull +1832 -> 2276
    //   447: aload_0
    //   448: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   451: ifnull +1825 -> 2276
    //   454: aload_0
    //   455: iconst_0
    //   456: putfield 173	com/tencent/mm/plugin/voip/model/e:otn	I
    //   459: invokestatic 734	java/lang/System:currentTimeMillis	()J
    //   462: lstore 11
    //   464: ldc 254
    //   466: new 256	java/lang/StringBuilder
    //   469: dup
    //   470: ldc_w 736
    //   473: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   476: aload_0
    //   477: getfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   480: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 738
    //   486: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   492: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc_w 740
    //   498: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: lload 11
    //   503: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   516: invokevirtual 747	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   519: astore 14
    //   521: aload_0
    //   522: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   525: invokevirtual 750	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   528: astore 13
    //   530: aload_0
    //   531: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   534: ldc2_w 751
    //   537: invokevirtual 756	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   540: istore_3
    //   541: iload_3
    //   542: iflt +62 -> 604
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 152	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   550: invokespecial 758	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   553: lstore 11
    //   555: aload 14
    //   557: iload_3
    //   558: aaload
    //   559: astore 14
    //   561: aload 14
    //   563: invokevirtual 762	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   566: pop
    //   567: aload 14
    //   569: aload_1
    //   570: iconst_0
    //   571: aload_0
    //   572: getfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   575: invokevirtual 925	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   578: pop
    //   579: aload_0
    //   580: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   583: iload_3
    //   584: aload_0
    //   585: getfield 179	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   588: lload 11
    //   590: iconst_0
    //   591: invokevirtual 769	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   594: aload_0
    //   595: aload_0
    //   596: getfield 152	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   599: lconst_1
    //   600: ladd
    //   601: putfield 152	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   604: new 771	android/media/MediaCodec$BufferInfo
    //   607: dup
    //   608: invokespecial 772	android/media/MediaCodec$BufferInfo:<init>	()V
    //   611: astore_1
    //   612: aload_0
    //   613: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   616: aload_1
    //   617: aload_0
    //   618: getfield 140	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   621: i2l
    //   622: invokevirtual 776	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   625: istore 4
    //   627: iload_2
    //   628: istore_3
    //   629: iload 4
    //   631: istore 6
    //   633: iload 4
    //   635: bipush 254
    //   637: if_icmpne +239 -> 876
    //   640: aload_0
    //   641: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   644: invokevirtual 780	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   647: astore 14
    //   649: ldc 254
    //   651: ldc_w 782
    //   654: aload 14
    //   656: invokestatic 325	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   659: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   662: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: iload_2
    //   666: istore_3
    //   667: iload 4
    //   669: istore 6
    //   671: aload 14
    //   673: ldc_w 497
    //   676: invokevirtual 785	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   679: ifeq +197 -> 876
    //   682: iload_2
    //   683: istore_3
    //   684: iload 4
    //   686: istore 6
    //   688: aload 14
    //   690: ldc_w 497
    //   693: invokevirtual 516	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   696: i2d
    //   697: aload_0
    //   698: getfield 193	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   701: sipush 1000
    //   704: imul
    //   705: i2d
    //   706: ldc2_w 786
    //   709: dmul
    //   710: dcmpl
    //   711: ifle +165 -> 876
    //   714: ldc 254
    //   716: new 256	java/lang/StringBuilder
    //   719: dup
    //   720: ldc_w 789
    //   723: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload 14
    //   728: ldc_w 497
    //   731: invokevirtual 516	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   734: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   737: ldc_w 791
    //   740: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload_0
    //   744: getfield 193	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   747: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload_0
    //   757: sipush 2007
    //   760: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   763: aload_0
    //   764: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   767: istore_2
    //   768: iload_2
    //   769: ineg
    //   770: istore_2
    //   771: ldc_w 918
    //   774: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   777: iload_2
    //   778: ireturn
    //   779: astore 13
    //   781: ldc 254
    //   783: new 256	java/lang/StringBuilder
    //   786: dup
    //   787: ldc_w 336
    //   790: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   793: aload 13
    //   795: invokevirtual 337	java/lang/Exception:toString	()Ljava/lang/String;
    //   798: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: iload_3
    //   808: istore_2
    //   809: goto -366 -> 443
    //   812: aload_0
    //   813: getfield 793	com/tencent/mm/plugin/voip/model/e:oth	Z
    //   816: ifeq +22 -> 838
    //   819: aload 14
    //   821: ifnull +17 -> 838
    //   824: aload_0
    //   825: getfield 795	com/tencent/mm/plugin/voip/model/e:otf	Landroid/media/MediaMuxer;
    //   828: aload_0
    //   829: getfield 797	com/tencent/mm/plugin/voip/model/e:otg	I
    //   832: aload 14
    //   834: aload_1
    //   835: invokevirtual 803	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   838: aload_1
    //   839: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   842: istore_3
    //   843: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   846: iconst_1
    //   847: iadd
    //   848: putstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   851: aload_0
    //   852: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   855: iload 6
    //   857: iconst_0
    //   858: invokevirtual 810	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   861: aload_0
    //   862: getfield 200	com/tencent/mm/plugin/voip/model/e:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   865: aload_1
    //   866: aload_0
    //   867: getfield 140	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   870: i2l
    //   871: invokevirtual 776	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   874: istore 6
    //   876: iload_3
    //   877: istore_2
    //   878: iload 6
    //   880: iflt +1388 -> 2268
    //   883: aload 13
    //   885: iload 6
    //   887: aaload
    //   888: astore 14
    //   890: aload_1
    //   891: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   894: newarray byte
    //   896: astore 15
    //   898: aload 14
    //   900: aload 15
    //   902: invokevirtual 815	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   905: pop
    //   906: aload_0
    //   907: getfield 817	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   910: ifnull +16 -> 926
    //   913: aload_0
    //   914: getfield 817	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   917: aload 15
    //   919: iconst_0
    //   920: aload 15
    //   922: arraylength
    //   923: invokevirtual 728	java/io/BufferedOutputStream:write	([BII)V
    //   926: aload_1
    //   927: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   930: iconst_2
    //   931: if_icmpne +547 -> 1478
    //   934: aload 15
    //   936: invokestatic 819	com/tencent/mm/plugin/voip/model/e:bF	([B)Ljava/util/ArrayList;
    //   939: astore 16
    //   941: new 821	com/tencent/mm/protocal/protobuf/biy
    //   944: dup
    //   945: invokespecial 822	com/tencent/mm/protocal/protobuf/biy:<init>	()V
    //   948: astore 17
    //   950: iconst_0
    //   951: istore 9
    //   953: iconst_0
    //   954: istore 10
    //   956: iconst_0
    //   957: istore 5
    //   959: iconst_0
    //   960: istore 4
    //   962: iconst_0
    //   963: istore_3
    //   964: iconst_0
    //   965: istore_2
    //   966: aload 16
    //   968: invokevirtual 824	java/util/ArrayList:size	()I
    //   971: iconst_3
    //   972: if_icmpne +324 -> 1296
    //   975: aload_0
    //   976: getfield 138	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   979: ldc 242
    //   981: invokevirtual 246	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   984: ifeq +312 -> 1296
    //   987: aload 16
    //   989: iconst_0
    //   990: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   993: checkcast 227	java/lang/Integer
    //   996: invokevirtual 830	java/lang/Integer:intValue	()I
    //   999: iconst_4
    //   1000: iadd
    //   1001: istore 7
    //   1003: aload 16
    //   1005: iconst_1
    //   1006: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1009: checkcast 227	java/lang/Integer
    //   1012: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1015: iconst_4
    //   1016: iadd
    //   1017: istore 5
    //   1019: aload 16
    //   1021: iconst_2
    //   1022: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1025: checkcast 227	java/lang/Integer
    //   1028: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1031: iconst_4
    //   1032: iadd
    //   1033: istore_3
    //   1034: iload 5
    //   1036: iload 7
    //   1038: isub
    //   1039: iconst_4
    //   1040: isub
    //   1041: istore 8
    //   1043: iload_3
    //   1044: iload 5
    //   1046: isub
    //   1047: iconst_4
    //   1048: isub
    //   1049: istore 4
    //   1051: aload_1
    //   1052: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1055: iload_3
    //   1056: isub
    //   1057: istore_2
    //   1058: aload 17
    //   1060: aload 15
    //   1062: iload 7
    //   1064: iload 8
    //   1066: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1069: putfield 840	com/tencent/mm/protocal/protobuf/biy:EXP	Lcom/tencent/mm/bw/b;
    //   1072: aload_0
    //   1073: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1076: ifnonnull +13 -> 1089
    //   1079: aload_0
    //   1080: aload_1
    //   1081: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1084: newarray byte
    //   1086: putfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1089: aload_0
    //   1090: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1093: ifnull +40 -> 1133
    //   1096: aload_1
    //   1097: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1100: aload_0
    //   1101: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1104: arraylength
    //   1105: if_icmple +13 -> 1118
    //   1108: aload_0
    //   1109: aload_1
    //   1110: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1113: newarray byte
    //   1115: putfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1118: aload 15
    //   1120: iconst_0
    //   1121: aload_0
    //   1122: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1125: iconst_0
    //   1126: aload_1
    //   1127: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1130: invokestatic 892	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1133: ldc 254
    //   1135: new 256	java/lang/StringBuilder
    //   1138: dup
    //   1139: ldc_w 842
    //   1142: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1145: iload 5
    //   1147: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1150: ldc_w 844
    //   1153: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: iload 4
    //   1158: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: ldc_w 846
    //   1164: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: iload_3
    //   1168: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1171: ldc_w 844
    //   1174: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: iload_2
    //   1178: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1181: ldc_w 848
    //   1184: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: iload 7
    //   1189: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1192: ldc_w 844
    //   1195: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: iload 8
    //   1200: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1209: aload_0
    //   1210: getfield 167	com/tencent/mm/plugin/voip/model/e:otk	I
    //   1213: iconst_1
    //   1214: if_icmpeq +198 -> 1412
    //   1217: aload_0
    //   1218: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1221: aload 15
    //   1223: invokevirtual 852	com/tencent/mm/plugin/voip/model/g:bG	([B)Z
    //   1226: ifeq +186 -> 1412
    //   1229: aload_0
    //   1230: aload_0
    //   1231: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1234: getfield 855	com/tencent/mm/plugin/voip/model/g:Azv	I
    //   1237: putfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1240: aload_0
    //   1241: iconst_1
    //   1242: putfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1245: ldc 254
    //   1247: new 256	java/lang/StringBuilder
    //   1250: dup
    //   1251: ldc_w 857
    //   1254: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1257: aload_0
    //   1258: getfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1261: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1264: ldc_w 859
    //   1267: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: aload_0
    //   1271: getfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1274: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1283: aload_0
    //   1284: invokespecial 709	com/tencent/mm/plugin/voip/model/e:bVq	()I
    //   1287: istore_2
    //   1288: ldc_w 918
    //   1291: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1294: iload_2
    //   1295: ireturn
    //   1296: iload 10
    //   1298: istore 8
    //   1300: iload 9
    //   1302: istore 7
    //   1304: aload 16
    //   1306: invokevirtual 824	java/util/ArrayList:size	()I
    //   1309: iconst_2
    //   1310: if_icmpne -238 -> 1072
    //   1313: aload 16
    //   1315: iconst_0
    //   1316: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1319: checkcast 227	java/lang/Integer
    //   1322: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1325: iconst_4
    //   1326: iadd
    //   1327: istore 5
    //   1329: aload 16
    //   1331: iconst_1
    //   1332: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1335: checkcast 227	java/lang/Integer
    //   1338: invokevirtual 830	java/lang/Integer:intValue	()I
    //   1341: iconst_4
    //   1342: iadd
    //   1343: istore_3
    //   1344: iload_3
    //   1345: iload 5
    //   1347: isub
    //   1348: iconst_4
    //   1349: isub
    //   1350: istore 4
    //   1352: aload_1
    //   1353: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1356: iload_3
    //   1357: isub
    //   1358: istore_2
    //   1359: iload 10
    //   1361: istore 8
    //   1363: iload 9
    //   1365: istore 7
    //   1367: goto -295 -> 1072
    //   1370: astore_1
    //   1371: ldc 254
    //   1373: new 256	java/lang/StringBuilder
    //   1376: dup
    //   1377: ldc_w 861
    //   1380: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1383: aload_1
    //   1384: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1387: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1393: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1396: aload_0
    //   1397: sipush 2005
    //   1400: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1403: aload_0
    //   1404: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1407: ineg
    //   1408: istore_2
    //   1409: goto -121 -> 1288
    //   1412: aload 17
    //   1414: iconst_4
    //   1415: putfield 864	com/tencent/mm/protocal/protobuf/biy:EXM	I
    //   1418: aload 17
    //   1420: aload 15
    //   1422: iload 5
    //   1424: iload 4
    //   1426: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1429: putfield 867	com/tencent/mm/protocal/protobuf/biy:EXN	Lcom/tencent/mm/bw/b;
    //   1432: aload 17
    //   1434: aload 15
    //   1436: iload_3
    //   1437: iload_2
    //   1438: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1441: putfield 870	com/tencent/mm/protocal/protobuf/biy:EXO	Lcom/tencent/mm/bw/b;
    //   1444: aload 17
    //   1446: invokevirtual 873	com/tencent/mm/protocal/protobuf/biy:toByteArray	()[B
    //   1449: arraylength
    //   1450: istore_2
    //   1451: aload_0
    //   1452: aload 17
    //   1454: invokevirtual 873	com/tencent/mm/protocal/protobuf/biy:toByteArray	()[B
    //   1457: aload_1
    //   1458: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1461: iload_2
    //   1462: invokespecial 875	com/tencent/mm/plugin/voip/model/e:C	([BII)I
    //   1465: istore_2
    //   1466: iload_2
    //   1467: ifge -655 -> 812
    //   1470: ldc_w 918
    //   1473: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1476: iload_2
    //   1477: ireturn
    //   1478: aload_0
    //   1479: getfield 167	com/tencent/mm/plugin/voip/model/e:otk	I
    //   1482: iconst_1
    //   1483: if_icmpeq +124 -> 1607
    //   1486: aload_0
    //   1487: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1490: aload 15
    //   1492: invokevirtual 878	com/tencent/mm/plugin/voip/model/g:bH	([B)Z
    //   1495: ifeq +112 -> 1607
    //   1498: aload_0
    //   1499: aload_0
    //   1500: getfield 165	com/tencent/mm/plugin/voip/model/e:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1503: getfield 855	com/tencent/mm/plugin/voip/model/g:Azv	I
    //   1506: putfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1509: aload_0
    //   1510: iconst_1
    //   1511: putfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1514: ldc 254
    //   1516: new 256	java/lang/StringBuilder
    //   1519: dup
    //   1520: ldc_w 857
    //   1523: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1526: aload_0
    //   1527: getfield 169	com/tencent/mm/plugin/voip/model/e:otl	I
    //   1530: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1533: ldc_w 859
    //   1536: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: aload_0
    //   1540: getfield 171	com/tencent/mm/plugin/voip/model/e:otm	I
    //   1543: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1546: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1552: aload_0
    //   1553: invokespecial 709	com/tencent/mm/plugin/voip/model/e:bVq	()I
    //   1556: istore_2
    //   1557: ldc_w 918
    //   1560: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1563: iload_2
    //   1564: ireturn
    //   1565: astore_1
    //   1566: ldc 254
    //   1568: new 256	java/lang/StringBuilder
    //   1571: dup
    //   1572: ldc_w 861
    //   1575: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1578: aload_1
    //   1579: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1582: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1591: aload_0
    //   1592: sipush 2005
    //   1595: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1598: aload_0
    //   1599: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1602: ineg
    //   1603: istore_2
    //   1604: goto -47 -> 1557
    //   1607: aload_1
    //   1608: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1611: ifeq +70 -> 1681
    //   1614: aload_1
    //   1615: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1618: iconst_1
    //   1619: if_icmpeq +62 -> 1681
    //   1622: aload_0
    //   1623: sipush 2009
    //   1626: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1629: aload_0
    //   1630: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   1633: ineg
    //   1634: istore_2
    //   1635: ldc 254
    //   1637: new 256	java/lang/StringBuilder
    //   1640: dup
    //   1641: ldc_w 880
    //   1644: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1647: aload_1
    //   1648: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1651: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1654: ldc_w 844
    //   1657: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: aload_1
    //   1661: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1664: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1667: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1670: invokestatic 388	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1673: ldc_w 918
    //   1676: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1679: iload_2
    //   1680: ireturn
    //   1681: iconst_0
    //   1682: istore_3
    //   1683: iload_3
    //   1684: istore_2
    //   1685: aload_1
    //   1686: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1689: iconst_1
    //   1690: if_icmpne +63 -> 1753
    //   1693: aload_0
    //   1694: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1697: arraylength
    //   1698: newarray byte
    //   1700: astore 16
    //   1702: aload 15
    //   1704: iconst_0
    //   1705: aload 16
    //   1707: iconst_0
    //   1708: aload_0
    //   1709: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1712: arraylength
    //   1713: invokestatic 892	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1716: aload 16
    //   1718: aload_0
    //   1719: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1722: invokestatic 931	java/util/Arrays:equals	([B[B)Z
    //   1725: ifeq +245 -> 1970
    //   1728: aload_0
    //   1729: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   1732: arraylength
    //   1733: istore_2
    //   1734: ldc 254
    //   1736: ldc_w 933
    //   1739: iconst_1
    //   1740: anewarray 4	java/lang/Object
    //   1743: dup
    //   1744: iconst_0
    //   1745: iload_2
    //   1746: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1749: aastore
    //   1750: invokestatic 936	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1753: iconst_4
    //   1754: invokestatic 883	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1757: astore 16
    //   1759: aload 16
    //   1761: aload_1
    //   1762: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1765: iconst_4
    //   1766: isub
    //   1767: iload_2
    //   1768: isub
    //   1769: invokevirtual 885	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1772: pop
    //   1773: aload 16
    //   1775: getstatic 888	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1778: invokevirtual 580	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1781: invokevirtual 722	java/nio/ByteBuffer:array	()[B
    //   1784: iconst_0
    //   1785: aload 15
    //   1787: iload_2
    //   1788: iconst_4
    //   1789: invokestatic 892	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1792: invokestatic 734	java/lang/System:currentTimeMillis	()J
    //   1795: lstore 11
    //   1797: ldc 254
    //   1799: new 256	java/lang/StringBuilder
    //   1802: dup
    //   1803: ldc_w 894
    //   1806: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1809: aload_1
    //   1810: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1813: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1816: ldc_w 896
    //   1819: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: aload_1
    //   1823: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1826: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1829: ldc_w 738
    //   1832: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: getstatic 85	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   1838: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1841: ldc_w 740
    //   1844: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: lload 11
    //   1849: invokevirtual 743	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1852: ldc_w 938
    //   1855: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: iload_2
    //   1859: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1868: new 898	com/tencent/mm/protocal/protobuf/bix
    //   1871: dup
    //   1872: invokespecial 899	com/tencent/mm/protocal/protobuf/bix:<init>	()V
    //   1875: astore 16
    //   1877: aload 16
    //   1879: aload 15
    //   1881: iload_2
    //   1882: aload_1
    //   1883: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1886: iload_2
    //   1887: isub
    //   1888: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   1891: putfield 902	com/tencent/mm/protocal/protobuf/bix:EXI	Lcom/tencent/mm/bw/b;
    //   1894: aload 16
    //   1896: iconst_1
    //   1897: putfield 905	com/tencent/mm/protocal/protobuf/bix:EXJ	I
    //   1900: aload 16
    //   1902: aload_0
    //   1903: getfield 161	com/tencent/mm/plugin/voip/model/e:Azp	Ljava/util/LinkedList;
    //   1906: putfield 908	com/tencent/mm/protocal/protobuf/bix:EXK	Ljava/util/LinkedList;
    //   1909: aload_0
    //   1910: getfield 163	com/tencent/mm/plugin/voip/model/e:Azq	Ljava/util/LinkedList;
    //   1913: iconst_0
    //   1914: aload_1
    //   1915: getfield 813	android/media/MediaCodec$BufferInfo:size	I
    //   1918: iload_2
    //   1919: isub
    //   1920: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1923: invokevirtual 912	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1926: pop
    //   1927: aload 16
    //   1929: aload_0
    //   1930: getfield 163	com/tencent/mm/plugin/voip/model/e:Azq	Ljava/util/LinkedList;
    //   1933: putfield 915	com/tencent/mm/protocal/protobuf/bix:EXL	Ljava/util/LinkedList;
    //   1936: aload 16
    //   1938: invokevirtual 916	com/tencent/mm/protocal/protobuf/bix:toByteArray	()[B
    //   1941: arraylength
    //   1942: istore_2
    //   1943: aload_0
    //   1944: aload 16
    //   1946: invokevirtual 916	com/tencent/mm/protocal/protobuf/bix:toByteArray	()[B
    //   1949: aload_1
    //   1950: getfield 806	android/media/MediaCodec$BufferInfo:flags	I
    //   1953: iload_2
    //   1954: invokespecial 875	com/tencent/mm/plugin/voip/model/e:C	([BII)I
    //   1957: istore_2
    //   1958: iload_2
    //   1959: ifge -1147 -> 812
    //   1962: ldc_w 918
    //   1965: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1968: iload_2
    //   1969: ireturn
    //   1970: aload 15
    //   1972: invokestatic 819	com/tencent/mm/plugin/voip/model/e:bF	([B)Ljava/util/ArrayList;
    //   1975: astore 16
    //   1977: iload_3
    //   1978: istore_2
    //   1979: aload 16
    //   1981: invokevirtual 824	java/util/ArrayList:size	()I
    //   1984: iconst_3
    //   1985: if_icmpne -232 -> 1753
    //   1988: iload_3
    //   1989: istore_2
    //   1990: aload_0
    //   1991: getfield 138	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1994: ldc_w 508
    //   1997: invokevirtual 246	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2000: ifeq -247 -> 1753
    //   2003: aload 16
    //   2005: iconst_0
    //   2006: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2009: checkcast 227	java/lang/Integer
    //   2012: invokevirtual 830	java/lang/Integer:intValue	()I
    //   2015: istore_3
    //   2016: aload 16
    //   2018: iconst_1
    //   2019: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2022: checkcast 227	java/lang/Integer
    //   2025: invokevirtual 830	java/lang/Integer:intValue	()I
    //   2028: istore 4
    //   2030: aload 16
    //   2032: iconst_2
    //   2033: invokevirtual 827	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2036: checkcast 227	java/lang/Integer
    //   2039: invokevirtual 830	java/lang/Integer:intValue	()I
    //   2042: istore_2
    //   2043: iload 4
    //   2045: iload_3
    //   2046: isub
    //   2047: istore 5
    //   2049: iload_2
    //   2050: iload 4
    //   2052: isub
    //   2053: istore 7
    //   2055: ldc 254
    //   2057: ldc_w 940
    //   2060: iconst_5
    //   2061: anewarray 4	java/lang/Object
    //   2064: dup
    //   2065: iconst_0
    //   2066: iload_3
    //   2067: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2070: aastore
    //   2071: dup
    //   2072: iconst_1
    //   2073: iload 4
    //   2075: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2078: aastore
    //   2079: dup
    //   2080: iconst_2
    //   2081: iload_2
    //   2082: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2085: aastore
    //   2086: dup
    //   2087: iconst_3
    //   2088: iload 5
    //   2090: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2093: aastore
    //   2094: dup
    //   2095: iconst_4
    //   2096: iload 7
    //   2098: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2101: aastore
    //   2102: invokestatic 942	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2105: aload_0
    //   2106: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   2109: arraylength
    //   2110: iload 5
    //   2112: iload 7
    //   2114: iadd
    //   2115: if_icmpge +14 -> 2129
    //   2118: aload_0
    //   2119: iload 5
    //   2121: iload 7
    //   2123: iadd
    //   2124: newarray byte
    //   2126: putfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   2129: aload 15
    //   2131: iload_3
    //   2132: aload_0
    //   2133: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   2136: iconst_0
    //   2137: iload 5
    //   2139: invokestatic 892	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2142: aload 15
    //   2144: iload 7
    //   2146: aload_0
    //   2147: getfield 144	com/tencent/mm/plugin/voip/model/e:Azn	[B
    //   2150: iload 5
    //   2152: iload 7
    //   2154: invokestatic 892	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2157: new 821	com/tencent/mm/protocal/protobuf/biy
    //   2160: dup
    //   2161: invokespecial 822	com/tencent/mm/protocal/protobuf/biy:<init>	()V
    //   2164: astore 16
    //   2166: aload 16
    //   2168: iconst_4
    //   2169: putfield 864	com/tencent/mm/protocal/protobuf/biy:EXM	I
    //   2172: aload 16
    //   2174: aload 15
    //   2176: iload_3
    //   2177: iconst_4
    //   2178: iadd
    //   2179: iload 5
    //   2181: iconst_4
    //   2182: isub
    //   2183: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   2186: putfield 867	com/tencent/mm/protocal/protobuf/biy:EXN	Lcom/tencent/mm/bw/b;
    //   2189: aload 16
    //   2191: aload 15
    //   2193: iload 4
    //   2195: iconst_4
    //   2196: iadd
    //   2197: iload 7
    //   2199: iconst_4
    //   2200: isub
    //   2201: invokestatic 836	com/tencent/mm/bw/b:E	([BII)Lcom/tencent/mm/bw/b;
    //   2204: putfield 870	com/tencent/mm/protocal/protobuf/biy:EXO	Lcom/tencent/mm/bw/b;
    //   2207: aload 16
    //   2209: invokevirtual 873	com/tencent/mm/protocal/protobuf/biy:toByteArray	()[B
    //   2212: arraylength
    //   2213: istore_3
    //   2214: aload_0
    //   2215: aload 16
    //   2217: invokevirtual 873	com/tencent/mm/protocal/protobuf/biy:toByteArray	()[B
    //   2220: iconst_2
    //   2221: iload_3
    //   2222: invokespecial 875	com/tencent/mm/plugin/voip/model/e:C	([BII)I
    //   2225: pop
    //   2226: goto -473 -> 1753
    //   2229: astore_1
    //   2230: ldc 254
    //   2232: new 256	java/lang/StringBuilder
    //   2235: dup
    //   2236: ldc_w 336
    //   2239: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2242: aload_1
    //   2243: invokevirtual 337	java/lang/Exception:toString	()Ljava/lang/String;
    //   2246: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2252: invokestatic 293	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2255: aload_0
    //   2256: sipush 2004
    //   2259: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   2262: aload_0
    //   2263: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   2266: ineg
    //   2267: istore_2
    //   2268: ldc_w 918
    //   2271: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2274: iload_2
    //   2275: ireturn
    //   2276: aload_0
    //   2277: getfield 173	com/tencent/mm/plugin/voip/model/e:otn	I
    //   2280: istore_3
    //   2281: aload_0
    //   2282: iload_3
    //   2283: iconst_1
    //   2284: iadd
    //   2285: putfield 173	com/tencent/mm/plugin/voip/model/e:otn	I
    //   2288: iload_3
    //   2289: iconst_5
    //   2290: if_icmple -22 -> 2268
    //   2293: aload_0
    //   2294: sipush 2006
    //   2297: putfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   2300: aload_0
    //   2301: getfield 134	com/tencent/mm/plugin/voip/model/e:otc	I
    //   2304: ineg
    //   2305: istore_2
    //   2306: goto -38 -> 2268
    //   2309: iconst_0
    //   2310: istore_2
    //   2311: aload 13
    //   2313: astore_1
    //   2314: goto -1871 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2317	0	this	e
    //   0	2317	1	paramArrayOfByte	byte[]
    //   0	2317	2	paramInt1	int
    //   0	2317	3	paramInt2	int
    //   0	2317	4	paramInt3	int
    //   957	1226	5	i	int
    //   631	255	6	j	int
    //   1001	1200	7	k	int
    //   1041	321	8	m	int
    //   951	413	9	n	int
    //   954	406	10	i1	int
    //   462	1386	11	l	long
    //   7	1	13	localObject1	Object
    //   364	15	13	localException1	Exception
    //   528	1	13	arrayOfByteBuffer	ByteBuffer[]
    //   779	1533	13	localException2	Exception
    //   519	380	14	localObject2	Object
    //   896	1296	15	arrayOfByte	byte[]
    //   939	1277	16	localObject3	Object
    //   948	505	17	localbiy	com.tencent.mm.protocal.protobuf.biy
    // Exception table:
    //   from	to	target	type
    //   326	331	364	java/lang/Exception
    //   425	441	779	java/lang/Exception
    //   1283	1288	1370	java/lang/Exception
    //   1552	1557	1565	java/lang/Exception
    //   454	541	2229	java/lang/Exception
    //   545	555	2229	java/lang/Exception
    //   561	604	2229	java/lang/Exception
    //   604	627	2229	java/lang/Exception
    //   640	665	2229	java/lang/Exception
    //   671	682	2229	java/lang/Exception
    //   688	768	2229	java/lang/Exception
    //   812	819	2229	java/lang/Exception
    //   824	838	2229	java/lang/Exception
    //   838	876	2229	java/lang/Exception
    //   890	926	2229	java/lang/Exception
    //   926	950	2229	java/lang/Exception
    //   966	1034	2229	java/lang/Exception
    //   1051	1072	2229	java/lang/Exception
    //   1072	1089	2229	java/lang/Exception
    //   1089	1118	2229	java/lang/Exception
    //   1118	1133	2229	java/lang/Exception
    //   1133	1283	2229	java/lang/Exception
    //   1304	1344	2229	java/lang/Exception
    //   1352	1359	2229	java/lang/Exception
    //   1371	1409	2229	java/lang/Exception
    //   1412	1466	2229	java/lang/Exception
    //   1478	1552	2229	java/lang/Exception
    //   1566	1604	2229	java/lang/Exception
    //   1607	1673	2229	java/lang/Exception
    //   1685	1753	2229	java/lang/Exception
    //   1753	1958	2229	java/lang/Exception
    //   1970	1977	2229	java/lang/Exception
    //   1979	1988	2229	java/lang/Exception
    //   1990	2043	2229	java/lang/Exception
    //   2055	2129	2229	java/lang/Exception
    //   2129	2226	2229	java/lang/Exception
  }
  
  public final void ehl()
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
      if (this.oti != null)
      {
        this.oti.flush();
        this.oti.close();
      }
      if (this.otf != null)
      {
        this.otf.stop();
        this.otf.release();
      }
      AppMethodBeat.o(114839);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
      AppMethodBeat.o(114839);
    }
  }
  
  final class a
  {
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
      this.s2p = new byte[14];
      AppMethodBeat.o(114832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.e
 * JD-Core Version:    0.7.0.1
 */