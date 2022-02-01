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
  public static List<Integer> ahZS;
  private static int ahZY;
  private static com.tencent.pb.talkroom.sdk.e ahda;
  public static String[] aiaE;
  public String IMR;
  public int JMX;
  boolean Kfr;
  public long UGt;
  boolean Uxb;
  private com.tencent.f.a.a ahVh;
  f ahZR;
  private Map<String, e> ahZT;
  private final int ahZU;
  private final int ahZV;
  private final int ahZW;
  private final int ahZX;
  private boolean ahZZ;
  int ahcO;
  private Timer aiaA;
  g aiaB;
  private int aiaC;
  private boolean aiaD;
  public String aiaF;
  HashSet<Long> aiaG;
  public boolean aiaH;
  public boolean aiaI;
  public boolean aiaJ;
  private short[] aiaK;
  private String[] aiaL;
  private short[] aiaM;
  private String[] aiaN;
  private int aiaO;
  public boolean aiaP;
  public boolean aiaQ;
  private Runnable aiaR;
  private com.tencent.pb.common.b.d aiaS;
  private Runnable aiaT;
  private boolean aiaa;
  String aiab;
  public String aiac;
  private int aiad;
  private int aiae;
  private int aiaf;
  private long aiag;
  private boolean aiah;
  private int aiai;
  private int aiaj;
  String aiak;
  int aial;
  private int aiam;
  private int aian;
  private int aiao;
  private int aiap;
  private int aiaq;
  private int aiar;
  private int aias;
  public h aiat;
  b aiau;
  private talk.IMultiTalkListener aiav;
  private TimerTask aiaw;
  private TimerTask aiax;
  private Timer aiay;
  private TimerTask aiaz;
  Handler mHandler;
  boolean mIsMute;
  int state;
  
  static
  {
    AppMethodBeat.i(62787);
    ahda = null;
    ahZS = new ArrayList();
    ahZY = 30000;
    aiaE = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(62787);
  }
  
  public f()
  {
    AppMethodBeat.i(62723);
    this.ahZT = new HashMap();
    this.ahZU = 1;
    this.ahZV = 2;
    this.ahZW = 3;
    this.ahZX = 4;
    this.state = 0;
    this.Uxb = false;
    this.ahZZ = false;
    this.aiaa = false;
    this.Kfr = false;
    this.aiad = 0;
    this.aiae = 0;
    this.aiaf = 0;
    this.aiag = 0L;
    this.aiah = true;
    this.aiai = 0;
    this.aiaj = 0;
    this.aiak = null;
    this.aial = -1;
    this.aiam = -1;
    this.aian = -1;
    this.aiao = -1;
    this.aiap = -1;
    this.aiaq = -1;
    this.aiar = -1;
    this.aias = -1;
    this.aiat = h.aibP;
    this.aiay = new Timer("TalkRoomService_HelloTimer");
    this.aiaA = new Timer("TalkRoomService_talkDurationTimer");
    this.aiaB = new g();
    this.aiaC = 0;
    this.aiaD = false;
    this.aiaF = null;
    this.aiaG = new HashSet();
    this.aiaH = false;
    this.aiaI = true;
    this.aiaJ = true;
    this.aiaK = null;
    this.aiaL = null;
    this.aiaM = null;
    this.aiaN = null;
    this.aiaO = 0;
    this.mIsMute = false;
    this.aiaP = false;
    this.aiaQ = true;
    this.aiaR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62550);
        if ((f.this.hWB()) && (f.s(f.this)))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
          h.aJm(-2003);
          f.this.aiat.aJp(401);
          f.this.bk(f.b(f.this), 3, 108);
        }
        AppMethodBeat.o(62550);
      }
    };
    this.aiaS = null;
    this.aiaT = new Runnable()
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
        if (!f.this.hWB())
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
              if (f.a(f.this, locale.IMR, locale.JMX, locale.UGt, f.aJk(locale.aicr)))
              {
                localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
              }
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.pb.common.b.e.jQX().b((com.tencent.pb.common.b.d)localObject1);
          AppMethodBeat.o(62587);
          return;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        AppMethodBeat.o(62587);
      }
    };
    com.tencent.pb.common.b.e.jQX().a(201, this);
    com.tencent.pb.common.b.e.jQX().a(202, this);
    com.tencent.pb.common.b.e.jQX().a(203, this);
    com.tencent.pb.common.b.e.jQX().a(204, this);
    com.tencent.pb.common.b.e.jQX().a(205, this);
    com.tencent.pb.common.b.e.jQX().a(206, this);
    com.tencent.pb.common.b.e.jQX().a(207, this);
    com.tencent.pb.common.b.e.jQX().a(208, this);
    com.tencent.pb.common.b.e.jQX().a(210, this);
    com.tencent.pb.common.b.e.jQX().a(209, this);
    com.tencent.pb.common.b.e.jQX().a(211, this);
    com.tencent.pb.common.b.e.jQX().a(212, this);
    com.tencent.pb.common.b.e.jQX().a(213, this);
    com.tencent.pb.common.b.e.jQX().a(214, this);
    com.tencent.pb.common.b.e.jQX().a(800, this);
    com.tencent.pb.common.b.e.jQX().a(801, this);
    com.tencent.pb.common.b.e.jQX().a(802, this);
    Object localObject = c.ked();
    g localg = this.aiaB;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).ahZJ = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      kej();
      if (this.ahVh == null) {
        this.ahVh = ((com.tencent.f.a.a)com.tencent.f.f.bGu("EventCenter"));
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.ahVh.a(this, aiaE);
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
  
  private void P(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62772);
    try
    {
      String str = c.ked().O(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.Uxb), " mTalkDuration: ", Integer.valueOf(this.aiad), " msgKey: ", str });
      AppMethodBeat.o(62772);
      return;
    }
    finally
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
      if (b(paramh.groupId, paramh.roomId, paramh.Hnt, false)) {
        this.aiat.ai(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62747);
      return;
    }
    paramObject = (a.am)paramObject;
    if (!b(paramObject.groupId, paramObject.UAZ, paramObject.UBa, false))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.UAZ), Integer.valueOf(this.JMX) });
      AppMethodBeat.o(62747);
      return;
    }
    this.aiat.ai(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.ahcO, paramObject.UAZ, paramObject.UBa, paramObject.aheQ, paramObject.aheS, paramObject.ahdv, false, false);
    a(paramObject.aheR, paramObject.aheY, paramObject.aheZ);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect type:", Integer.valueOf(this.aiaj) });
    if (this.aiaj == 0)
    {
      paramh = new byte[paramObject.aheU.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.aheU.length)
      {
        paramh[paramInt1] = ((byte)paramObject.aheU[paramInt1]);
        paramInt1 += 1;
      }
      localObject1 = new int[paramObject.ahfd.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.ahfd.length)
      {
        localObject1[paramInt1] = paramObject.ahfd[paramInt1];
        paramInt1 += 1;
      }
      if (this.aiau != null)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.aiau.Close()) });
        localObject2 = paramObject.aheQ;
        localObject3 = paramObject.aheh;
        if ((paramObject.aheT & 0x2) == 0) {
          break label547;
        }
      }
      label547:
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ba[])localObject2, (a.ax)localObject3, paramh, bool, paramObject.groupId, paramObject.UAZ, paramObject.UBa, paramObject.ahfa, paramObject.ahfb, paramObject.ahfc, (int[])localObject1, paramObject.ahej, this.aiak);
        AppMethodBeat.o(62747);
        return;
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp engine close but nullptr" });
        AppMethodBeat.o(62747);
        return;
      }
    }
    paramInt1 = j.oL(com.tencent.pb.common.c.c.UMe);
    com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "amyfwang,Redirect::netType:", Integer.valueOf(paramInt1) });
    paramObject = this.aiau;
    paramh = this.aiaL;
    Object localObject1 = this.aiaK;
    Object localObject2 = this.aiaN;
    Object localObject3 = this.aiaM;
    if (paramObject.ahZE != null) {
      paramObject.ahZE.Redirect(paramh, (short[])localObject1, (String[])localObject2, (short[])localObject3, paramInt1);
    }
    AppMethodBeat.o(62747);
  }
  
  private void a(int paramInt, a.ac paramac, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(212314);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.IMR, Integer.valueOf(parame.JMX), Long.valueOf(parame.UGt), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.a.S(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111), Integer.valueOf(14287), Integer.valueOf(-1112) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.aJl(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramac.groupId, Integer.valueOf(paramac.UAZ), Long.valueOf(paramac.UBa) });
      this.aiaB.L(-14255, paramac);
      AppMethodBeat.o(212314);
      return;
    }
    if (paramInt == 14287)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14287), paramac.groupId, Integer.valueOf(paramac.UAZ), Long.valueOf(paramac.UBa) });
      this.aiaB.L(-14287, paramac);
      AppMethodBeat.o(212314);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramac.groupId, Integer.valueOf(paramac.UAZ), Long.valueOf(paramac.UBa) });
      this.aiaB.L(-14256, paramac);
      AppMethodBeat.o(212314);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.IMR, parame.JMX, parame.UGt, aJj(parame.aicr)))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.IMR, " mGroupId: ", this.IMR, Integer.valueOf(parame.JMX), Integer.valueOf(this.JMX), Long.valueOf(parame.UGt), Long.valueOf(this.UGt) });
        AppMethodBeat.o(212314);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.IMR, Integer.valueOf(parame.JMX), Long.valueOf(parame.UGt) });
        AppMethodBeat.o(212314);
        return;
      }
      this.aiat.ai(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.aiat.aJp(322);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.IMR, Integer.valueOf(parame.JMX), Long.valueOf(parame.UGt) });
      a(parame.IMR, parame.JMX, parame.UGt, true);
      if (paramInt == 14251)
      {
        this.aiaB.L(-1000, null);
        AppMethodBeat.o(212314);
        return;
      }
      if (paramInt == 14252)
      {
        this.aiaB.L(-1200, null);
        AppMethodBeat.o(212314);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramac != null) {
          parame = Integer.valueOf(paramac.aheW);
        }
        this.aiaB.L(-1500, parame);
        AppMethodBeat.o(212314);
        return;
      }
      this.aiaB.L(-200, null);
      AppMethodBeat.o(212314);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramac.groupId, Integer.valueOf(paramac.UAZ), Long.valueOf(paramac.UBa) });
      AppMethodBeat.o(212314);
      return;
    }
    if (!b(paramac.groupId, paramac.UAZ, paramac.UBa, aJj(paramac.ACR)))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramac.groupId, " mGroupId: ", this.IMR, Integer.valueOf(paramac.UAZ), Integer.valueOf(this.JMX), Long.valueOf(paramac.UBa), Long.valueOf(this.UGt) });
      a(paramac.groupId, paramac.UAZ, paramac.UBa, 111, false);
      h.aJl(-1110);
      AppMethodBeat.o(212314);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramac.groupId, Integer.valueOf(paramac.UAZ), Long.valueOf(paramac.UBa) });
      AppMethodBeat.o(212314);
      return;
    }
    this.aiat.ai(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramac.aheR == null) || (paramac.aheR.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramac.groupId, Integer.valueOf(paramac.UAZ), Long.valueOf(paramac.UBa) });
      h.aJl(-1605);
      this.aiat.UXk = 329;
      a(paramac.groupId, paramac.UAZ, paramac.UBa, 116, true);
      this.aiaB.L(-200, null);
      AppMethodBeat.o(212314);
      return;
    }
    this.IMR = paramac.groupId;
    this.aiaF = paramac.groupId;
    this.JMX = paramac.UAZ;
    this.UGt = paramac.UBa;
    setState(4);
    a(paramac.aheR, paramac.aheY, paramac.aheZ);
    a(paramac.groupId, null, this.ahcO, paramac.UAZ, paramac.UBa, paramac.aheQ, paramac.aheS, paramac.ahdv, false, true);
    parame = this.aiaB;
    localObject = new g.11(parame, c.ked().bGL(paramac.groupId), this.UGt);
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramac.aheU.length];
      paramInt = 0;
      while (paramInt < paramac.aheU.length)
      {
        parame[paramInt] = ((byte)paramac.aheU[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramac.ahfd.length];
    paramInt = 0;
    while (paramInt < paramac.ahfd.length)
    {
      localObject[paramInt] = paramac.ahfd[paramInt];
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(paramac.ahfd.length), " redirect type:", Integer.valueOf(localObject[talk.LhL]), " SimpleRedirect value:", Integer.valueOf(talk.LhL) });
    a.ba[] arrayOfba = paramac.aheQ;
    a.ax localax = paramac.aheh;
    if ((paramac.aheT & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfba, localax, parame, bool, paramac.groupId, paramac.UAZ, paramac.UBa, paramac.ahfa, paramac.ahfb, paramac.ahfc, (int[])localObject, paramac.ahej, this.aiak);
      if (paramac.aheX != 0)
      {
        com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramac.aheX });
        ahZY = paramac.aheX * 1000;
      }
      keo();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt) });
      AppMethodBeat.o(212314);
      return;
    }
  }
  
  private void a(int paramInt, a.al paramal)
  {
    AppMethodBeat.i(212312);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.aiaB.oz(null);
      AppMethodBeat.o(212312);
      return;
    }
    paramal = paramal.ahfo;
    if ((paramal == null) || (paramal.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(212312);
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
        a(localObject.groupId, null, 0, localObject.UAZ, localObject.UBa, localObject.aheQ, null, null, false, false);
        localArrayList.add(c.ked().bGL(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.aiaB.oz(localArrayList);
    AppMethodBeat.o(212312);
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
    //   62: getfield 502	com/tencent/wecall/talkroom/model/f:aiau	Lcom/tencent/wecall/talkroom/model/b;
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
    //   166: getfield 238	com/tencent/wecall/talkroom/model/f:aiat	Lcom/tencent/wecall/talkroom/model/h;
    //   169: sipush 202
    //   172: invokevirtual 636	com/tencent/wecall/talkroom/model/h:aJp	(I)V
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
    //   206: getfield 256	com/tencent/wecall/talkroom/model/f:aiaB	Lcom/tencent/wecall/talkroom/model/g;
    //   209: sipush -400
    //   212: aconst_null
    //   213: invokevirtual 614	com/tencent/wecall/talkroom/model/g:L	(ILjava/lang/Object;)V
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
    ahda = parame;
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
    if (!aJj(paramInt3)) {
      this.aiat.keD();
    }
    this.aiat.keC();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.aiau.kea(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.jQX().b(paramString1);
    e(paramString1);
    AppMethodBeat.o(62731);
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62754);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(62754);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.ba[] paramArrayOfba)
  {
    AppMethodBeat.i(212323);
    if (paramArrayOfba == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(212323);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfba.length;
    int i = 0;
    while (i < j)
    {
      a.ba localba = paramArrayOfba[i];
      if (localba != null) {
        localStringBuffer.append(" memberId:" + localba.wTC + " uuid: " + localba.hJs + " status: " + localba.status + "   mem.inviteTime:" + localba.ahgm + "  mem.reason: " + localba.reason + "  mem.inviteuuid: " + localba.ahgy + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfba.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(212323);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.ba[] paramArrayOfba, a.bb[] paramArrayOfbb, a.ay paramay, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(212317);
    a(paramString1, paramInt2, paramLong, paramArrayOfba);
    c localc = c.ked();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.IMR == null) || (!this.IMR.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramay, paramArrayOfba, paramArrayOfbb, paramBoolean1, bool);
      paramString2 = this.IMR;
      i = this.JMX;
      l = this.UGt;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfba == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfba.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.aiah) });
      if (c.ked().eH(this.IMR, false))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.aiah), " mGroupId: ", this.IMR, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.aiah)
        {
          this.aiah = false;
          this.Kfr = true;
          this.aiaD = j.keG();
          this.aiaf = this.aiad;
          ket();
        }
      }
      if (paramArrayOfba != null) {
        break label380;
      }
      AppMethodBeat.o(212317);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfba.length > 0) && (this.aiau != null)) {
      a(paramArrayOfba);
    }
    AppMethodBeat.o(212317);
  }
  
  private void a(a.ba[] paramArrayOfba)
  {
    AppMethodBeat.i(212320);
    if (paramArrayOfba == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(212320);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfba.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfba.length)
    {
      arrayOfInt[i] = paramArrayOfba[i].wTC;
      localStringBuffer.append(paramArrayOfba[i].wTC);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.aiau == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(212320);
      return;
    }
    this.aiau.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(212320);
  }
  
  private void a(a.q[] paramArrayOfq1, a.q[] paramArrayOfq2, int paramInt)
  {
    AppMethodBeat.i(212326);
    if (paramArrayOfq1 == null) {}
    for (int i = 0;; i = paramArrayOfq1.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfq1 != null) && (paramArrayOfq1.length > 0)) {
        break;
      }
      AppMethodBeat.o(212326);
      return;
    }
    this.aiaL = new String[paramArrayOfq1.length];
    this.aiaK = new short[paramArrayOfq1.length];
    this.aiaN = new String[paramArrayOfq2.length];
    this.aiaM = new short[paramArrayOfq2.length];
    this.aiaO = paramInt;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.aiaO) });
    int j = paramArrayOfq1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.q localq = paramArrayOfq1[paramInt];
      this.aiaL[i] = localq.ahed;
      this.aiaK[i] = ((short)localq.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData ip: ", localq.ahed, " addr.port: ", Integer.valueOf(localq.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfq2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfq1 = paramArrayOfq2[paramInt];
      this.aiaN[i] = paramArrayOfq1.ahed;
      this.aiaM[i] = ((short)paramArrayOfq1.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", paramArrayOfq1.ahed, " tcpAddr.port: ", Integer.valueOf(paramArrayOfq1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.aiaL), Arrays.toString(this.aiaK), this.IMR, this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt), Arrays.toString(this.aiaN), Arrays.toString(this.aiaM), Integer.valueOf(this.aiaO) });
    AppMethodBeat.o(212326);
  }
  
  private boolean a(a.ba[] paramArrayOfba, a.ax paramax, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, String paramString)
  {
    AppMethodBeat.i(212329);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(212329);
      return false;
    }
    this.aiaj = paramArrayOfInt[talk.LhL];
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit general policy cnt:", Integer.valueOf(paramArrayOfInt.length), ", redirect type:", this.aiaj + " wifigateway:" + paramString });
    paramBoolean = b(paramArrayOfba, paramax, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramString);
    AppMethodBeat.o(212329);
    return paramBoolean;
  }
  
  private boolean aGH()
  {
    AppMethodBeat.i(62739);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = ahda;
      if (locale == null) {
        break label99;
      }
      this.aiat.UDO = locale.gfA();
      this.aiat.UDK = locale.gfB();
      bool = locale.gfy();
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
  
  private static boolean aJj(int paramInt)
  {
    return paramInt != 1;
  }
  
  private void aNm()
  {
    AppMethodBeat.i(62727);
    this.ahZT.remove(this.IMR);
    this.aiaC = 0;
    this.mIsMute = false;
    setState(0);
    this.aiaa = false;
    b(this.aiac, 0, 0L, null, null);
    this.aiac = null;
    this.ahcO = 0;
    this.aiad = 0;
    this.aiae = 0;
    this.aiaf = 0;
    this.aiah = true;
    this.aiaI = true;
    this.aiag = 0L;
    this.aiai = 0;
    this.ahZZ = false;
    this.aiaP = false;
    this.aiaQ = true;
    kel();
    this.mHandler.removeMessages(1);
    if (this.aiau != null) {
      this.aiau.keb();
    }
    keq();
    kep();
    ker();
    keu();
    this.Kfr = false;
    this.aiaH = false;
    this.aiaj = 0;
    AppMethodBeat.o(62727);
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(62738);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = ahda;
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
      com.tencent.pb.talkroom.sdk.e locale = ahda;
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
  
  private void b(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.JMX = paramInt;
    this.UGt = paramLong;
    this.IMR = paramString2;
    this.aiac = paramString1;
    this.aiab = paramString3;
  }
  
  private boolean b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62771);
    if (paramBoolean)
    {
      paramBoolean = com.tencent.pb.common.c.f.qz(paramString, this.IMR);
      AppMethodBeat.o(62771);
      return paramBoolean;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.IMR, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.JMX), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.UGt) });
    if ((com.tencent.pb.common.c.f.qz(paramString, this.IMR)) && (paramInt == this.JMX) && (paramLong == this.UGt))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    AppMethodBeat.o(62771);
    return false;
  }
  
  private boolean b(a.ba[] paramArrayOfba, a.ax paramax, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, String paramString)
  {
    AppMethodBeat.i(212330);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.IMR, " ip: ", Arrays.toString(this.aiaL), " ports: ", Arrays.toString(this.aiaK), " tcpIp: ", Arrays.toString(this.aiaN), " tcpPorts: ", Arrays.toString(this.aiaM), " tcpStartTime: ", Integer.valueOf(this.aiaO), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.jRr();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfba != null) && (paramArrayOfba.length > 0))
    {
      localObject1 = new int[paramArrayOfba.length];
      j = 0;
      while (j < paramArrayOfba.length)
      {
        localObject1[j] = paramArrayOfba[j].wTC;
        if (com.tencent.pb.common.c.f.qA(paramArrayOfba[j].hJs, (String)localObject2)) {
          i = paramArrayOfba[j].wTC;
        }
        j += 1;
      }
      paramArrayOfba = (a.ba[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.ked().bGG(this.IMR);
      this.aiat.wTC = j;
      for (;;)
      {
        try
        {
          localObject2 = this.aiau;
          localIMultiTalkListener = this.aiav;
          localObject3 = c.ked();
          localObject1 = this.IMR;
          localObject3 = ((c)localObject3).bGE((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.aiaL;
          arrayOfShort1 = this.aiaK;
          arrayOfString = this.aiaN;
          arrayOfShort2 = this.aiaM;
          m = this.aiaO;
          localObject1 = null;
          if (paramax == null) {
            continue;
          }
          paramax = new VoiceEngineConf(paramax.ahfD, paramax.oBU, paramax.oBV, paramax.ahfE, paramax.ahfF, paramax.ahfG, paramax.ahfH, paramax.ahfI, paramax.ahfJ, paramax.ahfK, paramax.ahfL, paramax.ahfM);
          n = j.oL(com.tencent.pb.common.c.c.UMe);
          localObject1 = ((b)localObject2).ahZE;
          if (localObject1 != null) {
            continue;
          }
          paramInt1 = -1;
        }
        finally
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
          paramInt1 = ((b)localObject2).ahZE.Open(localIMultiTalkListener, paramax, i, j, paramInt1, paramLong, (String[])localObject3, arrayOfShort1, 0, paramArrayOfba, paramArrayOfByte1, paramBoolean, n, arrayOfString, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramString);
          continue;
          paramArrayOfba.handler.post(paramax);
          continue;
          AppMethodBeat.o(212330);
          return false;
        }
        paramArrayOfba = this.aiaB;
        paramax = new g.5(paramArrayOfba, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramax.run();
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.aJo(-3002);
        }
        if (paramInt1 == 0) {
          this.aiat.UXn = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(212330);
        return true;
        localObject3 = ((TalkRoom)localObject3).bGD(com.tencent.pb.a.a.a.jRr());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).ahZK;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.ba)localObject3).Yzt) });
            i = ((a.ba)localObject3).Yzt;
            continue;
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramax = (a.ax)localObject1;
          }
        }
      }
      paramArrayOfba = null;
    }
  }
  
  private void dpe()
  {
    AppMethodBeat.i(62767);
    aGH();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.c()
    {
      public final void aj(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            if ((com.tencent.pb.common.a.a.ahcq) && (localb.ahZE != null)) {
              break label140;
            }
          }
          for (;;)
          {
            if (f.this.aiaI)
            {
              f.this.aiaI = false;
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt) });
            }
            AppMethodBeat.o(62659);
            return;
            label140:
            localb.ahZE.SendAudio(paramAnonymousArrayOfByte, s, 0);
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
      this.aiat.aJp(101);
      h.aJm(-2001);
      this.aiaB.L(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.aiat;
    }
    for (localh.aibQ &= 0xFFFFFFFE;; localh.aibQ |= 0x1)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62767);
      return;
      localh = this.aiat;
    }
  }
  
  private void e(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62775);
    this.mHandler.removeCallbacks(this.aiaT);
    this.aiaS = paramd;
    this.mHandler.postDelayed(this.aiaT, 3000L);
    AppMethodBeat.o(62775);
  }
  
  private boolean eu(int paramInt, String paramString)
  {
    AppMethodBeat.i(62732);
    if (paramInt == 100)
    {
      AppMethodBeat.o(62732);
      return true;
    }
    if (aJj(paramInt))
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
      boolean bool = bGN(paramString);
      AppMethodBeat.o(62732);
      return bool;
    }
    AppMethodBeat.o(62732);
    return false;
  }
  
  /* Error */
  private void hCF()
  {
    // Byte code:
    //   0: ldc_w 1288
    //   3: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 330
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 1290
    //   18: aastore
    //   19: invokestatic 375	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: invokespecial 1233	com/tencent/wecall/talkroom/model/f:aGH	()Z
    //   26: pop
    //   27: aload_0
    //   28: invokespecial 1293	com/tencent/wecall/talkroom/model/f:ken	()Z
    //   31: pop
    //   32: ldc_w 1288
    //   35: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: astore_1
    //   40: ldc_w 330
    //   43: iconst_2
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 1295
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: aload_1
    //   56: aastore
    //   57: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: goto -33 -> 27
    //   63: astore_1
    //   64: ldc_w 330
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: ldc_w 1295
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload_1
    //   80: aastore
    //   81: invokestatic 409	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc_w 1288
    //   87: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	f
    //   39	17	1	localObject1	Object
    //   63	17	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	27	39	finally
    //   27	32	63	finally
  }
  
  private boolean jG(String paramString, int paramInt)
  {
    AppMethodBeat.i(62735);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62735);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.ahcO);
    boolean bool = com.tencent.pb.common.b.e.jQX().b(localc);
    this.aiat.ai(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.JMX, this.UGt, true);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62735);
    return bool;
  }
  
  private void kej()
  {
    AppMethodBeat.i(212292);
    this.aiam = -1;
    this.aian = -1;
    this.aiao = -1;
    this.aiap = -1;
    this.aiaq = -1;
    this.aiar = -1;
    this.aias = -1;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "multitalk voiceMsg local seq reset" });
    AppMethodBeat.o(212292);
  }
  
  private int kem()
  {
    AppMethodBeat.i(62734);
    if (this.aiag == 0L)
    {
      AppMethodBeat.o(62734);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.aiag) / 1000L);
    AppMethodBeat.o(62734);
    return i;
  }
  
  private boolean ken()
  {
    AppMethodBeat.i(62737);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = ahda;
      if (locale == null) {
        break label99;
      }
      this.aiat.UEe = locale.gfz();
      this.aiat.UDL = locale.gfC();
      bool = locale.gfx();
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
  
  private void keo()
  {
    AppMethodBeat.i(62759);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.aiaw != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(62759);
      return;
    }
    try
    {
      this.aiaw = new TimerTask()
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
      this.aiay.schedule(this.aiaw, 0L, ahZY);
      AppMethodBeat.o(62759);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(62759);
    }
  }
  
  private void kep()
  {
    AppMethodBeat.i(62760);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.aiax != null) {
        this.aiax.cancel();
      }
      this.aiax = null;
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
  
  private void keq()
  {
    AppMethodBeat.i(62761);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.aiaw != null) {
        this.aiaw.cancel();
      }
      this.aiaw = null;
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
  
  private void ker()
  {
    AppMethodBeat.i(62762);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.aiaz != null) {
        this.aiaz.cancel();
      }
      this.aiaz = null;
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
  
  private void kes()
  {
    AppMethodBeat.i(62768);
    ken();
    Object localObject = new AtomicInteger();
    final AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new com.tencent.pb.talkroom.sdk.b()
    {
      public final int ai(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
            AtomicInteger localAtomicInteger1 = this.aibm;
            AtomicInteger localAtomicInteger2 = localAtomicInteger;
            if (com.tencent.pb.common.a.a.ahcq) {
              if (localb.ahZE == null)
              {
                break label169;
                if ((f.this.aiaJ) && (i >= 0))
                {
                  f.this.aiaJ = false;
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt), " ret: ", Integer.valueOf(i) });
                }
                AppMethodBeat.o(62788);
                return i;
              }
              else
              {
                i = localb.ahZE.GetAudioData(paramAnonymousArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
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
      this.aiat.aJp(101);
      h.aJm(-2001);
      localObject = this.aiat;
      ((h)localObject).aibQ |= 0x1;
      this.aiaB.L(-500, null);
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62768);
  }
  
  private void ket()
  {
    AppMethodBeat.i(62769);
    if (this.aiaz != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(62769);
      return;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.ahZR, " mIsHoldOn: ", Boolean.valueOf(this.aiaP) });
    this.aiaz = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(62661);
        if (!f.this.aiaP)
        {
          f.a(f.this, f.n(f.this) + 1);
          if (f.o(f.this)) {
            f.b(f.this, f.p(f.this) + 1);
          }
          if ((f.q(f.this) == 3) || (f.q(f.this) == 2))
          {
            f.c(f.this, f.r(f.this) + 1);
            f.this.aiat.UXy = f.r(f.this);
          }
          f.this.aiat.aibU = (f.n(f.this) * 1000);
          f.this.aiat.UXx = f.n(f.this);
        }
        if (f.this.ahZR != null) {
          f.n(f.this);
        }
        AppMethodBeat.o(62661);
      }
    };
    this.aiaA.scheduleAtFixedRate(this.aiaz, 1000L, 1000L);
    AppMethodBeat.o(62769);
  }
  
  private void keu()
  {
    AppMethodBeat.i(62774);
    this.mHandler.removeCallbacks(this.aiaT);
    this.aiaS = null;
    AppMethodBeat.o(62774);
  }
  
  private static void kev()
  {
    AppMethodBeat.i(62777);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.c.UMe.getSystemService("audio");
      localAudioManager.setMode(0);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "resumeAudioConfig mode: ", Integer.valueOf(localAudioManager.getMode()), " isSpeaker: ", Boolean.valueOf(localAudioManager.isSpeakerphoneOn()) });
      AppMethodBeat.o(62777);
      return;
    }
    finally
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "resumeAudioConfig ", localObject });
      AppMethodBeat.o(62777);
    }
  }
  
  public static boolean kew()
  {
    AppMethodBeat.i(62778);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.c.UMe.getSystemService("audio")).isSpeakerphoneOn();
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
  
  public static com.tencent.pb.talkroom.sdk.e kex()
  {
    return ahda;
  }
  
  static String[] oA(List<String> paramList)
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
  
  public final void OL(boolean paramBoolean)
  {
    AppMethodBeat.i(62725);
    this.aiat.groupId = this.IMR;
    this.aiat.ahdt = this.aiac;
    if (com.tencent.pb.common.c.f.hm(this.aiat.groupId)) {
      this.aiat.groupId = "";
    }
    if (com.tencent.pb.common.c.f.hm(this.aiat.ahdt)) {
      this.aiat.ahdt = "";
    }
    this.aiat.UDI = 1;
    this.aiat.roomId = this.JMX;
    this.aiat.Hnt = this.UGt;
    kej();
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    hCF();
    aNm();
    int j = -99999;
    int i = j;
    if (this.aiau != null) {}
    try
    {
      this.aiaC = this.aiau.kec();
      i = this.aiau.Close();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.aiau == null) {}
    }
    finally
    {
      try
      {
        j = this.aiau.uninitLive();
        this.aiau = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.aiat.kez();
          if ((!TextUtils.isEmpty(this.aiat.groupId)) || (!TextUtils.isEmpty(this.aiat.ahdt)))
          {
            h.bGO(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.aiat.reset();
          kev();
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService end error", Integer.valueOf(j) });
        AppMethodBeat.o(62725);
        return;
        localObject = finally;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService", localObject });
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
  
  public final com.tencent.pb.talkroom.sdk.f S(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62745);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.Kfr)
    {
      localObject = localf;
      if (this.aiau == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo" });
        localb = this.aiau;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfInt != null) && (localb.ahZE != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", localb.ahZE });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.Kfr), " decInfo: ", paramArrayOfInt, " engine: ", this.aiau });
      localObject = paramArrayOfInt;
      AppMethodBeat.o(62745);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.ahZE.videoDecode(paramArrayOfInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhk = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhl = localb.ahZE.field_remoteImgLength;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhm = localb.ahZE.field_remoteImgWidth;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhn = localb.ahZE.field_remoteImgHeight;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahho = (localb.ahZE.field_remoteImgChannel & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhp = 0;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhi = c.ked().jE(a.kdP().IMR, ((com.tencent.pb.talkroom.sdk.f)localObject).ahho);
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
    AppMethodBeat.i(212340);
    localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject = localf;
    if (this.Kfr)
    {
      localObject = localf;
      if (this.aiau == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen" });
        localb = this.aiau;
        localObject = new com.tencent.pb.talkroom.sdk.f();
        if ((paramArrayOfByte != null) && (paramArrayOfInt != null) && (localb.ahZE != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveScreen null, imgBuffer32:", paramArrayOfInt, ", engine:", localb.ahZE });
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
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveScreen finished, ", Boolean.valueOf(this.Kfr), " decInfo: ", paramArrayOfByte, " engine: ", this.aiau });
      localObject = paramArrayOfByte;
      AppMethodBeat.o(212340);
      return localObject;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ret = localb.ahZE.screenDecode(paramArrayOfByte, paramArrayOfInt, paramInt);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhq = paramArrayOfByte;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhk = paramArrayOfInt;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhl = localb.ahZE.field_remoteImgLength_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhm = localb.ahZE.field_remoteImgWidth_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhn = localb.ahZE.field_remoteImgHeight_screen;
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahho = (localb.ahZE.field_remoteImgChannel_screen & 0x3FFF);
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhp = localb.ahZE.field_remoteImgOrien_screen;
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen channel:", Integer.valueOf(localb.ahZE.field_remoteImgChannel_screen) });
      com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "weiranli: receiveScreen field_remoteImgOrien:", Integer.valueOf(localb.ahZE.field_remoteImgOrien_screen) });
      ((com.tencent.pb.talkroom.sdk.f)localObject).ahhi = c.ked().jE(a.kdP().IMR, ((com.tencent.pb.talkroom.sdk.f)localObject).ahho);
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
    AppMethodBeat.i(212336);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.JMX), Integer.valueOf(paramInt1), Long.valueOf(this.UGt), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    this.aiak = paramString3;
    if (!com.tencent.pb.a.a.a.jRs())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.jRs()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.jRt()) });
      h.a(paramString1, "", this.JMX, this.UGt, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = b.aibv;
      AppMethodBeat.o(212336);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((aJj(paramInt3)) && (paramInt3 != 100) && (hWB()))
    {
      h.a(paramString1, "", this.JMX, this.UGt, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = b.aibz;
      AppMethodBeat.o(212336);
      return paramString1;
    }
    if (!eu(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.JMX, this.UGt, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = b.aibA;
      AppMethodBeat.o(212336);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.JMX, this.UGt, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = b.aibB;
      AppMethodBeat.o(212336);
      return paramString1;
    }
    if (aJj(paramInt3))
    {
      this.aiat.reset();
      OL(false);
    }
    if (!kek())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initService fail" });
      if (aJj(paramInt3))
      {
        h.a(paramString1, "", this.JMX, this.UGt, new String[] { "enter", "req", "false", "initServicefail" });
        OL(false);
      }
      for (;;)
      {
        paramString1 = b.aibC;
        AppMethodBeat.o(212336);
        return paramString1;
        this.aiat.ai(new String[] { "enter", "req", "false", "initServicefail" });
      }
    }
    if (!hCI())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (aJj(paramInt3))
      {
        h.a(paramString1, "", this.JMX, this.UGt, new String[] { "enter", "req", "false", "initEnginefail" });
        OL(false);
      }
      for (;;)
      {
        paramString1 = b.aibD;
        AppMethodBeat.o(212336);
        return paramString1;
        this.aiat.ai(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.IMR = paramString1;
    int i;
    long l;
    label829:
    label835:
    boolean bool;
    if (!aJj(paramInt3))
    {
      paramString3 = bGM(paramString1);
      if (paramString3 == null)
      {
        i = 0;
        this.JMX = i;
        if (paramString3 != null) {
          break label999;
        }
        l = 0L;
        this.UGt = l;
        this.aiaF = paramString1;
        this.ahcO = paramInt2;
        setState(3);
        if (!aJj(paramInt3)) {
          break label1022;
        }
        bool = true;
        label862:
        this.Uxb = bool;
        if (this.Uxb) {
          this.aiat.keA();
        }
        if ((!this.Uxb) || (c.ked().eH(this.IMR, true))) {
          break label1028;
        }
        paramString3 = new c();
        paramString3.groupId = paramString1;
        paramString3.roomId = paramInt1;
        paramString3.Hnt = paramLong;
        paramString3.ACR = paramInt3;
        paramString3.ahdy = paramInt2;
        paramString3.aibF = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = paramString3;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = b.aibu;
      AppMethodBeat.o(212336);
      return paramString1;
      i = paramString3.roomId;
      break;
      label999:
      l = paramString3.Hnt;
      break label829;
      this.JMX = paramInt1;
      this.UGt = paramLong;
      break label835;
      label1022:
      bool = false;
      break label862;
      label1028:
      a(paramString1, this.JMX, this.UGt, paramInt2, paramInt3, paramString2);
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
        paramString = com.tencent.pb.common.c.a.S(new Integer[] { Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542) });
        i = paramd.getType();
        if (paramString.containsKey(Integer.valueOf(i))) {
          h.aJl(((Integer)paramString.get(Integer.valueOf(i))).intValue());
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
          if (com.tencent.pb.common.c.f.qz(this.aiac, paramString.aiac))
          {
            this.aiat.aJp(301);
            this.aiat.ai(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            jG(paramString.aiac, 1001);
            if (!paramString.aicq) {
              this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.aiaB.L(-100, null);
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
      if (!b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
        h.a(paramString.IMR, paramString.JMX, paramString.UGt, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.aiaB.a(paramString.aicp, c.ked().bGL(paramString.IMR));
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.IMR, paramString.JMX, paramString.UGt, false))
      {
        this.aiat.ai(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.aiaB.L(-300, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.IMR, paramString.JMX, paramString.UGt, aJj(paramString.aicr))) && (this.state == 3))
      {
        this.aiat.aJp(302);
        this.aiaB.L(-200, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.aiaB.oz(null);
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
      if (b(paramString.groupId, paramString.roomId, paramString.Hnt, false)) {
        this.aiat.ai(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (m)paramd;
      if (b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
        this.aiaB.L(-800, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (k)paramd;
      if (b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
        this.aiaB.L(-1600, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 801)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      if (b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
        this.aiaB.L(-1601, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 802)
    {
      paramString = (l)paramd;
      if (b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
        this.aiaB.L(-1602, null);
      }
    }
    AppMethodBeat.o(62742);
    return;
    label1141:
    Object localObject2;
    if (paramd.getType() == 201)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.d)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).ahcN != null))
      {
        paramString = (a.ab)((com.tencent.pb.common.b.d)localObject1).ahcN;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).aiac });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).aicq) {
          break label2628;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.a.S(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.aJl(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          ahZS = null;
          if (paramInt2 == 0) {
            break label2895;
          }
          if (com.tencent.pb.common.c.f.qz(this.aiac, ((com.tencent.wecall.talkroom.a.d)localObject1).aiac)) {
            break label2634;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.aiac, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).aiac, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1430:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.ahcN != null)) {
        a(paramInt2, (a.ac)paramString.ahcN, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.ahcN != null))
      {
        localObject1 = (a.z)paramString.ahcN;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.a.S(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303), Integer.valueOf(14651), Integer.valueOf(-1309) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.aJl(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label3928;
        }
        if (b(paramString.IMR, paramString.JMX, paramString.UGt, false))
        {
          this.aiat.ai(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (paramInt2 != 14651) {
            break label3914;
          }
          com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14651), ((a.z)localObject1).groupId, Integer.valueOf(((a.z)localObject1).UAZ), Long.valueOf(((a.z)localObject1).UBa) });
          this.aiaB.L(-301, localObject1);
        }
      }
    }
    label1821:
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.ahcN != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ad)paramString.ahcN).groupId, this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.a.S(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.aJl(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (n)paramd;
      if ((paramString != null) && (paramString.ahcN != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.an)paramString.ahcN).groupId, this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        kep();
        i = 0;
        if (paramInt2 != 14800) {
          break label4145;
        }
        i = -1401;
        label2181:
        if (i != 0)
        {
          this.aiat.aJp(324);
          h.aJl(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.ahcN != null))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.IMR, " roomid: ", Integer.valueOf(paramString.JMX), " roomKey: ", Long.valueOf(paramString.UGt) });
        if (paramInt2 != 18950) {
          break label4160;
        }
        if (!b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
          h.a(paramString.IMR, paramString.JMX, paramString.UGt, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.ked().bGL(paramString.IMR);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.IMR, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.aiaB.a(paramString.aicp, (MultiTalkGroup)localObject1);
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
        if ((paramString != null) && (paramString.ahcN != null))
        {
          if (paramInt2 == 18100) {
            h.aJl(-1501);
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
        }
      }
      if (paramd.getType() == 208)
      {
        paramString = (com.tencent.wecall.talkroom.a.c)paramd;
        if ((paramString != null) && (paramString.ahcN != null))
        {
          if (paramInt2 == 18300) {
            h.aJl(-1531);
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
        }
      }
      if (paramd.getType() != 209) {
        break label4646;
      }
      paramString = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((paramString == null) || (paramString.ahcN == null)) {
        break label4646;
      }
      paramString = (a.ae)paramString.ahcN;
      if (paramInt2 == 17900) {
        h.aJl(-1511);
      }
      if (paramInt2 == 0) {
        break label4566;
      }
      AppMethodBeat.o(62742);
      throw null;
      i = 0;
      break;
      if (paramInt2 != -1)
      {
        this.aiat.aJp(321);
        this.aiat.ai(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
      }
      if (this.state != 1)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).aiac });
        if (i == 0) {
          break label1430;
        }
        this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break label1430;
      }
      a(this.IMR, this.JMX, this.UGt, true);
      if (paramInt2 == 14051) {
        this.aiaB.L(-900, null);
      }
      for (;;)
      {
        if (i == 0) {
          break label2893;
        }
        this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break;
        if (paramInt2 == 14052) {
          this.aiaB.L(-1100, null);
        } else if (paramInt2 == 14053) {
          this.aiaB.L(-1300, paramString);
        } else if (paramInt2 == 14504) {
          this.aiaB.L(-1400, null);
        } else {
          this.aiaB.L(-100, null);
        }
      }
      break label1430;
      if (!com.tencent.pb.common.c.f.qz(this.aiac, paramString.ahdt))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.aiac, " resp.clientGroupId: ", paramString.ahdt, Integer.valueOf(paramString.UAZ), Long.valueOf(paramString.UBa) });
        a(paramString.groupId, paramString.UAZ, paramString.UBa, 110, false);
        if (i == 0) {
          break label1430;
        }
        this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break label1430;
      }
      this.aiat.ai(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
      if (this.state != 1)
      {
        h.aJl(-1003);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.ahdt, Integer.valueOf(paramString.UAZ), Long.valueOf(paramString.UBa) });
        if (i == 0) {
          break label1430;
        }
        this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        break label1430;
      }
      if ((paramString.aheR == null) || (paramString.aheR.length == 0))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.ahdt, Integer.valueOf(paramString.UAZ), Long.valueOf(paramString.UBa) });
        h.aJl(-1605);
        this.aiat.UXk = 329;
        a(paramString.groupId, paramString.UAZ, paramString.UBa, 116, true);
        if (i != 0) {
          this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
        }
        this.aiaB.L(-100, null);
        break label1430;
      }
      b(paramString.ahdt, paramString.UAZ, paramString.UBa, paramString.groupId, paramString.ahdv.ahfW);
      this.aiaF = paramString.groupId;
      this.ahcO = paramString.ahdy;
      setState(4);
      a(paramString.aheR, paramString.aheY, paramString.aheZ);
      a(paramString.groupId, paramString.ahdt, paramString.ahdy, paramString.UAZ, paramString.UBa, paramString.aheg, paramString.aheS, paramString.ahdv, false, true);
      if (this.aiaB != null)
      {
        localObject1 = this.aiaB;
        localObject2 = new g.9((g)localObject1, c.ked().bGL(paramString.groupId), paramString.UBa);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label3464;
        }
        ((Runnable)localObject2).run();
      }
      for (;;)
      {
        localObject1 = new byte[paramString.aheU.length];
        j = 0;
        while (j < paramString.aheU.length)
        {
          localObject1[j] = ((byte)paramString.aheU[j]);
          j += 1;
        }
        label3464:
        ((g)localObject1).handler.post((Runnable)localObject2);
      }
      localObject2 = new int[paramString.ahfd.length];
      int j = 0;
      while (j < paramString.ahfd.length)
      {
        localObject2[j] = paramString.ahfd[j];
        j += 1;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(paramString.ahfd.length) });
      if (paramString.ahfd.length > talk.LhL) {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { " redirect type:", Integer.valueOf(localObject2[talk.LhL]), " SimpleRedirect value:", Integer.valueOf(talk.LhL) });
      }
      localObject3 = paramString.aheg;
      a.ax localax = paramString.aheh;
      if ((paramString.aheT & 0x2) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ba[])localObject3, localax, (byte[])localObject1, bool, paramString.groupId, paramString.UAZ, paramString.UBa, paramString.ahfa, paramString.ahfb, paramString.ahfc, (int[])localObject2, paramString.ahej, this.aiak);
        if (paramString.aheX != 0)
        {
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.aheX });
          ahZY = paramString.aheX * 1000;
        }
        keo();
        P(paramString.groupId, paramString.UAZ, paramString.UBa);
        if (i != 0)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("result", Boolean.TRUE);
          ((Map)localObject1).put("shareUrl", new String(paramString.ahdv.ahfQ, Charset.forName("utf-8")));
          ((Map)localObject1).put("smsShortUrl", new String(paramString.ahdv.ahfR, Charset.forName("utf-8")));
          ((Map)localObject1).put("groupId", paramString.groupId);
          this.ahVh.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt) });
        break;
      }
      label3914:
      this.aiaB.L(-300, null);
      break label1821;
      label3928:
      if (((a.z)localObject1).aheQ == null)
      {
        i = 0;
        label3939:
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
        if (b(((a.z)localObject1).groupId, ((a.z)localObject1).UAZ, ((a.z)localObject1).UBa, false)) {
          break label4102;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.z)localObject1).groupId, this.IMR, " resp.roomid: ", Integer.valueOf(((a.z)localObject1).UAZ), Integer.valueOf(this.JMX) });
        h.aJl(-1308);
      }
      for (;;)
      {
        a(((a.z)localObject1).groupId, null, this.ahcO, ((a.z)localObject1).UAZ, ((a.z)localObject1).UBa, ((a.z)localObject1).aheQ, null, ((a.z)localObject1).ahdv, true, true);
        break;
        i = ((a.z)localObject1).aheQ.length;
        break label3939;
        label4102:
        this.aiat.ai(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
      }
      label4145:
      if (paramInt2 != 14801) {
        break label2181;
      }
      i = -1402;
      break label2181;
      label4160:
      if (paramInt2 == 0) {
        this.ahZZ = true;
      }
      if (!hWB())
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.IMR });
        this.aiat.reset();
        OL(false);
        this.aiat.ai(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.Uxb = false;
        this.IMR = paramString.IMR;
        this.aiaF = this.IMR;
        this.JMX = paramString.JMX;
        this.UGt = paramString.UGt;
        this.ahcO = paramString.ahcO;
        setState(2);
        this.aiag = System.currentTimeMillis();
        localObject1 = this.aiat;
        com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "beginNotifyTime" });
        ((h)localObject1).aicf = System.currentTimeMillis();
        if (paramInt2 == 18900) {
          h.aJl(-1521);
        }
      }
      while (!com.tencent.pb.common.c.f.qA(paramString.IMR, this.IMR))
      {
        localObject1 = new e();
        ((e)localObject1).groupId = paramString.IMR;
        ((e)localObject1).roomId = paramString.JMX;
        ((e)localObject1).Hnt = paramString.UGt;
        this.ahZT.put(paramString.IMR, localObject1);
        localObject1 = c.ked().bGL(paramString.IMR);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.IMR, " multiTalkGroup: ", localObject1 });
        if (localObject1 == null) {
          break label4544;
        }
        paramString = this.aiaB;
        localObject1 = new g.3(paramString, (MultiTalkGroup)localObject1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label4531;
        }
        ((Runnable)localObject1).run();
        break;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.IMR });
      continue;
      label4531:
      paramString.handler.post((Runnable)localObject1);
      continue;
      label4544:
      a(paramString.IMR, paramString.JMX, paramString.UGt, false, false, false);
    }
    label4566:
    Object localObject1 = c.ked().bGE(paramString.groupId);
    if (localObject1 != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
      a(paramString.groupId, null, ((TalkRoom)localObject1).kdS(), TalkRoom.kdT(), TalkRoom.hVw(), null, null, paramString.ahdv, true, false);
    }
    for (;;)
    {
      com.tencent.pb.common.c.g.runOnMainThread(new g.16(this.aiaB, paramString.groupId, 0));
      label4646:
      if (paramd.getType() == 210)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (paramInt2 == 19100) {
          h.aJl(-1541);
        }
      }
      if (paramd.getType() == 211)
      {
        paramString = (com.tencent.wecall.talkroom.a.h)paramd;
        if (paramString != null) {
          a(paramInt1, paramInt2, paramd.ahcN, paramString);
        }
      }
      if (paramd.getType() == 212) {
        a(paramInt2, (a.al)paramd.ahcN);
      }
      if (paramd.getType() != 213) {
        break label4834;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break;
      }
      AppMethodBeat.o(62742);
      throw null;
      a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.ahdv, true, false);
    }
    AppMethodBeat.o(62742);
    throw null;
    label4834:
    if (paramd.getType() == 214)
    {
      paramString = (a.aj)paramd.ahcN;
      localObject1 = (m)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (((m)localObject1).aics == 1) {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleSwitchVideoGroup, but ilink event" });
      }
    }
    else
    {
      if (paramd.getType() == 800)
      {
        paramString = (k)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
        if (b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
          break label5686;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.IMR, Integer.valueOf(paramString.JMX) });
      }
      if (paramd.getType() == 801)
      {
        paramString = (com.tencent.wecall.talkroom.a.j)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo errCode: ", Integer.valueOf(paramInt2) });
        if (b(paramString.IMR, paramString.JMX, paramString.UGt, false)) {
          break label5751;
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo isCurrentRoom is not same", paramString.IMR, Integer.valueOf(paramString.JMX) });
      }
    }
    for (;;)
    {
      label5002:
      if (paramd.getType() == 802)
      {
        paramString = (l)paramd;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeScreenSharingVideo errCode: ", Integer.valueOf(paramInt2) });
        if (!b(paramString.IMR, paramString.JMX, paramString.UGt, false))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeScreenSharingVideo isCurrentRoom is not same", paramString.IMR, Integer.valueOf(paramString.JMX) });
          AppMethodBeat.o(62742);
          return;
          if (!b(((m)localObject1).IMR, ((m)localObject1).JMX, ((m)localObject1).UGt, false))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((m)localObject1).IMR, Integer.valueOf(((m)localObject1).JMX) });
            break;
          }
          if (this.aiau != null)
          {
            localObject2 = new int[6];
            localObject2[0] = paramString.ZPI;
            localObject2[1] = paramString.ahff;
            localObject2[2] = paramString.ahfg;
            localObject2[3] = paramString.ahfh;
            localObject2[4] = paramString.ahfi;
            localObject2[5] = paramString.ahfj;
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]), Integer.valueOf(localObject2[2]), Integer.valueOf(localObject2[3]), Integer.valueOf(localObject2[4]), Integer.valueOf(localObject2[5]) });
            localObject3 = this.aiau;
            if (((b)localObject3).ahZE != null) {
              break label5493;
            }
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject2, ", engine:", ((b)localObject3).ahZE });
          }
          for (;;)
          {
            if (paramString.ahfm == 0)
            {
              if (paramInt2 == 0)
              {
                localObject1 = this.aiaB;
                paramString = new g.18((g)localObject1, paramString.ZPI);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  paramString.run();
                  break;
                  label5493:
                  ((b)localObject3).ahZE.setMVSvrCfg((int[])localObject2, 6);
                  continue;
                }
                ((g)localObject1).handler.post(paramString);
                break;
              }
              if (paramInt2 == 24301)
              {
                this.aiaB.L(-1700, Integer.valueOf(paramString.ahfl));
                break;
              }
              this.aiaB.L(-800, null);
              break;
            }
          }
          if (paramString.ahfm != 1) {
            break;
          }
          if (((m)localObject1).zZv == 103)
          {
            localObject2 = this.aiaB;
            paramString = new g.20((g)localObject2, ((m)localObject1).aict, paramInt2, paramString.ahfn);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              paramString.run();
              break;
            }
            ((g)localObject2).handler.post(paramString);
            break;
          }
          paramString = this.aiaB;
          localObject1 = new g.19(paramString, paramInt2);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break;
          }
          paramString.handler.post((Runnable)localObject1);
          break;
          label5686:
          if (paramInt2 == 0)
          {
            paramString = this.aiaB;
            localObject1 = new g.21(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              break label5002;
            }
            paramString.handler.post((Runnable)localObject1);
            break label5002;
          }
          this.aiaB.L(-1600, null);
          break label5002;
          label5751:
          if (paramInt2 == 0)
          {
            paramString = this.aiaB;
            localObject1 = new g.22(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              continue;
            }
            paramString.handler.post((Runnable)localObject1);
            continue;
          }
          this.aiaB.L(-1601, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.aiaB;
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
        this.aiaB.L(-1602, null);
      }
    }
    AppMethodBeat.o(62742);
  }
  
  public final void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(62755);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.IMR, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.JMX), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.UGt) });
    c.ked().bGF(paramString);
    if (paramBoolean1) {
      P(paramString, paramInt, paramLong);
    }
    this.ahZT.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      OL(true);
      this.aiaB.eI(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.ked().bGL(paramString);
      if (paramString != null) {
        this.aiaB.f(paramString);
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
    boolean bool = com.tencent.pb.common.b.e.jQX().b(localf);
    this.aiat.ai(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62736);
    return bool;
  }
  
  public final com.tencent.pb.talkroom.sdk.g b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62744);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.Kfr) && (this.aiau != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.aiau;
        if ((paramArrayOfByte == null) || (localb.ahZE == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.ahZE });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.Kfr), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.aiau });
          AppMethodBeat.o(62744);
          return paramArrayOfByte;
        }
        paramInt1 = localb.ahZE.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.Lml = paramArrayOfInt;
        paramArrayOfByte.Lmm = localb.ahZE.field_localImgWidth;
        paramArrayOfByte.Lmn = localb.ahZE.field_localImgHeight;
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
  
  public final e bGM(String paramString)
  {
    AppMethodBeat.i(62757);
    paramString = (e)this.ahZT.get(paramString);
    AppMethodBeat.o(62757);
    return paramString;
  }
  
  public final boolean bGN(String paramString)
  {
    AppMethodBeat.i(62758);
    if ((e)this.ahZT.get(paramString) != null)
    {
      AppMethodBeat.o(62758);
      return true;
    }
    AppMethodBeat.o(62758);
    return false;
  }
  
  public final boolean bk(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62773);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62773);
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100)) {
      this.aiat.keB();
    }
    int i = this.JMX;
    long l = this.UGt;
    int j = a.kdP().state;
    if (i.bGS(paramString))
    {
      this.aiat.aJp(327);
      bool = a.kdP().jG(paramString, 1000);
      AppMethodBeat.o(62773);
      return bool;
    }
    if (j == 2)
    {
      bool = a.kdP().c(paramString, i, l, paramInt1);
      AppMethodBeat.o(62773);
      return bool;
    }
    com.tencent.pb.common.c.a.R(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.kdP().a(paramString, i, l, paramInt2, true);
    AppMethodBeat.o(62773);
    return bool;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(212338);
    int j = -1;
    int i = j;
    if (this.Kfr)
    {
      i = j;
      if (this.aiau == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.aiau;
        if ((paramArrayOfByte != null) && (localb.ahZE != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendScreen null, buffer:", paramArrayOfByte, ", engine:", localb.ahZE });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendScreen error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen finished, ", Boolean.valueOf(this.Kfr), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.aiau });
      i = paramInt1;
      AppMethodBeat.o(212338);
      return i;
      paramInt1 = localb.ahZE.SendScreen(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(212337);
    int j = -1;
    int i = j;
    if (this.Kfr)
    {
      i = j;
      if (this.aiau == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localb = this.aiau;
        if ((paramArrayOfByte != null) && (localb.ahZE != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.ahZE });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.Kfr), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.aiau });
      i = paramInt1;
      AppMethodBeat.o(212337);
      return i;
      paramInt1 = localb.ahZE.SendVideo(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final boolean c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62733);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.IMR, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
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
        kem();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.jQX().b(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.aiat.ai(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
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
  
  public final int dB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62753);
    long l;
    int n;
    label348:
    int i1;
    try
    {
      paramArrayOfByte = (a.r)com.google.d.a.e.a(new a.r(), paramArrayOfByte, paramArrayOfByte.length);
      if (paramArrayOfByte == null) {
        if ((!TextUtils.isEmpty(this.IMR)) || (!TextUtils.isEmpty(this.aiac)))
        {
          this.aiat.ai(new String[] { "notify", "pasrefail" });
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
        h.aJl(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.JMX, this.UGt, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange ", this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt), Long.valueOf(paramArrayOfByte.msgId), Integer.valueOf(paramArrayOfByte.ahee), Integer.valueOf(paramArrayOfByte.oUj) });
      l = paramArrayOfByte.msgId;
      if (this.aiaG.contains(Long.valueOf(l)))
      {
        n = 1;
        if (n == 0) {
          break label392;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error: msgId:", Long.valueOf(paramArrayOfByte.msgId) });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false)) {
          break label348;
        }
        this.aiat.ai(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.ahee) });
      }
      for (;;)
      {
        AppMethodBeat.o(62753);
        return -3;
        this.aiaG.add(Long.valueOf(l));
        n = 0;
        break;
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.ahee) });
      }
      label392:
      n = paramArrayOfByte.ahee;
      i1 = paramArrayOfByte.oUj;
      switch (n)
      {
      default: 
        com.tencent.pb.common.c.b.w(" unknow voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1) });
        n = 0;
      }
    }
    if (n == 0) {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange update msg seq fail type:", Integer.valueOf(paramArrayOfByte.ahee) });
    }
    for (;;)
    {
      AppMethodBeat.o(62753);
      return 0;
      if ((i1 > 0) && (i1 <= this.aiam))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.aiam) });
        n = 0;
        break;
      }
      this.aiam = i1;
      for (;;)
      {
        com.tencent.pb.common.c.b.w("voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1), " update local seq" });
        n = 1;
        break;
        if (i1 <= this.aian)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.aian) });
          n = 0;
          break;
        }
        this.aian = i1;
        continue;
        if (i1 <= this.aiao)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.aiao) });
          n = 0;
          break;
        }
        this.aiao = i1;
        continue;
        if (i1 <= this.aiap)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.aiap) });
          n = 0;
          break;
        }
        this.aiap = i1;
        continue;
        if (i1 <= this.aiaq)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.aiaq) });
          n = 0;
          break;
        }
        this.aiaq = i1;
        continue;
        if (i1 <= this.aiar)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.aiar) });
          n = 0;
          break;
        }
        this.aiar = i1;
        continue;
        if (i1 <= this.aias)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.aias) });
          n = 0;
          break;
        }
        this.aias = i1;
      }
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false)) {
        this.aiat.ai(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.ahee) });
      }
      if (paramArrayOfByte.ahee == 2)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.ahdy, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, paramArrayOfByte.aheg, paramArrayOfByte.ahef, paramArrayOfByte.ahdv, true, true);
      }
      else
      {
        Object localObject1;
        if (paramArrayOfByte.ahee == 4)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.ahdy, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, paramArrayOfByte.aheg, paramArrayOfByte.ahef, paramArrayOfByte.ahdv, true, true);
          if ((paramArrayOfByte.ahei != 0) || (paramArrayOfByte.ahej != 0))
          {
            localObject1 = this.aiau;
            n = paramArrayOfByte.ahei;
            i1 = paramArrayOfByte.ahej;
            if ((com.tencent.pb.common.a.a.ahcq) && (((b)localObject1).ahZE != null)) {
              ((b)localObject1).ahZE.SetAVEncryptType(n, i1);
            }
          }
        }
        else if (paramArrayOfByte.ahee == 16)
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.ahdy, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, paramArrayOfByte.aheg, paramArrayOfByte.ahef, paramArrayOfByte.ahdv, true, false);
        }
        else if (paramArrayOfByte.ahee == 1)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.UAZ), " roomkey: ", Long.valueOf(paramArrayOfByte.UBa) });
          if ((!com.tencent.pb.a.a.a.jRs()) || (!com.tencent.pb.a.a.a.jRt()))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
          }
          else if ((hWB()) && (com.tencent.pb.common.c.f.qA(paramArrayOfByte.groupId, this.IMR)))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.IMR });
          }
          else
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.ahdy, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, paramArrayOfByte.aheg, paramArrayOfByte.ahef, paramArrayOfByte.ahdv, false, true);
            localObject1 = paramArrayOfByte.groupId;
            n = paramArrayOfByte.UAZ;
            l = paramArrayOfByte.UBa;
            i1 = paramArrayOfByte.ahdy;
            int i2 = paramArrayOfByte.ahek;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
            }
            for (;;)
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
              break;
              paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, n, l, i1, i2);
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i2), Boolean.valueOf(com.tencent.pb.common.b.e.jQX().b(paramArrayOfByte)) });
            }
          }
        }
        else if (paramArrayOfByte.ahee == 8)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.IMR });
          if (b(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false))
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.ahdy, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, paramArrayOfByte.aheg, paramArrayOfByte.ahef, paramArrayOfByte.ahdv, true, false);
            a(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false, false, true);
          }
          else
          {
            a(paramArrayOfByte.groupId, null, paramArrayOfByte.ahdy, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, paramArrayOfByte.aheg, paramArrayOfByte.ahef, paramArrayOfByte.ahdv, true, false);
          }
        }
        else
        {
          String str;
          if (paramArrayOfByte.ahee == 128)
          {
            localObject1 = paramArrayOfByte.groupId;
            str = this.IMR;
            if (paramArrayOfByte.ahel == null) {}
            for (n = 0;; n = paramArrayOfByte.ahel.length)
            {
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(n) });
              localObject1 = this.aiaB;
              paramArrayOfByte = new g.24((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.ahel);
              if (Looper.myLooper() != Looper.getMainLooper()) {
                break label2016;
              }
              paramArrayOfByte.run();
              break;
            }
            label2016:
            ((g)localObject1).handler.post(paramArrayOfByte);
          }
          else
          {
            Object localObject2;
            if (paramArrayOfByte.ahee == 256)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
              } else if (paramArrayOfByte.ahel == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
              } else {
                try
                {
                  localObject1 = paramArrayOfByte.ahel;
                  localObject1 = (a.t)com.google.d.a.e.a(new a.t(), (byte[])localObject1, localObject1.length);
                  if ((localObject1 == null) || (((a.t)localObject1).ahep == null)) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
                  }
                }
                catch (com.google.d.a.d locald1)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember ", locald1 });
                    localObject2 = null;
                  }
                  paramArrayOfByte = new ArrayList();
                  localObject2 = ((a.t)localObject2).ahep;
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
                  com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.IMR, " roomId: ", Integer.valueOf(this.JMX), " videoUserNames: ", paramArrayOfByte });
                  localObject2 = this.aiaB;
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
            else if (paramArrayOfByte.ahee == 1024)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
              }
              else if ((this.state != 3) && (this.state != 4))
              {
                c(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, 1);
                this.aiaB.L(-1400, null);
              }
            }
            else if (paramArrayOfByte.ahee == 512)
            {
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false)) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
              } else if (paramArrayOfByte.ahel == null) {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
              } else {
                try
                {
                  localObject2 = paramArrayOfByte.ahel;
                  localObject2 = (a.s)com.google.d.a.e.a(new a.s(), (byte[])localObject2, localObject2.length);
                  if (localObject2 == null) {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
                  }
                }
                catch (com.google.d.a.d locald2)
                {
                  for (;;)
                  {
                    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                    local1 = null;
                  }
                  paramArrayOfByte = this.aiaB;
                  g.1 local1 = new g.1(paramArrayOfByte, local1.aheo);
                  if (Looper.myLooper() == Looper.getMainLooper())
                  {
                    local1.run();
                    continue;
                  }
                  paramArrayOfByte.handler.post(local1);
                }
              }
            }
            else if (paramArrayOfByte.ahee == 2048)
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, chgtype: audiostream" });
              if (!b(paramArrayOfByte.groupId, paramArrayOfByte.UAZ, paramArrayOfByte.UBa, false))
              {
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAudioStreamChange is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.UAZ) });
              }
              else
              {
                com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleAudioStreamChange audio_stream_type", Integer.valueOf(paramArrayOfByte.TFq) });
                int i = (byte)(paramArrayOfByte.TFq & 0xFF);
                int j = (byte)(paramArrayOfByte.TFq >> 8 & 0xFF);
                int k = (byte)(paramArrayOfByte.TFq >> 16 & 0xFF);
                int m = (byte)(paramArrayOfByte.TFq >> 24 & 0xFF);
                this.aiau.ahZE.setAppCmd(306, new byte[] { i, j, k, m }, 4);
              }
            }
            else
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onVoiceGroupChange, unknow chgtype:", Integer.valueOf(paramArrayOfByte.ahee), Long.valueOf(paramArrayOfByte.msgId) });
            }
          }
        }
      }
    }
  }
  
  final boolean hCI()
  {
    AppMethodBeat.i(62765);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initEngine", this.IMR, Integer.valueOf(this.JMX), Long.valueOf(this.UGt), Integer.valueOf(this.state) });
    int i;
    label133:
    int j;
    try
    {
      localb = this.aiau;
      boolean bool = com.tencent.pb.common.a.a.ahcq;
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
        i = localException.ahZE.field_capInfo.length;
      }
      AppMethodBeat.o(62765);
      return true;
    }
    if (i < 0)
    {
      h.aJo(-3001);
      this.aiat.aJp(201);
      this.aiau = null;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(62765);
      return false;
      str = com.tencent.pb.common.c.c.UMe.getDir("lib", 0).getAbsolutePath();
      locale = ahda;
      if (locale == null) {
        break label380;
      }
      j = locale.aOK();
      i = locale.gfv();
    }
    for (;;)
    {
      int k = j.oL(com.tencent.pb.common.c.c.UMe);
      com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(k), " cpuFlag:", Integer.valueOf(j), "libPath:", str });
      if (localb.ahZE == null)
      {
        i = -1;
        break;
      }
      j = localb.ahZE.init(i, k, j, str + "/");
      if (localb.ahZE.field_capInfo == null)
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
  
  public final boolean hWB()
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
          if (com.tencent.pb.common.c.f.qz(paramMessage.groupId, this.IMR))
          {
            String str1 = paramMessage.groupId;
            Object localObject1 = paramMessage.aibo;
            a.bd localbd = paramMessage.aibp;
            int i = paramMessage.ahdy;
            int j = paramMessage.type;
            long l = paramMessage.aibq;
            String str2 = paramMessage.aibr;
            boolean bool = paramMessage.aibs;
            String str3 = paramMessage.aibt;
            this.aiat.keC();
            Object localObject2 = c.ked();
            paramMessage = "";
            localObject2 = ((c)localObject2).bGE(str1);
            if (localObject2 != null) {
              if (((TalkRoom)localObject2).ahZC != null) {
                break label484;
              }
            }
            label484:
            for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).ahZC.name)
            {
              localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.aiau.kea(), paramMessage, localbd, i, j, l, str2, bool, str3);
              bool = com.tencent.pb.common.b.e.jQX().b((com.tencent.pb.common.b.d)localObject1);
              this.aiat.ai(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
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
              if (b(paramMessage.groupId, paramMessage.roomId, paramMessage.Hnt, false))
              {
                a(paramMessage.groupId, paramMessage.roomId, paramMessage.Hnt, paramMessage.ahdy, paramMessage.ACR, paramMessage.aibF);
                continue;
                com.tencent.pb.common.c.e.jRq();
              }
            }
          }
        }
      }
    }
  }
  
  public final void jD(String paramString, int paramInt)
  {
    AppMethodBeat.i(62776);
    if ((com.tencent.pb.common.c.f.qA("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (hWB()) && ((this.Kfr) || (this.aiaa))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62776);
      return;
      switch (j.oL(com.tencent.pb.common.c.c.UMe))
      {
      }
      for (this.aiaD = false; (this.JMX == 0) || (this.UGt == 0L); this.aiaD = true)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(62776);
        return;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect", this.IMR, Integer.valueOf(this.JMX) });
      this.aiat.keC();
      paramString = new com.tencent.wecall.talkroom.a.h(this.IMR, this.JMX, this.UGt, c.ked().bGG(this.IMR), this.aiaj);
      boolean bool = com.tencent.pb.common.b.e.jQX().b(paramString);
      this.aiat.ai(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62776);
      return;
      paramString = this.aiau;
      paramInt = j.oL(com.tencent.pb.common.c.c.UMe);
      if ((!com.tencent.pb.common.a.a.ahcq) || (paramString.ahZE == null))
      {
        AppMethodBeat.o(62776);
        return;
      }
      paramString.ahZE.onNetworkChange(paramInt);
    }
  }
  
  final boolean kek()
  {
    AppMethodBeat.i(62724);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = ahda;
    if (locale != null) {
      locale.gfu();
    }
    this.aiau = new b();
    this.aiaF = this.IMR;
    kej();
    this.aiav = new talk.IMultiTalkListener()
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
          f.this.aiat.aibR = 1;
          localh = f.this.aiat;
          if (localh.aice != 0L) {
            break label121;
          }
        }
        label121:
        for (localh.aibS = 0L;; localh.aibS = (System.currentTimeMillis() - localh.aice))
        {
          com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.aice), Long.valueOf(localh.aibS) });
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
        //   3: ldc 119
        //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: aload_0
        //   9: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   12: getfield 77	com/tencent/wecall/talkroom/model/f:aiat	Lcom/tencent/wecall/talkroom/model/h;
        //   15: iconst_1
        //   16: putfield 122	com/tencent/wecall/talkroom/model/h:JIf	I
        //   19: ldc 59
        //   21: iconst_1
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 124
        //   29: aastore
        //   30: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   33: aload_0
        //   34: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   37: invokestatic 126	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   40: iconst_4
        //   41: if_icmpeq +36 -> 77
        //   44: ldc 59
        //   46: iconst_2
        //   47: anewarray 4	java/lang/Object
        //   50: dup
        //   51: iconst_0
        //   52: ldc 128
        //   54: aastore
        //   55: dup
        //   56: iconst_1
        //   57: aload_0
        //   58: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   61: invokestatic 126	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   64: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   67: aastore
        //   68: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   71: ldc 119
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aload_0
        //   78: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   81: astore 6
        //   83: invokestatic 134	com/tencent/wecall/talkroom/model/c:ked	()Lcom/tencent/wecall/talkroom/model/c;
        //   86: astore 4
        //   88: aload_0
        //   89: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   92: invokestatic 138	com/tencent/wecall/talkroom/model/f:b	(Lcom/tencent/wecall/talkroom/model/f;)Ljava/lang/String;
        //   95: astore 7
        //   97: aload 7
        //   99: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   102: ifeq +336 -> 438
        //   105: aload 5
        //   107: astore 4
        //   109: aload 6
        //   111: aload 4
        //   113: invokestatic 147	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;[I)V
        //   116: aload_0
        //   117: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   120: invokestatic 151	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   123: ifnull +30 -> 153
        //   126: aload_0
        //   127: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   130: invokestatic 151	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   133: astore 4
        //   135: invokestatic 154	com/tencent/wecall/talkroom/model/f:kew	()Z
        //   138: istore_3
        //   139: getstatic 160	com/tencent/pb/common/a/a:ahcq	Z
        //   142: ifeq +11 -> 153
        //   145: aload 4
        //   147: getfield 166	com/tencent/wecall/talkroom/model/b:ahZE	Lcom/tencent/mm/plugin/multi/talk;
        //   150: ifnonnull +431 -> 581
        //   153: aload_0
        //   154: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   157: invokestatic 169	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
        //   160: pop
        //   161: aload_0
        //   162: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   165: invokestatic 151	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   168: pop
        //   169: invokestatic 173	com/tencent/wecall/talkroom/model/f:kex	()Lcom/tencent/pb/talkroom/sdk/e;
        //   172: astore 4
        //   174: aload 4
        //   176: ifnull +11 -> 187
        //   179: aload 4
        //   181: invokeinterface 179 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   191: invokestatic 151	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   194: getfield 166	com/tencent/wecall/talkroom/model/b:ahZE	Lcom/tencent/mm/plugin/multi/talk;
        //   197: astore 6
        //   199: getstatic 160	com/tencent/pb/common/a/a:ahcq	Z
        //   202: ifeq +83 -> 285
        //   205: new 181	java/util/concurrent/atomic/AtomicInteger
        //   208: dup
        //   209: invokespecial 182	java/util/concurrent/atomic/AtomicInteger:<init>	()V
        //   212: astore 4
        //   214: new 181	java/util/concurrent/atomic/AtomicInteger
        //   217: dup
        //   218: invokespecial 182	java/util/concurrent/atomic/AtomicInteger:<init>	()V
        //   221: astore 5
        //   223: aload 6
        //   225: aload 4
        //   227: aload 5
        //   229: invokevirtual 188	com/tencent/mm/plugin/multi/talk:getSampleRate	(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)I
        //   232: pop
        //   233: aload 4
        //   235: invokevirtual 191	java/util/concurrent/atomic/AtomicInteger:get	()I
        //   238: istore_1
        //   239: aload 5
        //   241: invokevirtual 191	java/util/concurrent/atomic/AtomicInteger:get	()I
        //   244: istore_2
        //   245: iload_1
        //   246: putstatic 194	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
        //   249: iload_2
        //   250: putstatic 197	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
        //   253: ldc 199
        //   255: iconst_3
        //   256: anewarray 4	java/lang/Object
        //   259: dup
        //   260: iconst_0
        //   261: ldc 201
        //   263: aastore
        //   264: dup
        //   265: iconst_1
        //   266: getstatic 194	com/tencent/mm/plugin/multi/talk:VOICE_SAMPLERATE	I
        //   269: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   272: aastore
        //   273: dup
        //   274: iconst_2
        //   275: getstatic 197	com/tencent/mm/plugin/multi/talk:VOICE_FRAME_DURATION	I
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
        //   300: invokespecial 204	com/tencent/wecall/talkroom/model/f$1$1:<init>	(Lcom/tencent/wecall/talkroom/model/f$1;)V
        //   303: invokevirtual 52	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   306: pop
        //   307: aload_0
        //   308: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   311: getfield 77	com/tencent/wecall/talkroom/model/f:aiat	Lcom/tencent/wecall/talkroom/model/h;
        //   314: astore 4
        //   316: aload 4
        //   318: getfield 87	com/tencent/wecall/talkroom/model/h:aice	J
        //   321: lconst_0
        //   322: lcmp
        //   323: ifne +317 -> 640
        //   326: aload 4
        //   328: lconst_0
        //   329: putfield 207	com/tencent/wecall/talkroom/model/h:aibT	J
        //   332: getstatic 94	com/tencent/wecall/talkroom/model/h:TAG	Ljava/lang/String;
        //   335: iconst_3
        //   336: anewarray 4	java/lang/Object
        //   339: dup
        //   340: iconst_0
        //   341: ldc 209
        //   343: aastore
        //   344: dup
        //   345: iconst_1
        //   346: aload 4
        //   348: getfield 207	com/tencent/wecall/talkroom/model/h:aibT	J
        //   351: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   354: aastore
        //   355: dup
        //   356: iconst_2
        //   357: aload 4
        //   359: getfield 87	com/tencent/wecall/talkroom/model/h:aice	J
        //   362: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   365: aastore
        //   366: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   369: aload_0
        //   370: getfield 22	com/tencent/wecall/talkroom/model/f$1:aiaU	Lcom/tencent/wecall/talkroom/model/f;
        //   373: invokestatic 213	com/tencent/wecall/talkroom/model/f:f	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/g;
        //   376: astore 4
        //   378: new 215	com/tencent/wecall/talkroom/model/g$6
        //   381: dup
        //   382: aload 4
        //   384: invokespecial 218	com/tencent/wecall/talkroom/model/g$6:<init>	(Lcom/tencent/wecall/talkroom/model/g;)V
        //   387: astore 5
        //   389: invokestatic 221	android/os/Looper:myLooper	()Landroid/os/Looper;
        //   392: invokestatic 42	android/os/Looper:getMainLooper	()Landroid/os/Looper;
        //   395: if_acmpne +262 -> 657
        //   398: aload 5
        //   400: invokeinterface 226 1 0
        //   405: ldc 119
        //   407: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   410: return
        //   411: astore 4
        //   413: ldc 59
        //   415: iconst_2
        //   416: anewarray 4	java/lang/Object
        //   419: dup
        //   420: iconst_0
        //   421: ldc 228
        //   423: aastore
        //   424: dup
        //   425: iconst_1
        //   426: aload 4
        //   428: aastore
        //   429: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   432: ldc 119
        //   434: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   437: return
        //   438: aload 4
        //   440: aload 7
        //   442: invokevirtual 232	com/tencent/wecall/talkroom/model/c:bGE	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
        //   445: astore 7
        //   447: aload 5
        //   449: astore 4
        //   451: aload 7
        //   453: ifnull -344 -> 109
        //   456: aload 7
        //   458: invokevirtual 238	com/tencent/wecall/talkroom/model/TalkRoom:kdV	()Ljava/util/List;
        //   461: astore 7
        //   463: aload 5
        //   465: astore 4
        //   467: aload 7
        //   469: ifnull -360 -> 109
        //   472: aload 7
        //   474: invokeinterface 243 1 0
        //   479: newarray int
        //   481: astore 4
        //   483: new 245	java/lang/StringBuffer
        //   486: dup
        //   487: invokespecial 246	java/lang/StringBuffer:<init>	()V
        //   490: astore 5
        //   492: iconst_0
        //   493: istore_1
        //   494: iload_1
        //   495: aload 7
        //   497: invokeinterface 243 1 0
        //   502: if_icmpge +52 -> 554
        //   505: aload 7
        //   507: iload_1
        //   508: invokeinterface 249 2 0
        //   513: checkcast 251	com/tencent/wecall/talkroom/model/d
        //   516: astore 8
        //   518: aload 8
        //   520: ifnull +154 -> 674
        //   523: aload 4
        //   525: iload_1
        //   526: aload 8
        //   528: invokevirtual 254	com/tencent/wecall/talkroom/model/d:getMemberId	()I
        //   531: iastore
        //   532: aload 5
        //   534: aload 4
        //   536: iload_1
        //   537: iaload
        //   538: invokevirtual 258	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
        //   541: pop
        //   542: aload 5
        //   544: ldc_w 260
        //   547: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   550: pop
        //   551: goto +123 -> 674
        //   554: ldc_w 265
        //   557: iconst_2
        //   558: anewarray 4	java/lang/Object
        //   561: dup
        //   562: iconst_0
        //   563: ldc_w 267
        //   566: aastore
        //   567: dup
        //   568: iconst_1
        //   569: aload 5
        //   571: invokevirtual 271	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   574: aastore
        //   575: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   578: goto -469 -> 109
        //   581: iload_3
        //   582: ifeq +18 -> 600
        //   585: aload 4
        //   587: getfield 166	com/tencent/wecall/talkroom/model/b:ahZE	Lcom/tencent/mm/plugin/multi/talk;
        //   590: sipush 401
        //   593: invokevirtual 275	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   596: pop
        //   597: goto -444 -> 153
        //   600: aload 4
        //   602: getfield 166	com/tencent/wecall/talkroom/model/b:ahZE	Lcom/tencent/mm/plugin/multi/talk;
        //   605: sipush 402
        //   608: invokevirtual 275	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   611: pop
        //   612: goto -459 -> 153
        //   615: astore 6
        //   617: ldc 199
        //   619: iconst_2
        //   620: anewarray 4	java/lang/Object
        //   623: dup
        //   624: iconst_0
        //   625: ldc_w 277
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
        //   647: getfield 87	com/tencent/wecall/talkroom/model/h:aice	J
        //   650: lsub
        //   651: putfield 207	com/tencent/wecall/talkroom/model/h:aibT	J
        //   654: goto -322 -> 332
        //   657: aload 4
        //   659: getfield 283	com/tencent/wecall/talkroom/model/g:handler	Landroid/os/Handler;
        //   662: aload 5
        //   664: invokevirtual 52	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   667: pop
        //   668: ldc 119
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
        //   411	28	4	localObject2	Object
        //   449	209	4	localObject3	Object
        //   1	662	5	localObject4	Object
        //   81	143	6	localObject5	Object
        //   615	17	6	localObject6	Object
        //   95	411	7	localObject7	Object
        //   516	11	8	locald	d
        // Exception table:
        //   from	to	target	type
        //   77	105	411	finally
        //   109	153	411	finally
        //   153	174	411	finally
        //   179	187	411	finally
        //   187	223	411	finally
        //   233	285	411	finally
        //   285	332	411	finally
        //   332	410	411	finally
        //   438	447	411	finally
        //   456	463	411	finally
        //   472	492	411	finally
        //   494	518	411	finally
        //   523	551	411	finally
        //   554	578	411	finally
        //   585	597	411	finally
        //   600	612	411	finally
        //   617	637	411	finally
        //   640	654	411	finally
        //   657	668	411	finally
        //   223	233	615	finally
      }
      
      public final void keep_OnReportChannel(String paramAnonymousString)
      {
        AppMethodBeat.i(62608);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportChannel:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bFk(f.this.aiaF));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bGR(localStringBuilder.toString());
        AppMethodBeat.o(62608);
      }
      
      public final void keep_OnReportEngineRecv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62606);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bFk(f.this.aiaF));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bGP(localStringBuilder.toString());
        AppMethodBeat.o(62606);
      }
      
      public final void keep_OnReportEngineSend(String paramAnonymousString)
      {
        AppMethodBeat.i(62607);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.bFk(f.this.aiaF));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.bGQ(localStringBuilder.toString());
        AppMethodBeat.o(62607);
      }
      
      final class a
        implements Runnable
      {
        int aiaW;
        int aiaX;
        int aiaY;
        int aiaZ;
        int aiba;
        
        a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
          this.aiaW = paramInt1;
          this.aiaY = paramInt2;
          this.aiaZ = paramInt3;
          this.aiba = paramInt4;
          this.aiaX = paramInt5;
        }
        
        public final void run()
        {
          AppMethodBeat.i(62585);
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "keep_OnError handler" });
          h.aJo(this.aiaZ);
          f.this.aiat.aJp(this.aiaY);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.aiaX) });
          f.this.a(f.b(f.this), f.g(f.this), f.h(f.this), this.aiba, true);
          f.f(f.this).L(this.aiaW, null);
          AppMethodBeat.o(62585);
        }
      }
    };
    AppMethodBeat.o(62724);
    return true;
  }
  
  public final void kel()
  {
    AppMethodBeat.i(62726);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.aiaR != null) {
        this.mHandler.removeCallbacks(this.aiaR);
      }
      AppMethodBeat.o(62726);
      return;
    }
    finally
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { " stopTimer: ", localObject });
      AppMethodBeat.o(62726);
    }
  }
  
  public final int screenTrans(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(212339);
    if ((this.Kfr) && (this.aiau != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendScreen ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        b localb = this.aiau;
        if ((paramArrayOfByte1 == null) || (localb.ahZE == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:screenTrans null, buf:", paramArrayOfByte1, ", engine:", localb.ahZE });
          paramInt4 = -1;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "screenTrans finished, ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.Kfr), " engine: ", this.aiau });
          AppMethodBeat.o(212339);
          return paramInt4;
        }
        paramInt4 = localb.ahZE.screenTrans(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2, paramInt4, paramInt5, paramInt6);
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
    this.aiaB.onStateChanged(paramInt);
    AppMethodBeat.o(62728);
  }
  
  public final void yL(boolean paramBoolean)
  {
    AppMethodBeat.i(62766);
    try
    {
      aGH();
      ken();
      if (paramBoolean)
      {
        kes();
        dpe();
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(62766);
      return;
    }
    finally
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean), localObject });
      AppMethodBeat.o(62766);
    }
  }
  
  final class a
  {
    int ahdy;
    String[] aibo;
    a.bd aibp;
    long aibq;
    String aibr;
    boolean aibs;
    String aibt;
    String groupId;
    int type;
    
    a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(62686);
      aibu = new b("OK", 0);
      aibv = new b("NOT_AUTH", 1);
      aibw = new b("NOT_BIND", 2);
      aibx = new b("NOT_MATCH", 3);
      aiby = new b("NO_NETWORK", 4);
      aibz = new b("BUSY", 5);
      aibA = new b("NOT_VALID_STATE", 6);
      aibB = new b("GROUP_NOT_VALID", 7);
      aibC = new b("UNINIT_SERVICE_FAILED", 8);
      aibD = new b("INIT_ENGINE_FAILED", 9);
      aibE = new b[] { aibu, aibv, aibw, aibx, aiby, aibz, aibA, aibB, aibC, aibD };
      AppMethodBeat.o(62686);
    }
    
    private b() {}
  }
  
  final class c
  {
    int ACR;
    long Hnt;
    int ahdy;
    String aibF;
    String groupId;
    int roomId;
    
    c() {}
  }
  
  final class d {}
  
  final class e
  {
    long Hnt;
    String groupId;
    int roomId;
    
    e() {}
  }
  
  public static abstract interface f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */