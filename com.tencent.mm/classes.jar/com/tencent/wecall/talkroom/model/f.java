package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mm.plugin.multi.talk.IMultiTalkListener;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.ad;
import com.tencent.pb.common.b.a.a.a.ae;
import com.tencent.pb.common.b.a.a.a.aj;
import com.tencent.pb.common.b.a.a.a.al;
import com.tencent.pb.common.b.a.a.a.am;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.ax;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bd;
import com.tencent.pb.common.b.a.a.a.q;
import com.tencent.pb.common.b.a.a.a.r;
import com.tencent.pb.common.b.a.a.a.s;
import com.tencent.pb.common.b.a.a.a.t;
import com.tencent.pb.common.b.a.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.a.n;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
  implements Handler.Callback, com.tencent.f.a.d, com.tencent.pb.common.b.b
{
  public static List<Integer> ZVt;
  private static int ZVz;
  public static String[] ZWf;
  private static com.tencent.pb.talkroom.sdk.e Zex;
  public String CSB;
  public int DVO;
  boolean EmI;
  boolean NKr;
  public long NXM;
  private com.tencent.f.a.a ZQK;
  private boolean ZVA;
  private boolean ZVB;
  String ZVC;
  public String ZVD;
  private int ZVE;
  private int ZVF;
  private int ZVG;
  private long ZVH;
  private boolean ZVI;
  private int ZVJ;
  private int ZVK;
  String ZVL;
  int ZVM;
  private int ZVN;
  private int ZVO;
  private int ZVP;
  private int ZVQ;
  private int ZVR;
  private int ZVS;
  private int ZVT;
  public h ZVU;
  b ZVV;
  private talk.IMultiTalkListener ZVW;
  private TimerTask ZVX;
  private TimerTask ZVY;
  private Timer ZVZ;
  f ZVs;
  private Map<String, e> ZVu;
  private final int ZVv;
  private final int ZVw;
  private final int ZVx;
  private final int ZVy;
  private TimerTask ZWa;
  private Timer ZWb;
  g ZWc;
  private int ZWd;
  private boolean ZWe;
  public String ZWg;
  HashSet<Long> ZWh;
  public boolean ZWi;
  public boolean ZWj;
  public boolean ZWk;
  private short[] ZWl;
  private String[] ZWm;
  private short[] ZWn;
  private String[] ZWo;
  private int ZWp;
  public boolean ZWq;
  public boolean ZWr;
  private Runnable ZWs;
  private com.tencent.pb.common.b.d ZWt;
  private Runnable ZWu;
  int Zel;
  Handler mHandler;
  boolean mIsMute;
  int state;
  
  static
  {
    AppMethodBeat.i(62787);
    Zex = null;
    ZVt = new ArrayList();
    ZVz = 30000;
    ZWf = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(62787);
  }
  
  public f()
  {
    AppMethodBeat.i(62723);
    this.ZVu = new HashMap();
    this.ZVv = 1;
    this.ZVw = 2;
    this.ZVx = 3;
    this.ZVy = 4;
    this.state = 0;
    this.NKr = false;
    this.ZVA = false;
    this.ZVB = false;
    this.EmI = false;
    this.ZVE = 0;
    this.ZVF = 0;
    this.ZVG = 0;
    this.ZVH = 0L;
    this.ZVI = true;
    this.ZVJ = 0;
    this.ZVK = 0;
    this.ZVL = null;
    this.ZVM = -1;
    this.ZVN = -1;
    this.ZVO = -1;
    this.ZVP = -1;
    this.ZVQ = -1;
    this.ZVR = -1;
    this.ZVS = -1;
    this.ZVT = -1;
    this.ZVU = h.ZXq;
    this.ZVZ = new Timer("TalkRoomService_HelloTimer");
    this.ZWb = new Timer("TalkRoomService_talkDurationTimer");
    this.ZWc = new g();
    this.ZWd = 0;
    this.ZWe = false;
    this.ZWg = null;
    this.ZWh = new HashSet();
    this.ZWi = false;
    this.ZWj = true;
    this.ZWk = true;
    this.ZWl = null;
    this.ZWm = null;
    this.ZWn = null;
    this.ZWo = null;
    this.ZWp = 0;
    this.mIsMute = false;
    this.ZWq = false;
    this.ZWr = true;
    this.ZWs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62550);
        if ((f.this.gyH()) && (f.s(f.this)))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
          h.aCz(-2003);
          f.this.ZVU.aCC(401);
          f.this.ba(f.b(f.this), 3, 108);
        }
        AppMethodBeat.o(62550);
      }
    };
    this.ZWt = null;
    this.ZWu = new Runnable()
    {
      public final void run()
      {
        Object localObject2 = null;
        AppMethodBeat.i(62587);
        int i = f.a(f.this);
        if (f.t(f.this) == null) {}
        for (Object localObject1 = null;; localObject1 = Integer.valueOf(f.t(f.this).getType()))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "beginSenceCircle state: ", Integer.valueOf(i), " mCircleScene: ", localObject1, " mIsAck: ", Boolean.valueOf(f.u(f.this)) });
          if (f.t(f.this) != null) {
            break;
          }
          f.w(f.this).removeCallbacks(f.v(f.this));
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
          AppMethodBeat.o(62587);
          return;
        }
        if (!f.this.gyH())
        {
          f.w(f.this).removeCallbacks(f.v(f.this));
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
          AppMethodBeat.o(62587);
          return;
        }
        localObject1 = localObject2;
        if (f.t(f.this) != null)
        {
          localObject1 = localObject2;
          if (f.t(f.this).getType() == 202)
          {
            localObject1 = localObject2;
            if (f.a(f.this) == 3)
            {
              com.tencent.wecall.talkroom.a.e locale = (com.tencent.wecall.talkroom.a.e)f.t(f.this);
              localObject1 = localObject2;
              if (f.a(f.this, locale.CSB, locale.DVO, locale.NXM, f.aCx(locale.ZXS)))
              {
                localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
              }
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.pb.common.b.e.ikG().b((com.tencent.pb.common.b.d)localObject1);
          AppMethodBeat.o(62587);
          return;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        AppMethodBeat.o(62587);
      }
    };
    com.tencent.pb.common.b.e.ikG().a(201, this);
    com.tencent.pb.common.b.e.ikG().a(202, this);
    com.tencent.pb.common.b.e.ikG().a(203, this);
    com.tencent.pb.common.b.e.ikG().a(204, this);
    com.tencent.pb.common.b.e.ikG().a(205, this);
    com.tencent.pb.common.b.e.ikG().a(206, this);
    com.tencent.pb.common.b.e.ikG().a(207, this);
    com.tencent.pb.common.b.e.ikG().a(208, this);
    com.tencent.pb.common.b.e.ikG().a(210, this);
    com.tencent.pb.common.b.e.ikG().a(209, this);
    com.tencent.pb.common.b.e.ikG().a(211, this);
    com.tencent.pb.common.b.e.ikG().a(212, this);
    com.tencent.pb.common.b.e.ikG().a(213, this);
    com.tencent.pb.common.b.e.ikG().a(214, this);
    com.tencent.pb.common.b.e.ikG().a(800, this);
    com.tencent.pb.common.b.e.ikG().a(801, this);
    com.tencent.pb.common.b.e.ikG().a(802, this);
    Object localObject = c.iuI();
    g localg = this.ZWc;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).ZVk = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      iuO();
      if (this.ZQK == null) {
        this.ZQK = ((com.tencent.f.a.a)com.tencent.f.f.bDV("EventCenter"));
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.ZQK.a(this, ZWf);
      AppMethodBeat.o(62723);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "setTalkServerCallback caller stack: ", localThrowable });
      }
    }
  }
  
  private void N(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62772);
    try
    {
      String str = c.iuI().M(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.NKr), " mTalkDuration: ", Integer.valueOf(this.ZVE), " msgKey: ", str });
      AppMethodBeat.o(62772);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(62772);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    AppMethodBeat.i(62747);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.roomId, paramh.DPJ, false)) {
        this.ZVU.ag(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62747);
      return;
    }
    paramObject = (a.am)paramObject;
    if (!b(paramObject.groupId, paramObject.NOc, paramObject.NOd, false))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.NOc), Integer.valueOf(this.DVO) });
      AppMethodBeat.o(62747);
      return;
    }
    this.ZVU.ag(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.Zel, paramObject.NOc, paramObject.NOd, paramObject.Zgp, paramObject.Zgr, paramObject.ZeS, false, false);
    a(paramObject.Zgq, paramObject.Zgx, paramObject.Zgy);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect type:", Integer.valueOf(this.ZVK) });
    if (this.ZVK == 0)
    {
      paramh = new byte[paramObject.Zgt.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.Zgt.length)
      {
        paramh[paramInt1] = ((byte)paramObject.Zgt[paramInt1]);
        paramInt1 += 1;
      }
      localObject1 = new int[paramObject.ZgC.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.ZgC.length)
      {
        localObject1[paramInt1] = paramObject.ZgC[paramInt1];
        paramInt1 += 1;
      }
      if (this.ZVV != null)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.ZVV.Close()) });
        localObject2 = paramObject.Zgp;
        localObject3 = paramObject.ZfE;
        if ((paramObject.Zgs & 0x2) == 0) {
          break label547;
        }
      }
      label547:
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ba[])localObject2, (a.ax)localObject3, paramh, bool, paramObject.groupId, paramObject.NOc, paramObject.NOd, paramObject.Zgz, paramObject.ZgA, paramObject.ZgB, (int[])localObject1, paramObject.ZfG, this.ZVL);
        AppMethodBeat.o(62747);
        return;
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp engine close but nullptr" });
        AppMethodBeat.o(62747);
        return;
      }
    }
    paramInt1 = j.mv(com.tencent.pb.common.c.c.NYh);
    com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "amyfwang,Redirect::netType:", Integer.valueOf(paramInt1) });
    paramObject = this.ZVV;
    paramh = this.ZWm;
    Object localObject1 = this.ZWl;
    Object localObject2 = this.ZWo;
    Object localObject3 = this.ZWn;
    if (paramObject.ZVf != null) {
      paramObject.ZVf.Redirect(paramh, (short[])localObject1, (String[])localObject2, (short[])localObject3, paramInt1);
    }
    AppMethodBeat.o(62747);
  }
  
  private void a(int paramInt, a.ac paramac, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(209096);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.CSB, Integer.valueOf(parame.DVO), Long.valueOf(parame.NXM), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.a.O(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111), Integer.valueOf(14287), Integer.valueOf(-1112) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.aCy(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramac.groupId, Integer.valueOf(paramac.NOc), Long.valueOf(paramac.NOd) });
      this.ZWc.r(-14255, paramac);
      AppMethodBeat.o(209096);
      return;
    }
    if (paramInt == 14287)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14287), paramac.groupId, Integer.valueOf(paramac.NOc), Long.valueOf(paramac.NOd) });
      this.ZWc.r(-14287, paramac);
      AppMethodBeat.o(209096);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramac.groupId, Integer.valueOf(paramac.NOc), Long.valueOf(paramac.NOd) });
      this.ZWc.r(-14256, paramac);
      AppMethodBeat.o(209096);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.CSB, parame.DVO, parame.NXM, aCw(parame.ZXS)))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.CSB, " mGroupId: ", this.CSB, Integer.valueOf(parame.DVO), Integer.valueOf(this.DVO), Long.valueOf(parame.NXM), Long.valueOf(this.NXM) });
        AppMethodBeat.o(209096);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.CSB, Integer.valueOf(parame.DVO), Long.valueOf(parame.NXM) });
        AppMethodBeat.o(209096);
        return;
      }
      this.ZVU.ag(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.ZVU.aCC(322);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.CSB, Integer.valueOf(parame.DVO), Long.valueOf(parame.NXM) });
      a(parame.CSB, parame.DVO, parame.NXM, true);
      if (paramInt == 14251)
      {
        this.ZWc.r(-1000, null);
        AppMethodBeat.o(209096);
        return;
      }
      if (paramInt == 14252)
      {
        this.ZWc.r(-1200, null);
        AppMethodBeat.o(209096);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramac != null) {
          parame = Integer.valueOf(paramac.Zgv);
        }
        this.ZWc.r(-1500, parame);
        AppMethodBeat.o(209096);
        return;
      }
      this.ZWc.r(-200, null);
      AppMethodBeat.o(209096);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramac.groupId, Integer.valueOf(paramac.NOc), Long.valueOf(paramac.NOd) });
      AppMethodBeat.o(209096);
      return;
    }
    if (!b(paramac.groupId, paramac.NOc, paramac.NOd, aCw(paramac.xbJ)))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramac.groupId, " mGroupId: ", this.CSB, Integer.valueOf(paramac.NOc), Integer.valueOf(this.DVO), Long.valueOf(paramac.NOd), Long.valueOf(this.NXM) });
      a(paramac.groupId, paramac.NOc, paramac.NOd, 111, false);
      h.aCy(-1110);
      AppMethodBeat.o(209096);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramac.groupId, Integer.valueOf(paramac.NOc), Long.valueOf(paramac.NOd) });
      AppMethodBeat.o(209096);
      return;
    }
    this.ZVU.ag(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramac.Zgq == null) || (paramac.Zgq.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramac.groupId, Integer.valueOf(paramac.NOc), Long.valueOf(paramac.NOd) });
      h.aCy(-1605);
      this.ZVU.OiP = 329;
      a(paramac.groupId, paramac.NOc, paramac.NOd, 116, true);
      this.ZWc.r(-200, null);
      AppMethodBeat.o(209096);
      return;
    }
    this.CSB = paramac.groupId;
    this.ZWg = paramac.groupId;
    this.DVO = paramac.NOc;
    this.NXM = paramac.NOd;
    setState(4);
    a(paramac.Zgq, paramac.Zgx, paramac.Zgy);
    a(paramac.groupId, null, this.Zel, paramac.NOc, paramac.NOd, paramac.Zgp, paramac.Zgr, paramac.ZeS, false, true);
    parame = this.ZWc;
    localObject = new g.11(parame, c.iuI().bEm(paramac.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramac.Zgt.length];
      paramInt = 0;
      while (paramInt < paramac.Zgt.length)
      {
        parame[paramInt] = ((byte)paramac.Zgt[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramac.ZgC.length];
    paramInt = 0;
    while (paramInt < paramac.ZgC.length)
    {
      localObject[paramInt] = paramac.ZgC[paramInt];
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(paramac.ZgC.length), " redirect type:", Integer.valueOf(localObject[talk.FlJ]), " SimpleRedirect value:", Integer.valueOf(talk.FlJ) });
    a.ba[] arrayOfba = paramac.Zgp;
    a.ax localax = paramac.ZfE;
    if ((paramac.Zgs & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfba, localax, parame, bool, paramac.groupId, paramac.NOc, paramac.NOd, paramac.Zgz, paramac.ZgA, paramac.ZgB, (int[])localObject, paramac.ZfG, this.ZVL);
      if (paramac.Zgw != 0)
      {
        com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramac.Zgw });
        ZVz = paramac.Zgw * 1000;
      }
      iuT();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM) });
      AppMethodBeat.o(209096);
      return;
    }
  }
  
  private void a(int paramInt, a.al paramal)
  {
    AppMethodBeat.i(209095);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.ZWc.lc(null);
      AppMethodBeat.o(209095);
      return;
    }
    paramal = paramal.ZgN;
    if ((paramal == null) || (paramal.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(209095);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramal.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = paramal[paramInt];
      if (localObject != null)
      {
        a(localObject.groupId, null, 0, localObject.NOc, localObject.NOd, localObject.Zgp, null, null, false, false);
        localArrayList.add(c.iuI().bEm(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.ZWc.lc(localArrayList);
    AppMethodBeat.o(209095);
  }
  
  /* Error */
  private void a(final int paramInt1, final a.ba[] paramArrayOfba, final a.ax paramax, final byte[] paramArrayOfByte1, final boolean paramBoolean, final String paramString1, final int paramInt2, final long paramLong, int paramInt3, final int paramInt4, final byte[] paramArrayOfByte2, final int[] paramArrayOfInt, final int paramInt5, final String paramString2)
  {
    // Byte code:
    //   0: ldc_w 770
    //   3: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 330
    //   9: bipush 6
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 772
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: aload 6
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: iload 7
    //   36: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_4
    //   42: lload 8
    //   44: invokestatic 577	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_5
    //   50: aload_0
    //   51: getfield 191	com/tencent/wecall/talkroom/model/f:state	I
    //   54: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 375	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 502	com/tencent/wecall/talkroom/model/f:ZVV	Lcom/tencent/wecall/talkroom/model/b;
    //   65: ifnull +96 -> 161
    //   68: aload_0
    //   69: aload_2
    //   70: aload_3
    //   71: aload 4
    //   73: iload 5
    //   75: iload 7
    //   77: lload 8
    //   79: iload 10
    //   81: iload 11
    //   83: aload 12
    //   85: aload 13
    //   87: iload 14
    //   89: aload 15
    //   91: invokespecial 775	com/tencent/wecall/talkroom/model/f:a	([Lcom/tencent/pb/common/b/a/a/a$ba;Lcom/tencent/pb/common/b/a/a/a$ax;[BZIJII[B[IILjava/lang/String;)Z
    //   94: istore 16
    //   96: ldc_w 330
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 777
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: iload 16
    //   113: invokestatic 397	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: aastore
    //   117: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: iload 16
    //   122: ifeq +39 -> 161
    //   125: ldc_w 770
    //   128: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: astore 17
    //   134: iconst_0
    //   135: istore 16
    //   137: ldc_w 330
    //   140: iconst_2
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: ldc_w 779
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload 17
    //   154: aastore
    //   155: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: goto -38 -> 120
    //   161: iload_1
    //   162: ifgt +61 -> 223
    //   165: aload_0
    //   166: getfield 238	com/tencent/wecall/talkroom/model/f:ZVU	Lcom/tencent/wecall/talkroom/model/h;
    //   169: sipush 202
    //   172: invokevirtual 636	com/tencent/wecall/talkroom/model/h:aCC	(I)V
    //   175: ldc_w 330
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc_w 781
    //   187: aastore
    //   188: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: aload 6
    //   194: iload 7
    //   196: lload 8
    //   198: bipush 102
    //   200: iconst_1
    //   201: invokevirtual 656	com/tencent/wecall/talkroom/model/f:a	(Ljava/lang/String;IJIZ)Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 256	com/tencent/wecall/talkroom/model/f:ZWc	Lcom/tencent/wecall/talkroom/model/g;
    //   209: sipush -400
    //   212: aconst_null
    //   213: invokevirtual 614	com/tencent/wecall/talkroom/model/g:r	(ILjava/lang/Object;)V
    //   216: ldc_w 770
    //   219: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: return
    //   223: aload_0
    //   224: getfield 345	com/tencent/wecall/talkroom/model/f:mHandler	Landroid/os/Handler;
    //   227: new 23	com/tencent/wecall/talkroom/model/f$4
    //   230: dup
    //   231: aload_0
    //   232: iload_1
    //   233: aload_2
    //   234: aload_3
    //   235: aload 4
    //   237: iload 5
    //   239: aload 6
    //   241: iload 7
    //   243: lload 8
    //   245: iload 10
    //   247: iload 11
    //   249: aload 12
    //   251: aload 13
    //   253: iload 14
    //   255: aload 15
    //   257: invokespecial 784	com/tencent/wecall/talkroom/model/f$4:<init>	(Lcom/tencent/wecall/talkroom/model/f;I[Lcom/tencent/pb/common/b/a/a/a$ba;Lcom/tencent/pb/common/b/a/a/a$ax;[BZLjava/lang/String;IJII[B[IILjava/lang/String;)V
    //   260: ldc2_w 785
    //   263: invokevirtual 790	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   266: pop
    //   267: ldc_w 770
    //   270: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: return
    //   274: astore 17
    //   276: goto -139 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	f
    //   0	279	1	paramInt1	int
    //   0	279	2	paramArrayOfba	a.ba[]
    //   0	279	3	paramax	a.ax
    //   0	279	4	paramArrayOfByte1	byte[]
    //   0	279	5	paramBoolean	boolean
    //   0	279	6	paramString1	String
    //   0	279	7	paramInt2	int
    //   0	279	8	paramLong	long
    //   0	279	10	paramInt3	int
    //   0	279	11	paramInt4	int
    //   0	279	12	paramArrayOfByte2	byte[]
    //   0	279	13	paramArrayOfInt	int[]
    //   0	279	14	paramInt5	int
    //   0	279	15	paramString2	String
    //   94	42	16	bool	boolean
    //   132	21	17	localException1	Exception
    //   274	1	17	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   68	96	132	java/lang/Exception
    //   96	120	274	java/lang/Exception
  }
  
  public static void a(com.tencent.pb.talkroom.sdk.e parame)
  {
    Zex = parame;
  }
  
  private void a(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62731);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendEnterGroupScence groupId: ", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " enterType: ", Integer.valueOf(paramInt3), " isSenceCircle: ", Boolean.TRUE, " wXgroupId: ", paramString2 });
    if ((paramInt1 == 0) || (paramLong == 0L))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "roomId or roomkey is 0..return." });
      AppMethodBeat.o(62731);
      return;
    }
    if (!aCw(paramInt3)) {
      this.ZVU.ivh();
    }
    this.ZVU.ivg();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.ZVV.iuF(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.ikG().b(paramString1);
    e(paramString1);
    AppMethodBeat.o(62731);
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.DVO = paramInt;
    this.NXM = paramLong;
    this.CSB = paramString2;
    this.ZVD = paramString1;
    this.ZVC = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62754);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(62754);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.ba[] paramArrayOfba)
  {
    AppMethodBeat.i(209101);
    if (paramArrayOfba == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(209101);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfba.length;
    int i = 0;
    while (i < j)
    {
      a.ba localba = paramArrayOfba[i];
      if (localba != null) {
        localStringBuffer.append(" memberId:" + localba.tQm + " uuid: " + localba.fEC + " status: " + localba.status + "   mem.inviteTime:" + localba.ZhL + "  mem.reason: " + localba.bnA + "  mem.inviteuuid: " + localba.ZhX + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfba.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(209101);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.ba[] paramArrayOfba, a.bb[] paramArrayOfbb, a.ay paramay, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209098);
    a(paramString1, paramInt2, paramLong, paramArrayOfba);
    c localc = c.iuI();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.CSB == null) || (!this.CSB.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramay, paramArrayOfba, paramArrayOfbb, paramBoolean1, bool);
      paramString2 = this.CSB;
      i = this.DVO;
      l = this.NXM;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfba == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfba.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.ZVI) });
      if (c.iuI().dS(this.CSB, false))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.ZVI), " mGroupId: ", this.CSB, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.ZVI)
        {
          this.ZVI = false;
          this.EmI = true;
          this.ZWe = j.ivk();
          this.ZVG = this.ZVE;
          iuY();
        }
      }
      if (paramArrayOfba != null) {
        break label380;
      }
      AppMethodBeat.o(209098);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfba.length > 0) && (this.ZVV != null)) {
      a(paramArrayOfba);
    }
    AppMethodBeat.o(209098);
  }
  
  private void a(a.ba[] paramArrayOfba)
  {
    AppMethodBeat.i(209099);
    if (paramArrayOfba == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(209099);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfba.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfba.length)
    {
      arrayOfInt[i] = paramArrayOfba[i].tQm;
      localStringBuffer.append(paramArrayOfba[i].tQm);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.ZVV == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(209099);
      return;
    }
    this.ZVV.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(209099);
  }
  
  private void a(a.q[] paramArrayOfq1, a.q[] paramArrayOfq2, int paramInt)
  {
    AppMethodBeat.i(209102);
    if (paramArrayOfq1 == null) {}
    for (int i = 0;; i = paramArrayOfq1.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfq1 != null) && (paramArrayOfq1.length > 0)) {
        break;
      }
      AppMethodBeat.o(209102);
      return;
    }
    this.ZWm = new String[paramArrayOfq1.length];
    this.ZWl = new short[paramArrayOfq1.length];
    this.ZWo = new String[paramArrayOfq2.length];
    this.ZWn = new short[paramArrayOfq2.length];
    this.ZWp = paramInt;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.ZWp) });
    int j = paramArrayOfq1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.q localq = paramArrayOfq1[paramInt];
      this.ZWm[i] = localq.ZfA;
      this.ZWl[i] = ((short)localq.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData ip: ", localq.ZfA, " addr.port: ", Integer.valueOf(localq.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfq2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfq1 = paramArrayOfq2[paramInt];
      this.ZWo[i] = paramArrayOfq1.ZfA;
      this.ZWn[i] = ((short)paramArrayOfq1.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", paramArrayOfq1.ZfA, " tcpAddr.port: ", Integer.valueOf(paramArrayOfq1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.ZWm), Arrays.toString(this.ZWl), this.CSB, this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM), Arrays.toString(this.ZWo), Arrays.toString(this.ZWn), Integer.valueOf(this.ZWp) });
    AppMethodBeat.o(209102);
  }
  
  private boolean a(a.ba[] paramArrayOfba, a.ax paramax, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, String paramString)
  {
    AppMethodBeat.i(209114);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(209114);
      return false;
    }
    this.ZVK = paramArrayOfInt[talk.FlJ];
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit general policy cnt:", Integer.valueOf(paramArrayOfInt.length), ", redirect type:", this.ZVK + " wifigateway:" + paramString });
    paramBoolean = b(paramArrayOfba, paramax, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramString);
    AppMethodBeat.o(209114);
    return paramBoolean;
  }
  
  private static boolean aCw(int paramInt)
  {
    return paramInt != 1;
  }
  
  private boolean aeJ()
  {
    AppMethodBeat.i(62739);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Zex;
      if (locale == null) {
        break label99;
      }
      this.ZVU.NRc = locale.eWH();
      this.ZVU.NQY = locale.eWI();
      bool = locale.eWF();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopRecord: ", localException });
        boolean bool = false;
      }
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "stopRecord ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62739);
    return bool;
  }
  
  private void ate()
  {
    AppMethodBeat.i(62727);
    this.ZVu.remove(this.CSB);
    this.ZWd = 0;
    this.mIsMute = false;
    setState(0);
    this.ZVB = false;
    a(this.ZVD, 0, 0L, null, null);
    this.ZVD = null;
    this.Zel = 0;
    this.ZVE = 0;
    this.ZVF = 0;
    this.ZVG = 0;
    this.ZVI = true;
    this.ZWj = true;
    this.ZVH = 0L;
    this.ZVJ = 0;
    this.ZVA = false;
    this.ZWq = false;
    this.ZWr = true;
    iuQ();
    this.mHandler.removeMessages(1);
    if (this.ZVV != null) {
      this.ZVV.iuG();
    }
    iuV();
    iuU();
    iuW();
    iuZ();
    this.EmI = false;
    this.ZWi = false;
    this.ZVK = 0;
    AppMethodBeat.o(62727);
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(62738);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Zex;
      i = j;
      if (locale != null) {
        i = locale.a(paramInt1, paramInt2, paramb);
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startPlayer: ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramb });
        int i = j;
      }
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62738);
    return i;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.c paramc)
  {
    AppMethodBeat.i(62740);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Zex;
      i = j;
      if (locale != null) {
        i = locale.a(paramInt1, paramInt2, paramc);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startRecord: ", paramc });
        int i = j;
      }
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62740);
    return i;
  }
  
  private boolean b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62771);
    if (paramBoolean)
    {
      paramBoolean = com.tencent.pb.common.c.f.oB(paramString, this.CSB);
      AppMethodBeat.o(62771);
      return paramBoolean;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.CSB, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.DVO), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.NXM) });
    if ((com.tencent.pb.common.c.f.oB(paramString, this.CSB)) && (paramInt == this.DVO) && (paramLong == this.NXM))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    AppMethodBeat.o(62771);
    return false;
  }
  
  private boolean b(a.ba[] paramArrayOfba, a.ax paramax, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, String paramString)
  {
    AppMethodBeat.i(209121);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.CSB, " ip: ", Arrays.toString(this.ZWm), " ports: ", Arrays.toString(this.ZWl), " tcpIp: ", Arrays.toString(this.ZWo), " tcpPorts: ", Arrays.toString(this.ZWn), " tcpStartTime: ", Integer.valueOf(this.ZWp), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.ila();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfba != null) && (paramArrayOfba.length > 0))
    {
      localObject1 = new int[paramArrayOfba.length];
      j = 0;
      while (j < paramArrayOfba.length)
      {
        localObject1[j] = paramArrayOfba[j].tQm;
        if (com.tencent.pb.common.c.f.oC(paramArrayOfba[j].fEC, (String)localObject2)) {
          i = paramArrayOfba[j].tQm;
        }
        j += 1;
      }
      paramArrayOfba = (a.ba[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.iuI().bEh(this.CSB);
      this.ZVU.tQm = j;
      for (;;)
      {
        try
        {
          localObject2 = this.ZVV;
          localIMultiTalkListener = this.ZVW;
          localObject3 = c.iuI();
          localObject1 = this.CSB;
          localObject3 = ((c)localObject3).bEf((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.ZWm;
          arrayOfShort1 = this.ZWl;
          arrayOfString = this.ZWo;
          arrayOfShort2 = this.ZWn;
          m = this.ZWp;
          localObject1 = null;
          if (paramax == null) {
            continue;
          }
          paramax = new VoiceEngineConf(paramax.Zhc, paramax.lJs, paramax.lJt, paramax.Zhd, paramax.Zhe, paramax.Zhf, paramax.Zhg, paramax.Zhh, paramax.Zhi, paramax.Zhj, paramax.Zhk, paramax.Zhl);
          n = j.mv(com.tencent.pb.common.c.c.NYh);
          localObject1 = ((b)localObject2).ZVf;
          if (localObject1 != null) {
            continue;
          }
          paramInt1 = -1;
        }
        catch (Throwable paramArrayOfba)
        {
          talk.IMultiTalkListener localIMultiTalkListener;
          Object localObject3;
          short[] arrayOfShort1;
          String[] arrayOfString;
          short[] arrayOfShort2;
          int m;
          int n;
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "connectToCompenent", paramArrayOfba });
          paramInt1 = -99999;
          continue;
          paramInt1 = ((b)localObject2).ZVf.Open(localIMultiTalkListener, paramax, i, j, paramInt1, paramLong, (String[])localObject3, arrayOfShort1, 0, paramArrayOfba, paramArrayOfByte1, paramBoolean, n, arrayOfString, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramString);
          continue;
          paramArrayOfba.handler.post(paramax);
          continue;
          AppMethodBeat.o(209121);
          return false;
        }
        paramArrayOfba = this.ZWc;
        paramax = new g.5(paramArrayOfba, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramax.run();
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.aCB(-3002);
        }
        if (paramInt1 == 0) {
          this.ZVU.OiS = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(209121);
        return true;
        localObject3 = ((TalkRoom)localObject3).bEe(com.tencent.pb.a.a.a.ila());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).ZVl;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.ba)localObject3).RCR) });
            i = ((a.ba)localObject3).RCR;
            continue;
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramax = (a.ax)localObject1;
          }
        }
      }
      paramArrayOfba = null;
    }
  }
  
  private void bRC()
  {
    AppMethodBeat.i(62767);
    aeJ();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c()
    {
      public final void ai(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(62659);
        try
        {
          boolean bool = f.l(f.this);
          if (!bool)
          {
            AppMethodBeat.o(62659);
            return;
          }
          if (f.m(f.this))
          {
            int i = 0;
            while (i < paramAnonymousArrayOfByte.length)
            {
              paramAnonymousArrayOfByte[i] = 0;
              i += 1;
            }
          }
          b localb;
          short s;
          if (f.l(f.this))
          {
            localb = f.c(f.this);
            s = (short)paramAnonymousInt;
            if ((com.tencent.pb.common.a.a.ZdM) && (localb.ZVf != null)) {
              break label140;
            }
          }
          for (;;)
          {
            if (f.this.ZWj)
            {
              f.this.ZWj = false;
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt) });
            }
            AppMethodBeat.o(62659);
            return;
            label140:
            localb.ZVf.SendAudio(paramAnonymousArrayOfByte, s, 0);
          }
          return;
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initMediaComponent record", paramAnonymousArrayOfByte });
          AppMethodBeat.o(62659);
        }
      }
    });
    if (i <= 0)
    {
      this.ZVU.aCC(101);
      h.aCz(-2001);
      this.ZWc.r(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.ZVU;
    }
    for (localh.ZXr &= 0xFFFFFFFE;; localh.ZXr |= 0x1)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62767);
      return;
      localh = this.ZVU;
    }
  }
  
  private boolean dz(int paramInt, String paramString)
  {
    AppMethodBeat.i(62732);
    if (paramInt == 100)
    {
      AppMethodBeat.o(62732);
      return true;
    }
    if (aCw(paramInt))
    {
      if (this.state == 0)
      {
        AppMethodBeat.o(62732);
        return true;
      }
      AppMethodBeat.o(62732);
      return false;
    }
    if (paramInt == 1)
    {
      boolean bool = bEo(paramString);
      AppMethodBeat.o(62732);
      return bool;
    }
    AppMethodBeat.o(62732);
    return false;
  }
  
  private void e(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62775);
    this.mHandler.removeCallbacks(this.ZWu);
    this.ZWt = paramd;
    this.mHandler.postDelayed(this.ZWu, 3000L);
    AppMethodBeat.o(62775);
  }
  
  private void giE()
  {
    AppMethodBeat.i(62741);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "releaseConpent" });
    try
    {
      aeJ();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          iuS();
          AppMethodBeat.o(62741);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "releaseConpent ", localThrowable2 });
          AppMethodBeat.o(62741);
        }
        localThrowable1 = localThrowable1;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "releaseConpent ", localThrowable1 });
      }
    }
  }
  
  private boolean iu(String paramString, int paramInt)
  {
    AppMethodBeat.i(62735);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62735);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.Zel);
    boolean bool = com.tencent.pb.common.b.e.ikG().b(localc);
    this.ZVU.ag(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.DVO, this.NXM, true);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62735);
    return bool;
  }
  
  private void iuO()
  {
    AppMethodBeat.i(209056);
    this.ZVN = -1;
    this.ZVO = -1;
    this.ZVP = -1;
    this.ZVQ = -1;
    this.ZVR = -1;
    this.ZVS = -1;
    this.ZVT = -1;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "multitalk voiceMsg local seq reset" });
    AppMethodBeat.o(209056);
  }
  
  private int iuR()
  {
    AppMethodBeat.i(62734);
    if (this.ZVH == 0L)
    {
      AppMethodBeat.o(62734);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.ZVH) / 1000L);
    AppMethodBeat.o(62734);
    return i;
  }
  
  private boolean iuS()
  {
    AppMethodBeat.i(62737);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Zex;
      if (locale == null) {
        break label99;
      }
      this.ZVU.NRk = locale.eWG();
      this.ZVU.NQZ = locale.eWJ();
      bool = locale.eWE();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopPlayer: ", localException });
        boolean bool = false;
      }
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "stopPlayer ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62737);
    return bool;
  }
  
  private void iuT()
  {
    AppMethodBeat.i(62759);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.ZVX != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(62759);
      return;
    }
    try
    {
      this.ZVX = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(62720);
          if ((f.g(f.this) == 0) || (f.b(f.this) == null))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(f.g(f.this)), f.b(f.this) });
            f.k(f.this);
            AppMethodBeat.o(62720);
            return;
          }
          f.a(f.this, f.j(f.this));
          AppMethodBeat.o(62720);
        }
      };
      this.ZVZ.schedule(this.ZVX, 0L, ZVz);
      AppMethodBeat.o(62759);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(62759);
    }
  }
  
  private void iuU()
  {
    AppMethodBeat.i(62760);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.ZVY != null) {
        this.ZVY.cancel();
      }
      this.ZVY = null;
      AppMethodBeat.o(62760);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask: ", localException });
      }
    }
  }
  
  private void iuV()
  {
    AppMethodBeat.i(62761);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.ZVX != null) {
        this.ZVX.cancel();
      }
      this.ZVX = null;
      AppMethodBeat.o(62761);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask: ", localException });
      }
    }
  }
  
  private void iuW()
  {
    AppMethodBeat.i(62762);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.ZWa != null) {
        this.ZWa.cancel();
      }
      this.ZWa = null;
      AppMethodBeat.o(62762);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask: ", localException });
      }
    }
  }
  
  private void iuX()
  {
    AppMethodBeat.i(62768);
    iuS();
    Object localObject = new AtomicInteger();
    final AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b()
    {
      public final int ah(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(62788);
        if (!f.l(f.this))
        {
          AppMethodBeat.o(62788);
          return 0;
        }
        label169:
        for (;;)
        {
          try
          {
            b localb = f.c(f.this);
            int i = (short)paramAnonymousInt;
            AtomicInteger localAtomicInteger1 = this.ZWN;
            AtomicInteger localAtomicInteger2 = localAtomicInteger;
            if (com.tencent.pb.common.a.a.ZdM) {
              if (localb.ZVf == null)
              {
                break label169;
                if ((f.this.ZWk) && (i >= 0))
                {
                  f.this.ZWk = false;
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt), " ret: ", Integer.valueOf(i) });
                }
                AppMethodBeat.o(62788);
                return i;
              }
              else
              {
                i = localb.ZVf.GetAudioData(paramAnonymousArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
                continue;
              }
            }
            i = 1;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initMediaComponent play", paramAnonymousArrayOfByte });
            AppMethodBeat.o(62788);
            return -1;
          }
        }
      }
    });
    if (i <= 0)
    {
      this.ZVU.aCC(101);
      h.aCz(-2001);
      localObject = this.ZVU;
      ((h)localObject).ZXr |= 0x1;
      this.ZWc.r(-500, null);
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62768);
  }
  
  private void iuY()
  {
    AppMethodBeat.i(62769);
    if (this.ZWa != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(62769);
      return;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.ZVs, " mIsHoldOn: ", Boolean.valueOf(this.ZWq) });
    this.ZWa = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(62661);
        if (!f.this.ZWq)
        {
          f.a(f.this, f.n(f.this) + 1);
          if (f.o(f.this)) {
            f.b(f.this, f.p(f.this) + 1);
          }
          if ((f.q(f.this) == 3) || (f.q(f.this) == 2))
          {
            f.c(f.this, f.r(f.this) + 1);
            f.this.ZVU.Ojd = f.r(f.this);
          }
          f.this.ZVU.ZXv = (f.n(f.this) * 1000);
          f.this.ZVU.Ojc = f.n(f.this);
        }
        if (f.this.ZVs != null) {
          f.n(f.this);
        }
        AppMethodBeat.o(62661);
      }
    };
    this.ZWb.scheduleAtFixedRate(this.ZWa, 1000L, 1000L);
    AppMethodBeat.o(62769);
  }
  
  private void iuZ()
  {
    AppMethodBeat.i(62774);
    this.mHandler.removeCallbacks(this.ZWu);
    this.ZWt = null;
    AppMethodBeat.o(62774);
  }
  
  private static void iva()
  {
    AppMethodBeat.i(62777);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.c.NYh.getSystemService("audio");
      localAudioManager.setMode(0);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "resumeAudioConfig mode: ", Integer.valueOf(localAudioManager.getMode()), " isSpeaker: ", Boolean.valueOf(localAudioManager.isSpeakerphoneOn()) });
      AppMethodBeat.o(62777);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "resumeAudioConfig ", localThrowable });
      AppMethodBeat.o(62777);
    }
  }
  
  public static boolean ivb()
  {
    AppMethodBeat.i(62778);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.c.NYh.getSystemService("audio")).isSpeakerphoneOn();
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "isSpeakerOn ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62778);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isSpeakerOn ", localException });
        boolean bool = false;
      }
    }
  }
  
  public static com.tencent.pb.talkroom.sdk.e ivc()
  {
    return Zex;
  }
  
  static String[] ld(List<String> paramList)
  {
    AppMethodBeat.i(62729);
    if ((paramList != null) && (paramList.size() > 0))
    {
      String[] arrayOfString = new String[paramList.size()];
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        arrayOfString[i] = ((String)paramList.next());
        i += 1;
      }
      AppMethodBeat.o(62729);
      return arrayOfString;
    }
    AppMethodBeat.o(62729);
    return new String[0];
  }
  
  public final void IJ(boolean paramBoolean)
  {
    AppMethodBeat.i(62725);
    this.ZVU.groupId = this.CSB;
    this.ZVU.ZeQ = this.ZVD;
    if (com.tencent.pb.common.c.f.fK(this.ZVU.groupId)) {
      this.ZVU.groupId = "";
    }
    if (com.tencent.pb.common.c.f.fK(this.ZVU.ZeQ)) {
      this.ZVU.ZeQ = "";
    }
    this.ZVU.NQW = 1;
    this.ZVU.roomId = this.DVO;
    this.ZVU.DPJ = this.NXM;
    iuO();
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    giE();
    ate();
    int j = -99999;
    int i = j;
    if (this.ZVV != null) {}
    try
    {
      this.ZWd = this.ZVV.iuH();
      i = this.ZVV.Close();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.ZVV == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        j = this.ZVV.uninitLive();
        this.ZVV = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.ZVU.ivd();
          if ((!TextUtils.isEmpty(this.ZVU.groupId)) || (!TextUtils.isEmpty(this.ZVU.ZeQ)))
          {
            h.bEp(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.ZVU.reset();
          iva();
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService end error", Integer.valueOf(j) });
        AppMethodBeat.o(62725);
        return;
        localThrowable = localThrowable;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService", localThrowable });
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService 2", localException });
          j = i;
        }
      }
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f Q(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62745);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.EmI)
    {
      localObject = localf;
      if (this.ZVV == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo" });
        localb = this.ZVV;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfInt != null) && (localb.ZVf != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", localb.ZVf });
        paramArrayOfInt = (int[])localObject;
      }
      catch (Exception paramArrayOfInt)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "receiveVideo error: ", paramArrayOfInt });
        paramArrayOfInt = localf;
        continue;
        int i = paramArrayOfInt.length;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.EmI), " decInfo: ", paramArrayOfInt, " engine: ", this.ZVV });
      localObject = paramArrayOfInt;
      AppMethodBeat.o(62745);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.ZVf.videoDecode(paramArrayOfInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiJ = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiK = localb.ZVf.field_remoteImgLength;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiL = localb.ZVf.field_remoteImgWidth;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiM = localb.ZVf.field_remoteImgHeight;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiN = (localb.ZVf.field_remoteImgChannel & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiO = 0;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiH = c.iuI().is(a.iut().CSB, ((com.tencent.pb.talkroom.sdk.f)localObject).ZiN);
      if (paramArrayOfInt != null) {
        continue;
      }
      i = 0;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "steve:receiveVideo imgBuffer size:", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localObject });
      paramArrayOfInt = (int[])localObject;
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(209094);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.EmI)
    {
      localObject = localf;
      if (this.ZVV == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen" });
        localb = this.ZVV;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfByte != null) && (paramArrayOfInt != null) && (localb.ZVf != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveScreen null, imgBuffer32:", paramArrayOfInt, ", engine:", localb.ZVf });
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "receiveScreen error: ", paramArrayOfByte });
        paramArrayOfByte = localf;
        continue;
        paramInt = paramArrayOfInt.length;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen finished, ", Boolean.valueOf(this.EmI), " decInfo: ", paramArrayOfByte, " engine: ", this.ZVV });
      localObject = paramArrayOfByte;
      AppMethodBeat.o(209094);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.ZVf.screenDecode(paramArrayOfByte, paramArrayOfInt, paramInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiP = paramArrayOfByte;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiJ = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiK = localb.ZVf.field_remoteImgLength_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiL = localb.ZVf.field_remoteImgWidth_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiM = localb.ZVf.field_remoteImgHeight_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiN = (localb.ZVf.field_remoteImgChannel_screen & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiO = localb.ZVf.field_remoteImgOrien_screen;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen channel:", Integer.valueOf(localb.ZVf.field_remoteImgChannel_screen) });
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen field_remoteImgOrien:", Integer.valueOf(localb.ZVf.field_remoteImgOrien_screen) });
      ((com.tencent.pb.talkroom.sdk.f)localObject).ZiH = c.iuI().is(a.iut().CSB, ((com.tencent.pb.talkroom.sdk.f)localObject).ZiN);
      if (paramArrayOfInt != null) {
        continue;
      }
      paramInt = 0;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "steve:receiveScreen imgBuffer32 size:", Integer.valueOf(paramInt), " MultiTalkVideoDecodeInfo: ", localObject });
      paramArrayOfByte = (byte[])localObject;
    }
  }
  
  public final b a(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(209067);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.DVO), Integer.valueOf(paramInt1), Long.valueOf(this.NXM), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    this.ZVL = paramString3;
    if (!com.tencent.pb.a.a.a.ilb())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.ilb()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.ilc()) });
      h.a(paramString1, "", this.DVO, this.NXM, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = b.ZWW;
      AppMethodBeat.o(209067);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((aCw(paramInt3)) && (paramInt3 != 100) && (gyH()))
    {
      h.a(paramString1, "", this.DVO, this.NXM, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = b.ZXa;
      AppMethodBeat.o(209067);
      return paramString1;
    }
    if (!dz(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.DVO, this.NXM, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = b.ZXb;
      AppMethodBeat.o(209067);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.DVO, this.NXM, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = b.ZXc;
      AppMethodBeat.o(209067);
      return paramString1;
    }
    if (aCw(paramInt3))
    {
      this.ZVU.reset();
      IJ(false);
    }
    iuP();
    if (!giH())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (aCw(paramInt3))
      {
        h.a(paramString1, "", this.DVO, this.NXM, new String[] { "enter", "req", "false", "initEnginefail" });
        IJ(false);
      }
      for (;;)
      {
        paramString1 = b.ZXe;
        AppMethodBeat.o(209067);
        return paramString1;
        this.ZVU.ag(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.CSB = paramString1;
    int i;
    long l;
    label705:
    label711:
    boolean bool;
    if (!aCw(paramInt3))
    {
      paramString3 = bEn(paramString1);
      if (paramString3 == null)
      {
        i = 0;
        this.DVO = i;
        if (paramString3 != null) {
          break label875;
        }
        l = 0L;
        this.NXM = l;
        this.ZWg = paramString1;
        this.Zel = paramInt2;
        setState(3);
        if (!aCw(paramInt3)) {
          break label898;
        }
        bool = true;
        label738:
        this.NKr = bool;
        if (this.NKr) {
          this.ZVU.ive();
        }
        if ((!this.NKr) || (c.iuI().dS(this.CSB, true))) {
          break label904;
        }
        paramString3 = new c();
        paramString3.groupId = paramString1;
        paramString3.roomId = paramInt1;
        paramString3.DPJ = paramLong;
        paramString3.xbJ = paramInt3;
        paramString3.ZeV = paramInt2;
        paramString3.ZXg = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = paramString3;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = b.ZWV;
      AppMethodBeat.o(209067);
      return paramString1;
      i = paramString3.roomId;
      break;
      label875:
      l = paramString3.DPJ;
      break label705;
      this.DVO = paramInt1;
      this.NXM = paramLong;
      break label711;
      label898:
      bool = false;
      break label738;
      label904:
      a(paramString1, this.DVO, this.NXM, paramInt2, paramInt3, paramString2);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62742);
    if (paramd != null) {
      paramString = Integer.valueOf(paramd.getType());
    }
    int i;
    for (;;)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onNetSceneEnd errCode:", Integer.valueOf(paramInt2), " errType: ", Integer.valueOf(paramInt1), " scene.getType(): ", paramString });
      if ((paramInt1 == 1) || (paramInt1 == 2))
      {
        paramString = com.tencent.pb.common.c.a.O(new Integer[] { Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542) });
        i = paramd.getType();
        if (paramString.containsKey(Integer.valueOf(i))) {
          h.aCy(((Integer)paramString.get(Integer.valueOf(i))).intValue());
        }
      }
      if (paramInt2 != -1) {
        break label1141;
      }
      try
      {
        if (paramd.getType() == 201)
        {
          paramString = (com.tencent.wecall.talkroom.a.d)paramd;
          if (com.tencent.pb.common.c.f.oB(this.ZVD, paramString.ZVD))
          {
            this.ZVU.aCC(301);
            this.ZVU.ag(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            iu(paramString.ZVD, 1001);
            if (!paramString.ZXR) {
              this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.ZWc.r(-100, null);
          }
          AppMethodBeat.o(62742);
          return;
          paramString = "";
        }
        else if (paramd.getType() == 209)
        {
          AppMethodBeat.o(62742);
          throw null;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom: ", paramString });
        AppMethodBeat.o(62742);
        return;
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if (!b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
        h.a(paramString.CSB, paramString.DVO, paramString.NXM, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.ZWc.a(paramString.ZXQ, c.iuI().bEm(paramString.CSB));
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.CSB, paramString.DVO, paramString.NXM, false))
      {
        this.ZVU.ag(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.ZWc.r(-300, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.CSB, paramString.DVO, paramString.NXM, aCw(paramString.ZXS))) && (this.state == 3))
      {
        this.ZVU.aCC(302);
        this.ZWc.r(-200, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.ZWc.lc(null);
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 213)
    {
      AppMethodBeat.o(62742);
      throw null;
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (b(paramString.groupId, paramString.roomId, paramString.DPJ, false)) {
        this.ZVU.ag(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (m)paramd;
      if (b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
        this.ZWc.r(-800, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (k)paramd;
      if (b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
        this.ZWc.r(-1600, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 801)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      if (b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
        this.ZWc.r(-1601, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 802)
    {
      paramString = (l)paramd;
      if (b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
        this.ZWc.r(-1602, null);
      }
    }
    AppMethodBeat.o(62742);
    return;
    label1141:
    Object localObject2;
    if (paramd.getType() == 201)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.d)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).Zej != null))
      {
        paramString = (a.ab)((com.tencent.pb.common.b.d)localObject1).Zej;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).ZVD });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).ZXR) {
          break label2628;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.a.O(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.aCy(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          ZVt = null;
          if (paramInt2 == 0) {
            break label2895;
          }
          if (com.tencent.pb.common.c.f.oB(this.ZVD, ((com.tencent.wecall.talkroom.a.d)localObject1).ZVD)) {
            break label2634;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.ZVD, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).ZVD, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1430:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.Zej != null)) {
        a(paramInt2, (a.ac)paramString.Zej, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.Zej != null))
      {
        localObject1 = (a.z)paramString.Zej;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.a.O(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303), Integer.valueOf(14651), Integer.valueOf(-1309) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.aCy(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label3924;
        }
        if (b(paramString.CSB, paramString.DVO, paramString.NXM, false))
        {
          this.ZVU.ag(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (paramInt2 != 14651) {
            break label3910;
          }
          com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14651), ((a.z)localObject1).groupId, Integer.valueOf(((a.z)localObject1).NOc), Long.valueOf(((a.z)localObject1).NOd) });
          this.ZWc.r(-301, localObject1);
        }
      }
    }
    label1821:
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.Zej != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ad)paramString.Zej).groupId, this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.a.O(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.aCy(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (n)paramd;
      if ((paramString != null) && (paramString.Zej != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.an)paramString.Zej).groupId, this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        iuU();
        i = 0;
        if (paramInt2 != 14800) {
          break label4141;
        }
        i = -1401;
        label2181:
        if (i != 0)
        {
          this.ZVU.aCC(324);
          h.aCy(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.Zej != null))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.CSB, " roomid: ", Integer.valueOf(paramString.DVO), " roomKey: ", Long.valueOf(paramString.NXM) });
        if (paramInt2 != 18950) {
          break label4156;
        }
        if (!b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
          h.a(paramString.CSB, paramString.DVO, paramString.NXM, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.iuI().bEm(paramString.CSB);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.CSB, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.ZWc.a(paramString.ZXQ, (MultiTalkGroup)localObject1);
        }
      }
    }
    label2628:
    label2634:
    label2893:
    label2895:
    Object localObject3;
    for (;;)
    {
      if (paramd.getType() == 207)
      {
        paramString = (com.tencent.wecall.talkroom.a.i)paramd;
        if ((paramString != null) && (paramString.Zej != null))
        {
          if (paramInt2 == 18100) {
            h.aCy(-1501);
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
        }
      }
      if (paramd.getType() == 208)
      {
        paramString = (com.tencent.wecall.talkroom.a.c)paramd;
        if ((paramString != null) && (paramString.Zej != null))
        {
          if (paramInt2 == 18300) {
            h.aCy(-1531);
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
        }
      }
      if (paramd.getType() != 209) {
        break label4642;
      }
      paramString = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((paramString == null) || (paramString.Zej == null)) {
        break label4642;
      }
      paramString = (a.ae)paramString.Zej;
      if (paramInt2 == 17900) {
        h.aCy(-1511);
      }
      if (paramInt2 == 0) {
        break label4562;
      }
      AppMethodBeat.o(62742);
      throw null;
      i = 0;
      break;
      if (paramInt2 != -1)
      {
        this.ZVU.aCC(321);
        this.ZVU.ag(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
      }
      if (this.state != 1)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).ZVD });
        if (i == 0) {
          break label1430;
        }
        this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break label1430;
      }
      a(this.CSB, this.DVO, this.NXM, true);
      if (paramInt2 == 14051) {
        this.ZWc.r(-900, null);
      }
      for (;;)
      {
        if (i == 0) {
          break label2893;
        }
        this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break;
        if (paramInt2 == 14052) {
          this.ZWc.r(-1100, null);
        } else if (paramInt2 == 14053) {
          this.ZWc.r(-1300, paramString);
        } else if (paramInt2 == 14504) {
          this.ZWc.r(-1400, null);
        } else {
          this.ZWc.r(-100, null);
        }
      }
      break label1430;
      if (!com.tencent.pb.common.c.f.oB(this.ZVD, paramString.ZeQ))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.ZVD, " resp.clientGroupId: ", paramString.ZeQ, Integer.valueOf(paramString.NOc), Long.valueOf(paramString.NOd) });
        a(paramString.groupId, paramString.NOc, paramString.NOd, 110, false);
        if (i == 0) {
          break label1430;
        }
        this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break label1430;
      }
      this.ZVU.ag(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
      if (this.state != 1)
      {
        h.aCy(-1003);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.ZeQ, Integer.valueOf(paramString.NOc), Long.valueOf(paramString.NOd) });
        if (i == 0) {
          break label1430;
        }
        this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break label1430;
      }
      if ((paramString.Zgq == null) || (paramString.Zgq.length == 0))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.ZeQ, Integer.valueOf(paramString.NOc), Long.valueOf(paramString.NOd) });
        h.aCy(-1605);
        this.ZVU.OiP = 329;
        a(paramString.groupId, paramString.NOc, paramString.NOd, 116, true);
        if (i != 0) {
          this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        }
        this.ZWc.r(-100, null);
        break label1430;
      }
      a(paramString.ZeQ, paramString.NOc, paramString.NOd, paramString.groupId, paramString.ZeS.Zhv);
      this.ZWg = paramString.groupId;
      this.Zel = paramString.ZeV;
      setState(4);
      a(paramString.Zgq, paramString.Zgx, paramString.Zgy);
      a(paramString.groupId, paramString.ZeQ, paramString.ZeV, paramString.NOc, paramString.NOd, paramString.ZfD, paramString.Zgr, paramString.ZeS, false, true);
      if (this.ZWc != null)
      {
        localObject1 = this.ZWc;
        localObject2 = new g.9((g)localObject1, c.iuI().bEm(paramString.groupId));
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label3460;
        }
        ((Runnable)localObject2).run();
      }
      for (;;)
      {
        localObject1 = new byte[paramString.Zgt.length];
        j = 0;
        while (j < paramString.Zgt.length)
        {
          localObject1[j] = ((byte)paramString.Zgt[j]);
          j += 1;
        }
        label3460:
        ((g)localObject1).handler.post((Runnable)localObject2);
      }
      localObject2 = new int[paramString.ZgC.length];
      int j = 0;
      while (j < paramString.ZgC.length)
      {
        localObject2[j] = paramString.ZgC[j];
        j += 1;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(paramString.ZgC.length) });
      if (paramString.ZgC.length > talk.FlJ) {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { " redirect type:", Integer.valueOf(localObject2[talk.FlJ]), " SimpleRedirect value:", Integer.valueOf(talk.FlJ) });
      }
      localObject3 = paramString.ZfD;
      a.ax localax = paramString.ZfE;
      if ((paramString.Zgs & 0x2) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ba[])localObject3, localax, (byte[])localObject1, bool, paramString.groupId, paramString.NOc, paramString.NOd, paramString.Zgz, paramString.ZgA, paramString.ZgB, (int[])localObject2, paramString.ZfG, this.ZVL);
        if (paramString.Zgw != 0)
        {
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.Zgw });
          ZVz = paramString.Zgw * 1000;
        }
        iuT();
        N(paramString.groupId, paramString.NOc, paramString.NOd);
        if (i != 0)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("result", Boolean.TRUE);
          ((Map)localObject1).put("shareUrl", new String(paramString.ZeS.Zhp, Charset.forName("utf-8")));
          ((Map)localObject1).put("smsShortUrl", new String(paramString.ZeS.Zhq, Charset.forName("utf-8")));
          ((Map)localObject1).put("groupId", paramString.groupId);
          this.ZQK.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM) });
        break;
      }
      label3910:
      this.ZWc.r(-300, null);
      break label1821;
      label3924:
      if (((a.z)localObject1).Zgp == null)
      {
        i = 0;
        label3935:
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
        if (b(((a.z)localObject1).groupId, ((a.z)localObject1).NOc, ((a.z)localObject1).NOd, false)) {
          break label4098;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.z)localObject1).groupId, this.CSB, " resp.roomid: ", Integer.valueOf(((a.z)localObject1).NOc), Integer.valueOf(this.DVO) });
        h.aCy(-1308);
      }
      for (;;)
      {
        a(((a.z)localObject1).groupId, null, this.Zel, ((a.z)localObject1).NOc, ((a.z)localObject1).NOd, ((a.z)localObject1).Zgp, null, ((a.z)localObject1).ZeS, true, true);
        break;
        i = ((a.z)localObject1).Zgp.length;
        break label3935;
        label4098:
        this.ZVU.ag(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
      }
      label4141:
      if (paramInt2 != 14801) {
        break label2181;
      }
      i = -1402;
      break label2181;
      label4156:
      if (paramInt2 == 0) {
        this.ZVA = true;
      }
      if (!gyH())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.CSB });
        this.ZVU.reset();
        IJ(false);
        this.ZVU.ag(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.NKr = false;
        this.CSB = paramString.CSB;
        this.ZWg = this.CSB;
        this.DVO = paramString.DVO;
        this.NXM = paramString.NXM;
        this.Zel = paramString.Zel;
        setState(2);
        this.ZVH = System.currentTimeMillis();
        localObject1 = this.ZVU;
        com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "beginNotifyTime" });
        ((h)localObject1).ZXG = System.currentTimeMillis();
        if (paramInt2 == 18900) {
          h.aCy(-1521);
        }
      }
      while (!com.tencent.pb.common.c.f.oC(paramString.CSB, this.CSB))
      {
        localObject1 = new e();
        ((e)localObject1).groupId = paramString.CSB;
        ((e)localObject1).roomId = paramString.DVO;
        ((e)localObject1).DPJ = paramString.NXM;
        this.ZVu.put(paramString.CSB, localObject1);
        localObject1 = c.iuI().bEm(paramString.CSB);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.CSB, " multiTalkGroup: ", localObject1 });
        if (localObject1 == null) {
          break label4540;
        }
        paramString = this.ZWc;
        localObject1 = new g.3(paramString, (MultiTalkGroup)localObject1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label4527;
        }
        ((Runnable)localObject1).run();
        break;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.CSB });
      continue;
      label4527:
      paramString.handler.post((Runnable)localObject1);
      continue;
      label4540:
      a(paramString.CSB, paramString.DVO, paramString.NXM, false, false, false);
    }
    label4562:
    Object localObject1 = c.iuI().bEf(paramString.groupId);
    if (localObject1 != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
      a(paramString.groupId, null, ((TalkRoom)localObject1).iuw(), TalkRoom.iux(), TalkRoom.gAo(), null, null, paramString.ZeS, true, false);
    }
    for (;;)
    {
      com.tencent.pb.common.c.g.runOnMainThread(new g.16(this.ZWc, paramString.groupId, 0));
      label4642:
      if (paramd.getType() == 210)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (paramInt2 == 19100) {
          h.aCy(-1541);
        }
      }
      if (paramd.getType() == 211)
      {
        paramString = (com.tencent.wecall.talkroom.a.h)paramd;
        if (paramString != null) {
          a(paramInt1, paramInt2, paramd.Zej, paramString);
        }
      }
      if (paramd.getType() == 212) {
        a(paramInt2, (a.al)paramd.Zej);
      }
      if (paramd.getType() != 213) {
        break label4830;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break;
      }
      AppMethodBeat.o(62742);
      throw null;
      a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.ZeS, true, false);
    }
    AppMethodBeat.o(62742);
    throw null;
    label4830:
    if (paramd.getType() == 214)
    {
      paramString = (a.aj)paramd.Zej;
      localObject1 = (m)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (((m)localObject1).ZXT == 1) {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleSwitchVideoGroup, but ilink event" });
      }
    }
    else
    {
      if (paramd.getType() == 800)
      {
        paramString = (k)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
        if (b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
          break label5682;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.CSB, Integer.valueOf(paramString.DVO) });
      }
      if (paramd.getType() == 801)
      {
        paramString = (com.tencent.wecall.talkroom.a.j)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo errCode: ", Integer.valueOf(paramInt2) });
        if (b(paramString.CSB, paramString.DVO, paramString.NXM, false)) {
          break label5747;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo isCurrentRoom is not same", paramString.CSB, Integer.valueOf(paramString.DVO) });
      }
    }
    for (;;)
    {
      label4998:
      if (paramd.getType() == 802)
      {
        paramString = (l)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeScreenSharingVideo errCode: ", Integer.valueOf(paramInt2) });
        if (!b(paramString.CSB, paramString.DVO, paramString.NXM, false))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeScreenSharingVideo isCurrentRoom is not same", paramString.CSB, Integer.valueOf(paramString.DVO) });
          AppMethodBeat.o(62742);
          return;
          if (!b(((m)localObject1).CSB, ((m)localObject1).DVO, ((m)localObject1).NXM, false))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((m)localObject1).CSB, Integer.valueOf(((m)localObject1).DVO) });
            break;
          }
          if (this.ZVV != null)
          {
            localObject2 = new int[6];
            localObject2[0] = paramString.SKL;
            localObject2[1] = paramString.ZgE;
            localObject2[2] = paramString.ZgF;
            localObject2[3] = paramString.ZgG;
            localObject2[4] = paramString.ZgH;
            localObject2[5] = paramString.ZgI;
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]), Integer.valueOf(localObject2[2]), Integer.valueOf(localObject2[3]), Integer.valueOf(localObject2[4]), Integer.valueOf(localObject2[5]) });
            localObject3 = this.ZVV;
            if (((b)localObject3).ZVf != null) {
              break label5489;
            }
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject2, ", engine:", ((b)localObject3).ZVf });
          }
          for (;;)
          {
            if (paramString.ZgL == 0)
            {
              if (paramInt2 == 0)
              {
                localObject1 = this.ZWc;
                paramString = new g.18((g)localObject1, paramString.SKL);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  paramString.run();
                  break;
                  label5489:
                  ((b)localObject3).ZVf.setMVSvrCfg((int[])localObject2, 6);
                  continue;
                }
                ((g)localObject1).handler.post(paramString);
                break;
              }
              if (paramInt2 == 24301)
              {
                this.ZWc.r(-1700, Integer.valueOf(paramString.ZgK));
                break;
              }
              this.ZWc.r(-800, null);
              break;
            }
          }
          if (paramString.ZgL != 1) {
            break;
          }
          if (((m)localObject1).wDk == 103)
          {
            localObject2 = this.ZWc;
            paramString = new g.20((g)localObject2, ((m)localObject1).ZXU, paramInt2, paramString.ZgM);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              paramString.run();
              break;
            }
            ((g)localObject2).handler.post(paramString);
            break;
          }
          paramString = this.ZWc;
          localObject1 = new g.19(paramString, paramInt2);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break;
          }
          paramString.handler.post((Runnable)localObject1);
          break;
          label5682:
          if (paramInt2 == 0)
          {
            paramString = this.ZWc;
            localObject1 = new g.21(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              break label4998;
            }
            paramString.handler.post((Runnable)localObject1);
            break label4998;
          }
          this.ZWc.r(-1600, null);
          break label4998;
          label5747:
          if (paramInt2 == 0)
          {
            paramString = this.ZWc;
            localObject1 = new g.22(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              continue;
            }
            paramString.handler.post((Runnable)localObject1);
            continue;
          }
          this.ZWc.r(-1601, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.ZWc;
          paramd = new g.23(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            paramd.run();
            AppMethodBeat.o(62742);
            return;
          }
          paramString.handler.post(paramd);
          AppMethodBeat.o(62742);
          return;
        }
        this.ZWc.r(-1602, null);
      }
    }
    AppMethodBeat.o(62742);
  }
  
  public final void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(62755);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.CSB, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.DVO), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.NXM) });
    c.iuI().bEg(paramString);
    if (paramBoolean1) {
      N(paramString, paramInt, paramLong);
    }
    this.ZVu.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      IJ(true);
      this.ZWc.dT(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.iuI().bEm(paramString);
      if (paramString != null) {
        this.ZWc.f(paramString);
      }
    }
    AppMethodBeat.o(62755);
  }
  
  public final boolean a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(62736);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "exitTalkRoom: has exited" });
      AppMethodBeat.o(62736);
      return false;
    }
    com.tencent.wecall.talkroom.a.f localf = new com.tencent.wecall.talkroom.a.f(paramString, paramInt1, paramLong, paramInt2);
    boolean bool = com.tencent.pb.common.b.e.ikG().b(localf);
    this.ZVU.ag(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62736);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62744);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.EmI) && (this.ZVV != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.ZVV;
        if ((paramArrayOfByte == null) || (localb.ZVf == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.ZVf });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.EmI), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.ZVV });
          AppMethodBeat.o(62744);
          return paramArrayOfByte;
        }
        paramInt1 = localb.ZVf.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.Fqb = paramArrayOfInt;
        paramArrayOfByte.Fqc = localb.ZVf.field_localImgWidth;
        paramArrayOfByte.Fqd = localb.ZVf.field_localImgHeight;
        paramArrayOfByte.ret = paramInt1;
        continue;
        paramArrayOfByte = localg;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "videoTrans error: ", paramArrayOfByte });
      }
    }
  }
  
  public final e bEn(String paramString)
  {
    AppMethodBeat.i(62757);
    paramString = (e)this.ZVu.get(paramString);
    AppMethodBeat.o(62757);
    return paramString;
  }
  
  public final boolean bEo(String paramString)
  {
    AppMethodBeat.i(62758);
    if ((e)this.ZVu.get(paramString) != null)
    {
      AppMethodBeat.o(62758);
      return true;
    }
    AppMethodBeat.o(62758);
    return false;
  }
  
  public final boolean ba(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62773);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62773);
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100)) {
      this.ZVU.ivf();
    }
    int i = this.DVO;
    long l = this.NXM;
    int j = a.iut().state;
    if (i.bEt(paramString))
    {
      this.ZVU.aCC(327);
      bool = a.iut().iu(paramString, 1000);
      AppMethodBeat.o(62773);
      return bool;
    }
    if (j == 2)
    {
      bool = a.iut().c(paramString, i, l, paramInt1);
      AppMethodBeat.o(62773);
      return bool;
    }
    com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.iut().a(paramString, i, l, paramInt2, true);
    AppMethodBeat.o(62773);
    return bool;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(209090);
    int j = -1;
    int i = j;
    if (this.EmI)
    {
      i = j;
      if (this.ZVV == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.ZVV;
        if ((paramArrayOfByte != null) && (localb.ZVf != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.ZVf });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.EmI), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.ZVV });
      i = paramInt1;
      AppMethodBeat.o(209090);
      return i;
      paramInt1 = localb.ZVf.SendVideo(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final boolean c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62733);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.CSB, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62733);
      return false;
    }
    int i;
    boolean bool;
    if (1 == paramInt2)
    {
      i = 1;
      if ((3 == i) && (paramInt2 != 7)) {
        iuR();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.ikG().b(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.ZVU.ag(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
    }
    for (;;)
    {
      a(paramString, paramInt1, paramLong, false);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62733);
      return bool;
      i = 3;
      break;
      label249:
      h.a(paramString, paramInt1, paramLong, new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
    }
  }
  
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209091);
    int j = -1;
    int i = j;
    if (this.EmI)
    {
      i = j;
      if (this.ZVV == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.ZVV;
        if ((paramArrayOfByte != null) && (localb.ZVf != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendScreen null, buffer:", paramArrayOfByte, ", engine:", localb.ZVf });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendScreen error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen finished, ", Boolean.valueOf(this.EmI), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.ZVV });
      i = paramInt1;
      AppMethodBeat.o(209091);
      return i;
      paramInt1 = localb.ZVf.SendScreen(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final int dz(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62753);
    long l;
    int n;
    label348:
    int i1;
    try
    {
      paramArrayOfByte = (a.r)com.google.b.a.e.a(new a.r(), paramArrayOfByte, paramArrayOfByte.length);
      if (paramArrayOfByte == null) {
        if ((!TextUtils.isEmpty(this.CSB)) || (!TextUtils.isEmpty(this.ZVD)))
        {
          this.ZVU.ag(new String[] { "notify", "pasrefail" });
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange groupChg null" });
          AppMethodBeat.o(62753);
          return -2;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        h.aCy(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.DVO, this.NXM, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange ", this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM), Long.valueOf(paramArrayOfByte.msgId), Integer.valueOf(paramArrayOfByte.ZfB), Integer.valueOf(paramArrayOfByte.mbp) });
      l = paramArrayOfByte.msgId;
      if (this.ZWh.contains(Long.valueOf(l)))
      {
        n = 1;
        if (n == 0) {
          break label392;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error: msgId:", Long.valueOf(paramArrayOfByte.msgId) });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false)) {
          break label348;
        }
        this.ZVU.ag(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.ZfB) });
      }
      for (;;)
      {
        AppMethodBeat.o(62753);
        return -3;
        this.ZWh.add(Long.valueOf(l));
        n = 0;
        break;
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.ZfB) });
      }
      label392:
      n = paramArrayOfByte.ZfB;
      i1 = paramArrayOfByte.mbp;
      switch (n)
      {
      default: 
        com.tencent.pb.common.c.b.w(" unknow voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1) });
        n = 0;
      }
    }
    if (n == 0) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange update msg seq fail type:", Integer.valueOf(paramArrayOfByte.ZfB) });
    }
    for (;;)
    {
      AppMethodBeat.o(62753);
      return 0;
      if ((i1 > 0) && (i1 <= this.ZVN))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.ZVN) });
        n = 0;
        break;
      }
      this.ZVN = i1;
      for (;;)
      {
        com.tencent.pb.common.c.b.w("voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1), " update local seq" });
        n = 1;
        break;
        if (i1 <= this.ZVO)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.ZVO) });
          n = 0;
          break;
        }
        this.ZVO = i1;
        continue;
        if (i1 <= this.ZVP)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.ZVP) });
          n = 0;
          break;
        }
        this.ZVP = i1;
        continue;
        if (i1 <= this.ZVQ)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.ZVQ) });
          n = 0;
          break;
        }
        this.ZVQ = i1;
        continue;
        if (i1 <= this.ZVR)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.ZVR) });
          n = 0;
          break;
        }
        this.ZVR = i1;
        continue;
        if (i1 <= this.ZVS)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.ZVS) });
          n = 0;
          break;
        }
        this.ZVS = i1;
        continue;
        if (i1 <= this.ZVT)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.ZVT) });
          n = 0;
          break;
        }
        this.ZVT = i1;
      }
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false)) {
        this.ZVU.ag(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.ZfB) });
      }
      if (paramArrayOfByte.ZfB == 2)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.ZeV, paramArrayOfByte.NOc, paramArrayOfByte.NOd, paramArrayOfByte.ZfD, paramArrayOfByte.ZfC, paramArrayOfByte.ZeS, true, true);
      }
      else
      {
        Object localObject1;
        if (paramArrayOfByte.ZfB == 4)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.ZeV, paramArrayOfByte.NOc, paramArrayOfByte.NOd, paramArrayOfByte.ZfD, paramArrayOfByte.ZfC, paramArrayOfByte.ZeS, true, true);
          if ((paramArrayOfByte.ZfF != 0) || (paramArrayOfByte.ZfG != 0))
          {
            localObject1 = this.ZVV;
            n = paramArrayOfByte.ZfF;
            i1 = paramArrayOfByte.ZfG;
            if ((com.tencent.pb.common.a.a.ZdM) && (((b)localObject1).ZVf != null)) {
              ((b)localObject1).ZVf.SetAVEncryptType(n, i1);
            }
          }
        }
        else if (paramArrayOfByte.ZfB == 16)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.ZeV, paramArrayOfByte.NOc, paramArrayOfByte.NOd, paramArrayOfByte.ZfD, paramArrayOfByte.ZfC, paramArrayOfByte.ZeS, true, false);
        }
        else if (paramArrayOfByte.ZfB == 1)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.NOc), " roomkey: ", Long.valueOf(paramArrayOfByte.NOd) });
          if (com.tencent.pb.a.a.a.ilb())
          {
            com.tencent.pb.a.a.a.ilc();
            if ((gyH()) && (com.tencent.pb.common.c.f.oC(paramArrayOfByte.groupId, this.CSB))) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.CSB });
            }
          }
          else
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
            continue;
          }
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.ZeV, paramArrayOfByte.NOc, paramArrayOfByte.NOd, paramArrayOfByte.ZfD, paramArrayOfByte.ZfC, paramArrayOfByte.ZeS, false, true);
          localObject1 = paramArrayOfByte.groupId;
          n = paramArrayOfByte.NOc;
          l = paramArrayOfByte.NOd;
          i1 = paramArrayOfByte.ZeV;
          int i2 = paramArrayOfByte.ZfH;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
          }
          for (;;)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
            break;
            paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, n, l, i1, i2);
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i2), Boolean.valueOf(com.tencent.pb.common.b.e.ikG().b(paramArrayOfByte)) });
          }
        }
        else if (paramArrayOfByte.ZfB == 8)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.CSB });
          if (b(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false))
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.ZeV, paramArrayOfByte.NOc, paramArrayOfByte.NOd, paramArrayOfByte.ZfD, paramArrayOfByte.ZfC, paramArrayOfByte.ZeS, true, false);
            a(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false, false, true);
          }
          else
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.ZeV, paramArrayOfByte.NOc, paramArrayOfByte.NOd, paramArrayOfByte.ZfD, paramArrayOfByte.ZfC, paramArrayOfByte.ZeS, true, false);
          }
        }
        else
        {
          String str;
          if (paramArrayOfByte.ZfB == 128)
          {
            localObject1 = paramArrayOfByte.groupId;
            str = this.CSB;
            if (paramArrayOfByte.ZfI == null) {}
            for (n = 0;; n = paramArrayOfByte.ZfI.length)
            {
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(n) });
              localObject1 = this.ZWc;
              paramArrayOfByte = new g.24((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.ZfI);
              if (Looper.myLooper() != Looper.getMainLooper()) {
                break label2014;
              }
              paramArrayOfByte.run();
              break;
            }
            label2014:
            ((g)localObject1).handler.post(paramArrayOfByte);
          }
          else
          {
            Object localObject2;
            if (paramArrayOfByte.ZfB == 256)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
              } else if (paramArrayOfByte.ZfI == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
              } else {
                try
                {
                  localObject1 = paramArrayOfByte.ZfI;
                  localObject1 = (a.t)com.google.b.a.e.a(new a.t(), (byte[])localObject1, localObject1.length);
                  if ((localObject1 == null) || (((a.t)localObject1).ZfN == null)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
                  }
                }
                catch (com.google.b.a.d locald1)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember ", locald1 });
                    localObject2 = null;
                  }
                  paramArrayOfByte = new ArrayList();
                  localObject2 = ((a.t)localObject2).ZfN;
                  i1 = localObject2.length;
                  n = 0;
                  while (n < i1)
                  {
                    str = localObject2[n];
                    if (str != null) {
                      paramArrayOfByte.add(str);
                    }
                    n += 1;
                  }
                  com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.CSB, " roomId: ", Integer.valueOf(this.DVO), " videoUserNames: ", paramArrayOfByte });
                  localObject2 = this.ZWc;
                  paramArrayOfByte = new g.10((g)localObject2, paramArrayOfByte);
                  if (Looper.myLooper() == Looper.getMainLooper())
                  {
                    paramArrayOfByte.run();
                    continue;
                  }
                  ((g)localObject2).handler.post(paramArrayOfByte);
                }
              }
            }
            else if (paramArrayOfByte.ZfB == 1024)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
              }
              else if ((this.state != 3) && (this.state != 4))
              {
                c(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, 1);
                this.ZWc.r(-1400, null);
              }
            }
            else if (paramArrayOfByte.ZfB == 512)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
              } else if (paramArrayOfByte.ZfI == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
              } else {
                try
                {
                  localObject2 = paramArrayOfByte.ZfI;
                  localObject2 = (a.s)com.google.b.a.e.a(new a.s(), (byte[])localObject2, localObject2.length);
                  if (localObject2 == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
                  }
                }
                catch (com.google.b.a.d locald2)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                    local1 = null;
                  }
                  paramArrayOfByte = this.ZWc;
                  g.1 local1 = new g.1(paramArrayOfByte, local1.ZfM);
                  if (Looper.myLooper() == Looper.getMainLooper())
                  {
                    local1.run();
                    continue;
                  }
                  paramArrayOfByte.handler.post(local1);
                }
              }
            }
            else if (paramArrayOfByte.ZfB == 2048)
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, chgtype: audiostream" });
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.NOc, paramArrayOfByte.NOd, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAudioStreamChange is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.NOc) });
              }
              else
              {
                com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleAudioStreamChange audio_stream_type", Integer.valueOf(paramArrayOfByte.ZfL) });
                int i = (byte)(paramArrayOfByte.ZfL & 0xFF);
                int j = (byte)(paramArrayOfByte.ZfL >> 8 & 0xFF);
                int k = (byte)(paramArrayOfByte.ZfL >> 16 & 0xFF);
                int m = (byte)(paramArrayOfByte.ZfL >> 24 & 0xFF);
                this.ZVV.ZVf.setAppCmd(306, new byte[] { i, j, k, m }, 4);
              }
            }
            else
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, unknow chgtype:", Integer.valueOf(paramArrayOfByte.ZfB), Long.valueOf(paramArrayOfByte.msgId) });
            }
          }
        }
      }
    }
  }
  
  final boolean giH()
  {
    AppMethodBeat.i(62765);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initEngine", this.CSB, Integer.valueOf(this.DVO), Long.valueOf(this.NXM), Integer.valueOf(this.state) });
    int i;
    label133:
    int j;
    try
    {
      localb = this.ZVV;
      boolean bool = com.tencent.pb.common.a.a.ZdM;
      if (bool) {
        break label133;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b localb;
        String str;
        com.tencent.pb.talkroom.sdk.e locale;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine", localException });
        i = -99999;
        continue;
        i = localException.ZVf.field_capInfo.length;
      }
      AppMethodBeat.o(62765);
      return true;
    }
    if (i < 0)
    {
      h.aCB(-3001);
      this.ZVU.aCC(201);
      this.ZVV = null;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(62765);
      return false;
      str = com.tencent.pb.common.c.c.NYh.getDir("lib", 0).getAbsolutePath();
      locale = Zex;
      if (locale == null) {
        break label380;
      }
      j = locale.aus();
      i = locale.eWC();
    }
    for (;;)
    {
      int k = j.mv(com.tencent.pb.common.c.c.NYh);
      com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(k), " cpuFlag:", Integer.valueOf(j), "libPath:", str });
      if (localb.ZVf == null)
      {
        i = -1;
        break;
      }
      j = localb.ZVf.init(i, k, j, str + "/");
      if (localb.ZVf.field_capInfo == null)
      {
        i = 0;
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit", Integer.valueOf(j), "field_capInfo length: ", Integer.valueOf(i) });
        i = j;
        break;
      }
      label380:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean gyH()
  {
    AppMethodBeat.i(62756);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "state: ", Integer.valueOf(this.state) });
    if (this.state != 0)
    {
      AppMethodBeat.o(62756);
      return true;
    }
    AppMethodBeat.o(62756);
    return false;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(62722);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62722);
      return true;
      paramMessage = paramMessage.obj;
      if (this.state == 4)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut state: ", Integer.valueOf(this.state) });
      }
      else if (!(paramMessage instanceof d))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut obj is not GroupRoomInfo" });
      }
      else
      {
        AppMethodBeat.o(62722);
        throw null;
        paramMessage = paramMessage.obj;
        if (this.state != 1)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroup state: ", Integer.valueOf(this.state) });
        }
        else if (!(paramMessage instanceof a))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroup obj is not CreateGroupObj" });
        }
        else
        {
          paramMessage = (a)paramMessage;
          if (com.tencent.pb.common.c.f.oB(paramMessage.groupId, this.CSB))
          {
            String str1 = paramMessage.groupId;
            Object localObject1 = paramMessage.ZWP;
            a.bd localbd = paramMessage.ZWQ;
            int i = paramMessage.ZeV;
            int j = paramMessage.type;
            long l = paramMessage.ZWR;
            String str2 = paramMessage.ZWS;
            boolean bool = paramMessage.ZWT;
            String str3 = paramMessage.ZWU;
            this.ZVU.ivg();
            Object localObject2 = c.iuI();
            paramMessage = "";
            localObject2 = ((c)localObject2).bEf(str1);
            if (localObject2 != null) {
              if (((TalkRoom)localObject2).ZVd != null) {
                break label484;
              }
            }
            label484:
            for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).ZVd.name)
            {
              localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.ZVV.iuF(), paramMessage, localbd, i, j, l, str2, bool, str3);
              bool = com.tencent.pb.common.b.e.ikG().b((com.tencent.pb.common.b.d)localObject1);
              this.ZVU.ag(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendCreateSence groupId: ", str1, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(j), " playId: ", Long.valueOf(l), " name: ", paramMessage, " ret: ", Boolean.valueOf(bool) });
              break;
            }
            paramMessage = paramMessage.obj;
            if (this.state != 3)
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerEnterGroup state: ", Integer.valueOf(this.state) });
            }
            else if (!(paramMessage instanceof c))
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroup obj is not CreateGroupObj" });
            }
            else
            {
              paramMessage = (c)paramMessage;
              if (b(paramMessage.groupId, paramMessage.roomId, paramMessage.DPJ, false))
              {
                a(paramMessage.groupId, paramMessage.roomId, paramMessage.DPJ, paramMessage.ZeV, paramMessage.xbJ, paramMessage.ZXg);
                continue;
                com.tencent.pb.common.c.e.ikZ();
              }
            }
          }
        }
      }
    }
  }
  
  public final void iq(String paramString, int paramInt)
  {
    AppMethodBeat.i(62776);
    if ((com.tencent.pb.common.c.f.oC("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (gyH()) && ((this.EmI) || (this.ZVB))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62776);
      return;
      switch (j.mv(com.tencent.pb.common.c.c.NYh))
      {
      }
      for (this.ZWe = false; (this.DVO == 0) || (this.NXM == 0L); this.ZWe = true)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(62776);
        return;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect", this.CSB, Integer.valueOf(this.DVO) });
      this.ZVU.ivg();
      paramString = new com.tencent.wecall.talkroom.a.h(this.CSB, this.DVO, this.NXM, c.iuI().bEh(this.CSB), this.ZVK);
      boolean bool = com.tencent.pb.common.b.e.ikG().b(paramString);
      this.ZVU.ag(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62776);
      return;
      paramString = this.ZVV;
      paramInt = j.mv(com.tencent.pb.common.c.c.NYh);
      if ((!com.tencent.pb.common.a.a.ZdM) || (paramString.ZVf == null))
      {
        AppMethodBeat.o(62776);
        return;
      }
      paramString.ZVf.onNetworkChange(paramInt);
    }
  }
  
  final boolean iuP()
  {
    AppMethodBeat.i(62724);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = Zex;
    if (locale != null) {
      locale.eWB();
    }
    this.ZVV = new b();
    this.ZWg = this.CSB;
    iuO();
    this.ZVW = new talk.IMultiTalkListener()
    {
      public final void keep_OnError(int paramAnonymousInt)
      {
        int m = -401;
        AppMethodBeat.i(62604);
        int i = 207;
        int j = -3007;
        int k = 103;
        switch (paramAnonymousInt)
        {
        default: 
          m = -400;
        }
        for (;;)
        {
          new Handler(Looper.getMainLooper()).post(new a(m, i, j, k, paramAnonymousInt));
          AppMethodBeat.o(62604);
          return;
          i = 203;
          j = -3003;
          k = 112;
          continue;
          i = 204;
          j = -3004;
          k = 113;
          continue;
          i = 205;
          j = -3005;
          k = 114;
          continue;
          i = 206;
          j = -3006;
          k = 115;
          m = -400;
        }
      }
      
      public final void keep_OnNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(62605);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "keep_OnNotify eventCode: ", Integer.valueOf(paramAnonymousInt) });
        h localh;
        if (paramAnonymousInt == 5)
        {
          f.this.ZVU.ZXs = 1;
          localh = f.this.ZVU;
          if (localh.ZXF != 0L) {
            break label121;
          }
        }
        label121:
        for (localh.ZXt = 0L;; localh.ZXt = (System.currentTimeMillis() - localh.ZXF))
        {
          com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.ZXF), Long.valueOf(localh.ZXt) });
          f.i(f.this);
          f.j(f.this);
          AppMethodBeat.o(62605);
          return;
        }
      }
      
      /* Error */
      public final void keep_OnOpenSuccess()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: ldc 121
        //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: aload_0
        //   9: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   12: getfield 77	com/tencent/wecall/talkroom/model/f:ZVU	Lcom/tencent/wecall/talkroom/model/h;
        //   15: iconst_1
        //   16: putfield 124	com/tencent/wecall/talkroom/model/h:DQV	I
        //   19: ldc 59
        //   21: iconst_1
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 126
        //   29: aastore
        //   30: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   33: aload_0
        //   34: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   37: invokestatic 128	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   40: iconst_4
        //   41: if_icmpeq +36 -> 77
        //   44: ldc 59
        //   46: iconst_2
        //   47: anewarray 4	java/lang/Object
        //   50: dup
        //   51: iconst_0
        //   52: ldc 130
        //   54: aastore
        //   55: dup
        //   56: iconst_1
        //   57: aload_0
        //   58: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   61: invokestatic 128	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   64: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   67: aastore
        //   68: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   71: ldc 121
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aload_0
        //   78: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   81: astore 6
        //   83: invokestatic 136	com/tencent/wecall/talkroom/model/c:iuI	()Lcom/tencent/wecall/talkroom/model/c;
        //   86: astore 4
        //   88: aload_0
        //   89: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   92: invokestatic 140	com/tencent/wecall/talkroom/model/f:b	(Lcom/tencent/wecall/talkroom/model/f;)Ljava/lang/String;
        //   95: astore 7
        //   97: aload 7
        //   99: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   102: ifeq +336 -> 438
        //   105: aload 5
        //   107: astore 4
        //   109: aload 6
        //   111: aload 4
        //   113: invokestatic 149	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;[I)V
        //   116: aload_0
        //   117: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   120: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   123: ifnull +30 -> 153
        //   126: aload_0
        //   127: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   130: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   133: astore 4
        //   135: invokestatic 156	com/tencent/wecall/talkroom/model/f:ivb	()Z
        //   138: istore_3
        //   139: getstatic 162	com/tencent/pb/common/a/a:ZdM	Z
        //   142: ifeq +11 -> 153
        //   145: aload 4
        //   147: getfield 168	com/tencent/wecall/talkroom/model/b:ZVf	Lcom/tencent/mm/plugin/multi/talk;
        //   150: ifnonnull +431 -> 581
        //   153: aload_0
        //   154: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   157: invokestatic 171	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
        //   160: pop
        //   161: aload_0
        //   162: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   165: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   168: pop
        //   169: invokestatic 175	com/tencent/wecall/talkroom/model/f:ivc	()Lcom/tencent/pb/talkroom/sdk/e;
        //   172: astore 4
        //   174: aload 4
        //   176: ifnull +11 -> 187
        //   179: aload 4
        //   181: invokeinterface 181 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   191: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   194: getfield 168	com/tencent/wecall/talkroom/model/b:ZVf	Lcom/tencent/mm/plugin/multi/talk;
        //   197: astore 6
        //   199: getstatic 162	com/tencent/pb/common/a/a:ZdM	Z
        //   202: ifeq +83 -> 285
        //   205: new 183	java/util/concurrent/atomic/AtomicInteger
        //   208: dup
        //   209: invokespecial 184	java/util/concurrent/atomic/AtomicInteger:<init>	()V
        //   212: astore 4
        //   214: new 183	java/util/concurrent/atomic/AtomicInteger
        //   217: dup
        //   218: invokespecial 184	java/util/concurrent/atomic/AtomicInteger:<init>	()V
        //   221: astore 5
        //   223: aload 6
        //   225: aload 4
        //   227: aload 5
        //   229: invokevirtual 190	com/tencent/mm/plugin/multi/talk:getSampleRate	(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)I
        //   232: pop
        //   233: aload 4
        //   235: invokevirtual 193	java/util/concurrent/atomic/AtomicInteger:get	()I
        //   238: istore_1
        //   239: aload 5
        //   241: invokevirtual 193	java/util/concurrent/atomic/AtomicInteger:get	()I
        //   244: istore_2
        //   245: iload_1
        //   246: putstatic 196	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
        //   249: iload_2
        //   250: putstatic 199	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
        //   253: ldc 201
        //   255: iconst_3
        //   256: anewarray 4	java/lang/Object
        //   259: dup
        //   260: iconst_0
        //   261: ldc 203
        //   263: aastore
        //   264: dup
        //   265: iconst_1
        //   266: getstatic 196	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
        //   269: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   272: aastore
        //   273: dup
        //   274: iconst_2
        //   275: getstatic 199	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
        //   278: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   281: aastore
        //   282: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   285: new 36	android/os/Handler
        //   288: dup
        //   289: invokestatic 42	android/os/Looper:getMainLooper	()Landroid/os/Looper;
        //   292: invokespecial 45	android/os/Handler:<init>	(Landroid/os/Looper;)V
        //   295: new 13	com/tencent/wecall/talkroom/model/f$1$1
        //   298: dup
        //   299: aload_0
        //   300: invokespecial 206	com/tencent/wecall/talkroom/model/f$1$1:<init>	(Lcom/tencent/wecall/talkroom/model/f$1;)V
        //   303: invokevirtual 52	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   306: pop
        //   307: aload_0
        //   308: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   311: getfield 77	com/tencent/wecall/talkroom/model/f:ZVU	Lcom/tencent/wecall/talkroom/model/h;
        //   314: astore 4
        //   316: aload 4
        //   318: getfield 87	com/tencent/wecall/talkroom/model/h:ZXF	J
        //   321: lconst_0
        //   322: lcmp
        //   323: ifne +317 -> 640
        //   326: aload 4
        //   328: lconst_0
        //   329: putfield 209	com/tencent/wecall/talkroom/model/h:ZXu	J
        //   332: getstatic 94	com/tencent/wecall/talkroom/model/h:TAG	Ljava/lang/String;
        //   335: iconst_3
        //   336: anewarray 4	java/lang/Object
        //   339: dup
        //   340: iconst_0
        //   341: ldc 211
        //   343: aastore
        //   344: dup
        //   345: iconst_1
        //   346: aload 4
        //   348: getfield 209	com/tencent/wecall/talkroom/model/h:ZXu	J
        //   351: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   354: aastore
        //   355: dup
        //   356: iconst_2
        //   357: aload 4
        //   359: getfield 87	com/tencent/wecall/talkroom/model/h:ZXF	J
        //   362: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   365: aastore
        //   366: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   369: aload_0
        //   370: getfield 22	com/tencent/wecall/talkroom/model/f$1:ZWv	Lcom/tencent/wecall/talkroom/model/f;
        //   373: invokestatic 215	com/tencent/wecall/talkroom/model/f:f	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/g;
        //   376: astore 4
        //   378: new 217	com/tencent/wecall/talkroom/model/g$6
        //   381: dup
        //   382: aload 4
        //   384: invokespecial 220	com/tencent/wecall/talkroom/model/g$6:<init>	(Lcom/tencent/wecall/talkroom/model/g;)V
        //   387: astore 5
        //   389: invokestatic 223	android/os/Looper:myLooper	()Landroid/os/Looper;
        //   392: invokestatic 42	android/os/Looper:getMainLooper	()Landroid/os/Looper;
        //   395: if_acmpne +262 -> 657
        //   398: aload 5
        //   400: invokeinterface 228 1 0
        //   405: ldc 121
        //   407: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   410: return
        //   411: astore 4
        //   413: ldc 59
        //   415: iconst_2
        //   416: anewarray 4	java/lang/Object
        //   419: dup
        //   420: iconst_0
        //   421: ldc 230
        //   423: aastore
        //   424: dup
        //   425: iconst_1
        //   426: aload 4
        //   428: aastore
        //   429: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   432: ldc 121
        //   434: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   437: return
        //   438: aload 4
        //   440: aload 7
        //   442: invokevirtual 234	com/tencent/wecall/talkroom/model/c:bEf	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
        //   445: astore 7
        //   447: aload 5
        //   449: astore 4
        //   451: aload 7
        //   453: ifnull -344 -> 109
        //   456: aload 7
        //   458: invokevirtual 240	com/tencent/wecall/talkroom/model/TalkRoom:iuz	()Ljava/util/List;
        //   461: astore 7
        //   463: aload 5
        //   465: astore 4
        //   467: aload 7
        //   469: ifnull -360 -> 109
        //   472: aload 7
        //   474: invokeinterface 245 1 0
        //   479: newarray int
        //   481: astore 4
        //   483: new 247	java/lang/StringBuffer
        //   486: dup
        //   487: invokespecial 248	java/lang/StringBuffer:<init>	()V
        //   490: astore 5
        //   492: iconst_0
        //   493: istore_1
        //   494: iload_1
        //   495: aload 7
        //   497: invokeinterface 245 1 0
        //   502: if_icmpge +52 -> 554
        //   505: aload 7
        //   507: iload_1
        //   508: invokeinterface 251 2 0
        //   513: checkcast 253	com/tencent/wecall/talkroom/model/d
        //   516: astore 8
        //   518: aload 8
        //   520: ifnull +154 -> 674
        //   523: aload 4
        //   525: iload_1
        //   526: aload 8
        //   528: invokevirtual 256	com/tencent/wecall/talkroom/model/d:getMemberId	()I
        //   531: iastore
        //   532: aload 5
        //   534: aload 4
        //   536: iload_1
        //   537: iaload
        //   538: invokevirtual 260	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
        //   541: pop
        //   542: aload 5
        //   544: ldc_w 262
        //   547: invokevirtual 265	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   550: pop
        //   551: goto +123 -> 674
        //   554: ldc_w 267
        //   557: iconst_2
        //   558: anewarray 4	java/lang/Object
        //   561: dup
        //   562: iconst_0
        //   563: ldc_w 269
        //   566: aastore
        //   567: dup
        //   568: iconst_1
        //   569: aload 5
        //   571: invokevirtual 273	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   574: aastore
        //   575: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   578: goto -469 -> 109
        //   581: iload_3
        //   582: ifeq +18 -> 600
        //   585: aload 4
        //   587: getfield 168	com/tencent/wecall/talkroom/model/b:ZVf	Lcom/tencent/mm/plugin/multi/talk;
        //   590: sipush 401
        //   593: invokevirtual 277	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   596: pop
        //   597: goto -444 -> 153
        //   600: aload 4
        //   602: getfield 168	com/tencent/wecall/talkroom/model/b:ZVf	Lcom/tencent/mm/plugin/multi/talk;
        //   605: sipush 402
        //   608: invokevirtual 277	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   611: pop
        //   612: goto -459 -> 153
        //   615: astore 6
        //   617: ldc 201
        //   619: iconst_2
        //   620: anewarray 4	java/lang/Object
        //   623: dup
        //   624: iconst_0
        //   625: ldc_w 279
        //   628: aastore
        //   629: dup
        //   630: iconst_1
        //   631: aload 6
        //   633: aastore
        //   634: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   637: goto -404 -> 233
        //   640: aload 4
        //   642: invokestatic 117	java/lang/System:currentTimeMillis	()J
        //   645: aload 4
        //   647: getfield 87	com/tencent/wecall/talkroom/model/h:ZXF	J
        //   650: lsub
        //   651: putfield 209	com/tencent/wecall/talkroom/model/h:ZXu	J
        //   654: goto -322 -> 332
        //   657: aload 4
        //   659: getfield 285	com/tencent/wecall/talkroom/model/g:handler	Landroid/os/Handler;
        //   662: aload 5
        //   664: invokevirtual 52	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   667: pop
        //   668: ldc 121
        //   670: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   673: return
        //   674: iload_1
        //   675: iconst_1
        //   676: iadd
        //   677: istore_1
        //   678: goto -184 -> 494
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	681	0	this	1
        //   238	440	1	i	int
        //   244	6	2	j	int
        //   138	444	3	bool	boolean
        //   86	297	4	localObject1	Object
        //   411	28	4	localThrowable1	Throwable
        //   449	209	4	localObject2	Object
        //   1	662	5	localObject3	Object
        //   81	143	6	localObject4	Object
        //   615	17	6	localThrowable2	Throwable
        //   95	411	7	localObject5	Object
        //   516	11	8	locald	d
        // Exception table:
        //   from	to	target	type
        //   77	105	411	java/lang/Throwable
        //   109	153	411	java/lang/Throwable
        //   153	174	411	java/lang/Throwable
        //   179	187	411	java/lang/Throwable
        //   187	223	411	java/lang/Throwable
        //   233	285	411	java/lang/Throwable
        //   285	332	411	java/lang/Throwable
        //   332	410	411	java/lang/Throwable
        //   438	447	411	java/lang/Throwable
        //   456	463	411	java/lang/Throwable
        //   472	492	411	java/lang/Throwable
        //   494	518	411	java/lang/Throwable
        //   523	551	411	java/lang/Throwable
        //   554	578	411	java/lang/Throwable
        //   585	597	411	java/lang/Throwable
        //   600	612	411	java/lang/Throwable
        //   617	637	411	java/lang/Throwable
        //   640	654	411	java/lang/Throwable
        //   657	668	411	java/lang/Throwable
        //   223	233	615	java/lang/Throwable
      }
      
      public final void keep_OnReportChannel(String paramAnonymousString)
      {
        AppMethodBeat.i(62608);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportChannel:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bCH(f.this.ZWg));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bEs(localStringBuilder.toString());
        AppMethodBeat.o(62608);
      }
      
      public final void keep_OnReportEngineRecv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62606);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bCH(f.this.ZWg));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bEq(localStringBuilder.toString());
        AppMethodBeat.o(62606);
      }
      
      public final void keep_OnReportEngineSend(String paramAnonymousString)
      {
        AppMethodBeat.i(62607);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bCH(f.this.ZWg));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bEr(localStringBuilder.toString());
        AppMethodBeat.o(62607);
      }
      
      final class a
        implements Runnable
      {
        int ZWA;
        int ZWB;
        int ZWx;
        int ZWy;
        int ZWz;
        
        a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
          this.ZWx = paramInt1;
          this.ZWz = paramInt2;
          this.ZWA = paramInt3;
          this.ZWB = paramInt4;
          this.ZWy = paramInt5;
        }
        
        public final void run()
        {
          AppMethodBeat.i(62585);
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "keep_OnError handler" });
          h.aCB(this.ZWA);
          f.this.ZVU.aCC(this.ZWz);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.ZWy) });
          f.this.a(f.b(f.this), f.g(f.this), f.h(f.this), this.ZWB, true);
          f.f(f.this).r(this.ZWx, null);
          AppMethodBeat.o(62585);
        }
      }
    };
    AppMethodBeat.o(62724);
    return true;
  }
  
  public final void iuQ()
  {
    AppMethodBeat.i(62726);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.ZWs != null) {
        this.mHandler.removeCallbacks(this.ZWs);
      }
      AppMethodBeat.o(62726);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { " stopTimer: ", localThrowable });
      AppMethodBeat.o(62726);
    }
  }
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(209093);
    if ((this.EmI) && (this.ZVV != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        b localb = this.ZVV;
        if ((paramArrayOfByte1 == null) || (localb.ZVf == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:screenTrans null, buf:", paramArrayOfByte1, ", engine:", localb.ZVf });
          paramInt4 = -1;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "screenTrans finished, ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.EmI), " engine: ", this.ZVV });
          AppMethodBeat.o(209093);
          return paramInt4;
        }
        paramInt4 = localb.ZVf.screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
        continue;
        paramInt4 = 0;
      }
      catch (Exception paramArrayOfByte1)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "videoTrans error: ", paramArrayOfByte1 });
      }
    }
  }
  
  final void setState(int paramInt)
  {
    AppMethodBeat.i(62728);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setState newState: ", Integer.valueOf(paramInt) });
    if (this.state == paramInt)
    {
      AppMethodBeat.o(62728);
      return;
    }
    this.state = paramInt;
    this.ZWc.onStateChanged(paramInt);
    AppMethodBeat.o(62728);
  }
  
  public final void ux(boolean paramBoolean)
  {
    AppMethodBeat.i(62766);
    try
    {
      aeJ();
      iuS();
      if (paramBoolean)
      {
        iuX();
        bRC();
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(62766);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean), localThrowable });
      AppMethodBeat.o(62766);
    }
  }
  
  final class a
  {
    String[] ZWP;
    a.bd ZWQ;
    long ZWR;
    String ZWS;
    boolean ZWT;
    String ZWU;
    int ZeV;
    String groupId;
    int type;
    
    a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(62686);
      ZWV = new b("OK", 0);
      ZWW = new b("NOT_AUTH", 1);
      ZWX = new b("NOT_BIND", 2);
      ZWY = new b("NOT_MATCH", 3);
      ZWZ = new b("NO_NETWORK", 4);
      ZXa = new b("BUSY", 5);
      ZXb = new b("NOT_VALID_STATE", 6);
      ZXc = new b("GROUP_NOT_VALID", 7);
      ZXd = new b("UNINIT_SERVICE_FAILED", 8);
      ZXe = new b("INIT_ENGINE_FAILED", 9);
      ZXf = new b[] { ZWV, ZWW, ZWX, ZWY, ZWZ, ZXa, ZXb, ZXc, ZXd, ZXe };
      AppMethodBeat.o(62686);
    }
    
    private b() {}
  }
  
  final class c
  {
    long DPJ;
    String ZXg;
    int ZeV;
    String groupId;
    int roomId;
    int xbJ;
    
    c() {}
  }
  
  final class d {}
  
  final class e
  {
    long DPJ;
    String groupId;
    int roomId;
    
    e() {}
  }
  
  public static abstract interface f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */