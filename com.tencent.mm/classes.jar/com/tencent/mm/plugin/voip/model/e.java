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
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.ad;
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
  l BXC;
  private byte[] BYn;
  private byte[] BYo;
  private ByteBuffer BYp;
  a BYq;
  public String ENCODING;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public long hku;
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
  private byte[] oWA;
  private MediaMuxer oWB;
  private int oWC;
  private boolean oWD;
  private BufferedOutputStream oWE;
  g oWF;
  public int oWG;
  public int oWH;
  public int oWI;
  public int oWJ;
  public int oWy;
  private z oWz;
  private BufferedOutputStream outputStream;
  public LinkedList<bnh> waZ;
  public LinkedList<Integer> wba;
  public int wbb;
  
  static
  {
    AppMethodBeat.i(177015);
    streamqueuesize = 100;
    frameID = 0;
    path = b.arU();
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
    this.oWy = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.BYn = null;
    this.BYo = null;
    this.oWA = null;
    this.BYp = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.hku = 0L;
    this.BXC = null;
    this.waZ = new LinkedList();
    this.wba = new LinkedList();
    this.oWF = null;
    this.oWG = 0;
    this.oWH = 8;
    this.oWI = 0;
    this.oWJ = 0;
    this.wbb = 0;
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
    this.BYq = new a();
    this.oWz = null;
    this.oWH = 8;
    this.oWG = 0;
    this.oWI = 0;
    this.oWy = 0;
    paramString = new bnh();
    paramString.GHm = 1L;
    paramString.GHn = 24;
    paramString.GHo = 1L;
    paramString.GHp = 24;
    paramString.GHq = 0L;
    paramString.GHr = 0;
    this.waZ.add(paramString);
    this.wba.add(Integer.valueOf(0));
    this.oWA = null;
    this.BYp = null;
    this.oWJ = 0;
    this.wbb = 0;
    this.hku = 0L;
    AppMethodBeat.o(114837);
  }
  
  @SuppressLint({"NewApi"})
  private boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(114843);
    try
    {
      if (this.oWz != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        ad.v("MeidaCodec[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.oWz.setParameters(localBundle);
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
  
  @SuppressLint({"NewApi"})
  private void StopEncoder()
  {
    AppMethodBeat.i(114838);
    try
    {
      if (this.oWz != null)
      {
        this.oWz.stop();
        this.oWz.release();
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
    if (com.tencent.mm.compatible.util.d.ly(23))
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
      if (8 <= this.oWH)
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
                ad.i("MeidaCodec[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.oWH + ", MIME:" + paramString);
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
  
  @SuppressLint({"NewApi"})
  private int bZU()
  {
    AppMethodBeat.i(114836);
    if (this.oWz != null) {
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
      this.oWy = 2001;
      i = -this.oWy;
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
    this.oWG = 1;
    label391:
    boolean bool;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (com.tencent.mm.compatible.util.d.ly(23)))
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
      for (this.oWG = this.mediaFormat.getInteger("profile");; this.oWG = 1)
      {
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try
        {
          this.oWz = z.q(str1, false);
          ad.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.oWG);
          this.oWz.a(this.mediaFormat, null, 1);
          this.oWz.start();
          this.oWF = new g();
          AppMethodBeat.o(114836);
          return 2000;
        }
        catch (Exception localException)
        {
          label557:
          ad.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
          this.oWy = 2002;
          i = -this.oWy;
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
        bool = a(localMediaCodecInfo, str1, this.oWH);
        break label438;
      }
      label680:
      bool = false;
    }
  }
  
  private static String bu(byte[] paramArrayOfByte)
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
  
  private static ArrayList<Integer> by(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114841);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = bu(paramArrayOfByte);
    String str = bu(new byte[] { 0, 0, 0, 1 });
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
  
  private long computePresentationTime(long paramLong)
  {
    AppMethodBeat.i(216241);
    int i = Math.min(Math.max(this.m_framerate, 15), 30);
    if ((paramLong == 0L) || (this.hku == 0L)) {}
    for (this.hku = 132L;; this.hku = (1000000 / i + paramLong))
    {
      paramLong = this.hku;
      AppMethodBeat.o(216241);
      return paramLong;
      paramLong = this.hku;
    }
  }
  
  private int x(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114844);
    if ((paramArrayOfByte != null) && (this.BXC.CaI != null))
    {
      int i = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = VFMT_HEVC_HW;
      }
      i = this.BXC.CaI.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
      if (i >= 0)
      {
        this.wbb = 0;
        ad.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114844);
      return paramInt1;
      paramInt1 = this.wbb;
      this.wbb = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.oWy = 2008;
        paramInt1 = -this.oWy;
        ad.e("MeidaCodec[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(paramInt1)));
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  public final void DoQosSvrCtrl()
  {
    AppMethodBeat.i(216240);
    int k;
    if ((this.BXC != null) && (this.BXC.CaI != null))
    {
      ftp();
      k = this.BYq.iKbps;
      if (this.oWG != 8) {
        break label296;
      }
    }
    label296:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (i == 0)
      {
        double d = Math.max(Math.min(this.BXC.CaI.Cgc, 30), 0) * 1.0D / 100.0D;
        j = (int)(k * (d + 1.0D));
      }
      if (this.m_br_kbps != j)
      {
        SetBitRate(j);
        ad.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + j + ", tuneRatio:" + this.BXC.CaI.Cgc);
        this.m_br_kbps = j;
      }
      if ((1 == this.BYq.cIReqFlag) && (frameID > 0))
      {
        if (this.oWz != null)
        {
          ad.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
          Bundle localBundle = new Bundle();
          localBundle.putInt("request-sync", 0);
          this.oWz.setParameters(localBundle);
        }
        ad.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
      }
      if (this.BYq.cFps != this.m_framerate) {
        this.m_framerate = this.BYq.cFps;
      }
      AppMethodBeat.o(216240);
      return;
    }
  }
  
  /* Error */
  public final int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 597
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 14
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   22: if_icmpeq +33 -> 55
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   40: aload_0
    //   41: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   44: imul
    //   45: iconst_3
    //   46: imul
    //   47: iconst_2
    //   48: idiv
    //   49: invokestatic 603	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   52: putfield 151	com/tencent/mm/plugin/voip/model/e:BYp	Ljava/nio/ByteBuffer;
    //   55: aload_0
    //   56: getfield 151	com/tencent/mm/plugin/voip/model/e:BYp	Ljava/nio/ByteBuffer;
    //   59: ifnonnull +23 -> 82
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   67: aload_0
    //   68: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   71: imul
    //   72: iconst_3
    //   73: imul
    //   74: iconst_2
    //   75: idiv
    //   76: invokestatic 603	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   79: putfield 151	com/tencent/mm/plugin/voip/model/e:BYp	Ljava/nio/ByteBuffer;
    //   82: ldc 246
    //   84: new 292	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 605
    //   91: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 194	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   98: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc_w 607
    //   104: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 196	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   111: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 201	com/tencent/mm/plugin/voip/model/e:BYq	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   124: getfield 610	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   127: ifne +1817 -> 1944
    //   130: aload_0
    //   131: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   134: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   137: ifnull +1807 -> 1944
    //   140: iload 5
    //   142: ifeq +233 -> 375
    //   145: invokestatic 616	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   148: lstore 12
    //   150: aload_0
    //   151: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   154: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   157: aload_1
    //   158: aload_1
    //   159: invokevirtual 619	java/nio/ByteBuffer:capacity	()I
    //   162: aload_0
    //   163: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   166: aload_0
    //   167: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   170: iload 4
    //   172: aload_0
    //   173: getfield 151	com/tencent/mm/plugin/voip/model/e:BYp	Ljava/nio/ByteBuffer;
    //   176: invokevirtual 623	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess2	(Ljava/nio/ByteBuffer;IIIILjava/nio/ByteBuffer;)I
    //   179: pop
    //   180: getstatic 629	com/tencent/mm/plugin/voip/video/render/i:Csj	Lcom/tencent/mm/plugin/voip/video/render/i;
    //   183: astore_1
    //   184: iconst_0
    //   185: lload 12
    //   187: invokestatic 632	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   190: invokestatic 636	com/tencent/mm/plugin/voip/video/render/i:aJ	(IJ)V
    //   193: aload_0
    //   194: getfield 151	com/tencent/mm/plugin/voip/model/e:BYp	Ljava/nio/ByteBuffer;
    //   197: astore_1
    //   198: iload 5
    //   200: ifeq +178 -> 378
    //   203: aload_0
    //   204: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   207: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   210: getfield 639	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   213: istore 4
    //   215: iload 5
    //   217: ifeq +167 -> 384
    //   220: aload_0
    //   221: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   224: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   227: getfield 642	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   230: istore 6
    //   232: aload_0
    //   233: getfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   236: iload 4
    //   238: if_icmpne +12 -> 250
    //   241: aload_0
    //   242: getfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   245: iload 6
    //   247: if_icmpeq +187 -> 434
    //   250: ldc 246
    //   252: new 292	java/lang/StringBuilder
    //   255: dup
    //   256: ldc_w 644
    //   259: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: iload_2
    //   263: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 645
    //   269: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload_3
    //   273: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: ldc_w 647
    //   279: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   286: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: ldc_w 645
    //   292: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: getfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   299: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: iload 4
    //   311: putfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   314: aload_0
    //   315: iload 6
    //   317: putfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   325: aload_0
    //   326: getfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   329: imul
    //   330: iconst_3
    //   331: imul
    //   332: iconst_1
    //   333: ishr
    //   334: putfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   337: aload_0
    //   338: invokespecial 649	com/tencent/mm/plugin/voip/model/e:bZU	()I
    //   341: istore_2
    //   342: iload_2
    //   343: istore_3
    //   344: iload_2
    //   345: ifge +91 -> 436
    //   348: ldc 246
    //   350: ldc_w 651
    //   353: iload_2
    //   354: invokestatic 251	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   357: invokevirtual 255	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   360: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_0
    //   364: invokevirtual 654	com/tencent/mm/plugin/voip/model/e:dpf	()V
    //   367: ldc_w 597
    //   370: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   373: iload_2
    //   374: ireturn
    //   375: goto -177 -> 198
    //   378: iload_2
    //   379: istore 4
    //   381: goto -166 -> 215
    //   384: iload_3
    //   385: istore 6
    //   387: goto -155 -> 232
    //   390: astore 14
    //   392: ldc 246
    //   394: new 292	java/lang/StringBuilder
    //   397: dup
    //   398: ldc_w 656
    //   401: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: aload 14
    //   406: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: aload_0
    //   419: sipush 2003
    //   422: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   425: aload_0
    //   426: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   429: ineg
    //   430: istore_2
    //   431: goto -89 -> 342
    //   434: iconst_0
    //   435: istore_3
    //   436: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   439: bipush 100
    //   441: if_icmpgt +407 -> 848
    //   444: aload_0
    //   445: getfield 658	com/tencent/mm/plugin/voip/model/e:oWE	Ljava/io/BufferedOutputStream;
    //   448: ifnull +400 -> 848
    //   451: aload_0
    //   452: getfield 658	com/tencent/mm/plugin/voip/model/e:oWE	Ljava/io/BufferedOutputStream;
    //   455: aload_0
    //   456: getfield 151	com/tencent/mm/plugin/voip/model/e:BYp	Ljava/nio/ByteBuffer;
    //   459: invokevirtual 662	java/nio/ByteBuffer:array	()[B
    //   462: iconst_0
    //   463: aload_0
    //   464: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   467: invokevirtual 668	java/io/BufferedOutputStream:write	([BII)V
    //   470: iload_3
    //   471: istore_2
    //   472: aload_1
    //   473: ifnull +1438 -> 1911
    //   476: aload_0
    //   477: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   480: ifnull +1431 -> 1911
    //   483: aload_0
    //   484: iconst_0
    //   485: putfield 176	com/tencent/mm/plugin/voip/model/e:oWJ	I
    //   488: invokestatic 673	java/lang/System:currentTimeMillis	()J
    //   491: lstore 12
    //   493: ldc 246
    //   495: new 292	java/lang/StringBuilder
    //   498: dup
    //   499: ldc_w 675
    //   502: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   505: aload_0
    //   506: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   509: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: ldc_w 677
    //   515: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   521: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: ldc_w 679
    //   527: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: lload 12
    //   532: invokevirtual 682	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: aload_0
    //   542: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   545: invokevirtual 686	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   548: astore 15
    //   550: aload_0
    //   551: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   554: invokevirtual 689	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   557: astore 14
    //   559: aload_0
    //   560: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   563: ldc2_w 690
    //   566: invokevirtual 695	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   569: istore_3
    //   570: iload_3
    //   571: iflt +74 -> 645
    //   574: aload_0
    //   575: aload_0
    //   576: getfield 155	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   579: invokespecial 697	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   582: lstore 12
    //   584: aload_1
    //   585: invokevirtual 701	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   588: aload_0
    //   589: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   592: invokevirtual 707	java/nio/Buffer:limit	(I)Ljava/nio/Buffer;
    //   595: pop
    //   596: aload 15
    //   598: iload_3
    //   599: aaload
    //   600: astore 15
    //   602: aload 15
    //   604: invokevirtual 710	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   607: pop
    //   608: aload 15
    //   610: aload_1
    //   611: invokevirtual 714	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   614: pop
    //   615: aload_1
    //   616: invokevirtual 710	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   619: pop
    //   620: aload_0
    //   621: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   624: iload_3
    //   625: aload_0
    //   626: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   629: lload 12
    //   631: iconst_0
    //   632: invokevirtual 717	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 155	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   640: lconst_1
    //   641: ladd
    //   642: putfield 155	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   645: new 719	android/media/MediaCodec$BufferInfo
    //   648: dup
    //   649: invokespecial 720	android/media/MediaCodec$BufferInfo:<init>	()V
    //   652: astore_1
    //   653: aload_0
    //   654: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   657: aload_1
    //   658: aload_0
    //   659: getfield 141	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   662: i2l
    //   663: invokevirtual 724	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   666: istore 4
    //   668: iload_2
    //   669: istore_3
    //   670: iload 4
    //   672: istore 7
    //   674: iload 4
    //   676: bipush 254
    //   678: if_icmpne +239 -> 917
    //   681: aload_0
    //   682: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   685: invokevirtual 728	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   688: astore 15
    //   690: ldc 246
    //   692: ldc_w 730
    //   695: aload 15
    //   697: invokestatic 278	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   700: invokevirtual 255	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   703: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: iload_2
    //   707: istore_3
    //   708: iload 4
    //   710: istore 7
    //   712: aload 15
    //   714: ldc_w 436
    //   717: invokevirtual 733	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   720: ifeq +197 -> 917
    //   723: iload_2
    //   724: istore_3
    //   725: iload 4
    //   727: istore 7
    //   729: aload 15
    //   731: ldc_w 436
    //   734: invokevirtual 455	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   737: i2d
    //   738: aload_0
    //   739: getfield 196	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   742: sipush 1000
    //   745: imul
    //   746: i2d
    //   747: ldc2_w 734
    //   750: dmul
    //   751: dcmpl
    //   752: ifle +165 -> 917
    //   755: ldc 246
    //   757: new 292	java/lang/StringBuilder
    //   760: dup
    //   761: ldc_w 737
    //   764: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   767: aload 15
    //   769: ldc_w 436
    //   772: invokevirtual 455	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   775: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: ldc_w 739
    //   781: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload_0
    //   785: getfield 196	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   788: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   791: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   797: aload_0
    //   798: sipush 2007
    //   801: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   804: aload_0
    //   805: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   808: istore_2
    //   809: iload_2
    //   810: ineg
    //   811: istore_2
    //   812: ldc_w 597
    //   815: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   818: iload_2
    //   819: ireturn
    //   820: astore 14
    //   822: ldc 246
    //   824: new 292	java/lang/StringBuilder
    //   827: dup
    //   828: ldc_w 294
    //   831: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   834: aload 14
    //   836: invokevirtual 300	java/lang/Exception:toString	()Ljava/lang/String;
    //   839: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   848: iload_3
    //   849: istore_2
    //   850: goto -378 -> 472
    //   853: aload_0
    //   854: getfield 741	com/tencent/mm/plugin/voip/model/e:oWD	Z
    //   857: ifeq +22 -> 879
    //   860: aload 15
    //   862: ifnull +17 -> 879
    //   865: aload_0
    //   866: getfield 743	com/tencent/mm/plugin/voip/model/e:oWB	Landroid/media/MediaMuxer;
    //   869: aload_0
    //   870: getfield 745	com/tencent/mm/plugin/voip/model/e:oWC	I
    //   873: aload 15
    //   875: aload_1
    //   876: invokevirtual 751	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   879: aload_1
    //   880: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   883: istore_3
    //   884: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   887: iconst_1
    //   888: iadd
    //   889: putstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   892: aload_0
    //   893: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   896: iload 7
    //   898: iconst_0
    //   899: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   902: aload_0
    //   903: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   906: aload_1
    //   907: aload_0
    //   908: getfield 141	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   911: i2l
    //   912: invokevirtual 724	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   915: istore 7
    //   917: iload_3
    //   918: istore_2
    //   919: iload 7
    //   921: iflt +982 -> 1903
    //   924: aload 14
    //   926: iload 7
    //   928: aaload
    //   929: astore 15
    //   931: aload_1
    //   932: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   935: newarray byte
    //   937: astore 16
    //   939: aload 15
    //   941: aload 16
    //   943: invokevirtual 765	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   946: pop
    //   947: aload_0
    //   948: getfield 767	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   951: ifnull +16 -> 967
    //   954: aload_0
    //   955: getfield 767	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   958: aload 16
    //   960: iconst_0
    //   961: aload 16
    //   963: arraylength
    //   964: invokevirtual 668	java/io/BufferedOutputStream:write	([BII)V
    //   967: aload_1
    //   968: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   971: iconst_2
    //   972: if_icmpne +488 -> 1460
    //   975: aload 16
    //   977: invokestatic 769	com/tencent/mm/plugin/voip/model/e:by	([B)Ljava/util/ArrayList;
    //   980: astore 17
    //   982: new 771	com/tencent/mm/protocal/protobuf/bng
    //   985: dup
    //   986: invokespecial 772	com/tencent/mm/protocal/protobuf/bng:<init>	()V
    //   989: astore 18
    //   991: iconst_0
    //   992: istore 10
    //   994: iconst_0
    //   995: istore 11
    //   997: iconst_0
    //   998: istore_3
    //   999: iconst_0
    //   1000: istore_2
    //   1001: iconst_0
    //   1002: istore 6
    //   1004: iconst_0
    //   1005: istore 4
    //   1007: aload 17
    //   1009: invokevirtual 774	java/util/ArrayList:size	()I
    //   1012: iconst_3
    //   1013: if_icmpne +264 -> 1277
    //   1016: aload_0
    //   1017: getfield 139	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1020: ldc_w 544
    //   1023: invokevirtual 422	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1026: ifeq +251 -> 1277
    //   1029: aload 17
    //   1031: iconst_0
    //   1032: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1035: checkcast 230	java/lang/Integer
    //   1038: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1041: iconst_4
    //   1042: iadd
    //   1043: istore 8
    //   1045: aload 17
    //   1047: iconst_1
    //   1048: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1051: checkcast 230	java/lang/Integer
    //   1054: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1057: iconst_4
    //   1058: iadd
    //   1059: istore_3
    //   1060: aload 17
    //   1062: iconst_2
    //   1063: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1066: checkcast 230	java/lang/Integer
    //   1069: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1072: iconst_4
    //   1073: iadd
    //   1074: istore 6
    //   1076: iload_3
    //   1077: iload 8
    //   1079: isub
    //   1080: iconst_4
    //   1081: isub
    //   1082: istore 9
    //   1084: iload 6
    //   1086: iload_3
    //   1087: isub
    //   1088: iconst_4
    //   1089: isub
    //   1090: istore_2
    //   1091: aload_1
    //   1092: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1095: iload 6
    //   1097: isub
    //   1098: istore 4
    //   1100: aload 18
    //   1102: aload 16
    //   1104: iload 8
    //   1106: iload 9
    //   1108: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1111: putfield 790	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   1114: ldc 246
    //   1116: new 292	java/lang/StringBuilder
    //   1119: dup
    //   1120: ldc_w 792
    //   1123: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1126: iload_3
    //   1127: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1130: ldc_w 794
    //   1133: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: iload_2
    //   1137: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1140: ldc_w 796
    //   1143: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: iload 6
    //   1148: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1151: ldc_w 794
    //   1154: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: iload 4
    //   1159: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: ldc_w 798
    //   1165: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: iload 8
    //   1170: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1173: ldc_w 794
    //   1176: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: iload 9
    //   1181: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1184: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1190: aload_0
    //   1191: getfield 170	com/tencent/mm/plugin/voip/model/e:oWG	I
    //   1194: iconst_1
    //   1195: if_icmpeq +199 -> 1394
    //   1198: aload_0
    //   1199: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1202: aload 16
    //   1204: invokevirtual 802	com/tencent/mm/plugin/voip/model/g:bN	([B)Z
    //   1207: ifeq +187 -> 1394
    //   1210: aload_0
    //   1211: aload_0
    //   1212: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1215: getfield 805	com/tencent/mm/plugin/voip/model/g:BYv	I
    //   1218: putfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1221: aload_0
    //   1222: iconst_1
    //   1223: putfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1226: ldc 246
    //   1228: new 292	java/lang/StringBuilder
    //   1231: dup
    //   1232: ldc_w 807
    //   1235: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1238: aload_0
    //   1239: getfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1242: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1245: ldc_w 809
    //   1248: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: aload_0
    //   1252: getfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1255: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1264: aload_0
    //   1265: invokespecial 649	com/tencent/mm/plugin/voip/model/e:bZU	()I
    //   1268: istore_2
    //   1269: ldc_w 597
    //   1272: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1275: iload_2
    //   1276: ireturn
    //   1277: iload 10
    //   1279: istore 8
    //   1281: iload 11
    //   1283: istore 9
    //   1285: aload 17
    //   1287: invokevirtual 774	java/util/ArrayList:size	()I
    //   1290: iconst_2
    //   1291: if_icmpne -177 -> 1114
    //   1294: aload 17
    //   1296: iconst_0
    //   1297: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1300: checkcast 230	java/lang/Integer
    //   1303: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1306: iconst_4
    //   1307: iadd
    //   1308: istore_3
    //   1309: aload 17
    //   1311: iconst_1
    //   1312: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1315: checkcast 230	java/lang/Integer
    //   1318: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1321: iconst_4
    //   1322: iadd
    //   1323: istore 6
    //   1325: iload 6
    //   1327: iload_3
    //   1328: isub
    //   1329: iconst_4
    //   1330: isub
    //   1331: istore_2
    //   1332: aload_1
    //   1333: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1336: iload 6
    //   1338: isub
    //   1339: istore 4
    //   1341: iload 10
    //   1343: istore 8
    //   1345: iload 11
    //   1347: istore 9
    //   1349: goto -235 -> 1114
    //   1352: astore_1
    //   1353: ldc 246
    //   1355: new 292	java/lang/StringBuilder
    //   1358: dup
    //   1359: ldc_w 811
    //   1362: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1365: aload_1
    //   1366: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1369: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1375: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1378: aload_0
    //   1379: sipush 2005
    //   1382: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1385: aload_0
    //   1386: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1389: ineg
    //   1390: istore_2
    //   1391: goto -122 -> 1269
    //   1394: aload 18
    //   1396: iconst_4
    //   1397: putfield 814	com/tencent/mm/protocal/protobuf/bng:GHi	I
    //   1400: aload 18
    //   1402: aload 16
    //   1404: iload_3
    //   1405: iload_2
    //   1406: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1409: putfield 817	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   1412: aload 18
    //   1414: aload 16
    //   1416: iload 6
    //   1418: iload 4
    //   1420: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1423: putfield 820	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   1426: aload 18
    //   1428: invokevirtual 823	com/tencent/mm/protocal/protobuf/bng:toByteArray	()[B
    //   1431: arraylength
    //   1432: istore_2
    //   1433: aload_0
    //   1434: aload 18
    //   1436: invokevirtual 823	com/tencent/mm/protocal/protobuf/bng:toByteArray	()[B
    //   1439: aload_1
    //   1440: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1443: iload_2
    //   1444: invokespecial 825	com/tencent/mm/plugin/voip/model/e:x	([BII)I
    //   1447: istore_2
    //   1448: iload_2
    //   1449: ifge -596 -> 853
    //   1452: ldc_w 597
    //   1455: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1458: iload_2
    //   1459: ireturn
    //   1460: aload_0
    //   1461: getfield 170	com/tencent/mm/plugin/voip/model/e:oWG	I
    //   1464: iconst_1
    //   1465: if_icmpeq +124 -> 1589
    //   1468: aload_0
    //   1469: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1472: aload 16
    //   1474: invokevirtual 828	com/tencent/mm/plugin/voip/model/g:bO	([B)Z
    //   1477: ifeq +112 -> 1589
    //   1480: aload_0
    //   1481: aload_0
    //   1482: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1485: getfield 805	com/tencent/mm/plugin/voip/model/g:BYv	I
    //   1488: putfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1491: aload_0
    //   1492: iconst_1
    //   1493: putfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1496: ldc 246
    //   1498: new 292	java/lang/StringBuilder
    //   1501: dup
    //   1502: ldc_w 807
    //   1505: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1508: aload_0
    //   1509: getfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1512: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1515: ldc_w 809
    //   1518: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: aload_0
    //   1522: getfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1525: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1528: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1531: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: aload_0
    //   1535: invokespecial 649	com/tencent/mm/plugin/voip/model/e:bZU	()I
    //   1538: istore_2
    //   1539: ldc_w 597
    //   1542: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1545: iload_2
    //   1546: ireturn
    //   1547: astore_1
    //   1548: ldc 246
    //   1550: new 292	java/lang/StringBuilder
    //   1553: dup
    //   1554: ldc_w 811
    //   1557: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1560: aload_1
    //   1561: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1564: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1573: aload_0
    //   1574: sipush 2005
    //   1577: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1580: aload_0
    //   1581: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1584: ineg
    //   1585: istore_2
    //   1586: goto -47 -> 1539
    //   1589: aload_1
    //   1590: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1593: ifeq +70 -> 1663
    //   1596: aload_1
    //   1597: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1600: iconst_1
    //   1601: if_icmpeq +62 -> 1663
    //   1604: aload_0
    //   1605: sipush 2009
    //   1608: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1611: aload_0
    //   1612: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1615: ineg
    //   1616: istore_2
    //   1617: ldc 246
    //   1619: new 292	java/lang/StringBuilder
    //   1622: dup
    //   1623: ldc_w 830
    //   1626: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1629: aload_1
    //   1630: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1633: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1636: ldc_w 794
    //   1639: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: aload_1
    //   1643: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1646: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1649: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1652: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1655: ldc_w 597
    //   1658: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1661: iload_2
    //   1662: ireturn
    //   1663: iconst_4
    //   1664: invokestatic 833	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1667: astore 17
    //   1669: aload 17
    //   1671: aload_1
    //   1672: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1675: iconst_4
    //   1676: isub
    //   1677: invokevirtual 835	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1680: pop
    //   1681: aload 17
    //   1683: getstatic 841	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1686: invokevirtual 845	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1689: invokevirtual 662	java/nio/ByteBuffer:array	()[B
    //   1692: iconst_0
    //   1693: aload 16
    //   1695: iconst_0
    //   1696: iconst_4
    //   1697: invokestatic 849	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1700: invokestatic 673	java/lang/System:currentTimeMillis	()J
    //   1703: lstore 12
    //   1705: ldc 246
    //   1707: new 292	java/lang/StringBuilder
    //   1710: dup
    //   1711: ldc_w 851
    //   1714: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1717: aload_1
    //   1718: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1721: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1724: ldc_w 853
    //   1727: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1730: aload_1
    //   1731: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1734: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1737: ldc_w 677
    //   1740: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   1746: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1749: ldc_w 679
    //   1752: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: lload 12
    //   1757: invokevirtual 682	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1760: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1763: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1766: new 855	com/tencent/mm/protocal/protobuf/bnf
    //   1769: dup
    //   1770: invokespecial 856	com/tencent/mm/protocal/protobuf/bnf:<init>	()V
    //   1773: astore 17
    //   1775: aload 17
    //   1777: aload 16
    //   1779: iconst_0
    //   1780: aload_1
    //   1781: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1784: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1787: putfield 859	com/tencent/mm/protocal/protobuf/bnf:GHe	Lcom/tencent/mm/bx/b;
    //   1790: aload 17
    //   1792: iconst_1
    //   1793: putfield 862	com/tencent/mm/protocal/protobuf/bnf:GHf	I
    //   1796: aload 17
    //   1798: aload_0
    //   1799: getfield 164	com/tencent/mm/plugin/voip/model/e:waZ	Ljava/util/LinkedList;
    //   1802: putfield 865	com/tencent/mm/protocal/protobuf/bnf:GHg	Ljava/util/LinkedList;
    //   1805: aload_0
    //   1806: getfield 166	com/tencent/mm/plugin/voip/model/e:wba	Ljava/util/LinkedList;
    //   1809: iconst_0
    //   1810: aload_1
    //   1811: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1814: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1817: invokevirtual 869	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1820: pop
    //   1821: aload 17
    //   1823: aload_0
    //   1824: getfield 166	com/tencent/mm/plugin/voip/model/e:wba	Ljava/util/LinkedList;
    //   1827: putfield 872	com/tencent/mm/protocal/protobuf/bnf:GHh	Ljava/util/LinkedList;
    //   1830: aload 17
    //   1832: invokevirtual 873	com/tencent/mm/protocal/protobuf/bnf:toByteArray	()[B
    //   1835: arraylength
    //   1836: istore_2
    //   1837: aload_0
    //   1838: aload 17
    //   1840: invokevirtual 873	com/tencent/mm/protocal/protobuf/bnf:toByteArray	()[B
    //   1843: aload_1
    //   1844: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1847: iload_2
    //   1848: invokespecial 825	com/tencent/mm/plugin/voip/model/e:x	([BII)I
    //   1851: istore_2
    //   1852: iload_2
    //   1853: ifge -1000 -> 853
    //   1856: ldc_w 597
    //   1859: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1862: iload_2
    //   1863: ireturn
    //   1864: astore_1
    //   1865: ldc 246
    //   1867: new 292	java/lang/StringBuilder
    //   1870: dup
    //   1871: ldc_w 294
    //   1874: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1877: aload_1
    //   1878: invokevirtual 300	java/lang/Exception:toString	()Ljava/lang/String;
    //   1881: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1887: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1890: aload_0
    //   1891: sipush 2004
    //   1894: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1897: aload_0
    //   1898: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1901: ineg
    //   1902: istore_2
    //   1903: ldc_w 597
    //   1906: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1909: iload_2
    //   1910: ireturn
    //   1911: aload_0
    //   1912: getfield 176	com/tencent/mm/plugin/voip/model/e:oWJ	I
    //   1915: istore_3
    //   1916: aload_0
    //   1917: iload_3
    //   1918: iconst_1
    //   1919: iadd
    //   1920: putfield 176	com/tencent/mm/plugin/voip/model/e:oWJ	I
    //   1923: iload_3
    //   1924: iconst_5
    //   1925: if_icmple -22 -> 1903
    //   1928: aload_0
    //   1929: sipush 2006
    //   1932: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1935: aload_0
    //   1936: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1939: ineg
    //   1940: istore_2
    //   1941: goto -38 -> 1903
    //   1944: iconst_0
    //   1945: istore_2
    //   1946: aload 14
    //   1948: astore_1
    //   1949: goto -1477 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1952	0	this	e
    //   0	1952	1	paramByteBuffer	ByteBuffer
    //   0	1952	2	paramInt1	int
    //   0	1952	3	paramInt2	int
    //   0	1952	4	paramInt3	int
    //   0	1952	5	paramBoolean	boolean
    //   230	1187	6	i	int
    //   672	255	7	j	int
    //   1043	301	8	k	int
    //   1082	266	9	m	int
    //   992	350	10	n	int
    //   995	351	11	i1	int
    //   148	1608	12	l	long
    //   7	1	14	localObject1	Object
    //   390	15	14	localException1	Exception
    //   557	1	14	arrayOfByteBuffer	ByteBuffer[]
    //   820	1127	14	localException2	Exception
    //   548	392	15	localObject2	Object
    //   937	841	16	arrayOfByte	byte[]
    //   980	859	17	localObject3	Object
    //   989	446	18	localbng	com.tencent.mm.protocal.protobuf.bng
    // Exception table:
    //   from	to	target	type
    //   337	342	390	java/lang/Exception
    //   451	470	820	java/lang/Exception
    //   1264	1269	1352	java/lang/Exception
    //   1534	1539	1547	java/lang/Exception
    //   483	570	1864	java/lang/Exception
    //   574	596	1864	java/lang/Exception
    //   602	645	1864	java/lang/Exception
    //   645	668	1864	java/lang/Exception
    //   681	706	1864	java/lang/Exception
    //   712	723	1864	java/lang/Exception
    //   729	809	1864	java/lang/Exception
    //   853	860	1864	java/lang/Exception
    //   865	879	1864	java/lang/Exception
    //   879	917	1864	java/lang/Exception
    //   931	967	1864	java/lang/Exception
    //   967	991	1864	java/lang/Exception
    //   1007	1076	1864	java/lang/Exception
    //   1091	1114	1864	java/lang/Exception
    //   1114	1264	1864	java/lang/Exception
    //   1285	1325	1864	java/lang/Exception
    //   1332	1341	1864	java/lang/Exception
    //   1353	1391	1864	java/lang/Exception
    //   1394	1448	1864	java/lang/Exception
    //   1460	1534	1864	java/lang/Exception
    //   1548	1586	1864	java/lang/Exception
    //   1589	1655	1864	java/lang/Exception
    //   1663	1852	1864	java/lang/Exception
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 875
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   22: if_icmpeq +32 -> 54
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   40: aload_0
    //   41: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   44: imul
    //   45: iconst_3
    //   46: imul
    //   47: iconst_2
    //   48: idiv
    //   49: newarray byte
    //   51: putfield 149	com/tencent/mm/plugin/voip/model/e:oWA	[B
    //   54: aload_0
    //   55: getfield 149	com/tencent/mm/plugin/voip/model/e:oWA	[B
    //   58: ifnonnull +22 -> 80
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   66: aload_0
    //   67: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   70: imul
    //   71: iconst_3
    //   72: imul
    //   73: iconst_2
    //   74: idiv
    //   75: newarray byte
    //   77: putfield 149	com/tencent/mm/plugin/voip/model/e:oWA	[B
    //   80: ldc 246
    //   82: new 292	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 605
    //   89: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 194	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   96: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 607
    //   102: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 196	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   109: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: getfield 201	com/tencent/mm/plugin/voip/model/e:BYq	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   122: getfield 610	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   125: ifne +2234 -> 2359
    //   128: aload_0
    //   129: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   132: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   135: ifnull +2224 -> 2359
    //   138: aload_0
    //   139: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   142: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   145: aload_1
    //   146: aload_1
    //   147: arraylength
    //   148: aload_0
    //   149: getfield 190	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   152: aload_0
    //   153: getfield 192	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   156: iload 4
    //   158: aload_0
    //   159: getfield 149	com/tencent/mm/plugin/voip/model/e:oWA	[B
    //   162: invokevirtual 879	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess	([BIIII[B)I
    //   165: pop
    //   166: aload_0
    //   167: getfield 149	com/tencent/mm/plugin/voip/model/e:oWA	[B
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   175: aload_0
    //   176: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   179: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   182: getfield 639	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   185: if_icmpne +20 -> 205
    //   188: aload_0
    //   189: getfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   192: aload_0
    //   193: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   196: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   199: getfield 642	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   202: if_icmpeq +206 -> 408
    //   205: ldc 246
    //   207: new 292	java/lang/StringBuilder
    //   210: dup
    //   211: ldc_w 644
    //   214: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   221: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   224: getfield 639	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   227: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: ldc_w 645
    //   233: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   240: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   243: getfield 642	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   246: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 647
    //   252: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: getfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   259: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 645
    //   265: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   272: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: aload_0
    //   283: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   286: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   289: getfield 639	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   292: putfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 159	com/tencent/mm/plugin/voip/model/e:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   300: getfield 542	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   303: getfield 642	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   306: putfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 186	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   314: aload_0
    //   315: getfield 188	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   318: imul
    //   319: iconst_3
    //   320: imul
    //   321: iconst_1
    //   322: ishr
    //   323: putfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   326: aload_0
    //   327: invokespecial 649	com/tencent/mm/plugin/voip/model/e:bZU	()I
    //   330: istore_2
    //   331: iload_2
    //   332: istore_3
    //   333: iload_2
    //   334: ifge +76 -> 410
    //   337: ldc 246
    //   339: ldc_w 651
    //   342: iload_2
    //   343: invokestatic 251	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   346: invokevirtual 255	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_0
    //   353: invokevirtual 654	com/tencent/mm/plugin/voip/model/e:dpf	()V
    //   356: ldc_w 875
    //   359: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: iload_2
    //   363: ireturn
    //   364: astore 13
    //   366: ldc 246
    //   368: new 292	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 656
    //   375: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: aload 13
    //   380: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   383: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_0
    //   393: sipush 2003
    //   396: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   399: aload_0
    //   400: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   403: ineg
    //   404: istore_2
    //   405: goto -74 -> 331
    //   408: iconst_0
    //   409: istore_3
    //   410: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   413: bipush 100
    //   415: if_icmpgt +392 -> 807
    //   418: aload_0
    //   419: getfield 658	com/tencent/mm/plugin/voip/model/e:oWE	Ljava/io/BufferedOutputStream;
    //   422: ifnull +385 -> 807
    //   425: aload_0
    //   426: getfield 658	com/tencent/mm/plugin/voip/model/e:oWE	Ljava/io/BufferedOutputStream;
    //   429: aload_0
    //   430: getfield 149	com/tencent/mm/plugin/voip/model/e:oWA	[B
    //   433: iconst_0
    //   434: aload_0
    //   435: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   438: invokevirtual 668	java/io/BufferedOutputStream:write	([BII)V
    //   441: iload_3
    //   442: istore_2
    //   443: aload_1
    //   444: ifnull +1882 -> 2326
    //   447: aload_0
    //   448: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   451: ifnull +1875 -> 2326
    //   454: aload_0
    //   455: iconst_0
    //   456: putfield 176	com/tencent/mm/plugin/voip/model/e:oWJ	I
    //   459: invokestatic 673	java/lang/System:currentTimeMillis	()J
    //   462: lstore 11
    //   464: ldc 246
    //   466: new 292	java/lang/StringBuilder
    //   469: dup
    //   470: ldc_w 675
    //   473: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   476: aload_0
    //   477: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   480: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 677
    //   486: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   492: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc_w 679
    //   498: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: lload 11
    //   503: invokevirtual 682	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   516: invokevirtual 686	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   519: astore 14
    //   521: aload_0
    //   522: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   525: invokevirtual 689	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   528: astore 13
    //   530: aload_0
    //   531: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   534: ldc2_w 690
    //   537: invokevirtual 695	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   540: istore_3
    //   541: iload_3
    //   542: iflt +62 -> 604
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 155	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   550: invokespecial 697	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   553: lstore 11
    //   555: aload 14
    //   557: iload_3
    //   558: aaload
    //   559: astore 14
    //   561: aload 14
    //   563: invokevirtual 710	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   566: pop
    //   567: aload 14
    //   569: aload_1
    //   570: iconst_0
    //   571: aload_0
    //   572: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   575: invokevirtual 882	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   578: pop
    //   579: aload_0
    //   580: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   583: iload_3
    //   584: aload_0
    //   585: getfield 182	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   588: lload 11
    //   590: iconst_0
    //   591: invokevirtual 717	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   594: aload_0
    //   595: aload_0
    //   596: getfield 155	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   599: lconst_1
    //   600: ladd
    //   601: putfield 155	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   604: new 719	android/media/MediaCodec$BufferInfo
    //   607: dup
    //   608: invokespecial 720	android/media/MediaCodec$BufferInfo:<init>	()V
    //   611: astore_1
    //   612: aload_0
    //   613: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   616: aload_1
    //   617: aload_0
    //   618: getfield 141	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   621: i2l
    //   622: invokevirtual 724	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   625: istore 4
    //   627: iload_2
    //   628: istore_3
    //   629: iload 4
    //   631: istore 6
    //   633: iload 4
    //   635: bipush 254
    //   637: if_icmpne +239 -> 876
    //   640: aload_0
    //   641: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   644: invokevirtual 728	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   647: astore 14
    //   649: ldc 246
    //   651: ldc_w 730
    //   654: aload 14
    //   656: invokestatic 278	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   659: invokevirtual 255	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   662: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: iload_2
    //   666: istore_3
    //   667: iload 4
    //   669: istore 6
    //   671: aload 14
    //   673: ldc_w 436
    //   676: invokevirtual 733	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   679: ifeq +197 -> 876
    //   682: iload_2
    //   683: istore_3
    //   684: iload 4
    //   686: istore 6
    //   688: aload 14
    //   690: ldc_w 436
    //   693: invokevirtual 455	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   696: i2d
    //   697: aload_0
    //   698: getfield 196	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   701: sipush 1000
    //   704: imul
    //   705: i2d
    //   706: ldc2_w 734
    //   709: dmul
    //   710: dcmpl
    //   711: ifle +165 -> 876
    //   714: ldc 246
    //   716: new 292	java/lang/StringBuilder
    //   719: dup
    //   720: ldc_w 737
    //   723: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload 14
    //   728: ldc_w 436
    //   731: invokevirtual 455	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   734: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   737: ldc_w 739
    //   740: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload_0
    //   744: getfield 196	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   747: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload_0
    //   757: sipush 2007
    //   760: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   763: aload_0
    //   764: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   767: istore_2
    //   768: iload_2
    //   769: ineg
    //   770: istore_2
    //   771: ldc_w 875
    //   774: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   777: iload_2
    //   778: ireturn
    //   779: astore 13
    //   781: ldc 246
    //   783: new 292	java/lang/StringBuilder
    //   786: dup
    //   787: ldc_w 294
    //   790: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   793: aload 13
    //   795: invokevirtual 300	java/lang/Exception:toString	()Ljava/lang/String;
    //   798: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: iload_3
    //   808: istore_2
    //   809: goto -366 -> 443
    //   812: aload_0
    //   813: getfield 741	com/tencent/mm/plugin/voip/model/e:oWD	Z
    //   816: ifeq +22 -> 838
    //   819: aload 14
    //   821: ifnull +17 -> 838
    //   824: aload_0
    //   825: getfield 743	com/tencent/mm/plugin/voip/model/e:oWB	Landroid/media/MediaMuxer;
    //   828: aload_0
    //   829: getfield 745	com/tencent/mm/plugin/voip/model/e:oWC	I
    //   832: aload 14
    //   834: aload_1
    //   835: invokevirtual 751	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   838: aload_1
    //   839: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   842: istore_3
    //   843: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   846: iconst_1
    //   847: iadd
    //   848: putstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   851: aload_0
    //   852: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   855: iload 6
    //   857: iconst_0
    //   858: invokevirtual 758	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   861: aload_0
    //   862: getfield 203	com/tencent/mm/plugin/voip/model/e:oWz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   865: aload_1
    //   866: aload_0
    //   867: getfield 141	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   870: i2l
    //   871: invokevirtual 724	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   874: istore 6
    //   876: iload_3
    //   877: istore_2
    //   878: iload 6
    //   880: iflt +1430 -> 2310
    //   883: aload 13
    //   885: iload 6
    //   887: aaload
    //   888: astore 14
    //   890: aload_1
    //   891: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   894: newarray byte
    //   896: astore 15
    //   898: aload 14
    //   900: aload 15
    //   902: invokevirtual 765	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   905: pop
    //   906: aload_0
    //   907: getfield 767	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   910: ifnull +16 -> 926
    //   913: aload_0
    //   914: getfield 767	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   917: aload 15
    //   919: iconst_0
    //   920: aload 15
    //   922: arraylength
    //   923: invokevirtual 668	java/io/BufferedOutputStream:write	([BII)V
    //   926: aload_1
    //   927: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   930: iconst_2
    //   931: if_icmpne +548 -> 1479
    //   934: aload 15
    //   936: invokestatic 769	com/tencent/mm/plugin/voip/model/e:by	([B)Ljava/util/ArrayList;
    //   939: astore 16
    //   941: new 771	com/tencent/mm/protocal/protobuf/bng
    //   944: dup
    //   945: invokespecial 772	com/tencent/mm/protocal/protobuf/bng:<init>	()V
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
    //   968: invokevirtual 774	java/util/ArrayList:size	()I
    //   971: iconst_3
    //   972: if_icmpne +325 -> 1297
    //   975: aload_0
    //   976: getfield 139	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   979: ldc_w 544
    //   982: invokevirtual 422	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   985: ifeq +312 -> 1297
    //   988: aload 16
    //   990: iconst_0
    //   991: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   994: checkcast 230	java/lang/Integer
    //   997: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1000: iconst_4
    //   1001: iadd
    //   1002: istore 7
    //   1004: aload 16
    //   1006: iconst_1
    //   1007: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1010: checkcast 230	java/lang/Integer
    //   1013: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1016: iconst_4
    //   1017: iadd
    //   1018: istore 5
    //   1020: aload 16
    //   1022: iconst_2
    //   1023: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1026: checkcast 230	java/lang/Integer
    //   1029: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1032: iconst_4
    //   1033: iadd
    //   1034: istore_3
    //   1035: iload 5
    //   1037: iload 7
    //   1039: isub
    //   1040: iconst_4
    //   1041: isub
    //   1042: istore 8
    //   1044: iload_3
    //   1045: iload 5
    //   1047: isub
    //   1048: iconst_4
    //   1049: isub
    //   1050: istore 4
    //   1052: aload_1
    //   1053: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1056: iload_3
    //   1057: isub
    //   1058: istore_2
    //   1059: aload 17
    //   1061: aload 15
    //   1063: iload 7
    //   1065: iload 8
    //   1067: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1070: putfield 790	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   1073: aload_0
    //   1074: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1077: ifnonnull +13 -> 1090
    //   1080: aload_0
    //   1081: aload_1
    //   1082: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1085: newarray byte
    //   1087: putfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1090: aload_0
    //   1091: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1094: ifnull +40 -> 1134
    //   1097: aload_1
    //   1098: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1101: aload_0
    //   1102: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1105: arraylength
    //   1106: if_icmple +13 -> 1119
    //   1109: aload_0
    //   1110: aload_1
    //   1111: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1114: newarray byte
    //   1116: putfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1119: aload 15
    //   1121: iconst_0
    //   1122: aload_0
    //   1123: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1126: iconst_0
    //   1127: aload_1
    //   1128: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1131: invokestatic 849	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1134: ldc 246
    //   1136: new 292	java/lang/StringBuilder
    //   1139: dup
    //   1140: ldc_w 792
    //   1143: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1146: iload 5
    //   1148: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1151: ldc_w 794
    //   1154: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: iload 4
    //   1159: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: ldc_w 796
    //   1165: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: iload_3
    //   1169: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: ldc_w 794
    //   1175: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload_2
    //   1179: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: ldc_w 798
    //   1185: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: iload 7
    //   1190: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1193: ldc_w 794
    //   1196: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: iload 8
    //   1201: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1210: aload_0
    //   1211: getfield 170	com/tencent/mm/plugin/voip/model/e:oWG	I
    //   1214: iconst_1
    //   1215: if_icmpeq +198 -> 1413
    //   1218: aload_0
    //   1219: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1222: aload 15
    //   1224: invokevirtual 802	com/tencent/mm/plugin/voip/model/g:bN	([B)Z
    //   1227: ifeq +186 -> 1413
    //   1230: aload_0
    //   1231: aload_0
    //   1232: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1235: getfield 805	com/tencent/mm/plugin/voip/model/g:BYv	I
    //   1238: putfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1241: aload_0
    //   1242: iconst_1
    //   1243: putfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1246: ldc 246
    //   1248: new 292	java/lang/StringBuilder
    //   1251: dup
    //   1252: ldc_w 807
    //   1255: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1258: aload_0
    //   1259: getfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1262: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1265: ldc_w 809
    //   1268: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: aload_0
    //   1272: getfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1275: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1278: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1281: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1284: aload_0
    //   1285: invokespecial 649	com/tencent/mm/plugin/voip/model/e:bZU	()I
    //   1288: istore_2
    //   1289: ldc_w 875
    //   1292: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1295: iload_2
    //   1296: ireturn
    //   1297: iload 10
    //   1299: istore 8
    //   1301: iload 9
    //   1303: istore 7
    //   1305: aload 16
    //   1307: invokevirtual 774	java/util/ArrayList:size	()I
    //   1310: iconst_2
    //   1311: if_icmpne -238 -> 1073
    //   1314: aload 16
    //   1316: iconst_0
    //   1317: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1320: checkcast 230	java/lang/Integer
    //   1323: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1326: iconst_4
    //   1327: iadd
    //   1328: istore 5
    //   1330: aload 16
    //   1332: iconst_1
    //   1333: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1336: checkcast 230	java/lang/Integer
    //   1339: invokevirtual 780	java/lang/Integer:intValue	()I
    //   1342: iconst_4
    //   1343: iadd
    //   1344: istore_3
    //   1345: iload_3
    //   1346: iload 5
    //   1348: isub
    //   1349: iconst_4
    //   1350: isub
    //   1351: istore 4
    //   1353: aload_1
    //   1354: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1357: iload_3
    //   1358: isub
    //   1359: istore_2
    //   1360: iload 10
    //   1362: istore 8
    //   1364: iload 9
    //   1366: istore 7
    //   1368: goto -295 -> 1073
    //   1371: astore_1
    //   1372: ldc 246
    //   1374: new 292	java/lang/StringBuilder
    //   1377: dup
    //   1378: ldc_w 811
    //   1381: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1384: aload_1
    //   1385: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1388: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: aload_0
    //   1398: sipush 2005
    //   1401: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1404: aload_0
    //   1405: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1408: ineg
    //   1409: istore_2
    //   1410: goto -121 -> 1289
    //   1413: aload 17
    //   1415: iconst_4
    //   1416: putfield 814	com/tencent/mm/protocal/protobuf/bng:GHi	I
    //   1419: aload 17
    //   1421: aload 15
    //   1423: iload 5
    //   1425: iload 4
    //   1427: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1430: putfield 817	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   1433: aload 17
    //   1435: aload 15
    //   1437: iload_3
    //   1438: iload_2
    //   1439: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1442: putfield 820	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   1445: aload 17
    //   1447: invokevirtual 823	com/tencent/mm/protocal/protobuf/bng:toByteArray	()[B
    //   1450: arraylength
    //   1451: istore_2
    //   1452: aload_0
    //   1453: aload 17
    //   1455: invokevirtual 823	com/tencent/mm/protocal/protobuf/bng:toByteArray	()[B
    //   1458: aload_1
    //   1459: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1462: iload_2
    //   1463: invokespecial 825	com/tencent/mm/plugin/voip/model/e:x	([BII)I
    //   1466: istore_2
    //   1467: iload_2
    //   1468: ifge -656 -> 812
    //   1471: ldc_w 875
    //   1474: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1477: iload_2
    //   1478: ireturn
    //   1479: aload_0
    //   1480: getfield 170	com/tencent/mm/plugin/voip/model/e:oWG	I
    //   1483: iconst_1
    //   1484: if_icmpeq +124 -> 1608
    //   1487: aload_0
    //   1488: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1491: aload 15
    //   1493: invokevirtual 828	com/tencent/mm/plugin/voip/model/g:bO	([B)Z
    //   1496: ifeq +112 -> 1608
    //   1499: aload_0
    //   1500: aload_0
    //   1501: getfield 168	com/tencent/mm/plugin/voip/model/e:oWF	Lcom/tencent/mm/plugin/voip/model/g;
    //   1504: getfield 805	com/tencent/mm/plugin/voip/model/g:BYv	I
    //   1507: putfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1510: aload_0
    //   1511: iconst_1
    //   1512: putfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1515: ldc 246
    //   1517: new 292	java/lang/StringBuilder
    //   1520: dup
    //   1521: ldc_w 807
    //   1524: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1527: aload_0
    //   1528: getfield 172	com/tencent/mm/plugin/voip/model/e:oWH	I
    //   1531: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1534: ldc_w 809
    //   1537: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: aload_0
    //   1541: getfield 174	com/tencent/mm/plugin/voip/model/e:oWI	I
    //   1544: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1547: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1550: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1553: aload_0
    //   1554: invokespecial 649	com/tencent/mm/plugin/voip/model/e:bZU	()I
    //   1557: istore_2
    //   1558: ldc_w 875
    //   1561: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1564: iload_2
    //   1565: ireturn
    //   1566: astore_1
    //   1567: ldc 246
    //   1569: new 292	java/lang/StringBuilder
    //   1572: dup
    //   1573: ldc_w 811
    //   1576: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1579: aload_1
    //   1580: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1583: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1589: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1592: aload_0
    //   1593: sipush 2005
    //   1596: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1599: aload_0
    //   1600: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1603: ineg
    //   1604: istore_2
    //   1605: goto -47 -> 1558
    //   1608: aload_1
    //   1609: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1612: ifeq +70 -> 1682
    //   1615: aload_1
    //   1616: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1619: iconst_1
    //   1620: if_icmpeq +62 -> 1682
    //   1623: aload_0
    //   1624: sipush 2009
    //   1627: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1630: aload_0
    //   1631: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   1634: ineg
    //   1635: istore_2
    //   1636: ldc 246
    //   1638: new 292	java/lang/StringBuilder
    //   1641: dup
    //   1642: ldc_w 830
    //   1645: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1648: aload_1
    //   1649: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1652: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1655: ldc_w 794
    //   1658: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: aload_1
    //   1662: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1665: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1668: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1671: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1674: ldc_w 875
    //   1677: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1680: iload_2
    //   1681: ireturn
    //   1682: iconst_0
    //   1683: istore_3
    //   1684: iload_3
    //   1685: istore_2
    //   1686: aload_1
    //   1687: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1690: iconst_1
    //   1691: if_icmpne +63 -> 1754
    //   1694: aload_0
    //   1695: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1698: arraylength
    //   1699: newarray byte
    //   1701: astore 16
    //   1703: aload 15
    //   1705: iconst_0
    //   1706: aload 16
    //   1708: iconst_0
    //   1709: aload_0
    //   1710: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1713: arraylength
    //   1714: invokestatic 849	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1717: aload 16
    //   1719: aload_0
    //   1720: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1723: invokestatic 888	java/util/Arrays:equals	([B[B)Z
    //   1726: ifeq +245 -> 1971
    //   1729: aload_0
    //   1730: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   1733: arraylength
    //   1734: istore_2
    //   1735: ldc 246
    //   1737: ldc_w 890
    //   1740: iconst_1
    //   1741: anewarray 4	java/lang/Object
    //   1744: dup
    //   1745: iconst_0
    //   1746: iload_2
    //   1747: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1750: aastore
    //   1751: invokestatic 893	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1754: iconst_4
    //   1755: invokestatic 833	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1758: astore 16
    //   1760: aload 16
    //   1762: aload_1
    //   1763: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1766: iconst_4
    //   1767: isub
    //   1768: iload_2
    //   1769: isub
    //   1770: invokevirtual 835	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1773: pop
    //   1774: aload 16
    //   1776: getstatic 841	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1779: invokevirtual 845	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1782: invokevirtual 662	java/nio/ByteBuffer:array	()[B
    //   1785: iconst_0
    //   1786: aload 15
    //   1788: iload_2
    //   1789: iconst_4
    //   1790: invokestatic 849	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1793: invokestatic 673	java/lang/System:currentTimeMillis	()J
    //   1796: lstore 11
    //   1798: ldc 246
    //   1800: new 292	java/lang/StringBuilder
    //   1803: dup
    //   1804: ldc_w 851
    //   1807: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1810: aload_1
    //   1811: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1814: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1817: ldc_w 853
    //   1820: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: aload_1
    //   1824: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1827: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1830: ldc_w 677
    //   1833: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: getstatic 86	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   1839: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1842: ldc_w 679
    //   1845: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: lload 11
    //   1850: invokevirtual 682	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1853: ldc_w 895
    //   1856: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1859: iload_2
    //   1860: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1863: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1866: invokestatic 321	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1869: new 855	com/tencent/mm/protocal/protobuf/bnf
    //   1872: dup
    //   1873: invokespecial 856	com/tencent/mm/protocal/protobuf/bnf:<init>	()V
    //   1876: astore 16
    //   1878: aload 16
    //   1880: aload 15
    //   1882: iload_2
    //   1883: aload_1
    //   1884: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1887: iload_2
    //   1888: isub
    //   1889: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   1892: putfield 859	com/tencent/mm/protocal/protobuf/bnf:GHe	Lcom/tencent/mm/bx/b;
    //   1895: aload 16
    //   1897: iconst_1
    //   1898: putfield 862	com/tencent/mm/protocal/protobuf/bnf:GHf	I
    //   1901: aload 16
    //   1903: aload_0
    //   1904: getfield 164	com/tencent/mm/plugin/voip/model/e:waZ	Ljava/util/LinkedList;
    //   1907: putfield 865	com/tencent/mm/protocal/protobuf/bnf:GHg	Ljava/util/LinkedList;
    //   1910: aload_0
    //   1911: getfield 166	com/tencent/mm/plugin/voip/model/e:wba	Ljava/util/LinkedList;
    //   1914: iconst_0
    //   1915: aload_1
    //   1916: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1919: iload_2
    //   1920: isub
    //   1921: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1924: invokevirtual 869	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1927: pop
    //   1928: aload 16
    //   1930: aload_0
    //   1931: getfield 166	com/tencent/mm/plugin/voip/model/e:wba	Ljava/util/LinkedList;
    //   1934: putfield 872	com/tencent/mm/protocal/protobuf/bnf:GHh	Ljava/util/LinkedList;
    //   1937: aload 16
    //   1939: invokevirtual 873	com/tencent/mm/protocal/protobuf/bnf:toByteArray	()[B
    //   1942: arraylength
    //   1943: istore_2
    //   1944: aload_0
    //   1945: aload 16
    //   1947: invokevirtual 873	com/tencent/mm/protocal/protobuf/bnf:toByteArray	()[B
    //   1950: aload_1
    //   1951: getfield 754	android/media/MediaCodec$BufferInfo:flags	I
    //   1954: iload_2
    //   1955: invokespecial 825	com/tencent/mm/plugin/voip/model/e:x	([BII)I
    //   1958: istore_2
    //   1959: iload_2
    //   1960: ifge -1148 -> 812
    //   1963: ldc_w 875
    //   1966: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1969: iload_2
    //   1970: ireturn
    //   1971: aload_0
    //   1972: getfield 147	com/tencent/mm/plugin/voip/model/e:BYo	[B
    //   1975: ifnonnull +11 -> 1986
    //   1978: aload_0
    //   1979: bipush 100
    //   1981: newarray byte
    //   1983: putfield 147	com/tencent/mm/plugin/voip/model/e:BYo	[B
    //   1986: aload_1
    //   1987: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   1990: bipush 100
    //   1992: if_icmple +326 -> 2318
    //   1995: bipush 100
    //   1997: istore_2
    //   1998: aload 15
    //   2000: iconst_0
    //   2001: aload_0
    //   2002: getfield 147	com/tencent/mm/plugin/voip/model/e:BYo	[B
    //   2005: iconst_0
    //   2006: iload_2
    //   2007: invokestatic 849	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2010: aload_0
    //   2011: getfield 147	com/tencent/mm/plugin/voip/model/e:BYo	[B
    //   2014: invokestatic 769	com/tencent/mm/plugin/voip/model/e:by	([B)Ljava/util/ArrayList;
    //   2017: astore 16
    //   2019: iload_3
    //   2020: istore_2
    //   2021: aload 16
    //   2023: invokevirtual 774	java/util/ArrayList:size	()I
    //   2026: iconst_3
    //   2027: if_icmpne -273 -> 1754
    //   2030: iload_3
    //   2031: istore_2
    //   2032: aload_0
    //   2033: getfield 139	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   2036: ldc_w 447
    //   2039: invokevirtual 422	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2042: ifeq -288 -> 1754
    //   2045: aload 16
    //   2047: iconst_0
    //   2048: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2051: checkcast 230	java/lang/Integer
    //   2054: invokevirtual 780	java/lang/Integer:intValue	()I
    //   2057: istore_3
    //   2058: aload 16
    //   2060: iconst_1
    //   2061: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2064: checkcast 230	java/lang/Integer
    //   2067: invokevirtual 780	java/lang/Integer:intValue	()I
    //   2070: istore 4
    //   2072: aload 16
    //   2074: iconst_2
    //   2075: invokevirtual 777	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2078: checkcast 230	java/lang/Integer
    //   2081: invokevirtual 780	java/lang/Integer:intValue	()I
    //   2084: istore_2
    //   2085: iload 4
    //   2087: iload_3
    //   2088: isub
    //   2089: istore 5
    //   2091: iload_2
    //   2092: iload 4
    //   2094: isub
    //   2095: istore 7
    //   2097: ldc 246
    //   2099: ldc_w 897
    //   2102: iconst_5
    //   2103: anewarray 4	java/lang/Object
    //   2106: dup
    //   2107: iconst_0
    //   2108: iload_3
    //   2109: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2112: aastore
    //   2113: dup
    //   2114: iconst_1
    //   2115: iload 4
    //   2117: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2120: aastore
    //   2121: dup
    //   2122: iconst_2
    //   2123: iload_2
    //   2124: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2127: aastore
    //   2128: dup
    //   2129: iconst_3
    //   2130: iload 5
    //   2132: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2135: aastore
    //   2136: dup
    //   2137: iconst_4
    //   2138: iload 7
    //   2140: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2143: aastore
    //   2144: invokestatic 899	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2147: aload_0
    //   2148: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   2151: arraylength
    //   2152: iload 5
    //   2154: iload 7
    //   2156: iadd
    //   2157: if_icmpge +14 -> 2171
    //   2160: aload_0
    //   2161: iload 5
    //   2163: iload 7
    //   2165: iadd
    //   2166: newarray byte
    //   2168: putfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   2171: aload 15
    //   2173: iload_3
    //   2174: aload_0
    //   2175: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   2178: iconst_0
    //   2179: iload 5
    //   2181: invokestatic 849	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2184: aload 15
    //   2186: iload 7
    //   2188: aload_0
    //   2189: getfield 145	com/tencent/mm/plugin/voip/model/e:BYn	[B
    //   2192: iload 5
    //   2194: iload 7
    //   2196: invokestatic 849	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2199: new 771	com/tencent/mm/protocal/protobuf/bng
    //   2202: dup
    //   2203: invokespecial 772	com/tencent/mm/protocal/protobuf/bng:<init>	()V
    //   2206: astore 16
    //   2208: aload 16
    //   2210: iconst_4
    //   2211: putfield 814	com/tencent/mm/protocal/protobuf/bng:GHi	I
    //   2214: aload 16
    //   2216: aload 15
    //   2218: iload_3
    //   2219: iconst_4
    //   2220: iadd
    //   2221: iload 5
    //   2223: iconst_4
    //   2224: isub
    //   2225: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   2228: putfield 817	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   2231: aload 16
    //   2233: aload 15
    //   2235: iload 4
    //   2237: iconst_4
    //   2238: iadd
    //   2239: iload 7
    //   2241: iconst_4
    //   2242: isub
    //   2243: invokestatic 786	com/tencent/mm/bx/b:F	([BII)Lcom/tencent/mm/bx/b;
    //   2246: putfield 820	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   2249: aload 16
    //   2251: invokevirtual 823	com/tencent/mm/protocal/protobuf/bng:toByteArray	()[B
    //   2254: arraylength
    //   2255: istore_3
    //   2256: aload_0
    //   2257: aload 16
    //   2259: invokevirtual 823	com/tencent/mm/protocal/protobuf/bng:toByteArray	()[B
    //   2262: iconst_2
    //   2263: iload_3
    //   2264: invokespecial 825	com/tencent/mm/plugin/voip/model/e:x	([BII)I
    //   2267: pop
    //   2268: goto -514 -> 1754
    //   2271: astore_1
    //   2272: ldc 246
    //   2274: new 292	java/lang/StringBuilder
    //   2277: dup
    //   2278: ldc_w 294
    //   2281: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2284: aload_1
    //   2285: invokevirtual 300	java/lang/Exception:toString	()Ljava/lang/String;
    //   2288: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2294: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2297: aload_0
    //   2298: sipush 2004
    //   2301: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   2304: aload_0
    //   2305: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   2308: ineg
    //   2309: istore_2
    //   2310: ldc_w 875
    //   2313: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2316: iload_2
    //   2317: ireturn
    //   2318: aload_1
    //   2319: getfield 761	android/media/MediaCodec$BufferInfo:size	I
    //   2322: istore_2
    //   2323: goto -325 -> 1998
    //   2326: aload_0
    //   2327: getfield 176	com/tencent/mm/plugin/voip/model/e:oWJ	I
    //   2330: istore_3
    //   2331: aload_0
    //   2332: iload_3
    //   2333: iconst_1
    //   2334: iadd
    //   2335: putfield 176	com/tencent/mm/plugin/voip/model/e:oWJ	I
    //   2338: iload_3
    //   2339: iconst_5
    //   2340: if_icmple -30 -> 2310
    //   2343: aload_0
    //   2344: sipush 2006
    //   2347: putfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   2350: aload_0
    //   2351: getfield 135	com/tencent/mm/plugin/voip/model/e:oWy	I
    //   2354: ineg
    //   2355: istore_2
    //   2356: goto -46 -> 2310
    //   2359: iconst_0
    //   2360: istore_2
    //   2361: aload 13
    //   2363: astore_1
    //   2364: goto -1921 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2367	0	this	e
    //   0	2367	1	paramArrayOfByte	byte[]
    //   0	2367	2	paramInt1	int
    //   0	2367	3	paramInt2	int
    //   0	2367	4	paramInt3	int
    //   957	1268	5	i	int
    //   631	255	6	j	int
    //   1002	1241	7	k	int
    //   1042	321	8	m	int
    //   951	414	9	n	int
    //   954	407	10	i1	int
    //   462	1387	11	l	long
    //   7	1	13	localObject1	Object
    //   364	15	13	localException1	Exception
    //   528	1	13	arrayOfByteBuffer	ByteBuffer[]
    //   779	1583	13	localException2	Exception
    //   519	380	14	localObject2	Object
    //   896	1338	15	arrayOfByte	byte[]
    //   939	1319	16	localObject3	Object
    //   948	506	17	localbng	com.tencent.mm.protocal.protobuf.bng
    // Exception table:
    //   from	to	target	type
    //   326	331	364	java/lang/Exception
    //   425	441	779	java/lang/Exception
    //   1284	1289	1371	java/lang/Exception
    //   1553	1558	1566	java/lang/Exception
    //   454	541	2271	java/lang/Exception
    //   545	555	2271	java/lang/Exception
    //   561	604	2271	java/lang/Exception
    //   604	627	2271	java/lang/Exception
    //   640	665	2271	java/lang/Exception
    //   671	682	2271	java/lang/Exception
    //   688	768	2271	java/lang/Exception
    //   812	819	2271	java/lang/Exception
    //   824	838	2271	java/lang/Exception
    //   838	876	2271	java/lang/Exception
    //   890	926	2271	java/lang/Exception
    //   926	950	2271	java/lang/Exception
    //   966	1035	2271	java/lang/Exception
    //   1052	1073	2271	java/lang/Exception
    //   1073	1090	2271	java/lang/Exception
    //   1090	1119	2271	java/lang/Exception
    //   1119	1134	2271	java/lang/Exception
    //   1134	1284	2271	java/lang/Exception
    //   1305	1345	2271	java/lang/Exception
    //   1353	1360	2271	java/lang/Exception
    //   1372	1410	2271	java/lang/Exception
    //   1413	1467	2271	java/lang/Exception
    //   1479	1553	2271	java/lang/Exception
    //   1567	1605	2271	java/lang/Exception
    //   1608	1674	2271	java/lang/Exception
    //   1686	1754	2271	java/lang/Exception
    //   1754	1959	2271	java/lang/Exception
    //   1971	1986	2271	java/lang/Exception
    //   1986	1995	2271	java/lang/Exception
    //   1998	2019	2271	java/lang/Exception
    //   2021	2030	2271	java/lang/Exception
    //   2032	2085	2271	java/lang/Exception
    //   2097	2171	2271	java/lang/Exception
    //   2171	2268	2271	java/lang/Exception
    //   2318	2323	2271	java/lang/Exception
  }
  
  public final void dpf()
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
      if (this.oWE != null)
      {
        this.oWE.flush();
        this.oWE.close();
      }
      if (this.oWB != null)
      {
        this.oWB.stop();
        this.oWB.release();
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
  
  public final void ftp()
  {
    AppMethodBeat.i(221682);
    if (this.BXC.CaI.setAppCmd(EMethodGetQosPara, this.BYq.s2p, this.BYq.s2p.length) >= 0)
    {
      Object localObject = this.BYq;
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
      ((a)localObject).BYr = localByteBuffer.getShort();
      ((a)localObject).BYs = localByteBuffer.getShort();
      localObject = this.BYq;
      ad.i("MeidaCodec[HWEnc]", "raw S2P:" + ((a)localObject).s2p);
      ad.i("MeidaCodec[HWEnc]", "-S2P- iKbps:" + ((a)localObject).iKbps + ", fps:" + ((a)localObject).cFps + ", IP:" + ((a)localObject).cIPeriod + ", RS:" + ((a)localObject).cRSLevel + ", QPMin:" + ((a)localObject).cQPmin + ", QPMax:" + ((a)localObject).cQPmax + ", HPP:" + ((a)localObject).cHPPMaxLyr + ", SWitch:" + ((a)localObject).cSwitch + ", Reso:" + ((a)localObject).cResolution + ", Rsvd1:" + ((a)localObject).cRsvd1 + ", Rsvd2:" + ((a)localObject).cRsvd2 + ", Skip:" + ((a)localObject).cSkipFlag + ", IReq:" + ((a)localObject).cIReqFlag + ", iEncW:" + ((a)localObject).BYr + ", iEncH:" + ((a)localObject).BYs);
      localObject = com.tencent.mm.plugin.voip.b.d.Clj;
      com.tencent.mm.plugin.voip.b.d.dQ(this.BYq.BYr, this.BYq.BYs);
    }
    AppMethodBeat.o(221682);
  }
  
  final class a
  {
    public short BYr;
    public short BYs;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.e
 * JD-Core Version:    0.7.0.1
 */