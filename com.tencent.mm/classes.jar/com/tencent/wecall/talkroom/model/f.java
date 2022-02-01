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
  public static List<Integer> MIC;
  private static int MII;
  public static String[] MJo;
  private static com.tencent.pb.talkroom.sdk.e McG;
  public long CCU;
  boolean Cqi;
  private com.tencent.f.a.a MHf;
  f MIB;
  private Map<String, e> MID;
  private final int MIE;
  private final int MIF;
  private final int MIG;
  private final int MIH;
  private boolean MIJ;
  private boolean MIK;
  private String MIL;
  public String MIM;
  private int MIN;
  private int MIO;
  private int MIP;
  private long MIQ;
  private boolean MIR;
  private int MIS;
  private int MIT;
  int MIU;
  int MIV;
  private int MIW;
  private int MIX;
  private int MIY;
  private int MIZ;
  public boolean MJA;
  private Runnable MJB;
  private com.tencent.pb.common.b.d MJC;
  private Runnable MJD;
  private int MJa;
  private int MJb;
  private int MJc;
  public h MJd;
  b MJe;
  private talk.a MJf;
  private TimerTask MJg;
  private TimerTask MJh;
  private Timer MJi;
  private TimerTask MJj;
  private Timer MJk;
  g MJl;
  private int MJm;
  private boolean MJn;
  public String MJp;
  HashSet<Long> MJq;
  public boolean MJr;
  public boolean MJs;
  public boolean MJt;
  private short[] MJu;
  private String[] MJv;
  private short[] MJw;
  private String[] MJx;
  private int MJy;
  public boolean MJz;
  int Mcu;
  Handler mHandler;
  boolean mIsMute;
  int state;
  public String uwq;
  public int vdk;
  boolean voZ;
  
  static
  {
    AppMethodBeat.i(62787);
    McG = null;
    MIC = new ArrayList();
    MII = 30000;
    MJo = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(62787);
  }
  
  public f()
  {
    AppMethodBeat.i(62723);
    this.MID = new HashMap();
    this.MIE = 1;
    this.MIF = 2;
    this.MIG = 3;
    this.MIH = 4;
    this.state = 0;
    this.Cqi = false;
    this.MIJ = false;
    this.MIK = false;
    this.voZ = false;
    this.MIN = 0;
    this.MIO = 0;
    this.MIP = 0;
    this.MIQ = 0L;
    this.MIR = true;
    this.MIS = 0;
    this.MIT = 0;
    this.MIU = 0;
    this.MIV = -1;
    this.MIW = -1;
    this.MIX = -1;
    this.MIY = -1;
    this.MIZ = -1;
    this.MJa = -1;
    this.MJb = -1;
    this.MJc = -1;
    this.MJd = h.MKx;
    this.MJi = new Timer("TalkRoomService_HelloTimer");
    this.MJk = new Timer("TalkRoomService_talkDurationTimer");
    this.MJl = new g();
    this.MJm = 0;
    this.MJn = false;
    this.MJp = null;
    this.MJq = new HashSet();
    this.MJr = false;
    this.MJs = true;
    this.MJt = true;
    this.MJu = null;
    this.MJv = null;
    this.MJw = null;
    this.MJx = null;
    this.MJy = 0;
    this.mIsMute = false;
    this.MJz = false;
    this.MJA = true;
    this.MJB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62550);
        if ((f.this.ezD()) && (f.s(f.this)))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
          h.ajc(-2003);
          f.this.MJd.ajf(401);
          f.this.bd(f.b(f.this), 3, 108);
        }
        AppMethodBeat.o(62550);
      }
    };
    this.MJC = null;
    this.MJD = new Runnable()
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
        if (!f.this.ezD())
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
              if (f.a(f.this, locale.uwq, locale.vdk, locale.CCU, f.aja(locale.MKZ)))
              {
                localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
              }
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.pb.common.b.e.fXr().a((com.tencent.pb.common.b.d)localObject1);
          AppMethodBeat.o(62587);
          return;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        AppMethodBeat.o(62587);
      }
    };
    com.tencent.pb.common.b.e.fXr().a(201, this);
    com.tencent.pb.common.b.e.fXr().a(202, this);
    com.tencent.pb.common.b.e.fXr().a(203, this);
    com.tencent.pb.common.b.e.fXr().a(204, this);
    com.tencent.pb.common.b.e.fXr().a(205, this);
    com.tencent.pb.common.b.e.fXr().a(206, this);
    com.tencent.pb.common.b.e.fXr().a(207, this);
    com.tencent.pb.common.b.e.fXr().a(208, this);
    com.tencent.pb.common.b.e.fXr().a(210, this);
    com.tencent.pb.common.b.e.fXr().a(209, this);
    com.tencent.pb.common.b.e.fXr().a(211, this);
    com.tencent.pb.common.b.e.fXr().a(212, this);
    com.tencent.pb.common.b.e.fXr().a(213, this);
    com.tencent.pb.common.b.e.fXr().a(214, this);
    com.tencent.pb.common.b.e.fXr().a(800, this);
    com.tencent.pb.common.b.e.fXr().a(801, this);
    Object localObject = c.gdW();
    g localg = this.MJl;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).MIt = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      gee();
      if (this.MHf == null) {
        this.MHf = ((com.tencent.f.a.a)com.tencent.f.f.bbx("EventCenter"));
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.MHf.a(this, MJo);
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
      String str = c.gdW().M(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.Cqi), " mTalkDuration: ", Integer.valueOf(this.MIN), " msgKey: ", str });
      AppMethodBeat.o(62772);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(62772);
    }
  }
  
  private boolean PF()
  {
    AppMethodBeat.i(62739);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = McG;
      if (locale == null) {
        break label99;
      }
      this.MJd.Cxc = locale.dsA();
      this.MJd.CwY = locale.dsB();
      bool = locale.dsy();
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
  
  private void Zq()
  {
    AppMethodBeat.i(62727);
    this.MID.remove(this.uwq);
    this.MJm = 0;
    this.mIsMute = false;
    setState(0);
    this.MIK = false;
    a(this.MIM, 0, 0L, null, null);
    this.MIM = null;
    this.Mcu = 0;
    this.MIN = 0;
    this.MIO = 0;
    this.MIP = 0;
    this.MIR = true;
    this.MJs = true;
    this.MIQ = 0L;
    this.MIS = 0;
    this.MIJ = false;
    this.MJz = false;
    this.MJA = true;
    geg();
    this.mHandler.removeMessages(1);
    if (this.MJe != null) {
      this.MJe.gdU();
    }
    gel();
    gek();
    gem();
    gep();
    this.voZ = false;
    this.MJr = false;
    this.MIT = 0;
    AppMethodBeat.o(62727);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    AppMethodBeat.i(62747);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.roomId, paramh.uXg, false)) {
        this.MJd.af(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62747);
      return;
    }
    paramObject = (a.al)paramObject;
    if (!b(paramObject.groupId, paramObject.Cuf, paramObject.Cug, false))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.Cuf), Integer.valueOf(this.vdk) });
      AppMethodBeat.o(62747);
      return;
    }
    this.MJd.af(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.Mcu, paramObject.Cuf, paramObject.Cug, paramObject.Met, paramObject.Mev, paramObject.Mdb, false, false);
    a(paramObject.Meu, paramObject.MeB, paramObject.MeC);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect type:", Integer.valueOf(this.MIT) });
    if (this.MIT == 0)
    {
      paramh = new byte[paramObject.Mex.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.Mex.length)
      {
        paramh[paramInt1] = ((byte)paramObject.Mex[paramInt1]);
        paramInt1 += 1;
      }
      localObject1 = new int[paramObject.MeG.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.MeG.length)
      {
        localObject1[paramInt1] = paramObject.MeG[paramInt1];
        paramInt1 += 1;
      }
      if (this.MJe != null)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.MJe.Close()) });
        localObject2 = paramObject.Met;
        localObject3 = paramObject.MdI;
        if ((paramObject.Mew & 0x2) == 0) {
          break label547;
        }
      }
      label547:
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ay[])localObject2, (a.av)localObject3, paramh, bool, paramObject.groupId, paramObject.Cuf, paramObject.Cug, paramObject.MeD, paramObject.MeE, paramObject.MeF, (int[])localObject1, paramObject.MdK, this.MIU);
        AppMethodBeat.o(62747);
        return;
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp engine close but nullptr" });
        AppMethodBeat.o(62747);
        return;
      }
    }
    paramInt1 = k.ly(com.tencent.pb.common.c.c.CDp);
    com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "amyfwang,Redirect::netType:", Integer.valueOf(paramInt1) });
    paramObject = this.MJe;
    paramh = this.MJv;
    Object localObject1 = this.MJu;
    Object localObject2 = this.MJx;
    Object localObject3 = this.MJw;
    if (paramObject.MIo != null) {
      paramObject.MIo.Redirect(paramh, (short[])localObject1, (String[])localObject2, (short[])localObject3, paramInt1);
    }
    AppMethodBeat.o(62747);
  }
  
  private void a(int paramInt, a.ab paramab, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(208343);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.uwq, Integer.valueOf(parame.vdk), Long.valueOf(parame.CCU), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111), Integer.valueOf(14287), Integer.valueOf(-1112) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.ajb(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramab.groupId, Integer.valueOf(paramab.Cuf), Long.valueOf(paramab.Cug) });
      this.MJl.m(-14255, paramab);
      AppMethodBeat.o(208343);
      return;
    }
    if (paramInt == 14287)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14287), paramab.groupId, Integer.valueOf(paramab.Cuf), Long.valueOf(paramab.Cug) });
      this.MJl.m(-14287, paramab);
      AppMethodBeat.o(208343);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramab.groupId, Integer.valueOf(paramab.Cuf), Long.valueOf(paramab.Cug) });
      this.MJl.m(-14256, paramab);
      AppMethodBeat.o(208343);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.uwq, parame.vdk, parame.CCU, aiZ(parame.MKZ)))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.uwq, " mGroupId: ", this.uwq, Integer.valueOf(parame.vdk), Integer.valueOf(this.vdk), Long.valueOf(parame.CCU), Long.valueOf(this.CCU) });
        AppMethodBeat.o(208343);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.uwq, Integer.valueOf(parame.vdk), Long.valueOf(parame.CCU) });
        AppMethodBeat.o(208343);
        return;
      }
      this.MJd.af(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.MJd.ajf(322);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.uwq, Integer.valueOf(parame.vdk), Long.valueOf(parame.CCU) });
      a(parame.uwq, parame.vdk, parame.CCU, true);
      if (paramInt == 14251)
      {
        this.MJl.m(-1000, null);
        AppMethodBeat.o(208343);
        return;
      }
      if (paramInt == 14252)
      {
        this.MJl.m(-1200, null);
        AppMethodBeat.o(208343);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramab != null) {
          parame = Integer.valueOf(paramab.Mez);
        }
        this.MJl.m(-1500, parame);
        AppMethodBeat.o(208343);
        return;
      }
      this.MJl.m(-200, null);
      AppMethodBeat.o(208343);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramab.groupId, Integer.valueOf(paramab.Cuf), Long.valueOf(paramab.Cug) });
      AppMethodBeat.o(208343);
      return;
    }
    if (!b(paramab.groupId, paramab.Cuf, paramab.Cug, aiZ(paramab.vGk)))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramab.groupId, " mGroupId: ", this.uwq, Integer.valueOf(paramab.Cuf), Integer.valueOf(this.vdk), Long.valueOf(paramab.Cug), Long.valueOf(this.CCU) });
      a(paramab.groupId, paramab.Cuf, paramab.Cug, 111, false);
      h.ajb(-1110);
      AppMethodBeat.o(208343);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramab.groupId, Integer.valueOf(paramab.Cuf), Long.valueOf(paramab.Cug) });
      AppMethodBeat.o(208343);
      return;
    }
    this.MJd.af(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramab.Meu == null) || (paramab.Meu.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramab.groupId, Integer.valueOf(paramab.Cuf), Long.valueOf(paramab.Cug) });
      h.ajb(-1605);
      this.MJd.CMo = 329;
      a(paramab.groupId, paramab.Cuf, paramab.Cug, 116, true);
      this.MJl.m(-200, null);
      AppMethodBeat.o(208343);
      return;
    }
    this.uwq = paramab.groupId;
    this.MJp = paramab.groupId;
    this.vdk = paramab.Cuf;
    this.CCU = paramab.Cug;
    setState(4);
    a(paramab.Meu, paramab.MeB, paramab.MeC);
    a(paramab.groupId, null, this.Mcu, paramab.Cuf, paramab.Cug, paramab.Met, paramab.Mev, paramab.Mdb, false, true);
    parame = this.MJl;
    localObject = new g.9(parame, c.gdW().bbJ(paramab.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramab.Mex.length];
      paramInt = 0;
      while (paramInt < paramab.Mex.length)
      {
        parame[paramInt] = ((byte)paramab.Mex[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramab.MeG.length];
    paramInt = 0;
    while (paramInt < paramab.MeG.length)
    {
      localObject[paramInt] = paramab.MeG[paramInt];
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(paramab.MeG.length), " redirect type:", Integer.valueOf(localObject[talk.wlX]), " SimpleRedirect value:", Integer.valueOf(talk.wlX) });
    a.ay[] arrayOfay = paramab.Met;
    a.av localav = paramab.MdI;
    if ((paramab.Mew & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfay, localav, parame, bool, paramab.groupId, paramab.Cuf, paramab.Cug, paramab.MeD, paramab.MeE, paramab.MeF, (int[])localObject, paramab.MdK, this.MIU);
      if (paramab.MeA != 0)
      {
        com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramab.MeA });
        MII = paramab.MeA * 1000;
      }
      gej();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU) });
      AppMethodBeat.o(208343);
      return;
    }
  }
  
  private void a(int paramInt, a.aj paramaj)
  {
    AppMethodBeat.i(208342);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.MJl.jb(null);
      AppMethodBeat.o(208342);
      return;
    }
    paramaj = paramaj.MeQ;
    if ((paramaj == null) || (paramaj.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(208342);
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
        a(localObject.groupId, null, 0, localObject.Cuf, localObject.Cug, localObject.Met, null, null, false, false);
        localArrayList.add(c.gdW().bbJ(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.MJl.jb(localArrayList);
    AppMethodBeat.o(208342);
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
    //   62: getfield 464	com/tencent/wecall/talkroom/model/f:MJe	Lcom/tencent/wecall/talkroom/model/b;
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
    //   166: getfield 238	com/tencent/wecall/talkroom/model/f:MJd	Lcom/tencent/wecall/talkroom/model/h;
    //   169: sipush 202
    //   172: invokevirtual 693	com/tencent/wecall/talkroom/model/h:ajf	(I)V
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
    //   206: getfield 256	com/tencent/wecall/talkroom/model/f:MJl	Lcom/tencent/wecall/talkroom/model/g;
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
    McG = parame;
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
    if (!aiZ(paramInt3)) {
      this.MJd.gey();
    }
    this.MJd.gex();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.MJe.gdT(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.fXr().a(paramString1);
    c(paramString1);
    AppMethodBeat.o(62731);
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.vdk = paramInt;
    this.CCU = paramLong;
    this.uwq = paramString2;
    this.MIM = paramString1;
    this.MIL = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62754);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(62754);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(208346);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(208346);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfay.length;
    int i = 0;
    while (i < j)
    {
      a.ay localay = paramArrayOfay[i];
      if (localay != null) {
        localStringBuffer.append(" memberId:" + localay.pcE + " uuid: " + localay.duC + " status: " + localay.status + "   mem.inviteTime:" + localay.MfN + "  mem.reason: " + localay.reason + "  mem.inviteuuid: " + localay.MfZ + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfay.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(208346);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz, a.aw paramaw, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208344);
    a(paramString1, paramInt2, paramLong, paramArrayOfay);
    c localc = c.gdW();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.uwq == null) || (!this.uwq.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramaw, paramArrayOfay, paramArrayOfaz, paramBoolean1, bool);
      paramString2 = this.uwq;
      i = this.vdk;
      l = this.CCU;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfay == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfay.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.MIR) });
      if (c.gdW().dl(this.uwq, false))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.MIR), " mGroupId: ", this.uwq, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.MIR)
        {
          this.MIR = false;
          this.voZ = true;
          this.MJn = k.geC();
          this.MIP = this.MIN;
          geo();
        }
      }
      if (paramArrayOfay != null) {
        break label380;
      }
      AppMethodBeat.o(208344);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfay.length > 0) && (this.MJe != null)) {
      a(paramArrayOfay);
    }
    AppMethodBeat.o(208344);
  }
  
  private void a(a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(208345);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(208345);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfay.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfay.length)
    {
      arrayOfInt[i] = paramArrayOfay[i].pcE;
      localStringBuffer.append(paramArrayOfay[i].pcE);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.MJe == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(208345);
      return;
    }
    this.MJe.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(208345);
  }
  
  private void a(a.p[] paramArrayOfp1, a.p[] paramArrayOfp2, int paramInt)
  {
    AppMethodBeat.i(208347);
    if (paramArrayOfp1 == null) {}
    for (int i = 0;; i = paramArrayOfp1.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfp1 != null) && (paramArrayOfp1.length > 0)) {
        break;
      }
      AppMethodBeat.o(208347);
      return;
    }
    this.MJv = new String[paramArrayOfp1.length];
    this.MJu = new short[paramArrayOfp1.length];
    this.MJx = new String[paramArrayOfp2.length];
    this.MJw = new short[paramArrayOfp2.length];
    this.MJy = paramInt;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.MJy) });
    int j = paramArrayOfp1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.p localp = paramArrayOfp1[paramInt];
      this.MJv[i] = localp.MdE;
      this.MJu[i] = ((short)localp.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData ip: ", localp.MdE, " addr.port: ", Integer.valueOf(localp.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfp2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfp1 = paramArrayOfp2[paramInt];
      this.MJx[i] = paramArrayOfp1.MdE;
      this.MJw[i] = ((short)paramArrayOfp1.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", paramArrayOfp1.MdE, " tcpAddr.port: ", Integer.valueOf(paramArrayOfp1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.MJv), Arrays.toString(this.MJu), this.uwq, this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU), Arrays.toString(this.MJx), Arrays.toString(this.MJw), Integer.valueOf(this.MJy) });
    AppMethodBeat.o(208347);
  }
  
  private boolean a(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208349);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(208349);
      return false;
    }
    this.MIT = paramArrayOfInt[talk.wlX];
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit general policy cnt:", Integer.valueOf(paramArrayOfInt.length), ", redirect type:", this.MIT + " wifigateway:" + paramInt5 });
    paramBoolean = b(paramArrayOfay, paramav, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
    AppMethodBeat.o(208349);
    return paramBoolean;
  }
  
  private static boolean aiZ(int paramInt)
  {
    return paramInt != 1;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(62738);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = McG;
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
      com.tencent.pb.talkroom.sdk.e locale = McG;
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
      paramBoolean = com.tencent.pb.common.c.f.mP(paramString, this.uwq);
      AppMethodBeat.o(62771);
      return paramBoolean;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.uwq, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.vdk), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.CCU) });
    if ((com.tencent.pb.common.c.f.mP(paramString, this.uwq)) && (paramInt == this.vdk) && (paramLong == this.CCU))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    AppMethodBeat.o(62771);
    return false;
  }
  
  private boolean b(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208350);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.uwq, " ip: ", Arrays.toString(this.MJv), " ports: ", Arrays.toString(this.MJu), " tcpIp: ", Arrays.toString(this.MJx), " tcpPorts: ", Arrays.toString(this.MJw), " tcpStartTime: ", Integer.valueOf(this.MJy), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.fXK();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfay != null) && (paramArrayOfay.length > 0))
    {
      localObject1 = new int[paramArrayOfay.length];
      j = 0;
      while (j < paramArrayOfay.length)
      {
        localObject1[j] = paramArrayOfay[j].pcE;
        if (com.tencent.pb.common.c.f.equals(paramArrayOfay[j].duC, (String)localObject2)) {
          i = paramArrayOfay[j].pcE;
        }
        j += 1;
      }
      paramArrayOfay = (a.ay[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.gdW().bbE(this.uwq);
      this.MJd.pcE = j;
      for (;;)
      {
        try
        {
          localObject2 = this.MJe;
          locala = this.MJf;
          localObject3 = c.gdW();
          localObject1 = this.uwq;
          localObject3 = ((c)localObject3).bbC((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.MJv;
          arrayOfShort1 = this.MJu;
          arrayOfString = this.MJx;
          arrayOfShort2 = this.MJw;
          m = this.MJy;
          localObject1 = null;
          if (paramav == null) {
            continue;
          }
          paramav = new i(paramav.Mff, paramav.hYc, paramav.hYd, paramav.Mfg, paramav.Mfh, paramav.Mfi, paramav.Mfj, paramav.Mfk, paramav.Mfl, paramav.Mfm, paramav.Mfn, paramav.Mfo);
          n = k.ly(com.tencent.pb.common.c.c.CDp);
          localObject1 = ((b)localObject2).MIo;
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
          paramInt1 = ((b)localObject2).MIo.Open(locala, paramav, i, j, paramInt1, paramLong, (String[])localObject3, arrayOfShort1, 0, paramArrayOfay, paramArrayOfByte1, paramBoolean, n, arrayOfString, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
          continue;
          paramArrayOfay.handler.post(paramav);
          continue;
          AppMethodBeat.o(208350);
          return false;
        }
        paramArrayOfay = this.MJl;
        paramav = new g.4(paramArrayOfay, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramav.run();
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.aje(-3002);
        }
        if (paramInt1 == 0) {
          this.MJd.CMr = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(208350);
        return true;
        localObject3 = ((TalkRoom)localObject3).bbB(com.tencent.pb.a.a.a.fXK());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).MIu;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.ay)localObject3).FHN) });
            i = ((a.ay)localObject3).FHN;
            continue;
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramav = (a.av)localObject1;
          }
        }
      }
      paramArrayOfay = null;
    }
  }
  
  private void bkx()
  {
    AppMethodBeat.i(62767);
    PF();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c()
    {
      public final void af(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            if ((com.tencent.pb.common.a.a.MbV) && (localb.MIo != null)) {
              break label140;
            }
          }
          for (;;)
          {
            if (f.this.MJs)
            {
              f.this.MJs = false;
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt) });
            }
            AppMethodBeat.o(62659);
            return;
            label140:
            localb.MIo.SendAudio(paramAnonymousArrayOfByte, s, 0);
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
      this.MJd.ajf(101);
      h.ajc(-2001);
      this.MJl.m(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.MJd;
    }
    for (localh.MKy &= 0xFFFFFFFE;; localh.MKy |= 0x1)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62767);
      return;
      localh = this.MJd;
    }
  }
  
  private void c(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62775);
    this.mHandler.removeCallbacks(this.MJD);
    this.MJC = paramd;
    this.mHandler.postDelayed(this.MJD, 3000L);
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
    if (aiZ(paramInt))
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
      boolean bool = bbL(paramString);
      AppMethodBeat.o(62732);
      return bool;
    }
    AppMethodBeat.o(62732);
    return false;
  }
  
  private void erz()
  {
    AppMethodBeat.i(62741);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "releaseConpent" });
    try
    {
      PF();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          gei();
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
  
  private void gee()
  {
    AppMethodBeat.i(208337);
    this.MIW = -1;
    this.MIX = -1;
    this.MIY = -1;
    this.MIZ = -1;
    this.MJa = -1;
    this.MJb = -1;
    this.MJc = -1;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "multitalk voiceMsg local seq reset" });
    AppMethodBeat.o(208337);
  }
  
  private int geh()
  {
    AppMethodBeat.i(62734);
    if (this.MIQ == 0L)
    {
      AppMethodBeat.o(62734);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.MIQ) / 1000L);
    AppMethodBeat.o(62734);
    return i;
  }
  
  private boolean gei()
  {
    AppMethodBeat.i(62737);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = McG;
      if (locale == null) {
        break label99;
      }
      this.MJd.Cxk = locale.dsz();
      this.MJd.CwZ = locale.dsC();
      bool = locale.dsx();
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
  
  private void gej()
  {
    AppMethodBeat.i(62759);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.MJg != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(62759);
      return;
    }
    try
    {
      this.MJg = new TimerTask()
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
      this.MJi.schedule(this.MJg, 0L, MII);
      AppMethodBeat.o(62759);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(62759);
    }
  }
  
  private void gek()
  {
    AppMethodBeat.i(62760);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.MJh != null) {
        this.MJh.cancel();
      }
      this.MJh = null;
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
  
  private void gel()
  {
    AppMethodBeat.i(62761);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.MJg != null) {
        this.MJg.cancel();
      }
      this.MJg = null;
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
  
  private void gem()
  {
    AppMethodBeat.i(62762);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.MJj != null) {
        this.MJj.cancel();
      }
      this.MJj = null;
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
  
  private void gen()
  {
    AppMethodBeat.i(62768);
    gei();
    Object localObject = new AtomicInteger();
    final AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b()
    {
      public final int ae(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            AtomicInteger localAtomicInteger1 = this.MJW;
            AtomicInteger localAtomicInteger2 = localAtomicInteger;
            if (com.tencent.pb.common.a.a.MbV) {
              if (localb.MIo == null)
              {
                break label169;
                if ((f.this.MJt) && (i >= 0))
                {
                  f.this.MJt = false;
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt), " ret: ", Integer.valueOf(i) });
                }
                AppMethodBeat.o(62788);
                return i;
              }
              else
              {
                i = localb.MIo.GetAudioData(paramAnonymousArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
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
      this.MJd.ajf(101);
      h.ajc(-2001);
      localObject = this.MJd;
      ((h)localObject).MKy |= 0x1;
      this.MJl.m(-500, null);
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62768);
  }
  
  private void geo()
  {
    AppMethodBeat.i(62769);
    if (this.MJj != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(62769);
      return;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.MIB, " mIsHoldOn: ", Boolean.valueOf(this.MJz) });
    this.MJj = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(62661);
        if (!f.this.MJz)
        {
          f.a(f.this, f.n(f.this) + 1);
          if (f.o(f.this)) {
            f.b(f.this, f.p(f.this) + 1);
          }
          if ((f.q(f.this) == 3) || (f.q(f.this) == 2))
          {
            f.c(f.this, f.r(f.this) + 1);
            f.this.MJd.CMC = f.r(f.this);
          }
          f.this.MJd.MKC = (f.n(f.this) * 1000);
          f.this.MJd.CMB = f.n(f.this);
        }
        if (f.this.MIB != null) {
          f.n(f.this);
        }
        AppMethodBeat.o(62661);
      }
    };
    this.MJk.scheduleAtFixedRate(this.MJj, 1000L, 1000L);
    AppMethodBeat.o(62769);
  }
  
  private void gep()
  {
    AppMethodBeat.i(62774);
    this.mHandler.removeCallbacks(this.MJD);
    this.MJC = null;
    AppMethodBeat.o(62774);
  }
  
  private static void geq()
  {
    AppMethodBeat.i(62777);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.c.CDp.getSystemService("audio");
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
  
  public static boolean ger()
  {
    AppMethodBeat.i(62778);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.c.CDp.getSystemService("audio")).isSpeakerphoneOn();
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
  
  public static com.tencent.pb.talkroom.sdk.e ges()
  {
    return McG;
  }
  
  private boolean hp(String paramString, int paramInt)
  {
    AppMethodBeat.i(62735);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62735);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.Mcu);
    boolean bool = com.tencent.pb.common.b.e.fXr().a(localc);
    this.MJd.af(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.vdk, this.CCU, true);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62735);
    return bool;
  }
  
  static String[] jc(List<String> paramList)
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
  
  public final com.tencent.pb.talkroom.sdk.f K(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62745);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.voZ)
    {
      localObject = localf;
      if (this.MJe == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo" });
        localb = this.MJe;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfInt != null) && (localb.MIo != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", localb.MIo });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.voZ), " decInfo: ", paramArrayOfInt, " engine: ", this.MJe });
      localObject = paramArrayOfInt;
      AppMethodBeat.o(62745);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.MIo.videoDecode(paramArrayOfInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgL = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgM = localb.MIo.field_remoteImgLength;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgN = localb.MIo.field_remoteImgWidth;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgO = localb.MIo.field_remoteImgHeight;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgP = (localb.MIo.field_remoteImgChannel & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgQ = 0;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgJ = c.gdW().hn(a.gdH().uwq, ((com.tencent.pb.talkroom.sdk.f)localObject).MgP);
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
    AppMethodBeat.i(208341);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.voZ)
    {
      localObject = localf;
      if (this.MJe == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen" });
        localb = this.MJe;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfByte != null) && (paramArrayOfInt != null) && (localb.MIo != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveScreen null, imgBuffer32:", paramArrayOfInt, ", engine:", localb.MIo });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen finished, ", Boolean.valueOf(this.voZ), " decInfo: ", paramArrayOfByte, " engine: ", this.MJe });
      localObject = paramArrayOfByte;
      AppMethodBeat.o(208341);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.MIo.screenDecode(paramArrayOfByte, paramArrayOfInt, paramInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgR = paramArrayOfByte;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgL = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgM = localb.MIo.field_remoteImgLength_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgN = localb.MIo.field_remoteImgWidth_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgO = localb.MIo.field_remoteImgHeight_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgP = (localb.MIo.field_remoteImgChannel_screen & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgQ = localb.MIo.field_remoteImgOrien_screen;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen channel:", Integer.valueOf(localb.MIo.field_remoteImgChannel_screen) });
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen field_remoteImgOrien:", Integer.valueOf(localb.MIo.field_remoteImgOrien_screen) });
      ((com.tencent.pb.talkroom.sdk.f)localObject).MgJ = c.gdW().hn(a.gdH().uwq, ((com.tencent.pb.talkroom.sdk.f)localObject).MgP);
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
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.vdk), Integer.valueOf(paramInt1), Long.valueOf(this.CCU), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    this.MIU = paramInt4;
    if (!com.tencent.pb.a.a.a.fXL())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.fXL()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.fXM()) });
      h.a(paramString1, "", this.vdk, this.CCU, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = b.MKf;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((aiZ(paramInt3)) && (paramInt3 != 100) && (ezD()))
    {
      h.a(paramString1, "", this.vdk, this.CCU, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = b.MKj;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (!db(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.vdk, this.CCU, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = b.MKk;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.vdk, this.CCU, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = b.MKl;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (aiZ(paramInt3))
    {
      this.MJd.reset();
      zQ(false);
    }
    gef();
    if (!erC())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (aiZ(paramInt3))
      {
        h.a(paramString1, "", this.vdk, this.CCU, new String[] { "enter", "req", "false", "initEnginefail" });
        zQ(false);
      }
      for (;;)
      {
        paramString1 = b.MKn;
        AppMethodBeat.o(183718);
        return paramString1;
        this.MJd.af(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.uwq = paramString1;
    Object localObject;
    long l;
    label705:
    label711:
    boolean bool;
    if (!aiZ(paramInt3))
    {
      localObject = bbK(paramString1);
      if (localObject == null)
      {
        paramInt4 = 0;
        this.vdk = paramInt4;
        if (localObject != null) {
          break label875;
        }
        l = 0L;
        this.CCU = l;
        this.MJp = paramString1;
        this.Mcu = paramInt2;
        setState(3);
        if (!aiZ(paramInt3)) {
          break label898;
        }
        bool = true;
        label738:
        this.Cqi = bool;
        if (this.Cqi) {
          this.MJd.gev();
        }
        if ((!this.Cqi) || (c.gdW().dl(this.uwq, true))) {
          break label904;
        }
        localObject = new c();
        ((c)localObject).groupId = paramString1;
        ((c)localObject).roomId = paramInt1;
        ((c)localObject).uXg = paramLong;
        ((c)localObject).vGk = paramInt3;
        ((c)localObject).Mde = paramInt2;
        ((c)localObject).MKp = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = localObject;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = b.MKe;
      AppMethodBeat.o(183718);
      return paramString1;
      paramInt4 = ((e)localObject).roomId;
      break;
      label875:
      l = ((e)localObject).uXg;
      break label705;
      this.vdk = paramInt1;
      this.CCU = paramLong;
      break label711;
      label898:
      bool = false;
      break label738;
      label904:
      a(paramString1, this.vdk, this.CCU, paramInt2, paramInt3, paramString2);
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
        paramString = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542) });
        i = paramd.getType();
        if (paramString.containsKey(Integer.valueOf(i))) {
          h.ajb(((Integer)paramString.get(Integer.valueOf(i))).intValue());
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
          if (com.tencent.pb.common.c.f.mP(this.MIM, paramString.MIM))
          {
            this.MJd.ajf(301);
            this.MJd.af(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            hp(paramString.MIM, 1001);
            if (!paramString.MKY) {
              this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.MJl.m(-100, null);
          }
          AppMethodBeat.o(62742);
          return;
          paramString = "";
        }
        else if (paramd.getType() == 209)
        {
          paramString = (com.tencent.wecall.talkroom.a.g)paramd;
          this.MJl.ho(paramString.uwq, paramInt2);
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
      if (!b(paramString.uwq, paramString.vdk, paramString.CCU, false)) {
        h.a(paramString.uwq, paramString.vdk, paramString.CCU, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.MJl.a(paramString.MKX, c.gdW().bbJ(paramString.uwq));
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.uwq, paramString.vdk, paramString.CCU, false))
      {
        this.MJd.af(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.MJl.m(-300, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.uwq, paramString.vdk, paramString.CCU, aiZ(paramString.MKZ))) && (this.state == 3))
      {
        this.MJd.ajf(302);
        this.MJl.m(-200, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.MJl.jb(null);
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 213)
    {
      if (com.tencent.pb.common.c.f.equals(((com.tencent.wecall.talkroom.a.j)paramd).uwq, this.uwq))
      {
        this.MJd.af(new String[] { "sendmsg", "resp", "-1", String.valueOf(this.state) });
        this.MJl.m(-700, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (b(paramString.groupId, paramString.roomId, paramString.uXg, false)) {
        this.MJd.af(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (m)paramd;
      if (b(paramString.uwq, paramString.vdk, paramString.CCU, false)) {
        this.MJl.m(-800, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      if (b(paramString.uwq, paramString.vdk, paramString.CCU, false)) {
        this.MJl.m(-1600, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 801)
    {
      paramString = (com.tencent.wecall.talkroom.a.k)paramd;
      if (b(paramString.uwq, paramString.vdk, paramString.CCU, false)) {
        this.MJl.m(-1601, null);
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
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).Mcs != null))
      {
        paramString = (a.aa)((com.tencent.pb.common.b.d)localObject1).Mcs;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).MIM });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).MKY) {
          break label3210;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.ajb(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          MIC = null;
          if (paramInt2 == 0) {
            break label3477;
          }
          if (com.tencent.pb.common.c.f.mP(this.MIM, ((com.tencent.wecall.talkroom.a.d)localObject1).MIM)) {
            break label3216;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.MIM, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).MIM, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1459:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.Mcs != null)) {
        a(paramInt2, (a.ab)paramString.Mcs, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.Mcs != null))
      {
        localObject1 = (a.y)paramString.Mcs;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303), Integer.valueOf(14651), Integer.valueOf(-1309) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.ajb(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label4486;
        }
        if (b(paramString.uwq, paramString.vdk, paramString.CCU, false))
        {
          this.MJd.af(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (paramInt2 != 14651) {
            break label4472;
          }
          com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14651), ((a.y)localObject1).groupId, Integer.valueOf(((a.y)localObject1).Cuf), Long.valueOf(((a.y)localObject1).Cug) });
          this.MJl.m(-301, localObject1);
        }
      }
    }
    label1850:
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.Mcs != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ac)paramString.Mcs).groupId, this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.ajb(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (n)paramd;
      if ((paramString != null) && (paramString.Mcs != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.am)paramString.Mcs).groupId, this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        gek();
        i = 0;
        if (paramInt2 != 14800) {
          break label4703;
        }
        i = -1401;
        label2210:
        if (i != 0)
        {
          this.MJd.ajf(324);
          h.ajb(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.Mcs != null))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.uwq, " roomid: ", Integer.valueOf(paramString.vdk), " roomKey: ", Long.valueOf(paramString.CCU) });
        if (paramInt2 != 18950) {
          break label4718;
        }
        if (!b(paramString.uwq, paramString.vdk, paramString.CCU, false)) {
          h.a(paramString.uwq, paramString.vdk, paramString.CCU, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.gdW().bbJ(paramString.uwq);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.uwq, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.MJl.a(paramString.MKX, (MultiTalkGroup)localObject1);
        }
      }
    }
    label2468:
    if (paramd.getType() == 207)
    {
      paramString = (com.tencent.wecall.talkroom.a.i)paramd;
      if ((paramString != null) && (paramString.Mcs != null))
      {
        if (paramInt2 == 18100) {
          h.ajb(-1501);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 208)
    {
      paramString = (com.tencent.wecall.talkroom.a.c)paramd;
      if ((paramString != null) && (paramString.Mcs != null))
      {
        if (paramInt2 == 18300) {
          h.ajb(-1531);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 209)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).Mcs != null))
      {
        paramString = (a.ad)((com.tencent.pb.common.b.d)localObject1).Mcs;
        if (paramInt2 == 17900) {
          h.ajb(-1511);
        }
        if (paramInt2 == 0) {
          break label5124;
        }
        this.MJl.ho(((com.tencent.wecall.talkroom.a.g)localObject1).uwq, paramInt2);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 210)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 == 19100) {
        h.ajb(-1541);
      }
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (paramString != null) {
        a(paramInt1, paramInt2, paramd.Mcs, paramString);
      }
    }
    if (paramd.getType() == 212) {
      a(paramInt2, (a.aj)paramd.Mcs);
    }
    if (paramd.getType() == 213)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break label5223;
      }
      if (com.tencent.pb.common.c.f.equals(paramString.uwq, this.uwq))
      {
        this.MJd.af(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.MJl.m(-700, null);
      }
    }
    label2909:
    if (paramd.getType() == 214)
    {
      paramString = (a.ah)paramd.Mcs;
      localObject1 = (m)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (!b(((m)localObject1).uwq, ((m)localObject1).vdk, ((m)localObject1).CCU, false)) {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((m)localObject1).uwq, Integer.valueOf(((m)localObject1).vdk) });
      }
    }
    else if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
      if (b(paramString.uwq, paramString.vdk, paramString.CCU, false)) {
        break label5687;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.uwq, Integer.valueOf(paramString.vdk) });
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
        if (!b(paramString.uwq, paramString.vdk, paramString.CCU, false))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo isCurrentRoom is not same", paramString.uwq, Integer.valueOf(paramString.vdk) });
          AppMethodBeat.o(62742);
          return;
          i = 0;
          break;
          if (paramInt2 != -1)
          {
            this.MJd.ajf(321);
            this.MJd.af(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          if (this.state != 1)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).MIM });
            if (i == 0) {
              break label1459;
            }
            this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          a(this.uwq, this.vdk, this.CCU, true);
          if (paramInt2 == 14051) {
            this.MJl.m(-900, null);
          }
          for (;;)
          {
            if (i == 0) {
              break label3475;
            }
            this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break;
            if (paramInt2 == 14052) {
              this.MJl.m(-1100, null);
            } else if (paramInt2 == 14053) {
              this.MJl.m(-1300, paramString);
            } else if (paramInt2 == 14504) {
              this.MJl.m(-1400, null);
            } else {
              this.MJl.m(-100, null);
            }
          }
          break label1459;
          if (!com.tencent.pb.common.c.f.mP(this.MIM, paramString.McZ))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.MIM, " resp.clientGroupId: ", paramString.McZ, Integer.valueOf(paramString.Cuf), Long.valueOf(paramString.Cug) });
            a(paramString.groupId, paramString.Cuf, paramString.Cug, 110, false);
            if (i == 0) {
              break label1459;
            }
            this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          this.MJd.af(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (this.state != 1)
          {
            h.ajb(-1003);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.McZ, Integer.valueOf(paramString.Cuf), Long.valueOf(paramString.Cug) });
            if (i == 0) {
              break label1459;
            }
            this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          if ((paramString.Meu == null) || (paramString.Meu.length == 0))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.McZ, Integer.valueOf(paramString.Cuf), Long.valueOf(paramString.Cug) });
            h.ajb(-1605);
            this.MJd.CMo = 329;
            a(paramString.groupId, paramString.Cuf, paramString.Cug, 116, true);
            if (i != 0) {
              this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.MJl.m(-100, null);
            break label1459;
          }
          a(paramString.McZ, paramString.Cuf, paramString.Cug, paramString.groupId, paramString.Mdb.Mfy);
          this.MJp = paramString.groupId;
          this.Mcu = paramString.Mde;
          setState(4);
          a(paramString.Meu, paramString.MeB, paramString.MeC);
          a(paramString.groupId, paramString.McZ, paramString.Mde, paramString.Cuf, paramString.Cug, paramString.MdH, paramString.Mev, paramString.Mdb, false, true);
          if (this.MJl != null)
          {
            localObject1 = this.MJl;
            localObject2 = new g.8((g)localObject1, c.gdW().bbJ(paramString.groupId));
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label4042;
            }
            ((Runnable)localObject2).run();
          }
          for (;;)
          {
            localObject1 = new byte[paramString.Mex.length];
            j = 0;
            while (j < paramString.Mex.length)
            {
              localObject1[j] = ((byte)paramString.Mex[j]);
              j += 1;
            }
            label4042:
            ((g)localObject1).handler.post((Runnable)localObject2);
          }
          localObject2 = new int[paramString.MeG.length];
          int j = 0;
          while (j < paramString.MeG.length)
          {
            localObject2[j] = paramString.MeG[j];
            j += 1;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(paramString.MeG.length), " redirect type:", Integer.valueOf(localObject2[talk.wlX]), " SimpleRedirect value:", Integer.valueOf(talk.wlX) });
          a.ay[] arrayOfay = paramString.MdH;
          a.av localav = paramString.MdI;
          if ((paramString.Mew & 0x2) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            a(0, arrayOfay, localav, (byte[])localObject1, bool, paramString.groupId, paramString.Cuf, paramString.Cug, paramString.MeD, paramString.MeE, paramString.MeF, (int[])localObject2, paramString.MdK, this.MIU);
            if (paramString.MeA != 0)
            {
              com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.MeA });
              MII = paramString.MeA * 1000;
            }
            gej();
            N(paramString.groupId, paramString.Cuf, paramString.Cug);
            if (i != 0)
            {
              localObject1 = new HashMap();
              ((Map)localObject1).put("result", Boolean.TRUE);
              ((Map)localObject1).put("shareUrl", new String(paramString.Mdb.Mfs, Charset.forName("utf-8")));
              ((Map)localObject1).put("smsShortUrl", new String(paramString.Mdb.Mft, Charset.forName("utf-8")));
              ((Map)localObject1).put("groupId", paramString.groupId);
              this.MHf.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU) });
            break;
          }
          label4472:
          this.MJl.m(-300, null);
          break label1850;
          if (((a.y)localObject1).Met == null)
          {
            i = 0;
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
            if (b(((a.y)localObject1).groupId, ((a.y)localObject1).Cuf, ((a.y)localObject1).Cug, false)) {
              break label4660;
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.y)localObject1).groupId, this.uwq, " resp.roomid: ", Integer.valueOf(((a.y)localObject1).Cuf), Integer.valueOf(this.vdk) });
            h.ajb(-1308);
          }
          for (;;)
          {
            a(((a.y)localObject1).groupId, null, this.Mcu, ((a.y)localObject1).Cuf, ((a.y)localObject1).Cug, ((a.y)localObject1).Met, null, ((a.y)localObject1).Mdb, true, true);
            break;
            i = ((a.y)localObject1).Met.length;
            break label4497;
            this.MJd.af(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          label4703:
          if (paramInt2 != 14801) {
            break label2210;
          }
          i = -1402;
          break label2210;
          label4718:
          if (paramInt2 == 0) {
            this.MIJ = true;
          }
          if (!ezD())
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.uwq });
            this.MJd.reset();
            zQ(false);
            this.MJd.af(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
            this.Cqi = false;
            this.uwq = paramString.uwq;
            this.MJp = this.uwq;
            this.vdk = paramString.vdk;
            this.CCU = paramString.CCU;
            this.Mcu = paramString.Mcu;
            setState(2);
            this.MIQ = System.currentTimeMillis();
            localObject1 = this.MJd;
            com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "beginNotifyTime" });
            ((h)localObject1).MKN = System.currentTimeMillis();
            if (paramInt2 == 18900) {
              h.ajb(-1521);
            }
          }
          while (!com.tencent.pb.common.c.f.equals(paramString.uwq, this.uwq))
          {
            localObject1 = new e();
            ((e)localObject1).groupId = paramString.uwq;
            ((e)localObject1).roomId = paramString.vdk;
            ((e)localObject1).uXg = paramString.CCU;
            this.MID.put(paramString.uwq, localObject1);
            localObject1 = c.gdW().bbJ(paramString.uwq);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.uwq, " multiTalkGroup: ", localObject1 });
            if (localObject1 == null) {
              break label5102;
            }
            paramString = this.MJl;
            localObject1 = new g.2(paramString, (MultiTalkGroup)localObject1);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label5089;
            }
            ((Runnable)localObject1).run();
            break;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.uwq });
          break label2468;
          label5089:
          paramString.handler.post((Runnable)localObject1);
          break label2468;
          label5102:
          a(paramString.uwq, paramString.vdk, paramString.CCU, false, false, false);
          break label2468;
          localObject1 = c.gdW().bbC(paramString.groupId);
          if (localObject1 != null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
            a(paramString.groupId, null, ((TalkRoom)localObject1).gdK(), TalkRoom.gdL(), TalkRoom.eBe(), null, null, paramString.Mdb, true, false);
          }
          for (;;)
          {
            this.MJl.ho(paramString.groupId, 0);
            break;
            a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.Mdb, true, false);
          }
          label5223:
          if (!com.tencent.pb.common.c.f.equals(paramString.uwq, this.uwq)) {
            break label2909;
          }
          this.MJd.af(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          paramString = this.MJl;
          localObject1 = new g.22(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label2909;
          }
          paramString.handler.post((Runnable)localObject1);
          break label2909;
          if (this.MJe != null)
          {
            localObject1 = new int[6];
            localObject1[0] = paramString.GGJ;
            localObject1[1] = paramString.MeI;
            localObject1[2] = paramString.MeJ;
            localObject1[3] = paramString.MeK;
            localObject1[4] = paramString.MeL;
            localObject1[5] = paramString.MeM;
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject1[2]), Integer.valueOf(localObject1[3]), Integer.valueOf(localObject1[4]), Integer.valueOf(localObject1[5]) });
            localObject2 = this.MJe;
            if (((b)localObject2).MIo != null) {
              break label5561;
            }
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject1, ", engine:", ((b)localObject2).MIo });
          }
          for (;;)
          {
            if (paramString.MeP == 0)
            {
              if (paramInt2 == 0)
              {
                localObject1 = this.MJl;
                paramString = new g.17((g)localObject1, paramString.GGJ);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  paramString.run();
                  break;
                  ((b)localObject2).MIo.setMVSvrCfg((int[])localObject1, 6);
                  continue;
                }
                ((g)localObject1).handler.post(paramString);
                break;
              }
              if (paramInt2 == 24301)
              {
                this.MJl.m(-1700, Integer.valueOf(paramString.MeO));
                break;
              }
              this.MJl.m(-800, null);
              break;
            }
          }
          if (paramString.MeP != 1) {
            break label3017;
          }
          paramString = this.MJl;
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
            paramString = this.MJl;
            localObject1 = new g.19(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              continue;
            }
            paramString.handler.post((Runnable)localObject1);
            continue;
          }
          this.MJl.m(-1600, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.MJl;
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
        this.MJl.m(-1601, null);
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
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.uwq, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.vdk), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.CCU) });
    c.gdW().bbD(paramString);
    if (paramBoolean1) {
      N(paramString, paramInt, paramLong);
    }
    this.MID.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      zQ(true);
      this.MJl.dm(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.gdW().bbJ(paramString);
      if (paramString != null) {
        this.MJl.f(paramString);
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
    boolean bool = com.tencent.pb.common.b.e.fXr().a(localf);
    this.MJd.af(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62736);
    return bool;
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208338);
    int j = -1;
    int i = j;
    if (this.voZ)
    {
      i = j;
      if (this.MJe == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.MJe;
        if ((paramArrayOfByte != null) && (localb.MIo != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.MIo });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.voZ), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.MJe });
      i = paramInt1;
      AppMethodBeat.o(208338);
      return i;
      paramInt1 = localb.MIo.SendVideo(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62744);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.voZ) && (this.MJe != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.MJe;
        if ((paramArrayOfByte == null) || (localb.MIo == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.MIo });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.voZ), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.MJe });
          AppMethodBeat.o(62744);
          return paramArrayOfByte;
        }
        paramInt1 = localb.MIo.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.wpx = paramArrayOfInt;
        paramArrayOfByte.wpy = localb.MIo.field_localImgWidth;
        paramArrayOfByte.wpz = localb.MIo.field_localImgHeight;
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
  
  public final boolean b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62733);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.uwq, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
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
        geh();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.fXr().a(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.MJd.af(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
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
  
  public final e bbK(String paramString)
  {
    AppMethodBeat.i(62757);
    paramString = (e)this.MID.get(paramString);
    AppMethodBeat.o(62757);
    return paramString;
  }
  
  public final boolean bbL(String paramString)
  {
    AppMethodBeat.i(62758);
    if ((e)this.MID.get(paramString) != null)
    {
      AppMethodBeat.o(62758);
      return true;
    }
    AppMethodBeat.o(62758);
    return false;
  }
  
  public final boolean bd(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62773);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62773);
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100)) {
      this.MJd.gew();
    }
    int i = this.vdk;
    long l = this.CCU;
    int j = a.gdH().state;
    if (j.bbQ(paramString))
    {
      this.MJd.ajf(327);
      bool = a.gdH().hp(paramString, 1000);
      AppMethodBeat.o(62773);
      return bool;
    }
    if (j == 2)
    {
      bool = a.gdH().b(paramString, i, l, paramInt1);
      AppMethodBeat.o(62773);
      return bool;
    }
    com.tencent.pb.common.c.a.L(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.gdH().a(paramString, i, l, paramInt2, true);
    AppMethodBeat.o(62773);
    return bool;
  }
  
  public final int cX(byte[] paramArrayOfByte)
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
        if ((!TextUtils.isEmpty(this.uwq)) || (!TextUtils.isEmpty(this.MIM)))
        {
          this.MJd.af(new String[] { "notify", "pasrefail" });
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
        h.ajb(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.vdk, this.CCU, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange ", this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU), Long.valueOf(paramArrayOfByte.msgId), Integer.valueOf(paramArrayOfByte.MdF), Integer.valueOf(paramArrayOfByte.iqb) });
      l = paramArrayOfByte.msgId;
      if (this.MJq.contains(Long.valueOf(l)))
      {
        n = 1;
        if (n == 0) {
          break label392;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error: msgId:", Long.valueOf(paramArrayOfByte.msgId) });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false)) {
          break label348;
        }
        this.MJd.af(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.MdF) });
      }
      for (;;)
      {
        AppMethodBeat.o(62753);
        return -3;
        this.MJq.add(Long.valueOf(l));
        n = 0;
        break;
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.MdF) });
      }
      label392:
      n = paramArrayOfByte.MdF;
      i1 = paramArrayOfByte.iqb;
      switch (n)
      {
      default: 
        com.tencent.pb.common.c.b.w(" unknow voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1) });
        n = 0;
      }
    }
    if (n == 0) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange update msg seq fail type:", Integer.valueOf(paramArrayOfByte.MdF) });
    }
    for (;;)
    {
      AppMethodBeat.o(62753);
      return 0;
      if (i1 <= this.MIW)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MIW) });
        n = 0;
        break;
      }
      this.MIW = i1;
      for (;;)
      {
        com.tencent.pb.common.c.b.w("voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1), " update local seq" });
        n = 1;
        break;
        if (i1 <= this.MIX)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MIX) });
          n = 0;
          break;
        }
        this.MIX = i1;
        continue;
        if (i1 <= this.MIY)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MIY) });
          n = 0;
          break;
        }
        this.MIY = i1;
        continue;
        if (i1 <= this.MIZ)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MIZ) });
          n = 0;
          break;
        }
        this.MIZ = i1;
        continue;
        if (i1 <= this.MJa)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MJa) });
          n = 0;
          break;
        }
        this.MJa = i1;
        continue;
        if (i1 <= this.MJb)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MJb) });
          n = 0;
          break;
        }
        this.MJb = i1;
        continue;
        if (i1 <= this.MJc)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.MJc) });
          n = 0;
          break;
        }
        this.MJc = i1;
      }
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false)) {
        this.MJd.af(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.MdF) });
      }
      if (paramArrayOfByte.MdF == 2)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.Mde, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, paramArrayOfByte.MdH, paramArrayOfByte.MdG, paramArrayOfByte.Mdb, true, true);
      }
      else
      {
        Object localObject1;
        if (paramArrayOfByte.MdF == 4)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.Mde, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, paramArrayOfByte.MdH, paramArrayOfByte.MdG, paramArrayOfByte.Mdb, true, true);
          if ((paramArrayOfByte.MdJ != 0) || (paramArrayOfByte.MdK != 0))
          {
            localObject1 = this.MJe;
            n = paramArrayOfByte.MdJ;
            i1 = paramArrayOfByte.MdK;
            if ((com.tencent.pb.common.a.a.MbV) && (((b)localObject1).MIo != null)) {
              ((b)localObject1).MIo.SetAVEncryptType(n, i1);
            }
          }
        }
        else if (paramArrayOfByte.MdF == 16)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.Mde, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, paramArrayOfByte.MdH, paramArrayOfByte.MdG, paramArrayOfByte.Mdb, true, false);
        }
        else if (paramArrayOfByte.MdF == 1)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.Cuf), " roomkey: ", Long.valueOf(paramArrayOfByte.Cug) });
          if (com.tencent.pb.a.a.a.fXL())
          {
            com.tencent.pb.a.a.a.fXM();
            if ((ezD()) && (com.tencent.pb.common.c.f.equals(paramArrayOfByte.groupId, this.uwq))) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.uwq });
            }
          }
          else
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
            continue;
          }
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.Mde, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, paramArrayOfByte.MdH, paramArrayOfByte.MdG, paramArrayOfByte.Mdb, false, true);
          localObject1 = paramArrayOfByte.groupId;
          n = paramArrayOfByte.Cuf;
          l = paramArrayOfByte.Cug;
          i1 = paramArrayOfByte.Mde;
          int i2 = paramArrayOfByte.MdL;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
          }
          for (;;)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
            break;
            paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, n, l, i1, i2);
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i2), Boolean.valueOf(com.tencent.pb.common.b.e.fXr().a(paramArrayOfByte)) });
          }
        }
        else if (paramArrayOfByte.MdF == 8)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.uwq });
          if (b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false))
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.Mde, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, paramArrayOfByte.MdH, paramArrayOfByte.MdG, paramArrayOfByte.Mdb, true, false);
            a(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false, false, true);
          }
          else
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.Mde, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, paramArrayOfByte.MdH, paramArrayOfByte.MdG, paramArrayOfByte.Mdb, true, false);
          }
        }
        else
        {
          String str;
          if (paramArrayOfByte.MdF == 128)
          {
            localObject1 = paramArrayOfByte.groupId;
            str = this.uwq;
            if (paramArrayOfByte.MdM == null) {}
            for (n = 0;; n = paramArrayOfByte.MdM.length)
            {
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(n) });
              localObject1 = this.MJl;
              paramArrayOfByte = new g.21((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.MdM);
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
            if (paramArrayOfByte.MdF == 256)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
              } else if (paramArrayOfByte.MdM == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
              } else {
                try
                {
                  localObject1 = paramArrayOfByte.MdM;
                  localObject1 = (a.s)com.google.b.a.e.a(new a.s(), (byte[])localObject1, localObject1.length);
                  if ((localObject1 == null) || (((a.s)localObject1).MdQ == null)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
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
                  localObject2 = ((a.s)localObject2).MdQ;
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
                  com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.uwq, " roomId: ", Integer.valueOf(this.vdk), " videoUserNames: ", paramArrayOfByte });
                  localObject2 = this.MJl;
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
            else if (paramArrayOfByte.MdF == 1024)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
              }
              else if ((this.state != 3) && (this.state != 4))
              {
                b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, 1);
                this.MJl.m(-1400, null);
              }
            }
            else if (paramArrayOfByte.MdF == 512)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
              } else if (paramArrayOfByte.MdM == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
              } else {
                try
                {
                  localObject2 = paramArrayOfByte.MdM;
                  localObject2 = (a.r)com.google.b.a.e.a(new a.r(), (byte[])localObject2, localObject2.length);
                  if (localObject2 == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
                  }
                }
                catch (com.google.b.a.d locald2)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                    local1 = null;
                  }
                  paramArrayOfByte = this.MJl;
                  g.1 local1 = new g.1(paramArrayOfByte, local1.MdP);
                  if (Looper.myLooper() == Looper.getMainLooper())
                  {
                    local1.run();
                    continue;
                  }
                  paramArrayOfByte.handler.post(local1);
                }
              }
            }
            else if (paramArrayOfByte.MdF == 2048)
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, chgtype: audiostream" });
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.Cuf, paramArrayOfByte.Cug, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAudioStreamChange is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.Cuf) });
              }
              else
              {
                com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleAudioStreamChange audio_stream_type", Integer.valueOf(paramArrayOfByte.audioStreamType) });
                int i = (byte)(paramArrayOfByte.audioStreamType & 0xFF);
                int j = (byte)(paramArrayOfByte.audioStreamType >> 8 & 0xFF);
                int k = (byte)(paramArrayOfByte.audioStreamType >> 16 & 0xFF);
                int m = (byte)(paramArrayOfByte.audioStreamType >> 24 & 0xFF);
                this.MJe.MIo.setAppCmd(306, new byte[] { i, j, k, m }, 4);
              }
            }
            else
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, unknow chgtype:", Integer.valueOf(paramArrayOfByte.MdF), Long.valueOf(paramArrayOfByte.msgId) });
            }
          }
        }
      }
    }
  }
  
  public final int e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208339);
    int j = -1;
    int i = j;
    if (this.voZ)
    {
      i = j;
      if (this.MJe == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.MJe;
        if ((paramArrayOfByte != null) && (localb.MIo != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendScreen null, buffer:", paramArrayOfByte, ", engine:", localb.MIo });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendScreen error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen finished, ", Boolean.valueOf(this.voZ), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.MJe });
      i = paramInt1;
      AppMethodBeat.o(208339);
      return i;
      paramInt1 = localb.MIo.SendScreen(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  final boolean erC()
  {
    AppMethodBeat.i(62765);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initEngine", this.uwq, Integer.valueOf(this.vdk), Long.valueOf(this.CCU), Integer.valueOf(this.state) });
    int i;
    label133:
    int j;
    try
    {
      localb = this.MJe;
      boolean bool = com.tencent.pb.common.a.a.MbV;
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
        i = localException.MIo.field_capInfo.length;
      }
      AppMethodBeat.o(62765);
      return true;
    }
    if (i < 0)
    {
      h.aje(-3001);
      this.MJd.ajf(201);
      this.MJe = null;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(62765);
      return false;
      str = com.tencent.pb.common.c.c.CDp.getDir("lib", 0).getAbsolutePath();
      locale = McG;
      if (locale == null) {
        break label380;
      }
      j = locale.aao();
      i = locale.dsv();
    }
    for (;;)
    {
      int k = k.ly(com.tencent.pb.common.c.c.CDp);
      com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(k), " cpuFlag:", Integer.valueOf(j), "libPath:", str });
      if (localb.MIo == null)
      {
        i = -1;
        break;
      }
      j = localb.MIo.init(i, k, j, str + "/");
      if (localb.MIo.field_capInfo == null)
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
  
  public final boolean ezD()
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
  
  final boolean gef()
  {
    AppMethodBeat.i(62724);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = McG;
    if (locale != null) {
      locale.dsu();
    }
    this.MJe = new b();
    this.MJp = this.uwq;
    gee();
    this.MJf = new talk.a()
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
          f.this.MJd.MKz = 1;
          localh = f.this.MJd;
          if (localh.MKM != 0L) {
            break label121;
          }
        }
        label121:
        for (localh.MKA = 0L;; localh.MKA = (System.currentTimeMillis() - localh.MKM))
        {
          com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.MKM), Long.valueOf(localh.MKA) });
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
        //   9: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   12: getfield 77	com/tencent/wecall/talkroom/model/f:MJd	Lcom/tencent/wecall/talkroom/model/h;
        //   15: iconst_1
        //   16: putfield 124	com/tencent/wecall/talkroom/model/h:uYt	I
        //   19: ldc 59
        //   21: iconst_1
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 126
        //   29: aastore
        //   30: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   33: aload_0
        //   34: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
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
        //   58: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   61: invokestatic 128	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   64: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   67: aastore
        //   68: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   71: ldc 121
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aload_0
        //   78: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   81: astore 6
        //   83: invokestatic 136	com/tencent/wecall/talkroom/model/c:gdW	()Lcom/tencent/wecall/talkroom/model/c;
        //   86: astore 4
        //   88: aload_0
        //   89: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
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
        //   117: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   120: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   123: ifnull +30 -> 153
        //   126: aload_0
        //   127: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   130: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   133: astore 4
        //   135: invokestatic 156	com/tencent/wecall/talkroom/model/f:ger	()Z
        //   138: istore_3
        //   139: getstatic 162	com/tencent/pb/common/a/a:MbV	Z
        //   142: ifeq +11 -> 153
        //   145: aload 4
        //   147: getfield 168	com/tencent/wecall/talkroom/model/b:MIo	Lcom/tencent/mm/plugin/multi/talk;
        //   150: ifnonnull +431 -> 581
        //   153: aload_0
        //   154: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   157: invokestatic 171	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
        //   160: pop
        //   161: aload_0
        //   162: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   165: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   168: pop
        //   169: invokestatic 175	com/tencent/wecall/talkroom/model/f:ges	()Lcom/tencent/pb/talkroom/sdk/e;
        //   172: astore 4
        //   174: aload 4
        //   176: ifnull +11 -> 187
        //   179: aload 4
        //   181: invokeinterface 181 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   191: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   194: getfield 168	com/tencent/wecall/talkroom/model/b:MIo	Lcom/tencent/mm/plugin/multi/talk;
        //   197: astore 6
        //   199: getstatic 162	com/tencent/pb/common/a/a:MbV	Z
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
        //   308: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
        //   311: getfield 77	com/tencent/wecall/talkroom/model/f:MJd	Lcom/tencent/wecall/talkroom/model/h;
        //   314: astore 4
        //   316: aload 4
        //   318: getfield 87	com/tencent/wecall/talkroom/model/h:MKM	J
        //   321: lconst_0
        //   322: lcmp
        //   323: ifne +317 -> 640
        //   326: aload 4
        //   328: lconst_0
        //   329: putfield 209	com/tencent/wecall/talkroom/model/h:MKB	J
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
        //   348: getfield 209	com/tencent/wecall/talkroom/model/h:MKB	J
        //   351: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   354: aastore
        //   355: dup
        //   356: iconst_2
        //   357: aload 4
        //   359: getfield 87	com/tencent/wecall/talkroom/model/h:MKM	J
        //   362: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   365: aastore
        //   366: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   369: aload_0
        //   370: getfield 22	com/tencent/wecall/talkroom/model/f$1:MJE	Lcom/tencent/wecall/talkroom/model/f;
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
        //   442: invokevirtual 234	com/tencent/wecall/talkroom/model/c:bbC	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
        //   445: astore 7
        //   447: aload 5
        //   449: astore 4
        //   451: aload 7
        //   453: ifnull -344 -> 109
        //   456: aload 7
        //   458: invokevirtual 240	com/tencent/wecall/talkroom/model/TalkRoom:gdN	()Ljava/util/List;
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
        //   587: getfield 168	com/tencent/wecall/talkroom/model/b:MIo	Lcom/tencent/mm/plugin/multi/talk;
        //   590: sipush 401
        //   593: invokevirtual 277	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   596: pop
        //   597: goto -444 -> 153
        //   600: aload 4
        //   602: getfield 168	com/tencent/wecall/talkroom/model/b:MIo	Lcom/tencent/mm/plugin/multi/talk;
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
        //   647: getfield 87	com/tencent/wecall/talkroom/model/h:MKM	J
        //   650: lsub
        //   651: putfield 209	com/tencent/wecall/talkroom/model/h:MKB	J
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
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.baC(f.this.MJp));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bbP(localStringBuilder.toString());
        AppMethodBeat.o(62608);
      }
      
      public final void keep_OnReportEngineRecv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62606);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.baC(f.this.MJp));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bbN(localStringBuilder.toString());
        AppMethodBeat.o(62606);
      }
      
      public final void keep_OnReportEngineSend(String paramAnonymousString)
      {
        AppMethodBeat.i(62607);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.baC(f.this.MJp));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bbO(localStringBuilder.toString());
        AppMethodBeat.o(62607);
      }
      
      final class a
        implements Runnable
      {
        int MJG;
        int MJH;
        int MJI;
        int MJJ;
        int MJK;
        
        a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
          this.MJG = paramInt1;
          this.MJI = paramInt2;
          this.MJJ = paramInt3;
          this.MJK = paramInt4;
          this.MJH = paramInt5;
        }
        
        public final void run()
        {
          AppMethodBeat.i(62585);
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "keep_OnError handler" });
          h.aje(this.MJJ);
          f.this.MJd.ajf(this.MJI);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.MJH) });
          f.this.a(f.b(f.this), f.g(f.this), f.h(f.this), this.MJK, true);
          f.f(f.this).m(this.MJG, null);
          AppMethodBeat.o(62585);
        }
      }
    };
    AppMethodBeat.o(62724);
    return true;
  }
  
  public final void geg()
  {
    AppMethodBeat.i(62726);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.MJB != null) {
        this.mHandler.removeCallbacks(this.MJB);
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
        if (paramMessage.uwq == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId is null" });
        }
        else
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handlerInviteTimeOut" });
          if ((paramMessage.uwq.equals(this.uwq)) && (paramMessage.vdk == this.vdk) && (paramMessage.CCU == this.CCU))
          {
            h.gez();
            this.MJd.ajf(501);
            b(paramMessage.uwq, paramMessage.vdk, paramMessage.CCU, 7);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId: ", paramMessage.uwq });
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
              if (com.tencent.pb.common.c.f.mP(paramMessage.groupId, this.uwq))
              {
                String str1 = paramMessage.groupId;
                Object localObject1 = paramMessage.MJY;
                a.bb localbb = paramMessage.MJZ;
                int i = paramMessage.Mde;
                int j = paramMessage.type;
                long l = paramMessage.MKa;
                String str2 = paramMessage.MKb;
                boolean bool = paramMessage.MKc;
                String str3 = paramMessage.MKd;
                this.MJd.gex();
                Object localObject2 = c.gdW();
                paramMessage = "";
                localObject2 = ((c)localObject2).bbC(str1);
                if (localObject2 != null) {
                  if (((TalkRoom)localObject2).MIm != null) {
                    break label618;
                  }
                }
                label618:
                for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).MIm.name)
                {
                  localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.MJe.gdT(), paramMessage, localbb, i, j, l, str2, bool, str3);
                  bool = com.tencent.pb.common.b.e.fXr().a((com.tencent.pb.common.b.d)localObject1);
                  this.MJd.af(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
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
                  if (b(paramMessage.groupId, paramMessage.roomId, paramMessage.uXg, false))
                  {
                    a(paramMessage.groupId, paramMessage.roomId, paramMessage.uXg, paramMessage.Mde, paramMessage.vGk, paramMessage.MKp);
                    continue;
                    com.tencent.pb.common.c.e.fXJ();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void hm(String paramString, int paramInt)
  {
    AppMethodBeat.i(62776);
    if ((com.tencent.pb.common.c.f.equals("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (ezD()) && ((this.voZ) || (this.MIK))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62776);
      return;
      switch (k.ly(com.tencent.pb.common.c.c.CDp))
      {
      }
      for (this.MJn = false; (this.vdk == 0) || (this.CCU == 0L); this.MJn = true)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(62776);
        return;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect", this.uwq, Integer.valueOf(this.vdk) });
      this.MJd.gex();
      paramString = new com.tencent.wecall.talkroom.a.h(this.uwq, this.vdk, this.CCU, c.gdW().bbE(this.uwq), this.MIT);
      boolean bool = com.tencent.pb.common.b.e.fXr().a(paramString);
      this.MJd.af(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62776);
      return;
      paramString = this.MJe;
      paramInt = k.ly(com.tencent.pb.common.c.c.CDp);
      if ((!com.tencent.pb.common.a.a.MbV) || (paramString.MIo == null))
      {
        AppMethodBeat.o(62776);
        return;
      }
      paramString.MIo.onNetworkChange(paramInt);
    }
  }
  
  public final void oL(boolean paramBoolean)
  {
    AppMethodBeat.i(62766);
    try
    {
      PF();
      gei();
      if (paramBoolean)
      {
        gen();
        bkx();
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
    AppMethodBeat.i(208340);
    if ((this.voZ) && (this.MJe != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        b localb = this.MJe;
        if ((paramArrayOfByte1 == null) || (localb.MIo == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:screenTrans null, buf:", paramArrayOfByte1, ", engine:", localb.MIo });
          paramInt4 = -1;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "screenTrans finished, ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.voZ), " engine: ", this.MJe });
          AppMethodBeat.o(208340);
          return paramInt4;
        }
        paramInt4 = localb.MIo.screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
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
    this.MJl.onStateChanged(paramInt);
    AppMethodBeat.o(62728);
  }
  
  public final void zQ(boolean paramBoolean)
  {
    AppMethodBeat.i(62725);
    this.MJd.groupId = this.uwq;
    this.MJd.McZ = this.MIM;
    if (com.tencent.pb.common.c.f.ef(this.MJd.groupId)) {
      this.MJd.groupId = "";
    }
    if (com.tencent.pb.common.c.f.ef(this.MJd.McZ)) {
      this.MJd.McZ = "";
    }
    this.MJd.CwV = 1;
    this.MJd.roomId = this.vdk;
    this.MJd.uXg = this.CCU;
    gee();
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    erz();
    Zq();
    int j = -99999;
    int i = j;
    if (this.MJe != null) {}
    try
    {
      this.MJm = this.MJe.gdV();
      i = this.MJe.Close();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.MJe == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        j = this.MJe.uninitLive();
        this.MJe = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.MJd.geu();
          if ((!TextUtils.isEmpty(this.MJd.groupId)) || (!TextUtils.isEmpty(this.MJd.McZ)))
          {
            h.bbM(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.MJd.reset();
          geq();
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
  
  final class a
  {
    String[] MJY;
    a.bb MJZ;
    long MKa;
    String MKb;
    boolean MKc;
    String MKd;
    int Mde;
    String groupId;
    int type;
    
    a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(62686);
      MKe = new b("OK", 0);
      MKf = new b("NOT_AUTH", 1);
      MKg = new b("NOT_BIND", 2);
      MKh = new b("NOT_MATCH", 3);
      MKi = new b("NO_NETWORK", 4);
      MKj = new b("BUSY", 5);
      MKk = new b("NOT_VALID_STATE", 6);
      MKl = new b("GROUP_NOT_VALID", 7);
      MKm = new b("UNINIT_SERVICE_FAILED", 8);
      MKn = new b("INIT_ENGINE_FAILED", 9);
      MKo = new b[] { MKe, MKf, MKg, MKh, MKi, MKj, MKk, MKl, MKm, MKn };
      AppMethodBeat.o(62686);
    }
    
    private b() {}
  }
  
  final class c
  {
    String MKp;
    int Mde;
    String groupId;
    int roomId;
    long uXg;
    int vGk;
    
    c() {}
  }
  
  final class d
  {
    long CCU;
    String uwq;
    int vdk;
  }
  
  final class e
  {
    String groupId;
    int roomId;
    long uXg;
    
    e() {}
  }
  
  public static abstract interface f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */