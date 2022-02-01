package com.tencent.mm.plugin.voip.model;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.f.h;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import java.io.BufferedOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
  public LinkedList<cyu> Lnl;
  public LinkedList<Integer> Lnm;
  public int Lnn;
  private int TIMEOUT_USEC;
  l UvO;
  private int UwA;
  private byte[] UwB;
  private byte[] UwC;
  private ByteBuffer UwD;
  private boolean UwE;
  private final int UwF;
  b UwG;
  public Surface UwH;
  public a UwI;
  public int UwJ;
  public int UwK;
  public byte[] configbyte;
  public int encLen;
  public boolean isRuning;
  private int mCodecType;
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
    AppMethodBeat.i(177015);
    streamqueuesize = 100;
    frameID = 0;
    path = com.tencent.mm.loader.i.b.bmz();
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
    this.wUa = 0;
    this.ENCODING = "h264";
    this.TIMEOUT_USEC = 12000;
    this.mCodecType = 8;
    this.UwA = 0;
    this.mProfileCfg = 1;
    this.UwB = null;
    this.UwC = null;
    this.wUc = null;
    this.UwD = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.nAO = 0L;
    this.UvO = null;
    this.Lnl = new LinkedList();
    this.Lnm = new LinkedList();
    this.wUh = null;
    this.wUi = 0;
    this.wUj = 8;
    this.wUk = 0;
    this.wUl = 0;
    this.Lnn = 0;
    Object localObject = com.tencent.mm.util.i.agtt;
    this.UwF = com.tencent.mm.util.i.a(b.a.agsJ, 0);
    this.isRuning = false;
    this.encLen = 0;
    this.UwJ = 640;
    this.UwK = 480;
    this.mPrevResolution = 8;
    this.m_width = paramInt1;
    this.m_height = paramInt2;
    this.m_CapW = paramInt1;
    this.m_CapH = paramInt2;
    this.ENCODING = paramString;
    this.m_framerate = paramInt3;
    this.m_br_kbps = paramInt4;
    this.mProfileCfg = paramInt5;
    this.UwE = h.ibI();
    localObject = new StringBuilder("licaguo: mUsingSurfaceInput = ");
    if (this.UwE) {}
    for (paramString = "true";; paramString = "false")
    {
      Log.i("MicroMsg.AvcEncoder", paramString);
      if (this.UwE) {
        this.TIMEOUT_USEC = 5000;
      }
      frameID = 0;
      this.mGeneratedIdx = 0L;
      this.UwG = new b();
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
      this.UwD = null;
      this.wUl = 0;
      this.Lnn = 0;
      this.nAO = 0L;
      AppMethodBeat.o(114837);
      return;
    }
  }
  
  private int I(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114844);
    int i;
    if ((paramArrayOfByte != null) && (this.UvO.UyU != null))
    {
      i = VFMT_i264;
      if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
        i = VFMT_HEVC_HW;
      }
      i = this.UvO.UyU.videoEncodeToSend(paramArrayOfByte, paramInt2, this.m_width, paramInt1, i);
      if (i >= 0)
      {
        this.Lnn = 0;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114844);
      return paramInt1;
      MakeIFrame();
      Log.e("MicroMsg.AvcEncoder", "licaguo: type = " + paramInt1 + ", length = " + paramInt2 + ", ret = " + i);
      paramInt1 = this.Lnn;
      this.Lnn = (paramInt1 + 1);
      if (paramInt1 > 5)
      {
        this.wUa = 2008;
        paramInt1 = -this.wUa;
        Log.e("MicroMsg.AvcEncoder", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(paramInt1)));
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  private void MakeIFrame()
  {
    AppMethodBeat.i(293302);
    if (this.wUb != null)
    {
      Log.v("MicroMsg.AvcEncoder", "steve: Sync frame request soon!");
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      try
      {
        this.wUb.setParameters(localBundle);
        AppMethodBeat.o(293302);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AvcEncoder", "make I failed, just ignored, exception: ".concat(String.valueOf(localException)));
      }
    }
    AppMethodBeat.o(293302);
  }
  
  private boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(114843);
    try
    {
      if (this.wUb != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        Log.v("MicroMsg.AvcEncoder", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.wUb.setParameters(localBundle);
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
  
  private void StopEncoder()
  {
    AppMethodBeat.i(114838);
    try
    {
      com.tencent.mm.plugin.voip.f.e locale = com.tencent.mm.plugin.voip.f.e.ULA;
      com.tencent.mm.plugin.voip.f.e.GM(false);
      if (this.wUb != null)
      {
        Log.i("MicroMsg.AvcEncoder", "licaguo, now we call StopEncoder");
        this.wUb.signalEndOfInputStream();
        if ((this.UwE) && (this.UwI != null)) {
          this.UwI.u(this.UwH);
        }
        this.wUb.stop();
        this.wUb.release();
      }
      this.wUb = null;
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
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(114833);
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
                Log.i("MicroMsg.AvcEncoder", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.wUj + ", MIME:" + paramString);
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
    if (d.rb(23))
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
  
  private static String cg(byte[] paramArrayOfByte)
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
  
  private static ArrayList<Integer> ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114841);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramArrayOfByte = cg(paramArrayOfByte);
    String str = cg(new byte[] { 0, 0, 0, 1 });
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
    AppMethodBeat.i(293304);
    int i = Math.min(Math.max(this.m_framerate, 15), 30);
    if ((paramLong == 0L) || (this.nAO == 0L)) {}
    for (this.nAO = 132L;; this.nAO = (1000000 / i + paramLong))
    {
      paramLong = this.nAO;
      AppMethodBeat.o(293304);
      return paramLong;
      paramLong = this.nAO;
    }
  }
  
  private int drc()
  {
    AppMethodBeat.i(114836);
    if (this.wUb != null) {
      StopEncoder();
    }
    String str1 = this.ENCODING;
    int m = MediaCodecList.getCodecCount();
    int i = 0;
    Object localObject;
    int j;
    label59:
    int k;
    if (i < m)
    {
      localObject = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)localObject).isEncoder())
      {
        String[] arrayOfString1 = ((MediaCodecInfo)localObject).getSupportedTypes();
        j = 0;
        if (j < arrayOfString1.length) {
          if (arrayOfString1[j].equalsIgnoreCase(str1))
          {
            String str2 = ((MediaCodecInfo)localObject).getName();
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
      if (localObject != null) {
        break label209;
      }
      Log.e("MicroMsg.AvcEncoder", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.wUa = 2001;
      i = -this.wUa;
      AppMethodBeat.o(114836);
      return i;
      k += 1;
      break label97;
      j += 1;
      break label59;
      i += 1;
      break;
      localObject = null;
    }
    label209:
    Log.i("MicroMsg.AvcEncoder", "steve: found HW codec: " + ((MediaCodecInfo)localObject).getName());
    Log.i("MicroMsg.AvcEncoder", "licaguo: InitHWEncoder width = " + this.m_width + " height = " + this.m_height);
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    label441:
    label459:
    boolean bool;
    if (this.UwE)
    {
      this.mediaFormat.setInteger("color-format", 2130708361);
      Log.i("MicroMsg.AvcEncoder", "InitHWEncoder with surface encode");
      this.mediaFormat.setInteger("stride", this.m_width);
      this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
      this.mediaFormat.setInteger("frame-rate", this.m_framerate);
      this.mediaFormat.setInteger("i-frame-interval", 4);
      str1 = this.mediaFormat.getString("mime");
      this.wUi = 1;
      if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a((MediaCodecInfo)localObject)) && (d.rb(23)))
      {
        if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x1) == 0)) {
          break label741;
        }
        i = 1;
        if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x4) == 0)) {
          break label746;
        }
        j = 1;
        bool = a((MediaCodecInfo)localObject, str1);
        if ((j == 0) || (!bool)) {
          break label751;
        }
        this.mediaFormat.setInteger("profile", 8);
        this.mediaFormat.setInteger("level", 256);
        bool = true;
      }
    }
    for (;;)
    {
      label506:
      if (bool) {}
      for (this.wUi = this.mediaFormat.getInteger("profile");; this.wUi = 1)
      {
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try
        {
          this.wUb = aa.u(str1, false);
          Log.i("MicroMsg.AvcEncoder", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.wUi);
          this.wUb.a(this.mediaFormat, null, 1);
          if (this.UwE) {
            this.UwH = this.wUb.createInputSurface();
          }
          this.wUb.start();
          localObject = com.tencent.mm.plugin.voip.f.e.ULA;
          com.tencent.mm.plugin.voip.f.e.GM(true);
          if ((this.UwE) && (this.UwI != null)) {
            this.UwI.f(this.UwH, this.m_width, this.m_height);
          }
          this.wUh = new g();
          AppMethodBeat.o(114836);
          return 2000;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.AvcEncoder", localException, "InitHWEncoder error:" + localException.toString(), new Object[0]);
          this.wUa = 2002;
          i = -this.wUa;
          AppMethodBeat.o(114836);
          return i;
        }
        if (d.rd(30))
        {
          this.mediaFormat.setInteger("color-format", 20);
          Log.i("MicroMsg.AvcEncoder", "licaguo InitHWEncoder with csp YUV420PP");
          break;
        }
        this.mediaFormat.setInteger("color-format", 21);
        Log.i("MicroMsg.AvcEncoder", "licaguo InitHWEncoder with csp YUV420SP, aka NV12");
        break;
        label741:
        i = 0;
        break label441;
        label746:
        j = 0;
        break label459;
        label751:
        if (i != 0)
        {
          this.mediaFormat.setInteger("profile", 1);
          this.mediaFormat.setInteger("level", 256);
          bool = true;
          break label506;
        }
        if (localObject == null) {
          break label870;
        }
        bool = a((MediaCodecInfo)localObject, str1, this.wUj);
        break label506;
      }
      label870:
      bool = false;
    }
  }
  
  public final void DoQosSvrCtrl()
  {
    AppMethodBeat.i(293328);
    int k;
    int j;
    if ((this.UvO != null) && (this.UvO.UyU != null))
    {
      if ((this.UvO != null) && (this.UvO.UyU != null) && (this.UvO.UyU.setAppCmd(EMethodGetQosPara, this.UwG.s2p, this.UwG.s2p.length) >= 0))
      {
        Object localObject = this.UwG;
        ByteBuffer localByteBuffer = ByteBuffer.wrap(((b)localObject).s2p);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        ((b)localObject).iKbps = localByteBuffer.getShort();
        ((b)localObject).cFps = localByteBuffer.get();
        ((b)localObject).cIPeriod = localByteBuffer.get();
        ((b)localObject).cRSLevel = localByteBuffer.get();
        ((b)localObject).cQPmin = localByteBuffer.get();
        ((b)localObject).cQPmax = localByteBuffer.get();
        ((b)localObject).cHPPMaxLyr = localByteBuffer.get();
        ((b)localObject).cSwitch = localByteBuffer.get();
        ((b)localObject).cResolution = localByteBuffer.get();
        ((b)localObject).cRsvd1 = localByteBuffer.get();
        ((b)localObject).cRsvd2 = localByteBuffer.get();
        ((b)localObject).cSkipFlag = localByteBuffer.get();
        ((b)localObject).cIReqFlag = localByteBuffer.get();
        ((b)localObject).UwL = localByteBuffer.getShort();
        ((b)localObject).UwM = localByteBuffer.getShort();
        int m = this.UwG.UwL;
        k = this.UwG.UwM;
        if (1 == (this.UwG.cRsvd1 & 0x1))
        {
          if (8 != this.UwG.cRsvd1 >> 1) {
            break label649;
          }
          this.mCodecType = 8;
          this.ENCODING = "video/avc";
        }
        j = k;
        i = m;
        if (!v2protocal.UDn) {
          if (m < 1280)
          {
            j = k;
            i = m;
            if (k < 1280) {}
          }
          else
          {
            i = ((m >> 1) + 8) / 16 * 16;
            j = ((k >> 1) + 8) / 16 * 16;
          }
        }
        if (this.UwF == 0)
        {
          localObject = com.tencent.mm.plugin.voip.f.e.ULA;
          com.tencent.mm.plugin.voip.f.e.fu(this.UwG.UwL, this.UwG.UwM);
        }
        localObject = com.tencent.mm.plugin.voip.f.e.ULA;
        com.tencent.mm.plugin.voip.f.e.GN(false);
        this.UwJ = i;
        this.UwK = j;
      }
      k = this.UwG.iKbps;
      if (this.wUi != 8) {
        break label677;
      }
    }
    label649:
    label677:
    for (int i = 1;; i = 0)
    {
      j = k;
      if (i == 0)
      {
        double d = Math.max(Math.min(this.UvO.UyU.UEI, 30), 0) * 1.0D / 100.0D;
        j = (int)(k * (d + 1.0D));
      }
      if (this.m_br_kbps != j)
      {
        SetBitRate(j);
        Log.i("MicroMsg.AvcEncoder", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + j + ", tuneRatio:" + this.UvO.UyU.UEI);
        this.m_br_kbps = j;
      }
      if ((1 == this.UwG.cIReqFlag) && (frameID > 0))
      {
        MakeIFrame();
        Log.i("MicroMsg.AvcEncoder", "steve[QoS]: Force I Frame! frameID: " + frameID);
      }
      if (this.UwG.cFps != this.m_framerate) {
        this.m_framerate = this.UwG.cFps;
      }
      AppMethodBeat.o(293328);
      return;
      if (4 != this.UwG.cRsvd1 >> 1) {
        break;
      }
      this.mCodecType = 4;
      this.ENCODING = "video/hevc";
      break;
    }
  }
  
  public final int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(293322);
    int j = 0;
    int i;
    long l;
    int k;
    if ((this.UwG.cSkipFlag == 0) && (this.UvO != null) && (this.UvO.UyU != null))
    {
      if (!this.UwE)
      {
        if ((paramInt1 != this.m_CapW) || (paramInt2 != this.m_CapH) || (this.UwD == null))
        {
          this.m_CapW = paramInt1;
          this.m_CapH = paramInt2;
          this.UwD = ByteBuffer.allocateDirect(this.m_CapW * this.m_CapH * 3 / 2);
        }
        i = 1;
        if (d.rd(30))
        {
          i = 0;
          paramBoolean = true;
        }
        if (paramBoolean)
        {
          l = Util.currentTicks();
          paramInt3 = this.UvO.UyU.videoHWProcess3(paramByteBuffer, paramByteBuffer.capacity(), this.m_CapW, this.m_CapH, paramInt3, this.UwD, i);
          if (paramInt3 < 0)
          {
            Log.e("MicroMsg.AvcEncoder", "videoHWProcess2 return error code: ".concat(String.valueOf(paramInt3)));
            gfg();
            AppMethodBeat.o(293322);
            return -2010;
          }
          paramByteBuffer = com.tencent.mm.plugin.voip.video.render.i.USW;
          com.tencent.mm.plugin.voip.video.render.i.bj(0, Util.ticksToNow(l));
          paramByteBuffer = this.UwD;
          i = this.UvO.UyU.field_HWEncW;
          k = this.UvO.UyU.field_HWEncH;
          if ((this.UwF != 0) && (com.tencent.mm.plugin.voip.f.e.ULB > 0) && (com.tencent.mm.plugin.voip.f.e.ULC > 0))
          {
            i = com.tencent.mm.plugin.voip.f.e.ULB;
            k = com.tencent.mm.plugin.voip.f.e.ULC;
            j = paramInt3;
            paramInt3 = k;
          }
        }
      }
      while ((this.m_width != i) || (this.m_height != paramInt3) || (this.wUb == null) || (this.UwA != this.mCodecType))
      {
        Log.i("MicroMsg.AvcEncoder", "restart encoder! clipWH:" + paramInt1 + "x" + paramInt2 + ", wh:" + this.m_width + "x" + this.m_height + ", mCodecTypePrev: " + this.UwA + ", mCodecType: " + this.mCodecType);
        this.m_width = i;
        this.m_height = paramInt3;
        this.encLen = (this.m_width * this.m_height * 3 >> 1);
        try
        {
          j = drc();
          if (j < 0)
          {
            Log.e("MicroMsg.AvcEncoder", "mediacodec init failed, stop HW encoding! ret: ".concat(String.valueOf(j)));
            gfg();
            AppMethodBeat.o(293322);
            return j;
            if ((this.m_width != i) || (this.m_height != k)) {
              Log.i("MicroMsg.AvcEncoder", "yuv update enc size:[%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
            }
            j = paramInt3;
            paramInt3 = k;
            continue;
            paramInt3 = paramInt2;
            i = paramInt1;
            continue;
            if ((paramInt1 != this.m_CapW) || (paramInt2 != this.m_CapH))
            {
              Log.i("MicroMsg.AvcEncoder", "update CapW = " + paramInt1 + ", CapH = " + paramInt2);
              this.m_CapW = paramInt1;
              this.m_CapH = paramInt2;
            }
            j = this.UvO.UyU.videoGetEncWH(paramInt1, paramInt2);
            i = this.UvO.UyU.field_HWEncW;
            paramInt3 = this.UvO.UyU.field_HWEncH;
            if ((this.UwF != 0) && (com.tencent.mm.plugin.voip.f.e.ULB > 0) && (com.tencent.mm.plugin.voip.f.e.ULC > 0))
            {
              i = com.tencent.mm.plugin.voip.f.e.ULB;
              paramInt3 = com.tencent.mm.plugin.voip.f.e.ULC;
              paramByteBuffer = null;
              continue;
            }
            if ((this.m_width != i) || (this.m_height != paramInt3)) {
              Log.i("MicroMsg.AvcEncoder", "surface update enc size:[%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
            }
            paramByteBuffer = null;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.AvcEncoder", "mediacodec init error: " + localException.getMessage());
            this.wUa = 2003;
            j = -this.wUa;
          }
          this.UwA = this.mCodecType;
          if (this.UwE)
          {
            AppMethodBeat.o(293322);
            return 0;
          }
        }
      }
    }
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if (this.wUb != null) {}
      for (;;)
      {
        Object localObject1;
        try
        {
          this.wUl = 0;
          if (!this.UwE)
          {
            localObject1 = this.wUb.aPD();
            paramInt2 = this.wUb.dequeueInputBuffer(-1L);
            if (paramInt2 >= 0)
            {
              l = computePresentationTime(this.mGeneratedIdx);
              paramByteBuffer.rewind().limit(this.encLen);
              localObject1 = localObject1[paramInt2];
              ((ByteBuffer)localObject1).clear();
              ((ByteBuffer)localObject1).put(paramByteBuffer);
              paramByteBuffer.clear();
              this.wUb.a(paramInt2, this.encLen, l, 0);
              this.mGeneratedIdx += 1L;
            }
          }
          paramByteBuffer = this.wUb.aPE();
          localObject1 = new MediaCodec.BufferInfo();
          paramInt3 = this.wUb.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, this.TIMEOUT_USEC);
          paramInt2 = paramInt1;
          j = paramInt3;
          MediaFormat localMediaFormat;
          if (paramInt3 == -2)
          {
            localMediaFormat = this.wUb.getOutputFormat();
            Log.i("MicroMsg.AvcEncoder", "steve: encoder output format changed: ".concat(String.valueOf(localMediaFormat)));
            paramInt2 = paramInt1;
            j = paramInt3;
            if (localMediaFormat.containsKey("bitrate"))
            {
              paramInt2 = paramInt1;
              j = paramInt3;
              if (localMediaFormat.getInteger("bitrate") > this.m_br_kbps * 1000 * 1.5D)
              {
                Log.e("MicroMsg.AvcEncoder", "steve: bitrate NOT match!! real:" + localMediaFormat.getInteger("bitrate") + ", target:" + this.m_br_kbps);
                this.wUa = 2007;
                paramInt1 = this.wUa;
                paramInt1 = -paramInt1;
                AppMethodBeat.o(293322);
                return paramInt1;
                if (this.UwE) {
                  break;
                }
                AppMethodBeat.o(293322);
                return 0;
                if ((this.wUf) && (localMediaFormat != null)) {
                  this.wUd.writeSampleData(this.wUe, localMediaFormat, (MediaCodec.BufferInfo)localObject1);
                }
                paramInt2 = ((MediaCodec.BufferInfo)localObject1).flags;
                frameID += 1;
                this.wUb.releaseOutputBuffer(j, false);
                j = this.wUb.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, this.TIMEOUT_USEC);
              }
            }
          }
          paramInt1 = paramInt2;
          if (j >= 0)
          {
            localMediaFormat = paramByteBuffer[j];
            byte[] arrayOfByte = new byte[((MediaCodec.BufferInfo)localObject1).size];
            localMediaFormat.get(arrayOfByte);
            if (this.outputStream != null) {
              this.outputStream.write(arrayOfByte, 0, arrayOfByte.length);
            }
            if (((MediaCodec.BufferInfo)localObject1).flags == 2)
            {
              localObject2 = ck(arrayOfByte);
              cyt localcyt = new cyt();
              int n = 0;
              int i1 = 0;
              i = 0;
              paramInt3 = 0;
              paramInt2 = 0;
              paramInt1 = 0;
              int m;
              if ((((ArrayList)localObject2).size() == 3) && (this.ENCODING.equalsIgnoreCase("video/hevc")))
              {
                k = ((Integer)((ArrayList)localObject2).get(0)).intValue() + 4;
                i = ((Integer)((ArrayList)localObject2).get(1)).intValue() + 4;
                paramInt2 = ((Integer)((ArrayList)localObject2).get(2)).intValue() + 4;
                m = i - k - 4;
                paramInt3 = paramInt2 - i - 4;
                paramInt1 = ((MediaCodec.BufferInfo)localObject1).size - paramInt2;
                localcyt.aaDB = com.tencent.mm.bx.b.P(arrayOfByte, k, m);
                if (this.UwB == null) {
                  this.UwB = new byte[((MediaCodec.BufferInfo)localObject1).size];
                }
                if (this.UwB != null)
                {
                  if (((MediaCodec.BufferInfo)localObject1).size > this.UwB.length) {
                    this.UwB = new byte[((MediaCodec.BufferInfo)localObject1).size];
                  }
                  System.arraycopy(arrayOfByte, 0, this.UwB, 0, ((MediaCodec.BufferInfo)localObject1).size);
                }
                Log.d("MicroMsg.AvcEncoder", "sps start: " + i + ", len:" + paramInt3 + ", pps start:" + paramInt2 + ", len:" + paramInt1 + ", vps start: " + k + ", len:" + m);
                if ((this.wUi != 1) && (this.wUh.cA(arrayOfByte)))
                {
                  this.wUk = this.wUh.UwP;
                  this.wUj = 1;
                  Log.i("MicroMsg.AvcEncoder", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.wUj + ", checkCodeForBSlice:" + this.wUk);
                }
              }
              else
              {
                try
                {
                  paramInt1 = drc();
                  AppMethodBeat.o(293322);
                  return paramInt1;
                  m = i1;
                  k = n;
                  if (((ArrayList)localObject2).size() != 2) {
                    continue;
                  }
                  i = ((Integer)((ArrayList)localObject2).get(0)).intValue() + 4;
                  paramInt2 = ((Integer)((ArrayList)localObject2).get(1)).intValue() + 4;
                  paramInt3 = paramInt2 - i - 4;
                  paramInt1 = ((MediaCodec.BufferInfo)localObject1).size - paramInt2;
                  m = i1;
                  k = n;
                }
                catch (Exception paramByteBuffer)
                {
                  Log.e("MicroMsg.AvcEncoder", "mediacodec reinit error: " + paramByteBuffer.getMessage());
                  this.wUa = 2005;
                  paramInt1 = -this.wUa;
                  continue;
                }
              }
              localcyt.aaDy = 4;
              localcyt.aaDz = com.tencent.mm.bx.b.P(arrayOfByte, i, paramInt3);
              localcyt.aaDA = com.tencent.mm.bx.b.P(arrayOfByte, paramInt2, paramInt1);
              paramInt1 = localcyt.toByteArray().length;
              paramInt1 = I(localcyt.toByteArray(), ((MediaCodec.BufferInfo)localObject1).flags, paramInt1);
              if (paramInt1 >= 0) {
                continue;
              }
              AppMethodBeat.o(293322);
              return paramInt1;
            }
            if ((this.wUi != 1) && (this.wUh.cB(arrayOfByte)))
            {
              this.wUk = this.wUh.UwP;
              this.wUj = 1;
              Log.i("MicroMsg.AvcEncoder", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.wUj + ", checkCodeForBSlice:" + this.wUk);
              try
              {
                paramInt1 = drc();
                AppMethodBeat.o(293322);
                return paramInt1;
              }
              catch (Exception paramByteBuffer)
              {
                Log.e("MicroMsg.AvcEncoder", "mediacodec reinit error: " + paramByteBuffer.getMessage());
                this.wUa = 2005;
                paramInt1 = -this.wUa;
                continue;
              }
            }
            if ((((MediaCodec.BufferInfo)localObject1).flags != 0) && (((MediaCodec.BufferInfo)localObject1).flags != 1))
            {
              this.wUa = 2009;
              paramInt1 = -this.wUa;
              Log.i("MicroMsg.AvcEncoder", "steve:unknown frame error!!! type:" + ((MediaCodec.BufferInfo)localObject1).flags + ", len:" + ((MediaCodec.BufferInfo)localObject1).size);
              AppMethodBeat.o(293322);
              return paramInt1;
            }
            if (((MediaCodec.BufferInfo)localObject1).flags != 1) {
              break label2581;
            }
            Object localObject2 = new byte[this.UwB.length];
            System.arraycopy(arrayOfByte, 0, localObject2, 0, this.UwB.length);
            if (Arrays.equals((byte[])localObject2, this.UwB))
            {
              paramInt1 = this.UwB.length;
              Log.d("MicroMsg.AvcEncoder", "EQU!!!, head_len[%d]", new Object[] { Integer.valueOf(paramInt1) });
              localObject2 = ByteBuffer.allocate(4);
              ((ByteBuffer)localObject2).putInt(((MediaCodec.BufferInfo)localObject1).size - 4 - paramInt1);
              System.arraycopy(((ByteBuffer)localObject2).order(ByteOrder.BIG_ENDIAN).array(), 0, arrayOfByte, paramInt1, 4);
              localObject2 = new cys();
              ((cys)localObject2).aaDu = com.tencent.mm.bx.b.P(arrayOfByte, paramInt1, ((MediaCodec.BufferInfo)localObject1).size - paramInt1);
              ((cys)localObject2).aaDv = 1;
              ((cys)localObject2).aaDw = this.Lnl;
              this.Lnm.set(0, Integer.valueOf(((MediaCodec.BufferInfo)localObject1).size - paramInt1));
              ((cys)localObject2).aaDx = this.Lnm;
              paramInt1 = ((cys)localObject2).toByteArray().length;
              paramInt1 = I(((cys)localObject2).toByteArray(), ((MediaCodec.BufferInfo)localObject1).flags, paramInt1);
              if (paramInt1 >= 0) {
                continue;
              }
              AppMethodBeat.o(293322);
              return paramInt1;
            }
            if (this.UwC == null) {
              this.UwC = new byte[100];
            }
            if (((MediaCodec.BufferInfo)localObject1).size > 100)
            {
              paramInt1 = 100;
              System.arraycopy(arrayOfByte, 0, this.UwC, 0, paramInt1);
              localObject2 = ck(this.UwC);
              if ((((ArrayList)localObject2).size() != 3) || (!this.ENCODING.equalsIgnoreCase("video/avc"))) {
                break label2581;
              }
              paramInt2 = ((Integer)((ArrayList)localObject2).get(0)).intValue();
              paramInt3 = ((Integer)((ArrayList)localObject2).get(1)).intValue();
              paramInt1 = ((Integer)((ArrayList)localObject2).get(2)).intValue();
              i = paramInt3 - paramInt2;
              k = paramInt1 - paramInt3;
              Log.i("MicroMsg.AvcEncoder", "spsStart[%d], ppsStart[%d], frameStart[%d], spsLen[%d], ppsLen[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(k) });
              if (this.UwB.length < i + k) {
                this.UwB = new byte[i + k];
              }
              System.arraycopy(arrayOfByte, paramInt2, this.UwB, 0, i);
              System.arraycopy(arrayOfByte, k, this.UwB, i, k);
              localObject2 = new cyt();
              ((cyt)localObject2).aaDy = 4;
              ((cyt)localObject2).aaDz = com.tencent.mm.bx.b.P(arrayOfByte, paramInt2 + 4, i - 4);
              ((cyt)localObject2).aaDA = com.tencent.mm.bx.b.P(arrayOfByte, paramInt3 + 4, k - 4);
              paramInt2 = ((cyt)localObject2).toByteArray().length;
              I(((cyt)localObject2).toByteArray(), 2, paramInt2);
              continue;
            }
          }
          else
          {
            AppMethodBeat.o(293322);
          }
        }
        catch (Exception paramByteBuffer)
        {
          Log.printErrStackTrace("MicroMsg.AvcEncoder", paramByteBuffer, "DoMediaCodecEnc error:" + paramByteBuffer.toString(), new Object[0]);
          this.wUa = 2004;
          paramInt1 = -this.wUa;
        }
        for (;;)
        {
          return paramInt1;
          paramInt1 = ((MediaCodec.BufferInfo)localObject1).size;
          break;
          paramInt2 = this.wUl;
          this.wUl = (paramInt2 + 1);
          if (paramInt2 > 5)
          {
            this.wUa = 2006;
            paramInt1 = -this.wUa;
          }
        }
        label2581:
        paramInt1 = 0;
      }
      paramByteBuffer = null;
    }
  }
  
  /* Error */
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 1055
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore 5
    //   9: aconst_null
    //   10: astore 14
    //   12: iload_2
    //   13: aload_0
    //   14: getfield 225	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   17: if_icmpne +11 -> 28
    //   20: iload_3
    //   21: aload_0
    //   22: getfield 227	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   25: if_icmpeq +32 -> 57
    //   28: aload_0
    //   29: iload_2
    //   30: putfield 225	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   33: aload_0
    //   34: iload_3
    //   35: putfield 227	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 225	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   43: aload_0
    //   44: getfield 227	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   47: imul
    //   48: iconst_3
    //   49: imul
    //   50: iconst_2
    //   51: idiv
    //   52: newarray byte
    //   54: putfield 163	com/tencent/mm/plugin/voip/model/e:wUc	[B
    //   57: aload_0
    //   58: getfield 163	com/tencent/mm/plugin/voip/model/e:wUc	[B
    //   61: ifnonnull +22 -> 83
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 225	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   69: aload_0
    //   70: getfield 227	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   73: imul
    //   74: iconst_3
    //   75: imul
    //   76: iconst_2
    //   77: idiv
    //   78: newarray byte
    //   80: putfield 163	com/tencent/mm/plugin/voip/model/e:wUc	[B
    //   83: ldc 250
    //   85: new 241	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 1057
    //   92: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 229	com/tencent/mm/plugin/voip/model/e:m_framerate	I
    //   99: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 1059
    //   105: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 231	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   112: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: iload 5
    //   123: istore_2
    //   124: aload 14
    //   126: astore 13
    //   128: aload_0
    //   129: getfield 267	com/tencent/mm/plugin/voip/model/e:UwG	Lcom/tencent/mm/plugin/voip/model/e$b;
    //   132: getfield 734	com/tencent/mm/plugin/voip/model/e$b:cSkipFlag	B
    //   135: ifne +373 -> 508
    //   138: iload 5
    //   140: istore_2
    //   141: aload 14
    //   143: astore 13
    //   145: aload_0
    //   146: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   149: ifnull +359 -> 508
    //   152: iload 5
    //   154: istore_2
    //   155: aload 14
    //   157: astore 13
    //   159: aload_0
    //   160: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   163: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   166: ifnull +342 -> 508
    //   169: aload_0
    //   170: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   173: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   176: aload_1
    //   177: aload_1
    //   178: arraylength
    //   179: aload_0
    //   180: getfield 225	com/tencent/mm/plugin/voip/model/e:m_CapW	I
    //   183: aload_0
    //   184: getfield 227	com/tencent/mm/plugin/voip/model/e:m_CapH	I
    //   187: iload 4
    //   189: aload_0
    //   190: getfield 163	com/tencent/mm/plugin/voip/model/e:wUc	[B
    //   193: invokevirtual 1063	com/tencent/mm/plugin/voip/model/v2protocal:videoHWProcess	([BIIII[B)I
    //   196: istore_3
    //   197: iload_3
    //   198: ifge +32 -> 230
    //   201: ldc 250
    //   203: ldc_w 1065
    //   206: iload_3
    //   207: invokestatic 342	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   210: invokevirtual 346	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_0
    //   217: invokevirtual 794	com/tencent/mm/plugin/voip/model/e:gfg	()V
    //   220: ldc_w 1055
    //   223: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: sipush -2010
    //   229: ireturn
    //   230: aload_0
    //   231: getfield 163	com/tencent/mm/plugin/voip/model/e:wUc	[B
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 221	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   239: aload_0
    //   240: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   243: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   246: getfield 810	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   249: if_icmpne +20 -> 269
    //   252: aload_0
    //   253: getfield 223	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   256: aload_0
    //   257: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   260: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   263: getfield 813	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   266: if_icmpeq +206 -> 472
    //   269: ldc 250
    //   271: new 241	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 821
    //   278: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   285: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   288: getfield 810	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   291: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: ldc_w 823
    //   297: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_0
    //   301: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   304: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   307: getfield 813	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   310: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 825
    //   316: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 221	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   323: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 823
    //   329: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: getfield 223	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   336: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: aload_0
    //   347: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   350: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   353: getfield 810	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncW	I
    //   356: putfield 221	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   359: aload_0
    //   360: aload_0
    //   361: getfield 173	com/tencent/mm/plugin/voip/model/e:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   364: getfield 310	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   367: getfield 813	com/tencent/mm/plugin/voip/model/v2protocal:field_HWEncH	I
    //   370: putfield 223	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   373: aload_0
    //   374: aload_0
    //   375: getfield 221	com/tencent/mm/plugin/voip/model/e:m_width	I
    //   378: aload_0
    //   379: getfield 223	com/tencent/mm/plugin/voip/model/e:m_height	I
    //   382: imul
    //   383: iconst_3
    //   384: imul
    //   385: iconst_1
    //   386: ishr
    //   387: putfield 213	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   390: aload_0
    //   391: invokespecial 831	com/tencent/mm/plugin/voip/model/e:drc	()I
    //   394: istore_2
    //   395: iload_2
    //   396: istore_3
    //   397: iload_2
    //   398: ifge +74 -> 472
    //   401: ldc 250
    //   403: ldc_w 833
    //   406: iload_2
    //   407: invokestatic 342	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   410: invokevirtual 346	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   413: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_0
    //   417: invokevirtual 794	com/tencent/mm/plugin/voip/model/e:gfg	()V
    //   420: ldc_w 1055
    //   423: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: iload_2
    //   427: ireturn
    //   428: astore 13
    //   430: ldc 250
    //   432: new 241	java/lang/StringBuilder
    //   435: dup
    //   436: ldc_w 849
    //   439: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   442: aload 13
    //   444: invokevirtual 506	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   447: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload_0
    //   457: sipush 2003
    //   460: putfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   463: aload_0
    //   464: getfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   467: ineg
    //   468: istore_2
    //   469: goto -74 -> 395
    //   472: getstatic 96	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   475: bipush 100
    //   477: if_icmpgt +345 -> 822
    //   480: aload_0
    //   481: getfield 1067	com/tencent/mm/plugin/voip/model/e:wUg	Ljava/io/BufferedOutputStream;
    //   484: ifnull +338 -> 822
    //   487: aload_0
    //   488: getfield 1067	com/tencent/mm/plugin/voip/model/e:wUg	Ljava/io/BufferedOutputStream;
    //   491: aload_0
    //   492: getfield 163	com/tencent/mm/plugin/voip/model/e:wUc	[B
    //   495: iconst_0
    //   496: aload_0
    //   497: getfield 213	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   500: invokevirtual 938	java/io/BufferedOutputStream:write	([BII)V
    //   503: aload_1
    //   504: astore 13
    //   506: iload_3
    //   507: istore_2
    //   508: aload 13
    //   510: ifnull +1780 -> 2290
    //   513: aload_0
    //   514: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   517: ifnull +1773 -> 2290
    //   520: aload_0
    //   521: iconst_0
    //   522: putfield 190	com/tencent/mm/plugin/voip/model/e:wUl	I
    //   525: aload_0
    //   526: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   529: invokevirtual 853	com/tencent/mm/compatible/deviceinfo/aa:aPD	()[Ljava/nio/ByteBuffer;
    //   532: astore 14
    //   534: aload_0
    //   535: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   538: invokevirtual 884	com/tencent/mm/compatible/deviceinfo/aa:aPE	()[Ljava/nio/ByteBuffer;
    //   541: astore_1
    //   542: aload_0
    //   543: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   546: ldc2_w 854
    //   549: invokevirtual 859	com/tencent/mm/compatible/deviceinfo/aa:dequeueInputBuffer	(J)I
    //   552: istore_3
    //   553: iload_3
    //   554: iflt +63 -> 617
    //   557: aload_0
    //   558: aload_0
    //   559: getfield 169	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   562: invokespecial 861	com/tencent/mm/plugin/voip/model/e:computePresentationTime	(J)J
    //   565: lstore 11
    //   567: aload 14
    //   569: iload_3
    //   570: aaload
    //   571: astore 14
    //   573: aload 14
    //   575: invokevirtual 874	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   578: pop
    //   579: aload 14
    //   581: aload 13
    //   583: iconst_0
    //   584: aload_0
    //   585: getfield 213	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   588: invokevirtual 1070	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   591: pop
    //   592: aload_0
    //   593: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   596: iload_3
    //   597: aload_0
    //   598: getfield 213	com/tencent/mm/plugin/voip/model/e:encLen	I
    //   601: lload 11
    //   603: iconst_0
    //   604: invokevirtual 881	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 169	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   612: lconst_1
    //   613: ladd
    //   614: putfield 169	com/tencent/mm/plugin/voip/model/e:mGeneratedIdx	J
    //   617: new 886	android/media/MediaCodec$BufferInfo
    //   620: dup
    //   621: invokespecial 887	android/media/MediaCodec$BufferInfo:<init>	()V
    //   624: astore 13
    //   626: aload_0
    //   627: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   630: aload 13
    //   632: aload_0
    //   633: getfield 151	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   636: i2l
    //   637: invokevirtual 891	com/tencent/mm/compatible/deviceinfo/aa:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   640: istore 4
    //   642: iload_2
    //   643: istore_3
    //   644: iload 4
    //   646: istore 6
    //   648: iload 4
    //   650: bipush 254
    //   652: if_icmpne +245 -> 897
    //   655: aload_0
    //   656: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   659: invokevirtual 895	com/tencent/mm/compatible/deviceinfo/aa:getOutputFormat	()Landroid/media/MediaFormat;
    //   662: astore 14
    //   664: ldc 250
    //   666: ldc_w 897
    //   669: aload 14
    //   671: invokestatic 374	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   674: invokevirtual 346	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   677: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   680: iload_2
    //   681: istore_3
    //   682: iload 4
    //   684: istore 6
    //   686: aload 14
    //   688: ldc_w 604
    //   691: invokevirtual 900	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   694: ifeq +203 -> 897
    //   697: iload_2
    //   698: istore_3
    //   699: iload 4
    //   701: istore 6
    //   703: aload 14
    //   705: ldc_w 604
    //   708: invokevirtual 623	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   711: i2d
    //   712: aload_0
    //   713: getfield 231	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   716: sipush 1000
    //   719: imul
    //   720: i2d
    //   721: ldc2_w 901
    //   724: dmul
    //   725: dcmpl
    //   726: ifle +171 -> 897
    //   729: ldc 250
    //   731: new 241	java/lang/StringBuilder
    //   734: dup
    //   735: ldc_w 904
    //   738: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   741: aload 14
    //   743: ldc_w 604
    //   746: invokevirtual 623	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   749: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   752: ldc_w 906
    //   755: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload_0
    //   759: getfield 231	com/tencent/mm/plugin/voip/model/e:m_br_kbps	I
    //   762: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload_0
    //   772: sipush 2007
    //   775: putfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   778: aload_0
    //   779: getfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   782: istore_2
    //   783: iload_2
    //   784: ineg
    //   785: istore_2
    //   786: ldc_w 1055
    //   789: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   792: iload_2
    //   793: ireturn
    //   794: astore 13
    //   796: ldc 250
    //   798: new 241	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 1072
    //   805: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload 13
    //   810: invokevirtual 417	java/lang/Exception:toString	()Ljava/lang/String;
    //   813: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: iload_3
    //   823: istore_2
    //   824: aload_1
    //   825: astore 13
    //   827: goto -319 -> 508
    //   830: aload_0
    //   831: getfield 908	com/tencent/mm/plugin/voip/model/e:wUf	Z
    //   834: ifeq +23 -> 857
    //   837: aload 14
    //   839: ifnull +18 -> 857
    //   842: aload_0
    //   843: getfield 910	com/tencent/mm/plugin/voip/model/e:wUd	Landroid/media/MediaMuxer;
    //   846: aload_0
    //   847: getfield 912	com/tencent/mm/plugin/voip/model/e:wUe	I
    //   850: aload 14
    //   852: aload 13
    //   854: invokevirtual 918	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   857: aload 13
    //   859: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   862: istore_3
    //   863: getstatic 96	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   866: iconst_1
    //   867: iadd
    //   868: putstatic 96	com/tencent/mm/plugin/voip/model/e:frameID	I
    //   871: aload_0
    //   872: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   875: iload 6
    //   877: iconst_0
    //   878: invokevirtual 925	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   881: aload_0
    //   882: getfield 269	com/tencent/mm/plugin/voip/model/e:wUb	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   885: aload 13
    //   887: aload_0
    //   888: getfield 151	com/tencent/mm/plugin/voip/model/e:TIMEOUT_USEC	I
    //   891: i2l
    //   892: invokevirtual 891	com/tencent/mm/compatible/deviceinfo/aa:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   895: istore 6
    //   897: iload_3
    //   898: istore_2
    //   899: iload 6
    //   901: iflt +1372 -> 2273
    //   904: aload_1
    //   905: iload 6
    //   907: aaload
    //   908: astore 14
    //   910: aload 13
    //   912: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   915: newarray byte
    //   917: astore 15
    //   919: aload 14
    //   921: aload 15
    //   923: invokevirtual 930	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   926: pop
    //   927: aload_0
    //   928: getfield 932	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   931: ifnull +16 -> 947
    //   934: aload_0
    //   935: getfield 932	com/tencent/mm/plugin/voip/model/e:outputStream	Ljava/io/BufferedOutputStream;
    //   938: aload 15
    //   940: iconst_0
    //   941: aload 15
    //   943: arraylength
    //   944: invokevirtual 938	java/io/BufferedOutputStream:write	([BII)V
    //   947: aload 13
    //   949: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   952: iconst_2
    //   953: if_icmpne +555 -> 1508
    //   956: aload 15
    //   958: invokestatic 940	com/tencent/mm/plugin/voip/model/e:ck	([B)Ljava/util/ArrayList;
    //   961: astore 16
    //   963: new 942	com/tencent/mm/protocal/protobuf/cyt
    //   966: dup
    //   967: invokespecial 943	com/tencent/mm/protocal/protobuf/cyt:<init>	()V
    //   970: astore 17
    //   972: iconst_0
    //   973: istore 9
    //   975: iconst_0
    //   976: istore 10
    //   978: iconst_0
    //   979: istore 5
    //   981: iconst_0
    //   982: istore 4
    //   984: iconst_0
    //   985: istore_3
    //   986: iconst_0
    //   987: istore_2
    //   988: aload 16
    //   990: invokevirtual 945	java/util/ArrayList:size	()I
    //   993: iconst_3
    //   994: if_icmpne +330 -> 1324
    //   997: aload_0
    //   998: getfield 149	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1001: ldc_w 312
    //   1004: invokevirtual 316	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1007: ifeq +317 -> 1324
    //   1010: aload 16
    //   1012: iconst_0
    //   1013: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1016: checkcast 296	java/lang/Integer
    //   1019: invokevirtual 951	java/lang/Integer:intValue	()I
    //   1022: iconst_4
    //   1023: iadd
    //   1024: istore 7
    //   1026: aload 16
    //   1028: iconst_1
    //   1029: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1032: checkcast 296	java/lang/Integer
    //   1035: invokevirtual 951	java/lang/Integer:intValue	()I
    //   1038: iconst_4
    //   1039: iadd
    //   1040: istore 5
    //   1042: aload 16
    //   1044: iconst_2
    //   1045: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1048: checkcast 296	java/lang/Integer
    //   1051: invokevirtual 951	java/lang/Integer:intValue	()I
    //   1054: iconst_4
    //   1055: iadd
    //   1056: istore_3
    //   1057: iload 5
    //   1059: iload 7
    //   1061: isub
    //   1062: iconst_4
    //   1063: isub
    //   1064: istore 8
    //   1066: iload_3
    //   1067: iload 5
    //   1069: isub
    //   1070: iconst_4
    //   1071: isub
    //   1072: istore 4
    //   1074: aload 13
    //   1076: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1079: iload_3
    //   1080: isub
    //   1081: istore_2
    //   1082: aload 17
    //   1084: aload 15
    //   1086: iload 7
    //   1088: iload 8
    //   1090: invokestatic 957	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   1093: putfield 961	com/tencent/mm/protocal/protobuf/cyt:aaDB	Lcom/tencent/mm/bx/b;
    //   1096: aload_0
    //   1097: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1100: ifnonnull +14 -> 1114
    //   1103: aload_0
    //   1104: aload 13
    //   1106: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1109: newarray byte
    //   1111: putfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1114: aload_0
    //   1115: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1118: ifnull +43 -> 1161
    //   1121: aload 13
    //   1123: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1126: aload_0
    //   1127: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1130: arraylength
    //   1131: if_icmple +14 -> 1145
    //   1134: aload_0
    //   1135: aload 13
    //   1137: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1140: newarray byte
    //   1142: putfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1145: aload 15
    //   1147: iconst_0
    //   1148: aload_0
    //   1149: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1152: iconst_0
    //   1153: aload 13
    //   1155: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1158: invokestatic 967	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1161: ldc 250
    //   1163: new 241	java/lang/StringBuilder
    //   1166: dup
    //   1167: ldc_w 969
    //   1170: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1173: iload 5
    //   1175: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1178: ldc_w 971
    //   1181: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: iload 4
    //   1186: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: ldc_w 973
    //   1192: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: iload_3
    //   1196: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1199: ldc_w 971
    //   1202: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: iload_2
    //   1206: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1209: ldc_w 975
    //   1212: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: iload 7
    //   1217: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1220: ldc_w 971
    //   1223: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: iload 8
    //   1228: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1231: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1237: aload_0
    //   1238: getfield 184	com/tencent/mm/plugin/voip/model/e:wUi	I
    //   1241: iconst_1
    //   1242: if_icmpeq +199 -> 1441
    //   1245: aload_0
    //   1246: getfield 182	com/tencent/mm/plugin/voip/model/e:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1249: aload 15
    //   1251: invokevirtual 979	com/tencent/mm/plugin/voip/model/g:cA	([B)Z
    //   1254: ifeq +187 -> 1441
    //   1257: aload_0
    //   1258: aload_0
    //   1259: getfield 182	com/tencent/mm/plugin/voip/model/e:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1262: getfield 982	com/tencent/mm/plugin/voip/model/g:UwP	I
    //   1265: putfield 188	com/tencent/mm/plugin/voip/model/e:wUk	I
    //   1268: aload_0
    //   1269: iconst_1
    //   1270: putfield 186	com/tencent/mm/plugin/voip/model/e:wUj	I
    //   1273: ldc 250
    //   1275: new 241	java/lang/StringBuilder
    //   1278: dup
    //   1279: ldc_w 984
    //   1282: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1285: aload_0
    //   1286: getfield 186	com/tencent/mm/plugin/voip/model/e:wUj	I
    //   1289: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1292: ldc_w 986
    //   1295: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: aload_0
    //   1299: getfield 188	com/tencent/mm/plugin/voip/model/e:wUk	I
    //   1302: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1305: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1308: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1311: aload_0
    //   1312: invokespecial 831	com/tencent/mm/plugin/voip/model/e:drc	()I
    //   1315: istore_2
    //   1316: ldc_w 1055
    //   1319: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1322: iload_2
    //   1323: ireturn
    //   1324: iload 10
    //   1326: istore 8
    //   1328: iload 9
    //   1330: istore 7
    //   1332: aload 16
    //   1334: invokevirtual 945	java/util/ArrayList:size	()I
    //   1337: iconst_2
    //   1338: if_icmpne -242 -> 1096
    //   1341: aload 16
    //   1343: iconst_0
    //   1344: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1347: checkcast 296	java/lang/Integer
    //   1350: invokevirtual 951	java/lang/Integer:intValue	()I
    //   1353: iconst_4
    //   1354: iadd
    //   1355: istore 5
    //   1357: aload 16
    //   1359: iconst_1
    //   1360: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1363: checkcast 296	java/lang/Integer
    //   1366: invokevirtual 951	java/lang/Integer:intValue	()I
    //   1369: iconst_4
    //   1370: iadd
    //   1371: istore_3
    //   1372: iload_3
    //   1373: iload 5
    //   1375: isub
    //   1376: iconst_4
    //   1377: isub
    //   1378: istore 4
    //   1380: aload 13
    //   1382: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1385: iload_3
    //   1386: isub
    //   1387: istore_2
    //   1388: iload 10
    //   1390: istore 8
    //   1392: iload 9
    //   1394: istore 7
    //   1396: goto -300 -> 1096
    //   1399: astore_1
    //   1400: ldc 250
    //   1402: new 241	java/lang/StringBuilder
    //   1405: dup
    //   1406: ldc_w 988
    //   1409: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1412: aload_1
    //   1413: invokevirtual 506	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1416: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1422: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1425: aload_0
    //   1426: sipush 2005
    //   1429: putfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   1432: aload_0
    //   1433: getfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   1436: ineg
    //   1437: istore_2
    //   1438: goto -122 -> 1316
    //   1441: aload 17
    //   1443: iconst_4
    //   1444: putfield 991	com/tencent/mm/protocal/protobuf/cyt:aaDy	I
    //   1447: aload 17
    //   1449: aload 15
    //   1451: iload 5
    //   1453: iload 4
    //   1455: invokestatic 957	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   1458: putfield 994	com/tencent/mm/protocal/protobuf/cyt:aaDz	Lcom/tencent/mm/bx/b;
    //   1461: aload 17
    //   1463: aload 15
    //   1465: iload_3
    //   1466: iload_2
    //   1467: invokestatic 957	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   1470: putfield 997	com/tencent/mm/protocal/protobuf/cyt:aaDA	Lcom/tencent/mm/bx/b;
    //   1473: aload 17
    //   1475: invokevirtual 1001	com/tencent/mm/protocal/protobuf/cyt:toByteArray	()[B
    //   1478: arraylength
    //   1479: istore_2
    //   1480: aload_0
    //   1481: aload 17
    //   1483: invokevirtual 1001	com/tencent/mm/protocal/protobuf/cyt:toByteArray	()[B
    //   1486: aload 13
    //   1488: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   1491: iload_2
    //   1492: invokespecial 1003	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   1495: istore_2
    //   1496: iload_2
    //   1497: ifge -667 -> 830
    //   1500: ldc_w 1055
    //   1503: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1506: iload_2
    //   1507: ireturn
    //   1508: aload_0
    //   1509: getfield 184	com/tencent/mm/plugin/voip/model/e:wUi	I
    //   1512: iconst_1
    //   1513: if_icmpeq +124 -> 1637
    //   1516: aload_0
    //   1517: getfield 182	com/tencent/mm/plugin/voip/model/e:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1520: aload 15
    //   1522: invokevirtual 1006	com/tencent/mm/plugin/voip/model/g:cB	([B)Z
    //   1525: ifeq +112 -> 1637
    //   1528: aload_0
    //   1529: aload_0
    //   1530: getfield 182	com/tencent/mm/plugin/voip/model/e:wUh	Lcom/tencent/mm/plugin/voip/model/g;
    //   1533: getfield 982	com/tencent/mm/plugin/voip/model/g:UwP	I
    //   1536: putfield 188	com/tencent/mm/plugin/voip/model/e:wUk	I
    //   1539: aload_0
    //   1540: iconst_1
    //   1541: putfield 186	com/tencent/mm/plugin/voip/model/e:wUj	I
    //   1544: ldc 250
    //   1546: new 241	java/lang/StringBuilder
    //   1549: dup
    //   1550: ldc_w 984
    //   1553: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1556: aload_0
    //   1557: getfield 186	com/tencent/mm/plugin/voip/model/e:wUj	I
    //   1560: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1563: ldc_w 986
    //   1566: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload_0
    //   1570: getfield 188	com/tencent/mm/plugin/voip/model/e:wUk	I
    //   1573: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1576: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1582: aload_0
    //   1583: invokespecial 831	com/tencent/mm/plugin/voip/model/e:drc	()I
    //   1586: istore_2
    //   1587: ldc_w 1055
    //   1590: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1593: iload_2
    //   1594: ireturn
    //   1595: astore_1
    //   1596: ldc 250
    //   1598: new 241	java/lang/StringBuilder
    //   1601: dup
    //   1602: ldc_w 988
    //   1605: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1608: aload_1
    //   1609: invokevirtual 506	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1612: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1621: aload_0
    //   1622: sipush 2005
    //   1625: putfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   1628: aload_0
    //   1629: getfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   1632: ineg
    //   1633: istore_2
    //   1634: goto -47 -> 1587
    //   1637: aload 13
    //   1639: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   1642: ifeq +73 -> 1715
    //   1645: aload 13
    //   1647: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   1650: iconst_1
    //   1651: if_icmpeq +64 -> 1715
    //   1654: aload_0
    //   1655: sipush 2009
    //   1658: putfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   1661: aload_0
    //   1662: getfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   1665: ineg
    //   1666: istore_2
    //   1667: ldc 250
    //   1669: new 241	java/lang/StringBuilder
    //   1672: dup
    //   1673: ldc_w 1008
    //   1676: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1679: aload 13
    //   1681: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   1684: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1687: ldc_w 971
    //   1690: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: aload 13
    //   1695: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1698: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1707: ldc_w 1055
    //   1710: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1713: iload_2
    //   1714: ireturn
    //   1715: iconst_0
    //   1716: istore_3
    //   1717: iload_3
    //   1718: istore_2
    //   1719: aload 13
    //   1721: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   1724: iconst_1
    //   1725: if_icmpne +63 -> 1788
    //   1728: aload_0
    //   1729: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1732: arraylength
    //   1733: newarray byte
    //   1735: astore 16
    //   1737: aload 15
    //   1739: iconst_0
    //   1740: aload 16
    //   1742: iconst_0
    //   1743: aload_0
    //   1744: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1747: arraylength
    //   1748: invokestatic 967	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1751: aload 16
    //   1753: aload_0
    //   1754: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1757: invokestatic 1014	java/util/Arrays:equals	([B[B)Z
    //   1760: ifeq +173 -> 1933
    //   1763: aload_0
    //   1764: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   1767: arraylength
    //   1768: istore_2
    //   1769: ldc 250
    //   1771: ldc_w 1016
    //   1774: iconst_1
    //   1775: anewarray 4	java/lang/Object
    //   1778: dup
    //   1779: iconst_0
    //   1780: iload_2
    //   1781: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1784: aastore
    //   1785: invokestatic 1018	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1788: iconst_4
    //   1789: invokestatic 1021	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1792: astore 16
    //   1794: aload 16
    //   1796: aload 13
    //   1798: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1801: iconst_4
    //   1802: isub
    //   1803: iload_2
    //   1804: isub
    //   1805: invokevirtual 1023	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1808: pop
    //   1809: aload 16
    //   1811: getstatic 1026	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1814: invokevirtual 688	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1817: invokevirtual 1029	java/nio/ByteBuffer:array	()[B
    //   1820: iconst_0
    //   1821: aload 15
    //   1823: iload_2
    //   1824: iconst_4
    //   1825: invokestatic 967	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1828: new 1031	com/tencent/mm/protocal/protobuf/cys
    //   1831: dup
    //   1832: invokespecial 1032	com/tencent/mm/protocal/protobuf/cys:<init>	()V
    //   1835: astore 16
    //   1837: aload 16
    //   1839: aload 15
    //   1841: iload_2
    //   1842: aload 13
    //   1844: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1847: iload_2
    //   1848: isub
    //   1849: invokestatic 957	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   1852: putfield 1035	com/tencent/mm/protocal/protobuf/cys:aaDu	Lcom/tencent/mm/bx/b;
    //   1855: aload 16
    //   1857: iconst_1
    //   1858: putfield 1038	com/tencent/mm/protocal/protobuf/cys:aaDv	I
    //   1861: aload 16
    //   1863: aload_0
    //   1864: getfield 178	com/tencent/mm/plugin/voip/model/e:Lnl	Ljava/util/LinkedList;
    //   1867: putfield 1041	com/tencent/mm/protocal/protobuf/cys:aaDw	Ljava/util/LinkedList;
    //   1870: aload_0
    //   1871: getfield 180	com/tencent/mm/plugin/voip/model/e:Lnm	Ljava/util/LinkedList;
    //   1874: iconst_0
    //   1875: aload 13
    //   1877: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1880: iload_2
    //   1881: isub
    //   1882: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1885: invokevirtual 1045	java/util/LinkedList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1888: pop
    //   1889: aload 16
    //   1891: aload_0
    //   1892: getfield 180	com/tencent/mm/plugin/voip/model/e:Lnm	Ljava/util/LinkedList;
    //   1895: putfield 1048	com/tencent/mm/protocal/protobuf/cys:aaDx	Ljava/util/LinkedList;
    //   1898: aload 16
    //   1900: invokevirtual 1049	com/tencent/mm/protocal/protobuf/cys:toByteArray	()[B
    //   1903: arraylength
    //   1904: istore_2
    //   1905: aload_0
    //   1906: aload 16
    //   1908: invokevirtual 1049	com/tencent/mm/protocal/protobuf/cys:toByteArray	()[B
    //   1911: aload 13
    //   1913: getfield 921	android/media/MediaCodec$BufferInfo:flags	I
    //   1916: iload_2
    //   1917: invokespecial 1003	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   1920: istore_2
    //   1921: iload_2
    //   1922: ifge -1092 -> 830
    //   1925: ldc_w 1055
    //   1928: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1931: iload_2
    //   1932: ireturn
    //   1933: aload_0
    //   1934: getfield 161	com/tencent/mm/plugin/voip/model/e:UwC	[B
    //   1937: ifnonnull +11 -> 1948
    //   1940: aload_0
    //   1941: bipush 100
    //   1943: newarray byte
    //   1945: putfield 161	com/tencent/mm/plugin/voip/model/e:UwC	[B
    //   1948: aload 13
    //   1950: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   1953: bipush 100
    //   1955: if_icmple +326 -> 2281
    //   1958: bipush 100
    //   1960: istore_2
    //   1961: aload 15
    //   1963: iconst_0
    //   1964: aload_0
    //   1965: getfield 161	com/tencent/mm/plugin/voip/model/e:UwC	[B
    //   1968: iconst_0
    //   1969: iload_2
    //   1970: invokestatic 967	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1973: aload_0
    //   1974: getfield 161	com/tencent/mm/plugin/voip/model/e:UwC	[B
    //   1977: invokestatic 940	com/tencent/mm/plugin/voip/model/e:ck	([B)Ljava/util/ArrayList;
    //   1980: astore 16
    //   1982: iload_3
    //   1983: istore_2
    //   1984: aload 16
    //   1986: invokevirtual 945	java/util/ArrayList:size	()I
    //   1989: iconst_3
    //   1990: if_icmpne -202 -> 1788
    //   1993: iload_3
    //   1994: istore_2
    //   1995: aload_0
    //   1996: getfield 149	com/tencent/mm/plugin/voip/model/e:ENCODING	Ljava/lang/String;
    //   1999: ldc_w 615
    //   2002: invokevirtual 316	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2005: ifeq -217 -> 1788
    //   2008: aload 16
    //   2010: iconst_0
    //   2011: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2014: checkcast 296	java/lang/Integer
    //   2017: invokevirtual 951	java/lang/Integer:intValue	()I
    //   2020: istore_3
    //   2021: aload 16
    //   2023: iconst_1
    //   2024: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2027: checkcast 296	java/lang/Integer
    //   2030: invokevirtual 951	java/lang/Integer:intValue	()I
    //   2033: istore 4
    //   2035: aload 16
    //   2037: iconst_2
    //   2038: invokevirtual 948	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2041: checkcast 296	java/lang/Integer
    //   2044: invokevirtual 951	java/lang/Integer:intValue	()I
    //   2047: istore_2
    //   2048: iload 4
    //   2050: iload_3
    //   2051: isub
    //   2052: istore 5
    //   2054: iload_2
    //   2055: iload 4
    //   2057: isub
    //   2058: istore 7
    //   2060: ldc 250
    //   2062: ldc_w 1051
    //   2065: iconst_5
    //   2066: anewarray 4	java/lang/Object
    //   2069: dup
    //   2070: iconst_0
    //   2071: iload_3
    //   2072: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2075: aastore
    //   2076: dup
    //   2077: iconst_1
    //   2078: iload 4
    //   2080: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2083: aastore
    //   2084: dup
    //   2085: iconst_2
    //   2086: iload_2
    //   2087: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2090: aastore
    //   2091: dup
    //   2092: iconst_3
    //   2093: iload 5
    //   2095: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2098: aastore
    //   2099: dup
    //   2100: iconst_4
    //   2101: iload 7
    //   2103: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2106: aastore
    //   2107: invokestatic 838	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2110: aload_0
    //   2111: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   2114: arraylength
    //   2115: iload 5
    //   2117: iload 7
    //   2119: iadd
    //   2120: if_icmpge +14 -> 2134
    //   2123: aload_0
    //   2124: iload 5
    //   2126: iload 7
    //   2128: iadd
    //   2129: newarray byte
    //   2131: putfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   2134: aload 15
    //   2136: iload_3
    //   2137: aload_0
    //   2138: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   2141: iconst_0
    //   2142: iload 5
    //   2144: invokestatic 967	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2147: aload 15
    //   2149: iload 7
    //   2151: aload_0
    //   2152: getfield 159	com/tencent/mm/plugin/voip/model/e:UwB	[B
    //   2155: iload 5
    //   2157: iload 7
    //   2159: invokestatic 967	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2162: new 942	com/tencent/mm/protocal/protobuf/cyt
    //   2165: dup
    //   2166: invokespecial 943	com/tencent/mm/protocal/protobuf/cyt:<init>	()V
    //   2169: astore 16
    //   2171: aload 16
    //   2173: iconst_4
    //   2174: putfield 991	com/tencent/mm/protocal/protobuf/cyt:aaDy	I
    //   2177: aload 16
    //   2179: aload 15
    //   2181: iload_3
    //   2182: iconst_4
    //   2183: iadd
    //   2184: iload 5
    //   2186: iconst_4
    //   2187: isub
    //   2188: invokestatic 957	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   2191: putfield 994	com/tencent/mm/protocal/protobuf/cyt:aaDz	Lcom/tencent/mm/bx/b;
    //   2194: aload 16
    //   2196: aload 15
    //   2198: iload 4
    //   2200: iconst_4
    //   2201: iadd
    //   2202: iload 7
    //   2204: iconst_4
    //   2205: isub
    //   2206: invokestatic 957	com/tencent/mm/bx/b:P	([BII)Lcom/tencent/mm/bx/b;
    //   2209: putfield 997	com/tencent/mm/protocal/protobuf/cyt:aaDA	Lcom/tencent/mm/bx/b;
    //   2212: aload 16
    //   2214: invokevirtual 1001	com/tencent/mm/protocal/protobuf/cyt:toByteArray	()[B
    //   2217: arraylength
    //   2218: istore_3
    //   2219: aload_0
    //   2220: aload 16
    //   2222: invokevirtual 1001	com/tencent/mm/protocal/protobuf/cyt:toByteArray	()[B
    //   2225: iconst_2
    //   2226: iload_3
    //   2227: invokespecial 1003	com/tencent/mm/plugin/voip/model/e:I	([BII)I
    //   2230: pop
    //   2231: goto -443 -> 1788
    //   2234: astore_1
    //   2235: ldc 250
    //   2237: new 241	java/lang/StringBuilder
    //   2240: dup
    //   2241: ldc_w 1072
    //   2244: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2247: aload_1
    //   2248: invokevirtual 417	java/lang/Exception:toString	()Ljava/lang/String;
    //   2251: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2257: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2260: aload_0
    //   2261: sipush 2004
    //   2264: putfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   2267: aload_0
    //   2268: getfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   2271: ineg
    //   2272: istore_2
    //   2273: ldc_w 1055
    //   2276: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2279: iload_2
    //   2280: ireturn
    //   2281: aload 13
    //   2283: getfield 928	android/media/MediaCodec$BufferInfo:size	I
    //   2286: istore_2
    //   2287: goto -326 -> 1961
    //   2290: aload_0
    //   2291: getfield 190	com/tencent/mm/plugin/voip/model/e:wUl	I
    //   2294: istore_3
    //   2295: aload_0
    //   2296: iload_3
    //   2297: iconst_1
    //   2298: iadd
    //   2299: putfield 190	com/tencent/mm/plugin/voip/model/e:wUl	I
    //   2302: iload_3
    //   2303: iconst_5
    //   2304: if_icmple -31 -> 2273
    //   2307: aload_0
    //   2308: sipush 2006
    //   2311: putfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   2314: aload_0
    //   2315: getfield 145	com/tencent/mm/plugin/voip/model/e:wUa	I
    //   2318: ineg
    //   2319: istore_2
    //   2320: goto -47 -> 2273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2323	0	this	e
    //   0	2323	1	paramArrayOfByte	byte[]
    //   0	2323	2	paramInt1	int
    //   0	2323	3	paramInt2	int
    //   0	2323	4	paramInt3	int
    //   7	2181	5	i	int
    //   646	260	6	j	int
    //   1024	1182	7	k	int
    //   1064	327	8	m	int
    //   973	420	9	n	int
    //   976	413	10	i1	int
    //   565	37	11	l	long
    //   126	32	13	localObject1	Object
    //   428	15	13	localException1	Exception
    //   504	127	13	localObject2	Object
    //   794	15	13	localException2	Exception
    //   825	1457	13	arrayOfByte1	byte[]
    //   10	910	14	localObject3	Object
    //   917	1280	15	arrayOfByte2	byte[]
    //   961	1260	16	localObject4	Object
    //   970	512	17	localcyt	cyt
    // Exception table:
    //   from	to	target	type
    //   390	395	428	java/lang/Exception
    //   487	503	794	java/lang/Exception
    //   1311	1316	1399	java/lang/Exception
    //   1582	1587	1595	java/lang/Exception
    //   520	553	2234	java/lang/Exception
    //   557	567	2234	java/lang/Exception
    //   573	617	2234	java/lang/Exception
    //   617	642	2234	java/lang/Exception
    //   655	680	2234	java/lang/Exception
    //   686	697	2234	java/lang/Exception
    //   703	783	2234	java/lang/Exception
    //   830	837	2234	java/lang/Exception
    //   842	857	2234	java/lang/Exception
    //   857	897	2234	java/lang/Exception
    //   910	947	2234	java/lang/Exception
    //   947	972	2234	java/lang/Exception
    //   988	1057	2234	java/lang/Exception
    //   1074	1096	2234	java/lang/Exception
    //   1096	1114	2234	java/lang/Exception
    //   1114	1145	2234	java/lang/Exception
    //   1145	1161	2234	java/lang/Exception
    //   1161	1311	2234	java/lang/Exception
    //   1332	1372	2234	java/lang/Exception
    //   1380	1388	2234	java/lang/Exception
    //   1400	1438	2234	java/lang/Exception
    //   1441	1496	2234	java/lang/Exception
    //   1508	1582	2234	java/lang/Exception
    //   1596	1634	2234	java/lang/Exception
    //   1637	1707	2234	java/lang/Exception
    //   1719	1788	2234	java/lang/Exception
    //   1788	1921	2234	java/lang/Exception
    //   1933	1948	2234	java/lang/Exception
    //   1948	1958	2234	java/lang/Exception
    //   1961	1982	2234	java/lang/Exception
    //   1984	1993	2234	java/lang/Exception
    //   1995	2048	2234	java/lang/Exception
    //   2060	2134	2234	java/lang/Exception
    //   2134	2231	2234	java/lang/Exception
    //   2281	2287	2234	java/lang/Exception
  }
  
  public final void gfg()
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
      if (this.wUg != null)
      {
        this.wUg.flush();
        this.wUg.close();
      }
      if (this.wUd != null)
      {
        this.wUd.stop();
        this.wUd.release();
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
  
  public static abstract interface a
  {
    public abstract void f(Surface paramSurface, int paramInt1, int paramInt2);
    
    public abstract void u(Surface paramSurface);
  }
  
  final class b
  {
    public short UwL;
    public short UwM;
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
    
    public b()
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