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
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.BufferedOutputStream;
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
  public String ENCODING;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public long gru;
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
  public int nPX;
  z nPY;
  private byte[] nPZ;
  private MediaMuxer nQa;
  private int nQb;
  private boolean nQc;
  private BufferedOutputStream nQd;
  g nQe;
  public int nQf;
  public int nQg;
  public int nQh;
  public int nQi;
  private BufferedOutputStream outputStream;
  l zfA;
  public LinkedList<bfh> zgG;
  public LinkedList<Integer> zgH;
  public int zgI;
  a zgJ;
  
  static
  {
    AppMethodBeat.i(177015);
    streamqueuesize = 100;
    frameID = 0;
    path = b.aih();
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
    this.nPX = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.nPZ = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.gru = 0L;
    this.zfA = null;
    this.zgG = new LinkedList();
    this.zgH = new LinkedList();
    this.nQe = null;
    this.nQf = 0;
    this.nQg = 8;
    this.nQh = 0;
    this.nQi = 0;
    this.zgI = 0;
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
    this.zgJ = new a();
    this.nPY = null;
    this.nQg = 8;
    this.nQf = 0;
    this.nQh = 0;
    this.nPX = 0;
    paramString = new bfh();
    paramString.DCu = 1L;
    paramString.DCv = 24;
    paramString.DCw = 1L;
    paramString.DCx = 24;
    paramString.DCy = 0L;
    paramString.DCz = 0;
    this.zgG.add(paramString);
    this.zgH.add(Integer.valueOf(0));
    this.nPZ = null;
    this.nQi = 0;
    this.zgI = 0;
    this.gru = 0L;
    AppMethodBeat.o(114837);
  }
  
  private int D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114844);
    if ((paramArrayOfByte != null) && (this.zfA.ziZ != null))
    {
      int i = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = VFMT_HEVC_HW;
      }
      i = this.zfA.ziZ.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
      if (i >= 0)
      {
        this.zgI = 0;
        ad.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114844);
      return paramInt1;
      paramInt1 = this.zgI;
      this.zgI = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.nPX = 2008;
        paramInt1 = -this.nPX;
        ad.e("MeidaCodec[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(paramInt1)));
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void StopEncoder()
  {
    AppMethodBeat.i(114838);
    try
    {
      if (this.nPY != null)
      {
        this.nPY.stop();
        this.nPY.release();
      }
      AppMethodBeat.o(114838);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
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
          ad.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
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
    if (d.lf(23))
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
          ad.e("MeidaCodec[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
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
        ad.i("MeidaCodec[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      ad.i("MeidaCodec[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
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
      if (8 <= this.nQg)
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
                ad.i("MeidaCodec[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.nQg + ", MIME:" + paramString);
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
  
  private static String bF(byte[] paramArrayOfByte)
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
  
  private static ArrayList<Integer> bG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114841);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = bF(paramArrayOfByte);
    String str = bF(new byte[] { 0, 0, 0, 1 });
    ad.d("MeidaCodec[HWEnc]", "parent: " + paramArrayOfByte + ", child:" + str);
    for (;;)
    {
      int j = paramArrayOfByte.indexOf(str, i);
      if (j == -1) {
        break;
      }
      ad.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + j);
      i = str.length() + j;
      localArrayList.add(Integer.valueOf(j / 2));
    }
    AppMethodBeat.o(114841);
    return localArrayList;
  }
  
  @SuppressLint({"NewApi"})
  private int bOd()
  {
    AppMethodBeat.i(114836);
    if (this.nPY != null) {
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
                ad.i("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(str2)));
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
      ad.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.nPX = 2001;
      i = -this.nPX;
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
    ad.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 4);
    str1 = this.mediaFormat.getString("mime");
    this.nQf = 1;
    label391:
    boolean bool;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.lf(23)))
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
      for (this.nQf = this.mediaFormat.getInteger("profile");; this.nQf = 1)
      {
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try
        {
          this.nPY = z.q(str1, false);
          ad.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.nQf);
          this.nPY.a(this.mediaFormat, null, 1);
          this.nPY.start();
          this.nQe = new g();
          AppMethodBeat.o(114836);
          return 2000;
        }
        catch (Exception localException)
        {
          label557:
          ad.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
          this.nPX = 2002;
          i = -this.nPX;
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
        bool = a(localMediaCodecInfo, str1, this.nQg);
        break label438;
      }
      label680:
      bool = false;
    }
  }
  
  @SuppressLint({"NewApi"})
  public final boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(114843);
    try
    {
      if (this.nPY != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        ad.v("MeidaCodec[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.nPY.setParameters(localBundle);
        AppMethodBeat.o(114843);
        return true;
      }
    }
    catch (Exception localException)
    {
      ad.e("MeidaCodec[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
      AppMethodBeat.o(114843);
    }
    return false;
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 535
    //   3: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 180	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 182	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   22: if_icmpeq +32 -> 54
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 180	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 182	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 180	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   40: aload_0
    //   41: getfield 182	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   44: imul
    //   45: iconst_3
    //   46: imul
    //   47: iconst_2
    //   48: idiv
    //   49: newarray byte
    //   51: putfield 141	com/tencent/mm/plugin/voip/model/e:nPZ	[B
    //   54: aload_0
    //   55: getfield 141	com/tencent/mm/plugin/voip/model/e:nPZ	[B
    //   58: ifnonnull +22 -> 80
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 180	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   66: aload_0
    //   67: getfield 182	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   70: imul
    //   71: iconst_3
    //   72: imul
    //   73: iconst_2
    //   74: idiv
    //   75: newarray byte
    //   77: putfield 141	com/tencent/mm/plugin/voip/model/e:nPZ	[B
    //   80: ldc 247
    //   82: new 249	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 537
    //   89: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 184	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   96: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 539
    //   102: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 186	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   109: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: getfield 191	com/tencent/mm/plugin/voip/model/e:zgJ	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   122: getfield 543	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   125: ifne +1836 -> 1961
    //   128: aload_0
    //   129: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   132: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   135: ifnull +1826 -> 1961
    //   138: aload_0
    //   139: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   142: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   145: aload_1
    //   146: aload_1
    //   147: arraylength
    //   148: aload_0
    //   149: getfield 180	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   152: aload_0
    //   153: getfield 182	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   156: iload 4
    //   158: aload_0
    //   159: getfield 141	com/tencent/mm/plugin/voip/model/e:nPZ	[B
    //   162: invokevirtual 547	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess	([BIIII[B)I
    //   165: pop
    //   166: aload_0
    //   167: getfield 141	com/tencent/mm/plugin/voip/model/e:nPZ	[B
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 176	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   175: aload_0
    //   176: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   179: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   182: getfield 550	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   185: if_icmpne +20 -> 205
    //   188: aload_0
    //   189: getfield 178	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   192: aload_0
    //   193: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   196: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   199: getfield 553	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   202: if_icmpeq +206 -> 408
    //   205: ldc 247
    //   207: new 249	java/lang/StringBuilder
    //   210: dup
    //   211: ldc_w 555
    //   214: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   221: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   224: getfield 550	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   227: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: ldc_w 557
    //   233: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   240: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   243: getfield 553	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   246: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 559
    //   252: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: getfield 176	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   259: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 557
    //   265: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 178	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   272: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: aload_0
    //   283: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   286: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   289: getfield 550	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   292: putfield 176	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 149	com/tencent/mm/plugin/voip/model/e:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   300: getfield 233	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   303: getfield 553	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   306: putfield 178	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 176	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   314: aload_0
    //   315: getfield 178	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   318: imul
    //   319: iconst_3
    //   320: imul
    //   321: iconst_1
    //   322: ishr
    //   323: putfield 172	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   326: aload_0
    //   327: invokespecial 561	com/tencent/mm/plugin/voip/model/e:bOd	()I
    //   330: istore_2
    //   331: iload_2
    //   332: istore_3
    //   333: iload_2
    //   334: ifge +76 -> 410
    //   337: ldc 247
    //   339: ldc_w 563
    //   342: iload_2
    //   343: invokestatic 279	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   346: invokevirtual 283	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_0
    //   353: invokevirtual 566	com/tencent/mm/plugin/voip/model/e:dRZ	()V
    //   356: ldc_w 535
    //   359: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: iload_2
    //   363: ireturn
    //   364: astore 13
    //   366: ldc 247
    //   368: new 249	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 568
    //   375: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: aload 13
    //   380: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   383: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_0
    //   393: sipush 2003
    //   396: putfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   399: aload_0
    //   400: getfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   403: ineg
    //   404: istore_2
    //   405: goto -74 -> 331
    //   408: iconst_0
    //   409: istore_3
    //   410: getstatic 82	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   413: bipush 100
    //   415: if_icmpgt +433 -> 848
    //   418: aload_0
    //   419: getfield 570	com/tencent/mm/plugin/voip/model/e:nQd	Ljava/io/BufferedOutputStream;
    //   422: ifnull +426 -> 848
    //   425: aload_0
    //   426: getfield 570	com/tencent/mm/plugin/voip/model/e:nQd	Ljava/io/BufferedOutputStream;
    //   429: aload_0
    //   430: getfield 141	com/tencent/mm/plugin/voip/model/e:nPZ	[B
    //   433: iconst_0
    //   434: aload_0
    //   435: getfield 172	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   438: invokevirtual 576	java/io/BufferedOutputStream:write	([BII)V
    //   441: iload_3
    //   442: istore_2
    //   443: aload_1
    //   444: ifnull +1484 -> 1928
    //   447: aload_0
    //   448: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   451: ifnull +1477 -> 1928
    //   454: aload_0
    //   455: iconst_0
    //   456: putfield 166	com/tencent/mm/plugin/voip/model/e:nQi	I
    //   459: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   462: lstore 11
    //   464: ldc 247
    //   466: new 249	java/lang/StringBuilder
    //   469: dup
    //   470: ldc_w 584
    //   473: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   476: aload_0
    //   477: getfield 172	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   480: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 586
    //   486: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: getstatic 82	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   492: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc_w 588
    //   498: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: lload 11
    //   503: invokevirtual 591	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   516: invokevirtual 595	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   519: astore 14
    //   521: aload_0
    //   522: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   525: invokevirtual 598	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   528: astore 13
    //   530: aload_0
    //   531: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   534: ldc2_w 599
    //   537: invokevirtual 604	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   540: istore_3
    //   541: iload_3
    //   542: iflt +103 -> 645
    //   545: aload_0
    //   546: getfield 145	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   549: lstore 11
    //   551: aload_0
    //   552: getfield 184	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   555: bipush 15
    //   557: invokestatic 610	java/lang/Math:max	(II)I
    //   560: bipush 30
    //   562: invokestatic 613	java/lang/Math:min	(II)I
    //   565: istore 4
    //   567: lload 11
    //   569: lconst_0
    //   570: lcmp
    //   571: ifeq +12 -> 583
    //   574: aload_0
    //   575: getfield 147	com/tencent/mm/plugin/voip/model/e:gru	J
    //   578: lconst_0
    //   579: lcmp
    //   580: ifne +273 -> 853
    //   583: aload_0
    //   584: ldc2_w 614
    //   587: putfield 147	com/tencent/mm/plugin/voip/model/e:gru	J
    //   590: aload_0
    //   591: getfield 147	com/tencent/mm/plugin/voip/model/e:gru	J
    //   594: lstore 11
    //   596: aload 14
    //   598: iload_3
    //   599: aaload
    //   600: astore 14
    //   602: aload 14
    //   604: invokevirtual 621	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   607: pop
    //   608: aload 14
    //   610: aload_1
    //   611: iconst_0
    //   612: aload_0
    //   613: getfield 172	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   616: invokevirtual 625	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   619: pop
    //   620: aload_0
    //   621: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   624: iload_3
    //   625: aload_0
    //   626: getfield 172	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   629: lload 11
    //   631: iconst_0
    //   632: invokevirtual 628	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 145	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   640: lconst_1
    //   641: ladd
    //   642: putfield 145	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   645: new 630	android/media/MediaCodec$BufferInfo
    //   648: dup
    //   649: invokespecial 631	android/media/MediaCodec$BufferInfo:<init>	()V
    //   652: astore_1
    //   653: aload_0
    //   654: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   657: aload_1
    //   658: aload_0
    //   659: getfield 137	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   662: i2l
    //   663: invokevirtual 635	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   666: istore 4
    //   668: iload_2
    //   669: istore_3
    //   670: iload 4
    //   672: istore 6
    //   674: iload 4
    //   676: bipush 254
    //   678: if_icmpne +305 -> 983
    //   681: aload_0
    //   682: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   685: invokevirtual 639	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   688: astore 14
    //   690: ldc 247
    //   692: ldc_w 641
    //   695: aload 14
    //   697: invokestatic 319	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   700: invokevirtual 283	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   703: invokestatic 359	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: iload_2
    //   707: istore_3
    //   708: iload 4
    //   710: istore 6
    //   712: aload 14
    //   714: ldc_w 469
    //   717: invokevirtual 644	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   720: ifeq +263 -> 983
    //   723: iload_2
    //   724: istore_3
    //   725: iload 4
    //   727: istore 6
    //   729: aload 14
    //   731: ldc_w 469
    //   734: invokevirtual 488	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   737: i2d
    //   738: aload_0
    //   739: getfield 186	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   742: sipush 1000
    //   745: imul
    //   746: i2d
    //   747: ldc2_w 645
    //   750: dmul
    //   751: dcmpl
    //   752: ifle +231 -> 983
    //   755: ldc 247
    //   757: new 249	java/lang/StringBuilder
    //   760: dup
    //   761: ldc_w 648
    //   764: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   767: aload 14
    //   769: ldc_w 469
    //   772: invokevirtual 488	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   775: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: ldc_w 650
    //   781: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload_0
    //   785: getfield 186	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   788: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   791: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   797: aload_0
    //   798: sipush 2007
    //   801: putfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   804: aload_0
    //   805: getfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   808: istore_2
    //   809: iload_2
    //   810: ineg
    //   811: istore_2
    //   812: ldc_w 535
    //   815: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   818: iload_2
    //   819: ireturn
    //   820: astore 13
    //   822: ldc 247
    //   824: new 249	java/lang/StringBuilder
    //   827: dup
    //   828: ldc_w 302
    //   831: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   834: aload 13
    //   836: invokevirtual 303	java/lang/Exception:toString	()Ljava/lang/String;
    //   839: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   848: iload_3
    //   849: istore_2
    //   850: goto -407 -> 443
    //   853: aload_0
    //   854: aload_0
    //   855: getfield 147	com/tencent/mm/plugin/voip/model/e:gru	J
    //   858: ldc_w 651
    //   861: iload 4
    //   863: idiv
    //   864: i2l
    //   865: ladd
    //   866: putfield 147	com/tencent/mm/plugin/voip/model/e:gru	J
    //   869: goto -279 -> 590
    //   872: astore_1
    //   873: ldc 247
    //   875: new 249	java/lang/StringBuilder
    //   878: dup
    //   879: ldc_w 302
    //   882: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   885: aload_1
    //   886: invokevirtual 303	java/lang/Exception:toString	()Ljava/lang/String;
    //   889: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload_0
    //   899: sipush 2004
    //   902: putfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   905: aload_0
    //   906: getfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   909: ineg
    //   910: istore_2
    //   911: ldc_w 535
    //   914: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   917: iload_2
    //   918: ireturn
    //   919: aload_0
    //   920: getfield 653	com/tencent/mm/plugin/voip/model/e:nQc	Z
    //   923: ifeq +22 -> 945
    //   926: aload 14
    //   928: ifnull +17 -> 945
    //   931: aload_0
    //   932: getfield 655	com/tencent/mm/plugin/voip/model/e:nQa	Landroid/media/MediaMuxer;
    //   935: aload_0
    //   936: getfield 657	com/tencent/mm/plugin/voip/model/e:nQb	I
    //   939: aload 14
    //   941: aload_1
    //   942: invokevirtual 663	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   945: aload_1
    //   946: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   949: istore_3
    //   950: getstatic 82	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   953: iconst_1
    //   954: iadd
    //   955: putstatic 82	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   958: aload_0
    //   959: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   962: iload 6
    //   964: iconst_0
    //   965: invokevirtual 670	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   968: aload_0
    //   969: getfield 193	com/tencent/mm/plugin/voip/model/e:nPY	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   972: aload_1
    //   973: aload_0
    //   974: getfield 137	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   977: i2l
    //   978: invokevirtual 635	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   981: istore 6
    //   983: iload_3
    //   984: istore_2
    //   985: iload 6
    //   987: iflt -76 -> 911
    //   990: aload 13
    //   992: iload 6
    //   994: aaload
    //   995: astore 14
    //   997: aload_1
    //   998: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1001: newarray byte
    //   1003: astore 15
    //   1005: aload 14
    //   1007: aload 15
    //   1009: invokevirtual 677	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1012: pop
    //   1013: aload_0
    //   1014: getfield 679	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   1017: ifnull +16 -> 1033
    //   1020: aload_0
    //   1021: getfield 679	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   1024: aload 15
    //   1026: iconst_0
    //   1027: aload 15
    //   1029: arraylength
    //   1030: invokevirtual 576	java/io/BufferedOutputStream:write	([BII)V
    //   1033: aload_1
    //   1034: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   1037: iconst_2
    //   1038: if_icmpne +486 -> 1524
    //   1041: aload 15
    //   1043: invokestatic 681	com/tencent/mm/plugin/voip/model/e:bG	([B)Ljava/util/ArrayList;
    //   1046: astore 16
    //   1048: new 683	com/tencent/mm/protocal/protobuf/bfg
    //   1051: dup
    //   1052: invokespecial 684	com/tencent/mm/protocal/protobuf/bfg:<init>	()V
    //   1055: astore 17
    //   1057: iconst_0
    //   1058: istore 9
    //   1060: iconst_0
    //   1061: istore 10
    //   1063: iconst_0
    //   1064: istore 5
    //   1066: iconst_0
    //   1067: istore 4
    //   1069: iconst_0
    //   1070: istore_3
    //   1071: iconst_0
    //   1072: istore_2
    //   1073: aload 16
    //   1075: invokevirtual 686	java/util/ArrayList:size	()I
    //   1078: iconst_3
    //   1079: if_icmpne +263 -> 1342
    //   1082: aload_0
    //   1083: getfield 135	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1086: ldc 235
    //   1088: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1091: ifeq +251 -> 1342
    //   1094: aload 16
    //   1096: iconst_0
    //   1097: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1100: checkcast 220	java/lang/Integer
    //   1103: invokevirtual 692	java/lang/Integer:intValue	()I
    //   1106: iconst_4
    //   1107: iadd
    //   1108: istore 8
    //   1110: aload 16
    //   1112: iconst_1
    //   1113: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1116: checkcast 220	java/lang/Integer
    //   1119: invokevirtual 692	java/lang/Integer:intValue	()I
    //   1122: iconst_4
    //   1123: iadd
    //   1124: istore 5
    //   1126: aload 16
    //   1128: iconst_2
    //   1129: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1132: checkcast 220	java/lang/Integer
    //   1135: invokevirtual 692	java/lang/Integer:intValue	()I
    //   1138: iconst_4
    //   1139: iadd
    //   1140: istore_3
    //   1141: iload 5
    //   1143: iload 8
    //   1145: isub
    //   1146: iconst_4
    //   1147: isub
    //   1148: istore 7
    //   1150: iload_3
    //   1151: iload 5
    //   1153: isub
    //   1154: iconst_4
    //   1155: isub
    //   1156: istore 4
    //   1158: aload_1
    //   1159: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1162: iload_3
    //   1163: isub
    //   1164: istore_2
    //   1165: aload 17
    //   1167: aload 15
    //   1169: iload 8
    //   1171: iload 7
    //   1173: invokestatic 698	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1176: putfield 702	com/tencent/mm/protocal/protobuf/bfg:DCt	Lcom/tencent/mm/bx/b;
    //   1179: ldc 247
    //   1181: new 249	java/lang/StringBuilder
    //   1184: dup
    //   1185: ldc_w 704
    //   1188: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1191: iload 5
    //   1193: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1196: ldc_w 706
    //   1199: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: iload 4
    //   1204: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1207: ldc_w 708
    //   1210: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: iload_3
    //   1214: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1217: ldc_w 706
    //   1220: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: iload_2
    //   1224: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1227: ldc_w 710
    //   1230: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: iload 8
    //   1235: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1238: ldc_w 706
    //   1241: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: iload 7
    //   1246: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1249: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1252: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1255: aload_0
    //   1256: getfield 160	com/tencent/mm/plugin/voip/model/e:nQf	I
    //   1259: iconst_1
    //   1260: if_icmpeq +198 -> 1458
    //   1263: aload_0
    //   1264: getfield 158	com/tencent/mm/plugin/voip/model/e:nQe	Lcom/tencent/mm/plugin/voip/model/g;
    //   1267: aload 15
    //   1269: invokevirtual 714	com/tencent/mm/plugin/voip/model/g:bH	([B)Z
    //   1272: ifeq +186 -> 1458
    //   1275: aload_0
    //   1276: aload_0
    //   1277: getfield 158	com/tencent/mm/plugin/voip/model/e:nQe	Lcom/tencent/mm/plugin/voip/model/g;
    //   1280: getfield 717	com/tencent/mm/plugin/voip/model/g:zgM	I
    //   1283: putfield 164	com/tencent/mm/plugin/voip/model/e:nQh	I
    //   1286: aload_0
    //   1287: iconst_1
    //   1288: putfield 162	com/tencent/mm/plugin/voip/model/e:nQg	I
    //   1291: ldc 247
    //   1293: new 249	java/lang/StringBuilder
    //   1296: dup
    //   1297: ldc_w 719
    //   1300: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1303: aload_0
    //   1304: getfield 162	com/tencent/mm/plugin/voip/model/e:nQg	I
    //   1307: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1310: ldc_w 721
    //   1313: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: aload_0
    //   1317: getfield 164	com/tencent/mm/plugin/voip/model/e:nQh	I
    //   1320: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1323: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: invokestatic 359	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1329: aload_0
    //   1330: invokespecial 561	com/tencent/mm/plugin/voip/model/e:bOd	()I
    //   1333: istore_2
    //   1334: ldc_w 535
    //   1337: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1340: iload_2
    //   1341: ireturn
    //   1342: iload 9
    //   1344: istore 8
    //   1346: iload 10
    //   1348: istore 7
    //   1350: aload 16
    //   1352: invokevirtual 686	java/util/ArrayList:size	()I
    //   1355: iconst_2
    //   1356: if_icmpne -177 -> 1179
    //   1359: aload 16
    //   1361: iconst_0
    //   1362: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1365: checkcast 220	java/lang/Integer
    //   1368: invokevirtual 692	java/lang/Integer:intValue	()I
    //   1371: iconst_4
    //   1372: iadd
    //   1373: istore 5
    //   1375: aload 16
    //   1377: iconst_1
    //   1378: invokevirtual 689	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1381: checkcast 220	java/lang/Integer
    //   1384: invokevirtual 692	java/lang/Integer:intValue	()I
    //   1387: iconst_4
    //   1388: iadd
    //   1389: istore_3
    //   1390: iload_3
    //   1391: iload 5
    //   1393: isub
    //   1394: iconst_4
    //   1395: isub
    //   1396: istore 4
    //   1398: aload_1
    //   1399: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1402: iload_3
    //   1403: isub
    //   1404: istore_2
    //   1405: iload 9
    //   1407: istore 8
    //   1409: iload 10
    //   1411: istore 7
    //   1413: goto -234 -> 1179
    //   1416: astore_1
    //   1417: ldc 247
    //   1419: new 249	java/lang/StringBuilder
    //   1422: dup
    //   1423: ldc_w 723
    //   1426: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1429: aload_1
    //   1430: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1433: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1442: aload_0
    //   1443: sipush 2005
    //   1446: putfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1449: aload_0
    //   1450: getfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1453: ineg
    //   1454: istore_2
    //   1455: goto -121 -> 1334
    //   1458: aload 17
    //   1460: iconst_4
    //   1461: putfield 726	com/tencent/mm/protocal/protobuf/bfg:DCq	I
    //   1464: aload 17
    //   1466: aload 15
    //   1468: iload 5
    //   1470: iload 4
    //   1472: invokestatic 698	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1475: putfield 729	com/tencent/mm/protocal/protobuf/bfg:DCr	Lcom/tencent/mm/bx/b;
    //   1478: aload 17
    //   1480: aload 15
    //   1482: iload_3
    //   1483: iload_2
    //   1484: invokestatic 698	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1487: putfield 732	com/tencent/mm/protocal/protobuf/bfg:DCs	Lcom/tencent/mm/bx/b;
    //   1490: aload 17
    //   1492: invokevirtual 736	com/tencent/mm/protocal/protobuf/bfg:toByteArray	()[B
    //   1495: arraylength
    //   1496: istore_2
    //   1497: aload_0
    //   1498: aload 17
    //   1500: invokevirtual 736	com/tencent/mm/protocal/protobuf/bfg:toByteArray	()[B
    //   1503: aload_1
    //   1504: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   1507: iload_2
    //   1508: invokespecial 738	com/tencent/mm/plugin/voip/model/e:D	([BII)I
    //   1511: istore_2
    //   1512: iload_2
    //   1513: ifge -594 -> 919
    //   1516: ldc_w 535
    //   1519: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1522: iload_2
    //   1523: ireturn
    //   1524: aload_0
    //   1525: getfield 160	com/tencent/mm/plugin/voip/model/e:nQf	I
    //   1528: iconst_1
    //   1529: if_icmpeq +124 -> 1653
    //   1532: aload_0
    //   1533: getfield 158	com/tencent/mm/plugin/voip/model/e:nQe	Lcom/tencent/mm/plugin/voip/model/g;
    //   1536: aload 15
    //   1538: invokevirtual 741	com/tencent/mm/plugin/voip/model/g:bI	([B)Z
    //   1541: ifeq +112 -> 1653
    //   1544: aload_0
    //   1545: aload_0
    //   1546: getfield 158	com/tencent/mm/plugin/voip/model/e:nQe	Lcom/tencent/mm/plugin/voip/model/g;
    //   1549: getfield 717	com/tencent/mm/plugin/voip/model/g:zgM	I
    //   1552: putfield 164	com/tencent/mm/plugin/voip/model/e:nQh	I
    //   1555: aload_0
    //   1556: iconst_1
    //   1557: putfield 162	com/tencent/mm/plugin/voip/model/e:nQg	I
    //   1560: ldc 247
    //   1562: new 249	java/lang/StringBuilder
    //   1565: dup
    //   1566: ldc_w 719
    //   1569: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1572: aload_0
    //   1573: getfield 162	com/tencent/mm/plugin/voip/model/e:nQg	I
    //   1576: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1579: ldc_w 721
    //   1582: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: aload_0
    //   1586: getfield 164	com/tencent/mm/plugin/voip/model/e:nQh	I
    //   1589: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1592: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1595: invokestatic 359	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1598: aload_0
    //   1599: invokespecial 561	com/tencent/mm/plugin/voip/model/e:bOd	()I
    //   1602: istore_2
    //   1603: ldc_w 535
    //   1606: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1609: iload_2
    //   1610: ireturn
    //   1611: astore_1
    //   1612: ldc 247
    //   1614: new 249	java/lang/StringBuilder
    //   1617: dup
    //   1618: ldc_w 723
    //   1621: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1624: aload_1
    //   1625: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1628: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1634: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1637: aload_0
    //   1638: sipush 2005
    //   1641: putfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1644: aload_0
    //   1645: getfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1648: ineg
    //   1649: istore_2
    //   1650: goto -47 -> 1603
    //   1653: aload_1
    //   1654: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   1657: ifeq +70 -> 1727
    //   1660: aload_1
    //   1661: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   1664: iconst_1
    //   1665: if_icmpeq +62 -> 1727
    //   1668: aload_0
    //   1669: sipush 2009
    //   1672: putfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1675: aload_0
    //   1676: getfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1679: ineg
    //   1680: istore_2
    //   1681: ldc 247
    //   1683: new 249	java/lang/StringBuilder
    //   1686: dup
    //   1687: ldc_w 743
    //   1690: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1693: aload_1
    //   1694: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   1697: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1700: ldc_w 706
    //   1703: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1706: aload_1
    //   1707: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1710: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1713: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1716: invokestatic 359	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1719: ldc_w 535
    //   1722: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1725: iload_2
    //   1726: ireturn
    //   1727: iconst_4
    //   1728: invokestatic 747	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1731: astore 16
    //   1733: aload 16
    //   1735: aload_1
    //   1736: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1739: iconst_4
    //   1740: isub
    //   1741: invokevirtual 749	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1744: pop
    //   1745: aload 16
    //   1747: getstatic 755	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1750: invokevirtual 759	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1753: invokevirtual 762	java/nio/ByteBuffer:array	()[B
    //   1756: iconst_0
    //   1757: aload 15
    //   1759: iconst_0
    //   1760: iconst_4
    //   1761: invokestatic 766	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1764: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   1767: lstore 11
    //   1769: ldc 247
    //   1771: new 249	java/lang/StringBuilder
    //   1774: dup
    //   1775: ldc_w 768
    //   1778: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1781: aload_1
    //   1782: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   1785: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1788: ldc_w 770
    //   1791: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: aload_1
    //   1795: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1798: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1801: ldc_w 586
    //   1804: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: getstatic 82	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   1810: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1813: ldc_w 588
    //   1816: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: lload 11
    //   1821: invokevirtual 591	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1824: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1827: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1830: new 772	com/tencent/mm/protocal/protobuf/bff
    //   1833: dup
    //   1834: invokespecial 773	com/tencent/mm/protocal/protobuf/bff:<init>	()V
    //   1837: astore 16
    //   1839: aload 16
    //   1841: aload 15
    //   1843: iconst_0
    //   1844: aload_1
    //   1845: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1848: invokestatic 698	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1851: putfield 776	com/tencent/mm/protocal/protobuf/bff:DCm	Lcom/tencent/mm/bx/b;
    //   1854: aload 16
    //   1856: iconst_1
    //   1857: putfield 779	com/tencent/mm/protocal/protobuf/bff:DCn	I
    //   1860: aload 16
    //   1862: aload_0
    //   1863: getfield 154	com/tencent/mm/plugin/voip/model/e:zgG	Ljava/util/LinkedList;
    //   1866: putfield 782	com/tencent/mm/protocal/protobuf/bff:DCo	Ljava/util/LinkedList;
    //   1869: aload_0
    //   1870: getfield 156	com/tencent/mm/plugin/voip/model/e:zgH	Ljava/util/LinkedList;
    //   1873: iconst_0
    //   1874: aload_1
    //   1875: getfield 673	android/media/MediaCodec$BufferInfo:size	I
    //   1878: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1881: invokevirtual 786	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1884: pop
    //   1885: aload 16
    //   1887: aload_0
    //   1888: getfield 156	com/tencent/mm/plugin/voip/model/e:zgH	Ljava/util/LinkedList;
    //   1891: putfield 789	com/tencent/mm/protocal/protobuf/bff:DCp	Ljava/util/LinkedList;
    //   1894: aload 16
    //   1896: invokevirtual 790	com/tencent/mm/protocal/protobuf/bff:toByteArray	()[B
    //   1899: arraylength
    //   1900: istore_2
    //   1901: aload_0
    //   1902: aload 16
    //   1904: invokevirtual 790	com/tencent/mm/protocal/protobuf/bff:toByteArray	()[B
    //   1907: aload_1
    //   1908: getfield 666	android/media/MediaCodec$BufferInfo:flags	I
    //   1911: iload_2
    //   1912: invokespecial 738	com/tencent/mm/plugin/voip/model/e:D	([BII)I
    //   1915: istore_2
    //   1916: iload_2
    //   1917: ifge -998 -> 919
    //   1920: ldc_w 535
    //   1923: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1926: iload_2
    //   1927: ireturn
    //   1928: aload_0
    //   1929: getfield 166	com/tencent/mm/plugin/voip/model/e:nQi	I
    //   1932: istore_3
    //   1933: aload_0
    //   1934: iload_3
    //   1935: iconst_1
    //   1936: iadd
    //   1937: putfield 166	com/tencent/mm/plugin/voip/model/e:nQi	I
    //   1940: iload_3
    //   1941: iconst_5
    //   1942: if_icmple -1031 -> 911
    //   1945: aload_0
    //   1946: sipush 2006
    //   1949: putfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1952: aload_0
    //   1953: getfield 131	com/tencent/mm/plugin/voip/model/e:nPX	I
    //   1956: ineg
    //   1957: istore_2
    //   1958: goto -1047 -> 911
    //   1961: iconst_0
    //   1962: istore_2
    //   1963: aload 13
    //   1965: astore_1
    //   1966: goto -1523 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1969	0	this	e
    //   0	1969	1	paramArrayOfByte	byte[]
    //   0	1969	2	paramInt1	int
    //   0	1969	3	paramInt2	int
    //   0	1969	4	paramInt3	int
    //   1064	405	5	i	int
    //   672	321	6	j	int
    //   1148	264	7	k	int
    //   1108	300	8	m	int
    //   1058	348	9	n	int
    //   1061	349	10	i1	int
    //   462	1358	11	l	long
    //   7	1	13	localObject1	Object
    //   364	15	13	localException1	Exception
    //   528	1	13	arrayOfByteBuffer	java.nio.ByteBuffer[]
    //   820	1144	13	localException2	Exception
    //   519	487	14	localObject2	Object
    //   1003	839	15	arrayOfByte	byte[]
    //   1046	857	16	localObject3	Object
    //   1055	444	17	localbfg	com.tencent.mm.protocal.protobuf.bfg
    // Exception table:
    //   from	to	target	type
    //   326	331	364	java/lang/Exception
    //   425	441	820	java/lang/Exception
    //   454	541	872	java/lang/Exception
    //   545	567	872	java/lang/Exception
    //   574	583	872	java/lang/Exception
    //   583	590	872	java/lang/Exception
    //   590	596	872	java/lang/Exception
    //   602	645	872	java/lang/Exception
    //   645	668	872	java/lang/Exception
    //   681	706	872	java/lang/Exception
    //   712	723	872	java/lang/Exception
    //   729	809	872	java/lang/Exception
    //   853	869	872	java/lang/Exception
    //   919	926	872	java/lang/Exception
    //   931	945	872	java/lang/Exception
    //   945	983	872	java/lang/Exception
    //   997	1033	872	java/lang/Exception
    //   1033	1057	872	java/lang/Exception
    //   1073	1141	872	java/lang/Exception
    //   1158	1179	872	java/lang/Exception
    //   1179	1329	872	java/lang/Exception
    //   1350	1390	872	java/lang/Exception
    //   1398	1405	872	java/lang/Exception
    //   1417	1455	872	java/lang/Exception
    //   1458	1512	872	java/lang/Exception
    //   1524	1598	872	java/lang/Exception
    //   1612	1650	872	java/lang/Exception
    //   1653	1719	872	java/lang/Exception
    //   1727	1916	872	java/lang/Exception
    //   1329	1334	1416	java/lang/Exception
    //   1598	1603	1611	java/lang/Exception
  }
  
  public final void dRZ()
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
      if (this.nQd != null)
      {
        this.nQd.flush();
        this.nQd.close();
      }
      if (this.nQa != null)
      {
        this.nQa.stop();
        this.nQa.release();
      }
      AppMethodBeat.o(114839);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
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