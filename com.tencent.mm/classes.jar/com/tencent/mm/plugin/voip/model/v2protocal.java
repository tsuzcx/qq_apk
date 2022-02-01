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
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class v2protocal
{
  public static boolean CwB;
  public static boolean CwC;
  public static int CwD;
  public static int Cxr;
  public static d CyL;
  public static Surface CyN;
  public static com.tencent.mm.media.g.d CyO;
  private static int Cyn;
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  protected static int cpuFlag0;
  public static SurfaceTexture mSurfaceTexture;
  public int CwE;
  public int CwF;
  public int CwG;
  public long CwH;
  public byte[] CwI;
  public volatile byte[] CwJ;
  public byte[] CwK;
  public int CwL;
  public byte[] CwM;
  public int CwN;
  public int CwO;
  public int CwP;
  public int CwQ;
  public byte[] CwR;
  public byte[] CwS;
  public byte[] CwT;
  public int CwU;
  public int CwV;
  public int CwW;
  public int CwX;
  public int CwY;
  public int CwZ;
  public int CxA;
  public int CxB;
  public int CxC;
  public int CxD;
  public int CxE;
  public int CxF;
  public int CxG;
  public int CxH;
  public int CxI;
  public int CxJ;
  public int CxK;
  public int CxL;
  public int CxM;
  public int CxN;
  public int CxO;
  public int CxP;
  public int CxQ;
  public int[] CxR;
  public int CxS;
  public int CxT;
  public int CxU;
  public int CxV;
  public byte[] CxW;
  public int CxX;
  public int CxY;
  public int CxZ;
  public int Cxa;
  public int Cxb;
  public int Cxc;
  public int Cxd;
  public int Cxe;
  public int Cxf;
  public int Cxg;
  public int Cxh;
  public int Cxi;
  public int Cxj;
  public int Cxk;
  public int Cxl;
  public int Cxm;
  public int Cxn;
  public int Cxo;
  public int Cxp;
  public int Cxq;
  public String Cxs;
  public int Cxt;
  public int Cxu;
  public int Cxv;
  public int Cxw;
  public int Cxx;
  public int Cxy;
  public int Cxz;
  byte[] CyA;
  byte[] CyB;
  byte[] CyC;
  public byte[] CyD;
  public byte[] CyE;
  public int[] CyF;
  int CyG;
  public o CyH;
  public int CyI;
  private int CyJ;
  public volatile e CyK;
  int CyM;
  public int Cya;
  public byte[] Cyb;
  public int Cyc;
  public byte[] Cyd;
  public byte[] Cye;
  public int Cyf;
  public int Cyg;
  public int Cyh;
  public int Cyi;
  public int Cyj;
  public byte[] Cyk;
  public byte[] Cyl;
  public byte[] Cym;
  public ArrayBlockingQueue<byte[]> Cyo;
  long Cyp;
  public byte[] Cyq;
  public int Cyr;
  public int Cys;
  public int Cyt;
  public int Cyu;
  public int Cyv;
  byte[] Cyw;
  byte[] Cyx;
  byte[] Cyy;
  byte[] Cyz;
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
  public String gpK;
  private aq handler;
  public int height;
  public long icx;
  protected boolean iys;
  public int netType;
  public boolean peH;
  public int pnU;
  public int roomId;
  public long uXg;
  public int uXi;
  public int uXn;
  public int width;
  
  static
  {
    AppMethodBeat.i(115291);
    v2protocal.class.getClassLoader();
    j.vN("voipMain");
    int i = m.aao();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      CwB = false;
      CwC = false;
      CwD = 0;
      Cxr = 0;
      Cyn = 10;
      CyL = null;
      CyN = null;
      CyO = null;
      AppMethodBeat.o(115291);
      return;
    }
  }
  
  public v2protocal(aq paramaq)
  {
    AppMethodBeat.i(115273);
    this.icx = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.CwE = 0;
    this.pnU = 0;
    this.gpK = "";
    this.CwF = 0;
    this.CwG = 0;
    this.roomId = 0;
    this.CwH = 0L;
    this.uXn = 0;
    this.uXg = 0L;
    this.uXi = 0;
    this.CwI = null;
    this.CwJ = null;
    this.CwK = null;
    this.CwL = 0;
    this.CwM = null;
    this.channelStrategy = 0;
    this.CwN = 500;
    this.CwO = 30;
    this.CwP = 999;
    this.CwQ = 0;
    this.CwR = null;
    this.CwS = null;
    this.CwT = new byte[10];
    this.CwU = 20;
    this.CwV = 0;
    this.CwW = 0;
    this.CwX = 0;
    this.CwY = 0;
    this.CwZ = 0;
    this.Cxa = 65536;
    this.Cxb = 0;
    this.Cxc = 0;
    this.Cxd = 0;
    this.Cxe = 7;
    this.Cxf = 3;
    this.Cxg = 3;
    this.Cxh = 0;
    this.Cxi = 0;
    this.Cxj = -1;
    this.Cxk = -1;
    this.Cxl = 0;
    this.Cxm = 0;
    this.Cxn = 0;
    this.Cxo = 0;
    this.Cxp = 0;
    this.Cxq = 0;
    this.Cxs = "";
    this.Cxt = 0;
    this.Cxu = 0;
    this.Cxv = 0;
    this.Cxw = 0;
    this.Cxx = 100;
    this.Cxy = 300;
    this.Cxz = 1;
    this.CxA = 1;
    this.CxB = 0;
    this.CxC = 1;
    this.CxD = 0;
    this.CxE = 0;
    this.CxF = 0;
    this.CxG = 0;
    this.CxH = 0;
    this.CxI = 0;
    this.CxJ = 0;
    this.CxK = 0;
    this.CxL = 0;
    this.CxM = 0;
    this.CxN = 0;
    this.CxO = 0;
    this.CxP = 0;
    this.CxQ = 0;
    this.CxR = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_mGetValidSample = 0;
    this.CxS = 0;
    this.CxT = 0;
    this.CxU = 0;
    this.CxV = 0;
    this.CxW = null;
    this.CxX = 0;
    this.CxY = 0;
    this.CxZ = 0;
    this.Cya = 0;
    this.Cyb = new byte[1500];
    this.Cyc = 0;
    this.Cyd = null;
    this.Cye = null;
    this.Cyf = 0;
    this.Cyg = 0;
    this.Cyh = 0;
    this.Cyi = 0;
    this.Cyj = 0;
    this.Cyk = null;
    this.Cyl = null;
    this.Cym = null;
    this.Cyo = new ArrayBlockingQueue(Cyn);
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
    this.Cyp = 0L;
    this.Cyq = new byte[8];
    this.Cyr = 0;
    this.Cys = 0;
    this.Cyt = 0;
    this.Cyu = 0;
    this.Cyv = 0;
    this.Cyw = new byte[4096];
    this.Cyx = new byte[2048];
    this.Cyy = new byte[2048];
    this.Cyz = new byte[4096];
    this.CyA = new byte[4096];
    this.CyB = new byte[2048];
    this.CyC = new byte[4096];
    this.CyD = new byte[2048];
    this.CyE = new byte[2048];
    this.CyF = new int[30];
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
    this.CyG = 0;
    this.CyH = new o();
    this.CyI = 0;
    this.CyJ = 0;
    this.handler = null;
    this.iys = false;
    this.CyK = null;
    this.width = 640;
    this.height = 480;
    this.CyM = 8;
    this.bitrate = 300;
    this.peH = false;
    this.handler = paramaq;
    AppMethodBeat.o(115273);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean asz(String paramString)
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
        f.Logi("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject).getName());
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
        f.Logi("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(localObject)));
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
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Voip", paramString, "SupportAvcCodec error: %s", new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      AppMethodBeat.o(115288);
      return bool1;
      label268:
      bool1 = false;
    }
  }
  
  public static long bX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115262);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(115262);
    return l;
  }
  
  private static String eBR()
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
  
  private String eBS()
  {
    long l3 = 0L;
    AppMethodBeat.i(115263);
    if ((this.CwW == 0) && (this.CwX == 0))
    {
      this.CyH.CtK = 0;
      this.CyH.CtS = f.getNetType(ak.getContext());
      this.CyH.CtR = this.field_videoDuration;
      this.CyH.CtQ = this.field_audioDuration;
      this.Cxb = com.tencent.mm.plugin.audio.c.a.bHB();
      if ((this.CyH.Cua <= 0L) || (this.CyH.CtU <= this.CyH.Cua)) {
        break label1475;
      }
    }
    label1475:
    for (long l1 = this.CyH.CtU - this.CyH.Cua;; l1 = 0L)
    {
      f.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.Cyq, this.Cyq.length);
      long l4 = bX(this.Cyq);
      Object localObject1 = this.CyH;
      if ((l4 > this.CyH.CtY) && (this.CyH.CtY > 0L)) {}
      for (long l2 = l4 - this.CyH.CtY;; l2 = 0L)
      {
        ((o)localObject1).Cub = l2;
        localObject1 = this.CyH;
        l2 = l3;
        if (l4 > this.CyH.Cua)
        {
          l2 = l3;
          if (this.CyH.Cua > 0L) {
            l2 = l4 - this.CyH.Cua;
          }
        }
        ((o)localObject1).Cuc = l2;
        f.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.CyH.Cub + " lCalledWaitTime:" + this.CyH.Cuc);
        int i = cpuFlag0;
        boolean bool = com.tencent.mm.plugin.voip.c.eyu();
        int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPk, 0);
        StringBuilder localStringBuilder = new StringBuilder().append(this.CwV).append(",").append(this.roomId).append(",").append(this.uXg).append(",").append(this.uXn).append(",").append(this.CyH.Ctt).append(",").append(this.CyH.CtF).append(",").append(this.CyH.CtG).append(",").append(this.CyH.CtH).append(",").append(this.CyH.CtI).append(",").append(this.CyH.CtJ).append(",").append(this.CyH.CtK).append(",").append(this.CyH.CtD).append(",").append(this.CyH.CtL).append(",").append(this.CyH.CtM).append(",").append(this.CyH.CtN).append(",").append(this.CyH.CtO).append(",").append(this.CyH.CtP).append(",").append(this.CyH.CtQ).append(",").append(this.CyH.CtR).append(",").append(this.CyH.CtS).append(eBY()).append(eBZ()).append(eBR()).append(",").append(this.CyH.CtT).append(",").append(this.Cxa).append(",").append(this.Cxb).append(",").append(l1).append(",").append(this.CyH.Cub).append(",").append(this.CyH.Cuc).append(",").append(this.Cxc).append(",").append(this.CwF).append(eBT()).append(",").append(i & 0xFF).append(",").append(this.Cxj).append(",").append(this.Cxk);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.CyH.CtV + "," + this.CyH.CtX + "," + this.CyH.CtW + ",0," + this.CyH.Cud + "," + this.CyH.CqP + "," + this.CyH.CqQ + "," + this.CyH.Cue + ",0,0,0," + this.Cxl + "," + this.Cxm + "," + this.Cxd + "," + this.Cxn + "," + this.Cxo + "," + this.Cxp + "," + this.CyI + "," + this.Cxs + "," + this.Cxq + "," + Cxr + "," + j + "," + bool;
        f.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.CwF);
        f.Logi("MicroMsg.Voip", ":".concat(String.valueOf(localObject1)));
        f.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + eBT());
        f.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.CyH.CqP + ",lInterruptEndTime:" + this.CyH.CqQ + ",mIinterruptCnt:" + this.CyH.Cue + ",iPlayMinBufSize:" + this.Cxl + ",iRecordMinBufSize:" + this.Cxm);
        f.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.CyI);
        AppMethodBeat.o(115263);
        return localObject1;
        if ((this.CwX != 0) && (this.CwW != 0))
        {
          this.CyH.CtK = 3;
          break;
        }
        if (this.CwX != 0)
        {
          this.CyH.CtK = 1;
          break;
        }
        if (this.CwW == 0) {
          break;
        }
        this.CyH.CtK = 2;
        break;
      }
    }
  }
  
  private String eBT()
  {
    AppMethodBeat.i(115264);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(115264);
    return str;
  }
  
  private void eBX()
  {
    AppMethodBeat.i(184064);
    if ((this.Cyr <= 0) || (this.field_videoDuration <= 0))
    {
      AppMethodBeat.o(184064);
      return;
    }
    this.CyJ = (this.Cyr / this.field_videoDuration);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip", "calcCpatureFps:%s", new Object[] { Integer.valueOf(this.CyJ) });
    AppMethodBeat.o(184064);
  }
  
  private String eBY()
  {
    AppMethodBeat.i(115266);
    f.Logd("MicroMsg.Voip", "usePreConnect:" + this.Cxv);
    String str = "," + this.Cxv;
    AppMethodBeat.o(115266);
    return str;
  }
  
  private String eBZ()
  {
    AppMethodBeat.i(115267);
    f.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.Cxw);
    String str = "," + this.Cxw;
    AppMethodBeat.o(115267);
    return str;
  }
  
  private String eCa()
  {
    AppMethodBeat.i(115268);
    this.Cxf = com.tencent.mm.plugin.audio.c.a.bHy().audioManager.getMode();
    this.Cxg = com.tencent.mm.plugin.audio.c.a.bHy().audioManager.getMode();
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYN >= 0) {
      this.Cxf = com.tencent.mm.compatible.deviceinfo.ae.geN.fYN;
    }
    if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.k.Xu()) && (2 == com.tencent.mm.compatible.deviceinfo.ae.geX.gbn)) {
      this.Cxg = 2;
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYO >= 0) {
      this.Cxg = com.tencent.mm.compatible.deviceinfo.ae.geN.fYO;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      this.Cxe = 1;
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYn) {
        this.Cxe = 1;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYM >= 0) {
        this.Cxe = com.tencent.mm.compatible.deviceinfo.ae.geN.fYM;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYo <= 0) {
        break label292;
      }
      this.Cxh = 3;
      this.Cxi = 0;
    }
    for (;;)
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ >= 0) {
        this.Cxh = com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYR >= 0) {
        this.Cxi = com.tencent.mm.compatible.deviceinfo.ae.geN.fYR;
      }
      String str = "," + this.Cxf + "," + this.Cxg + "," + this.Cxe + "," + this.Cxh + "," + this.Cxi;
      AppMethodBeat.o(115268);
      return str;
      this.Cxe = 7;
      break;
      label292:
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYP >= 0)
      {
        this.Cxh = com.tencent.mm.compatible.deviceinfo.ae.geN.fYP;
        this.Cxi = com.tencent.mm.compatible.deviceinfo.ae.geN.fYP;
      }
    }
  }
  
  private String eCc()
  {
    AppMethodBeat.i(115270);
    getNewEngineInfo(this.CyA, this.CyA.length);
    getNewEngineExtInfo(this.CyB, this.CyB.length);
    f.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.uXn + "," + this.uXg + this.CyH.eAh() + "," + this.CwW + "," + this.CwX + eBU() + new String(this.CyA, 0, this.field_newEngineStatLength) + "," + this.CwY + "," + this.CwZ + eCa() + new String(this.CyB, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.CyA, this.CyA.length);
    String str = this.uXn + "," + this.uXg + this.CyH.eAh() + "," + this.CwW + "," + this.CwX + eBU() + new String(this.CyA, 0, this.field_newEngineReportLength);
    f.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115270);
    return str;
  }
  
  public static int eCg()
  {
    AppMethodBeat.i(115276);
    DhcpInfo localDhcpInfo = ((WifiManager)ak.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
    f.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(localDhcpInfo.gateway))));
    int i = localDhcpInfo.gateway;
    AppMethodBeat.o(115276);
    return i;
  }
  
  public static String eCi()
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
      parama.CoZ = localAtomicInteger2.get();
      parama.xrw = localAtomicInteger1.get();
      parama.CoY = 0;
      f.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.xrw + ", framelenms =" + parama.CoZ + ", channels =" + parama.channels);
      AppMethodBeat.o(115289);
      return j;
    }
    if ((m.aao() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.xrw = i;
      parama.channels = 1;
      parama.CoZ = 20;
      parama.CoY = 0;
      break;
    }
  }
  
  public final int a(eak parameak)
  {
    AppMethodBeat.i(115260);
    if (this.Cyp != 0L)
    {
      f.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      AppMethodBeat.o(115260);
      return -1;
    }
    this.Cyp = parameak.Igi;
    dzr localdzr = new dzr();
    localdzr.IeD = parameak.Igi;
    int i = 0;
    while (i < parameak.Ign)
    {
      dzu localdzu = new dzu();
      localdzu.HUh = ((dit)parameak.Igo.get(i)).HPO.HUk;
      localdzu.port = ((dit)parameak.Igo.get(i)).HPO.Hzv;
      localdzu.CFz = ((dit)parameak.Igo.get(i)).HPN;
      localdzu.gap = ((dit)parameak.Igo.get(i)).HQt;
      localdzu.timeout = ((dit)parameak.Igo.get(i)).HQu;
      localdzu.IeX = ((dit)parameak.Igo.get(i)).HQv;
      localdzr.IeE.add(localdzu);
      i += 1;
    }
    try
    {
      f.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(localdzr.toByteArray(), localdzr.toByteArray().length))));
      AppMethodBeat.o(115260);
      return 0;
    }
    catch (IOException parameak)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Voip", parameak, "StartVoipSpeedTest exception", new Object[0]);
      }
    }
  }
  
  public final int aZ(LinkedList<ccp> paramLinkedList)
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
        ccp localccp = new ccp();
        localccp.GUc = new String(arrayOfByte2, 0, ((AtomicInteger)localObject).get());
        localccp.Hpj = localAtomicInteger5.get();
        localccp.GsP = localAtomicInteger4.get();
        paramLinkedList.add(localccp);
      }
      if (localAtomicInteger1.get() > 0)
      {
        localObject = new ccp();
        ((ccp)localObject).GUc = new String(arrayOfByte1, 0, localAtomicInteger1.get());
        ((ccp)localObject).Hpj = localAtomicInteger3.get();
        ((ccp)localObject).GsP = localAtomicInteger2.get();
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
  
  protected final String eBU()
  {
    AppMethodBeat.i(115265);
    if (this.field_videoDuration == 0)
    {
      f.Logd("MicroMsg.Voip", "captureFrames:" + this.Cyr + ", videoduration: 0");
      AppMethodBeat.o(115265);
      return ",0";
    }
    f.Logd("MicroMsg.Voip", "capturefps:" + this.Cyr / this.field_videoDuration + " framecount:" + this.Cyr + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.Cyr / this.field_videoDuration;
    AppMethodBeat.o(115265);
    return str;
  }
  
  public final int eBV()
  {
    if (this.CyJ > 0) {
      return this.CyJ;
    }
    if (this.field_videoDuration == 0) {
      return 0;
    }
    return this.Cyr / this.field_videoDuration;
  }
  
  public final void eBW()
  {
    AppMethodBeat.i(210122);
    this.CyJ = 0;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip", "resetCaptureFps");
    AppMethodBeat.o(210122);
  }
  
  final String eCb()
  {
    AppMethodBeat.i(115269);
    getChannelInfo(this.Cyz, this.Cyz.length, this.CxS, this.CxT, this.CxU, this.CxV);
    Object localObject = new StringBuilder().append(this.uXg).append(",").append(this.roomId).append(",").append(this.uXn).append(this.CyH.eAh());
    o localo = this.CyH;
    f.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localo.CtJ).toString() + new String(this.Cyz, 0, this.field_channelStatLength))));
    getChannelReport(this.Cyz, this.Cyz.length);
    localObject = new String(this.Cyz, 0, this.field_channelReportLength);
    f.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(115269);
    return localObject;
  }
  
  final String eCd()
  {
    AppMethodBeat.i(115271);
    getEngine2ndInfo(this.CyC, this.CyC.length);
    f.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.uXg + "," + this.roomId + "," + this.uXn + new String(this.CyC, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.CyC, this.CyC.length);
    String str = this.uXg + "," + this.roomId + "," + this.uXn + new String(this.CyC, 0, this.field_engine2ndReportLength);
    f.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115271);
    return str;
  }
  
  public final String eCe()
  {
    AppMethodBeat.i(115272);
    int i = cpuFlag0;
    String str = eBR() + "," + this.Cxt + "," + (i & 0xFF) + eCa() + "," + this.Cxk;
    AppMethodBeat.o(115272);
    return str;
  }
  
  public final boolean eCf()
  {
    return this.iys;
  }
  
  public final int eCh()
  {
    AppMethodBeat.i(115278);
    this.netType = f.getNetType(ak.getContext());
    if (this.netType == 5) {
      this.netType = 4;
    }
    this.CxR = new int[this.defaultWidth * this.defaultHeight];
    g.ajP();
    this.pnU = com.tencent.mm.kernel.a.getUin();
    int i = m.aao();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.pnU, k << 24 | j << 16 | i, com.tencent.mm.loader.j.b.asa() + "lib/", 4, 0L);
    f.Logd("MicroMsg.Voip", "protocal init ret :" + i + ",uin= " + this.pnU);
    this.iys = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(115278);
    return i;
  }
  
  public final String eCj()
  {
    AppMethodBeat.i(115281);
    String str = eBS();
    AppMethodBeat.o(115281);
    return str;
  }
  
  public final String[] eCk()
  {
    AppMethodBeat.i(115282);
    String[] arrayOfString = getNatReport();
    f.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      f.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115282);
    return arrayOfString;
  }
  
  public final String[] eCl()
  {
    AppMethodBeat.i(115283);
    String[] arrayOfString = getMPDirectReport();
    f.Loge("MicroMsg.Voip", "direct_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      f.Loge("MicroMsg.Voip", "direct_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115283);
    return arrayOfString;
  }
  
  public final String[] eCm()
  {
    AppMethodBeat.i(115284);
    String[] arrayOfString = getMPRelayReport();
    f.Loge("MicroMsg.Voip", "relay_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      f.Loge("MicroMsg.Voip", "relay_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115284);
    return arrayOfString;
  }
  
  public final String[] eCn()
  {
    AppMethodBeat.i(115285);
    String[] arrayOfString = getMPEngineReport();
    f.Loge("MicroMsg.Voip", "engine_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = (this.uXg + "," + this.uXn + arrayOfString[i]);
      f.Loge("MicroMsg.Voip", "engine_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115285);
    return arrayOfString;
  }
  
  public final String eCo()
  {
    AppMethodBeat.i(115286);
    String str = eCc();
    AppMethodBeat.o(115286);
    return str;
  }
  
  public final int erf()
  {
    AppMethodBeat.i(115279);
    this.netType = f.getNetType(ak.getContext());
    this.CwF = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool4;
    boolean bool5;
    label90:
    boolean bool6;
    label110:
    int i;
    label129:
    boolean bool7;
    label201:
    boolean bool8;
    label274:
    int j;
    label286:
    boolean bool9;
    label299:
    boolean bool10;
    label311:
    int k;
    label322:
    int m;
    label334:
    boolean bool1;
    label346:
    label381:
    boolean bool2;
    label401:
    boolean bool3;
    label421:
    boolean bool11;
    label429:
    Object localObject;
    if ((this.CwF >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool4 = true;
      if ((!bool4) || ((cpuFlag0 & 0xFF) < 30)) {
        break label1147;
      }
      bool5 = true;
      if ((!bool5) || ((cpuFlag0 & 0xFF) < 60)) {
        break label1153;
      }
      bool6 = true;
      if ((!bool6) || ((cpuFlag0 & 0xFF) < 71)) {
        break label1159;
      }
      i = 1;
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaM <= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gan.width < 480) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gan.height < 360) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.width < 480) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.height < 360)) {
        break label1164;
      }
      bool7 = true;
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaM < 2) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gan.width < 640) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gan.height < 480) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.width < 640) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.height < 480)) {
        break label1170;
      }
      bool8 = true;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaM != 2) {
        break label1176;
      }
      j = 1;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaM < 4) {
        break label1181;
      }
      bool9 = true;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaM != 0) {
        break label1187;
      }
      bool10 = true;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaN != 0) {
        break label1193;
      }
      k = 1;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaN <= 0) {
        break label1198;
      }
      m = 1;
      if ((i == 0) || (!bool9)) {
        break label1204;
      }
      bool1 = true;
      CwC = bool1;
      CwD = 0;
      this.peH = false;
      if (k != 0) {
        break label1275;
      }
      if ((!bool5) || (!asz("video/avc"))) {
        break label1210;
      }
      bool1 = true;
      if (m == 0) {
        break label1265;
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaN & 0x10) == 0) {
        break label1216;
      }
      bool2 = true;
      if ((!bool1) || ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaN & 0xF) == 0)) {
        break label1222;
      }
      bool3 = true;
      if (!bool3) {
        break label1228;
      }
      bool11 = true;
      this.peH = bool11;
      localObject = new StringBuilder("hwH264Local:").append(bool1).append(",hwHEVCLocal:false, bSupportH264HW:").append(bool3).append(", bSupportHEVCSW:").append(bool2).append(", bSupportHEVCHW:false, svrHWCfg:").append(com.tencent.mm.compatible.deviceinfo.ae.geM.gaN).append(", 720p jcchen ").append(bool6).append("-");
      if (j != 0) {
        break label1234;
      }
      bool1 = true;
      label513:
      f.Logi("MicroMsg.Voip", bool1 + "-" + bool9 + "-" + CwC + " svr 480p:" + com.tencent.mm.compatible.deviceinfo.ae.geM.gaM);
      if (!bool3) {
        break label1260;
      }
      i = 1;
      label574:
      if (!bool2) {
        break label1257;
      }
      i |= 0x2;
    }
    for (;;)
    {
      if (((bool4) || (bool7)) && (!bool10))
      {
        if ((!this.peH) && (!bool8)) {
          break label1240;
        }
        this.defaultWidth = 640;
        this.defaultHeight = 480;
        if ((bool6) && (j == 0)) {
          this.defaultWidth = 1280;
        }
      }
      for (this.defaultHeight = 720;; this.defaultHeight = 360)
      {
        CwB = true;
        f.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        f.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool4 + ", bEnable480FromSvr:" + bool7 + ", bDisable480FromSvr:" + bool10 + ", bEnable640FromLocal:" + bool5 + ", bEnable640FromSvr:" + bool8);
        this.CxR = new int[this.defaultWidth * this.defaultHeight];
        g.ajP();
        this.pnU = com.tencent.mm.kernel.a.getUin();
        k = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        localObject = ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay();
        m = ((Display)localObject).getWidth();
        int n = ((Display)localObject).getHeight();
        long l2 = 0L;
        int i1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKM, -1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i1) });
        int i2 = com.tencent.mm.compatible.deviceinfo.ae.geN.fZa;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", new Object[] { Integer.valueOf(i2) });
        long l1 = l2;
        if (i1 > 0)
        {
          l1 = l2;
          if (i2 > 0)
          {
            l1 = (i1 * 100000.0D) + 456L;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip", "kerrizhang typectrl %d", new Object[] { Long.valueOf(l1) });
          }
        }
        i1 = this.netType;
        i2 = this.defaultWidth;
        k = init(i << 8 | i1, 2, this.defaultHeight | i2 << 16, m << 16 | n, this.pnU, j << 24 | k << 16 | cpuFlag0, com.tencent.mm.loader.j.b.asa() + "lib/", 0, l1);
        f.Logi("MicroMsg.Voip", "protocal init ret :" + k + ",uin= " + this.pnU + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i);
        this.iys = true;
        if (k < 0) {
          reset();
        }
        AppMethodBeat.o(115279);
        return k;
        bool4 = false;
        break;
        label1147:
        bool5 = false;
        break label90;
        label1153:
        bool6 = false;
        break label110;
        label1159:
        i = 0;
        break label129;
        label1164:
        bool7 = false;
        break label201;
        label1170:
        bool8 = false;
        break label274;
        label1176:
        j = 0;
        break label286;
        label1181:
        bool9 = false;
        break label299;
        label1187:
        bool10 = false;
        break label311;
        label1193:
        k = 0;
        break label322;
        label1198:
        m = 0;
        break label334;
        label1204:
        bool1 = false;
        break label346;
        label1210:
        bool1 = false;
        break label381;
        label1216:
        bool2 = false;
        break label401;
        label1222:
        bool3 = false;
        break label421;
        label1228:
        bool11 = false;
        break label429;
        label1234:
        bool1 = false;
        break label513;
        label1240:
        this.defaultWidth = 480;
      }
      label1257:
      continue;
      label1260:
      i = 0;
      break label574;
      label1265:
      bool2 = false;
      bool3 = bool1;
      break label421;
      label1275:
      i = 0;
    }
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
    f.Logd("MicroMsg.VoipService", "callByJni : arg1:" + paramInt1 + " arg2:" + paramInt2);
    if (paramInt1 == 100)
    {
      f.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      AppMethodBeat.o(115274);
      return 0;
    }
    if (paramInt1 == 101)
    {
      f.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
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
      f.Logd("MicroMsg.VoipService", "callByJniInt : arg1:" + paramInt1 + " arg2:" + paramInt2);
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
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.Voip", "v2protocal reset!", new Object[0]);
    eBX();
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.roomId = 0;
    this.CwH = 0L;
    this.CwG = 0;
    this.uXn = 0;
    this.uXg = 0L;
    this.channelStrategy = 0;
    this.uXi = 0;
    this.icx = 0L;
    this.CwI = null;
    this.CwJ = null;
    this.CwK = null;
    this.CwL = 0;
    this.CwM = null;
    this.CxV = 0;
    this.CxW = null;
    this.CxX = 0;
    this.CxY = 0;
    this.CwR = null;
    this.CwS = null;
    this.Cyd = null;
    this.Cye = null;
    this.Cyk = null;
    this.Cyl = null;
    this.Cym = null;
    this.Cyr = 0;
    this.Cys = 0;
    this.Cyt = 0;
    this.Cyu = 0;
    this.Cyv = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.CyG = 0;
    this.Cxw = 0;
    this.Cxv = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.CwY = 0;
    this.CwZ = 0;
    this.Cxa = 65536;
    this.Cxb = 0;
    this.Cxc = 0;
    this.Cxd = 0;
    this.Cxk = -1;
    this.Cxt = 0;
    this.Cyh = 0;
    this.CwE = 0;
    this.gpK = "";
    this.Cyf = 0;
    this.Cyg = 0;
    this.CyH.reset();
    this.CyH.eAg();
    CwB = false;
    CwD = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.Cxn = 0;
    this.Cxo = 0;
    this.Cxp = 0;
    this.Cxq = 0;
    Cxr = 0;
    this.Cxs = "";
    this.CyI = 0;
    int i = freeJNIReport();
    f.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
    AppMethodBeat.o(115287);
  }
  
  public native int setActive();
  
  public final int setAppCmd(int paramInt)
  {
    AppMethodBeat.i(115259);
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      f.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
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
  
  public final String tx(boolean paramBoolean)
  {
    AppMethodBeat.i(115280);
    if (this.iys)
    {
      f.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.CyH.CtD;
      this.field_ChannelReportDial[1] = this.CyH.CtJ;
      this.field_ChannelReportDial[2] = this.CxS;
      this.field_ChannelReportDial[3] = this.CxT;
      this.field_ChannelReportDial[4] = this.CxU;
      this.field_ChannelReportDial[5] = this.CxV;
      this.field_EngineReportStatFromApp = new int[14];
      eCa();
      this.field_EngineReportStatFromApp[0] = this.CwY;
      this.field_EngineReportStatFromApp[1] = this.CwZ;
      this.field_EngineReportStatFromApp[2] = this.Cxf;
      this.field_EngineReportStatFromApp[3] = this.Cxg;
      this.field_EngineReportStatFromApp[4] = this.Cxe;
      this.field_EngineReportStatFromApp[5] = this.Cxh;
      this.field_EngineReportStatFromApp[6] = this.Cxi;
      this.field_EngineReportStatFromApp[7] = -1;
      if (this.CyK != null)
      {
        this.field_EngineReportStatFromApp[8] = this.CyK.pdj;
        this.field_EngineReportStatFromApp[9] = this.CyK.pdl;
        this.field_EngineReportStatFromApp[10] = this.CyK.pdb;
        if (CyL == null) {
          break label1116;
        }
        this.field_EngineReportStatFromApp[11] = CyL.wqq;
      }
      for (;;)
      {
        this.field_EngineReportStatFromApp[12] = this.Cyi;
        this.field_EngineReportStatFromApp[13] = this.Cyj;
        this.iys = false;
        uninit(this.roomId, this.uXg, this.uXn);
        CwB = false;
        CwD = 0;
        if (this.CyK != null)
        {
          this.CyK.dsq();
          this.CyK = null;
        }
        if (CyL != null)
        {
          CyL.interrupt();
          CyL.dsq();
          CyL = null;
        }
        if (CyN != null) {
          CyN.release();
        }
        CyN = null;
        f.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1127;
        }
        getStatInfo(this.Cyw, this.Cyw.length, this.CyF, 30);
        getEngineVersionInfo(this.Cyx, this.Cyx.length);
        getEngineQosInfo(this.Cyy, this.Cyy.length);
        Object localObject1 = new StringBuilder();
        long l = this.pnU;
        if (this.pnU < 0) {
          l = this.pnU + 4294967296L;
        }
        Object localObject2 = new StringBuilder().append(l).append(",").append(this.uXg).append(",").append(this.roomId).append(",").append(this.uXn).append(",");
        o localo = this.CyH;
        localObject2 = new StringBuilder().append(localo.Ctt).append(",").append(localo.Ctu).append(",").append(localo.Ctv).append(",").append(localo.Ctw).append(",").append(localo.Ctx).append(",").append(localo.Cty).append(",").append(localo.Ctz).append(",").append(localo.CtA).append(",").append(localo.CtB).append(",").append(localo.CtC).append(",").append(localo.CtD).toString();
        f.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.Cyw, 0, this.field_statInfoLength)).append(eBR()).append(eBT());
        localObject2 = this.CyH;
        localObject1 = ((StringBuilder)localObject1).append("," + ((o)localObject2).CtE).append(new String(this.Cyx, 0, this.field_engineVersionStatLength)).append(eBU());
        f.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + eBY() + eBZ() + new String(this.Cyy, 0, this.field_engineQosStatLength);
        f.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.Cyw, 0, this.field_statInfoLength));
        f.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.Cyx, 0, this.field_engineVersionStatLength));
        f.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.Cyy, 0, this.field_engineQosStatLength));
        f.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        au.a.hIH.db(this.field_netFlowRecv, this.field_netFlowSent);
        f.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
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