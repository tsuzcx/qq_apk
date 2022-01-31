package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.format.Formatter;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class v2protocal
{
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  protected static int cpuFlag0;
  public static SurfaceTexture mSurfaceTexture;
  private static final String[] supportedH264HwCodecPrefixes;
  public static d tBP;
  public static Surface tBR;
  private static int tBt;
  public static int textureId;
  public static boolean tzX;
  int bitrate;
  public int channelStrategy;
  public int defaultHeight;
  public int defaultWidth;
  public long fDU;
  public int[] field_ChannelReportDial;
  public int[] field_EngineReportStatFromApp;
  public int field_HWEncH;
  public int field_HWEncW;
  public int[] field_SpeedTestSvrParaArray;
  public int field_audioDuration;
  public byte[] field_capInfo;
  int field_channelReportLength;
  int field_channelStatLength;
  public int field_connectingStatusKey;
  int field_engine2ndReportLength;
  int field_engine2ndStatLength;
  int field_engineQosStatLength;
  int field_engineVersionStatLength;
  public int[] field_jbmBitratRsSvrParamArray;
  public double[] field_jbmBitratRsSvrParamDoubleArray;
  public int field_jbmParamArraySize;
  public int field_jbmParamDoubleArraySize;
  public int field_localImgHeight;
  public int field_localImgWidth;
  public int field_mGetValidSample;
  public int[] field_natSvrArray;
  int field_netFlowRecv;
  int field_netFlowSent;
  int field_newEngineExtStatLength;
  int field_newEngineReportLength;
  int field_newEngineStatLength;
  public byte[] field_peerId;
  public int field_pstnChannelInfoLength;
  public int field_pstnEngineInfoLength;
  public int[] field_punchSvrArray;
  public int field_realLinkQualityInfoBuffLen;
  public int field_recvVideoLen;
  public int field_relayDataSyncKey;
  public int[] field_relaySvrArray;
  public int[] field_relayTcpSvrArray;
  public int field_remoteImgHeight;
  public int field_remoteImgLength;
  public int field_remoteImgOrien;
  public int field_remoteImgWidth;
  public int field_sendVideoLen;
  int field_speedTestInfoLength;
  int field_statInfoLength;
  public int field_statusSyncKey;
  public int field_videoDuration;
  private ak handler;
  public int height;
  protected boolean isInited;
  public boolean kLn;
  public int kTL;
  public int nMZ;
  public long nNa;
  public int nNc;
  public int nNh;
  public int netType;
  public String ocN;
  public int tAA;
  public int tAB;
  public int tAC;
  public int tAD;
  public int tAE;
  public int tAF;
  public int tAG;
  public int tAH;
  public int tAI;
  public int tAJ;
  public int tAK;
  public int tAL;
  public int tAM;
  public int tAN;
  public int tAO;
  public int tAP;
  public int tAQ;
  public int tAR;
  public int tAS;
  public int tAT;
  public int tAU;
  public int tAV;
  public int tAW;
  public int tAX;
  public int tAY;
  public int tAZ;
  public int tAa;
  public long tAb;
  public byte[] tAc;
  public byte[] tAd;
  public byte[] tAe;
  public int tAf;
  public byte[] tAg;
  public int tAh;
  public int tAi;
  public int tAj;
  public int tAk;
  public byte[] tAl;
  public byte[] tAm;
  public int tAn;
  public int tAo;
  public int tAp;
  public int tAq;
  public int tAr;
  public int tAs;
  public int tAt;
  public int tAu;
  public int tAv;
  public int tAw;
  public int tAx;
  public int tAy;
  public int tAz;
  public int tBA;
  public int tBB;
  byte[] tBC;
  byte[] tBD;
  byte[] tBE;
  byte[] tBF;
  byte[] tBG;
  byte[] tBH;
  byte[] tBI;
  public byte[] tBJ;
  public byte[] tBK;
  public int[] tBL;
  int tBM;
  public n tBN;
  public e tBO;
  int tBQ;
  public int[] tBa;
  public int tBb;
  public int tBc;
  public int tBd;
  public int tBe;
  public byte[] tBf;
  public int tBg;
  public int tBh;
  public int tBi;
  public int tBj;
  public byte[] tBk;
  public int tBl;
  public byte[] tBm;
  public byte[] tBn;
  public int tBo;
  public int tBp;
  public int tBq;
  public int tBr;
  public int tBs;
  public ArrayBlockingQueue<byte[]> tBu;
  public long tBv;
  public byte[] tBw;
  public int tBx;
  public int tBy;
  public int tBz;
  public int tzY;
  public int tzZ;
  public int width;
  
  static
  {
    AppMethodBeat.i(4769);
    com.tencent.mm.compatible.util.k.a("voipMain", v2protocal.class.getClassLoader());
    int i = m.Lo();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      tzX = false;
      tBt = 10;
      tBP = null;
      tBR = null;
      textureId = 0;
      supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi" };
      AppMethodBeat.o(4769);
      return;
    }
  }
  
  public v2protocal(ak paramak)
  {
    AppMethodBeat.i(4752);
    this.fDU = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.tzY = 0;
    this.kTL = 0;
    this.ocN = "";
    this.tzZ = 0;
    this.tAa = 0;
    this.nMZ = 0;
    this.tAb = 0L;
    this.nNh = 0;
    this.nNa = 0L;
    this.nNc = 0;
    this.tAc = null;
    this.tAd = null;
    this.tAe = null;
    this.tAf = 0;
    this.tAg = null;
    this.channelStrategy = 0;
    this.tAh = 500;
    this.tAi = 30;
    this.tAj = 999;
    this.tAk = 0;
    this.tAl = null;
    this.tAm = null;
    this.tAn = 20;
    this.tAo = 0;
    this.tAp = 0;
    this.tAq = 0;
    this.tAr = 0;
    this.tAs = 0;
    this.tAt = 65536;
    this.tAu = 0;
    this.tAv = 0;
    this.tAw = 7;
    this.tAx = 3;
    this.tAy = 3;
    this.tAz = 0;
    this.tAA = 0;
    this.tAB = -1;
    this.tAC = -1;
    this.tAD = 0;
    this.tAE = 0;
    this.tAF = 0;
    this.tAG = 0;
    this.tAH = 100;
    this.tAI = 300;
    this.tAJ = 1;
    this.tAK = 1;
    this.tAL = 0;
    this.tAM = 1;
    this.tAN = 0;
    this.tAO = 0;
    this.tAP = 0;
    this.tAQ = 0;
    this.tAR = 0;
    this.tAS = 0;
    this.tAT = 0;
    this.tAU = 0;
    this.tAV = 0;
    this.tAW = 0;
    this.tAX = 0;
    this.tAY = 0;
    this.tAZ = 0;
    this.tBa = null;
    this.field_punchSvrArray = null;
    this.field_relaySvrArray = null;
    this.field_relayTcpSvrArray = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_SpeedTestSvrParaArray = null;
    this.field_mGetValidSample = 0;
    this.tBb = 0;
    this.tBc = 0;
    this.tBd = 0;
    this.tBe = 0;
    this.tBf = null;
    this.tBg = 0;
    this.tBh = 0;
    this.tBi = 0;
    this.tBj = 0;
    this.tBk = new byte[1500];
    this.tBl = 0;
    this.tBm = null;
    this.tBn = null;
    this.tBo = 0;
    this.tBp = 0;
    this.tBq = 0;
    this.tBr = 0;
    this.tBs = 0;
    this.tBu = new ArrayBlockingQueue(tBt);
    this.field_localImgWidth = 0;
    this.field_localImgHeight = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.field_HWEncW = 0;
    this.field_HWEncH = 0;
    this.field_sendVideoLen = 100;
    this.field_realLinkQualityInfoBuffLen = 0;
    this.field_remoteImgLength = 0;
    this.field_remoteImgHeight = 0;
    this.field_remoteImgWidth = 0;
    this.field_remoteImgOrien = 0;
    this.field_recvVideoLen = 120;
    this.tBv = 0L;
    this.tBw = new byte[8];
    this.tBx = 0;
    this.tBy = 0;
    this.tBz = 0;
    this.tBA = 0;
    this.tBB = 0;
    this.tBC = new byte[4096];
    this.tBD = new byte[2048];
    this.tBE = new byte[2048];
    this.tBF = new byte[4096];
    this.tBG = new byte[4096];
    this.tBH = new byte[2048];
    this.tBI = new byte[4096];
    this.tBJ = new byte[2048];
    this.tBK = new byte[2048];
    this.tBL = new int[30];
    this.field_statInfoLength = 0;
    this.field_speedTestInfoLength = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_channelStatLength = 0;
    this.field_channelReportLength = 0;
    this.field_newEngineStatLength = 0;
    this.field_newEngineReportLength = 0;
    this.field_netFlowSent = 0;
    this.field_netFlowRecv = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.field_newEngineExtStatLength = 0;
    this.field_engine2ndStatLength = 0;
    this.field_engine2ndReportLength = 0;
    this.field_pstnChannelInfoLength = 0;
    this.field_pstnEngineInfoLength = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.tBM = 0;
    this.tBN = new n();
    this.handler = null;
    this.isInited = false;
    this.tBO = null;
    this.width = 640;
    this.height = 480;
    this.tBQ = 8;
    this.bitrate = 300;
    this.kLn = false;
    this.handler = paramak;
    AppMethodBeat.o(4752);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean aeG(String paramString)
  {
    AppMethodBeat.i(4767);
    boolean bool1;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label202;
        }
        i = MediaCodecList.getCodecCount();
        i -= 1;
        bool1 = false;
        label24:
        bool2 = bool1;
        if (i >= 0) {
          bool2 = bool1;
        }
      }
      catch (Exception paramString)
      {
        int i;
        Object localObject;
        String[] arrayOfString;
        int j;
        boolean bool3;
        bool1 = false;
      }
    }
    try
    {
      localObject = MediaCodecList.getCodecInfoAt(i);
      bool2 = bool1;
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
      bool2 = bool1;
      arrayOfString = ((MediaCodecInfo)localObject).getSupportedTypes();
      bool2 = bool1;
      localObject = ((MediaCodecInfo)localObject).getName();
      j = 0;
      bool2 = bool1;
      if (j < arrayOfString.length)
      {
        bool2 = bool1;
        bool3 = arrayOfString[j].equalsIgnoreCase(paramString);
        if (!bool3) {}
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label156:
        bool1 = bool2;
      }
    }
    try
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
      bool1 = true;
      j += 1;
    }
    catch (Exception paramString)
    {
      bool1 = true;
      break label156;
    }
    i -= 1;
    break label24;
    ab.printErrStackTrace("MicroMsg.Voip", paramString, "SupportAvcCodec error: %s", new Object[] { paramString.getMessage() });
    label202:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(4767);
      return bool2;
    }
  }
  
  public static long bw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4741);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(4741);
    return l;
  }
  
  private String cOA()
  {
    AppMethodBeat.i(4746);
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.tAG);
    String str = "," + this.tAG;
    AppMethodBeat.o(4746);
    return str;
  }
  
  private String cOB()
  {
    AppMethodBeat.i(4747);
    if (Build.VERSION.SDK_INT < 11)
    {
      this.tAx = 0;
      this.tAy = 2;
      if (ac.erv.ene >= 0) {
        this.tAx = ac.erv.ene;
      }
      if ((Build.VERSION.SDK_INT >= 11) && (l.IM()) && (2 == ac.erF.eoV)) {
        this.tAy = 2;
      }
      if (ac.erv.enf >= 0) {
        this.tAy = ac.erv.enf;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        break label288;
      }
      this.tAw = 1;
      label104:
      if (ac.erv.emD) {
        this.tAw = 1;
      }
      if (ac.erv.enc >= 0) {
        this.tAw = ac.erv.enc;
      }
      if (ac.erv.emE <= 0) {
        break label297;
      }
      this.tAz = 3;
      this.tAA = 0;
    }
    for (;;)
    {
      if (ac.erv.enh >= 0) {
        this.tAz = ac.erv.enh;
      }
      if (ac.erv.eni >= 0) {
        this.tAA = ac.erv.eni;
      }
      String str = "," + this.tAx + "," + this.tAy + "," + this.tAw + "," + this.tAz + "," + this.tAA;
      AppMethodBeat.o(4747);
      return str;
      this.tAx = 3;
      this.tAy = 3;
      break;
      label288:
      this.tAw = 7;
      break label104;
      label297:
      if (ac.erv.eng >= 0)
      {
        this.tAz = ac.erv.eng;
        this.tAA = ac.erv.eng;
      }
    }
  }
  
  private String cOD()
  {
    AppMethodBeat.i(4749);
    getNewEngineInfo(this.tBG, this.tBG.length);
    getNewEngineExtInfo(this.tBH, this.tBH.length);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.nNh + "," + this.nNa + this.tBN.cMx() + "," + this.tAp + "," + this.tAq + cOy() + new String(this.tBG, 0, this.field_newEngineStatLength) + "," + this.tAr + "," + this.tAs + cOB() + new String(this.tBH, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.tBG, this.tBG.length);
    String str = this.nNh + "," + this.nNa + this.tBN.cMx() + "," + this.tAp + "," + this.tAq + cOy() + new String(this.tBG, 0, this.field_newEngineReportLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(4749);
    return str;
  }
  
  private static int cOH()
  {
    AppMethodBeat.i(4756);
    DhcpInfo localDhcpInfo = ((WifiManager)ah.getContext().getSystemService("wifi")).getDhcpInfo();
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(localDhcpInfo.gateway))));
    int i = localDhcpInfo.gateway;
    AppMethodBeat.o(4756);
    return i;
  }
  
  public static boolean cOJ()
  {
    if ((cpuFlag0 & 0x400) != 0) {}
    for (int i = 1;; i = 0)
    {
      int j = cpuFlag0;
      int k = cpuFlag0;
      int m = Build.VERSION.SDK_INT;
      if ((i == 0) || ((j >> 12 & 0xF) < 4) || ((k & 0xFF) < 30) || (m < 23)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static String cOK()
  {
    return "";
  }
  
  private static String cOv()
  {
    AppMethodBeat.i(4740);
    Object localObject2 = Build.MANUFACTURER;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains(",")) {
      localObject1 = ((String)localObject2).replace(',', ' ');
    }
    Object localObject3 = Build.MODEL;
    localObject2 = localObject3;
    if (((String)localObject3).contains(",")) {
      localObject2 = ((String)localObject3).replace(',', ' ');
    }
    Object localObject4 = Build.VERSION.SDK;
    localObject3 = localObject4;
    if (((String)localObject4).contains(",")) {
      localObject3 = ((String)localObject4).replace(',', ' ');
    }
    String str = Build.VERSION.RELEASE;
    localObject4 = str;
    if (str.contains(",")) {
      localObject4 = ((String)localObject3).replace(',', ' ');
    }
    localObject1 = "," + (String)localObject1 + "," + (String)localObject2 + "," + (String)localObject3 + "," + (String)localObject4;
    AppMethodBeat.o(4740);
    return localObject1;
  }
  
  private String cOw()
  {
    long l3 = 0L;
    AppMethodBeat.i(4742);
    if ((this.tAp == 0) && (this.tAq == 0))
    {
      this.tBN.tws = 0;
      this.tBN.twA = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
      this.tBN.twz = this.field_videoDuration;
      this.tBN.twy = this.field_audioDuration;
      this.tAu = com.tencent.mm.compatible.b.g.KC().KT();
      if ((this.tBN.twI <= 0L) || (this.tBN.twC <= this.tBN.twI)) {
        break label1252;
      }
    }
    label1252:
    for (long l1 = this.tBN.twC - this.tBN.twI;; l1 = 0L)
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.tBw, this.tBw.length);
      long l4 = bw(this.tBw);
      Object localObject1 = this.tBN;
      if ((l4 > this.tBN.twG) && (this.tBN.twG > 0L)) {}
      for (long l2 = l4 - this.tBN.twG;; l2 = 0L)
      {
        ((n)localObject1).twJ = l2;
        localObject1 = this.tBN;
        l2 = l3;
        if (l4 > this.tBN.twI)
        {
          l2 = l3;
          if (this.tBN.twI > 0L) {
            l2 = l4 - this.tBN.twI;
          }
        }
        ((n)localObject1).twK = l2;
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.tBN.twJ + " lCalledWaitTime:" + this.tBN.twK);
        int i = cpuFlag0;
        StringBuilder localStringBuilder = new StringBuilder().append(this.tAo).append(",").append(this.nMZ).append(",").append(this.nNa).append(",").append(this.nNh).append(",").append(this.tBN.twb).append(",").append(this.tBN.twn).append(",").append(this.tBN.two).append(",").append(this.tBN.twp).append(",").append(this.tBN.twq).append(",").append(this.tBN.twr).append(",").append(this.tBN.tws).append(",").append(this.tBN.twl).append(",").append(this.tBN.twt).append(",").append(this.tBN.twu).append(",").append(this.tBN.twv).append(",").append(this.tBN.tww).append(",").append(this.tBN.twx).append(",").append(this.tBN.twy).append(",").append(this.tBN.twz).append(",").append(this.tBN.twA).append(cOz()).append(cOA()).append(cOv()).append(",").append(this.tBN.twB).append(",").append(this.tAt).append(",").append(this.tAu).append(",").append(l1).append(",").append(this.tBN.twJ).append(",").append(this.tBN.twK).append(",").append(this.tAv).append(",").append(this.tzZ).append(cOx()).append(",").append(i & 0xFF).append(",").append(this.tAB).append(",").append(this.tAC);
        Object localObject2 = Build.VERSION.INCREMENTAL;
        localObject1 = localObject2;
        if (((String)localObject2).contains(",")) {
          localObject1 = ((String)localObject2).replace(',', ' ');
        }
        String str = Build.DISPLAY;
        localObject2 = str;
        if (str.contains(",")) {
          localObject2 = str.replace(',', ' ');
        }
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.tBN.twD + "," + this.tBN.twF + "," + this.tBN.twE + ",0," + this.tBN.twL + "," + this.tBN.twM + "," + this.tBN.twN + "," + this.tBN.twO;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.tzZ);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:NewDialStatString:".concat(String.valueOf(localObject1)));
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + cOx());
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.tBN.twM + "lInterruptEndTime:" + this.tBN.twN + "mIinterruptCnt:" + this.tBN.twO);
        AppMethodBeat.o(4742);
        return localObject1;
        if ((this.tAq != 0) && (this.tAp != 0))
        {
          this.tBN.tws = 3;
          break;
        }
        if (this.tAq != 0)
        {
          this.tBN.tws = 1;
          break;
        }
        if (this.tAp == 0) {
          break;
        }
        this.tBN.tws = 2;
        break;
      }
    }
  }
  
  private String cOx()
  {
    AppMethodBeat.i(4743);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(4743);
    return str;
  }
  
  private String cOz()
  {
    AppMethodBeat.i(4745);
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "usePreConnect:" + this.tAF);
    String str = "," + this.tAF;
    AppMethodBeat.o(4745);
    return str;
  }
  
  private native int forceredirect(int paramInt1, int paramInt2);
  
  private native int setsvraddr(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4);
  
  private native int uninit(int paramInt1, long paramLong, int paramInt2);
  
  public native int GetAudioFormat(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3);
  
  public native int GetNetBottleneckSide();
  
  public native int SendDTMF(int paramInt);
  
  public native int SendRUDP(byte[] paramArrayOfByte, int paramInt);
  
  public native int SetDTMFPayload(int paramInt);
  
  public native int StartSpeedTest(long paramLong, int paramInt);
  
  public native int StopSpeedTest();
  
  public final int a(a parama)
  {
    AppMethodBeat.i(4768);
    AtomicInteger localAtomicInteger1 = new AtomicInteger();
    AtomicInteger localAtomicInteger2 = new AtomicInteger();
    AtomicInteger localAtomicInteger3 = new AtomicInteger();
    int j = GetAudioFormat(localAtomicInteger1, localAtomicInteger2, localAtomicInteger3);
    if (j == 0)
    {
      parama.channels = localAtomicInteger3.get();
      parama.tti = localAtomicInteger2.get();
      parama.pJf = localAtomicInteger1.get();
      parama.tth = 0;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.pJf + ", framelenms =" + parama.tti + ", channels =" + parama.channels);
      AppMethodBeat.o(4768);
      return j;
    }
    if ((m.Lo() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.pJf = i;
      parama.channels = 1;
      parama.tti = 20;
      parama.tth = 0;
      break;
    }
  }
  
  public final int a(crn paramcrn1, crn paramcrn2, crn paramcrn3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4755);
    if ((paramcrn1 != null) && (paramcrn1.yak > 0))
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
      this.field_relaySvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcrn1);
      if ((paramcrn2 == null) || (paramcrn2.yak <= 0)) {
        break label138;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
      this.field_punchSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcrn2);
      label62:
      if ((paramcrn3 == null) || (paramcrn3.yak <= 0)) {
        break label150;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
      this.field_relayTcpSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcrn3);
    }
    for (;;)
    {
      paramInt1 = forceredirect(paramInt1, paramInt2);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal forceRedirect ret :".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(4755);
      return paramInt1;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
      break;
      label138:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: No punch svr ip");
      break label62;
      label150:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
    }
  }
  
  public final int a(crn paramcrn1, crn paramcrn2, crn paramcrn3, csx paramcsx, LinkedList<csv> paramLinkedList)
  {
    AppMethodBeat.i(4757);
    if (paramcrn1.yak > 0)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
      this.field_relaySvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcrn1);
      if (paramcrn2.yak <= 0) {
        break label226;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
      this.field_punchSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcrn2);
      label54:
      if (paramcrn3.yak <= 0) {
        break label238;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
      this.field_relayTcpSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcrn3);
      label78:
      if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
        break label250;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal natSvr.size() :" + paramLinkedList.size());
      this.field_natSvrArray = com.tencent.mm.plugin.voip.a.a.ay(paramLinkedList);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal field_natSvrArray :" + this.field_natSvrArray.length);
    }
    for (;;)
    {
      int i = setsvraddr(paramcsx.ybW, paramcsx.ybX, paramcsx.ybY, paramcsx.userName, paramcsx.gFE, cOH());
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal setsvraddr ret :".concat(String.valueOf(i)));
      AppMethodBeat.o(4757);
      return i;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
      break;
      label226:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
      break label54;
      label238:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
      break label78;
      label250:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal field_natSvrArray no nat svr list");
    }
  }
  
  public native int app2EngineDataEx(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4);
  
  public native int app2EngineLinkQualityEx(int paramInt, byte[] paramArrayOfByte);
  
  public final int cHn()
  {
    AppMethodBeat.i(4759);
    this.netType = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
    this.tzZ = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool4;
    boolean bool1;
    label90:
    boolean bool5;
    label162:
    boolean bool6;
    label235:
    boolean bool7;
    label247:
    int i;
    label258:
    int j;
    label269:
    boolean bool2;
    label295:
    int i1;
    label319:
    boolean bool3;
    label339:
    boolean bool8;
    if ((this.tzZ >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool4 = true;
      if ((!bool4) || ((cpuFlag0 & 0xFF) < 30)) {
        break label824;
      }
      bool1 = true;
      if ((ac.eru.eou <= 0) || (ac.eru.enV.width < 480) || (ac.eru.enV.height < 360) || (ac.eru.enX.width < 480) || (ac.eru.enX.height < 360)) {
        break label830;
      }
      bool5 = true;
      if ((ac.eru.eou < 2) || (ac.eru.enV.width < 640) || (ac.eru.enV.height < 480) || (ac.eru.enX.width < 640) || (ac.eru.enX.height < 480)) {
        break label836;
      }
      bool6 = true;
      if (ac.eru.eou != 0) {
        break label842;
      }
      bool7 = true;
      if (ac.eru.eov != 0) {
        break label848;
      }
      i = 1;
      if (ac.eru.eov <= 0) {
        break label853;
      }
      j = 1;
      this.kLn = false;
      if (i != 0) {
        break label918;
      }
      if ((!bool1) || (!aeG("video/avc"))) {
        break label858;
      }
      bool2 = true;
      if (j == 0) {
        break label907;
      }
      if ((!bool1) || ((ac.eru.eov & 0x10) == 0)) {
        break label864;
      }
      i1 = 1;
      if ((!bool2) || ((ac.eru.eov & 0xF) == 0)) {
        break label870;
      }
      bool3 = true;
      if (!bool3) {
        break label876;
      }
      bool8 = true;
      label347:
      this.kLn = bool8;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "hwH264Local:" + bool2 + ",hwHEVCLocal:false, bSupportH264HW:" + bool3 + ", bSupportHEVCHW:false, svrHWCfg:" + ac.eru.eov);
      if (!bool3) {
        break label902;
      }
      i = 1;
      label410:
      if (i1 == 0) {
        break label899;
      }
      i |= 0x2;
    }
    for (;;)
    {
      if (((bool4) || (bool5)) && (!bool7))
      {
        if ((!this.kLn) && (!bool6)) {
          break label882;
        }
        this.defaultWidth = 640;
      }
      for (this.defaultHeight = 480;; this.defaultHeight = 360)
      {
        tzX = true;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool4 + ", bEnable480FromSvr:" + bool5 + ", bDisable480FromSvr:" + bool7 + ", bEnable640FromLocal:" + bool1 + ", bEnable640FromSvr:" + bool6);
        this.tBa = new int[this.defaultWidth * this.defaultHeight];
        com.tencent.mm.kernel.g.RJ();
        this.kTL = com.tencent.mm.kernel.a.getUin();
        int k = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
        int m = localDisplay.getWidth();
        int n = localDisplay.getHeight();
        k = init(this.netType | i << 8, 2, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.kTL, cpuFlag0 | j << 24 | k << 16, com.tencent.mm.compatible.util.e.eQu + "lib/", 0);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "protocal init ret :" + k + ",uin= " + this.kTL + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i);
        this.isInited = true;
        if (k < 0) {
          reset();
        }
        AppMethodBeat.o(4759);
        return k;
        bool4 = false;
        break;
        label824:
        bool1 = false;
        break label90;
        label830:
        bool5 = false;
        break label162;
        label836:
        bool6 = false;
        break label235;
        label842:
        bool7 = false;
        break label247;
        label848:
        i = 0;
        break label258;
        label853:
        j = 0;
        break label269;
        label858:
        bool2 = false;
        break label295;
        label864:
        i1 = 0;
        break label319;
        label870:
        bool3 = false;
        break label339;
        label876:
        bool8 = false;
        break label347;
        label882:
        this.defaultWidth = 480;
      }
      label899:
      continue;
      label902:
      i = 0;
      break label410;
      label907:
      i1 = bool1;
      bool3 = bool2;
      break label339;
      label918:
      i = 0;
    }
  }
  
  final String cOC()
  {
    AppMethodBeat.i(4748);
    getChannelInfo(this.tBF, this.tBF.length, this.tBb, this.tBc, this.tBd, this.tBe);
    Object localObject = new StringBuilder().append(this.nNa).append(",").append(this.nMZ).append(",").append(this.nNh).append(this.tBN.cMx());
    n localn = this.tBN;
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localn.twr).toString() + new String(this.tBF, 0, this.field_channelStatLength))));
    getChannelReport(this.tBF, this.tBF.length);
    localObject = new String(this.tBF, 0, this.field_channelReportLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(4748);
    return localObject;
  }
  
  final String cOE()
  {
    AppMethodBeat.i(4750);
    getEngine2ndInfo(this.tBI, this.tBI.length);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.nNa + "," + this.nMZ + "," + this.nNh + new String(this.tBI, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.tBI, this.tBI.length);
    String str = this.nNa + "," + this.nMZ + "," + this.nNh + new String(this.tBI, 0, this.field_engine2ndReportLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(4750);
    return str;
  }
  
  public final String cOF()
  {
    AppMethodBeat.i(4751);
    int i = cpuFlag0;
    String str = cOv() + "," + this.tAD + "," + (i & 0xFF) + cOB() + "," + this.tAC;
    AppMethodBeat.o(4751);
    return str;
  }
  
  public final boolean cOG()
  {
    return this.isInited;
  }
  
  public final int cOI()
  {
    AppMethodBeat.i(4758);
    this.netType = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
    if (this.netType == 5) {
      this.netType = 4;
    }
    this.tBa = new int[this.defaultWidth * this.defaultHeight];
    com.tencent.mm.kernel.g.RJ();
    this.kTL = com.tencent.mm.kernel.a.getUin();
    int i = m.Lo();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.kTL, i | k << 24 | j << 16, com.tencent.mm.compatible.util.e.eQu + "lib/", 4);
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "protocal init ret :" + i + ",uin= " + this.kTL);
    this.isInited = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(4758);
    return i;
  }
  
  public final String cOL()
  {
    AppMethodBeat.i(4761);
    String str = cOw();
    AppMethodBeat.o(4761);
    return str;
  }
  
  public final String[] cOM()
  {
    AppMethodBeat.i(4762);
    String[] arrayOfString = getNatReport();
    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(4762);
    return arrayOfString;
  }
  
  public final String cON()
  {
    AppMethodBeat.i(4763);
    String str = cOD();
    AppMethodBeat.o(4763);
    return str;
  }
  
  protected final String cOy()
  {
    AppMethodBeat.i(4744);
    if (this.field_videoDuration == 0)
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "captureFrames:" + this.tBx + ", videoduration: 0");
      AppMethodBeat.o(4744);
      return ",0";
    }
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "capturefps:" + this.tBx / this.field_videoDuration + " framecount:" + this.tBx + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.tBx / this.field_videoDuration;
    AppMethodBeat.o(4744);
    return str;
  }
  
  public native int connectToPeer();
  
  public native int connectToPeerDirect();
  
  public native int connectToPeerRelay();
  
  public native int doubleLinkSwitch(int paramInt);
  
  public native int exchangeCabInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int freeJNIReport();
  
  public native int getAVDuration(byte[] paramArrayOfByte, int paramInt);
  
  public native int getChannelInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int getChannelReport(byte[] paramArrayOfByte, int paramInt);
  
  public native int getCurrentConnType();
  
  public native int getEngine2ndInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getEngine2ndInfoReport(byte[] paramArrayOfByte, int paramInt);
  
  public native int getEngineQosInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getEngineVersionInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native String[] getNatReport();
  
  public native int getNewEngineExtInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getNewEngineInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getNewEngineInfoReport(byte[] paramArrayOfByte, int paramInt);
  
  public native int getPstnChannelInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int getPstnEngineInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getStatInfo(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public native int getVideoHWDecode(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt);
  
  public native int getVoipcsChannelInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int getVoipcsEngineInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getcurstrategy();
  
  public native int handleCommand(byte[] paramArrayOfByte, int paramInt);
  
  protected native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7);
  
  public native int isDCReady();
  
  public native int isDCSameLan();
  
  public native int isRelayConnReady();
  
  public int keep_onNotifyFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4753);
    if (paramInt1 == 100)
    {
      com.tencent.mm.plugin.voip.a.a.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      AppMethodBeat.o(4753);
      return 0;
    }
    if (paramInt1 == 101)
    {
      com.tencent.mm.plugin.voip.a.a.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
      AppMethodBeat.o(4753);
      return 0;
    }
    Message localMessage = new Message();
    localMessage.what = 59998;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramArrayOfByte;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(4753);
    return 0;
  }
  
  public int keep_onNotifyFromJniInt(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(4754);
    if (paramArrayOfInt != null)
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipService", "callByJni : arg1:" + paramInt1 + " arg2:" + paramInt2);
      Message localMessage = new Message();
      localMessage.what = 59998;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramArrayOfInt;
      this.handler.sendMessage(localMessage);
    }
    AppMethodBeat.o(4754);
    return 0;
  }
  
  public final String mX(boolean paramBoolean)
  {
    AppMethodBeat.i(4760);
    if (this.isInited)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.tBN.twl;
      this.field_ChannelReportDial[1] = this.tBN.twr;
      this.field_ChannelReportDial[2] = this.tBb;
      this.field_ChannelReportDial[3] = this.tBc;
      this.field_ChannelReportDial[4] = this.tBd;
      this.field_ChannelReportDial[5] = this.tBe;
      this.field_EngineReportStatFromApp = new int[14];
      cOB();
      this.field_EngineReportStatFromApp[0] = this.tAr;
      this.field_EngineReportStatFromApp[1] = this.tAs;
      this.field_EngineReportStatFromApp[2] = this.tAx;
      this.field_EngineReportStatFromApp[3] = this.tAy;
      this.field_EngineReportStatFromApp[4] = this.tAw;
      this.field_EngineReportStatFromApp[5] = this.tAz;
      this.field_EngineReportStatFromApp[6] = this.tAA;
      this.field_EngineReportStatFromApp[7] = -1;
      if (this.tBO != null)
      {
        this.field_EngineReportStatFromApp[8] = this.tBO.kKe;
        this.field_EngineReportStatFromApp[9] = this.tBO.kKg;
        this.field_EngineReportStatFromApp[10] = this.tBO.kJZ;
        if (tBP == null) {
          break label1100;
        }
        this.field_EngineReportStatFromApp[11] = tBP.tul;
      }
      for (;;)
      {
        this.field_EngineReportStatFromApp[12] = this.tBr;
        this.field_EngineReportStatFromApp[13] = this.tBs;
        this.isInited = false;
        uninit(this.nMZ, this.nNa, this.nNh);
        tzX = false;
        if (this.tBO != null)
        {
          this.tBO.cLN();
          this.tBO = null;
        }
        if (tBP != null)
        {
          tBP.interrupt();
          tBP.cLN();
          tBP = null;
        }
        tBR = null;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1111;
        }
        getStatInfo(this.tBC, this.tBC.length, this.tBL, 30);
        getEngineVersionInfo(this.tBD, this.tBD.length);
        getEngineQosInfo(this.tBE, this.tBE.length);
        Object localObject1 = new StringBuilder();
        long l = this.kTL;
        if (this.kTL < 0) {
          l = this.kTL + 4294967296L;
        }
        Object localObject2 = new StringBuilder().append(l).append(",").append(this.nNa).append(",").append(this.nMZ).append(",").append(this.nNh).append(",");
        n localn = this.tBN;
        localObject2 = new StringBuilder().append(localn.twb).append(",").append(localn.twc).append(",").append(localn.twd).append(",").append(localn.twe).append(",").append(localn.twf).append(",").append(localn.twg).append(",").append(localn.twh).append(",").append(localn.twi).append(",").append(localn.twj).append(",").append(localn.twk).append(",").append(localn.twl).toString();
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.tBC, 0, this.field_statInfoLength)).append(cOv()).append(cOx());
        localObject2 = this.tBN;
        localObject1 = ((StringBuilder)localObject1).append("," + ((n)localObject2).twm).append(new String(this.tBD, 0, this.field_engineVersionStatLength)).append(cOy());
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + cOz() + cOA() + new String(this.tBE, 0, this.field_engineQosStatLength);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.tBC, 0, this.field_statInfoLength));
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.tBD, 0, this.field_engineVersionStatLength));
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.tBE, 0, this.field_engineQosStatLength));
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        ao.a.flJ.cq(this.field_netFlowRecv, this.field_netFlowSent);
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
        AppMethodBeat.o(4760);
        return localObject1;
        this.field_EngineReportStatFromApp[8] = 0;
        this.field_EngineReportStatFromApp[9] = 0;
        this.field_EngineReportStatFromApp[10] = 0;
        break;
        label1100:
        this.field_EngineReportStatFromApp[11] = 0;
      }
    }
    label1111:
    AppMethodBeat.o(4760);
    return "";
  }
  
  public native int parseSyncKeyBuff(byte[] paramArrayOfByte, int paramInt);
  
  public native int playCallback(byte[] paramArrayOfByte, int paramInt);
  
  public native int recordCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public final void reset()
  {
    AppMethodBeat.i(4764);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal reset!");
    this.field_punchSvrArray = null;
    this.field_relaySvrArray = null;
    this.field_relayTcpSvrArray = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.nMZ = 0;
    this.tAb = 0L;
    this.tAa = 0;
    this.nNh = 0;
    this.nNa = 0L;
    this.channelStrategy = 0;
    this.nNc = 0;
    this.fDU = 0L;
    this.tAc = null;
    this.tAd = null;
    this.tAe = null;
    this.tAf = 0;
    this.tAg = null;
    this.tBe = 0;
    this.tBf = null;
    this.tBg = 0;
    this.tBh = 0;
    this.tAl = null;
    this.tAm = null;
    this.tBm = null;
    this.tBn = null;
    this.tBx = 0;
    this.tBy = 0;
    this.tBz = 0;
    this.tBA = 0;
    this.tBB = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.tBM = 0;
    this.tAG = 0;
    this.tAF = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.tAr = 0;
    this.tAs = 0;
    this.tAt = 65536;
    this.tAu = 0;
    this.tAv = 0;
    this.tAC = -1;
    this.tAD = 0;
    this.tBq = 0;
    this.tzY = 0;
    this.ocN = "";
    this.tBo = 0;
    this.tBp = 0;
    this.tBN.reset();
    this.tBN.cMw();
    tzX = false;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    int i = freeJNIReport();
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
    AppMethodBeat.o(4764);
  }
  
  public native int setActive();
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(4739);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
    }
    AppMethodBeat.o(4739);
    return paramInt;
  }
  
  public native int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setConfigInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, int paramInt8, int paramInt9, int paramInt10, int paramInt11, byte[] paramArrayOfByte3, int paramInt12, int paramInt13, int paramInt14, byte[] paramArrayOfByte4, int paramInt15);
  
  public native int setInactive();
  
  public native int setJNIAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setNetSignalValue(int paramInt1, int paramInt2);
  
  public native int setSvrConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte);
  
  public native int setjbmbitraterssvrparam();
  
  public native int startEngine();
  
  public native int videoDecode(byte[] paramArrayOfByte);
  
  public native int videoDecode(int[] paramArrayOfInt);
  
  public native int videoDecodeBB(ByteBuffer paramByteBuffer);
  
  public native int videoEncodeToLocal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt);
  
  public native int videoEncodeToSend(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int videoHWDecode(byte[] paramArrayOfByte);
  
  public native int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2);
  
  public native int videoRorate90D(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */