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
  private static com.tencent.pb.talkroom.sdk.e JLT;
  public static List<Integer> KvG;
  private static int KvM;
  public static String[] Kwr;
  public long AMc;
  boolean AzH;
  int JLH;
  private com.tencent.f.a.a Kuh;
  f KvF;
  private Map<String, e> KvH;
  private final int KvI;
  private final int KvJ;
  private final int KvK;
  private final int KvL;
  private boolean KvN;
  private boolean KvO;
  private String KvP;
  public String KvQ;
  private int KvR;
  private int KvS;
  private int KvT;
  private long KvU;
  private boolean KvV;
  private int KvW;
  private int KvX;
  int KvY;
  int KvZ;
  private String[] KwA;
  private int KwB;
  public boolean KwC;
  public boolean KwD;
  private Runnable KwE;
  private com.tencent.pb.common.b.d KwF;
  private Runnable KwG;
  private int Kwa;
  private int Kwb;
  private int Kwc;
  private int Kwd;
  private int Kwe;
  private int Kwf;
  public h Kwg;
  b Kwh;
  private talk.a Kwi;
  private TimerTask Kwj;
  private TimerTask Kwk;
  private Timer Kwl;
  private TimerTask Kwm;
  private Timer Kwn;
  g Kwo;
  private int Kwp;
  private boolean Kwq;
  public String Kws;
  HashSet<Long> Kwt;
  public boolean Kwu;
  public boolean Kwv;
  public boolean Kww;
  private short[] Kwx;
  private String[] Kwy;
  private short[] Kwz;
  Handler mHandler;
  boolean mIsMute;
  int state;
  public int tOL;
  public String tmu;
  boolean uaf;
  
  static
  {
    AppMethodBeat.i(62787);
    JLT = null;
    KvG = new ArrayList();
    KvM = 30000;
    Kwr = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(62787);
  }
  
  public f()
  {
    AppMethodBeat.i(62723);
    this.KvH = new HashMap();
    this.KvI = 1;
    this.KvJ = 2;
    this.KvK = 3;
    this.KvL = 4;
    this.state = 0;
    this.AzH = false;
    this.KvN = false;
    this.KvO = false;
    this.uaf = false;
    this.KvR = 0;
    this.KvS = 0;
    this.KvT = 0;
    this.KvU = 0L;
    this.KvV = true;
    this.KvW = 0;
    this.KvX = 0;
    this.KvY = 0;
    this.KvZ = -1;
    this.Kwa = -1;
    this.Kwb = -1;
    this.Kwc = -1;
    this.Kwd = -1;
    this.Kwe = -1;
    this.Kwf = -1;
    this.Kwg = h.KxA;
    this.Kwl = new Timer("TalkRoomService_HelloTimer");
    this.Kwn = new Timer("TalkRoomService_talkDurationTimer");
    this.Kwo = new g();
    this.Kwp = 0;
    this.Kwq = false;
    this.Kws = null;
    this.Kwt = new HashSet();
    this.Kwu = false;
    this.Kwv = true;
    this.Kww = true;
    this.Kwx = null;
    this.Kwy = null;
    this.Kwz = null;
    this.KwA = null;
    this.KwB = 0;
    this.mIsMute = false;
    this.KwC = false;
    this.KwD = true;
    this.KwE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62550);
        if ((f.this.eil()) && (f.s(f.this)))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
          h.afT(-2003);
          f.this.Kwg.afW(401);
          f.this.aW(f.b(f.this), 3, 108);
        }
        AppMethodBeat.o(62550);
      }
    };
    this.KwF = null;
    this.KwG = new Runnable()
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
        if (!f.this.eil())
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
              if (f.a(f.this, locale.tmu, locale.tOL, locale.AMc, f.afR(locale.Kyc)))
              {
                localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
              }
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.pb.common.b.e.fBC().a((com.tencent.pb.common.b.d)localObject1);
          AppMethodBeat.o(62587);
          return;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        AppMethodBeat.o(62587);
      }
    };
    com.tencent.pb.common.b.e.fBC().a(201, this);
    com.tencent.pb.common.b.e.fBC().a(202, this);
    com.tencent.pb.common.b.e.fBC().a(203, this);
    com.tencent.pb.common.b.e.fBC().a(204, this);
    com.tencent.pb.common.b.e.fBC().a(205, this);
    com.tencent.pb.common.b.e.fBC().a(206, this);
    com.tencent.pb.common.b.e.fBC().a(207, this);
    com.tencent.pb.common.b.e.fBC().a(208, this);
    com.tencent.pb.common.b.e.fBC().a(210, this);
    com.tencent.pb.common.b.e.fBC().a(209, this);
    com.tencent.pb.common.b.e.fBC().a(211, this);
    com.tencent.pb.common.b.e.fBC().a(212, this);
    com.tencent.pb.common.b.e.fBC().a(213, this);
    com.tencent.pb.common.b.e.fBC().a(214, this);
    com.tencent.pb.common.b.e.fBC().a(800, this);
    com.tencent.pb.common.b.e.fBC().a(801, this);
    Object localObject = c.fIe();
    g localg = this.Kwo;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).Kvx = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      fIm();
      if (this.Kuh == null) {
        this.Kuh = ((com.tencent.f.a.a)com.tencent.f.f.aTW("EventCenter"));
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.Kuh.a(this, Kwr);
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
  
  private boolean NX()
  {
    AppMethodBeat.i(62739);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = JLT;
      if (locale == null) {
        break label99;
      }
      this.Kwg.AGB = locale.dfy();
      this.Kwg.AGx = locale.dfz();
      bool = locale.dfw();
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
  
  private void WN()
  {
    AppMethodBeat.i(62727);
    this.KvH.remove(this.tmu);
    this.Kwp = 0;
    this.mIsMute = false;
    setState(0);
    this.KvO = false;
    a(this.KvQ, 0, 0L, null, null);
    this.KvQ = null;
    this.JLH = 0;
    this.KvR = 0;
    this.KvS = 0;
    this.KvT = 0;
    this.KvV = true;
    this.Kwv = true;
    this.KvU = 0L;
    this.KvW = 0;
    this.KvN = false;
    this.KwC = false;
    this.KwD = true;
    fIo();
    this.mHandler.removeMessages(1);
    if (this.Kwh != null) {
      this.Kwh.fIc();
    }
    fIt();
    fIs();
    fIu();
    fIx();
    this.uaf = false;
    this.Kwu = false;
    this.KvX = 0;
    AppMethodBeat.o(62727);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    AppMethodBeat.i(62747);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.roomId, paramh.tIG, false)) {
        this.Kwg.ad(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62747);
      return;
    }
    paramObject = (a.al)paramObject;
    if (!b(paramObject.groupId, paramObject.ADE, paramObject.ADF, false))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.ADE), Integer.valueOf(this.tOL) });
      AppMethodBeat.o(62747);
      return;
    }
    this.Kwg.ad(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.JLH, paramObject.ADE, paramObject.ADF, paramObject.JNG, paramObject.JNI, paramObject.JMo, false, false);
    a(paramObject.JNH, paramObject.JNO, paramObject.JNP);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect type:", Integer.valueOf(this.KvX) });
    if (this.KvX == 0)
    {
      paramh = new byte[paramObject.JNK.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.JNK.length)
      {
        paramh[paramInt1] = ((byte)paramObject.JNK[paramInt1]);
        paramInt1 += 1;
      }
      localObject1 = new int[paramObject.JNT.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.JNT.length)
      {
        localObject1[paramInt1] = paramObject.JNT[paramInt1];
        paramInt1 += 1;
      }
      if (this.Kwh != null)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.Kwh.Close()) });
        localObject2 = paramObject.JNG;
        localObject3 = paramObject.JMV;
        if ((paramObject.JNJ & 0x2) == 0) {
          break label547;
        }
      }
      label547:
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ay[])localObject2, (a.av)localObject3, paramh, bool, paramObject.groupId, paramObject.ADE, paramObject.ADF, paramObject.JNQ, paramObject.JNR, paramObject.JNS, (int[])localObject1, paramObject.JMX, this.KvY);
        AppMethodBeat.o(62747);
        return;
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp engine close but nullptr" });
        AppMethodBeat.o(62747);
        return;
      }
    }
    paramInt1 = k.lf(com.tencent.pb.common.c.c.AMx);
    com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "amyfwang,Redirect::netType:", Integer.valueOf(paramInt1) });
    paramObject = this.Kwh;
    paramh = this.Kwy;
    Object localObject1 = this.Kwx;
    Object localObject2 = this.KwA;
    Object localObject3 = this.Kwz;
    if (paramObject.Kvs != null) {
      paramObject.Kvs.Redirect(paramh, (short[])localObject1, (String[])localObject2, (short[])localObject3, paramInt1);
    }
    AppMethodBeat.o(62747);
  }
  
  private void a(int paramInt, a.ab paramab, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(192761);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.tmu, Integer.valueOf(parame.tOL), Long.valueOf(parame.AMc), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111), Integer.valueOf(14287), Integer.valueOf(-1112) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.afS(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramab.groupId, Integer.valueOf(paramab.ADE), Long.valueOf(paramab.ADF) });
      this.Kwo.n(-14255, paramab);
      AppMethodBeat.o(192761);
      return;
    }
    if (paramInt == 14287)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14287), paramab.groupId, Integer.valueOf(paramab.ADE), Long.valueOf(paramab.ADF) });
      this.Kwo.n(-14287, paramab);
      AppMethodBeat.o(192761);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramab.groupId, Integer.valueOf(paramab.ADE), Long.valueOf(paramab.ADF) });
      this.Kwo.n(-14256, paramab);
      AppMethodBeat.o(192761);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.tmu, parame.tOL, parame.AMc, afQ(parame.Kyc)))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.tmu, " mGroupId: ", this.tmu, Integer.valueOf(parame.tOL), Integer.valueOf(this.tOL), Long.valueOf(parame.AMc), Long.valueOf(this.AMc) });
        AppMethodBeat.o(192761);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.tmu, Integer.valueOf(parame.tOL), Long.valueOf(parame.AMc) });
        AppMethodBeat.o(192761);
        return;
      }
      this.Kwg.ad(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.Kwg.afW(322);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.tmu, Integer.valueOf(parame.tOL), Long.valueOf(parame.AMc) });
      a(parame.tmu, parame.tOL, parame.AMc, true);
      if (paramInt == 14251)
      {
        this.Kwo.n(-1000, null);
        AppMethodBeat.o(192761);
        return;
      }
      if (paramInt == 14252)
      {
        this.Kwo.n(-1200, null);
        AppMethodBeat.o(192761);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramab != null) {
          parame = Integer.valueOf(paramab.JNM);
        }
        this.Kwo.n(-1500, parame);
        AppMethodBeat.o(192761);
        return;
      }
      this.Kwo.n(-200, null);
      AppMethodBeat.o(192761);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramab.groupId, Integer.valueOf(paramab.ADE), Long.valueOf(paramab.ADF) });
      AppMethodBeat.o(192761);
      return;
    }
    if (!b(paramab.groupId, paramab.ADE, paramab.ADF, afQ(paramab.urD)))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramab.groupId, " mGroupId: ", this.tmu, Integer.valueOf(paramab.ADE), Integer.valueOf(this.tOL), Long.valueOf(paramab.ADF), Long.valueOf(this.AMc) });
      a(paramab.groupId, paramab.ADE, paramab.ADF, 111, false);
      h.afS(-1110);
      AppMethodBeat.o(192761);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramab.groupId, Integer.valueOf(paramab.ADE), Long.valueOf(paramab.ADF) });
      AppMethodBeat.o(192761);
      return;
    }
    this.Kwg.ad(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramab.JNH == null) || (paramab.JNH.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramab.groupId, Integer.valueOf(paramab.ADE), Long.valueOf(paramab.ADF) });
      h.afS(-1605);
      this.Kwg.AUB = 329;
      a(paramab.groupId, paramab.ADE, paramab.ADF, 116, true);
      this.Kwo.n(-200, null);
      AppMethodBeat.o(192761);
      return;
    }
    this.tmu = paramab.groupId;
    this.Kws = paramab.groupId;
    this.tOL = paramab.ADE;
    this.AMc = paramab.ADF;
    setState(4);
    a(paramab.JNH, paramab.JNO, paramab.JNP);
    a(paramab.groupId, null, this.JLH, paramab.ADE, paramab.ADF, paramab.JNG, paramab.JNI, paramab.JMo, false, true);
    parame = this.Kwo;
    localObject = new g.8(parame, c.fIe().aUi(paramab.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramab.JNK.length];
      paramInt = 0;
      while (paramInt < paramab.JNK.length)
      {
        parame[paramInt] = ((byte)paramab.JNK[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramab.JNT.length];
    paramInt = 0;
    while (paramInt < paramab.JNT.length)
    {
      localObject[paramInt] = paramab.JNT[paramInt];
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(paramab.JNT.length), " redirect type:", Integer.valueOf(localObject[talk.uWL]), " SimpleRedirect value:", Integer.valueOf(talk.uWL) });
    a.ay[] arrayOfay = paramab.JNG;
    a.av localav = paramab.JMV;
    if ((paramab.JNJ & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfay, localav, parame, bool, paramab.groupId, paramab.ADE, paramab.ADF, paramab.JNQ, paramab.JNR, paramab.JNS, (int[])localObject, paramab.JMX, this.KvY);
      if (paramab.JNN != 0)
      {
        com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramab.JNN });
        KvM = paramab.JNN * 1000;
      }
      fIr();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc) });
      AppMethodBeat.o(192761);
      return;
    }
  }
  
  private void a(int paramInt, a.aj paramaj)
  {
    AppMethodBeat.i(192760);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.Kwo.iE(null);
      AppMethodBeat.o(192760);
      return;
    }
    paramaj = paramaj.JOc;
    if ((paramaj == null) || (paramaj.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(192760);
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
        a(localObject.groupId, null, 0, localObject.ADE, localObject.ADF, localObject.JNG, null, null, false, false);
        localArrayList.add(c.fIe().aUi(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.Kwo.iE(localArrayList);
    AppMethodBeat.o(192760);
  }
  
  /* Error */
  private void a(final int paramInt1, final a.ay[] paramArrayOfay, final a.av paramav, final byte[] paramArrayOfByte1, final boolean paramBoolean, final String paramString, final int paramInt2, final long paramLong, int paramInt3, final int paramInt4, final byte[] paramArrayOfByte2, final int[] paramArrayOfInt, final int paramInt5, final int paramInt6)
  {
    // Byte code:
    //   0: ldc_w 805
    //   3: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 327
    //   9: bipush 6
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 807
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: aload 6
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: iload 7
    //   36: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_4
    //   42: lload 8
    //   44: invokestatic 619	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_5
    //   50: aload_0
    //   51: getfield 190	com/tencent/wecall/talkroom/model/f:state	I
    //   54: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 372	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 439	com/tencent/wecall/talkroom/model/f:Kwh	Lcom/tencent/wecall/talkroom/model/b;
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
    //   91: invokespecial 810	com/tencent/wecall/talkroom/model/f:a	([Lcom/tencent/pb/common/b/a/a/a$ay;Lcom/tencent/pb/common/b/a/a/a$av;[BZIJII[B[III)Z
    //   94: istore 16
    //   96: ldc_w 327
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 812
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: iload 16
    //   113: invokestatic 406	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: aastore
    //   117: invokestatic 411	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: iload 16
    //   122: ifeq +39 -> 161
    //   125: ldc_w 805
    //   128: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: astore 17
    //   134: iconst_0
    //   135: istore 16
    //   137: ldc_w 327
    //   140: iconst_2
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: ldc_w 814
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload 17
    //   154: aastore
    //   155: invokestatic 411	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: goto -38 -> 120
    //   161: iload_1
    //   162: ifgt +61 -> 223
    //   165: aload_0
    //   166: getfield 235	com/tencent/wecall/talkroom/model/f:Kwg	Lcom/tencent/wecall/talkroom/model/h;
    //   169: sipush 202
    //   172: invokevirtual 674	com/tencent/wecall/talkroom/model/h:afW	(I)V
    //   175: ldc_w 327
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc_w 816
    //   187: aastore
    //   188: invokestatic 411	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: aload 6
    //   194: iload 7
    //   196: lload 8
    //   198: bipush 102
    //   200: iconst_1
    //   201: invokevirtual 694	com/tencent/wecall/talkroom/model/f:a	(Ljava/lang/String;IJIZ)Z
    //   204: pop
    //   205: aload_0
    //   206: getfield 253	com/tencent/wecall/talkroom/model/f:Kwo	Lcom/tencent/wecall/talkroom/model/g;
    //   209: sipush -400
    //   212: aconst_null
    //   213: invokevirtual 653	com/tencent/wecall/talkroom/model/g:n	(ILjava/lang/Object;)V
    //   216: ldc_w 805
    //   219: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: return
    //   223: aload_0
    //   224: getfield 342	com/tencent/wecall/talkroom/model/f:mHandler	Landroid/os/Handler;
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
    //   257: invokespecial 819	com/tencent/wecall/talkroom/model/f$4:<init>	(Lcom/tencent/wecall/talkroom/model/f;I[Lcom/tencent/pb/common/b/a/a/a$ay;Lcom/tencent/pb/common/b/a/a/a$av;[BZLjava/lang/String;IJII[B[III)V
    //   260: ldc2_w 820
    //   263: invokevirtual 825	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   266: pop
    //   267: ldc_w 805
    //   270: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    JLT = parame;
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
    if (!afQ(paramInt3)) {
      this.Kwg.fIF();
    }
    this.Kwg.fIE();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.Kwh.fIb(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.fBC().a(paramString1);
    c(paramString1);
    AppMethodBeat.o(62731);
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.tOL = paramInt;
    this.AMc = paramLong;
    this.tmu = paramString2;
    this.KvQ = paramString1;
    this.KvP = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62754);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(62754);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(192764);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(192764);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfay.length;
    int i = 0;
    while (i < j)
    {
      a.ay localay = paramArrayOfay[i];
      if (localay != null) {
        localStringBuffer.append(" memberId:" + localay.osF + " uuid: " + localay.dhV + " status: " + localay.status + "   mem.inviteTime:" + localay.JOX + "  mem.reason: " + localay.reason + "  mem.inviteuuid: " + localay.JPj + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfay.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(192764);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz, a.aw paramaw, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192762);
    a(paramString1, paramInt2, paramLong, paramArrayOfay);
    c localc = c.fIe();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.tmu == null) || (!this.tmu.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramaw, paramArrayOfay, paramArrayOfaz, paramBoolean1, bool);
      paramString2 = this.tmu;
      i = this.tOL;
      l = this.AMc;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfay == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfay.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.KvV) });
      if (c.fIe().dd(this.tmu, false))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.KvV), " mGroupId: ", this.tmu, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.KvV)
        {
          this.KvV = false;
          this.uaf = true;
          this.Kwq = k.fIJ();
          this.KvT = this.KvR;
          fIw();
        }
      }
      if (paramArrayOfay != null) {
        break label380;
      }
      AppMethodBeat.o(192762);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfay.length > 0) && (this.Kwh != null)) {
      a(paramArrayOfay);
    }
    AppMethodBeat.o(192762);
  }
  
  private void a(a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(192763);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(192763);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfay.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfay.length)
    {
      arrayOfInt[i] = paramArrayOfay[i].osF;
      localStringBuffer.append(paramArrayOfay[i].osF);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.Kwh == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(192763);
      return;
    }
    this.Kwh.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(192763);
  }
  
  private void a(a.p[] paramArrayOfp1, a.p[] paramArrayOfp2, int paramInt)
  {
    AppMethodBeat.i(192765);
    if (paramArrayOfp1 == null) {}
    for (int i = 0;; i = paramArrayOfp1.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfp1 != null) && (paramArrayOfp1.length > 0)) {
        break;
      }
      AppMethodBeat.o(192765);
      return;
    }
    this.Kwy = new String[paramArrayOfp1.length];
    this.Kwx = new short[paramArrayOfp1.length];
    this.KwA = new String[paramArrayOfp2.length];
    this.Kwz = new short[paramArrayOfp2.length];
    this.KwB = paramInt;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.KwB) });
    int j = paramArrayOfp1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.p localp = paramArrayOfp1[paramInt];
      this.Kwy[i] = localp.JMR;
      this.Kwx[i] = ((short)localp.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData ip: ", localp.JMR, " addr.port: ", Integer.valueOf(localp.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfp2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfp1 = paramArrayOfp2[paramInt];
      this.KwA[i] = paramArrayOfp1.JMR;
      this.Kwz[i] = ((short)paramArrayOfp1.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", paramArrayOfp1.JMR, " tcpAddr.port: ", Integer.valueOf(paramArrayOfp1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.Kwy), Arrays.toString(this.Kwx), this.tmu, this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc), Arrays.toString(this.KwA), Arrays.toString(this.Kwz), Integer.valueOf(this.KwB) });
    AppMethodBeat.o(192765);
  }
  
  private boolean a(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(192767);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(192767);
      return false;
    }
    this.KvX = paramArrayOfInt[talk.uWL];
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit general policy cnt:", Integer.valueOf(paramArrayOfInt.length), ", redirect type:", this.KvX + " wifigateway:" + paramInt5 });
    paramBoolean = b(paramArrayOfay, paramav, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
    AppMethodBeat.o(192767);
    return paramBoolean;
  }
  
  private static boolean afQ(int paramInt)
  {
    return paramInt != 1;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(62738);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = JLT;
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
      com.tencent.pb.talkroom.sdk.e locale = JLT;
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
      paramBoolean = com.tencent.pb.common.c.f.ml(paramString, this.tmu);
      AppMethodBeat.o(62771);
      return paramBoolean;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.tmu, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.tOL), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.AMc) });
    if ((com.tencent.pb.common.c.f.ml(paramString, this.tmu)) && (paramInt == this.tOL) && (paramLong == this.AMc))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    AppMethodBeat.o(62771);
    return false;
  }
  
  private boolean b(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(192768);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.tmu, " ip: ", Arrays.toString(this.Kwy), " ports: ", Arrays.toString(this.Kwx), " tcpIp: ", Arrays.toString(this.KwA), " tcpPorts: ", Arrays.toString(this.Kwz), " tcpStartTime: ", Integer.valueOf(this.KwB), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.fBV();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfay != null) && (paramArrayOfay.length > 0))
    {
      localObject1 = new int[paramArrayOfay.length];
      j = 0;
      while (j < paramArrayOfay.length)
      {
        localObject1[j] = paramArrayOfay[j].osF;
        if (com.tencent.pb.common.c.f.equals(paramArrayOfay[j].dhV, (String)localObject2)) {
          i = paramArrayOfay[j].osF;
        }
        j += 1;
      }
      paramArrayOfay = (a.ay[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.fIe().aUd(this.tmu);
      this.Kwg.osF = j;
      for (;;)
      {
        try
        {
          localObject2 = this.Kwh;
          locala = this.Kwi;
          localObject3 = c.fIe();
          localObject1 = this.tmu;
          localObject3 = ((c)localObject3).aUb((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.Kwy;
          arrayOfShort1 = this.Kwx;
          arrayOfString = this.KwA;
          arrayOfShort2 = this.Kwz;
          m = this.KwB;
          localObject1 = null;
          if (paramav == null) {
            continue;
          }
          paramav = new i(paramav.JOp, paramav.hCF, paramav.hCG, paramav.JOq, paramav.JOr, paramav.JOs, paramav.JOt, paramav.JOu, paramav.JOv, paramav.JOw, paramav.JOx, paramav.JOy);
          n = k.lf(com.tencent.pb.common.c.c.AMx);
          localObject1 = ((b)localObject2).Kvs;
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
          paramInt1 = ((b)localObject2).Kvs.Open(locala, paramav, i, j, paramInt1, paramLong, (String[])localObject3, arrayOfShort1, 0, paramArrayOfay, paramArrayOfByte1, paramBoolean, n, arrayOfString, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
          continue;
          paramArrayOfay.handler.post(paramav);
          continue;
          AppMethodBeat.o(192768);
          return false;
        }
        paramArrayOfay = this.Kwo;
        paramav = new g.3(paramArrayOfay, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramav.run();
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.afV(-3002);
        }
        if (paramInt1 == 0) {
          this.Kwg.AUE = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(192768);
        return true;
        localObject3 = ((TalkRoom)localObject3).aUa(com.tencent.pb.a.a.a.fBV());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).Kvy;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.ay)localObject3).DKi) });
            i = ((a.ay)localObject3).DKi;
            continue;
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramav = (a.av)localObject1;
          }
        }
      }
      paramArrayOfay = null;
    }
  }
  
  private void bgk()
  {
    AppMethodBeat.i(62767);
    NX();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c()
    {
      public final void aa(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            if ((com.tencent.pb.common.a.a.JLi) && (localb.Kvs != null)) {
              break label140;
            }
          }
          for (;;)
          {
            if (f.this.Kwv)
            {
              f.this.Kwv = false;
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt) });
            }
            AppMethodBeat.o(62659);
            return;
            label140:
            localb.Kvs.SendAudio(paramAnonymousArrayOfByte, s, 0);
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
      this.Kwg.afW(101);
      h.afT(-2001);
      this.Kwo.n(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.Kwg;
    }
    for (localh.KxB &= 0xFFFFFFFE;; localh.KxB |= 0x1)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62767);
      return;
      localh = this.Kwg;
    }
  }
  
  private void c(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62775);
    this.mHandler.removeCallbacks(this.KwG);
    this.KwF = paramd;
    this.mHandler.postDelayed(this.KwG, 3000L);
    AppMethodBeat.o(62775);
  }
  
  private boolean cT(int paramInt, String paramString)
  {
    AppMethodBeat.i(62732);
    if (paramInt == 100)
    {
      AppMethodBeat.o(62732);
      return true;
    }
    if (afQ(paramInt))
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
      boolean bool = aUk(paramString);
      AppMethodBeat.o(62732);
      return bool;
    }
    AppMethodBeat.o(62732);
    return false;
  }
  
  private void ebB()
  {
    AppMethodBeat.i(62741);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "releaseConpent" });
    try
    {
      NX();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          fIq();
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
  
  public static com.tencent.pb.talkroom.sdk.e fIA()
  {
    return JLT;
  }
  
  private void fIm()
  {
    AppMethodBeat.i(192759);
    this.Kwa = -1;
    this.Kwb = -1;
    this.Kwc = -1;
    this.Kwd = -1;
    this.Kwe = -1;
    this.Kwf = -1;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "multitalk voiceMsg local seq reset" });
    AppMethodBeat.o(192759);
  }
  
  private int fIp()
  {
    AppMethodBeat.i(62734);
    if (this.KvU == 0L)
    {
      AppMethodBeat.o(62734);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.KvU) / 1000L);
    AppMethodBeat.o(62734);
    return i;
  }
  
  private boolean fIq()
  {
    AppMethodBeat.i(62737);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = JLT;
      if (locale == null) {
        break label99;
      }
      this.Kwg.AGI = locale.dfx();
      this.Kwg.AGy = locale.dfA();
      bool = locale.dfv();
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
  
  private void fIr()
  {
    AppMethodBeat.i(62759);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.Kwj != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(62759);
      return;
    }
    try
    {
      this.Kwj = new TimerTask()
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
      this.Kwl.schedule(this.Kwj, 0L, KvM);
      AppMethodBeat.o(62759);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(62759);
    }
  }
  
  private void fIs()
  {
    AppMethodBeat.i(62760);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.Kwk != null) {
        this.Kwk.cancel();
      }
      this.Kwk = null;
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
  
  private void fIt()
  {
    AppMethodBeat.i(62761);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.Kwj != null) {
        this.Kwj.cancel();
      }
      this.Kwj = null;
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
  
  private void fIu()
  {
    AppMethodBeat.i(62762);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.Kwm != null) {
        this.Kwm.cancel();
      }
      this.Kwm = null;
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
  
  private void fIv()
  {
    AppMethodBeat.i(62768);
    fIq();
    Object localObject = new AtomicInteger();
    final AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b()
    {
      public final int Z(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            AtomicInteger localAtomicInteger1 = this.KwZ;
            AtomicInteger localAtomicInteger2 = localAtomicInteger;
            if (com.tencent.pb.common.a.a.JLi) {
              if (localb.Kvs == null)
              {
                break label169;
                if ((f.this.Kww) && (i >= 0))
                {
                  f.this.Kww = false;
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt), " ret: ", Integer.valueOf(i) });
                }
                AppMethodBeat.o(62788);
                return i;
              }
              else
              {
                i = localb.Kvs.GetAudioData(paramAnonymousArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
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
      this.Kwg.afW(101);
      h.afT(-2001);
      localObject = this.Kwg;
      ((h)localObject).KxB |= 0x1;
      this.Kwo.n(-500, null);
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62768);
  }
  
  private void fIw()
  {
    AppMethodBeat.i(62769);
    if (this.Kwm != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(62769);
      return;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.KvF, " mIsHoldOn: ", Boolean.valueOf(this.KwC) });
    this.Kwm = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(62661);
        if (!f.this.KwC)
        {
          f.a(f.this, f.n(f.this) + 1);
          if (f.o(f.this)) {
            f.b(f.this, f.p(f.this) + 1);
          }
          if ((f.q(f.this) == 3) || (f.q(f.this) == 2))
          {
            f.c(f.this, f.r(f.this) + 1);
            f.this.Kwg.AUP = f.r(f.this);
          }
          f.this.Kwg.KxF = (f.n(f.this) * 1000);
          f.this.Kwg.AUO = f.n(f.this);
        }
        if (f.this.KvF != null) {
          f.n(f.this);
        }
        AppMethodBeat.o(62661);
      }
    };
    this.Kwn.scheduleAtFixedRate(this.Kwm, 1000L, 1000L);
    AppMethodBeat.o(62769);
  }
  
  private void fIx()
  {
    AppMethodBeat.i(62774);
    this.mHandler.removeCallbacks(this.KwG);
    this.KwF = null;
    AppMethodBeat.o(62774);
  }
  
  private static void fIy()
  {
    AppMethodBeat.i(62777);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.c.AMx.getSystemService("audio");
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
  
  public static boolean fIz()
  {
    AppMethodBeat.i(62778);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.c.AMx.getSystemService("audio")).isSpeakerphoneOn();
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
  
  private boolean gH(String paramString, int paramInt)
  {
    AppMethodBeat.i(62735);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62735);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.JLH);
    boolean bool = com.tencent.pb.common.b.e.fBC().a(localc);
    this.Kwg.ad(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.tOL, this.AMc, true);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62735);
    return bool;
  }
  
  static String[] iF(List<String> paramList)
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
  
  private void r(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62772);
    try
    {
      String str = c.fIe().q(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.AzH), " mTalkDuration: ", Integer.valueOf(this.KvR), " msgKey: ", str });
      AppMethodBeat.o(62772);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(62772);
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f J(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62745);
    com.tencent.pb.talkroom.sdk.f localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject1 = localf;
    if (this.uaf)
    {
      localObject1 = localf;
      if (this.Kwh == null) {}
    }
    try
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo" });
      localObject2 = this.Kwh;
      localObject1 = new com.tencent.pb.talkroom.sdk.f();
      if ((paramArrayOfInt != null) && (((b)localObject2).Kvs != null)) {
        break label176;
      }
      com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", ((b)localObject2).Kvs });
      paramArrayOfInt = (int[])localObject1;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "receiveVideo error: ", paramArrayOfInt });
        paramArrayOfInt = localf;
        continue;
        Object localObject3 = ((TalkRoom)localObject3).fHZ().iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localay = (a.ay)((Iterator)localObject3).next();
        } while ((localay == null) || (localay.osF != i));
        com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getUsrNameByMemberId wxUserName:", localay.dhV, " groupId: ", localObject2, " memberId: ", Integer.valueOf(i) });
        if (localay.dhV == null) {
          break;
        }
        localObject2 = localay.dhV;
        continue;
        int i = paramArrayOfInt.length;
      }
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.uaf), " decInfo: ", paramArrayOfInt, " engine: ", this.Kwh });
    localObject1 = paramArrayOfInt;
    AppMethodBeat.o(62745);
    return localObject1;
    label176:
    ((com.tencent.pb.talkroom.sdk.f)localObject1).ret = ((b)localObject2).Kvs.videoDecode(paramArrayOfInt);
    ((com.tencent.pb.talkroom.sdk.f)localObject1).JPY = paramArrayOfInt;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).JPZ = ((b)localObject2).Kvs.field_remoteImgLength;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).JQa = ((b)localObject2).Kvs.field_remoteImgWidth;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).JQb = ((b)localObject2).Kvs.field_remoteImgHeight;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).JQc = (((b)localObject2).Kvs.field_remoteImgChannel & 0x3FFF);
    localObject3 = c.fIe();
    Object localObject2 = a.fHP().tmu;
    i = ((com.tencent.pb.talkroom.sdk.f)localObject1).JQc;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i) });
    }
    for (;;)
    {
      ((com.tencent.pb.talkroom.sdk.f)localObject1).JPW = ((String)localObject2);
      if (paramArrayOfInt == null)
      {
        i = 0;
        com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "steve:receiveVideo imgBuffer size:", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localObject1 });
        paramArrayOfInt = (int[])localObject1;
        break;
        localObject3 = ((c)localObject3).aUb((String)localObject2);
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId talkRoom is null groupId: ", localObject2, " memberId: ", Integer.valueOf(i) });
          break label556;
        }
      }
      a.ay localay;
      label556:
      localObject2 = "";
    }
  }
  
  public final int a(byte[] paramArrayOfByte, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62743);
    int j = -1;
    int i = j;
    if (this.uaf)
    {
      i = j;
      if (this.Kwh == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localb = this.Kwh;
        if ((paramArrayOfByte != null) && (localb.Kvs != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.Kvs });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.uaf), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.Kwh });
      i = paramInt1;
      AppMethodBeat.o(62743);
      return i;
      paramInt1 = localb.Kvs.SendVideo(paramArrayOfByte, paramShort, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62744);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.uaf) && (this.Kwh != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.Kwh;
        if ((paramArrayOfByte == null) || (localb.Kvs == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.Kvs });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.uaf), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.Kwh });
          AppMethodBeat.o(62744);
          return paramArrayOfByte;
        }
        paramInt1 = localb.Kvs.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.JQd = paramArrayOfInt;
        paramArrayOfByte.JQe = localb.Kvs.field_localImgWidth;
        paramArrayOfByte.JQf = localb.Kvs.field_localImgHeight;
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
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.tOL), Integer.valueOf(paramInt1), Long.valueOf(this.AMc), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    this.KvY = paramInt4;
    if (!com.tencent.pb.a.a.a.fBW())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.fBW()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.fBX()) });
      h.a(paramString1, "", this.tOL, this.AMc, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = b.Kxi;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((afQ(paramInt3)) && (paramInt3 != 100) && (eil()))
    {
      h.a(paramString1, "", this.tOL, this.AMc, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = b.Kxm;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (!cT(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.tOL, this.AMc, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = b.Kxn;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.tOL, this.AMc, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = b.Kxo;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (afQ(paramInt3))
    {
      this.Kwg.reset();
      yP(false);
    }
    fIn();
    if (!ebE())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (afQ(paramInt3))
      {
        h.a(paramString1, "", this.tOL, this.AMc, new String[] { "enter", "req", "false", "initEnginefail" });
        yP(false);
      }
      for (;;)
      {
        paramString1 = b.Kxq;
        AppMethodBeat.o(183718);
        return paramString1;
        this.Kwg.ad(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.tmu = paramString1;
    Object localObject;
    long l;
    label705:
    label711:
    boolean bool;
    if (!afQ(paramInt3))
    {
      localObject = aUj(paramString1);
      if (localObject == null)
      {
        paramInt4 = 0;
        this.tOL = paramInt4;
        if (localObject != null) {
          break label875;
        }
        l = 0L;
        this.AMc = l;
        this.Kws = paramString1;
        this.JLH = paramInt2;
        setState(3);
        if (!afQ(paramInt3)) {
          break label898;
        }
        bool = true;
        label738:
        this.AzH = bool;
        if (this.AzH) {
          this.Kwg.fIC();
        }
        if ((!this.AzH) || (c.fIe().dd(this.tmu, true))) {
          break label904;
        }
        localObject = new c();
        ((c)localObject).groupId = paramString1;
        ((c)localObject).roomId = paramInt1;
        ((c)localObject).tIG = paramLong;
        ((c)localObject).urD = paramInt3;
        ((c)localObject).JMr = paramInt2;
        ((c)localObject).Kxs = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = localObject;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = b.Kxh;
      AppMethodBeat.o(183718);
      return paramString1;
      paramInt4 = ((e)localObject).roomId;
      break;
      label875:
      l = ((e)localObject).tIG;
      break label705;
      this.tOL = paramInt1;
      this.AMc = paramLong;
      break label711;
      label898:
      bool = false;
      break label738;
      label904:
      a(paramString1, this.tOL, this.AMc, paramInt2, paramInt3, paramString2);
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
          h.afS(((Integer)paramString.get(Integer.valueOf(i))).intValue());
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
          if (com.tencent.pb.common.c.f.ml(this.KvQ, paramString.KvQ))
          {
            this.Kwg.afW(301);
            this.Kwg.ad(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            gH(paramString.KvQ, 1001);
            if (!paramString.Kyb) {
              this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.Kwo.n(-100, null);
          }
          AppMethodBeat.o(62742);
          return;
          paramString = "";
        }
        else if (paramd.getType() == 209)
        {
          paramString = (com.tencent.wecall.talkroom.a.g)paramd;
          this.Kwo.gG(paramString.tmu, paramInt2);
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
      if (!b(paramString.tmu, paramString.tOL, paramString.AMc, false)) {
        h.a(paramString.tmu, paramString.tOL, paramString.AMc, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.Kwo.a(paramString.Kya, c.fIe().aUi(paramString.tmu));
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.tmu, paramString.tOL, paramString.AMc, false))
      {
        this.Kwg.ad(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.Kwo.n(-300, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.tmu, paramString.tOL, paramString.AMc, afQ(paramString.Kyc))) && (this.state == 3))
      {
        this.Kwg.afW(302);
        this.Kwo.n(-200, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.Kwo.iE(null);
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 213)
    {
      if (com.tencent.pb.common.c.f.equals(((com.tencent.wecall.talkroom.a.j)paramd).tmu, this.tmu))
      {
        this.Kwg.ad(new String[] { "sendmsg", "resp", "-1", String.valueOf(this.state) });
        this.Kwo.n(-700, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (b(paramString.groupId, paramString.roomId, paramString.tIG, false)) {
        this.Kwg.ad(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (m)paramd;
      if (b(paramString.tmu, paramString.tOL, paramString.AMc, false)) {
        this.Kwo.n(-800, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      if (b(paramString.tmu, paramString.tOL, paramString.AMc, false)) {
        this.Kwo.n(-1600, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 801)
    {
      paramString = (com.tencent.wecall.talkroom.a.k)paramd;
      if (b(paramString.tmu, paramString.tOL, paramString.AMc, false)) {
        this.Kwo.n(-1601, null);
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
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).JLF != null))
      {
        paramString = (a.aa)((com.tencent.pb.common.b.d)localObject1).JLF;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).KvQ });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).Kyb) {
          break label3210;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.afS(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          KvG = null;
          if (paramInt2 == 0) {
            break label3477;
          }
          if (com.tencent.pb.common.c.f.ml(this.KvQ, ((com.tencent.wecall.talkroom.a.d)localObject1).KvQ)) {
            break label3216;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.KvQ, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).KvQ, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1459:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.JLF != null)) {
        a(paramInt2, (a.ab)paramString.JLF, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.JLF != null))
      {
        localObject1 = (a.y)paramString.JLF;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303), Integer.valueOf(14651), Integer.valueOf(-1309) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.afS(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label4486;
        }
        if (b(paramString.tmu, paramString.tOL, paramString.AMc, false))
        {
          this.Kwg.ad(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (paramInt2 != 14651) {
            break label4472;
          }
          com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14651), ((a.y)localObject1).groupId, Integer.valueOf(((a.y)localObject1).ADE), Long.valueOf(((a.y)localObject1).ADF) });
          this.Kwo.n(-301, localObject1);
        }
      }
    }
    label1850:
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.JLF != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ac)paramString.JLF).groupId, this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.a.M(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.afS(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (n)paramd;
      if ((paramString != null) && (paramString.JLF != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.am)paramString.JLF).groupId, this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        fIs();
        i = 0;
        if (paramInt2 != 14800) {
          break label4703;
        }
        i = -1401;
        label2210:
        if (i != 0)
        {
          this.Kwg.afW(324);
          h.afS(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.JLF != null))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.tmu, " roomid: ", Integer.valueOf(paramString.tOL), " roomKey: ", Long.valueOf(paramString.AMc) });
        if (paramInt2 != 18950) {
          break label4718;
        }
        if (!b(paramString.tmu, paramString.tOL, paramString.AMc, false)) {
          h.a(paramString.tmu, paramString.tOL, paramString.AMc, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.fIe().aUi(paramString.tmu);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.tmu, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.Kwo.a(paramString.Kya, (MultiTalkGroup)localObject1);
        }
      }
    }
    label2468:
    if (paramd.getType() == 207)
    {
      paramString = (com.tencent.wecall.talkroom.a.i)paramd;
      if ((paramString != null) && (paramString.JLF != null))
      {
        if (paramInt2 == 18100) {
          h.afS(-1501);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 208)
    {
      paramString = (com.tencent.wecall.talkroom.a.c)paramd;
      if ((paramString != null) && (paramString.JLF != null))
      {
        if (paramInt2 == 18300) {
          h.afS(-1531);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 209)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).JLF != null))
      {
        paramString = (a.ad)((com.tencent.pb.common.b.d)localObject1).JLF;
        if (paramInt2 == 17900) {
          h.afS(-1511);
        }
        if (paramInt2 == 0) {
          break label5124;
        }
        this.Kwo.gG(((com.tencent.wecall.talkroom.a.g)localObject1).tmu, paramInt2);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 210)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 == 19100) {
        h.afS(-1541);
      }
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (paramString != null) {
        a(paramInt1, paramInt2, paramd.JLF, paramString);
      }
    }
    if (paramd.getType() == 212) {
      a(paramInt2, (a.aj)paramd.JLF);
    }
    if (paramd.getType() == 213)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break label5223;
      }
      if (com.tencent.pb.common.c.f.equals(paramString.tmu, this.tmu))
      {
        this.Kwg.ad(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.Kwo.n(-700, null);
      }
    }
    label2909:
    if (paramd.getType() == 214)
    {
      paramString = (a.ah)paramd.JLF;
      localObject1 = (m)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (!b(((m)localObject1).tmu, ((m)localObject1).tOL, ((m)localObject1).AMc, false)) {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((m)localObject1).tmu, Integer.valueOf(((m)localObject1).tOL) });
      }
    }
    else if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
      if (b(paramString.tmu, paramString.tOL, paramString.AMc, false)) {
        break label5624;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.tmu, Integer.valueOf(paramString.tOL) });
    }
    label3210:
    label3216:
    label3475:
    label3477:
    label4660:
    for (;;)
    {
      label3017:
      if (paramd.getType() == 801)
      {
        paramString = (com.tencent.wecall.talkroom.a.k)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo errCode: ", Integer.valueOf(paramInt2) });
        if (!b(paramString.tmu, paramString.tOL, paramString.AMc, false))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo isCurrentRoom is not same", paramString.tmu, Integer.valueOf(paramString.tOL) });
          AppMethodBeat.o(62742);
          return;
          i = 0;
          break;
          if (paramInt2 != -1)
          {
            this.Kwg.afW(321);
            this.Kwg.ad(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          if (this.state != 1)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).KvQ });
            if (i == 0) {
              break label1459;
            }
            this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          a(this.tmu, this.tOL, this.AMc, true);
          if (paramInt2 == 14051) {
            this.Kwo.n(-900, null);
          }
          for (;;)
          {
            if (i == 0) {
              break label3475;
            }
            this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break;
            if (paramInt2 == 14052) {
              this.Kwo.n(-1100, null);
            } else if (paramInt2 == 14053) {
              this.Kwo.n(-1300, paramString);
            } else if (paramInt2 == 14504) {
              this.Kwo.n(-1400, null);
            } else {
              this.Kwo.n(-100, null);
            }
          }
          break label1459;
          if (!com.tencent.pb.common.c.f.ml(this.KvQ, paramString.JMm))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.KvQ, " resp.clientGroupId: ", paramString.JMm, Integer.valueOf(paramString.ADE), Long.valueOf(paramString.ADF) });
            a(paramString.groupId, paramString.ADE, paramString.ADF, 110, false);
            if (i == 0) {
              break label1459;
            }
            this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          this.Kwg.ad(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (this.state != 1)
          {
            h.afS(-1003);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.JMm, Integer.valueOf(paramString.ADE), Long.valueOf(paramString.ADF) });
            if (i == 0) {
              break label1459;
            }
            this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          if ((paramString.JNH == null) || (paramString.JNH.length == 0))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.JMm, Integer.valueOf(paramString.ADE), Long.valueOf(paramString.ADF) });
            h.afS(-1605);
            this.Kwg.AUB = 329;
            a(paramString.groupId, paramString.ADE, paramString.ADF, 116, true);
            if (i != 0) {
              this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.Kwo.n(-100, null);
            break label1459;
          }
          a(paramString.JMm, paramString.ADE, paramString.ADF, paramString.groupId, paramString.JMo.JOI);
          this.Kws = paramString.groupId;
          this.JLH = paramString.JMr;
          setState(4);
          a(paramString.JNH, paramString.JNO, paramString.JNP);
          a(paramString.groupId, paramString.JMm, paramString.JMr, paramString.ADE, paramString.ADF, paramString.JMU, paramString.JNI, paramString.JMo, false, true);
          if (this.Kwo != null)
          {
            localObject1 = this.Kwo;
            localObject2 = new g.7((g)localObject1, c.fIe().aUi(paramString.groupId));
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label4042;
            }
            ((Runnable)localObject2).run();
          }
          for (;;)
          {
            localObject1 = new byte[paramString.JNK.length];
            j = 0;
            while (j < paramString.JNK.length)
            {
              localObject1[j] = ((byte)paramString.JNK[j]);
              j += 1;
            }
            label4042:
            ((g)localObject1).handler.post((Runnable)localObject2);
          }
          localObject2 = new int[paramString.JNT.length];
          int j = 0;
          while (j < paramString.JNT.length)
          {
            localObject2[j] = paramString.JNT[j];
            j += 1;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(paramString.JNT.length), " redirect type:", Integer.valueOf(localObject2[talk.uWL]), " SimpleRedirect value:", Integer.valueOf(talk.uWL) });
          a.ay[] arrayOfay = paramString.JMU;
          a.av localav = paramString.JMV;
          if ((paramString.JNJ & 0x2) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            a(0, arrayOfay, localav, (byte[])localObject1, bool, paramString.groupId, paramString.ADE, paramString.ADF, paramString.JNQ, paramString.JNR, paramString.JNS, (int[])localObject2, paramString.JMX, this.KvY);
            if (paramString.JNN != 0)
            {
              com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.JNN });
              KvM = paramString.JNN * 1000;
            }
            fIr();
            r(paramString.groupId, paramString.ADE, paramString.ADF);
            if (i != 0)
            {
              localObject1 = new HashMap();
              ((Map)localObject1).put("result", Boolean.TRUE);
              ((Map)localObject1).put("shareUrl", new String(paramString.JMo.JOC, Charset.forName("utf-8")));
              ((Map)localObject1).put("smsShortUrl", new String(paramString.JMo.JOD, Charset.forName("utf-8")));
              ((Map)localObject1).put("groupId", paramString.groupId);
              this.Kuh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc) });
            break;
          }
          label4472:
          this.Kwo.n(-300, null);
          break label1850;
          if (((a.y)localObject1).JNG == null)
          {
            i = 0;
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
            if (b(((a.y)localObject1).groupId, ((a.y)localObject1).ADE, ((a.y)localObject1).ADF, false)) {
              break label4660;
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.y)localObject1).groupId, this.tmu, " resp.roomid: ", Integer.valueOf(((a.y)localObject1).ADE), Integer.valueOf(this.tOL) });
            h.afS(-1308);
          }
          for (;;)
          {
            a(((a.y)localObject1).groupId, null, this.JLH, ((a.y)localObject1).ADE, ((a.y)localObject1).ADF, ((a.y)localObject1).JNG, null, ((a.y)localObject1).JMo, true, true);
            break;
            i = ((a.y)localObject1).JNG.length;
            break label4497;
            this.Kwg.ad(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          label4703:
          if (paramInt2 != 14801) {
            break label2210;
          }
          i = -1402;
          break label2210;
          label4718:
          if (paramInt2 == 0) {
            this.KvN = true;
          }
          if (!eil())
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.tmu });
            this.Kwg.reset();
            yP(false);
            this.Kwg.ad(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
            this.AzH = false;
            this.tmu = paramString.tmu;
            this.Kws = this.tmu;
            this.tOL = paramString.tOL;
            this.AMc = paramString.AMc;
            this.JLH = paramString.JLH;
            setState(2);
            this.KvU = System.currentTimeMillis();
            localObject1 = this.Kwg;
            com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "beginNotifyTime" });
            ((h)localObject1).KxQ = System.currentTimeMillis();
            if (paramInt2 == 18900) {
              h.afS(-1521);
            }
          }
          while (!com.tencent.pb.common.c.f.equals(paramString.tmu, this.tmu))
          {
            localObject1 = new e();
            ((e)localObject1).groupId = paramString.tmu;
            ((e)localObject1).roomId = paramString.tOL;
            ((e)localObject1).tIG = paramString.AMc;
            this.KvH.put(paramString.tmu, localObject1);
            localObject1 = c.fIe().aUi(paramString.tmu);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.tmu, " multiTalkGroup: ", localObject1 });
            if (localObject1 == null) {
              break label5102;
            }
            paramString = this.Kwo;
            localObject1 = new g.22(paramString, (MultiTalkGroup)localObject1);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label5089;
            }
            ((Runnable)localObject1).run();
            break;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.tmu });
          break label2468;
          label5089:
          paramString.handler.post((Runnable)localObject1);
          break label2468;
          label5102:
          a(paramString.tmu, paramString.tOL, paramString.AMc, false, false, false);
          break label2468;
          localObject1 = c.fIe().aUb(paramString.groupId);
          if (localObject1 != null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
            a(paramString.groupId, null, ((TalkRoom)localObject1).fHS(), TalkRoom.fHT(), TalkRoom.ejM(), null, null, paramString.JMo, true, false);
          }
          for (;;)
          {
            this.Kwo.gG(paramString.groupId, 0);
            break;
            a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.JMo, true, false);
          }
          label5223:
          if (!com.tencent.pb.common.c.f.equals(paramString.tmu, this.tmu)) {
            break label2909;
          }
          this.Kwg.ad(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          paramString = this.Kwo;
          localObject1 = new g.20(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label2909;
          }
          paramString.handler.post((Runnable)localObject1);
          break label2909;
          if (this.Kwh != null)
          {
            localObject1 = new int[6];
            localObject1[0] = paramString.EFp;
            localObject1[1] = paramString.JNV;
            localObject1[2] = paramString.JNW;
            localObject1[3] = paramString.JNX;
            localObject1[4] = paramString.JNY;
            localObject1[5] = paramString.JNZ;
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject1[2]), Integer.valueOf(localObject1[3]), Integer.valueOf(localObject1[4]), Integer.valueOf(localObject1[5]) });
            localObject2 = this.Kwh;
            if (((b)localObject2).Kvs != null) {
              break label5554;
            }
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject1, ", engine:", ((b)localObject2).Kvs });
          }
          for (;;)
          {
            if (paramInt2 == 0)
            {
              localObject1 = this.Kwo;
              paramString = new g.16((g)localObject1, paramString.EFp);
              if (Looper.myLooper() == Looper.getMainLooper())
              {
                paramString.run();
                break;
                ((b)localObject2).Kvs.setMVSvrCfg((int[])localObject1, 6);
                continue;
              }
              ((g)localObject1).handler.post(paramString);
              break;
            }
          }
          if (paramInt2 == 24301)
          {
            this.Kwo.n(-1700, Integer.valueOf(paramString.JOb));
            break label3017;
          }
          this.Kwo.n(-800, null);
          break label3017;
          label5624:
          if (paramInt2 == 0)
          {
            paramString = this.Kwo;
            localObject1 = new g.17(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              continue;
            }
            paramString.handler.post((Runnable)localObject1);
            continue;
          }
          this.Kwo.n(-1600, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.Kwo;
          paramd = new g.18(paramString);
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
        this.Kwo.n(-1601, null);
      }
    }
    label4486:
    label4497:
    label5554:
    AppMethodBeat.o(62742);
    label5124:
  }
  
  public final void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(62755);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.tmu, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.tOL), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.AMc) });
    c.fIe().aUc(paramString);
    if (paramBoolean1) {
      r(paramString, paramInt, paramLong);
    }
    this.KvH.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      yP(true);
      this.Kwo.de(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.fIe().aUi(paramString);
      if (paramString != null) {
        this.Kwo.f(paramString);
      }
    }
    AppMethodBeat.o(62755);
  }
  
  public final boolean a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62733);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.tmu, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
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
        fIp();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.fBC().a(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.Kwg.ad(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
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
    boolean bool = com.tencent.pb.common.b.e.fBC().a(localf);
    this.Kwg.ad(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62736);
    return bool;
  }
  
  public final e aUj(String paramString)
  {
    AppMethodBeat.i(62757);
    paramString = (e)this.KvH.get(paramString);
    AppMethodBeat.o(62757);
    return paramString;
  }
  
  public final boolean aUk(String paramString)
  {
    AppMethodBeat.i(62758);
    if ((e)this.KvH.get(paramString) != null)
    {
      AppMethodBeat.o(62758);
      return true;
    }
    AppMethodBeat.o(62758);
    return false;
  }
  
  public final boolean aW(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62773);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62773);
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100)) {
      this.Kwg.fID();
    }
    int i = this.tOL;
    long l = this.AMc;
    int j = a.fHP().state;
    if (j.aUp(paramString))
    {
      this.Kwg.afW(327);
      bool = a.fHP().gH(paramString, 1000);
      AppMethodBeat.o(62773);
      return bool;
    }
    if (j == 2)
    {
      bool = a.fHP().a(paramString, i, l, paramInt1);
      AppMethodBeat.o(62773);
      return bool;
    }
    com.tencent.pb.common.c.a.L(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.fHP().a(paramString, i, l, paramInt2, true);
    AppMethodBeat.o(62773);
    return bool;
  }
  
  public final int cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62753);
    long l;
    int n;
    label338:
    label382:
    int i1;
    try
    {
      paramArrayOfByte = (a.q)com.google.b.a.e.a(new a.q(), paramArrayOfByte, paramArrayOfByte.length);
      if (paramArrayOfByte == null) {
        if ((!TextUtils.isEmpty(this.tmu)) || (!TextUtils.isEmpty(this.KvQ)))
        {
          this.Kwg.ad(new String[] { "notify", "pasrefail" });
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
        h.afS(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.tOL, this.AMc, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange ", this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc), Long.valueOf(paramArrayOfByte.msgId), Integer.valueOf(paramArrayOfByte.JMS), Integer.valueOf(paramArrayOfByte.hTM) });
      l = paramArrayOfByte.msgId;
      if (this.Kwt.contains(Long.valueOf(l)))
      {
        n = 1;
        if (n == 0) {
          break label382;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error" });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false)) {
          break label338;
        }
        this.Kwg.ad(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.JMS) });
      }
      for (;;)
      {
        AppMethodBeat.o(62753);
        return -3;
        this.Kwt.add(Long.valueOf(l));
        n = 0;
        break;
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.JMS) });
      }
      n = paramArrayOfByte.JMS;
      i1 = paramArrayOfByte.hTM;
      switch (n)
      {
      default: 
        com.tencent.pb.common.c.b.w("unknow voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1) });
        n = 0;
      }
    }
    if (n != 0)
    {
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false)) {
        this.Kwg.ad(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.JMS) });
      }
      if (paramArrayOfByte.JMS != 2) {
        break label1115;
      }
      a(paramArrayOfByte.groupId, null, paramArrayOfByte.JMr, paramArrayOfByte.ADE, paramArrayOfByte.ADF, paramArrayOfByte.JMU, paramArrayOfByte.JMT, paramArrayOfByte.JMo, true, true);
    }
    for (;;)
    {
      AppMethodBeat.o(62753);
      return 0;
      if (i1 <= this.Kwa)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Kwa) });
        n = 0;
        break;
      }
      this.Kwa = i1;
      for (;;)
      {
        com.tencent.pb.common.c.b.w("voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1), " update local seq" });
        n = 1;
        break;
        if (i1 <= this.Kwb)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Kwa) });
          n = 0;
          break;
        }
        this.Kwb = i1;
        continue;
        if (i1 <= this.Kwc)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Kwa) });
          n = 0;
          break;
        }
        this.Kwc = i1;
        continue;
        if (i1 <= this.Kwd)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Kwa) });
          n = 0;
          break;
        }
        this.Kwd = i1;
        continue;
        if (i1 <= this.Kwe)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Kwa) });
          n = 0;
          break;
        }
        this.Kwe = i1;
        continue;
        if (i1 <= this.Kwf)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.Kwa) });
          n = 0;
          break;
        }
        this.Kwf = i1;
      }
      label1115:
      Object localObject1;
      if (paramArrayOfByte.JMS == 4)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.JMr, paramArrayOfByte.ADE, paramArrayOfByte.ADF, paramArrayOfByte.JMU, paramArrayOfByte.JMT, paramArrayOfByte.JMo, true, true);
        if ((paramArrayOfByte.JMW != 0) || (paramArrayOfByte.JMX != 0))
        {
          localObject1 = this.Kwh;
          n = paramArrayOfByte.JMW;
          i1 = paramArrayOfByte.JMX;
          if ((com.tencent.pb.common.a.a.JLi) && (((b)localObject1).Kvs != null)) {
            ((b)localObject1).Kvs.SetAVEncryptType(n, i1);
          }
        }
      }
      else if (paramArrayOfByte.JMS == 16)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.JMr, paramArrayOfByte.ADE, paramArrayOfByte.ADF, paramArrayOfByte.JMU, paramArrayOfByte.JMT, paramArrayOfByte.JMo, true, false);
      }
      else if (paramArrayOfByte.JMS == 1)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.ADE), " roomkey: ", Long.valueOf(paramArrayOfByte.ADF) });
        if (com.tencent.pb.a.a.a.fBW())
        {
          com.tencent.pb.a.a.a.fBX();
          if ((eil()) && (com.tencent.pb.common.c.f.equals(paramArrayOfByte.groupId, this.tmu))) {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.tmu });
          }
        }
        else
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
          continue;
        }
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.JMr, paramArrayOfByte.ADE, paramArrayOfByte.ADF, paramArrayOfByte.JMU, paramArrayOfByte.JMT, paramArrayOfByte.JMo, false, true);
        localObject1 = paramArrayOfByte.groupId;
        n = paramArrayOfByte.ADE;
        l = paramArrayOfByte.ADF;
        i1 = paramArrayOfByte.JMr;
        int i2 = paramArrayOfByte.JMY;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
        }
        for (;;)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
          break;
          paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, n, l, i1, i2);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i2), Boolean.valueOf(com.tencent.pb.common.b.e.fBC().a(paramArrayOfByte)) });
        }
      }
      else if (paramArrayOfByte.JMS == 8)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.tmu });
        if (b(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false))
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.JMr, paramArrayOfByte.ADE, paramArrayOfByte.ADF, paramArrayOfByte.JMU, paramArrayOfByte.JMT, paramArrayOfByte.JMo, true, false);
          a(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false, false, true);
        }
        else
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.JMr, paramArrayOfByte.ADE, paramArrayOfByte.ADF, paramArrayOfByte.JMU, paramArrayOfByte.JMT, paramArrayOfByte.JMo, true, false);
        }
      }
      else
      {
        String str;
        if (paramArrayOfByte.JMS == 128)
        {
          localObject1 = paramArrayOfByte.groupId;
          str = this.tmu;
          if (paramArrayOfByte.JMZ == null) {}
          for (n = 0;; n = paramArrayOfByte.JMZ.length)
          {
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(n) });
            localObject1 = this.Kwo;
            paramArrayOfByte = new g.19((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.JMZ);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label1885;
            }
            paramArrayOfByte.run();
            break;
          }
          label1885:
          ((g)localObject1).handler.post(paramArrayOfByte);
        }
        else
        {
          Object localObject2;
          if (paramArrayOfByte.JMS == 256)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false)) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
            } else if (paramArrayOfByte.JMZ == null) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
            } else {
              try
              {
                localObject1 = paramArrayOfByte.JMZ;
                localObject1 = (a.s)com.google.b.a.e.a(new a.s(), (byte[])localObject1, localObject1.length);
                if ((localObject1 == null) || (((a.s)localObject1).JNd == null)) {
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
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
                localObject2 = ((a.s)localObject2).JNd;
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
                com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.tmu, " roomId: ", Integer.valueOf(this.tOL), " videoUserNames: ", paramArrayOfByte });
                localObject2 = this.Kwo;
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
          else if (paramArrayOfByte.JMS == 1024)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false))
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
            }
            else if ((this.state != 3) && (this.state != 4))
            {
              a(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, 1);
              this.Kwo.n(-1400, null);
            }
          }
          else if (paramArrayOfByte.JMS == 512)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false)) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
            } else if (paramArrayOfByte.JMZ == null) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
            } else {
              try
              {
                localObject2 = paramArrayOfByte.JMZ;
                localObject2 = (a.r)com.google.b.a.e.a(new a.r(), (byte[])localObject2, localObject2.length);
                if (localObject2 == null) {
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
                }
              }
              catch (com.google.b.a.d locald2)
              {
                for (;;)
                {
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                  local1 = null;
                }
                paramArrayOfByte = this.Kwo;
                g.1 local1 = new g.1(paramArrayOfByte, local1.JNc);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  local1.run();
                  continue;
                }
                paramArrayOfByte.handler.post(local1);
              }
            }
          }
          else if (paramArrayOfByte.JMS == 2048) {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.ADE, paramArrayOfByte.ADF, false))
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAudioStreamChange is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.ADE) });
            }
            else
            {
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleAudioStreamChange audio_stream_type", Integer.valueOf(paramArrayOfByte.audioStreamType) });
              int i = (byte)(paramArrayOfByte.audioStreamType & 0xFF);
              int j = (byte)(paramArrayOfByte.audioStreamType >> 8 & 0xFF);
              int k = (byte)(paramArrayOfByte.audioStreamType >> 16 & 0xFF);
              int m = (byte)(paramArrayOfByte.audioStreamType >> 24 & 0xFF);
              this.Kwh.Kvs.setAppCmd(306, new byte[] { i, j, k, m }, 4);
            }
          }
        }
      }
    }
  }
  
  final boolean ebE()
  {
    AppMethodBeat.i(62765);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initEngine", this.tmu, Integer.valueOf(this.tOL), Long.valueOf(this.AMc), Integer.valueOf(this.state) });
    try
    {
      localb = this.Kwh;
      boolean bool = com.tencent.pb.common.a.a.JLi;
      if (bool) {
        break label131;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b localb;
        label131:
        String str;
        com.tencent.pb.talkroom.sdk.e locale;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine", localException });
        i = -99999;
        continue;
        i = localException.Kvs.field_capInfo.length;
      }
      AppMethodBeat.o(62765);
      return true;
    }
    if (i < 0)
    {
      h.afV(-3001);
      this.Kwg.afW(201);
      this.Kwh = null;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(62765);
      return false;
      str = com.tencent.pb.common.c.c.AMx.getDir("lib", 0).getAbsolutePath();
      locale = JLT;
      if (locale == null) {
        break label369;
      }
    }
    label369:
    for (int i = locale.XE();; i = 0)
    {
      int j = k.lf(com.tencent.pb.common.c.c.AMx);
      com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(j), " cpuFlag:", Integer.valueOf(i), "libPath:", str });
      if (localb.Kvs == null)
      {
        i = -1;
        break;
      }
      j = localb.Kvs.init(j, i, str + "/");
      if (localb.Kvs.field_capInfo == null)
      {
        i = 0;
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit", Integer.valueOf(j), "field_capInfo length: ", Integer.valueOf(i) });
        i = j;
        break;
      }
    }
  }
  
  public final boolean eil()
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
  
  final boolean fIn()
  {
    AppMethodBeat.i(62724);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = JLT;
    if (locale != null) {
      locale.dft();
    }
    this.Kwh = new b();
    this.Kws = this.tmu;
    fIm();
    this.Kwi = new talk.a()
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
          f.this.Kwg.KxC = 1;
          localh = f.this.Kwg;
          if (localh.KxP != 0L) {
            break label121;
          }
        }
        label121:
        for (localh.KxD = 0L;; localh.KxD = (System.currentTimeMillis() - localh.KxP))
        {
          com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.KxP), Long.valueOf(localh.KxD) });
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
        //   9: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   12: getfield 77	com/tencent/wecall/talkroom/model/f:Kwg	Lcom/tencent/wecall/talkroom/model/h;
        //   15: iconst_1
        //   16: putfield 124	com/tencent/wecall/talkroom/model/h:tJT	I
        //   19: ldc 59
        //   21: iconst_1
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 126
        //   29: aastore
        //   30: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   33: aload_0
        //   34: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
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
        //   58: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   61: invokestatic 128	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   64: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   67: aastore
        //   68: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   71: ldc 121
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aload_0
        //   78: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   81: astore 6
        //   83: invokestatic 136	com/tencent/wecall/talkroom/model/c:fIe	()Lcom/tencent/wecall/talkroom/model/c;
        //   86: astore 4
        //   88: aload_0
        //   89: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
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
        //   117: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   120: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   123: ifnull +30 -> 153
        //   126: aload_0
        //   127: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   130: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   133: astore 4
        //   135: invokestatic 156	com/tencent/wecall/talkroom/model/f:fIz	()Z
        //   138: istore_3
        //   139: getstatic 162	com/tencent/pb/common/a/a:JLi	Z
        //   142: ifeq +11 -> 153
        //   145: aload 4
        //   147: getfield 168	com/tencent/wecall/talkroom/model/b:Kvs	Lcom/tencent/mm/plugin/multi/talk;
        //   150: ifnonnull +431 -> 581
        //   153: aload_0
        //   154: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   157: invokestatic 171	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
        //   160: pop
        //   161: aload_0
        //   162: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   165: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   168: pop
        //   169: invokestatic 175	com/tencent/wecall/talkroom/model/f:fIA	()Lcom/tencent/pb/talkroom/sdk/e;
        //   172: astore 4
        //   174: aload 4
        //   176: ifnull +11 -> 187
        //   179: aload 4
        //   181: invokeinterface 181 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   191: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   194: getfield 168	com/tencent/wecall/talkroom/model/b:Kvs	Lcom/tencent/mm/plugin/multi/talk;
        //   197: astore 6
        //   199: getstatic 162	com/tencent/pb/common/a/a:JLi	Z
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
        //   308: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   311: getfield 77	com/tencent/wecall/talkroom/model/f:Kwg	Lcom/tencent/wecall/talkroom/model/h;
        //   314: astore 4
        //   316: aload 4
        //   318: getfield 87	com/tencent/wecall/talkroom/model/h:KxP	J
        //   321: lconst_0
        //   322: lcmp
        //   323: ifne +317 -> 640
        //   326: aload 4
        //   328: lconst_0
        //   329: putfield 209	com/tencent/wecall/talkroom/model/h:KxE	J
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
        //   348: getfield 209	com/tencent/wecall/talkroom/model/h:KxE	J
        //   351: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   354: aastore
        //   355: dup
        //   356: iconst_2
        //   357: aload 4
        //   359: getfield 87	com/tencent/wecall/talkroom/model/h:KxP	J
        //   362: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   365: aastore
        //   366: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   369: aload_0
        //   370: getfield 22	com/tencent/wecall/talkroom/model/f$1:KwH	Lcom/tencent/wecall/talkroom/model/f;
        //   373: invokestatic 215	com/tencent/wecall/talkroom/model/f:f	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/g;
        //   376: astore 4
        //   378: new 217	com/tencent/wecall/talkroom/model/g$4
        //   381: dup
        //   382: aload 4
        //   384: invokespecial 220	com/tencent/wecall/talkroom/model/g$4:<init>	(Lcom/tencent/wecall/talkroom/model/g;)V
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
        //   442: invokevirtual 234	com/tencent/wecall/talkroom/model/c:aUb	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
        //   445: astore 7
        //   447: aload 5
        //   449: astore 4
        //   451: aload 7
        //   453: ifnull -344 -> 109
        //   456: aload 7
        //   458: invokevirtual 240	com/tencent/wecall/talkroom/model/TalkRoom:fHV	()Ljava/util/List;
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
        //   587: getfield 168	com/tencent/wecall/talkroom/model/b:Kvs	Lcom/tencent/mm/plugin/multi/talk;
        //   590: sipush 401
        //   593: invokevirtual 277	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   596: pop
        //   597: goto -444 -> 153
        //   600: aload 4
        //   602: getfield 168	com/tencent/wecall/talkroom/model/b:Kvs	Lcom/tencent/mm/plugin/multi/talk;
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
        //   647: getfield 87	com/tencent/wecall/talkroom/model/h:KxP	J
        //   650: lsub
        //   651: putfield 209	com/tencent/wecall/talkroom/model/h:KxE	J
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
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aSZ(f.this.Kws));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.aUo(localStringBuilder.toString());
        AppMethodBeat.o(62608);
      }
      
      public final void keep_OnReportEngineRecv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62606);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aSZ(f.this.Kws));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.aUm(localStringBuilder.toString());
        AppMethodBeat.o(62606);
      }
      
      public final void keep_OnReportEngineSend(String paramAnonymousString)
      {
        AppMethodBeat.i(62607);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aSZ(f.this.Kws));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.aUn(localStringBuilder.toString());
        AppMethodBeat.o(62607);
      }
      
      final class a
        implements Runnable
      {
        int KwJ;
        int KwK;
        int KwL;
        int KwM;
        int KwN;
        
        a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
          this.KwJ = paramInt1;
          this.KwL = paramInt2;
          this.KwM = paramInt3;
          this.KwN = paramInt4;
          this.KwK = paramInt5;
        }
        
        public final void run()
        {
          AppMethodBeat.i(62585);
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "keep_OnError handler" });
          h.afV(this.KwM);
          f.this.Kwg.afW(this.KwL);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.KwK) });
          f.this.a(f.b(f.this), f.g(f.this), f.h(f.this), this.KwN, true);
          f.f(f.this).n(this.KwJ, null);
          AppMethodBeat.o(62585);
        }
      }
    };
    AppMethodBeat.o(62724);
    return true;
  }
  
  public final void fIo()
  {
    AppMethodBeat.i(62726);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.KwE != null) {
        this.mHandler.removeCallbacks(this.KwE);
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
  
  public final void gF(String paramString, int paramInt)
  {
    AppMethodBeat.i(62776);
    if ((com.tencent.pb.common.c.f.equals("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (eil()) && ((this.uaf) || (this.KvO))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62776);
      return;
      switch (k.lf(com.tencent.pb.common.c.c.AMx))
      {
      }
      for (this.Kwq = false; (this.tOL == 0) || (this.AMc == 0L); this.Kwq = true)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(62776);
        return;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect", this.tmu, Integer.valueOf(this.tOL) });
      this.Kwg.fIE();
      paramString = new com.tencent.wecall.talkroom.a.h(this.tmu, this.tOL, this.AMc, c.fIe().aUd(this.tmu), this.KvX);
      boolean bool = com.tencent.pb.common.b.e.fBC().a(paramString);
      this.Kwg.ad(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62776);
      return;
      paramString = this.Kwh;
      paramInt = k.lf(com.tencent.pb.common.c.c.AMx);
      if ((!com.tencent.pb.common.a.a.JLi) || (paramString.Kvs == null))
      {
        AppMethodBeat.o(62776);
        return;
      }
      paramString.Kvs.onNetworkChange(paramInt);
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
        if (paramMessage.tmu == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId is null" });
        }
        else
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handlerInviteTimeOut" });
          if ((paramMessage.tmu.equals(this.tmu)) && (paramMessage.tOL == this.tOL) && (paramMessage.AMc == this.AMc))
          {
            h.fIG();
            this.Kwg.afW(501);
            a(paramMessage.tmu, paramMessage.tOL, paramMessage.AMc, 7);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId: ", paramMessage.tmu });
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
              if (com.tencent.pb.common.c.f.ml(paramMessage.groupId, this.tmu))
              {
                String str1 = paramMessage.groupId;
                Object localObject1 = paramMessage.Kxb;
                a.bb localbb = paramMessage.Kxc;
                int i = paramMessage.JMr;
                int j = paramMessage.type;
                long l = paramMessage.Kxd;
                String str2 = paramMessage.Kxe;
                boolean bool = paramMessage.Kxf;
                String str3 = paramMessage.Kxg;
                this.Kwg.fIE();
                Object localObject2 = c.fIe();
                paramMessage = "";
                localObject2 = ((c)localObject2).aUb(str1);
                if (localObject2 != null) {
                  if (((TalkRoom)localObject2).Kvq != null) {
                    break label618;
                  }
                }
                label618:
                for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).Kvq.name)
                {
                  localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.Kwh.fIb(), paramMessage, localbb, i, j, l, str2, bool, str3);
                  bool = com.tencent.pb.common.b.e.fBC().a((com.tencent.pb.common.b.d)localObject1);
                  this.Kwg.ad(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
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
                  if (b(paramMessage.groupId, paramMessage.roomId, paramMessage.tIG, false))
                  {
                    a(paramMessage.groupId, paramMessage.roomId, paramMessage.tIG, paramMessage.JMr, paramMessage.urD, paramMessage.Kxs);
                    continue;
                    com.tencent.pb.common.c.e.fBU();
                  }
                }
              }
            }
          }
        }
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
    this.Kwo.onStateChanged(paramInt);
    AppMethodBeat.o(62728);
  }
  
  public final void yP(boolean paramBoolean)
  {
    AppMethodBeat.i(62725);
    this.Kwg.groupId = this.tmu;
    this.Kwg.JMm = this.KvQ;
    if (com.tencent.pb.common.c.f.cX(this.Kwg.groupId)) {
      this.Kwg.groupId = "";
    }
    if (com.tencent.pb.common.c.f.cX(this.Kwg.JMm)) {
      this.Kwg.JMm = "";
    }
    this.Kwg.AGu = 1;
    this.Kwg.roomId = this.tOL;
    this.Kwg.tIG = this.AMc;
    fIm();
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    ebB();
    WN();
    int j = -99999;
    int i = j;
    if (this.Kwh != null) {}
    try
    {
      this.Kwp = this.Kwh.fId();
      i = this.Kwh.Close();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.Kwh == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        j = this.Kwh.uninitLive();
        this.Kwh = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.Kwg.fIB();
          if ((!TextUtils.isEmpty(this.Kwg.groupId)) || (!TextUtils.isEmpty(this.Kwg.JMm)))
          {
            h.aUl(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.Kwg.reset();
          fIy();
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
  
  public final void yQ(boolean paramBoolean)
  {
    AppMethodBeat.i(62766);
    try
    {
      NX();
      fIq();
      if (paramBoolean)
      {
        fIv();
        bgk();
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
    int JMr;
    String[] Kxb;
    a.bb Kxc;
    long Kxd;
    String Kxe;
    boolean Kxf;
    String Kxg;
    String groupId;
    int type;
    
    a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(62686);
      Kxh = new b("OK", 0);
      Kxi = new b("NOT_AUTH", 1);
      Kxj = new b("NOT_BIND", 2);
      Kxk = new b("NOT_MATCH", 3);
      Kxl = new b("NO_NETWORK", 4);
      Kxm = new b("BUSY", 5);
      Kxn = new b("NOT_VALID_STATE", 6);
      Kxo = new b("GROUP_NOT_VALID", 7);
      Kxp = new b("UNINIT_SERVICE_FAILED", 8);
      Kxq = new b("INIT_ENGINE_FAILED", 9);
      Kxr = new b[] { Kxh, Kxi, Kxj, Kxk, Kxl, Kxm, Kxn, Kxo, Kxp, Kxq };
      AppMethodBeat.o(62686);
    }
    
    private b() {}
  }
  
  final class c
  {
    int JMr;
    String Kxs;
    String groupId;
    int roomId;
    long tIG;
    int urD;
    
    c() {}
  }
  
  final class d
  {
    long AMc;
    int tOL;
    String tmu;
  }
  
  final class e
  {
    String groupId;
    int roomId;
    long tIG;
    
    e() {}
  }
  
  public static abstract interface f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */