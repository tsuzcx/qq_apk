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
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
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

public final class o
  implements ServiceConnection, com.tencent.pb.talkroom.sdk.a
{
  private Timer cNY;
  public boolean fMP;
  com.tencent.mm.sdk.b.c had;
  public boolean lbb;
  private boolean uJZ;
  public int wbA;
  private int wbB;
  private int wbC;
  private boolean wbD;
  private boolean wbE;
  private long wbF;
  private long wbG;
  public e wbH;
  private t.a wbI;
  public boolean wbJ;
  MultiTalkGroup wbK;
  long wbL;
  private boolean wbM;
  public com.tencent.mm.plugin.multitalk.a.a wbN;
  private r wbO;
  private ad wbP;
  private ab wbQ;
  private a wbR;
  av wbS;
  a wbT;
  public boolean wbU;
  private ap wbV;
  BroadcastReceiver wbW;
  private boolean wbp;
  private boolean wbq;
  public int wbr;
  public boolean wbs;
  public HashSet<String> wbt;
  public com.tencent.mm.plugin.multitalk.ui.widget.i wbu;
  public MultiTalkGroup wbv;
  public w wbw;
  public boolean wbx;
  public boolean wby;
  private long wbz;
  
  public o()
  {
    AppMethodBeat.i(114486);
    this.wbs = true;
    this.wbt = new HashSet();
    this.wbu = com.tencent.mm.plugin.multitalk.ui.widget.i.wgs;
    this.wbv = null;
    this.wbx = false;
    this.wby = false;
    this.wbz = 0L;
    this.wbA = 0;
    this.wbB = 0;
    this.wbC = 2;
    this.wbD = false;
    this.wbE = false;
    this.wbF = 0L;
    this.wbG = 30000L;
    this.wbK = null;
    this.wbL = 0L;
    this.wbM = false;
    this.wbS = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114480);
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (o.a(o.this) == null)
        {
          o.b(o.this);
          o.c(o.this).stopTimer();
          AppMethodBeat.o(114480);
          return false;
        }
        if (o.fS(aj.getContext()))
        {
          o.this.b(o.a(o.this));
          o.d(o.this);
          o.b(o.this);
          o.c(o.this).stopTimer();
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 7L, 1L, false);
          AppMethodBeat.o(114480);
          return false;
        }
        if (System.currentTimeMillis() - o.e(o.this) < 60000L)
        {
          AppMethodBeat.o(114480);
          return true;
        }
        o.d(o.this);
        o.b(o.this);
        o.c(o.this).stopTimer();
        AppMethodBeat.o(114480);
        return false;
      }
    }, true);
    this.wbU = false;
    this.wbV = new ap(Looper.getMainLooper());
    this.wbW = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114473);
        if (!o.this.dpa())
        {
          AppMethodBeat.o(114473);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          o.h(o.this).removeCallbacksAndMessages(null);
          o.h(o.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114470);
              t.a locala1 = t.dqn();
              if (locala1 != o.i(o.this))
              {
                t.a locala2 = o.i(o.this);
                o.a(o.this, locala1);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), o.i(o.this).name() });
                o.this.KE(o.j(o.this));
                if (o.k(o.this) != null) {
                  o.k(o.this).a(o.i(o.this));
                }
                AppMethodBeat.o(114470);
                return;
              }
              o.this.KE(o.j(o.this));
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { o.i(o.this).name() });
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[] { Integer.valueOf(i) });
          if (i != 0) {
            break;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114471);
              z.dqw().wbf.zo(false);
              if (o.this.wbN != null) {
                o.this.wbN.Ob();
              }
              if (!com.tencent.mm.plugin.audio.c.a.bGD()) {
                o.this.oU(z.dqx().lbb);
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
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114472);
            z.dqw().wbf.zo(true);
            AppMethodBeat.o(114472);
          }
        });
        AppMethodBeat.o(114473);
      }
    };
    this.had = new o.4(this);
    com.tencent.mm.sdk.b.a.IbL.c(this.had);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
    localIntentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    aj.getContext().registerReceiver(this.wbW, localIntentFilter);
    this.wbJ = false;
    AppMethodBeat.o(114486);
  }
  
  public static boolean KF(int paramInt)
  {
    AppMethodBeat.i(206575);
    boolean bool = z.dqw().wbf.KE(paramInt);
    AppMethodBeat.o(206575);
    return bool;
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(114500);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((parami == com.tencent.mm.plugin.multitalk.ui.widget.i.wgt) && (paramBoolean))
    {
      parami = new bu();
      parami.setType(64);
      parami.qA(System.currentTimeMillis());
      parami.setStatus(6);
      parami.setContent(aj.getContext().getString(2131761448));
      if (com.tencent.mm.model.q.yK(paramMultiTalkGroup.LJE))
      {
        parami.tN(paramMultiTalkGroup.LJE);
        parami.setContent(parami.field_content);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as(parami);
      }
    }
    AppMethodBeat.o(114500);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114493);
    if (!dpa())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { t.g(paramMultiTalkGroup) });
      this.wbv = paramMultiTalkGroup;
      this.wbA = 0;
      this.wbr = 1;
      this.wbt.clear();
      dpN();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    Object localObject1 = this.wbv;
    int i;
    if ((paramMultiTalkGroup == null) || (localObject1 == null)) {
      i = 0;
    }
    while (i != 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { t.g(paramMultiTalkGroup) });
      Object localObject2 = this.wbv;
      localObject1 = new HashMap();
      Object localObject3 = paramMultiTalkGroup.LJG.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject3).next();
          ((HashMap)localObject1).put(localMultiTalkGroupMember.LJH, localMultiTalkGroupMember);
          continue;
          if ((!bt.isNullOrNil(paramMultiTalkGroup.LJC)) && (!bt.isNullOrNil(((MultiTalkGroup)localObject1).LJC)) && (paramMultiTalkGroup.LJC.equals(((MultiTalkGroup)localObject1).LJC)))
          {
            i = 1;
            break;
          }
          if ((!bt.isNullOrNil(paramMultiTalkGroup.LJD)) && (!bt.isNullOrNil(((MultiTalkGroup)localObject1).LJD)) && (paramMultiTalkGroup.LJD.equals(((MultiTalkGroup)localObject1).LJD)))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      localObject2 = ((MultiTalkGroup)localObject2).LJG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiTalkGroupMember)((Iterator)localObject2).next();
        if ((!u.aAm().equals(((MultiTalkGroupMember)localObject3).LJH)) && (u.aAm().equals(((MultiTalkGroupMember)localObject3).LJI)) && (((MultiTalkGroupMember)localObject3).status == 1) && ((!((HashMap)localObject1).containsKey(((MultiTalkGroupMember)localObject3).LJH)) || (((MultiTalkGroupMember)((HashMap)localObject1).get(((MultiTalkGroupMember)localObject3).LJH)).status == 20)))
        {
          localObject3 = ((MultiTalkGroupMember)localObject3).LJH;
          localObject3 = aj.getContext().getString(2131761442, new Object[] { v.zf((String)localObject3) });
          localObject3 = k.c(aj.getContext(), (CharSequence)localObject3);
          Toast.makeText(aj.getContext(), (CharSequence)localObject3, 0).show();
        }
      }
      this.wbv = paramMultiTalkGroup;
      dpN();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { t.g(this.wbv), t.g(paramMultiTalkGroup) });
    AppMethodBeat.o(114493);
    return false;
  }
  
  private void aUi()
  {
    AppMethodBeat.i(114526);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.cNY != null)
    {
      this.cNY.cancel();
      AppMethodBeat.o(114526);
      return;
    }
    this.wbz = System.currentTimeMillis();
    this.wbA = 0;
    this.cNY = new Timer();
    TimerTask local3 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(114476);
        if ((o.this.getTotalTime() >= 45000L) && (o.l(o.this) != com.tencent.mm.plugin.multitalk.ui.widget.i.wgw)) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114474);
              o.this.h(false, true, false);
              AppMethodBeat.o(114474);
            }
          });
        }
        if (o.l(o.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.wgw)
        {
          o.m(o.this);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114475);
              if (o.l(o.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.wgw)
              {
                com.tencent.mm.plugin.voip.c.euN().tt(o.this.wbA);
                if (o.k(o.this) != null) {
                  o.k(o.this).ddo();
                }
              }
              AppMethodBeat.o(114475);
            }
          });
        }
        AppMethodBeat.o(114476);
      }
    };
    this.cNY.schedule(local3, 1000L, 1000L);
    AppMethodBeat.o(114526);
  }
  
  public static void art(String paramString)
  {
    AppMethodBeat.i(114499);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    bu localbu = new bu();
    localbu.setType(64);
    localbu.qA(System.currentTimeMillis());
    localbu.setStatus(6);
    localbu.setContent(aj.getContext().getString(2131761448));
    if (com.tencent.mm.model.q.yK(paramString))
    {
      localbu.tN(paramString);
      localbu.setContent(localbu.field_content);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as(localbu);
    }
    AppMethodBeat.o(114499);
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.i parami)
  {
    boolean bool = true;
    AppMethodBeat.i(114525);
    Object localObject = this.wbu;
    this.wbu = parami;
    if (localObject != parami) {
      if (parami == com.tencent.mm.plugin.multitalk.ui.widget.i.wgw)
      {
        localObject = new qm();
        ((qm)localObject).dFi.type = 1;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        n.a(t.i(this.wbv), getTotalTime(), t.j(this.wbv));
        z.dqx().stopRing();
        com.tencent.mm.plugin.audio.c.a.setMode(3);
        if ((com.tencent.mm.plugin.audio.c.a.bGx()) || (com.tencent.mm.plugin.audio.c.a.bGD())) {
          break label133;
        }
      }
    }
    for (;;)
    {
      oU(bool);
      z.dqw().oK(bool);
      if (this.wbH != null) {
        this.wbH.a(parami);
      }
      AppMethodBeat.o(114525);
      return;
      label133:
      bool = false;
    }
  }
  
  private void bxe()
  {
    AppMethodBeat.i(114527);
    if (this.cNY != null)
    {
      this.cNY.cancel();
      this.cNY = null;
    }
    AppMethodBeat.o(114527);
  }
  
  private static boolean cH(Context paramContext)
  {
    AppMethodBeat.i(114531);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
        AppMethodBeat.o(114531);
        return false;
      }
    }
    if (((KeyguardManager)aj.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(114531);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
    AppMethodBeat.o(114531);
    return true;
  }
  
  private void dpN()
  {
    AppMethodBeat.i(114495);
    Iterator localIterator = this.wbv.LJG.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.wbt.remove(localMultiTalkGroupMember.LJH))) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.LJH });
      }
    }
    AppMethodBeat.o(114495);
  }
  
  private h dpO()
  {
    AppMethodBeat.i(206565);
    if (this.wbO == null) {
      this.wbO = new r();
    }
    r localr = this.wbO;
    AppMethodBeat.o(206565);
    return localr;
  }
  
  private void dpR()
  {
    AppMethodBeat.i(206568);
    if (this.wbP == null)
    {
      AppMethodBeat.o(206568);
      return;
    }
    this.wbP.close();
    this.wbP = null;
    AppMethodBeat.o(206568);
  }
  
  private void dpV()
  {
    AppMethodBeat.i(114504);
    if (this.wbu == com.tencent.mm.plugin.multitalk.ui.widget.i.wgu) {}
    for (;;)
    {
      boolean bool = false;
      for (o localo = this;; localo = this)
      {
        localo.lbb = bool;
        this.fMP = false;
        this.wbI = t.dqn();
        AppMethodBeat.o(114504);
        return;
        if ((com.tencent.mm.plugin.audio.c.a.bGx()) || (com.tencent.mm.plugin.audio.c.a.bGD())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void dpW()
  {
    AppMethodBeat.i(114508);
    if (t.h(this.wbv)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wgw);
    }
    while (this.wbH != null)
    {
      this.wbH.dlr();
      localObject = t.dqn();
      if (localObject != this.wbI) {
        this.wbI = ((t.a)localObject);
      }
      AppMethodBeat.o(114508);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wgv);
    }
    Object localObject = new Intent();
    com.tencent.mm.bs.d.b(aj.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(114508);
  }
  
  private void dqc()
  {
    AppMethodBeat.i(114519);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.ly(26)) && (this.wbM))
      {
        aj.getContext().unbindService(this);
        this.wbM = false;
      }
      AppMethodBeat.o(114519);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.MT.MultiTalkManager", localException, "unBind VoipSmallService error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(114519);
    }
  }
  
  private static boolean dqg()
  {
    AppMethodBeat.i(114530);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)aj.getContext().getSystemService("phone");
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
  
  public static void dqh()
  {
    AppMethodBeat.i(178891);
    com.tencent.mm.plugin.voip.c.euN().dqh();
    AppMethodBeat.o(178891);
  }
  
  private void oS(boolean paramBoolean)
  {
    AppMethodBeat.i(206570);
    if (this.wbQ == null)
    {
      AppMethodBeat.o(206570);
      return;
    }
    this.wbQ.ab(paramBoolean);
    if (!paramBoolean) {
      this.wbQ = null;
    }
    AppMethodBeat.o(206570);
  }
  
  private void sort()
  {
    AppMethodBeat.i(114494);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.wbv.LJG });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.wbv.LJG.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.LJH.equals(u.aAm())) {
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
    this.wbv.LJG = localLinkedList;
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.wbv.LJG });
    AppMethodBeat.o(114494);
  }
  
  public final void KD(int paramInt)
  {
    AppMethodBeat.i(114515);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.wbJ = true;
      AppMethodBeat.o(114515);
      return;
    }
    this.wbJ = false;
    AppMethodBeat.o(114515);
  }
  
  public final boolean KE(int paramInt)
  {
    AppMethodBeat.i(114523);
    if (dpM())
    {
      this.wbU = false;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "try switch to action : ".concat(String.valueOf(paramInt)));
      boolean bool = z.dqw().wbf.KE(paramInt);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[] { Boolean.valueOf(bool) });
      int i = this.wbr;
      this.wbr = paramInt;
      if (t.KI(this.wbr)) {
        dqd();
      }
      for (;;)
      {
        if ((this.wbH != null) && (i != this.wbr)) {
          this.wbH.gE(i, this.wbr);
        }
        AppMethodBeat.o(114523);
        return bool;
        dqe();
      }
    }
    AppMethodBeat.o(114523);
    return false;
  }
  
  public final void Ky(int paramInt)
  {
    AppMethodBeat.i(206572);
    h localh = dpO();
    if (localh != null) {
      localh.Ky(paramInt);
    }
    AppMethodBeat.o(206572);
  }
  
  final void a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(114503);
    com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      dqb();
      this.wbp = false;
      dpV();
      aUi();
      Intent localIntent = new Intent();
      RemoteViews localRemoteViews = null;
      String str = "";
      if (!paramBoolean.booleanValue())
      {
        if ((com.tencent.mm.compatible.util.d.lA(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
          i = 1;
        }
        if (i != 0) {
          this.wbT = new a(paramMultiTalkGroup, Boolean.FALSE);
        }
        paramBoolean = aj.getResources().getString(2131761415);
        localIntent.putExtra("Voip_User", t.k(paramMultiTalkGroup));
        paramMultiTalkGroup = v.zf(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(localIntent.getStringExtra("Voip_User")).field_username);
        localRemoteViews = new RemoteViews(aj.getPackageName(), 2131495877);
        localRemoteViews.setTextViewText(2131302963, paramBoolean);
        localRemoteViews.setTextViewText(2131302962, paramMultiTalkGroup);
        localRemoteViews.setImageViewResource(2131306948, 2131234752);
        localRemoteViews.setImageViewResource(2131302957, 2131234488);
        str = paramMultiTalkGroup + paramBoolean;
      }
      com.tencent.mm.util.a.a(aj.getContext(), "multitalk", ".ui.MultiTalkMainUI", localIntent, localRemoteViews, str, com.tencent.mm.br.a.eYE());
    }
    AppMethodBeat.o(114503);
  }
  
  public final boolean aru(String paramString)
  {
    AppMethodBeat.i(114524);
    if (dpM())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      boolean bool = z.dqw().wbf.aru(paramString);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(114524);
      return bool;
    }
    AppMethodBeat.o(114524);
    return false;
  }
  
  public final void arv(String paramString)
  {
    AppMethodBeat.i(206576);
    if (this.wbw == null) {
      this.wbw = new w();
    }
    this.wbw.a(dpS());
    if (TextUtils.isEmpty(paramString))
    {
      this.wbw.dqq();
      AppMethodBeat.o(206576);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast ownerUserName : ".concat(String.valueOf(paramString)));
    this.wbw.arB(paramString);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast error");
    AppMethodBeat.o(206576);
  }
  
  public final void b(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114502);
    boolean bool2 = this.fMP;
    boolean bool3 = this.lbb;
    boolean bool4 = this.wbs;
    Object localObject = this.wbu.toString();
    if (this.wbv == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      n.dpy();
      if ((com.tencent.mm.n.f.abH()) || (cH(aj.getContext()))) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.wbK == null) && (this.wbS.fkZ()))
      {
        this.wbK = paramMultiTalkGroup;
        this.wbS.az(2000L, 2000L);
        this.wbL = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(114502);
      return;
    }
    localObject = t.k(paramMultiTalkGroup);
    am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject);
    if (com.tencent.mm.n.g.acA().getInt("MultitalkBlockReceiver", 0) == 0) {}
    for (int i = 1; (i == 0) || (localam == null) || (localam.adk()); i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114481);
          String str2 = paramMultiTalkGroup.LJC;
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.LJD;
          }
          z.dqw().wbf.arl(str1);
          AppMethodBeat.o(114481);
        }
      }, 1000L);
      n.bw(3, t.j(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if ((!dpa()) && (!com.tencent.mm.plugin.voip.b.n.isVoipStarted()) && (!com.tencent.mm.plugin.voip.b.n.eAe()) && (!com.tencent.mm.bi.e.aMj())) {
      if (((TelephonyManager)aj.getContext().getSystemService("phone")).getCallState() == 0) {
        break label460;
      }
    }
    label460:
    for (i = 1; (i != 0) || (com.tencent.mm.plugin.voip.b.n.eAf()) || (!com.tencent.mm.o.b.lM(localam.field_type)); i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
      if (!com.tencent.mm.model.q.yI(paramMultiTalkGroup.LJE))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.LJE });
        as.a.hFO.a(paramMultiTalkGroup.LJE, "", new as.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
        });
      }
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114482);
          String str2 = paramMultiTalkGroup.LJC;
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.LJD;
          }
          z.dqw().wbf.arl(str1);
          AppMethodBeat.o(114482);
        }
      }, 1000L);
      n.bw(3, t.j(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if (!com.tencent.mm.model.q.yI(paramMultiTalkGroup.LJE))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.LJE });
      as.a.hFO.a(paramMultiTalkGroup.LJE, "", null);
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.i.wgt);
    n.bw(1, t.j(paramMultiTalkGroup));
    if ((!com.tencent.mm.o.b.lM(localam.field_type)) || (com.tencent.mm.s.a.adD()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { localObject, u.aAm() });
      if (a(paramMultiTalkGroup))
      {
        this.wbp = false;
        dpV();
        aUi();
        AppMethodBeat.o(114502);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { localObject, u.aAm() });
      localObject = new mc();
      ((mc)localObject).dzy.action = 3;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      a(paramMultiTalkGroup, Boolean.FALSE);
    }
    AppMethodBeat.o(114502);
  }
  
  public final void c(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114496);
    boolean bool2 = this.fMP;
    boolean bool3 = this.lbb;
    boolean bool4 = this.wbs;
    Object localObject = this.wbu.toString();
    if (this.wbv == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      n.dpx();
      if (!dqg()) {
        break;
      }
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760333, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.n.eAe())
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
    if (com.tencent.mm.bi.e.aMj())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760332, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.n.eAf())
    {
      com.tencent.mm.ui.base.h.l(paramActivity, 2131760335, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (dpa())
    {
      com.tencent.mm.bi.e.a(paramActivity, 2131761410, null);
      AppMethodBeat.o(114496);
      return;
    }
    if ((this.wbE) && (System.currentTimeMillis() - this.wbF < this.wbG))
    {
      com.tencent.mm.bi.e.a(paramActivity, 2131761433, null);
      AppMethodBeat.o(114496);
      return;
    }
    this.wbE = false;
    paramActivity = bt.U(paramString1.split(","));
    paramString1 = new MultiTalkGroup();
    paramString1.LJD = z.dqw().wbf.fTo();
    paramString1.LJE = paramString2;
    localObject = paramActivity.iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
      localMultiTalkGroupMember.LJH = str;
      if (str.equals(u.aAm())) {}
      for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
      {
        paramString1.LJG.add(localMultiTalkGroupMember);
        break;
      }
    }
    z.dqw().wbf.cW(bt.n((Integer)com.tencent.mm.kernel.g.ajC().gBh.get(1)), u.aAm());
    if (z.dqw().wbf.a(paramString1.LJD, paramString2, paramActivity, v2protocal.eyy())) {
      n.dps();
    }
    for (;;)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wgu);
      a(paramString1, Boolean.TRUE);
      paramActivity = com.tencent.mm.plugin.multitalk.c.d.whH;
      com.tencent.mm.plugin.multitalk.c.d.reset();
      AppMethodBeat.o(114496);
      return;
      n.dpt();
    }
  }
  
  public final void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114505);
    n.bw(2, t.j(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i.wgt, true);
    AppMethodBeat.o(114505);
  }
  
  public final boolean cae()
  {
    AppMethodBeat.i(206577);
    if (this.wbN != null)
    {
      boolean bool = this.wbN.gXE.OJ();
      AppMethodBeat.o(206577);
      return bool;
    }
    AppMethodBeat.o(206577);
    return true;
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114506);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
    n.oQ(true);
    if (a(paramMultiTalkGroup)) {
      dpW();
    }
    AppMethodBeat.o(114506);
  }
  
  public final void d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114498);
    if (!com.tencent.mm.model.q.yI(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      as.a.hFO.a(paramString1, "", new as.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    bu localbu = new bu();
    localbu.setType(64);
    localbu.qA(System.currentTimeMillis());
    localbu.setStatus(6);
    localbu.kr(2);
    String str = v.zf(paramString2);
    Object localObject = paramString2;
    if (str != null) {
      if (!str.equals("")) {
        break label400;
      }
    }
    label400:
    for (localObject = paramString2;; localObject = str)
    {
      paramString2 = (String)localObject + aj.getContext().getString(2131761446);
      localbu.setContent(paramString2);
      if (com.tencent.mm.model.q.yK(paramString1))
      {
        localbu.tN(paramString1);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as(localbu);
        localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz(paramString1);
        if (localObject != null)
        {
          if (paramBoolean1) {
            ((at)localObject).kp(((ba)localObject).field_unReadCount + 1);
          }
          ((at)localObject).setContent(paramString2);
          if (((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a((at)localObject, paramString1) == -1) {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
          }
          if (paramBoolean2)
          {
            ((au)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbu);
            AppMethodBeat.o(114498);
          }
        }
        else
        {
          localObject = new at();
          ((at)localObject).setUsername(paramString1);
          if (paramBoolean1) {
            ((at)localObject).kp(1);
          }
          ((at)localObject).setContent(paramString2);
          ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().e((at)localObject);
          if (paramBoolean2) {
            ((au)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbu);
          }
        }
      }
      AppMethodBeat.o(114498);
      return;
    }
  }
  
  public final boolean doZ()
  {
    AppMethodBeat.i(114491);
    if (this.wbu == com.tencent.mm.plugin.multitalk.ui.widget.i.wgw) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114491);
      return bool;
    }
  }
  
  public final MultiTalkGroup dpI()
  {
    return this.wbv;
  }
  
  public final boolean dpJ()
  {
    AppMethodBeat.i(114487);
    boolean bool = t.KH(this.wbr);
    AppMethodBeat.o(114487);
    return bool;
  }
  
  public final boolean dpK()
  {
    return this.lbb;
  }
  
  public final HashSet<String> dpL()
  {
    return this.wbt;
  }
  
  public final boolean dpM()
  {
    AppMethodBeat.i(114490);
    if ((this.wbu == com.tencent.mm.plugin.multitalk.ui.widget.i.wgv) || (this.wbu == com.tencent.mm.plugin.multitalk.ui.widget.i.wgw)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114490);
      return bool;
    }
  }
  
  public final r dpP()
  {
    AppMethodBeat.i(206566);
    if (this.wbO == null) {
      this.wbO = new r();
    }
    r localr = this.wbO;
    AppMethodBeat.o(206566);
    return localr;
  }
  
  public final ac dpQ()
  {
    AppMethodBeat.i(206567);
    if (this.wbP == null) {
      this.wbP = new ad(z.dqw().wbf);
    }
    ad localad = this.wbP;
    AppMethodBeat.o(206567);
    return localad;
  }
  
  public final ab dpS()
  {
    AppMethodBeat.i(206569);
    if (this.wbQ == null) {
      this.wbQ = new ab();
    }
    ab localab = this.wbQ;
    AppMethodBeat.o(206569);
    return localab;
  }
  
  public final a dpT()
  {
    AppMethodBeat.i(206571);
    if (this.wbR == null) {
      this.wbR = new a();
    }
    a locala = this.wbR;
    AppMethodBeat.o(206571);
    return locala;
  }
  
  public final void dpU()
  {
    AppMethodBeat.i(162239);
    this.wbT = null;
    this.wbD = false;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162239);
  }
  
  public final void dpX()
  {
    AppMethodBeat.i(114510);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(114510);
  }
  
  public final void dpY()
  {
    AppMethodBeat.i(114513);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.wbr) });
    AppMethodBeat.o(114513);
  }
  
  public final void dpZ()
  {
    AppMethodBeat.i(114514);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(114514);
  }
  
  public final boolean dpa()
  {
    AppMethodBeat.i(114489);
    if ((this.wbu != com.tencent.mm.plugin.multitalk.ui.widget.i.wgs) && (this.wbv != null)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114489);
      return bool;
    }
  }
  
  public final void dqa()
  {
    AppMethodBeat.i(178889);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
    AppMethodBeat.o(178889);
  }
  
  public final void dqb()
  {
    AppMethodBeat.i(206573);
    this.wbN = new com.tencent.mm.plugin.multitalk.a.a();
    if (this.lbb) {
      this.wbN.cn(true);
    }
    com.tencent.mm.plugin.multitalk.a.a.doG();
    AppMethodBeat.o(206573);
  }
  
  public final void dqd()
  {
    AppMethodBeat.i(114520);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (this.wbH == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.wbt.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.wbw == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "startNetworkDataSource: NetworkDataSource is null %d", new Object[] { Integer.valueOf(this.wbt.size()) });
      this.wbw = new w();
    }
    this.wbw.a(dpS());
    w localw = this.wbw;
    if (!localw.wcF)
    {
      com.tencent.mm.sdk.platformtools.ad.i("NetworkDataSource", "start");
      localw.wcF = true;
      w.b[] arrayOfb = localw.wcE;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = arrayOfb[i];
        synchronized (Boolean.valueOf(((w.b)localObject3).wcN))
        {
          if (!((w.b)localObject3).wcN)
          {
            ((w.b)localObject3).wcN = true;
            new Thread((Runnable)localObject3).start();
          }
          localObject3 = d.z.MKo;
          i += 1;
        }
      }
      if (localObject2.dqp()) {
        localObject2.arB(localObject2.wcI);
      }
    }
    if (dpT().doK())
    {
      ??? = dpT().wag;
      if (??? != null)
      {
        ??? = ((com.tencent.mm.plugin.multitalk.ui.widget.b)???).wex;
        if (??? != null)
        {
          String str = ((MultiTalkVideoView)???).getUsername();
          ??? = str;
          if (str != null) {
            break label306;
          }
        }
      }
      ??? = "";
      label306:
      arv((String)???);
    }
    AppMethodBeat.o(114520);
  }
  
  public final void dqe()
  {
    AppMethodBeat.i(114521);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
    if (this.wbw != null)
    {
      this.wbw.stop();
      this.wbw = null;
    }
    AppMethodBeat.o(114521);
  }
  
  public final boolean dqf()
  {
    AppMethodBeat.i(206574);
    if (dpM())
    {
      this.wbU = true;
      this.wbr = 3;
      boolean bool = z.dqw().wbf.KE(3);
      AppMethodBeat.o(206574);
      return bool;
    }
    AppMethodBeat.o(206574);
    return false;
  }
  
  public final boolean dqi()
  {
    return this.wbq;
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114507);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { t.g(paramMultiTalkGroup) });
    qm localqm = new qm();
    localqm.dFi.type = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localqm);
    n.oR(true);
    if (this.wbu != com.tencent.mm.plugin.multitalk.ui.widget.i.wgt)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.wgv);
      a(paramMultiTalkGroup, Boolean.TRUE);
    }
    if ((dpa()) && (a(paramMultiTalkGroup))) {
      dpW();
    }
    AppMethodBeat.o(114507);
  }
  
  public final void ez(List<a.ap> paramList)
  {
    AppMethodBeat.i(114516);
    if (dpa())
    {
      Object localObject = dpO();
      if (localObject != null) {
        ((h)localObject).ez(paramList);
      }
      this.wbt.clear();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (a.ap)paramList.next();
        if ((((a.ap)localObject).LHP == 2) || (((a.ap)localObject).LHP == 3)) {
          this.wbt.add(((a.ap)localObject).dtx);
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.wbt });
      if (this.wbH != null) {
        this.wbH.dpd();
      }
    }
    AppMethodBeat.o(114516);
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114509);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { t.g(paramMultiTalkGroup) });
    int i;
    if ((dpa()) && (a(paramMultiTalkGroup)))
    {
      Iterator localIterator = this.wbv.LJG.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
        if ((localMultiTalkGroupMember.status != 10) && (localMultiTalkGroupMember.status != 1)) {
          break label242;
        }
        i += 1;
      }
    }
    label242:
    for (;;)
    {
      break;
      if (i > 1) {
        i = 1;
      }
      while (i == 0) {
        if (this.wbu == com.tencent.mm.plugin.multitalk.ui.widget.i.wgt)
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
      if ((this.wbu != com.tencent.mm.plugin.multitalk.ui.widget.i.wgw) && (t.h(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.i.wgw);
      }
      if (this.wbH != null)
      {
        paramMultiTalkGroup = this.wbu;
        if ((paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.wgv) && (paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.wgw))
        {
          i = j;
          if (paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.wgt) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          this.wbH.dpc();
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
    long l2 = this.wbz;
    AppMethodBeat.o(114492);
    return l1 - l2;
  }
  
  public final void h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(114497);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    dpO().close();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    z.dqx().stopRing();
    Object localObject;
    String str;
    boolean bool;
    long l;
    int i;
    if (dpa())
    {
      localObject = new qm();
      ((qm)localObject).dFi.type = 2;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = this.wbv;
      str = t.j((MultiTalkGroup)localObject);
      n.hZ(((MultiTalkGroup)localObject).LJE, str);
      n.ars(str);
      if (this.wbu != com.tencent.mm.plugin.multitalk.ui.widget.i.wgw)
      {
        bool = t.i(this.wbv);
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
      n.a(bool, l, str, i);
      label192:
      localObject = this.wbu;
      if (this.wbH != null) {
        this.wbH.dpb();
      }
      this.wbx = false;
      this.wby = false;
      this.wbu = com.tencent.mm.plugin.multitalk.ui.widget.i.wgs;
      dqe();
      dpR();
      oS(false);
      this.wbR = null;
      nz(true);
      bxe();
      if (this.wbN != null) {
        this.wbN.doI();
      }
      z.dqv().reset();
      if (this.wbv != null)
      {
        a(this.wbv, (com.tencent.mm.plugin.multitalk.ui.widget.i)localObject, paramBoolean2);
        str = this.wbv.LJC;
        localObject = str;
        if (bt.isNullOrNil(str)) {
          localObject = this.wbv.LJD;
        }
        z.dqw().wbf.arl((String)localObject);
        this.wbv = null;
      }
      this.wbr = 0;
      this.lbb = true;
      this.fMP = false;
      this.wbs = true;
      this.wbz = 0L;
      this.wbA = 0;
      this.wbt.clear();
      localObject = new fj();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      this.wbD = true;
      for (;;)
      {
        localObject = com.tencent.mm.plugin.multitalk.c.d.whH;
        com.tencent.mm.plugin.multitalk.c.d.report();
        dqc();
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
          break label601;
        }
        i = 10;
        break;
        n.KC(this.wbA);
        n.u(this.wbA, str);
        if (((MultiTalkGroup)localObject).LJG == null) {
          break label192;
        }
        n.Kz(((MultiTalkGroup)localObject).LJG.size());
        break label192;
        if (!this.wbD)
        {
          dqe();
          nz(false);
          bxe();
          this.wbv = null;
          this.wbr = 0;
          this.wbz = 0L;
          this.wbA = 0;
          this.wbt.clear();
          this.wbu = com.tencent.mm.plugin.multitalk.ui.widget.i.wgs;
          this.wbB = 0;
        }
      }
      label601:
      i = 0;
    }
  }
  
  public final void m(int paramInt, Object paramObject)
  {
    int j = 2131761391;
    AppMethodBeat.i(114501);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDo, Integer.valueOf(-1));
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDp, Long.valueOf(-1L));
    int i;
    switch (paramInt)
    {
    default: 
      i = 2131761406;
    }
    for (;;)
    {
      if (this.wbH != null) {
        this.wbH.onError(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(aj.getContext(), aj.getContext().getString(i), 0).show();
        h(false, false, true);
      }
      AppMethodBeat.o(114501);
      return;
      n.oQ(false);
      i = 2131761394;
      continue;
      n.oR(false);
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
      this.wbE = true;
      this.wbF = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.aa)paramObject;
        i = j;
        if (paramObject != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.LHv);
          i = j;
          if (paramObject.LHv != 0)
          {
            this.wbG = (paramObject.LHv * 1000);
            i = j;
            continue;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = 2131761400;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.ab)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.fZg().zC(false);
                i = j;
                continue;
                i = 2131761399;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.wbv;
                if (this.wbv != null) {}
                for (String str = this.wbv.LJE;; str = "")
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.ab)paramObject;
                    if (paramObject != null)
                    {
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.LFX != null)
                      {
                        z.dqy().arn(paramObject.LFX.LIu);
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.LFX.LIu);
                      }
                      if (!z.dqw().wbf.arl(paramObject.groupId)) {
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = 2131761444;
                  break;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(aj.getContext(), aj.getContext().getString(2131761391), 0).show();
                i = j;
                if (paramObject != null)
                {
                  int k = ((Integer)paramObject).intValue();
                  i = j;
                  if (k > 0)
                  {
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDo, Integer.valueOf(k));
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDp, Long.valueOf(bt.HI()));
                    i = j;
                    continue;
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                    i = 2131761430;
                    continue;
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
                    AppMethodBeat.o(114501);
                    return;
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
                    i = 2131761401;
                    continue;
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
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
  
  public final void nz(boolean paramBoolean)
  {
    AppMethodBeat.i(178890);
    this.uJZ = false;
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.euN().eyZ();
    }
    for (;;)
    {
      ((NotificationManager)aj.getContext().getSystemService("notification")).cancel(43);
      dqc();
      AppMethodBeat.o(178890);
      return;
      com.tencent.mm.plugin.voip.c.euN().rf(false);
    }
  }
  
  public final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(114511);
    this.fMP = paramBoolean;
    if (this.wbH != null) {
      this.wbH.oG(this.fMP);
    }
    AppMethodBeat.o(114511);
  }
  
  public final void oI(boolean paramBoolean)
  {
    AppMethodBeat.i(114532);
    if ((z.dqx().dpM()) && (this.wbH != null))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.wbH.oI(paramBoolean);
    }
    AppMethodBeat.o(114532);
  }
  
  public final void oT(boolean paramBoolean)
  {
    AppMethodBeat.i(114517);
    if (dpa())
    {
      if (this.uJZ)
      {
        AppMethodBeat.o(114517);
        return;
      }
      this.uJZ = true;
      n.i(t.dql(), t.KH(z.dqx().wbr), paramBoolean);
      Toast.makeText(aj.getContext(), 2131761425, 0).show();
      Object localObject1 = aj.getContext().getString(2131761388);
      String str = aj.getContext().getString(2131761434);
      Object localObject2 = new Intent();
      ((Intent)localObject2).setClass(aj.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(aj.getContext(), 43, (Intent)localObject2, 134217728);
      int i = 2131233502;
      if (com.tencent.mm.compatible.util.d.lz(19)) {
        i = 2131233500;
      }
      localObject1 = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(str).i(System.currentTimeMillis()).f((CharSequence)localObject1).g(str);
      ((s.c)localObject1).Hl = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.b.n.e((s.c)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
      if (this.wbH != null) {
        this.wbH.ddn();
      }
      dpR();
      oS(true);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114485);
          Intent localIntent = new Intent();
          localIntent.setFlags(268435456);
          if (o.f(o.this) != null) {}
          for (String str = o.f(o.this).LJE;; str = "")
          {
            localIntent.putExtra("enterMainUiWxGroupId", str);
            localIntent.setClass(aj.getContext(), MultiTalkMainUI.class);
            localIntent.putExtra("notification", this.wcb);
            localIntent.putExtra("enterMainUiSource", 1);
            com.tencent.mm.plugin.voip.c.euN().a(localIntent, false, true, new com.tencent.mm.plugin.voip.ui.a()
            {
              public final void a(Intent paramAnonymous2Intent, BaseSmallView paramAnonymous2BaseSmallView)
              {
                AppMethodBeat.i(178888);
                if (!o.this.doZ())
                {
                  paramAnonymous2BaseSmallView.aDK(aj.getContext().getString(2131761459));
                  AppMethodBeat.o(178888);
                  return;
                }
                int i = o.this.wbA;
                paramAnonymous2BaseSmallView.aDJ(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
                AppMethodBeat.o(178888);
              }
              
              public final boolean ddj()
              {
                AppMethodBeat.i(114483);
                if ((o.this.dpM()) || (o.this.doZ()))
                {
                  AppMethodBeat.o(114483);
                  return true;
                }
                AppMethodBeat.o(114483);
                return false;
              }
            });
            o.g(o.this);
            AppMethodBeat.o(114485);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(114517);
  }
  
  public final void oU(boolean paramBoolean)
  {
    AppMethodBeat.i(114512);
    com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    z.dqw().wbf.oU(paramBoolean);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lbb = paramBoolean;
    if (this.wbH != null) {
      this.wbH.oH(this.lbb);
    }
    AppMethodBeat.o(114512);
  }
  
  public final void oV(boolean paramBoolean)
  {
    AppMethodBeat.i(114528);
    if (this.wbp)
    {
      AppMethodBeat.o(114528);
      return;
    }
    if (this.wbN != null)
    {
      this.wbN.K(paramBoolean, 0);
      this.wbp = true;
    }
    AppMethodBeat.o(114528);
  }
  
  public final void oW(boolean paramBoolean)
  {
    AppMethodBeat.i(114533);
    com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wbq = paramBoolean;
    AppMethodBeat.o(114533);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void stopRing()
  {
    AppMethodBeat.i(114529);
    if ((this.wbp) && (this.wbN != null))
    {
      this.wbN.doH();
      this.wbp = false;
    }
    AppMethodBeat.o(114529);
  }
  
  final class a
  {
    MultiTalkGroup wcd;
    Boolean wce;
    
    a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
    {
      this.wcd = paramMultiTalkGroup;
      this.wce = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.o
 * JD-Core Version:    0.7.0.1
 */