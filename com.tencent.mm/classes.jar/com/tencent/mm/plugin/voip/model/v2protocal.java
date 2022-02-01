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
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.IOException;
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
  public static boolean znm;
  public static boolean znn;
  public static int zno;
  private static int zoW;
  public static d zpu;
  public static Surface zpw;
  public static com.tencent.mm.media.f.d zpx;
  int bitrate;
  public int channelStrategy;
  public int defaultHeight;
  public int defaultWidth;
  public String fPP;
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
  protected boolean hBC;
  private ap handler;
  public int height;
  public long hgs;
  public boolean nRs;
  public int netType;
  public int oap;
  public int roomId;
  public long sAY;
  public int sBa;
  public int sBf;
  public int width;
  public int znA;
  public int znB;
  public byte[] znC;
  public byte[] znD;
  public byte[] znE;
  public int znF;
  public int znG;
  public int znH;
  public int znI;
  public int znJ;
  public int znK;
  public int znL;
  public int znM;
  public int znN;
  public int znO;
  public int znP;
  public int znQ;
  public int znR;
  public int znS;
  public int znT;
  public int znU;
  public int znV;
  public int znW;
  public int znX;
  public int znY;
  public int znZ;
  public int znp;
  public int znq;
  public int znr;
  public long zns;
  public byte[] znt;
  public volatile byte[] znu;
  public byte[] znv;
  public int znw;
  public byte[] znx;
  public int zny;
  public int znz;
  public int[] zoA;
  public int zoB;
  public int zoC;
  public int zoD;
  public int zoE;
  public byte[] zoF;
  public int zoG;
  public int zoH;
  public int zoI;
  public int zoJ;
  public byte[] zoK;
  public int zoL;
  public byte[] zoM;
  public byte[] zoN;
  public int zoO;
  public int zoP;
  public int zoQ;
  public int zoR;
  public int zoS;
  public byte[] zoT;
  public byte[] zoU;
  public byte[] zoV;
  public ArrayBlockingQueue<byte[]> zoX;
  long zoY;
  public byte[] zoZ;
  public int zoa;
  public String zob;
  public int zoc;
  public int zod;
  public int zoe;
  public int zof;
  public int zog;
  public int zoh;
  public int zoi;
  public int zoj;
  public int zok;
  public int zol;
  public int zom;
  public int zon;
  public int zoo;
  public int zop;
  public int zoq;
  public int zor;
  public int zos;
  public int zot;
  public int zou;
  public int zov;
  public int zow;
  public int zox;
  public int zoy;
  public int zoz;
  public int zpa;
  public int zpb;
  public int zpc;
  public int zpd;
  public int zpe;
  byte[] zpf;
  byte[] zpg;
  byte[] zph;
  byte[] zpi;
  byte[] zpj;
  byte[] zpk;
  byte[] zpl;
  public byte[] zpm;
  public byte[] zpn;
  public int[] zpo;
  int zpp;
  public o zpq;
  public int zpr;
  private int zps;
  public volatile e zpt;
  int zpv;
  
  static
  {
    AppMethodBeat.i(115291);
    v2protocal.class.getClassLoader();
    j.pq("voipMain");
    int i = m.WG();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      znm = false;
      znn = false;
      zno = 0;
      zoW = 10;
      zpu = null;
      zpw = null;
      zpx = null;
      AppMethodBeat.o(115291);
      return;
    }
  }
  
  public v2protocal(ap paramap)
  {
    AppMethodBeat.i(115273);
    this.hgs = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.znp = 0;
    this.oap = 0;
    this.fPP = "";
    this.znq = 0;
    this.znr = 0;
    this.roomId = 0;
    this.zns = 0L;
    this.sBf = 0;
    this.sAY = 0L;
    this.sBa = 0;
    this.znt = null;
    this.znu = null;
    this.znv = null;
    this.znw = 0;
    this.znx = null;
    this.channelStrategy = 0;
    this.zny = 500;
    this.znz = 30;
    this.znA = 999;
    this.znB = 0;
    this.znC = null;
    this.znD = null;
    this.znE = new byte[10];
    this.znF = 20;
    this.znG = 0;
    this.znH = 0;
    this.znI = 0;
    this.znJ = 0;
    this.znK = 0;
    this.znL = 65536;
    this.znM = 0;
    this.znN = 0;
    this.znO = 7;
    this.znP = 3;
    this.znQ = 3;
    this.znR = 0;
    this.znS = 0;
    this.znT = -1;
    this.znU = -1;
    this.znV = 0;
    this.znW = 0;
    this.znX = 0;
    this.znY = 0;
    this.znZ = 0;
    this.zoa = 0;
    this.zob = "";
    this.zoc = 0;
    this.zod = 0;
    this.zoe = 0;
    this.zof = 0;
    this.zog = 100;
    this.zoh = 300;
    this.zoi = 1;
    this.zoj = 1;
    this.zok = 0;
    this.zol = 1;
    this.zom = 0;
    this.zon = 0;
    this.zoo = 0;
    this.zop = 0;
    this.zoq = 0;
    this.zor = 0;
    this.zos = 0;
    this.zot = 0;
    this.zou = 0;
    this.zov = 0;
    this.zow = 0;
    this.zox = 0;
    this.zoy = 0;
    this.zoz = 0;
    this.zoA = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_mGetValidSample = 0;
    this.zoB = 0;
    this.zoC = 0;
    this.zoD = 0;
    this.zoE = 0;
    this.zoF = null;
    this.zoG = 0;
    this.zoH = 0;
    this.zoI = 0;
    this.zoJ = 0;
    this.zoK = new byte[1500];
    this.zoL = 0;
    this.zoM = null;
    this.zoN = null;
    this.zoO = 0;
    this.zoP = 0;
    this.zoQ = 0;
    this.zoR = 0;
    this.zoS = 0;
    this.zoT = null;
    this.zoU = null;
    this.zoV = null;
    this.zoX = new ArrayBlockingQueue(zoW);
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
    this.zoY = 0L;
    this.zoZ = new byte[8];
    this.zpa = 0;
    this.zpb = 0;
    this.zpc = 0;
    this.zpd = 0;
    this.zpe = 0;
    this.zpf = new byte[4096];
    this.zpg = new byte[2048];
    this.zph = new byte[2048];
    this.zpi = new byte[4096];
    this.zpj = new byte[4096];
    this.zpk = new byte[2048];
    this.zpl = new byte[4096];
    this.zpm = new byte[2048];
    this.zpn = new byte[2048];
    this.zpo = new int[30];
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
    this.zpp = 0;
    this.zpq = new o();
    this.zpr = 0;
    this.zps = 0;
    this.handler = null;
    this.hBC = false;
    this.zpt = null;
    this.width = 640;
    this.height = 480;
    this.zpv = 8;
    this.bitrate = 300;
    this.nRs = false;
    this.handler = paramap;
    AppMethodBeat.o(115273);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean ati(String paramString)
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
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
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
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
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
      ad.printErrStackTrace("MicroMsg.Voip", paramString, "SupportAvcCodec error: %s", new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      AppMethodBeat.o(115288);
      return bool1;
      label268:
      bool1 = false;
    }
  }
  
  public static long bO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115262);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(115262);
    return l;
  }
  
  public static int dVB()
  {
    AppMethodBeat.i(115276);
    DhcpInfo localDhcpInfo = ((WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(localDhcpInfo.gateway))));
    int i = localDhcpInfo.gateway;
    AppMethodBeat.o(115276);
    return i;
  }
  
  public static String dVD()
  {
    return "";
  }
  
  private static String dVm()
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
  
  private String dVn()
  {
    long l3 = 0L;
    AppMethodBeat.i(115263);
    if ((this.znH == 0) && (this.znI == 0))
    {
      this.zpq.zky = 0;
      this.zpq.zkG = com.tencent.mm.plugin.voip.b.c.getNetType(aj.getContext());
      this.zpq.zkF = this.field_videoDuration;
      this.zpq.zkE = this.field_audioDuration;
      this.znM = com.tencent.mm.plugin.audio.c.a.bvD();
      if ((this.zpq.zkO <= 0L) || (this.zpq.zkI <= this.zpq.zkO)) {
        break label1405;
      }
    }
    label1405:
    for (long l1 = this.zpq.zkI - this.zpq.zkO;; l1 = 0L)
    {
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.zoZ, this.zoZ.length);
      long l4 = bO(this.zoZ);
      Object localObject1 = this.zpq;
      if ((l4 > this.zpq.zkM) && (this.zpq.zkM > 0L)) {}
      for (long l2 = l4 - this.zpq.zkM;; l2 = 0L)
      {
        ((o)localObject1).zkP = l2;
        localObject1 = this.zpq;
        l2 = l3;
        if (l4 > this.zpq.zkO)
        {
          l2 = l3;
          if (this.zpq.zkO > 0L) {
            l2 = l4 - this.zpq.zkO;
          }
        }
        ((o)localObject1).zkQ = l2;
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.zpq.zkP + " lCalledWaitTime:" + this.zpq.zkQ);
        int i = cpuFlag0;
        StringBuilder localStringBuilder = new StringBuilder().append(this.znG).append(",").append(this.roomId).append(",").append(this.sAY).append(",").append(this.sBf).append(",").append(this.zpq.zkh).append(",").append(this.zpq.zkt).append(",").append(this.zpq.zku).append(",").append(this.zpq.zkv).append(",").append(this.zpq.zkw).append(",").append(this.zpq.zkx).append(",").append(this.zpq.zky).append(",").append(this.zpq.zkr).append(",").append(this.zpq.zkz).append(",").append(this.zpq.zkA).append(",").append(this.zpq.zkB).append(",").append(this.zpq.zkC).append(",").append(this.zpq.zkD).append(",").append(this.zpq.zkE).append(",").append(this.zpq.zkF).append(",").append(this.zpq.zkG).append(dVt()).append(dVu()).append(dVm()).append(",").append(this.zpq.zkH).append(",").append(this.znL).append(",").append(this.znM).append(",").append(l1).append(",").append(this.zpq.zkP).append(",").append(this.zpq.zkQ).append(",").append(this.znN).append(",").append(this.znq).append(dVo()).append(",").append(i & 0xFF).append(",").append(this.znT).append(",").append(this.znU);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.zpq.zkJ + "," + this.zpq.zkL + "," + this.zpq.zkK + ",0," + this.zpq.zkR + "," + this.zpq.zhF + "," + this.zpq.zhG + "," + this.zpq.zkS + ",0,0,0," + this.znV + "," + this.znW + ",0," + this.znX + "," + this.znY + "," + this.znZ + "," + this.zpr + "," + this.zob + "," + this.zoa;
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.znq);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:NewDialStatString:".concat(String.valueOf(localObject1)));
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + dVo());
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.zpq.zhF + ",lInterruptEndTime:" + this.zpq.zhG + ",mIinterruptCnt:" + this.zpq.zkS + ",iPlayMinBufSize:" + this.znV + ",iRecordMinBufSize:" + this.znW);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.zpr);
        AppMethodBeat.o(115263);
        return localObject1;
        if ((this.znI != 0) && (this.znH != 0))
        {
          this.zpq.zky = 3;
          break;
        }
        if (this.znI != 0)
        {
          this.zpq.zky = 1;
          break;
        }
        if (this.znH == 0) {
          break;
        }
        this.zpq.zky = 2;
        break;
      }
    }
  }
  
  private String dVo()
  {
    AppMethodBeat.i(115264);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(115264);
    return str;
  }
  
  private void dVs()
  {
    AppMethodBeat.i(184064);
    if ((this.zpa <= 0) || (this.field_videoDuration <= 0))
    {
      AppMethodBeat.o(184064);
      return;
    }
    this.zps = (this.zpa / this.field_videoDuration);
    ad.i("MicroMsg.Voip", "calcCpatureFps:%s", new Object[] { Integer.valueOf(this.zps) });
    AppMethodBeat.o(184064);
  }
  
  private String dVt()
  {
    AppMethodBeat.i(115266);
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "usePreConnect:" + this.zoe);
    String str = "," + this.zoe;
    AppMethodBeat.o(115266);
    return str;
  }
  
  private String dVu()
  {
    AppMethodBeat.i(115267);
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.zof);
    String str = "," + this.zof;
    AppMethodBeat.o(115267);
    return str;
  }
  
  private String dVv()
  {
    AppMethodBeat.i(115268);
    if (Build.VERSION.SDK_INT < 11)
    {
      this.znP = 0;
      this.znQ = 2;
      if (ae.fFx.fzM >= 0) {
        this.znP = ae.fFx.fzM;
      }
      if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.k.Ua()) && (2 == ae.fFH.fCa)) {
        this.znQ = 2;
      }
      if (ae.fFx.fzN >= 0) {
        this.znQ = ae.fFx.fzN;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        break label288;
      }
      this.znO = 1;
      label104:
      if (ae.fFx.fzm) {
        this.znO = 1;
      }
      if (ae.fFx.fzL >= 0) {
        this.znO = ae.fFx.fzL;
      }
      if (ae.fFx.fzn <= 0) {
        break label297;
      }
      this.znR = 3;
      this.znS = 0;
    }
    for (;;)
    {
      if (ae.fFx.fzP >= 0) {
        this.znR = ae.fFx.fzP;
      }
      if (ae.fFx.fzQ >= 0) {
        this.znS = ae.fFx.fzQ;
      }
      String str = "," + this.znP + "," + this.znQ + "," + this.znO + "," + this.znR + "," + this.znS;
      AppMethodBeat.o(115268);
      return str;
      this.znP = 3;
      this.znQ = 3;
      break;
      label288:
      this.znO = 7;
      break label104;
      label297:
      if (ae.fFx.fzO >= 0)
      {
        this.znR = ae.fFx.fzO;
        this.znS = ae.fFx.fzO;
      }
    }
  }
  
  private String dVx()
  {
    AppMethodBeat.i(115270);
    getNewEngineInfo(this.zpj, this.zpj.length);
    getNewEngineExtInfo(this.zpk, this.zpk.length);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.sBf + "," + this.sAY + this.zpq.dTD() + "," + this.znH + "," + this.znI + dVp() + new String(this.zpj, 0, this.field_newEngineStatLength) + "," + this.znJ + "," + this.znK + dVv() + new String(this.zpk, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.zpj, this.zpj.length);
    String str = this.sBf + "," + this.sAY + this.zpq.dTD() + "," + this.znH + "," + this.znI + dVp() + new String(this.zpj, 0, this.field_newEngineReportLength);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115270);
    return str;
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
      parama.zfw = localAtomicInteger2.get();
      parama.uLy = localAtomicInteger1.get();
      parama.zfv = 0;
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.uLy + ", framelenms =" + parama.zfw + ", channels =" + parama.channels);
      AppMethodBeat.o(115289);
      return j;
    }
    if ((m.WG() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.uLy = i;
      parama.channels = 1;
      parama.zfw = 20;
      parama.zfv = 0;
      break;
    }
  }
  
  public final int a(dni paramdni)
  {
    AppMethodBeat.i(115260);
    if (this.zoY != 0L)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      AppMethodBeat.o(115260);
      return -1;
    }
    this.zoY = paramdni.EDR;
    dmp localdmp = new dmp();
    localdmp.ECm = paramdni.EDR;
    int i = 0;
    while (i < paramdni.EDW)
    {
      dms localdms = new dms();
      localdms.EsN = ((cwz)paramdni.EDX.get(i)).Eoy.EsQ;
      localdms.port = ((cwz)paramdni.EDX.get(i)).Eoy.DYT;
      localdms.zvK = ((cwz)paramdni.EDX.get(i)).Eox;
      localdms.gap = ((cwz)paramdni.EDX.get(i)).Epd;
      localdms.timeout = ((cwz)paramdni.EDX.get(i)).Epe;
      localdms.ECG = ((cwz)paramdni.EDX.get(i)).Epf;
      localdmp.ECn.add(localdms);
      i += 1;
    }
    try
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(localdmp.toByteArray(), localdmp.toByteArray().length))));
      AppMethodBeat.o(115260);
      return 0;
    }
    catch (IOException paramdni)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Voip", paramdni, "StartVoipSpeedTest exception", new Object[0]);
      }
    }
  }
  
  public final int aQ(LinkedList<bso> paramLinkedList)
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
        bso localbso = new bso();
        localbso.DvP = new String(arrayOfByte2, 0, ((AtomicInteger)localObject).get());
        localbso.DPI = localAtomicInteger5.get();
        localbso.DPK = localAtomicInteger4.get();
        paramLinkedList.add(localbso);
      }
      if (localAtomicInteger1.get() > 0)
      {
        localObject = new bso();
        ((bso)localObject).DvP = new String(arrayOfByte1, 0, localAtomicInteger1.get());
        ((bso)localObject).DPI = localAtomicInteger3.get();
        ((bso)localObject).DPK = localAtomicInteger2.get();
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
  
  public final int dMH()
  {
    AppMethodBeat.i(115279);
    this.netType = com.tencent.mm.plugin.voip.b.c.getNetType(aj.getContext());
    this.znq = this.netType;
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
    label361:
    boolean bool12;
    label373:
    int i;
    label384:
    int j;
    label395:
    boolean bool1;
    label408:
    label443:
    boolean bool2;
    label462:
    boolean bool3;
    label482:
    boolean bool13;
    if ((this.znq >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool4 = true;
      if ((!bool4) || ((cpuFlag0 & 0xFF) < 30)) {
        break label1209;
      }
      bool5 = true;
      if ((!bool5) || ((cpuFlag0 & 0xFF) < 60)) {
        break label1215;
      }
      bool6 = true;
      if ((!bool6) || ((cpuFlag0 & 0xFF) < 90)) {
        break label1221;
      }
      bool7 = true;
      if ((ae.fFw.fBz <= 0) || (ae.fFw.fBb.width < 480) || (ae.fFw.fBb.height < 360) || (ae.fFw.fBd.width < 480) || (ae.fFw.fBd.height < 360)) {
        break label1227;
      }
      bool8 = true;
      if ((ae.fFw.fBz < 2) || (ae.fFw.fBb.width < 640) || (ae.fFw.fBb.height < 480) || (ae.fFw.fBd.width < 640) || (ae.fFw.fBd.height < 480)) {
        break label1233;
      }
      bool9 = true;
      if (ae.fFw.fBz < 3) {
        break label1239;
      }
      bool10 = true;
      if ((ae.fFw.fBz < 4) || (ae.fFw.fBb.width < 1280) || (ae.fFw.fBb.height < 720) || (ae.fFw.fBd.width < 1280) || (ae.fFw.fBd.height < 720)) {
        break label1245;
      }
      bool11 = true;
      if (ae.fFw.fBz != 0) {
        break label1251;
      }
      bool12 = true;
      if (ae.fFw.fBA != 0) {
        break label1257;
      }
      i = 1;
      if (ae.fFw.fBA <= 0) {
        break label1262;
      }
      j = 1;
      if ((!bool7) || (!bool11)) {
        break label1267;
      }
      bool1 = true;
      znn = bool1;
      zno = 0;
      this.nRs = false;
      if (i != 0) {
        break label1332;
      }
      if ((!bool5) || (!ati("video/avc"))) {
        break label1273;
      }
      bool1 = true;
      if (j == 0) {
        break label1322;
      }
      if ((ae.fFw.fBA & 0x10) == 0) {
        break label1279;
      }
      bool2 = true;
      if ((!bool1) || ((ae.fFw.fBA & 0xF) == 0)) {
        break label1285;
      }
      bool3 = true;
      if (!bool3) {
        break label1291;
      }
      bool13 = true;
      label490:
      this.nRs = bool13;
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "hwH264Local:" + bool1 + ",hwHEVCLocal:false, bSupportH264HW:" + bool3 + ", bSupportHEVCSW:" + bool2 + ", bSupportHEVCHW:false, svrHWCfg:" + ae.fFw.fBA + ", 720p support " + bool6 + "-" + bool10 + "-" + bool7 + "-" + bool11 + "-" + znn + "svr 480p:" + ae.fFw.fBz);
      if (!bool3) {
        break label1317;
      }
      i = 1;
      label635:
      if (!bool2) {
        break label1314;
      }
      i |= 0x2;
    }
    for (;;)
    {
      if (((bool4) || (bool8)) && (!bool12))
      {
        if ((!this.nRs) && (!bool9)) {
          break label1297;
        }
        this.defaultWidth = 640;
        this.defaultHeight = 480;
        if ((bool6) && (bool10)) {
          this.defaultWidth = 1280;
        }
      }
      for (this.defaultHeight = 720;; this.defaultHeight = 360)
      {
        znm = true;
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool4 + ", bEnable480FromSvr:" + bool8 + ", bDisable480FromSvr:" + bool12 + ", bEnable640FromLocal:" + bool5 + ", bEnable640FromSvr:" + bool9);
        this.zoA = new int[this.defaultWidth * this.defaultHeight];
        g.afz();
        this.oap = com.tencent.mm.kernel.a.getUin();
        int k = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
        int m = localDisplay.getWidth();
        int n = localDisplay.getHeight();
        long l2 = 0L;
        int i1 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ptX, -1);
        ad.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i1) });
        int i2 = ae.fFx.fzZ;
        ad.i("MicroMsg.Voip", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(i2) });
        long l1 = l2;
        if (i1 > 0)
        {
          l1 = l2;
          if (i2 > 0)
          {
            l1 = (i1 * 100000.0D) + 456L;
            ad.i("MicroMsg.Voip", "kerrizhang typectrl %d", new Object[] { Long.valueOf(l1) });
          }
        }
        i1 = this.netType;
        i2 = this.defaultWidth;
        k = init(i << 8 | i1, 2, this.defaultHeight | i2 << 16, m << 16 | n, this.oap, j << 24 | k << 16 | cpuFlag0, com.tencent.mm.loader.j.b.ahY() + "lib/", 0, l1);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "protocal init ret :" + k + ",uin= " + this.oap + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i);
        this.hBC = true;
        if (k < 0) {
          reset();
        }
        AppMethodBeat.o(115279);
        return k;
        bool4 = false;
        break;
        label1209:
        bool5 = false;
        break label90;
        label1215:
        bool6 = false;
        break label110;
        label1221:
        bool7 = false;
        break label130;
        label1227:
        bool8 = false;
        break label202;
        label1233:
        bool9 = false;
        break label275;
        label1239:
        bool10 = false;
        break label288;
        label1245:
        bool11 = false;
        break label361;
        label1251:
        bool12 = false;
        break label373;
        label1257:
        i = 0;
        break label384;
        label1262:
        j = 0;
        break label395;
        label1267:
        bool1 = false;
        break label408;
        label1273:
        bool1 = false;
        break label443;
        label1279:
        bool2 = false;
        break label462;
        label1285:
        bool3 = false;
        break label482;
        label1291:
        bool13 = false;
        break label490;
        label1297:
        this.defaultWidth = 480;
      }
      label1314:
      continue;
      label1317:
      i = 0;
      break label635;
      label1322:
      bool2 = false;
      bool3 = bool1;
      break label482;
      label1332:
      i = 0;
    }
  }
  
  public final boolean dVA()
  {
    return this.hBC;
  }
  
  public final int dVC()
  {
    AppMethodBeat.i(115278);
    this.netType = com.tencent.mm.plugin.voip.b.c.getNetType(aj.getContext());
    if (this.netType == 5) {
      this.netType = 4;
    }
    this.zoA = new int[this.defaultWidth * this.defaultHeight];
    g.afz();
    this.oap = com.tencent.mm.kernel.a.getUin();
    int i = m.WG();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.oap, k << 24 | j << 16 | i, com.tencent.mm.loader.j.b.ahY() + "lib/", 4, 0L);
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "protocal init ret :" + i + ",uin= " + this.oap);
    this.hBC = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(115278);
    return i;
  }
  
  public final String dVE()
  {
    AppMethodBeat.i(115281);
    String str = dVn();
    AppMethodBeat.o(115281);
    return str;
  }
  
  public final String[] dVF()
  {
    AppMethodBeat.i(115282);
    String[] arrayOfString = getNatReport();
    com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115282);
    return arrayOfString;
  }
  
  public final String[] dVG()
  {
    AppMethodBeat.i(115283);
    String[] arrayOfString = getMPDirectReport();
    com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "direct_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "direct_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115283);
    return arrayOfString;
  }
  
  public final String[] dVH()
  {
    AppMethodBeat.i(115284);
    String[] arrayOfString = getMPRelayReport();
    com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "relay_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "relay_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115284);
    return arrayOfString;
  }
  
  public final String[] dVI()
  {
    AppMethodBeat.i(115285);
    String[] arrayOfString = getMPEngineReport();
    com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "engine_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = (this.sAY + "," + this.sBf + arrayOfString[i]);
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip", "engine_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115285);
    return arrayOfString;
  }
  
  public final String dVJ()
  {
    AppMethodBeat.i(115286);
    String str = dVx();
    AppMethodBeat.o(115286);
    return str;
  }
  
  protected final String dVp()
  {
    AppMethodBeat.i(115265);
    if (this.field_videoDuration == 0)
    {
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "captureFrames:" + this.zpa + ", videoduration: 0");
      AppMethodBeat.o(115265);
      return ",0";
    }
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "capturefps:" + this.zpa / this.field_videoDuration + " framecount:" + this.zpa + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.zpa / this.field_videoDuration;
    AppMethodBeat.o(115265);
    return str;
  }
  
  public final int dVq()
  {
    if (this.zps > 0) {
      return this.zps;
    }
    if (this.field_videoDuration == 0) {
      return 0;
    }
    return this.zpa / this.field_videoDuration;
  }
  
  public final void dVr()
  {
    AppMethodBeat.i(192079);
    this.zps = 0;
    ad.i("MicroMsg.Voip", "resetCaptureFps");
    AppMethodBeat.o(192079);
  }
  
  final String dVw()
  {
    AppMethodBeat.i(115269);
    getChannelInfo(this.zpi, this.zpi.length, this.zoB, this.zoC, this.zoD, this.zoE);
    Object localObject = new StringBuilder().append(this.sAY).append(",").append(this.roomId).append(",").append(this.sBf).append(this.zpq.dTD());
    o localo = this.zpq;
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localo.zkx).toString() + new String(this.zpi, 0, this.field_channelStatLength))));
    getChannelReport(this.zpi, this.zpi.length);
    localObject = new String(this.zpi, 0, this.field_channelReportLength);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(115269);
    return localObject;
  }
  
  final String dVy()
  {
    AppMethodBeat.i(115271);
    getEngine2ndInfo(this.zpl, this.zpl.length);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.sAY + "," + this.roomId + "," + this.sBf + new String(this.zpl, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.zpl, this.zpl.length);
    String str = this.sAY + "," + this.roomId + "," + this.sBf + new String(this.zpl, 0, this.field_engine2ndReportLength);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115271);
    return str;
  }
  
  public final String dVz()
  {
    AppMethodBeat.i(115272);
    int i = cpuFlag0;
    String str = dVm() + "," + this.zoc + "," + (i & 0xFF) + dVv() + "," + this.znU;
    AppMethodBeat.o(115272);
    return str;
  }
  
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
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.VoipService", "callByJni : arg1:" + paramInt1 + " arg2:" + paramInt2);
    if (paramInt1 == 100)
    {
      com.tencent.mm.plugin.voip.b.c.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      AppMethodBeat.o(115274);
      return 0;
    }
    if (paramInt1 == 101)
    {
      com.tencent.mm.plugin.voip.b.c.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
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
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.VoipService", "callByJniInt : arg1:" + paramInt1 + " arg2:" + paramInt2);
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
  
  public final String rG(boolean paramBoolean)
  {
    AppMethodBeat.i(115280);
    if (this.hBC)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.zpq.zkr;
      this.field_ChannelReportDial[1] = this.zpq.zkx;
      this.field_ChannelReportDial[2] = this.zoB;
      this.field_ChannelReportDial[3] = this.zoC;
      this.field_ChannelReportDial[4] = this.zoD;
      this.field_ChannelReportDial[5] = this.zoE;
      this.field_EngineReportStatFromApp = new int[14];
      dVv();
      this.field_EngineReportStatFromApp[0] = this.znJ;
      this.field_EngineReportStatFromApp[1] = this.znK;
      this.field_EngineReportStatFromApp[2] = this.znP;
      this.field_EngineReportStatFromApp[3] = this.znQ;
      this.field_EngineReportStatFromApp[4] = this.znO;
      this.field_EngineReportStatFromApp[5] = this.znR;
      this.field_EngineReportStatFromApp[6] = this.znS;
      this.field_EngineReportStatFromApp[7] = -1;
      if (this.zpt != null)
      {
        this.field_EngineReportStatFromApp[8] = this.zpt.nQf;
        this.field_EngineReportStatFromApp[9] = this.zpt.nQh;
        this.field_EngineReportStatFromApp[10] = this.zpt.nPX;
        if (zpu == null) {
          break label1116;
        }
        this.field_EngineReportStatFromApp[11] = zpu.zgC;
      }
      for (;;)
      {
        this.field_EngineReportStatFromApp[12] = this.zoR;
        this.field_EngineReportStatFromApp[13] = this.zoS;
        this.hBC = false;
        uninit(this.roomId, this.sAY, this.sBf);
        znm = false;
        zno = 0;
        if (this.zpt != null)
        {
          this.zpt.dRZ();
          this.zpt = null;
        }
        if (zpu != null)
        {
          zpu.interrupt();
          zpu.dRZ();
          zpu = null;
        }
        if (zpw != null) {
          zpw.release();
        }
        zpw = null;
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1127;
        }
        getStatInfo(this.zpf, this.zpf.length, this.zpo, 30);
        getEngineVersionInfo(this.zpg, this.zpg.length);
        getEngineQosInfo(this.zph, this.zph.length);
        Object localObject1 = new StringBuilder();
        long l = this.oap;
        if (this.oap < 0) {
          l = this.oap + 4294967296L;
        }
        Object localObject2 = new StringBuilder().append(l).append(",").append(this.sAY).append(",").append(this.roomId).append(",").append(this.sBf).append(",");
        o localo = this.zpq;
        localObject2 = new StringBuilder().append(localo.zkh).append(",").append(localo.zki).append(",").append(localo.zkj).append(",").append(localo.zkk).append(",").append(localo.zkl).append(",").append(localo.zkm).append(",").append(localo.zkn).append(",").append(localo.zko).append(",").append(localo.zkp).append(",").append(localo.zkq).append(",").append(localo.zkr).toString();
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.zpf, 0, this.field_statInfoLength)).append(dVm()).append(dVo());
        localObject2 = this.zpq;
        localObject1 = ((StringBuilder)localObject1).append("," + ((o)localObject2).zks).append(new String(this.zpg, 0, this.field_engineVersionStatLength)).append(dVp());
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + dVt() + dVu() + new String(this.zph, 0, this.field_engineQosStatLength);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.zpf, 0, this.field_statInfoLength));
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.zpg, 0, this.field_engineVersionStatLength));
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.zph, 0, this.field_engineQosStatLength));
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        ar.a.gMX.cZ(this.field_netFlowRecv, this.field_netFlowSent);
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
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
  
  public native int recordCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public final void reset()
  {
    AppMethodBeat.i(115287);
    ad.m("MicroMsg.Voip", "v2protocal reset!", new Object[0]);
    dVs();
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.roomId = 0;
    this.zns = 0L;
    this.znr = 0;
    this.sBf = 0;
    this.sAY = 0L;
    this.channelStrategy = 0;
    this.sBa = 0;
    this.hgs = 0L;
    this.znt = null;
    this.znu = null;
    this.znv = null;
    this.znw = 0;
    this.znx = null;
    this.zoE = 0;
    this.zoF = null;
    this.zoG = 0;
    this.zoH = 0;
    this.znC = null;
    this.znD = null;
    this.zoM = null;
    this.zoN = null;
    this.zoT = null;
    this.zoU = null;
    this.zoV = null;
    this.zpa = 0;
    this.zpb = 0;
    this.zpc = 0;
    this.zpd = 0;
    this.zpe = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.zpp = 0;
    this.zof = 0;
    this.zoe = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.znJ = 0;
    this.znK = 0;
    this.znL = 65536;
    this.znM = 0;
    this.znN = 0;
    this.znU = -1;
    this.zoc = 0;
    this.zoQ = 0;
    this.znp = 0;
    this.fPP = "";
    this.zoO = 0;
    this.zoP = 0;
    this.zpq.reset();
    this.zpq.dTC();
    znm = false;
    zno = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.znX = 0;
    this.znY = 0;
    this.znZ = 0;
    this.zoa = 0;
    this.zob = "";
    this.zpr = 0;
    int i = freeJNIReport();
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
    AppMethodBeat.o(115287);
  }
  
  public native int setActive();
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(115259);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
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
  
  public native int videoEncodeToSend(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int videoHWDecode(byte[] paramArrayOfByte);
  
  public native int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2);
  
  public native int videoRorate90D(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */