package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.s.c;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.b.j;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.multitalk.b.p.20;
import com.tencent.mm.plugin.multitalk.b.p.28;
import com.tencent.mm.plugin.multitalk.b.p.35;
import com.tencent.mm.plugin.multitalk.b.p.5;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.pb.common.b.a.a.a.aa;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.b.a.a.a.aw;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class o
  implements ServiceConnection, com.tencent.pb.talkroom.sdk.a
{
  private Timer cOI;
  public boolean fOX;
  com.tencent.mm.sdk.b.c hcQ;
  public boolean leL;
  private boolean uVM;
  public e wps;
  private boolean wqO;
  private boolean wqP;
  public int wqQ;
  public boolean wqR;
  public HashSet<String> wqS;
  public com.tencent.mm.plugin.multitalk.ui.widget.i wqT;
  public MultiTalkGroup wqU;
  public w wqV;
  public boolean wqW;
  public boolean wqX;
  private long wqY;
  public int wqZ;
  private int wra;
  private int wrb;
  private boolean wrc;
  private boolean wrd;
  private long wre;
  private long wrf;
  private t.a wrg;
  public boolean wrh;
  private MultiTalkGroup wri;
  private long wrj;
  private boolean wrk;
  public com.tencent.mm.plugin.multitalk.a.a wrl;
  private r wrm;
  private ad wrn;
  private ab wro;
  private a wrp;
  HashMap<String, Integer> wrq;
  private com.tencent.mm.sdk.platformtools.aw wrr;
  a wrs;
  public boolean wrt;
  private aq wru;
  BroadcastReceiver wrv;
  
  public o()
  {
    AppMethodBeat.i(114486);
    this.wqR = true;
    this.wqS = new HashSet();
    this.wqT = com.tencent.mm.plugin.multitalk.ui.widget.i.wvV;
    this.wqU = null;
    this.wqW = false;
    this.wqX = false;
    this.wqY = 0L;
    this.wqZ = 0;
    this.wra = 0;
    this.wrb = 2;
    this.wrc = false;
    this.wrd = false;
    this.wre = 0L;
    this.wrf = 30000L;
    this.wri = null;
    this.wrj = 0L;
    this.wrk = false;
    this.wrq = new HashMap();
    this.wrr = new com.tencent.mm.sdk.platformtools.aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(190773);
        ae.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (o.a(o.this) == null)
        {
          o.b(o.this);
          o.c(o.this).stopTimer();
          AppMethodBeat.o(190773);
          return false;
        }
        if (o.fY(ak.getContext()))
        {
          o.this.b(o.a(o.this));
          o.d(o.this);
          o.b(o.this);
          o.c(o.this).stopTimer();
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 7L, 1L, false);
          AppMethodBeat.o(190773);
          return false;
        }
        if (System.currentTimeMillis() - o.e(o.this) < 60000L)
        {
          AppMethodBeat.o(190773);
          return true;
        }
        o.d(o.this);
        o.b(o.this);
        o.c(o.this).stopTimer();
        AppMethodBeat.o(190773);
        return false;
      }
    }, true);
    this.wrt = false;
    this.wru = new aq(Looper.getMainLooper());
    this.wrv = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(190766);
        if (!o.this.dsk())
        {
          AppMethodBeat.o(190766);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          o.h(o.this).removeCallbacksAndMessages(null);
          o.h(o.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114474);
              t.a locala1 = t.dtA();
              if (locala1 != o.i(o.this))
              {
                t.a locala2 = o.i(o.this);
                o.a(o.this, locala1);
                ae.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), o.i(o.this).name() });
                o.this.Lj(o.j(o.this));
                if (o.k(o.this) != null) {
                  o.k(o.this).a(o.i(o.this));
                }
                AppMethodBeat.o(114474);
                return;
              }
              o.this.Lj(o.j(o.this));
              ae.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { o.i(o.this).name() });
              AppMethodBeat.o(114474);
            }
          }, 8000L);
          AppMethodBeat.o(190766);
          return;
        }
        int i;
        if (paramAnonymousIntent != null)
        {
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("state");
          if (paramAnonymousIntent != null) {
            if (paramAnonymousIntent.equals("IDLE")) {
              i = 0;
            }
          }
        }
        final boolean bool;
        for (;;)
        {
          bool = o.this.dsX();
          ae.i("MicroMsg.MT.MultiTalkManager", "phone state %d, isILinkMode:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if (i != 0) {
            break;
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114475);
              if (bool) {
                p.wmO.oL(true);
              }
              for (;;)
              {
                if (!com.tencent.mm.plugin.audio.c.a.bHz()) {
                  o.this.pb(z.dtK().leL);
                }
                AppMethodBeat.o(114475);
                return;
                z.dtJ().wqE.zC(false);
                if (o.this.wrl != null) {
                  o.this.wrl.NZ();
                }
              }
            }
          });
          AppMethodBeat.o(190766);
          return;
          if (paramAnonymousIntent.equals("RINGING")) {
            i = 1;
          } else if (paramAnonymousIntent.equals("OFFHOOK")) {
            i = 2;
          } else {
            i = ((TelephonyManager)paramAnonymousContext.getSystemService("phone")).getCallState();
          }
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190765);
            if (bool)
            {
              p.wmO.oL(false);
              AppMethodBeat.o(190765);
              return;
            }
            z.dtJ().wqE.zC(true);
            AppMethodBeat.o(190765);
          }
        });
        AppMethodBeat.o(190766);
      }
    };
    this.hcQ = new o.5(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.hcQ);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
    localIntentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ak.getContext().registerReceiver(this.wrv, localIntentFilter);
    this.wrh = false;
    AppMethodBeat.o(114486);
  }
  
  public static boolean Lk(int paramInt)
  {
    AppMethodBeat.i(190794);
    if (!z.dtK().dsX())
    {
      boolean bool = z.dtJ().wqE.Lj(paramInt);
      AppMethodBeat.o(190794);
      return bool;
    }
    p localp = p.wmO;
    localp.ad(new p.35(localp, paramInt));
    AppMethodBeat.o(190794);
    return true;
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(114500);
    ae.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((parami == com.tencent.mm.plugin.multitalk.ui.widget.i.wvW) && (paramBoolean))
    {
      parami = new bv();
      parami.setType(64);
      parami.qN(System.currentTimeMillis());
      parami.setStatus(6);
      parami.setContent(ak.getContext().getString(2131761448));
      if (com.tencent.mm.model.r.zu(paramMultiTalkGroup.wmA))
      {
        parami.ui(paramMultiTalkGroup.wmA);
        parami.setContent(parami.field_content);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar(parami);
      }
    }
    AppMethodBeat.o(114500);
  }
  
  private void a(MultiTalkGroup paramMultiTalkGroup, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(190781);
    String str = t.k(paramMultiTalkGroup);
    n.jdMethod_if(paramMultiTalkGroup.wmA, str);
    n.asA(str);
    if (this.wqT != com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ)
    {
      boolean bool = t.j(this.wqU);
      long l = getTotalTime();
      int i = 0;
      if (bool) {
        if (paramBoolean2) {
          i = 4;
        }
      }
      for (;;)
      {
        n.a(bool, l, str, i);
        AppMethodBeat.o(190781);
        return;
        if (paramBoolean1)
        {
          i = 1;
        }
        else if (paramBoolean3)
        {
          i = 5;
        }
        else
        {
          i = 2;
          continue;
          if (paramBoolean2)
          {
            if (l >= 45L) {
              i = 6;
            } else {
              i = 8;
            }
          }
          else if (paramBoolean1) {
            i = 7;
          } else if (paramBoolean3) {
            i = 10;
          }
        }
      }
    }
    n.Lh(this.wqZ);
    n.v(this.wqZ, str);
    if (paramMultiTalkGroup.MgI != null) {
      n.Le(paramMultiTalkGroup.MgI.size());
    }
    AppMethodBeat.o(190781);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114493);
    if (!dsk())
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { t.g(paramMultiTalkGroup) });
      this.wqU = paramMultiTalkGroup;
      this.wqZ = 0;
      this.wqQ = 1;
      this.wqS.clear();
      dsZ();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    Object localObject1 = this.wqU;
    int i;
    if ((paramMultiTalkGroup == null) || (localObject1 == null)) {
      i = 0;
    }
    while (i != 0)
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { t.g(paramMultiTalkGroup) });
      Object localObject2 = this.wqU;
      localObject1 = new HashMap();
      Object localObject3 = paramMultiTalkGroup.MgI.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject3).next();
          ((HashMap)localObject1).put(localMultiTalkGroupMember.MgJ, localMultiTalkGroupMember);
          continue;
          if ((!bu.isNullOrNil(paramMultiTalkGroup.wmz)) && (!bu.isNullOrNil(((MultiTalkGroup)localObject1).wmz)) && (paramMultiTalkGroup.wmz.equals(((MultiTalkGroup)localObject1).wmz)))
          {
            i = 1;
            break;
          }
          if ((!bu.isNullOrNil(paramMultiTalkGroup.MgG)) && (!bu.isNullOrNil(((MultiTalkGroup)localObject1).MgG)) && (paramMultiTalkGroup.MgG.equals(((MultiTalkGroup)localObject1).MgG)))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      localObject2 = ((MultiTalkGroup)localObject2).MgI.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiTalkGroupMember)((Iterator)localObject2).next();
        if ((!v.aAC().equals(((MultiTalkGroupMember)localObject3).MgJ)) && (v.aAC().equals(((MultiTalkGroupMember)localObject3).MgK)) && (((MultiTalkGroupMember)localObject3).status == 1) && ((!((HashMap)localObject1).containsKey(((MultiTalkGroupMember)localObject3).MgJ)) || (((MultiTalkGroupMember)((HashMap)localObject1).get(((MultiTalkGroupMember)localObject3).MgJ)).status == 20)))
        {
          localObject3 = ((MultiTalkGroupMember)localObject3).MgJ;
          localObject3 = ak.getContext().getString(2131761442, new Object[] { com.tencent.mm.model.w.zP((String)localObject3) });
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(ak.getContext(), (CharSequence)localObject3);
          Toast.makeText(ak.getContext(), (CharSequence)localObject3, 0).show();
        }
      }
      this.wqU = paramMultiTalkGroup;
      dsZ();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    ae.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { t.g(this.wqU), t.g(paramMultiTalkGroup) });
    AppMethodBeat.o(114493);
    return false;
  }
  
  private void aUH()
  {
    AppMethodBeat.i(114526);
    ae.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.cOI != null)
    {
      this.cOI.cancel();
      AppMethodBeat.o(114526);
      return;
    }
    this.wqY = System.currentTimeMillis();
    this.wqZ = 0;
    this.cOI = new Timer();
    TimerTask local4 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(190769);
        if ((o.this.getTotalTime() >= 45000L) && (o.l(o.this) != com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ)) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190767);
              o.this.j(false, true, false);
              AppMethodBeat.o(190767);
            }
          });
        }
        if (o.l(o.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ)
        {
          o.m(o.this);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190768);
              if (o.l(o.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ)
              {
                com.tencent.mm.plugin.voip.c.eyt().tx(o.this.wqZ);
                if (o.k(o.this) != null) {
                  o.k(o.this).dgg();
                }
              }
              AppMethodBeat.o(190768);
            }
          });
        }
        AppMethodBeat.o(190769);
      }
    };
    this.cOI.schedule(local4, 1000L, 1000L);
    AppMethodBeat.o(114526);
  }
  
  private void ac(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(190779);
    paramString1 = bu.U(paramString1.split(","));
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (paramInt == 2)
    {
      localObject1 = new ArrayList();
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        localObject2 = (String)paramString1.next();
        localObject3 = new j();
        ((j)localObject3).fIQ = ((String)localObject2);
        ((j)localObject3).mStatus = 2;
        ((ArrayList)localObject1).add(localObject3);
      }
      p.wmO.u(bu.o((Integer)com.tencent.mm.kernel.g.ajR().gDO.get(1)), v.aAC());
      p.wmO.e((ArrayList)localObject1, paramString2);
      ey(paramString2, 2);
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wvX);
      bool = true;
      if (!bool) {
        break label362;
      }
      n.dsD();
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.multitalk.d.d.wxl;
      com.tencent.mm.plugin.multitalk.d.d.reset();
      AppMethodBeat.o(190779);
      return;
      localObject1 = new MultiTalkGroup();
      ((MultiTalkGroup)localObject1).MgG = z.dtJ().wqE.fXO();
      ((MultiTalkGroup)localObject1).wmA = paramString2;
      localObject2 = paramString1.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.MgJ = ((String)localObject3);
        if (((String)localObject3).equals(v.aAC())) {}
        for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
        {
          ((MultiTalkGroup)localObject1).MgI.add(localMultiTalkGroupMember);
          break;
        }
      }
      z.dtJ().wqE.cW(bu.o((Integer)com.tencent.mm.kernel.g.ajR().gDO.get(1)), v.aAC());
      bool = z.dtJ().wqE.a(((MultiTalkGroup)localObject1).MgG, paramString2, paramString1, v2protocal.eCg());
      ey(paramString2, 1);
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wvX);
      a((MultiTalkGroup)localObject1, Boolean.TRUE);
      break;
      label362:
      n.dsE();
    }
  }
  
  private static String asC(String paramString)
  {
    AppMethodBeat.i(190789);
    String str2 = com.tencent.mm.model.w.zP(paramString);
    String str1 = paramString;
    if (str2 != null) {
      if (!str2.equals("")) {
        break label64;
      }
    }
    label64:
    for (str1 = paramString;; str1 = str2)
    {
      paramString = str1 + ak.getContext().getString(2131761446);
      AppMethodBeat.o(190789);
      return paramString;
    }
  }
  
  public static void asE(String paramString)
  {
    AppMethodBeat.i(114499);
    ae.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    bv localbv = new bv();
    localbv.setType(64);
    localbv.qN(System.currentTimeMillis());
    localbv.setStatus(6);
    localbv.setContent(ak.getContext().getString(2131761448));
    if (com.tencent.mm.model.r.zu(paramString))
    {
      localbv.ui(paramString);
      localbv.setContent(localbv.field_content);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar(localbv);
    }
    AppMethodBeat.o(114499);
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.i parami)
  {
    boolean bool = true;
    AppMethodBeat.i(114525);
    Object localObject = this.wqT;
    this.wqT = parami;
    if (localObject != parami) {
      if (parami == com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ)
      {
        localObject = new qn();
        ((qn)localObject).dGn.type = 1;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        n.a(t.j(this.wqU), getTotalTime(), t.k(this.wqU));
        z.dtK().stopRing();
        com.tencent.mm.plugin.audio.c.a.setMode(3);
        if ((com.tencent.mm.plugin.audio.c.a.bHt()) || (com.tencent.mm.plugin.audio.c.a.bHz())) {
          break label133;
        }
      }
    }
    for (;;)
    {
      pb(bool);
      z.dtJ().oR(bool);
      if (this.wps != null) {
        this.wps.a(parami);
      }
      AppMethodBeat.o(114525);
      return;
      label133:
      bool = false;
    }
  }
  
  private void bxX()
  {
    AppMethodBeat.i(114527);
    if (this.cOI != null)
    {
      this.cOI.cancel();
      this.cOI = null;
    }
    AppMethodBeat.o(114527);
  }
  
  private static boolean cJ(Context paramContext)
  {
    AppMethodBeat.i(114531);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ae.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ae.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
        AppMethodBeat.o(114531);
        return false;
      }
    }
    if (((KeyguardManager)ak.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(114531);
      return false;
    }
    ae.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
    AppMethodBeat.o(114531);
    return true;
  }
  
  private void dsZ()
  {
    AppMethodBeat.i(114495);
    Iterator localIterator = this.wqU.MgI.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.wqS.remove(localMultiTalkGroupMember.MgJ))) {
        ae.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.MgJ });
      }
    }
    AppMethodBeat.o(114495);
  }
  
  private h dta()
  {
    AppMethodBeat.i(190782);
    if (this.wrm == null) {
      this.wrm = new r();
    }
    r localr = this.wrm;
    AppMethodBeat.o(190782);
    return localr;
  }
  
  private void dtd()
  {
    AppMethodBeat.i(190785);
    if (this.wrn == null)
    {
      AppMethodBeat.o(190785);
      return;
    }
    this.wrn.close();
    this.wrn = null;
    AppMethodBeat.o(190785);
  }
  
  private void dth()
  {
    AppMethodBeat.i(114504);
    if (this.wqT == com.tencent.mm.plugin.multitalk.ui.widget.i.wvX) {}
    for (;;)
    {
      boolean bool = false;
      for (o localo = this;; localo = this)
      {
        localo.leL = bool;
        this.fOX = false;
        this.wrg = t.dtA();
        AppMethodBeat.o(114504);
        return;
        if ((com.tencent.mm.plugin.audio.c.a.bHt()) || (com.tencent.mm.plugin.audio.c.a.bHz())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void dti()
  {
    AppMethodBeat.i(114508);
    if (t.h(this.wqU)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ);
    }
    while (this.wps != null)
    {
      this.wps.dor();
      localObject = t.dtA();
      if (localObject != this.wrg) {
        this.wrg = ((t.a)localObject);
      }
      AppMethodBeat.o(114508);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wvY);
    }
    Object localObject = new Intent();
    com.tencent.mm.br.d.b(ak.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(114508);
  }
  
  private void dto()
  {
    AppMethodBeat.i(114519);
    try
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.lA(26)) && (this.wrk))
      {
        ak.getContext().unbindService(this);
        this.wrk = false;
      }
      AppMethodBeat.o(114519);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MT.MultiTalkManager", localException, "unBind VoipSmallService error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(114519);
    }
  }
  
  private static boolean dtt()
  {
    AppMethodBeat.i(114530);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ak.getContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          continue;
        }
        i = localTelephonyManager.getCallState();
        switch (i)
        {
        default: 
          bool = false;
        }
      }
      catch (Exception localException1)
      {
        int i;
        boolean bool = false;
        ae.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ae.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(114530);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public static void dtu()
  {
    AppMethodBeat.i(178891);
    com.tencent.mm.plugin.voip.c.eyt().dtu();
    AppMethodBeat.o(178891);
  }
  
  private void k(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(190780);
    a(this.wqU, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(190780);
  }
  
  private void oZ(boolean paramBoolean)
  {
    AppMethodBeat.i(190787);
    if (this.wro == null)
    {
      AppMethodBeat.o(190787);
      return;
    }
    this.wro.ab(paramBoolean);
    if (!paramBoolean) {
      this.wro = null;
    }
    AppMethodBeat.o(190787);
  }
  
  private void sort()
  {
    AppMethodBeat.i(114494);
    ae.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.wqU.MgI });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.wqU.MgI.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.MgJ.equals(v.aAC())) {
        localLinkedList.add(localMultiTalkGroupMember);
      } else {
        localObject = localMultiTalkGroupMember;
      }
    }
    Collections.sort(localLinkedList, new Comparator() {});
    Collections.sort(localLinkedList, new Comparator() {});
    Collections.sort(localLinkedList, new Comparator() {});
    if (localObject != null) {
      localLinkedList.add(localObject);
    }
    this.wqU.MgI = localLinkedList;
    ae.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.wqU.MgI });
    AppMethodBeat.o(114494);
  }
  
  public final void Ld(int paramInt)
  {
    AppMethodBeat.i(190791);
    h localh = dta();
    if (localh != null) {
      localh.Ld(paramInt);
    }
    AppMethodBeat.o(190791);
  }
  
  public final void Li(int paramInt)
  {
    AppMethodBeat.i(114515);
    ae.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.wrh = true;
      AppMethodBeat.o(114515);
      return;
    }
    this.wrh = false;
    AppMethodBeat.o(114515);
  }
  
  public final boolean Lj(int paramInt)
  {
    AppMethodBeat.i(114523);
    boolean bool;
    if (dsY())
    {
      this.wrt = false;
      bool = z.dtK().dsX();
      ae.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + paramInt + ", isILink:" + bool);
      if (bool) {
        break label171;
      }
      bool = z.dtJ().wqE.Lj(paramInt);
      if (t.Ln(this.wqQ)) {
        dtp();
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo result: %b", new Object[] { Boolean.valueOf(bool) });
      int i = this.wqQ;
      this.wqQ = paramInt;
      if ((this.wps != null) && (i != this.wqQ)) {
        this.wps.gF(i, this.wqQ);
      }
      AppMethodBeat.o(114523);
      return bool;
      dtq();
      continue;
      AppMethodBeat.o(114523);
      return false;
      label171:
      bool = false;
    }
  }
  
  public final boolean Pd()
  {
    return this.fOX;
  }
  
  public final void a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(114503);
    ae.m("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      dtn();
      this.wqO = false;
      dth();
      aUH();
      Intent localIntent = new Intent();
      RemoteViews localRemoteViews = null;
      String str = "";
      if (!paramBoolean.booleanValue())
      {
        if ((com.tencent.mm.compatible.util.d.lC(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
          i = 1;
        }
        if (i != 0) {
          this.wrs = new a(paramMultiTalkGroup, Boolean.FALSE);
        }
        paramBoolean = ak.getResources().getString(2131761415);
        localIntent.putExtra("Voip_User", t.l(paramMultiTalkGroup));
        paramMultiTalkGroup = com.tencent.mm.model.w.zP(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localIntent.getStringExtra("Voip_User")).field_username);
        localRemoteViews = new RemoteViews(ak.getPackageName(), 2131495877);
        localRemoteViews.setTextViewText(2131302963, paramBoolean);
        localRemoteViews.setTextViewText(2131302962, paramMultiTalkGroup);
        localRemoteViews.setImageViewResource(2131306948, 2131234752);
        localRemoteViews.setImageViewResource(2131302957, 2131234488);
        str = paramMultiTalkGroup + paramBoolean;
      }
      com.tencent.mm.util.a.a(ak.getContext(), "multitalk", ".ui.MultiTalkMainUI", localIntent, localRemoteViews, str, com.tencent.mm.bq.a.fcs());
    }
    AppMethodBeat.o(114503);
  }
  
  public final boolean asB(String paramString)
  {
    AppMethodBeat.i(190775);
    String str = paramString;
    if (bu.isNullOrNil(paramString))
    {
      paramString = this.wqU.wmz;
      str = paramString;
      if (bu.isNullOrNil(paramString)) {
        str = this.wqU.MgG;
      }
    }
    if (this.wrq.containsKey(str)) {}
    for (int i = ((Integer)this.wrq.get(str)).intValue();; i = 0)
    {
      if (i == 2)
      {
        AppMethodBeat.o(190775);
        return true;
      }
      AppMethodBeat.o(190775);
      return false;
    }
  }
  
  public final void asD(String paramString)
  {
    AppMethodBeat.i(190790);
    bv localbv = new bv();
    localbv.setType(64);
    localbv.qN(System.currentTimeMillis());
    localbv.setStatus(6);
    localbv.setContent(ak.getContext().getString(2131761445));
    if (com.tencent.mm.model.r.zu(paramString))
    {
      localbv.ui(paramString);
      localbv.setContent(localbv.field_content);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar(localbv);
    }
    if ((this.wri != null) && (paramString.equals(this.wri.wmA)) && (!this.wrr.foU()))
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
      this.wri = null;
      this.wrj = 0L;
      this.wrr.stopTimer();
    }
    AppMethodBeat.o(190790);
  }
  
  public final boolean asF(String paramString)
  {
    AppMethodBeat.i(114524);
    if (dsY())
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      if (dsX())
      {
        if (paramString.equals(""))
        {
          this.wps.dso();
          ae.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe small video of visiable region OK!");
        }
        for (;;)
        {
          AppMethodBeat.o(114524);
          return true;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramString);
          paramString = p.wmO;
          paramString.ad(new p.28(paramString, localArrayList));
          ae.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe large video OK, mems:".concat(String.valueOf(localArrayList)));
        }
      }
      boolean bool = z.dtJ().wqE.asF(paramString);
      ae.i("MicroMsg.MT.MultiTalkManager", "result of old subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(114524);
      return bool;
    }
    AppMethodBeat.o(114524);
    return false;
  }
  
  public final void asG(String paramString)
  {
    AppMethodBeat.i(190795);
    if (dsX())
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast exit due to ILINK mode!!!");
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString)) {
        localArrayList.add(paramString);
      }
      p.wmO.aT(localArrayList);
      AppMethodBeat.o(190795);
      return;
    }
    if (this.wqV == null) {
      this.wqV = new w();
    }
    this.wqV.a(dte());
    if (TextUtils.isEmpty(paramString))
    {
      this.wqV.dtD();
      AppMethodBeat.o(190795);
      return;
    }
    ae.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast ownerUserName : ".concat(String.valueOf(paramString)));
    this.wqV.asN(paramString);
    ae.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast error");
    AppMethodBeat.o(190795);
  }
  
  public final void b(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114502);
    boolean bool2 = this.fOX;
    boolean bool3 = this.leL;
    boolean bool4 = this.wqR;
    Object localObject = this.wqT.toString();
    if (this.wqU == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      n.dsJ();
      if ((com.tencent.mm.n.f.abQ()) || (cJ(ak.getContext()))) {
        break;
      }
      ae.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.wri == null) && (this.wrr.foU()))
      {
        this.wri = paramMultiTalkGroup;
        this.wrr.ay(2000L, 2000L);
        this.wrj = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(114502);
      return;
    }
    localObject = t.l(paramMultiTalkGroup);
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localObject);
    if ((!com.tencent.mm.bh.e.aMH()) || (localan == null) || (localan.adv()))
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190774);
          String str2 = paramMultiTalkGroup.wmz;
          String str1 = str2;
          if (bu.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.MgG;
          }
          z.dtJ().wqE.ast(str1);
          AppMethodBeat.o(190774);
        }
      }, 1000L);
      n.bw(3, t.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if ((dsk()) || (com.tencent.mm.plugin.voip.b.n.isVoipStarted()) || (com.tencent.mm.plugin.voip.b.n.eDM()) || (com.tencent.mm.bh.e.aMG()) || (com.tencent.mm.bh.e.PC()) || (com.tencent.mm.plugin.voip.b.n.eDN()) || (!com.tencent.mm.contact.c.lO(localan.field_type)))
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
      if (!com.tencent.mm.model.r.zs(paramMultiTalkGroup.wmA))
      {
        ae.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.wmA });
        au.a.hIG.a(paramMultiTalkGroup.wmA, "", new au.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
        });
      }
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114485);
          String str2 = paramMultiTalkGroup.wmz;
          String str1 = str2;
          if (bu.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.MgG;
          }
          z.dtJ().wqE.ast(str1);
          AppMethodBeat.o(114485);
        }
      }, 1000L);
      n.bw(3, t.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if (!com.tencent.mm.model.r.zs(paramMultiTalkGroup.wmA))
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.wmA });
      au.a.hIG.a(paramMultiTalkGroup.wmA, "", null);
    }
    ae.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.i.wvW);
    n.bw(1, t.k(paramMultiTalkGroup));
    if ((!com.tencent.mm.contact.c.lO(localan.field_type)) || (com.tencent.mm.r.a.adP()))
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { localObject, v.aAC() });
      if (a(paramMultiTalkGroup))
      {
        this.wqO = false;
        dth();
        aUH();
        AppMethodBeat.o(114502);
      }
    }
    else
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { localObject, v.aAC() });
      localObject = new md();
      ((md)localObject).dAD.action = 3;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      a(paramMultiTalkGroup, Boolean.FALSE);
    }
    AppMethodBeat.o(114502);
  }
  
  public final void c(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114496);
    boolean bool2 = this.fOX;
    boolean bool3 = this.leL;
    boolean bool4 = this.wqR;
    Object localObject1 = this.wqT.toString();
    if (this.wqU == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject1, Boolean.valueOf(bool1) });
      n.dsI();
      if (!dtt()) {
        break;
      }
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760333, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.n.eDM())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760337, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.n.isVoipStarted())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760336, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.bh.e.aMG())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760332, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.n.eDN())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760335, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (dsk())
    {
      com.tencent.mm.bh.e.a(paramActivity, 2131761410, null);
      AppMethodBeat.o(114496);
      return;
    }
    if ((this.wrd) && (System.currentTimeMillis() - this.wre < this.wrf))
    {
      com.tencent.mm.bh.e.a(paramActivity, 2131761433, null);
      AppMethodBeat.o(114496);
      return;
    }
    this.wrd = false;
    Object localObject3 = bu.U(paramString1.split(","));
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qQc, 0);
    ae.i("MicroMsg.MT.MultiTalkManager", "getMultiTalkSDKMode sdk mode:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ac(paramString1, paramString2, 2);
      AppMethodBeat.o(114496);
      return;
    }
    paramActivity = p.wmO;
    paramString1 = new o.8(this, paramString1, paramString2);
    Object localObject2 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject2).hQF = new dxh();
    ((com.tencent.mm.ak.b.a)localObject2).hQG = new dxi();
    ((com.tencent.mm.ak.b.a)localObject2).funcId = 5949;
    ((com.tencent.mm.ak.b.a)localObject2).uri = "/cgi-bin/micromsg-bin/voipmtgetsdkmode";
    ((com.tencent.mm.ak.b.a)localObject2).hQH = 0;
    ((com.tencent.mm.ak.b.a)localObject2).respCmdId = 0;
    localObject1 = new LinkedList();
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      dxw localdxw = new dxw();
      localdxw.username = str;
      ((LinkedList)localObject1).add(localdxw);
    }
    localObject2 = ((com.tencent.mm.ak.b.a)localObject2).aDS();
    localObject3 = (dxh)((com.tencent.mm.ak.b)localObject2).hQD.hQJ;
    ((dxh)localObject3).IcH = ((LinkedList)localObject1);
    ((dxh)localObject3).Icy = paramString2;
    IPCRunCgi.a((com.tencent.mm.ak.b)localObject2, new p.5(paramActivity, paramString1));
    AppMethodBeat.o(114496);
  }
  
  public final void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114505);
    n.bw(2, t.k(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i.wvW, true);
    AppMethodBeat.o(114505);
  }
  
  public final boolean cbt()
  {
    AppMethodBeat.i(190798);
    if (this.wrl != null)
    {
      boolean bool = this.wrl.haq.OH();
      AppMethodBeat.o(190798);
      return bool;
    }
    AppMethodBeat.o(190798);
    return true;
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114506);
    ae.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
    n.oX(true);
    if (a(paramMultiTalkGroup)) {
      dti();
    }
    AppMethodBeat.o(114506);
  }
  
  public final void d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114498);
    if (!com.tencent.mm.model.r.zs(paramString1))
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      au.a.hIG.a(paramString1, "", new au.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    bv localbv = new bv();
    localbv.setType(64);
    localbv.qN(System.currentTimeMillis());
    localbv.setStatus(6);
    localbv.kt(2);
    paramString2 = asC(paramString2);
    localbv.setContent(paramString2);
    if (com.tencent.mm.model.r.zu(paramString1))
    {
      localbv.ui(paramString1);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar(localbv);
      au localau = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa(paramString1);
      if (localau != null)
      {
        if (paramBoolean1) {
          localau.kr(localau.field_unReadCount + 1);
        }
        localau.setContent(paramString2);
        if (((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(localau, paramString1) == -1) {
          ae.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
        }
        if (paramBoolean2)
        {
          ((com.tencent.mm.model.aw)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbv);
          AppMethodBeat.o(114498);
        }
      }
      else
      {
        localau = new au();
        localau.setUsername(paramString1);
        if (paramBoolean1) {
          localau.kr(1);
        }
        localau.setContent(paramString2);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().e(localau);
        if (paramBoolean2) {
          ((com.tencent.mm.model.aw)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbv);
        }
      }
    }
    AppMethodBeat.o(114498);
  }
  
  public final MultiTalkGroup dsT()
  {
    return this.wqU;
  }
  
  public final boolean dsU()
  {
    AppMethodBeat.i(114487);
    boolean bool = t.Lm(this.wqQ);
    AppMethodBeat.o(114487);
    return bool;
  }
  
  public final boolean dsV()
  {
    return this.leL;
  }
  
  public final HashSet<String> dsW()
  {
    return this.wqS;
  }
  
  public final boolean dsX()
  {
    AppMethodBeat.i(190776);
    if (this.wqU != null)
    {
      boolean bool = asB(this.wqU.wmA);
      AppMethodBeat.o(190776);
      return bool;
    }
    AppMethodBeat.o(190776);
    return false;
  }
  
  public final boolean dsY()
  {
    AppMethodBeat.i(114490);
    if ((this.wqT == com.tencent.mm.plugin.multitalk.ui.widget.i.wvY) || (this.wqT == com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114490);
      return bool;
    }
  }
  
  public final boolean dsj()
  {
    AppMethodBeat.i(114491);
    if (this.wqT == com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114491);
      return bool;
    }
  }
  
  public final boolean dsk()
  {
    AppMethodBeat.i(114489);
    if ((this.wqT != com.tencent.mm.plugin.multitalk.ui.widget.i.wvV) && (this.wqU != null)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114489);
      return bool;
    }
  }
  
  public final r dtb()
  {
    AppMethodBeat.i(190783);
    if (this.wrm == null) {
      this.wrm = new r();
    }
    r localr = this.wrm;
    AppMethodBeat.o(190783);
    return localr;
  }
  
  public final ac dtc()
  {
    AppMethodBeat.i(190784);
    if (this.wrn == null) {
      this.wrn = new ad(z.dtJ().wqE);
    }
    ad localad = this.wrn;
    AppMethodBeat.o(190784);
    return localad;
  }
  
  public final ab dte()
  {
    AppMethodBeat.i(190786);
    if (this.wro == null) {
      this.wro = new ab();
    }
    ab localab = this.wro;
    AppMethodBeat.o(190786);
    return localab;
  }
  
  public final a dtf()
  {
    AppMethodBeat.i(190788);
    if (this.wrp == null) {
      this.wrp = new a();
    }
    a locala = this.wrp;
    AppMethodBeat.o(190788);
    return locala;
  }
  
  public final void dtg()
  {
    AppMethodBeat.i(162239);
    this.wrs = null;
    this.wrc = false;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162239);
  }
  
  public final void dtj()
  {
    AppMethodBeat.i(114510);
    ae.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(114510);
  }
  
  public final void dtk()
  {
    AppMethodBeat.i(114513);
    ae.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.wqQ) });
    AppMethodBeat.o(114513);
  }
  
  public final void dtl()
  {
    AppMethodBeat.i(114514);
    ae.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(114514);
  }
  
  public final void dtm()
  {
    AppMethodBeat.i(178889);
    ae.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
    AppMethodBeat.o(178889);
  }
  
  public final void dtn()
  {
    AppMethodBeat.i(190792);
    this.wrl = new com.tencent.mm.plugin.multitalk.a.a();
    if (this.leL) {
      this.wrl.cn(true);
    }
    com.tencent.mm.plugin.multitalk.a.a.drE();
    AppMethodBeat.o(190792);
  }
  
  public final void dtp()
  {
    AppMethodBeat.i(114520);
    ae.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (dsX())
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver exit due to ILINK mode!!!");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.wps == null)
    {
      ae.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.wqS.size() == 0)
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.wqV == null)
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "startNetworkDataSource: NetworkDataSource is null %d", new Object[] { Integer.valueOf(this.wqS.size()) });
      this.wqV = new w();
    }
    this.wqV.a(dte());
    w localw = this.wqV;
    if (!localw.wsh)
    {
      ae.i("NetworkDataSource", "start");
      localw.wsh = true;
      w.b[] arrayOfb = localw.wsg;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = arrayOfb[i];
        synchronized (Boolean.valueOf(((w.b)localObject3).wsp))
        {
          if (!((w.b)localObject3).wsp)
          {
            ((w.b)localObject3).wsp = true;
            new Thread((Runnable)localObject3).start();
          }
          localObject3 = d.z.Nhr;
          i += 1;
        }
      }
      if (localObject2.dtC()) {
        localObject2.asN(localObject2.wsk);
      }
    }
    if (dtf().drT())
    {
      ??? = dtf().wpF;
      if (??? != null)
      {
        ??? = ((com.tencent.mm.plugin.multitalk.ui.widget.b)???).wua;
        if (??? != null)
        {
          String str = ((MultiTalkVideoView)???).getUsername();
          ??? = str;
          if (str != null) {
            break label329;
          }
        }
      }
      ??? = "";
      label329:
      asG((String)???);
    }
    AppMethodBeat.o(114520);
  }
  
  public final void dtq()
  {
    AppMethodBeat.i(114521);
    ae.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
    if (this.wqV != null)
    {
      this.wqV.stop();
      this.wqV = null;
    }
    AppMethodBeat.o(114521);
  }
  
  public final boolean dtr()
  {
    AppMethodBeat.i(190793);
    if (dsY())
    {
      this.wrt = true;
      this.wqQ = 3;
      if (!z.dtK().dsX())
      {
        boolean bool = z.dtJ().wqE.Lj(3);
        AppMethodBeat.o(190793);
        return bool;
      }
      AppMethodBeat.o(190793);
      return true;
    }
    AppMethodBeat.o(190793);
    return false;
  }
  
  public final List<String> dts()
  {
    AppMethodBeat.i(190797);
    String str = this.wqU.wmz;
    Object localObject = str;
    if (bu.isNullOrNil(str)) {
      localObject = this.wqU.MgG;
    }
    boolean bool = asB(this.wqU.wmA);
    ae.d("MicroMsg.MT.MultiTalkManager", "getWeakNetworkMember: %s, groupid:%s, isILink:%b", new Object[] { t.g(this.wqU), this.wqU.wmA, Boolean.valueOf(bool) });
    new ArrayList();
    if (bool) {}
    for (localObject = p.wmO.drQ();; localObject = u.wse.asM((String)localObject))
    {
      AppMethodBeat.o(190797);
      return localObject;
      if (u.wse == null) {
        u.wse = new u();
      }
    }
  }
  
  public final boolean dtv()
  {
    return this.wqP;
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114507);
    ae.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
    qn localqn = new qn();
    localqn.dGn.type = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localqn);
    n.oY(true);
    if (this.wqT != com.tencent.mm.plugin.multitalk.ui.widget.i.wvW)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wvY);
      a(paramMultiTalkGroup, Boolean.TRUE);
    }
    if ((dsk()) && (a(paramMultiTalkGroup))) {
      dti();
    }
    AppMethodBeat.o(114507);
  }
  
  public final void eE(List<a.ap> paramList)
  {
    AppMethodBeat.i(114516);
    if (dsk())
    {
      Object localObject = dta();
      if (localObject != null) {
        ((h)localObject).eE(paramList);
      }
      this.wqS.clear();
      ae.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (a.ap)paramList.next();
        if ((((a.ap)localObject).MeT == 2) || (((a.ap)localObject).MeT == 3)) {
          this.wqS.add(((a.ap)localObject).duC);
        }
      }
      ae.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.wqS });
      if (this.wps != null)
      {
        this.wps.dsn();
        AppMethodBeat.o(114516);
        return;
      }
      ae.e("MicroMsg.MT.MultiTalkManager", "uiCallback is NULL !!!");
    }
    AppMethodBeat.o(114516);
  }
  
  public final void eF(List<String> paramList)
  {
    AppMethodBeat.i(190778);
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    if (dsk())
    {
      localObject2 = this.wqU.wmz;
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = this.wqU.MgG;
      }
      boolean bool = asB(this.wqU.wmA);
      ae.i("MicroMsg.MT.MultiTalkManager", "addMemberList: %s, wifigateway:%d, groupid:%s, isILink:%b", new Object[] { t.g(this.wqU), Integer.valueOf(v2protocal.eCg()), this.wqU.wmA, Boolean.valueOf(bool) });
      if (bool)
      {
        localObject1 = p.wmO;
        localObject2 = new LinkedList();
        localArrayList = ((p)localObject1).wmo.drI();
        paramList = paramList.iterator();
      }
    }
    label295:
    for (;;)
    {
      String str;
      if (paramList.hasNext())
      {
        str = (String)paramList.next();
        Iterator localIterator = localArrayList.iterator();
        j localj;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localj = (j)localIterator.next();
        } while ((!str.equals(localj.fIQ)) || ((localj.mStatus != 1) && (localj.mStatus != 2) && (localj.mStatus != 3)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label295;
        }
        ((LinkedList)localObject2).add(str);
        break;
        IPCRunCgi.a(com.tencent.mm.plugin.multitalk.b.i.aI((LinkedList)localObject2), new p.20((p)localObject1));
        AppMethodBeat.o(190778);
        return;
        z.dtJ().wqE.J((String)localObject1, paramList);
        AppMethodBeat.o(190778);
        return;
      }
    }
  }
  
  public final boolean eG(List<a.ao> paramList)
  {
    AppMethodBeat.i(190796);
    if (dsY())
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(paramList)));
      boolean bool = z.dtJ().wqE.eG(paramList);
      ae.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(190796);
      return bool;
    }
    AppMethodBeat.o(190796);
    return false;
  }
  
  public final void ey(String paramString, int paramInt)
  {
    AppMethodBeat.i(190777);
    ae.i("MicroMsg.MT.MultiTalkManager", "setCurrentMTSDKMode groupid:%s, mode:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.wrq == null)
    {
      AppMethodBeat.o(190777);
      return;
    }
    if ((!this.wrq.containsKey(paramString)) || (((Integer)this.wrq.get(paramString)).intValue() != paramInt)) {
      this.wrq.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(190777);
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114509);
    ae.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { t.g(paramMultiTalkGroup) });
    if ((dsk()) && (a(paramMultiTalkGroup)))
    {
      if (!t.i(this.wqU))
      {
        if (this.wqT == com.tencent.mm.plugin.multitalk.ui.widget.i.wvW)
        {
          j(false, true, false);
          AppMethodBeat.o(114509);
          return;
        }
        j(false, false, false);
        AppMethodBeat.o(114509);
        return;
      }
      if ((this.wqT != com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ) && (t.h(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.i.wvZ);
      }
      if ((this.wps != null) && (t.c(this.wqT))) {
        this.wps.dsm();
      }
    }
    AppMethodBeat.o(114509);
  }
  
  public final long getTotalTime()
  {
    AppMethodBeat.i(114492);
    long l1 = System.currentTimeMillis();
    long l2 = this.wqY;
    AppMethodBeat.o(114492);
    return l1 - l2;
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(114497);
    ae.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    dta().close();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    z.dtK().stopRing();
    Object localObject;
    if (dsk())
    {
      localObject = new qn();
      ((qn)localObject).dGn.type = 2;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      k(paramBoolean1, paramBoolean2, paramBoolean3);
      localObject = this.wqT;
      if (this.wps != null) {
        this.wps.dsl();
      }
      this.wqW = false;
      this.wqX = false;
      this.wqT = com.tencent.mm.plugin.multitalk.ui.widget.i.wvV;
      dtq();
      dtd();
      oZ(false);
      this.wrp = null;
      nD(true);
      bxX();
      if (this.wrl != null) {
        this.wrl.drG();
      }
      z.dtI().reset();
      if (this.wqU != null)
      {
        a(this.wqU, (com.tencent.mm.plugin.multitalk.ui.widget.i)localObject, paramBoolean2);
        String str = this.wqU.wmz;
        localObject = str;
        if (bu.isNullOrNil(str)) {
          localObject = this.wqU.MgG;
        }
        if (dsX())
        {
          p.wmO.Lb(1);
          if (this.wrq != null) {
            this.wrq.remove(this.wqU.wmA);
          }
          this.wqU = null;
        }
      }
      else
      {
        this.wqQ = 0;
        this.leL = true;
        this.fOX = false;
        this.wqR = true;
        this.wqY = 0L;
        this.wqZ = 0;
        this.wqS.clear();
        localObject = new fk();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        this.wrc = true;
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.multitalk.d.d.wxl;
      com.tencent.mm.plugin.multitalk.d.d.report();
      dto();
      AppMethodBeat.o(114497);
      return;
      z.dtJ().wqE.ast((String)localObject);
      break;
      if (!this.wrc)
      {
        dtq();
        nD(false);
        bxX();
        if (this.wrl != null) {
          this.wrl.drG();
        }
        this.wqU = null;
        this.wqQ = 0;
        this.wqY = 0L;
        this.wqZ = 0;
        this.wqS.clear();
        this.wqT = com.tencent.mm.plugin.multitalk.ui.widget.i.wvV;
        this.wra = 0;
      }
    }
  }
  
  public final void m(int paramInt, Object paramObject)
  {
    int j = 2131761391;
    AppMethodBeat.i(114501);
    ae.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXO, Integer.valueOf(-1));
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXP, Long.valueOf(-1L));
    int i;
    switch (paramInt)
    {
    default: 
      i = 2131761406;
    }
    for (;;)
    {
      if (this.wps != null) {
        this.wps.onError(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(ak.getContext(), ak.getContext().getString(i), 0).show();
        j(false, false, true);
      }
      AppMethodBeat.o(114501);
      return;
      n.oX(false);
      i = 2131761394;
      continue;
      n.oY(false);
      i = 2131761402;
      continue;
      i = 2131761403;
      continue;
      i = 2131761404;
      continue;
      i = 2131761405;
      continue;
      i = 2131761406;
      continue;
      i = 2131761407;
      continue;
      i = 2131761408;
      continue;
      i = 2131761409;
      continue;
      i = 2131761395;
      continue;
      i = 2131761396;
      continue;
      i = 2131761397;
      continue;
      j = 2131761398;
      this.wrd = true;
      this.wre = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.aa)paramObject;
        i = j;
        if (paramObject != null)
        {
          ae.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.Mez);
          i = j;
          if (paramObject.Mez != 0)
          {
            this.wrf = (paramObject.Mez * 1000);
            i = j;
            continue;
            ae.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = 2131761400;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.ab)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.gdH().zQ(false);
                i = j;
                continue;
                i = 2131761399;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.wqU;
                if (this.wqU != null) {}
                for (String str = this.wqU.wmA;; str = "")
                {
                  ae.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.ab)paramObject;
                    if (paramObject != null)
                    {
                      ae.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.Mdb != null)
                      {
                        z.dtL().asv(paramObject.Mdb.Mfy);
                        ae.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.Mdb.Mfy);
                      }
                      if (!z.dtJ().wqE.ast(paramObject.groupId)) {
                        ae.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = 2131761444;
                  break;
                }
                ae.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(ak.getContext(), ak.getContext().getString(2131761391), 0).show();
                i = j;
                if (paramObject != null)
                {
                  int k = ((Integer)paramObject).intValue();
                  i = j;
                  if (k > 0)
                  {
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXO, Integer.valueOf(k));
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXP, Long.valueOf(bu.HQ()));
                    i = j;
                    continue;
                    ae.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                    i = 2131761430;
                    continue;
                    ae.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
                    AppMethodBeat.o(114501);
                    return;
                    ae.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
                    i = 2131761401;
                    continue;
                    ae.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
                    i = 2131761401;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void nD(boolean paramBoolean)
  {
    AppMethodBeat.i(178890);
    this.uVM = false;
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.eyt().eCH();
    }
    for (;;)
    {
      ((NotificationManager)ak.getContext().getSystemService("notification")).cancel(43);
      dto();
      AppMethodBeat.o(178890);
      return;
      com.tencent.mm.plugin.voip.c.eyt().rm(false);
    }
  }
  
  public final void oN(boolean paramBoolean)
  {
    AppMethodBeat.i(114511);
    this.fOX = paramBoolean;
    if (this.wps != null) {
      this.wps.oN(this.fOX);
    }
    AppMethodBeat.o(114511);
  }
  
  public final void oP(boolean paramBoolean)
  {
    AppMethodBeat.i(114532);
    if ((z.dtK().dsY()) && (this.wps != null))
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.wps.oP(paramBoolean);
    }
    AppMethodBeat.o(114532);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void pa(boolean paramBoolean)
  {
    AppMethodBeat.i(114517);
    if (dsk())
    {
      if (this.uVM)
      {
        AppMethodBeat.o(114517);
        return;
      }
      this.uVM = true;
      n.i(t.dty(), t.Lm(z.dtK().wqQ), paramBoolean);
      Toast.makeText(ak.getContext(), 2131761425, 0).show();
      Object localObject1 = ak.getContext().getString(2131761388);
      String str = ak.getContext().getString(2131761434);
      Object localObject2 = new Intent();
      ((Intent)localObject2).setClass(ak.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(ak.getContext(), 43, (Intent)localObject2, 134217728);
      int i = 2131233502;
      if (com.tencent.mm.compatible.util.d.lB(19)) {
        i = 2131233500;
      }
      localObject1 = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(str).i(System.currentTimeMillis()).f((CharSequence)localObject1).g(str);
      ((s.c)localObject1).Hl = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.b.n.e((s.c)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
      if (this.wps != null) {
        this.wps.dgf();
      }
      dtd();
      oZ(true);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190764);
          Intent localIntent = new Intent();
          localIntent.setFlags(268435456);
          if (o.f(o.this) != null) {}
          for (String str = o.f(o.this).wmA;; str = "")
          {
            localIntent.putExtra("enterMainUiWxGroupId", str);
            localIntent.setClass(ak.getContext(), MultiTalkMainUI.class);
            localIntent.putExtra("notification", this.wrx);
            localIntent.putExtra("enterMainUiSource", 1);
            com.tencent.mm.plugin.voip.c.eyt().a(localIntent, false, true, new com.tencent.mm.plugin.voip.ui.a()
            {
              public final void a(Intent paramAnonymous2Intent, BaseSmallView paramAnonymous2BaseSmallView)
              {
                AppMethodBeat.i(190763);
                if (!o.this.dsj())
                {
                  paramAnonymous2BaseSmallView.aFd(ak.getContext().getString(2131761459));
                  AppMethodBeat.o(190763);
                  return;
                }
                int i = o.this.wqZ;
                paramAnonymous2BaseSmallView.aFc(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
                AppMethodBeat.o(190763);
              }
              
              public final boolean dgb()
              {
                AppMethodBeat.i(190762);
                if ((o.this.dsY()) || (o.this.dsj()))
                {
                  AppMethodBeat.o(190762);
                  return true;
                }
                AppMethodBeat.o(190762);
                return false;
              }
            });
            o.g(o.this);
            AppMethodBeat.o(190764);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(114517);
  }
  
  public final void pb(boolean paramBoolean)
  {
    AppMethodBeat.i(114512);
    ae.m("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (dsX()) {
      p.wmO.wmR.wmm.wmq.jG(paramBoolean);
    }
    for (;;)
    {
      ae.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
      this.leL = paramBoolean;
      if (this.wps != null) {
        this.wps.oO(this.leL);
      }
      AppMethodBeat.o(114512);
      return;
      z.dtJ().wqE.pb(paramBoolean);
    }
  }
  
  public final void pc(boolean paramBoolean)
  {
    AppMethodBeat.i(114528);
    if (this.wqO)
    {
      AppMethodBeat.o(114528);
      return;
    }
    if (this.wrl != null)
    {
      this.wrl.M(paramBoolean, 0);
      this.wqO = true;
    }
    AppMethodBeat.o(114528);
  }
  
  public final void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(114533);
    ae.m("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wqP = paramBoolean;
    AppMethodBeat.o(114533);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(114529);
    if ((this.wqO) && (this.wrl != null))
    {
      this.wrl.drF();
      this.wqO = false;
    }
    AppMethodBeat.o(114529);
  }
  
  final class a
  {
    MultiTalkGroup wrF;
    Boolean wrG;
    
    a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
    {
      this.wrF = paramMultiTalkGroup;
      this.wrG = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.o
 * JD-Core Version:    0.7.0.1
 */