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
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.protocal.protobuf.caq;
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
  public static int GTO;
  public static short[] SizeFormat2WH;
  public static int VFMT_HEVC_HW;
  public static int VFMT_i264;
  public static int frameID;
  private static String path;
  private static int streamqueuesize;
  public static final String[] supportedH264HwCodecPrefixes;
  public String ENCODING;
  l GSZ;
  private byte[] GTK;
  private byte[] GTL;
  private ByteBuffer GTM;
  a GTN;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public long igB;
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
  private BufferedOutputStream outputStream;
  public int qsb;
  private z qsc;
  private byte[] qsd;
  private MediaMuxer qse;
  private int qsf;
  private boolean qsg;
  private BufferedOutputStream qsh;
  g qsi;
  public int qsj;
  public int qsk;
  public int qsl;
  public int qsm;
  public LinkedList<caq> zLK;
  public LinkedList<Integer> zLL;
  public int zLM;
  
  static
  {
    AppMethodBeat.i(177015);
    streamqueuesize = 100;
    frameID = 0;
    path = b.aKJ();
    VFMT_i264 = 18;
    VFMT_HEVC_HW = 19;
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK", "OMX.sprd" };
    GTO = 60;
    EMethodGetQosPara = 25;
    AppMethodBeat.o(177015);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    AppMethodBeat.i(114837);
    this.qsb = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.GTK = null;
    this.GTL = null;
    this.qsd = null;
    this.GTM = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.igB = 0L;
    this.GSZ = null;
    this.zLK = new LinkedList();
    this.zLL = new LinkedList();
    this.qsi = null;
    this.qsj = 0;
    this.qsk = 8;
    this.qsl = 0;
    this.qsm = 0;
    this.zLM = 0;
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
    this.GTN = new a();
    this.qsc = null;
    this.qsk = 8;
    this.qsj = 0;
    this.qsl = 0;
    this.qsb = 0;
    paramString = new caq();
    paramString.MfO = 1L;
    paramString.MfP = 24;
    paramString.MfQ = 1L;
    paramString.MfR = 24;
    paramString.MfS = 0L;
    paramString.MfT = 0;
    this.zLK.add(paramString);
    this.zLL.add(Integer.valueOf(0));
    this.qsd = null;
    this.GTM = null;
    this.qsm = 0;
    this.zLM = 0;
    this.igB = 0L;
    AppMethodBeat.o(114837);
  }
  
  private int I(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114844);
    if ((paramArrayOfByte != null) && (this.GSZ.GVV != null))
    {
      int i = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = VFMT_HEVC_HW;
      }
      i = this.GSZ.GVV.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
      if (i >= 0)
      {
        this.zLM = 0;
        Log.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114844);
      return paramInt1;
      paramInt1 = this.zLM;
      this.zLM = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.qsb = 2008;
        paramInt1 = -this.qsb;
        Log.e("MeidaCodec[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(paramInt1)));
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
      if (this.qsc != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        Log.v("MeidaCodec[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.qsc.setParameters(localBundle);
        AppMethodBeat.o(114843);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MeidaCodec[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
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
      if (this.qsc != null)
      {
        this.qsc.stop();
        this.qsc.release();
      }
      AppMethodBeat.o(114838);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
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
          Log.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
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
      if (8 <= this.qsk)
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
                Log.i("MeidaCodec[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.qsk + ", MIME:" + paramString);
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
    if (d.oD(23))
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
          Log.e("MeidaCodec[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
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
        Log.i("MeidaCodec[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      Log.i("MeidaCodec[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
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
  
  private static String bO(byte[] paramArrayOfByte)
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
  
  private static ArrayList<Integer> bS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114841);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = bO(paramArrayOfByte);
    String str = bO(new byte[] { 0, 0, 0, 1 });
    Log.d("MeidaCodec[HWEnc]", "parent: " + paramArrayOfByte + ", child:" + str);
    for (;;)
    {
      int j = paramArrayOfByte.indexOf(str, i);
      if (j == -1) {
        break;
      }
      Log.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + j);
      i = str.length() + j;
      localArrayList.add(Integer.valueOf(j / 2));
    }
    AppMethodBeat.o(114841);
    return localArrayList;
  }
  
  private long computePresentationTime(long paramLong)
  {
    AppMethodBeat.i(235483);
    int i = Math.min(Math.max(this.m_framerate, 15), 30);
    if ((paramLong == 0L) || (this.igB == 0L)) {}
    for (this.igB = 132L;; this.igB = (1000000 / i + paramLong))
    {
      paramLong = this.igB;
      AppMethodBeat.o(235483);
      return paramLong;
      paramLong = this.igB;
    }
  }
  
  @SuppressLint({"NewApi"})
  private int cyY()
  {
    AppMethodBeat.i(114836);
    if (this.qsc != null) {
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
                Log.i("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(str2)));
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
      Log.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.qsb = 2001;
      i = -this.qsb;
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
    Log.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 4);
    str1 = this.mediaFormat.getString("mime");
    this.qsj = 1;
    label394:
    boolean bool;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.oD(23)))
    {
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x1) == 0)) {
        break label561;
      }
      i = 1;
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x4) == 0)) {
        break label566;
      }
      j = 1;
      bool = a(localMediaCodecInfo, str1);
      if ((j == 0) || (!bool)) {
        break label571;
      }
      this.mediaFormat.setInteger("profile", 8);
      this.mediaFormat.setInteger("level", 256);
      bool = true;
    }
    for (;;)
    {
      label441:
      if (bool) {}
      for (this.qsj = this.mediaFormat.getInteger("profile");; this.qsj = 1)
      {
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try
        {
          this.qsc = z.q(str1, false);
          Log.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.qsj);
          this.qsc.a(this.mediaFormat, null, 1);
          this.qsc.start();
          this.qsi = new g();
          AppMethodBeat.o(114836);
          return 2000;
        }
        catch (Exception localException)
        {
          label561:
          Log.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
          this.qsb = 2002;
          i = -this.qsb;
          AppMethodBeat.o(114836);
          return i;
        }
        i = 0;
        break;
        label566:
        j = 0;
        break label394;
        label571:
        if (i != 0)
        {
          this.mediaFormat.setInteger("profile", 1);
          this.mediaFormat.setInteger("level", 256);
          bool = true;
          break label441;
        }
        if (localMediaCodecInfo == null) {
          break label685;
        }
        bool = a(localMediaCodecInfo, str1, this.qsk);
        break label441;
      }
      label685:
      bool = false;
    }
  }
  
  public final void DoQosSvrCtrl()
  {
    AppMethodBeat.i(235482);
    Object localObject;
    int k;
    if ((this.GSZ != null) && (this.GSZ.GVV != null))
    {
      if ((this.GSZ != null) && (this.GSZ.GVV != null) && (this.GSZ.GVV.setAppCmd(EMethodGetQosPara, this.GTN.s2p, this.GTN.s2p.length) >= 0))
      {
        localObject = this.GTN;
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
        ((a)localObject).GTP = localByteBuffer.getShort();
        ((a)localObject).GTQ = localByteBuffer.getShort();
        localObject = this.GTN;
        Log.i("MeidaCodec[HWEnc]", "raw S2P:" + ((a)localObject).s2p);
        Log.i("MeidaCodec[HWEnc]", "-S2P- iKbps:" + ((a)localObject).iKbps + ", fps:" + ((a)localObject).cFps + ", IP:" + ((a)localObject).cIPeriod + ", RS:" + ((a)localObject).cRSLevel + ", QPMin:" + ((a)localObject).cQPmin + ", QPMax:" + ((a)localObject).cQPmax + ", HPP:" + ((a)localObject).cHPPMaxLyr + ", SWitch:" + ((a)localObject).cSwitch + ", Reso:" + ((a)localObject).cResolution + ", Rsvd1:" + ((a)localObject).cRsvd1 + ", Rsvd2:" + ((a)localObject).cRsvd2 + ", Skip:" + ((a)localObject).cSkipFlag + ", IReq:" + ((a)localObject).cIReqFlag + ", iEncW:" + ((a)localObject).GTP + ", iEncH:" + ((a)localObject).GTQ);
        localObject = c.HgQ;
        c.ec(this.GTN.GTP, this.GTN.GTQ);
      }
      k = this.GTN.iKbps;
      if (this.qsj != 8) {
        break label796;
      }
    }
    label796:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (i == 0)
      {
        double d = Math.max(Math.min(this.GSZ.GVV.Hbr, 30), 0) * 1.0D / 100.0D;
        j = (int)(k * (d + 1.0D));
      }
      if (this.m_br_kbps != j)
      {
        SetBitRate(j);
        Log.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + j + ", tuneRatio:" + this.GSZ.GVV.Hbr);
        this.m_br_kbps = j;
      }
      if ((1 == this.GTN.cIReqFlag) && (frameID > 0))
      {
        if (this.qsc != null)
        {
          Log.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
          localObject = new Bundle();
          ((Bundle)localObject).putInt("request-sync", 0);
          this.qsc.setParameters((Bundle)localObject);
        }
        Log.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
      }
      if (this.GTN.cFps != this.m_framerate) {
        this.m_framerate = this.GTN.cFps;
      }
      AppMethodBeat.o(235482);
      return;
    }
  }
  
  /* Error */
  public final int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 704
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 14
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   22: if_icmpeq +33 -> 55
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   40: aload_0
    //   41: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   44: imul
    //   45: iconst_3
    //   46: imul
    //   47: iconst_2
    //   48: idiv
    //   49: invokestatic 708	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   52: putfield 154	com/tencent/mm/plugin/voip/model/e:GTM	Ljava/nio/ByteBuffer;
    //   55: aload_0
    //   56: getfield 154	com/tencent/mm/plugin/voip/model/e:GTM	Ljava/nio/ByteBuffer;
    //   59: ifnonnull +23 -> 82
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   67: aload_0
    //   68: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   71: imul
    //   72: iconst_3
    //   73: imul
    //   74: iconst_2
    //   75: idiv
    //   76: invokestatic 708	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   79: putfield 154	com/tencent/mm/plugin/voip/model/e:GTM	Ljava/nio/ByteBuffer;
    //   82: ldc_w 259
    //   85: new 261	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 710
    //   92: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 197	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   99: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 712
    //   105: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   112: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 204	com/tencent/mm/plugin/voip/model/e:GTN	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   125: getfield 630	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   128: ifne +2293 -> 2421
    //   131: aload_0
    //   132: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   135: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   138: ifnull +2283 -> 2421
    //   141: iload 5
    //   143: ifeq +235 -> 378
    //   146: invokestatic 718	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   149: lstore 12
    //   151: aload_0
    //   152: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   155: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   158: aload_1
    //   159: aload_1
    //   160: invokevirtual 721	java/nio/ByteBuffer:capacity	()I
    //   163: aload_0
    //   164: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   167: aload_0
    //   168: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   171: iload 4
    //   173: aload_0
    //   174: getfield 154	com/tencent/mm/plugin/voip/model/e:GTM	Ljava/nio/ByteBuffer;
    //   177: invokevirtual 725	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess2	(Ljava/nio/ByteBuffer;IIIILjava/nio/ByteBuffer;)I
    //   180: pop
    //   181: getstatic 731	com/tencent/mm/plugin/voip/video/render/i:HnR	Lcom/tencent/mm/plugin/voip/video/render/i;
    //   184: astore_1
    //   185: iconst_0
    //   186: lload 12
    //   188: invokestatic 734	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   191: invokestatic 738	com/tencent/mm/plugin/voip/video/render/i:aO	(IJ)V
    //   194: aload_0
    //   195: getfield 154	com/tencent/mm/plugin/voip/model/e:GTM	Ljava/nio/ByteBuffer;
    //   198: astore_1
    //   199: iload 5
    //   201: ifeq +180 -> 381
    //   204: aload_0
    //   205: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   208: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   211: getfield 741	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   214: istore 4
    //   216: iload 5
    //   218: ifeq +169 -> 387
    //   221: aload_0
    //   222: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   225: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   228: getfield 744	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   231: istore 6
    //   233: aload_0
    //   234: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   237: iload 4
    //   239: if_icmpne +12 -> 251
    //   242: aload_0
    //   243: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   246: iload 6
    //   248: if_icmpeq +190 -> 438
    //   251: ldc_w 259
    //   254: new 261	java/lang/StringBuilder
    //   257: dup
    //   258: ldc_w 746
    //   261: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: iload_2
    //   265: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: ldc_w 748
    //   271: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: iload_3
    //   275: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: ldc_w 750
    //   281: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   288: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 748
    //   294: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   301: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_0
    //   311: iload 4
    //   313: putfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   316: aload_0
    //   317: iload 6
    //   319: putfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   322: aload_0
    //   323: aload_0
    //   324: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   327: aload_0
    //   328: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   331: imul
    //   332: iconst_3
    //   333: imul
    //   334: iconst_1
    //   335: ishr
    //   336: putfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   339: aload_0
    //   340: invokespecial 752	com/tencent/mm/plugin/voip/model/e:cyY	()I
    //   343: istore_2
    //   344: iload_2
    //   345: istore_3
    //   346: iload_2
    //   347: ifge +93 -> 440
    //   350: ldc_w 259
    //   353: ldc_w 754
    //   356: iload_2
    //   357: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   360: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   363: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 757	com/tencent/mm/plugin/voip/model/e:emB	()V
    //   370: ldc_w 704
    //   373: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: iload_2
    //   377: ireturn
    //   378: goto -179 -> 199
    //   381: iload_2
    //   382: istore 4
    //   384: goto -168 -> 216
    //   387: iload_3
    //   388: istore 6
    //   390: goto -157 -> 233
    //   393: astore 14
    //   395: ldc_w 259
    //   398: new 261	java/lang/StringBuilder
    //   401: dup
    //   402: ldc_w 759
    //   405: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   408: aload 14
    //   410: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   413: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload_0
    //   423: sipush 2003
    //   426: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   429: aload_0
    //   430: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   433: ineg
    //   434: istore_2
    //   435: goto -91 -> 344
    //   438: iconst_0
    //   439: istore_3
    //   440: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   443: bipush 100
    //   445: if_icmpgt +411 -> 856
    //   448: aload_0
    //   449: getfield 761	com/tencent/mm/plugin/voip/model/e:qsh	Ljava/io/BufferedOutputStream;
    //   452: ifnull +404 -> 856
    //   455: aload_0
    //   456: getfield 761	com/tencent/mm/plugin/voip/model/e:qsh	Ljava/io/BufferedOutputStream;
    //   459: aload_0
    //   460: getfield 154	com/tencent/mm/plugin/voip/model/e:GTM	Ljava/nio/ByteBuffer;
    //   463: invokevirtual 765	java/nio/ByteBuffer:array	()[B
    //   466: iconst_0
    //   467: aload_0
    //   468: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   471: invokevirtual 771	java/io/BufferedOutputStream:write	([BII)V
    //   474: iload_3
    //   475: istore_2
    //   476: aload_1
    //   477: ifnull +1911 -> 2388
    //   480: aload_0
    //   481: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   484: ifnull +1904 -> 2388
    //   487: aload_0
    //   488: iconst_0
    //   489: putfield 179	com/tencent/mm/plugin/voip/model/e:qsm	I
    //   492: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   495: lstore 12
    //   497: ldc_w 259
    //   500: new 261	java/lang/StringBuilder
    //   503: dup
    //   504: ldc_w 778
    //   507: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   510: aload_0
    //   511: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   514: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: ldc_w 780
    //   520: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   526: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: ldc_w 782
    //   532: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: lload 12
    //   537: invokevirtual 785	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   540: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload_0
    //   547: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   550: invokevirtual 789	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   553: astore 15
    //   555: aload_0
    //   556: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   559: invokevirtual 792	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   562: astore 14
    //   564: aload_0
    //   565: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   568: ldc2_w 793
    //   571: invokevirtual 798	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   574: istore_3
    //   575: iload_3
    //   576: iflt +74 -> 650
    //   579: aload_0
    //   580: aload_0
    //   581: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   584: invokespecial 800	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   587: lstore 12
    //   589: aload_1
    //   590: invokevirtual 804	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   593: aload_0
    //   594: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   597: invokevirtual 810	java/nio/Buffer:limit	(I)Ljava/nio/Buffer;
    //   600: pop
    //   601: aload 15
    //   603: iload_3
    //   604: aaload
    //   605: astore 15
    //   607: aload 15
    //   609: invokevirtual 813	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   612: pop
    //   613: aload 15
    //   615: aload_1
    //   616: invokevirtual 817	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   619: pop
    //   620: aload_1
    //   621: invokevirtual 813	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   624: pop
    //   625: aload_0
    //   626: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   629: iload_3
    //   630: aload_0
    //   631: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   634: lload 12
    //   636: iconst_0
    //   637: invokevirtual 820	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   640: aload_0
    //   641: aload_0
    //   642: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   645: lconst_1
    //   646: ladd
    //   647: putfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   650: new 822	android/media/MediaCodec$BufferInfo
    //   653: dup
    //   654: invokespecial 823	android/media/MediaCodec$BufferInfo:<init>	()V
    //   657: astore_1
    //   658: aload_0
    //   659: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   662: aload_1
    //   663: aload_0
    //   664: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   667: i2l
    //   668: invokevirtual 827	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   671: istore 4
    //   673: iload_2
    //   674: istore_3
    //   675: iload 4
    //   677: istore 7
    //   679: iload 4
    //   681: bipush 254
    //   683: if_icmpne +242 -> 925
    //   686: aload_0
    //   687: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   690: invokevirtual 831	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   693: astore 15
    //   695: ldc_w 259
    //   698: ldc_w 833
    //   701: aload 15
    //   703: invokestatic 330	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   706: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   709: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: iload_2
    //   713: istore_3
    //   714: iload 4
    //   716: istore 7
    //   718: aload 15
    //   720: ldc_w 516
    //   723: invokevirtual 836	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   726: ifeq +199 -> 925
    //   729: iload_2
    //   730: istore_3
    //   731: iload 4
    //   733: istore 7
    //   735: aload 15
    //   737: ldc_w 516
    //   740: invokevirtual 535	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   743: i2d
    //   744: aload_0
    //   745: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   748: sipush 1000
    //   751: imul
    //   752: i2d
    //   753: ldc2_w 837
    //   756: dmul
    //   757: dcmpl
    //   758: ifle +167 -> 925
    //   761: ldc_w 259
    //   764: new 261	java/lang/StringBuilder
    //   767: dup
    //   768: ldc_w 840
    //   771: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   774: aload 15
    //   776: ldc_w 516
    //   779: invokevirtual 535	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   782: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   785: ldc_w 842
    //   788: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: aload_0
    //   792: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   795: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   798: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: aload_0
    //   805: sipush 2007
    //   808: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   811: aload_0
    //   812: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   815: istore_2
    //   816: iload_2
    //   817: ineg
    //   818: istore_2
    //   819: ldc_w 704
    //   822: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   825: iload_2
    //   826: ireturn
    //   827: astore 14
    //   829: ldc_w 259
    //   832: new 261	java/lang/StringBuilder
    //   835: dup
    //   836: ldc_w 341
    //   839: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   842: aload 14
    //   844: invokevirtual 342	java/lang/Exception:toString	()Ljava/lang/String;
    //   847: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   856: iload_3
    //   857: istore_2
    //   858: goto -382 -> 476
    //   861: aload_0
    //   862: getfield 844	com/tencent/mm/plugin/voip/model/e:qsg	Z
    //   865: ifeq +22 -> 887
    //   868: aload 15
    //   870: ifnull +17 -> 887
    //   873: aload_0
    //   874: getfield 846	com/tencent/mm/plugin/voip/model/e:qse	Landroid/media/MediaMuxer;
    //   877: aload_0
    //   878: getfield 848	com/tencent/mm/plugin/voip/model/e:qsf	I
    //   881: aload 15
    //   883: aload_1
    //   884: invokevirtual 854	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   887: aload_1
    //   888: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   891: istore_3
    //   892: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   895: iconst_1
    //   896: iadd
    //   897: putstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   900: aload_0
    //   901: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   904: iload 7
    //   906: iconst_0
    //   907: invokevirtual 861	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   910: aload_0
    //   911: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   914: aload_1
    //   915: aload_0
    //   916: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   919: i2l
    //   920: invokevirtual 827	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   923: istore 7
    //   925: iload_3
    //   926: istore_2
    //   927: iload 7
    //   929: iflt +1443 -> 2372
    //   932: aload 14
    //   934: iload 7
    //   936: aaload
    //   937: astore 15
    //   939: aload_1
    //   940: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   943: newarray byte
    //   945: astore 16
    //   947: aload 15
    //   949: aload 16
    //   951: invokevirtual 866	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   954: pop
    //   955: aload_0
    //   956: getfield 868	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   959: ifnull +16 -> 975
    //   962: aload_0
    //   963: getfield 868	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   966: aload 16
    //   968: iconst_0
    //   969: aload 16
    //   971: arraylength
    //   972: invokevirtual 771	java/io/BufferedOutputStream:write	([BII)V
    //   975: aload_1
    //   976: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   979: iconst_2
    //   980: if_icmpne +554 -> 1534
    //   983: aload 16
    //   985: invokestatic 870	com/tencent/mm/plugin/voip/model/e:bS	([B)Ljava/util/ArrayList;
    //   988: astore 17
    //   990: new 872	com/tencent/mm/protocal/protobuf/cap
    //   993: dup
    //   994: invokespecial 873	com/tencent/mm/protocal/protobuf/cap:<init>	()V
    //   997: astore 18
    //   999: iconst_0
    //   1000: istore 10
    //   1002: iconst_0
    //   1003: istore 11
    //   1005: iconst_0
    //   1006: istore 4
    //   1008: iconst_0
    //   1009: istore_2
    //   1010: iconst_0
    //   1011: istore 6
    //   1013: iconst_0
    //   1014: istore_3
    //   1015: aload 17
    //   1017: invokevirtual 875	java/util/ArrayList:size	()I
    //   1020: iconst_3
    //   1021: if_icmpne +328 -> 1349
    //   1024: aload_0
    //   1025: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1028: ldc 247
    //   1030: invokevirtual 251	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1033: ifeq +316 -> 1349
    //   1036: aload 17
    //   1038: iconst_0
    //   1039: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1042: checkcast 233	java/lang/Integer
    //   1045: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1048: iconst_4
    //   1049: iadd
    //   1050: istore 8
    //   1052: aload 17
    //   1054: iconst_1
    //   1055: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1058: checkcast 233	java/lang/Integer
    //   1061: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1064: iconst_4
    //   1065: iadd
    //   1066: istore 4
    //   1068: aload 17
    //   1070: iconst_2
    //   1071: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1074: checkcast 233	java/lang/Integer
    //   1077: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1080: iconst_4
    //   1081: iadd
    //   1082: istore 6
    //   1084: iload 4
    //   1086: iload 8
    //   1088: isub
    //   1089: iconst_4
    //   1090: isub
    //   1091: istore 9
    //   1093: iload 6
    //   1095: iload 4
    //   1097: isub
    //   1098: iconst_4
    //   1099: isub
    //   1100: istore_2
    //   1101: aload_1
    //   1102: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1105: iload 6
    //   1107: isub
    //   1108: istore_3
    //   1109: aload 18
    //   1111: aload 16
    //   1113: iload 8
    //   1115: iload 9
    //   1117: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1120: putfield 891	com/tencent/mm/protocal/protobuf/cap:MfN	Lcom/tencent/mm/bw/b;
    //   1123: aload_0
    //   1124: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1127: ifnonnull +13 -> 1140
    //   1130: aload_0
    //   1131: aload_1
    //   1132: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1135: newarray byte
    //   1137: putfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1140: aload_0
    //   1141: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1144: ifnull +40 -> 1184
    //   1147: aload_1
    //   1148: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1151: aload_0
    //   1152: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1155: arraylength
    //   1156: if_icmple +13 -> 1169
    //   1159: aload_0
    //   1160: aload_1
    //   1161: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1164: newarray byte
    //   1166: putfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1169: aload 16
    //   1171: iconst_0
    //   1172: aload_0
    //   1173: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1176: iconst_0
    //   1177: aload_1
    //   1178: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1181: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1184: ldc_w 259
    //   1187: new 261	java/lang/StringBuilder
    //   1190: dup
    //   1191: ldc_w 897
    //   1194: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1197: iload 4
    //   1199: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1202: ldc_w 899
    //   1205: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: iload_2
    //   1209: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1212: ldc_w 901
    //   1215: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: iload 6
    //   1220: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1223: ldc_w 899
    //   1226: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: iload_3
    //   1230: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1233: ldc_w 903
    //   1236: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: iload 8
    //   1241: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: ldc_w 899
    //   1247: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: iload 9
    //   1252: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1255: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1258: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1261: aload_0
    //   1262: getfield 173	com/tencent/mm/plugin/voip/model/e:qsj	I
    //   1265: iconst_1
    //   1266: if_icmpeq +202 -> 1468
    //   1269: aload_0
    //   1270: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1273: aload 16
    //   1275: invokevirtual 907	com/tencent/mm/plugin/voip/model/g:cg	([B)Z
    //   1278: ifeq +190 -> 1468
    //   1281: aload_0
    //   1282: aload_0
    //   1283: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1286: getfield 910	com/tencent/mm/plugin/voip/model/g:GTT	I
    //   1289: putfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1292: aload_0
    //   1293: iconst_1
    //   1294: putfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1297: ldc_w 259
    //   1300: new 261	java/lang/StringBuilder
    //   1303: dup
    //   1304: ldc_w 912
    //   1307: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1310: aload_0
    //   1311: getfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1314: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: ldc_w 914
    //   1320: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload_0
    //   1324: getfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1327: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1330: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1336: aload_0
    //   1337: invokespecial 752	com/tencent/mm/plugin/voip/model/e:cyY	()I
    //   1340: istore_2
    //   1341: ldc_w 704
    //   1344: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1347: iload_2
    //   1348: ireturn
    //   1349: iload 11
    //   1351: istore 9
    //   1353: iload 10
    //   1355: istore 8
    //   1357: aload 17
    //   1359: invokevirtual 875	java/util/ArrayList:size	()I
    //   1362: iconst_2
    //   1363: if_icmpne -240 -> 1123
    //   1366: aload 17
    //   1368: iconst_0
    //   1369: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1372: checkcast 233	java/lang/Integer
    //   1375: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1378: iconst_4
    //   1379: iadd
    //   1380: istore 4
    //   1382: aload 17
    //   1384: iconst_1
    //   1385: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1388: checkcast 233	java/lang/Integer
    //   1391: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1394: iconst_4
    //   1395: iadd
    //   1396: istore 6
    //   1398: iload 6
    //   1400: iload 4
    //   1402: isub
    //   1403: iconst_4
    //   1404: isub
    //   1405: istore_2
    //   1406: aload_1
    //   1407: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1410: iload 6
    //   1412: isub
    //   1413: istore_3
    //   1414: iload 11
    //   1416: istore 9
    //   1418: iload 10
    //   1420: istore 8
    //   1422: goto -299 -> 1123
    //   1425: astore_1
    //   1426: ldc_w 259
    //   1429: new 261	java/lang/StringBuilder
    //   1432: dup
    //   1433: ldc_w 916
    //   1436: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1439: aload_1
    //   1440: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1443: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1449: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1452: aload_0
    //   1453: sipush 2005
    //   1456: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1459: aload_0
    //   1460: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1463: ineg
    //   1464: istore_2
    //   1465: goto -124 -> 1341
    //   1468: aload 18
    //   1470: iconst_4
    //   1471: putfield 919	com/tencent/mm/protocal/protobuf/cap:MfK	I
    //   1474: aload 18
    //   1476: aload 16
    //   1478: iload 4
    //   1480: iload_2
    //   1481: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1484: putfield 922	com/tencent/mm/protocal/protobuf/cap:MfL	Lcom/tencent/mm/bw/b;
    //   1487: aload 18
    //   1489: aload 16
    //   1491: iload 6
    //   1493: iload_3
    //   1494: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1497: putfield 925	com/tencent/mm/protocal/protobuf/cap:MfM	Lcom/tencent/mm/bw/b;
    //   1500: aload 18
    //   1502: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   1505: arraylength
    //   1506: istore_2
    //   1507: aload_0
    //   1508: aload 18
    //   1510: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   1513: aload_1
    //   1514: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1517: iload_2
    //   1518: invokespecial 930	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   1521: istore_2
    //   1522: iload_2
    //   1523: ifge -662 -> 861
    //   1526: ldc_w 704
    //   1529: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1532: iload_2
    //   1533: ireturn
    //   1534: aload_0
    //   1535: getfield 173	com/tencent/mm/plugin/voip/model/e:qsj	I
    //   1538: iconst_1
    //   1539: if_icmpeq +126 -> 1665
    //   1542: aload_0
    //   1543: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1546: aload 16
    //   1548: invokevirtual 933	com/tencent/mm/plugin/voip/model/g:ch	([B)Z
    //   1551: ifeq +114 -> 1665
    //   1554: aload_0
    //   1555: aload_0
    //   1556: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1559: getfield 910	com/tencent/mm/plugin/voip/model/g:GTT	I
    //   1562: putfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1565: aload_0
    //   1566: iconst_1
    //   1567: putfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1570: ldc_w 259
    //   1573: new 261	java/lang/StringBuilder
    //   1576: dup
    //   1577: ldc_w 912
    //   1580: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1583: aload_0
    //   1584: getfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1587: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1590: ldc_w 914
    //   1593: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: aload_0
    //   1597: getfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1600: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1603: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1606: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1609: aload_0
    //   1610: invokespecial 752	com/tencent/mm/plugin/voip/model/e:cyY	()I
    //   1613: istore_2
    //   1614: ldc_w 704
    //   1617: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1620: iload_2
    //   1621: ireturn
    //   1622: astore_1
    //   1623: ldc_w 259
    //   1626: new 261	java/lang/StringBuilder
    //   1629: dup
    //   1630: ldc_w 916
    //   1633: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1636: aload_1
    //   1637: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1640: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1646: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1649: aload_0
    //   1650: sipush 2005
    //   1653: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1656: aload_0
    //   1657: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1660: ineg
    //   1661: istore_2
    //   1662: goto -48 -> 1614
    //   1665: aload_1
    //   1666: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1669: ifeq +71 -> 1740
    //   1672: aload_1
    //   1673: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1676: iconst_1
    //   1677: if_icmpeq +63 -> 1740
    //   1680: aload_0
    //   1681: sipush 2009
    //   1684: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1687: aload_0
    //   1688: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1691: ineg
    //   1692: istore_2
    //   1693: ldc_w 259
    //   1696: new 261	java/lang/StringBuilder
    //   1699: dup
    //   1700: ldc_w 935
    //   1703: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1706: aload_1
    //   1707: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1710: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1713: ldc_w 899
    //   1716: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: aload_1
    //   1720: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1723: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1729: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1732: ldc_w 704
    //   1735: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1738: iload_2
    //   1739: ireturn
    //   1740: iconst_0
    //   1741: istore_3
    //   1742: iload_3
    //   1743: istore_2
    //   1744: aload_1
    //   1745: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1748: iconst_1
    //   1749: if_icmpne +64 -> 1813
    //   1752: aload_0
    //   1753: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1756: arraylength
    //   1757: newarray byte
    //   1759: astore 17
    //   1761: aload 16
    //   1763: iconst_0
    //   1764: aload 17
    //   1766: iconst_0
    //   1767: aload_0
    //   1768: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1771: arraylength
    //   1772: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1775: aload 17
    //   1777: aload_0
    //   1778: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1781: invokestatic 941	java/util/Arrays:equals	([B[B)Z
    //   1784: ifeq +247 -> 2031
    //   1787: aload_0
    //   1788: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1791: arraylength
    //   1792: istore_2
    //   1793: ldc_w 259
    //   1796: ldc_w 943
    //   1799: iconst_1
    //   1800: anewarray 4	java/lang/Object
    //   1803: dup
    //   1804: iconst_0
    //   1805: iload_2
    //   1806: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1809: aastore
    //   1810: invokestatic 946	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1813: iconst_4
    //   1814: invokestatic 949	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1817: astore 17
    //   1819: aload 17
    //   1821: aload_1
    //   1822: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1825: iconst_4
    //   1826: isub
    //   1827: iload_2
    //   1828: isub
    //   1829: invokevirtual 951	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1832: pop
    //   1833: aload 17
    //   1835: getstatic 954	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1838: invokevirtual 584	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1841: invokevirtual 765	java/nio/ByteBuffer:array	()[B
    //   1844: iconst_0
    //   1845: aload 16
    //   1847: iload_2
    //   1848: iconst_4
    //   1849: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1852: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   1855: lstore 12
    //   1857: ldc_w 259
    //   1860: new 261	java/lang/StringBuilder
    //   1863: dup
    //   1864: ldc_w 956
    //   1867: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1870: aload_1
    //   1871: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1874: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1877: ldc_w 958
    //   1880: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: aload_1
    //   1884: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1887: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1890: ldc_w 780
    //   1893: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   1899: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1902: ldc_w 782
    //   1905: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: lload 12
    //   1910: invokevirtual 785	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1913: ldc_w 960
    //   1916: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: iload_2
    //   1920: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1923: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1926: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1929: new 962	com/tencent/mm/protocal/protobuf/cao
    //   1932: dup
    //   1933: invokespecial 963	com/tencent/mm/protocal/protobuf/cao:<init>	()V
    //   1936: astore 17
    //   1938: aload 17
    //   1940: aload 16
    //   1942: iload_2
    //   1943: aload_1
    //   1944: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1947: iload_2
    //   1948: isub
    //   1949: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1952: putfield 966	com/tencent/mm/protocal/protobuf/cao:MfG	Lcom/tencent/mm/bw/b;
    //   1955: aload 17
    //   1957: iconst_1
    //   1958: putfield 969	com/tencent/mm/protocal/protobuf/cao:MfH	I
    //   1961: aload 17
    //   1963: aload_0
    //   1964: getfield 167	com/tencent/mm/plugin/voip/model/e:zLK	Ljava/util/LinkedList;
    //   1967: putfield 972	com/tencent/mm/protocal/protobuf/cao:MfI	Ljava/util/LinkedList;
    //   1970: aload_0
    //   1971: getfield 169	com/tencent/mm/plugin/voip/model/e:zLL	Ljava/util/LinkedList;
    //   1974: iconst_0
    //   1975: aload_1
    //   1976: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1979: iload_2
    //   1980: isub
    //   1981: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1984: invokevirtual 976	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1987: pop
    //   1988: aload 17
    //   1990: aload_0
    //   1991: getfield 169	com/tencent/mm/plugin/voip/model/e:zLL	Ljava/util/LinkedList;
    //   1994: putfield 979	com/tencent/mm/protocal/protobuf/cao:MfJ	Ljava/util/LinkedList;
    //   1997: aload 17
    //   1999: invokevirtual 980	com/tencent/mm/protocal/protobuf/cao:toByteArray	()[B
    //   2002: arraylength
    //   2003: istore_2
    //   2004: aload_0
    //   2005: aload 17
    //   2007: invokevirtual 980	com/tencent/mm/protocal/protobuf/cao:toByteArray	()[B
    //   2010: aload_1
    //   2011: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   2014: iload_2
    //   2015: invokespecial 930	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   2018: istore_2
    //   2019: iload_2
    //   2020: ifge -1159 -> 861
    //   2023: ldc_w 704
    //   2026: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2029: iload_2
    //   2030: ireturn
    //   2031: aload_0
    //   2032: getfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   2035: ifnonnull +11 -> 2046
    //   2038: aload_0
    //   2039: bipush 100
    //   2041: newarray byte
    //   2043: putfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   2046: aload_1
    //   2047: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   2050: bipush 100
    //   2052: if_icmple +328 -> 2380
    //   2055: bipush 100
    //   2057: istore_2
    //   2058: aload 16
    //   2060: iconst_0
    //   2061: aload_0
    //   2062: getfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   2065: iconst_0
    //   2066: iload_2
    //   2067: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2070: aload_0
    //   2071: getfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   2074: invokestatic 870	com/tencent/mm/plugin/voip/model/e:bS	([B)Ljava/util/ArrayList;
    //   2077: astore 17
    //   2079: iload_3
    //   2080: istore_2
    //   2081: aload 17
    //   2083: invokevirtual 875	java/util/ArrayList:size	()I
    //   2086: iconst_3
    //   2087: if_icmpne -274 -> 1813
    //   2090: iload_3
    //   2091: istore_2
    //   2092: aload_0
    //   2093: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   2096: ldc_w 527
    //   2099: invokevirtual 251	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2102: ifeq -289 -> 1813
    //   2105: aload 17
    //   2107: iconst_0
    //   2108: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2111: checkcast 233	java/lang/Integer
    //   2114: invokevirtual 881	java/lang/Integer:intValue	()I
    //   2117: istore_3
    //   2118: aload 17
    //   2120: iconst_1
    //   2121: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2124: checkcast 233	java/lang/Integer
    //   2127: invokevirtual 881	java/lang/Integer:intValue	()I
    //   2130: istore 4
    //   2132: aload 17
    //   2134: iconst_2
    //   2135: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2138: checkcast 233	java/lang/Integer
    //   2141: invokevirtual 881	java/lang/Integer:intValue	()I
    //   2144: istore_2
    //   2145: iload 4
    //   2147: iload_3
    //   2148: isub
    //   2149: istore 6
    //   2151: iload_2
    //   2152: iload 4
    //   2154: isub
    //   2155: istore 8
    //   2157: ldc_w 259
    //   2160: ldc_w 982
    //   2163: iconst_5
    //   2164: anewarray 4	java/lang/Object
    //   2167: dup
    //   2168: iconst_0
    //   2169: iload_3
    //   2170: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2173: aastore
    //   2174: dup
    //   2175: iconst_1
    //   2176: iload 4
    //   2178: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2181: aastore
    //   2182: dup
    //   2183: iconst_2
    //   2184: iload_2
    //   2185: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2188: aastore
    //   2189: dup
    //   2190: iconst_3
    //   2191: iload 6
    //   2193: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2196: aastore
    //   2197: dup
    //   2198: iconst_4
    //   2199: iload 8
    //   2201: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2204: aastore
    //   2205: invokestatic 984	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2208: aload_0
    //   2209: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2212: arraylength
    //   2213: iload 6
    //   2215: iload 8
    //   2217: iadd
    //   2218: if_icmpge +14 -> 2232
    //   2221: aload_0
    //   2222: iload 6
    //   2224: iload 8
    //   2226: iadd
    //   2227: newarray byte
    //   2229: putfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2232: aload 16
    //   2234: iload_3
    //   2235: aload_0
    //   2236: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2239: iconst_0
    //   2240: iload 6
    //   2242: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2245: aload 16
    //   2247: iload 8
    //   2249: aload_0
    //   2250: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2253: iload 6
    //   2255: iload 8
    //   2257: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2260: new 872	com/tencent/mm/protocal/protobuf/cap
    //   2263: dup
    //   2264: invokespecial 873	com/tencent/mm/protocal/protobuf/cap:<init>	()V
    //   2267: astore 17
    //   2269: aload 17
    //   2271: iconst_4
    //   2272: putfield 919	com/tencent/mm/protocal/protobuf/cap:MfK	I
    //   2275: aload 17
    //   2277: aload 16
    //   2279: iload_3
    //   2280: iconst_4
    //   2281: iadd
    //   2282: iload 6
    //   2284: iconst_4
    //   2285: isub
    //   2286: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   2289: putfield 922	com/tencent/mm/protocal/protobuf/cap:MfL	Lcom/tencent/mm/bw/b;
    //   2292: aload 17
    //   2294: aload 16
    //   2296: iload 4
    //   2298: iconst_4
    //   2299: iadd
    //   2300: iload 8
    //   2302: iconst_4
    //   2303: isub
    //   2304: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   2307: putfield 925	com/tencent/mm/protocal/protobuf/cap:MfM	Lcom/tencent/mm/bw/b;
    //   2310: aload 17
    //   2312: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   2315: arraylength
    //   2316: istore_3
    //   2317: aload_0
    //   2318: aload 17
    //   2320: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   2323: iconst_2
    //   2324: iload_3
    //   2325: invokespecial 930	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   2328: pop
    //   2329: goto -516 -> 1813
    //   2332: astore_1
    //   2333: ldc_w 259
    //   2336: new 261	java/lang/StringBuilder
    //   2339: dup
    //   2340: ldc_w 341
    //   2343: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2346: aload_1
    //   2347: invokevirtual 342	java/lang/Exception:toString	()Ljava/lang/String;
    //   2350: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2353: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2356: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2359: aload_0
    //   2360: sipush 2004
    //   2363: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2366: aload_0
    //   2367: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2370: ineg
    //   2371: istore_2
    //   2372: ldc_w 704
    //   2375: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2378: iload_2
    //   2379: ireturn
    //   2380: aload_1
    //   2381: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   2384: istore_2
    //   2385: goto -327 -> 2058
    //   2388: aload_0
    //   2389: getfield 179	com/tencent/mm/plugin/voip/model/e:qsm	I
    //   2392: istore_3
    //   2393: aload_0
    //   2394: iload_3
    //   2395: iconst_1
    //   2396: iadd
    //   2397: putfield 179	com/tencent/mm/plugin/voip/model/e:qsm	I
    //   2400: iload_3
    //   2401: iconst_5
    //   2402: if_icmple -30 -> 2372
    //   2405: aload_0
    //   2406: sipush 2006
    //   2409: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2412: aload_0
    //   2413: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2416: ineg
    //   2417: istore_2
    //   2418: goto -46 -> 2372
    //   2421: iconst_0
    //   2422: istore_2
    //   2423: aload 14
    //   2425: astore_1
    //   2426: goto -1950 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2429	0	this	e
    //   0	2429	1	paramByteBuffer	ByteBuffer
    //   0	2429	2	paramInt1	int
    //   0	2429	3	paramInt2	int
    //   0	2429	4	paramInt3	int
    //   0	2429	5	paramBoolean	boolean
    //   231	2055	6	i	int
    //   677	258	7	j	int
    //   1050	1254	8	k	int
    //   1091	326	9	m	int
    //   1000	419	10	n	int
    //   1003	412	11	i1	int
    //   149	1760	12	l	long
    //   7	1	14	localObject1	Object
    //   393	16	14	localException1	Exception
    //   562	1	14	arrayOfByteBuffer	ByteBuffer[]
    //   827	1597	14	localException2	Exception
    //   553	395	15	localObject2	Object
    //   945	1350	16	arrayOfByte	byte[]
    //   988	1331	17	localObject3	Object
    //   997	512	18	localcap	com.tencent.mm.protocal.protobuf.cap
    // Exception table:
    //   from	to	target	type
    //   339	344	393	java/lang/Exception
    //   455	474	827	java/lang/Exception
    //   1336	1341	1425	java/lang/Exception
    //   1609	1614	1622	java/lang/Exception
    //   487	575	2332	java/lang/Exception
    //   579	601	2332	java/lang/Exception
    //   607	650	2332	java/lang/Exception
    //   650	673	2332	java/lang/Exception
    //   686	712	2332	java/lang/Exception
    //   718	729	2332	java/lang/Exception
    //   735	816	2332	java/lang/Exception
    //   861	868	2332	java/lang/Exception
    //   873	887	2332	java/lang/Exception
    //   887	925	2332	java/lang/Exception
    //   939	975	2332	java/lang/Exception
    //   975	999	2332	java/lang/Exception
    //   1015	1084	2332	java/lang/Exception
    //   1101	1123	2332	java/lang/Exception
    //   1123	1140	2332	java/lang/Exception
    //   1140	1169	2332	java/lang/Exception
    //   1169	1184	2332	java/lang/Exception
    //   1184	1336	2332	java/lang/Exception
    //   1357	1398	2332	java/lang/Exception
    //   1406	1414	2332	java/lang/Exception
    //   1426	1465	2332	java/lang/Exception
    //   1468	1522	2332	java/lang/Exception
    //   1534	1609	2332	java/lang/Exception
    //   1623	1662	2332	java/lang/Exception
    //   1665	1732	2332	java/lang/Exception
    //   1744	1813	2332	java/lang/Exception
    //   1813	2019	2332	java/lang/Exception
    //   2031	2046	2332	java/lang/Exception
    //   2046	2055	2332	java/lang/Exception
    //   2058	2079	2332	java/lang/Exception
    //   2081	2090	2332	java/lang/Exception
    //   2092	2145	2332	java/lang/Exception
    //   2157	2232	2332	java/lang/Exception
    //   2232	2329	2332	java/lang/Exception
    //   2380	2385	2332	java/lang/Exception
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 987
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   22: if_icmpeq +32 -> 54
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   40: aload_0
    //   41: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   44: imul
    //   45: iconst_3
    //   46: imul
    //   47: iconst_2
    //   48: idiv
    //   49: newarray byte
    //   51: putfield 152	com/tencent/mm/plugin/voip/model/e:qsd	[B
    //   54: aload_0
    //   55: getfield 152	com/tencent/mm/plugin/voip/model/e:qsd	[B
    //   58: ifnonnull +22 -> 80
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   66: aload_0
    //   67: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   70: imul
    //   71: iconst_3
    //   72: imul
    //   73: iconst_2
    //   74: idiv
    //   75: newarray byte
    //   77: putfield 152	com/tencent/mm/plugin/voip/model/e:qsd	[B
    //   80: ldc_w 259
    //   83: new 261	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 710
    //   90: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: getfield 197	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   97: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc_w 712
    //   103: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   110: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 204	com/tencent/mm/plugin/voip/model/e:GTN	Lcom/tencent/mm/plugin/voip/model/e$a;
    //   123: getfield 630	com/tencent/mm/plugin/voip/model/e$a:cSkipFlag	B
    //   126: ifne +2250 -> 2376
    //   129: aload_0
    //   130: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   133: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   136: ifnull +2240 -> 2376
    //   139: aload_0
    //   140: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   143: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   146: aload_1
    //   147: aload_1
    //   148: arraylength
    //   149: aload_0
    //   150: getfield 193	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   153: aload_0
    //   154: getfield 195	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   157: iload 4
    //   159: aload_0
    //   160: getfield 152	com/tencent/mm/plugin/voip/model/e:qsd	[B
    //   163: invokevirtual 991	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess	([BIIII[B)I
    //   166: pop
    //   167: aload_0
    //   168: getfield 152	com/tencent/mm/plugin/voip/model/e:qsd	[B
    //   171: astore_1
    //   172: aload_0
    //   173: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   176: aload_0
    //   177: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   180: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   183: getfield 741	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   186: if_icmpne +20 -> 206
    //   189: aload_0
    //   190: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   193: aload_0
    //   194: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   197: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   200: getfield 744	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   203: if_icmpeq +209 -> 412
    //   206: ldc_w 259
    //   209: new 261	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 746
    //   216: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   223: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   226: getfield 741	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   229: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc_w 748
    //   235: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   242: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   245: getfield 744	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   248: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: ldc_w 750
    //   254: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_0
    //   258: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   261: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: ldc_w 748
    //   267: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_0
    //   271: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   274: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   288: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   291: getfield 741	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   294: putfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   297: aload_0
    //   298: aload_0
    //   299: getfield 162	com/tencent/mm/plugin/voip/model/e:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   302: getfield 245	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   305: getfield 744	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   308: putfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   311: aload_0
    //   312: aload_0
    //   313: getfield 189	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   316: aload_0
    //   317: getfield 191	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   320: imul
    //   321: iconst_3
    //   322: imul
    //   323: iconst_1
    //   324: ishr
    //   325: putfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   328: aload_0
    //   329: invokespecial 752	com/tencent/mm/plugin/voip/model/e:cyY	()I
    //   332: istore_2
    //   333: iload_2
    //   334: istore_3
    //   335: iload_2
    //   336: ifge +78 -> 414
    //   339: ldc_w 259
    //   342: ldc_w 754
    //   345: iload_2
    //   346: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   349: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   352: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload_0
    //   356: invokevirtual 757	com/tencent/mm/plugin/voip/model/e:emB	()V
    //   359: ldc_w 987
    //   362: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: iload_2
    //   366: ireturn
    //   367: astore 13
    //   369: ldc_w 259
    //   372: new 261	java/lang/StringBuilder
    //   375: dup
    //   376: ldc_w 759
    //   379: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: aload 13
    //   384: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   387: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_0
    //   397: sipush 2003
    //   400: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   403: aload_0
    //   404: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   407: ineg
    //   408: istore_2
    //   409: goto -76 -> 333
    //   412: iconst_0
    //   413: istore_3
    //   414: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   417: bipush 100
    //   419: if_icmpgt +396 -> 815
    //   422: aload_0
    //   423: getfield 761	com/tencent/mm/plugin/voip/model/e:qsh	Ljava/io/BufferedOutputStream;
    //   426: ifnull +389 -> 815
    //   429: aload_0
    //   430: getfield 761	com/tencent/mm/plugin/voip/model/e:qsh	Ljava/io/BufferedOutputStream;
    //   433: aload_0
    //   434: getfield 152	com/tencent/mm/plugin/voip/model/e:qsd	[B
    //   437: iconst_0
    //   438: aload_0
    //   439: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   442: invokevirtual 771	java/io/BufferedOutputStream:write	([BII)V
    //   445: iload_3
    //   446: istore_2
    //   447: aload_1
    //   448: ifnull +1895 -> 2343
    //   451: aload_0
    //   452: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   455: ifnull +1888 -> 2343
    //   458: aload_0
    //   459: iconst_0
    //   460: putfield 179	com/tencent/mm/plugin/voip/model/e:qsm	I
    //   463: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   466: lstore 11
    //   468: ldc_w 259
    //   471: new 261	java/lang/StringBuilder
    //   474: dup
    //   475: ldc_w 778
    //   478: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   481: aload_0
    //   482: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   485: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: ldc_w 780
    //   491: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   497: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: ldc_w 782
    //   503: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: lload 11
    //   508: invokevirtual 785	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   511: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload_0
    //   518: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   521: invokevirtual 789	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   524: astore 14
    //   526: aload_0
    //   527: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   530: invokevirtual 792	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   533: astore 13
    //   535: aload_0
    //   536: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   539: ldc2_w 793
    //   542: invokevirtual 798	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   545: istore_3
    //   546: iload_3
    //   547: iflt +62 -> 609
    //   550: aload_0
    //   551: aload_0
    //   552: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   555: invokespecial 800	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   558: lstore 11
    //   560: aload 14
    //   562: iload_3
    //   563: aaload
    //   564: astore 14
    //   566: aload 14
    //   568: invokevirtual 813	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   571: pop
    //   572: aload 14
    //   574: aload_1
    //   575: iconst_0
    //   576: aload_0
    //   577: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   580: invokevirtual 994	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   583: pop
    //   584: aload_0
    //   585: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   588: iload_3
    //   589: aload_0
    //   590: getfield 185	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   593: lload 11
    //   595: iconst_0
    //   596: invokevirtual 820	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   599: aload_0
    //   600: aload_0
    //   601: getfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   604: lconst_1
    //   605: ladd
    //   606: putfield 158	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   609: new 822	android/media/MediaCodec$BufferInfo
    //   612: dup
    //   613: invokespecial 823	android/media/MediaCodec$BufferInfo:<init>	()V
    //   616: astore_1
    //   617: aload_0
    //   618: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   621: aload_1
    //   622: aload_0
    //   623: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   626: i2l
    //   627: invokevirtual 827	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   630: istore 4
    //   632: iload_2
    //   633: istore_3
    //   634: iload 4
    //   636: istore 6
    //   638: iload 4
    //   640: bipush 254
    //   642: if_icmpne +242 -> 884
    //   645: aload_0
    //   646: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   649: invokevirtual 831	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   652: astore 14
    //   654: ldc_w 259
    //   657: ldc_w 833
    //   660: aload 14
    //   662: invokestatic 330	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   665: invokevirtual 295	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   668: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: iload_2
    //   672: istore_3
    //   673: iload 4
    //   675: istore 6
    //   677: aload 14
    //   679: ldc_w 516
    //   682: invokevirtual 836	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   685: ifeq +199 -> 884
    //   688: iload_2
    //   689: istore_3
    //   690: iload 4
    //   692: istore 6
    //   694: aload 14
    //   696: ldc_w 516
    //   699: invokevirtual 535	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   702: i2d
    //   703: aload_0
    //   704: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   707: sipush 1000
    //   710: imul
    //   711: i2d
    //   712: ldc2_w 837
    //   715: dmul
    //   716: dcmpl
    //   717: ifle +167 -> 884
    //   720: ldc_w 259
    //   723: new 261	java/lang/StringBuilder
    //   726: dup
    //   727: ldc_w 840
    //   730: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   733: aload 14
    //   735: ldc_w 516
    //   738: invokevirtual 535	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   741: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   744: ldc_w 842
    //   747: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_0
    //   751: getfield 199	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   754: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   757: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: aload_0
    //   764: sipush 2007
    //   767: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   770: aload_0
    //   771: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   774: istore_2
    //   775: iload_2
    //   776: ineg
    //   777: istore_2
    //   778: ldc_w 987
    //   781: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   784: iload_2
    //   785: ireturn
    //   786: astore 13
    //   788: ldc_w 259
    //   791: new 261	java/lang/StringBuilder
    //   794: dup
    //   795: ldc_w 341
    //   798: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   801: aload 13
    //   803: invokevirtual 342	java/lang/Exception:toString	()Ljava/lang/String;
    //   806: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: iload_3
    //   816: istore_2
    //   817: goto -370 -> 447
    //   820: aload_0
    //   821: getfield 844	com/tencent/mm/plugin/voip/model/e:qsg	Z
    //   824: ifeq +22 -> 846
    //   827: aload 14
    //   829: ifnull +17 -> 846
    //   832: aload_0
    //   833: getfield 846	com/tencent/mm/plugin/voip/model/e:qse	Landroid/media/MediaMuxer;
    //   836: aload_0
    //   837: getfield 848	com/tencent/mm/plugin/voip/model/e:qsf	I
    //   840: aload 14
    //   842: aload_1
    //   843: invokevirtual 854	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   846: aload_1
    //   847: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   850: istore_3
    //   851: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   854: iconst_1
    //   855: iadd
    //   856: putstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   859: aload_0
    //   860: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   863: iload 6
    //   865: iconst_0
    //   866: invokevirtual 861	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   869: aload_0
    //   870: getfield 206	com/tencent/mm/plugin/voip/model/e:qsc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   873: aload_1
    //   874: aload_0
    //   875: getfield 144	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   878: i2l
    //   879: invokevirtual 827	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   882: istore 6
    //   884: iload_3
    //   885: istore_2
    //   886: iload 6
    //   888: iflt +1439 -> 2327
    //   891: aload 13
    //   893: iload 6
    //   895: aaload
    //   896: astore 14
    //   898: aload_1
    //   899: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   902: newarray byte
    //   904: astore 15
    //   906: aload 14
    //   908: aload 15
    //   910: invokevirtual 866	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   913: pop
    //   914: aload_0
    //   915: getfield 868	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   918: ifnull +16 -> 934
    //   921: aload_0
    //   922: getfield 868	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   925: aload 15
    //   927: iconst_0
    //   928: aload 15
    //   930: arraylength
    //   931: invokevirtual 771	java/io/BufferedOutputStream:write	([BII)V
    //   934: aload_1
    //   935: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   938: iconst_2
    //   939: if_icmpne +550 -> 1489
    //   942: aload 15
    //   944: invokestatic 870	com/tencent/mm/plugin/voip/model/e:bS	([B)Ljava/util/ArrayList;
    //   947: astore 16
    //   949: new 872	com/tencent/mm/protocal/protobuf/cap
    //   952: dup
    //   953: invokespecial 873	com/tencent/mm/protocal/protobuf/cap:<init>	()V
    //   956: astore 17
    //   958: iconst_0
    //   959: istore 9
    //   961: iconst_0
    //   962: istore 10
    //   964: iconst_0
    //   965: istore 5
    //   967: iconst_0
    //   968: istore 4
    //   970: iconst_0
    //   971: istore_3
    //   972: iconst_0
    //   973: istore_2
    //   974: aload 16
    //   976: invokevirtual 875	java/util/ArrayList:size	()I
    //   979: iconst_3
    //   980: if_icmpne +326 -> 1306
    //   983: aload_0
    //   984: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   987: ldc 247
    //   989: invokevirtual 251	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   992: ifeq +314 -> 1306
    //   995: aload 16
    //   997: iconst_0
    //   998: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1001: checkcast 233	java/lang/Integer
    //   1004: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1007: iconst_4
    //   1008: iadd
    //   1009: istore 7
    //   1011: aload 16
    //   1013: iconst_1
    //   1014: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1017: checkcast 233	java/lang/Integer
    //   1020: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1023: iconst_4
    //   1024: iadd
    //   1025: istore 5
    //   1027: aload 16
    //   1029: iconst_2
    //   1030: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1033: checkcast 233	java/lang/Integer
    //   1036: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1039: iconst_4
    //   1040: iadd
    //   1041: istore_3
    //   1042: iload 5
    //   1044: iload 7
    //   1046: isub
    //   1047: iconst_4
    //   1048: isub
    //   1049: istore 8
    //   1051: iload_3
    //   1052: iload 5
    //   1054: isub
    //   1055: iconst_4
    //   1056: isub
    //   1057: istore 4
    //   1059: aload_1
    //   1060: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1063: iload_3
    //   1064: isub
    //   1065: istore_2
    //   1066: aload 17
    //   1068: aload 15
    //   1070: iload 7
    //   1072: iload 8
    //   1074: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1077: putfield 891	com/tencent/mm/protocal/protobuf/cap:MfN	Lcom/tencent/mm/bw/b;
    //   1080: aload_0
    //   1081: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1084: ifnonnull +13 -> 1097
    //   1087: aload_0
    //   1088: aload_1
    //   1089: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1092: newarray byte
    //   1094: putfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1097: aload_0
    //   1098: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1101: ifnull +40 -> 1141
    //   1104: aload_1
    //   1105: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1108: aload_0
    //   1109: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1112: arraylength
    //   1113: if_icmple +13 -> 1126
    //   1116: aload_0
    //   1117: aload_1
    //   1118: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1121: newarray byte
    //   1123: putfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1126: aload 15
    //   1128: iconst_0
    //   1129: aload_0
    //   1130: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1133: iconst_0
    //   1134: aload_1
    //   1135: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1138: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1141: ldc_w 259
    //   1144: new 261	java/lang/StringBuilder
    //   1147: dup
    //   1148: ldc_w 897
    //   1151: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1154: iload 5
    //   1156: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1159: ldc_w 899
    //   1162: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: iload 4
    //   1167: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1170: ldc_w 901
    //   1173: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: iload_3
    //   1177: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1180: ldc_w 899
    //   1183: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: iload_2
    //   1187: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1190: ldc_w 903
    //   1193: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: iload 7
    //   1198: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1201: ldc_w 899
    //   1204: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: iload 8
    //   1209: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1218: aload_0
    //   1219: getfield 173	com/tencent/mm/plugin/voip/model/e:qsj	I
    //   1222: iconst_1
    //   1223: if_icmpeq +200 -> 1423
    //   1226: aload_0
    //   1227: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1230: aload 15
    //   1232: invokevirtual 907	com/tencent/mm/plugin/voip/model/g:cg	([B)Z
    //   1235: ifeq +188 -> 1423
    //   1238: aload_0
    //   1239: aload_0
    //   1240: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1243: getfield 910	com/tencent/mm/plugin/voip/model/g:GTT	I
    //   1246: putfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1249: aload_0
    //   1250: iconst_1
    //   1251: putfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1254: ldc_w 259
    //   1257: new 261	java/lang/StringBuilder
    //   1260: dup
    //   1261: ldc_w 912
    //   1264: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1267: aload_0
    //   1268: getfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1271: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1274: ldc_w 914
    //   1277: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: aload_0
    //   1281: getfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1284: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1287: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1290: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1293: aload_0
    //   1294: invokespecial 752	com/tencent/mm/plugin/voip/model/e:cyY	()I
    //   1297: istore_2
    //   1298: ldc_w 987
    //   1301: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1304: iload_2
    //   1305: ireturn
    //   1306: iload 10
    //   1308: istore 8
    //   1310: iload 9
    //   1312: istore 7
    //   1314: aload 16
    //   1316: invokevirtual 875	java/util/ArrayList:size	()I
    //   1319: iconst_2
    //   1320: if_icmpne -240 -> 1080
    //   1323: aload 16
    //   1325: iconst_0
    //   1326: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1329: checkcast 233	java/lang/Integer
    //   1332: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1335: iconst_4
    //   1336: iadd
    //   1337: istore 5
    //   1339: aload 16
    //   1341: iconst_1
    //   1342: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1345: checkcast 233	java/lang/Integer
    //   1348: invokevirtual 881	java/lang/Integer:intValue	()I
    //   1351: iconst_4
    //   1352: iadd
    //   1353: istore_3
    //   1354: iload_3
    //   1355: iload 5
    //   1357: isub
    //   1358: iconst_4
    //   1359: isub
    //   1360: istore 4
    //   1362: aload_1
    //   1363: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1366: iload_3
    //   1367: isub
    //   1368: istore_2
    //   1369: iload 10
    //   1371: istore 8
    //   1373: iload 9
    //   1375: istore 7
    //   1377: goto -297 -> 1080
    //   1380: astore_1
    //   1381: ldc_w 259
    //   1384: new 261	java/lang/StringBuilder
    //   1387: dup
    //   1388: ldc_w 916
    //   1391: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1394: aload_1
    //   1395: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1398: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1404: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1407: aload_0
    //   1408: sipush 2005
    //   1411: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1414: aload_0
    //   1415: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1418: ineg
    //   1419: istore_2
    //   1420: goto -122 -> 1298
    //   1423: aload 17
    //   1425: iconst_4
    //   1426: putfield 919	com/tencent/mm/protocal/protobuf/cap:MfK	I
    //   1429: aload 17
    //   1431: aload 15
    //   1433: iload 5
    //   1435: iload 4
    //   1437: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1440: putfield 922	com/tencent/mm/protocal/protobuf/cap:MfL	Lcom/tencent/mm/bw/b;
    //   1443: aload 17
    //   1445: aload 15
    //   1447: iload_3
    //   1448: iload_2
    //   1449: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1452: putfield 925	com/tencent/mm/protocal/protobuf/cap:MfM	Lcom/tencent/mm/bw/b;
    //   1455: aload 17
    //   1457: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   1460: arraylength
    //   1461: istore_2
    //   1462: aload_0
    //   1463: aload 17
    //   1465: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   1468: aload_1
    //   1469: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1472: iload_2
    //   1473: invokespecial 930	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   1476: istore_2
    //   1477: iload_2
    //   1478: ifge -658 -> 820
    //   1481: ldc_w 987
    //   1484: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1487: iload_2
    //   1488: ireturn
    //   1489: aload_0
    //   1490: getfield 173	com/tencent/mm/plugin/voip/model/e:qsj	I
    //   1493: iconst_1
    //   1494: if_icmpeq +126 -> 1620
    //   1497: aload_0
    //   1498: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1501: aload 15
    //   1503: invokevirtual 933	com/tencent/mm/plugin/voip/model/g:ch	([B)Z
    //   1506: ifeq +114 -> 1620
    //   1509: aload_0
    //   1510: aload_0
    //   1511: getfield 171	com/tencent/mm/plugin/voip/model/e:qsi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1514: getfield 910	com/tencent/mm/plugin/voip/model/g:GTT	I
    //   1517: putfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1520: aload_0
    //   1521: iconst_1
    //   1522: putfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1525: ldc_w 259
    //   1528: new 261	java/lang/StringBuilder
    //   1531: dup
    //   1532: ldc_w 912
    //   1535: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1538: aload_0
    //   1539: getfield 175	com/tencent/mm/plugin/voip/model/e:qsk	I
    //   1542: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1545: ldc_w 914
    //   1548: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: aload_0
    //   1552: getfield 177	com/tencent/mm/plugin/voip/model/e:qsl	I
    //   1555: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1558: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1564: aload_0
    //   1565: invokespecial 752	com/tencent/mm/plugin/voip/model/e:cyY	()I
    //   1568: istore_2
    //   1569: ldc_w 987
    //   1572: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1575: iload_2
    //   1576: ireturn
    //   1577: astore_1
    //   1578: ldc_w 259
    //   1581: new 261	java/lang/StringBuilder
    //   1584: dup
    //   1585: ldc_w 916
    //   1588: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1591: aload_1
    //   1592: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1595: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1601: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1604: aload_0
    //   1605: sipush 2005
    //   1608: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1611: aload_0
    //   1612: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1615: ineg
    //   1616: istore_2
    //   1617: goto -48 -> 1569
    //   1620: aload_1
    //   1621: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1624: ifeq +71 -> 1695
    //   1627: aload_1
    //   1628: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1631: iconst_1
    //   1632: if_icmpeq +63 -> 1695
    //   1635: aload_0
    //   1636: sipush 2009
    //   1639: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1642: aload_0
    //   1643: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   1646: ineg
    //   1647: istore_2
    //   1648: ldc_w 259
    //   1651: new 261	java/lang/StringBuilder
    //   1654: dup
    //   1655: ldc_w 935
    //   1658: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1661: aload_1
    //   1662: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1665: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1668: ldc_w 899
    //   1671: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: aload_1
    //   1675: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1678: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1681: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1684: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1687: ldc_w 987
    //   1690: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1693: iload_2
    //   1694: ireturn
    //   1695: iconst_0
    //   1696: istore_3
    //   1697: iload_3
    //   1698: istore_2
    //   1699: aload_1
    //   1700: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1703: iconst_1
    //   1704: if_icmpne +64 -> 1768
    //   1707: aload_0
    //   1708: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1711: arraylength
    //   1712: newarray byte
    //   1714: astore 16
    //   1716: aload 15
    //   1718: iconst_0
    //   1719: aload 16
    //   1721: iconst_0
    //   1722: aload_0
    //   1723: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1726: arraylength
    //   1727: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1730: aload 16
    //   1732: aload_0
    //   1733: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1736: invokestatic 941	java/util/Arrays:equals	([B[B)Z
    //   1739: ifeq +247 -> 1986
    //   1742: aload_0
    //   1743: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   1746: arraylength
    //   1747: istore_2
    //   1748: ldc_w 259
    //   1751: ldc_w 943
    //   1754: iconst_1
    //   1755: anewarray 4	java/lang/Object
    //   1758: dup
    //   1759: iconst_0
    //   1760: iload_2
    //   1761: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1764: aastore
    //   1765: invokestatic 946	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1768: iconst_4
    //   1769: invokestatic 949	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1772: astore 16
    //   1774: aload 16
    //   1776: aload_1
    //   1777: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1780: iconst_4
    //   1781: isub
    //   1782: iload_2
    //   1783: isub
    //   1784: invokevirtual 951	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1787: pop
    //   1788: aload 16
    //   1790: getstatic 954	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1793: invokevirtual 584	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1796: invokevirtual 765	java/nio/ByteBuffer:array	()[B
    //   1799: iconst_0
    //   1800: aload 15
    //   1802: iload_2
    //   1803: iconst_4
    //   1804: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1807: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   1810: lstore 11
    //   1812: ldc_w 259
    //   1815: new 261	java/lang/StringBuilder
    //   1818: dup
    //   1819: ldc_w 956
    //   1822: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1825: aload_1
    //   1826: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1829: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1832: ldc_w 958
    //   1835: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: aload_1
    //   1839: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1842: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1845: ldc_w 780
    //   1848: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: getstatic 87	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   1854: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1857: ldc_w 782
    //   1860: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: lload 11
    //   1865: invokevirtual 785	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1868: ldc_w 960
    //   1871: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: iload_2
    //   1875: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1878: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1881: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1884: new 962	com/tencent/mm/protocal/protobuf/cao
    //   1887: dup
    //   1888: invokespecial 963	com/tencent/mm/protocal/protobuf/cao:<init>	()V
    //   1891: astore 16
    //   1893: aload 16
    //   1895: aload 15
    //   1897: iload_2
    //   1898: aload_1
    //   1899: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1902: iload_2
    //   1903: isub
    //   1904: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   1907: putfield 966	com/tencent/mm/protocal/protobuf/cao:MfG	Lcom/tencent/mm/bw/b;
    //   1910: aload 16
    //   1912: iconst_1
    //   1913: putfield 969	com/tencent/mm/protocal/protobuf/cao:MfH	I
    //   1916: aload 16
    //   1918: aload_0
    //   1919: getfield 167	com/tencent/mm/plugin/voip/model/e:zLK	Ljava/util/LinkedList;
    //   1922: putfield 972	com/tencent/mm/protocal/protobuf/cao:MfI	Ljava/util/LinkedList;
    //   1925: aload_0
    //   1926: getfield 169	com/tencent/mm/plugin/voip/model/e:zLL	Ljava/util/LinkedList;
    //   1929: iconst_0
    //   1930: aload_1
    //   1931: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   1934: iload_2
    //   1935: isub
    //   1936: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1939: invokevirtual 976	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1942: pop
    //   1943: aload 16
    //   1945: aload_0
    //   1946: getfield 169	com/tencent/mm/plugin/voip/model/e:zLL	Ljava/util/LinkedList;
    //   1949: putfield 979	com/tencent/mm/protocal/protobuf/cao:MfJ	Ljava/util/LinkedList;
    //   1952: aload 16
    //   1954: invokevirtual 980	com/tencent/mm/protocal/protobuf/cao:toByteArray	()[B
    //   1957: arraylength
    //   1958: istore_2
    //   1959: aload_0
    //   1960: aload 16
    //   1962: invokevirtual 980	com/tencent/mm/protocal/protobuf/cao:toByteArray	()[B
    //   1965: aload_1
    //   1966: getfield 857	android/media/MediaCodec$BufferInfo:flags	I
    //   1969: iload_2
    //   1970: invokespecial 930	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   1973: istore_2
    //   1974: iload_2
    //   1975: ifge -1155 -> 820
    //   1978: ldc_w 987
    //   1981: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1984: iload_2
    //   1985: ireturn
    //   1986: aload_0
    //   1987: getfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   1990: ifnonnull +11 -> 2001
    //   1993: aload_0
    //   1994: bipush 100
    //   1996: newarray byte
    //   1998: putfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   2001: aload_1
    //   2002: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   2005: bipush 100
    //   2007: if_icmple +328 -> 2335
    //   2010: bipush 100
    //   2012: istore_2
    //   2013: aload 15
    //   2015: iconst_0
    //   2016: aload_0
    //   2017: getfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   2020: iconst_0
    //   2021: iload_2
    //   2022: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2025: aload_0
    //   2026: getfield 150	com/tencent/mm/plugin/voip/model/e:GTL	[B
    //   2029: invokestatic 870	com/tencent/mm/plugin/voip/model/e:bS	([B)Ljava/util/ArrayList;
    //   2032: astore 16
    //   2034: iload_3
    //   2035: istore_2
    //   2036: aload 16
    //   2038: invokevirtual 875	java/util/ArrayList:size	()I
    //   2041: iconst_3
    //   2042: if_icmpne -274 -> 1768
    //   2045: iload_3
    //   2046: istore_2
    //   2047: aload_0
    //   2048: getfield 142	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   2051: ldc_w 527
    //   2054: invokevirtual 251	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2057: ifeq -289 -> 1768
    //   2060: aload 16
    //   2062: iconst_0
    //   2063: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2066: checkcast 233	java/lang/Integer
    //   2069: invokevirtual 881	java/lang/Integer:intValue	()I
    //   2072: istore_3
    //   2073: aload 16
    //   2075: iconst_1
    //   2076: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2079: checkcast 233	java/lang/Integer
    //   2082: invokevirtual 881	java/lang/Integer:intValue	()I
    //   2085: istore 4
    //   2087: aload 16
    //   2089: iconst_2
    //   2090: invokevirtual 878	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2093: checkcast 233	java/lang/Integer
    //   2096: invokevirtual 881	java/lang/Integer:intValue	()I
    //   2099: istore_2
    //   2100: iload 4
    //   2102: iload_3
    //   2103: isub
    //   2104: istore 5
    //   2106: iload_2
    //   2107: iload 4
    //   2109: isub
    //   2110: istore 7
    //   2112: ldc_w 259
    //   2115: ldc_w 982
    //   2118: iconst_5
    //   2119: anewarray 4	java/lang/Object
    //   2122: dup
    //   2123: iconst_0
    //   2124: iload_3
    //   2125: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2128: aastore
    //   2129: dup
    //   2130: iconst_1
    //   2131: iload 4
    //   2133: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2136: aastore
    //   2137: dup
    //   2138: iconst_2
    //   2139: iload_2
    //   2140: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2143: aastore
    //   2144: dup
    //   2145: iconst_3
    //   2146: iload 5
    //   2148: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2151: aastore
    //   2152: dup
    //   2153: iconst_4
    //   2154: iload 7
    //   2156: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2159: aastore
    //   2160: invokestatic 984	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2163: aload_0
    //   2164: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2167: arraylength
    //   2168: iload 5
    //   2170: iload 7
    //   2172: iadd
    //   2173: if_icmpge +14 -> 2187
    //   2176: aload_0
    //   2177: iload 5
    //   2179: iload 7
    //   2181: iadd
    //   2182: newarray byte
    //   2184: putfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2187: aload 15
    //   2189: iload_3
    //   2190: aload_0
    //   2191: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2194: iconst_0
    //   2195: iload 5
    //   2197: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2200: aload 15
    //   2202: iload 7
    //   2204: aload_0
    //   2205: getfield 148	com/tencent/mm/plugin/voip/model/e:GTK	[B
    //   2208: iload 5
    //   2210: iload 7
    //   2212: invokestatic 895	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2215: new 872	com/tencent/mm/protocal/protobuf/cap
    //   2218: dup
    //   2219: invokespecial 873	com/tencent/mm/protocal/protobuf/cap:<init>	()V
    //   2222: astore 16
    //   2224: aload 16
    //   2226: iconst_4
    //   2227: putfield 919	com/tencent/mm/protocal/protobuf/cap:MfK	I
    //   2230: aload 16
    //   2232: aload 15
    //   2234: iload_3
    //   2235: iconst_4
    //   2236: iadd
    //   2237: iload 5
    //   2239: iconst_4
    //   2240: isub
    //   2241: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   2244: putfield 922	com/tencent/mm/protocal/protobuf/cap:MfL	Lcom/tencent/mm/bw/b;
    //   2247: aload 16
    //   2249: aload 15
    //   2251: iload 4
    //   2253: iconst_4
    //   2254: iadd
    //   2255: iload 7
    //   2257: iconst_4
    //   2258: isub
    //   2259: invokestatic 887	com/tencent/mm/bw/b:Q	([BII)Lcom/tencent/mm/bw/b;
    //   2262: putfield 925	com/tencent/mm/protocal/protobuf/cap:MfM	Lcom/tencent/mm/bw/b;
    //   2265: aload 16
    //   2267: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   2270: arraylength
    //   2271: istore_3
    //   2272: aload_0
    //   2273: aload 16
    //   2275: invokevirtual 928	com/tencent/mm/protocal/protobuf/cap:toByteArray	()[B
    //   2278: iconst_2
    //   2279: iload_3
    //   2280: invokespecial 930	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   2283: pop
    //   2284: goto -516 -> 1768
    //   2287: astore_1
    //   2288: ldc_w 259
    //   2291: new 261	java/lang/StringBuilder
    //   2294: dup
    //   2295: ldc_w 341
    //   2298: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2301: aload_1
    //   2302: invokevirtual 342	java/lang/Exception:toString	()Ljava/lang/String;
    //   2305: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2308: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2311: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2314: aload_0
    //   2315: sipush 2004
    //   2318: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2321: aload_0
    //   2322: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2325: ineg
    //   2326: istore_2
    //   2327: ldc_w 987
    //   2330: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2333: iload_2
    //   2334: ireturn
    //   2335: aload_1
    //   2336: getfield 864	android/media/MediaCodec$BufferInfo:size	I
    //   2339: istore_2
    //   2340: goto -327 -> 2013
    //   2343: aload_0
    //   2344: getfield 179	com/tencent/mm/plugin/voip/model/e:qsm	I
    //   2347: istore_3
    //   2348: aload_0
    //   2349: iload_3
    //   2350: iconst_1
    //   2351: iadd
    //   2352: putfield 179	com/tencent/mm/plugin/voip/model/e:qsm	I
    //   2355: iload_3
    //   2356: iconst_5
    //   2357: if_icmple -30 -> 2327
    //   2360: aload_0
    //   2361: sipush 2006
    //   2364: putfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2367: aload_0
    //   2368: getfield 138	com/tencent/mm/plugin/voip/model/e:qsb	I
    //   2371: ineg
    //   2372: istore_2
    //   2373: goto -46 -> 2327
    //   2376: iconst_0
    //   2377: istore_2
    //   2378: aload 13
    //   2380: astore_1
    //   2381: goto -1934 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2384	0	this	e
    //   0	2384	1	paramArrayOfByte	byte[]
    //   0	2384	2	paramInt1	int
    //   0	2384	3	paramInt2	int
    //   0	2384	4	paramInt3	int
    //   965	1276	5	i	int
    //   636	258	6	j	int
    //   1009	1250	7	k	int
    //   1049	323	8	m	int
    //   959	415	9	n	int
    //   962	408	10	i1	int
    //   466	1398	11	l	long
    //   7	1	13	localObject1	Object
    //   367	16	13	localException1	Exception
    //   533	1	13	arrayOfByteBuffer	ByteBuffer[]
    //   786	1593	13	localException2	Exception
    //   524	383	14	localObject2	Object
    //   904	1346	15	arrayOfByte	byte[]
    //   947	1327	16	localObject3	Object
    //   956	508	17	localcap	com.tencent.mm.protocal.protobuf.cap
    // Exception table:
    //   from	to	target	type
    //   328	333	367	java/lang/Exception
    //   429	445	786	java/lang/Exception
    //   1293	1298	1380	java/lang/Exception
    //   1564	1569	1577	java/lang/Exception
    //   458	546	2287	java/lang/Exception
    //   550	560	2287	java/lang/Exception
    //   566	609	2287	java/lang/Exception
    //   609	632	2287	java/lang/Exception
    //   645	671	2287	java/lang/Exception
    //   677	688	2287	java/lang/Exception
    //   694	775	2287	java/lang/Exception
    //   820	827	2287	java/lang/Exception
    //   832	846	2287	java/lang/Exception
    //   846	884	2287	java/lang/Exception
    //   898	934	2287	java/lang/Exception
    //   934	958	2287	java/lang/Exception
    //   974	1042	2287	java/lang/Exception
    //   1059	1080	2287	java/lang/Exception
    //   1080	1097	2287	java/lang/Exception
    //   1097	1126	2287	java/lang/Exception
    //   1126	1141	2287	java/lang/Exception
    //   1141	1293	2287	java/lang/Exception
    //   1314	1354	2287	java/lang/Exception
    //   1362	1369	2287	java/lang/Exception
    //   1381	1420	2287	java/lang/Exception
    //   1423	1477	2287	java/lang/Exception
    //   1489	1564	2287	java/lang/Exception
    //   1578	1617	2287	java/lang/Exception
    //   1620	1687	2287	java/lang/Exception
    //   1699	1768	2287	java/lang/Exception
    //   1768	1974	2287	java/lang/Exception
    //   1986	2001	2287	java/lang/Exception
    //   2001	2010	2287	java/lang/Exception
    //   2013	2034	2287	java/lang/Exception
    //   2036	2045	2287	java/lang/Exception
    //   2047	2100	2287	java/lang/Exception
    //   2112	2187	2287	java/lang/Exception
    //   2187	2284	2287	java/lang/Exception
    //   2335	2340	2287	java/lang/Exception
  }
  
  public final void emB()
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
      if (this.qsh != null)
      {
        this.qsh.flush();
        this.qsh.close();
      }
      if (this.qse != null)
      {
        this.qse.stop();
        this.qse.release();
      }
      AppMethodBeat.o(114839);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MeidaCodec[HWEnc]", " error:" + localException.toString());
      AppMethodBeat.o(114839);
    }
  }
  
  final class a
  {
    public short GTP;
    public short GTQ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.e
 * JD-Core Version:    0.7.0.1
 */