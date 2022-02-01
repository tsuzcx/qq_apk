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
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.protocal.protobuf.dyt;
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
  public static int CfQ;
  public static boolean Cfa;
  public static boolean Cfb;
  public static int Cfc;
  private static int CgM;
  public static d Chk;
  public static Surface Chm;
  public static com.tencent.mm.media.g.d Chn;
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  protected static int cpuFlag0;
  public static SurfaceTexture mSurfaceTexture;
  public int CfA;
  public int CfB;
  public int CfC;
  public int CfD;
  public int CfE;
  public int CfF;
  public int CfG;
  public int CfH;
  public int CfI;
  public int CfJ;
  public int CfK;
  public int CfL;
  public int CfM;
  public int CfN;
  public int CfO;
  public int CfP;
  public String CfR;
  public int CfS;
  public int CfT;
  public int CfU;
  public int CfV;
  public int CfW;
  public int CfX;
  public int CfY;
  public int CfZ;
  public int Cfd;
  public int Cfe;
  public int Cff;
  public long Cfg;
  public byte[] Cfh;
  public volatile byte[] Cfi;
  public byte[] Cfj;
  public int Cfk;
  public byte[] Cfl;
  public int Cfm;
  public int Cfn;
  public int Cfo;
  public int Cfp;
  public byte[] Cfq;
  public byte[] Cfr;
  public byte[] Cfs;
  public int Cft;
  public int Cfu;
  public int Cfv;
  public int Cfw;
  public int Cfx;
  public int Cfy;
  public int Cfz;
  public byte[] CgA;
  public int CgB;
  public byte[] CgC;
  public byte[] CgD;
  public int CgE;
  public int CgF;
  public int CgG;
  public int CgH;
  public int CgI;
  public byte[] CgJ;
  public byte[] CgK;
  public byte[] CgL;
  public ArrayBlockingQueue<byte[]> CgN;
  long CgO;
  public byte[] CgP;
  public int CgQ;
  public int CgR;
  public int CgS;
  public int CgT;
  public int CgU;
  byte[] CgV;
  byte[] CgW;
  byte[] CgX;
  byte[] CgY;
  byte[] CgZ;
  public int Cga;
  public int Cgb;
  public int Cgc;
  public int Cgd;
  public int Cge;
  public int Cgf;
  public int Cgg;
  public int Cgh;
  public int Cgi;
  public int Cgj;
  public int Cgk;
  public int Cgl;
  public int Cgm;
  public int Cgn;
  public int Cgo;
  public int Cgp;
  public int[] Cgq;
  public int Cgr;
  public int Cgs;
  public int Cgt;
  public int Cgu;
  public byte[] Cgv;
  public int Cgw;
  public int Cgx;
  public int Cgy;
  public int Cgz;
  byte[] Cha;
  byte[] Chb;
  public byte[] Chc;
  public byte[] Chd;
  public int[] Che;
  int Chf;
  public o Chg;
  public int Chh;
  private int Chi;
  public volatile e Chj;
  int Chl;
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
  public String gno;
  public long hZF;
  private ap handler;
  public int height;
  protected boolean ivz;
  public int netType;
  public boolean oYd;
  public int pho;
  public int roomId;
  public int uLA;
  public long uLt;
  public int uLv;
  public int width;
  
  static
  {
    AppMethodBeat.i(115291);
    v2protocal.class.getClassLoader();
    j.vr("voipMain");
    int i = m.aaf();
    cpuFlag0 = i;
    if ((i & 0x400) != 0) {}
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      Cfa = false;
      Cfb = false;
      Cfc = 0;
      CfQ = 0;
      CgM = 10;
      Chk = null;
      Chm = null;
      Chn = null;
      AppMethodBeat.o(115291);
      return;
    }
  }
  
  public v2protocal(ap paramap)
  {
    AppMethodBeat.i(115273);
    this.hZF = 0L;
    this.defaultWidth = 320;
    this.defaultHeight = 240;
    this.netType = 0;
    this.Cfd = 0;
    this.pho = 0;
    this.gno = "";
    this.Cfe = 0;
    this.Cff = 0;
    this.roomId = 0;
    this.Cfg = 0L;
    this.uLA = 0;
    this.uLt = 0L;
    this.uLv = 0;
    this.Cfh = null;
    this.Cfi = null;
    this.Cfj = null;
    this.Cfk = 0;
    this.Cfl = null;
    this.channelStrategy = 0;
    this.Cfm = 500;
    this.Cfn = 30;
    this.Cfo = 999;
    this.Cfp = 0;
    this.Cfq = null;
    this.Cfr = null;
    this.Cfs = new byte[10];
    this.Cft = 20;
    this.Cfu = 0;
    this.Cfv = 0;
    this.Cfw = 0;
    this.Cfx = 0;
    this.Cfy = 0;
    this.Cfz = 65536;
    this.CfA = 0;
    this.CfB = 0;
    this.CfC = 0;
    this.CfD = 7;
    this.CfE = 3;
    this.CfF = 3;
    this.CfG = 0;
    this.CfH = 0;
    this.CfI = -1;
    this.CfJ = -1;
    this.CfK = 0;
    this.CfL = 0;
    this.CfM = 0;
    this.CfN = 0;
    this.CfO = 0;
    this.CfP = 0;
    this.CfR = "";
    this.CfS = 0;
    this.CfT = 0;
    this.CfU = 0;
    this.CfV = 0;
    this.CfW = 100;
    this.CfX = 300;
    this.CfY = 1;
    this.CfZ = 1;
    this.Cga = 0;
    this.Cgb = 1;
    this.Cgc = 0;
    this.Cgd = 0;
    this.Cge = 0;
    this.Cgf = 0;
    this.Cgg = 0;
    this.Cgh = 0;
    this.Cgi = 0;
    this.Cgj = 0;
    this.Cgk = 0;
    this.Cgl = 0;
    this.Cgm = 0;
    this.Cgn = 0;
    this.Cgo = 0;
    this.Cgp = 0;
    this.Cgq = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.field_ChannelReportDial = null;
    this.field_EngineReportStatFromApp = null;
    this.field_mGetValidSample = 0;
    this.Cgr = 0;
    this.Cgs = 0;
    this.Cgt = 0;
    this.Cgu = 0;
    this.Cgv = null;
    this.Cgw = 0;
    this.Cgx = 0;
    this.Cgy = 0;
    this.Cgz = 0;
    this.CgA = new byte[1500];
    this.CgB = 0;
    this.CgC = null;
    this.CgD = null;
    this.CgE = 0;
    this.CgF = 0;
    this.CgG = 0;
    this.CgH = 0;
    this.CgI = 0;
    this.CgJ = null;
    this.CgK = null;
    this.CgL = null;
    this.CgN = new ArrayBlockingQueue(CgM);
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
    this.CgO = 0L;
    this.CgP = new byte[8];
    this.CgQ = 0;
    this.CgR = 0;
    this.CgS = 0;
    this.CgT = 0;
    this.CgU = 0;
    this.CgV = new byte[4096];
    this.CgW = new byte[2048];
    this.CgX = new byte[2048];
    this.CgY = new byte[4096];
    this.CgZ = new byte[4096];
    this.Cha = new byte[2048];
    this.Chb = new byte[4096];
    this.Chc = new byte[2048];
    this.Chd = new byte[2048];
    this.Che = new int[30];
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
    this.Chf = 0;
    this.Chg = new o();
    this.Chh = 0;
    this.Chi = 0;
    this.handler = null;
    this.ivz = false;
    this.Chj = null;
    this.width = 640;
    this.height = 480;
    this.Chl = 8;
    this.bitrate = 300;
    this.oYd = false;
    this.handler = paramap;
    AppMethodBeat.o(115273);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean arr(String paramString)
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
  
  public static long bU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115262);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    long l = paramArrayOfByte.getLong();
    AppMethodBeat.o(115262);
    return l;
  }
  
  public static String eyA()
  {
    return "";
  }
  
  private static String eyj()
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
  
  private String eyk()
  {
    long l3 = 0L;
    AppMethodBeat.i(115263);
    if ((this.Cfv == 0) && (this.Cfw == 0))
    {
      this.Chg.Ccj = 0;
      this.Chg.Ccr = f.getNetType(aj.getContext());
      this.Chg.Ccq = this.field_videoDuration;
      this.Chg.Ccp = this.field_audioDuration;
      this.CfA = com.tencent.mm.plugin.audio.c.a.bGF();
      if ((this.Chg.Ccz <= 0L) || (this.Chg.Cct <= this.Chg.Ccz)) {
        break label1475;
      }
    }
    label1475:
    for (long l1 = this.Chg.Cct - this.Chg.Ccz;; l1 = 0L)
    {
      f.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(l1)));
      setJNIAppCmd(1, this.CgP, this.CgP.length);
      long l4 = bU(this.CgP);
      Object localObject1 = this.Chg;
      if ((l4 > this.Chg.Ccx) && (this.Chg.Ccx > 0L)) {}
      for (long l2 = l4 - this.Chg.Ccx;; l2 = 0L)
      {
        ((o)localObject1).CcA = l2;
        localObject1 = this.Chg;
        l2 = l3;
        if (l4 > this.Chg.Ccz)
        {
          l2 = l3;
          if (this.Chg.Ccz > 0L) {
            l2 = l4 - this.Chg.Ccz;
          }
        }
        ((o)localObject1).CcB = l2;
        f.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.Chg.CcA + " lCalledWaitTime:" + this.Chg.CcB);
        int i = cpuFlag0;
        boolean bool = com.tencent.mm.plugin.voip.c.euO();
        int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHE, 0);
        StringBuilder localStringBuilder = new StringBuilder().append(this.Cfu).append(",").append(this.roomId).append(",").append(this.uLt).append(",").append(this.uLA).append(",").append(this.Chg.CbS).append(",").append(this.Chg.Cce).append(",").append(this.Chg.Ccf).append(",").append(this.Chg.Ccg).append(",").append(this.Chg.Cch).append(",").append(this.Chg.Cci).append(",").append(this.Chg.Ccj).append(",").append(this.Chg.Ccc).append(",").append(this.Chg.Cck).append(",").append(this.Chg.Ccl).append(",").append(this.Chg.Ccm).append(",").append(this.Chg.Ccn).append(",").append(this.Chg.Cco).append(",").append(this.Chg.Ccp).append(",").append(this.Chg.Ccq).append(",").append(this.Chg.Ccr).append(eyq()).append(eyr()).append(eyj()).append(",").append(this.Chg.Ccs).append(",").append(this.Cfz).append(",").append(this.CfA).append(",").append(l1).append(",").append(this.Chg.CcA).append(",").append(this.Chg.CcB).append(",").append(this.CfB).append(",").append(this.Cfe).append(eyl()).append(",").append(i & 0xFF).append(",").append(this.CfI).append(",").append(this.CfJ);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.Chg.Ccu + "," + this.Chg.Ccw + "," + this.Chg.Ccv + ",0," + this.Chg.CcC + "," + this.Chg.BZo + "," + this.Chg.BZp + "," + this.Chg.CcD + ",0,0,0," + this.CfK + "," + this.CfL + "," + this.CfC + "," + this.CfM + "," + this.CfN + "," + this.CfO + "," + this.Chh + "," + this.CfR + "," + this.CfP + "," + CfQ + "," + j + "," + bool;
        f.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.Cfe);
        f.Logi("MicroMsg.Voip", ":".concat(String.valueOf(localObject1)));
        f.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + eyl());
        f.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.Chg.BZo + ",lInterruptEndTime:" + this.Chg.BZp + ",mIinterruptCnt:" + this.Chg.CcD + ",iPlayMinBufSize:" + this.CfK + ",iRecordMinBufSize:" + this.CfL);
        f.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.Chh);
        AppMethodBeat.o(115263);
        return localObject1;
        if ((this.Cfw != 0) && (this.Cfv != 0))
        {
          this.Chg.Ccj = 3;
          break;
        }
        if (this.Cfw != 0)
        {
          this.Chg.Ccj = 1;
          break;
        }
        if (this.Cfv == 0) {
          break;
        }
        this.Chg.Ccj = 2;
        break;
      }
    }
  }
  
  private String eyl()
  {
    AppMethodBeat.i(115264);
    String str = "," + this.channelStrategy;
    AppMethodBeat.o(115264);
    return str;
  }
  
  private void eyp()
  {
    AppMethodBeat.i(184064);
    if ((this.CgQ <= 0) || (this.field_videoDuration <= 0))
    {
      AppMethodBeat.o(184064);
      return;
    }
    this.Chi = (this.CgQ / this.field_videoDuration);
    ad.i("MicroMsg.Voip", "calcCpatureFps:%s", new Object[] { Integer.valueOf(this.Chi) });
    AppMethodBeat.o(184064);
  }
  
  private String eyq()
  {
    AppMethodBeat.i(115266);
    f.Logd("MicroMsg.Voip", "usePreConnect:" + this.CfU);
    String str = "," + this.CfU;
    AppMethodBeat.o(115266);
    return str;
  }
  
  private String eyr()
  {
    AppMethodBeat.i(115267);
    f.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.CfV);
    String str = "," + this.CfV;
    AppMethodBeat.o(115267);
    return str;
  }
  
  private String eys()
  {
    AppMethodBeat.i(115268);
    this.CfE = com.tencent.mm.plugin.audio.c.a.bGC().audioManager.getMode();
    this.CfF = com.tencent.mm.plugin.audio.c.a.bGC().audioManager.getMode();
    if (ae.gcF.fWH >= 0) {
      this.CfE = ae.gcF.fWH;
    }
    if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.k.Xm()) && (2 == ae.gcP.fZg)) {
      this.CfF = 2;
    }
    if (ae.gcF.fWI >= 0) {
      this.CfF = ae.gcF.fWI;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      this.CfD = 1;
      if (ae.gcF.fWh) {
        this.CfD = 1;
      }
      if (ae.gcF.fWG >= 0) {
        this.CfD = ae.gcF.fWG;
      }
      if (ae.gcF.fWi <= 0) {
        break label292;
      }
      this.CfG = 3;
      this.CfH = 0;
    }
    for (;;)
    {
      if (ae.gcF.fWK >= 0) {
        this.CfG = ae.gcF.fWK;
      }
      if (ae.gcF.fWL >= 0) {
        this.CfH = ae.gcF.fWL;
      }
      String str = "," + this.CfE + "," + this.CfF + "," + this.CfD + "," + this.CfG + "," + this.CfH;
      AppMethodBeat.o(115268);
      return str;
      this.CfD = 7;
      break;
      label292:
      if (ae.gcF.fWJ >= 0)
      {
        this.CfG = ae.gcF.fWJ;
        this.CfH = ae.gcF.fWJ;
      }
    }
  }
  
  private String eyu()
  {
    AppMethodBeat.i(115270);
    getNewEngineInfo(this.CgZ, this.CgZ.length);
    getNewEngineExtInfo(this.Cha, this.Cha.length);
    f.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.uLA + "," + this.uLt + this.Chg.ewA() + "," + this.Cfv + "," + this.Cfw + eym() + new String(this.CgZ, 0, this.field_newEngineStatLength) + "," + this.Cfx + "," + this.Cfy + eys() + new String(this.Cha, 0, this.field_newEngineExtStatLength))));
    getNewEngineInfoReport(this.CgZ, this.CgZ.length);
    String str = this.uLA + "," + this.uLt + this.Chg.ewA() + "," + this.Cfv + "," + this.Cfw + eym() + new String(this.CgZ, 0, this.field_newEngineReportLength);
    f.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115270);
    return str;
  }
  
  public static int eyy()
  {
    AppMethodBeat.i(115276);
    DhcpInfo localDhcpInfo = ((WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
    f.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(localDhcpInfo.gateway))));
    int i = localDhcpInfo.gateway;
    AppMethodBeat.o(115276);
    return i;
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
      parama.BXy = localAtomicInteger2.get();
      parama.xbF = localAtomicInteger1.get();
      parama.BXx = 0;
      f.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + j + ",samplerate = " + parama.xbF + ", framelenms =" + parama.BXy + ", channels =" + parama.channels);
      AppMethodBeat.o(115289);
      return j;
    }
    if ((m.aaf() & 0x400) != 0) {}
    for (int i = 16000;; i = 8000)
    {
      parama.xbF = i;
      parama.channels = 1;
      parama.BXy = 20;
      parama.BXx = 0;
      break;
    }
  }
  
  public final int a(dyt paramdyt)
  {
    AppMethodBeat.i(115260);
    if (this.CgO != 0L)
    {
      f.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      AppMethodBeat.o(115260);
      return -1;
    }
    this.CgO = paramdyt.HMb;
    dya localdya = new dya();
    localdya.HKv = paramdyt.HMb;
    int i = 0;
    while (i < paramdyt.HMg)
    {
      dyd localdyd = new dyd();
      localdyd.HAu = ((dhy)paramdyt.HMh.get(i)).Hwf.HAx;
      localdyd.port = ((dhy)paramdyt.HMh.get(i)).Hwf.HfV;
      localdyd.CnV = ((dhy)paramdyt.HMh.get(i)).Hwe;
      localdyd.gap = ((dhy)paramdyt.HMh.get(i)).HwK;
      localdyd.timeout = ((dhy)paramdyt.HMh.get(i)).HwL;
      localdyd.HKP = ((dhy)paramdyt.HMh.get(i)).HwM;
      localdya.HKw.add(localdyd);
      i += 1;
    }
    try
    {
      f.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(localdya.toByteArray(), localdya.toByteArray().length))));
      AppMethodBeat.o(115260);
      return 0;
    }
    catch (IOException paramdyt)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Voip", paramdyt, "StartVoipSpeedTest exception", new Object[0]);
      }
    }
  }
  
  public final int aY(LinkedList<cbv> paramLinkedList)
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
        cbv localcbv = new cbv();
        localcbv.GAC = new String(arrayOfByte2, 0, ((AtomicInteger)localObject).get());
        localcbv.GVI = localAtomicInteger5.get();
        localcbv.GVK = localAtomicInteger4.get();
        paramLinkedList.add(localcbv);
      }
      if (localAtomicInteger1.get() > 0)
      {
        localObject = new cbv();
        ((cbv)localObject).GAC = new String(arrayOfByte1, 0, localAtomicInteger1.get());
        ((cbv)localObject).GVI = localAtomicInteger3.get();
        ((cbv)localObject).GVK = localAtomicInteger2.get();
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
  
  public final int eny()
  {
    AppMethodBeat.i(115279);
    this.netType = f.getNetType(aj.getContext());
    this.Cfe = this.netType;
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
    if ((this.Cfe >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
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
      if ((ae.gcE.fYF <= 0) || (ae.gcE.fYh.width < 480) || (ae.gcE.fYh.height < 360) || (ae.gcE.fYj.width < 480) || (ae.gcE.fYj.height < 360)) {
        break label1164;
      }
      bool7 = true;
      if ((ae.gcE.fYF < 2) || (ae.gcE.fYh.width < 640) || (ae.gcE.fYh.height < 480) || (ae.gcE.fYj.width < 640) || (ae.gcE.fYj.height < 480)) {
        break label1170;
      }
      bool8 = true;
      if (ae.gcE.fYF != 2) {
        break label1176;
      }
      j = 1;
      if (ae.gcE.fYF < 4) {
        break label1181;
      }
      bool9 = true;
      if (ae.gcE.fYF != 0) {
        break label1187;
      }
      bool10 = true;
      if (ae.gcE.fYG != 0) {
        break label1193;
      }
      k = 1;
      if (ae.gcE.fYG <= 0) {
        break label1198;
      }
      m = 1;
      if ((i == 0) || (!bool9)) {
        break label1204;
      }
      bool1 = true;
      Cfb = bool1;
      Cfc = 0;
      this.oYd = false;
      if (k != 0) {
        break label1275;
      }
      if ((!bool5) || (!arr("video/avc"))) {
        break label1210;
      }
      bool1 = true;
      if (m == 0) {
        break label1265;
      }
      if ((ae.gcE.fYG & 0x10) == 0) {
        break label1216;
      }
      bool2 = true;
      if ((!bool1) || ((ae.gcE.fYG & 0xF) == 0)) {
        break label1222;
      }
      bool3 = true;
      if (!bool3) {
        break label1228;
      }
      bool11 = true;
      this.oYd = bool11;
      localObject = new StringBuilder("hwH264Local:").append(bool1).append(",hwHEVCLocal:false, bSupportH264HW:").append(bool3).append(", bSupportHEVCSW:").append(bool2).append(", bSupportHEVCHW:false, svrHWCfg:").append(ae.gcE.fYG).append(", 720p jcchen ").append(bool6).append("-");
      if (j != 0) {
        break label1234;
      }
      bool1 = true;
      label513:
      f.Logi("MicroMsg.Voip", bool1 + "-" + bool9 + "-" + Cfb + " svr 480p:" + ae.gcE.fYF);
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
        if ((!this.oYd) && (!bool8)) {
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
        Cfa = true;
        f.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        f.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool4 + ", bEnable480FromSvr:" + bool7 + ", bDisable480FromSvr:" + bool10 + ", bEnable640FromLocal:" + bool5 + ", bEnable640FromSvr:" + bool8);
        this.Cgq = new int[this.defaultWidth * this.defaultHeight];
        g.ajA();
        this.pho = com.tencent.mm.kernel.a.getUin();
        k = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        localObject = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
        m = ((Display)localObject).getWidth();
        int n = ((Display)localObject).getHeight();
        long l2 = 0L;
        int i1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDk, -1);
        ad.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", new Object[] { Integer.valueOf(i1) });
        int i2 = ae.gcF.fWU;
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
        k = init(i << 8 | i1, 2, this.defaultHeight | i2 << 16, m << 16 | n, this.pho, j << 24 | k << 16 | cpuFlag0, com.tencent.mm.loader.j.b.arL() + "lib/", 0, l1);
        f.Logi("MicroMsg.Voip", "protocal init ret :" + k + ",uin= " + this.pho + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i);
        this.ivz = true;
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
  
  public final String eyB()
  {
    AppMethodBeat.i(115281);
    String str = eyk();
    AppMethodBeat.o(115281);
    return str;
  }
  
  public final String[] eyC()
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
  
  public final String[] eyD()
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
  
  public final String[] eyE()
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
  
  public final String[] eyF()
  {
    AppMethodBeat.i(115285);
    String[] arrayOfString = getMPEngineReport();
    f.Loge("MicroMsg.Voip", "engine_report_string size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = (this.uLt + "," + this.uLA + arrayOfString[i]);
      f.Loge("MicroMsg.Voip", "engine_report_string:" + arrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(115285);
    return arrayOfString;
  }
  
  public final String eyG()
  {
    AppMethodBeat.i(115286);
    String str = eyu();
    AppMethodBeat.o(115286);
    return str;
  }
  
  protected final String eym()
  {
    AppMethodBeat.i(115265);
    if (this.field_videoDuration == 0)
    {
      f.Logd("MicroMsg.Voip", "captureFrames:" + this.CgQ + ", videoduration: 0");
      AppMethodBeat.o(115265);
      return ",0";
    }
    f.Logd("MicroMsg.Voip", "capturefps:" + this.CgQ / this.field_videoDuration + " framecount:" + this.CgQ + " videoDuration:" + this.field_videoDuration);
    String str = "," + this.CgQ / this.field_videoDuration;
    AppMethodBeat.o(115265);
    return str;
  }
  
  public final int eyn()
  {
    if (this.Chi > 0) {
      return this.Chi;
    }
    if (this.field_videoDuration == 0) {
      return 0;
    }
    return this.CgQ / this.field_videoDuration;
  }
  
  public final void eyo()
  {
    AppMethodBeat.i(216443);
    this.Chi = 0;
    ad.i("MicroMsg.Voip", "resetCaptureFps");
    AppMethodBeat.o(216443);
  }
  
  final String eyt()
  {
    AppMethodBeat.i(115269);
    getChannelInfo(this.CgY, this.CgY.length, this.Cgr, this.Cgs, this.Cgt, this.Cgu);
    Object localObject = new StringBuilder().append(this.uLt).append(",").append(this.roomId).append(",").append(this.uLA).append(this.Chg.ewA());
    o localo = this.Chg;
    f.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(new StringBuilder(",").append(localo.Cci).toString() + new String(this.CgY, 0, this.field_channelStatLength))));
    getChannelReport(this.CgY, this.CgY.length);
    localObject = new String(this.CgY, 0, this.field_channelReportLength);
    f.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(115269);
    return localObject;
  }
  
  final String eyv()
  {
    AppMethodBeat.i(115271);
    getEngine2ndInfo(this.Chb, this.Chb.length);
    f.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.uLt + "," + this.roomId + "," + this.uLA + new String(this.Chb, 0, this.field_engine2ndStatLength))));
    getEngine2ndInfoReport(this.Chb, this.Chb.length);
    String str = this.uLt + "," + this.roomId + "," + this.uLA + new String(this.Chb, 0, this.field_engine2ndReportLength);
    f.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
    AppMethodBeat.o(115271);
    return str;
  }
  
  public final String eyw()
  {
    AppMethodBeat.i(115272);
    int i = cpuFlag0;
    String str = eyj() + "," + this.CfS + "," + (i & 0xFF) + eys() + "," + this.CfJ;
    AppMethodBeat.o(115272);
    return str;
  }
  
  public final boolean eyx()
  {
    return this.ivz;
  }
  
  public final int eyz()
  {
    AppMethodBeat.i(115278);
    this.netType = f.getNetType(aj.getContext());
    if (this.netType == 5) {
      this.netType = 4;
    }
    this.Cgq = new int[this.defaultWidth * this.defaultHeight];
    g.ajA();
    this.pho = com.tencent.mm.kernel.a.getUin();
    int i = m.aaf();
    int j = Build.VERSION.SDK_INT;
    int k = OpenGlRender.getGLVersion();
    Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int n = localDisplay.getHeight();
    i = init(this.netType, 65538, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.pho, k << 24 | j << 16 | i, com.tencent.mm.loader.j.b.arL() + "lib/", 4, 0L);
    f.Logd("MicroMsg.Voip", "protocal init ret :" + i + ",uin= " + this.pho);
    this.ivz = true;
    if (i < 0) {
      reset();
    }
    AppMethodBeat.o(115278);
    return i;
  }
  
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
    ad.m("MicroMsg.Voip", "v2protocal reset!", new Object[0]);
    eyp();
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.roomId = 0;
    this.Cfg = 0L;
    this.Cff = 0;
    this.uLA = 0;
    this.uLt = 0L;
    this.channelStrategy = 0;
    this.uLv = 0;
    this.hZF = 0L;
    this.Cfh = null;
    this.Cfi = null;
    this.Cfj = null;
    this.Cfk = 0;
    this.Cfl = null;
    this.Cgu = 0;
    this.Cgv = null;
    this.Cgw = 0;
    this.Cgx = 0;
    this.Cfq = null;
    this.Cfr = null;
    this.CgC = null;
    this.CgD = null;
    this.CgJ = null;
    this.CgK = null;
    this.CgL = null;
    this.CgQ = 0;
    this.CgR = 0;
    this.CgS = 0;
    this.CgT = 0;
    this.CgU = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.Chf = 0;
    this.CfV = 0;
    this.CfU = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.Cfx = 0;
    this.Cfy = 0;
    this.Cfz = 65536;
    this.CfA = 0;
    this.CfB = 0;
    this.CfC = 0;
    this.CfJ = -1;
    this.CfS = 0;
    this.CgG = 0;
    this.Cfd = 0;
    this.gno = "";
    this.CgE = 0;
    this.CgF = 0;
    this.Chg.reset();
    this.Chg.ewz();
    Cfa = false;
    Cfc = 0;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    this.CfM = 0;
    this.CfN = 0;
    this.CfO = 0;
    this.CfP = 0;
    CfQ = 0;
    this.CfR = "";
    this.Chh = 0;
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
  
  public final String tq(boolean paramBoolean)
  {
    AppMethodBeat.i(115280);
    if (this.ivz)
    {
      f.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(paramBoolean)));
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.Chg.Ccc;
      this.field_ChannelReportDial[1] = this.Chg.Cci;
      this.field_ChannelReportDial[2] = this.Cgr;
      this.field_ChannelReportDial[3] = this.Cgs;
      this.field_ChannelReportDial[4] = this.Cgt;
      this.field_ChannelReportDial[5] = this.Cgu;
      this.field_EngineReportStatFromApp = new int[14];
      eys();
      this.field_EngineReportStatFromApp[0] = this.Cfx;
      this.field_EngineReportStatFromApp[1] = this.Cfy;
      this.field_EngineReportStatFromApp[2] = this.CfE;
      this.field_EngineReportStatFromApp[3] = this.CfF;
      this.field_EngineReportStatFromApp[4] = this.CfD;
      this.field_EngineReportStatFromApp[5] = this.CfG;
      this.field_EngineReportStatFromApp[6] = this.CfH;
      this.field_EngineReportStatFromApp[7] = -1;
      if (this.Chj != null)
      {
        this.field_EngineReportStatFromApp[8] = this.Chj.oWG;
        this.field_EngineReportStatFromApp[9] = this.Chj.oWI;
        this.field_EngineReportStatFromApp[10] = this.Chj.oWy;
        if (Chk == null) {
          break label1116;
        }
        this.field_EngineReportStatFromApp[11] = Chk.waR;
      }
      for (;;)
      {
        this.field_EngineReportStatFromApp[12] = this.CgH;
        this.field_EngineReportStatFromApp[13] = this.CgI;
        this.ivz = false;
        uninit(this.roomId, this.uLt, this.uLA);
        Cfa = false;
        Cfc = 0;
        if (this.Chj != null)
        {
          this.Chj.dpf();
          this.Chj = null;
        }
        if (Chk != null)
        {
          Chk.interrupt();
          Chk.dpf();
          Chk = null;
        }
        if (Chm != null) {
          Chm.release();
        }
        Chm = null;
        f.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1127;
        }
        getStatInfo(this.CgV, this.CgV.length, this.Che, 30);
        getEngineVersionInfo(this.CgW, this.CgW.length);
        getEngineQosInfo(this.CgX, this.CgX.length);
        Object localObject1 = new StringBuilder();
        long l = this.pho;
        if (this.pho < 0) {
          l = this.pho + 4294967296L;
        }
        Object localObject2 = new StringBuilder().append(l).append(",").append(this.uLt).append(",").append(this.roomId).append(",").append(this.uLA).append(",");
        o localo = this.Chg;
        localObject2 = new StringBuilder().append(localo.CbS).append(",").append(localo.CbT).append(",").append(localo.CbU).append(",").append(localo.CbV).append(",").append(localo.CbW).append(",").append(localo.CbX).append(",").append(localo.CbY).append(",").append(localo.CbZ).append(",").append(localo.Cca).append(",").append(localo.Ccb).append(",").append(localo.Ccc).toString();
        f.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(localObject2)));
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.CgV, 0, this.field_statInfoLength)).append(eyj()).append(eyl());
        localObject2 = this.Chg;
        localObject1 = ((StringBuilder)localObject1).append("," + ((o)localObject2).Ccd).append(new String(this.CgW, 0, this.field_engineVersionStatLength)).append(eym());
        f.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + eyq() + eyr() + new String(this.CgX, 0, this.field_engineQosStatLength);
        f.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.CgV, 0, this.field_statInfoLength));
        f.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.CgW, 0, this.field_engineVersionStatLength));
        f.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.CgX, 0, this.field_engineQosStatLength));
        f.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(localObject1)));
        as.a.hFP.db(this.field_netFlowRecv, this.field_netFlowSent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */