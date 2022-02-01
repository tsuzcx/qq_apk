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
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.s.c;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.rh.a;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.b.j;
import com.tencent.mm.plugin.multitalk.b.k;
import com.tencent.mm.plugin.multitalk.b.p.21;
import com.tencent.mm.plugin.multitalk.b.p.29;
import com.tencent.mm.plugin.multitalk.b.p.33;
import com.tencent.mm.plugin.multitalk.b.p.36;
import com.tencent.mm.plugin.multitalk.b.p.5;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.multitalk.ui.widget.n.f;
import com.tencent.mm.plugin.multitalk.ui.widget.n.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.ern;
import com.tencent.mm.protocal.protobuf.ero;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.common.b.a.a.a.as;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public final class q
  implements ServiceConnection, com.tencent.pb.talkroom.sdk.a
{
  private Timer dfh;
  public boolean guh;
  IListener hXn;
  public boolean mkd;
  public boolean yon;
  public e zLR;
  public boolean zMA;
  public Bundle zMB;
  public HashSet<String> zMC;
  public com.tencent.mm.plugin.multitalk.ui.widget.o zMD;
  public MultiTalkGroup zME;
  public z zMF;
  public boolean zMG;
  public boolean zMH;
  private long zMI;
  public int zMJ;
  private int zMK;
  private int zML;
  private boolean zMM;
  private boolean zMN;
  private long zMO;
  private long zMP;
  private v.a zMQ;
  private boolean zMR;
  private MultiTalkGroup zMS;
  private long zMT;
  private boolean zMU;
  public com.tencent.mm.plugin.multitalk.a.a zMV;
  private t zMW;
  private ag zMX;
  private ae zMY;
  private a zMZ;
  private boolean zMv;
  private boolean zMw;
  public int zMx;
  private boolean zMy;
  public boolean zMz;
  private Object zNa;
  HashMap<String, Integer> zNb;
  public CopyOnWriteArrayList<String> zNc;
  private MTimerHandler zNd;
  a zNe;
  public boolean zNf;
  private MMHandler zNg;
  BroadcastReceiver zNh;
  private IListener zNi;
  
  public q()
  {
    AppMethodBeat.i(114486);
    this.zMy = true;
    this.zMz = false;
    this.zMA = false;
    this.zMC = new HashSet();
    this.zMD = com.tencent.mm.plugin.multitalk.ui.widget.o.zUc;
    this.zME = null;
    this.zMG = false;
    this.zMH = false;
    this.zMI = 0L;
    this.zMJ = 0;
    this.zMK = 0;
    this.zML = 2;
    this.zMM = false;
    this.zMN = false;
    this.zMO = 0L;
    this.zMP = 30000L;
    this.zMS = null;
    this.zMT = 0L;
    this.zMU = false;
    this.zNa = new Object();
    this.zNb = new HashMap();
    this.zNc = new CopyOnWriteArrayList();
    this.zNd = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(239380);
        Log.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (q.a(q.this) == null)
        {
          q.b(q.this);
          q.c(q.this).stopTimer();
          AppMethodBeat.o(239380);
          return false;
        }
        if (q.gD(MMApplicationContext.getContext()))
        {
          q.this.b(q.a(q.this));
          q.d(q.this);
          q.b(q.this);
          q.c(q.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 7L, 1L, false);
          AppMethodBeat.o(239380);
          return false;
        }
        if (System.currentTimeMillis() - q.e(q.this) < 60000L)
        {
          AppMethodBeat.o(239380);
          return true;
        }
        q.d(q.this);
        q.b(q.this);
        q.c(q.this).stopTimer();
        AppMethodBeat.o(239380);
        return false;
      }
    }, true);
    this.zNf = false;
    this.zNg = new MMHandler(Looper.getMainLooper());
    this.zNh = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(239370);
        if (!q.this.ems())
        {
          AppMethodBeat.o(239370);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          q.h(q.this).removeCallbacksAndMessages(null);
          q.h(q.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114474);
              v.a locala1 = v.enY();
              if (locala1 != q.i(q.this))
              {
                v.a locala2 = q.i(q.this);
                q.a(q.this, locala1);
                Log.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), q.i(q.this).name() });
                q.this.aF(q.j(q.this), ac.eom().zMz);
                if (q.k(q.this) != null) {
                  q.k(q.this).a(q.i(q.this));
                }
                AppMethodBeat.o(114474);
                return;
              }
              q.this.aF(q.j(q.this), q.l(q.this));
              Log.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { q.i(q.this).name() });
              AppMethodBeat.o(114474);
            }
          }, 8000L);
          AppMethodBeat.o(239370);
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
          bool = q.this.ens();
          Log.i("MicroMsg.MT.MultiTalkManager", "phone state %d, isILinkMode:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if (i != 0) {
            break;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114475);
              if (bool) {
                com.tencent.mm.plugin.multitalk.b.p.zHS.rt(true);
              }
              for (;;)
              {
                if (!com.tencent.mm.plugin.audio.c.a.ceb()) {
                  q.this.rJ(ac.eom().mkd);
                }
                AppMethodBeat.o(114475);
                return;
                ac.eol().zMd.DM(false);
                if (q.this.zMV != null) {
                  q.this.zMV.Yl();
                }
              }
            }
          });
          AppMethodBeat.o(239370);
          return;
          if (paramAnonymousIntent.equals("RINGING")) {
            i = 1;
          } else if (paramAnonymousIntent.equals("OFFHOOK")) {
            i = 2;
          } else {
            i = ((TelephonyManager)paramAnonymousContext.getSystemService("phone")).getCallState();
          }
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(239369);
            if (bool)
            {
              com.tencent.mm.plugin.multitalk.b.p.zHS.rt(false);
              AppMethodBeat.o(239369);
              return;
            }
            ac.eol().zMd.DM(true);
            AppMethodBeat.o(239369);
          }
        });
        AppMethodBeat.o(239370);
      }
    };
    this.zNi = new IListener()
    {
      private boolean a(rh paramAnonymousrh)
      {
        AppMethodBeat.i(239375);
        if (paramAnonymousrh != null) {
          switch (paramAnonymousrh.dXY.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(239375);
          return false;
          paramAnonymousrh = new IntentFilter();
          paramAnonymousrh.addAction("android.intent.action.PHONE_STATE");
          paramAnonymousrh.addAction("android.intent.action.PHONE_STATE_2");
          paramAnonymousrh.addAction("android.intent.action.PHONE_STATE2");
          paramAnonymousrh.addAction("android.intent.action.PHONE_STATE_EXT");
          paramAnonymousrh.addAction("android.intent.action.DUAL_PHONE_STATE");
          paramAnonymousrh.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          try
          {
            MMApplicationContext.getContext().registerReceiver(q.o(q.this), paramAnonymousrh);
          }
          catch (Exception paramAnonymousrh)
          {
            Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver register error %s", new Object[] { paramAnonymousrh.fillInStackTrace() });
          }
          continue;
          try
          {
            MMApplicationContext.getContext().unregisterReceiver(q.o(q.this));
          }
          catch (Exception paramAnonymousrh)
          {
            Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver unregister error %s", new Object[] { paramAnonymousrh.fillInStackTrace() });
          }
        }
      }
    };
    this.hXn = new IListener() {};
    EventCenter.instance.addListener(this.hXn);
    EventCenter.instance.addListener(this.zNi);
    this.zMR = false;
    AppMethodBeat.o(114486);
  }
  
  public static boolean Rj(int paramInt)
  {
    AppMethodBeat.i(239409);
    if (!ac.eom().ens())
    {
      boolean bool = ac.eol().zMd.aqv(paramInt);
      AppMethodBeat.o(239409);
      return bool;
    }
    com.tencent.mm.plugin.multitalk.b.p localp = com.tencent.mm.plugin.multitalk.b.p.zHS;
    localp.aj(new p.36(localp, paramInt));
    AppMethodBeat.o(239409);
    return true;
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(114500);
    Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.zUd) && (paramBoolean))
    {
      paramo = new ca();
      paramo.setType(64);
      paramo.setCreateTime(System.currentTimeMillis());
      paramo.setStatus(6);
      paramo.setContent(MMApplicationContext.getContext().getString(2131763310));
      if (com.tencent.mm.model.v.HW(paramMultiTalkGroup.zHE))
      {
        paramo.Cy(paramMultiTalkGroup.zHE);
        paramo.setContent(paramo.field_content);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(paramo);
      }
    }
    AppMethodBeat.o(114500);
  }
  
  private void a(MultiTalkGroup paramMultiTalkGroup, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(239394);
    String str = v.k(paramMultiTalkGroup);
    p.iO(paramMultiTalkGroup.zHE, str);
    p.aFV(str);
    if (this.zMD != com.tencent.mm.plugin.multitalk.ui.widget.o.zUg)
    {
      paramBoolean3 = v.j(this.zME);
      long l = getTotalTime();
      int i = 0;
      if (paramBoolean3) {
        if (paramBoolean2) {
          i = 4;
        }
      }
      for (;;)
      {
        p.a(paramBoolean3, l, str, i);
        AppMethodBeat.o(239394);
        return;
        if (paramBoolean1)
        {
          i = 1;
        }
        else if (paramBoolean4)
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
          } else if (paramBoolean4) {
            i = 10;
          }
        }
      }
    }
    p.Rh(this.zMJ);
    p.z(this.zMJ, str);
    if (paramMultiTalkGroup.RHa != null) {
      p.Re(paramMultiTalkGroup.RHa.size());
    }
    AppMethodBeat.o(239394);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114493);
    if (!ems())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { v.g(paramMultiTalkGroup) });
      this.zME = paramMultiTalkGroup;
      this.zMJ = 0;
      this.zMx = 1;
      this.zMC.clear();
      enu();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    Object localObject1 = this.zME;
    int i;
    if ((paramMultiTalkGroup == null) || (localObject1 == null)) {
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { v.g(paramMultiTalkGroup) });
      Object localObject2 = this.zME;
      localObject1 = new HashMap();
      Object localObject3 = paramMultiTalkGroup.RHa.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject3).next();
          ((HashMap)localObject1).put(localMultiTalkGroupMember.RHb, localMultiTalkGroupMember);
          continue;
          if ((!Util.isNullOrNil(paramMultiTalkGroup.zHD)) && (!Util.isNullOrNil(((MultiTalkGroup)localObject1).zHD)) && (paramMultiTalkGroup.zHD.equals(((MultiTalkGroup)localObject1).zHD)))
          {
            i = 1;
            break;
          }
          if ((!Util.isNullOrNil(paramMultiTalkGroup.RGY)) && (!Util.isNullOrNil(((MultiTalkGroup)localObject1).RGY)) && (paramMultiTalkGroup.RGY.equals(((MultiTalkGroup)localObject1).RGY)))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      localObject2 = ((MultiTalkGroup)localObject2).RHa.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiTalkGroupMember)((Iterator)localObject2).next();
        if ((!com.tencent.mm.model.z.aTY().equals(((MultiTalkGroupMember)localObject3).RHb)) && (com.tencent.mm.model.z.aTY().equals(((MultiTalkGroupMember)localObject3).RHc)) && (((MultiTalkGroupMember)localObject3).status == 1) && ((!((HashMap)localObject1).containsKey(((MultiTalkGroupMember)localObject3).RHb)) || (((MultiTalkGroupMember)((HashMap)localObject1).get(((MultiTalkGroupMember)localObject3).RHb)).status == 20)))
        {
          localObject3 = ((MultiTalkGroupMember)localObject3).RHb;
          localObject3 = MMApplicationContext.getContext().getString(2131763304, new Object[] { aa.getDisplayName((String)localObject3) });
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)localObject3);
          Toast.makeText(MMApplicationContext.getContext(), (CharSequence)localObject3, 0).show();
        }
      }
      this.zME = paramMultiTalkGroup;
      enu();
      sort();
      AppMethodBeat.o(114493);
      return true;
    }
    Log.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { v.g(this.zME), v.g(paramMultiTalkGroup) });
    AppMethodBeat.o(114493);
    return false;
  }
  
  private static String aGb(String paramString)
  {
    AppMethodBeat.i(239402);
    String str2 = aa.getDisplayName(paramString);
    String str1 = paramString;
    if (str2 != null) {
      if (!str2.equals("")) {
        break label64;
      }
    }
    label64:
    for (str1 = paramString;; str1 = str2)
    {
      paramString = str1 + MMApplicationContext.getContext().getString(2131763308);
      AppMethodBeat.o(239402);
      return paramString;
    }
  }
  
  public static void aGd(String paramString)
  {
    AppMethodBeat.i(114499);
    Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    ca localca = new ca();
    localca.setType(64);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(6);
    localca.setContent(MMApplicationContext.getContext().getString(2131763310));
    if (com.tencent.mm.model.v.HW(paramString))
    {
      localca.Cy(paramString);
      localca.setContent(localca.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
    }
    AppMethodBeat.o(114499);
  }
  
  private void af(String arg1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(239388);
    Object localObject1 = Util.stringsToList(???.split(","));
    Object localObject2;
    Object localObject3;
    Object localObject4;
    synchronized (this.zNa)
    {
      if (this.zMD != com.tencent.mm.plugin.multitalk.ui.widget.o.zUc)
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "already in multitalk! cannot start again, status:%s", new Object[] { this.zMD.toString() });
        AppMethodBeat.o(239388);
        return;
      }
      if (paramInt != 2) {
        break label231;
      }
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = new j();
        ((j)localObject4).goe = ((String)localObject3);
        ((j)localObject4).mStatus = 2;
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    com.tencent.mm.plugin.multitalk.b.p.zHS.y(Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
    com.tencent.mm.plugin.multitalk.b.p.zHS.e((ArrayList)localObject2, paramString2);
    eM(paramString2, 2);
    b(com.tencent.mm.plugin.multitalk.ui.widget.o.zUe);
    boolean bool = true;
    if (bool) {
      p.emV();
    }
    for (;;)
    {
      paramString2 = com.tencent.mm.plugin.multitalk.d.d.zZa;
      com.tencent.mm.plugin.multitalk.d.d.reset();
      AppMethodBeat.o(239388);
      return;
      label231:
      localObject2 = new MultiTalkGroup();
      ((MultiTalkGroup)localObject2).RGY = ac.eol().zMd.hju();
      ((MultiTalkGroup)localObject2).zHE = paramString2;
      localObject3 = ((List)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.RHb = ((String)localObject4);
        if (((String)localObject4).equals(com.tencent.mm.model.z.aTY())) {}
        for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
        {
          ((MultiTalkGroup)localObject2).RHa.add(localMultiTalkGroupMember);
          break;
        }
      }
      ac.eol().zMd.dr(Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
      bool = ac.eol().zMd.a(((MultiTalkGroup)localObject2).RGY, paramString2, (List)localObject1, v2protocal.fJa());
      eM(paramString2, 1);
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.zUe);
      a((MultiTalkGroup)localObject2, Boolean.TRUE);
      break;
      p.emW();
    }
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.o paramo)
  {
    boolean bool = true;
    AppMethodBeat.i(114525);
    Object localObject = this.zMD;
    this.zMD = paramo;
    if (localObject != paramo) {
      if (paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.zUg)
      {
        localObject = new rh();
        ((rh)localObject).dXY.type = 1;
        EventCenter.instance.publish((IEvent)localObject);
        p.a(v.j(this.zME), getTotalTime(), v.k(this.zME));
        ac.eom().stopRing();
        com.tencent.mm.plugin.audio.c.a.setMode(3);
        if ((com.tencent.mm.plugin.audio.c.a.cdW()) || (com.tencent.mm.plugin.audio.c.a.ceb())) {
          break label133;
        }
      }
    }
    for (;;)
    {
      rJ(bool);
      ac.eol().rz(bool);
      if (this.zLR != null) {
        this.zLR.a(paramo);
      }
      AppMethodBeat.o(114525);
      return;
      label133:
      bool = false;
    }
  }
  
  private void bUm()
  {
    AppMethodBeat.i(114527);
    if (this.dfh != null)
    {
      this.dfh.cancel();
      this.dfh = null;
    }
    AppMethodBeat.o(114527);
  }
  
  private void bpu()
  {
    AppMethodBeat.i(114526);
    Log.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.dfh != null)
    {
      this.dfh.cancel();
      AppMethodBeat.o(114526);
      return;
    }
    this.zMI = System.currentTimeMillis();
    this.zMJ = 0;
    this.dfh = new Timer();
    TimerTask local4 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(239373);
        if ((q.this.getTotalTime() >= 45000L) && (q.m(q.this) != com.tencent.mm.plugin.multitalk.ui.widget.o.zUg)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(239371);
              q.this.j(false, true, false);
              AppMethodBeat.o(239371);
            }
          });
        }
        if (q.m(q.this) == com.tencent.mm.plugin.multitalk.ui.widget.o.zUg)
        {
          q.n(q.this);
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(239372);
              if (q.m(q.this) == com.tencent.mm.plugin.multitalk.ui.widget.o.zUg)
              {
                Object localObject1 = ac.eon();
                int i = q.this.zMJ;
                localObject1 = ((n)localObject1).zTM;
                if (localObject1 != null)
                {
                  Object localObject2 = kotlin.g.b.ae.SYK;
                  localObject2 = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }, 2));
                  kotlin.g.b.p.g(localObject2, "java.lang.String.format(format, *args)");
                  ((com.tencent.mm.plugin.multitalk.ui.widget.m)localObject1).aGy((String)localObject2);
                }
                if (q.k(q.this) != null) {
                  q.k(q.this).eaa();
                }
              }
              AppMethodBeat.o(239372);
            }
          });
        }
        AppMethodBeat.o(239373);
      }
    };
    this.dfh.schedule(local4, 1000L, 1000L);
    AppMethodBeat.o(114526);
  }
  
  private void enC()
  {
    AppMethodBeat.i(114504);
    if (this.zMD == com.tencent.mm.plugin.multitalk.ui.widget.o.zUe) {}
    for (;;)
    {
      boolean bool = false;
      for (q localq = this;; localq = this)
      {
        localq.mkd = bool;
        this.guh = false;
        this.zMQ = v.enY();
        AppMethodBeat.o(114504);
        return;
        if ((com.tencent.mm.plugin.audio.c.a.cdW()) || (com.tencent.mm.plugin.audio.c.a.ceb())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void enD()
  {
    AppMethodBeat.i(114508);
    if (v.h(this.zME)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.zUg);
    }
    while (this.zLR != null)
    {
      this.zLR.eie();
      localObject = v.enY();
      if (localObject != this.zMQ) {
        this.zMQ = ((v.a)localObject);
      }
      AppMethodBeat.o(114508);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.zUf);
    }
    Object localObject = new Intent();
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(114508);
  }
  
  private void enK()
  {
    AppMethodBeat.i(114519);
    try
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.oD(26)) && (this.zMU))
      {
        MMApplicationContext.getContext().unbindService(this);
        this.zMU = false;
      }
      AppMethodBeat.o(114519);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MT.MultiTalkManager", localException, "unBind VoipSmallService error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(114519);
    }
  }
  
  private static boolean enQ()
  {
    AppMethodBeat.i(114530);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
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
        Log.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
  
  public static void enR()
  {
    AppMethodBeat.i(178891);
    n localn = ac.eon();
    if ((localn.zTM != null) && (!localn.zTO))
    {
      com.tencent.f.h.RTc.bqo("showIcon");
      com.tencent.f.h.RTc.b((Runnable)new n.f(localn), "showIcon");
    }
    AppMethodBeat.o(178891);
  }
  
  public static boolean enp()
  {
    AppMethodBeat.i(239382);
    if (ac.eom().zMC.contains(com.tencent.mm.model.z.aTY())) {}
    for (int i = 1;; i = 0)
    {
      if (ac.eom().zMC.size() > i)
      {
        AppMethodBeat.o(239382);
        return true;
      }
      AppMethodBeat.o(239382);
      return false;
    }
  }
  
  private void enu()
  {
    AppMethodBeat.i(114495);
    Iterator localIterator = this.zME.RHa.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.zMC.remove(localMultiTalkGroupMember.RHb))) {
        Log.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.RHb });
      }
    }
    AppMethodBeat.o(114495);
  }
  
  private h env()
  {
    AppMethodBeat.i(239395);
    if (this.zMW == null) {
      this.zMW = new t();
    }
    t localt = this.zMW;
    AppMethodBeat.o(239395);
    return localt;
  }
  
  private void eny()
  {
    AppMethodBeat.i(239398);
    if (this.zMX == null)
    {
      AppMethodBeat.o(239398);
      return;
    }
    this.zMX.close();
    this.zMX = null;
    AppMethodBeat.o(239398);
  }
  
  private static boolean isAppOnForeground(Context paramContext)
  {
    AppMethodBeat.i(114531);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      Log.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
        AppMethodBeat.o(114531);
        return false;
      }
    }
    if (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(114531);
      return false;
    }
    Log.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
    AppMethodBeat.o(114531);
    return true;
  }
  
  private void k(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(239393);
    a(this.zME, paramBoolean1, paramBoolean2, false, paramBoolean3);
    AppMethodBeat.o(239393);
  }
  
  private void rH(boolean paramBoolean)
  {
    AppMethodBeat.i(239400);
    if (this.zMY == null)
    {
      AppMethodBeat.o(239400);
      return;
    }
    this.zMY.aa(paramBoolean);
    if (!paramBoolean) {
      this.zMY = null;
    }
    AppMethodBeat.o(239400);
  }
  
  private void sort()
  {
    AppMethodBeat.i(114494);
    Log.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.zME.RHa });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.zME.RHa.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.RHb.equals(com.tencent.mm.model.z.aTY())) {
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
    this.zME.RHa = localLinkedList;
    Log.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.zME.RHa });
    AppMethodBeat.o(114494);
  }
  
  public final void Rd(int paramInt)
  {
    AppMethodBeat.i(239405);
    h localh = env();
    if (localh != null) {
      localh.Rd(paramInt);
    }
    AppMethodBeat.o(239405);
  }
  
  public final void Ri(int paramInt)
  {
    AppMethodBeat.i(114515);
    Log.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.zMR = true;
      AppMethodBeat.o(114515);
      return;
    }
    this.zMR = false;
    AppMethodBeat.o(114515);
  }
  
  public final boolean Zx()
  {
    return this.guh;
  }
  
  public final void a(e parame)
  {
    this.zLR = parame;
  }
  
  public final void a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(114503);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      enJ();
      this.zMv = false;
      enC();
      bpu();
      Intent localIntent = new Intent();
      RemoteViews localRemoteViews = null;
      String str = "";
      if (!paramBoolean.booleanValue())
      {
        if ((com.tencent.mm.compatible.util.d.oF(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
          i = 1;
        }
        if (i != 0) {
          this.zNe = new a(paramMultiTalkGroup, Boolean.FALSE);
        }
        paramBoolean = MMApplicationContext.getResources().getString(2131763270);
        localIntent.putExtra("Voip_User", v.l(paramMultiTalkGroup));
        paramMultiTalkGroup = aa.getDisplayName(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localIntent.getStringExtra("Voip_User")).field_username);
        localRemoteViews = new RemoteViews(MMApplicationContext.getPackageName(), 2131496857);
        localRemoteViews.setTextViewText(2131305550, paramBoolean);
        localRemoteViews.setTextViewText(2131305549, paramMultiTalkGroup);
        localRemoteViews.setImageViewResource(2131310423, 2131235720);
        localRemoteViews.setImageViewResource(2131305544, 2131235444);
        str = paramMultiTalkGroup + paramBoolean;
      }
      com.tencent.mm.util.a.a(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", localIntent, localRemoteViews, str, com.tencent.mm.bq.a.glD());
    }
    AppMethodBeat.o(114503);
  }
  
  public final boolean aF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239408);
    if (paramBoolean)
    {
      if (ent())
      {
        this.zNf = true;
        this.zMx = paramInt;
        if (!ac.eom().ens())
        {
          paramBoolean = ac.eol().zMd.aqv(paramInt);
          AppMethodBeat.o(239408);
          return paramBoolean;
        }
        AppMethodBeat.o(239408);
        return true;
      }
      AppMethodBeat.o(239408);
      return false;
    }
    if (ent())
    {
      this.zNf = false;
      paramBoolean = ac.eom().ens();
      Log.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + paramInt + ", isILink:" + paramBoolean);
      if (paramBoolean) {
        break label238;
      }
      paramBoolean = ac.eol().zMd.aqv(paramInt);
      if (v.Rm(this.zMx)) {
        enL();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      int i = this.zMx;
      this.zMx = paramInt;
      if ((this.zLR != null) && (i != this.zMx)) {
        this.zLR.hh(i, this.zMx);
      }
      AppMethodBeat.o(239408);
      return paramBoolean;
      enM();
      continue;
      AppMethodBeat.o(239408);
      return false;
      label238:
      paramBoolean = false;
    }
  }
  
  public final void aFS(String paramString)
  {
    AppMethodBeat.i(239389);
    if (this.zLR != null) {
      this.zLR.aFS(paramString);
    }
    AppMethodBeat.o(239389);
  }
  
  public final boolean aFW(String paramString)
  {
    AppMethodBeat.i(239383);
    String str = paramString;
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.zME.zHD;
      str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = this.zME.RGY;
      }
    }
    if (this.zNb.containsKey(str)) {}
    for (int i = ((Integer)this.zNb.get(str)).intValue();; i = 0)
    {
      if (i == 2)
      {
        AppMethodBeat.o(239383);
        return true;
      }
      AppMethodBeat.o(239383);
      return false;
    }
  }
  
  public final void aFX(String paramString)
  {
    AppMethodBeat.i(239386);
    Log.i("MicroMsg.MT.MultiTalkManager", "removeCurrentMTSDKMode groupid:%s", new Object[] { paramString });
    if ((this.zNb != null) && (this.zNb.containsKey(paramString))) {
      this.zNb.remove(paramString);
    }
    AppMethodBeat.o(239386);
  }
  
  public final void aFY(String paramString)
  {
    AppMethodBeat.i(239390);
    if (this.zLR != null) {
      this.zLR.aFT(paramString);
    }
    AppMethodBeat.o(239390);
  }
  
  public final boolean aFZ(String paramString)
  {
    AppMethodBeat.i(239391);
    ArrayList localArrayList = new ArrayList(this.zNc);
    if (localArrayList.contains(paramString))
    {
      AppMethodBeat.o(239391);
      return true;
    }
    localArrayList.add(paramString);
    this.zNc = new CopyOnWriteArrayList(localArrayList);
    AppMethodBeat.o(239391);
    return false;
  }
  
  public final void aGa(String paramString)
  {
    AppMethodBeat.i(239392);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zNc.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.equals(paramString)) {
        localArrayList.add(str);
      }
    }
    this.zNc = new CopyOnWriteArrayList(localArrayList);
    AppMethodBeat.o(239392);
  }
  
  public final void aGc(String paramString)
  {
    AppMethodBeat.i(239403);
    ca localca = new ca();
    localca.setType(64);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(6);
    localca.setContent(MMApplicationContext.getContext().getString(2131763307));
    if (com.tencent.mm.model.v.HW(paramString))
    {
      localca.Cy(paramString);
      localca.setContent(localca.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
    }
    if ((this.zMS != null) && (paramString.equals(this.zMS.zHE)) && (!this.zNd.stopped()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
      this.zMS = null;
      this.zMT = 0L;
      this.zNd.stopTimer();
    }
    AppMethodBeat.o(239403);
  }
  
  public final boolean aGe(String paramString)
  {
    AppMethodBeat.i(114524);
    if (ent())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      if (ens())
      {
        if (paramString.equals(""))
        {
          this.zLR.emw();
          Log.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe small video of visiable region OK!");
        }
        for (;;)
        {
          AppMethodBeat.o(114524);
          return true;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramString);
          paramString = com.tencent.mm.plugin.multitalk.b.p.zHS;
          paramString.aj(new p.29(paramString, localArrayList));
          Log.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe large video OK, mems:".concat(String.valueOf(localArrayList)));
        }
      }
      boolean bool = ac.eol().zMd.aGe(paramString);
      Log.i("MicroMsg.MT.MultiTalkManager", "result of old subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(114524);
      return bool;
    }
    AppMethodBeat.o(114524);
    return false;
  }
  
  public final void b(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114502);
    boolean bool2 = this.guh;
    boolean bool3 = this.mkd;
    boolean bool4 = this.zMy;
    Object localObject = this.zMD.toString();
    if (this.zME == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      p.enb();
      if ((com.tencent.mm.n.g.apP()) || (isAppOnForeground(MMApplicationContext.getContext()))) {
        break;
      }
      Log.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.zMS == null) && (this.zNd.stopped()))
      {
        this.zMS = paramMultiTalkGroup;
        this.zNd.startTimer(2000L);
        this.zMT = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(114502);
      return;
    }
    localObject = v.l(paramMultiTalkGroup);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject);
    if ((!com.tencent.mm.bh.e.bgI()) || (localas == null) || (localas.ary()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239381);
          String str2 = paramMultiTalkGroup.zHD;
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.RGY;
          }
          ac.eol().zMd.aFM(str1);
          AppMethodBeat.o(239381);
        }
      }, 1000L);
      p.bI(3, v.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if ((ems()) || (com.tencent.mm.plugin.voip.b.m.isVoipStarted()) || (com.tencent.mm.plugin.voip.b.m.fKH()) || (com.tencent.mm.bh.e.bgH()) || (com.tencent.mm.bh.e.isCalling()) || (com.tencent.mm.plugin.voip.b.m.fKI()) || (!com.tencent.mm.contact.c.oR(localas.field_type)))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
      if (!com.tencent.mm.model.v.HU(paramMultiTalkGroup.zHE))
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.zHE });
        ay.a.iDq.a(paramMultiTalkGroup.zHE, "", new ay.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
        });
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114485);
          String str2 = paramMultiTalkGroup.zHD;
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.RGY;
          }
          ac.eol().zMd.aFM(str1);
          AppMethodBeat.o(114485);
        }
      }, 1000L);
      p.bI(3, v.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if (!com.tencent.mm.model.v.HU(paramMultiTalkGroup.zHE))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.zHE });
      ay.a.iDq.a(paramMultiTalkGroup.zHE, "", null);
    }
    Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.o.zUd);
    p.bI(1, v.k(paramMultiTalkGroup));
    if ((!com.tencent.mm.contact.c.oR(localas.field_type)) || (com.tencent.mm.q.a.atu()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { localObject, com.tencent.mm.model.z.aTY() });
      if (a(paramMultiTalkGroup))
      {
        this.zMv = false;
        enC();
        bpu();
        AppMethodBeat.o(114502);
      }
    }
    else
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { localObject, com.tencent.mm.model.z.aTY() });
      localObject = new mu();
      ((mu)localObject).dSs.action = 3;
      EventCenter.instance.publish((IEvent)localObject);
      a(paramMultiTalkGroup, Boolean.FALSE);
    }
    AppMethodBeat.o(114502);
  }
  
  public final void bR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(239410);
    if (ens())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast exit due to ILINK mode!!!");
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString)) {
        localArrayList.add(paramString);
      }
      com.tencent.mm.plugin.multitalk.b.p.zHS.d(localArrayList, paramBoolean);
      AppMethodBeat.o(239410);
      return;
    }
    if (this.zMF == null) {
      this.zMF = new z();
    }
    this.zMF.a(enz());
    if (TextUtils.isEmpty(paramString))
    {
      this.zMF.eof();
      AppMethodBeat.o(239410);
      return;
    }
    Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast ownerUserName : ".concat(String.valueOf(paramString)));
    this.zMF.aGm(paramString);
    Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast error");
    AppMethodBeat.o(239410);
  }
  
  public final void c(Activity paramActivity, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(114496);
    boolean bool2 = this.guh;
    boolean bool3 = this.mkd;
    boolean bool4 = this.zMy;
    Object localObject1 = this.zMD.toString();
    if (this.zME == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject1, Boolean.valueOf(bool1) });
      p.ena();
      if (!enQ()) {
        break;
      }
      com.tencent.mm.ui.base.h.n(paramActivity, 2131761778, 2131755998);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.m.fKH())
    {
      com.tencent.mm.ui.base.h.n(paramActivity, 2131761782, 2131755998);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.m.isVoipStarted())
    {
      com.tencent.mm.ui.base.h.n(paramActivity, 2131761781, 2131755998);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.bh.e.bgH())
    {
      com.tencent.mm.ui.base.h.n(paramActivity, 2131761777, 2131755998);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.b.m.fKI())
    {
      com.tencent.mm.ui.base.h.n(paramActivity, 2131761780, 2131755998);
      AppMethodBeat.o(114496);
      return;
    }
    if (ems())
    {
      com.tencent.mm.bh.e.a(paramActivity, 2131763265, null);
      AppMethodBeat.o(114496);
      return;
    }
    if ((this.zMN) && (System.currentTimeMillis() - this.zMO < this.zMP))
    {
      com.tencent.mm.bh.e.a(paramActivity, 2131763289, null);
      AppMethodBeat.o(114496);
      return;
    }
    this.zMN = false;
    Object localObject3 = Util.stringsToList(paramString1.split(","));
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soa, 0);
    Log.i("MicroMsg.MT.MultiTalkManager", "getMultiTalkSDKMode sdk mode:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      af(paramString1, paramString2, 2);
      AppMethodBeat.o(114496);
      return;
    }
    paramActivity = com.tencent.mm.plugin.multitalk.b.p.zHS;
    paramString1 = new com.tencent.mm.plugin.multitalk.b.b() {};
    Object localObject2 = new d.a();
    ((d.a)localObject2).iLN = new ern();
    ((d.a)localObject2).iLO = new ero();
    ((d.a)localObject2).funcId = 5949;
    ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/voipmtgetsdkmode";
    ((d.a)localObject2).iLP = 0;
    ((d.a)localObject2).respCmdId = 0;
    localObject1 = new LinkedList();
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      esc localesc = new esc();
      localesc.username = str;
      ((LinkedList)localObject1).add(localesc);
    }
    localObject2 = ((d.a)localObject2).aXF();
    localObject3 = (ern)((com.tencent.mm.ak.d)localObject2).iLK.iLR;
    ((ern)localObject3).Npf = ((LinkedList)localObject1);
    ((ern)localObject3).NoW = paramString2;
    IPCRunCgi.a((com.tencent.mm.ak.d)localObject2, new p.5(paramActivity, paramString1));
    AppMethodBeat.o(114496);
  }
  
  public final void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114505);
    p.bI(2, v.k(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.o.zUd, true);
    AppMethodBeat.o(114505);
  }
  
  public final boolean czl()
  {
    AppMethodBeat.i(239414);
    if (this.zMV != null)
    {
      boolean bool = this.zMV.hTl.YZ();
      AppMethodBeat.o(239414);
      return bool;
    }
    AppMethodBeat.o(239414);
    return true;
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114506);
    Log.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
    p.rF(true);
    if (a(paramMultiTalkGroup)) {
      enD();
    }
    AppMethodBeat.o(114506);
  }
  
  public final void d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114498);
    if (!com.tencent.mm.model.v.HU(paramString1))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      ay.a.iDq.a(paramString1, "", new ay.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    ca localca = new ca();
    localca.setType(64);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(6);
    localca.nv(2);
    paramString2 = aGb(paramString2);
    localca.setContent(paramString2);
    if (com.tencent.mm.model.v.HW(paramString1))
    {
      localca.Cy(paramString1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
      az localaz = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(paramString1);
      if (localaz != null)
      {
        if (paramBoolean1) {
          localaz.nt(localaz.field_unReadCount + 1);
        }
        localaz.setContent(paramString2);
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().a(localaz, paramString1) == -1) {
          Log.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
        }
        if (paramBoolean2)
        {
          ((ba)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localca);
          AppMethodBeat.o(114498);
        }
      }
      else
      {
        localaz = new az();
        localaz.setUsername(paramString1);
        if (paramBoolean1) {
          localaz.nt(1);
        }
        localaz.setContent(paramString2);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().e(localaz);
        if (paramBoolean2) {
          ((ba)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localca);
        }
      }
    }
    AppMethodBeat.o(114498);
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114507);
    Log.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
    rh localrh = new rh();
    localrh.dXY.type = 1;
    EventCenter.instance.publish(localrh);
    p.rG(true);
    if (this.zMD != com.tencent.mm.plugin.multitalk.ui.widget.o.zUd)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.zUf);
      a(paramMultiTalkGroup, Boolean.TRUE);
    }
    if ((ems()) && (a(paramMultiTalkGroup))) {
      enD();
    }
    AppMethodBeat.o(114507);
  }
  
  public final void eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(239385);
    Log.i("MicroMsg.MT.MultiTalkManager", "setCurrentMTSDKMode groupid:%s, mode:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.zNb == null)
    {
      AppMethodBeat.o(239385);
      return;
    }
    if ((!this.zNb.containsKey(paramString)) || (((Integer)this.zNb.get(paramString)).intValue() != paramInt)) {
      this.zNb.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(239385);
  }
  
  public final List<String> elR()
  {
    AppMethodBeat.i(239413);
    if (this.zME == null)
    {
      AppMethodBeat.o(239413);
      return null;
    }
    String str = this.zME.zHD;
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = this.zME.RGY;
    }
    boolean bool = aFW(this.zME.zHE);
    Log.d("MicroMsg.MT.MultiTalkManager", "getTalkingMember: %s, groupid:%s, isILink:%b", new Object[] { v.g(this.zME), this.zME.zHE, Boolean.valueOf(bool) });
    new ArrayList();
    if (bool) {}
    for (localObject = com.tencent.mm.plugin.multitalk.b.p.zHS.elR();; localObject = ac.eol().zMd.bpM((String)localObject))
    {
      AppMethodBeat.o(239413);
      return localObject;
    }
  }
  
  public final boolean emr()
  {
    AppMethodBeat.i(114491);
    if (this.zMD == com.tencent.mm.plugin.multitalk.ui.widget.o.zUg) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114491);
      return bool;
    }
  }
  
  public final boolean ems()
  {
    AppMethodBeat.i(114489);
    if ((this.zMD != com.tencent.mm.plugin.multitalk.ui.widget.o.zUc) && (this.zME != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114489);
      return bool;
    }
  }
  
  public final void emx()
  {
    AppMethodBeat.i(239415);
    if ((ac.eom().ent()) && (this.zLR != null))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "exitProjectScreen");
      this.zLR.emx();
    }
    AppMethodBeat.o(239415);
  }
  
  public final a enA()
  {
    AppMethodBeat.i(239401);
    if (this.zMZ == null) {
      this.zMZ = new a();
    }
    a locala = this.zMZ;
    AppMethodBeat.o(239401);
    return locala;
  }
  
  public final void enB()
  {
    AppMethodBeat.i(162239);
    this.zNe = null;
    this.zMM = false;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162239);
  }
  
  public final void enE()
  {
    AppMethodBeat.i(114510);
    Log.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(114510);
  }
  
  public final void enF()
  {
    AppMethodBeat.i(114513);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.zMx) });
    AppMethodBeat.o(114513);
  }
  
  public final void enG()
  {
    AppMethodBeat.i(114514);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(114514);
  }
  
  public final void enH()
  {
    AppMethodBeat.i(178889);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
    AppMethodBeat.o(178889);
  }
  
  public final void enI()
  {
    AppMethodBeat.i(239404);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeScreenSharingVideoSuss ");
    AppMethodBeat.o(239404);
  }
  
  public final void enJ()
  {
    AppMethodBeat.i(239406);
    this.zMV = new com.tencent.mm.plugin.multitalk.a.a();
    if (this.mkd) {
      this.zMV.cV(true);
    }
    com.tencent.mm.plugin.multitalk.a.a.elz();
    AppMethodBeat.o(239406);
  }
  
  public final void enL()
  {
    AppMethodBeat.i(114520);
    Log.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (ens())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver exit due to ILINK mode!!!");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.zLR == null)
    {
      Log.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.zMC.size() == 0)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.zMF == null)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkDataSource: NetworkDataSource is null %d", new Object[] { Integer.valueOf(this.zMC.size()) });
      this.zMF = new z();
    }
    this.zMF.a(enz());
    this.zMF.start();
    if (enA().emb())
    {
      Object localObject = enA().zKR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).zQT;
        if (localObject != null)
        {
          String str = ((MultitalkFrameView)localObject).getUsername();
          localObject = str;
          if (str != null) {
            break label195;
          }
        }
      }
      localObject = "";
      label195:
      bR((String)localObject, false);
    }
    AppMethodBeat.o(114520);
  }
  
  public final void enM()
  {
    AppMethodBeat.i(114521);
    Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
    if (this.zMF != null)
    {
      this.zMF.stop();
      this.zMF = null;
    }
    AppMethodBeat.o(114521);
  }
  
  public final void enN()
  {
    AppMethodBeat.i(239411);
    if (this.zMF == null) {
      this.zMF = new z();
    }
    this.zMF.a(enz());
    this.zMF.start();
    ac.eom().enx().rQ(true);
    AppMethodBeat.o(239411);
  }
  
  public final boolean enO()
  {
    return this.zMR;
  }
  
  public final boolean enP()
  {
    return this.zMy;
  }
  
  public final boolean enS()
  {
    return this.zMw;
  }
  
  public final void enm()
  {
    this.zLR = null;
  }
  
  public final MultiTalkGroup enn()
  {
    return this.zME;
  }
  
  public final boolean eno()
  {
    AppMethodBeat.i(114487);
    boolean bool = v.Rl(this.zMx);
    AppMethodBeat.o(114487);
    return bool;
  }
  
  public final boolean enq()
  {
    return this.mkd;
  }
  
  public final HashSet<String> enr()
  {
    return this.zMC;
  }
  
  public final boolean ens()
  {
    AppMethodBeat.i(239384);
    if (this.zME != null)
    {
      boolean bool = aFW(this.zME.zHE);
      AppMethodBeat.o(239384);
      return bool;
    }
    AppMethodBeat.o(239384);
    return false;
  }
  
  public final boolean ent()
  {
    AppMethodBeat.i(114490);
    if ((this.zMD == com.tencent.mm.plugin.multitalk.ui.widget.o.zUf) || (this.zMD == com.tencent.mm.plugin.multitalk.ui.widget.o.zUg)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114490);
      return bool;
    }
  }
  
  public final t enw()
  {
    AppMethodBeat.i(239396);
    if (this.zMW == null) {
      this.zMW = new t();
    }
    t localt = this.zMW;
    AppMethodBeat.o(239396);
    return localt;
  }
  
  public final af enx()
  {
    AppMethodBeat.i(239397);
    if (this.zMX == null) {
      this.zMX = new ag(ac.eol().zMd);
    }
    ag localag = this.zMX;
    AppMethodBeat.o(239397);
    return localag;
  }
  
  public final ae enz()
  {
    AppMethodBeat.i(239399);
    if (this.zMY == null) {
      this.zMY = new ae();
    }
    ae localae = this.zMY;
    AppMethodBeat.o(239399);
    return localae;
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114509);
    Log.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { v.g(paramMultiTalkGroup) });
    if ((ems()) && (a(paramMultiTalkGroup)))
    {
      if (!v.i(this.zME))
      {
        if (this.zMD == com.tencent.mm.plugin.multitalk.ui.widget.o.zUd)
        {
          j(false, true, false);
          AppMethodBeat.o(114509);
          return;
        }
        j(false, false, false);
        AppMethodBeat.o(114509);
        return;
      }
      if ((this.zMD != com.tencent.mm.plugin.multitalk.ui.widget.o.zUg) && (v.h(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.o.zUg);
      }
      if ((this.zLR != null) && (v.c(this.zMD))) {
        this.zLR.emu();
      }
    }
    AppMethodBeat.o(114509);
  }
  
  public final void fA(List<String> paramList)
  {
    AppMethodBeat.i(239387);
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    if (ems())
    {
      localObject2 = this.zME.zHD;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = this.zME.RGY;
      }
      boolean bool = aFW(this.zME.zHE);
      Log.i("MicroMsg.MT.MultiTalkManager", "addMemberList: %s, wifigateway:%d, groupid:%s, isILink:%b", new Object[] { v.g(this.zME), Integer.valueOf(v2protocal.fJa()), this.zME.zHE, Boolean.valueOf(bool) });
      if (bool)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.b.p.zHS;
        localObject2 = new LinkedList();
        localArrayList = ((com.tencent.mm.plugin.multitalk.b.p)localObject1).zHs.elF();
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
        } while ((!str.equals(localj.goe)) || ((localj.mStatus != 1) && (localj.mStatus != 2) && (localj.mStatus != 3)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label295;
        }
        ((LinkedList)localObject2).add(str);
        break;
        IPCRunCgi.a(com.tencent.mm.plugin.multitalk.b.i.bd((LinkedList)localObject2), new p.21((com.tencent.mm.plugin.multitalk.b.p)localObject1));
        AppMethodBeat.o(239387);
        return;
        ac.eol().zMd.Q((String)localObject1, paramList);
        AppMethodBeat.o(239387);
        return;
      }
    }
  }
  
  public final boolean fB(List<a.ar> paramList)
  {
    AppMethodBeat.i(239412);
    if (ent())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(paramList)));
      boolean bool = ac.eol().zMd.fB(paramList);
      Log.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(239412);
      return bool;
    }
    AppMethodBeat.o(239412);
    return false;
  }
  
  public final void fz(List<a.as> paramList)
  {
    AppMethodBeat.i(114516);
    if (ems())
    {
      this.zMC.clear();
      Log.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.as localas = (a.as)((Iterator)localObject).next();
        if ((localas.videoStatus == 2) || (localas.videoStatus == 3)) {
          this.zMC.add(localas.dLN);
        }
      }
      localObject = env();
      if (localObject != null) {
        ((h)localObject).fz(paramList);
      }
      Log.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.zMC });
      if (this.zLR != null)
      {
        this.zLR.emv();
        AppMethodBeat.o(114516);
        return;
      }
      Log.e("MicroMsg.MT.MultiTalkManager", "uiCallback is NULL !!!");
    }
    AppMethodBeat.o(114516);
  }
  
  public final long getTotalTime()
  {
    AppMethodBeat.i(114492);
    long l1 = System.currentTimeMillis();
    long l2 = this.zMI;
    AppMethodBeat.o(114492);
    return l1 - l2;
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(114497);
    Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    env().close();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    ac.eom().stopRing();
    Object localObject;
    if (ems())
    {
      localObject = new rh();
      ((rh)localObject).dXY.type = 2;
      EventCenter.instance.publish((IEvent)localObject);
      k(paramBoolean1, paramBoolean2, paramBoolean3);
      localObject = this.zMD;
      if (this.zLR != null) {
        this.zLR.emt();
      }
      this.zMG = false;
      this.zMH = false;
      this.zMD = com.tencent.mm.plugin.multitalk.ui.widget.o.zUc;
      enM();
      eny();
      rH(false);
      this.zMZ = null;
      qm(true);
      bUm();
      if (this.zMV != null)
      {
        this.zMV.elB();
        com.tencent.mm.plugin.multitalk.a.a.unInit();
      }
      ac.eok().reset();
      if (this.zME != null)
      {
        a(this.zME, (com.tencent.mm.plugin.multitalk.ui.widget.o)localObject, paramBoolean2);
        String str = this.zME.zHD;
        localObject = str;
        if (Util.isNullOrNil(str)) {
          localObject = this.zME.RGY;
        }
        Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isILinkMode %b", new Object[] { Boolean.valueOf(ens()) });
        com.tencent.mm.plugin.multitalk.b.p.zHS.Rb(1);
        ac.eol().zMd.aFM((String)localObject);
        this.zME = null;
        this.zMx = 0;
        this.mkd = true;
        this.guh = false;
        this.zMy = true;
        this.zMI = 0L;
        this.zMJ = 0;
        this.zMC.clear();
        localObject = new fn();
        EventCenter.instance.publish((IEvent)localObject);
        this.zMM = true;
      }
    }
    for (;;)
    {
      this.zNc.clear();
      localObject = com.tencent.mm.plugin.multitalk.d.d.zZa;
      com.tencent.mm.plugin.multitalk.d.d.report();
      enK();
      AppMethodBeat.o(114497);
      return;
      Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: currentMultiTalkGroup null");
      break;
      Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: not connecting, isHangupMultitalk %b", new Object[] { Boolean.valueOf(this.zMM) });
      if (!this.zMM)
      {
        enM();
        qm(false);
        bUm();
        if (this.zMV != null) {
          this.zMV.elB();
        }
        this.zME = null;
        this.zMx = 0;
        this.zMI = 0L;
        this.zMJ = 0;
        this.zMC.clear();
        this.zMD = com.tencent.mm.plugin.multitalk.ui.widget.o.zUc;
        this.zMK = 0;
      }
    }
  }
  
  public final void n(int paramInt, Object paramObject)
  {
    int j = 2131763246;
    AppMethodBeat.i(114501);
    Log.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogl, Integer.valueOf(-1));
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogm, Long.valueOf(-1L));
    int i;
    switch (paramInt)
    {
    default: 
      i = 2131763261;
    }
    for (;;)
    {
      if (this.zLR != null) {
        this.zLR.onError(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(i), 0).show();
        j(false, false, true);
      }
      AppMethodBeat.o(114501);
      return;
      p.rF(false);
      i = 2131763249;
      continue;
      p.rG(false);
      i = 2131763257;
      continue;
      i = 2131763258;
      continue;
      i = 2131763259;
      continue;
      i = 2131763260;
      continue;
      i = 2131763261;
      continue;
      i = 2131763262;
      continue;
      i = 2131763263;
      continue;
      i = 2131763264;
      continue;
      i = 2131763250;
      continue;
      i = 2131763251;
      continue;
      i = 2131763252;
      continue;
      j = 2131763253;
      this.zMN = true;
      this.zMO = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.ab)paramObject;
        i = j;
        if (paramObject != null)
        {
          Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.REQ);
          i = j;
          if (paramObject.REQ != 0)
          {
            this.zMP = (paramObject.REQ * 1000);
            i = j;
            continue;
            Log.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = 2131763255;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.ac)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.hqJ().Eh(false);
                i = j;
                continue;
                i = 2131763254;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.zME;
                if (this.zME != null) {}
                for (String str = this.zME.zHE;; str = "")
                {
                  Log.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.ac)paramObject;
                    if (paramObject != null)
                    {
                      Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.RDq != null)
                      {
                        ac.eop().aFO(paramObject.RDq.RFQ);
                        Log.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.RDq.RFQ);
                      }
                      if (!ac.eol().zMd.aFM(paramObject.groupId)) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = 2131763306;
                  break;
                }
                Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763246), 0).show();
                i = j;
                if (paramObject != null)
                {
                  int k = ((Integer)paramObject).intValue();
                  i = j;
                  if (k > 0)
                  {
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogl, Integer.valueOf(k));
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogm, Long.valueOf(Util.currentTicks()));
                    i = j;
                    continue;
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                    i = 2131763286;
                    continue;
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
                    AppMethodBeat.o(114501);
                    return;
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
                    i = 2131763256;
                    continue;
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
                    i = 2131763256;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void qm(boolean paramBoolean)
  {
    AppMethodBeat.i(178890);
    this.yon = false;
    if (paramBoolean) {
      ac.eon().eoN();
    }
    for (;;)
    {
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).cancel(43);
      enK();
      AppMethodBeat.o(178890);
      return;
      ac.eon().rX(false);
    }
  }
  
  public final void rI(boolean paramBoolean)
  {
    AppMethodBeat.i(114517);
    if (ems())
    {
      if (this.yon)
      {
        AppMethodBeat.o(114517);
        return;
      }
      p.j(v.enW(), v.Rl(ac.eom().zMx), paramBoolean);
      Toast.makeText(MMApplicationContext.getContext(), 2131763281, 0).show();
      Object localObject1 = MMApplicationContext.getContext().getString(2131763241);
      String str = MMApplicationContext.getContext().getString(2131763290);
      Object localObject2 = new Intent();
      if (this.zMA)
      {
        ((Intent)localObject2).putExtra("enterMainUIScreenProjectOnline", true);
        ((Intent)localObject2).putExtra("enterMainUIScreenProjectParams", this.zMB);
      }
      ((Intent)localObject2).setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, (Intent)localObject2, 134217728);
      int i = 2131234305;
      if (com.tencent.mm.compatible.util.d.oE(19)) {
        i = 2131234303;
      }
      localObject1 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(str).i(System.currentTimeMillis()).f((CharSequence)localObject1).g(str);
      ((s.c)localObject1).Hv = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.b.m.e((s.c)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
      if (this.zLR != null)
      {
        this.zLR.dZZ();
        this.yon = true;
      }
      eny();
      rH(true);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239368);
          Intent localIntent = new Intent();
          if (q.this.zMA)
          {
            localIntent.putExtra("enterMainUIScreenProjectOnline", true);
            localIntent.putExtra("enterMainUIScreenProjectParams", q.this.zMB);
          }
          localIntent.setFlags(268435456);
          Object localObject;
          if (q.f(q.this) != null)
          {
            localObject = q.f(q.this).zHE;
            localIntent.putExtra("enterMainUiWxGroupId", (String)localObject);
            localIntent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
            localIntent.putExtra("notification", this.zNk);
            localIntent.putExtra("enterMainUiSource", 1);
            localObject = ac.eon();
            com.tencent.mm.plugin.voip.ui.a local1 = new com.tencent.mm.plugin.voip.ui.a()
            {
              public final void a(Intent paramAnonymous2Intent, BaseSmallView paramAnonymous2BaseSmallView)
              {
                AppMethodBeat.i(239367);
                if (!q.this.emr())
                {
                  paramAnonymous2BaseSmallView.aGx(MMApplicationContext.getContext().getString(2131763321));
                  AppMethodBeat.o(239367);
                  return;
                }
                int i = q.this.zMJ;
                paramAnonymous2BaseSmallView.aGy(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
                AppMethodBeat.o(239367);
              }
              
              public final boolean dZV()
              {
                AppMethodBeat.i(239366);
                if ((q.this.ent()) || (q.this.emr()))
                {
                  AppMethodBeat.o(239366);
                  return true;
                }
                AppMethodBeat.o(239366);
                return false;
              }
            };
            ac.eom();
            boolean bool = q.enp();
            ((n)localObject).intent = localIntent;
            ((n)localObject).zTN = local1;
            if (com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
              break label213;
            }
            Log.e("MicroMsg.MultiTalkSmallWindow", "mini, permission denied");
            Context localContext = MMApplicationContext.getContext();
            RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131767297), (RequestFloatWindowPermissionDialog.a)new n.i((n)localObject, local1, localIntent, bool), com.tencent.mm.bq.a.apJ());
          }
          for (;;)
          {
            q.g(q.this);
            AppMethodBeat.o(239368);
            return;
            localObject = "";
            break;
            label213:
            ((n)localObject).aM(localIntent);
          }
        }
      });
    }
    AppMethodBeat.o(114517);
  }
  
  public final void rJ(boolean paramBoolean)
  {
    AppMethodBeat.i(114512);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (ens())
    {
      com.tencent.mm.plugin.multitalk.b.f localf = com.tencent.mm.plugin.multitalk.b.p.zHS.zHV;
      if (localf.zHq != null) {
        localf.zHq.zHu.kJ(paramBoolean);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mkd = paramBoolean;
      if (this.zLR != null) {
        this.zLR.rw(this.mkd);
      }
      AppMethodBeat.o(114512);
      return;
      ac.eol().zMd.rJ(paramBoolean);
    }
  }
  
  public final void rK(boolean paramBoolean)
  {
    AppMethodBeat.i(239407);
    if (ens())
    {
      com.tencent.mm.plugin.multitalk.b.p localp = com.tencent.mm.plugin.multitalk.b.p.zHS;
      Log.i("MicroMsg.Multitalk.ILinkService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localp.aj(new p.33(localp, paramBoolean));
    }
    for (;;)
    {
      rv(paramBoolean);
      AppMethodBeat.o(239407);
      return;
      ac.eol().zMd.rK(paramBoolean);
    }
  }
  
  public final void rL(boolean paramBoolean)
  {
    this.zMy = paramBoolean;
  }
  
  public final void rM(boolean paramBoolean)
  {
    AppMethodBeat.i(114528);
    if (this.zMv)
    {
      AppMethodBeat.o(114528);
      return;
    }
    if (this.zMV != null)
    {
      this.zMV.P(paramBoolean, 0);
      this.zMv = true;
    }
    AppMethodBeat.o(114528);
  }
  
  public final void rN(boolean paramBoolean)
  {
    AppMethodBeat.i(114533);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.zMw = paramBoolean;
    AppMethodBeat.o(114533);
  }
  
  public final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(114511);
    this.guh = paramBoolean;
    if (this.zLR != null) {
      this.zLR.rv(this.guh);
    }
    AppMethodBeat.o(114511);
  }
  
  public final void rx(boolean paramBoolean)
  {
    AppMethodBeat.i(114532);
    if ((ac.eom().ent()) && (this.zLR != null))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.zLR.rx(paramBoolean);
    }
    AppMethodBeat.o(114532);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(114529);
    if ((this.zMv) && (this.zMV != null))
    {
      this.zMV.elA();
      this.zMv = false;
    }
    AppMethodBeat.o(114529);
  }
  
  final class a
  {
    MultiTalkGroup zNs;
    Boolean zNt;
    
    a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
    {
      this.zNs = paramMultiTalkGroup;
      this.zNt = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.q
 * JD-Core Version:    0.7.0.1
 */