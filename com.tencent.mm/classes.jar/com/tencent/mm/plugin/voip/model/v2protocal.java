package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.RouteInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.format.Formatter;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fej;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class v2protocal
{
  public static int Fno;
  public static boolean Fnp;
  public static boolean NQA;
  public static boolean NQB;
  public static boolean NQC;
  public static boolean NQD;
  public static int NQE;
  public static int NRr;
  public static d NSM;
  public static Surface NSO;
  public static com.tencent.mm.media.g.d NSP;
  private static int NSo;
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  protected static int cpuFlag0;
  public static SurfaceTexture mSurfaceTexture;
  public long DPJ;
  public int DPL;
  public int DPQ;
  public int Ftu;
  public int NQF;
  public int NQG;
  public int NQH;
  public long NQI;
  public byte[] NQJ;
  public volatile byte[] NQK;
  public byte[] NQL;
  public int NQM;
  public byte[] NQN;
  public int NQO;
  public int NQP;
  public int NQQ;
  public int NQR;
  public byte[] NQS;
  public byte[] NQT;
  public byte[] NQU;
  public int NQV;
  public int NQW;
  public int NQX;
  public int NQY;
  public int NQZ;
  public int NRA;
  public int NRB;
  public int NRC;
  public int NRD;
  public int NRE;
  public int NRF;
  public int NRG;
  public int NRH;
  public int NRI;
  public int NRJ;
  public int NRK;
  public int NRL;
  public int NRM;
  public int NRN;
  public int NRO;
  public int NRP;
  public int NRQ;
  public int[] NRR;
  public int NRS;
  public int NRT;
  public int NRU;
  public int NRV;
  public byte[] NRW;
  public int NRX;
  public int NRY;
  public int NRZ;
  public int NRa;
  public int NRb;
  public int NRc;
  public int NRd;
  public int NRe;
  public int NRf;
  public int NRg;
  public int NRh;
  public int NRi;
  public int NRj;
  public int NRk;
  public int NRl;
  public int NRm;
  public int NRn;
  public int NRo;
  public int NRp;
  public int NRq;
  public String NRs;
  public int NRt;
  public int NRu;
  public int NRv;
  public int NRw;
  public int NRx;
  public int NRy;
  public int NRz;
  byte[] NSA;
  byte[] NSB;
  byte[] NSC;
  byte[] NSD;
  public byte[] NSE;
  public byte[] NSF;
  public int[] NSG;
  int NSH;
  public o NSI;
  public int NSJ;
  private int NSK;
  public volatile e NSL;
  int NSN;
  public int NSa;
  public byte[] NSb;
  public int NSc;
  public byte[] NSd;
  public byte[] NSe;
  public int NSf;
  public int NSg;
  public int NSh;
  public int NSi;
  public int NSj;
  public int NSk;
  public byte[] NSl;
  public byte[] NSm;
  public byte[] NSn;
  public ArrayBlockingQueue<byte[]> NSp;
  long NSq;
  public byte[] NSr;
  public int NSs;
  public int NSt;
  public int NSu;
  public int NSv;
  public int NSw;
  byte[] NSx;
  byte[] NSy;
  byte[] NSz;
  int bitrate;
  public int channelStrategy;
  public int defaultHeight;
  public int defaultWidth;
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
  private MMHandler handler;
  public int height;
  public String jLI;
  public long lNP;
  protected boolean lsn;
  public int netType;
  public int roomId;
  public boolean tSw;
  public int ucB;
  public int width;
  
  static
  {
    AppMethodBeat.i(115291);
    v2protocal.class.getClassLoader();
    j.KW("voipMain");
    int i = m.aus();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      NQA = false;
      NQB = false;
      NQC = false;
      NQD = false;
      NQE = 0;
      NRr = 0;
      Fnp = false;
      Fno = 0;
      NSo = 10;
      NSM = null;
      NSO = null;
      NSP = null;
      AppMethodBeat.o(115291);
      return;
    }
  }
  
  public v2protocal(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(115273);
    this.lNP = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.NQF = 0;
    this.ucB = 0;
    this.jLI = "";
    this.NQG = 0;
    this.NQH = 0;
    this.roomId = 0;
    this.NQI = 0L;
    this.DPQ = 0;
    this.DPJ = 0L;
    this.DPL = 0;
    this.NQJ = null;
    this.NQK = null;
    this.NQL = null;
    this.NQM = 0;
    this.NQN = null;
    this.channelStrategy = 0;
    this.NQO = 500;
    this.NQP = 30;
    this.NQQ = 999;
    this.NQR = 0;
    this.NQS = null;
    this.NQT = null;
    this.NQU = new byte[10];
    this.NQV = 20;
    this.NQW = 0;
    this.Ftu = 0;
    this.NQX = 0;
    this.NQY = 0;
    this.NQZ = 0;
    this.NRa = 65536;
    this.NRb = 0;
    this.NRc = 0;
    this.NRd = 0;
    this.NRe = 7;
    this.NRf = 3;
    this.NRg = 3;
    this.NRh = 0;
    this.NRi = 0;
    this.NRj = -1;
    this.NRk = -1;
    this.NRl = 0;
    this.NRm = 0;
    this.NRn = 0;
    this.NRo = 0;
    this.NRp = 0;
    this.NRq = 0;
    this.NRs = "";
    this.NRt = 0;
    this.NRu = 0;
    this.NRv = 0;
    this.NRw = 0;
    this.NRx = 100;
    this.NRy = 300;
    this.NRz = 1;
    this.NRA = 1;
    this.NRB = 0;
    this.NRC = 1;
    this.NRD = 0;
    this.NRE = 0;
    this.NRF = 0;
    this.NRG = 0;
    this.NRH = 0;
    this.NRI = 0;
    this.NRJ = 0;
    this.NRK = 0;
    this.NRL = 0;
    this.NRM = 0;
    this.NRN = 0;
    this.NRO = 0;
    this.NRP = 0;
    this.NRQ = 0;
    this.NRR = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_mGetValidSample = 0;
    this.NRS = 0;
    this.NRT = 0;
    this.NRU = 0;
    this.NRV = 0;
    this.NRW = null;
    this.NRX = 0;
    this.NRY = 0;
    this.NRZ = 0;
    this.NSa = 0;
    this.NSb = new byte[1500];
    this.NSc = 0;
    this.NSd = null;
    this.NSe = null;
    this.NSf = 0;
    this.NSg = 0;
    this.NSh = 0;
    this.NSi = 0;
    this.NSj = 0;
    this.NSk = 0;
    this.NSl = null;
    this.NSm = null;
    this.NSn = null;
    this.NSp = new ArrayBlockingQueue(NSo);
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
    this.NSq = 0L;
    this.NSr = new byte[8];
    this.NSs = 0;
    this.NSt = 0;
    this.NSu = 0;
    this.NSv = 0;
    this.NSw = 0;
    this.NSx = new byte[4096];
    this.NSy = new byte[2048];
    this.NSz = new byte[2048];
    this.NSA = new byte[4096];
    this.NSB = new byte[4096];
    this.NSC = new byte[2048];
    this.NSD = new byte[4096];
    this.NSE = new byte[2048];
    this.NSF = new byte[2048];
    this.NSG = new int[30];
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
    this.NSH = 0;
    this.NSI = new o();
    this.NSJ = 0;
    this.NSK = 0;
    this.handler = null;
    this.lsn = false;
    this.NSL = null;
    this.width = 640;
    this.height = 480;
    this.NSN = 8;
    this.bitrate = 300;
    this.tSw = true;
    this.handler = paramMMHandler;
    AppMethodBeat.o(115273);
  }
  
  private static boolean aQg(String paramString)
  {
    AppMethodBeat.i(115288);
    if ((((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbV, 0) == 1) || (com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Voip", "SupportAvcCodec codecUseCache = %b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (!MultiProcessMMKV.getDefault().contains("SupportAvcCodec_".concat(String.valueOf(paramString))))) {
        break;
      }
      bool = MultiProcessMMKV.getDefault().decodeBool("SupportAvcCodec_".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.Voip", "SupportAvcCodec use MMKV cache res = %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115288);
      return bool;
    }
    bool = bgh(paramString);
    MultiProcessMMKV.getDefault().encode("SupportAvcCodec_".concat(String.valueOf(paramString)), bool);
    Log.i("MicroMsg.Voip", "SupportAvcCodec result saving to MMKV, key = %s, val = %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(115288);
    return bool;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean bgh(String paramString)
  {
    AppMethodBeat.i(238093);
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
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
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
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
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
      Log.printErrStackTrace("MicroMsg.Voip", paramString, "SupportAvcCodec error: %s", new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      AppMethodBeat.o(238093);
      return bool1;
      label268:
      bool1 = false;
    }
  }
  
  public static long cD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115262);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(115262);
    return l;
  }
  
  private native int forceredirect(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);
  
  private static String gBa()
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
  
  private String gBb()
  {
    long l3 = 0L;
    AppMethodBeat.i(115263);
    int i;
    if ((this.Ftu == 0) && (this.NQX == 0))
    {
      this.NSI.NNH = 0;
      this.NSI.NNP = com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext());
      MMApplicationContext.getContext();
      i = com.tencent.mm.plugin.voip.c.e.gCA();
      this.NSI.NNO = this.field_videoDuration;
      this.NSI.NNN = this.field_audioDuration;
      this.NRb = com.tencent.mm.plugin.audio.c.a.crq();
      if ((this.NSI.NNX <= 0L) || (this.NSI.NNR <= this.NSI.NNX)) {
        break label1496;
      }
    }
    label1496:
    for (long l1 = this.NSI.NNR - this.NSI.NNX;; l1 = 0L)
    {
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.NSr, this.NSr.length);
      long l4 = cD(this.NSr);
      Object localObject1 = this.NSI;
      if ((l4 > this.NSI.NNV) && (this.NSI.NNV > 0L)) {}
      for (long l2 = l4 - this.NSI.NNV;; l2 = 0L)
      {
        ((o)localObject1).NNY = l2;
        localObject1 = this.NSI;
        l2 = l3;
        if (l4 > this.NSI.NNX)
        {
          l2 = l3;
          if (this.NSI.NNX > 0L) {
            l2 = l4 - this.NSI.NNX;
          }
        }
        ((o)localObject1).NNZ = l2;
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.NSI.NNY + " lCalledWaitTime:" + this.NSI.NNZ);
        int j = cpuFlag0;
        boolean bool = com.tencent.mm.plugin.voip.c.gxv();
        int k = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXn, 0);
        StringBuilder localStringBuilder = new StringBuilder().append(this.NQW).append(",").append(this.roomId).append(",").append(this.DPJ).append(",").append(this.DPQ).append(",").append(this.NSI.NNq).append(",").append(this.NSI.NNC).append(",").append(this.NSI.NND).append(",").append(this.NSI.NNE).append(",").append(this.NSI.NNF).append(",").append(this.NSI.NNG).append(",").append(this.NSI.NNH).append(",").append(this.NSI.NNA).append(",").append(this.NSI.NNI).append(",").append(this.NSI.NNJ).append(",").append(this.NSI.NNK).append(",").append(this.NSI.NNL).append(",").append(this.NSI.NNM).append(",").append(this.NSI.NNN).append(",").append(this.NSI.NNO).append(",").append(this.NSI.NNP).append(gBh()).append(gBi()).append(gBa()).append(",").append(this.NSI.NNQ).append(",").append(this.NRa).append(",").append(this.NRb).append(",").append(l1).append(",").append(this.NSI.NNY).append(",").append(this.NSI.NNZ).append(",").append(this.NRc).append(",").append(this.NQG).append(gBc()).append(",").append(j & 0xFF).append(",").append(this.NRj).append(",").append(this.NRk);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.NSI.NNS + "," + this.NSI.NNU + "," + this.NSI.NNT + ",0," + this.NSI.NOa + "," + this.NSI.NKQ + "," + this.NSI.NKR + "," + this.NSI.NOb + ",0,0,0," + this.NRl + "," + this.NRm + "," + this.NRd + "," + this.NRn + "," + this.NRo + "," + this.NRp + "," + this.NSJ + "," + this.NRs + "," + this.NRq + "," + NRr + "," + k + "," + bool + "," + i;
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.NQG);
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", ":".concat(String.valueOf(localObject1)));
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + gBc());
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.NSI.NKQ + ",lInterruptEndTime:" + this.NSI.NKR + ",mIinterruptCnt:" + this.NSI.NOb + ",iPlayMinBufSize:" + this.NRl + ",iRecordMinBufSize:" + this.NRm);
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.NSJ);
        AppMethodBeat.o(115263);
        return localObject1;
        if ((this.NQX != 0) && (this.Ftu != 0))
        {
          this.NSI.NNH = 3;
          break;
        }
        if (this.NQX != 0)
        {
          this.NSI.NNH = 1;
          break;
        }
        if (this.Ftu == 0) {
          break;
        }
        this.NSI.NNH = 2;
        break;
      }
    }
  }
  
  private String gBc()
  {
    AppMethodBeat.i(115264);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(115264);
    return str;
  }
  
  private void gBg()
  {
    AppMethodBeat.i(184064);
    if ((this.NSs <= 0) || (this.field_videoDuration <= 0))
    {
      AppMethodBeat.o(184064);
      return;
    }
    this.NSK = (this.NSs / this.field_videoDuration);
    Log.i("MicroMsg.Voip", "calcCpatureFps:%s", new Object[] { Integer.valueOf(this.NSK) });
    AppMethodBeat.o(184064);
  }
  
  private String gBh()
  {
    AppMethodBeat.i(115266);
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "usePreConnect:" + this.NRv);
    String str = "," + this.NRv;
    AppMethodBeat.o(115266);
    return str;
  }
  
  private String gBi()
  {
    AppMethodBeat.i(115267);
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.NRw);
    String str = "," + this.NRw;
    AppMethodBeat.o(115267);
    return str;
  }
  
  private String gBj()
  {
    AppMethodBeat.i(115268);
    this.NRf = com.tencent.mm.plugin.audio.c.a.crn().audioManager.getMode();
    this.NRg = com.tencent.mm.plugin.audio.c.a.crn().audioManager.getMode();
    if (af.juI.joo >= 0) {
      this.NRf = af.juI.joo;
    }
    if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.k.are()) && (2 == af.juS.jqR)) {
      this.NRg = 2;
    }
    if (af.juI.jop >= 0) {
      this.NRg = af.juI.jop;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      this.NRe = 1;
      if (af.juI.jnK) {
        this.NRe = 1;
      }
      if (af.juI.jon >= 0) {
        this.NRe = af.juI.jon;
      }
      if (af.juI.jnL <= 0) {
        break label292;
      }
      this.NRh = 3;
      this.NRi = 0;
    }
    for (;;)
    {
      if (af.juI.jor >= 0) {
        this.NRh = af.juI.jor;
      }
      if (af.juI.jos >= 0) {
        this.NRi = af.juI.jos;
      }
      String str = "," + this.NRf + "," + this.NRg + "," + this.NRe + "," + this.NRh + "," + this.NRi;
      AppMethodBeat.o(115268);
      return str;
      this.NRe = 7;
      break;
      label292:
      if (af.juI.joq >= 0)
      {
        this.NRh = af.juI.joq;
        this.NRi = af.juI.joq;
      }
    }
  }
  
  private String gBl()
  {
    AppMethodBeat.i(115270);
    getNewEngineInfo(this.NSB, this.NSB.length);
    getNewEngineExtInfo(this.NSC, this.NSC.length);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.DPQ + "," + this.DPJ + this.NSI.gzl() + "," + this.Ftu + "," + this.NQX + gBd() + new String(this.NSB, 0, this.field_newEngineStatLength) + "," + this.NQY + "," + this.NQZ + gBj() + new String(this.NSC, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.NSB, this.NSB.length);
    String str = this.DPQ + "," + this.DPJ + this.NSI.gzl() + "," + this.Ftu + "," + this.NQX + gBd() + new String(this.NSB, 0, this.field_newEngineReportLength);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115270);
    return str;
  }
  
  public static String gBp()
  {
    AppMethodBeat.i(238064);
    if (Build.VERSION.SDK_INT < 23)
    {
      localObject1 = Formatter.formatIpAddress(((WifiManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(238064);
      return localObject1;
    }
    Object localObject1 = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    localObject1 = ((ConnectivityManager)localObject1).getLinkProperties(((ConnectivityManager)localObject1).getActiveNetwork());
    if (localObject1 == null)
    {
      Log.i("MicroMsg.Voip", "linkProperties null");
      AppMethodBeat.o(238064);
      return "";
    }
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "Interface name:" + ((LinkProperties)localObject1).getInterfaceName());
    Object localObject2 = ((LinkProperties)localObject1).getRoutes().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RouteInfo localRouteInfo = (RouteInfo)((Iterator)localObject2).next();
      if ((localRouteInfo.isDefaultRoute()) && (localRouteInfo.hasGateway()))
      {
        localObject2 = localRouteInfo.getGateway();
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "get wifi route ip:" + ((InetAddress)localObject2).getHostAddress());
        if ((localObject2 instanceof Inet6Address)) {
          try
          {
            i = NetworkInterface.getByName(((LinkProperties)localObject1).getInterfaceName()).getIndex();
            localObject1 = ((InetAddress)localObject2).getHostAddress() + "%" + i;
            AppMethodBeat.o(238064);
            return localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Voip", localException, "NetworkInterface error: %s", new Object[] { localException.getMessage() });
              int i = 0;
            }
          }
        }
        String str = ((InetAddress)localObject2).getHostAddress();
        if (str == null)
        {
          AppMethodBeat.o(238064);
          return "";
        }
        AppMethodBeat.o(238064);
        return str;
      }
    }
    AppMethodBeat.o(238064);
    return "";
  }
  
  public static boolean gBr()
  {
    AppMethodBeat.i(238068);
    int i = m.aus();
    boolean bool1;
    int j;
    int k;
    int m;
    long l;
    boolean bool2;
    label80:
    boolean bool3;
    label106:
    boolean bool4;
    if ((i & 0x400) != 0)
    {
      bool1 = true;
      j = i >> 12 & 0xF;
      k = i & 0xFF;
      m = Build.VERSION.SDK_INT;
      l = com.tencent.matrix.e.a.getTotalMemory(MMApplicationContext.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDP, 4)) {
        break label295;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDQ, 71)) {
        break label301;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDR, 23)) {
        break label307;
      }
      bool4 = true;
      label132:
      if (l < ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDS, 4096)) {
        break label313;
      }
    }
    label295:
    label301:
    label307:
    label313:
    for (boolean bool5 = true;; bool5 = false)
    {
      Log.i("MicroMsg.Voip", "check720EncodeLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s, nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label319;
      }
      AppMethodBeat.o(238068);
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label80;
      bool3 = false;
      break label106;
      bool4 = false;
      break label132;
    }
    label319:
    AppMethodBeat.o(238068);
    return false;
  }
  
  public static String gBs()
  {
    return "";
  }
  
  private native int setsvraddr(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, byte[] paramArrayOfByte, int paramInt5);
  
  private native int uninit(int paramInt1, long paramLong, int paramInt2);
  
  public final String AZ(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(115280);
    if (this.lsn)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.NSI.NNA;
      this.field_ChannelReportDial[1] = this.NSI.NNG;
      this.field_ChannelReportDial[2] = this.NRS;
      this.field_ChannelReportDial[3] = this.NRT;
      this.field_ChannelReportDial[4] = this.NRU;
      this.field_ChannelReportDial[5] = this.NRV;
      this.field_EngineReportStatFromApp = new int[19];
      gBj();
      this.field_EngineReportStatFromApp[0] = this.NQY;
      this.field_EngineReportStatFromApp[1] = this.NQZ;
      this.field_EngineReportStatFromApp[2] = this.NRf;
      this.field_EngineReportStatFromApp[3] = this.NRg;
      this.field_EngineReportStatFromApp[4] = this.NRe;
      this.field_EngineReportStatFromApp[5] = this.NRh;
      this.field_EngineReportStatFromApp[6] = this.NRi;
      this.field_EngineReportStatFromApp[7] = -1;
      label265:
      label324:
      Object localObject1;
      if (this.NSL != null)
      {
        this.field_EngineReportStatFromApp[8] = this.NSL.tQS;
        this.field_EngineReportStatFromApp[9] = this.NSL.tQU;
        this.field_EngineReportStatFromApp[10] = this.NSL.tQK;
        if (NSM == null) {
          break label1280;
        }
        this.field_EngineReportStatFromApp[11] = NSM.FqT;
        this.field_EngineReportStatFromApp[12] = this.NSi;
        this.field_EngineReportStatFromApp[13] = this.NSj;
        this.field_EngineReportStatFromApp[14] = this.NSk;
        if (!NQD) {
          break label1291;
        }
        this.field_EngineReportStatFromApp[15] = 1280;
        this.field_EngineReportStatFromApp[16] = 720;
        localObject1 = this.field_EngineReportStatFromApp;
        if (!NQC) {
          break label1314;
        }
        i = 1;
        label338:
        localObject1[17] = i;
        localObject1 = this.field_EngineReportStatFromApp;
        if (!NQB) {
          break label1319;
        }
      }
      label1280:
      label1291:
      label1314:
      label1319:
      for (int i = j;; i = 0)
      {
        localObject1[18] = i;
        this.lsn = false;
        uninit(this.roomId, this.DPJ, this.DPQ);
        NQA = false;
        NQE = 0;
        if (this.NSL != null)
        {
          this.NSL.eWp();
          this.NSL = null;
          localObject1 = com.tencent.mm.plugin.voip.c.c.NXF;
          com.tencent.mm.plugin.voip.c.c.gCn();
        }
        if (NSM != null)
        {
          NSM.interrupt();
          localObject1 = NSM;
          ((d)localObject1).FqM = false;
          ((d)localObject1).FqN = false;
          ((d)localObject1).FqP = 0;
          Log.d("MicroMsg.AvcDecoder", "steve: Stop Decode Thread!");
        }
        try
        {
          if (((d)localObject1).outputStream != null)
          {
            ((d)localObject1).outputStream.flush();
            ((d)localObject1).outputStream.close();
          }
          if (((d)localObject1).FqD != null)
          {
            ((d)localObject1).FqD.flush();
            ((d)localObject1).FqD.close();
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            long l;
            Object localObject2;
            o localo;
            Log.e("MicroMsg.AvcDecoder", " error:" + localIOException.toString());
          }
        }
        NSM = null;
        if (NSO != null) {
          NSO.release();
        }
        NSO = null;
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1356;
        }
        getStatInfo(this.NSx, this.NSx.length, this.NSG, 30);
        getEngineVersionInfo(this.NSy, this.NSy.length);
        getEngineQosInfo(this.NSz, this.NSz.length);
        localObject1 = new StringBuilder();
        l = this.ucB;
        if (this.ucB < 0) {
          l = this.ucB + 4294967296L;
        }
        localObject2 = new StringBuilder().append(l).append(",").append(this.DPJ).append(",").append(this.roomId).append(",").append(this.DPQ).append(",");
        localo = this.NSI;
        localObject2 = new StringBuilder().append(localo.NNq).append(",").append(localo.NNr).append(",").append(localo.NNs).append(",").append(localo.NNt).append(",").append(localo.NNu).append(",").append(localo.NNv).append(",").append(localo.NNw).append(",").append(localo.NNx).append(",").append(localo.NNy).append(",").append(localo.NNz).append(",").append(localo.NNA).toString();
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.NSx, 0, this.field_statInfoLength)).append(gBa()).append(gBc());
        localObject2 = this.NSI;
        localObject1 = ((StringBuilder)localObject1).append("," + ((o)localObject2).NNB).append(new String(this.NSy, 0, this.field_engineVersionStatLength)).append(gBd());
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + gBh() + gBi() + new String(this.NSz, 0, this.field_engineQosStatLength);
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.NSx, 0, this.field_statInfoLength));
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.NSy, 0, this.field_engineVersionStatLength));
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.NSz, 0, this.field_engineQosStatLength));
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        az.a.lts.dH(this.field_netFlowRecv, this.field_netFlowSent);
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
        AppMethodBeat.o(115280);
        return localObject1;
        this.field_EngineReportStatFromApp[8] = 0;
        this.field_EngineReportStatFromApp[9] = 0;
        this.field_EngineReportStatFromApp[10] = 0;
        break;
        this.field_EngineReportStatFromApp[11] = 0;
        break label265;
        this.field_EngineReportStatFromApp[15] = 640;
        this.field_EngineReportStatFromApp[16] = 480;
        break label324;
        i = 0;
        break label338;
      }
    }
    label1356:
    AppMethodBeat.o(115280);
    return "";
  }
  
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
      parama.NJg = localAtomicInteger2.get();
      parama.HlR = localAtomicInteger1.get();
      parama.NJf = 0;
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.HlR + ", framelenms =" + parama.NJg + ", channels =" + parama.channels);
      AppMethodBeat.o(115289);
      return j;
    }
    if ((m.aus() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.HlR = i;
      parama.channels = 1;
      parama.NJg = 20;
      parama.NJf = 0;
      break;
    }
  }
  
  public final int a(ffc paramffc)
  {
    AppMethodBeat.i(115260);
    if (this.NSq != 0L)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      AppMethodBeat.o(115260);
      return -1;
    }
    this.NSq = paramffc.UFD;
    fej localfej = new fej();
    localfej.UDX = paramffc.UFD;
    int i = 0;
    while (i < paramffc.UFI)
    {
      fem localfem = new fem();
      localfem.Utd = ((eme)paramffc.UFJ.get(i)).Uoc.Utg;
      localfem.port = ((eme)paramffc.UFJ.get(i)).Uoc.TVY;
      localfem.NZB = ((eme)paramffc.UFJ.get(i)).Uob;
      localfem.UEr = ((eme)paramffc.UFJ.get(i)).UoH;
      localfem.timeout = ((eme)paramffc.UFJ.get(i)).UoI;
      localfem.UEs = ((eme)paramffc.UFJ.get(i)).UoJ;
      localfej.UDY.add(localfem);
      i += 1;
    }
    try
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(localfej.toByteArray(), localfej.toByteArray().length))));
      AppMethodBeat.o(115260);
      return 0;
    }
    catch (IOException paramffc)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Voip", paramffc, "StartVoipSpeedTest exception", new Object[0]);
      }
    }
  }
  
  public native int app2EngineDataEx(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4);
  
  public native int app2EngineLinkQualityEx(int paramInt, byte[] paramArrayOfByte);
  
  public final int bS(LinkedList<dbt> paramLinkedList)
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
        dbt localdbt = new dbt();
        localdbt.ThL = new String(arrayOfByte2, 0, ((AtomicInteger)localObject).get());
        localdbt.TJp = localAtomicInteger5.get();
        localdbt.SpF = localAtomicInteger4.get();
        paramLinkedList.add(localdbt);
      }
      if (localAtomicInteger1.get() > 0)
      {
        localObject = new dbt();
        ((dbt)localObject).ThL = new String(arrayOfByte1, 0, localAtomicInteger1.get());
        ((dbt)localObject).TJp = localAtomicInteger3.get();
        ((dbt)localObject).SpF = localAtomicInteger2.get();
        paramLinkedList.add(localObject);
      }
    }
    AppMethodBeat.o(115290);
    return i;
  }
  
  public native int connectToPeer();
  
  public native int connectToPeerDirect();
  
  public native int connectToPeerRelay();
  
  public native int doubleLinkSwitch(int paramInt);
  
  public native int exchangeCabInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int freeJNIReport();
  
  protected final String gBd()
  {
    AppMethodBeat.i(115265);
    if (this.field_videoDuration == 0)
    {
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "captureFrames:" + this.NSs + ", videoduration: 0");
      AppMethodBeat.o(115265);
      return ",0";
    }
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "capturefps:" + this.NSs / this.field_videoDuration + " framecount:" + this.NSs + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.NSs / this.field_videoDuration;
    AppMethodBeat.o(115265);
    return str;
  }
  
  public final int gBe()
  {
    if (this.NSK > 0) {
      return this.NSK;
    }
    if (this.field_videoDuration == 0) {
      return 0;
    }
    return this.NSs / this.field_videoDuration;
  }
  
  public final void gBf()
  {
    AppMethodBeat.i(238047);
    this.NSK = 0;
    Log.i("MicroMsg.Voip", "resetCaptureFps");
    AppMethodBeat.o(238047);
  }
  
  final String gBk()
  {
    AppMethodBeat.i(115269);
    getChannelInfo(this.NSA, this.NSA.length, this.NRS, this.NRT, this.NRU, this.NRV);
    Object localObject = new StringBuilder().append(this.DPJ).append(",").append(this.roomId).append(",").append(this.DPQ).append(this.NSI.gzl());
    o localo = this.NSI;
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localo.NNG).toString() + new String(this.NSA, 0, this.field_channelStatLength))));
    getChannelReport(this.NSA, this.NSA.length);
    localObject = new String(this.NSA, 0, this.field_channelReportLength);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(115269);
    return localObject;
  }
  
  final String gBm()
  {
    AppMethodBeat.i(115271);
    getEngine2ndInfo(this.NSD, this.NSD.length);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.DPJ + "," + this.roomId + "," + this.DPQ + new String(this.NSD, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.NSD, this.NSD.length);
    String str = this.DPJ + "," + this.roomId + "," + this.DPQ + new String(this.NSD, 0, this.field_engine2ndReportLength);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115271);
    return str;
  }
  
  public final String gBn()
  {
    AppMethodBeat.i(115272);
    int i = cpuFlag0;
    String str = gBa() + "," + this.NRt + "," + (i & 0xFF) + gBj() + "," + this.NRk;
    AppMethodBeat.o(115272);
    return str;
  }
  
  public final boolean gBo()
  {
    return this.lsn;
  }
  
  public final int gBq()
  {
    AppMethodBeat.i(115278);
    this.netType = com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext());
    if (this.netType == 5) {
      this.netType = 4;
    }
    this.NRR = new int[this.defaultWidth * this.defaultHeight];
    h.aHE();
    this.ucB = com.tencent.mm.kernel.b.getUin();
    int i = m.aus();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.ucB, k << 24 | j << 16 | i, com.tencent.mm.loader.j.b.aSC() + "lib/", 4, 0L, 0, 0);
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip", "protocalInitForPstn protocal init ret :" + i + ",uin= " + this.ucB + ", groupRsCap = 0, x_vcodec2_paras = 0");
    this.lsn = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(115278);
    return i;
  }
  
  public final String gBt()
  {
    AppMethodBeat.i(115281);
    String str = gBb();
    AppMethodBeat.o(115281);
    return str;
  }
  
  public final String[] gBu()
  {
    AppMethodBeat.i(115282);
    String[] arrayOfString = getNatReport();
    com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115282);
    return arrayOfString;
  }
  
  public final String[] gBv()
  {
    AppMethodBeat.i(115283);
    String[] arrayOfString = getMPDirectReport();
    com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "direct_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "direct_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115283);
    return arrayOfString;
  }
  
  public final String[] gBw()
  {
    AppMethodBeat.i(115284);
    String[] arrayOfString = getMPRelayReport();
    com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "relay_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "relay_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115284);
    return arrayOfString;
  }
  
  public final String[] gBx()
  {
    AppMethodBeat.i(115285);
    String[] arrayOfString = getMPEngineReport();
    com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "engine_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = (this.DPJ + "," + this.DPQ + arrayOfString[i]);
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip", "engine_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115285);
    return arrayOfString;
  }
  
  public final String gBy()
  {
    AppMethodBeat.i(115286);
    String str = gBl();
    AppMethodBeat.o(115286);
    return str;
  }
  
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
  
  public final int gid()
  {
    AppMethodBeat.i(115279);
    this.netType = com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext());
    this.NQG = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool5;
    boolean bool6;
    label90:
    boolean bool7;
    label110:
    boolean bool1;
    label124:
    boolean bool8;
    label201:
    boolean bool9;
    label274:
    int k;
    label286:
    int i;
    label298:
    boolean bool10;
    label311:
    boolean bool11;
    label323:
    int j;
    label334:
    int m;
    label346:
    int i2;
    int n;
    label378:
    int i1;
    label402:
    label416:
    label426:
    boolean bool12;
    label550:
    label567:
    boolean bool3;
    label579:
    boolean bool2;
    label599:
    label619:
    boolean bool4;
    label639:
    boolean bool13;
    label651:
    label664:
    Object localObject;
    if ((this.NQG >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool5 = true;
      if ((!bool5) || ((cpuFlag0 & 0xFF) < 30)) {
        break label2263;
      }
      bool6 = true;
      if ((!bool6) || ((cpuFlag0 & 0xFF) < 60)) {
        break label2269;
      }
      bool7 = true;
      if ((!bool7) || (!gBr())) {
        break label2275;
      }
      bool1 = true;
      NQC = bool1;
      if ((af.juH.jqm <= 0) || (af.juH.jpO.width < 480) || (af.juH.jpO.height < 360) || (af.juH.jpQ.width < 480) || (af.juH.jpQ.height < 360)) {
        break label2281;
      }
      bool8 = true;
      if ((af.juH.jqm < 2) || (af.juH.jpO.width < 640) || (af.juH.jpO.height < 480) || (af.juH.jpQ.width < 640) || (af.juH.jpQ.height < 480)) {
        break label2287;
      }
      bool9 = true;
      if (af.juH.jqm != 2) {
        break label2293;
      }
      k = 1;
      if (af.juH.jqm != 3) {
        break label2298;
      }
      i = 1;
      if (af.juH.jqm < 4) {
        break label2303;
      }
      bool10 = true;
      if (af.juH.jqm != 0) {
        break label2309;
      }
      bool11 = true;
      if (af.juH.jqn != 0) {
        break label2315;
      }
      j = 1;
      if (af.juH.jqn <= 0) {
        break label2320;
      }
      m = 1;
      i2 = af.juH.jqo;
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDN, 0) == 0) {
        break label2326;
      }
      n = 1;
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDM, 0) == 0) {
        break label2332;
      }
      i1 = 1;
      if (af.juH.jqp != 2) {
        break label2338;
      }
      NQB = false;
      if (i2 != 2) {
        break label2373;
      }
      NQD = false;
      if ((af.juH.jpO.width >= 480) || (af.juH.jpQ.width >= 480))
      {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "hseasun:Close the 720p force due to configuration from svr");
        NQB = false;
        NQD = false;
      }
      if (NQB) {
        NQD = true;
      }
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "hseasun: enable720Cap: " + NQD + " enable1280HWEnc: " + NQB);
      NQE = 0;
      this.tSw = false;
      if (j != 0) {
        break label2501;
      }
      if ((!bool6) || (!aQg("video/avc"))) {
        break label2404;
      }
      bool1 = true;
      if ((!bool7) || (!aQg("video/hevc"))) {
        break label2410;
      }
      bool12 = true;
      if ((!bool12) || (i == 0)) {
        break label2416;
      }
      bool3 = true;
      if (m == 0) {
        break label2479;
      }
      if ((af.juH.jqn & 0x10) == 0) {
        break label2422;
      }
      bool2 = true;
      if ((!bool3) || ((af.juH.jqn & 0x20) == 0)) {
        break label2428;
      }
      bool3 = true;
      if ((!bool1) || ((af.juH.jqn & 0xF) == 0)) {
        break label2434;
      }
      bool4 = true;
      bool13 = bool4;
      bool4 = bool3;
      bool3 = bool13;
      if ((!bool4) && (!bool3)) {
        break label2440;
      }
      bool13 = true;
      this.tSw = bool13;
      localObject = new StringBuilder("hwH264Local:").append(bool1).append(",hwHEVCLocal:").append(bool12).append(", bSupportH264HW:").append(bool3).append(", bSupportHEVCSW:").append(bool2).append(", bSupportHEVCHW:").append(bool4).append(", svrHWCfg:").append(af.juH.jqn).append(", 720p jcchen ").append(bool7).append("-");
      if (k != 0) {
        break label2446;
      }
      bool1 = true;
      label770:
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", bool1 + "-" + bool10 + "-" + NQB + " svr 480p:" + af.juH.jqm);
      if (!bool3) {
        break label2474;
      }
      i = 1;
      label831:
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      if (!bool4) {
        break label2469;
      }
      i = j | 0x4;
    }
    for (;;)
    {
      if (((bool5) || (bool8)) && (!bool11))
      {
        if ((!this.tSw) && (!bool9)) {
          break label2452;
        }
        this.defaultWidth = 640;
        this.defaultHeight = 480;
        if ((bool7) && (k == 0)) {
          this.defaultWidth = 1280;
        }
      }
      for (this.defaultHeight = 720;; this.defaultHeight = 360)
      {
        NQA = true;
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool5 + ", bEnable480FromSvr:" + bool8 + ", bDisable480FromSvr:" + bool11 + ", bEnable640FromLocal:" + bool6 + ", bEnable640FromSvr:" + bool9);
        this.NRR = new int[this.defaultWidth * this.defaultHeight];
        h.aHE();
        this.ucB = com.tencent.mm.kernel.b.getUin();
        n = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        localObject = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        i1 = ((Display)localObject).getWidth();
        i2 = ((Display)localObject).getHeight();
        k = af.juS.jrr;
        m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQz, -1);
        long l2 = 0L;
        int i3 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQy, -1);
        Log.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i3) });
        int i4 = af.juI.joB;
        Log.i("MicroMsg.Voip", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(i4) });
        long l1 = l2;
        if (i3 > 0)
        {
          l1 = l2;
          if (i4 > 0)
          {
            l1 = (i3 * 100000.0D) + 456L;
            Log.i("MicroMsg.Voip", "kerrizhang typectrl %d", new Object[] { Long.valueOf(l1) });
          }
        }
        i3 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRa, 0);
        Log.i("MicroMsg.Voip", "winterwang get server opuswbswitch %d", new Object[] { Integer.valueOf(i3) });
        localObject = new byte[4];
        localObject[0] = ((byte)i3);
        Log.i("MicroMsg.Voip", "winterwang setJNIAppCmd  EMethod_AudioOptionSwitch ,ret: %d", new Object[] { Integer.valueOf(setJNIAppCmd(5, (byte[])localObject, 4)) });
        i3 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQK, -1);
        i4 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQL, -1);
        int i5 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQM, -1);
        int i6 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQN, -1);
        int i7 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQO, -1);
        int i8 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQP, -1);
        int i9 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQQ, -1);
        int i10 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQR, -1);
        Log.i("MicroMsg.Voip", "qipengfeng, neteq-x-expt: %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10) });
        if ((i3 > 0) && (i4 > 0) && (i5 > 0) && (i6 > 0) && (i7 >= 0) && (i8 > 0) && (i9 > 0) && (i10 >= 0)) {
          setJNIAppCmd(6, new byte[] { (byte)(i3 & 0xFF), (byte)(i3 >> 8 & 0xFF), (byte)(i3 >> 16 & 0xFF), (byte)(i3 >> 24 & 0xFF), (byte)(i4 & 0xFF), (byte)(i4 >> 8 & 0xFF), (byte)(i4 >> 16 & 0xFF), (byte)(i4 >> 24 & 0xFF), (byte)(i5 & 0xFF), (byte)(i5 >> 8 & 0xFF), (byte)(i5 >> 16 & 0xFF), (byte)(i5 >> 24 & 0xFF), (byte)(i6 & 0xFF), (byte)(i6 >> 8 & 0xFF), (byte)(i6 >> 16 & 0xFF), (byte)(i6 >> 24 & 0xFF), (byte)(i7 & 0xFF), (byte)(i7 >> 8 & 0xFF), (byte)(i7 >> 16 & 0xFF), (byte)(i7 >> 24 & 0xFF), (byte)(i8 & 0xFF), (byte)(i8 >> 8 & 0xFF), (byte)(i8 >> 16 & 0xFF), (byte)(i8 >> 24 & 0xFF), (byte)(i9 & 0xFF), (byte)(i9 >> 8 & 0xFF), (byte)(i9 >> 16 & 0xFF), (byte)(i9 >> 24 & 0xFF), (byte)(i10 & 0xFF), (byte)(i10 >> 8 & 0xFF), (byte)(i10 >> 16 & 0xFF), (byte)(i10 >> 24 & 0xFF) }, 8);
        }
        i3 = this.netType;
        i4 = this.defaultWidth;
        n = init(i << 8 | i3, 2, this.defaultHeight | i4 << 16, i1 << 16 | i2, this.ucB, j << 24 | n << 16 | cpuFlag0, com.tencent.mm.loader.j.b.aSC() + "lib/", 0, l1, k, m);
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "protocalInit protocal init ret :" + n + ",uin= " + this.ucB + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i + ", groupRsCap = " + k + ", x_vcodec2_paras = " + m);
        this.lsn = true;
        if (n < 0) {
          reset();
        }
        AppMethodBeat.o(115279);
        return n;
        bool5 = false;
        break;
        label2263:
        bool6 = false;
        break label90;
        label2269:
        bool7 = false;
        break label110;
        label2275:
        bool1 = false;
        break label124;
        label2281:
        bool8 = false;
        break label201;
        label2287:
        bool9 = false;
        break label274;
        label2293:
        k = 0;
        break label286;
        label2298:
        i = 0;
        break label298;
        label2303:
        bool10 = false;
        break label311;
        label2309:
        bool11 = false;
        break label323;
        label2315:
        j = 0;
        break label334;
        label2320:
        m = 0;
        break label346;
        label2326:
        n = 0;
        break label378;
        label2332:
        i1 = 0;
        break label402;
        label2338:
        if (af.juH.jqp == 1)
        {
          NQB = true;
          break label416;
        }
        if ((!NQC) || (n == 0)) {
          break label416;
        }
        NQB = true;
        break label416;
        label2373:
        if (i2 == 1)
        {
          NQD = true;
          break label426;
        }
        if ((!NQC) || (i1 == 0)) {
          break label426;
        }
        NQD = true;
        break label426;
        label2404:
        bool1 = false;
        break label550;
        label2410:
        bool12 = false;
        break label567;
        label2416:
        bool3 = false;
        break label579;
        label2422:
        bool2 = false;
        break label599;
        label2428:
        bool3 = false;
        break label619;
        label2434:
        bool4 = false;
        break label639;
        label2440:
        bool13 = false;
        break label664;
        label2446:
        bool1 = false;
        break label770;
        label2452:
        this.defaultWidth = 480;
      }
      label2469:
      i = j;
      continue;
      label2474:
      i = 0;
      break label831;
      label2479:
      bool2 = false;
      bool4 = bool1;
      bool13 = bool3;
      bool3 = bool4;
      bool4 = bool13;
      break label651;
      label2501:
      i = 0;
    }
  }
  
  public native int handleCommand(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  protected native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, long paramLong, int paramInt8, int paramInt9);
  
  public native int isDCReady();
  
  public native int isDCSameLan();
  
  public native int isRelayConnReady();
  
  public int keep_onNotifyFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115274);
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.VoipService", "callByJni : arg1:" + paramInt1 + " arg2:" + paramInt2);
    if (paramInt1 == 100)
    {
      com.tencent.mm.plugin.voip.c.e.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      AppMethodBeat.o(115274);
      return 0;
    }
    if (paramInt1 == 101)
    {
      com.tencent.mm.plugin.voip.c.e.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
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
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.VoipService", "callByJniInt : arg1:" + paramInt1 + " arg2:" + paramInt2);
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
    Log.printInfoStack("MicroMsg.Voip", "v2protocal reset!", new Object[0]);
    gBg();
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.roomId = 0;
    this.NQI = 0L;
    this.NQH = 0;
    this.DPQ = 0;
    this.DPJ = 0L;
    this.channelStrategy = 0;
    this.DPL = 0;
    this.lNP = 0L;
    this.NQJ = null;
    this.NQK = null;
    this.NQL = null;
    this.NQM = 0;
    this.NQN = null;
    this.NRV = 0;
    this.NRW = null;
    this.NRX = 0;
    this.NRY = 0;
    this.NQS = null;
    this.NQT = null;
    this.NSd = null;
    this.NSe = null;
    this.NSl = null;
    this.NSm = null;
    this.NSn = null;
    this.NSs = 0;
    this.NSt = 0;
    this.NSu = 0;
    this.NSv = 0;
    this.NSw = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.NSH = 0;
    this.NRw = 0;
    this.NRv = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.NQY = 0;
    this.NQZ = 0;
    this.NRa = 65536;
    this.NRb = 0;
    this.NRc = 0;
    this.NRd = 0;
    this.NRk = -1;
    this.NRt = 0;
    this.NSh = 0;
    this.NQF = 0;
    this.jLI = "";
    this.NSf = 0;
    this.NSg = 0;
    this.NSI.reset();
    this.NSI.gzk();
    NQA = false;
    NQE = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.NRn = 0;
    this.NRo = 0;
    this.NRp = 0;
    this.NRq = 0;
    NRr = 0;
    Fnp = false;
    Fno = 0;
    this.NRs = "";
    this.NSJ = 0;
    com.tencent.mm.plugin.voip.c.gxu();
    int i = freeJNIReport();
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
    AppMethodBeat.o(115287);
  }
  
  public native int setActive();
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(115259);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
    }
    AppMethodBeat.o(115259);
    return paramInt;
  }
  
  public native int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setConfigInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, int paramInt8, int paramInt9, int paramInt10, int paramInt11, byte[] paramArrayOfByte3, int paramInt12, int paramInt13, int paramInt14, byte[] paramArrayOfByte4, int paramInt15, int paramInt16, int paramInt17, int paramInt18, String paramString1, String paramString2, String paramString3);
  
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
  
  public native int videoHWProcess3(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer2, int paramInt5);
  
  public native int videoRorate90D(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */