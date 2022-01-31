package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.graphics.Matrix;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.e;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.cfk;
import com.tencent.mm.protocal.c.cfm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import junit.framework.Assert;

public class v2protocal
{
  public static final int VOICE_FRAME_BYTES;
  public static final int VOICE_SAMPLERATE;
  public static int cpuFlag0;
  private static final String[] pOW;
  public static boolean pUv;
  private static int pVO;
  public static c pWk;
  public static Surface pWm;
  public static WeakReference<com.tencent.mm.plugin.voip.video.e> rpQ;
  int bitrate = 300;
  public int channelStrategy = 0;
  public int defaultHeight = 240;
  public int defaultWidth = 320;
  public long enx = 0L;
  public int[] field_ChannelReportDial = null;
  public int[] field_EngineReportStatFromApp = null;
  public int field_HWEncH = 0;
  public int field_HWEncW = 0;
  public int[] field_SpeedTestSvrParaArray = null;
  public int field_audioDuration = 0;
  public byte[] field_capInfo = null;
  int field_channelReportLength = 0;
  int field_channelStatLength = 0;
  public int field_connectingStatusKey = 0;
  int field_engine2ndReportLength = 0;
  int field_engine2ndStatLength = 0;
  int field_engineQosStatLength = 0;
  int field_engineVersionStatLength = 0;
  public int[] field_jbmBitratRsSvrParamArray = null;
  public double[] field_jbmBitratRsSvrParamDoubleArray = null;
  public int field_jbmParamArraySize = 0;
  public int field_jbmParamDoubleArraySize = 0;
  public int field_localImgHeight = 0;
  public int field_localImgWidth = 0;
  public int field_mGetValidSample = 0;
  public int[] field_natSvrArray = null;
  int field_netFlowRecv = 0;
  int field_netFlowSent = 0;
  int field_newEngineExtStatLength = 0;
  int field_newEngineReportLength = 0;
  int field_newEngineStatLength = 0;
  public byte[] field_peerId = null;
  public int field_pstnChannelInfoLength = 0;
  public int field_pstnEngineInfoLength = 0;
  public int[] field_punchSvrArray = null;
  public int field_realLinkQualityInfoBuffLen = 0;
  public int field_recvVideoLen = 120;
  public int field_relayDataSyncKey = 0;
  public int[] field_relaySvrArray = null;
  public int[] field_relayTcpSvrArray = null;
  public int field_remoteImgHeight = 0;
  public int field_remoteImgLength = 0;
  public int field_remoteImgOrien = 0;
  public int field_remoteImgWidth = 0;
  public int field_sendVideoLen = 100;
  int field_speedTestInfoLength = 0;
  int field_statInfoLength = 0;
  public int field_statusSyncKey = 0;
  public int field_videoDuration = 0;
  private ah handler = null;
  public int height = 480;
  public boolean isInited = false;
  public String lFA = "";
  public int lpD = 0;
  public long lpE = 0L;
  public int lpG = 0;
  public int lpL = 0;
  public int netType = 0;
  public long pUA = 0L;
  public byte[] pUB = null;
  public byte[] pUC = null;
  public byte[] pUD = null;
  public int pUE = 0;
  public byte[] pUF = null;
  public int pUG = 500;
  public int pUH = 30;
  public int pUI = 999;
  public int pUJ = 0;
  public byte[] pUK = null;
  public int pUL = 20;
  public int pUM = 0;
  public int pUN = 0;
  public int pUO = 0;
  public int pUP = 0;
  public int pUQ = 0;
  public int pUR = 65536;
  public int pUS = 0;
  public int pUT = 0;
  public int pUU = 7;
  public int pUV = 3;
  public int pUW = 3;
  public int pUX = 0;
  public int pUY = 0;
  public int pUZ = -1;
  public int pUw = 0;
  public int pUx = 0;
  public int pUy = 0;
  public int pUz = 0;
  public byte[] pVA = null;
  public int pVB = 0;
  public int pVC = 0;
  public int pVD = 0;
  public int pVE = 0;
  public byte[] pVF = new byte[1500];
  public int pVG = 0;
  public byte[] pVH = null;
  public byte[] pVI = null;
  public int pVJ = 0;
  public int pVK = 0;
  public int pVL = 0;
  public int pVM = 0;
  public int pVN = 0;
  public ArrayBlockingQueue<byte[]> pVP = new ArrayBlockingQueue(pVO);
  public long pVQ = 0L;
  public byte[] pVR = new byte[8];
  public int pVS = 0;
  public int pVT = 0;
  public int pVU = 0;
  public int pVV = 0;
  public int pVW = 0;
  byte[] pVX = new byte[4096];
  byte[] pVY = new byte[2048];
  byte[] pVZ = new byte[2048];
  public int pVa = -1;
  public int pVb = 0;
  public int pVc = 0;
  public int pVd = 0;
  public int pVe = 0;
  public int pVf = 100;
  public int pVg = 300;
  public int pVh = 1;
  public int pVi = 1;
  public int pVj = 0;
  public int pVk = 1;
  public int pVl = 0;
  public int pVm = 0;
  public int pVn = 0;
  public int pVo = 0;
  public int pVp = 0;
  public int pVq = 0;
  public int pVr = 0;
  public int pVs = 0;
  public int pVt = 0;
  public int pVu = 0;
  public int[] pVv = null;
  public int pVw = 0;
  public int pVx = 0;
  public int pVy = 0;
  public int pVz = 0;
  byte[] pWa = new byte[4096];
  byte[] pWb = new byte[4096];
  byte[] pWc = new byte[2048];
  byte[] pWd = new byte[4096];
  public byte[] pWe = new byte[2048];
  public byte[] pWf = new byte[2048];
  public int[] pWg = new int[30];
  int pWh = 0;
  public m pWi = new m();
  public d pWj = null;
  int pWl = 8;
  public boolean pWn = false;
  public int width = 640;
  
  static
  {
    int i = com.tencent.mm.compatible.e.m.yR();
    if ((i & 0x400) != 0)
    {
      com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v7a.so");
      com.tencent.mm.compatible.util.k.b("voipMain", v2protocal.class.getClassLoader());
      i = com.tencent.mm.compatible.e.m.yR();
      cpuFlag0 = i;
      if ((i & 0x400) == 0) {
        break label157;
      }
    }
    label157:
    for (i = 16000;; i = 8000)
    {
      VOICE_SAMPLERATE = i;
      VOICE_FRAME_BYTES = i / 1000 * 20 * 2;
      pUv = false;
      pVO = 10;
      pWk = null;
      pWm = null;
      rpQ = null;
      pOW = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi" };
      return;
      if ((i & 0x200) != 0)
      {
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec.so");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
        break;
      }
      com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v5.so");
      Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      break;
    }
  }
  
  public v2protocal(ah paramah)
  {
    this.handler = paramah;
  }
  
  public static void a(com.tencent.mm.plugin.voip.video.e parame)
  {
    rpQ = new WeakReference(parame);
  }
  
  public static long aV(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    return paramArrayOfByte.getLong();
  }
  
  public static String bRE()
  {
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
    return "," + (String)localObject1 + "," + (String)localObject2 + "," + (String)localObject3 + "," + (String)localObject4;
  }
  
  private String bRF()
  {
    return "," + this.channelStrategy;
  }
  
