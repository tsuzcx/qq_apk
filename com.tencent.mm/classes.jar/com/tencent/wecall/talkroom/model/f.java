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
  public static String[] IJZ;
  public static List<Integer> IJo;
  private static int IJu;
  private static com.tencent.pb.talkroom.sdk.e Iki;
  private com.tencent.f.a.a IHW;
  private int IJA;
  private int IJB;
  private long IJC;
  private boolean IJD;
  private int IJE;
  private int IJF;
  int IJG;
  int IJH;
  private int IJI;
  private int IJJ;
  private int IJK;
  private int IJL;
  private int IJM;
  private int IJN;
  public h IJO;
  b IJP;
  private talk.a IJQ;
  private TimerTask IJR;
  private TimerTask IJS;
  private Timer IJT;
  private TimerTask IJU;
  private Timer IJV;
  g IJW;
  private int IJX;
  private boolean IJY;
  f IJn;
  private Map<String, e> IJp;
  private final int IJq;
  private final int IJr;
  private final int IJs;
  private final int IJt;
  private boolean IJv;
  private boolean IJw;
  private String IJx;
  public String IJy;
  private int IJz;
  public String IKa;
  HashSet<Long> IKb;
  public boolean IKc;
  public boolean IKd;
  public boolean IKe;
  private short[] IKf;
  private String[] IKg;
  private short[] IKh;
  private String[] IKi;
  private int IKj;
  public boolean IKk;
  public boolean IKl;
  private Runnable IKm;
  private com.tencent.pb.common.b.d IKn;
  private Runnable IKo;
  int IjW;
  Handler mHandler;
  boolean mIsMute;
  public int sHe;
  boolean sRS;
  public String seB;
  int state;
  boolean zgY;
  public long ztl;
  
  static
  {
    AppMethodBeat.i(62787);
    Iki = null;
    IJo = new ArrayList();
    IJu = 30000;
    IJZ = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(62787);
  }
  
  public f()
  {
    AppMethodBeat.i(62723);
    this.IJp = new HashMap();
    this.IJq = 1;
    this.IJr = 2;
    this.IJs = 3;
    this.IJt = 4;
    this.state = 0;
    this.zgY = false;
    this.IJv = false;
    this.IJw = false;
    this.sRS = false;
    this.IJz = 0;
    this.IJA = 0;
    this.IJB = 0;
    this.IJC = 0L;
    this.IJD = true;
    this.IJE = 0;
    this.IJF = 0;
    this.IJG = 0;
    this.IJH = -1;
    this.IJI = -1;
    this.IJJ = -1;
    this.IJK = -1;
    this.IJL = -1;
    this.IJM = -1;
    this.IJN = -1;
    this.IJO = h.ILi;
    this.IJT = new Timer("TalkRoomService_HelloTimer");
    this.IJV = new Timer("TalkRoomService_talkDurationTimer");
    this.IJW = new g();
    this.IJX = 0;
    this.IJY = false;
    this.IKa = null;
    this.IKb = new HashSet();
    this.IKc = false;
    this.IKd = true;
    this.IKe = true;
    this.IKf = null;
    this.IKg = null;
    this.IKh = null;
    this.IKi = null;
    this.IKj = 0;
    this.mIsMute = false;
    this.IKk = false;
    this.IKl = true;
    this.IKm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62550);
        if ((f.this.dSZ()) && (f.s(f.this)))
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
          h.acX(-2003);
          f.this.IJO.ada(401);
          f.this.aV(f.b(f.this), 3, 108);
        }
        AppMethodBeat.o(62550);
      }
    };
    this.IKn = null;
    this.IKo = new Runnable()
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
        if (!f.this.dSZ())
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
              if (f.a(f.this, locale.seB, locale.sHe, locale.ztl, f.acV(locale.ILK)))
              {
                localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
                com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
              }
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.pb.common.b.e.fll().a((com.tencent.pb.common.b.d)localObject1);
          AppMethodBeat.o(62587);
          return;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        AppMethodBeat.o(62587);
      }
    };
    com.tencent.pb.common.b.e.fll().a(201, this);
    com.tencent.pb.common.b.e.fll().a(202, this);
    com.tencent.pb.common.b.e.fll().a(203, this);
    com.tencent.pb.common.b.e.fll().a(204, this);
    com.tencent.pb.common.b.e.fll().a(205, this);
    com.tencent.pb.common.b.e.fll().a(206, this);
    com.tencent.pb.common.b.e.fll().a(207, this);
    com.tencent.pb.common.b.e.fll().a(208, this);
    com.tencent.pb.common.b.e.fll().a(210, this);
    com.tencent.pb.common.b.e.fll().a(209, this);
    com.tencent.pb.common.b.e.fll().a(211, this);
    com.tencent.pb.common.b.e.fll().a(212, this);
    com.tencent.pb.common.b.e.fll().a(213, this);
    com.tencent.pb.common.b.e.fll().a(214, this);
    com.tencent.pb.common.b.e.fll().a(800, this);
    com.tencent.pb.common.b.e.fll().a(801, this);
    Object localObject = c.fpJ();
    g localg = this.IJW;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).IJf = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      fpR();
      if (this.IHW == null) {
        this.IHW = ((com.tencent.f.a.a)com.tencent.f.f.aOl("EventCenter"));
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.IHW.a(this, IJZ);
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
  
  private boolean Ob()
  {
    AppMethodBeat.i(62739);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Iki;
      if (locale == null) {
        break label99;
      }
      this.IJO.znN = locale.cRO();
      this.IJO.znJ = locale.cRP();
      bool = locale.cRM();
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
  
  private void VP()
  {
    AppMethodBeat.i(62727);
    this.IJp.remove(this.seB);
    this.IJX = 0;
    this.mIsMute = false;
    setState(0);
    this.IJw = false;
    a(this.IJy, 0, 0L, null, null);
    this.IJy = null;
    this.IjW = 0;
    this.IJz = 0;
    this.IJA = 0;
    this.IJB = 0;
    this.IJD = true;
    this.IKd = true;
    this.IJC = 0L;
    this.IJE = 0;
    this.IJv = false;
    this.IKk = false;
    this.IKl = true;
    fpT();
    this.mHandler.removeMessages(1);
    if (this.IJP != null) {
      this.IJP.fpH();
    }
    fpY();
    fpX();
    fpZ();
    fqc();
    this.sRS = false;
    this.IKc = false;
    this.IJF = 0;
    AppMethodBeat.o(62727);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    AppMethodBeat.i(62747);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.roomId, paramh.sAY, false)) {
        this.IJO.ad(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62747);
      return;
    }
    paramObject = (a.al)paramObject;
    if (!b(paramObject.groupId, paramObject.zkT, paramObject.zkU, false))
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.zkT), Integer.valueOf(this.sHe) });
      AppMethodBeat.o(62747);
      return;
    }
    this.IJO.ad(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.IjW, paramObject.zkT, paramObject.zkU, paramObject.IlV, paramObject.IlX, paramObject.IkD, false, false);
    a(paramObject.IlW, paramObject.Imd, paramObject.Ime);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect type:", Integer.valueOf(this.IJF) });
    if (this.IJF == 0)
    {
      paramh = new byte[paramObject.IlZ.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.IlZ.length)
      {
        paramh[paramInt1] = ((byte)paramObject.IlZ[paramInt1]);
        paramInt1 += 1;
      }
      localObject1 = new int[paramObject.Imi.length];
      paramInt1 = 0;
      while (paramInt1 < paramObject.Imi.length)
      {
        localObject1[paramInt1] = paramObject.Imi[paramInt1];
        paramInt1 += 1;
      }
      if (this.IJP != null)
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp redirect engine close ret:", Integer.valueOf(this.IJP.Close()) });
        localObject2 = paramObject.IlV;
        localObject3 = paramObject.Ilk;
        if ((paramObject.IlY & 0x2) == 0) {
          break label547;
        }
      }
      label547:
      for (boolean bool = true;; bool = false)
      {
        a(0, (a.ay[])localObject2, (a.av)localObject3, paramh, bool, paramObject.groupId, paramObject.zkT, paramObject.zkU, paramObject.Imf, paramObject.Img, paramObject.Imh, (int[])localObject1, paramObject.Ilm, this.IJG);
        AppMethodBeat.o(62747);
        return;
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRedirectResp engine close but nullptr" });
        AppMethodBeat.o(62747);
        return;
      }
    }
    paramInt1 = k.kR(com.tencent.pb.common.c.c.ztG);
    com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "amyfwang,Redirect::netType:", Integer.valueOf(paramInt1) });
    paramObject = this.IJP;
    paramh = this.IKg;
    Object localObject1 = this.IKf;
    Object localObject2 = this.IKi;
    Object localObject3 = this.IKh;
    if (paramObject.IJa != null) {
      paramObject.IJa.Redirect(paramh, (short[])localObject1, (String[])localObject2, (short[])localObject3, paramInt1);
    }
    AppMethodBeat.o(62747);
  }
  
  private void a(int paramInt, a.ab paramab, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(189099);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.seB, Integer.valueOf(parame.sHe), Long.valueOf(parame.ztl), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.a.K(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111), Integer.valueOf(14287), Integer.valueOf(-1112) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.acW(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramab.groupId, Integer.valueOf(paramab.zkT), Long.valueOf(paramab.zkU) });
      this.IJW.n(-14255, paramab);
      AppMethodBeat.o(189099);
      return;
    }
    if (paramInt == 14287)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14287), paramab.groupId, Integer.valueOf(paramab.zkT), Long.valueOf(paramab.zkU) });
      this.IJW.n(-14287, paramab);
      AppMethodBeat.o(189099);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramab.groupId, Integer.valueOf(paramab.zkT), Long.valueOf(paramab.zkU) });
      this.IJW.n(-14256, paramab);
      AppMethodBeat.o(189099);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.seB, parame.sHe, parame.ztl, acU(parame.ILK)))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.seB, " mGroupId: ", this.seB, Integer.valueOf(parame.sHe), Integer.valueOf(this.sHe), Long.valueOf(parame.ztl), Long.valueOf(this.ztl) });
        AppMethodBeat.o(189099);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.seB, Integer.valueOf(parame.sHe), Long.valueOf(parame.ztl) });
        AppMethodBeat.o(189099);
        return;
      }
      this.IJO.ad(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.IJO.ada(322);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.seB, Integer.valueOf(parame.sHe), Long.valueOf(parame.ztl) });
      a(parame.seB, parame.sHe, parame.ztl, true);
      if (paramInt == 14251)
      {
        this.IJW.n(-1000, null);
        AppMethodBeat.o(189099);
        return;
      }
      if (paramInt == 14252)
      {
        this.IJW.n(-1200, null);
        AppMethodBeat.o(189099);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramab != null) {
          parame = Integer.valueOf(paramab.Imb);
        }
        this.IJW.n(-1500, parame);
        AppMethodBeat.o(189099);
        return;
      }
      this.IJW.n(-200, null);
      AppMethodBeat.o(189099);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramab.groupId, Integer.valueOf(paramab.zkT), Long.valueOf(paramab.zkU) });
      AppMethodBeat.o(189099);
      return;
    }
    if (!b(paramab.groupId, paramab.zkT, paramab.zkU, acU(paramab.tjk)))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramab.groupId, " mGroupId: ", this.seB, Integer.valueOf(paramab.zkT), Integer.valueOf(this.sHe), Long.valueOf(paramab.zkU), Long.valueOf(this.ztl) });
      a(paramab.groupId, paramab.zkT, paramab.zkU, 111, false);
      h.acW(-1110);
      AppMethodBeat.o(189099);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramab.groupId, Integer.valueOf(paramab.zkT), Long.valueOf(paramab.zkU) });
      AppMethodBeat.o(189099);
      return;
    }
    this.IJO.ad(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramab.IlW == null) || (paramab.IlW.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramab.groupId, Integer.valueOf(paramab.zkT), Long.valueOf(paramab.zkU) });
      h.acW(-1605);
      this.IJO.zCo = 329;
      a(paramab.groupId, paramab.zkT, paramab.zkU, 116, true);
      this.IJW.n(-200, null);
      AppMethodBeat.o(189099);
      return;
    }
    this.seB = paramab.groupId;
    this.IKa = paramab.groupId;
    this.sHe = paramab.zkT;
    this.ztl = paramab.zkU;
    setState(4);
    a(paramab.IlW, paramab.Imd, paramab.Ime);
    a(paramab.groupId, null, this.IjW, paramab.zkT, paramab.zkU, paramab.IlV, paramab.IlX, paramab.IkD, false, true);
    parame = this.IJW;
    localObject = new g.8(parame, c.fpJ().aOw(paramab.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramab.IlZ.length];
      paramInt = 0;
      while (paramInt < paramab.IlZ.length)
      {
        parame[paramInt] = ((byte)paramab.IlZ[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramab.Imi.length];
    paramInt = 0;
    while (paramInt < paramab.Imi.length)
    {
      localObject[paramInt] = paramab.Imi[paramInt];
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd, general policy cnt:", Integer.valueOf(paramab.Imi.length), " redirect type:", Integer.valueOf(localObject[talk.tOi]), " SimpleRedirect value:", Integer.valueOf(talk.tOi) });
    a.ay[] arrayOfay = paramab.IlV;
    a.av localav = paramab.Ilk;
    if ((paramab.IlY & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfay, localav, parame, bool, paramab.groupId, paramab.zkT, paramab.zkU, paramab.Imf, paramab.Img, paramab.Imh, (int[])localObject, paramab.Ilm, this.IJG);
      if (paramab.Imc != 0)
      {
        com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramab.Imc });
        IJu = paramab.Imc * 1000;
      }
      fpW();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl) });
      AppMethodBeat.o(189099);
      return;
    }
  }
  
  private void a(int paramInt, a.aj paramaj)
  {
    AppMethodBeat.i(189098);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.IJW.ir(null);
      AppMethodBeat.o(189098);
      return;
    }
    paramaj = paramaj.Imr;
    if ((paramaj == null) || (paramaj.length == 0))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(189098);
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
        a(localObject.groupId, null, 0, localObject.zkT, localObject.zkU, localObject.IlV, null, null, false, false);
        localArrayList.add(c.fpJ().aOw(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.IJW.ir(localArrayList);
    AppMethodBeat.o(189098);
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
    //   62: getfield 439	com/tencent/wecall/talkroom/model/f:IJP	Lcom/tencent/wecall/talkroom/model/b;
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
    //   166: getfield 235	com/tencent/wecall/talkroom/model/f:IJO	Lcom/tencent/wecall/talkroom/model/h;
    //   169: sipush 202
    //   172: invokevirtual 674	com/tencent/wecall/talkroom/model/h:ada	(I)V
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
    //   206: getfield 253	com/tencent/wecall/talkroom/model/f:IJW	Lcom/tencent/wecall/talkroom/model/g;
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
    Iki = parame;
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
    if (!acU(paramInt3)) {
      this.IJO.fqk();
    }
    this.IJO.fqj();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.IJP.fpG(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.fll().a(paramString1);
    c(paramString1);
    AppMethodBeat.o(62731);
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.sHe = paramInt;
    this.ztl = paramLong;
    this.seB = paramString2;
    this.IJy = paramString1;
    this.IJx = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62754);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(62754);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(189102);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(189102);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfay.length;
    int i = 0;
    while (i < j)
    {
      a.ay localay = paramArrayOfay[i];
      if (localay != null) {
        localStringBuffer.append(" memberId:" + localay.nPB + " uuid: " + localay.Imu + " status: " + localay.status + "   mem.inviteTime:" + localay.Inn + "  mem.reason: " + localay.bvJ + "  mem.inviteuuid: " + localay.Inz + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfay.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(189102);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.ay[] paramArrayOfay, a.az[] paramArrayOfaz, a.aw paramaw, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(189100);
    a(paramString1, paramInt2, paramLong, paramArrayOfay);
    c localc = c.fpJ();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.seB == null) || (!this.seB.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramaw, paramArrayOfay, paramArrayOfaz, paramBoolean1, bool);
      paramString2 = this.seB;
      i = this.sHe;
      l = this.ztl;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfay == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfay.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.IJD) });
      if (c.fpJ().cY(this.seB, false))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.IJD), " mGroupId: ", this.seB, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.IJD)
        {
          this.IJD = false;
          this.sRS = true;
          this.IJY = k.fqo();
          this.IJB = this.IJz;
          fqb();
        }
      }
      if (paramArrayOfay != null) {
        break label380;
      }
      AppMethodBeat.o(189100);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfay.length > 0) && (this.IJP != null)) {
      a(paramArrayOfay);
    }
    AppMethodBeat.o(189100);
  }
  
  private void a(a.ay[] paramArrayOfay)
  {
    AppMethodBeat.i(189101);
    if (paramArrayOfay == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(189101);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfay.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfay.length)
    {
      arrayOfInt[i] = paramArrayOfay[i].nPB;
      localStringBuffer.append(paramArrayOfay[i].nPB);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.IJP == null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(189101);
      return;
    }
    this.IJP.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(189101);
  }
  
  private void a(a.p[] paramArrayOfp1, a.p[] paramArrayOfp2, int paramInt)
  {
    AppMethodBeat.i(189103);
    if (paramArrayOfp1 == null) {}
    for (int i = 0;; i = paramArrayOfp1.length)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfp1 != null) && (paramArrayOfp1.length > 0)) {
        break;
      }
      AppMethodBeat.o(189103);
      return;
    }
    this.IKg = new String[paramArrayOfp1.length];
    this.IKf = new short[paramArrayOfp1.length];
    this.IKi = new String[paramArrayOfp2.length];
    this.IKh = new short[paramArrayOfp2.length];
    this.IKj = paramInt;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.IKj) });
    int j = paramArrayOfp1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.p localp = paramArrayOfp1[paramInt];
      this.IKg[i] = localp.Ilg;
      this.IKf[i] = ((short)localp.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData ip: ", localp.Ilg, " addr.port: ", Integer.valueOf(localp.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfp2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfp1 = paramArrayOfp2[paramInt];
      this.IKi[i] = paramArrayOfp1.Ilg;
      this.IKh[i] = ((short)paramArrayOfp1.port);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", paramArrayOfp1.Ilg, " tcpAddr.port: ", Integer.valueOf(paramArrayOfp1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.IKg), Arrays.toString(this.IKf), this.seB, this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl), Arrays.toString(this.IKi), Arrays.toString(this.IKh), Integer.valueOf(this.IKj) });
    AppMethodBeat.o(189103);
  }
  
  private boolean a(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(189105);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(189105);
      return false;
    }
    this.IJF = paramArrayOfInt[talk.tOi];
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit general policy cnt:", Integer.valueOf(paramArrayOfInt.length), ", redirect type:", this.IJF + " wifigateway:" + paramInt5 });
    paramBoolean = b(paramArrayOfay, paramav, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
    AppMethodBeat.o(189105);
    return paramBoolean;
  }
  
  private void aZs()
  {
    AppMethodBeat.i(62767);
    Ob();
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
            if ((com.tencent.pb.common.a.a.Ijx) && (localb.IJa != null)) {
              break label140;
            }
          }
          for (;;)
          {
            if (f.this.IKd)
            {
              f.this.IKd = false;
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt) });
            }
            AppMethodBeat.o(62659);
            return;
            label140:
            localb.IJa.SendAudio(paramAnonymousArrayOfByte, s, 0);
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
      this.IJO.ada(101);
      h.acX(-2001);
      this.IJW.n(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.IJO;
    }
    for (localh.ILj &= 0xFFFFFFFE;; localh.ILj |= 0x1)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(62767);
      return;
      localh = this.IJO;
    }
  }
  
  private static boolean acU(int paramInt)
  {
    return paramInt != 1;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(62738);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Iki;
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
      com.tencent.pb.talkroom.sdk.e locale = Iki;
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
      paramBoolean = com.tencent.pb.common.c.f.lO(paramString, this.seB);
      AppMethodBeat.o(62771);
      return paramBoolean;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.seB, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.sHe), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.ztl) });
    if ((com.tencent.pb.common.c.f.lO(paramString, this.seB)) && (paramInt == this.sHe) && (paramLong == this.ztl))
    {
      AppMethodBeat.o(62771);
      return true;
    }
    AppMethodBeat.o(62771);
    return false;
  }
  
  private boolean b(a.ay[] paramArrayOfay, a.av paramav, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(189106);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.seB, " ip: ", Arrays.toString(this.IKg), " ports: ", Arrays.toString(this.IKf), " tcpIp: ", Arrays.toString(this.IKi), " tcpPorts: ", Arrays.toString(this.IKh), " tcpStartTime: ", Integer.valueOf(this.IKj), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.flE();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfay != null) && (paramArrayOfay.length > 0))
    {
      localObject1 = new int[paramArrayOfay.length];
      j = 0;
      while (j < paramArrayOfay.length)
      {
        localObject1[j] = paramArrayOfay[j].nPB;
        if (com.tencent.pb.common.c.f.equals(paramArrayOfay[j].Imu, (String)localObject2)) {
          i = paramArrayOfay[j].nPB;
        }
        j += 1;
      }
      paramArrayOfay = (a.ay[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.fpJ().aOr(this.seB);
      this.IJO.nPB = j;
      for (;;)
      {
        try
        {
          localObject2 = this.IJP;
          locala = this.IJQ;
          localObject3 = c.fpJ();
          localObject1 = this.seB;
          localObject3 = ((c)localObject3).aOp((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.IKg;
          arrayOfShort1 = this.IKf;
          arrayOfString = this.IKi;
          arrayOfShort2 = this.IKh;
          m = this.IKj;
          localObject1 = null;
          if (paramav == null) {
            continue;
          }
          paramav = new i(paramav.ImF, paramav.hcd, paramav.hce, paramav.ImG, paramav.ImH, paramav.ImI, paramav.ImJ, paramav.ImK, paramav.ImL, paramav.ImM, paramav.ImN, paramav.ImO);
          n = k.kR(com.tencent.pb.common.c.c.ztG);
          localObject1 = ((b)localObject2).IJa;
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
          paramInt1 = ((b)localObject2).IJa.Open(locala, paramav, i, j, paramInt1, paramLong, (String[])localObject3, arrayOfShort1, 0, paramArrayOfay, paramArrayOfByte1, paramBoolean, n, arrayOfString, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4, paramInt5);
          continue;
          paramArrayOfay.handler.post(paramav);
          continue;
          AppMethodBeat.o(189106);
          return false;
        }
        paramArrayOfay = this.IJW;
        paramav = new g.3(paramArrayOfay, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramav.run();
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.acZ(-3002);
        }
        if (paramInt1 == 0) {
          this.IJO.zCr = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(189106);
        return true;
        localObject3 = ((TalkRoom)localObject3).aOo(com.tencent.pb.a.a.a.flE());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).IJg;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.ay)localObject3).CrQ) });
            i = ((a.ay)localObject3).CrQ;
            continue;
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramav = (a.av)localObject1;
          }
        }
      }
      paramArrayOfay = null;
    }
  }
  
  private void c(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(62775);
    this.mHandler.removeCallbacks(this.IKo);
    this.IKn = paramd;
    this.mHandler.postDelayed(this.IKo, 3000L);
    AppMethodBeat.o(62775);
  }
  
  private boolean cQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(62732);
    if (paramInt == 100)
    {
      AppMethodBeat.o(62732);
      return true;
    }
    if (acU(paramInt))
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
      boolean bool = aOy(paramString);
      AppMethodBeat.o(62732);
      return bool;
    }
    AppMethodBeat.o(62732);
    return false;
  }
  
  private void dNb()
  {
    AppMethodBeat.i(62741);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "releaseConpent" });
    try
    {
      Ob();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          fpV();
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
  
  private void fpR()
  {
    AppMethodBeat.i(189097);
    this.IJI = -1;
    this.IJJ = -1;
    this.IJK = -1;
    this.IJL = -1;
    this.IJM = -1;
    this.IJN = -1;
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "multitalk voiceMsg local seq reset" });
    AppMethodBeat.o(189097);
  }
  
  private int fpU()
  {
    AppMethodBeat.i(62734);
    if (this.IJC == 0L)
    {
      AppMethodBeat.o(62734);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.IJC) / 1000L);
    AppMethodBeat.o(62734);
    return i;
  }
  
  private boolean fpV()
  {
    AppMethodBeat.i(62737);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Iki;
      if (locale == null) {
        break label99;
      }
      this.IJO.znU = locale.cRN();
      this.IJO.znK = locale.cRQ();
      bool = locale.cRL();
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
  
  private void fpW()
  {
    AppMethodBeat.i(62759);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.IJR != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(62759);
      return;
    }
    try
    {
      this.IJR = new TimerTask()
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
      this.IJT.schedule(this.IJR, 0L, IJu);
      AppMethodBeat.o(62759);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(62759);
    }
  }
  
  private void fpX()
  {
    AppMethodBeat.i(62760);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.IJS != null) {
        this.IJS.cancel();
      }
      this.IJS = null;
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
  
  private void fpY()
  {
    AppMethodBeat.i(62761);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.IJR != null) {
        this.IJR.cancel();
      }
      this.IJR = null;
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
  
  private void fpZ()
  {
    AppMethodBeat.i(62762);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.IJU != null) {
        this.IJU.cancel();
      }
      this.IJU = null;
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
  
  private void fqa()
  {
    AppMethodBeat.i(62768);
    fpV();
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
            AtomicInteger localAtomicInteger1 = this.IKH;
            AtomicInteger localAtomicInteger2 = localAtomicInteger;
            if (com.tencent.pb.common.a.a.Ijx) {
              if (localb.IJa == null)
              {
                break label169;
                if ((f.this.IKe) && (i >= 0))
                {
                  f.this.IKe = false;
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramAnonymousInt), " ret: ", Integer.valueOf(i) });
                }
                AppMethodBeat.o(62788);
                return i;
              }
              else
              {
                i = localb.IJa.GetAudioData(paramAnonymousArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
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
      this.IJO.ada(101);
      h.acX(-2001);
      localObject = this.IJO;
      ((h)localObject).ILj |= 0x1;
      this.IJW.n(-500, null);
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(62768);
  }
  
  private void fqb()
  {
    AppMethodBeat.i(62769);
    if (this.IJU != null)
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(62769);
      return;
    }
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.IJn, " mIsHoldOn: ", Boolean.valueOf(this.IKk) });
    this.IJU = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(62661);
        if (!f.this.IKk)
        {
          f.a(f.this, f.n(f.this) + 1);
          if (f.o(f.this)) {
            f.b(f.this, f.p(f.this) + 1);
          }
          if ((f.q(f.this) == 3) || (f.q(f.this) == 2))
          {
            f.c(f.this, f.r(f.this) + 1);
            f.this.IJO.zCC = f.r(f.this);
          }
          f.this.IJO.ILn = (f.n(f.this) * 1000);
          f.this.IJO.zCB = f.n(f.this);
        }
        if (f.this.IJn != null) {
          f.n(f.this);
        }
        AppMethodBeat.o(62661);
      }
    };
    this.IJV.scheduleAtFixedRate(this.IJU, 1000L, 1000L);
    AppMethodBeat.o(62769);
  }
  
  private void fqc()
  {
    AppMethodBeat.i(62774);
    this.mHandler.removeCallbacks(this.IKo);
    this.IKn = null;
    AppMethodBeat.o(62774);
  }
  
  private static void fqd()
  {
    AppMethodBeat.i(62777);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.c.ztG.getSystemService("audio");
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
  
  public static boolean fqe()
  {
    AppMethodBeat.i(62778);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.c.ztG.getSystemService("audio")).isSpeakerphoneOn();
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
  
  public static com.tencent.pb.talkroom.sdk.e fqf()
  {
    return Iki;
  }
  
  private boolean gD(String paramString, int paramInt)
  {
    AppMethodBeat.i(62735);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62735);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.IjW);
    boolean bool = com.tencent.pb.common.b.e.fll().a(localc);
    this.IJO.ad(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.sHe, this.ztl, true);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62735);
    return bool;
  }
  
  static String[] is(List<String> paramList)
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
  
  private void q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62772);
    try
    {
      String str = c.fpJ().p(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.zgY), " mTalkDuration: ", Integer.valueOf(this.IJz), " msgKey: ", str });
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
    if (this.sRS)
    {
      localObject1 = localf;
      if (this.IJP == null) {}
    }
    try
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo" });
      localObject2 = this.IJP;
      localObject1 = new com.tencent.pb.talkroom.sdk.f();
      if ((paramArrayOfInt != null) && (((b)localObject2).IJa != null)) {
        break label176;
      }
      com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", ((b)localObject2).IJa });
      paramArrayOfInt = (int[])localObject1;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "receiveVideo error: ", paramArrayOfInt });
        paramArrayOfInt = localf;
        continue;
        Object localObject3 = ((TalkRoom)localObject3).fpE().iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localay = (a.ay)((Iterator)localObject3).next();
        } while ((localay == null) || (localay.nPB != i));
        com.tencent.pb.common.c.b.d("TalkRoomManager", new Object[] { "getUsrNameByMemberId wxUserName:", localay.Imu, " groupId: ", localObject2, " memberId: ", Integer.valueOf(i) });
        if (localay.Imu == null) {
          break;
        }
        localObject2 = localay.Imu;
        continue;
        int i = paramArrayOfInt.length;
      }
    }
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.sRS), " decInfo: ", paramArrayOfInt, " engine: ", this.IJP });
    localObject1 = paramArrayOfInt;
    AppMethodBeat.o(62745);
    return localObject1;
    label176:
    ((com.tencent.pb.talkroom.sdk.f)localObject1).ret = ((b)localObject2).IJa.videoDecode(paramArrayOfInt);
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Ion = paramArrayOfInt;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Ioo = ((b)localObject2).IJa.field_remoteImgLength;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Iop = ((b)localObject2).IJa.field_remoteImgWidth;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Ioq = ((b)localObject2).IJa.field_remoteImgHeight;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Ior = (((b)localObject2).IJa.field_remoteImgChannel & 0x3FFF);
    localObject3 = c.fpJ();
    Object localObject2 = a.fpu().seB;
    i = ((com.tencent.pb.talkroom.sdk.f)localObject1).Ior;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      com.tencent.pb.common.c.b.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i) });
    }
    for (;;)
    {
      ((com.tencent.pb.talkroom.sdk.f)localObject1).Iol = ((String)localObject2);
      if (paramArrayOfInt == null)
      {
        i = 0;
        com.tencent.pb.common.c.b.d("simon:TalkRoomContext", new Object[] { "steve:receiveVideo imgBuffer size:", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localObject1 });
        paramArrayOfInt = (int[])localObject1;
        break;
        localObject3 = ((c)localObject3).aOp((String)localObject2);
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
    if (this.sRS)
    {
      i = j;
      if (this.IJP == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localb = this.IJP;
        if ((paramArrayOfByte != null) && (localb.IJa != null)) {
          continue;
        }
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.IJa });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.sRS), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.IJP });
      i = paramInt1;
      AppMethodBeat.o(62743);
      return i;
      paramInt1 = localb.IJa.SendVideo(paramArrayOfByte, paramShort, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62744);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.sRS) && (this.IJP != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.IJP;
        if ((paramArrayOfByte == null) || (localb.IJa == null))
        {
          com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.IJa });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.sRS), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.IJP });
          AppMethodBeat.o(62744);
          return paramArrayOfByte;
        }
        paramInt1 = localb.IJa.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.Ios = paramArrayOfInt;
        paramArrayOfByte.Iot = localb.IJa.field_localImgWidth;
        paramArrayOfByte.Iou = localb.IJa.field_localImgHeight;
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
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.sHe), Integer.valueOf(paramInt1), Long.valueOf(this.ztl), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    this.IJG = paramInt4;
    if (!com.tencent.pb.a.a.a.flF())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.flF()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.flG()) });
      h.a(paramString1, "", this.sHe, this.ztl, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = b.IKQ;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((acU(paramInt3)) && (paramInt3 != 100) && (dSZ()))
    {
      h.a(paramString1, "", this.sHe, this.ztl, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = b.IKU;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (!cQ(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.sHe, this.ztl, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = b.IKV;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.sHe, this.ztl, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = b.IKW;
      AppMethodBeat.o(183718);
      return paramString1;
    }
    if (acU(paramInt3))
    {
      this.IJO.reset();
      xz(false);
    }
    fpS();
    if (!dNe())
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (acU(paramInt3))
      {
        h.a(paramString1, "", this.sHe, this.ztl, new String[] { "enter", "req", "false", "initEnginefail" });
        xz(false);
      }
      for (;;)
      {
        paramString1 = b.IKY;
        AppMethodBeat.o(183718);
        return paramString1;
        this.IJO.ad(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.seB = paramString1;
    Object localObject;
    long l;
    label705:
    label711:
    boolean bool;
    if (!acU(paramInt3))
    {
      localObject = aOx(paramString1);
      if (localObject == null)
      {
        paramInt4 = 0;
        this.sHe = paramInt4;
        if (localObject != null) {
          break label875;
        }
        l = 0L;
        this.ztl = l;
        this.IKa = paramString1;
        this.IjW = paramInt2;
        setState(3);
        if (!acU(paramInt3)) {
          break label898;
        }
        bool = true;
        label738:
        this.zgY = bool;
        if (this.zgY) {
          this.IJO.fqh();
        }
        if ((!this.zgY) || (c.fpJ().cY(this.seB, true))) {
          break label904;
        }
        localObject = new c();
        ((c)localObject).groupId = paramString1;
        ((c)localObject).roomId = paramInt1;
        ((c)localObject).sAY = paramLong;
        ((c)localObject).tjk = paramInt3;
        ((c)localObject).IkG = paramInt2;
        ((c)localObject).ILa = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = localObject;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = b.IKP;
      AppMethodBeat.o(183718);
      return paramString1;
      paramInt4 = ((e)localObject).roomId;
      break;
      label875:
      l = ((e)localObject).sAY;
      break label705;
      this.sHe = paramInt1;
      this.ztl = paramLong;
      break label711;
      label898:
      bool = false;
      break label738;
      label904:
      a(paramString1, this.sHe, this.ztl, paramInt2, paramInt3, paramString2);
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
        paramString = com.tencent.pb.common.c.a.K(new Integer[] { Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542) });
        i = paramd.getType();
        if (paramString.containsKey(Integer.valueOf(i))) {
          h.acW(((Integer)paramString.get(Integer.valueOf(i))).intValue());
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
          if (com.tencent.pb.common.c.f.lO(this.IJy, paramString.IJy))
          {
            this.IJO.ada(301);
            this.IJO.ad(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            gD(paramString.IJy, 1001);
            if (!paramString.ILJ) {
              this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.IJW.n(-100, null);
          }
          AppMethodBeat.o(62742);
          return;
          paramString = "";
        }
        else if (paramd.getType() == 209)
        {
          paramString = (com.tencent.wecall.talkroom.a.g)paramd;
          this.IJW.gC(paramString.seB, paramInt2);
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
      if (!b(paramString.seB, paramString.sHe, paramString.ztl, false)) {
        h.a(paramString.seB, paramString.sHe, paramString.ztl, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.IJW.a(paramString.ILI, c.fpJ().aOw(paramString.seB));
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.seB, paramString.sHe, paramString.ztl, false))
      {
        this.IJO.ad(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.IJW.n(-300, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.seB, paramString.sHe, paramString.ztl, acU(paramString.ILK))) && (this.state == 3))
      {
        this.IJO.ada(302);
        this.IJW.n(-200, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.IJW.ir(null);
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 213)
    {
      if (com.tencent.pb.common.c.f.equals(((com.tencent.wecall.talkroom.a.j)paramd).seB, this.seB))
      {
        this.IJO.ad(new String[] { "sendmsg", "resp", "-1", String.valueOf(this.state) });
        this.IJW.n(-700, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (b(paramString.groupId, paramString.roomId, paramString.sAY, false)) {
        this.IJO.ad(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (m)paramd;
      if (b(paramString.seB, paramString.sHe, paramString.ztl, false)) {
        this.IJW.n(-800, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      if (b(paramString.seB, paramString.sHe, paramString.ztl, false)) {
        this.IJW.n(-1600, null);
      }
      AppMethodBeat.o(62742);
      return;
    }
    if (paramd.getType() == 801)
    {
      paramString = (com.tencent.wecall.talkroom.a.k)paramd;
      if (b(paramString.seB, paramString.sHe, paramString.ztl, false)) {
        this.IJW.n(-1601, null);
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
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).IjU != null))
      {
        paramString = (a.aa)((com.tencent.pb.common.b.d)localObject1).IjU;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).IJy });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).ILJ) {
          break label3210;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.a.K(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.acW(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          IJo = null;
          if (paramInt2 == 0) {
            break label3477;
          }
          if (com.tencent.pb.common.c.f.lO(this.IJy, ((com.tencent.wecall.talkroom.a.d)localObject1).IJy)) {
            break label3216;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.IJy, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).IJy, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1459:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.IjU != null)) {
        a(paramInt2, (a.ab)paramString.IjU, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.IjU != null))
      {
        localObject1 = (a.y)paramString.IjU;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.a.K(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303), Integer.valueOf(14651), Integer.valueOf(-1309) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.acW(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label4486;
        }
        if (b(paramString.seB, paramString.sHe, paramString.ztl, false))
        {
          this.IJO.ad(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (paramInt2 != 14651) {
            break label4472;
          }
          com.tencent.pb.common.c.b.e("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14651), ((a.y)localObject1).groupId, Integer.valueOf(((a.y)localObject1).zkT), Long.valueOf(((a.y)localObject1).zkU) });
          this.IJW.n(-301, localObject1);
        }
      }
    }
    label1850:
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.IjU != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ac)paramString.IjU).groupId, this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.a.K(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.acW(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (n)paramd;
      if ((paramString != null) && (paramString.IjU != null))
      {
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.am)paramString.IjU).groupId, this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        fpX();
        i = 0;
        if (paramInt2 != 14800) {
          break label4703;
        }
        i = -1401;
        label2210:
        if (i != 0)
        {
          this.IJO.ada(324);
          h.acW(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.IjU != null))
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.seB, " roomid: ", Integer.valueOf(paramString.sHe), " roomKey: ", Long.valueOf(paramString.ztl) });
        if (paramInt2 != 18950) {
          break label4718;
        }
        if (!b(paramString.seB, paramString.sHe, paramString.ztl, false)) {
          h.a(paramString.seB, paramString.sHe, paramString.ztl, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.fpJ().aOw(paramString.seB);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.seB, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.IJW.a(paramString.ILI, (MultiTalkGroup)localObject1);
        }
      }
    }
    label2468:
    if (paramd.getType() == 207)
    {
      paramString = (com.tencent.wecall.talkroom.a.i)paramd;
      if ((paramString != null) && (paramString.IjU != null))
      {
        if (paramInt2 == 18100) {
          h.acW(-1501);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 208)
    {
      paramString = (com.tencent.wecall.talkroom.a.c)paramd;
      if ((paramString != null) && (paramString.IjU != null))
      {
        if (paramInt2 == 18300) {
          h.acW(-1531);
        }
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 209)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).IjU != null))
      {
        paramString = (a.ad)((com.tencent.pb.common.b.d)localObject1).IjU;
        if (paramInt2 == 17900) {
          h.acW(-1511);
        }
        if (paramInt2 == 0) {
          break label5124;
        }
        this.IJW.gC(((com.tencent.wecall.talkroom.a.g)localObject1).seB, paramInt2);
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 210)
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 == 19100) {
        h.acW(-1541);
      }
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (paramString != null) {
        a(paramInt1, paramInt2, paramd.IjU, paramString);
      }
    }
    if (paramd.getType() == 212) {
      a(paramInt2, (a.aj)paramd.IjU);
    }
    if (paramd.getType() == 213)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break label5223;
      }
      if (com.tencent.pb.common.c.f.equals(paramString.seB, this.seB))
      {
        this.IJO.ad(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.IJW.n(-700, null);
      }
    }
    label2909:
    if (paramd.getType() == 214)
    {
      paramString = (a.ah)paramd.IjU;
      localObject1 = (m)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (!b(((m)localObject1).seB, ((m)localObject1).sHe, ((m)localObject1).ztl, false)) {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((m)localObject1).seB, Integer.valueOf(((m)localObject1).sHe) });
      }
    }
    else if (paramd.getType() == 800)
    {
      paramString = (l)paramd;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
      if (b(paramString.seB, paramString.sHe, paramString.ztl, false)) {
        break label5624;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.seB, Integer.valueOf(paramString.sHe) });
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
        if (!b(paramString.seB, paramString.sHe, paramString.ztl, false))
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleSubscribeGeneralVideo isCurrentRoom is not same", paramString.seB, Integer.valueOf(paramString.sHe) });
          AppMethodBeat.o(62742);
          return;
          i = 0;
          break;
          if (paramInt2 != -1)
          {
            this.IJO.ada(321);
            this.IJO.ad(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          if (this.state != 1)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).IJy });
            if (i == 0) {
              break label1459;
            }
            this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          a(this.seB, this.sHe, this.ztl, true);
          if (paramInt2 == 14051) {
            this.IJW.n(-900, null);
          }
          for (;;)
          {
            if (i == 0) {
              break label3475;
            }
            this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break;
            if (paramInt2 == 14052) {
              this.IJW.n(-1100, null);
            } else if (paramInt2 == 14053) {
              this.IJW.n(-1300, paramString);
            } else if (paramInt2 == 14504) {
              this.IJW.n(-1400, null);
            } else {
              this.IJW.n(-100, null);
            }
          }
          break label1459;
          if (!com.tencent.pb.common.c.f.lO(this.IJy, paramString.IkB))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.IJy, " resp.clientGroupId: ", paramString.IkB, Integer.valueOf(paramString.zkT), Long.valueOf(paramString.zkU) });
            a(paramString.groupId, paramString.zkT, paramString.zkU, 110, false);
            if (i == 0) {
              break label1459;
            }
            this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          this.IJO.ad(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (this.state != 1)
          {
            h.acW(-1003);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.IkB, Integer.valueOf(paramString.zkT), Long.valueOf(paramString.zkU) });
            if (i == 0) {
              break label1459;
            }
            this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1459;
          }
          if ((paramString.IlW == null) || (paramString.IlW.length == 0))
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.IkB, Integer.valueOf(paramString.zkT), Long.valueOf(paramString.zkU) });
            h.acW(-1605);
            this.IJO.zCo = 329;
            a(paramString.groupId, paramString.zkT, paramString.zkU, 116, true);
            if (i != 0) {
              this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.IJW.n(-100, null);
            break label1459;
          }
          a(paramString.IkB, paramString.zkT, paramString.zkU, paramString.groupId, paramString.IkD.ImY);
          this.IKa = paramString.groupId;
          this.IjW = paramString.IkG;
          setState(4);
          a(paramString.IlW, paramString.Imd, paramString.Ime);
          a(paramString.groupId, paramString.IkB, paramString.IkG, paramString.zkT, paramString.zkU, paramString.Ilj, paramString.IlX, paramString.IkD, false, true);
          if (this.IJW != null)
          {
            localObject1 = this.IJW;
            localObject2 = new g.7((g)localObject1, c.fpJ().aOw(paramString.groupId));
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label4042;
            }
            ((Runnable)localObject2).run();
          }
          for (;;)
          {
            localObject1 = new byte[paramString.IlZ.length];
            j = 0;
            while (j < paramString.IlZ.length)
            {
              localObject1[j] = ((byte)paramString.IlZ[j]);
              j += 1;
            }
            label4042:
            ((g)localObject1).handler.post((Runnable)localObject2);
          }
          localObject2 = new int[paramString.Imi.length];
          int j = 0;
          while (j < paramString.Imi.length)
          {
            localObject2[j] = paramString.Imi[j];
            j += 1;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateTalkRoomEnd, general policy cnt:", Integer.valueOf(paramString.Imi.length), " redirect type:", Integer.valueOf(localObject2[talk.tOi]), " SimpleRedirect value:", Integer.valueOf(talk.tOi) });
          a.ay[] arrayOfay = paramString.Ilj;
          a.av localav = paramString.Ilk;
          if ((paramString.IlY & 0x2) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            a(0, arrayOfay, localav, (byte[])localObject1, bool, paramString.groupId, paramString.zkT, paramString.zkU, paramString.Imf, paramString.Img, paramString.Imh, (int[])localObject2, paramString.Ilm, this.IJG);
            if (paramString.Imc != 0)
            {
              com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.Imc });
              IJu = paramString.Imc * 1000;
            }
            fpW();
            q(paramString.groupId, paramString.zkT, paramString.zkU);
            if (i != 0)
            {
              localObject1 = new HashMap();
              ((Map)localObject1).put("result", Boolean.TRUE);
              ((Map)localObject1).put("shareUrl", new String(paramString.IkD.ImS, Charset.forName("utf-8")));
              ((Map)localObject1).put("smsShortUrl", new String(paramString.IkD.ImT, Charset.forName("utf-8")));
              ((Map)localObject1).put("groupId", paramString.groupId);
              this.IHW.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl) });
            break;
          }
          label4472:
          this.IJW.n(-300, null);
          break label1850;
          if (((a.y)localObject1).IlV == null)
          {
            i = 0;
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
            if (b(((a.y)localObject1).groupId, ((a.y)localObject1).zkT, ((a.y)localObject1).zkU, false)) {
              break label4660;
            }
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.y)localObject1).groupId, this.seB, " resp.roomid: ", Integer.valueOf(((a.y)localObject1).zkT), Integer.valueOf(this.sHe) });
            h.acW(-1308);
          }
          for (;;)
          {
            a(((a.y)localObject1).groupId, null, this.IjW, ((a.y)localObject1).zkT, ((a.y)localObject1).zkU, ((a.y)localObject1).IlV, null, ((a.y)localObject1).IkD, true, true);
            break;
            i = ((a.y)localObject1).IlV.length;
            break label4497;
            this.IJO.ad(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          label4703:
          if (paramInt2 != 14801) {
            break label2210;
          }
          i = -1402;
          break label2210;
          label4718:
          if (paramInt2 == 0) {
            this.IJv = true;
          }
          if (!dSZ())
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.seB });
            this.IJO.reset();
            xz(false);
            this.IJO.ad(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
            this.zgY = false;
            this.seB = paramString.seB;
            this.IKa = this.seB;
            this.sHe = paramString.sHe;
            this.ztl = paramString.ztl;
            this.IjW = paramString.IjW;
            setState(2);
            this.IJC = System.currentTimeMillis();
            localObject1 = this.IJO;
            com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "beginNotifyTime" });
            ((h)localObject1).ILy = System.currentTimeMillis();
            if (paramInt2 == 18900) {
              h.acW(-1521);
            }
          }
          while (!com.tencent.pb.common.c.f.equals(paramString.seB, this.seB))
          {
            localObject1 = new e();
            ((e)localObject1).groupId = paramString.seB;
            ((e)localObject1).roomId = paramString.sHe;
            ((e)localObject1).sAY = paramString.ztl;
            this.IJp.put(paramString.seB, localObject1);
            localObject1 = c.fpJ().aOw(paramString.seB);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.seB, " multiTalkGroup: ", localObject1 });
            if (localObject1 == null) {
              break label5102;
            }
            paramString = this.IJW;
            localObject1 = new g.22(paramString, (MultiTalkGroup)localObject1);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label5089;
            }
            ((Runnable)localObject1).run();
            break;
          }
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.seB });
          break label2468;
          label5089:
          paramString.handler.post((Runnable)localObject1);
          break label2468;
          label5102:
          a(paramString.seB, paramString.sHe, paramString.ztl, false, false, false);
          break label2468;
          localObject1 = c.fpJ().aOp(paramString.groupId);
          if (localObject1 != null)
          {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
            a(paramString.groupId, null, ((TalkRoom)localObject1).fpx(), TalkRoom.fpy(), TalkRoom.dUA(), null, null, paramString.IkD, true, false);
          }
          for (;;)
          {
            this.IJW.gC(paramString.groupId, 0);
            break;
            a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.IkD, true, false);
          }
          label5223:
          if (!com.tencent.pb.common.c.f.equals(paramString.seB, this.seB)) {
            break label2909;
          }
          this.IJO.ad(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          paramString = this.IJW;
          localObject1 = new g.20(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label2909;
          }
          paramString.handler.post((Runnable)localObject1);
          break label2909;
          if (this.IJP != null)
          {
            localObject1 = new int[6];
            localObject1[0] = paramString.DlI;
            localObject1[1] = paramString.Imk;
            localObject1[2] = paramString.Iml;
            localObject1[3] = paramString.Imm;
            localObject1[4] = paramString.Imn;
            localObject1[5] = paramString.Imo;
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject1[2]), Integer.valueOf(localObject1[3]), Integer.valueOf(localObject1[4]), Integer.valueOf(localObject1[5]) });
            localObject2 = this.IJP;
            if (((b)localObject2).IJa != null) {
              break label5554;
            }
            com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject1, ", engine:", ((b)localObject2).IJa });
          }
          for (;;)
          {
            if (paramInt2 == 0)
            {
              localObject1 = this.IJW;
              paramString = new g.16((g)localObject1, paramString.DlI);
              if (Looper.myLooper() == Looper.getMainLooper())
              {
                paramString.run();
                break;
                ((b)localObject2).IJa.setMVSvrCfg((int[])localObject1, 6);
                continue;
              }
              ((g)localObject1).handler.post(paramString);
              break;
            }
          }
          if (paramInt2 == 24301)
          {
            this.IJW.n(-1700, Integer.valueOf(paramString.Imq));
            break label3017;
          }
          this.IJW.n(-800, null);
          break label3017;
          label5624:
          if (paramInt2 == 0)
          {
            paramString = this.IJW;
            localObject1 = new g.17(paramString);
            if (Looper.myLooper() == Looper.getMainLooper())
            {
              ((Runnable)localObject1).run();
              continue;
            }
            paramString.handler.post((Runnable)localObject1);
            continue;
          }
          this.IJW.n(-1600, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.IJW;
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
        this.IJW.n(-1601, null);
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
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.seB, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.sHe), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.ztl) });
    c.fpJ().aOq(paramString);
    if (paramBoolean1) {
      q(paramString, paramInt, paramLong);
    }
    this.IJp.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      xz(true);
      this.IJW.cZ(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.fpJ().aOw(paramString);
      if (paramString != null) {
        this.IJW.f(paramString);
      }
    }
    AppMethodBeat.o(62755);
  }
  
  public final boolean a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62733);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.seB, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
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
        fpU();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.fll().a(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.IJO.ad(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
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
    boolean bool = com.tencent.pb.common.b.e.fll().a(localf);
    this.IJO.ad(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(62736);
    return bool;
  }
  
  public final e aOx(String paramString)
  {
    AppMethodBeat.i(62757);
    paramString = (e)this.IJp.get(paramString);
    AppMethodBeat.o(62757);
    return paramString;
  }
  
  public final boolean aOy(String paramString)
  {
    AppMethodBeat.i(62758);
    if ((e)this.IJp.get(paramString) != null)
    {
      AppMethodBeat.o(62758);
      return true;
    }
    AppMethodBeat.o(62758);
    return false;
  }
  
  public final boolean aV(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62773);
    com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62773);
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100)) {
      this.IJO.fqi();
    }
    int i = this.sHe;
    long l = this.ztl;
    int j = a.fpu().state;
    if (j.aOD(paramString))
    {
      this.IJO.ada(327);
      bool = a.fpu().gD(paramString, 1000);
      AppMethodBeat.o(62773);
      return bool;
    }
    if (j == 2)
    {
      bool = a.fpu().a(paramString, i, l, paramInt1);
      AppMethodBeat.o(62773);
      return bool;
    }
    com.tencent.pb.common.c.a.J(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.fpu().a(paramString, i, l, paramInt2, true);
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
        if ((!TextUtils.isEmpty(this.seB)) || (!TextUtils.isEmpty(this.IJy)))
        {
          this.IJO.ad(new String[] { "notify", "pasrefail" });
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
        h.acW(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.sHe, this.ztl, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange ", this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl), Long.valueOf(paramArrayOfByte.msgId), Integer.valueOf(paramArrayOfByte.Ilh), Integer.valueOf(paramArrayOfByte.htk) });
      l = paramArrayOfByte.msgId;
      if (this.IKb.contains(Long.valueOf(l)))
      {
        n = 1;
        if (n == 0) {
          break label382;
        }
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error" });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false)) {
          break label338;
        }
        this.IJO.ad(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.Ilh) });
      }
      for (;;)
      {
        AppMethodBeat.o(62753);
        return -3;
        this.IKb.add(Long.valueOf(l));
        n = 0;
        break;
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.Ilh) });
      }
      n = paramArrayOfByte.Ilh;
      i1 = paramArrayOfByte.htk;
      switch (n)
      {
      default: 
        com.tencent.pb.common.c.b.w("unknow voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1) });
        n = 0;
      }
    }
    if (n != 0)
    {
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false)) {
        this.IJO.ad(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.Ilh) });
      }
      if (paramArrayOfByte.Ilh != 2) {
        break label1115;
      }
      a(paramArrayOfByte.groupId, null, paramArrayOfByte.IkG, paramArrayOfByte.zkT, paramArrayOfByte.zkU, paramArrayOfByte.Ilj, paramArrayOfByte.Ili, paramArrayOfByte.IkD, true, true);
    }
    for (;;)
    {
      AppMethodBeat.o(62753);
      return 0;
      if (i1 <= this.IJI)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.IJI) });
        n = 0;
        break;
      }
      this.IJI = i1;
      for (;;)
      {
        com.tencent.pb.common.c.b.w("voiceMsg type ", new Object[] { Integer.valueOf(n), " seq ", Integer.valueOf(i1), " update local seq" });
        n = 1;
        break;
        if (i1 <= this.IJJ)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.IJI) });
          n = 0;
          break;
        }
        this.IJJ = i1;
        continue;
        if (i1 <= this.IJK)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.IJI) });
          n = 0;
          break;
        }
        this.IJK = i1;
        continue;
        if (i1 <= this.IJL)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.IJI) });
          n = 0;
          break;
        }
        this.IJL = i1;
        continue;
        if (i1 <= this.IJM)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.IJI) });
          n = 0;
          break;
        }
        this.IJM = i1;
        continue;
        if (i1 <= this.IJN)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "voiceMsg type ", Integer.valueOf(n), " seq ", Integer.valueOf(i1), " is smaller than the latest handled msg seq ", Integer.valueOf(this.IJI) });
          n = 0;
          break;
        }
        this.IJN = i1;
      }
      label1115:
      Object localObject1;
      if (paramArrayOfByte.Ilh == 4)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.IkG, paramArrayOfByte.zkT, paramArrayOfByte.zkU, paramArrayOfByte.Ilj, paramArrayOfByte.Ili, paramArrayOfByte.IkD, true, true);
        if ((paramArrayOfByte.Ill != 0) || (paramArrayOfByte.Ilm != 0))
        {
          localObject1 = this.IJP;
          n = paramArrayOfByte.Ill;
          i1 = paramArrayOfByte.Ilm;
          if ((com.tencent.pb.common.a.a.Ijx) && (((b)localObject1).IJa != null)) {
            ((b)localObject1).IJa.SetAVEncryptType(n, i1);
          }
        }
      }
      else if (paramArrayOfByte.Ilh == 16)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.IkG, paramArrayOfByte.zkT, paramArrayOfByte.zkU, paramArrayOfByte.Ilj, paramArrayOfByte.Ili, paramArrayOfByte.IkD, true, false);
      }
      else if (paramArrayOfByte.Ilh == 1)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.zkT), " roomkey: ", Long.valueOf(paramArrayOfByte.zkU) });
        if (com.tencent.pb.a.a.a.flF())
        {
          com.tencent.pb.a.a.a.flG();
          if ((dSZ()) && (com.tencent.pb.common.c.f.equals(paramArrayOfByte.groupId, this.seB))) {
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.seB });
          }
        }
        else
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
          continue;
        }
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.IkG, paramArrayOfByte.zkT, paramArrayOfByte.zkU, paramArrayOfByte.Ilj, paramArrayOfByte.Ili, paramArrayOfByte.IkD, false, true);
        localObject1 = paramArrayOfByte.groupId;
        n = paramArrayOfByte.zkT;
        l = paramArrayOfByte.zkU;
        i1 = paramArrayOfByte.IkG;
        int i2 = paramArrayOfByte.Iln;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
        }
        for (;;)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
          break;
          paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, n, l, i1, i2);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(n), Long.valueOf(l), Integer.valueOf(i2), Boolean.valueOf(com.tencent.pb.common.b.e.fll().a(paramArrayOfByte)) });
        }
      }
      else if (paramArrayOfByte.Ilh == 8)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.seB });
        if (b(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false))
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.IkG, paramArrayOfByte.zkT, paramArrayOfByte.zkU, paramArrayOfByte.Ilj, paramArrayOfByte.Ili, paramArrayOfByte.IkD, true, false);
          a(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false, false, true);
        }
        else
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.IkG, paramArrayOfByte.zkT, paramArrayOfByte.zkU, paramArrayOfByte.Ilj, paramArrayOfByte.Ili, paramArrayOfByte.IkD, true, false);
        }
      }
      else
      {
        String str;
        if (paramArrayOfByte.Ilh == 128)
        {
          localObject1 = paramArrayOfByte.groupId;
          str = this.seB;
          if (paramArrayOfByte.Ilo == null) {}
          for (n = 0;; n = paramArrayOfByte.Ilo.length)
          {
            com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(n) });
            localObject1 = this.IJW;
            paramArrayOfByte = new g.19((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.Ilo);
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
          if (paramArrayOfByte.Ilh == 256)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false)) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
            } else if (paramArrayOfByte.Ilo == null) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
            } else {
              try
              {
                localObject1 = paramArrayOfByte.Ilo;
                localObject1 = (a.s)com.google.b.a.e.a(new a.s(), (byte[])localObject1, localObject1.length);
                if ((localObject1 == null) || (((a.s)localObject1).Ils == null)) {
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
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
                localObject2 = ((a.s)localObject2).Ils;
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
                com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.seB, " roomId: ", Integer.valueOf(this.sHe), " videoUserNames: ", paramArrayOfByte });
                localObject2 = this.IJW;
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
          else if (paramArrayOfByte.Ilh == 1024)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false))
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
            }
            else if ((this.state != 3) && (this.state != 4))
            {
              a(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, 1);
              this.IJW.n(-1400, null);
            }
          }
          else if (paramArrayOfByte.Ilh == 512)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false)) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
            } else if (paramArrayOfByte.Ilo == null) {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
            } else {
              try
              {
                localObject2 = paramArrayOfByte.Ilo;
                localObject2 = (a.r)com.google.b.a.e.a(new a.r(), (byte[])localObject2, localObject2.length);
                if (localObject2 == null) {
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
                }
              }
              catch (com.google.b.a.d locald2)
              {
                for (;;)
                {
                  com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                  local1 = null;
                }
                paramArrayOfByte = this.IJW;
                g.1 local1 = new g.1(paramArrayOfByte, local1.Ilr);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  local1.run();
                  continue;
                }
                paramArrayOfByte.handler.post(local1);
              }
            }
          }
          else if (paramArrayOfByte.Ilh == 2048) {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.zkT, paramArrayOfByte.zkU, false))
            {
              com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handleAudioStreamChange is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.zkT) });
            }
            else
            {
              com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handleAudioStreamChange audio_stream_type", Integer.valueOf(paramArrayOfByte.audioStreamType) });
              int i = (byte)(paramArrayOfByte.audioStreamType & 0xFF);
              int j = (byte)(paramArrayOfByte.audioStreamType >> 8 & 0xFF);
              int k = (byte)(paramArrayOfByte.audioStreamType >> 16 & 0xFF);
              int m = (byte)(paramArrayOfByte.audioStreamType >> 24 & 0xFF);
              this.IJP.IJa.setAppCmd(306, new byte[] { i, j, k, m }, 4);
            }
          }
        }
      }
    }
  }
  
  final boolean dNe()
  {
    AppMethodBeat.i(62765);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initEngine", this.seB, Integer.valueOf(this.sHe), Long.valueOf(this.ztl), Integer.valueOf(this.state) });
    try
    {
      localb = this.IJP;
      boolean bool = com.tencent.pb.common.a.a.Ijx;
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
        i = localException.IJa.field_capInfo.length;
      }
      AppMethodBeat.o(62765);
      return true;
    }
    if (i < 0)
    {
      h.acZ(-3001);
      this.IJO.ada(201);
      this.IJP = null;
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(62765);
      return false;
      str = com.tencent.pb.common.c.c.ztG.getDir("lib", 0).getAbsolutePath();
      locale = Iki;
      if (locale == null) {
        break label369;
      }
    }
    label369:
    for (int i = locale.WG();; i = 0)
    {
      int j = k.kR(com.tencent.pb.common.c.c.ztG);
      com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(j), " cpuFlag:", Integer.valueOf(i), "libPath:", str });
      if (localb.IJa == null)
      {
        i = -1;
        break;
      }
      j = localb.IJa.init(j, i, str + "/");
      if (localb.IJa.field_capInfo == null)
      {
        i = 0;
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "protocalInit", Integer.valueOf(j), "field_capInfo length: ", Integer.valueOf(i) });
        i = j;
        break;
      }
    }
  }
  
  public final boolean dSZ()
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
  
  final boolean fpS()
  {
    AppMethodBeat.i(62724);
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = Iki;
    if (locale != null) {
      locale.cRJ();
    }
    this.IJP = new b();
    this.IKa = this.seB;
    fpR();
    this.IJQ = new talk.a()
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
          f.this.IJO.ILk = 1;
          localh = f.this.IJO;
          if (localh.ILx != 0L) {
            break label121;
          }
        }
        label121:
        for (localh.ILl = 0L;; localh.ILl = (System.currentTimeMillis() - localh.ILx))
        {
          com.tencent.pb.common.c.b.d(h.TAG, new Object[] { "endRecvFirstPcm", Long.valueOf(localh.ILx), Long.valueOf(localh.ILl) });
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
        //   9: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   12: getfield 77	com/tencent/wecall/talkroom/model/f:IJO	Lcom/tencent/wecall/talkroom/model/h;
        //   15: iconst_1
        //   16: putfield 124	com/tencent/wecall/talkroom/model/h:sCl	I
        //   19: ldc 59
        //   21: iconst_1
        //   22: anewarray 4	java/lang/Object
        //   25: dup
        //   26: iconst_0
        //   27: ldc 126
        //   29: aastore
        //   30: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   33: aload_0
        //   34: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
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
        //   58: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   61: invokestatic 128	com/tencent/wecall/talkroom/model/f:a	(Lcom/tencent/wecall/talkroom/model/f;)I
        //   64: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   67: aastore
        //   68: invokestatic 73	com/tencent/pb/common/c/b:w	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   71: ldc 121
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aload_0
        //   78: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   81: astore 6
        //   83: invokestatic 136	com/tencent/wecall/talkroom/model/c:fpJ	()Lcom/tencent/wecall/talkroom/model/c;
        //   86: astore 4
        //   88: aload_0
        //   89: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
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
        //   117: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   120: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   123: ifnull +30 -> 153
        //   126: aload_0
        //   127: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   130: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   133: astore 4
        //   135: invokestatic 156	com/tencent/wecall/talkroom/model/f:fqe	()Z
        //   138: istore_3
        //   139: getstatic 162	com/tencent/pb/common/a/a:Ijx	Z
        //   142: ifeq +11 -> 153
        //   145: aload 4
        //   147: getfield 168	com/tencent/wecall/talkroom/model/b:IJa	Lcom/tencent/mm/plugin/multi/talk;
        //   150: ifnonnull +431 -> 581
        //   153: aload_0
        //   154: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   157: invokestatic 171	com/tencent/wecall/talkroom/model/f:d	(Lcom/tencent/wecall/talkroom/model/f;)Z
        //   160: pop
        //   161: aload_0
        //   162: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   165: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   168: pop
        //   169: invokestatic 175	com/tencent/wecall/talkroom/model/f:fqf	()Lcom/tencent/pb/talkroom/sdk/e;
        //   172: astore 4
        //   174: aload 4
        //   176: ifnull +11 -> 187
        //   179: aload 4
        //   181: invokeinterface 181 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   191: invokestatic 153	com/tencent/wecall/talkroom/model/f:c	(Lcom/tencent/wecall/talkroom/model/f;)Lcom/tencent/wecall/talkroom/model/b;
        //   194: getfield 168	com/tencent/wecall/talkroom/model/b:IJa	Lcom/tencent/mm/plugin/multi/talk;
        //   197: astore 6
        //   199: getstatic 162	com/tencent/pb/common/a/a:Ijx	Z
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
        //   308: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
        //   311: getfield 77	com/tencent/wecall/talkroom/model/f:IJO	Lcom/tencent/wecall/talkroom/model/h;
        //   314: astore 4
        //   316: aload 4
        //   318: getfield 87	com/tencent/wecall/talkroom/model/h:ILx	J
        //   321: lconst_0
        //   322: lcmp
        //   323: ifne +317 -> 640
        //   326: aload 4
        //   328: lconst_0
        //   329: putfield 209	com/tencent/wecall/talkroom/model/h:ILm	J
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
        //   348: getfield 209	com/tencent/wecall/talkroom/model/h:ILm	J
        //   351: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   354: aastore
        //   355: dup
        //   356: iconst_2
        //   357: aload 4
        //   359: getfield 87	com/tencent/wecall/talkroom/model/h:ILx	J
        //   362: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   365: aastore
        //   366: invokestatic 104	com/tencent/pb/common/c/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   369: aload_0
        //   370: getfield 22	com/tencent/wecall/talkroom/model/f$1:IKp	Lcom/tencent/wecall/talkroom/model/f;
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
        //   442: invokevirtual 234	com/tencent/wecall/talkroom/model/c:aOp	(Ljava/lang/String;)Lcom/tencent/wecall/talkroom/model/TalkRoom;
        //   445: astore 7
        //   447: aload 5
        //   449: astore 4
        //   451: aload 7
        //   453: ifnull -344 -> 109
        //   456: aload 7
        //   458: invokevirtual 240	com/tencent/wecall/talkroom/model/TalkRoom:fpA	()Ljava/util/List;
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
        //   587: getfield 168	com/tencent/wecall/talkroom/model/b:IJa	Lcom/tencent/mm/plugin/multi/talk;
        //   590: sipush 401
        //   593: invokevirtual 277	com/tencent/mm/plugin/multi/talk:setAppCmd	(I)I
        //   596: pop
        //   597: goto -444 -> 153
        //   600: aload 4
        //   602: getfield 168	com/tencent/wecall/talkroom/model/b:IJa	Lcom/tencent/mm/plugin/multi/talk;
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
        //   647: getfield 87	com/tencent/wecall/talkroom/model/h:ILx	J
        //   650: lsub
        //   651: putfield 209	com/tencent/wecall/talkroom/model/h:ILm	J
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
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aNw(f.this.IKa));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.aOC(localStringBuilder.toString());
        AppMethodBeat.o(62608);
      }
      
      public final void keep_OnReportEngineRecv(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(62606);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineRecv:", Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aNw(f.this.IKa));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.aOA(localStringBuilder.toString());
        AppMethodBeat.o(62606);
      }
      
      public final void keep_OnReportEngineSend(String paramAnonymousString)
      {
        AppMethodBeat.i(62607);
        com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "keep_OnReportEngineSend:", paramAnonymousString });
        StringBuilder localStringBuilder = new StringBuilder(com.tencent.pb.common.c.f.aNw(f.this.IKa));
        localStringBuilder.append(",");
        localStringBuilder.append(paramAnonymousString);
        h.aOB(localStringBuilder.toString());
        AppMethodBeat.o(62607);
      }
      
      final class a
        implements Runnable
      {
        int IKr;
        int IKs;
        int IKt;
        int IKu;
        int IKv;
        
        a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        {
          this.IKr = paramInt1;
          this.IKt = paramInt2;
          this.IKu = paramInt3;
          this.IKv = paramInt4;
          this.IKs = paramInt5;
        }
        
        public final void run()
        {
          AppMethodBeat.i(62585);
          com.tencent.pb.common.c.b.i("TalkRoomService", new Object[] { "keep_OnError handler" });
          h.acZ(this.IKu);
          f.this.IJO.ada(this.IKt);
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(this.IKs) });
          f.this.a(f.b(f.this), f.g(f.this), f.h(f.this), this.IKv, true);
          f.f(f.this).n(this.IKr, null);
          AppMethodBeat.o(62585);
        }
      }
    };
    AppMethodBeat.o(62724);
    return true;
  }
  
  public final void fpT()
  {
    AppMethodBeat.i(62726);
    try
    {
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.IKm != null) {
        this.mHandler.removeCallbacks(this.IKm);
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
  
  public final void gB(String paramString, int paramInt)
  {
    AppMethodBeat.i(62776);
    if ((com.tencent.pb.common.c.f.equals("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (dSZ()) && ((this.sRS) || (this.IJw))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62776);
      return;
      switch (k.kR(com.tencent.pb.common.c.c.ztG))
      {
      }
      for (this.IJY = false; (this.sHe == 0) || (this.ztl == 0L); this.IJY = true)
      {
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(62776);
        return;
      }
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect", this.seB, Integer.valueOf(this.sHe) });
      this.IJO.fqj();
      paramString = new com.tencent.wecall.talkroom.a.h(this.seB, this.sHe, this.ztl, c.fpJ().aOr(this.seB), this.IJF);
      boolean bool = com.tencent.pb.common.b.e.fll().a(paramString);
      this.IJO.ad(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(62776);
      return;
      paramString = this.IJP;
      paramInt = k.kR(com.tencent.pb.common.c.c.ztG);
      if ((!com.tencent.pb.common.a.a.Ijx) || (paramString.IJa == null))
      {
        AppMethodBeat.o(62776);
        return;
      }
      paramString.IJa.onNetworkChange(paramInt);
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
        if (paramMessage.seB == null)
        {
          com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId is null" });
        }
        else
        {
          com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "handlerInviteTimeOut" });
          if ((paramMessage.seB.equals(this.seB)) && (paramMessage.sHe == this.sHe) && (paramMessage.ztl == this.ztl))
          {
            h.fql();
            this.IJO.ada(501);
            a(paramMessage.seB, paramMessage.sHe, paramMessage.ztl, 7);
            com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId: ", paramMessage.seB });
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
              if (com.tencent.pb.common.c.f.lO(paramMessage.groupId, this.seB))
              {
                String str1 = paramMessage.groupId;
                Object localObject1 = paramMessage.IKJ;
                a.bb localbb = paramMessage.IKK;
                int i = paramMessage.IkG;
                int j = paramMessage.type;
                long l = paramMessage.IKL;
                String str2 = paramMessage.IKM;
                boolean bool = paramMessage.IKN;
                String str3 = paramMessage.IKO;
                this.IJO.fqj();
                Object localObject2 = c.fpJ();
                paramMessage = "";
                localObject2 = ((c)localObject2).aOp(str1);
                if (localObject2 != null) {
                  if (((TalkRoom)localObject2).IIY != null) {
                    break label618;
                  }
                }
                label618:
                for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).IIY.name)
                {
                  localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.IJP.fpG(), paramMessage, localbb, i, j, l, str2, bool, str3);
                  bool = com.tencent.pb.common.b.e.fll().a((com.tencent.pb.common.b.d)localObject1);
                  this.IJO.ad(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
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
                  if (b(paramMessage.groupId, paramMessage.roomId, paramMessage.sAY, false))
                  {
                    a(paramMessage.groupId, paramMessage.roomId, paramMessage.sAY, paramMessage.IkG, paramMessage.tjk, paramMessage.ILa);
                    continue;
                    com.tencent.pb.common.c.e.flD();
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
    this.IJW.onStateChanged(paramInt);
    AppMethodBeat.o(62728);
  }
  
  public final void xA(boolean paramBoolean)
  {
    AppMethodBeat.i(62766);
    try
    {
      Ob();
      fpV();
      if (paramBoolean)
      {
        fqa();
        aZs();
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
  
  public final void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(62725);
    this.IJO.groupId = this.seB;
    this.IJO.IkB = this.IJy;
    if (com.tencent.pb.common.c.f.dq(this.IJO.groupId)) {
      this.IJO.groupId = "";
    }
    if (com.tencent.pb.common.c.f.dq(this.IJO.IkB)) {
      this.IJO.IkB = "";
    }
    this.IJO.znG = 1;
    this.IJO.roomId = this.sHe;
    this.IJO.sAY = this.ztl;
    fpR();
    com.tencent.pb.common.c.b.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    dNb();
    VP();
    int j = -99999;
    int i = j;
    if (this.IJP != null) {}
    try
    {
      this.IJX = this.IJP.fpI();
      i = this.IJP.Close();
      com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.IJP == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        j = this.IJP.uninitLive();
        this.IJP = null;
        com.tencent.pb.common.c.b.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.IJO.fqg();
          if ((!TextUtils.isEmpty(this.IJO.groupId)) || (!TextUtils.isEmpty(this.IJO.IkB)))
          {
            h.aOz(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.IJO.reset();
          fqd();
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
    String[] IKJ;
    a.bb IKK;
    long IKL;
    String IKM;
    boolean IKN;
    String IKO;
    int IkG;
    String groupId;
    int type;
    
    a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(62686);
      IKP = new b("OK", 0);
      IKQ = new b("NOT_AUTH", 1);
      IKR = new b("NOT_BIND", 2);
      IKS = new b("NOT_MATCH", 3);
      IKT = new b("NO_NETWORK", 4);
      IKU = new b("BUSY", 5);
      IKV = new b("NOT_VALID_STATE", 6);
      IKW = new b("GROUP_NOT_VALID", 7);
      IKX = new b("UNINIT_SERVICE_FAILED", 8);
      IKY = new b("INIT_ENGINE_FAILED", 9);
      IKZ = new b[] { IKP, IKQ, IKR, IKS, IKT, IKU, IKV, IKW, IKX, IKY };
      AppMethodBeat.o(62686);
    }
    
    private b() {}
  }
  
  final class c
  {
    String ILa;
    int IkG;
    String groupId;
    int roomId;
    long sAY;
    int tjk;
    
    c() {}
  }
  
  final class d
  {
    int sHe;
    String seB;
    long ztl;
  }
  
  final class e
  {
    String groupId;
    int roomId;
    long sAY;
    
    e() {}
  }
  
  public static abstract interface f {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */