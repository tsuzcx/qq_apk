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
import android.widget.RemoteViews;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.d.4;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.pb.common.b.a.a.a.aa;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.b.a.a.a.aw;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class f
  implements ServiceConnection, com.tencent.pb.talkroom.sdk.a
{
  public boolean ftN;
  com.tencent.mm.sdk.b.c gGt;
  public boolean kER;
  private boolean tHm;
  MultiTalkGroup uXA;
  long uXB;
  private boolean uXC;
  public com.tencent.mm.plugin.multitalk.a.a uXD;
  au uXE;
  a uXF;
  private ao uXG;
  BroadcastReceiver uXH;
  private boolean uXe;
  private boolean uXf;
  public int uXg;
  public boolean uXh;
  public HashSet<String> uXi;
  public com.tencent.mm.plugin.multitalk.ui.widget.i uXj;
  public MultiTalkGroup uXk;
  private l uXl;
  public boolean uXm;
  public boolean uXn;
  private long uXo;
  public int uXp;
  private int uXq;
  private int uXr;
  private boolean uXs;
  private boolean uXt;
  private long uXu;
  private long uXv;
  public b uXw;
  private Timer uXx;
  private j.a uXy;
  public boolean uXz;
  
  public f()
  {
    AppMethodBeat.i(114486);
    this.uXh = true;
    this.uXi = new HashSet();
    this.uXj = com.tencent.mm.plugin.multitalk.ui.widget.i.vbj;
    this.uXk = null;
    this.uXm = false;
    this.uXn = false;
    this.uXo = 0L;
    this.uXp = 0;
    this.uXq = 0;
    this.uXr = 2;
    this.uXs = false;
    this.uXt = false;
    this.uXu = 0L;
    this.uXv = 30000L;
    this.uXA = null;
    this.uXB = 0L;
    this.uXC = false;
    this.uXE = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114480);
        ac.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (f.a(f.this) == null)
        {
          f.b(f.this);
          f.c(f.this).stopTimer();
          AppMethodBeat.o(114480);
          return false;
        }
        if (f.fN(com.tencent.mm.sdk.platformtools.ai.getContext()))
        {
          f.this.b(f.a(f.this));
          f.d(f.this);
          f.b(f.this);
          f.c(f.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 7L, 1L, false);
          AppMethodBeat.o(114480);
          return false;
        }
        if (System.currentTimeMillis() - f.e(f.this) < 60000L)
        {
          AppMethodBeat.o(114480);
          return true;
        }
        f.d(f.this);
        f.b(f.this);
        f.c(f.this).stopTimer();
        AppMethodBeat.o(114480);
        return false;
      }
    }, true);
    this.uXG = new ao(Looper.getMainLooper());
    this.uXH = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114473);
        if (!f.this.dfo())
        {
          AppMethodBeat.o(114473);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          f.h(f.this).removeCallbacksAndMessages(null);
          f.h(f.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114470);
              j.a locala1 = j.dgo();
              if (locala1 != f.i(f.this))
              {
                j.a locala2 = f.i(f.this);
                f.a(f.this, locala1);
                ac.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), f.i(f.this).name() });
                f.this.Jf(f.j(f.this));
                if (f.k(f.this) != null) {
                  f.k(f.this).a(f.i(f.this));
                }
                AppMethodBeat.o(114470);
                return;
              }
              f.this.Jf(f.j(f.this));
              ac.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { f.i(f.this).name() });
              AppMethodBeat.o(114470);
            }
          }, 8000L);
          AppMethodBeat.o(114473);
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
        for (;;)
        {
          ac.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[] { Integer.valueOf(i) });
          if (i != 0) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114471);
              p.dgw().uWU.yB(false);
              if (f.this.uXD != null) {
                f.this.uXD.Ms();
              }
              if (!com.tencent.mm.plugin.audio.c.a.bCy()) {
                f.this.ox(p.dgx().kER);
              }
              AppMethodBeat.o(114471);
            }
          });
          AppMethodBeat.o(114473);
          return;
          if (paramAnonymousIntent.equals("RINGING")) {
            i = 1;
          } else if (paramAnonymousIntent.equals("OFFHOOK")) {
            i = 2;
          } else {
            i = ((TelephonyManager)paramAnonymousContext.getSystemService("phone")).getCallState();
          }
        }
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114472);
            p.dgw().uWU.yB(true);
            AppMethodBeat.o(114472);
          }
        });
        AppMethodBeat.o(114473);
      }
    };
    this.gGt = new f.4(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.gGt);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
    localIntentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(this.uXH, localIntentFilter);
    this.uXz = false;
    AppMethodBeat.o(114486);
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(114500);
    ac.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((parami == com.tencent.mm.plugin.multitalk.ui.widget.i.vbk) && (paramBoolean))
    {
      parami = new bo();
      parami.setType(64);
      parami.oA(System.currentTimeMillis());
      parami.setStatus(6);
      parami.setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761448));
      if (q.vT(paramMultiTalkGroup.JPT))
      {
        parami.re(paramMultiTalkGroup.JPT);
        parami.setContent(parami.field_content);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(parami);
      }
    }
    AppMethodBeat.o(114500);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114493);
    if (!dfo())
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { j.g(paramMultiTalkGroup) });
      this.uXk = paramMultiTalkGroup;
      this.uXp = 0;
      this.uXg = 1;
      this.uXi.clear();
      dfV();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    Object localObject1 = this.uXk;
    int i;
    if ((paramMultiTalkGroup == null) || (localObject1 == null)) {
      i = 0;
    }
    while (i != 0)
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { j.g(paramMultiTalkGroup) });
      Object localObject2 = this.uXk;
      localObject1 = new HashMap();
      Object localObject3 = paramMultiTalkGroup.JPV.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject3).next();
          ((HashMap)localObject1).put(localMultiTalkGroupMember.JPW, localMultiTalkGroupMember);
          continue;
          if ((!bs.isNullOrNil(paramMultiTalkGroup.JPR)) && (!bs.isNullOrNil(((MultiTalkGroup)localObject1).JPR)) && (paramMultiTalkGroup.JPR.equals(((MultiTalkGroup)localObject1).JPR)))
          {
            i = 1;
            break;
          }
          if ((!bs.isNullOrNil(paramMultiTalkGroup.JPS)) && (!bs.isNullOrNil(((MultiTalkGroup)localObject1).JPS)) && (paramMultiTalkGroup.JPS.equals(((MultiTalkGroup)localObject1).JPS)))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      localObject2 = ((MultiTalkGroup)localObject2).JPV.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiTalkGroupMember)((Iterator)localObject2).next();
        if ((!u.axw().equals(((MultiTalkGroupMember)localObject3).JPW)) && (u.axw().equals(((MultiTalkGroupMember)localObject3).JPX)) && (((MultiTalkGroupMember)localObject3).status == 1) && ((!((HashMap)localObject1).containsKey(((MultiTalkGroupMember)localObject3).JPW)) || (((MultiTalkGroupMember)((HashMap)localObject1).get(((MultiTalkGroupMember)localObject3).JPW)).status == 20)))
        {
          localObject3 = ((MultiTalkGroupMember)localObject3).JPW;
          localObject3 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761442, new Object[] { v.wk((String)localObject3) });
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(com.tencent.mm.sdk.platformtools.ai.getContext(), (CharSequence)localObject3);
          Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), (CharSequence)localObject3, 0).show();
        }
      }
      this.uXk = paramMultiTalkGroup;
      dfV();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    ac.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { j.g(this.uXk), j.g(paramMultiTalkGroup) });
    AppMethodBeat.o(114493);
    return false;
  }
  
  private void aQW()
  {
    AppMethodBeat.i(114526);
    ac.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.uXx != null)
    {
      this.uXx.cancel();
      AppMethodBeat.o(114526);
      return;
    }
    this.uXo = System.currentTimeMillis();
    this.uXp = 0;
    this.uXx = new Timer();
    TimerTask local3 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(114476);
        if ((f.this.getTotalTime() >= 45000L) && (f.l(f.this) != com.tencent.mm.plugin.multitalk.ui.widget.i.vbn)) {
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114474);
              f.this.h(false, true, false);
              AppMethodBeat.o(114474);
            }
          });
        }
        if (f.l(f.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.vbn)
        {
          f.m(f.this);
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114475);
              if (f.l(f.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.vbn)
              {
                com.tencent.mm.plugin.voip.c.ehc().sQ(f.this.uXp);
                if (f.k(f.this) != null) {
                  f.k(f.this).cUd();
                }
              }
              AppMethodBeat.o(114475);
            }
          });
        }
        AppMethodBeat.o(114476);
      }
    };
    this.uXx.schedule(local3, 1000L, 1000L);
    AppMethodBeat.o(114526);
  }
  
  public static void amx(String paramString)
  {
    AppMethodBeat.i(114499);
    ac.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    bo localbo = new bo();
    localbo.setType(64);
    localbo.oA(System.currentTimeMillis());
    localbo.setStatus(6);
    localbo.setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761448));
    if (q.vT(paramString))
    {
      localbo.re(paramString);
      localbo.setContent(localbo.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
    }
    AppMethodBeat.o(114499);
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.i parami)
  {
    boolean bool = true;
    AppMethodBeat.i(114525);
    Object localObject = this.uXj;
    this.uXj = parami;
    if (localObject != parami) {
      if (parami == com.tencent.mm.plugin.multitalk.ui.widget.i.vbn)
      {
        localObject = new qb();
        ((qb)localObject).dtg.type = 1;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        e.a(j.i(this.uXk), getTotalTime(), j.j(this.uXk));
        p.dgx().stopRing();
        com.tencent.mm.plugin.audio.c.a.setMode(3);
        if ((com.tencent.mm.plugin.audio.c.a.bCs()) || (com.tencent.mm.plugin.audio.c.a.bCy())) {
          break label126;
        }
      }
    }
    for (;;)
    {
      ox(bool);
      if (this.uXw != null) {
        this.uXw.a(parami);
      }
      AppMethodBeat.o(114525);
      return;
      label126:
      bool = false;
    }
  }
  
  private void bsZ()
  {
    AppMethodBeat.i(114527);
    if (this.uXx != null)
    {
      this.uXx.cancel();
      this.uXx = null;
    }
    AppMethodBeat.o(114527);
  }
  
  private static boolean cK(Context paramContext)
  {
    AppMethodBeat.i(114531);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ac.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ac.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
        AppMethodBeat.o(114531);
        return false;
      }
    }
    if (((KeyguardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(114531);
      return false;
    }
    ac.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
    AppMethodBeat.o(114531);
    return true;
  }
  
  private void dfV()
  {
    AppMethodBeat.i(114495);
    Iterator localIterator = this.uXk.JPV.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.uXi.remove(localMultiTalkGroupMember.JPW))) {
        ac.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.JPW });
      }
    }
    AppMethodBeat.o(114495);
  }
  
  private void dfX()
  {
    AppMethodBeat.i(114504);
    if (this.uXj == com.tencent.mm.plugin.multitalk.ui.widget.i.vbl) {}
    for (;;)
    {
      boolean bool = false;
      for (f localf = this;; localf = this)
      {
        localf.kER = bool;
        this.ftN = false;
        this.uXy = j.dgo();
        AppMethodBeat.o(114504);
        return;
        if ((com.tencent.mm.plugin.audio.c.a.bCs()) || (com.tencent.mm.plugin.audio.c.a.bCy())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void dfY()
  {
    AppMethodBeat.i(114508);
    if (j.h(this.uXk)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.vbn);
    }
    while (this.uXw != null)
    {
      this.uXw.dbX();
      localObject = j.dgo();
      if (localObject != this.uXy) {
        this.uXy = ((j.a)localObject);
      }
      AppMethodBeat.o(114508);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.vbm);
    }
    Object localObject = new Intent();
    com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(114508);
  }
  
  private void dge()
  {
    AppMethodBeat.i(114519);
    try
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.kZ(26)) && (this.uXC))
      {
        com.tencent.mm.sdk.platformtools.ai.getContext().unbindService(this);
        this.uXC = false;
      }
      AppMethodBeat.o(114519);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MT.MultiTalkManager", localException, "unBind VoipSmallService error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(114519);
    }
  }
  
  private static boolean dgh()
  {
    AppMethodBeat.i(114530);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("phone");
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
        ac.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ac.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
  
  public static void dgi()
  {
    AppMethodBeat.i(178891);
    com.tencent.mm.plugin.voip.ui.d locald = com.tencent.mm.plugin.voip.c.ehc();
    if ((locald.AKy != null) && (!locald.AKB))
    {
      com.tencent.e.h.JZN.aTz("showIcon");
      com.tencent.e.h.JZN.f(new d.4(locald), "showIcon");
    }
    AppMethodBeat.o(178891);
  }
  
  private void sort()
  {
    AppMethodBeat.i(114494);
    ac.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.uXk.JPV });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.uXk.JPV.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.JPW.equals(u.axw())) {
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
    this.uXk.JPV = localLinkedList;
    ac.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.uXk.JPV });
    AppMethodBeat.o(114494);
  }
  
  public final void Je(int paramInt)
  {
    AppMethodBeat.i(114515);
    ac.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.uXz = true;
      AppMethodBeat.o(114515);
      return;
    }
    this.uXz = false;
    AppMethodBeat.o(114515);
  }
  
  public final boolean Jf(int paramInt)
  {
    AppMethodBeat.i(114523);
    if (dfU())
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "try switch to action : ".concat(String.valueOf(paramInt)));
      boolean bool = p.dgw().uWU.Jf(paramInt);
      ac.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[] { Boolean.valueOf(bool) });
      int i = this.uXg;
      this.uXg = paramInt;
      if (j.Jh(this.uXg)) {
        dgf();
      }
      for (;;)
      {
        if ((this.uXw != null) && (i != this.uXg)) {
          this.uXw.gn(i, this.uXg);
        }
        AppMethodBeat.o(114523);
        return bool;
        dgg();
      }
    }
    AppMethodBeat.o(114523);
    return false;
  }
  
  final void a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(114503);
    ac.m("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      dgd();
      this.uXe = false;
      dfX();
      aQW();
      Intent localIntent = new Intent();
      RemoteViews localRemoteViews = null;
      String str = "";
      if (!paramBoolean.booleanValue())
      {
        if ((com.tencent.mm.compatible.util.d.lb(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
          i = 1;
        }
        if (i != 0) {
          this.uXF = new a(paramMultiTalkGroup, Boolean.FALSE);
        }
        paramBoolean = com.tencent.mm.sdk.platformtools.ai.getResources().getString(2131761415);
        localIntent.putExtra("Voip_User", j.k(paramMultiTalkGroup));
        paramMultiTalkGroup = v.wk(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localIntent.getStringExtra("Voip_User")).field_username);
        localRemoteViews = new RemoteViews(com.tencent.mm.sdk.platformtools.ai.getPackageName(), 2131495877);
        localRemoteViews.setTextViewText(2131302963, paramBoolean);
        localRemoteViews.setTextViewText(2131302962, paramMultiTalkGroup);
        localRemoteViews.setImageViewResource(2131306948, 2131234752);
        localRemoteViews.setImageViewResource(2131302957, 2131234488);
        str = paramMultiTalkGroup + paramBoolean;
      }
      com.tencent.mm.util.a.a(com.tencent.mm.sdk.platformtools.ai.getContext(), "multitalk", ".ui.MultiTalkMainUI", localIntent, localRemoteViews, str, com.tencent.mm.bq.a.eJQ());
    }
    AppMethodBeat.o(114503);
  }
  
  public final boolean amy(String paramString)
  {
    AppMethodBeat.i(114524);
    if (dfU())
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      boolean bool = p.dgw().uWU.amy(paramString);
      ac.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(114524);
      return bool;
    }
    AppMethodBeat.o(114524);
    return false;
  }
  
  public final void b(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114502);
    boolean bool2 = this.ftN;
    boolean bool3 = this.kER;
    boolean bool4 = this.uXh;
    Object localObject = this.uXj.toString();
    if (this.uXk == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      e.dfH();
      if ((com.tencent.mm.m.f.Zh()) || (cK(com.tencent.mm.sdk.platformtools.ai.getContext()))) {
        break;
      }
      ac.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.uXA == null) && (this.uXE.eVs()))
      {
        this.uXA = paramMultiTalkGroup;
        this.uXE.au(2000L, 2000L);
        this.uXB = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(114502);
      return;
    }
    localObject = j.k(paramMultiTalkGroup);
    com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject);
    if (com.tencent.mm.m.g.ZY().getInt("MultitalkBlockReceiver", 0) == 0) {}
    for (int i = 1; (i == 0) || (localai == null) || (localai.aaH()); i = 0)
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114481);
          String str2 = paramMultiTalkGroup.JPR;
          String str1 = str2;
          if (bs.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.JPS;
          }
          p.dgw().uWU.amp(str1);
          AppMethodBeat.o(114481);
        }
      }, 1000L);
      e.bs(3, j.j(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if ((!dfo()) && (!com.tencent.mm.plugin.voip.b.l.isVoipStarted()) && (!com.tencent.mm.plugin.voip.b.l.emj()) && (!com.tencent.mm.bh.e.aIZ())) {
      if (((TelephonyManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("phone")).getCallState() == 0) {
        break label455;
      }
    }
    label455:
    for (i = 1; (i != 0) || (com.tencent.mm.plugin.voip.b.l.emk()) || (!com.tencent.mm.n.b.ln(localai.field_type)); i = 0)
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
      if (!q.vR(paramMultiTalkGroup.JPT))
      {
        ac.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.JPT });
        ar.a.hnw.a(paramMultiTalkGroup.JPT, "", new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
        });
      }
      com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114482);
          String str2 = paramMultiTalkGroup.JPR;
          String str1 = str2;
          if (bs.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.JPS;
          }
          p.dgw().uWU.amp(str1);
          AppMethodBeat.o(114482);
        }
      }, 1000L);
      e.bs(3, j.j(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if (!q.vR(paramMultiTalkGroup.JPT))
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.JPT });
      ar.a.hnw.a(paramMultiTalkGroup.JPT, "", null);
    }
    ac.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.i.vbk);
    e.bs(1, j.j(paramMultiTalkGroup));
    if ((!com.tencent.mm.n.b.ln(localai.field_type)) || (com.tencent.mm.r.a.aba()))
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { localObject, u.axw() });
      if (a(paramMultiTalkGroup))
      {
        this.uXe = false;
        dfX();
        aQW();
        AppMethodBeat.o(114502);
      }
    }
    else
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { localObject, u.axw() });
      localObject = new lt();
      ((lt)localObject).dnK.action = 3;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      a(paramMultiTalkGroup, Boolean.FALSE);
    }
    AppMethodBeat.o(114502);
  }
  
  public final boolean bVB()
  {
    AppMethodBeat.i(200689);
    if (this.uXD != null)
    {
      boolean bool = this.uXD.gDU.Na();
      AppMethodBeat.o(200689);
      return bool;
    }
    AppMethodBeat.o(200689);
    return true;
  }
  
  public final void c(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114496);
    boolean bool2 = this.ftN;
    boolean bool3 = this.kER;
    boolean bool4 = this.uXh;
    Object localObject = this.uXj.toString();
    if (this.uXk == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      e.dfG();
      if (!dgh()) {
        break;
      }
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760333, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.l.emj())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760337, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.l.isVoipStarted())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760336, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.bh.e.aIZ())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760332, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.l.emk())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760335, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (dfo())
    {
      com.tencent.mm.bh.e.a(paramActivity, 2131761410, null);
      AppMethodBeat.o(114496);
      return;
    }
    if ((this.uXt) && (System.currentTimeMillis() - this.uXu < this.uXv))
    {
      com.tencent.mm.bh.e.a(paramActivity, 2131761433, null);
      AppMethodBeat.o(114496);
      return;
    }
    this.uXt = false;
    paramActivity = bs.S(paramString1.split(","));
    paramString1 = new MultiTalkGroup();
    paramString1.JPS = p.dgw().uWU.fBZ();
    paramString1.JPT = paramString2;
    localObject = paramActivity.iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
      localMultiTalkGroupMember.JPW = str;
      if (str.equals(u.axw())) {}
      for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
      {
        paramString1.JPV.add(localMultiTalkGroupMember);
        break;
      }
    }
    p.dgw().uWU.cO(bs.m((Integer)com.tencent.mm.kernel.g.agR().ghx.get(1)), u.axw());
    if (p.dgw().uWU.a(paramString1.JPS, paramString2, paramActivity, v2protocal.ekN())) {
      e.dfB();
    }
    for (;;)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.vbl);
      a(paramString1, Boolean.TRUE);
      AppMethodBeat.o(114496);
      return;
      e.dfC();
    }
  }
  
  public final void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114505);
    e.bs(2, j.j(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i.vbk, true);
    AppMethodBeat.o(114505);
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114506);
    ac.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
    e.ou(true);
    if (a(paramMultiTalkGroup)) {
      dfY();
    }
    AppMethodBeat.o(114506);
  }
  
  public final void d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114498);
    if (!q.vR(paramString1))
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      ar.a.hnw.a(paramString1, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    bo localbo = new bo();
    localbo.setType(64);
    localbo.oA(System.currentTimeMillis());
    localbo.setStatus(6);
    localbo.jT(2);
    String str = v.wk(paramString2);
    Object localObject = paramString2;
    if (str != null) {
      if (!str.equals("")) {
        break label398;
      }
    }
    label398:
    for (localObject = paramString2;; localObject = str)
    {
      paramString2 = (String)localObject + com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761446);
      localbo.setContent(paramString2);
      if (q.vT(paramString1))
      {
        localbo.re(paramString1);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(paramString1);
        if (localObject != null)
        {
          if (paramBoolean1) {
            ((com.tencent.mm.storage.ap)localObject).jR(((az)localObject).field_unReadCount + 1);
          }
          ((com.tencent.mm.storage.ap)localObject).setContent(paramString2);
          if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a((com.tencent.mm.storage.ap)localObject, paramString1) == -1) {
            ac.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
          }
          if (paramBoolean2)
          {
            ((at)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbo);
            AppMethodBeat.o(114498);
          }
        }
        else
        {
          localObject = new com.tencent.mm.storage.ap();
          ((com.tencent.mm.storage.ap)localObject).setUsername(paramString1);
          if (paramBoolean1) {
            ((com.tencent.mm.storage.ap)localObject).jR(1);
          }
          ((com.tencent.mm.storage.ap)localObject).setContent(paramString2);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().e((com.tencent.mm.storage.ap)localObject);
          if (paramBoolean2) {
            ((at)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbo);
          }
        }
      }
      AppMethodBeat.o(114498);
      return;
    }
  }
  
  public final MultiTalkGroup dfS()
  {
    return this.uXk;
  }
  
  public final boolean dfT()
  {
    return this.kER;
  }
  
  public final boolean dfU()
  {
    AppMethodBeat.i(114490);
    if ((this.uXj == com.tencent.mm.plugin.multitalk.ui.widget.i.vbm) || (this.uXj == com.tencent.mm.plugin.multitalk.ui.widget.i.vbn)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114490);
      return bool;
    }
  }
  
  public final void dfW()
  {
    AppMethodBeat.i(162239);
    this.uXF = null;
    this.uXs = false;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162239);
  }
  
  public final void dfZ()
  {
    AppMethodBeat.i(114510);
    ac.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(114510);
  }
  
  public final boolean dfn()
  {
    AppMethodBeat.i(114491);
    if (this.uXj == com.tencent.mm.plugin.multitalk.ui.widget.i.vbn) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114491);
      return bool;
    }
  }
  
  public final boolean dfo()
  {
    AppMethodBeat.i(114489);
    if ((this.uXj != com.tencent.mm.plugin.multitalk.ui.widget.i.vbj) && (this.uXk != null)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114489);
      return bool;
    }
  }
  
  public final void dga()
  {
    AppMethodBeat.i(114513);
    ac.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.uXg) });
    AppMethodBeat.o(114513);
  }
  
  public final void dgb()
  {
    AppMethodBeat.i(114514);
    ac.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(114514);
  }
  
  public final void dgc()
  {
    AppMethodBeat.i(178889);
    ac.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
    AppMethodBeat.o(178889);
  }
  
  public final void dgd()
  {
    AppMethodBeat.i(200688);
    this.uXD = new com.tencent.mm.plugin.multitalk.a.a();
    if (this.kER) {
      this.uXD.cm(true);
    }
    com.tencent.mm.plugin.multitalk.a.a.dfi();
    AppMethodBeat.o(200688);
  }
  
  public final void dgf()
  {
    AppMethodBeat.i(114520);
    ac.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (this.uXw == null)
    {
      ac.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.uXi.size() == 0)
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.uXl == null)
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[] { Integer.valueOf(this.uXi.size()) });
      this.uXl = new l(this.uXw);
      this.uXl.Ji(this.uXi.size());
    }
    if (!this.uXl.running) {
      this.uXl.start();
    }
    AppMethodBeat.o(114520);
  }
  
  public final void dgg()
  {
    AppMethodBeat.i(114521);
    ac.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
    if (this.uXl != null)
    {
      this.uXl.stop();
      this.uXl = null;
    }
    AppMethodBeat.o(114521);
  }
  
  public final boolean dgj()
  {
    return this.uXf;
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114507);
    ac.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
    qb localqb = new qb();
    localqb.dtg.type = 1;
    com.tencent.mm.sdk.b.a.GpY.l(localqb);
    e.ov(true);
    if (this.uXj != com.tencent.mm.plugin.multitalk.ui.widget.i.vbk)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.vbm);
      a(paramMultiTalkGroup, Boolean.TRUE);
    }
    if ((dfo()) && (a(paramMultiTalkGroup))) {
      dfY();
    }
    AppMethodBeat.o(114507);
  }
  
  public final void em(List<a.ap> paramList)
  {
    AppMethodBeat.i(114516);
    if (dfo())
    {
      this.uXi.clear();
      ac.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a.ap localap = (a.ap)paramList.next();
        if ((localap.JOf == 2) || (localap.JOf == 3)) {
          this.uXi.add(localap.dhV);
        }
      }
      this.uXi.remove(u.axw());
      ac.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.uXi });
      if (this.uXl != null) {
        this.uXl.Ji(this.uXi.size());
      }
      if (this.uXw != null) {
        this.uXw.dfr();
      }
    }
    AppMethodBeat.o(114516);
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114509);
    ac.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { j.g(paramMultiTalkGroup) });
    int i;
    if ((dfo()) && (a(paramMultiTalkGroup)))
    {
      Iterator localIterator = this.uXk.JPV.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
        if ((localMultiTalkGroupMember.status != 10) && (localMultiTalkGroupMember.status != 1)) {
          break label241;
        }
        i += 1;
      }
    }
    label241:
    for (;;)
    {
      break;
      if (i > 1) {
        i = 1;
      }
      while (i == 0) {
        if (this.uXj == com.tencent.mm.plugin.multitalk.ui.widget.i.vbk)
        {
          h(false, true, false);
          AppMethodBeat.o(114509);
          return;
          i = 0;
        }
        else
        {
          h(false, false, false);
          AppMethodBeat.o(114509);
          return;
        }
      }
      if ((this.uXj != com.tencent.mm.plugin.multitalk.ui.widget.i.vbn) && (j.h(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.i.vbn);
      }
      if (this.uXw != null)
      {
        paramMultiTalkGroup = this.uXj;
        if ((paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.vbm) && (paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.vbn))
        {
          i = j;
          if (paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.vbk) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          this.uXw.dfq();
        }
      }
      AppMethodBeat.o(114509);
      return;
    }
  }
  
  public final long getTotalTime()
  {
    AppMethodBeat.i(114492);
    long l1 = System.currentTimeMillis();
    long l2 = this.uXo;
    AppMethodBeat.o(114492);
    return l1 - l2;
  }
  
  public final void h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(114497);
    ac.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    p.dgx().stopRing();
    Object localObject;
    String str;
    boolean bool;
    long l;
    int i;
    if (dfo())
    {
      localObject = new qb();
      ((qb)localObject).dtg.type = 2;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = this.uXk;
      str = j.j((MultiTalkGroup)localObject);
      e.hO(((MultiTalkGroup)localObject).JPT, str);
      e.amw(str);
      if (this.uXj != com.tencent.mm.plugin.multitalk.ui.widget.i.vbn)
      {
        bool = j.i(this.uXk);
        l = getTotalTime();
        if (bool) {
          if (paramBoolean2) {
            i = 4;
          }
        }
      }
    }
    for (;;)
    {
      e.a(bool, l, str, i);
      label182:
      localObject = this.uXj;
      if (this.uXw != null) {
        this.uXw.dfp();
      }
      this.uXm = false;
      this.uXn = false;
      this.uXj = com.tencent.mm.plugin.multitalk.ui.widget.i.vbj;
      dgg();
      nf(true);
      bsZ();
      if (this.uXD != null) {
        this.uXD.dfk();
      }
      p.dgv().reset();
      p.dgy().dgq();
      if (this.uXk != null)
      {
        a(this.uXk, (com.tencent.mm.plugin.multitalk.ui.widget.i)localObject, paramBoolean2);
        str = this.uXk.JPR;
        localObject = str;
        if (bs.isNullOrNil(str)) {
          localObject = this.uXk.JPS;
        }
        p.dgw().uWU.amp((String)localObject);
        this.uXk = null;
      }
      this.uXg = 0;
      this.kER = true;
      this.ftN = false;
      this.uXh = true;
      this.uXo = 0L;
      this.uXp = 0;
      this.uXi.clear();
      localObject = new fg();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      this.uXs = true;
      for (;;)
      {
        dge();
        AppMethodBeat.o(114497);
        return;
        if (paramBoolean1)
        {
          i = 1;
          break;
        }
        if (paramBoolean3)
        {
          i = 5;
          break;
        }
        i = 2;
        break;
        if (paramBoolean2)
        {
          if (l >= 45L)
          {
            i = 6;
            break;
          }
          i = 8;
          break;
        }
        if (paramBoolean1)
        {
          i = 7;
          break;
        }
        if (!paramBoolean3) {
          break label575;
        }
        i = 10;
        break;
        e.Jd(this.uXp);
        e.t(this.uXp, str);
        if (((MultiTalkGroup)localObject).JPV == null) {
          break label182;
        }
        e.Ja(((MultiTalkGroup)localObject).JPV.size());
        break label182;
        if (!this.uXs)
        {
          dgg();
          nf(false);
          bsZ();
          this.uXk = null;
          this.uXg = 0;
          this.uXo = 0L;
          this.uXp = 0;
          this.uXi.clear();
          this.uXj = com.tencent.mm.plugin.multitalk.ui.widget.i.vbj;
          this.uXq = 0;
        }
      }
      label575:
      i = 0;
    }
  }
  
  public final void n(int paramInt, Object paramObject)
  {
    int j = 2131761391;
    AppMethodBeat.i(114501);
    ac.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQR, Integer.valueOf(-1));
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQS, Long.valueOf(-1L));
    int i;
    switch (paramInt)
    {
    default: 
      i = 2131761406;
    }
    for (;;)
    {
      if (this.uXw != null) {
        this.uXw.onError(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(i), 0).show();
        h(false, false, true);
      }
      AppMethodBeat.o(114501);
      return;
      e.ou(false);
      i = 2131761394;
      continue;
      e.ov(false);
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
      this.uXt = true;
      this.uXu = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.aa)paramObject;
        i = j;
        if (paramObject != null)
        {
          ac.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.JNM);
          i = j;
          if (paramObject.JNM != 0)
          {
            this.uXv = (paramObject.JNM * 1000);
            i = j;
            continue;
            ac.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = 2131761400;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.ab)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.fHP().yP(false);
                i = j;
                continue;
                i = 2131761399;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.uXk;
                if (this.uXk != null) {}
                for (String str = this.uXk.JPT;; str = "")
                {
                  ac.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.ab)paramObject;
                    if (paramObject != null)
                    {
                      ac.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.JMo != null)
                      {
                        p.dgz().amr(paramObject.JMo.JOI);
                        ac.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.JMo.JOI);
                      }
                      if (!p.dgw().uWU.amp(paramObject.groupId)) {
                        ac.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = 2131761444;
                  break;
                }
                ac.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761391), 0).show();
                i = j;
                if (paramObject != null)
                {
                  int k = ((Integer)paramObject).intValue();
                  i = j;
                  if (k > 0)
                  {
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQR, Integer.valueOf(k));
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQS, Long.valueOf(bs.Gn()));
                    i = j;
                    continue;
                    ac.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                    i = 2131761430;
                    continue;
                    ac.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
                    AppMethodBeat.o(114501);
                    return;
                    ac.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
                    i = 2131761401;
                    continue;
                    ac.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
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
  
  public final void nf(boolean paramBoolean)
  {
    AppMethodBeat.i(178890);
    this.tHm = false;
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.ehc().elp();
    }
    for (;;)
    {
      ((NotificationManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("notification")).cancel(43);
      dge();
      AppMethodBeat.o(178890);
      return;
      com.tencent.mm.plugin.voip.c.ehc().qD(false);
    }
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(114511);
    this.ftN = paramBoolean;
    if (this.uXw != null) {
      this.uXw.om(this.ftN);
    }
    AppMethodBeat.o(114511);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(114532);
    if ((p.dgx().dfU()) && (this.uXw != null))
    {
      ac.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.uXw.oo(paramBoolean);
    }
    AppMethodBeat.o(114532);
  }
  
  public final void ow(boolean paramBoolean)
  {
    AppMethodBeat.i(114517);
    if (dfo())
    {
      if (this.tHm)
      {
        AppMethodBeat.o(114517);
        return;
      }
      this.tHm = true;
      e.g(j.dgm(), j.Jg(p.dgx().uXg), paramBoolean);
      Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131761425, 0).show();
      Object localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761388);
      String str = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761434);
      Object localObject2 = new Intent();
      ((Intent)localObject2).setClass(com.tencent.mm.sdk.platformtools.ai.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(com.tencent.mm.sdk.platformtools.ai.getContext(), 43, (Intent)localObject2, 134217728);
      int i = 2131233502;
      if (com.tencent.mm.compatible.util.d.la(19)) {
        i = 2131233500;
      }
      localObject1 = com.tencent.mm.bq.a.bE(com.tencent.mm.sdk.platformtools.ai.getContext(), "reminder_channel_id").i(str).i(System.currentTimeMillis()).f((CharSequence)localObject1).g(str);
      ((s.c)localObject1).Fu = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.b.l.e((s.c)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
      if (this.uXw != null) {
        this.uXw.cUc();
      }
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114485);
          Intent localIntent = new Intent();
          localIntent.setFlags(268435456);
          if (f.f(f.this) != null) {}
          for (String str = f.f(f.this).JPT;; str = "")
          {
            localIntent.putExtra("enterMainUiWxGroupId", str);
            localIntent.setClass(com.tencent.mm.sdk.platformtools.ai.getContext(), MultiTalkMainUI.class);
            localIntent.putExtra("notification", this.uXM);
            localIntent.putExtra("enterMainUiSource", 1);
            com.tencent.mm.plugin.voip.c.ehc().a(localIntent, false, true, new com.tencent.mm.plugin.voip.ui.a()
            {
              public final void a(Intent paramAnonymous2Intent, BaseSmallView paramAnonymous2BaseSmallView)
              {
                AppMethodBeat.i(178888);
                if (!f.this.dfn())
                {
                  paramAnonymous2BaseSmallView.ayC(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761459));
                  AppMethodBeat.o(178888);
                  return;
                }
                int i = f.this.uXp;
                paramAnonymous2BaseSmallView.ayB(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
                AppMethodBeat.o(178888);
              }
              
              public final boolean cTY()
              {
                AppMethodBeat.i(114483);
                if ((f.this.dfU()) || (f.this.dfn()))
                {
                  AppMethodBeat.o(114483);
                  return true;
                }
                AppMethodBeat.o(114483);
                return false;
              }
            });
            f.g(f.this);
            AppMethodBeat.o(114485);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(114517);
  }
  
  public final void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(114512);
    ac.m("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    p.dgw().uWU.ox(paramBoolean);
    ac.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kER = paramBoolean;
    if (this.uXw != null) {
      this.uXw.on(this.kER);
    }
    AppMethodBeat.o(114512);
  }
  
  public final void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(114528);
    if (this.uXe)
    {
      AppMethodBeat.o(114528);
      return;
    }
    if (this.uXD != null)
    {
      this.uXD.K(paramBoolean, 0);
      this.uXe = true;
    }
    AppMethodBeat.o(114528);
  }
  
  public final void oz(boolean paramBoolean)
  {
    AppMethodBeat.i(114533);
    ac.m("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uXf = paramBoolean;
    AppMethodBeat.o(114533);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(114529);
    if ((this.uXe) && (this.uXD != null))
    {
      this.uXD.dfj();
      this.uXe = false;
    }
    AppMethodBeat.o(114529);
  }
  
  final class a
  {
    MultiTalkGroup uXO;
    Boolean uXP;
    
    a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
    {
      this.uXO = paramMultiTalkGroup;
      this.uXP = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f
 * JD-Core Version:    0.7.0.1
 */