  private String bRH()
  {
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "usePreConnect:" + this.pVd);
    return "," + this.pVd;
  }
  
  private String bRI()
  {
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.pVe);
    return "," + this.pVe;
  }
  
  public static boolean bRK()
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
  
  public static String bRL()
  {
    return "";
  }
  
  private native int forceredirect(int paramInt1, int paramInt2);
  
  public static void gF(int paramInt1, int paramInt2)
  {
    com.tencent.mm.plugin.voip.video.e locale;
    int k;
    int m;
    double d;
    int j;
    int i;
    if (rpQ != null)
    {
      locale = (com.tencent.mm.plugin.voip.video.e)rpQ.get();
      if (locale != null)
      {
        k = locale.jXi.getWidth();
        m = locale.jXi.getHeight();
        d = paramInt2 / paramInt1;
        if (m <= (int)(k * d)) {
          break label250;
        }
        j = (int)(m / d);
        i = m;
      }
    }
    for (;;)
    {
      int n = (k - j) / 2;
      int i1 = (m - i) / 2;
      y.v("DecodeTextureView", "video=" + paramInt1 + "x" + paramInt2 + " view=" + k + "x" + m + " newView=" + j + "x" + i + " off=" + n + "," + i1);
      Matrix localMatrix = new Matrix();
      locale.jXi.getTransform(localMatrix);
      localMatrix.setScale(j / k, i / m);
      localMatrix.postTranslate(n, i1);
      locale.jXi.setTransform(localMatrix);
      return;
      label250:
      i = (int)(d * k);
      j = k;
    }
  }
  
  private native int setsvraddr(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2);
  
  private native int uninit(int paramInt1, long paramLong, int paramInt2);
  
  public native int SendDTMF(int paramInt);
  
  public native int SendRUDP(byte[] paramArrayOfByte, int paramInt);
  
  public native int SetDTMFPayload(int paramInt);
  
  public native int StartSpeedTest(long paramLong, int paramInt);
  
  public native int StopSpeedTest();
  
  public final int a(cec paramcec1, cec paramcec2, cec paramcec3, int paramInt1, int paramInt2)
  {
    if ((paramcec1 != null) && (paramcec1.tSS > 0))
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
      this.field_relaySvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcec1);
      if ((paramcec2 == null) || (paramcec2.tSS <= 0)) {
        break label133;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
      this.field_punchSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcec2);
      label56:
      if ((paramcec3 == null) || (paramcec3.tSS <= 0)) {
        break label145;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
      this.field_relayTcpSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcec3);
    }
    for (;;)
    {
      paramInt1 = forceredirect(paramInt1, paramInt2);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal forceRedirect ret :" + paramInt1);
      return paramInt1;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
      break;
      label133:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: No punch svr ip");
      break label56;
      label145:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
    }
  }
  
  public final int a(cec paramcec1, cec paramcec2, cec paramcec3, cfm paramcfm, LinkedList<cfk> paramLinkedList)
  {
    if (paramcec1.tSS > 0)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
      this.field_relaySvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcec1);
      if (paramcec2.tSS <= 0) {
        break label218;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
      this.field_punchSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcec2);
      label48:
      if (paramcec3.tSS <= 0) {
        break label230;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
      this.field_relayTcpSvrArray = com.tencent.mm.plugin.voip.a.a.a(paramcec3);
      label72:
      if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
        break label242;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal natSvr.size() :" + paramLinkedList.size());
      this.field_natSvrArray = com.tencent.mm.plugin.voip.a.a.ap(paramLinkedList);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal field_natSvrArray :" + this.field_natSvrArray.length);
    }
    for (;;)
    {
      int i = setsvraddr(paramcfm.tUF, paramcfm.tUG, paramcfm.tUH, paramcfm.userName, paramcfm.foj);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal setsvraddr ret :" + i);
      return i;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
      break;
      label218:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
      break label48;
      label230:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
      break label72;
      label242:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal field_natSvrArray no nat svr list");
    }
  }
  
  public native int app2EngineDataEx(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4);
  
  public native int app2EngineLinkQualityEx(int paramInt, byte[] paramArrayOfByte);
  
  public final int bMo()
  {
    this.netType = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
    this.pUy = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool3;
    boolean bool4;
    label84:
    boolean bool5;
    label156:
    boolean bool6;
    label229:
    boolean bool7;
    label241:
    int i;
    label252:
    int j;
    label263:
    int m;
    int k;
    if ((this.pUy >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 26))
    {
      bool3 = true;
      if ((!bool3) || ((cpuFlag0 & 0xFF) < 30)) {
        break label419;
      }
      bool4 = true;
      if ((q.dyd.dwA <= 0) || (q.dyd.dwc.width < 480) || (q.dyd.dwc.height < 360) || (q.dyd.dwe.width < 480) || (q.dyd.dwe.height < 360)) {
        break label425;
      }
      bool5 = true;
      if ((q.dyd.dwA < 2) || (q.dyd.dwc.width < 640) || (q.dyd.dwc.height < 480) || (q.dyd.dwe.width < 640) || (q.dyd.dwe.height < 480)) {
        break label431;
      }
      bool6 = true;
      if (q.dyd.dwA != 0) {
        break label437;
      }
      bool7 = true;
      if (q.dyd.dwB != 0) {
        break label443;
      }
      i = 1;
      if (q.dyd.dwB <= 0) {
        break label448;
      }
      j = 1;
      this.pWn = false;
      if (i != 0) {
        break label1133;
      }
      if (!bool4) {
        break label1011;
      }
      m = 0;
      i = 0;
      if (Build.VERSION.SDK_INT < 21) {
        break label463;
      }
      k = MediaCodecList.getCodecCount() - 1;
    }
    Object localObject1;
    int n;
    for (;;)
    {
      m = i;
      if (k < 0) {
        break label463;
      }
      Object localObject2 = MediaCodecList.getCodecInfoAt(k);
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "steve codecInfo : " + ((MediaCodecInfo)localObject2).getName());
      localObject1 = ((MediaCodecInfo)localObject2).getSupportedTypes();
      localObject2 = ((MediaCodecInfo)localObject2).getName();
      n = 0;
      m = i;
      i = n;
      for (;;)
      {
        if (i < localObject1.length)
        {
          if (localObject1[i].equalsIgnoreCase("video/avc"))
          {
            m = 1;
            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "steve : H.264 HW encoder found:" + (String)localObject2);
          }
          i += 1;
          continue;
          bool3 = false;
          break;
          label419:
          bool4 = false;
          break label84;
          label425:
          bool5 = false;
          break label156;
          label431:
          bool6 = false;
          break label229;
          label437:
          bool7 = false;
          break label241;
          label443:
          i = 0;
          break label252;
          label448:
          j = 0;
          break label263;
        }
      }
      k -= 1;
      i = m;
    }
    label463:
    boolean bool1;
    label489:
    boolean bool2;
    label509:
    label511:
    boolean bool8;
    if (m != 0)
    {
      bool1 = true;
      if (j == 0) {
        break label1124;
      }
      if ((q.dyd.dwB & 0x10) == 0) {
        break label1017;
      }
      i = 1;
      if ((!bool1) || ((q.dyd.dwB & 0xF) == 0)) {
        break label1022;
      }
      bool2 = true;
      j = i;
      if (!bool2) {
        break label1028;
      }
      bool8 = true;
      label519:
      this.pWn = bool8;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "hwH264Local:" + bool1 + ",hwHEVCLocal:false, bSupportH264HW:" + bool2 + ", bSupportHEVCHW:false, svrHWCfg:" + q.dyd.dwB);
      if (!bool2) {
        break label1119;
      }
      i = 1;
      label582:
      if (j == 0) {
        break label1116;
      }
      i |= 0x2;
    }
    for (;;)
    {
      if (((bool3) || (bool5)) && (!bool7))
      {
        if ((this.pWn) || (bool6))
        {
          this.defaultWidth = 640;
          this.defaultHeight = 480;
          label631:
          pUv = true;
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
      }
      else
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool3 + ", bEnable480FromSvr:" + bool5 + ", bDisable480FromSvr:" + bool7 + ", bEnable640FromLocal:" + bool4 + ", bEnable640FromSvr:" + bool6);
        this.pVv = new int[this.defaultWidth * this.defaultHeight];
        g.DN();
        this.pUx = com.tencent.mm.kernel.a.CK();
        if ((cpuFlag0 & 0x400) == 0) {
          break label1051;
        }
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v7a.so");
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
      }
      for (;;)
      {
        k = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        localObject1 = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
        m = ((Display)localObject1).getWidth();
        n = ((Display)localObject1).getHeight();
        k = init(this.netType | i << 8, 2, this.defaultWidth << 16 | this.defaultHeight, m << 16 | n, this.pUx, cpuFlag0 | j << 24 | k << 16, com.tencent.mm.compatible.util.e.dOO + "app_lib/", 0);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "protocal init ret :" + k + ",uin= " + this.pUx + ", gl_vs:" + j + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i);
        this.isInited = true;
        if (k < 0) {
          reset();
        }
        return k;
        label1011:
        bool1 = false;
        break;
        label1017:
        i = 0;
        break label489;
        label1022:
        bool2 = false;
        break label509;
        label1028:
        bool8 = false;
        break label519;
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        break label631;
        label1051:
        if ((cpuFlag0 & 0x200) != 0)
        {
          com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec.so");
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
          Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
        }
        else
        {
          com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v5.so");
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
          Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
        }
      }
      label1116:
      continue;
      label1119:
      i = 0;
      break label582;
      label1124:
      j = 0;
      bool2 = bool1;
      break label511;
      label1133:
      i = 0;
    }
  }
  
  public final String bRG()
  {
    if (this.field_videoDuration == 0)
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "captureFrames:" + this.pVS + ", videoduration: 0");
      return ",0";
    }
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "capturefps:" + this.pVS / this.field_videoDuration + " framecount:" + this.pVS + " videoDuration:" + this.field_videoDuration);
    return "," + this.pVS / this.field_videoDuration;
  }
  
  public final String bRJ()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.pUV = 0;
      this.pUW = 2;
      if (q.dye.dvn >= 0) {
        this.pUV = q.dye.dvn;
      }
      if ((Build.VERSION.SDK_INT >= 11) && (l.wx()) && (2 == q.dyn.dwX)) {
        this.pUW = 2;
      }
      if (q.dye.dvo >= 0) {
        this.pUW = q.dye.dvo;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        break label274;
      }
      this.pUU = 1;
      label98:
      if (q.dye.duN) {
        this.pUU = 1;
      }
      if (q.dye.dvm >= 0) {
        this.pUU = q.dye.dvm;
      }
      if (q.dye.duO <= 0) {
        break label283;
      }
      this.pUX = 3;
      this.pUY = 0;
    }
    for (;;)
    {
      if (q.dye.dvq >= 0) {
        this.pUX = q.dye.dvq;
      }
      if (q.dye.dvr >= 0) {
        this.pUY = q.dye.dvr;
      }
      return "," + this.pUV + "," + this.pUW + "," + this.pUU + "," + this.pUX + "," + this.pUY;
      this.pUV = 3;
      this.pUW = 3;
      break;
      label274:
      this.pUU = 7;
      break label98;
      label283:
      if (q.dye.dvp >= 0)
      {
        this.pUX = q.dye.dvp;
        this.pUY = q.dye.dvp;
      }
    }
  }
  
  public final String bRM()
  {
    long l3 = 0L;
    if ((this.pUN == 0) && (this.pUO == 0))
    {
      this.pWi.pRl = 0;
      this.pWi.pRt = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
      this.pWi.pRs = this.field_videoDuration;
      this.pWi.pRr = this.field_audioDuration;
      this.pUS = f.yi().yy();
      if ((this.pWi.pRB <= 0L) || (this.pWi.pRv <= this.pWi.pRB)) {
        break label1254;
      }
    }
    label1254:
    for (long l1 = this.pWi.pRv - this.pWi.pRB;; l1 = 0L)
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:" + l1);
      setJNIAppCmd(1, this.pVR, this.pVR.length);
      long l4 = aV(this.pVR);
      Object localObject1 = this.pWi;
      if ((l4 > this.pWi.pRz) && (this.pWi.pRz > 0L)) {}
      for (long l2 = l4 - this.pWi.pRz;; l2 = 0L)
      {
        ((m)localObject1).pRC = l2;
        localObject1 = this.pWi;
        l2 = l3;
        if (l4 > this.pWi.pRB)
        {
          l2 = l3;
          if (this.pWi.pRB > 0L) {
            l2 = l4 - this.pWi.pRB;
          }
        }
        ((m)localObject1).pRD = l2;
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.pWi.pRC + " lCalledWaitTime:" + this.pWi.pRD);
        int i = cpuFlag0;
        StringBuilder localStringBuilder = new StringBuilder().append(this.pUM).append(",").append(this.lpD).append(",").append(this.lpE).append(",").append(this.lpL).append(",").append(this.pWi.pQU).append(",").append(this.pWi.pRg).append(",").append(this.pWi.pRh).append(",").append(this.pWi.pRi).append(",").append(this.pWi.pRj).append(",").append(this.pWi.pRk).append(",").append(this.pWi.pRl).append(",").append(this.pWi.pRe).append(",").append(this.pWi.pRm).append(",").append(this.pWi.pRn).append(",").append(this.pWi.pRo).append(",").append(this.pWi.pRp).append(",").append(this.pWi.pRq).append(",").append(this.pWi.pRr).append(",").append(this.pWi.pRs).append(",").append(this.pWi.pRt).append(bRH()).append(bRI()).append(bRE()).append(",").append(this.pWi.pRu).append(",").append(this.pUR).append(",").append(this.pUS).append(",").append(l1).append(",").append(this.pWi.pRC).append(",").append(this.pWi.pRD).append(",").append(this.pUT).append(",").append(this.pUy).append(bRF()).append(",").append(i & 0xFF).append(",").append(this.pUZ).append(",").append(this.pVa);
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
        localObject1 = new StringBuilder(",").append((String)localObject1).append(",").append((String)localObject2).toString() + "," + this.pWi.pRw + "," + this.pWi.pRy + "," + this.pWi.pRx + ",0," + this.pWi.pRE + "," + this.pWi.pRF + "," + this.pWi.pRG + "," + this.pWi.pRH;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.pUy);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:NewDialStatString:" + (String)localObject1);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + bRF());
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.pWi.pRF + "lInterruptEndTime:" + this.pWi.pRG + "mIinterruptCnt:" + this.pWi.pRH);
        return localObject1;
        if ((this.pUO != 0) && (this.pUN != 0))
        {
          this.pWi.pRl = 3;
          break;
        }
        if (this.pUO != 0)
        {
          this.pWi.pRl = 1;
          break;
        }
        if (this.pUN == 0) {
          break;
        }
        this.pWi.pRl = 2;
        break;
      }
    }
  }
  
  public final String bRN()
  {
    getChannelInfo(this.pWa, this.pWa.length, this.pVw, this.pVx, this.pVy, this.pVz);
    Object localObject = new StringBuilder().append(this.lpE).append(",").append(this.lpD).append(",").append(this.lpL).append(this.pWi.bQo());
    m localm = this.pWi;
    localObject = new StringBuilder(",").append(localm.pRk).toString() + new String(this.pWa, 0, this.field_channelStatLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:oldChannelString: " + (String)localObject);
    getChannelReport(this.pWa, this.pWa.length);
    localObject = new String(this.pWa, 0, this.field_channelReportLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:newChannelString: " + (String)localObject);
    return localObject;
  }
  
  public final String[] bRO()
  {
    String[] arrayOfString = getNatReport();
    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip", "nat_report size:" + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip", "nat_report:" + arrayOfString[i]);
      i += 1;
    }
    return arrayOfString;
  }
  
  public final String bRP()
  {
    getNewEngineInfo(this.pWb, this.pWb.length);
    getNewEngineExtInfo(this.pWc, this.pWc.length);
    String str = this.lpL + "," + this.lpE + this.pWi.bQo() + "," + this.pUN + "," + this.pUO + bRG() + new String(this.pWb, 0, this.field_newEngineStatLength) + "," + this.pUP + "," + this.pUQ + bRJ() + new String(this.pWc, 0, this.field_newEngineExtStatLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:" + str);
    getNewEngineInfoReport(this.pWb, this.pWb.length);
    str = this.lpL + "," + this.lpE + this.pWi.bQo() + "," + this.pUN + "," + this.pUO + bRG() + new String(this.pWb, 0, this.field_newEngineReportLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:" + str);
    return str;
  }
  
  public final String bRQ()
  {
    getEngine2ndInfo(this.pWd, this.pWd.length);
    String str = this.lpE + "," + this.lpD + "," + this.lpL + new String(this.pWd, 0, this.field_engine2ndStatLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:" + str);
    getEngine2ndInfoReport(this.pWd, this.pWd.length);
    str = this.lpE + "," + this.lpD + "," + this.lpL + new String(this.pWd, 0, this.field_engine2ndReportLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:" + str);
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
  
  public native int init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7);
  
  public native int isDCReady();
  
  public native int isDCSameLan();
  
  public native int isRelayConnReady();
  
  public final String kb(boolean paramBoolean)
  {
    if (this.isInited)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=" + paramBoolean);
      this.field_ChannelReportDial = new int[6];
      this.field_ChannelReportDial[0] = this.pWi.pRe;
      this.field_ChannelReportDial[1] = this.pWi.pRk;
      this.field_ChannelReportDial[2] = this.pVw;
      this.field_ChannelReportDial[3] = this.pVx;
      this.field_ChannelReportDial[4] = this.pVy;
      this.field_ChannelReportDial[5] = this.pVz;
      this.field_EngineReportStatFromApp = new int[14];
      bRJ();
      this.field_EngineReportStatFromApp[0] = this.pUP;
      this.field_EngineReportStatFromApp[1] = this.pUQ;
      this.field_EngineReportStatFromApp[2] = this.pUV;
      this.field_EngineReportStatFromApp[3] = this.pUW;
      this.field_EngineReportStatFromApp[4] = this.pUU;
      this.field_EngineReportStatFromApp[5] = this.pUX;
      this.field_EngineReportStatFromApp[6] = this.pUY;
      this.field_EngineReportStatFromApp[7] = -1;
      if (this.pWj != null)
      {
        this.field_EngineReportStatFromApp[8] = this.pWj.pOQ;
        this.field_EngineReportStatFromApp[9] = this.pWj.pOS;
        this.field_EngineReportStatFromApp[10] = this.pWj.pOv;
        if (pWk == null) {
          break label1113;
        }
        this.field_EngineReportStatFromApp[11] = pWk.pOr;
      }
      for (;;)
      {
        this.field_EngineReportStatFromApp[12] = this.pVM;
        this.field_EngineReportStatFromApp[13] = this.pVN;
        this.isInited = false;
        uninit(this.lpD, this.lpE, this.lpL);
        pUv = false;
        if (this.pWj != null)
        {
          this.pWj.bPJ();
          this.pWj = null;
        }
        if (pWk != null)
        {
          pWk.interrupt();
          pWk.bPJ();
          pWk = null;
        }
        pWm = null;
        rpQ = null;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "uninit over.");
        if (!paramBoolean) {
          break label1124;
        }
        getStatInfo(this.pVX, this.pVX.length, this.pWg, 30);
        getEngineVersionInfo(this.pVY, this.pVY.length);
        getEngineQosInfo(this.pVZ, this.pVZ.length);
        Object localObject1 = new StringBuilder();
        long l = this.pUx;
        if (this.pUx < 0) {
          l = this.pUx + 4294967296L;
        }
        Object localObject2 = new StringBuilder().append(l).append(",").append(this.lpE).append(",").append(this.lpD).append(",").append(this.lpL).append(",");
        m localm = this.pWi;
        localObject2 = new StringBuilder().append(localm.pQU).append(",").append(localm.pQV).append(",").append(localm.pQW).append(",").append(localm.pQX).append(",").append(localm.pQY).append(",").append(localm.pQZ).append(",").append(localm.pRa).append(",").append(localm.pRb).append(",").append(localm.pRc).append(",").append(localm.pRd).append(",").append(localm.pRe).toString();
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:DailStatString:" + (String)localObject2);
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(new String(this.pVX, 0, this.field_statInfoLength)).append(bRE()).append(bRF());
        localObject2 = this.pWi;
        localObject1 = ((StringBuilder)localObject1).append("," + ((m)localObject2).pRf).append(new String(this.pVY, 0, this.field_engineVersionStatLength)).append(bRG());
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
        localObject1 = new StringBuilder(",").append(cpuFlag0).toString() + bRH() + bRI() + new String(this.pVZ, 0, this.field_engineQosStatLength);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.pVX, 0, this.field_statInfoLength));
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.pVY, 0, this.field_engineVersionStatLength));
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.pVZ, 0, this.field_engineQosStatLength));
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "voipreport:StatString = " + (String)localObject1);
        am.a.dVz.bg(this.field_netFlowRecv, this.field_netFlowSent);
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
        return localObject1;
        this.field_EngineReportStatFromApp[8] = 0;
        this.field_EngineReportStatFromApp[9] = 0;
        this.field_EngineReportStatFromApp[10] = 0;
        break;
        label1113:
        this.field_EngineReportStatFromApp[11] = 0;
      }
    }
    label1124:
    return "";
  }
  
  public int keep_onNotifyFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt1 == 100)
    {
      com.tencent.mm.plugin.voip.a.a.outputJniLog(paramArrayOfByte, "MicroMsg.Voip", paramInt2);
      return 0;
    }
    if (paramInt1 == 101)
    {
      com.tencent.mm.plugin.voip.a.a.outputJniLog(paramArrayOfByte, "MicroMsg.v2Core", paramInt2);
      return 0;
    }
    Message localMessage = new Message();
    localMessage.what = 59998;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramArrayOfByte;
    this.handler.sendMessage(localMessage);
    return 0;
  }
  
  public int keep_onNotifyFromJniInt(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
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
    return 0;
  }
  
  public native int parseSyncKeyBuff(byte[] paramArrayOfByte, int paramInt);
  
  public native int playCallback(byte[] paramArrayOfByte, int paramInt);
  
  public native int recordCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public final void reset()
  {
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal reset!");
    this.field_punchSvrArray = null;
    this.field_relaySvrArray = null;
    this.field_relayTcpSvrArray = null;
    this.field_natSvrArray = null;
    this.field_peerId = null;
    this.field_capInfo = null;
    this.lpD = 0;
    this.pUA = 0L;
    this.pUz = 0;
    this.lpL = 0;
    this.lpE = 0L;
    this.channelStrategy = 0;
    this.lpG = 0;
    this.enx = 0L;
    this.pUB = null;
    this.pUC = null;
    this.pUD = null;
    this.pUE = 0;
    this.pUF = null;
    this.pVz = 0;
    this.pVA = null;
    this.pVB = 0;
    this.pVC = 0;
    this.pUK = null;
    this.pVH = null;
    this.pVI = null;
    this.pVS = 0;
    this.pVT = 0;
    this.pVU = 0;
    this.pVV = 0;
    this.pVW = 0;
    this.field_videoDuration = 0;
    this.field_audioDuration = 0;
    this.pWh = 0;
    this.pVe = 0;
    this.pVd = 0;
    this.field_engineVersionStatLength = 0;
    this.field_engineQosStatLength = 0;
    this.field_statusSyncKey = 0;
    this.field_relayDataSyncKey = 0;
    this.field_connectingStatusKey = 0;
    this.pUP = 0;
    this.pUQ = 0;
    this.pUR = 65536;
    this.pUS = 0;
    this.pUT = 0;
    this.pVa = -1;
    this.pVb = 0;
    this.pVL = 0;
    this.pUw = 0;
    this.lFA = "";
    this.pVJ = 0;
    this.pVK = 0;
    this.pWi.reset();
    this.pWi.bQn();
    pUv = false;
    this.field_jbmBitratRsSvrParamArray = null;
    this.field_jbmParamArraySize = 0;
    this.field_jbmBitratRsSvrParamDoubleArray = null;
    this.field_jbmParamDoubleArraySize = 0;
    int i = freeJNIReport();
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "freeJNIReport : " + i + ". [0: null, no need to free, 1: free success!]");
  }
  
  public native int setActive();
  
  public native int setAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setConfigInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, byte[] paramArrayOfByte1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, int paramInt8, int paramInt9, int paramInt10, int paramInt11, byte[] paramArrayOfByte3, int paramInt12, int paramInt13, int paramInt14, byte[] paramArrayOfByte4);
  
  public native int setInactive();
  
  public native int setJNIAppCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public native int setNetSignalValue(int paramInt1, int paramInt2);
  
  public native int setSvrConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public native int setjbmbitraterssvrparam();
  
  public native int startEngine();
  
  public final int um(int paramInt)
  {
    paramInt = setAppCmd(paramInt, new byte[] { 0 }, 1);
    if (paramInt < 0) {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "setAppCmd: type:" + paramInt + ":ret:" + paramInt);
    }
    return paramInt;
  }
  
  public native int videoDecode(int[] paramArrayOfInt);
  
  public native int videoEncodeToLocal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt);
  
  public native int videoEncodeToSend(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int videoHWDecode(byte[] paramArrayOfByte);
  
  public native int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2);
  
  public native int videoRorate90D(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v2protocal
 * JD-Core Version:    0.7.0.1
 */