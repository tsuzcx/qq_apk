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
import com.tencent.mm.plugin.multi.talk.a;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.ad;
import com.tencent.pb.common.b.a.a.a.ae;
import com.tencent.pb.common.b.a.a.a.aj;
import com.tencent.pb.common.b.a.a.a.al;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bc;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.common.b.a.a.a.q;
import com.tencent.pb.common.b.a.a.a.r;
import com.tencent.pb.common.b.a.a.a.s;
import com.tencent.pb.common.b.a.a.a.t;
import com.tencent.pb.common.b.a.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.a.n;
import com.tencent.wecall.talkroom.a.o;
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
  implements Handler.Callback, com.tencent.g.a.d, com.tencent.pb.common.b.b
{
  private static com.tencent.pb.talkroom.sdk.e RCV;
  private static int SuD;
  public static List<Integer> Sux;
  public static String[] Svj;
  boolean GUf;
  public long HgX;
  int RCJ;
  private com.tencent.g.a.a Spf;
  private final int SuA;
  private final int SuB;
  private final int SuC;
  private boolean SuE;
  private boolean SuF;
  private String SuG;
  public String SuH;
  private int SuI;
  private int SuJ;
  private int SuK;
  private long SuL;
  private boolean SuM;
  private int SuN;
  private int SuO;
  int SuP;
  int SuQ;
  private int SuR;
  private int SuS;
  private int SuT;
  private int SuU;
  private int SuV;
  private int SuW;
  private int SuX;
  public h SuY;
  b SuZ;
  f Suw;
  private Map<String, e> Suy;
  private final int Suz;
  private talk.a Sva;
  private TimerTask Svb;
  private TimerTask Svc;
  private Timer Svd;
  private TimerTask Sve;
  private Timer Svf;
  g Svg;
  private int Svh;
  private boolean Svi;
  public String Svk;
  HashSet<Long> Svl;
  public boolean Svm;
  public boolean Svn;
  public boolean Svo;
  private short[] Svp;
  private String[] Svq;
  private short[] Svr;
  private String[] Svs;
  private int Svt;
  public boolean Svu;
  public boolean Svv;
  private Runnable Svw;
  private com.tencent.pb.common.b.d Svx;
  private Runnable Svy;
  Handler mHandler;
  boolean mIsMute;
  int state;
  public String xOr;
  boolean yIP;
  public int yvK;
  
  static
  {
    AppMethodBeat.i(62787);
    RCV = null;
    Sux = new ArrayList();
    SuD = 30000;
    Svj = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(62787);
  }
  
  public f()
  {
    AppMethodBeat.i(62723);
    this.Suy = new HashMap();
    this.Suz = 1;
    this.SuA = 2;
    this.SuB = 3;
    this.SuC = 4;
    this.state = 0;
    this.GUf = false;
    this.SuE = false;
    this.SuF = false;
    this.yIP = false;
    this.SuI = 0;
    this.SuJ = 0;
    this.SuK = 0;
    this.SuL = 0L;
    this.SuM = true;
    this.SuN = 0;
    this.SuO = 0;
    this.SuP = 0;
    this.SuQ = -1;
    this.SuR = -1;
    this.SuS = -1;
    this.SuT = -1;
    this.SuU = -1;
    this.SuV = -1;
    this.SuW = -1;
    this.SuX = -1;
    this.SuY = h.Sws;
    this.Svd = new Timer("TalkRoomService_HelloTimer");
    this.Svf = new Timer("TalkRoomService_talkDurationTimer");
    this.Svg = new g();
    this.Svh = 0;
    this.Svi = false;
    this.Svk = null;
    this.Svl = new HashSet();
    this.Svm = false;
    this.Svn = true;
    this.Svo = true;
    this.Svp = null;
    this.Svq = null;
    this.Svr = null;
    this.Svs = null;
    this.Svt = 0;
    this.mIsMute = false;
    this.Svu = false;
    this.Svv = true;
    this.Svw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62550);
        if ((f.this.fGt()) && (f.s(f.this)))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
          h.asL(-2003);
          f.this.SuY.asO(401);
          f.this.aY(f.b(f.this), 3, 108);
        }
        AppMethodBeat.o(62550);
      }
    };
    this.Svx = null;
    this.Svy = new Runnable()
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
        if (!f.this.fGt())
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
              if (f.a(f.this, locale.xOr, locale.yvK, locale.HgX, f.asJ(locale.SwU)))
              {
                localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
              }
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.pb.common.b.e.hiW().a((com.tencent.pb.common.b.d)localObject1);
          AppMethodBeat.o(62587);
          return;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        AppMethodBeat.o(62587);
      }
    };
    com.tencent.pb.common.b.e.hiW().a(201, this);
    com.tencent.pb.common.b.e.hiW().a(202, this);
    com.tencent.pb.common.b.e.hiW().a(203, this);
    com.tencent.pb.common.b.e.hiW().a(204, this);
    com.tencent.pb.common.b.e.hiW().a(205, this);
    com.tencent.pb.common.b.e.hiW().a(206, this);
    com.tencent.pb.common.b.e.hiW().a(207, this);
    com.tencent.pb.common.b.e.hiW().a(208, this);
    com.tencent.pb.common.b.e.hiW().a(210, this);
    com.tencent.pb.common.b.e.hiW().a(209, this);
    com.tencent.pb.common.b.e.hiW().a(211, this);
    com.tencent.pb.common.b.e.hiW().a(212, this);
    com.tencent.pb.common.b.e.hiW().a(213, this);
    com.tencent.pb.common.b.e.hiW().a(214, this);
    com.tencent.pb.common.b.e.hiW().a(800, this);
    com.tencent.pb.common.b.e.hiW().a(801, this);
    com.tencent.pb.common.b.e.hiW().a(802, this);
    Object localObject = c.hqY();
    g localg = this.Svg;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).Suo = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      hrf();
      if (this.Spf == null) {
        this.Spf = ((com.tencent.g.a.a)com.tencent.g.f.bqW("EventCenter"));
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.Spf.a(this, Svj);
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
      String str = c.hqY().M(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.GUf), " mTalkDuration: ", Integer.valueOf(this.SuI), " msgKey: ", str });
      AppMethodBeat.o(62772);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(62772);
    }
  }
  
  private boolean ZZ()
  {
    AppMethodBeat.i(62739);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = RCV;
      if (locale == null) {
        break label99;
      }
      this.SuY.HaQ = locale.emS();
      this.SuY.HaM = locale.emT();
      bool = locale.emQ();
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
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    AppMethodBeat.i(62747);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.roomId, paramh.ypH, false)) {
        this.SuY.ag(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62747);
      return;
    }
    paramObject = (a.an)paramObject;
    if (!b(paramObject.groupId, paramObject.GXO, paramObject.GXP, false))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.GXO), Integer.valueOf(this.yvK) });
      AppMethodBeat.o(62747);
      return;
    }
    this.SuY.ag(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.RCJ, paramObject.GXO, paramObject.GXP, paramObject.REK, paramObject.REM, paramObject.RDq, false, false);
    a(paramObject.REL, paramObject.RES, paramObject.RET);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect type:", Integer.valueOf(this.SuO) });
    if (this.SuO == 0)
    {
      paramh = new byte[paramObject.REO.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.REO.length)
      {
        paramh[paramInt1] = ((byte)paramObject.REO[paramInt1]);
        paramInt1 += 1;
      }
      localObject1 = new int[paramObject.REY.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.REY.length)
      {
        localObject1[paramInt1] = paramObject.REY[paramInt1];
        paramInt1 += 1;
      }
      if (this.SuZ != null)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.SuZ.Close()) });
        localObject2 = paramObject.REK;
        localObject3 = paramObject.RDY;
        if ((paramObject.REN & 0x2) == 0) {
          break label547;
        }
      }
      label547:
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.bb[])localObject2, (a.ay)localObject3, paramh, bool, paramObject.groupId, paramObject.GXO, paramObject.GXP, paramObject.REU, paramObject.REW, paramObject.REX, (int[])localObject1, paramObject.REa, this.SuP);
        AppMethodBeat.o(62747);
        return;
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp engine close but nullptr" });
        AppMethodBeat.o(62747);
        return;
      }
    }
    paramInt1 = k.lx(com.tencent.pb.common.c.c.Hhs);
    com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "amyfwang,Redirect::netType:", Integer.valueOf(paramInt1) });
    paramObject = this.SuZ;
    paramh = this.Svq;
    Object localObject1 = this.Svp;
    Object localObject2 = this.Svs;
    Object localObject3 = this.Svr;
    if (paramObject.Suj != null) {
      paramObject.Suj.Redirect(paramh, (short[])localObject1, (String[])localObject2, (short[])localObject3, paramInt1);
    }
    AppMethodBeat.o(62747);
  }
  
  private void a(int paramInt, a.ac paramac, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(199689);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.xOr, Integer.valueOf(parame.yvK), Long.valueOf(parame.HgX), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111), Integer.valueOf(14287), Integer.valueOf(-1112) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.asK(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramac.groupId, Integer.valueOf(paramac.GXO), Long.valueOf(paramac.GXP) });
      this.Svg.n(-14255, paramac);
      AppMethodBeat.o(199689);
      return;
    }
    if (paramInt == 14287)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14287), paramac.groupId, Integer.valueOf(paramac.GXO), Long.valueOf(paramac.GXP) });
      this.Svg.n(-14287, paramac);
      AppMethodBeat.o(199689);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramac.groupId, Integer.valueOf(paramac.GXO), Long.valueOf(paramac.GXP) });
      this.Svg.n(-14256, paramac);
      AppMethodBeat.o(199689);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.xOr, parame.yvK, parame.HgX, asI(parame.SwU)))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.xOr, " mGroupId: ", this.xOr, Integer.valueOf(parame.yvK), Integer.valueOf(this.yvK), Long.valueOf(parame.HgX), Long.valueOf(this.HgX) });
        AppMethodBeat.o(199689);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.xOr, Integer.valueOf(parame.yvK), Long.valueOf(parame.HgX) });
        AppMethodBeat.o(199689);
        return;
      }
      this.SuY.ag(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.SuY.asO(322);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.xOr, Integer.valueOf(parame.yvK), Long.valueOf(parame.HgX) });
      a(parame.xOr, parame.yvK, parame.HgX, true);
      if (paramInt == 14251)
      {
        this.Svg.n(-1000, null);
        AppMethodBeat.o(199689);
        return;
      }
      if (paramInt == 14252)
      {
        this.Svg.n(-1200, null);
        AppMethodBeat.o(199689);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramac != null) {
          parame = Integer.valueOf(paramac.REQ);
        }
        this.Svg.n(-1500, parame);
        AppMethodBeat.o(199689);
        return;
      }
      this.Svg.n(-200, null);
      AppMethodBeat.o(199689);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramac.groupId, Integer.valueOf(paramac.GXO), Long.valueOf(paramac.GXP) });
      AppMethodBeat.o(199689);
      return;
    }
    if (!b(paramac.groupId, paramac.GXO, paramac.GXP, asI(paramac.vkj)))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramac.groupId, " mGroupId: ", this.xOr, Integer.valueOf(paramac.GXO), Integer.valueOf(this.yvK), Long.valueOf(paramac.GXP), Long.valueOf(this.HgX) });
      a(paramac.groupId, paramac.GXO, paramac.GXP, 111, false);
      h.asK(-1110);
      AppMethodBeat.o(199689);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramac.groupId, Integer.valueOf(paramac.GXO), Long.valueOf(paramac.GXP) });
      AppMethodBeat.o(199689);
      return;
    }
    this.SuY.ag(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramac.REL == null) || (paramac.REL.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramac.groupId, Integer.valueOf(paramac.GXO), Long.valueOf(paramac.GXP) });
      h.asK(-1605);
      this.SuY.Hre = 329;
      a(paramac.groupId, paramac.GXO, paramac.GXP, 116, true);
      this.Svg.n(-200, null);
      AppMethodBeat.o(199689);
      return;
    }
    this.xOr = paramac.groupId;
    this.Svk = paramac.groupId;
    this.yvK = paramac.GXO;
    this.HgX = paramac.GXP;
    setState(4);
    a(paramac.REL, paramac.RES, paramac.RET);
    a(paramac.groupId, null, this.RCJ, paramac.GXO, paramac.GXP, paramac.REK, paramac.REM, paramac.RDq, false, true);
    parame = this.Svg;
    localObject = new g.10(parame, c.hqY().brn(paramac.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramac.REO.length];
      paramInt = 0;
      while (paramInt < paramac.REO.length)
      {
        parame[paramInt] = ((byte)paramac.REO[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramac.REY.length];
    paramInt = 0;
    while (paramInt < paramac.REY.length)
    {
      localObject[paramInt] = paramac.REY[paramInt];
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(paramac.REY.length), " redirect type:", Integer.valueOf(localObject[talk.zGz]), " SimpleRedirect value:", Integer.valueOf(talk.zGz) });
    a.bb[] arrayOfbb = paramac.REK;
    a.ay localay = paramac.RDY;
    if ((paramac.REN & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfbb, localay, parame, bool, paramac.groupId, paramac.GXO, paramac.GXP, paramac.REU, paramac.REW, paramac.REX, (int[])localObject, paramac.REa, this.SuP);
      if (paramac.RER != 0)
      {
        com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramac.RER });
        SuD = paramac.RER * 1000;
      }
      hrk();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX) });
      AppMethodBeat.o(199689);
      return;
    }
  }
  
  private void a(int paramInt, a.al paramal)
  {
    AppMethodBeat.i(199688);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.Svg.ki(null);
      AppMethodBeat.o(199688);
      return;
    }
    paramal = paramal.RFi;
    if ((paramal == null) || (paramal.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(199688);
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
        a(localObject.groupId, null, 0, localObject.GXO, localObject.GXP, localObject.REK, null, null, false, false);
        localArrayList.add(c.hqY().brn(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.Svg.ki(localArrayList);
    AppMethodBeat.o(199688);
  }
  
  /* Error */
  private void a(final int paramInt1, final a.bb[] paramArrayOfbb, final a.ay paramay, final byte[] paramArrayOfByte1, final boolean paramBoolean, final String paramString, final int paramInt2, final long paramLong, int paramInt3, final int paramInt4, final byte[] paramArrayOfByte2, final int[] paramArrayOfInt, final int paramInt5, final int paramInt6)
  {
    // Byte code:
    //   0: ldc_w 793
    //   3: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 330
    //   9: bipush 6
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 795
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
    //   44: invokestatic 601	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_5
    //   50: aload_0
    //   51: getfield 191	com/tencent/wecall/talkroom/model/f:state	I
    //   54: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 375	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 527	com/tencent/wecall/talkroom/model/f:SuZ	Lcom/tencent/wecall/talkroom/model/b;
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
    //   89: iload 15
    //   91: invokespecial 798	com/tencent/wecall/talkroom/model/f:a	([Lcom/tencent/pb/common/b/a/a/a$bb;Lcom/tencent/pb/common/b/a/a/a$ay;[BZIJII[B[III)Z
    //   94: istore 16
    //   96: ldc_w 330
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 800
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: iload 16
    //   113: invokestatic 397	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: aastore
    //   117: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: iload 16
    //   122: ifeq +39 -> 161
    //   125: ldc_w 793
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
    //   146: ldc_w 802
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
    //   166: getfield 238	com/tencent/wecall/talkroom/model/f:SuY	Lcom/tencent/wecall/talkroom/model/h;
    //   169: sipush 202
    //   172: invokevirtual 659	com/tencent/wecall/talkroom/model/h:asO	(I)V
    //   175: ldc_w 330
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc_w 804
    //   187: aastore
    //   188: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: aload 6
    //   194: iload 7
    //   196: lload 8
    //   198: bipush 102
    //   200: iconst_1
    //   201: invokevirtual 679	com/tencent/wecall/talkroom/model/f:a	(Ljava/lang/String;IJIZ)Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 256	com/tencent/wecall/talkroom/model/f:Svg	Lcom/tencent/wecall/talkroom/model/g;
    //   209: sipush -400
    //   212: aconst_null
    //   213: invokevirtual 637	com/tencent/wecall/talkroom/model/g:n	(ILjava/lang/Object;)V
    //   216: ldc_w 793
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
    //   255: iload 15
    //   257: invokespecial 807	com/tencent/wecall/talkroom/model/f$4:<init>	(Lcom/tencent/wecall/talkroom/model/f;I[Lcom/tencent/pb/common/b/a/a/a$bb;Lcom/tencent/pb/common/b/a/a/a$ay;[BZLjava/lang/String;IJII[B[III)V
    //   260: ldc2_w 808
    //   263: invokevirtual 813	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   266: pop
    //   267: ldc_w 793
    //   270: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: return
    //   274: astore 17
    //   276: goto -139 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	f
    //   0	279	1	paramInt1	int
    //   0	279	2	paramArrayOfbb	a.bb[]
    //   0	279	3	paramay	a.ay
    //   0	279	4	paramArrayOfByte1	byte[]
    //   0	279	5	paramBoolean	boolean
    //   0	279	6	paramString	String
    //   0	279	7	paramInt2	int
    //   0	279	8	paramLong	long
    //   0	279	10	paramInt3	int
    //   0	279	11	paramInt4	int
    //   0	279	12	paramArrayOfByte2	byte[]
    //   0	279	13	paramArrayOfInt	int[]
    //   0	279	14	paramInt5	int
    //   0	279	15	paramInt6	int
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
    RCV = parame;
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
    if (!asI(paramInt3)) {
      this.SuY.hry();
    }
    this.SuY.hrx();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.SuZ.hqV(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.hiW().a(paramString1);
    c(paramString1);
    AppMethodBeat.o(62731);
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.yvK = paramInt;
    this.HgX = paramLong;
    this.xOr = paramString2;
    this.SuH = paramString1;
    this.SuG = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62754);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(62754);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.bb[] paramArrayOfbb)
  {
    AppMethodBeat.i(199692);
    if (paramArrayOfbb == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(199692);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfbb.length;
    int i = 0;
    while (i < j)
    {
      a.bb localbb = paramArrayOfbb[i];
      if (localbb != null) {
        localStringBuffer.append(" memberId:" + localbb.qrD + " uuid: " + localbb.dLN + " status: " + localbb.status + "   mem.inviteTime:" + localbb.RGf + "  mem.reason: " + localbb.bDZ + "  mem.inviteuuid: " + localbb.RGr + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfbb.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(199692);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.bb[] paramArrayOfbb, a.bc[] paramArrayOfbc, a.az paramaz, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199690);
    a(paramString1, paramInt2, paramLong, paramArrayOfbb);
    c localc = c.hqY();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.xOr == null) || (!this.xOr.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramaz, paramArrayOfbb, paramArrayOfbc, paramBoolean1, bool);
      paramString2 = this.xOr;
      i = this.yvK;
      l = this.HgX;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfbb == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfbb.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.SuM) });
      if (c.hqY().dG(this.xOr, false))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.SuM), " mGroupId: ", this.xOr, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.SuM)
        {
          this.SuM = false;
          this.yIP = true;
          this.Svi = k.hrC();
          this.SuK = this.SuI;
          hrp();
        }
      }
      if (paramArrayOfbb != null) {
        break label380;
      }
      AppMethodBeat.o(199690);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfbb.length > 0) && (this.SuZ != null)) {
      a(paramArrayOfbb);
    }
    AppMethodBeat.o(199690);
  }
  
  private void a(a.bb[] paramArrayOfbb)
  {
    AppMethodBeat.i(199691);
    if (paramArrayOfbb == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(199691);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfbb.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfbb.length)
    {
      arrayOfInt[i] = paramArrayOfbb[i].qrD;
      localStringBuffer.append(paramArrayOfbb[i].qrD);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.SuZ == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(199691);
      return;
    }
    this.SuZ.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(199691);
  }
  
  private void a(a.q[] paramArrayOfq1, a.q[] paramArrayOfq2, int paramInt)
  {
    AppMethodBeat.i(199693);
    if (paramArrayOfq1 == null) {}
    for (int i = 0;; i = paramArrayOfq1.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfq1 != null) && (paramArrayOfq1.length > 0)) {
        break;
      }
      AppMethodBeat.o(199693);
      return;
    }
    this.Svq = new String[paramArrayOfq1.length];
    this.Svp = new short[paramArrayOfq1.length];
    this.Svs = new String[paramArrayOfq2.length];
    this.Svr = new short[paramArrayOfq2.length];
    this.Svt = paramInt;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.Svt) });
    int j = paramArrayOfq1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.q localq = paramArrayOfq1[paramInt];
      this.Svq[i] = localq.RDU;
      this.Svp[i] = ((short)localq.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData ip: ", localq.RDU, " addr.port: ", Integer.valueOf(localq.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfq2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfq1 = paramArrayOfq2[paramInt];
      this.Svs[i] = paramArrayOfq1.RDU;
      this.Svr[i] = ((short)paramArrayOfq1.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", paramArrayOfq1.RDU, " tcpAddr.port: ", Integer.valueOf(paramArrayOfq1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.Svq), Arrays.toString(this.Svp), this.xOr, this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Arrays.toString(this.Svs), Arrays.toString(this.Svr), Integer.valueOf(this.Svt) });
    AppMethodBeat.o(199693);
  }
  
  private boolean a(a.bb[] paramArrayOfbb, a.ay paramay, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(199695);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(199695);
      return false;
    }
    this.SuO = paramArrayOfInt[talk.zGz];
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit general policy cnt:", Integer.valueOf(paramArrayOfInt.length), ", redirect type:", this.SuO + " wifigateway:" + paramInt5 });
    paramBoolean = b(paramArrayOfbb, paramay, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
    AppMethodBeat.o(199695);
    return paramBoolean;
  }
  
  private void and()
  {
    AppMethodBeat.i(62727);
    this.Suy.remove(this.xOr);
    this.Svh = 0;
    this.mIsMute = false;
    setState(0);
    this.SuF = false;
    a(this.SuH, 0, 0L, null, null);
    this.SuH = null;
    this.RCJ = 0;
    this.SuI = 0;
    this.SuJ = 0;
    this.SuK = 0;
    this.SuM = true;
    this.Svn = true;
    this.SuL = 0L;
    this.SuN = 0;
    this.SuE = false;
    this.Svu = false;
    this.Svv = true;
    hrh();
    this.mHandler.removeMessages(1);
    if (this.SuZ != null) {
      this.SuZ.hqW();
    }
    hrm();
    hrl();
    hrn();
    hrq();
    this.yIP = false;
    this.Svm = false;
    this.SuO = 0;
    AppMethodBeat.o(62727);
  }
  
  private static boolean asI(int paramInt)
  {
    return paramInt != 1;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(62738);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = RCV;
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
      com.tencent.pb.talkroom.sdk.e locale = RCV;
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
      paramBoolean = com.tencent.pb.common.c.f.nG(paramString, this.xOr);
      AppMethodBeat.o(62771);
      return paramBoolean;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.xOr, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.yvK), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.HgX) });
    if ((com.tencent.pb.common.c.f.nG(paramString, this.xOr)) && (paramInt == this.yvK) && (paramLong == this.HgX))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    AppMethodBeat.o(62771);
    return false;
  }
  
  private boolean b(a.bb[] paramArrayOfbb, a.ay paramay, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(199696);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.xOr, " ip: ", Arrays.toString(this.Svq), " ports: ", Arrays.toString(this.Svp), " tcpIp: ", Arrays.toString(this.Svs), " tcpPorts: ", Arrays.toString(this.Svr), " tcpStartTime: ", Integer.valueOf(this.Svt), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.hjq();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfbb != null) && (paramArrayOfbb.length > 0))
    {
      localObject1 = new int[paramArrayOfbb.length];
      j = 0;
      while (j < paramArrayOfbb.length)
      {
        localObject1[j] = paramArrayOfbb[j].qrD;
        if (com.tencent.pb.common.c.f.equals(paramArrayOfbb[j].dLN, (String)localObject2)) {
          i = paramArrayOfbb[j].qrD;
        }
        j += 1;
      }
      paramArrayOfbb = (a.bb[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.hqY().bri(this.xOr);
      this.SuY.qrD = j;
      for (;;)
      {
        try
        {
          localObject2 = this.SuZ;
          locala = this.Sva;
          localObject3 = c.hqY();
          localObject1 = this.xOr;
          localObject3 = ((c)localObject3).brg((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.Svq;
          arrayOfShort1 = this.Svp;
          arrayOfString = this.Svs;
          arrayOfShort2 = this.Svr;
          m = this.Svt;
          localObject1 = null;
          if (paramay == null) {
            continue;
          }
          paramay = new i(paramay.RFx, paramay.iTa, paramay.iTb, paramay.RFy, paramay.RFz, paramay.RFA, paramay.RFB, paramay.RFC, paramay.RFD, paramay.RFE, paramay.RFF, paramay.RFG);
          n = k.lx(com.tencent.pb.common.c.c.Hhs);
          localObject1 = ((b)localObject2).Suj;
          if (localObject1 != null) {
            continue;
          }
          paramInt1 = -1;
        }
        catch (Throwable paramArrayOfbb)
        {
          talk.a locala;
          Object localObject3;
          short[] arrayOfShort1;
          String[] arrayOfString;
          short[] arrayOfShort2;
          int m;
          int n;
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "connectToCompenent", paramArrayOfbb });
          paramInt1 = -99999;
          continue;
          paramInt1 = ((b)localObject2).Suj.Open(locala, paramay, i, j, paramInt1, paramLong, (String[])localObject3, arrayOfShort1, 0, paramArrayOfbb, paramArrayOfByte1, paramBoolean, n, arrayOfString, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
          continue;
          paramArrayOfbb.handler.post(paramay);
          continue;
          AppMethodBeat.o(199696);
          return false;
        }
        paramArrayOfbb = this.Svg;
        paramay = new g.5(paramArrayOfbb, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramay.run();
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.asN(-3002);
        }
        if (paramInt1 == 0) {
          this.SuY.Hrh = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(199696);
        return true;
        localObject3 = ((TalkRoom)localObject3).brf(com.tencent.pb.a.a.a.hjq());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).Sup;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.bb)localObject3).KBb) });
            i = ((a.bb)localObject3).KBb;
            continue;
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramay = (a.ay)localObject1;
          }
        }
      }
      paramArrayOfbb = null;
    }
  }
  
  private void bFT()
  {
    AppMethodBeat.i(62767);
    ZZ();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c()
    {
      public final void ag(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            if ((com.tencent.pb.common.a.a.RCk) && (localb.Suj != null)) {
              break label140;
            }
          }
          for (;;)
          {
            if (f.this.Svn)
            {
              f.this.Svn = false;
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt) });
            }
            AppMethodBeat.o(62659);
            return;
            label140:
            localb.Suj.SendAudio(paramAnonymousArrayOfByte, s, 0);
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
      this.SuY.asO(101);
      h.asL(-2001);
      this.Svg.n(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.SuY;
    }
    for (localh.Swt &= 0xFFFFFFFE;; localh.Swt |= 0x1)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62767);
      return;
      localh = this.SuY;
    }
  }
  
  private void c(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62775);
    this.mHandler.removeCallbacks(this.Svy);
    this.Svx = paramd;
    this.mHandler.postDelayed(this.Svy, 3000L);
    AppMethodBeat.o(62775);
  }
  
  private boolean dy(int paramInt, String paramString)
  {
    AppMethodBeat.i(62732);
    if (paramInt == 100)
    {
      AppMethodBeat.o(62732);
      return true;
    }
    if (asI(paramInt))
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
      boolean bool = brp(paramString);
      AppMethodBeat.o(62732);
      return bool;
    }
    AppMethodBeat.o(62732);
    return false;
  }
  
  private void fuc()
  {
    AppMethodBeat.i(62741);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "releaseConpent" });
    try
    {
      ZZ();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          hrj();
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
  
  private boolean hL(String paramString, int paramInt)
  {
    AppMethodBeat.i(62735);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62735);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.RCJ);
    boolean bool = com.tencent.pb.common.b.e.hiW().a(localc);
    this.SuY.ag(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.yvK, this.HgX, true);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62735);
    return bool;
  }
  
  private void hrf()
  {
    AppMethodBeat.i(199683);
    this.SuR = -1;
    this.SuS = -1;
    this.SuT = -1;
    this.SuU = -1;
    this.SuV = -1;
    this.SuW = -1;
    this.SuX = -1;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "multitalk voiceMsg local seq reset" });
    AppMethodBeat.o(199683);
  }
  
  private int hri()
  {
    AppMethodBeat.i(62734);
    if (this.SuL == 0L)
    {
      AppMethodBeat.o(62734);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.SuL) / 1000L);
    AppMethodBeat.o(62734);
    return i;
  }
  
  private boolean hrj()
  {
    AppMethodBeat.i(62737);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = RCV;
      if (locale == null) {
        break label99;
      }
      this.SuY.HaY = locale.emR();
      this.SuY.HaN = locale.emU();
      bool = locale.emP();
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
  
  private void hrk()
  {
    AppMethodBeat.i(62759);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.Svb != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(62759);
      return;
    }
    try
    {
      this.Svb = new TimerTask()
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
      this.Svd.schedule(this.Svb, 0L, SuD);
      AppMethodBeat.o(62759);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(62759);
    }
  }
  
  private void hrl()
  {
    AppMethodBeat.i(62760);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.Svc != null) {
        this.Svc.cancel();
      }
      this.Svc = null;
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
  
  private void hrm()
  {
    AppMethodBeat.i(62761);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.Svb != null) {
        this.Svb.cancel();
      }
      this.Svb = null;
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
  
  private void hrn()
  {
    AppMethodBeat.i(62762);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.Sve != null) {
        this.Sve.cancel();
      }
      this.Sve = null;
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
  
  private void hro()
  {
    AppMethodBeat.i(62768);
    hrj();
    Object localObject = new AtomicInteger();
    final AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b()
    {
      public final int af(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            AtomicInteger localAtomicInteger1 = this.SvR;
            AtomicInteger localAtomicInteger2 = localAtomicInteger;
            if (com.tencent.pb.common.a.a.RCk) {
              if (localb.Suj == null)
              {
                break label169;
                if ((f.this.Svo) && (i >= 0))
                {
                  f.this.Svo = false;
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt), " ret: ", Integer.valueOf(i) });
                }
                AppMethodBeat.o(62788);
                return i;
              }
              else
              {
                i = localb.Suj.GetAudioData(paramAnonymousArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
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
      this.SuY.asO(101);
      h.asL(-2001);
      localObject = this.SuY;
      ((h)localObject).Swt |= 0x1;
      this.Svg.n(-500, null);
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62768);
  }
  
  private void hrp()
  {
    AppMethodBeat.i(62769);
    if (this.Sve != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(62769);
      return;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.Suw, " mIsHoldOn: ", Boolean.valueOf(this.Svu) });
    this.Sve = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(62661);
        if (!f.this.Svu)
        {
          f.a(f.this, f.n(f.this) + 1);
          if (f.o(f.this)) {
            f.b(f.this, f.p(f.this) + 1);
          }
          if ((f.q(f.this) == 3) || (f.q(f.this) == 2))
          {
            f.c(f.this, f.r(f.this) + 1);
            f.this.SuY.Hrs = f.r(f.this);
          }
          f.this.SuY.Swx = (f.n(f.this) * 1000);
          f.this.SuY.Hrr = f.n(f.this);
        }
        if (f.this.Suw != null) {
          f.n(f.this);
        }
        AppMethodBeat.o(62661);
      }
    };
    this.Svf.scheduleAtFixedRate(this.Sve, 1000L, 1000L);
    AppMethodBeat.o(62769);
  }
  
  private void hrq()
  {
    AppMethodBeat.i(62774);
    this.mHandler.removeCallbacks(this.Svy);
    this.Svx = null;
    AppMethodBeat.o(62774);
  }
  
  private static void hrr()
  {
    AppMethodBeat.i(62777);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.c.Hhs.getSystemService("audio");
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
  
  public static boolean hrs()
  {
    AppMethodBeat.i(62778);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.c.Hhs.getSystemService("audio")).isSpeakerphoneOn();
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
  
  public static com.tencent.pb.talkroom.sdk.e hrt()
  {
    return RCV;
  }
  
  static String[] kj(List<String> paramList)
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
  
  public final void Eh(boolean paramBoolean)
  {
    AppMethodBeat.i(62725);
    this.SuY.groupId = this.xOr;
    this.SuY.RDo = this.SuH;
    if (com.tencent.pb.common.c.f.eP(this.SuY.groupId)) {
      this.SuY.groupId = "";
    }
    if (com.tencent.pb.common.c.f.eP(this.SuY.RDo)) {
      this.SuY.RDo = "";
    }
    this.SuY.HaK = 1;
    this.SuY.roomId = this.yvK;
    this.SuY.ypH = this.HgX;
    hrf();
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    fuc();
    and();
    int j = -99999;
    int i = j;
    if (this.SuZ != null) {}
    try
    {
      this.Svh = this.SuZ.hqX();
      i = this.SuZ.Close();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.SuZ == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        j = this.SuZ.uninitLive();
        this.SuZ = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.SuY.hru();
          if ((!TextUtils.isEmpty(this.SuY.groupId)) || (!TextUtils.isEmpty(this.SuY.RDo)))
          {
            h.brq(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.SuY.reset();
          hrr();
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
  
  public final com.tencent.pb.talkroom.sdk.f R(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62745);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.yIP)
    {
      localObject = localf;
      if (this.SuZ == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo" });
        localb = this.SuZ;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfInt != null) && (localb.Suj != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", localb.Suj });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.yIP), " decInfo: ", paramArrayOfInt, " engine: ", this.SuZ });
      localObject = paramArrayOfInt;
      AppMethodBeat.o(62745);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.Suj.videoDecode(paramArrayOfInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHd = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHe = localb.Suj.field_remoteImgLength;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHf = localb.Suj.field_remoteImgWidth;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHg = localb.Suj.field_remoteImgHeight;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHh = (localb.Suj.field_remoteImgChannel & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHi = 0;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHb = c.hqY().hJ(a.hqJ().xOr, ((com.tencent.pb.talkroom.sdk.f)localObject).RHh);
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
    AppMethodBeat.i(199687);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.yIP)
    {
      localObject = localf;
      if (this.SuZ == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen" });
        localb = this.SuZ;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfByte != null) && (paramArrayOfInt != null) && (localb.Suj != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveScreen null, imgBuffer32:", paramArrayOfInt, ", engine:", localb.Suj });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen finished, ", Boolean.valueOf(this.yIP), " decInfo: ", paramArrayOfByte, " engine: ", this.SuZ });
      localObject = paramArrayOfByte;
      AppMethodBeat.o(199687);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.Suj.screenDecode(paramArrayOfByte, paramArrayOfInt, paramInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHj = paramArrayOfByte;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHd = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHe = localb.Suj.field_remoteImgLength_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHf = localb.Suj.field_remoteImgWidth_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHg = localb.Suj.field_remoteImgHeight_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHh = (localb.Suj.field_remoteImgChannel_screen & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHi = localb.Suj.field_remoteImgOrien_screen;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen channel:", Integer.valueOf(localb.Suj.field_remoteImgChannel_screen) });
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen field_remoteImgOrien:", Integer.valueOf(localb.Suj.field_remoteImgOrien_screen) });
      ((com.tencent.pb.talkroom.sdk.f)localObject).RHb = c.hqY().hJ(a.hqJ().xOr, ((com.tencent.pb.talkroom.sdk.f)localObject).RHh);
      if (paramArrayOfInt != null) {
        continue;
      }
      paramInt = 0;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "steve:receiveScreen imgBuffer32 size:", Integer.valueOf(paramInt), " MultiTalkVideoDecodeInfo: ", localObject });
      paramArrayOfByte = (byte[])localObject;
    }
  }
  
  public final b a(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    AppMethodBeat.i(183718);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.yvK), Integer.valueOf(paramInt1), Long.valueOf(this.HgX), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    this.SuP = paramInt4;
    if (!com.tencent.pb.a.a.a.hjr())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.hjr()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.hjs()) });
      h.a(paramString1, "", this.yvK, this.HgX, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = b.Swa;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((asI(paramInt3)) && (paramInt3 != 100) && (fGt()))
    {
      h.a(paramString1, "", this.yvK, this.HgX, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = b.Swe;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (!dy(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.yvK, this.HgX, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = b.Swf;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.yvK, this.HgX, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = b.Swg;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (asI(paramInt3))
    {
      this.SuY.reset();
      Eh(false);
    }
    hrg();
    if (!fuf())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (asI(paramInt3))
      {
        h.a(paramString1, "", this.yvK, this.HgX, new String[] { "enter", "req", "false", "initEnginefail" });
        Eh(false);
      }
      for (;;)
      {
        paramString1 = b.Swi;
        AppMethodBeat.o(183718);
        return paramString1;
        this.SuY.ag(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.xOr = paramString1;
    Object localObject;
    long l;
    label705:
    label711:
    boolean bool;
    if (!asI(paramInt3))
    {
      localObject = bro(paramString1);
      if (localObject == null)
      {
        paramInt4 = 0;
        this.yvK = paramInt4;
        if (localObject != null) {
          break label875;
        }
        l = 0L;
        this.HgX = l;
        this.Svk = paramString1;
        this.RCJ = paramInt2;
        setState(3);
        if (!asI(paramInt3)) {
          break label898;
        }
        bool = true;
        label738:
        this.GUf = bool;
        if (this.GUf) {
          this.SuY.hrv();
        }
        if ((!this.GUf) || (c.hqY().dG(this.xOr, true))) {
          break label904;
        }
        localObject = new c();
        ((c)localObject).groupId = paramString1;
        ((c)localObject).roomId = paramInt1;
        ((c)localObject).ypH = paramLong;
        ((c)localObject).vkj = paramInt3;
        ((c)localObject).RDt = paramInt2;
        ((c)localObject).Swk = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = localObject;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = b.SvZ;
      AppMethodBeat.o(183718);
      return paramString1;
      paramInt4 = ((e)localObject).roomId;
      break;
      label875:
      l = ((e)localObject).ypH;
      break label705;
      this.yvK = paramInt1;
      this.HgX = paramLong;
      break label711;
      label898:
      bool = false;
      break label738;
      label904:
      a(paramString1, this.yvK, this.HgX, paramInt2, paramInt3, paramString2);
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
        paramString = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542) });
        i = paramd.getType();
        if (paramString.containsKey(Integer.valueOf(i))) {
          h.asK(((Integer)paramString.get(Integer.valueOf(i))).intValue());
        }
      }
      if (paramInt2 != -1) {
        break label1225;
      }
      try
      {
        if (paramd.getType() == 201)
        {
          paramString = (com.tencent.wecall.talkroom.a.d)paramd;
          if (com.tencent.pb.common.c.f.nG(this.SuH, paramString.SuH))
          {
            this.SuY.asO(301);
            this.SuY.ag(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            hL(paramString.SuH, 1001);
            if (!paramString.SwT) {
              this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.Svg.n(-100, null);
          }
          AppMethodBeat.o(62742);
          return;
          paramString = "";
        }
        else if (paramd.getType() == 209)
        {
          paramString = (com.tencent.wecall.talkroom.a.g)paramd;
          this.Svg.hK(paramString.xOr, paramInt2);
          AppMethodBeat.o(62742);
          return;
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
      if (!b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
        h.a(paramString.xOr, paramString.yvK, paramString.HgX, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.Svg.a(paramString.SwS, c.hqY().brn(paramString.xOr));
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.xOr, paramString.yvK, paramString.HgX, false))
      {
        this.SuY.ag(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.Svg.n(-300, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.xOr, paramString.yvK, paramString.HgX, asI(paramString.SwU))) && (this.state == 3))
      {
        this.SuY.asO(302);
        this.Svg.n(-200, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.Svg.ki(null);
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 213)
    {
      if (com.tencent.pb.common.c.f.equals(((com.tencent.wecall.talkroom.a.j)paramd).xOr, this.xOr))
      {
        this.SuY.ag(new String[] { "sendmsg", "resp", "-1", String.valueOf(this.state) });
        this.Svg.n(-700, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (b(paramString.groupId, paramString.roomId, paramString.ypH, false)) {
        this.SuY.ag(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (n)paramd;
      if (b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
        this.Svg.n(-800, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      if (b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
        this.Svg.n(-1600, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 801)
    {
      paramString = (com.tencent.wecall.talkroom.a.k)paramd;
      if (b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
        this.Svg.n(-1601, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 802)
    {
      paramString = (m)paramd;
      if (b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
        this.Svg.n(-1602, null);
      }
    }
    AppMethodBeat.o(62742);
    return;
    label1225:
    Object localObject1;
    Object localObject2;
    if (paramd.getType() == 201)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.d)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).RCH != null))
      {
        paramString = (a.ab)((com.tencent.pb.common.b.d)localObject1).RCH;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).SuH });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).SwT) {
          break label3358;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.asK(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          Sux = null;
          if (paramInt2 == 0) {
            break label3625;
          }
          if (com.tencent.pb.common.c.f.nG(this.SuH, ((com.tencent.wecall.talkroom.a.d)localObject1).SuH)) {
            break label3364;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.SuH, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).SuH, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1514:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.RCH != null)) {
        a(paramInt2, (a.ac)paramString.RCH, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.RCH != null))
      {
        localObject1 = (a.z)paramString.RCH;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303), Integer.valueOf(14651), Integer.valueOf(-1309) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.asK(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label4654;
        }
        if (b(paramString.xOr, paramString.yvK, paramString.HgX, false))
        {
          this.SuY.ag(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (paramInt2 != 14651) {
            break label4640;
          }
          com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14651), ((a.z)localObject1).groupId, Integer.valueOf(((a.z)localObject1).GXO), Long.valueOf(((a.z)localObject1).GXP) });
          this.Svg.n(-301, localObject1);
        }
      }
    }
    label1905:
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.RCH != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ad)paramString.RCH).groupId, this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.asK(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (o)paramd;
      if ((paramString != null) && (paramString.RCH != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.ao)paramString.RCH).groupId, this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        hrl();
        i = 0;
        if (paramInt2 != 14800) {
          break label4871;
        }
        i = -1401;
        label2265:
        if (i != 0)
        {
          this.SuY.asO(324);
          h.asK(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.RCH != null))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.xOr, " roomid: ", Integer.valueOf(paramString.yvK), " roomKey: ", Long.valueOf(paramString.HgX) });
        if (paramInt2 != 18950) {
          break label4886;
        }
        if (!b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
          h.a(paramString.xOr, paramString.yvK, paramString.HgX, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.hqY().brn(paramString.xOr);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.xOr, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.Svg.a(paramString.SwS, (MultiTalkGroup)localObject1);
        }
      }
    }
    label2523:
    if (paramd.getType() == 207)
    {
      paramString = (com.tencent.wecall.talkroom.a.i)paramd;
      if ((paramString != null) && (paramString.RCH != null))
      {
        if (paramInt2 == 18100) {
          h.asK(-1501);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 208)
    {
      paramString = (com.tencent.wecall.talkroom.a.c)paramd;
      if ((paramString != null) && (paramString.RCH != null))
      {
        if (paramInt2 == 18300) {
          h.asK(-1531);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 209)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).RCH != null))
      {
        paramString = (a.ae)((com.tencent.pb.common.b.d)localObject1).RCH;
        if (paramInt2 == 17900) {
          h.asK(-1511);
        }
        if (paramInt2 == 0) {
          break label5292;
        }
        this.Svg.hK(((com.tencent.wecall.talkroom.a.g)localObject1).xOr, paramInt2);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 210)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 == 19100) {
        h.asK(-1541);
      }
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (paramString != null) {
        a(paramInt1, paramInt2, paramd.RCH, paramString);
      }
    }
    if (paramd.getType() == 212) {
      a(paramInt2, (a.al)paramd.RCH);
    }
    if (paramd.getType() == 213)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break label5391;
      }
      if (com.tencent.pb.common.c.f.equals(paramString.xOr, this.xOr))
      {
        this.SuY.ag(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.Svg.n(-700, null);
      }
    }
    label2964:
    if (paramd.getType() == 214)
    {
      paramString = (a.aj)paramd.RCH;
      localObject1 = (n)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (!b(((n)localObject1).xOr, ((n)localObject1).yvK, ((n)localObject1).HgX, false)) {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((n)localObject1).xOr, Integer.valueOf(((n)localObject1).yvK) });
      }
    }
    else
    {
      if (paramd.getType() == 800)
      {
        paramString = (l)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
        if (b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
          break label5855;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.xOr, Integer.valueOf(paramString.yvK) });
      }
      label3165:
      if (paramd.getType() == 801)
      {
        paramString = (com.tencent.wecall.talkroom.a.k)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo errCode: ", Integer.valueOf(paramInt2) });
        if (b(paramString.xOr, paramString.yvK, paramString.HgX, false)) {
          break label5920;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo isCurrentRoom is not same", paramString.xOr, Integer.valueOf(paramString.yvK) });
      }
    }
    for (;;)
    {
      label3072:
      if (paramd.getType() == 802)
      {
        paramString = (m)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeScreenSharingVideo errCode: ", Integer.valueOf(paramInt2) });
        if (!b(paramString.xOr, paramString.yvK, paramString.HgX, false))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeScreenSharingVideo isCurrentRoom is not same", paramString.xOr, Integer.valueOf(paramString.yvK) });
          AppMethodBeat.o(62742);
          return;
          label3358:
          i = 0;
          break;
          label3364:
          if (paramInt2 != -1)
          {
            this.SuY.asO(321);
            this.SuY.ag(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          if (this.state != 1)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).SuH });
            if (i == 0) {
              break label1514;
            }
            this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1514;
          }
          a(this.xOr, this.yvK, this.HgX, true);
          if (paramInt2 == 14051) {
            this.Svg.n(-900, null);
          }
          for (;;)
          {
            if (i == 0) {
              break label3623;
            }
            this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break;
            if (paramInt2 == 14052) {
              this.Svg.n(-1100, null);
            } else if (paramInt2 == 14053) {
              this.Svg.n(-1300, paramString);
            } else if (paramInt2 == 14504) {
              this.Svg.n(-1400, null);
            } else {
              this.Svg.n(-100, null);
            }
          }
          label3623:
          break label1514;
          label3625:
          if (!com.tencent.pb.common.c.f.nG(this.SuH, paramString.RDo))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.SuH, " resp.clientGroupId: ", paramString.RDo, Integer.valueOf(paramString.GXO), Long.valueOf(paramString.GXP) });
            a(paramString.groupId, paramString.GXO, paramString.GXP, 110, false);
            if (i == 0) {
              break label1514;
            }
            this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1514;
          }
          this.SuY.ag(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (this.state != 1)
          {
            h.asK(-1003);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.RDo, Integer.valueOf(paramString.GXO), Long.valueOf(paramString.GXP) });
            if (i == 0) {
              break label1514;
            }
            this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1514;
          }
          if ((paramString.REL == null) || (paramString.REL.length == 0))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.RDo, Integer.valueOf(paramString.GXO), Long.valueOf(paramString.GXP) });
            h.asK(-1605);
            this.SuY.Hre = 329;
            a(paramString.groupId, paramString.GXO, paramString.GXP, 116, true);
            if (i != 0) {
              this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.Svg.n(-100, null);
            break label1514;
          }
          a(paramString.RDo, paramString.GXO, paramString.GXP, paramString.groupId, paramString.RDq.RFQ);
          this.Svk = paramString.groupId;
          this.RCJ = paramString.RDt;
          setState(4);
          a(paramString.REL, paramString.RES, paramString.RET);
          a(paramString.groupId, paramString.RDo, paramString.RDt, paramString.GXO, paramString.GXP, paramString.RDX, paramString.REM, paramString.RDq, false, true);
          if (this.Svg != null)
          {
            localObject1 = this.Svg;
            localObject2 = new g.9((g)localObject1, c.hqY().brn(paramString.groupId));
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label4190;
            }
            ((Runnable)localObject2).run();
          }
          for (;;)
          {
            localObject1 = new byte[paramString.REO.length];
            j = 0;
            while (j < paramString.REO.length)
            {
              localObject1[j] = ((byte)paramString.REO[j]);
              j += 1;
            }
            label4190:
            ((g)localObject1).handler.post((Runnable)localObject2);
          }
          localObject2 = new int[paramString.REY.length];
          int j = 0;
          while (j < paramString.REY.length)
          {
            localObject2[j] = paramString.REY[j];
            j += 1;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(paramString.REY.length) });
          if (paramString.REY.length > talk.zGz) {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { " redirect type:", Integer.valueOf(localObject2[talk.zGz]), " SimpleRedirect value:", Integer.valueOf(talk.zGz) });
          }
          a.bb[] arrayOfbb = paramString.RDX;
          a.ay localay = paramString.RDY;
          if ((paramString.REN & 0x2) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            a(0, arrayOfbb, localay, (byte[])localObject1, bool, paramString.groupId, paramString.GXO, paramString.GXP, paramString.REU, paramString.REW, paramString.REX, (int[])localObject2, paramString.REa, this.SuP);
            if (paramString.RER != 0)
            {
              com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.RER });
              SuD = paramString.RER * 1000;
            }
            hrk();
            N(paramString.groupId, paramString.GXO, paramString.GXP);
            if (i != 0)
            {
              localObject1 = new HashMap();
              ((Map)localObject1).put("result", Boolean.TRUE);
              ((Map)localObject1).put("shareUrl", new String(paramString.RDq.RFK, Charset.forName("utf-8")));
              ((Map)localObject1).put("smsShortUrl", new String(paramString.RDq.RFL, Charset.forName("utf-8")));
              ((Map)localObject1).put("groupId", paramString.groupId);
              this.Spf.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX) });
            break;
          }
          label4640:
          this.Svg.n(-300, null);
          break label1905;
          label4654:
          if (((a.z)localObject1).REK == null)
          {
            i = 0;
            label4665:
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
            if (b(((a.z)localObject1).groupId, ((a.z)localObject1).GXO, ((a.z)localObject1).GXP, false)) {
              break label4828;
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.z)localObject1).groupId, this.xOr, " resp.roomid: ", Integer.valueOf(((a.z)localObject1).GXO), Integer.valueOf(this.yvK) });
            h.asK(-1308);
          }
          for (;;)
          {
            a(((a.z)localObject1).groupId, null, this.RCJ, ((a.z)localObject1).GXO, ((a.z)localObject1).GXP, ((a.z)localObject1).REK, null, ((a.z)localObject1).RDq, true, true);
            break;
            i = ((a.z)localObject1).REK.length;
            break label4665;
            label4828:
            this.SuY.ag(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          label4871:
          if (paramInt2 != 14801) {
            break label2265;
          }
          i = -1402;
          break label2265;
          label4886:
          if (paramInt2 == 0) {
            this.SuE = true;
          }
          if (!fGt())
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.xOr });
            this.SuY.reset();
            Eh(false);
            this.SuY.ag(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
            this.GUf = false;
            this.xOr = paramString.xOr;
            this.Svk = this.xOr;
            this.yvK = paramString.yvK;
            this.HgX = paramString.HgX;
            this.RCJ = paramString.RCJ;
            setState(2);
            this.SuL = System.currentTimeMillis();
            localObject1 = this.SuY;
            com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "beginNotifyTime" });
            ((h)localObject1).SwI = System.currentTimeMillis();
            if (paramInt2 == 18900) {
              h.asK(-1521);
            }
          }
          while (!com.tencent.pb.common.c.f.equals(paramString.xOr, this.xOr))
          {
            localObject1 = new e();
            ((e)localObject1).groupId = paramString.xOr;
            ((e)localObject1).roomId = paramString.yvK;
            ((e)localObject1).ypH = paramString.HgX;
            this.Suy.put(paramString.xOr, localObject1);
            localObject1 = c.hqY().brn(paramString.xOr);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.xOr, " multiTalkGroup: ", localObject1 });
            if (localObject1 == null) {
              break label5270;
            }
            paramString = this.Svg;
            localObject1 = new g.3(paramString, (MultiTalkGroup)localObject1);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label5257;
            }
            ((Runnable)localObject1).run();
            break;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.xOr });
          break label2523;
          label5257:
          paramString.handler.post((Runnable)localObject1);
          break label2523;
          label5270:
          a(paramString.xOr, paramString.yvK, paramString.HgX, false, false, false);
          break label2523;
          label5292:
          localObject1 = c.hqY().brg(paramString.groupId);
          if (localObject1 != null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
            a(paramString.groupId, null, ((TalkRoom)localObject1).hqM(), TalkRoom.hqN(), TalkRoom.fHV(), null, null, paramString.RDq, true, false);
          }
          for (;;)
          {
            this.Svg.hK(paramString.groupId, 0);
            break;
            a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.RDq, true, false);
          }
          label5391:
          if (!com.tencent.pb.common.c.f.equals(paramString.xOr, this.xOr)) {
            break label2964;
          }
          this.SuY.ag(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          paramString = this.Svg;
          localObject1 = new g.24(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label2964;
          }
          paramString.handler.post((Runnable)localObject1);
          break label2964;
          if (this.SuZ != null)
          {
            localObject1 = new int[6];
            localObject1[0] = paramString.LGa;
            localObject1[1] = paramString.RFa;
            localObject1[2] = paramString.RFb;
            localObject1[3] = paramString.RFc;
            localObject1[4] = paramString.RFd;
            localObject1[5] = paramString.RFe;
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject1[2]), Integer.valueOf(localObject1[3]), Integer.valueOf(localObject1[4]), Integer.valueOf(localObject1[5]) });
            localObject2 = this.SuZ;
            if (((b)localObject2).Suj != null) {
              break label5729;
            }
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject1, ", engine:", ((b)localObject2).Suj });
          }
          for (;;)
          {
            if (paramString.RFh == 0)
            {
              if (paramInt2 == 0)
              {
                localObject1 = this.Svg;
                paramString = new g.18((g)localObject1, paramString.LGa);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  paramString.run();
                  break;
                  label5729:
                  ((b)localObject2).Suj.setMVSvrCfg((int[])localObject1, 6);
                  continue;
                }
                ((g)localObject1).handler.post(paramString);
                break;
              }
              if (paramInt2 == 24301)
              {
                this.Svg.n(-1700, Integer.valueOf(paramString.RFg));
                break;
              }
              this.Svg.n(-800, null);
              break;
            }
          }
          if (paramString.RFh != 1) {
            break label3072;
          }
          paramString = this.Svg;
          localObject1 = new g.19(paramString, paramInt2);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label3072;
          }
          paramString.handler.post((Runnable)localObject1);
          break label3072;
          label5855:
          if (paramInt2 == 0)
          {
            paramString = this.Svg;
            localObject1 = new g.20(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              break label3165;
            }
            paramString.handler.post((Runnable)localObject1);
            break label3165;
          }
          this.Svg.n(-1600, null);
          break label3165;
          label5920:
          if (paramInt2 == 0)
          {
            paramString = this.Svg;
            localObject1 = new g.21(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              continue;
            }
            paramString.handler.post((Runnable)localObject1);
            continue;
          }
          this.Svg.n(-1601, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.Svg;
          paramd = new g.22(paramString);
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
        this.Svg.n(-1602, null);
      }
    }
    AppMethodBeat.o(62742);
  }
  
  public final void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(62755);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.xOr, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.yvK), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.HgX) });
    c.hqY().brh(paramString);
    if (paramBoolean1) {
      N(paramString, paramInt, paramLong);
    }
    this.Suy.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      Eh(true);
      this.Svg.dH(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.hqY().brn(paramString);
      if (paramString != null) {
        this.Svg.f(paramString);
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
    boolean bool = com.tencent.pb.common.b.e.hiW().a(localf);
    this.SuY.ag(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62736);
    return bool;
  }
  
  public final boolean aY(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62773);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62773);
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100)) {
      this.SuY.hrw();
    }
    int i = this.yvK;
    long l = this.HgX;
    int j = a.hqJ().state;
    if (j.bru(paramString))
    {
      this.SuY.asO(327);
      bool = a.hqJ().hL(paramString, 1000);
      AppMethodBeat.o(62773);
      return bool;
    }
    if (j == 2)
    {
      bool = a.hqJ().c(paramString, i, l, paramInt1);
      AppMethodBeat.o(62773);
      return bool;
    }
    com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.hqJ().a(paramString, i, l, paramInt2, true);
    AppMethodBeat.o(62773);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62744);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.yIP) && (this.SuZ != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.SuZ;
        if ((paramArrayOfByte == null) || (localb.Suj == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.Suj });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.yIP), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.SuZ });
          AppMethodBeat.o(62744);
          return paramArrayOfByte;
        }
        paramInt1 = localb.Suj.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.zKJ = paramArrayOfInt;
        paramArrayOfByte.zKK = localb.Suj.field_localImgWidth;
        paramArrayOfByte.zKL = localb.Suj.field_localImgHeight;
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
  
  public final e bro(String paramString)
  {
    AppMethodBeat.i(62757);
    paramString = (e)this.Suy.get(paramString);
    AppMethodBeat.o(62757);
    return paramString;
  }
  
  public final boolean brp(String paramString)
  {
    AppMethodBeat.i(62758);
    if ((e)this.Suy.get(paramString) != null)
    {
      AppMethodBeat.o(62758);
      return true;
    }
    AppMethodBeat.o(62758);
    return false;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(199684);
    int j = -1;
    int i = j;
    if (this.yIP)
    {
      i = j;
      if (this.SuZ == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.SuZ;
        if ((paramArrayOfByte != null) && (localb.Suj != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.Suj });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.yIP), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.SuZ });
      i = paramInt1;
      AppMethodBeat.o(199684);
      return i;
      paramInt1 = localb.Suj.SendVideo(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final boolean c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62733);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.xOr, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
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
        hri();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.hiW().a(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.SuY.ag(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
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
    AppMethodBeat.i(199685);
    int j = -1;
    int i = j;
    if (this.yIP)
    {
      i = j;
      if (this.SuZ == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.SuZ;
        if ((paramArrayOfByte != null) && (localb.Suj != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendScreen null, buffer:", paramArrayOfByte, ", engine:", localb.Suj });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendScreen error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen finished, ", Boolean.valueOf(this.yIP), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.SuZ });
      i = paramInt1;
      AppMethodBeat.o(199685);
      return i;
      paramInt1 = localb.Suj.SendScreen(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final int dc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62753);
    long l;
    int n;
    label348:
    int i1;
    try
    {
      paramArrayOfByte = (a.r)com.google.a.a.e.a(new a.r(), paramArrayOfByte, paramArrayOfByte.length);
      if (paramArrayOfByte == null) {
        if ((!TextUtils.isEmpty(this.xOr)) || (!TextUtils.isEmpty(this.SuH)))
        {
          this.SuY.ag(new String[] { "notify", "pasrefail" });
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
        h.asK(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.yvK, this.HgX, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange ", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Long.valueOf(paramArrayOfByte.msgId), Integer.valueOf(paramArrayOfByte.RDV), Integer.valueOf(paramArrayOfByte.jlm) });
      l = paramArrayOfByte.msgId;
      if (this.Svl.contains(Long.valueOf(l)))
      {
        n = 1;
        if (n == 0) {
          break label392;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error: msgId:", Long.valueOf(paramArrayOfByte.msgId) });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false)) {
          break label348;
        }
        this.SuY.ag(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.RDV) });
      }
      for (;;)
      {
        AppMethodBeat.o(62753);
        return -3;
        this.Svl.add(Long.valueOf(l));
        n = 0;
        break;
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.RDV) });
      }
      label392:
      n = paramArrayOfByte.RDV;
      i1 = paramArrayOfByte.jlm;
      switch (n)
      {
      default: 
        com.tencent.pb.common.c.b.w(" unknow voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1) });
        n = 0;
      }
    }
    if (n == 0) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange update msg seq fail type:", Integer.valueOf(paramArrayOfByte.RDV) });
    }
    for (;;)
    {
      AppMethodBeat.o(62753);
      return 0;
      if (i1 <= this.SuR)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuR) });
        n = 0;
        break;
      }
      this.SuR = i1;
      for (;;)
      {
        com.tencent.pb.common.c.b.w("voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1), " update local seq" });
        n = 1;
        break;
        if (i1 <= this.SuS)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuS) });
          n = 0;
          break;
        }
        this.SuS = i1;
        continue;
        if (i1 <= this.SuT)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuT) });
          n = 0;
          break;
        }
        this.SuT = i1;
        continue;
        if (i1 <= this.SuU)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuU) });
          n = 0;
          break;
        }
        this.SuU = i1;
        continue;
        if (i1 <= this.SuV)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuV) });
          n = 0;
          break;
        }
        this.SuV = i1;
        continue;
        if (i1 <= this.SuW)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuW) });
          n = 0;
          break;
        }
        this.SuW = i1;
        continue;
        if (i1 <= this.SuX)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.SuX) });
          n = 0;
          break;
        }
        this.SuX = i1;
      }
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false)) {
        this.SuY.ag(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.RDV) });
      }
      if (paramArrayOfByte.RDV == 2)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.RDt, paramArrayOfByte.GXO, paramArrayOfByte.GXP, paramArrayOfByte.RDX, paramArrayOfByte.RDW, paramArrayOfByte.RDq, true, true);
      }
      else
      {
        Object localObject1;
        if (paramArrayOfByte.RDV == 4)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.RDt, paramArrayOfByte.GXO, paramArrayOfByte.GXP, paramArrayOfByte.RDX, paramArrayOfByte.RDW, paramArrayOfByte.RDq, true, true);
          if ((paramArrayOfByte.RDZ != 0) || (paramArrayOfByte.REa != 0))
          {
            localObject1 = this.SuZ;
            n = paramArrayOfByte.RDZ;
            i1 = paramArrayOfByte.REa;
            if ((com.tencent.pb.common.a.a.RCk) && (((b)localObject1).Suj != null)) {
              ((b)localObject1).Suj.SetAVEncryptType(n, i1);
            }
          }
        }
        else if (paramArrayOfByte.RDV == 16)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.RDt, paramArrayOfByte.GXO, paramArrayOfByte.GXP, paramArrayOfByte.RDX, paramArrayOfByte.RDW, paramArrayOfByte.RDq, true, false);
        }
        else if (paramArrayOfByte.RDV == 1)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.GXO), " roomkey: ", Long.valueOf(paramArrayOfByte.GXP) });
          if (com.tencent.pb.a.a.a.hjr())
          {
            com.tencent.pb.a.a.a.hjs();
            if ((fGt()) && (com.tencent.pb.common.c.f.equals(paramArrayOfByte.groupId, this.xOr))) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.xOr });
            }
          }
          else
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
            continue;
          }
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.RDt, paramArrayOfByte.GXO, paramArrayOfByte.GXP, paramArrayOfByte.RDX, paramArrayOfByte.RDW, paramArrayOfByte.RDq, false, true);
          localObject1 = paramArrayOfByte.groupId;
          n = paramArrayOfByte.GXO;
          l = paramArrayOfByte.GXP;
          i1 = paramArrayOfByte.RDt;
          int i2 = paramArrayOfByte.REb;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
          }
          for (;;)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
            break;
            paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, n, l, i1, i2);
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i2), Boolean.valueOf(com.tencent.pb.common.b.e.hiW().a(paramArrayOfByte)) });
          }
        }
        else if (paramArrayOfByte.RDV == 8)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.xOr });
          if (b(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false))
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.RDt, paramArrayOfByte.GXO, paramArrayOfByte.GXP, paramArrayOfByte.RDX, paramArrayOfByte.RDW, paramArrayOfByte.RDq, true, false);
            a(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false, false, true);
          }
          else
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.RDt, paramArrayOfByte.GXO, paramArrayOfByte.GXP, paramArrayOfByte.RDX, paramArrayOfByte.RDW, paramArrayOfByte.RDq, true, false);
          }
        }
        else
        {
          String str;
          if (paramArrayOfByte.RDV == 128)
          {
            localObject1 = paramArrayOfByte.groupId;
            str = this.xOr;
            if (paramArrayOfByte.REc == null) {}
            for (n = 0;; n = paramArrayOfByte.REc.length)
            {
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(n) });
              localObject1 = this.Svg;
              paramArrayOfByte = new g.23((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.REc);
              if (Looper.myLooper() != Looper.getMainLooper()) {
                break label2009;
              }
              paramArrayOfByte.run();
              break;
            }
            label2009:
            ((g)localObject1).handler.post(paramArrayOfByte);
          }
          else
          {
            Object localObject2;
            if (paramArrayOfByte.RDV == 256)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
              } else if (paramArrayOfByte.REc == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
              } else {
                try
                {
                  localObject1 = paramArrayOfByte.REc;
                  localObject1 = (a.t)com.google.a.a.e.a(new a.t(), (byte[])localObject1, localObject1.length);
                  if ((localObject1 == null) || (((a.t)localObject1).REg == null)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
                  }
                }
                catch (com.google.a.a.d locald1)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember ", locald1 });
                    localObject2 = null;
                  }
                  paramArrayOfByte = new ArrayList();
                  localObject2 = ((a.t)localObject2).REg;
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
                  com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.xOr, " roomId: ", Integer.valueOf(this.yvK), " videoUserNames: ", paramArrayOfByte });
                  localObject2 = this.Svg;
                  paramArrayOfByte = new g.11((g)localObject2, paramArrayOfByte);
                  if (Looper.myLooper() == Looper.getMainLooper())
                  {
                    paramArrayOfByte.run();
                    continue;
                  }
                  ((g)localObject2).handler.post(paramArrayOfByte);
                }
              }
            }
            else if (paramArrayOfByte.RDV == 1024)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
              }
              else if ((this.state != 3) && (this.state != 4))
              {
                c(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, 1);
                this.Svg.n(-1400, null);
              }
            }
            else if (paramArrayOfByte.RDV == 512)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
              } else if (paramArrayOfByte.REc == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
              } else {
                try
                {
                  localObject2 = paramArrayOfByte.REc;
                  localObject2 = (a.s)com.google.a.a.e.a(new a.s(), (byte[])localObject2, localObject2.length);
                  if (localObject2 == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
                  }
                }
                catch (com.google.a.a.d locald2)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                    local1 = null;
                  }
                  paramArrayOfByte = this.Svg;
                  g.1 local1 = new g.1(paramArrayOfByte, local1.REf);
                  if (Looper.myLooper() == Looper.getMainLooper())
                  {
                    local1.run();
                    continue;
                  }
                  paramArrayOfByte.handler.post(local1);
                }
              }
            }
            else if (paramArrayOfByte.RDV == 2048)
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, chgtype: audiostream" });
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.GXO, paramArrayOfByte.GXP, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAudioStreamChange is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.GXO) });
              }
              else
              {
                com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleAudioStreamChange audio_stream_type", Integer.valueOf(paramArrayOfByte.audioStreamType) });
                int i = (byte)(paramArrayOfByte.audioStreamType & 0xFF);
                int j = (byte)(paramArrayOfByte.audioStreamType >> 8 & 0xFF);
                int k = (byte)(paramArrayOfByte.audioStreamType >> 16 & 0xFF);
                int m = (byte)(paramArrayOfByte.audioStreamType >> 24 & 0xFF);
                this.SuZ.Suj.setAppCmd(306, new byte[] { i, j, k, m }, 4);
              }
            }
            else
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, unknow chgtype:", Integer.valueOf(paramArrayOfByte.RDV), Long.valueOf(paramArrayOfByte.msgId) });
            }
          }
        }
      }
    }
  }
  
  public final boolean fGt()
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
  
  final boolean fuf()
  {
    AppMethodBeat.i(62765);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initEngine", this.xOr, Integer.valueOf(this.yvK), Long.valueOf(this.HgX), Integer.valueOf(this.state) });
    int i;
    label133:
    int j;
    try
    {
      localb = this.SuZ;
      boolean bool = com.tencent.pb.common.a.a.RCk;
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
        i = localException.Suj.field_capInfo.length;
      }
      AppMethodBeat.o(62765);
      return true;
    }
    if (i < 0)
    {
      h.asN(-3001);
      this.SuY.asO(201);
      this.SuZ = null;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(62765);
      return false;
      str = com.tencent.pb.common.c.c.Hhs.getDir("lib", 0).getAbsolutePath();
      locale = RCV;
      if (locale == null) {
        break label380;
      }
      j = locale.aon();
      i = locale.emN();
    }
    for (;;)
    {
      int k = k.lx(com.tencent.pb.common.c.c.Hhs);
      com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(k), " cpuFlag:", Integer.valueOf(j), "libPath:", str });
      if (localb.Suj == null)
      {
        i = -1;
        break;
      }
      j = localb.Suj.init(i, k, j, str + "/");
      if (localb.Suj.field_capInfo == null)
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
  
  public final void hH(String paramString, int paramInt)
  {
    AppMethodBeat.i(62776);
    if ((com.tencent.pb.common.c.f.equals("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (fGt()) && ((this.yIP) || (this.SuF))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62776);
      return;
      switch (k.lx(com.tencent.pb.common.c.c.Hhs))
      {
      }
      for (this.Svi = false; (this.yvK == 0) || (this.HgX == 0L); this.Svi = true)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(62776);
        return;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect", this.xOr, Integer.valueOf(this.yvK) });
      this.SuY.hrx();
      paramString = new com.tencent.wecall.talkroom.a.h(this.xOr, this.yvK, this.HgX, c.hqY().bri(this.xOr), this.SuO);
      boolean bool = com.tencent.pb.common.b.e.hiW().a(paramString);
      this.SuY.ag(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62776);
      return;
      paramString = this.SuZ;
      paramInt = k.lx(com.tencent.pb.common.c.c.Hhs);
      if ((!com.tencent.pb.common.a.a.RCk) || (paramString.Suj == null))
      {
        AppMethodBeat.o(62776);
        return;
      }
      paramString.Suj.onNetworkChange(paramInt);
    }
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
        paramMessage = (d)paramMessage;
        if (paramMessage.xOr == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId is null" });
        }
        else
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handlerInviteTimeOut" });
          if ((paramMessage.xOr.equals(this.xOr)) && (paramMessage.yvK == this.yvK) && (paramMessage.HgX == this.HgX))
          {
            h.hrz();
            this.SuY.asO(501);
            c(paramMessage.xOr, paramMessage.yvK, paramMessage.HgX, 7);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId: ", paramMessage.xOr });
            continue;
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
              if (com.tencent.pb.common.c.f.nG(paramMessage.groupId, this.xOr))
              {
                String str1 = paramMessage.groupId;
                Object localObject1 = paramMessage.SvT;
                a.be localbe = paramMessage.SvU;
                int i = paramMessage.RDt;
                int j = paramMessage.type;
                long l = paramMessage.SvV;
                String str2 = paramMessage.SvW;
                boolean bool = paramMessage.SvX;
                String str3 = paramMessage.SvY;
                this.SuY.hrx();
                Object localObject2 = c.hqY();
                paramMessage = "";
                localObject2 = ((c)localObject2).brg(str1);
                if (localObject2 != null) {
                  if (((TalkRoom)localObject2).Suh != null) {
                    break label618;
                  }
                }
                label618:
                for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).Suh.name)
                {
                  localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.SuZ.hqV(), paramMessage, localbe, i, j, l, str2, bool, str3);
                  bool = com.tencent.pb.common.b.e.hiW().a((com.tencent.pb.common.b.d)localObject1);
                  this.SuY.ag(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
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
                  if (b(paramMessage.groupId, paramMessage.roomId, paramMessage.ypH, false))
                  {
                    a(paramMessage.groupId, paramMessage.roomId, paramMessage.ypH, paramMessage.RDt, paramMessage.vkj, paramMessage.Swk);
                    continue;
                    com.tencent.pb.common.c.e.hjp();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final boolean hrg()
  {
    AppMethodBeat.i(62724);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = RCV;
    if (locale != null) {
      locale.emM();
    }
    this.SuZ = new b();
    this.Svk = this.xOr;
    hrf();
    this.Sva = new talk.a()
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
          f.this.SuY.Swu = 1;
          localh = f.this.SuY;
          if (localh.SwH != 0L) {
            break label121;
          }
        }
        label121:
        for (localh.Swv = 0L;; localh.Swv = (System.currentTimeMillis() - localh.SwH))
        {
          com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.SwH), Long.valueOf(localh.Swv) });
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
        //   9: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   12: getfield 77	com/tencent/wecall/talkroom/model/f:SuY	Lcom/tencent/wecall/talkroom/model/h;
        //   15: iconst_1
        //   16: putfield 124	com/tencent/wecall/talkroom/model/h:yqT	I
        //   19: ldc 59
        //   21: iconst_1
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 126
        //   29: aastore
        //   30: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   33: aload_0
        //   34: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
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
        //   58: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   61: invokestatic 128	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   64: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   67: aastore
        //   68: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   71: ldc 121
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aload_0
        //   78: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   81: astore 6
        //   83: invokestatic 136	com/tencent/wecall/talkroom/model/c:hqY	()Lcom/tencent/wecall/talkroom/model/c;
        //   86: astore 4
        //   88: aload_0
        //   89: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
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
        //   117: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   120: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   123: ifnull +30 -> 153
        //   126: aload_0
        //   127: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   130: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   133: astore 4
        //   135: invokestatic 156	com/tencent/wecall/talkroom/model/f:hrs	()Z
        //   138: istore_3
        //   139: getstatic 162	com/tencent/pb/common/a/a:RCk	Z
        //   142: ifeq +11 -> 153
        //   145: aload 4
        //   147: getfield 168	com/tencent/wecall/talkroom/model/b:Suj	Lcom/tencent/mm/plugin/multi/talk;
        //   150: ifnonnull +431 -> 581
        //   153: aload_0
        //   154: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   157: invokestatic 171	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
        //   160: pop
        //   161: aload_0
        //   162: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   165: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   168: pop
        //   169: invokestatic 175	com/tencent/wecall/talkroom/model/f:hrt	()Lcom/tencent/pb/talkroom/sdk/e;
        //   172: astore 4
        //   174: aload 4
        //   176: ifnull +11 -> 187
        //   179: aload 4
        //   181: invokeinterface 181 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   191: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   194: getfield 168	com/tencent/wecall/talkroom/model/b:Suj	Lcom/tencent/mm/plugin/multi/talk;
        //   197: astore 6
        //   199: getstatic 162	com/tencent/pb/common/a/a:RCk	Z
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
        //   308: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
        //   311: getfield 77	com/tencent/wecall/talkroom/model/f:SuY	Lcom/tencent/wecall/talkroom/model/h;
        //   314: astore 4
        //   316: aload 4
        //   318: getfield 87	com/tencent/wecall/talkroom/model/h:SwH	J
        //   321: lconst_0
        //   322: lcmp
        //   323: ifne +317 -> 640
        //   326: aload 4
        //   328: lconst_0
        //   329: putfield 209	com/tencent/wecall/talkroom/model/h:Sww	J
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
        //   348: getfield 209	com/tencent/wecall/talkroom/model/h:Sww	J
        //   351: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   354: aastore
        //   355: dup
        //   356: iconst_2
        //   357: aload 4
        //   359: getfield 87	com/tencent/wecall/talkroom/model/h:SwH	J
        //   362: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   365: aastore
        //   366: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   369: aload_0
        //   370: getfield 22	com/tencent/wecall/talkroom/model/f$1:Svz	Lcom/tencent/wecall/talkroom/model/f;
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
        //   442: invokevirtual 234	com/tencent/wecall/talkroom/model/c:brg	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
        //   445: astore 7
        //   447: aload 5
        //   449: astore 4
        //   451: aload 7
        //   453: ifnull -344 -> 109
        //   456: aload 7
        //   458: invokevirtual 240	com/tencent/wecall/talkroom/model/TalkRoom:hqP	()Ljava/util/List;
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
        //   587: getfield 168	com/tencent/wecall/talkroom/model/b:Suj	Lcom/tencent/mm/plugin/multi/talk;
        //   590: sipush 401
        //   593: invokevirtual 277	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   596: pop
        //   597: goto -444 -> 153
        //   600: aload 4
        //   602: getfield 168	com/tencent/wecall/talkroom/model/b:Suj	Lcom/tencent/mm/plugin/multi/talk;
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
        //   647: getfield 87	com/tencent/wecall/talkroom/model/h:SwH	J
        //   650: lsub
        //   651: putfield 209	com/tencent/wecall/talkroom/model/h:Sww	J
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
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bpK(f.this.Svk));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.brt(localStringBuilder.toString());
        AppMethodBeat.o(62608);
      }
      
      public final void keep_OnReportEngineRecv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62606);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bpK(f.this.Svk));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.brr(localStringBuilder.toString());
        AppMethodBeat.o(62606);
      }
      
      public final void keep_OnReportEngineSend(String paramAnonymousString)
      {
        AppMethodBeat.i(62607);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bpK(f.this.Svk));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.brs(localStringBuilder.toString());
        AppMethodBeat.o(62607);
      }
      
      final class a
        implements Runnable
      {
        int SvB;
        int SvC;
        int SvD;
        int SvE;
        int SvF;
        
        a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
          this.SvB = paramInt1;
          this.SvD = paramInt2;
          this.SvE = paramInt3;
          this.SvF = paramInt4;
          this.SvC = paramInt5;
        }
        
        public final void run()
        {
          AppMethodBeat.i(62585);
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "keep_OnError handler" });
          h.asN(this.SvE);
          f.this.SuY.asO(this.SvD);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.SvC) });
          f.this.a(f.b(f.this), f.g(f.this), f.h(f.this), this.SvF, true);
          f.f(f.this).n(this.SvB, null);
          AppMethodBeat.o(62585);
        }
      }
    };
    AppMethodBeat.o(62724);
    return true;
  }
  
  public final void hrh()
  {
    AppMethodBeat.i(62726);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.Svw != null) {
        this.mHandler.removeCallbacks(this.Svw);
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
  
  public final void rt(boolean paramBoolean)
  {
    AppMethodBeat.i(62766);
    try
    {
      ZZ();
      hrj();
      if (paramBoolean)
      {
        hro();
        bFT();
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
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(199686);
    if ((this.yIP) && (this.SuZ != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        b localb = this.SuZ;
        if ((paramArrayOfByte1 == null) || (localb.Suj == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:screenTrans null, buf:", paramArrayOfByte1, ", engine:", localb.Suj });
          paramInt4 = -1;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "screenTrans finished, ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.yIP), " engine: ", this.SuZ });
          AppMethodBeat.o(199686);
          return paramInt4;
        }
        paramInt4 = localb.Suj.screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
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
    this.Svg.onStateChanged(paramInt);
    AppMethodBeat.o(62728);
  }
  
  final class a
  {
    int RDt;
    String[] SvT;
    a.be SvU;
    long SvV;
    String SvW;
    boolean SvX;
    String SvY;
    String groupId;
    int type;
    
    a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(62686);
      SvZ = new b("OK", 0);
      Swa = new b("NOT_AUTH", 1);
      Swb = new b("NOT_BIND", 2);
      Swc = new b("NOT_MATCH", 3);
      Swd = new b("NO_NETWORK", 4);
      Swe = new b("BUSY", 5);
      Swf = new b("NOT_VALID_STATE", 6);
      Swg = new b("GROUP_NOT_VALID", 7);
      Swh = new b("UNINIT_SERVICE_FAILED", 8);
      Swi = new b("INIT_ENGINE_FAILED", 9);
      Swj = new b[] { SvZ, Swa, Swb, Swc, Swd, Swe, Swf, Swg, Swh, Swi };
      AppMethodBeat.o(62686);
    }
    
    private b() {}
  }
  
  final class c
  {
    int RDt;
    String Swk;
    String groupId;
    int roomId;
    int vkj;
    long ypH;
    
    c() {}
  }
  
  final class d
  {
    long HgX;
    String xOr;
    int yvK;
  }
  
  final class e
  {
    String groupId;
    int roomId;
    long ypH;
    
    e() {}
  }
  
  public static abstract interface f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */