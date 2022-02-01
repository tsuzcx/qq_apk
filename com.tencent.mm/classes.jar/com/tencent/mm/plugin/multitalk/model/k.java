package com.tencent.mm.plugin.multitalk.model;

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
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.multitalk.c.o;
import com.tencent.mm.plugin.voip.model.g;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class k
{
  public static int Lnk;
  public static int Lnp;
  public static short[] SizeFormat2WH;
  public static int VFMT_HEVC_HW;
  public static int VFMT_i264;
  public static int frameID;
  private static String path;
  private static int streamqueuesize;
  public static final String[] supportedH264HwCodecPrefixes;
  public String ENCODING;
  public LinkedList<cyu> Lnl;
  public LinkedList<Integer> Lnm;
  public int Lnn;
  public a Lno;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
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
  public long nAO;
  private BufferedOutputStream outputStream;
  public int wUa;
  private aa wUb;
  private byte[] wUc;
  private MediaMuxer wUd;
  private int wUe;
  private boolean wUf;
  private BufferedOutputStream wUg;
  g wUh;
  public int wUi;
  public int wUj;
  public int wUk;
  public int wUl;
  
  static
  {
    AppMethodBeat.i(284858);
    streamqueuesize = 100;
    frameID = 0;
    path = b.bmz();
    VFMT_i264 = 18;
    VFMT_HEVC_HW = 19;
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK", "OMX.sprd" };
    Lnk = 39;
    Lnp = 53;
    AppMethodBeat.o(284858);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(284812);
    this.wUa = 0;
    this.ENCODING = "video/avc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.wUc = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.nAO = 0L;
    this.Lnl = new LinkedList();
    this.Lnm = new LinkedList();
    this.wUh = null;
    this.wUi = 0;
    this.wUj = 8;
    this.wUk = 0;
    this.wUl = 0;
    this.Lnn = 0;
    this.isRuning = false;
    this.encLen = 0;
    Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] MultiAvcEncoder width[%d], height[%d], framerate[%d], bitrate[%d], profileCfg[%d]", new Object[] { Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(5), Integer.valueOf(3000), Integer.valueOf(0), paramString });
    this.mPrevResolution = 8;
    this.m_width = 1920;
    this.m_height = 1080;
    this.m_CapW = 1920;
    this.m_CapH = 1080;
    this.ENCODING = paramString;
    this.m_framerate = 5;
    this.m_br_kbps = 3000;
    this.mProfileCfg = 0;
    frameID = 0;
    this.mGeneratedIdx = 0L;
    this.Lno = new a();
    this.wUb = null;
    this.wUj = 8;
    this.wUi = 0;
    this.wUk = 0;
    this.wUa = 0;
    paramString = new cyu();
    paramString.aaDC = 1L;
    paramString.aaDD = 24;
    paramString.aaDE = 1L;
    paramString.aaDF = 24;
    paramString.aaDG = 0L;
    paramString.aaDH = 0;
    this.Lnl.add(paramString);
    this.Lnm.add(Integer.valueOf(0));
    this.wUc = null;
    this.wUl = 0;
    this.Lnn = 0;
    this.nAO = 0L;
    try
    {
      drc();
      AppMethodBeat.o(284812);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MultiAvcEncoder[HWEnc]", "mediacodec init error: " + paramString.getMessage());
      this.wUa = 2003;
      AppMethodBeat.o(284812);
    }
  }
  
  private int I(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284849);
    int j;
    int i;
    if (paramArrayOfByte != null)
    {
      j = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        j = VFMT_HEVC_HW;
      }
      if (ac.ggS().gfV())
      {
        i = o.Ljn.i(paramArrayOfByte, this.m_width, paramInt1, j + 128);
        Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] ret[%d],  m_width[%d], m_height[%d], type[%d], format[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.m_width), Integer.valueOf(this.m_height), Integer.valueOf(paramInt1), Integer.valueOf(j) });
        if (i < 0) {
          break label204;
        }
        this.Lnn = 0;
        Log.d("MultiAvcEncoder[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(284849);
      return i;
      i = ac.ggR().LnJ.c(paramArrayOfByte, paramInt2, this.m_width, paramInt1, j);
      break;
      label204:
      paramInt1 = this.Lnn;
      this.Lnn = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.wUa = 2008;
        i = -this.wUa;
        Log.e("MultiAvcEncoder[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(i)));
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(284840);
    try
    {
      if (this.wUb != null)
      {
        int i = paramInt;
        if (paramInt <= 0) {
          i = 700;
        }
        Bundle localBundle = new Bundle();
        paramInt = i * 1000;
        Log.v("MultiAvcEncoder[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.wUb.setParameters(localBundle);
        AppMethodBeat.o(284840);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MultiAvcEncoder[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
      AppMethodBeat.o(284840);
    }
    return false;
  }
  
  private void StopEncoder()
  {
    AppMethodBeat.i(284816);
    try
    {
      if (this.wUb != null)
      {
        this.wUb.stop();
        this.wUb.release();
      }
      AppMethodBeat.o(284816);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MultiAvcEncoder[HWEnc]", " error:" + localException.toString());
      AppMethodBeat.o(284816);
    }
  }
  
  private static boolean a(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool2 = false;
    AppMethodBeat.i(284794);
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
          Log.d("MultiAvcEncoder[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
        }
      }
      else
      {
        AppMethodBeat.o(284794);
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(284765);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool2 = bool3;
      if (8 <= this.wUj)
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
                Log.i("MultiAvcEncoder[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.wUj + ", MIME:" + paramString);
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
    AppMethodBeat.o(284765);
    return bool2;
  }
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(284787);
    bool2 = false;
    bool1 = bool2;
    if (com.tencent.mm.compatible.util.d.rb(23))
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
          Log.e("MultiAvcEncoder[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
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
        Log.i("MultiAvcEncoder[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      Log.i("MultiAvcEncoder[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
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
    AppMethodBeat.o(284787);
    return bool1;
  }
  
  public static boolean aNb(String paramString)
  {
    AppMethodBeat.i(284775);
    boolean bool1;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label265;
        }
        i = MediaCodecList.getCodecCount();
        i -= 1;
        bool2 = false;
        bool1 = bool2;
        if (i >= 0) {
          bool1 = bool2;
        }
      }
      catch (Exception paramString)
      {
        int i;
        boolean bool2;
        Object localObject;
        String[] arrayOfString1;
        int j;
        boolean bool3;
        int k;
        bool1 = false;
      }
      try
      {
        localObject = MediaCodecList.getCodecInfoAt(i);
        bool1 = bool2;
        Log.i("MultiAvcEncoder[HWEnc]", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
        bool1 = bool2;
        arrayOfString1 = ((MediaCodecInfo)localObject).getSupportedTypes();
        bool1 = bool2;
        localObject = ((MediaCodecInfo)localObject).getName();
        j = 0;
        bool1 = bool2;
        if (j < arrayOfString1.length)
        {
          bool3 = bool2;
          bool1 = bool2;
          if (arrayOfString1[j].equalsIgnoreCase(paramString))
          {
            bool1 = bool2;
            String[] arrayOfString2 = supportedH264HwCodecPrefixes;
            bool1 = bool2;
            int m = arrayOfString2.length;
            k = 0;
            bool3 = bool2;
            if (k < m)
            {
              bool1 = bool2;
              bool3 = ((String)localObject).startsWith(arrayOfString2[k]);
              if (!bool3) {}
            }
          }
        }
      }
      catch (Exception paramString)
      {
        break label225;
      }
      try
      {
        Log.i("MultiAvcEncoder[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
        bool2 = true;
        k += 1;
      }
      catch (Exception paramString)
      {
        bool1 = true;
        break label225;
      }
      j += 1;
      bool2 = bool3;
      continue;
      i -= 1;
      continue;
      label225:
      Log.printErrStackTrace("MultiAvcEncoder[HWEnc]", paramString, "SupportAvcCodec error: %s", new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      AppMethodBeat.o(284775);
      return bool1;
      label265:
      bool1 = false;
    }
  }
  
  private static String cg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(284820);
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
    AppMethodBeat.o(284820);
    return str1;
  }
  
  private static ArrayList<Integer> ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(284828);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = cg(paramArrayOfByte);
    String str = cg(new byte[] { 0, 0, 0, 1 });
    Log.d("MultiAvcEncoder[HWEnc]", "parent: " + paramArrayOfByte + ", child:" + str);
    for (;;)
    {
      int j = paramArrayOfByte.indexOf(str, i);
      if (j == -1) {
        break;
      }
      Log.d("MultiAvcEncoder[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + j);
      i = str.length() + j;
      localArrayList.add(Integer.valueOf(j / 2));
    }
    AppMethodBeat.o(284828);
    return localArrayList;
  }
  
  private int drc()
  {
    boolean bool1 = false;
    AppMethodBeat.i(284805);
    Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] InitHWEncoder!" + this.ENCODING);
    if (this.wUb != null) {
      StopEncoder();
    }
    MediaCodecInfo localMediaCodecInfo = selectCodec(this.ENCODING);
    int i;
    if (localMediaCodecInfo == null)
    {
      Log.e("MultiAvcEncoder[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.wUa = 2001;
      i = -this.wUa;
      AppMethodBeat.o(284805);
      return i;
    }
    Log.i("MultiAvcEncoder[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 1);
    String str = this.mediaFormat.getString("mime");
    this.wUi = 1;
    int j;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (com.tencent.mm.compatible.util.d.rb(23)))
    {
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x1) == 0)) {
        break label458;
      }
      i = 1;
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x4) == 0)) {
        break label463;
      }
      j = 1;
      label285:
      boolean bool2 = a(localMediaCodecInfo, str);
      if ((j == 0) || (!bool2)) {
        break label468;
      }
      this.mediaFormat.setInteger("profile", 8);
      this.mediaFormat.setInteger("level", 256);
      bool1 = true;
      label331:
      if (!bool1) {
        break label522;
      }
    }
    label522:
    for (this.wUi = this.mediaFormat.getInteger("profile");; this.wUi = 1)
    {
      this.mediaFormat.setInteger("bitrate-mode", 2);
      try
      {
        this.wUb = aa.u(str, false);
        SetBitRate(this.m_br_kbps);
        Log.i("MultiAvcEncoder[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.wUi);
        this.wUb.a(this.mediaFormat, null, 1);
        this.wUb.start();
        this.wUh = new g();
        AppMethodBeat.o(284805);
        return 2000;
      }
      catch (Exception localException)
      {
        label458:
        Log.e("MultiAvcEncoder[HWEnc]", " error:" + localException.toString());
        this.wUa = 2002;
        i = -this.wUa;
        AppMethodBeat.o(284805);
      }
      i = 0;
      break;
      label463:
      j = 0;
      break label285;
      label468:
      if (i != 0)
      {
        this.mediaFormat.setInteger("profile", 1);
        this.mediaFormat.setInteger("level", 256);
        bool1 = true;
        break label331;
      }
      if (localMediaCodecInfo == null) {
        break label331;
      }
      bool1 = a(localMediaCodecInfo, str, this.wUj);
      break label331;
    }
    return i;
  }
  
  public static int gfh()
  {
    AppMethodBeat.i(284833);
    Log.i("MultiAvcEncoder[HWEnc]", "closecodec: targetCodec: 8localClose: trueremoteClose: false" + "isEncoderTag: true");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)2);
    localByteBuffer.putShort((short)8);
    localByteBuffer.putShort((short)0);
    ac.ggR().LnJ.setAppCmd(Lnk, localByteBuffer.array(), 6);
    AppMethodBeat.o(284833);
    return 1;
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(284780);
    int m = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < m)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString1 = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString1.length)
        {
          if (arrayOfString1[j].equalsIgnoreCase(paramString))
          {
            String str = localMediaCodecInfo.getName();
            String[] arrayOfString2 = supportedH264HwCodecPrefixes;
            int n = arrayOfString2.length;
            int k = 0;
            while (k < n)
            {
              if (str.startsWith(arrayOfString2[k]))
              {
                Log.i("MultiAvcEncoder[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(str)));
                AppMethodBeat.o(284780);
                return localMediaCodecInfo;
              }
              k += 1;
            }
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(284780);
    return null;
  }
  
  public final void DoQosSvrCtrl()
  {
    AppMethodBeat.i(284889);
    int i = ac.ggR().LnJ.setAppCmd(Lnp, this.Lno.s2p, this.Lno.s2p.length);
    Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] EMethodGetQosPara ret[%d], len[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Lno.s2p.length) });
    Object localObject;
    if (i >= 0)
    {
      localObject = this.Lno;
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
      localObject = this.Lno;
      Log.d("MultiAvcEncoder[HWEnc]", "raw S2P:" + ((a)localObject).s2p);
      Log.d("MultiAvcEncoder[HWEnc]", "-S2P- iKbps:" + ((a)localObject).iKbps + ", fps:" + ((a)localObject).cFps + ", IP:" + ((a)localObject).cIPeriod + ", RS:" + ((a)localObject).cRSLevel + ", QPMin:" + ((a)localObject).cQPmin + ", QPMax:" + ((a)localObject).cQPmax + ", HPP:" + ((a)localObject).cHPPMaxLyr + ", SWitch:" + ((a)localObject).cSwitch + ", Reso:" + ((a)localObject).cResolution + ", Rsvd1:" + ((a)localObject).cRsvd1 + ", Rsvd2:" + ((a)localObject).cRsvd2 + ", Skip:" + ((a)localObject).cSkipFlag + ", IReq:" + ((a)localObject).cIReqFlag);
    }
    i = this.Lno.iKbps;
    if (this.m_br_kbps != i)
    {
      SetBitRate(i);
      Log.i("MultiAvcEncoder[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + i);
      this.m_br_kbps = i;
    }
    if ((1 == this.Lno.cIReqFlag) && (frameID > 0))
    {
      if (this.wUb != null)
      {
        Log.v("MultiAvcEncoder[HWEnc]", "steve: Sync frame request soon!");
        localObject = new Bundle();
        ((Bundle)localObject).putInt("request-sync", 0);
        this.wUb.setParameters((Bundle)localObject);
      }
      Log.i("MultiAvcEncoder[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
    }
    if (this.Lno.cFps != this.m_framerate) {
      this.m_framerate = this.Lno.cFps;
    }
    AppMethodBeat.o(284889);
  }
  
  /* Error */
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 710
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 199	com/tencent/mm/plugin/multitalk/model/k:m_br_kbps	I
    //   14: invokespecial 553	com/tencent/mm/plugin/multitalk/model/k:SetBitRate	(I)Z
    //   17: pop
    //   18: ldc 172
    //   20: ldc_w 712
    //   23: bipush 6
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   34: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: aload_0
    //   41: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   44: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: iload_2
    //   51: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: dup
    //   56: iconst_3
    //   57: iload_3
    //   58: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: dup
    //   63: iconst_4
    //   64: aload_0
    //   65: getfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   68: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: dup
    //   73: iconst_5
    //   74: aload_0
    //   75: getfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   78: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: invokestatic 185	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: iload_2
    //   86: aload_0
    //   87: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   90: if_icmpne +11 -> 101
    //   93: iload_3
    //   94: aload_0
    //   95: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   98: if_icmpeq +32 -> 130
    //   101: aload_0
    //   102: iload_2
    //   103: putfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   106: aload_0
    //   107: iload_3
    //   108: putfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   116: aload_0
    //   117: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   120: imul
    //   121: iconst_3
    //   122: imul
    //   123: iconst_2
    //   124: idiv
    //   125: newarray byte
    //   127: putfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   130: aload_0
    //   131: getfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   134: ifnonnull +22 -> 156
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   142: aload_0
    //   143: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   146: imul
    //   147: iconst_3
    //   148: imul
    //   149: iconst_2
    //   150: idiv
    //   151: newarray byte
    //   153: putfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   156: ldc 172
    //   158: ldc_w 712
    //   161: bipush 6
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_0
    //   169: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   172: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_0
    //   179: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   182: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: dup
    //   187: iconst_2
    //   188: iload_2
    //   189: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_3
    //   195: iload_3
    //   196: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: dup
    //   201: iconst_4
    //   202: aload_0
    //   203: getfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   206: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   209: aastore
    //   210: dup
    //   211: iconst_5
    //   212: aload_0
    //   213: getfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   216: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: invokestatic 185	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: ldc 172
    //   225: new 237	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 714
    //   232: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_0
    //   236: getfield 197	com/tencent/mm/plugin/multitalk/model/k:m_framerate	I
    //   239: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc_w 716
    //   245: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_0
    //   249: getfield 199	com/tencent/mm/plugin/multitalk/model/k:m_br_kbps	I
    //   252: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 718
    //   258: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload 4
    //   263: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 720
    //   269: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: getfield 204	com/tencent/mm/plugin/multitalk/model/k:Lno	Lcom/tencent/mm/plugin/multitalk/model/k$a;
    //   276: getfield 666	com/tencent/mm/plugin/multitalk/model/k$a:cSkipFlag	B
    //   279: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: ldc_w 722
    //   285: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: getfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   292: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: ldc_w 724
    //   298: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: getfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   305: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 726
    //   311: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: iload_2
    //   315: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 728
    //   321: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload_3
    //   325: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: ldc_w 730
    //   331: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_1
    //   335: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   338: ldc_w 732
    //   341: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_0
    //   345: getfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   348: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_0
    //   358: getfield 204	com/tencent/mm/plugin/multitalk/model/k:Lno	Lcom/tencent/mm/plugin/multitalk/model/k$a;
    //   361: getfield 666	com/tencent/mm/plugin/multitalk/model/k$a:cSkipFlag	B
    //   364: ifne +1896 -> 2260
    //   367: aload_0
    //   368: getfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   371: ifnull +1889 -> 2260
    //   374: aload_0
    //   375: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   378: istore 5
    //   380: aload_0
    //   381: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   384: istore 6
    //   386: invokestatic 302	com/tencent/mm/plugin/multitalk/model/ac:ggR	()Lcom/tencent/mm/plugin/multitalk/model/n;
    //   389: getfield 308	com/tencent/mm/plugin/multitalk/model/n:LnJ	Lcom/tencent/pb/talkroom/sdk/d;
    //   392: aload_1
    //   393: aload_0
    //   394: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   397: aload_0
    //   398: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   401: iload 4
    //   403: aload_0
    //   404: getfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   407: iload 5
    //   409: iload 6
    //   411: iload 4
    //   413: invokeinterface 736 9 0
    //   418: pop
    //   419: ldc 172
    //   421: ldc_w 712
    //   424: bipush 6
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: aload_0
    //   432: getfield 193	com/tencent/mm/plugin/multitalk/model/k:m_CapW	I
    //   435: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   438: aastore
    //   439: dup
    //   440: iconst_1
    //   441: aload_0
    //   442: getfield 195	com/tencent/mm/plugin/multitalk/model/k:m_CapH	I
    //   445: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aastore
    //   449: dup
    //   450: iconst_2
    //   451: iload_2
    //   452: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: aastore
    //   456: dup
    //   457: iconst_3
    //   458: iload_3
    //   459: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: dup
    //   464: iconst_4
    //   465: aload_0
    //   466: getfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   469: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   472: aastore
    //   473: dup
    //   474: iconst_5
    //   475: aload_0
    //   476: getfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   479: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: aastore
    //   483: invokestatic 185	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   486: aload_0
    //   487: getfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   490: astore_1
    //   491: aload_0
    //   492: aload_0
    //   493: getfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   496: aload_0
    //   497: getfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   500: imul
    //   501: iconst_3
    //   502: imul
    //   503: iconst_1
    //   504: ishr
    //   505: putfield 170	com/tencent/mm/plugin/multitalk/model/k:encLen	I
    //   508: aload_0
    //   509: getfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   512: iload 5
    //   514: if_icmpne +12 -> 526
    //   517: aload_0
    //   518: getfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   521: iload 6
    //   523: if_icmpeq +210 -> 733
    //   526: aload_0
    //   527: iload 5
    //   529: putfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   532: aload_0
    //   533: iload 6
    //   535: putfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   538: aload_0
    //   539: aload_0
    //   540: getfield 189	com/tencent/mm/plugin/multitalk/model/k:m_width	I
    //   543: aload_0
    //   544: getfield 191	com/tencent/mm/plugin/multitalk/model/k:m_height	I
    //   547: imul
    //   548: iconst_3
    //   549: imul
    //   550: iconst_1
    //   551: ishr
    //   552: putfield 170	com/tencent/mm/plugin/multitalk/model/k:encLen	I
    //   555: aload_0
    //   556: invokespecial 235	com/tencent/mm/plugin/multitalk/model/k:drc	()I
    //   559: istore_2
    //   560: iload_2
    //   561: istore_3
    //   562: iload_2
    //   563: ifge +172 -> 735
    //   566: ldc 172
    //   568: ldc_w 738
    //   571: iload_2
    //   572: invokestatic 319	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   575: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   578: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload_0
    //   582: iconst_0
    //   583: putfield 168	com/tencent/mm/plugin/multitalk/model/k:isRuning	Z
    //   586: aload_0
    //   587: invokespecial 512	com/tencent/mm/plugin/multitalk/model/k:StopEncoder	()V
    //   590: aload_0
    //   591: getfield 740	com/tencent/mm/plugin/multitalk/model/k:outputStream	Ljava/io/BufferedOutputStream;
    //   594: ifnull +17 -> 611
    //   597: aload_0
    //   598: getfield 740	com/tencent/mm/plugin/multitalk/model/k:outputStream	Ljava/io/BufferedOutputStream;
    //   601: invokevirtual 745	java/io/BufferedOutputStream:flush	()V
    //   604: aload_0
    //   605: getfield 740	com/tencent/mm/plugin/multitalk/model/k:outputStream	Ljava/io/BufferedOutputStream;
    //   608: invokevirtual 748	java/io/BufferedOutputStream:close	()V
    //   611: aload_0
    //   612: getfield 750	com/tencent/mm/plugin/multitalk/model/k:wUg	Ljava/io/BufferedOutputStream;
    //   615: ifnull +17 -> 632
    //   618: aload_0
    //   619: getfield 750	com/tencent/mm/plugin/multitalk/model/k:wUg	Ljava/io/BufferedOutputStream;
    //   622: invokevirtual 745	java/io/BufferedOutputStream:flush	()V
    //   625: aload_0
    //   626: getfield 750	com/tencent/mm/plugin/multitalk/model/k:wUg	Ljava/io/BufferedOutputStream;
    //   629: invokevirtual 748	java/io/BufferedOutputStream:close	()V
    //   632: aload_0
    //   633: getfield 752	com/tencent/mm/plugin/multitalk/model/k:wUd	Landroid/media/MediaMuxer;
    //   636: ifnull +17 -> 653
    //   639: aload_0
    //   640: getfield 752	com/tencent/mm/plugin/multitalk/model/k:wUd	Landroid/media/MediaMuxer;
    //   643: invokevirtual 755	android/media/MediaMuxer:stop	()V
    //   646: aload_0
    //   647: getfield 752	com/tencent/mm/plugin/multitalk/model/k:wUd	Landroid/media/MediaMuxer;
    //   650: invokevirtual 756	android/media/MediaMuxer:release	()V
    //   653: ldc_w 710
    //   656: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   659: iload_2
    //   660: ireturn
    //   661: astore 13
    //   663: ldc 172
    //   665: new 237	java/lang/StringBuilder
    //   668: dup
    //   669: ldc 239
    //   671: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   674: aload 13
    //   676: invokevirtual 244	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   679: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: aload_0
    //   689: sipush 2003
    //   692: putfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   695: aload_0
    //   696: getfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   699: ineg
    //   700: istore_2
    //   701: goto -141 -> 560
    //   704: astore_1
    //   705: ldc 172
    //   707: new 237	java/lang/StringBuilder
    //   710: dup
    //   711: ldc_w 361
    //   714: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   717: aload_1
    //   718: invokevirtual 362	java/lang/Exception:toString	()Ljava/lang/String;
    //   721: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: goto -77 -> 653
    //   733: iconst_0
    //   734: istore_3
    //   735: getstatic 78	com/tencent/mm/plugin/multitalk/model/k:frameID	I
    //   738: bipush 100
    //   740: if_icmpgt +755 -> 1495
    //   743: aload_0
    //   744: getfield 750	com/tencent/mm/plugin/multitalk/model/k:wUg	Ljava/io/BufferedOutputStream;
    //   747: ifnull +748 -> 1495
    //   750: aload_0
    //   751: getfield 750	com/tencent/mm/plugin/multitalk/model/k:wUg	Ljava/io/BufferedOutputStream;
    //   754: aload_0
    //   755: getfield 141	com/tencent/mm/plugin/multitalk/model/k:wUc	[B
    //   758: iconst_0
    //   759: aload_0
    //   760: getfield 170	com/tencent/mm/plugin/multitalk/model/k:encLen	I
    //   763: invokevirtual 760	java/io/BufferedOutputStream:write	([BII)V
    //   766: iload_3
    //   767: istore_2
    //   768: aload_1
    //   769: ifnull +1450 -> 2219
    //   772: aload_0
    //   773: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   776: ifnull +1443 -> 2219
    //   779: aload_0
    //   780: iconst_0
    //   781: putfield 164	com/tencent/mm/plugin/multitalk/model/k:wUl	I
    //   784: invokestatic 766	java/lang/System:currentTimeMillis	()J
    //   787: lstore 11
    //   789: ldc 172
    //   791: new 237	java/lang/StringBuilder
    //   794: dup
    //   795: ldc_w 768
    //   798: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   801: aload_0
    //   802: getfield 170	com/tencent/mm/plugin/multitalk/model/k:encLen	I
    //   805: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: ldc_w 770
    //   811: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: getstatic 78	com/tencent/mm/plugin/multitalk/model/k:frameID	I
    //   817: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   820: ldc_w 772
    //   823: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: lload 11
    //   828: invokevirtual 775	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   831: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   837: aload_0
    //   838: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   841: invokevirtual 779	com/tencent/mm/compatible/deviceinfo/aa:aPD	()[Ljava/nio/ByteBuffer;
    //   844: astore 14
    //   846: aload_0
    //   847: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   850: invokevirtual 782	com/tencent/mm/compatible/deviceinfo/aa:aPE	()[Ljava/nio/ByteBuffer;
    //   853: astore 13
    //   855: aload_0
    //   856: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   859: ldc2_w 783
    //   862: invokevirtual 788	com/tencent/mm/compatible/deviceinfo/aa:dequeueInputBuffer	(J)I
    //   865: istore_3
    //   866: ldc 172
    //   868: ldc_w 790
    //   871: iload_3
    //   872: invokestatic 319	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   875: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   878: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   881: iload_3
    //   882: iflt +119 -> 1001
    //   885: aload_0
    //   886: getfield 145	com/tencent/mm/plugin/multitalk/model/k:mGeneratedIdx	J
    //   889: lstore 11
    //   891: aload_0
    //   892: getfield 197	com/tencent/mm/plugin/multitalk/model/k:m_framerate	I
    //   895: bipush 15
    //   897: invokestatic 796	java/lang/Math:max	(II)I
    //   900: bipush 30
    //   902: invokestatic 799	java/lang/Math:min	(II)I
    //   905: istore 4
    //   907: lload 11
    //   909: lconst_0
    //   910: lcmp
    //   911: ifeq +12 -> 923
    //   914: aload_0
    //   915: getfield 147	com/tencent/mm/plugin/multitalk/model/k:nAO	J
    //   918: lconst_0
    //   919: lcmp
    //   920: ifne +580 -> 1500
    //   923: aload_0
    //   924: ldc2_w 800
    //   927: putfield 147	com/tencent/mm/plugin/multitalk/model/k:nAO	J
    //   930: aload_0
    //   931: getfield 147	com/tencent/mm/plugin/multitalk/model/k:nAO	J
    //   934: lstore 11
    //   936: ldc 172
    //   938: ldc_w 803
    //   941: lload 11
    //   943: invokestatic 806	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   946: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   949: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   952: aload 14
    //   954: iload_3
    //   955: aaload
    //   956: astore 14
    //   958: aload 14
    //   960: invokevirtual 810	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   963: pop
    //   964: aload 14
    //   966: aload_1
    //   967: iconst_0
    //   968: aload_0
    //   969: getfield 170	com/tencent/mm/plugin/multitalk/model/k:encLen	I
    //   972: invokevirtual 814	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   975: pop
    //   976: aload_0
    //   977: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   980: iload_3
    //   981: aload_0
    //   982: getfield 170	com/tencent/mm/plugin/multitalk/model/k:encLen	I
    //   985: lload 11
    //   987: iconst_0
    //   988: invokevirtual 817	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   991: aload_0
    //   992: aload_0
    //   993: getfield 145	com/tencent/mm/plugin/multitalk/model/k:mGeneratedIdx	J
    //   996: lconst_1
    //   997: ladd
    //   998: putfield 145	com/tencent/mm/plugin/multitalk/model/k:mGeneratedIdx	J
    //   1001: new 819	android/media/MediaCodec$BufferInfo
    //   1004: dup
    //   1005: invokespecial 820	android/media/MediaCodec$BufferInfo:<init>	()V
    //   1008: astore_1
    //   1009: aload_0
    //   1010: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1013: aload_1
    //   1014: aload_0
    //   1015: getfield 137	com/tencent/mm/plugin/multitalk/model/k:TIMEOUT_USEC	I
    //   1018: i2l
    //   1019: invokevirtual 824	com/tencent/mm/compatible/deviceinfo/aa:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1022: istore 6
    //   1024: ldc 172
    //   1026: ldc_w 826
    //   1029: iload 6
    //   1031: invokestatic 319	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1034: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1037: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1040: iload 6
    //   1042: bipush 254
    //   1044: if_icmpne +24 -> 1068
    //   1047: ldc 172
    //   1049: ldc_w 828
    //   1052: aload_0
    //   1053: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1056: invokevirtual 832	com/tencent/mm/compatible/deviceinfo/aa:getOutputFormat	()Landroid/media/MediaFormat;
    //   1059: invokestatic 351	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1062: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1065: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1068: ldc 172
    //   1070: ldc_w 826
    //   1073: iload 6
    //   1075: invokestatic 319	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1078: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1081: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1084: iload 6
    //   1086: iflt +472 -> 1558
    //   1089: aload 13
    //   1091: iload 6
    //   1093: aaload
    //   1094: astore 14
    //   1096: aload_1
    //   1097: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   1100: newarray byte
    //   1102: astore 15
    //   1104: aload 14
    //   1106: aload 15
    //   1108: invokevirtual 837	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1111: pop
    //   1112: aload_0
    //   1113: getfield 740	com/tencent/mm/plugin/multitalk/model/k:outputStream	Ljava/io/BufferedOutputStream;
    //   1116: ifnull +16 -> 1132
    //   1119: aload_0
    //   1120: getfield 740	com/tencent/mm/plugin/multitalk/model/k:outputStream	Ljava/io/BufferedOutputStream;
    //   1123: aload 15
    //   1125: iconst_0
    //   1126: aload 15
    //   1128: arraylength
    //   1129: invokevirtual 760	java/io/BufferedOutputStream:write	([BII)V
    //   1132: ldc 172
    //   1134: new 237	java/lang/StringBuilder
    //   1137: dup
    //   1138: ldc_w 839
    //   1141: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1144: aload_1
    //   1145: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   1148: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1157: aload_1
    //   1158: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   1161: iconst_2
    //   1162: if_icmpne +586 -> 1748
    //   1165: aload 15
    //   1167: invokestatic 844	com/tencent/mm/plugin/multitalk/model/k:ck	([B)Ljava/util/ArrayList;
    //   1170: astore 16
    //   1172: new 846	com/tencent/mm/protocal/protobuf/cyt
    //   1175: dup
    //   1176: invokespecial 847	com/tencent/mm/protocal/protobuf/cyt:<init>	()V
    //   1179: astore 17
    //   1181: iconst_0
    //   1182: istore 9
    //   1184: iconst_0
    //   1185: istore 10
    //   1187: iconst_0
    //   1188: istore 4
    //   1190: iconst_0
    //   1191: istore 5
    //   1193: iconst_0
    //   1194: istore_3
    //   1195: iconst_0
    //   1196: istore_2
    //   1197: aload 16
    //   1199: invokevirtual 849	java/util/ArrayList:size	()I
    //   1202: iconst_3
    //   1203: if_icmpne +363 -> 1566
    //   1206: aload_0
    //   1207: getfield 135	com/tencent/mm/plugin/multitalk/model/k:ENCODING	Ljava/lang/String;
    //   1210: ldc_w 259
    //   1213: invokevirtual 263	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1216: ifeq +350 -> 1566
    //   1219: aload 16
    //   1221: iconst_0
    //   1222: invokevirtual 852	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1225: checkcast 176	java/lang/Integer
    //   1228: invokevirtual 855	java/lang/Integer:intValue	()I
    //   1231: iconst_4
    //   1232: iadd
    //   1233: istore 8
    //   1235: aload 16
    //   1237: iconst_1
    //   1238: invokevirtual 852	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1241: checkcast 176	java/lang/Integer
    //   1244: invokevirtual 855	java/lang/Integer:intValue	()I
    //   1247: iconst_4
    //   1248: iadd
    //   1249: istore 4
    //   1251: aload 16
    //   1253: iconst_2
    //   1254: invokevirtual 852	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1257: checkcast 176	java/lang/Integer
    //   1260: invokevirtual 855	java/lang/Integer:intValue	()I
    //   1263: iconst_4
    //   1264: iadd
    //   1265: istore_3
    //   1266: iload 4
    //   1268: iload 8
    //   1270: isub
    //   1271: iconst_4
    //   1272: isub
    //   1273: istore 7
    //   1275: iload_3
    //   1276: iload 4
    //   1278: isub
    //   1279: iconst_4
    //   1280: isub
    //   1281: istore 5
    //   1283: aload_1
    //   1284: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   1287: iload_3
    //   1288: isub
    //   1289: istore_2
    //   1290: aload 17
    //   1292: aload 15
    //   1294: iload 8
    //   1296: iload 7
    //   1298: invokestatic 861	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   1301: putfield 865	com/tencent/mm/protocal/protobuf/cyt:aaDB	Lcom/tencent/mm/bx/b;
    //   1304: ldc 172
    //   1306: new 237	java/lang/StringBuilder
    //   1309: dup
    //   1310: ldc_w 867
    //   1313: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1316: iload 4
    //   1318: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1321: ldc_w 869
    //   1324: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: iload 5
    //   1329: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1332: ldc_w 871
    //   1335: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: iload_3
    //   1339: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1342: ldc_w 869
    //   1345: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: iload_2
    //   1349: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1352: ldc_w 873
    //   1355: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: iload 8
    //   1360: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1363: ldc_w 869
    //   1366: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: iload 7
    //   1371: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1374: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1380: aload_0
    //   1381: getfield 158	com/tencent/mm/plugin/multitalk/model/k:wUi	I
    //   1384: iconst_1
    //   1385: if_icmpeq +297 -> 1682
    //   1388: aload_0
    //   1389: getfield 156	com/tencent/mm/plugin/multitalk/model/k:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1392: aload 15
    //   1394: invokevirtual 877	com/tencent/mm/plugin/voip/model/g:cA	([B)Z
    //   1397: ifeq +285 -> 1682
    //   1400: aload_0
    //   1401: aload_0
    //   1402: getfield 156	com/tencent/mm/plugin/multitalk/model/k:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1405: getfield 880	com/tencent/mm/plugin/voip/model/g:UwP	I
    //   1408: putfield 162	com/tencent/mm/plugin/multitalk/model/k:wUk	I
    //   1411: aload_0
    //   1412: iconst_1
    //   1413: putfield 160	com/tencent/mm/plugin/multitalk/model/k:wUj	I
    //   1416: ldc 172
    //   1418: new 237	java/lang/StringBuilder
    //   1421: dup
    //   1422: ldc_w 882
    //   1425: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1428: aload_0
    //   1429: getfield 160	com/tencent/mm/plugin/multitalk/model/k:wUj	I
    //   1432: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1435: ldc_w 884
    //   1438: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: aload_0
    //   1442: getfield 162	com/tencent/mm/plugin/multitalk/model/k:wUk	I
    //   1445: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1454: aload_0
    //   1455: invokespecial 235	com/tencent/mm/plugin/multitalk/model/k:drc	()I
    //   1458: istore_2
    //   1459: ldc_w 710
    //   1462: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1465: iload_2
    //   1466: ireturn
    //   1467: astore 13
    //   1469: ldc 172
    //   1471: new 237	java/lang/StringBuilder
    //   1474: dup
    //   1475: ldc_w 361
    //   1478: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1481: aload 13
    //   1483: invokevirtual 362	java/lang/Exception:toString	()Ljava/lang/String;
    //   1486: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1495: iload_3
    //   1496: istore_2
    //   1497: goto -729 -> 768
    //   1500: aload_0
    //   1501: aload_0
    //   1502: getfield 147	com/tencent/mm/plugin/multitalk/model/k:nAO	J
    //   1505: ldc_w 885
    //   1508: iload 4
    //   1510: idiv
    //   1511: i2l
    //   1512: ladd
    //   1513: putfield 147	com/tencent/mm/plugin/multitalk/model/k:nAO	J
    //   1516: goto -586 -> 930
    //   1519: astore_1
    //   1520: ldc 172
    //   1522: new 237	java/lang/StringBuilder
    //   1525: dup
    //   1526: ldc_w 361
    //   1529: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1532: aload_1
    //   1533: invokevirtual 362	java/lang/Exception:toString	()Ljava/lang/String;
    //   1536: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1545: aload_0
    //   1546: sipush 2004
    //   1549: putfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1552: aload_0
    //   1553: getfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1556: ineg
    //   1557: istore_2
    //   1558: ldc_w 710
    //   1561: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1564: iload_2
    //   1565: ireturn
    //   1566: iload 9
    //   1568: istore 8
    //   1570: iload 10
    //   1572: istore 7
    //   1574: aload 16
    //   1576: invokevirtual 849	java/util/ArrayList:size	()I
    //   1579: iconst_2
    //   1580: if_icmpne -276 -> 1304
    //   1583: aload 16
    //   1585: iconst_0
    //   1586: invokevirtual 852	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1589: checkcast 176	java/lang/Integer
    //   1592: invokevirtual 855	java/lang/Integer:intValue	()I
    //   1595: iconst_4
    //   1596: iadd
    //   1597: istore 4
    //   1599: aload 16
    //   1601: iconst_1
    //   1602: invokevirtual 852	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1605: checkcast 176	java/lang/Integer
    //   1608: invokevirtual 855	java/lang/Integer:intValue	()I
    //   1611: iconst_4
    //   1612: iadd
    //   1613: istore_3
    //   1614: iload_3
    //   1615: iload 4
    //   1617: isub
    //   1618: iconst_4
    //   1619: isub
    //   1620: istore 5
    //   1622: aload_1
    //   1623: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   1626: iload_3
    //   1627: isub
    //   1628: istore_2
    //   1629: iload 9
    //   1631: istore 8
    //   1633: iload 10
    //   1635: istore 7
    //   1637: goto -333 -> 1304
    //   1640: astore_1
    //   1641: ldc 172
    //   1643: new 237	java/lang/StringBuilder
    //   1646: dup
    //   1647: ldc_w 887
    //   1650: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1653: aload_1
    //   1654: invokevirtual 244	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1657: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1663: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1666: aload_0
    //   1667: sipush 2005
    //   1670: putfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1673: aload_0
    //   1674: getfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1677: ineg
    //   1678: istore_2
    //   1679: goto -220 -> 1459
    //   1682: aload 17
    //   1684: iconst_4
    //   1685: putfield 890	com/tencent/mm/protocal/protobuf/cyt:aaDy	I
    //   1688: aload 17
    //   1690: aload 15
    //   1692: iload 4
    //   1694: iload 5
    //   1696: invokestatic 861	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   1699: putfield 893	com/tencent/mm/protocal/protobuf/cyt:aaDz	Lcom/tencent/mm/bx/b;
    //   1702: aload 17
    //   1704: aload 15
    //   1706: iload_3
    //   1707: iload_2
    //   1708: invokestatic 861	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   1711: putfield 896	com/tencent/mm/protocal/protobuf/cyt:aaDA	Lcom/tencent/mm/bx/b;
    //   1714: aload 17
    //   1716: invokevirtual 899	com/tencent/mm/protocal/protobuf/cyt:toByteArray	()[B
    //   1719: arraylength
    //   1720: istore_2
    //   1721: aload_0
    //   1722: aload 17
    //   1724: invokevirtual 899	com/tencent/mm/protocal/protobuf/cyt:toByteArray	()[B
    //   1727: aload_1
    //   1728: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   1731: iload_2
    //   1732: invokespecial 901	com/tencent/mm/plugin/multitalk/model/k:I	([BII)I
    //   1735: istore_2
    //   1736: iload_2
    //   1737: ifge +415 -> 2152
    //   1740: ldc_w 710
    //   1743: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1746: iload_2
    //   1747: ireturn
    //   1748: aload_0
    //   1749: getfield 158	com/tencent/mm/plugin/multitalk/model/k:wUi	I
    //   1752: iconst_1
    //   1753: if_icmpeq +124 -> 1877
    //   1756: aload_0
    //   1757: getfield 156	com/tencent/mm/plugin/multitalk/model/k:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1760: aload 15
    //   1762: invokevirtual 904	com/tencent/mm/plugin/voip/model/g:cB	([B)Z
    //   1765: ifeq +112 -> 1877
    //   1768: aload_0
    //   1769: aload_0
    //   1770: getfield 156	com/tencent/mm/plugin/multitalk/model/k:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1773: getfield 880	com/tencent/mm/plugin/voip/model/g:UwP	I
    //   1776: putfield 162	com/tencent/mm/plugin/multitalk/model/k:wUk	I
    //   1779: aload_0
    //   1780: iconst_1
    //   1781: putfield 160	com/tencent/mm/plugin/multitalk/model/k:wUj	I
    //   1784: ldc 172
    //   1786: new 237	java/lang/StringBuilder
    //   1789: dup
    //   1790: ldc_w 882
    //   1793: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1796: aload_0
    //   1797: getfield 160	com/tencent/mm/plugin/multitalk/model/k:wUj	I
    //   1800: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1803: ldc_w 884
    //   1806: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: aload_0
    //   1810: getfield 162	com/tencent/mm/plugin/multitalk/model/k:wUk	I
    //   1813: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1816: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1819: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1822: aload_0
    //   1823: invokespecial 235	com/tencent/mm/plugin/multitalk/model/k:drc	()I
    //   1826: istore_2
    //   1827: ldc_w 710
    //   1830: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1833: iload_2
    //   1834: ireturn
    //   1835: astore_1
    //   1836: ldc 172
    //   1838: new 237	java/lang/StringBuilder
    //   1841: dup
    //   1842: ldc_w 887
    //   1845: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1848: aload_1
    //   1849: invokevirtual 244	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1852: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1858: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1861: aload_0
    //   1862: sipush 2005
    //   1865: putfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1868: aload_0
    //   1869: getfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1872: ineg
    //   1873: istore_2
    //   1874: goto -47 -> 1827
    //   1877: aload_1
    //   1878: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   1881: ifeq +70 -> 1951
    //   1884: aload_1
    //   1885: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   1888: iconst_1
    //   1889: if_icmpeq +62 -> 1951
    //   1892: aload_0
    //   1893: sipush 2009
    //   1896: putfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1899: aload_0
    //   1900: getfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   1903: ineg
    //   1904: istore_2
    //   1905: ldc 172
    //   1907: new 237	java/lang/StringBuilder
    //   1910: dup
    //   1911: ldc_w 906
    //   1914: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1917: aload_1
    //   1918: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   1921: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1924: ldc_w 869
    //   1927: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: aload_1
    //   1931: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   1934: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1937: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1940: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1943: ldc_w 710
    //   1946: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1949: iload_2
    //   1950: ireturn
    //   1951: iconst_4
    //   1952: invokestatic 583	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1955: astore 16
    //   1957: aload 16
    //   1959: aload_1
    //   1960: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   1963: iconst_4
    //   1964: isub
    //   1965: invokevirtual 908	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1968: pop
    //   1969: aload 16
    //   1971: getstatic 911	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1974: invokevirtual 593	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1977: invokevirtual 601	java/nio/ByteBuffer:array	()[B
    //   1980: iconst_0
    //   1981: aload 15
    //   1983: iconst_0
    //   1984: iconst_4
    //   1985: invokestatic 915	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1988: invokestatic 766	java/lang/System:currentTimeMillis	()J
    //   1991: lstore 11
    //   1993: ldc 172
    //   1995: new 237	java/lang/StringBuilder
    //   1998: dup
    //   1999: ldc_w 917
    //   2002: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2005: aload_1
    //   2006: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   2009: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2012: ldc_w 919
    //   2015: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: aload_1
    //   2019: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   2022: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2025: ldc_w 770
    //   2028: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2031: getstatic 78	com/tencent/mm/plugin/multitalk/model/k:frameID	I
    //   2034: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2037: ldc_w 772
    //   2040: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: lload 11
    //   2045: invokevirtual 775	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2048: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2051: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2054: new 921	com/tencent/mm/protocal/protobuf/cys
    //   2057: dup
    //   2058: invokespecial 922	com/tencent/mm/protocal/protobuf/cys:<init>	()V
    //   2061: astore 16
    //   2063: aload 16
    //   2065: aload 15
    //   2067: iconst_0
    //   2068: aload_1
    //   2069: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   2072: invokestatic 861	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   2075: putfield 925	com/tencent/mm/protocal/protobuf/cys:aaDu	Lcom/tencent/mm/bx/b;
    //   2078: aload 16
    //   2080: iconst_1
    //   2081: putfield 928	com/tencent/mm/protocal/protobuf/cys:aaDv	I
    //   2084: aload 16
    //   2086: aload_0
    //   2087: getfield 152	com/tencent/mm/plugin/multitalk/model/k:Lnl	Ljava/util/LinkedList;
    //   2090: putfield 931	com/tencent/mm/protocal/protobuf/cys:aaDw	Ljava/util/LinkedList;
    //   2093: aload_0
    //   2094: getfield 154	com/tencent/mm/plugin/multitalk/model/k:Lnm	Ljava/util/LinkedList;
    //   2097: iconst_0
    //   2098: aload_1
    //   2099: getfield 835	android/media/MediaCodec$BufferInfo:size	I
    //   2102: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2105: invokevirtual 935	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   2108: pop
    //   2109: aload 16
    //   2111: aload_0
    //   2112: getfield 154	com/tencent/mm/plugin/multitalk/model/k:Lnm	Ljava/util/LinkedList;
    //   2115: putfield 938	com/tencent/mm/protocal/protobuf/cys:aaDx	Ljava/util/LinkedList;
    //   2118: aload 16
    //   2120: invokevirtual 939	com/tencent/mm/protocal/protobuf/cys:toByteArray	()[B
    //   2123: arraylength
    //   2124: istore_2
    //   2125: aload_0
    //   2126: aload 16
    //   2128: invokevirtual 939	com/tencent/mm/protocal/protobuf/cys:toByteArray	()[B
    //   2131: aload_1
    //   2132: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   2135: iload_2
    //   2136: invokespecial 901	com/tencent/mm/plugin/multitalk/model/k:I	([BII)I
    //   2139: istore_2
    //   2140: iload_2
    //   2141: ifge +11 -> 2152
    //   2144: ldc_w 710
    //   2147: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2150: iload_2
    //   2151: ireturn
    //   2152: aload_0
    //   2153: getfield 941	com/tencent/mm/plugin/multitalk/model/k:wUf	Z
    //   2156: ifeq +22 -> 2178
    //   2159: aload 14
    //   2161: ifnull +17 -> 2178
    //   2164: aload_0
    //   2165: getfield 752	com/tencent/mm/plugin/multitalk/model/k:wUd	Landroid/media/MediaMuxer;
    //   2168: aload_0
    //   2169: getfield 943	com/tencent/mm/plugin/multitalk/model/k:wUe	I
    //   2172: aload 14
    //   2174: aload_1
    //   2175: invokevirtual 947	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   2178: aload_1
    //   2179: getfield 842	android/media/MediaCodec$BufferInfo:flags	I
    //   2182: istore_2
    //   2183: getstatic 78	com/tencent/mm/plugin/multitalk/model/k:frameID	I
    //   2186: iconst_1
    //   2187: iadd
    //   2188: putstatic 78	com/tencent/mm/plugin/multitalk/model/k:frameID	I
    //   2191: aload_0
    //   2192: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   2195: iload 6
    //   2197: iconst_0
    //   2198: invokevirtual 951	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   2201: aload_0
    //   2202: getfield 206	com/tencent/mm/plugin/multitalk/model/k:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   2205: aload_1
    //   2206: aload_0
    //   2207: getfield 137	com/tencent/mm/plugin/multitalk/model/k:TIMEOUT_USEC	I
    //   2210: i2l
    //   2211: invokevirtual 824	com/tencent/mm/compatible/deviceinfo/aa:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2214: istore 6
    //   2216: goto -1132 -> 1084
    //   2219: aload_0
    //   2220: getfield 164	com/tencent/mm/plugin/multitalk/model/k:wUl	I
    //   2223: istore_3
    //   2224: aload_0
    //   2225: iload_3
    //   2226: iconst_1
    //   2227: iadd
    //   2228: putfield 164	com/tencent/mm/plugin/multitalk/model/k:wUl	I
    //   2231: iload_3
    //   2232: iconst_5
    //   2233: if_icmple -675 -> 1558
    //   2236: ldc 172
    //   2238: ldc_w 953
    //   2241: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2244: aload_0
    //   2245: sipush 2006
    //   2248: putfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   2251: aload_0
    //   2252: getfield 131	com/tencent/mm/plugin/multitalk/model/k:wUa	I
    //   2255: ineg
    //   2256: istore_2
    //   2257: goto -699 -> 1558
    //   2260: iconst_0
    //   2261: istore_2
    //   2262: aload 13
    //   2264: astore_1
    //   2265: goto -1497 -> 768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2268	0	this	k
    //   0	2268	1	paramArrayOfByte	byte[]
    //   0	2268	2	paramInt1	int
    //   0	2268	3	paramInt2	int
    //   0	2268	4	paramInt3	int
    //   378	1317	5	i	int
    //   384	1831	6	j	int
    //   1273	363	7	k	int
    //   1233	399	8	m	int
    //   1182	448	9	n	int
    //   1185	449	10	i1	int
    //   787	1257	11	l	long
    //   7	1	13	localObject1	Object
    //   661	14	13	localException1	Exception
    //   853	237	13	arrayOfByteBuffer	ByteBuffer[]
    //   1467	796	13	localException2	Exception
    //   844	1329	14	localObject2	Object
    //   1102	964	15	arrayOfByte	byte[]
    //   1170	957	16	localObject3	Object
    //   1179	544	17	localcyt	com.tencent.mm.protocal.protobuf.cyt
    // Exception table:
    //   from	to	target	type
    //   555	560	661	java/lang/Exception
    //   586	611	704	java/lang/Exception
    //   611	632	704	java/lang/Exception
    //   632	653	704	java/lang/Exception
    //   750	766	1467	java/lang/Exception
    //   779	881	1519	java/lang/Exception
    //   885	907	1519	java/lang/Exception
    //   914	923	1519	java/lang/Exception
    //   923	930	1519	java/lang/Exception
    //   930	952	1519	java/lang/Exception
    //   958	1001	1519	java/lang/Exception
    //   1001	1040	1519	java/lang/Exception
    //   1047	1068	1519	java/lang/Exception
    //   1068	1084	1519	java/lang/Exception
    //   1096	1132	1519	java/lang/Exception
    //   1132	1181	1519	java/lang/Exception
    //   1197	1266	1519	java/lang/Exception
    //   1283	1304	1519	java/lang/Exception
    //   1304	1454	1519	java/lang/Exception
    //   1500	1516	1519	java/lang/Exception
    //   1574	1614	1519	java/lang/Exception
    //   1622	1629	1519	java/lang/Exception
    //   1641	1679	1519	java/lang/Exception
    //   1682	1736	1519	java/lang/Exception
    //   1748	1822	1519	java/lang/Exception
    //   1836	1874	1519	java/lang/Exception
    //   1877	1943	1519	java/lang/Exception
    //   1951	2140	1519	java/lang/Exception
    //   2152	2159	1519	java/lang/Exception
    //   2164	2178	1519	java/lang/Exception
    //   2178	2216	1519	java/lang/Exception
    //   1454	1459	1640	java/lang/Exception
    //   1822	1827	1835	java/lang/Exception
  }
  
  public final boolean gfi()
  {
    AppMethodBeat.i(284895);
    Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] cRsvd1: " + this.Lno.cRsvd1);
    if ((this.Lno.cRsvd1 & 0x1) == 1)
    {
      AppMethodBeat.o(284895);
      return true;
    }
    AppMethodBeat.o(284895);
    return false;
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
      AppMethodBeat.i(284696);
      this.s2p = new byte[14];
      AppMethodBeat.o(284696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.k
 * JD-Core Version:    0.7.0.1
 */