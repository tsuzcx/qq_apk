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
import com.tencent.pb.common.b.a.a.a.aa;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.ad;
import com.tencent.pb.common.b.a.a.a.ah;
import com.tencent.pb.common.b.a.a.a.aj;
import com.tencent.pb.common.b.a.a.a.al;
import com.tencent.pb.common.b.a.a.a.am;
import com.tencent.pb.common.b.a.a.a.av;
import com.tencent.pb.common.b.a.a.a.aw;
import com.tencent.pb.common.b.a.a.a.ax;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.p;
import com.tencent.pb.common.b.a.a.a.q;
import com.tencent.pb.common.b.a.a.a.r;
import com.tencent.pb.common.b.a.a.a.s;
import com.tencent.pb.common.b.a.a.a.y;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
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
  private static com.tencent.pb.talkroom.sdk.e LFC;
  public static List<Integer> MlF;
  private static int MlL;
  public static String[] Mmr;
  boolean BYH;
  public long Clq;
  int LFq;
  private com.tencent.f.a.a Mki;
  f MlE;
  private Map<String, e> MlG;
  private final int MlH;
  private final int MlI;
  private final int MlJ;
  private final int MlK;
  private boolean MlM;
  private boolean MlN;
  private String MlO;
  public String MlP;
  private int MlQ;
  private int MlR;
  private int MlS;
  private long MlT;
  private boolean MlU;
  private int MlV;
  private int MlW;
  int MlX;
  int MlY;
  private int MlZ;
  private String[] MmA;
  private int MmB;
  public boolean MmC;
  public boolean MmD;
  private Runnable MmE;
  private com.tencent.pb.common.b.d MmF;
  private Runnable MmG;
  private int Mma;
  private int Mmb;
  private int Mmc;
  private int Mmd;
  private int Mme;
  private int Mmf;
  public h Mmg;
  b Mmh;
  private talk.a Mmi;
  private TimerTask Mmj;
  private TimerTask Mmk;
  private Timer Mml;
  private TimerTask Mmm;
  private Timer Mmn;
  g Mmo;
  private int Mmp;
  private boolean Mmq;
  public String Mms;
  HashSet<Long> Mmt;
  public boolean Mmu;
  public boolean Mmv;
  public boolean Mmw;
  private short[] Mmx;
  private String[] Mmy;
  private short[] Mmz;
  Handler mHandler;
  boolean mIsMute;
  int state;
  public int uRy;
  public String ukT;
  boolean vcO;
  
  static
  {
    AppMethodBeat.i(62787);
    LFC = null;
    MlF = new ArrayList();
    MlL = 30000;
    Mmr = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(62787);
  }
  
  public f()
  {
    AppMethodBeat.i(62723);
    this.MlG = new HashMap();
    this.MlH = 1;
    this.MlI = 2;
    this.MlJ = 3;
    this.MlK = 4;
    this.state = 0;
    this.BYH = false;
    this.MlM = false;
    this.MlN = false;
    this.vcO = false;
    this.MlQ = 0;
    this.MlR = 0;
    this.MlS = 0;
    this.MlT = 0L;
    this.MlU = true;
    this.MlV = 0;
    this.MlW = 0;
    this.MlX = 0;
    this.MlY = -1;
    this.MlZ = -1;
    this.Mma = -1;
    this.Mmb = -1;
    this.Mmc = -1;
    this.Mmd = -1;
    this.Mme = -1;
    this.Mmf = -1;
    this.Mmg = h.MnB;
    this.Mml = new Timer("TalkRoomService_HelloTimer");
    this.Mmn = new Timer("TalkRoomService_talkDurationTimer");
    this.Mmo = new g();
    this.Mmp = 0;
    this.Mmq = false;
    this.Mms = null;
    this.Mmt = new HashSet();
    this.Mmu = false;
    this.Mmv = true;
    this.Mmw = true;
    this.Mmx = null;
    this.Mmy = null;
    this.Mmz = null;
    this.MmA = null;
    this.MmB = 0;
    this.mIsMute = false;
    this.MmC = false;
    this.MmD = true;
    this.MmE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62550);
        if ((f.this.evW()) && (f.s(f.this)))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
          h.ait(-2003);
          f.this.Mmg.aiw(401);
          f.this.ba(f.b(f.this), 3, 108);
        }
        AppMethodBeat.o(62550);
      }
    };
    this.MmF = null;
    this.MmG = new Runnable()
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
        if (!f.this.evW())
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
              if (f.a(f.this, locale.ukT, locale.uRy, locale.Clq, f.air(locale.Mod)))
              {
                localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
              }
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.pb.common.b.e.fSR().a((com.tencent.pb.common.b.d)localObject1);
          AppMethodBeat.o(62587);
          return;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        AppMethodBeat.o(62587);
      }
    };
    com.tencent.pb.common.b.e.fSR().a(201, this);
    com.tencent.pb.common.b.e.fSR().a(202, this);
    com.tencent.pb.common.b.e.fSR().a(203, this);
    com.tencent.pb.common.b.e.fSR().a(204, this);
    com.tencent.pb.common.b.e.fSR().a(205, this);
    com.tencent.pb.common.b.e.fSR().a(206, this);
    com.tencent.pb.common.b.e.fSR().a(207, this);
    com.tencent.pb.common.b.e.fSR().a(208, this);
    com.tencent.pb.common.b.e.fSR().a(210, this);
    com.tencent.pb.common.b.e.fSR().a(209, this);
    com.tencent.pb.common.b.e.fSR().a(211, this);
    com.tencent.pb.common.b.e.fSR().a(212, this);
    com.tencent.pb.common.b.e.fSR().a(213, this);
    com.tencent.pb.common.b.e.fSR().a(214, this);
    com.tencent.pb.common.b.e.fSR().a(800, this);
    com.tencent.pb.common.b.e.fSR().a(801, this);
    Object localObject = c.fZv();
    g localg = this.Mmo;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).Mlw = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      fZD();
      if (this.Mki == null) {
        this.Mki = ((com.tencent.f.a.a)com.tencent.f.f.aZU("EventCenter"));
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.Mki.a(this, Mmr);
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
  
  private void O(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62772);
    try
    {
      String str = c.fZv().N(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.BYH), " mTalkDuration: ", Integer.valueOf(this.MlQ), " msgKey: ", str });
      AppMethodBeat.o(62772);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(62772);
    }
  }
  
  private boolean PG()
  {
    AppMethodBeat.i(62739);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = LFC;
      if (locale == null) {
        break label99;
      }
      this.Mmg.CfB = locale.dpp();
      this.Mmg.Cfx = locale.dpq();
      bool = locale.dpn();
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
  
  private void Zh()
  {
    AppMethodBeat.i(62727);
    this.MlG.remove(this.ukT);
    this.Mmp = 0;
    this.mIsMute = false;
    setState(0);
    this.MlN = false;
    a(this.MlP, 0, 0L, null, null);
    this.MlP = null;
    this.LFq = 0;
    this.MlQ = 0;
    this.MlR = 0;
    this.MlS = 0;
    this.MlU = true;
    this.Mmv = true;
    this.MlT = 0L;
    this.MlV = 0;
    this.MlM = false;
    this.MmC = false;
    this.MmD = true;
    fZF();
    this.mHandler.removeMessages(1);
    if (this.Mmh != null) {
      this.Mmh.fZt();
    }
    fZK();
    fZJ();
    fZL();
    fZO();
    this.vcO = false;
    this.Mmu = false;
    this.MlW = 0;
    AppMethodBeat.o(62727);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    AppMethodBeat.i(62747);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.roomId, paramh.uLt, false)) {
        this.Mmg.af(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62747);
      return;
    }
    paramObject = (a.al)paramObject;
    if (!b(paramObject.groupId, paramObject.CcE, paramObject.CcF, false))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.CcE), Integer.valueOf(this.uRy) });
      AppMethodBeat.o(62747);
      return;
    }
    this.Mmg.af(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.LFq, paramObject.CcE, paramObject.CcF, paramObject.LHp, paramObject.LHr, paramObject.LFX, false, false);
    a(paramObject.LHq, paramObject.LHx, paramObject.LHy);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect type:", Integer.valueOf(this.MlW) });
    if (this.MlW == 0)
    {
      paramh = new byte[paramObject.LHt.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.LHt.length)
      {
        paramh[paramInt1] = ((byte)paramObject.LHt[paramInt1]);
        paramInt1 += 1;
      }
      localObject1 = new int[paramObject.LHC.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.LHC.length)
      {
        localObject1[paramInt1] = paramObject.LHC[paramInt1];
        paramInt1 += 1;
      }
      if (this.Mmh != null)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.Mmh.Close()) });
        localObject2 = paramObject.LHp;
        localObject3 = paramObject.LGE;
        if ((paramObject.LHs & 0x2) == 0) {
          break label547;
        }
      }
      label547:
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ay[])localObject2, (a.av)localObject3, paramh, bool, paramObject.groupId, paramObject.CcE, paramObject.CcF, paramObject.LHz, paramObject.LHA, paramObject.LHB, (int[])localObject1, paramObject.LGG, this.MlX);
        AppMethodBeat.o(62747);
        return;
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp engine close but nullptr" });
        AppMethodBeat.o(62747);
        return;
      }
    }
    paramInt1 = k.ls(com.tencent.pb.common.c.c.ClL);
    com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "amyfwang,Redirect::netType:", Integer.valueOf(paramInt1) });
    paramObject = this.Mmh;
    paramh = this.Mmy;
    Object localObject1 = this.Mmx;
    Object localObject2 = this.MmA;
    Object localObject3 = this.Mmz;
    if (paramObject.Mlr != null) {
      paramObject.Mlr.Redirect(paramh, (short[])localObject1, (String[])localObject2, (short[])localObject3, paramInt1);
    }
    AppMethodBeat.o(62747);
  }
  
  private void a(int paramInt, a.ab paramab, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(213668);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.ukT, Integer.valueOf(parame.uRy), Long.valueOf(parame.Clq), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111), Integer.valueOf(14287), Integer.valueOf(-1112) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.ais(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramab.groupId, Integer.valueOf(paramab.CcE), Long.valueOf(paramab.CcF) });
      this.Mmo.m(-14255, paramab);
      AppMethodBeat.o(213668);
      return;
    }
    if (paramInt == 14287)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14287), paramab.groupId, Integer.valueOf(paramab.CcE), Long.valueOf(paramab.CcF) });
      this.Mmo.m(-14287, paramab);
      AppMethodBeat.o(213668);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramab.groupId, Integer.valueOf(paramab.CcE), Long.valueOf(paramab.CcF) });
      this.Mmo.m(-14256, paramab);
      AppMethodBeat.o(213668);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.ukT, parame.uRy, parame.Clq, aiq(parame.Mod)))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.ukT, " mGroupId: ", this.ukT, Integer.valueOf(parame.uRy), Integer.valueOf(this.uRy), Long.valueOf(parame.Clq), Long.valueOf(this.Clq) });
        AppMethodBeat.o(213668);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.ukT, Integer.valueOf(parame.uRy), Long.valueOf(parame.Clq) });
        AppMethodBeat.o(213668);
        return;
      }
      this.Mmg.af(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.Mmg.aiw(322);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.ukT, Integer.valueOf(parame.uRy), Long.valueOf(parame.Clq) });
      a(parame.ukT, parame.uRy, parame.Clq, true);
      if (paramInt == 14251)
      {
        this.Mmo.m(-1000, null);
        AppMethodBeat.o(213668);
        return;
      }
      if (paramInt == 14252)
      {
        this.Mmo.m(-1200, null);
        AppMethodBeat.o(213668);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramab != null) {
          parame = Integer.valueOf(paramab.LHv);
        }
        this.Mmo.m(-1500, parame);
        AppMethodBeat.o(213668);
        return;
      }
      this.Mmo.m(-200, null);
      AppMethodBeat.o(213668);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramab.groupId, Integer.valueOf(paramab.CcE), Long.valueOf(paramab.CcF) });
      AppMethodBeat.o(213668);
      return;
    }
    if (!b(paramab.groupId, paramab.CcE, paramab.CcF, aiq(paramab.vug)))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramab.groupId, " mGroupId: ", this.ukT, Integer.valueOf(paramab.CcE), Integer.valueOf(this.uRy), Long.valueOf(paramab.CcF), Long.valueOf(this.Clq) });
      a(paramab.groupId, paramab.CcE, paramab.CcF, 111, false);
      h.ais(-1110);
      AppMethodBeat.o(213668);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramab.groupId, Integer.valueOf(paramab.CcE), Long.valueOf(paramab.CcF) });
      AppMethodBeat.o(213668);
      return;
    }
    this.Mmg.af(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramab.LHq == null) || (paramab.LHq.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramab.groupId, Integer.valueOf(paramab.CcE), Long.valueOf(paramab.CcF) });
      h.ais(-1605);
      this.Mmg.CuJ = 329;
      a(paramab.groupId, paramab.CcE, paramab.CcF, 116, true);
      this.Mmo.m(-200, null);
      AppMethodBeat.o(213668);
      return;
    }
    this.ukT = paramab.groupId;
    this.Mms = paramab.groupId;
    this.uRy = paramab.CcE;
    this.Clq = paramab.CcF;
    setState(4);
    a(paramab.LHq, paramab.LHx, paramab.LHy);
    a(paramab.groupId, null, this.LFq, paramab.CcE, paramab.CcF, paramab.LHp, paramab.LHr, paramab.LFX, false, true);
    parame = this.Mmo;
    localObject = new g.9(parame, c.fZv().bag(paramab.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramab.LHt.length];
      paramInt = 0;
      while (paramInt < paramab.LHt.length)
      {
        parame[paramInt] = ((byte)paramab.LHt[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramab.LHC.length];
    paramInt = 0;
    while (paramInt < paramab.LHC.length)
    {
      localObject[paramInt] = paramab.LHC[paramInt];
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(paramab.LHC.length), " redirect type:", Integer.valueOf(localObject[talk.vZT]), " SimpleRedirect value:", Integer.valueOf(talk.vZT) });
    a.ay[] arrayOfay = paramab.LHp;
    a.av localav = paramab.LGE;
    if ((paramab.LHs & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfay, localav, parame, bool, paramab.groupId, paramab.CcE, paramab.CcF, paramab.LHz, paramab.LHA, paramab.LHB, (int[])localObject, paramab.LGG, this.MlX);
      if (paramab.LHw != 0)
      {
        com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramab.LHw });
        MlL = paramab.LHw * 1000;
      }
      fZI();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq) });
      AppMethodBeat.o(213668);
      return;
    }
  }
  
  private void a(int paramInt, a.aj paramaj)
  {
    AppMethodBeat.i(213667);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.Mmo.iS(null);
      AppMethodBeat.o(213667);
      return;
    }
    paramaj = paramaj.LHM;
    if ((paramaj == null) || (paramaj.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(213667);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramaj.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = paramaj[paramInt];
      if (localObject != null)
      {
        a(localObject.groupId, null, 0, localObject.CcE, localObject.CcF, localObject.LHp, null, null, false, false);
        localArrayList.add(c.fZv().bag(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.Mmo.iS(localArrayList);
    AppMethodBeat.o(213667);
  }
  
  /* Error */
  private void a(final int paramInt1, final a.ay[] paramArrayOfay, final a.av paramav, final byte[] paramArrayOfByte1, final boolean paramBoolean, final String paramString, final int paramInt2, final long paramLong, int paramInt3, final int paramInt4, final byte[] paramArrayOfByte2, final int[] paramArrayOfInt, final int paramInt5, final int paramInt6)
  {
    // Byte code:
    //   0: ldc_w 824
    //   3: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 330
    //   9: bipush 6
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 826
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
    //   44: invokestatic 639	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_5
    //   50: aload_0
    //   51: getfield 191	com/tencent/wecall/talkroom/model/f:state	I
    //   54: invokestatic 404	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 375	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 464	com/tencent/wecall/talkroom/model/f:Mmh	Lcom/tencent/wecall/talkroom/model/b;
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
    //   91: invokespecial 829	com/tencent/wecall/talkroom/model/f:a	([Lcom/tencent/pb/common/b/a/a/a$ay;Lcom/tencent/pb/common/b/a/a/a$av;[BZIJII[B[III)Z
    //   94: istore 16
    //   96: ldc_w 330
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 831
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: iload 16
    //   113: invokestatic 397	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: aastore
    //   117: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: iload 16
    //   122: ifeq +39 -> 161
    //   125: ldc_w 824
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
    //   146: ldc_w 833
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
    //   166: getfield 238	com/tencent/wecall/talkroom/model/f:Mmg	Lcom/tencent/wecall/talkroom/model/h;
    //   169: sipush 202
    //   172: invokevirtual 693	com/tencent/wecall/talkroom/model/h:aiw	(I)V
    //   175: ldc_w 330
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc_w 835
    //   187: aastore
    //   188: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: aload 6
    //   194: iload 7
    //   196: lload 8
    //   198: bipush 102
    //   200: iconst_1
    //   201: invokevirtual 713	com/tencent/wecall/talkroom/model/f:a	(Ljava/lang/String;IJIZ)Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 256	com/tencent/wecall/talkroom/model/f:Mmo	Lcom/tencent/wecall/talkroom/model/g;
    //   209: sipush -400
    //   212: aconst_null
    //   213: invokevirtual 672	com/tencent/wecall/talkroom/model/g:m	(ILjava/lang/Object;)V
    //   216: ldc_w 824
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
    //   257: invokespecial 838	com/tencent/wecall/talkroom/model/f$4:<init>	(Lcom/tencent/wecall/talkroom/model/f;I[Lcom/tencent/pb/common/b/a/a/a$ay;Lcom/tencent/pb/common/b/a/a/a$av;[BZLjava/lang/String;IJII[B[III)V
    //   260: ldc2_w 839
    //   263: invokevirtual 844	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   266: pop
    //   267: ldc_w 824
    //   270: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: return
    //   274: astore 17
    //   276: goto -139 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	f
    //   0	279	1	paramInt1	int
    //   0	279	2	paramArrayOfay	a.ay[]
    //   0	279	3	paramav	a.av
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
    LFC = parame;
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
    if (!aiq(paramInt3)) {
      this.Mmg.fZW();
    }
    this.Mmg.fZV();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.Mmh.fZs(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.fSR().a(paramString1);
    c(paramString1);
    AppMethodBeat.o(62731);
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.uRy = paramInt;
    this.Clq = paramLong;
    this.ukT = paramString2;
    this.MlP = paramString1;
    this.MlO = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62754);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(62754);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(213671);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(213671);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfay.length;
    int i = 0;
    while (i < j)
    {
      a.ay localay = paramArrayOfay[i];
      if (localay != null) {
        localStringBuffer.append(" memberId:" + localay.oWb + " uuid: " + localay.dtx + " status: " + localay.status + "   mem.inviteTime:" + localay.LIJ + "  mem.reason: " + localay.reason + "  mem.inviteuuid: " + localay.LIV + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfay.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(213671);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz, a.aw paramaw, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213669);
    a(paramString1, paramInt2, paramLong, paramArrayOfay);
    c localc = c.fZv();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.ukT == null) || (!this.ukT.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramaw, paramArrayOfay, paramArrayOfaz, paramBoolean1, bool);
      paramString2 = this.ukT;
      i = this.uRy;
      l = this.Clq;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfay == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfay.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.MlU) });
      if (c.fZv().di(this.ukT, false))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.MlU), " mGroupId: ", this.ukT, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.MlU)
        {
          this.MlU = false;
          this.vcO = true;
          this.Mmq = k.gaa();
          this.MlS = this.MlQ;
          fZN();
        }
      }
      if (paramArrayOfay != null) {
        break label380;
      }
      AppMethodBeat.o(213669);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfay.length > 0) && (this.Mmh != null)) {
      a(paramArrayOfay);
    }
    AppMethodBeat.o(213669);
  }
  
  private void a(a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(213670);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(213670);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfay.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfay.length)
    {
      arrayOfInt[i] = paramArrayOfay[i].oWb;
      localStringBuffer.append(paramArrayOfay[i].oWb);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.Mmh == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(213670);
      return;
    }
    this.Mmh.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(213670);
  }
  
  private void a(a.p[] paramArrayOfp1, a.p[] paramArrayOfp2, int paramInt)
  {
    AppMethodBeat.i(213672);
    if (paramArrayOfp1 == null) {}
    for (int i = 0;; i = paramArrayOfp1.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfp1 != null) && (paramArrayOfp1.length > 0)) {
        break;
      }
      AppMethodBeat.o(213672);
      return;
    }
    this.Mmy = new String[paramArrayOfp1.length];
    this.Mmx = new short[paramArrayOfp1.length];
    this.MmA = new String[paramArrayOfp2.length];
    this.Mmz = new short[paramArrayOfp2.length];
    this.MmB = paramInt;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.MmB) });
    int j = paramArrayOfp1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.p localp = paramArrayOfp1[paramInt];
      this.Mmy[i] = localp.LGA;
      this.Mmx[i] = ((short)localp.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData ip: ", localp.LGA, " addr.port: ", Integer.valueOf(localp.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfp2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfp1 = paramArrayOfp2[paramInt];
      this.MmA[i] = paramArrayOfp1.LGA;
      this.Mmz[i] = ((short)paramArrayOfp1.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", paramArrayOfp1.LGA, " tcpAddr.port: ", Integer.valueOf(paramArrayOfp1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.Mmy), Arrays.toString(this.Mmx), this.ukT, this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq), Arrays.toString(this.MmA), Arrays.toString(this.Mmz), Integer.valueOf(this.MmB) });
    AppMethodBeat.o(213672);
  }
  
  private boolean a(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(213674);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(213674);
      return false;
    }
    this.MlW = paramArrayOfInt[talk.vZT];
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit general policy cnt:", Integer.valueOf(paramArrayOfInt.length), ", redirect type:", this.MlW + " wifigateway:" + paramInt5 });
    paramBoolean = b(paramArrayOfay, paramav, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
    AppMethodBeat.o(213674);
    return paramBoolean;
  }
  
  private static boolean aiq(int paramInt)
  {
    return paramInt != 1;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(62738);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = LFC;
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
      com.tencent.pb.talkroom.sdk.e locale = LFC;
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
      paramBoolean = com.tencent.pb.common.c.f.mJ(paramString, this.ukT);
      AppMethodBeat.o(62771);
      return paramBoolean;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.ukT, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.uRy), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.Clq) });
    if ((com.tencent.pb.common.c.f.mJ(paramString, this.ukT)) && (paramInt == this.uRy) && (paramLong == this.Clq))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    AppMethodBeat.o(62771);
    return false;
  }
  
  private boolean b(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(213675);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.ukT, " ip: ", Arrays.toString(this.Mmy), " ports: ", Arrays.toString(this.Mmx), " tcpIp: ", Arrays.toString(this.MmA), " tcpPorts: ", Arrays.toString(this.Mmz), " tcpStartTime: ", Integer.valueOf(this.MmB), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.fTk();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfay != null) && (paramArrayOfay.length > 0))
    {
      localObject1 = new int[paramArrayOfay.length];
      j = 0;
      while (j < paramArrayOfay.length)
      {
        localObject1[j] = paramArrayOfay[j].oWb;
        if (com.tencent.pb.common.c.f.equals(paramArrayOfay[j].dtx, (String)localObject2)) {
          i = paramArrayOfay[j].oWb;
        }
        j += 1;
      }
      paramArrayOfay = (a.ay[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.fZv().bab(this.ukT);
      this.Mmg.oWb = j;
      for (;;)
      {
        try
        {
          localObject2 = this.Mmh;
          locala = this.Mmi;
          localObject3 = c.fZv();
          localObject1 = this.ukT;
          localObject3 = ((c)localObject3).aZZ((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.Mmy;
          arrayOfShort1 = this.Mmx;
          arrayOfString = this.MmA;
          arrayOfShort2 = this.Mmz;
          m = this.MmB;
          localObject1 = null;
          if (paramav == null) {
            continue;
          }
          paramav = new i(paramav.LIb, paramav.hVk, paramav.hVl, paramav.LIc, paramav.LId, paramav.LIe, paramav.LIf, paramav.LIg, paramav.LIh, paramav.LIi, paramav.LIj, paramav.LIk);
          n = k.ls(com.tencent.pb.common.c.c.ClL);
          localObject1 = ((b)localObject2).Mlr;
          if (localObject1 != null) {
            continue;
          }
          paramInt1 = -1;
        }
        catch (Throwable paramArrayOfay)
        {
          talk.a locala;
          Object localObject3;
          short[] arrayOfShort1;
          String[] arrayOfString;
          short[] arrayOfShort2;
          int m;
          int n;
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "connectToCompenent", paramArrayOfay });
          paramInt1 = -99999;
          continue;
          paramInt1 = ((b)localObject2).Mlr.Open(locala, paramav, i, j, paramInt1, paramLong, (String[])localObject3, arrayOfShort1, 0, paramArrayOfay, paramArrayOfByte1, paramBoolean, n, arrayOfString, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
          continue;
          paramArrayOfay.handler.post(paramav);
          continue;
          AppMethodBeat.o(213675);
          return false;
        }
        paramArrayOfay = this.Mmo;
        paramav = new g.4(paramArrayOfay, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramav.run();
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.aiv(-3002);
        }
        if (paramInt1 == 0) {
          this.Mmg.CuM = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(213675);
        return true;
        localObject3 = ((TalkRoom)localObject3).aZY(com.tencent.pb.a.a.a.fTk());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).Mlx;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.ay)localObject3).Fpp) });
            i = ((a.ay)localObject3).Fpp;
            continue;
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramav = (a.av)localObject1;
          }
        }
      }
      paramArrayOfay = null;
    }
  }
  
  private void bjO()
  {
    AppMethodBeat.i(62767);
    PG();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c()
    {
      public final void ab(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            if ((com.tencent.pb.common.a.a.LER) && (localb.Mlr != null)) {
              break label140;
            }
          }
          for (;;)
          {
            if (f.this.Mmv)
            {
              f.this.Mmv = false;
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt) });
            }
            AppMethodBeat.o(62659);
            return;
            label140:
            localb.Mlr.SendAudio(paramAnonymousArrayOfByte, s, 0);
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
      this.Mmg.aiw(101);
      h.ait(-2001);
      this.Mmo.m(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.Mmg;
    }
    for (localh.MnC &= 0xFFFFFFFE;; localh.MnC |= 0x1)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62767);
      return;
      localh = this.Mmg;
    }
  }
  
  private void c(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62775);
    this.mHandler.removeCallbacks(this.MmG);
    this.MmF = paramd;
    this.mHandler.postDelayed(this.MmG, 3000L);
    AppMethodBeat.o(62775);
  }
  
  private boolean db(int paramInt, String paramString)
  {
    AppMethodBeat.i(62732);
    if (paramInt == 100)
    {
      AppMethodBeat.o(62732);
      return true;
    }
    if (aiq(paramInt))
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
      boolean bool = bai(paramString);
      AppMethodBeat.o(62732);
      return bool;
    }
    AppMethodBeat.o(62732);
    return false;
  }
  
  private void enS()
  {
    AppMethodBeat.i(62741);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "releaseConpent" });
    try
    {
      PG();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          fZH();
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
  
  private void fZD()
  {
    AppMethodBeat.i(213662);
    this.MlZ = -1;
    this.Mma = -1;
    this.Mmb = -1;
    this.Mmc = -1;
    this.Mmd = -1;
    this.Mme = -1;
    this.Mmf = -1;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "multitalk voiceMsg local seq reset" });
    AppMethodBeat.o(213662);
  }
  
  private int fZG()
  {
    AppMethodBeat.i(62734);
    if (this.MlT == 0L)
    {
      AppMethodBeat.o(62734);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.MlT) / 1000L);
    AppMethodBeat.o(62734);
    return i;
  }
  
  private boolean fZH()
  {
    AppMethodBeat.i(62737);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = LFC;
      if (locale == null) {
        break label99;
      }
      this.Mmg.CfJ = locale.dpo();
      this.Mmg.Cfy = locale.dpr();
      bool = locale.dpm();
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
  
  private void fZI()
  {
    AppMethodBeat.i(62759);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.Mmj != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(62759);
      return;
    }
    try
    {
      this.Mmj = new TimerTask()
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
      this.Mml.schedule(this.Mmj, 0L, MlL);
      AppMethodBeat.o(62759);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(62759);
    }
  }
  
  private void fZJ()
  {
    AppMethodBeat.i(62760);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.Mmk != null) {
        this.Mmk.cancel();
      }
      this.Mmk = null;
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
  
  private void fZK()
  {
    AppMethodBeat.i(62761);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.Mmj != null) {
        this.Mmj.cancel();
      }
      this.Mmj = null;
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
  
  private void fZL()
  {
    AppMethodBeat.i(62762);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.Mmm != null) {
        this.Mmm.cancel();
      }
      this.Mmm = null;
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
  
  private void fZM()
  {
    AppMethodBeat.i(62768);
    fZH();
    Object localObject = new AtomicInteger();
    final AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b()
    {
      public final int aa(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            AtomicInteger localAtomicInteger1 = this.MmZ;
            AtomicInteger localAtomicInteger2 = localAtomicInteger;
            if (com.tencent.pb.common.a.a.LER) {
              if (localb.Mlr == null)
              {
                break label169;
                if ((f.this.Mmw) && (i >= 0))
                {
                  f.this.Mmw = false;
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt), " ret: ", Integer.valueOf(i) });
                }
                AppMethodBeat.o(62788);
                return i;
              }
              else
              {
                i = localb.Mlr.GetAudioData(paramAnonymousArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
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
      this.Mmg.aiw(101);
      h.ait(-2001);
      localObject = this.Mmg;
      ((h)localObject).MnC |= 0x1;
      this.Mmo.m(-500, null);
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62768);
  }
  
  private void fZN()
  {
    AppMethodBeat.i(62769);
    if (this.Mmm != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(62769);
      return;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.MlE, " mIsHoldOn: ", Boolean.valueOf(this.MmC) });
    this.Mmm = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(62661);
        if (!f.this.MmC)
        {
          f.a(f.this, f.n(f.this) + 1);
          if (f.o(f.this)) {
            f.b(f.this, f.p(f.this) + 1);
          }
          if ((f.q(f.this) == 3) || (f.q(f.this) == 2))
          {
            f.c(f.this, f.r(f.this) + 1);
            f.this.Mmg.CuX = f.r(f.this);
          }
          f.this.Mmg.MnG = (f.n(f.this) * 1000);
          f.this.Mmg.CuW = f.n(f.this);
        }
        if (f.this.MlE != null) {
          f.n(f.this);
        }
        AppMethodBeat.o(62661);
      }
    };
    this.Mmn.scheduleAtFixedRate(this.Mmm, 1000L, 1000L);
    AppMethodBeat.o(62769);
  }
  
  private void fZO()
  {
    AppMethodBeat.i(62774);
    this.mHandler.removeCallbacks(this.MmG);
    this.MmF = null;
    AppMethodBeat.o(62774);
  }
  
  private static void fZP()
  {
    AppMethodBeat.i(62777);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.c.ClL.getSystemService("audio");
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
  
  public static boolean fZQ()
  {
    AppMethodBeat.i(62778);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.c.ClL.getSystemService("audio")).isSpeakerphoneOn();
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
  
  public static com.tencent.pb.talkroom.sdk.e fZR()
  {
    return LFC;
  }
  
  private boolean hg(String paramString, int paramInt)
  {
    AppMethodBeat.i(62735);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62735);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.LFq);
    boolean bool = com.tencent.pb.common.b.e.fSR().a(localc);
    this.Mmg.af(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.uRy, this.Clq, true);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62735);
    return bool;
  }
  
  static String[] iT(List<String> paramList)
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
  
  public final com.tencent.pb.talkroom.sdk.f J(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62745);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.vcO)
    {
      localObject = localf;
      if (this.Mmh == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo" });
        localb = this.Mmh;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfInt != null) && (localb.Mlr != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", localb.Mlr });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.vcO), " decInfo: ", paramArrayOfInt, " engine: ", this.Mmh });
      localObject = paramArrayOfInt;
      AppMethodBeat.o(62745);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.Mlr.videoDecode(paramArrayOfInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJJ = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJK = localb.Mlr.field_remoteImgLength;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJL = localb.Mlr.field_remoteImgWidth;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJM = localb.Mlr.field_remoteImgHeight;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJN = (localb.Mlr.field_remoteImgChannel & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJO = 0;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJH = c.fZv().he(a.fZg().ukT, ((com.tencent.pb.talkroom.sdk.f)localObject).LJN);
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
    AppMethodBeat.i(213666);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.vcO)
    {
      localObject = localf;
      if (this.Mmh == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen" });
        localb = this.Mmh;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfByte != null) && (paramArrayOfInt != null) && (localb.Mlr != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveScreen null, imgBuffer32:", paramArrayOfInt, ", engine:", localb.Mlr });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen finished, ", Boolean.valueOf(this.vcO), " decInfo: ", paramArrayOfByte, " engine: ", this.Mmh });
      localObject = paramArrayOfByte;
      AppMethodBeat.o(213666);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.Mlr.screenDecode(paramArrayOfByte, paramArrayOfInt, paramInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJP = paramArrayOfByte;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJJ = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJK = localb.Mlr.field_remoteImgLength_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJL = localb.Mlr.field_remoteImgWidth_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJM = localb.Mlr.field_remoteImgHeight_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJN = (localb.Mlr.field_remoteImgChannel_screen & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJO = localb.Mlr.field_remoteImgOrien_screen;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen channel:", Integer.valueOf(localb.Mlr.field_remoteImgChannel_screen) });
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen field_remoteImgOrien:", Integer.valueOf(localb.Mlr.field_remoteImgOrien_screen) });
      ((com.tencent.pb.talkroom.sdk.f)localObject).LJH = c.fZv().he(a.fZg().ukT, ((com.tencent.pb.talkroom.sdk.f)localObject).LJN);
      if (paramArrayOfInt != null) {
        continue;
      }
      paramInt = 0;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "steve:receiveScreen imgBuffer32 size:", Integer.valueOf(paramInt), " MultiTalkVideoDecodeInfo: ", localObject });
      paramArrayOfByte = (byte[])localObject;
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62744);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.vcO) && (this.Mmh != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.Mmh;
        if ((paramArrayOfByte == null) || (localb.Mlr == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.Mlr });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.vcO), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.Mmh });
          AppMethodBeat.o(62744);
          return paramArrayOfByte;
        }
        paramInt1 = localb.Mlr.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.LJQ = paramArrayOfInt;
        paramArrayOfByte.LJR = localb.Mlr.field_localImgWidth;
        paramArrayOfByte.LJS = localb.Mlr.field_localImgHeight;
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
  
  public final b a(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    AppMethodBeat.i(183718);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.uRy), Integer.valueOf(paramInt1), Long.valueOf(this.Clq), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    this.MlX = paramInt4;
    if (!com.tencent.pb.a.a.a.fTl())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.fTl()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.fTm()) });
      h.a(paramString1, "", this.uRy, this.Clq, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = b.Mni;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((aiq(paramInt3)) && (paramInt3 != 100) && (evW()))
    {
      h.a(paramString1, "", this.uRy, this.Clq, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = b.Mnm;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (!db(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.uRy, this.Clq, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = b.Mnn;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.uRy, this.Clq, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = b.Mno;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (aiq(paramInt3))
    {
      this.Mmg.reset();
      zC(false);
    }
    fZE();
    if (!enV())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (aiq(paramInt3))
      {
        h.a(paramString1, "", this.uRy, this.Clq, new String[] { "enter", "req", "false", "initEnginefail" });
        zC(false);
      }
      for (;;)
      {
        paramString1 = b.Mnq;
        AppMethodBeat.o(183718);
        return paramString1;
        this.Mmg.af(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.ukT = paramString1;
    Object localObject;
    long l;
    label705:
    label711:
    boolean bool;
    if (!aiq(paramInt3))
    {
      localObject = bah(paramString1);
      if (localObject == null)
      {
        paramInt4 = 0;
        this.uRy = paramInt4;
        if (localObject != null) {
          break label875;
        }
        l = 0L;
        this.Clq = l;
        this.Mms = paramString1;
        this.LFq = paramInt2;
        setState(3);
        if (!aiq(paramInt3)) {
          break label898;
        }
        bool = true;
        label738:
        this.BYH = bool;
        if (this.BYH) {
          this.Mmg.fZT();
        }
        if ((!this.BYH) || (c.fZv().di(this.ukT, true))) {
          break label904;
        }
        localObject = new c();
        ((c)localObject).groupId = paramString1;
        ((c)localObject).roomId = paramInt1;
        ((c)localObject).uLt = paramLong;
        ((c)localObject).vug = paramInt3;
        ((c)localObject).LGa = paramInt2;
        ((c)localObject).Mns = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = localObject;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = b.Mnh;
      AppMethodBeat.o(183718);
      return paramString1;
      paramInt4 = ((e)localObject).roomId;
      break;
      label875:
      l = ((e)localObject).uLt;
      break label705;
      this.uRy = paramInt1;
      this.Clq = paramLong;
      break label711;
      label898:
      bool = false;
      break label738;
      label904:
      a(paramString1, this.uRy, this.Clq, paramInt2, paramInt3, paramString2);
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
          h.ais(((Integer)paramString.get(Integer.valueOf(i))).intValue());
        }
      }
      if (paramInt2 != -1) {
        break label1170;
      }
      try
      {
        if (paramd.getType() == 201)
        {
          paramString = (com.tencent.wecall.talkroom.a.d)paramd;
          if (com.tencent.pb.common.c.f.mJ(this.MlP, paramString.MlP))
          {
            this.Mmg.aiw(301);
            this.Mmg.af(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            hg(paramString.MlP, 1001);
            if (!paramString.Moc) {
              this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.Mmo.m(-100, null);
          }
          AppMethodBeat.o(62742);
          return;
          paramString = "";
        }
        else if (paramd.getType() == 209)
        {
          paramString = (com.tencent.wecall.talkroom.a.g)paramd;
          this.Mmo.hf(paramString.ukT, paramInt2);
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
      if (!b(paramString.ukT, paramString.uRy, paramString.Clq, false)) {
        h.a(paramString.ukT, paramString.uRy, paramString.Clq, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.Mmo.a(paramString.Mob, c.fZv().bag(paramString.ukT));
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.ukT, paramString.uRy, paramString.Clq, false))
      {
        this.Mmg.af(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.Mmo.m(-300, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.ukT, paramString.uRy, paramString.Clq, aiq(paramString.Mod))) && (this.state == 3))
      {
        this.Mmg.aiw(302);
        this.Mmo.m(-200, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.Mmo.iS(null);
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 213)
    {
      if (com.tencent.pb.common.c.f.equals(((com.tencent.wecall.talkroom.a.j)paramd).ukT, this.ukT))
      {
        this.Mmg.af(new String[] { "sendmsg", "resp", "-1", String.valueOf(this.state) });
        this.Mmo.m(-700, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (b(paramString.groupId, paramString.roomId, paramString.uLt, false)) {
        this.Mmg.af(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (m)paramd;
      if (b(paramString.ukT, paramString.uRy, paramString.Clq, false)) {
        this.Mmo.m(-800, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      if (b(paramString.ukT, paramString.uRy, paramString.Clq, false)) {
        this.Mmo.m(-1600, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 801)
    {
      paramString = (com.tencent.wecall.talkroom.a.k)paramd;
      if (b(paramString.ukT, paramString.uRy, paramString.Clq, false)) {
        this.Mmo.m(-1601, null);
      }
    }
    AppMethodBeat.o(62742);
    return;
    label1170:
    Object localObject1;
    Object localObject2;
    if (paramd.getType() == 201)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.d)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).LFo != null))
      {
        paramString = (a.aa)((com.tencent.pb.common.b.d)localObject1).LFo;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).MlP });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).Moc) {
          break label3210;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.ais(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          MlF = null;
          if (paramInt2 == 0) {
            break label3477;
          }
          if (com.tencent.pb.common.c.f.mJ(this.MlP, ((com.tencent.wecall.talkroom.a.d)localObject1).MlP)) {
            break label3216;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.MlP, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).MlP, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1459:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.LFo != null)) {
        a(paramInt2, (a.ab)paramString.LFo, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.LFo != null))
      {
        localObject1 = (a.y)paramString.LFo;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303), Integer.valueOf(14651), Integer.valueOf(-1309) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.ais(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label4486;
        }
        if (b(paramString.ukT, paramString.uRy, paramString.Clq, false))
        {
          this.Mmg.af(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (paramInt2 != 14651) {
            break label4472;
          }
          com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14651), ((a.y)localObject1).groupId, Integer.valueOf(((a.y)localObject1).CcE), Long.valueOf(((a.y)localObject1).CcF) });
          this.Mmo.m(-301, localObject1);
        }
      }
    }
    label1850:
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.LFo != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ac)paramString.LFo).groupId, this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.a.N(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.ais(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (n)paramd;
      if ((paramString != null) && (paramString.LFo != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.am)paramString.LFo).groupId, this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        fZJ();
        i = 0;
        if (paramInt2 != 14800) {
          break label4703;
        }
        i = -1401;
        label2210:
        if (i != 0)
        {
          this.Mmg.aiw(324);
          h.ais(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.LFo != null))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.ukT, " roomid: ", Integer.valueOf(paramString.uRy), " roomKey: ", Long.valueOf(paramString.Clq) });
        if (paramInt2 != 18950) {
          break label4718;
        }
        if (!b(paramString.ukT, paramString.uRy, paramString.Clq, false)) {
          h.a(paramString.ukT, paramString.uRy, paramString.Clq, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.fZv().bag(paramString.ukT);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.ukT, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.Mmo.a(paramString.Mob, (MultiTalkGroup)localObject1);
        }
      }
    }
    label2468:
    if (paramd.getType() == 207)
    {
      paramString = (com.tencent.wecall.talkroom.a.i)paramd;
      if ((paramString != null) && (paramString.LFo != null))
      {
        if (paramInt2 == 18100) {
          h.ais(-1501);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 208)
    {
      paramString = (com.tencent.wecall.talkroom.a.c)paramd;
      if ((paramString != null) && (paramString.LFo != null))
      {
        if (paramInt2 == 18300) {
          h.ais(-1531);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 209)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).LFo != null))
      {
        paramString = (a.ad)((com.tencent.pb.common.b.d)localObject1).LFo;
        if (paramInt2 == 17900) {
          h.ais(-1511);
        }
        if (paramInt2 == 0) {
          break label5124;
        }
        this.Mmo.hf(((com.tencent.wecall.talkroom.a.g)localObject1).ukT, paramInt2);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 210)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 == 19100) {
        h.ais(-1541);
      }
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (paramString != null) {
        a(paramInt1, paramInt2, paramd.LFo, paramString);
      }
    }
    if (paramd.getType() == 212) {
      a(paramInt2, (a.aj)paramd.LFo);
    }
    if (paramd.getType() == 213)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break label5223;
      }
      if (com.tencent.pb.common.c.f.equals(paramString.ukT, this.ukT))
      {
        this.Mmg.af(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.Mmo.m(-700, null);
      }
    }
    label2909:
    if (paramd.getType() == 214)
    {
      paramString = (a.ah)paramd.LFo;
      localObject1 = (m)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (!b(((m)localObject1).ukT, ((m)localObject1).uRy, ((m)localObject1).Clq, false)) {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((m)localObject1).ukT, Integer.valueOf(((m)localObject1).uRy) });
      }
    }
    else if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
      if (b(paramString.ukT, paramString.uRy, paramString.Clq, false)) {
        break label5687;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.ukT, Integer.valueOf(paramString.uRy) });
    }
    label3210:
    label3216:
    label3475:
    label3477:
    label4660:
    label5561:
    for (;;)
    {
      label3017:
      if (paramd.getType() == 801)
      {
        paramString = (com.tencent.wecall.talkroom.a.k)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo errCode: ", Integer.valueOf(paramInt2) });
        if (!b(paramString.ukT, paramString.uRy, paramString.Clq, false))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo isCurrentRoom is not same", paramString.ukT, Integer.valueOf(paramString.uRy) });
          AppMethodBeat.o(62742);
          return;
          i = 0;
          break;
          if (paramInt2 != -1)
          {
            this.Mmg.aiw(321);
            this.Mmg.af(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          if (this.state != 1)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).MlP });
            if (i == 0) {
              break label1459;
            }
            this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          a(this.ukT, this.uRy, this.Clq, true);
          if (paramInt2 == 14051) {
            this.Mmo.m(-900, null);
          }
          for (;;)
          {
            if (i == 0) {
              break label3475;
            }
            this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break;
            if (paramInt2 == 14052) {
              this.Mmo.m(-1100, null);
            } else if (paramInt2 == 14053) {
              this.Mmo.m(-1300, paramString);
            } else if (paramInt2 == 14504) {
              this.Mmo.m(-1400, null);
            } else {
              this.Mmo.m(-100, null);
            }
          }
          break label1459;
          if (!com.tencent.pb.common.c.f.mJ(this.MlP, paramString.LFV))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.MlP, " resp.clientGroupId: ", paramString.LFV, Integer.valueOf(paramString.CcE), Long.valueOf(paramString.CcF) });
            a(paramString.groupId, paramString.CcE, paramString.CcF, 110, false);
            if (i == 0) {
              break label1459;
            }
            this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          this.Mmg.af(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (this.state != 1)
          {
            h.ais(-1003);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.LFV, Integer.valueOf(paramString.CcE), Long.valueOf(paramString.CcF) });
            if (i == 0) {
              break label1459;
            }
            this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          if ((paramString.LHq == null) || (paramString.LHq.length == 0))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.LFV, Integer.valueOf(paramString.CcE), Long.valueOf(paramString.CcF) });
            h.ais(-1605);
            this.Mmg.CuJ = 329;
            a(paramString.groupId, paramString.CcE, paramString.CcF, 116, true);
            if (i != 0) {
              this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.Mmo.m(-100, null);
            break label1459;
          }
          a(paramString.LFV, paramString.CcE, paramString.CcF, paramString.groupId, paramString.LFX.LIu);
          this.Mms = paramString.groupId;
          this.LFq = paramString.LGa;
          setState(4);
          a(paramString.LHq, paramString.LHx, paramString.LHy);
          a(paramString.groupId, paramString.LFV, paramString.LGa, paramString.CcE, paramString.CcF, paramString.LGD, paramString.LHr, paramString.LFX, false, true);
          if (this.Mmo != null)
          {
            localObject1 = this.Mmo;
            localObject2 = new g.8((g)localObject1, c.fZv().bag(paramString.groupId));
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label4042;
            }
            ((Runnable)localObject2).run();
          }
          for (;;)
          {
            localObject1 = new byte[paramString.LHt.length];
            j = 0;
            while (j < paramString.LHt.length)
            {
              localObject1[j] = ((byte)paramString.LHt[j]);
              j += 1;
            }
            label4042:
            ((g)localObject1).handler.post((Runnable)localObject2);
          }
          localObject2 = new int[paramString.LHC.length];
          int j = 0;
          while (j < paramString.LHC.length)
          {
            localObject2[j] = paramString.LHC[j];
            j += 1;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(paramString.LHC.length), " redirect type:", Integer.valueOf(localObject2[talk.vZT]), " SimpleRedirect value:", Integer.valueOf(talk.vZT) });
          a.ay[] arrayOfay = paramString.LGD;
          a.av localav = paramString.LGE;
          if ((paramString.LHs & 0x2) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            a(0, arrayOfay, localav, (byte[])localObject1, bool, paramString.groupId, paramString.CcE, paramString.CcF, paramString.LHz, paramString.LHA, paramString.LHB, (int[])localObject2, paramString.LGG, this.MlX);
            if (paramString.LHw != 0)
            {
              com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.LHw });
              MlL = paramString.LHw * 1000;
            }
            fZI();
            O(paramString.groupId, paramString.CcE, paramString.CcF);
            if (i != 0)
            {
              localObject1 = new HashMap();
              ((Map)localObject1).put("result", Boolean.TRUE);
              ((Map)localObject1).put("shareUrl", new String(paramString.LFX.LIo, Charset.forName("utf-8")));
              ((Map)localObject1).put("smsShortUrl", new String(paramString.LFX.LIp, Charset.forName("utf-8")));
              ((Map)localObject1).put("groupId", paramString.groupId);
              this.Mki.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq) });
            break;
          }
          label4472:
          this.Mmo.m(-300, null);
          break label1850;
          if (((a.y)localObject1).LHp == null)
          {
            i = 0;
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
            if (b(((a.y)localObject1).groupId, ((a.y)localObject1).CcE, ((a.y)localObject1).CcF, false)) {
              break label4660;
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.y)localObject1).groupId, this.ukT, " resp.roomid: ", Integer.valueOf(((a.y)localObject1).CcE), Integer.valueOf(this.uRy) });
            h.ais(-1308);
          }
          for (;;)
          {
            a(((a.y)localObject1).groupId, null, this.LFq, ((a.y)localObject1).CcE, ((a.y)localObject1).CcF, ((a.y)localObject1).LHp, null, ((a.y)localObject1).LFX, true, true);
            break;
            i = ((a.y)localObject1).LHp.length;
            break label4497;
            this.Mmg.af(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          label4703:
          if (paramInt2 != 14801) {
            break label2210;
          }
          i = -1402;
          break label2210;
          label4718:
          if (paramInt2 == 0) {
            this.MlM = true;
          }
          if (!evW())
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.ukT });
            this.Mmg.reset();
            zC(false);
            this.Mmg.af(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
            this.BYH = false;
            this.ukT = paramString.ukT;
            this.Mms = this.ukT;
            this.uRy = paramString.uRy;
            this.Clq = paramString.Clq;
            this.LFq = paramString.LFq;
            setState(2);
            this.MlT = System.currentTimeMillis();
            localObject1 = this.Mmg;
            com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "beginNotifyTime" });
            ((h)localObject1).MnR = System.currentTimeMillis();
            if (paramInt2 == 18900) {
              h.ais(-1521);
            }
          }
          while (!com.tencent.pb.common.c.f.equals(paramString.ukT, this.ukT))
          {
            localObject1 = new e();
            ((e)localObject1).groupId = paramString.ukT;
            ((e)localObject1).roomId = paramString.uRy;
            ((e)localObject1).uLt = paramString.Clq;
            this.MlG.put(paramString.ukT, localObject1);
            localObject1 = c.fZv().bag(paramString.ukT);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.ukT, " multiTalkGroup: ", localObject1 });
            if (localObject1 == null) {
              break label5102;
            }
            paramString = this.Mmo;
            localObject1 = new g.2(paramString, (MultiTalkGroup)localObject1);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label5089;
            }
            ((Runnable)localObject1).run();
            break;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.ukT });
          break label2468;
          label5089:
          paramString.handler.post((Runnable)localObject1);
          break label2468;
          label5102:
          a(paramString.ukT, paramString.uRy, paramString.Clq, false, false, false);
          break label2468;
          localObject1 = c.fZv().aZZ(paramString.groupId);
          if (localObject1 != null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
            a(paramString.groupId, null, ((TalkRoom)localObject1).fZj(), TalkRoom.fZk(), TalkRoom.exx(), null, null, paramString.LFX, true, false);
          }
          for (;;)
          {
            this.Mmo.hf(paramString.groupId, 0);
            break;
            a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.LFX, true, false);
          }
          label5223:
          if (!com.tencent.pb.common.c.f.equals(paramString.ukT, this.ukT)) {
            break label2909;
          }
          this.Mmg.af(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          paramString = this.Mmo;
          localObject1 = new g.22(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label2909;
          }
          paramString.handler.post((Runnable)localObject1);
          break label2909;
          if (this.Mmh != null)
          {
            localObject1 = new int[6];
            localObject1[0] = paramString.GnD;
            localObject1[1] = paramString.LHE;
            localObject1[2] = paramString.LHF;
            localObject1[3] = paramString.LHG;
            localObject1[4] = paramString.LHH;
            localObject1[5] = paramString.LHI;
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject1[2]), Integer.valueOf(localObject1[3]), Integer.valueOf(localObject1[4]), Integer.valueOf(localObject1[5]) });
            localObject2 = this.Mmh;
            if (((b)localObject2).Mlr != null) {
              break label5561;
            }
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject1, ", engine:", ((b)localObject2).Mlr });
          }
          for (;;)
          {
            if (paramString.LHL == 0)
            {
              if (paramInt2 == 0)
              {
                localObject1 = this.Mmo;
                paramString = new g.17((g)localObject1, paramString.GnD);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  paramString.run();
                  break;
                  ((b)localObject2).Mlr.setMVSvrCfg((int[])localObject1, 6);
                  continue;
                }
                ((g)localObject1).handler.post(paramString);
                break;
              }
              if (paramInt2 == 24301)
              {
                this.Mmo.m(-1700, Integer.valueOf(paramString.LHK));
                break;
              }
              this.Mmo.m(-800, null);
              break;
            }
          }
          if (paramString.LHL != 1) {
            break label3017;
          }
          paramString = this.Mmo;
          localObject1 = new g.18(paramString, paramInt2);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label3017;
          }
          paramString.handler.post((Runnable)localObject1);
          break label3017;
          if (paramInt2 == 0)
          {
            paramString = this.Mmo;
            localObject1 = new g.19(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              continue;
            }
            paramString.handler.post((Runnable)localObject1);
            continue;
          }
          this.Mmo.m(-1600, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.Mmo;
          paramd = new g.20(paramString);
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
        this.Mmo.m(-1601, null);
      }
    }
    label4486:
    label4497:
    label5687:
    AppMethodBeat.o(62742);
    label5124:
  }
  
  public final void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(62755);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.ukT, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.uRy), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.Clq) });
    c.fZv().baa(paramString);
    if (paramBoolean1) {
      O(paramString, paramInt, paramLong);
    }
    this.MlG.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      zC(true);
      this.Mmo.dj(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.fZv().bag(paramString);
      if (paramString != null) {
        this.Mmo.f(paramString);
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
    boolean bool = com.tencent.pb.common.b.e.fSR().a(localf);
    this.Mmg.af(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62736);
    return bool;
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(213663);
    int j = -1;
    int i = j;
    if (this.vcO)
    {
      i = j;
      if (this.Mmh == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.Mmh;
        if ((paramArrayOfByte != null) && (localb.Mlr != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.Mlr });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.vcO), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.Mmh });
      i = paramInt1;
      AppMethodBeat.o(213663);
      return i;
      paramInt1 = localb.Mlr.SendVideo(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final boolean b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62733);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.ukT, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
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
        fZG();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.fSR().a(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.Mmg.af(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
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
      this.Mmg.fZU();
    }
    int i = this.uRy;
    long l = this.Clq;
    int j = a.fZg().state;
    if (j.ban(paramString))
    {
      this.Mmg.aiw(327);
      bool = a.fZg().hg(paramString, 1000);
      AppMethodBeat.o(62773);
      return bool;
    }
    if (j == 2)
    {
      bool = a.fZg().b(paramString, i, l, paramInt1);
      AppMethodBeat.o(62773);
      return bool;
    }
    com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.fZg().a(paramString, i, l, paramInt2, true);
    AppMethodBeat.o(62773);
    return bool;
  }
  
  public final e bah(String paramString)
  {
    AppMethodBeat.i(62757);
    paramString = (e)this.MlG.get(paramString);
    AppMethodBeat.o(62757);
    return paramString;
  }
  
  public final boolean bai(String paramString)
  {
    AppMethodBeat.i(62758);
    if ((e)this.MlG.get(paramString) != null)
    {
      AppMethodBeat.o(62758);
      return true;
    }
    AppMethodBeat.o(62758);
    return false;
  }
  
  public final int cU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62753);
    long l;
    int n;
    label348:
    int i1;
    try
    {
      paramArrayOfByte = (a.q)com.google.b.a.e.a(new a.q(), paramArrayOfByte, paramArrayOfByte.length);
      if (paramArrayOfByte == null) {
        if ((!TextUtils.isEmpty(this.ukT)) || (!TextUtils.isEmpty(this.MlP)))
        {
          this.Mmg.af(new String[] { "notify", "pasrefail" });
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
        h.ais(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.uRy, this.Clq, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange ", this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq), Long.valueOf(paramArrayOfByte.msgId), Integer.valueOf(paramArrayOfByte.LGB), Integer.valueOf(paramArrayOfByte.inh) });
      l = paramArrayOfByte.msgId;
      if (this.Mmt.contains(Long.valueOf(l)))
      {
        n = 1;
        if (n == 0) {
          break label392;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error: msgId:", Long.valueOf(paramArrayOfByte.msgId) });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false)) {
          break label348;
        }
        this.Mmg.af(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.LGB) });
      }
      for (;;)
      {
        AppMethodBeat.o(62753);
        return -3;
        this.Mmt.add(Long.valueOf(l));
        n = 0;
        break;
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.LGB) });
      }
      label392:
      n = paramArrayOfByte.LGB;
      i1 = paramArrayOfByte.inh;
      switch (n)
      {
      default: 
        com.tencent.pb.common.c.b.w(" unknow voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1) });
        n = 0;
      }
    }
    if (n == 0) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange update msg seq fail type:", Integer.valueOf(paramArrayOfByte.LGB) });
    }
    for (;;)
    {
      AppMethodBeat.o(62753);
      return 0;
      if (i1 <= this.MlZ)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MlZ) });
        n = 0;
        break;
      }
      this.MlZ = i1;
      for (;;)
      {
        com.tencent.pb.common.c.b.w("voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1), " update local seq" });
        n = 1;
        break;
        if (i1 <= this.Mma)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Mma) });
          n = 0;
          break;
        }
        this.Mma = i1;
        continue;
        if (i1 <= this.Mmb)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Mmb) });
          n = 0;
          break;
        }
        this.Mmb = i1;
        continue;
        if (i1 <= this.Mmc)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Mmc) });
          n = 0;
          break;
        }
        this.Mmc = i1;
        continue;
        if (i1 <= this.Mmd)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Mmd) });
          n = 0;
          break;
        }
        this.Mmd = i1;
        continue;
        if (i1 <= this.Mme)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Mme) });
          n = 0;
          break;
        }
        this.Mme = i1;
        continue;
        if (i1 <= this.Mmf)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Mmf) });
          n = 0;
          break;
        }
        this.Mmf = i1;
      }
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false)) {
        this.Mmg.af(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.LGB) });
      }
      if (paramArrayOfByte.LGB == 2)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.LGa, paramArrayOfByte.CcE, paramArrayOfByte.CcF, paramArrayOfByte.LGD, paramArrayOfByte.LGC, paramArrayOfByte.LFX, true, true);
      }
      else
      {
        Object localObject1;
        if (paramArrayOfByte.LGB == 4)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.LGa, paramArrayOfByte.CcE, paramArrayOfByte.CcF, paramArrayOfByte.LGD, paramArrayOfByte.LGC, paramArrayOfByte.LFX, true, true);
          if ((paramArrayOfByte.LGF != 0) || (paramArrayOfByte.LGG != 0))
          {
            localObject1 = this.Mmh;
            n = paramArrayOfByte.LGF;
            i1 = paramArrayOfByte.LGG;
            if ((com.tencent.pb.common.a.a.LER) && (((b)localObject1).Mlr != null)) {
              ((b)localObject1).Mlr.SetAVEncryptType(n, i1);
            }
          }
        }
        else if (paramArrayOfByte.LGB == 16)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.LGa, paramArrayOfByte.CcE, paramArrayOfByte.CcF, paramArrayOfByte.LGD, paramArrayOfByte.LGC, paramArrayOfByte.LFX, true, false);
        }
        else if (paramArrayOfByte.LGB == 1)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.CcE), " roomkey: ", Long.valueOf(paramArrayOfByte.CcF) });
          if (com.tencent.pb.a.a.a.fTl())
          {
            com.tencent.pb.a.a.a.fTm();
            if ((evW()) && (com.tencent.pb.common.c.f.equals(paramArrayOfByte.groupId, this.ukT))) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.ukT });
            }
          }
          else
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
            continue;
          }
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.LGa, paramArrayOfByte.CcE, paramArrayOfByte.CcF, paramArrayOfByte.LGD, paramArrayOfByte.LGC, paramArrayOfByte.LFX, false, true);
          localObject1 = paramArrayOfByte.groupId;
          n = paramArrayOfByte.CcE;
          l = paramArrayOfByte.CcF;
          i1 = paramArrayOfByte.LGa;
          int i2 = paramArrayOfByte.LGH;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
          }
          for (;;)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
            break;
            paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, n, l, i1, i2);
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i2), Boolean.valueOf(com.tencent.pb.common.b.e.fSR().a(paramArrayOfByte)) });
          }
        }
        else if (paramArrayOfByte.LGB == 8)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.ukT });
          if (b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false))
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.LGa, paramArrayOfByte.CcE, paramArrayOfByte.CcF, paramArrayOfByte.LGD, paramArrayOfByte.LGC, paramArrayOfByte.LFX, true, false);
            a(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false, false, true);
          }
          else
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.LGa, paramArrayOfByte.CcE, paramArrayOfByte.CcF, paramArrayOfByte.LGD, paramArrayOfByte.LGC, paramArrayOfByte.LFX, true, false);
          }
        }
        else
        {
          String str;
          if (paramArrayOfByte.LGB == 128)
          {
            localObject1 = paramArrayOfByte.groupId;
            str = this.ukT;
            if (paramArrayOfByte.LGI == null) {}
            for (n = 0;; n = paramArrayOfByte.LGI.length)
            {
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(n) });
              localObject1 = this.Mmo;
              paramArrayOfByte = new g.21((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.LGI);
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
            if (paramArrayOfByte.LGB == 256)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
              } else if (paramArrayOfByte.LGI == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
              } else {
                try
                {
                  localObject1 = paramArrayOfByte.LGI;
                  localObject1 = (a.s)com.google.b.a.e.a(new a.s(), (byte[])localObject1, localObject1.length);
                  if ((localObject1 == null) || (((a.s)localObject1).LGM == null)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
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
                  localObject2 = ((a.s)localObject2).LGM;
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
                  com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.ukT, " roomId: ", Integer.valueOf(this.uRy), " videoUserNames: ", paramArrayOfByte });
                  localObject2 = this.Mmo;
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
            else if (paramArrayOfByte.LGB == 1024)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
              }
              else if ((this.state != 3) && (this.state != 4))
              {
                b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, 1);
                this.Mmo.m(-1400, null);
              }
            }
            else if (paramArrayOfByte.LGB == 512)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
              } else if (paramArrayOfByte.LGI == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
              } else {
                try
                {
                  localObject2 = paramArrayOfByte.LGI;
                  localObject2 = (a.r)com.google.b.a.e.a(new a.r(), (byte[])localObject2, localObject2.length);
                  if (localObject2 == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
                  }
                }
                catch (com.google.b.a.d locald2)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                    local1 = null;
                  }
                  paramArrayOfByte = this.Mmo;
                  g.1 local1 = new g.1(paramArrayOfByte, local1.LGL);
                  if (Looper.myLooper() == Looper.getMainLooper())
                  {
                    local1.run();
                    continue;
                  }
                  paramArrayOfByte.handler.post(local1);
                }
              }
            }
            else if (paramArrayOfByte.LGB == 2048)
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, chgtype: audiostream" });
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.CcE, paramArrayOfByte.CcF, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAudioStreamChange is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.CcE) });
              }
              else
              {
                com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleAudioStreamChange audio_stream_type", Integer.valueOf(paramArrayOfByte.audioStreamType) });
                int i = (byte)(paramArrayOfByte.audioStreamType & 0xFF);
                int j = (byte)(paramArrayOfByte.audioStreamType >> 8 & 0xFF);
                int k = (byte)(paramArrayOfByte.audioStreamType >> 16 & 0xFF);
                int m = (byte)(paramArrayOfByte.audioStreamType >> 24 & 0xFF);
                this.Mmh.Mlr.setAppCmd(306, new byte[] { i, j, k, m }, 4);
              }
            }
            else
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, unknow chgtype:", Integer.valueOf(paramArrayOfByte.LGB), Long.valueOf(paramArrayOfByte.msgId) });
            }
          }
        }
      }
    }
  }
  
  public final int e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(213664);
    int j = -1;
    int i = j;
    if (this.vcO)
    {
      i = j;
      if (this.Mmh == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.Mmh;
        if ((paramArrayOfByte != null) && (localb.Mlr != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendScreen null, buffer:", paramArrayOfByte, ", engine:", localb.Mlr });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendScreen error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen finished, ", Boolean.valueOf(this.vcO), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.Mmh });
      i = paramInt1;
      AppMethodBeat.o(213664);
      return i;
      paramInt1 = localb.Mlr.SendScreen(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  final boolean enV()
  {
    AppMethodBeat.i(62765);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initEngine", this.ukT, Integer.valueOf(this.uRy), Long.valueOf(this.Clq), Integer.valueOf(this.state) });
    int i;
    label133:
    int j;
    try
    {
      localb = this.Mmh;
      boolean bool = com.tencent.pb.common.a.a.LER;
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
        i = localException.Mlr.field_capInfo.length;
      }
      AppMethodBeat.o(62765);
      return true;
    }
    if (i < 0)
    {
      h.aiv(-3001);
      this.Mmg.aiw(201);
      this.Mmh = null;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(62765);
      return false;
      str = com.tencent.pb.common.c.c.ClL.getDir("lib", 0).getAbsolutePath();
      locale = LFC;
      if (locale == null) {
        break label380;
      }
      j = locale.aaf();
      i = locale.dpk();
    }
    for (;;)
    {
      int k = k.ls(com.tencent.pb.common.c.c.ClL);
      com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(k), " cpuFlag:", Integer.valueOf(j), "libPath:", str });
      if (localb.Mlr == null)
      {
        i = -1;
        break;
      }
      j = localb.Mlr.init(i, k, j, str + "/");
      if (localb.Mlr.field_capInfo == null)
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
  
  public final boolean evW()
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
  
  final boolean fZE()
  {
    AppMethodBeat.i(62724);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = LFC;
    if (locale != null) {
      locale.dpj();
    }
    this.Mmh = new b();
    this.Mms = this.ukT;
    fZD();
    this.Mmi = new talk.a()
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
          f.this.Mmg.MnD = 1;
          localh = f.this.Mmg;
          if (localh.MnQ != 0L) {
            break label121;
          }
        }
        label121:
        for (localh.MnE = 0L;; localh.MnE = (System.currentTimeMillis() - localh.MnQ))
        {
          com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.MnQ), Long.valueOf(localh.MnE) });
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
        //   9: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   12: getfield 77	com/tencent/wecall/talkroom/model/f:Mmg	Lcom/tencent/wecall/talkroom/model/h;
        //   15: iconst_1
        //   16: putfield 124	com/tencent/wecall/talkroom/model/h:uMG	I
        //   19: ldc 59
        //   21: iconst_1
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 126
        //   29: aastore
        //   30: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   33: aload_0
        //   34: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
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
        //   58: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   61: invokestatic 128	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   64: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   67: aastore
        //   68: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   71: ldc 121
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aload_0
        //   78: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   81: astore 6
        //   83: invokestatic 136	com/tencent/wecall/talkroom/model/c:fZv	()Lcom/tencent/wecall/talkroom/model/c;
        //   86: astore 4
        //   88: aload_0
        //   89: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
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
        //   117: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   120: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   123: ifnull +30 -> 153
        //   126: aload_0
        //   127: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   130: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   133: astore 4
        //   135: invokestatic 156	com/tencent/wecall/talkroom/model/f:fZQ	()Z
        //   138: istore_3
        //   139: getstatic 162	com/tencent/pb/common/a/a:LER	Z
        //   142: ifeq +11 -> 153
        //   145: aload 4
        //   147: getfield 168	com/tencent/wecall/talkroom/model/b:Mlr	Lcom/tencent/mm/plugin/multi/talk;
        //   150: ifnonnull +431 -> 581
        //   153: aload_0
        //   154: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   157: invokestatic 171	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
        //   160: pop
        //   161: aload_0
        //   162: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   165: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   168: pop
        //   169: invokestatic 175	com/tencent/wecall/talkroom/model/f:fZR	()Lcom/tencent/pb/talkroom/sdk/e;
        //   172: astore 4
        //   174: aload 4
        //   176: ifnull +11 -> 187
        //   179: aload 4
        //   181: invokeinterface 181 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   191: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   194: getfield 168	com/tencent/wecall/talkroom/model/b:Mlr	Lcom/tencent/mm/plugin/multi/talk;
        //   197: astore 6
        //   199: getstatic 162	com/tencent/pb/common/a/a:LER	Z
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
        //   308: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   311: getfield 77	com/tencent/wecall/talkroom/model/f:Mmg	Lcom/tencent/wecall/talkroom/model/h;
        //   314: astore 4
        //   316: aload 4
        //   318: getfield 87	com/tencent/wecall/talkroom/model/h:MnQ	J
        //   321: lconst_0
        //   322: lcmp
        //   323: ifne +317 -> 640
        //   326: aload 4
        //   328: lconst_0
        //   329: putfield 209	com/tencent/wecall/talkroom/model/h:MnF	J
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
        //   348: getfield 209	com/tencent/wecall/talkroom/model/h:MnF	J
        //   351: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   354: aastore
        //   355: dup
        //   356: iconst_2
        //   357: aload 4
        //   359: getfield 87	com/tencent/wecall/talkroom/model/h:MnQ	J
        //   362: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   365: aastore
        //   366: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   369: aload_0
        //   370: getfield 22	com/tencent/wecall/talkroom/model/f$1:MmH	Lcom/tencent/wecall/talkroom/model/f;
        //   373: invokestatic 215	com/tencent/wecall/talkroom/model/f:f	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/g;
        //   376: astore 4
        //   378: new 217	com/tencent/wecall/talkroom/model/g$5
        //   381: dup
        //   382: aload 4
        //   384: invokespecial 220	com/tencent/wecall/talkroom/model/g$5:<init>	(Lcom/tencent/wecall/talkroom/model/g;)V
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
        //   442: invokevirtual 234	com/tencent/wecall/talkroom/model/c:aZZ	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
        //   445: astore 7
        //   447: aload 5
        //   449: astore 4
        //   451: aload 7
        //   453: ifnull -344 -> 109
        //   456: aload 7
        //   458: invokevirtual 240	com/tencent/wecall/talkroom/model/TalkRoom:fZm	()Ljava/util/List;
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
        //   587: getfield 168	com/tencent/wecall/talkroom/model/b:Mlr	Lcom/tencent/mm/plugin/multi/talk;
        //   590: sipush 401
        //   593: invokevirtual 277	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   596: pop
        //   597: goto -444 -> 153
        //   600: aload 4
        //   602: getfield 168	com/tencent/wecall/talkroom/model/b:Mlr	Lcom/tencent/mm/plugin/multi/talk;
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
        //   647: getfield 87	com/tencent/wecall/talkroom/model/h:MnQ	J
        //   650: lsub
        //   651: putfield 209	com/tencent/wecall/talkroom/model/h:MnF	J
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
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aYZ(f.this.Mms));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bam(localStringBuilder.toString());
        AppMethodBeat.o(62608);
      }
      
      public final void keep_OnReportEngineRecv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62606);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aYZ(f.this.Mms));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bak(localStringBuilder.toString());
        AppMethodBeat.o(62606);
      }
      
      public final void keep_OnReportEngineSend(String paramAnonymousString)
      {
        AppMethodBeat.i(62607);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aYZ(f.this.Mms));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bal(localStringBuilder.toString());
        AppMethodBeat.o(62607);
      }
      
      final class a
        implements Runnable
      {
        int MmJ;
        int MmK;
        int MmL;
        int MmM;
        int MmN;
        
        a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
          this.MmJ = paramInt1;
          this.MmL = paramInt2;
          this.MmM = paramInt3;
          this.MmN = paramInt4;
          this.MmK = paramInt5;
        }
        
        public final void run()
        {
          AppMethodBeat.i(62585);
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "keep_OnError handler" });
          h.aiv(this.MmM);
          f.this.Mmg.aiw(this.MmL);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.MmK) });
          f.this.a(f.b(f.this), f.g(f.this), f.h(f.this), this.MmN, true);
          f.f(f.this).m(this.MmJ, null);
          AppMethodBeat.o(62585);
        }
      }
    };
    AppMethodBeat.o(62724);
    return true;
  }
  
  public final void fZF()
  {
    AppMethodBeat.i(62726);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.MmE != null) {
        this.mHandler.removeCallbacks(this.MmE);
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
        if (paramMessage.ukT == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId is null" });
        }
        else
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handlerInviteTimeOut" });
          if ((paramMessage.ukT.equals(this.ukT)) && (paramMessage.uRy == this.uRy) && (paramMessage.Clq == this.Clq))
          {
            h.fZX();
            this.Mmg.aiw(501);
            b(paramMessage.ukT, paramMessage.uRy, paramMessage.Clq, 7);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId: ", paramMessage.ukT });
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
              if (com.tencent.pb.common.c.f.mJ(paramMessage.groupId, this.ukT))
              {
                String str1 = paramMessage.groupId;
                Object localObject1 = paramMessage.Mnb;
                a.bb localbb = paramMessage.Mnc;
                int i = paramMessage.LGa;
                int j = paramMessage.type;
                long l = paramMessage.Mnd;
                String str2 = paramMessage.Mne;
                boolean bool = paramMessage.Mnf;
                String str3 = paramMessage.Mng;
                this.Mmg.fZV();
                Object localObject2 = c.fZv();
                paramMessage = "";
                localObject2 = ((c)localObject2).aZZ(str1);
                if (localObject2 != null) {
                  if (((TalkRoom)localObject2).Mlp != null) {
                    break label618;
                  }
                }
                label618:
                for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).Mlp.name)
                {
                  localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.Mmh.fZs(), paramMessage, localbb, i, j, l, str2, bool, str3);
                  bool = com.tencent.pb.common.b.e.fSR().a((com.tencent.pb.common.b.d)localObject1);
                  this.Mmg.af(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
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
                  if (b(paramMessage.groupId, paramMessage.roomId, paramMessage.uLt, false))
                  {
                    a(paramMessage.groupId, paramMessage.roomId, paramMessage.uLt, paramMessage.LGa, paramMessage.vug, paramMessage.Mns);
                    continue;
                    com.tencent.pb.common.c.e.fTj();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void hd(String paramString, int paramInt)
  {
    AppMethodBeat.i(62776);
    if ((com.tencent.pb.common.c.f.equals("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (evW()) && ((this.vcO) || (this.MlN))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62776);
      return;
      switch (k.ls(com.tencent.pb.common.c.c.ClL))
      {
      }
      for (this.Mmq = false; (this.uRy == 0) || (this.Clq == 0L); this.Mmq = true)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(62776);
        return;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect", this.ukT, Integer.valueOf(this.uRy) });
      this.Mmg.fZV();
      paramString = new com.tencent.wecall.talkroom.a.h(this.ukT, this.uRy, this.Clq, c.fZv().bab(this.ukT), this.MlW);
      boolean bool = com.tencent.pb.common.b.e.fSR().a(paramString);
      this.Mmg.af(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62776);
      return;
      paramString = this.Mmh;
      paramInt = k.ls(com.tencent.pb.common.c.c.ClL);
      if ((!com.tencent.pb.common.a.a.LER) || (paramString.Mlr == null))
      {
        AppMethodBeat.o(62776);
        return;
      }
      paramString.Mlr.onNetworkChange(paramInt);
    }
  }
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(213665);
    if ((this.vcO) && (this.Mmh != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        b localb = this.Mmh;
        if ((paramArrayOfByte1 == null) || (localb.Mlr == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:screenTrans null, buf:", paramArrayOfByte1, ", engine:", localb.Mlr });
          paramInt4 = -1;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "screenTrans finished, ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.vcO), " engine: ", this.Mmh });
          AppMethodBeat.o(213665);
          return paramInt4;
        }
        paramInt4 = localb.Mlr.screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
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
    this.Mmo.onStateChanged(paramInt);
    AppMethodBeat.o(62728);
  }
  
  public final void zC(boolean paramBoolean)
  {
    AppMethodBeat.i(62725);
    this.Mmg.groupId = this.ukT;
    this.Mmg.LFV = this.MlP;
    if (com.tencent.pb.common.c.f.ea(this.Mmg.groupId)) {
      this.Mmg.groupId = "";
    }
    if (com.tencent.pb.common.c.f.ea(this.Mmg.LFV)) {
      this.Mmg.LFV = "";
    }
    this.Mmg.Cfu = 1;
    this.Mmg.roomId = this.uRy;
    this.Mmg.uLt = this.Clq;
    fZD();
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    enS();
    Zh();
    int j = -99999;
    int i = j;
    if (this.Mmh != null) {}
    try
    {
      this.Mmp = this.Mmh.fZu();
      i = this.Mmh.Close();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.Mmh == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        j = this.Mmh.uninitLive();
        this.Mmh = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.Mmg.fZS();
          if ((!TextUtils.isEmpty(this.Mmg.groupId)) || (!TextUtils.isEmpty(this.Mmg.LFV)))
          {
            h.baj(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.Mmg.reset();
          fZP();
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
  
  public final void zD(boolean paramBoolean)
  {
    AppMethodBeat.i(62766);
    try
    {
      PG();
      fZH();
      if (paramBoolean)
      {
        fZM();
        bjO();
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
    int LGa;
    String[] Mnb;
    a.bb Mnc;
    long Mnd;
    String Mne;
    boolean Mnf;
    String Mng;
    String groupId;
    int type;
    
    a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(62686);
      Mnh = new b("OK", 0);
      Mni = new b("NOT_AUTH", 1);
      Mnj = new b("NOT_BIND", 2);
      Mnk = new b("NOT_MATCH", 3);
      Mnl = new b("NO_NETWORK", 4);
      Mnm = new b("BUSY", 5);
      Mnn = new b("NOT_VALID_STATE", 6);
      Mno = new b("GROUP_NOT_VALID", 7);
      Mnp = new b("UNINIT_SERVICE_FAILED", 8);
      Mnq = new b("INIT_ENGINE_FAILED", 9);
      Mnr = new b[] { Mnh, Mni, Mnj, Mnk, Mnl, Mnm, Mnn, Mno, Mnp, Mnq };
      AppMethodBeat.o(62686);
    }
    
    private b() {}
  }
  
  final class c
  {
    int LGa;
    String Mns;
    String groupId;
    int roomId;
    long uLt;
    int vug;
    
    c() {}
  }
  
  final class d
  {
    long Clq;
    int uRy;
    String ukT;
  }
  
  final class e
  {
    String groupId;
    int roomId;
    long uLt;
    
    e() {}
  }
  
  public static abstract interface f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */