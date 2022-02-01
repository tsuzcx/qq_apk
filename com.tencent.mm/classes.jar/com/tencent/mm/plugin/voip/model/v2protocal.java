package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
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
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.ety;
import com.tencent.mm.protocal.protobuf.eub;
import com.tencent.mm.protocal.protobuf.eur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class v2protocal
{
  public static boolean Hap;
  public static boolean Haq;
  public static boolean Har;
  public static int Has;
  public static int Hbf;
  public static d HcA;
  public static Surface HcC;
  public static com.tencent.mm.media.g.d HcD;
  private static int Hcc;
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  protected static int cpuFlag0;
  public static SurfaceTexture mSurfaceTexture;
  public int HaA;
  public byte[] HaB;
  public int HaC;
  public int HaD;
  public int HaE;
  public int HaF;
  public byte[] HaG;
  public byte[] HaH;
  public byte[] HaI;
  public int HaJ;
  public int HaK;
  public int HaL;
  public int HaM;
  public int HaN;
  public int HaO;
  public int HaP;
  public int HaQ;
  public int HaR;
  public int HaS;
  public int HaT;
  public int HaU;
  public int HaV;
  public int HaW;
  public int HaX;
  public int HaY;
  public int HaZ;
  public int Hat;
  public int Hau;
  public int Hav;
  public long Haw;
  public byte[] Hax;
  public volatile byte[] Hay;
  public byte[] Haz;
  public int HbA;
  public int HbB;
  public int HbC;
  public int HbD;
  public int HbE;
  public int[] HbF;
  public int HbG;
  public int HbH;
  public int HbI;
  public int HbJ;
  public byte[] HbK;
  public int HbL;
  public int HbM;
  public int HbN;
  public int HbO;
  public byte[] HbP;
  public int HbQ;
  public byte[] HbR;
  public byte[] HbS;
  public int HbT;
  public int HbU;
  public int HbV;
  public int HbW;
  public int HbX;
  public int HbY;
  public byte[] HbZ;
  public int Hba;
  public int Hbb;
  public int Hbc;
  public int Hbd;
  public int Hbe;
  public String Hbg;
  public int Hbh;
  public int Hbi;
  public int Hbj;
  public int Hbk;
  public int Hbl;
  public int Hbm;
  public int Hbn;
  public int Hbo;
  public int Hbp;
  public int Hbq;
  public int Hbr;
  public int Hbs;
  public int Hbt;
  public int Hbu;
  public int Hbv;
  public int Hbw;
  public int Hbx;
  public int Hby;
  public int Hbz;
  int HcB;
  public byte[] Hca;
  public byte[] Hcb;
  public ArrayBlockingQueue<byte[]> Hcd;
  long Hce;
  public byte[] Hcf;
  public int Hcg;
  public int Hch;
  public int Hci;
  public int Hcj;
  public int Hck;
  byte[] Hcl;
  byte[] Hcm;
  byte[] Hcn;
  byte[] Hco;
  byte[] Hcp;
  byte[] Hcq;
  byte[] Hcr;
  public byte[] Hcs;
  public byte[] Hct;
  public int[] Hcu;
  int Hcv;
  public o Hcw;
  public int Hcx;
  private int Hcy;
  public volatile e Hcz;
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
  public String haD;
  private MMHandler handler;
  public int height;
  protected boolean iCs;
  public long iXv;
  public int netType;
  public int qDA;
  public boolean qtK;
  public int roomId;
  public int width;
  public long ypH;
  public int ypJ;
  public int ypO;
  public int zNX;
  
  static
  {
    AppMethodBeat.i(115291);
    v2protocal.class.getClassLoader();
    j.Ed("voipMain");
    int i = m.aon();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      Hap = false;
      Haq = false;
      Har = false;
      Has = 0;
      Hbf = 0;
      Hcc = 10;
      HcA = null;
      HcC = null;
      HcD = null;
      AppMethodBeat.o(115291);
      return;
    }
  }
  
  public v2protocal(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(115273);
    this.iXv = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.Hat = 0;
    this.qDA = 0;
    this.haD = "";
    this.Hau = 0;
    this.Hav = 0;
    this.roomId = 0;
    this.Haw = 0L;
    this.ypO = 0;
    this.ypH = 0L;
    this.ypJ = 0;
    this.Hax = null;
    this.Hay = null;
    this.Haz = null;
    this.HaA = 0;
    this.HaB = null;
    this.channelStrategy = 0;
    this.HaC = 500;
    this.HaD = 30;
    this.HaE = 999;
    this.HaF = 0;
    this.HaG = null;
    this.HaH = null;
    this.HaI = new byte[10];
    this.HaJ = 20;
    this.HaK = 0;
    this.zNX = 0;
    this.HaL = 0;
    this.HaM = 0;
    this.HaN = 0;
    this.HaO = 65536;
    this.HaP = 0;
    this.HaQ = 0;
    this.HaR = 0;
    this.HaS = 7;
    this.HaT = 3;
    this.HaU = 3;
    this.HaV = 0;
    this.HaW = 0;
    this.HaX = -1;
    this.HaY = -1;
    this.HaZ = 0;
    this.Hba = 0;
    this.Hbb = 0;
    this.Hbc = 0;
    this.Hbd = 0;
    this.Hbe = 0;
    this.Hbg = "";
    this.Hbh = 0;
    this.Hbi = 0;
    this.Hbj = 0;
    this.Hbk = 0;
    this.Hbl = 100;
    this.Hbm = 300;
    this.Hbn = 1;
    this.Hbo = 1;
    this.Hbp = 0;
    this.Hbq = 1;
    this.Hbr = 0;
    this.Hbs = 0;
    this.Hbt = 0;
    this.Hbu = 0;
    this.Hbv = 0;
    this.Hbw = 0;
    this.Hbx = 0;
    this.Hby = 0;
    this.Hbz = 0;
    this.HbA = 0;
    this.HbB = 0;
    this.HbC = 0;
    this.HbD = 0;
    this.HbE = 0;
    this.HbF = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_mGetValidSample = 0;
    this.HbG = 0;
    this.HbH = 0;
    this.HbI = 0;
    this.HbJ = 0;
    this.HbK = null;
    this.HbL = 0;
    this.HbM = 0;
    this.HbN = 0;
    this.HbO = 0;
    this.HbP = new byte[1500];
    this.HbQ = 0;
    this.HbR = null;
    this.HbS = null;
    this.HbT = 0;
    this.HbU = 0;
    this.HbV = 0;
    this.HbW = 0;
    this.HbX = 0;
    this.HbY = 0;
    this.HbZ = null;
    this.Hca = null;
    this.Hcb = null;
    this.Hcd = new ArrayBlockingQueue(Hcc);
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
    this.Hce = 0L;
    this.Hcf = new byte[8];
    this.Hcg = 0;
    this.Hch = 0;
    this.Hci = 0;
    this.Hcj = 0;
    this.Hck = 0;
    this.Hcl = new byte[4096];
    this.Hcm = new byte[2048];
    this.Hcn = new byte[2048];
    this.Hco = new byte[4096];
    this.Hcp = new byte[4096];
    this.Hcq = new byte[2048];
    this.Hcr = new byte[4096];
    this.Hcs = new byte[2048];
    this.Hct = new byte[2048];
    this.Hcu = new int[30];
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
    this.Hcv = 0;
    this.Hcw = new o();
    this.Hcx = 0;
    this.Hcy = 0;
    this.handler = null;
    this.iCs = false;
    this.Hcz = null;
    this.width = 640;
    this.height = 480;
    this.HcB = 8;
    this.bitrate = 300;
    this.qtK = false;
    this.handler = paramMMHandler;
    AppMethodBeat.o(115273);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean aFU(String paramString)
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
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
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
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
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
      AppMethodBeat.o(115288);
      return bool1;
      label268:
      bool1 = false;
    }
  }
  
  public static long cn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115262);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(115262);
    return l;
  }
  
  private static String fIL()
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
  
  private String fIM()
  {
    long l3 = 0L;
    AppMethodBeat.i(115263);
    if ((this.zNX == 0) && (this.HaL == 0))
    {
      this.Hcw.GXt = 0;
      this.Hcw.GXB = com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext());
      this.Hcw.GXA = this.field_videoDuration;
      this.Hcw.GXz = this.field_audioDuration;
      this.HaP = com.tencent.mm.plugin.audio.c.a.ced();
      if ((this.Hcw.GXJ <= 0L) || (this.Hcw.GXD <= this.Hcw.GXJ)) {
        break label1475;
      }
    }
    label1475:
    for (long l1 = this.Hcw.GXD - this.Hcw.GXJ;; l1 = 0L)
    {
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.Hcf, this.Hcf.length);
      long l4 = cn(this.Hcf);
      Object localObject1 = this.Hcw;
      if ((l4 > this.Hcw.GXH) && (this.Hcw.GXH > 0L)) {}
      for (long l2 = l4 - this.Hcw.GXH;; l2 = 0L)
      {
        ((o)localObject1).GXK = l2;
        localObject1 = this.Hcw;
        l2 = l3;
        if (l4 > this.Hcw.GXJ)
        {
          l2 = l3;
          if (this.Hcw.GXJ > 0L) {
            l2 = l4 - this.Hcw.GXJ;
          }
        }
        ((o)localObject1).GXL = l2;
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.Hcw.GXK + " lCalledWaitTime:" + this.Hcw.GXL);
        int i = cpuFlag0;
        boolean bool = com.tencent.mm.plugin.voip.c.fFj();
        int j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smt, 0);
        StringBuilder localStringBuilder = new StringBuilder().append(this.HaK).append(",").append(this.roomId).append(",").append(this.ypH).append(",").append(this.ypO).append(",").append(this.Hcw.GXc).append(",").append(this.Hcw.GXo).append(",").append(this.Hcw.GXp).append(",").append(this.Hcw.GXq).append(",").append(this.Hcw.GXr).append(",").append(this.Hcw.GXs).append(",").append(this.Hcw.GXt).append(",").append(this.Hcw.GXm).append(",").append(this.Hcw.GXu).append(",").append(this.Hcw.GXv).append(",").append(this.Hcw.GXw).append(",").append(this.Hcw.GXx).append(",").append(this.Hcw.GXy).append(",").append(this.Hcw.GXz).append(",").append(this.Hcw.GXA).append(",").append(this.Hcw.GXB).append(fIS()).append(fIT()).append(fIL()).append(",").append(this.Hcw.GXC).append(",").append(this.HaO).append(",").append(this.HaP).append(",").append(l1).append(",").append(this.Hcw.GXK).append(",").append(this.Hcw.GXL).append(",").append(this.HaQ).append(",").append(this.Hau).append(fIN()).append(",").append(i & 0xFF).append(",").append(this.HaX).append(",").append(this.HaY);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.Hcw.GXE + "," + this.Hcw.GXG + "," + this.Hcw.GXF + ",0," + this.Hcw.GXM + "," + this.Hcw.GUE + "," + this.Hcw.GUF + "," + this.Hcw.GXN + ",0,0,0," + this.HaZ + "," + this.Hba + "," + this.HaR + "," + this.Hbb + "," + this.Hbc + "," + this.Hbd + "," + this.Hcx + "," + this.Hbg + "," + this.Hbe + "," + Hbf + "," + j + "," + bool;
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.Hau);
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", ":".concat(String.valueOf(localObject1)));
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + fIN());
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.Hcw.GUE + ",lInterruptEndTime:" + this.Hcw.GUF + ",mIinterruptCnt:" + this.Hcw.GXN + ",iPlayMinBufSize:" + this.HaZ + ",iRecordMinBufSize:" + this.Hba);
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.Hcx);
        AppMethodBeat.o(115263);
        return localObject1;
        if ((this.HaL != 0) && (this.zNX != 0))
        {
          this.Hcw.GXt = 3;
          break;
        }
        if (this.HaL != 0)
        {
          this.Hcw.GXt = 1;
          break;
        }
        if (this.zNX == 0) {
          break;
        }
        this.Hcw.GXt = 2;
        break;
      }
    }
  }
  
  private String fIN()
  {
    AppMethodBeat.i(115264);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(115264);
    return str;
  }
  
  private void fIR()
  {
    AppMethodBeat.i(184064);
    if ((this.Hcg <= 0) || (this.field_videoDuration <= 0))
    {
      AppMethodBeat.o(184064);
      return;
    }
    this.Hcy = (this.Hcg / this.field_videoDuration);
    Log.i("MicroMsg.Voip", "calcCpatureFps:%s", new Object[] { Integer.valueOf(this.Hcy) });
    AppMethodBeat.o(184064);
  }
  
  private String fIS()
  {
    AppMethodBeat.i(115266);
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "usePreConnect:" + this.Hbj);
    String str = "," + this.Hbj;
    AppMethodBeat.o(115266);
    return str;
  }
  
  private String fIT()
  {
    AppMethodBeat.i(115267);
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.Hbk);
    String str = "," + this.Hbk;
    AppMethodBeat.o(115267);
    return str;
  }
  
  private String fIU()
  {
    AppMethodBeat.i(115268);
    this.HaT = com.tencent.mm.plugin.audio.c.a.cea().audioManager.getMode();
    this.HaU = com.tencent.mm.plugin.audio.c.a.cea().audioManager.getMode();
    if (ae.gKu.gEe >= 0) {
      this.HaT = ae.gKu.gEe;
    }
    if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.k.alh()) && (2 == ae.gKE.gGF)) {
      this.HaU = 2;
    }
    if (ae.gKu.gEf >= 0) {
      this.HaU = ae.gKu.gEf;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      this.HaS = 1;
      if (ae.gKu.gDA) {
        this.HaS = 1;
      }
      if (ae.gKu.gEd >= 0) {
        this.HaS = ae.gKu.gEd;
      }
      if (ae.gKu.gDB <= 0) {
        break label292;
      }
      this.HaV = 3;
      this.HaW = 0;
    }
    for (;;)
    {
      if (ae.gKu.gEh >= 0) {
        this.HaV = ae.gKu.gEh;
      }
      if (ae.gKu.gEi >= 0) {
        this.HaW = ae.gKu.gEi;
      }
      String str = "," + this.HaT + "," + this.HaU + "," + this.HaS + "," + this.HaV + "," + this.HaW;
      AppMethodBeat.o(115268);
      return str;
      this.HaS = 7;
      break;
      label292:
      if (ae.gKu.gEg >= 0)
      {
        this.HaV = ae.gKu.gEg;
        this.HaW = ae.gKu.gEg;
      }
    }
  }
  
  private String fIW()
  {
    AppMethodBeat.i(115270);
    getNewEngineInfo(this.Hcp, this.Hcp.length);
    getNewEngineExtInfo(this.Hcq, this.Hcq.length);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.ypO + "," + this.ypH + this.Hcw.fGX() + "," + this.zNX + "," + this.HaL + fIO() + new String(this.Hcp, 0, this.field_newEngineStatLength) + "," + this.HaM + "," + this.HaN + fIU() + new String(this.Hcq, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.Hcp, this.Hcp.length);
    String str = this.ypO + "," + this.ypH + this.Hcw.fGX() + "," + this.zNX + "," + this.HaL + fIO() + new String(this.Hcp, 0, this.field_newEngineReportLength);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115270);
    return str;
  }
  
  public static int fJa()
  {
    AppMethodBeat.i(115276);
    DhcpInfo localDhcpInfo = ((WifiManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(localDhcpInfo.gateway))));
    int i = localDhcpInfo.gateway;
    AppMethodBeat.o(115276);
    return i;
  }
  
  public static String fJc()
  {
    return "";
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
      parama.GSV = localAtomicInteger2.get();
      parama.Bry = localAtomicInteger1.get();
      parama.GSU = 0;
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.Bry + ", framelenms =" + parama.GSV + ", channels =" + parama.channels);
      AppMethodBeat.o(115289);
      return j;
    }
    if ((m.aon() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.Bry = i;
      parama.channels = 1;
      parama.GSV = 20;
      parama.GSU = 0;
      break;
    }
  }
  
  public final int a(eur parameur)
  {
    AppMethodBeat.i(115260);
    if (this.Hce != 0L)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      AppMethodBeat.o(115260);
      return -1;
    }
    this.Hce = parameur.NsG;
    ety localety = new ety();
    localety.Nrb = parameur.NsG;
    int i = 0;
    while (i < parameur.NsL)
    {
      eub localeub = new eub();
      localeub.Ngz = ((ecd)parameur.NsM.get(i)).NbG.NgC;
      localeub.port = ((ecd)parameur.NsM.get(i)).NbG.MKe;
      localeub.HiN = ((ecd)parameur.NsM.get(i)).NbF;
      localeub.gap = ((ecd)parameur.NsM.get(i)).Ncl;
      localeub.timeout = ((ecd)parameur.NsM.get(i)).Ncm;
      localeub.Nrv = ((ecd)parameur.NsM.get(i)).Ncn;
      localety.Nrc.add(localeub);
      i += 1;
    }
    try
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(localety.toByteArray(), localety.toByteArray().length))));
      AppMethodBeat.o(115260);
      return 0;
    }
    catch (IOException parameur)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Voip", parameur, "StartVoipSpeedTest exception", new Object[0]);
      }
    }
  }
  
  public native int app2EngineDataEx(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4);
  
  public native int app2EngineLinkQualityEx(int paramInt, byte[] paramArrayOfByte);
  
  public final int bv(LinkedList<csu> paramLinkedList)
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
        csu localcsu = new csu();
        localcsu.LYu = new String(arrayOfByte2, 0, ((AtomicInteger)localObject).get());
        localcsu.MxQ = localAtomicInteger5.get();
        localcsu.Loh = localAtomicInteger4.get();
        paramLinkedList.add(localcsu);
      }
      if (localAtomicInteger1.get() > 0)
      {
        localObject = new csu();
        ((csu)localObject).LYu = new String(arrayOfByte1, 0, localAtomicInteger1.get());
        ((csu)localObject).MxQ = localAtomicInteger3.get();
        ((csu)localObject).Loh = localAtomicInteger2.get();
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
  
  protected final String fIO()
  {
    AppMethodBeat.i(115265);
    if (this.field_videoDuration == 0)
    {
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "captureFrames:" + this.Hcg + ", videoduration: 0");
      AppMethodBeat.o(115265);
      return ",0";
    }
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "capturefps:" + this.Hcg / this.field_videoDuration + " framecount:" + this.Hcg + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.Hcg / this.field_videoDuration;
    AppMethodBeat.o(115265);
    return str;
  }
  
  public final int fIP()
  {
    if (this.Hcy > 0) {
      return this.Hcy;
    }
    if (this.field_videoDuration == 0) {
      return 0;
    }
    return this.Hcg / this.field_videoDuration;
  }
  
  public final void fIQ()
  {
    AppMethodBeat.i(235703);
    this.Hcy = 0;
    Log.i("MicroMsg.Voip", "resetCaptureFps");
    AppMethodBeat.o(235703);
  }
  
  final String fIV()
  {
    AppMethodBeat.i(115269);
    getChannelInfo(this.Hco, this.Hco.length, this.HbG, this.HbH, this.HbI, this.HbJ);
    Object localObject = new StringBuilder().append(this.ypH).append(",").append(this.roomId).append(",").append(this.ypO).append(this.Hcw.fGX());
    o localo = this.Hcw;
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localo.GXs).toString() + new String(this.Hco, 0, this.field_channelStatLength))));
    getChannelReport(this.Hco, this.Hco.length);
    localObject = new String(this.Hco, 0, this.field_channelReportLength);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(115269);
    return localObject;
  }
  
  final String fIX()
  {
    AppMethodBeat.i(115271);
    getEngine2ndInfo(this.Hcr, this.Hcr.length);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.ypH + "," + this.roomId + "," + this.ypO + new String(this.Hcr, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.Hcr, this.Hcr.length);
    String str = this.ypH + "," + this.roomId + "," + this.ypO + new String(this.Hcr, 0, this.field_engine2ndReportLength);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115271);
    return str;
  }
  
  public final String fIY()
  {
    AppMethodBeat.i(115272);
    int i = cpuFlag0;
    String str = fIL() + "," + this.Hbh + "," + (i & 0xFF) + fIU() + "," + this.HaY;
    AppMethodBeat.o(115272);
    return str;
  }
  
  public final boolean fIZ()
  {
    return this.iCs;
  }
  
  public final int fJb()
  {
    AppMethodBeat.i(115278);
    this.netType = com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext());
    if (this.netType == 5) {
      this.netType = 4;
    }
    this.HbF = new int[this.defaultWidth * this.defaultHeight];
    g.aAf();
    this.qDA = com.tencent.mm.kernel.a.getUin();
    int i = m.aon();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.qDA, k << 24 | j << 16 | i, com.tencent.mm.loader.j.b.aKA() + "lib/", 4, 0L, 0);
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "protocalInitForPstn protocal init ret :" + i + ",uin= " + this.qDA + ", groupRsCap = 0");
    this.iCs = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(115278);
    return i;
  }
  
  public final String fJd()
  {
    AppMethodBeat.i(115281);
    String str = fIM();
    AppMethodBeat.o(115281);
    return str;
  }
  
  public final String[] fJe()
  {
    AppMethodBeat.i(115282);
    String[] arrayOfString = getNatReport();
    com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115282);
    return arrayOfString;
  }
  
  public final String[] fJf()
  {
    AppMethodBeat.i(115283);
    String[] arrayOfString = getMPDirectReport();
    com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "direct_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "direct_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115283);
    return arrayOfString;
  }
  
  public final String[] fJg()
  {
    AppMethodBeat.i(115284);
    String[] arrayOfString = getMPRelayReport();
    com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "relay_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "relay_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115284);
    return arrayOfString;
  }
  
  public final String[] fJh()
  {
    AppMethodBeat.i(115285);
    String[] arrayOfString = getMPEngineReport();
    com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "engine_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = (this.ypH + "," + this.ypO + arrayOfString[i]);
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip", "engine_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115285);
    return arrayOfString;
  }
  
  public final String fJi()
  {
    AppMethodBeat.i(115286);
    String str = fIW();
    AppMethodBeat.o(115286);
    return str;
  }
  
  public native int freeJNIReport();
  
  public final int ftD()
  {
    AppMethodBeat.i(115279);
    this.netType = com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext());
    this.Hau = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool5;
    boolean bool6;
    label90:
    boolean bool7;
    label110:
    int i;
    label129:
    boolean bool8;
    label201:
    boolean bool9;
    label274:
    int k;
    label286:
    int j;
    label298:
    boolean bool10;
    label311:
    boolean bool11;
    label323:
    int m;
    label335:
    int n;
    label347:
    int i1;
    label359:
    int i2;
    label383:
    int i3;
    label407:
    boolean bool1;
    label428:
    label456:
    boolean bool12;
    label549:
    label566:
    boolean bool3;
    label578:
    boolean bool2;
    label598:
    label618:
    boolean bool4;
    label638:
    boolean bool13;
    label650:
    label663:
    Object localObject;
    if ((this.Hau >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool5 = true;
      if ((!bool5) || ((cpuFlag0 & 0xFF) < 30)) {
        break label1518;
      }
      bool6 = true;
      if ((!bool6) || ((cpuFlag0 & 0xFF) < 60)) {
        break label1524;
      }
      bool7 = true;
      if ((!bool7) || ((cpuFlag0 & 0xFF) < 71)) {
        break label1530;
      }
      i = 1;
      if ((ae.gKt.gGc <= 0) || (ae.gKt.gFE.width < 480) || (ae.gKt.gFE.height < 360) || (ae.gKt.gFG.width < 480) || (ae.gKt.gFG.height < 360)) {
        break label1535;
      }
      bool8 = true;
      if ((ae.gKt.gGc < 2) || (ae.gKt.gFE.width < 640) || (ae.gKt.gFE.height < 480) || (ae.gKt.gFG.width < 640) || (ae.gKt.gFG.height < 480)) {
        break label1541;
      }
      bool9 = true;
      if (ae.gKt.gGc != 2) {
        break label1547;
      }
      k = 1;
      if (ae.gKt.gGc != 3) {
        break label1552;
      }
      j = 1;
      if (ae.gKt.gGc < 4) {
        break label1557;
      }
      bool10 = true;
      if (ae.gKt.gGc != 0) {
        break label1563;
      }
      bool11 = true;
      if (ae.gKt.gGd != 0) {
        break label1569;
      }
      m = 1;
      if (ae.gKt.gGd <= 0) {
        break label1575;
      }
      n = 1;
      if (ae.gKt.gGe <= 0) {
        break label1581;
      }
      i1 = 1;
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXb, 0) == 0) {
        break label1587;
      }
      i2 = 1;
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXa, 0) == 0) {
        break label1593;
      }
      i3 = 1;
      if (((i == 0) || (!bool10)) && ((i == 0) || (i2 == 0))) {
        break label1599;
      }
      bool1 = true;
      Haq = bool1;
      if (((!bool7) || (i1 == 0)) && ((!bool7) || (i3 == 0))) {
        break label1605;
      }
      bool1 = true;
      Har = bool1;
      if ((ae.gKt.gFE.width >= 480) || (ae.gKt.gFG.width >= 480))
      {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "hseasun:Close the 720p force due to configuration from svr");
        Haq = false;
        Har = false;
      }
      if (Haq) {
        Har = true;
      }
      Has = 0;
      this.qtK = false;
      if (m != 0) {
        break label1708;
      }
      if ((!bool6) || (!aFU("video/avc"))) {
        break label1611;
      }
      bool1 = true;
      if ((!bool7) || (!aFU("video/hevc"))) {
        break label1617;
      }
      bool12 = true;
      if ((!bool12) || (j == 0)) {
        break label1623;
      }
      bool3 = true;
      if (n == 0) {
        break label1686;
      }
      if ((ae.gKt.gGd & 0x10) == 0) {
        break label1629;
      }
      bool2 = true;
      if ((!bool3) || ((ae.gKt.gGd & 0x20) == 0)) {
        break label1635;
      }
      bool3 = true;
      if ((!bool1) || ((ae.gKt.gGd & 0xF) == 0)) {
        break label1641;
      }
      bool4 = true;
      bool13 = bool4;
      bool4 = bool3;
      bool3 = bool13;
      if ((!bool4) && (!bool3)) {
        break label1647;
      }
      bool13 = true;
      this.qtK = bool13;
      localObject = new StringBuilder("hwH264Local:").append(bool1).append(",hwHEVCLocal:").append(bool12).append(", bSupportH264HW:").append(bool3).append(", bSupportHEVCSW:").append(bool2).append(", bSupportHEVCHW:").append(bool4).append(", svrHWCfg:").append(ae.gKt.gGd).append(", 720p jcchen ").append(bool7).append("-");
      if (k != 0) {
        break label1653;
      }
      bool1 = true;
      label769:
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", bool1 + "-" + bool10 + "-" + Haq + " svr 480p:" + ae.gKt.gGc);
      if (!bool3) {
        break label1681;
      }
      i = 1;
      label830:
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      if (!bool4) {
        break label1676;
      }
      i = j | 0x4;
    }
    for (;;)
    {
      if (((bool5) || (bool8)) && (!bool11))
      {
        if ((!this.qtK) && (!bool9)) {
          break label1659;
        }
        this.defaultWidth = 640;
        this.defaultHeight = 480;
        if ((bool7) && (k == 0)) {
          this.defaultWidth = 1280;
        }
      }
      for (this.defaultHeight = 720;; this.defaultHeight = 360)
      {
        Hap = true;
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool5 + ", bEnable480FromSvr:" + bool8 + ", bDisable480FromSvr:" + bool11 + ", bEnable640FromLocal:" + bool6 + ", bEnable640FromSvr:" + bool9);
        this.HbF = new int[this.defaultWidth * this.defaultHeight];
        g.aAf();
        this.qDA = com.tencent.mm.kernel.a.getUin();
        m = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        localObject = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        n = ((Display)localObject).getWidth();
        i1 = ((Display)localObject).getHeight();
        k = ae.gKE.gHf;
        long l2 = 0L;
        i2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgG, -1);
        Log.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i2) });
        i3 = ae.gKu.gEr;
        Log.i("MicroMsg.Voip", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(i3) });
        long l1 = l2;
        if (i2 > 0)
        {
          l1 = l2;
          if (i3 > 0)
          {
            l1 = (i2 * 100000.0D) + 456L;
            Log.i("MicroMsg.Voip", "kerrizhang typectrl %d", new Object[] { Long.valueOf(l1) });
          }
        }
        i2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shc, 0);
        Log.i("MicroMsg.Voip", "winterwang get server opuswbswitch %d", new Object[] { Integer.valueOf(i2) });
        localObject = new byte[4];
        localObject[0] = ((byte)i2);
        Log.i("MicroMsg.Voip", "winterwang setJNIAppCmd  EMethod_AudioOptionSwitch ,ret: %d", new Object[] { Integer.valueOf(setJNIAppCmd(5, (byte[])localObject, 4)) });
        i2 = this.netType;
        i3 = this.defaultWidth;
        m = init(i << 8 | i2, 2, this.defaultHeight | i3 << 16, n << 16 | i1, this.qDA, j << 24 | m << 16 | cpuFlag0, com.tencent.mm.loader.j.b.aKA() + "lib/", 0, l1, k);
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "protocalInit protocal init ret :" + m + ",uin= " + this.qDA + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i + ", groupRsCap = " + k);
        this.iCs = true;
        if (m < 0) {
          reset();
        }
        AppMethodBeat.o(115279);
        return m;
        bool5 = false;
        break;
        label1518:
        bool6 = false;
        break label90;
        label1524:
        bool7 = false;
        break label110;
        label1530:
        i = 0;
        break label129;
        label1535:
        bool8 = false;
        break label201;
        label1541:
        bool9 = false;
        break label274;
        label1547:
        k = 0;
        break label286;
        label1552:
        j = 0;
        break label298;
        label1557:
        bool10 = false;
        break label311;
        label1563:
        bool11 = false;
        break label323;
        label1569:
        m = 0;
        break label335;
        label1575:
        n = 0;
        break label347;
        label1581:
        i1 = 0;
        break label359;
        label1587:
        i2 = 0;
        break label383;
        label1593:
        i3 = 0;
        break label407;
        label1599:
        bool1 = false;
        break label428;
        label1605:
        bool1 = false;
        break label456;
        label1611:
        bool1 = false;
        break label549;
        label1617:
        bool12 = false;
        break label566;
        label1623:
        bool3 = false;
        break label578;
        label1629:
        bool2 = false;
        break label598;
        label1635:
        bool3 = false;
        break label618;
        label1641:
        bool4 = false;
        break label638;
        label1647:
        bool13 = false;
        break label663;
        label1653:
        bool1 = false;
        break label769;
        label1659:
        this.defaultWidth = 480;
      }
      label1676:
      i = j;
      continue;
      label1681:
      i = 0;
      break label830;
      label1686:
      bool2 = false;
      bool4 = bool1;
      bool13 = bool3;
      bool3 = bool4;
      bool4 = bool13;
      break label650;
      label1708:
      i = 0;
    }
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
  
  public native int handleCommand(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  protected native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, long paramLong, int paramInt8);
  
  public native int isDCReady();
  
  public native int isDCSameLan();
  
  public native int isRelayConnReady();
  
  public int keep_onNotifyFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115274);
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.VoipService", "callByJni : arg1:" + paramInt1 + " arg2:" + paramInt2);
    if (paramInt1 == 100)
    {
      com.tencent.mm.plugin.voip.b.e.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      AppMethodBeat.o(115274);
      return 0;
    }
    if (paramInt1 == 101)
    {
      com.tencent.mm.plugin.voip.b.e.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
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
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.VoipService", "callByJniInt : arg1:" + paramInt1 + " arg2:" + paramInt2);
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
    fIR();
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.roomId = 0;
    this.Haw = 0L;
    this.Hav = 0;
    this.ypO = 0;
    this.ypH = 0L;
    this.channelStrategy = 0;
    this.ypJ = 0;
    this.iXv = 0L;
    this.Hax = null;
    this.Hay = null;
    this.Haz = null;
    this.HaA = 0;
    this.HaB = null;
    this.HbJ = 0;
    this.HbK = null;
    this.HbL = 0;
    this.HbM = 0;
    this.HaG = null;
    this.HaH = null;
    this.HbR = null;
    this.HbS = null;
    this.HbZ = null;
    this.Hca = null;
    this.Hcb = null;
    this.Hcg = 0;
    this.Hch = 0;
    this.Hci = 0;
    this.Hcj = 0;
    this.Hck = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.Hcv = 0;
    this.Hbk = 0;
    this.Hbj = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.HaM = 0;
    this.HaN = 0;
    this.HaO = 65536;
    this.HaP = 0;
    this.HaQ = 0;
    this.HaR = 0;
    this.HaY = -1;
    this.Hbh = 0;
    this.HbV = 0;
    this.Hat = 0;
    this.haD = "";
    this.HbT = 0;
    this.HbU = 0;
    this.Hcw.reset();
    this.Hcw.fGW();
    Hap = false;
    Has = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.Hbb = 0;
    this.Hbc = 0;
    this.Hbd = 0;
    this.Hbe = 0;
    Hbf = 0;
    this.Hbg = "";
    this.Hcx = 0;
    com.tencent.mm.plugin.voip.c.fFi();
    int i = freeJNIReport();
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
    AppMethodBeat.o(115287);
  }
  
  public native int setActive();
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(115259);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
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
  
  public final String xh(boolean paramBoolean)
  {
    AppMethodBeat.i(115280);
    if (this.iCs)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.Hcw.GXm;
      this.field_ChannelReportDial[1] = this.Hcw.GXs;
      this.field_ChannelReportDial[2] = this.HbG;
      this.field_ChannelReportDial[3] = this.HbH;
      this.field_ChannelReportDial[4] = this.HbI;
      this.field_ChannelReportDial[5] = this.HbJ;
      this.field_EngineReportStatFromApp = new int[17];
      fIU();
      this.field_EngineReportStatFromApp[0] = this.HaM;
      this.field_EngineReportStatFromApp[1] = this.HaN;
      this.field_EngineReportStatFromApp[2] = this.HaT;
      this.field_EngineReportStatFromApp[3] = this.HaU;
      this.field_EngineReportStatFromApp[4] = this.HaS;
      this.field_EngineReportStatFromApp[5] = this.HaV;
      this.field_EngineReportStatFromApp[6] = this.HaW;
      this.field_EngineReportStatFromApp[7] = -1;
      if (this.Hcz != null)
      {
        this.field_EngineReportStatFromApp[8] = this.Hcz.qsj;
        this.field_EngineReportStatFromApp[9] = this.Hcz.qsl;
        this.field_EngineReportStatFromApp[10] = this.Hcz.qsb;
        if (HcA == null) {
          break label1227;
        }
        this.field_EngineReportStatFromApp[11] = HcA.zLC;
        label263:
        this.field_EngineReportStatFromApp[12] = this.HbW;
        this.field_EngineReportStatFromApp[13] = this.HbX;
        this.field_EngineReportStatFromApp[14] = this.HbY;
        if (!Har) {
          break label1238;
        }
        this.field_EngineReportStatFromApp[15] = 1280;
        this.field_EngineReportStatFromApp[16] = 720;
      }
      for (;;)
      {
        this.iCs = false;
        uninit(this.roomId, this.ypH, this.ypO);
        Hap = false;
        Has = 0;
        if (this.Hcz != null)
        {
          this.Hcz.emB();
          this.Hcz = null;
        }
        if (HcA != null)
        {
          HcA.interrupt();
          localObject1 = HcA;
          ((d)localObject1).zLv = false;
          ((d)localObject1).zLw = false;
          ((d)localObject1).zLy = 0;
          Log.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
        }
        try
        {
          if (((d)localObject1).outputStream != null)
          {
            ((d)localObject1).outputStream.flush();
            ((d)localObject1).outputStream.close();
          }
          if (((d)localObject1).zLm != null)
          {
            ((d)localObject1).zLm.flush();
            ((d)localObject1).zLm.close();
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            long l;
            Object localObject2;
            o localo;
            Log.e("MeidaCodec[HWDec]", " error:" + localIOException.toString());
          }
        }
        HcA = null;
        if (HcC != null) {
          HcC.release();
        }
        HcC = null;
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1293;
        }
        getStatInfo(this.Hcl, this.Hcl.length, this.Hcu, 30);
        getEngineVersionInfo(this.Hcm, this.Hcm.length);
        getEngineQosInfo(this.Hcn, this.Hcn.length);
        Object localObject1 = new StringBuilder();
        l = this.qDA;
        if (this.qDA < 0) {
          l = this.qDA + 4294967296L;
        }
        localObject2 = new StringBuilder().append(l).append(",").append(this.ypH).append(",").append(this.roomId).append(",").append(this.ypO).append(",");
        localo = this.Hcw;
        localObject2 = new StringBuilder().append(localo.GXc).append(",").append(localo.GXd).append(",").append(localo.GXe).append(",").append(localo.GXf).append(",").append(localo.GXg).append(",").append(localo.GXh).append(",").append(localo.GXi).append(",").append(localo.GXj).append(",").append(localo.GXk).append(",").append(localo.GXl).append(",").append(localo.GXm).toString();
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.Hcl, 0, this.field_statInfoLength)).append(fIL()).append(fIN());
        localObject2 = this.Hcw;
        localObject1 = ((StringBuilder)localObject1).append("," + ((o)localObject2).GXn).append(new String(this.Hcm, 0, this.field_engineVersionStatLength)).append(fIO());
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + fIS() + fIT() + new String(this.Hcn, 0, this.field_engineQosStatLength);
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.Hcl, 0, this.field_statInfoLength));
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.Hcm, 0, this.field_engineVersionStatLength));
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.Hcn, 0, this.field_engineQosStatLength));
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        ay.a.iDr.dl(this.field_netFlowRecv, this.field_netFlowSent);
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
        AppMethodBeat.o(115280);
        return localObject1;
        this.field_EngineReportStatFromApp[8] = 0;
        this.field_EngineReportStatFromApp[9] = 0;
        this.field_EngineReportStatFromApp[10] = 0;
        break;
        label1227:
        this.field_EngineReportStatFromApp[11] = 0;
        break label263;
        label1238:
        this.field_EngineReportStatFromApp[15] = 640;
        this.field_EngineReportStatFromApp[16] = 480;
      }
    }
    label1293:
    AppMethodBeat.o(115280);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */