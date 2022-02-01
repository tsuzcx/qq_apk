package com.tencent.mm.plugin.voip.model;

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
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.protocal.protobuf.fzn;
import com.tencent.mm.protocal.protobuf.gav;
import com.tencent.mm.protocal.protobuf.gay;
import com.tencent.mm.protocal.protobuf.gbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
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
  public static int Ljx;
  public static boolean Ljy;
  public static boolean UDm;
  public static boolean UDn;
  public static boolean UDo;
  public static boolean UDp;
  public static int UDq;
  public static int UEl;
  public static int UEw;
  public static int UEx;
  public static e.a UFR;
  public static d UFS;
  public static Surface UFU;
  public static com.tencent.mm.media.g.d UFV;
  private static int UFt;
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  protected static int cpuFlag0;
  public static SurfaceTexture mSurfaceTexture;
  public static Surface wNj;
  public long Hnt;
  public int JGW;
  public int JHb;
  public int LpO;
  public int UDA;
  public int UDB;
  public int UDC;
  public int UDD;
  public byte[] UDE;
  public byte[] UDF;
  public byte[] UDG;
  public int UDH;
  public int UDI;
  public int UDJ;
  public int UDK;
  public int UDL;
  public int UDM;
  public int UDN;
  public int UDO;
  public int UDP;
  public int UDQ;
  public int UDR;
  public int UDS;
  public int UDT;
  public int UDU;
  public int UDV;
  public int UDW;
  public int UDX;
  public int UDY;
  public int UDZ;
  public int UDr;
  public int UDs;
  public int UDt;
  public long UDu;
  public byte[] UDv;
  public volatile byte[] UDw;
  public byte[] UDx;
  public int UDy;
  public byte[] UDz;
  public int UEA;
  public int UEB;
  public int UEC;
  public int UED;
  public int UEE;
  public int UEF;
  public int UEG;
  public int UEH;
  public int UEI;
  public int UEJ;
  public int UEK;
  public int UEL;
  public int UEM;
  public int UEN;
  public int UEO;
  public int UEP;
  public int UEQ;
  public int UER;
  public int UES;
  public int UET;
  public int UEU;
  public int UEV;
  public int[] UEW;
  public int UEX;
  public int UEY;
  public int UEZ;
  public int UEa;
  public int UEb;
  public int UEc;
  public int UEd;
  public int UEe;
  public int UEf;
  public int UEg;
  public int UEh;
  public int UEi;
  public int UEj;
  public int UEk;
  public String UEm;
  public int UEn;
  public int UEo;
  public int UEp;
  public int UEq;
  public int UEr;
  public int UEs;
  public int UEt;
  public int UEu;
  public int UEv;
  public int UEy;
  public int UEz;
  public int UFA;
  public int UFB;
  byte[] UFC;
  byte[] UFD;
  byte[] UFE;
  byte[] UFF;
  byte[] UFG;
  byte[] UFH;
  byte[] UFI;
  public byte[] UFJ;
  public byte[] UFK;
  public int[] UFL;
  int UFM;
  public o UFN;
  public int UFO;
  int UFP;
  public volatile e UFQ;
  int UFT;
  public int UFa;
  public byte[] UFb;
  public int UFc;
  public int UFd;
  public int UFe;
  public int UFf;
  public byte[] UFg;
  public int UFh;
  public byte[] UFi;
  public byte[] UFj;
  public int UFk;
  public int UFl;
  public int UFm;
  public int UFn;
  public int UFo;
  public int UFp;
  public byte[] UFq;
  public byte[] UFr;
  public byte[] UFs;
  public ArrayBlockingQueue<byte[]> UFu;
  long UFv;
  public byte[] UFw;
  public int UFx;
  public int UFy;
  public int UFz;
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
  public String mkQ;
  public int netType;
  public long oGz;
  protected boolean ojM;
  public int roomId;
  public boolean wVN;
  public int width;
  public int xiF;
  
  static
  {
    AppMethodBeat.i(115291);
    v2protocal.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("voipMain");
    int i = m.aOK();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      UDm = false;
      UDn = false;
      UDo = false;
      UDp = false;
      UDq = 0;
      UEl = 0;
      Ljy = false;
      Ljx = 0;
      UEw = 0;
      UEx = 0;
      UFt = 10;
      UFS = null;
      UFU = null;
      wNj = null;
      UFV = null;
      AppMethodBeat.o(115291);
      return;
    }
  }
  
  public v2protocal(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(115273);
    this.oGz = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.UDr = 0;
    this.xiF = 0;
    this.mkQ = "";
    this.UDs = 0;
    this.UDt = 0;
    this.roomId = 0;
    this.UDu = 0L;
    this.JHb = 0;
    this.Hnt = 0L;
    this.JGW = 0;
    this.UDv = null;
    this.UDw = null;
    this.UDx = null;
    this.UDy = 0;
    this.UDz = null;
    this.channelStrategy = 0;
    this.UDA = 500;
    this.UDB = 30;
    this.UDC = 999;
    this.UDD = 0;
    this.UDE = null;
    this.UDF = null;
    this.UDG = new byte[10];
    this.UDH = 20;
    this.UDI = 0;
    this.LpO = 0;
    this.UDJ = 0;
    this.UDK = 0;
    this.UDL = 0;
    this.UDM = 65536;
    this.UDN = 0;
    this.UDO = 0;
    this.UDP = 0;
    this.UDQ = 7;
    this.UDR = 3;
    this.UDS = 3;
    this.UDT = 0;
    this.UDU = 0;
    this.UDV = -1;
    this.UDW = -1;
    this.UDX = -1;
    this.UDY = -1;
    this.UDZ = -1;
    this.UEa = -1;
    this.UEb = -1;
    this.UEc = -1;
    this.UEd = -1;
    this.UEe = -1;
    this.UEf = 0;
    this.UEg = 0;
    this.UEh = 0;
    this.UEi = 0;
    this.UEj = 0;
    this.UEk = 0;
    this.UEm = "";
    this.UEn = 0;
    this.UEo = 0;
    this.UEp = 0;
    this.UEq = 0;
    this.UEr = 0;
    this.UEs = 0;
    this.UEt = 0;
    this.UEu = 0;
    this.UEv = 0;
    this.UEy = 0;
    this.UEz = 0;
    this.UEA = 0;
    this.UEB = 0;
    this.UEC = 100;
    this.UED = 300;
    this.UEE = 1;
    this.UEF = 1;
    this.UEG = 0;
    this.UEH = 1;
    this.UEI = 0;
    this.UEJ = 0;
    this.UEK = 0;
    this.UEL = 0;
    this.UEM = 0;
    this.UEN = 0;
    this.UEO = 0;
    this.UEP = 0;
    this.UEQ = 0;
    this.UER = 0;
    this.UES = 0;
    this.UET = 0;
    this.UEU = 0;
    this.UEV = 0;
    this.UEW = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_mGetValidSample = 0;
    this.UEX = 0;
    this.UEY = 0;
    this.UEZ = 0;
    this.UFa = 0;
    this.UFb = null;
    this.UFc = 0;
    this.UFd = 0;
    this.UFe = 0;
    this.UFf = 0;
    this.UFg = new byte[1500];
    this.UFh = 0;
    this.UFi = null;
    this.UFj = null;
    this.UFk = 0;
    this.UFl = 0;
    this.UFm = 0;
    this.UFn = 0;
    this.UFo = 0;
    this.UFp = 0;
    this.UFq = null;
    this.UFr = null;
    this.UFs = null;
    this.UFu = new ArrayBlockingQueue(UFt);
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
    this.UFv = 0L;
    this.UFw = new byte[8];
    this.UFx = 0;
    this.UFy = 0;
    this.UFz = 0;
    this.UFA = 0;
    this.UFB = 0;
    this.UFC = new byte[4096];
    this.UFD = new byte[2048];
    this.UFE = new byte[2048];
    this.UFF = new byte[4096];
    this.UFG = new byte[4096];
    this.UFH = new byte[2048];
    this.UFI = new byte[4096];
    this.UFJ = new byte[2048];
    this.UFK = new byte[2048];
    this.UFL = new int[30];
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
    this.UFM = 0;
    this.UFN = new o();
    this.UFO = 0;
    this.UFP = 0;
    this.handler = null;
    this.ojM = false;
    this.UFQ = null;
    this.width = 640;
    this.height = 480;
    this.UFT = 8;
    this.bitrate = 300;
    this.wVN = true;
    this.handler = paramMMHandler;
    AppMethodBeat.o(115273);
  }
  
  private static boolean aNb(String paramString)
  {
    AppMethodBeat.i(115288);
    if (MultiProcessMMKV.getDefault().contains("SupportAvcCodec_".concat(String.valueOf(paramString))))
    {
      bool = MultiProcessMMKV.getDefault().decodeBool("SupportAvcCodec_".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.Voip", "SupportAvcCodec use MMKV cache res = %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115288);
      return bool;
    }
    boolean bool = bfK(paramString);
    MultiProcessMMKV.getDefault().encode("SupportAvcCodec_".concat(String.valueOf(paramString)), bool);
    Log.i("MicroMsg.Voip", "SupportAvcCodec result saving to MMKV, key = %s, val = %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(115288);
    return bool;
  }
  
  private static boolean bfK(String paramString)
  {
    AppMethodBeat.i(293323);
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
        g.Logi("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
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
        g.Logi("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
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
      AppMethodBeat.o(293323);
      return bool1;
      label268:
      bool1 = false;
    }
  }
  
  public static long cH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115262);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(115262);
    return l;
  }
  
  private native int forceredirect(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);
  
  private static String hYZ()
  {
    AppMethodBeat.i(115261);
    Object localObject2 = Build.MANUFACTURER;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains(",")) {
      localObject1 = ((String)localObject2).replace(',', ' ');
    }
    Object localObject3 = q.aPo();
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
  
  private String hZa()
  {
    AppMethodBeat.i(115263);
    int i;
    if ((this.LpO == 0) && (this.UDJ == 0))
    {
      this.UFN.UAy = 0;
      this.UFN.UAG = g.ibr();
      MMApplicationContext.getContext();
      i = g.ibs();
      this.UFN.UAF = this.field_videoDuration;
      this.UFN.UAE = this.field_audioDuration;
      this.UDN = com.tencent.mm.plugin.audio.c.a.cTZ();
      if ((this.UFN.UAT <= 0L) || (this.UFN.UAI <= this.UFN.UAT)) {
        break label1724;
      }
    }
    label1718:
    label1724:
    for (long l1 = this.UFN.UAI - this.UFN.UAT;; l1 = 0L)
    {
      g.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.UFw, this.UFw.length);
      long l3 = cH(this.UFw);
      Object localObject1 = this.UFN;
      if ((l3 > this.UFN.UAM) && (this.UFN.UAM > 0L))
      {
        l2 = l3 - this.UFN.UAM;
        label206:
        ((o)localObject1).UAU = l2;
        localObject1 = this.UFN;
        if ((l3 <= this.UFN.UAT) || (this.UFN.UAT <= 0L)) {
          break label1718;
        }
      }
      for (long l2 = l3 - this.UFN.UAT;; l2 = 0L)
      {
        ((o)localObject1).UAV = l2;
        g.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.UFN.UAU + " lCalledWaitTime:" + this.UFN.UAV);
        int j = cpuFlag0;
        boolean bool = SubCoreVoip.hVs();
        int k = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpT, 0);
        StringBuilder localStringBuilder = new StringBuilder().append(this.UDI).append(",").append(this.roomId).append(",").append(this.Hnt).append(",").append(this.JHb).append(",").append(this.UFN.UAh).append(",").append(this.UFN.UAt).append(",").append(this.UFN.UAu).append(",").append(this.UFN.UAv).append(",").append(this.UFN.UAw).append(",").append(this.UFN.UAx).append(",").append(this.UFN.UAy).append(",").append(this.UFN.UAr).append(",").append(this.UFN.UAz).append(",").append(this.UFN.UAA).append(",").append(this.UFN.UAB).append(",").append(this.UFN.UAC).append(",").append(this.UFN.UAD).append(",").append(this.UFN.UAE).append(",").append(this.UFN.UAF).append(",").append(this.UFN.UAG).append(hZf()).append(hZg()).append(hYZ()).append(",").append(this.UFN.UAH).append(",").append(this.UDM).append(",").append(this.UDN).append(",").append(l1).append(",").append(this.UFN.UAU).append(",").append(this.UFN.UAV).append(",").append(this.UDO).append(",").append(this.UDs).append(hZb()).append(",").append(j & 0xFF).append(",").append(this.UEd).append(",").append(this.UEe);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.UFN.UAJ + "," + this.UFN.UAL + "," + this.UFN.UAK + ",0," + this.UFN.UAX + "," + this.UFN.LiJ + "," + this.UFN.LiK + "," + this.UFN.UAY + ",0,0,0," + this.UEf + "," + this.UEg + "," + this.UDP + "," + this.UEh + "," + this.UEi + "," + this.UEj + "," + this.UFO + "," + this.UEm + "," + this.UEk + "," + UEl + "," + k + "," + bool + "," + i + "," + this.UEn + "," + this.UEo + "," + this.UEp + "," + this.UEq + "," + this.UEr + "," + this.UEs + "," + this.UEv + "," + this.UEu + "," + this.UFN.UAW[0] + "," + this.UFN.UAW[1] + "," + this.UFN.UAW[2] + "," + this.UFN.UAW[3] + "," + this.UFN.UAW[4] + "," + this.UFN.UAW[5] + "," + UEw + "," + UEx;
        g.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.UDs);
        g.Logi("MicroMsg.Voip", ":".concat(String.valueOf(localObject1)));
        g.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + hZb());
        g.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.UFN.LiJ + ",lInterruptEndTime:" + this.UFN.LiK + ",mIinterruptCnt:" + this.UFN.UAY + ",iPlayMinBufSize:" + this.UEf + ",iRecordMinBufSize:" + this.UEg);
        g.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.UFO);
        AppMethodBeat.o(115263);
        return localObject1;
        if ((this.UDJ != 0) && (this.LpO != 0))
        {
          this.UFN.UAy = 3;
          break;
        }
        if (this.UDJ != 0)
        {
          this.UFN.UAy = 1;
          break;
        }
        if (this.LpO == 0) {
          break;
        }
        this.UFN.UAy = 2;
        break;
        l2 = 0L;
        break label206;
      }
    }
  }
  
  private String hZb()
  {
    AppMethodBeat.i(115264);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(115264);
    return str;
  }
  
  private void hZe()
  {
    AppMethodBeat.i(184064);
    if ((this.UFx <= 0) || (this.field_videoDuration <= 0))
    {
      AppMethodBeat.o(184064);
      return;
    }
    this.UFP = (this.UFx / this.field_videoDuration);
    Log.i("MicroMsg.Voip", "calcCpatureFps:%s", new Object[] { Integer.valueOf(this.UFP) });
    AppMethodBeat.o(184064);
  }
  
  private String hZf()
  {
    AppMethodBeat.i(115266);
    g.Logd("MicroMsg.Voip", "usePreConnect:" + this.UEA);
    String str = "," + this.UEA;
    AppMethodBeat.o(115266);
    return str;
  }
  
  private String hZg()
  {
    AppMethodBeat.i(115267);
    g.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.UEB);
    String str = "," + this.UEB;
    AppMethodBeat.o(115267);
    return str;
  }
  
  private String hZh()
  {
    AppMethodBeat.i(115268);
    this.UDR = com.tencent.mm.plugin.audio.c.a.cTW().audioManager.getMode();
    this.UDS = com.tencent.mm.plugin.audio.c.a.cTW().audioManager.getMode();
    if (af.lXZ.lQS) {
      if (af.lXZ.aOv()) {
        if (af.lXZ.lQU >= 0)
        {
          this.UDR = af.lXZ.lQU;
          this.UDS = af.lXZ.lQU;
          if (Build.VERSION.SDK_INT >= 11) {
            break label407;
          }
          this.UDQ = 1;
          label92:
          if (af.lXZ.lQS) {
            this.UDQ = 1;
          }
          if (af.lXZ.lRv >= 0) {
            this.UDQ = af.lXZ.lRv;
          }
          if (af.lXZ.lQT <= 0) {
            break label416;
          }
          this.UDT = 3;
          this.UDU = 0;
        }
      }
    }
    for (;;)
    {
      if (af.lXZ.lRz >= 0) {
        this.UDT = af.lXZ.lRz;
      }
      if (af.lXZ.lRA >= 0) {
        this.UDU = af.lXZ.lRA;
      }
      String str = "," + this.UDR + "," + this.UDS + "," + this.UDQ + "," + this.UDT + "," + this.UDU;
      AppMethodBeat.o(115268);
      return str;
      if (af.lXZ.lQV < 0) {
        break;
      }
      this.UDR = 0;
      this.UDS = 2;
      break;
      if (!af.lXZ.aOw()) {
        break;
      }
      if (af.lXZ.aOy() >= 0) {
        this.UDR = af.lXZ.aOy();
      }
      if (af.lXZ.aOA() < 0) {
        break;
      }
      this.UDS = af.lXZ.aOA();
      break;
      this.UDR = 3;
      this.UDS = 3;
      if (af.lXZ.lRw >= 0) {
        this.UDR = af.lXZ.lRw;
      }
      if ((l.isSamsung()) && (2 == af.lYj.lUf)) {
        this.UDS = 2;
      }
      if (af.lXZ.lRx < 0) {
        break;
      }
      this.UDS = af.lXZ.lRx;
      break;
      label407:
      this.UDQ = 7;
      break label92;
      label416:
      if (af.lXZ.lRy >= 0)
      {
        this.UDT = af.lXZ.lRy;
        this.UDU = af.lXZ.lRy;
      }
    }
  }
  
  private String hZj()
  {
    AppMethodBeat.i(115270);
    getNewEngineInfo(this.UFG, this.UFG.length);
    getNewEngineExtInfo(this.UFH, this.UFH.length);
    g.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.JHb + "," + this.Hnt + this.UFN.hXh() + "," + this.LpO + "," + this.UDJ + hZc() + new String(this.UFG, 0, this.field_newEngineStatLength) + "," + this.UDK + "," + this.UDL + hZh() + new String(this.UFH, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.UFG, this.UFG.length);
    String str = this.JHb + "," + this.Hnt + this.UFN.hXh() + "," + this.LpO + "," + this.UDJ + hZc() + new String(this.UFG, 0, this.field_newEngineReportLength);
    g.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115270);
    return str;
  }
  
  public static String hZn()
  {
    AppMethodBeat.i(293317);
    if (Build.VERSION.SDK_INT < 23)
    {
      localObject1 = Formatter.formatIpAddress(((WifiManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
      g.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(293317);
      return localObject1;
    }
    Object localObject1 = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    localObject1 = ((ConnectivityManager)localObject1).getLinkProperties(((ConnectivityManager)localObject1).getActiveNetwork());
    if (localObject1 == null)
    {
      Log.i("MicroMsg.Voip", "linkProperties null");
      AppMethodBeat.o(293317);
      return "";
    }
    g.Logd("MicroMsg.Voip", "Interface name:" + ((LinkProperties)localObject1).getInterfaceName());
    Object localObject2 = ((LinkProperties)localObject1).getRoutes().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RouteInfo localRouteInfo = (RouteInfo)((Iterator)localObject2).next();
      if ((localRouteInfo.isDefaultRoute()) && (localRouteInfo.hasGateway()))
      {
        localObject2 = localRouteInfo.getGateway();
        g.Logd("MicroMsg.Voip", "get wifi route ip:" + ((InetAddress)localObject2).getHostAddress());
        if ((localObject2 instanceof Inet6Address)) {
          try
          {
            i = NetworkInterface.getByName(((LinkProperties)localObject1).getInterfaceName()).getIndex();
            localObject1 = ((InetAddress)localObject2).getHostAddress() + "%" + i;
            AppMethodBeat.o(293317);
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
          AppMethodBeat.o(293317);
          return "";
        }
        AppMethodBeat.o(293317);
        return str;
      }
    }
    AppMethodBeat.o(293317);
    return "";
  }
  
  public static boolean hZp()
  {
    AppMethodBeat.i(293320);
    int i = m.aOK();
    boolean bool1;
    int j;
    int k;
    int m;
    int n;
    long l;
    boolean bool2;
    label85:
    boolean bool3;
    label111:
    boolean bool4;
    label137:
    boolean bool5;
    if ((i & 0x400) != 0)
    {
      bool1 = true;
      j = i >> 12 & 0xF;
      k = i & 0xFF;
      m = Build.VERSION.SDK_INT;
      n = com.tencent.mm.media.util.d.bqn();
      l = com.tencent.matrix.e.a.aG(MMApplicationContext.getContext()) / 1024L / 1024L;
      if (j < ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySQ, 4)) {
        break label350;
      }
      bool2 = true;
      if (k < ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySR, 71)) {
        break label356;
      }
      bool3 = true;
      if (m < ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySS, 23)) {
        break label362;
      }
      bool4 = true;
      if (l < ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yST, 4096)) {
        break label368;
      }
      bool5 = true;
      label167:
      if (n < ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySU, 50)) {
        break label374;
      }
    }
    label350:
    label356:
    label362:
    label368:
    label374:
    for (boolean bool6 = true;; bool6 = false)
    {
      Log.i("MicroMsg.Voip", "check720EncodeLocalConfig, cpuFlags:%s, isNeon:%s, nCores:%s,gpuScore %s nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s gpuCheck:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5) || (!bool6)) {
        break label380;
      }
      AppMethodBeat.o(293320);
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label85;
      bool3 = false;
      break label111;
      bool4 = false;
      break label137;
      bool5 = false;
      break label167;
    }
    label380:
    AppMethodBeat.o(293320);
    return false;
  }
  
  public static String hZq()
  {
    return "";
  }
  
  private native int setsvraddr(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, byte[] paramArrayOfByte, int paramInt5);
  
  private native int uninit(int paramInt1, long paramLong, int paramInt2);
  
  public native int ActivateConn(int paramInt);
  
  public native int AddNewDirectConns(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int AddNewRelayConns(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int GetAudioFormat(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3);
  
  public native int GetNetBottleneckSide();
  
  public native int GetNicInfo(int paramInt, byte[] paramArrayOfByte1, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, byte[] paramArrayOfByte2, AtomicInteger paramAtomicInteger4, AtomicInteger paramAtomicInteger5, AtomicInteger paramAtomicInteger6);
  
  public final String Gw(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(115280);
    if (this.ojM)
    {
      g.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.UFN.UAr;
      this.field_ChannelReportDial[1] = this.UFN.UAx;
      this.field_ChannelReportDial[2] = this.UEX;
      this.field_ChannelReportDial[3] = this.UEY;
      this.field_ChannelReportDial[4] = this.UEZ;
      this.field_ChannelReportDial[5] = this.UFa;
      this.field_EngineReportStatFromApp = new int[27];
      hZh();
      this.field_EngineReportStatFromApp[0] = this.UDK;
      this.field_EngineReportStatFromApp[1] = this.UDL;
      this.field_EngineReportStatFromApp[2] = this.UDR;
      this.field_EngineReportStatFromApp[3] = this.UDS;
      this.field_EngineReportStatFromApp[4] = this.UDQ;
      this.field_EngineReportStatFromApp[5] = this.UDT;
      this.field_EngineReportStatFromApp[6] = this.UDU;
      this.field_EngineReportStatFromApp[7] = -1;
      label265:
      label324:
      Object localObject1;
      if (this.UFQ != null)
      {
        this.field_EngineReportStatFromApp[8] = this.UFQ.wUi;
        this.field_EngineReportStatFromApp[9] = this.UFQ.wUk;
        this.field_EngineReportStatFromApp[10] = this.UFQ.wUa;
        if (UFS == null) {
          break label1373;
        }
        this.field_EngineReportStatFromApp[11] = UFS.Lnd;
        this.field_EngineReportStatFromApp[12] = this.UFn;
        this.field_EngineReportStatFromApp[13] = this.UFo;
        this.field_EngineReportStatFromApp[14] = this.UFp;
        if (!UDp) {
          break label1384;
        }
        this.field_EngineReportStatFromApp[15] = 1280;
        this.field_EngineReportStatFromApp[16] = 720;
        localObject1 = this.field_EngineReportStatFromApp;
        if (!UDo) {
          break label1407;
        }
        i = 1;
        label338:
        localObject1[17] = i;
        localObject1 = this.field_EngineReportStatFromApp;
        if (!UDn) {
          break label1412;
        }
      }
      label1412:
      for (int i = j;; i = 0)
      {
        localObject1[18] = i;
        this.field_EngineReportStatFromApp[19] = this.UDV;
        this.field_EngineReportStatFromApp[20] = this.UDW;
        this.field_EngineReportStatFromApp[21] = this.UDX;
        this.field_EngineReportStatFromApp[22] = this.UDY;
        this.field_EngineReportStatFromApp[23] = this.UDZ;
        this.field_EngineReportStatFromApp[24] = this.UEa;
        this.field_EngineReportStatFromApp[25] = this.UEb;
        this.field_EngineReportStatFromApp[26] = this.UEc;
        this.ojM = false;
        uninit(this.roomId, this.Hnt, this.JHb);
        UDm = false;
        UDq = 0;
        if (this.UFQ != null)
        {
          this.UFQ.gfg();
          this.UFQ = null;
          localObject1 = com.tencent.mm.plugin.voip.f.e.ULA;
          com.tencent.mm.plugin.voip.f.e.GM(false);
        }
        if (UFS != null)
        {
          UFS.interrupt();
          localObject1 = UFS;
          ((d)localObject1).LmW = false;
          ((d)localObject1).LmX = false;
          ((d)localObject1).LmZ = 0;
          Log.d("MicroMsg.AvcDecoder", "steve: Stop Decode Thread!");
        }
        try
        {
          if (((d)localObject1).outputStream != null)
          {
            ((d)localObject1).outputStream.flush();
            ((d)localObject1).outputStream.close();
          }
          if (((d)localObject1).LmN != null)
          {
            ((d)localObject1).LmN.flush();
            ((d)localObject1).LmN.close();
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
        UFS = null;
        if (UFU != null) {
          UFU.release();
        }
        UFU = null;
        UFR = null;
        g.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1449;
        }
        getStatInfo(this.UFC, this.UFC.length, this.UFL, 30);
        getEngineVersionInfo(this.UFD, this.UFD.length);
        getEngineQosInfo(this.UFE, this.UFE.length);
        localObject1 = new StringBuilder();
        l = this.xiF;
        if (this.xiF < 0) {
          l = this.xiF + 4294967296L;
        }
        localObject2 = new StringBuilder().append(l).append(",").append(this.Hnt).append(",").append(this.roomId).append(",").append(this.JHb).append(",");
        localo = this.UFN;
        localObject2 = new StringBuilder().append(localo.UAh).append(",").append(localo.UAi).append(",").append(localo.UAj).append(",").append(localo.UAk).append(",").append(localo.UAl).append(",").append(localo.UAm).append(",").append(localo.UAn).append(",").append(localo.UAo).append(",").append(localo.UAp).append(",").append(localo.UAq).append(",").append(localo.UAr).toString();
        g.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.UFC, 0, this.field_statInfoLength)).append(hYZ()).append(hZb());
        localObject2 = this.UFN;
        localObject1 = ((StringBuilder)localObject1).append("," + ((o)localObject2).UAs).append(new String(this.UFD, 0, this.field_engineVersionStatLength)).append(hZc());
        g.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + hZf() + hZg() + new String(this.UFE, 0, this.field_engineQosStatLength);
        g.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.UFC, 0, this.field_statInfoLength));
        g.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.UFD, 0, this.field_engineVersionStatLength));
        g.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.UFE, 0, this.field_engineQosStatLength));
        g.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        az.a.okQ.eB(this.field_netFlowRecv, this.field_netFlowSent);
        g.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
        AppMethodBeat.o(115280);
        return localObject1;
        this.field_EngineReportStatFromApp[8] = 0;
        this.field_EngineReportStatFromApp[9] = 0;
        this.field_EngineReportStatFromApp[10] = 0;
        break;
        label1373:
        this.field_EngineReportStatFromApp[11] = 0;
        break label265;
        label1384:
        this.field_EngineReportStatFromApp[15] = 640;
        this.field_EngineReportStatFromApp[16] = 480;
        break label324;
        label1407:
        i = 0;
        break label338;
      }
    }
    label1449:
    AppMethodBeat.o(115280);
    return "";
  }
  
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
      parama.UvK = localAtomicInteger2.get();
      parama.NjF = localAtomicInteger1.get();
      parama.UvJ = 0;
      g.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.NjF + ", framelenms =" + parama.UvK + ", channels =" + parama.channels);
      AppMethodBeat.o(115289);
      return j;
    }
    if ((m.aOK() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.NjF = i;
      parama.channels = 1;
      parama.UvK = 20;
      parama.UvJ = 0;
      break;
    }
  }
  
  public final int a(gbo paramgbo)
  {
    AppMethodBeat.i(115260);
    if (this.UFv != 0L)
    {
      g.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      AppMethodBeat.o(115260);
      return -1;
    }
    this.UFv = paramgbo.abZN;
    gav localgav = new gav();
    localgav.abYi = paramgbo.abZN;
    int i = 0;
    while (i < paramgbo.abZS)
    {
      gay localgay = new gay();
      localgay.abMk = ((fgy)paramgbo.abZT.get(i)).abGE.abMn;
      localgay.port = ((fgy)paramgbo.abZT.get(i)).abGE.abmN;
      localgay.UNy = ((fgy)paramgbo.abZT.get(i)).abGD;
      localgay.abYC = ((fgy)paramgbo.abZT.get(i)).abHl;
      localgay.timeout = ((fgy)paramgbo.abZT.get(i)).abHm;
      localgay.abYD = ((fgy)paramgbo.abZT.get(i)).abHn;
      localgav.abYj.add(localgay);
      i += 1;
    }
    try
    {
      g.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(localgav.toByteArray(), localgav.toByteArray().length))));
      AppMethodBeat.o(115260);
      return 0;
    }
    catch (IOException paramgbo)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Voip", paramgbo, "StartVoipSpeedTest exception", new Object[0]);
      }
    }
  }
  
  public native int app2EngineDataEx(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4);
  
  public native int app2EngineLinkQualityEx(int paramInt, byte[] paramArrayOfByte);
  
  public final int cc(LinkedList<dtl> paramLinkedList)
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
        dtl localdtl = new dtl();
        localdtl.aavb = new String(arrayOfByte2, 0, ((AtomicInteger)localObject).get());
        localdtl.aaZf = localAtomicInteger5.get();
        localdtl.Zoz = localAtomicInteger4.get();
        paramLinkedList.add(localdtl);
      }
      if (localAtomicInteger1.get() > 0)
      {
        localObject = new dtl();
        ((dtl)localObject).aavb = new String(arrayOfByte1, 0, localAtomicInteger1.get());
        ((dtl)localObject).aaZf = localAtomicInteger3.get();
        ((dtl)localObject).Zoz = localAtomicInteger2.get();
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
  
  public native int getAVDuration(byte[] paramArrayOfByte, int paramInt);
  
  public native int getChannelInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int getChannelReport(byte[] paramArrayOfByte, int paramInt);
  
  public native int getCurrentConnType();
  
  public native int getEngine2ndInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getEngine2ndInfoReport(byte[] paramArrayOfByte, int paramInt);
  
  public native int getEngineQosInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getEngineVersionInfo(byte[] paramArrayOfByte, int paramInt);
  
  public native int getIpStack();
  
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
  
  public final int hCe()
  {
    AppMethodBeat.i(115279);
    MMApplicationContext.getContext();
    this.netType = g.ibq();
    this.UDs = this.netType;
    boolean bool4;
    boolean bool5;
    label78:
    boolean bool6;
    label98:
    boolean bool1;
    label112:
    boolean bool7;
    label189:
    boolean bool8;
    label262:
    int k;
    label274:
    boolean bool9;
    label287:
    boolean bool10;
    label299:
    int i;
    label310:
    int j;
    label321:
    int i1;
    int m;
    label353:
    int n;
    label377:
    int i2;
    boolean bool2;
    label410:
    label474:
    label484:
    Object localObject;
    label653:
    boolean bool12;
    label670:
    boolean bool11;
    label683:
    label752:
    boolean bool3;
    label772:
    boolean bool13;
    if ((this.UDs >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool4 = true;
      if ((!bool4) || ((cpuFlag0 & 0xFF) < 30)) {
        break label2481;
      }
      bool5 = true;
      if ((!bool5) || ((cpuFlag0 & 0xFF) < 60)) {
        break label2487;
      }
      bool6 = true;
      if ((!bool6) || (!hZp())) {
        break label2493;
      }
      bool1 = true;
      UDo = bool1;
      if ((af.lXY.lTt <= 0) || (af.lXY.lSV.width < 480) || (af.lXY.lSV.height < 360) || (af.lXY.lSX.width < 480) || (af.lXY.lSX.height < 360)) {
        break label2499;
      }
      bool7 = true;
      if ((af.lXY.lTt < 2) || (af.lXY.lSV.width < 640) || (af.lXY.lSV.height < 480) || (af.lXY.lSX.width < 640) || (af.lXY.lSX.height < 480)) {
        break label2505;
      }
      bool8 = true;
      if (af.lXY.lTt != 2) {
        break label2511;
      }
      k = 1;
      if (af.lXY.lTt < 4) {
        break label2516;
      }
      bool9 = true;
      if (af.lXY.lTt != 0) {
        break label2522;
      }
      bool10 = true;
      if (af.lXY.lTu != 0) {
        break label2528;
      }
      i = 1;
      if (af.lXY.lTu <= 0) {
        break label2533;
      }
      j = 1;
      i1 = af.lXY.lTv;
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySE, 1) == 0) {
        break label2538;
      }
      m = 1;
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySD, 1) == 0) {
        break label2544;
      }
      n = 1;
      i2 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySF, 0);
      if ((i2 & 0xF) >> 2 <= 0) {
        break label2550;
      }
      bool2 = true;
      g.Logi("MicroMsg.Voip", "iHWParam: " + i2 + "bEnableHWhevcFromSvr: " + bool2 + ", SrvDeviceInfo.mCameraInfo.mSupport480P: " + af.lXY.lTt);
      if (af.lXY.lTw != 2) {
        break label2556;
      }
      UDn = false;
      if (i1 != 2) {
        break label2591;
      }
      UDp = false;
      if ((af.lXY.lSV.width >= 480) || (af.lXY.lSX.width >= 480))
      {
        g.Logi("MicroMsg.Voip", "hseasun:Close the 720p force due to configuration from svr");
        UDn = false;
        UDp = false;
      }
      localObject = i.agtt;
      m = i.a(b.a.agsJ, 0);
      Log.i("MicroMsg.Voip", "hwEncodeRepairerConfig:%s", new Object[] { Integer.valueOf(m) });
      if (m == 3) {
        UDn = true;
      }
      if (UDn) {
        UDp = true;
      }
      g.Logi("MicroMsg.Voip", "hseasun: enable720Cap: " + UDp + " enable1280HWEnc: " + UDn);
      UDq = 0;
      this.wVN = false;
      if (i != 0) {
        break label2747;
      }
      if ((!bool5) || (!aNb("video/avc"))) {
        break label2622;
      }
      bool1 = true;
      if ((!bool6) || (!aNb("video/hevc"))) {
        break label2628;
      }
      bool12 = true;
      if ((!bool12) || (!bool2)) {
        break label2634;
      }
      bool11 = true;
      g.Logi("MicroMsg.Voip", "bSupportHEVCHW: " + bool11 + ", bEnableHWhevcFromSvr: " + bool2 + ", SrvDeviceInfo.mCameraInfo.mSupportHW: " + af.lXY.lTu);
      if (j == 0) {
        break label2737;
      }
      if ((af.lXY.lTu & 0x10) == 0) {
        break label2640;
      }
      bool2 = true;
      if ((!bool1) || ((af.lXY.lTu & 0xF) == 0)) {
        break label2646;
      }
      bool3 = true;
      if ((!bool11) && (!bool3)) {
        break label2652;
      }
      bool13 = true;
      label785:
      this.wVN = bool13;
      if (m != 0) {
        this.wVN = true;
      }
      localObject = new StringBuilder("hwH264Local:").append(bool1).append(",hwHEVCLocal:").append(bool12).append(", bSupportH264HW:").append(bool3).append(", bSupportHEVCSW:").append(bool2).append(", bSupportHEVCHW:").append(bool11).append(", svrHWCfg:").append(af.lXY.lTu).append(", 720p jcchen ").append(bool6).append("-");
      if (k != 0) {
        break label2658;
      }
      bool1 = true;
      label901:
      g.Logi("MicroMsg.Voip", bool1 + "-" + bool9 + "-" + UDn + " svr 480p:" + af.lXY.lTt);
      if (!bool3) {
        break label2732;
      }
      i = 1;
      label962:
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      if (!bool11) {
        break label2727;
      }
      i = j | 0x4;
    }
    for (;;)
    {
      if (((bool4) || (bool7)) && (!bool10))
      {
        if ((!this.wVN) && (!bool8)) {
          break label2664;
        }
        this.defaultWidth = 640;
        this.defaultHeight = 480;
        if ((bool6) && (k == 0))
        {
          this.defaultWidth = 1280;
          this.defaultHeight = 720;
        }
        label1046:
        UDm = true;
        if (m != 0)
        {
          if (m != 1) {
            break label2681;
          }
          this.defaultWidth = 480;
          this.defaultHeight = 360;
        }
      }
      for (;;)
      {
        g.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        g.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool4 + ", bEnable480FromSvr:" + bool7 + ", bDisable480FromSvr:" + bool10 + ", bEnable640FromLocal:" + bool5 + ", bEnable640FromSvr:" + bool8);
        this.UEW = new int[this.defaultWidth * this.defaultHeight];
        h.baC();
        this.xiF = com.tencent.mm.kernel.b.getUin();
        n = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        localObject = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        i1 = ((Display)localObject).getWidth();
        i2 = ((Display)localObject).getHeight();
        k = af.lYj.lUF;
        m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zji, -1);
        long l2 = 0L;
        int i3 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjh, -1);
        Log.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i3) });
        int i4 = af.lXZ.lRJ;
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
        i3 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjJ, 0);
        Log.i("MicroMsg.Voip", "winterwang get server opuswbswitch %d", new Object[] { Integer.valueOf(i3) });
        localObject = new byte[4];
        localObject[0] = ((byte)i3);
        Log.i("MicroMsg.Voip", "winterwang setJNIAppCmd  EMethod_AudioOptionSwitch ,ret: %d", new Object[] { Integer.valueOf(setJNIAppCmd(5, (byte[])localObject, 4)) });
        i3 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjt, -1);
        i4 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zju, -1);
        int i5 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjv, -1);
        int i6 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjw, -1);
        int i7 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjx, -1);
        int i8 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjy, -1);
        int i9 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjz, -1);
        int i10 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjA, -1);
        Log.i("MicroMsg.Voip", "qipengfeng, neteq-x-expt: %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10) });
        if ((i3 > 0) && (i4 > 0) && (i5 > 0) && (i6 > 0) && (i7 >= 0) && (i8 > 0) && (i9 > 0) && (i10 >= 0)) {
          setJNIAppCmd(6, new byte[] { (byte)(i3 & 0xFF), (byte)(i3 >> 8 & 0xFF), (byte)(i3 >> 16 & 0xFF), (byte)(i3 >> 24 & 0xFF), (byte)(i4 & 0xFF), (byte)(i4 >> 8 & 0xFF), (byte)(i4 >> 16 & 0xFF), (byte)(i4 >> 24 & 0xFF), (byte)(i5 & 0xFF), (byte)(i5 >> 8 & 0xFF), (byte)(i5 >> 16 & 0xFF), (byte)(i5 >> 24 & 0xFF), (byte)(i6 & 0xFF), (byte)(i6 >> 8 & 0xFF), (byte)(i6 >> 16 & 0xFF), (byte)(i6 >> 24 & 0xFF), (byte)(i7 & 0xFF), (byte)(i7 >> 8 & 0xFF), (byte)(i7 >> 16 & 0xFF), (byte)(i7 >> 24 & 0xFF), (byte)(i8 & 0xFF), (byte)(i8 >> 8 & 0xFF), (byte)(i8 >> 16 & 0xFF), (byte)(i8 >> 24 & 0xFF), (byte)(i9 & 0xFF), (byte)(i9 >> 8 & 0xFF), (byte)(i9 >> 16 & 0xFF), (byte)(i9 >> 24 & 0xFF), (byte)(i10 & 0xFF), (byte)(i10 >> 8 & 0xFF), (byte)(i10 >> 16 & 0xFF), (byte)(i10 >> 24 & 0xFF) }, 8);
        }
        i3 = g.bfN("hwenc") & 0xF | (g.bfN("hwdec") & 0xF) << 4 | (g.bfN("swenc") & 0xF) << 8 | (g.bfN("swdec") & 0xF) << 12;
        i4 = this.netType;
        i5 = this.defaultWidth;
        n = init(i << 8 | i4, 2, this.defaultHeight | i5 << 16, i1 << 16 | i2, this.xiF, j << 24 | n << 16 | cpuFlag0, com.tencent.mm.loader.i.b.bmq() + "lib/", 0, l1, k, m, i3);
        g.Logi("MicroMsg.Voip", "protocalInit protocal init ret :" + n + ",uin= " + this.xiF + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i + ", groupRsCap = " + k + ", x_vcodec2_paras = " + m + ", static_cab = " + i3);
        this.ojM = true;
        if (n < 0) {
          reset();
        }
        AppMethodBeat.o(115279);
        return n;
        bool4 = false;
        break;
        label2481:
        bool5 = false;
        break label78;
        label2487:
        bool6 = false;
        break label98;
        label2493:
        bool1 = false;
        break label112;
        label2499:
        bool7 = false;
        break label189;
        label2505:
        bool8 = false;
        break label262;
        label2511:
        k = 0;
        break label274;
        label2516:
        bool9 = false;
        break label287;
        label2522:
        bool10 = false;
        break label299;
        label2528:
        i = 0;
        break label310;
        label2533:
        j = 0;
        break label321;
        label2538:
        m = 0;
        break label353;
        label2544:
        n = 0;
        break label377;
        label2550:
        bool2 = false;
        break label410;
        label2556:
        if (af.lXY.lTw == 1)
        {
          UDn = true;
          break label474;
        }
        if ((!UDo) || (m == 0)) {
          break label474;
        }
        UDn = true;
        break label474;
        label2591:
        if (i1 == 1)
        {
          UDp = true;
          break label484;
        }
        if ((!UDo) || (n == 0)) {
          break label484;
        }
        UDp = true;
        break label484;
        label2622:
        bool1 = false;
        break label653;
        label2628:
        bool12 = false;
        break label670;
        label2634:
        bool11 = false;
        break label683;
        label2640:
        bool2 = false;
        break label752;
        label2646:
        bool3 = false;
        break label772;
        label2652:
        bool13 = false;
        break label785;
        label2658:
        bool1 = false;
        break label901;
        label2664:
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        break label1046;
        label2681:
        if (m == 2)
        {
          this.defaultWidth = 640;
          this.defaultHeight = 480;
        }
        else if (m == 3)
        {
          this.defaultWidth = 1280;
          this.defaultHeight = 720;
        }
      }
      label2727:
      i = j;
      continue;
      label2732:
      i = 0;
      break label962;
      label2737:
      bool2 = false;
      bool3 = bool1;
      break label772;
      label2747:
      i = 0;
    }
  }
  
  protected final String hZc()
  {
    AppMethodBeat.i(115265);
    if (this.field_videoDuration == 0)
    {
      g.Logd("MicroMsg.Voip", "captureFrames:" + this.UFx + ", videoduration: 0");
      AppMethodBeat.o(115265);
      return ",0";
    }
    g.Logd("MicroMsg.Voip", "capturefps:" + this.UFx / this.field_videoDuration + " framecount:" + this.UFx + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.UFx / this.field_videoDuration;
    AppMethodBeat.o(115265);
    return str;
  }
  
  public final void hZd()
  {
    AppMethodBeat.i(293448);
    this.UFP = 0;
    Log.i("MicroMsg.Voip", "resetCaptureFps");
    AppMethodBeat.o(293448);
  }
  
  final String hZi()
  {
    AppMethodBeat.i(115269);
    getChannelInfo(this.UFF, this.UFF.length, this.UEX, this.UEY, this.UEZ, this.UFa);
    Object localObject = new StringBuilder().append(this.Hnt).append(",").append(this.roomId).append(",").append(this.JHb).append(this.UFN.hXh());
    o localo = this.UFN;
    g.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localo.UAx).toString() + new String(this.UFF, 0, this.field_channelStatLength))));
    getChannelReport(this.UFF, this.UFF.length);
    localObject = new String(this.UFF, 0, this.field_channelReportLength);
    g.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(115269);
    return localObject;
  }
  
  final String hZk()
  {
    AppMethodBeat.i(115271);
    getEngine2ndInfo(this.UFI, this.UFI.length);
    g.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.Hnt + "," + this.roomId + "," + this.JHb + new String(this.UFI, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.UFI, this.UFI.length);
    String str = this.Hnt + "," + this.roomId + "," + this.JHb + new String(this.UFI, 0, this.field_engine2ndReportLength);
    g.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115271);
    return str;
  }
  
  public final String hZl()
  {
    AppMethodBeat.i(115272);
    int i = cpuFlag0;
    String str = hYZ() + "," + this.UEy + "," + (i & 0xFF) + hZh() + "," + this.UEe;
    AppMethodBeat.o(115272);
    return str;
  }
  
  public final boolean hZm()
  {
    return this.ojM;
  }
  
  public final int hZo()
  {
    AppMethodBeat.i(115278);
    MMApplicationContext.getContext();
    this.netType = g.ibq();
    if ((this.netType == 5) || (this.netType == 6) || (this.netType == 7)) {
      this.netType = 4;
    }
    this.UEW = new int[this.defaultWidth * this.defaultHeight];
    h.baC();
    this.xiF = com.tencent.mm.kernel.b.getUin();
    int i = m.aOK();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.xiF, k << 24 | j << 16 | i, com.tencent.mm.loader.i.b.bmq() + "lib/", 4, 0L, 0, 0, 0);
    g.Logd("MicroMsg.Voip", "protocalInitForPstn protocal init ret :" + i + ",uin= " + this.xiF + ", groupRsCap = 0, x_vcodec2_paras = 0, static_cab = 0");
    this.ojM = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(115278);
    return i;
  }
  
  public final String hZr()
  {
    AppMethodBeat.i(115281);
    String str = hZa();
    AppMethodBeat.o(115281);
    return str;
  }
  
  public final String[] hZs()
  {
    AppMethodBeat.i(115282);
    String[] arrayOfString = getNatReport();
    g.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      g.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115282);
    return arrayOfString;
  }
  
  public final String[] hZt()
  {
    AppMethodBeat.i(115283);
    String[] arrayOfString = getMPDirectReport();
    g.Loge("MicroMsg.Voip", "direct_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      g.Loge("MicroMsg.Voip", "direct_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115283);
    return arrayOfString;
  }
  
  public final String[] hZu()
  {
    AppMethodBeat.i(115284);
    String[] arrayOfString = getMPRelayReport();
    g.Loge("MicroMsg.Voip", "relay_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      g.Loge("MicroMsg.Voip", "relay_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115284);
    return arrayOfString;
  }
  
  public final String[] hZv()
  {
    AppMethodBeat.i(115285);
    String[] arrayOfString = getMPEngineReport();
    g.Loge("MicroMsg.Voip", "engine_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = (this.Hnt + "," + this.JHb + arrayOfString[i]);
      g.Loge("MicroMsg.Voip", "engine_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115285);
    return arrayOfString;
  }
  
  public final String hZw()
  {
    AppMethodBeat.i(115286);
    String str = hZj();
    AppMethodBeat.o(115286);
    return str;
  }
  
  public native int handleCommand(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  protected native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, long paramLong, int paramInt8, int paramInt9, int paramInt10);
  
  public native int isDCReady();
  
  public native int isDCSameLan();
  
  public native int isRelayConnReady();
  
  public int keep_onNotifyFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115274);
    g.Logd("MicroMsg.VoipService", "callByJni : arg1:" + paramInt1 + " arg2:" + paramInt2);
    if (paramInt1 == 100)
    {
      g.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      AppMethodBeat.o(115274);
      return 0;
    }
    if (paramInt1 == 101)
    {
      g.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
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
      g.Logd("MicroMsg.VoipService", "callByJniInt : arg1:" + paramInt1 + " arg2:" + paramInt2);
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
    hZe();
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.roomId = 0;
    this.UDu = 0L;
    this.UDt = 0;
    this.JHb = 0;
    this.Hnt = 0L;
    this.channelStrategy = 0;
    this.JGW = 0;
    this.oGz = 0L;
    this.UDv = null;
    this.UDw = null;
    this.UDx = null;
    this.UDy = 0;
    this.UDz = null;
    this.UFa = 0;
    this.UFb = null;
    this.UFc = 0;
    this.UFd = 0;
    this.UDE = null;
    this.UDF = null;
    this.UFi = null;
    this.UFj = null;
    this.UFq = null;
    this.UFr = null;
    this.UFs = null;
    this.UFx = 0;
    this.UFy = 0;
    this.UFz = 0;
    this.UFA = 0;
    this.UFB = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.UFM = 0;
    this.UEB = 0;
    this.UEA = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.UDK = 0;
    this.UDL = 0;
    this.UDM = 65536;
    this.UDN = 0;
    this.UDO = 0;
    this.UDP = 0;
    this.UEe = -1;
    this.UEy = 0;
    this.UFm = 0;
    this.UDr = 0;
    this.mkQ = "";
    this.UFk = 0;
    this.UFl = 0;
    this.UFN.reset();
    this.UFN.hXg();
    UDm = false;
    UDq = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.UEh = 0;
    this.UEi = 0;
    this.UEj = 0;
    this.UEk = 0;
    UEl = 0;
    this.UEn = 0;
    this.UEo = 0;
    this.UEp = 0;
    this.UEq = 0;
    this.UEr = 0;
    this.UEs = 0;
    this.UEv = 0;
    this.UEu = 0;
    this.UEt = 0;
    Ljy = false;
    Ljx = 0;
    this.UEm = "";
    UEw = 0;
    UEx = 0;
    this.UFO = 0;
    SubCoreVoip.hVr();
    int i = freeJNIReport();
    g.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
    AppMethodBeat.o(115287);
  }
  
  public native int setActive();
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(115259);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      g.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
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
  
  public native int videoGetEncWH(int paramInt1, int paramInt2);
  
  public native int videoHWDecode(byte[] paramArrayOfByte);
  
  public native int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2);
  
  public native int videoHWProcess2(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer2);
  
  public native int videoHWProcess3(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer2, int paramInt5);
  
  public native int videoRorate90D(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */