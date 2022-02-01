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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.protocal.protobuf.dsg;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class v2protocal
{
  public static int AGP;
  public static boolean AGa;
  public static boolean AGb;
  public static int AGc;
  private static int AHL;
  public static d AIj;
  public static Surface AIl;
  public static com.tencent.mm.media.f.d AIm;
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  protected static int cpuFlag0;
  public static SurfaceTexture mSurfaceTexture;
  public int AGA;
  public int AGB;
  public int AGC;
  public int AGD;
  public int AGE;
  public int AGF;
  public int AGG;
  public int AGH;
  public int AGI;
  public int AGJ;
  public int AGK;
  public int AGL;
  public int AGM;
  public int AGN;
  public int AGO;
  public String AGQ;
  public int AGR;
  public int AGS;
  public int AGT;
  public int AGU;
  public int AGV;
  public int AGW;
  public int AGX;
  public int AGY;
  public int AGZ;
  public int AGd;
  public int AGe;
  public int AGf;
  public long AGg;
  public byte[] AGh;
  public volatile byte[] AGi;
  public byte[] AGj;
  public int AGk;
  public byte[] AGl;
  public int AGm;
  public int AGn;
  public int AGo;
  public int AGp;
  public byte[] AGq;
  public byte[] AGr;
  public byte[] AGs;
  public int AGt;
  public int AGu;
  public int AGv;
  public int AGw;
  public int AGx;
  public int AGy;
  public int AGz;
  public int AHA;
  public byte[] AHB;
  public byte[] AHC;
  public int AHD;
  public int AHE;
  public int AHF;
  public int AHG;
  public int AHH;
  public byte[] AHI;
  public byte[] AHJ;
  public byte[] AHK;
  public ArrayBlockingQueue<byte[]> AHM;
  long AHN;
  public byte[] AHO;
  public int AHP;
  public int AHQ;
  public int AHR;
  public int AHS;
  public int AHT;
  byte[] AHU;
  byte[] AHV;
  byte[] AHW;
  byte[] AHX;
  byte[] AHY;
  byte[] AHZ;
  public int AHa;
  public int AHb;
  public int AHc;
  public int AHd;
  public int AHe;
  public int AHf;
  public int AHg;
  public int AHh;
  public int AHi;
  public int AHj;
  public int AHk;
  public int AHl;
  public int AHm;
  public int AHn;
  public int AHo;
  public int[] AHp;
  public int AHq;
  public int AHr;
  public int AHs;
  public int AHt;
  public byte[] AHu;
  public int AHv;
  public int AHw;
  public int AHx;
  public int AHy;
  public byte[] AHz;
  byte[] AIa;
  public byte[] AIb;
  public byte[] AIc;
  public int[] AId;
  int AIe;
  public o AIf;
  public int AIg;
  private int AIh;
  public volatile e AIi;
  int AIk;
  int bitrate;
  public int channelStrategy;
  public int defaultHeight;
  public int defaultWidth;
  public String fTK;
  public int[] field_ChannelReportDial;
  public int[] field_EngineReportStatFromApp;
  public int field_HWEncH;
  public int field_HWEncW;
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
  public int field_realLinkQualityInfoBuffLen;
  public int field_recvVideoLen;
  public int field_relayDataSyncKey;
  public int field_remoteImgHeight;
  public int field_remoteImgLength;
  public int field_remoteImgOrien;
  public int field_remoteImgWidth;
  public int field_sendVideoLen;
  int field_speedTestInfoLength;
  int field_statInfoLength;
  public int field_statusSyncKey;
  public int field_videoDuration;
  public long hGV;
  private ao handler;
  public int height;
  protected boolean icd;
  public int netType;
  public int oDO;
  public boolean ouI;
  public int roomId;
  public long tIG;
  public int tII;
  public int tIN;
  public int width;
  
  static
  {
    AppMethodBeat.i(115291);
    v2protocal.class.getClassLoader();
    j.sC("voipMain");
    int i = m.XE();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      AGa = false;
      AGb = false;
      AGc = 0;
      AGP = 0;
      AHL = 10;
      AIj = null;
      AIl = null;
      AIm = null;
      AppMethodBeat.o(115291);
      return;
    }
  }
  
  public v2protocal(ao paramao)
  {
    AppMethodBeat.i(115273);
    this.hGV = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.AGd = 0;
    this.oDO = 0;
    this.fTK = "";
    this.AGe = 0;
    this.AGf = 0;
    this.roomId = 0;
    this.AGg = 0L;
    this.tIN = 0;
    this.tIG = 0L;
    this.tII = 0;
    this.AGh = null;
    this.AGi = null;
    this.AGj = null;
    this.AGk = 0;
    this.AGl = null;
    this.channelStrategy = 0;
    this.AGm = 500;
    this.AGn = 30;
    this.AGo = 999;
    this.AGp = 0;
    this.AGq = null;
    this.AGr = null;
    this.AGs = new byte[10];
    this.AGt = 20;
    this.AGu = 0;
    this.AGv = 0;
    this.AGw = 0;
    this.AGx = 0;
    this.AGy = 0;
    this.AGz = 65536;
    this.AGA = 0;
    this.AGB = 0;
    this.AGC = 7;
    this.AGD = 3;
    this.AGE = 3;
    this.AGF = 0;
    this.AGG = 0;
    this.AGH = -1;
    this.AGI = -1;
    this.AGJ = 0;
    this.AGK = 0;
    this.AGL = 0;
    this.AGM = 0;
    this.AGN = 0;
    this.AGO = 0;
    this.AGQ = "";
    this.AGR = 0;
    this.AGS = 0;
    this.AGT = 0;
    this.AGU = 0;
    this.AGV = 100;
    this.AGW = 300;
    this.AGX = 1;
    this.AGY = 1;
    this.AGZ = 0;
    this.AHa = 1;
    this.AHb = 0;
    this.AHc = 0;
    this.AHd = 0;
    this.AHe = 0;
    this.AHf = 0;
    this.AHg = 0;
    this.AHh = 0;
    this.AHi = 0;
    this.AHj = 0;
    this.AHk = 0;
    this.AHl = 0;
    this.AHm = 0;
    this.AHn = 0;
    this.AHo = 0;
    this.AHp = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_mGetValidSample = 0;
    this.AHq = 0;
    this.AHr = 0;
    this.AHs = 0;
    this.AHt = 0;
    this.AHu = null;
    this.AHv = 0;
    this.AHw = 0;
    this.AHx = 0;
    this.AHy = 0;
    this.AHz = new byte[1500];
    this.AHA = 0;
    this.AHB = null;
    this.AHC = null;
    this.AHD = 0;
    this.AHE = 0;
    this.AHF = 0;
    this.AHG = 0;
    this.AHH = 0;
    this.AHI = null;
    this.AHJ = null;
    this.AHK = null;
    this.AHM = new ArrayBlockingQueue(AHL);
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
    this.AHN = 0L;
    this.AHO = new byte[8];
    this.AHP = 0;
    this.AHQ = 0;
    this.AHR = 0;
    this.AHS = 0;
    this.AHT = 0;
    this.AHU = new byte[4096];
    this.AHV = new byte[2048];
    this.AHW = new byte[2048];
    this.AHX = new byte[4096];
    this.AHY = new byte[4096];
    this.AHZ = new byte[2048];
    this.AIa = new byte[4096];
    this.AIb = new byte[2048];
    this.AIc = new byte[2048];
    this.AId = new int[30];
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
    this.AIe = 0;
    this.AIf = new o();
    this.AIg = 0;
    this.AIh = 0;
    this.handler = null;
    this.icd = false;
    this.AIi = null;
    this.width = 640;
    this.height = 480;
    this.AIk = 8;
    this.bitrate = 300;
    this.ouI = false;
    this.handler = paramao;
    AppMethodBeat.o(115273);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean ayz(String paramString)
  {
    AppMethodBeat.i(115288);
    boolean bool1;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label268;
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
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
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
            String[] arrayOfString2 = e.supportedH264HwCodecPrefixes;
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
        break label227;
      }
      try
      {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
        bool2 = true;
        k += 1;
      }
      catch (Exception paramString)
      {
        bool1 = true;
        break label227;
      }
      j += 1;
      bool2 = bool3;
      continue;
      i -= 1;
      continue;
      label227:
      ac.printErrStackTrace("MicroMsg.Voip", paramString, "SupportAvcCodec error: %s", new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      AppMethodBeat.o(115288);
      return bool1;
      label268:
      bool1 = false;
    }
  }
  
  public static long bN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115262);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(115262);
    return l;
  }
  
  private String ekA()
  {
    AppMethodBeat.i(115264);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(115264);
    return str;
  }
  
  private void ekE()
  {
    AppMethodBeat.i(184064);
    if ((this.AHP <= 0) || (this.field_videoDuration <= 0))
    {
      AppMethodBeat.o(184064);
      return;
    }
    this.AIh = (this.AHP / this.field_videoDuration);
    ac.i("MicroMsg.Voip", "calcCpatureFps:%s", new Object[] { Integer.valueOf(this.AIh) });
    AppMethodBeat.o(184064);
  }
  
  private String ekF()
  {
    AppMethodBeat.i(115266);
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "usePreConnect:" + this.AGT);
    String str = "," + this.AGT;
    AppMethodBeat.o(115266);
    return str;
  }
  
  private String ekG()
  {
    AppMethodBeat.i(115267);
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.AGU);
    String str = "," + this.AGU;
    AppMethodBeat.o(115267);
    return str;
  }
  
  private String ekH()
  {
    AppMethodBeat.i(115268);
    if (Build.VERSION.SDK_INT < 11)
    {
      this.AGD = 0;
      this.AGE = 2;
      if (ae.fJe.fDt >= 0) {
        this.AGD = ae.fJe.fDt;
      }
      if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.k.UV()) && (2 == ae.fJo.fFH)) {
        this.AGE = 2;
      }
      if (ae.fJe.fDu >= 0) {
        this.AGE = ae.fJe.fDu;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        break label288;
      }
      this.AGC = 1;
      label104:
      if (ae.fJe.fCT) {
        this.AGC = 1;
      }
      if (ae.fJe.fDs >= 0) {
        this.AGC = ae.fJe.fDs;
      }
      if (ae.fJe.fCU <= 0) {
        break label297;
      }
      this.AGF = 3;
      this.AGG = 0;
    }
    for (;;)
    {
      if (ae.fJe.fDw >= 0) {
        this.AGF = ae.fJe.fDw;
      }
      if (ae.fJe.fDx >= 0) {
        this.AGG = ae.fJe.fDx;
      }
      String str = "," + this.AGD + "," + this.AGE + "," + this.AGC + "," + this.AGF + "," + this.AGG;
      AppMethodBeat.o(115268);
      return str;
      this.AGD = 3;
      this.AGE = 3;
      break;
      label288:
      this.AGC = 7;
      break label104;
      label297:
      if (ae.fJe.fDv >= 0)
      {
        this.AGF = ae.fJe.fDv;
        this.AGG = ae.fJe.fDv;
      }
    }
  }
  
  private String ekJ()
  {
    AppMethodBeat.i(115270);
    getNewEngineInfo(this.AHY, this.AHY.length);
    getNewEngineExtInfo(this.AHZ, this.AHZ.length);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.tIN + "," + this.tIG + this.AIf.eiP() + "," + this.AGv + "," + this.AGw + ekB() + new String(this.AHY, 0, this.field_newEngineStatLength) + "," + this.AGx + "," + this.AGy + ekH() + new String(this.AHZ, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.AHY, this.AHY.length);
    String str = this.tIN + "," + this.tIG + this.AIf.eiP() + "," + this.AGv + "," + this.AGw + ekB() + new String(this.AHY, 0, this.field_newEngineReportLength);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115270);
    return str;
  }
  
  public static int ekN()
  {
    AppMethodBeat.i(115276);
    DhcpInfo localDhcpInfo = ((WifiManager)ai.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(localDhcpInfo.gateway))));
    int i = localDhcpInfo.gateway;
    AppMethodBeat.o(115276);
    return i;
  }
  
  public static String ekP()
  {
    return "";
  }
  
  private static String eky()
  {
    AppMethodBeat.i(115261);
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
    AppMethodBeat.o(115261);
    return localObject1;
  }
  
  private String ekz()
  {
    long l3 = 0L;
    AppMethodBeat.i(115263);
    if ((this.AGv == 0) && (this.AGw == 0))
    {
      this.AIf.ADi = 0;
      this.AIf.ADq = com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext());
      this.AIf.ADp = this.field_videoDuration;
      this.AIf.ADo = this.field_audioDuration;
      this.AGA = com.tencent.mm.plugin.audio.c.a.bCz();
      if ((this.AIf.ADy <= 0L) || (this.AIf.ADs <= this.AIf.ADy)) {
        break label1416;
      }
    }
    label1416:
    for (long l1 = this.AIf.ADs - this.AIf.ADy;; l1 = 0L)
    {
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.AHO, this.AHO.length);
      long l4 = bN(this.AHO);
      Object localObject1 = this.AIf;
      if ((l4 > this.AIf.ADw) && (this.AIf.ADw > 0L)) {}
      for (long l2 = l4 - this.AIf.ADw;; l2 = 0L)
      {
        ((o)localObject1).ADz = l2;
        localObject1 = this.AIf;
        l2 = l3;
        if (l4 > this.AIf.ADy)
        {
          l2 = l3;
          if (this.AIf.ADy > 0L) {
            l2 = l4 - this.AIf.ADy;
          }
        }
        ((o)localObject1).ADA = l2;
        com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.AIf.ADz + " lCalledWaitTime:" + this.AIf.ADA);
        int i = cpuFlag0;
        StringBuilder localStringBuilder = new StringBuilder().append(this.AGu).append(",").append(this.roomId).append(",").append(this.tIG).append(",").append(this.tIN).append(",").append(this.AIf.ACR).append(",").append(this.AIf.ADd).append(",").append(this.AIf.ADe).append(",").append(this.AIf.ADf).append(",").append(this.AIf.ADg).append(",").append(this.AIf.ADh).append(",").append(this.AIf.ADi).append(",").append(this.AIf.ADb).append(",").append(this.AIf.ADj).append(",").append(this.AIf.ADk).append(",").append(this.AIf.ADl).append(",").append(this.AIf.ADm).append(",").append(this.AIf.ADn).append(",").append(this.AIf.ADo).append(",").append(this.AIf.ADp).append(",").append(this.AIf.ADq).append(ekF()).append(ekG()).append(eky()).append(",").append(this.AIf.ADr).append(",").append(this.AGz).append(",").append(this.AGA).append(",").append(l1).append(",").append(this.AIf.ADz).append(",").append(this.AIf.ADA).append(",").append(this.AGB).append(",").append(this.AGe).append(ekA()).append(",").append(i & 0xFF).append(",").append(this.AGH).append(",").append(this.AGI);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.AIf.ADt + "," + this.AIf.ADv + "," + this.AIf.ADu + ",0," + this.AIf.ADB + "," + this.AIf.AAo + "," + this.AIf.AAp + "," + this.AIf.ADC + ",0,0,0," + this.AGJ + "," + this.AGK + ",0," + this.AGL + "," + this.AGM + "," + this.AGN + "," + this.AIg + "," + this.AGQ + "," + this.AGO + ',' + AGP;
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.AGe);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", ":".concat(String.valueOf(localObject1)));
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + ekA());
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.AIf.AAo + ",lInterruptEndTime:" + this.AIf.AAp + ",mIinterruptCnt:" + this.AIf.ADC + ",iPlayMinBufSize:" + this.AGJ + ",iRecordMinBufSize:" + this.AGK);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.AIg);
        AppMethodBeat.o(115263);
        return localObject1;
        if ((this.AGw != 0) && (this.AGv != 0))
        {
          this.AIf.ADi = 3;
          break;
        }
        if (this.AGw != 0)
        {
          this.AIf.ADi = 1;
          break;
        }
        if (this.AGv == 0) {
          break;
        }
        this.AIf.ADi = 2;
        break;
      }
    }
  }
  
  private native int forceredirect(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);
  
  private native int setsvraddr(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, byte[] paramArrayOfByte, int paramInt5);
  
  private native int uninit(int paramInt1, long paramLong, int paramInt2);
  
  public native int ActivateConn(int paramInt);
  
  public native int AddNewDirectConns(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int AddNewRelayConns(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int GetAudioFormat(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3);
  
  public native int GetNetBottleneckSide();
  
  public native int GetNicInfo(int paramInt, byte[] paramArrayOfByte1, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, byte[] paramArrayOfByte2, AtomicInteger paramAtomicInteger4, AtomicInteger paramAtomicInteger5, AtomicInteger paramAtomicInteger6);
  
  public native int InactivateConn(int paramInt);
  
  public native int QueryNicWanIp(byte[] paramArrayOfByte, int paramInt);
  
  public native int SendDTMF(int paramInt);
  
  public native int SendRUDP(byte[] paramArrayOfByte, int paramInt);
  
  public native int SetDTMFPayload(int paramInt);
  
  public native int StartSpeedTest(byte[] paramArrayOfByte, int paramInt);
  
  public native int StopSpeedTest();
  
  public final int a(a parama)
  {
    AppMethodBeat.i(115289);
    AtomicInteger localAtomicInteger1 = new AtomicInteger();
    AtomicInteger localAtomicInteger2 = new AtomicInteger();
    AtomicInteger localAtomicInteger3 = new AtomicInteger();
    int j = GetAudioFormat(localAtomicInteger1, localAtomicInteger2, localAtomicInteger3);
    if (j == 0)
    {
      parama.channels = localAtomicInteger3.get();
      parama.Ayd = localAtomicInteger2.get();
      parama.vUp = localAtomicInteger1.get();
      parama.Ayc = 0;
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.vUp + ", framelenms =" + parama.Ayd + ", channels =" + parama.channels);
      AppMethodBeat.o(115289);
      return j;
    }
    if ((m.XE() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.vUp = i;
      parama.channels = 1;
      parama.Ayd = 20;
      parama.Ayc = 0;
      break;
    }
  }
  
  public final int a(dsz paramdsz)
  {
    AppMethodBeat.i(115260);
    if (this.AHN != 0L)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      AppMethodBeat.o(115260);
      return -1;
    }
    this.AHN = paramdsz.Gbe;
    dsg localdsg = new dsg();
    localdsg.FZz = paramdsz.Gbe;
    int i = 0;
    while (i < paramdsz.Gbj)
    {
      dsj localdsj = new dsj();
      localdsj.FPP = ((dcl)paramdsz.Gbk.get(i)).FLx.FPS;
      localdsj.port = ((dcl)paramdsz.Gbk.get(i)).FLx.FvP;
      localdsj.AOB = ((dcl)paramdsz.Gbk.get(i)).FLw;
      localdsj.gap = ((dcl)paramdsz.Gbk.get(i)).FMc;
      localdsj.timeout = ((dcl)paramdsz.Gbk.get(i)).FMd;
      localdsj.FZT = ((dcl)paramdsz.Gbk.get(i)).FMe;
      localdsg.FZA.add(localdsj);
      i += 1;
    }
    try
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(localdsg.toByteArray(), localdsg.toByteArray().length))));
      AppMethodBeat.o(115260);
      return 0;
    }
    catch (IOException paramdsz)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Voip", paramdsz, "StartVoipSpeedTest exception", new Object[0]);
      }
    }
  }
  
  public final int aX(LinkedList<bxf> paramLinkedList)
  {
    AppMethodBeat.i(115290);
    Object localObject = new AtomicInteger();
    AtomicInteger localAtomicInteger4 = new AtomicInteger();
    AtomicInteger localAtomicInteger5 = new AtomicInteger();
    byte[] arrayOfByte2 = new byte[20];
    AtomicInteger localAtomicInteger1 = new AtomicInteger();
    AtomicInteger localAtomicInteger2 = new AtomicInteger();
    AtomicInteger localAtomicInteger3 = new AtomicInteger();
    byte[] arrayOfByte1 = new byte[20];
    int i = GetNicInfo(20, arrayOfByte2, (AtomicInteger)localObject, localAtomicInteger4, localAtomicInteger5, arrayOfByte1, localAtomicInteger1, localAtomicInteger2, localAtomicInteger3);
    if (i == 0)
    {
      if (((AtomicInteger)localObject).get() > 0)
      {
        bxf localbxf = new bxf();
        localbxf.ERk = new String(arrayOfByte2, 0, ((AtomicInteger)localObject).get());
        localbxf.FlZ = localAtomicInteger5.get();
        localbxf.Fmb = localAtomicInteger4.get();
        paramLinkedList.add(localbxf);
      }
      if (localAtomicInteger1.get() > 0)
      {
        localObject = new bxf();
        ((bxf)localObject).ERk = new String(arrayOfByte1, 0, localAtomicInteger1.get());
        ((bxf)localObject).FlZ = localAtomicInteger3.get();
        ((bxf)localObject).Fmb = localAtomicInteger2.get();
        paramLinkedList.add(localObject);
      }
    }
    AppMethodBeat.o(115290);
    return i;
  }
  
  public native int app2EngineDataEx(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4);
  
  public native int app2EngineLinkQualityEx(int paramInt, byte[] paramArrayOfByte);
  
  public native int connectToPeer();
  
  public native int connectToPeerDirect();
  
  public native int connectToPeerRelay();
  
  public native int doubleLinkSwitch(int paramInt);
  
  public final int ebh()
  {
    AppMethodBeat.i(115279);
    this.netType = com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext());
    this.AGe = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool4;
    boolean bool5;
    label90:
    boolean bool6;
    label110:
    boolean bool7;
    label130:
    boolean bool8;
    label202:
    boolean bool9;
    label275:
    boolean bool10;
    label288:
    boolean bool11;
    label301:
    boolean bool12;
    label313:
    int i;
    label324:
    int j;
    label335:
    boolean bool1;
    label348:
    label383:
    boolean bool2;
    label402:
    boolean bool3;
    label422:
    boolean bool13;
    if ((this.AGe >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool4 = true;
      if ((!bool4) || ((cpuFlag0 & 0xFF) < 30)) {
        break label1149;
      }
      bool5 = true;
      if ((!bool5) || ((cpuFlag0 & 0xFF) < 60)) {
        break label1155;
      }
      bool6 = true;
      if ((!bool6) || ((cpuFlag0 & 0xFF) < 71)) {
        break label1161;
      }
      bool7 = true;
      if ((ae.fJd.fFg <= 0) || (ae.fJd.fEI.width < 480) || (ae.fJd.fEI.height < 360) || (ae.fJd.fEK.width < 480) || (ae.fJd.fEK.height < 360)) {
        break label1167;
      }
      bool8 = true;
      if ((ae.fJd.fFg < 2) || (ae.fJd.fEI.width < 640) || (ae.fJd.fEI.height < 480) || (ae.fJd.fEK.width < 640) || (ae.fJd.fEK.height < 480)) {
        break label1173;
      }
      bool9 = true;
      if (ae.fJd.fFg < 3) {
        break label1179;
      }
      bool10 = true;
      if (ae.fJd.fFg < 4) {
        break label1185;
      }
      bool11 = true;
      if (ae.fJd.fFg != 0) {
        break label1191;
      }
      bool12 = true;
      if (ae.fJd.fFh != 0) {
        break label1197;
      }
      i = 1;
      if (ae.fJd.fFh <= 0) {
        break label1202;
      }
      j = 1;
      if ((!bool7) || (!bool11)) {
        break label1207;
      }
      bool1 = true;
      AGb = bool1;
      AGc = 0;
      this.ouI = false;
      if (i != 0) {
        break label1272;
      }
      if ((!bool5) || (!ayz("video/avc"))) {
        break label1213;
      }
      bool1 = true;
      if (j == 0) {
        break label1262;
      }
      if ((ae.fJd.fFh & 0x10) == 0) {
        break label1219;
      }
      bool2 = true;
      if ((!bool1) || ((ae.fJd.fFh & 0xF) == 0)) {
        break label1225;
      }
      bool3 = true;
      if (!bool3) {
        break label1231;
      }
      bool13 = true;
      label430:
      this.ouI = bool13;
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "hwH264Local:" + bool1 + ",hwHEVCLocal:false, bSupportH264HW:" + bool3 + ", bSupportHEVCSW:" + bool2 + ", bSupportHEVCHW:false, svrHWCfg:" + ae.fJd.fFh + ", 720p support " + bool6 + "-" + bool10 + "-" + bool7 + "-" + bool11 + "-" + AGb + "svr 480p:" + ae.fJd.fFg);
      if (!bool3) {
        break label1257;
      }
      i = 1;
      label575:
      if (!bool2) {
        break label1254;
      }
      i |= 0x2;
    }
    for (;;)
    {
      if (((bool4) || (bool8)) && (!bool12))
      {
        if ((!this.ouI) && (!bool9)) {
          break label1237;
        }
        this.defaultWidth = 640;
        this.defaultHeight = 480;
        if ((bool6) && (bool10)) {
          this.defaultWidth = 1280;
        }
      }
      for (this.defaultHeight = 720;; this.defaultHeight = 360)
      {
        AGa = true;
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool4 + ", bEnable480FromSvr:" + bool8 + ", bDisable480FromSvr:" + bool12 + ", bEnable640FromLocal:" + bool5 + ", bEnable640FromSvr:" + bool9);
        this.AHp = new int[this.defaultWidth * this.defaultHeight];
        g.agP();
        this.oDO = com.tencent.mm.kernel.a.getUin();
        int k = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        Display localDisplay = ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay();
        int m = localDisplay.getWidth();
        int n = localDisplay.getHeight();
        long l2 = 0L;
        int i1 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYg, -1);
        ac.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i1) });
        int i2 = ae.fJe.fDG;
        ac.i("MicroMsg.Voip", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(i2) });
        long l1 = l2;
        if (i1 > 0)
        {
          l1 = l2;
          if (i2 > 0)
          {
            l1 = (i1 * 100000.0D) + 456L;
            ac.i("MicroMsg.Voip", "kerrizhang typectrl %d", new Object[] { Long.valueOf(l1) });
          }
        }
        i1 = this.netType;
        i2 = this.defaultWidth;
        k = init(i << 8 | i1, 2, this.defaultHeight | i2 << 16, m << 16 | n, this.oDO, j << 24 | k << 16 | cpuFlag0, com.tencent.mm.loader.j.b.aoY() + "lib/", 0, l1);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "protocal init ret :" + k + ",uin= " + this.oDO + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i);
        this.icd = true;
        if (k < 0) {
          reset();
        }
        AppMethodBeat.o(115279);
        return k;
        bool4 = false;
        break;
        label1149:
        bool5 = false;
        break label90;
        label1155:
        bool6 = false;
        break label110;
        label1161:
        bool7 = false;
        break label130;
        label1167:
        bool8 = false;
        break label202;
        label1173:
        bool9 = false;
        break label275;
        label1179:
        bool10 = false;
        break label288;
        label1185:
        bool11 = false;
        break label301;
        label1191:
        bool12 = false;
        break label313;
        label1197:
        i = 0;
        break label324;
        label1202:
        j = 0;
        break label335;
        label1207:
        bool1 = false;
        break label348;
        label1213:
        bool1 = false;
        break label383;
        label1219:
        bool2 = false;
        break label402;
        label1225:
        bool3 = false;
        break label422;
        label1231:
        bool13 = false;
        break label430;
        label1237:
        this.defaultWidth = 480;
      }
      label1254:
      continue;
      label1257:
      i = 0;
      break label575;
      label1262:
      bool2 = false;
      bool3 = bool1;
      break label422;
      label1272:
      i = 0;
    }
  }
  
  protected final String ekB()
  {
    AppMethodBeat.i(115265);
    if (this.field_videoDuration == 0)
    {
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "captureFrames:" + this.AHP + ", videoduration: 0");
      AppMethodBeat.o(115265);
      return ",0";
    }
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "capturefps:" + this.AHP / this.field_videoDuration + " framecount:" + this.AHP + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.AHP / this.field_videoDuration;
    AppMethodBeat.o(115265);
    return str;
  }
  
  public final int ekC()
  {
    if (this.AIh > 0) {
      return this.AIh;
    }
    if (this.field_videoDuration == 0) {
      return 0;
    }
    return this.AHP / this.field_videoDuration;
  }
  
  public final void ekD()
  {
    AppMethodBeat.i(208406);
    this.AIh = 0;
    ac.i("MicroMsg.Voip", "resetCaptureFps");
    AppMethodBeat.o(208406);
  }
  
  final String ekI()
  {
    AppMethodBeat.i(115269);
    getChannelInfo(this.AHX, this.AHX.length, this.AHq, this.AHr, this.AHs, this.AHt);
    Object localObject = new StringBuilder().append(this.tIG).append(",").append(this.roomId).append(",").append(this.tIN).append(this.AIf.eiP());
    o localo = this.AIf;
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localo.ADh).toString() + new String(this.AHX, 0, this.field_channelStatLength))));
    getChannelReport(this.AHX, this.AHX.length);
    localObject = new String(this.AHX, 0, this.field_channelReportLength);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(115269);
    return localObject;
  }
  
  final String ekK()
  {
    AppMethodBeat.i(115271);
    getEngine2ndInfo(this.AIa, this.AIa.length);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.tIG + "," + this.roomId + "," + this.tIN + new String(this.AIa, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.AIa, this.AIa.length);
    String str = this.tIG + "," + this.roomId + "," + this.tIN + new String(this.AIa, 0, this.field_engine2ndReportLength);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115271);
    return str;
  }
  
  public final String ekL()
  {
    AppMethodBeat.i(115272);
    int i = cpuFlag0;
    String str = eky() + "," + this.AGR + "," + (i & 0xFF) + ekH() + "," + this.AGI;
    AppMethodBeat.o(115272);
    return str;
  }
  
  public final boolean ekM()
  {
    return this.icd;
  }
  
  public final int ekO()
  {
    AppMethodBeat.i(115278);
    this.netType = com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext());
    if (this.netType == 5) {
      this.netType = 4;
    }
    this.AHp = new int[this.defaultWidth * this.defaultHeight];
    g.agP();
    this.oDO = com.tencent.mm.kernel.a.getUin();
    int i = m.XE();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.oDO, k << 24 | j << 16 | i, com.tencent.mm.loader.j.b.aoY() + "lib/", 4, 0L);
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "protocal init ret :" + i + ",uin= " + this.oDO);
    this.icd = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(115278);
    return i;
  }
  
  public final String ekQ()
  {
    AppMethodBeat.i(115281);
    String str = ekz();
    AppMethodBeat.o(115281);
    return str;
  }
  
  public final String[] ekR()
  {
    AppMethodBeat.i(115282);
    String[] arrayOfString = getNatReport();
    com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115282);
    return arrayOfString;
  }
  
  public final String[] ekS()
  {
    AppMethodBeat.i(115283);
    String[] arrayOfString = getMPDirectReport();
    com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "direct_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "direct_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115283);
    return arrayOfString;
  }
  
  public final String[] ekT()
  {
    AppMethodBeat.i(115284);
    String[] arrayOfString = getMPRelayReport();
    com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "relay_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "relay_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115284);
    return arrayOfString;
  }
  
  public final String[] ekU()
  {
    AppMethodBeat.i(115285);
    String[] arrayOfString = getMPEngineReport();
    com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "engine_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = (this.tIG + "," + this.tIN + arrayOfString[i]);
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip", "engine_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115285);
    return arrayOfString;
  }
  
  public final String ekV()
  {
    AppMethodBeat.i(115286);
    String str = ekJ();
    AppMethodBeat.o(115286);
    return str;
  }
  
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
  
  public native String[] getMPDirectReport();
  
  public native String[] getMPEngineReport();
  
  public native String[] getMPRelayReport();
  
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
  
  protected native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, long paramLong);
  
  public native int isDCReady();
  
  public native int isDCSameLan();
  
  public native int isRelayConnReady();
  
  public int keep_onNotifyFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115274);
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.VoipService", "callByJni : arg1:" + paramInt1 + " arg2:" + paramInt2);
    if (paramInt1 == 100)
    {
      com.tencent.mm.plugin.voip.b.d.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      AppMethodBeat.o(115274);
      return 0;
    }
    if (paramInt1 == 101)
    {
      com.tencent.mm.plugin.voip.b.d.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
      AppMethodBeat.o(115274);
      return 0;
    }
    Message localMessage = new Message();
    localMessage.what = 59998;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramArrayOfByte;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(115274);
    return 0;
  }
  
  public int keep_onNotifyFromJniInt(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(115275);
    if (paramArrayOfInt != null)
    {
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.VoipService", "callByJniInt : arg1:" + paramInt1 + " arg2:" + paramInt2);
      Message localMessage = new Message();
      localMessage.what = 59998;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramArrayOfInt;
      this.handler.sendMessage(localMessage);
    }
    AppMethodBeat.o(115275);
    return 0;
  }
  
  public native int parseSyncKeyBuff(byte[] paramArrayOfByte, int paramInt);
  
  public native int playCallback(byte[] paramArrayOfByte, int paramInt);
  
  public native int recordCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public final void reset()
  {
    AppMethodBeat.i(115287);
    ac.m("MicroMsg.Voip", "v2protocal reset!", new Object[0]);
    ekE();
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.roomId = 0;
    this.AGg = 0L;
    this.AGf = 0;
    this.tIN = 0;
    this.tIG = 0L;
    this.channelStrategy = 0;
    this.tII = 0;
    this.hGV = 0L;
    this.AGh = null;
    this.AGi = null;
    this.AGj = null;
    this.AGk = 0;
    this.AGl = null;
    this.AHt = 0;
    this.AHu = null;
    this.AHv = 0;
    this.AHw = 0;
    this.AGq = null;
    this.AGr = null;
    this.AHB = null;
    this.AHC = null;
    this.AHI = null;
    this.AHJ = null;
    this.AHK = null;
    this.AHP = 0;
    this.AHQ = 0;
    this.AHR = 0;
    this.AHS = 0;
    this.AHT = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.AIe = 0;
    this.AGU = 0;
    this.AGT = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.AGx = 0;
    this.AGy = 0;
    this.AGz = 65536;
    this.AGA = 0;
    this.AGB = 0;
    this.AGI = -1;
    this.AGR = 0;
    this.AHF = 0;
    this.AGd = 0;
    this.fTK = "";
    this.AHD = 0;
    this.AHE = 0;
    this.AIf.reset();
    this.AIf.eiO();
    AGa = false;
    AGc = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.AGL = 0;
    this.AGM = 0;
    this.AGN = 0;
    this.AGO = 0;
    AGP = 0;
    this.AGQ = "";
    this.AIg = 0;
    int i = freeJNIReport();
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
    AppMethodBeat.o(115287);
  }
  
  public final String sH(boolean paramBoolean)
  {
    AppMethodBeat.i(115280);
    if (this.icd)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.AIf.ADb;
      this.field_ChannelReportDial[1] = this.AIf.ADh;
      this.field_ChannelReportDial[2] = this.AHq;
      this.field_ChannelReportDial[3] = this.AHr;
      this.field_ChannelReportDial[4] = this.AHs;
      this.field_ChannelReportDial[5] = this.AHt;
      this.field_EngineReportStatFromApp = new int[14];
      ekH();
      this.field_EngineReportStatFromApp[0] = this.AGx;
      this.field_EngineReportStatFromApp[1] = this.AGy;
      this.field_EngineReportStatFromApp[2] = this.AGD;
      this.field_EngineReportStatFromApp[3] = this.AGE;
      this.field_EngineReportStatFromApp[4] = this.AGC;
      this.field_EngineReportStatFromApp[5] = this.AGF;
      this.field_EngineReportStatFromApp[6] = this.AGG;
      this.field_EngineReportStatFromApp[7] = -1;
      if (this.AIi != null)
      {
        this.field_EngineReportStatFromApp[8] = this.AIi.otk;
        this.field_EngineReportStatFromApp[9] = this.AIi.otm;
        this.field_EngineReportStatFromApp[10] = this.AIi.otc;
        if (AIj == null) {
          break label1116;
        }
        this.field_EngineReportStatFromApp[11] = AIj.Azj;
      }
      for (;;)
      {
        this.field_EngineReportStatFromApp[12] = this.AHG;
        this.field_EngineReportStatFromApp[13] = this.AHH;
        this.icd = false;
        uninit(this.roomId, this.tIG, this.tIN);
        AGa = false;
        AGc = 0;
        if (this.AIi != null)
        {
          this.AIi.ehl();
          this.AIi = null;
        }
        if (AIj != null)
        {
          AIj.interrupt();
          AIj.ehl();
          AIj = null;
        }
        if (AIl != null) {
          AIl.release();
        }
        AIl = null;
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1127;
        }
        getStatInfo(this.AHU, this.AHU.length, this.AId, 30);
        getEngineVersionInfo(this.AHV, this.AHV.length);
        getEngineQosInfo(this.AHW, this.AHW.length);
        Object localObject1 = new StringBuilder();
        long l = this.oDO;
        if (this.oDO < 0) {
          l = this.oDO + 4294967296L;
        }
        Object localObject2 = new StringBuilder().append(l).append(",").append(this.tIG).append(",").append(this.roomId).append(",").append(this.tIN).append(",");
        o localo = this.AIf;
        localObject2 = new StringBuilder().append(localo.ACR).append(",").append(localo.ACS).append(",").append(localo.ACT).append(",").append(localo.ACU).append(",").append(localo.ACV).append(",").append(localo.ACW).append(",").append(localo.ACX).append(",").append(localo.ACY).append(",").append(localo.ACZ).append(",").append(localo.ADa).append(",").append(localo.ADb).toString();
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.AHU, 0, this.field_statInfoLength)).append(eky()).append(ekA());
        localObject2 = this.AIf;
        localObject1 = ((StringBuilder)localObject1).append("," + ((o)localObject2).ADc).append(new String(this.AHV, 0, this.field_engineVersionStatLength)).append(ekB());
        com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + ekF() + ekG() + new String(this.AHW, 0, this.field_engineQosStatLength);
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.AHU, 0, this.field_statInfoLength));
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.AHV, 0, this.field_engineVersionStatLength));
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.AHW, 0, this.field_engineQosStatLength));
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        ar.a.hnx.cZ(this.field_netFlowRecv, this.field_netFlowSent);
        com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
        AppMethodBeat.o(115280);
        return localObject1;
        this.field_EngineReportStatFromApp[8] = 0;
        this.field_EngineReportStatFromApp[9] = 0;
        this.field_EngineReportStatFromApp[10] = 0;
        break;
        label1116:
        this.field_EngineReportStatFromApp[11] = 0;
      }
    }
    label1127:
    AppMethodBeat.o(115280);
    return "";
  }
  
  public native int setActive();
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(115259);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
    }
    AppMethodBeat.o(115259);
    return paramInt;
  }
  
  public native int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setConfigInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, int paramInt8, int paramInt9, int paramInt10, int paramInt11, byte[] paramArrayOfByte3, int paramInt12, int paramInt13, int paramInt14, byte[] paramArrayOfByte4, int paramInt15, int paramInt16, int paramInt17, int paramInt18, String paramString1, String paramString2, int paramInt19);
  
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
  
  public native int videoEncodeToLocal2(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt);
  
  public native int videoEncodeToSend(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int videoEncodeToSend2(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int videoHWDecode(byte[] paramArrayOfByte);
  
  public native int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2);
  
  public native int videoHWProcess2(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer2);
  
  public native int videoRorate90D(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */