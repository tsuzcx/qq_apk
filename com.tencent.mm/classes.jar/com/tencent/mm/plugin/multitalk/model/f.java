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
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
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
  public boolean fqj;
  private boolean szC;
  private boolean tOB;
  public boolean tOC;
  private boolean tOD;
  public int tOE;
  public boolean tOF;
  public HashSet<String> tOG;
  public com.tencent.mm.plugin.multitalk.ui.widget.i tOH;
  public MultiTalkGroup tOI;
  private l tOJ;
  public boolean tOK;
  public boolean tOL;
  private long tOM;
  public int tON;
  private int tOO;
  private int tOP;
  private boolean tOQ;
  private boolean tOR;
  private long tOS;
  private long tOT;
  public b tOU;
  private Timer tOV;
  private j.a tOW;
  public boolean tOX;
  MultiTalkGroup tOY;
  long tOZ;
  private boolean tPa;
  public com.tencent.mm.plugin.multitalk.a.a tPb;
  av tPc;
  a tPd;
  private ap tPe;
  BroadcastReceiver tPf;
  com.tencent.mm.sdk.b.c tPg;
  
  public f()
  {
    AppMethodBeat.i(114486);
    this.tOF = true;
    this.tOG = new HashSet();
    this.tOH = com.tencent.mm.plugin.multitalk.ui.widget.i.tSC;
    this.tOI = null;
    this.tOK = false;
    this.tOL = false;
    this.tOM = 0L;
    this.tON = 0;
    this.tOO = 0;
    this.tOP = 2;
    this.tOQ = false;
    this.tOR = false;
    this.tOS = 0L;
    this.tOT = 30000L;
    this.tOY = null;
    this.tOZ = 0L;
    this.tPa = false;
    this.tPc = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(114480);
        ad.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (f.a(f.this) == null)
        {
          f.b(f.this);
          f.c(f.this).stopTimer();
          AppMethodBeat.o(114480);
          return false;
        }
        if (f.fB(aj.getContext()))
        {
          f.this.b(f.a(f.this));
          f.d(f.this);
          f.b(f.this);
          f.c(f.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 7L, 1L, false);
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
    this.tPe = new ap(Looper.getMainLooper());
    this.tPf = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114473);
        if (!f.this.cRE())
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
              j.a locala1 = j.cSF();
              if (locala1 != f.i(f.this))
              {
                j.a locala2 = f.i(f.this);
                f.a(f.this, locala1);
                ad.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), f.i(f.this).name() });
                f.this.Hi(f.j(f.this));
                if (f.k(f.this) != null) {
                  f.k(f.this).a(f.i(f.this));
                }
                AppMethodBeat.o(114470);
                return;
              }
              f.this.Hi(f.j(f.this));
              ad.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { f.i(f.this).name() });
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
          ad.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[] { Integer.valueOf(i) });
          if (i != 0) {
            break;
          }
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114471);
              p.cSN().tOr.xr(false);
              if (f.this.tPb != null) {
                f.this.tPb.Mu();
              }
              if (!com.tencent.mm.plugin.audio.c.a.bvC()) {
                f.this.nD(p.cSO().tOC);
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
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114472);
            p.cSN().tOr.xr(true);
            AppMethodBeat.o(114472);
          }
        });
        AppMethodBeat.o(114473);
      }
    };
    this.tPg = new f.4(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.tPg);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
    localIntentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    aj.getContext().registerReceiver(this.tPf, localIntentFilter);
    this.tOX = false;
    AppMethodBeat.o(114486);
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(114500);
    ad.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((parami == com.tencent.mm.plugin.multitalk.ui.widget.i.tSD) && (paramBoolean))
    {
      parami = new bl();
      parami.setType(64);
      parami.kY(System.currentTimeMillis());
      parami.setStatus(6);
      parami.setContent(aj.getContext().getString(2131761448));
      if (q.rQ(paramMultiTalkGroup.Ioi))
      {
        parami.nY(paramMultiTalkGroup.Ioi);
        parami.setContent(parami.field_content);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(parami);
      }
    }
    AppMethodBeat.o(114500);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114493);
    if (!cRE())
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { j.g(paramMultiTalkGroup) });
      this.tOI = paramMultiTalkGroup;
      this.tON = 0;
      this.tOE = 1;
      this.tOG.clear();
      cSl();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    Object localObject1 = this.tOI;
    int i;
    if ((paramMultiTalkGroup == null) || (localObject1 == null)) {
      i = 0;
    }
    while (i != 0)
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { j.g(paramMultiTalkGroup) });
      Object localObject2 = this.tOI;
      localObject1 = new HashMap();
      Object localObject3 = paramMultiTalkGroup.Iok.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject3).next();
          ((HashMap)localObject1).put(localMultiTalkGroupMember.Iol, localMultiTalkGroupMember);
          continue;
          if ((!bt.isNullOrNil(paramMultiTalkGroup.Iog)) && (!bt.isNullOrNil(((MultiTalkGroup)localObject1).Iog)) && (paramMultiTalkGroup.Iog.equals(((MultiTalkGroup)localObject1).Iog)))
          {
            i = 1;
            break;
          }
          if ((!bt.isNullOrNil(paramMultiTalkGroup.Ioh)) && (!bt.isNullOrNil(((MultiTalkGroup)localObject1).Ioh)) && (paramMultiTalkGroup.Ioh.equals(((MultiTalkGroup)localObject1).Ioh)))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      localObject2 = ((MultiTalkGroup)localObject2).Iok.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiTalkGroupMember)((Iterator)localObject2).next();
        if ((!u.aqG().equals(((MultiTalkGroupMember)localObject3).Iol)) && (u.aqG().equals(((MultiTalkGroupMember)localObject3).Iom)) && (((MultiTalkGroupMember)localObject3).status == 1) && ((!((HashMap)localObject1).containsKey(((MultiTalkGroupMember)localObject3).Iol)) || (((MultiTalkGroupMember)((HashMap)localObject1).get(((MultiTalkGroupMember)localObject3).Iol)).status == 20)))
        {
          localObject3 = ((MultiTalkGroupMember)localObject3).Iol;
          localObject3 = aj.getContext().getString(2131761442, new Object[] { v.sh((String)localObject3) });
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)localObject3);
          Toast.makeText(aj.getContext(), (CharSequence)localObject3, 0).show();
        }
      }
      this.tOI = paramMultiTalkGroup;
      cSl();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    ad.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { j.g(this.tOI), j.g(paramMultiTalkGroup) });
    AppMethodBeat.o(114493);
    return false;
  }
  
  private void aKf()
  {
    AppMethodBeat.i(114526);
    ad.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.tOV != null)
    {
      this.tOV.cancel();
      AppMethodBeat.o(114526);
      return;
    }
    this.tOM = System.currentTimeMillis();
    this.tON = 0;
    this.tOV = new Timer();
    TimerTask local3 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(114476);
        if ((f.this.getTotalTime() >= 45000L) && (f.l(f.this) != com.tencent.mm.plugin.multitalk.ui.widget.i.tSG)) {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114474);
              f.this.g(false, true, false);
              AppMethodBeat.o(114474);
            }
          });
        }
        if (f.l(f.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.tSG)
        {
          f.m(f.this);
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114475);
              if (f.l(f.this) == com.tencent.mm.plugin.multitalk.ui.widget.i.tSG)
              {
                com.tencent.mm.plugin.voip.c.dRR().sa(f.this.tON);
                if (f.k(f.this) != null) {
                  f.k(f.this).cGS();
                }
              }
              AppMethodBeat.o(114475);
            }
          });
        }
        AppMethodBeat.o(114476);
      }
    };
    this.tOV.schedule(local3, 1000L, 1000L);
    AppMethodBeat.o(114526);
  }
  
  public static void ahC(String paramString)
  {
    AppMethodBeat.i(114499);
    ad.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    bl localbl = new bl();
    localbl.setType(64);
    localbl.kY(System.currentTimeMillis());
    localbl.setStatus(6);
    localbl.setContent(aj.getContext().getString(2131761448));
    if (q.rQ(paramString))
    {
      localbl.nY(paramString);
      localbl.setContent(localbl.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
    }
    AppMethodBeat.o(114499);
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.i parami)
  {
    boolean bool = true;
    AppMethodBeat.i(114525);
    Object localObject = this.tOH;
    this.tOH = parami;
    if (localObject != parami) {
      if (parami == com.tencent.mm.plugin.multitalk.ui.widget.i.tSG)
      {
        localObject = new ps();
        ((ps)localObject).dvu.type = 1;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        e.a(j.i(this.tOI), getTotalTime(), j.j(this.tOI));
        p.cSO().stopRing();
        com.tencent.mm.plugin.audio.c.a.setMode(3);
        if ((com.tencent.mm.plugin.audio.c.a.bvw()) || (com.tencent.mm.plugin.audio.c.a.bvC())) {
          break label126;
        }
      }
    }
    for (;;)
    {
      nD(bool);
      if (this.tOU != null) {
        this.tOU.a(parami);
      }
      AppMethodBeat.o(114525);
      return;
      label126:
      bool = false;
    }
  }
  
  private void bmd()
  {
    AppMethodBeat.i(114527);
    if (this.tOV != null)
    {
      this.tOV.cancel();
      this.tOV = null;
    }
    AppMethodBeat.o(114527);
  }
  
  private static boolean cB(Context paramContext)
  {
    AppMethodBeat.i(114531);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ad.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ad.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
        AppMethodBeat.o(114531);
        return false;
      }
    }
    if (((KeyguardManager)aj.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(114531);
      return false;
    }
    ad.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
    AppMethodBeat.o(114531);
    return true;
  }
  
  private void cSl()
  {
    AppMethodBeat.i(114495);
    Iterator localIterator = this.tOI.Iok.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.tOG.remove(localMultiTalkGroupMember.Iol))) {
        ad.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.Iol });
      }
    }
    AppMethodBeat.o(114495);
  }
  
  private void cSn()
  {
    AppMethodBeat.i(114504);
    if (this.tOH == com.tencent.mm.plugin.multitalk.ui.widget.i.tSE) {}
    for (;;)
    {
      boolean bool = false;
      for (f localf = this;; localf = this)
      {
        localf.tOC = bool;
        this.fqj = false;
        this.tOW = j.cSF();
        AppMethodBeat.o(114504);
        return;
        if ((com.tencent.mm.plugin.audio.c.a.bvw()) || (com.tencent.mm.plugin.audio.c.a.bvC())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void cSo()
  {
    AppMethodBeat.i(114508);
    if (j.h(this.tOI)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.tSG);
    }
    while (this.tOU != null)
    {
      this.tOU.cOp();
      localObject = j.cSF();
      if (localObject != this.tOW) {
        this.tOW = ((j.a)localObject);
      }
      AppMethodBeat.o(114508);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.tSF);
    }
    Object localObject = new Intent();
    com.tencent.mm.bs.d.b(aj.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(114508);
  }
  
  private void cSu()
  {
    AppMethodBeat.i(114519);
    try
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.lf(26)) && (this.tPa))
      {
        aj.getContext().unbindService(this);
        this.tPa = false;
      }
      AppMethodBeat.o(114519);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MT.MultiTalkManager", localException, "unBind VoipSmallService error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(114519);
    }
  }
  
  private static boolean cSy()
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
        ad.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ad.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
  
  public static void cSz()
  {
    AppMethodBeat.i(178891);
    com.tencent.mm.plugin.voip.ui.d locald = com.tencent.mm.plugin.voip.c.dRR();
    if ((locald.zrN != null) && (!locald.zrQ))
    {
      com.tencent.e.h.Iye.aNW("showIcon");
      com.tencent.e.h.Iye.f(new d.4(locald), "showIcon");
    }
    AppMethodBeat.o(178891);
  }
  
  private void sort()
  {
    AppMethodBeat.i(114494);
    ad.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.tOI.Iok });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.tOI.Iok.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.Iol.equals(u.aqG())) {
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
    this.tOI.Iok = localLinkedList;
    ad.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.tOI.Iok });
    AppMethodBeat.o(114494);
  }
  
  public final void Hh(int paramInt)
  {
    AppMethodBeat.i(114515);
    ad.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.tOX = true;
      AppMethodBeat.o(114515);
      return;
    }
    this.tOX = false;
    AppMethodBeat.o(114515);
  }
  
  public final boolean Hi(int paramInt)
  {
    AppMethodBeat.i(114523);
    if (cSk())
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "try switch to action : ".concat(String.valueOf(paramInt)));
      boolean bool = p.cSN().tOr.Hi(paramInt);
      ad.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[] { Boolean.valueOf(bool) });
      int i = this.tOE;
      this.tOE = paramInt;
      if (j.Hk(this.tOE)) {
        cSv();
      }
      for (;;)
      {
        if ((this.tOU != null) && (i != this.tOE)) {
          this.tOU.gg(i, this.tOE);
        }
        AppMethodBeat.o(114523);
        return bool;
        cSw();
      }
    }
    AppMethodBeat.o(114523);
    return false;
  }
  
  final void a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(114503);
    ad.m("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      cSt();
      this.tOB = false;
      cSn();
      aKf();
      Intent localIntent = new Intent();
      RemoteViews localRemoteViews = null;
      String str = "";
      if (!paramBoolean.booleanValue())
      {
        if ((com.tencent.mm.compatible.util.d.lh(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
          i = 1;
        }
        if (i != 0) {
          this.tPd = new a(paramMultiTalkGroup, Boolean.FALSE);
        }
        paramBoolean = aj.getResources().getString(2131761415);
        localIntent.putExtra("Voip_User", j.k(paramMultiTalkGroup));
        paramMultiTalkGroup = v.sh(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localIntent.getStringExtra("Voip_User")).field_username);
        localRemoteViews = new RemoteViews(aj.getPackageName(), 2131495877);
        localRemoteViews.setTextViewText(2131302963, paramBoolean);
        localRemoteViews.setTextViewText(2131302962, paramMultiTalkGroup);
        localRemoteViews.setImageViewResource(2131306948, 2131234752);
        localRemoteViews.setImageViewResource(2131302957, 2131234488);
        str = paramMultiTalkGroup + paramBoolean;
      }
      com.tencent.mm.util.a.a(aj.getContext(), "multitalk", ".ui.MultiTalkMainUI", localIntent, localRemoteViews, str, com.tencent.mm.br.a.eux());
    }
    AppMethodBeat.o(114503);
  }
  
  public final boolean ahD(String paramString)
  {
    AppMethodBeat.i(114524);
    if (cSk())
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      boolean bool = p.cSN().tOr.ahD(paramString);
      ad.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(114524);
      return bool;
    }
    AppMethodBeat.o(114524);
    return false;
  }
  
  public final void b(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114502);
    boolean bool2 = this.fqj;
    boolean bool3 = this.tOC;
    boolean bool4 = this.tOF;
    Object localObject = this.tOH.toString();
    if (this.tOI == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      e.cRX();
      if ((com.tencent.mm.m.f.Yk()) || (cB(aj.getContext()))) {
        break;
      }
      ad.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.tOY == null) && (this.tPc.eFX()))
      {
        this.tOY = paramMultiTalkGroup;
        this.tPc.av(2000L, 2000L);
        this.tOZ = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(114502);
      return;
    }
    localObject = j.k(paramMultiTalkGroup);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject);
    if (com.tencent.mm.m.g.Zd().getInt("MultitalkBlockReceiver", 0) == 0) {}
    for (int i = 1; (i == 0) || (localaf == null) || (localaf.ZM()); i = 0)
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      com.tencent.mm.sdk.platformtools.aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114481);
          String str2 = paramMultiTalkGroup.Iog;
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.Ioh;
          }
          p.cSN().tOr.ahu(str1);
          AppMethodBeat.o(114481);
        }
      }, 1000L);
      e.bn(3, j.j(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if ((!cRE()) && (!com.tencent.mm.plugin.voip.b.k.isVoipStarted()) && (!com.tencent.mm.plugin.voip.b.k.dWP()) && (!com.tencent.mm.bi.e.aCj())) {
      if (((TelephonyManager)aj.getContext().getSystemService("phone")).getCallState() == 0) {
        break label455;
      }
    }
    label455:
    for (i = 1; (i != 0) || (com.tencent.mm.plugin.voip.b.k.dWQ()) || (!com.tencent.mm.n.b.ls(localaf.field_type)); i = 0)
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
      if (!q.rO(paramMultiTalkGroup.Ioi))
      {
        ad.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.Ioi });
        ar.a.gMW.a(paramMultiTalkGroup.Ioi, "", new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
        });
      }
      com.tencent.mm.sdk.platformtools.aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114482);
          String str2 = paramMultiTalkGroup.Iog;
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.Ioh;
          }
          p.cSN().tOr.ahu(str1);
          AppMethodBeat.o(114482);
        }
      }, 1000L);
      e.bn(3, j.j(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if (!q.rO(paramMultiTalkGroup.Ioi))
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.Ioi });
      ar.a.gMW.a(paramMultiTalkGroup.Ioi, "", null);
    }
    ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.i.tSD);
    e.bn(1, j.j(paramMultiTalkGroup));
    if ((!com.tencent.mm.n.b.ls(localaf.field_type)) || (com.tencent.mm.r.a.ccn()))
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { localObject, u.aqG() });
      if (a(paramMultiTalkGroup))
      {
        this.tOB = false;
        cSn();
        aKf();
        AppMethodBeat.o(114502);
      }
    }
    else
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { localObject, u.aqG() });
      localObject = new lk();
      ((lk)localObject).dpZ.action = 3;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      a(paramMultiTalkGroup, Boolean.FALSE);
    }
    AppMethodBeat.o(114502);
  }
  
  public final void c(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114496);
    boolean bool2 = this.fqj;
    boolean bool3 = this.tOC;
    boolean bool4 = this.tOF;
    Object localObject = this.tOH.toString();
    if (this.tOI == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      e.cRW();
      if (!cSy()) {
        break;
      }
      com.tencent.mm.ui.base.h.j(paramActivity, 2131760333, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.k.dWP())
    {
      com.tencent.mm.ui.base.h.j(paramActivity, 2131760337, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.k.isVoipStarted())
    {
      com.tencent.mm.ui.base.h.j(paramActivity, 2131760336, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.bi.e.aCj())
    {
      com.tencent.mm.ui.base.h.j(paramActivity, 2131760332, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.k.dWQ())
    {
      com.tencent.mm.ui.base.h.j(paramActivity, 2131760335, 2131755906);
      AppMethodBeat.o(114496);
      return;
    }
    if (cRE())
    {
      com.tencent.mm.bi.e.a(paramActivity, 2131761410, null);
      AppMethodBeat.o(114496);
      return;
    }
    if ((this.tOR) && (System.currentTimeMillis() - this.tOS < this.tOT))
    {
      com.tencent.mm.bi.e.a(paramActivity, 2131761433, null);
      AppMethodBeat.o(114496);
      return;
    }
    this.tOR = false;
    paramActivity = bt.S(paramString1.split(","));
    paramString1 = new MultiTalkGroup();
    paramString1.Ioh = p.cSN().tOr.flI();
    paramString1.Ioi = paramString2;
    localObject = paramActivity.iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
      localMultiTalkGroupMember.Iol = str;
      if (str.equals(u.aqG())) {}
      for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
      {
        paramString1.Iok.add(localMultiTalkGroupMember);
        break;
      }
    }
    p.cSN().tOr.cL(bt.l((Integer)com.tencent.mm.kernel.g.afB().gcR.get(1)), u.aqG());
    if (p.cSN().tOr.a(paramString1.Ioh, paramString2, paramActivity, v2protocal.dVB())) {
      e.cRR();
    }
    for (;;)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.tSE);
      a(paramString1, Boolean.TRUE);
      AppMethodBeat.o(114496);
      return;
      e.cRS();
    }
  }
  
  public final void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114505);
    e.bn(2, j.j(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.i.tSD, true);
    AppMethodBeat.o(114505);
  }
  
  public final boolean cRD()
  {
    AppMethodBeat.i(114491);
    if (this.tOH == com.tencent.mm.plugin.multitalk.ui.widget.i.tSG) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114491);
      return bool;
    }
  }
  
  public final boolean cRE()
  {
    AppMethodBeat.i(114489);
    if ((this.tOH != com.tencent.mm.plugin.multitalk.ui.widget.i.tSC) && (this.tOI != null)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114489);
      return bool;
    }
  }
  
  public final boolean cSA()
  {
    return this.tOD;
  }
  
  public final MultiTalkGroup cSi()
  {
    return this.tOI;
  }
  
  public final boolean cSj()
  {
    return this.tOC;
  }
  
  public final boolean cSk()
  {
    AppMethodBeat.i(114490);
    if ((this.tOH == com.tencent.mm.plugin.multitalk.ui.widget.i.tSF) || (this.tOH == com.tencent.mm.plugin.multitalk.ui.widget.i.tSG)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114490);
      return bool;
    }
  }
  
  public final void cSm()
  {
    AppMethodBeat.i(162239);
    this.tPd = null;
    this.tOQ = false;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162239);
  }
  
  public final void cSp()
  {
    AppMethodBeat.i(114510);
    ad.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(114510);
  }
  
  public final void cSq()
  {
    AppMethodBeat.i(114513);
    ad.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.tOE) });
    AppMethodBeat.o(114513);
  }
  
  public final void cSr()
  {
    AppMethodBeat.i(114514);
    ad.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(114514);
  }
  
  public final void cSs()
  {
    AppMethodBeat.i(178889);
    ad.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
    AppMethodBeat.o(178889);
  }
  
  public final void cSt()
  {
    AppMethodBeat.i(189954);
    this.tPb = new com.tencent.mm.plugin.multitalk.a.a();
    if (this.tOC) {
      this.tPb.ck(true);
    }
    com.tencent.mm.plugin.multitalk.a.a.cRy();
    AppMethodBeat.o(189954);
  }
  
  public final void cSv()
  {
    AppMethodBeat.i(114520);
    ad.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (this.tOU == null)
    {
      ad.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.tOG.size() == 0)
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.tOJ == null)
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[] { Integer.valueOf(this.tOG.size()) });
      this.tOJ = new l(this.tOU);
      this.tOJ.Hl(this.tOG.size());
    }
    if (!this.tOJ.running) {
      this.tOJ.start();
    }
    AppMethodBeat.o(114520);
  }
  
  public final void cSw()
  {
    AppMethodBeat.i(114521);
    ad.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
    if (this.tOJ != null)
    {
      this.tOJ.stop();
      this.tOJ = null;
    }
    AppMethodBeat.o(114521);
  }
  
  public final boolean cSx()
  {
    AppMethodBeat.i(189955);
    if (this.tPb != null)
    {
      boolean bool = this.tPb.sAC.Nc();
      AppMethodBeat.o(189955);
      return bool;
    }
    AppMethodBeat.o(189955);
    return true;
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114506);
    ad.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
    e.nA(true);
    if (a(paramMultiTalkGroup)) {
      cSo();
    }
    AppMethodBeat.o(114506);
  }
  
  public final void d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114498);
    if (!q.rO(paramString1))
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      ar.a.gMW.a(paramString1, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    bl localbl = new bl();
    localbl.setType(64);
    localbl.kY(System.currentTimeMillis());
    localbl.setStatus(6);
    localbl.jV(2);
    String str = v.sh(paramString2);
    Object localObject = paramString2;
    if (str != null) {
      if (!str.equals("")) {
        break label398;
      }
    }
    label398:
    for (localObject = paramString2;; localObject = str)
    {
      paramString2 = (String)localObject + aj.getContext().getString(2131761446);
      localbl.setContent(paramString2);
      if (q.rQ(paramString1))
      {
        localbl.nY(paramString1);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(paramString1);
        if (localObject != null)
        {
          if (paramBoolean1) {
            ((am)localObject).jT(((ay)localObject).field_unReadCount + 1);
          }
          ((am)localObject).setContent(paramString2);
          if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a((am)localObject, paramString1) == -1) {
            ad.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
          }
          if (paramBoolean2)
          {
            ((at)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbl);
            AppMethodBeat.o(114498);
          }
        }
        else
        {
          localObject = new am();
          ((am)localObject).setUsername(paramString1);
          if (paramBoolean1) {
            ((am)localObject).jT(1);
          }
          ((am)localObject).setContent(paramString2);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().e((am)localObject);
          if (paramBoolean2) {
            ((at)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbl);
          }
        }
      }
      AppMethodBeat.o(114498);
      return;
    }
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114507);
    ad.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { j.g(paramMultiTalkGroup) });
    ps localps = new ps();
    localps.dvu.type = 1;
    com.tencent.mm.sdk.b.a.ESL.l(localps);
    e.nB(true);
    if (this.tOH != com.tencent.mm.plugin.multitalk.ui.widget.i.tSD)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.i.tSF);
      a(paramMultiTalkGroup, Boolean.TRUE);
    }
    if ((cRE()) && (a(paramMultiTalkGroup))) {
      cSo();
    }
    AppMethodBeat.o(114507);
  }
  
  public final void ei(List<a.ap> paramList)
  {
    AppMethodBeat.i(114516);
    if (cRE())
    {
      this.tOG.clear();
      ad.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a.ap localap = (a.ap)paramList.next();
        if ((localap.Imv == 2) || (localap.Imv == 3)) {
          this.tOG.add(localap.Imu);
        }
      }
      this.tOG.remove(u.aqG());
      ad.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.tOG });
      if (this.tOJ != null) {
        this.tOJ.Hl(this.tOG.size());
      }
      if (this.tOU != null) {
        this.tOU.cRH();
      }
    }
    AppMethodBeat.o(114516);
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    int j = 0;
    AppMethodBeat.i(114509);
    ad.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { j.g(paramMultiTalkGroup) });
    int i;
    if ((cRE()) && (a(paramMultiTalkGroup)))
    {
      Iterator localIterator = this.tOI.Iok.iterator();
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
        if (this.tOH == com.tencent.mm.plugin.multitalk.ui.widget.i.tSD)
        {
          g(false, true, false);
          AppMethodBeat.o(114509);
          return;
          i = 0;
        }
        else
        {
          g(false, false, false);
          AppMethodBeat.o(114509);
          return;
        }
      }
      if ((this.tOH != com.tencent.mm.plugin.multitalk.ui.widget.i.tSG) && (j.h(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.i.tSG);
      }
      if (this.tOU != null)
      {
        paramMultiTalkGroup = this.tOH;
        if ((paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.tSF) && (paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.tSG))
        {
          i = j;
          if (paramMultiTalkGroup != com.tencent.mm.plugin.multitalk.ui.widget.i.tSD) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          this.tOU.cRG();
        }
      }
      AppMethodBeat.o(114509);
      return;
    }
  }
  
  public final void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(114497);
    ad.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    p.cSO().stopRing();
    Object localObject;
    String str;
    boolean bool;
    long l;
    int i;
    if (cRE())
    {
      localObject = new ps();
      ((ps)localObject).dvu.type = 2;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = this.tOI;
      str = j.j((MultiTalkGroup)localObject);
      e.hv(((MultiTalkGroup)localObject).Ioi, str);
      e.ahB(str);
      if (this.tOH != com.tencent.mm.plugin.multitalk.ui.widget.i.tSG)
      {
        bool = j.i(this.tOI);
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
      localObject = this.tOH;
      if (this.tOU != null) {
        this.tOU.cRF();
      }
      this.tOK = false;
      this.tOL = false;
      this.tOH = com.tencent.mm.plugin.multitalk.ui.widget.i.tSC;
      cSw();
      mm(true);
      bmd();
      if (this.tPb != null) {
        this.tPb.cRA();
      }
      p.cSM().reset();
      p.cSP().cSH();
      if (this.tOI != null)
      {
        a(this.tOI, (com.tencent.mm.plugin.multitalk.ui.widget.i)localObject, paramBoolean2);
        str = this.tOI.Iog;
        localObject = str;
        if (bt.isNullOrNil(str)) {
          localObject = this.tOI.Ioh;
        }
        p.cSN().tOr.ahu((String)localObject);
        this.tOI = null;
      }
      this.tOE = 0;
      this.tOC = true;
      this.fqj = false;
      this.tOF = true;
      this.tOM = 0L;
      this.tON = 0;
      this.tOG.clear();
      localObject = new ff();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      this.tOQ = true;
      for (;;)
      {
        cSu();
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
        e.Hg(this.tON);
        e.v(this.tON, str);
        if (((MultiTalkGroup)localObject).Iok == null) {
          break label182;
        }
        e.Hd(((MultiTalkGroup)localObject).Iok.size());
        break label182;
        if (!this.tOQ)
        {
          cSw();
          mm(false);
          bmd();
          this.tOI = null;
          this.tOE = 0;
          this.tOM = 0L;
          this.tON = 0;
          this.tOG.clear();
          this.tOH = com.tencent.mm.plugin.multitalk.ui.widget.i.tSC;
          this.tOO = 0;
        }
      }
      label575:
      i = 0;
    }
  }
  
  public final long getTotalTime()
  {
    AppMethodBeat.i(114492);
    long l1 = System.currentTimeMillis();
    long l2 = this.tOM;
    AppMethodBeat.o(114492);
    return l1 - l2;
  }
  
  public final void mm(boolean paramBoolean)
  {
    AppMethodBeat.i(178890);
    this.szC = false;
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.dRR().dWd();
    }
    for (;;)
    {
      ((NotificationManager)aj.getContext().getSystemService("notification")).cancel(43);
      cSu();
      AppMethodBeat.o(178890);
      return;
      com.tencent.mm.plugin.voip.c.dRR().pE(false);
    }
  }
  
  public final void n(int paramInt, Object paramObject)
  {
    int j = 2131761391;
    AppMethodBeat.i(114501);
    ad.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsY, Integer.valueOf(-1));
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsZ, Long.valueOf(-1L));
    int i;
    switch (paramInt)
    {
    default: 
      i = 2131761406;
    }
    for (;;)
    {
      if (this.tOU != null) {
        this.tOU.onError(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(aj.getContext(), aj.getContext().getString(i), 0).show();
        g(false, false, true);
      }
      AppMethodBeat.o(114501);
      return;
      e.nA(false);
      i = 2131761394;
      continue;
      e.nB(false);
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
      this.tOR = true;
      this.tOS = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.aa)paramObject;
        i = j;
        if (paramObject != null)
        {
          ad.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.Imb);
          i = j;
          if (paramObject.Imb != 0)
          {
            this.tOT = (paramObject.Imb * 1000);
            i = j;
            continue;
            ad.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = 2131761400;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.ab)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.fpu().xz(false);
                i = j;
                continue;
                i = 2131761399;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.tOI;
                if (this.tOI != null) {}
                for (String str = this.tOI.Ioi;; str = "")
                {
                  ad.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.ab)paramObject;
                    if (paramObject != null)
                    {
                      ad.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.IkD != null)
                      {
                        p.cSQ().ahw(paramObject.IkD.ImY);
                        ad.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.IkD.ImY);
                      }
                      if (!p.cSN().tOr.ahu(paramObject.groupId)) {
                        ad.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = 2131761444;
                  break;
                }
                ad.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(aj.getContext(), aj.getContext().getString(2131761391), 0).show();
                i = j;
                if (paramObject != null)
                {
                  int k = ((Integer)paramObject).intValue();
                  i = j;
                  if (k > 0)
                  {
                    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsY, Integer.valueOf(k));
                    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsZ, Long.valueOf(bt.GC()));
                    i = j;
                    continue;
                    ad.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                    i = 2131761430;
                    continue;
                    ad.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
                    AppMethodBeat.o(114501);
                    return;
                    ad.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
                    i = 2131761401;
                    continue;
                    ad.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
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
  
  public final void nC(boolean paramBoolean)
  {
    AppMethodBeat.i(114517);
    if (cRE())
    {
      if (this.szC)
      {
        AppMethodBeat.o(114517);
        return;
      }
      this.szC = true;
      e.f(j.cSD(), j.Hj(p.cSO().tOE), paramBoolean);
      Toast.makeText(aj.getContext(), 2131761425, 0).show();
      Object localObject1 = aj.getContext().getString(2131761388);
      String str = aj.getContext().getString(2131761434);
      Object localObject2 = new Intent();
      ((Intent)localObject2).setClass(aj.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(aj.getContext(), 43, (Intent)localObject2, 134217728);
      int i = 2131233502;
      if (com.tencent.mm.compatible.util.d.lg(19)) {
        i = 2131233500;
      }
      localObject1 = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(str).g(System.currentTimeMillis()).f((CharSequence)localObject1).g(str);
      ((s.c)localObject1).Ew = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.b.k.c((s.c)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
      if (this.tOU != null) {
        this.tOU.cGR();
      }
      com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114485);
          Intent localIntent = new Intent();
          localIntent.setFlags(268435456);
          if (f.f(f.this) != null) {}
          for (String str = f.f(f.this).Ioi;; str = "")
          {
            localIntent.putExtra("enterMainUiWxGroupId", str);
            localIntent.setClass(aj.getContext(), MultiTalkMainUI.class);
            localIntent.putExtra("notification", this.tPl);
            localIntent.putExtra("enterMainUiSource", 1);
            com.tencent.mm.plugin.voip.c.dRR().a(localIntent, false, true, new com.tencent.mm.plugin.voip.ui.a()
            {
              public final void a(Intent paramAnonymous2Intent, BaseSmallView paramAnonymous2BaseSmallView)
              {
                AppMethodBeat.i(178888);
                if (!f.this.cRD())
                {
                  paramAnonymous2BaseSmallView.atl(aj.getContext().getString(2131761459));
                  AppMethodBeat.o(178888);
                  return;
                }
                int i = f.this.tON;
                paramAnonymous2BaseSmallView.atk(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
                AppMethodBeat.o(178888);
              }
              
              public final boolean cGN()
              {
                AppMethodBeat.i(114483);
                if ((f.this.cSk()) || (f.this.cRD()))
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
  
  public final void nD(boolean paramBoolean)
  {
    AppMethodBeat.i(114512);
    ad.m("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    p.cSN().tOr.nD(paramBoolean);
    ad.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tOC = paramBoolean;
    if (this.tOU != null) {
      this.tOU.nt(this.tOC);
    }
    AppMethodBeat.o(114512);
  }
  
  public final void nE(boolean paramBoolean)
  {
    AppMethodBeat.i(114528);
    if (this.tOB)
    {
      AppMethodBeat.o(114528);
      return;
    }
    if (this.tPb != null)
    {
      this.tPb.I(paramBoolean, 0);
      this.tOB = true;
    }
    AppMethodBeat.o(114528);
  }
  
  public final void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(114533);
    ad.m("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tOD = paramBoolean;
    AppMethodBeat.o(114533);
  }
  
  public final void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(114511);
    this.fqj = paramBoolean;
    if (this.tOU != null) {
      this.tOU.ns(this.fqj);
    }
    AppMethodBeat.o(114511);
  }
  
  public final void nu(boolean paramBoolean)
  {
    AppMethodBeat.i(114532);
    if ((p.cSO().cSk()) && (this.tOU != null))
    {
      ad.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.tOU.nu(paramBoolean);
    }
    AppMethodBeat.o(114532);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void stopRing()
  {
    AppMethodBeat.i(114529);
    if ((this.tOB) && (this.tPb != null))
    {
      this.tPb.cRz();
      this.tOB = false;
    }
    AppMethodBeat.o(114529);
  }
  
  final class a
  {
    MultiTalkGroup tPn;
    Boolean tPo;
    
    a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
    {
      this.tPn = paramMultiTalkGroup;
      this.tPo = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f
 * JD-Core Version:    0.7.0.1
 */