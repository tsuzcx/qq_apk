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
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import androidx.core.app.e.d;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.fu;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.f.a.sh;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.b.j;
import com.tencent.mm.plugin.multitalk.b.o.21;
import com.tencent.mm.plugin.multitalk.b.o.29;
import com.tencent.mm.plugin.multitalk.b.o.34;
import com.tencent.mm.plugin.multitalk.b.o.38;
import com.tencent.mm.plugin.multitalk.b.o.5;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.n.f;
import com.tencent.mm.plugin.multitalk.ui.widget.n.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.protocal.protobuf.fcn;
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
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.common.b.a.a.a.ay;
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
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public final class q
  implements ServiceConnection, com.tencent.pb.talkroom.sdk.a
{
  public boolean DOp;
  private com.tencent.e.i.d<?> FpU;
  private boolean FrO;
  private boolean FrP;
  public int FrQ;
  private boolean FrR;
  public boolean FrS;
  public boolean FrT;
  public Bundle FrU;
  boolean FrV;
  public HashSet<String> FrW;
  public com.tencent.mm.plugin.multitalk.ui.widget.o FrX;
  public MultiTalkGroup FrY;
  public z FrZ;
  public e Fri;
  public ac FsA;
  public r FsB;
  public boolean FsC;
  private MMHandler FsD;
  BroadcastReceiver FsE;
  private IListener FsF;
  public boolean Fsa;
  public boolean Fsb;
  private long Fsc;
  public int Fsd;
  private int Fse;
  private int Fsf;
  private boolean Fsg;
  private boolean Fsh;
  private long Fsi;
  private long Fsj;
  private v.a Fsk;
  private boolean Fsl;
  private MultiTalkGroup Fsm;
  private long Fsn;
  private boolean Fso;
  public com.tencent.mm.plugin.multitalk.a.b Fsp;
  private t Fsq;
  private ah Fsr;
  private af Fss;
  private a Fst;
  private Object Fsu;
  public Object Fsv;
  HashMap<String, Integer> Fsw;
  public CopyOnWriteArrayList<String> Fsx;
  private MTimerHandler Fsy;
  a Fsz;
  public boolean iYs;
  IListener kLS;
  public boolean pih;
  
  public q()
  {
    AppMethodBeat.i(114486);
    this.FrR = true;
    this.FrS = false;
    this.FrT = false;
    this.FrV = false;
    this.FrW = new HashSet();
    this.FrX = com.tencent.mm.plugin.multitalk.ui.widget.o.FzF;
    this.FrY = null;
    this.Fsa = false;
    this.Fsb = false;
    this.Fsc = 0L;
    this.Fsd = 0;
    this.Fse = 0;
    this.Fsf = 2;
    this.Fsg = false;
    this.Fsh = false;
    this.Fsi = 0L;
    this.Fsj = 30000L;
    this.FpU = null;
    this.Fsm = null;
    this.Fsn = 0L;
    this.Fso = false;
    this.Fsu = new Object();
    this.Fsv = new Object();
    this.Fsw = new HashMap();
    this.Fsx = new CopyOnWriteArrayList();
    this.Fsy = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(197775);
        Log.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (q.a(q.this) == null)
        {
          q.b(q.this);
          q.c(q.this).stopTimer();
          AppMethodBeat.o(197775);
          return false;
        }
        if (q.hA(MMApplicationContext.getContext()))
        {
          q.this.b(q.a(q.this));
          q.d(q.this);
          q.b(q.this);
          q.c(q.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 7L, 1L, false);
          AppMethodBeat.o(197775);
          return false;
        }
        if (System.currentTimeMillis() - q.e(q.this) < 60000L)
        {
          AppMethodBeat.o(197775);
          return true;
        }
        q.d(q.this);
        q.b(q.this);
        q.c(q.this).stopTimer();
        AppMethodBeat.o(197775);
        return false;
      }
    }, true);
    this.FsB = new r();
    this.FsC = false;
    this.FsD = new MMHandler(Looper.getMainLooper());
    this.FsE = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(200038);
        if (!q.this.eWg())
        {
          AppMethodBeat.o(200038);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          q.h(q.this).removeCallbacksAndMessages(null);
          q.h(q.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200637);
              v.a locala1 = v.eXO();
              if (locala1 != q.i(q.this))
              {
                v.a locala2 = q.i(q.this);
                q.a(q.this, locala1);
                Log.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), q.i(q.this).name() });
                q.this.aK(q.j(q.this), ad.eYc().FrS);
                if (q.k(q.this) != null) {
                  q.k(q.this).a(q.i(q.this));
                }
                AppMethodBeat.o(200637);
                return;
              }
              q.this.aK(q.j(q.this), q.l(q.this));
              Log.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { q.i(q.this).name() });
              AppMethodBeat.o(200637);
            }
          }, 8000L);
          AppMethodBeat.o(200038);
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
          bool = q.this.eXg();
          Log.i("MicroMsg.MT.MultiTalkManager", "phone state %d, isILinkMode:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if (i != 0) {
            break;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196068);
              if (bool) {
                com.tencent.mm.plugin.multitalk.b.o.Fne.ux(true);
              }
              for (;;)
              {
                if (!com.tencent.mm.plugin.audio.c.a.cro()) {
                  q.this.uM(ad.eYc().pih);
                }
                AppMethodBeat.o(196068);
                return;
                ad.eYb().Frw.In(false);
                if (q.this.Fsp != null) {
                  q.this.Fsp.acR();
                }
              }
            }
          });
          AppMethodBeat.o(200038);
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
            AppMethodBeat.i(201810);
            if (bool)
            {
              com.tencent.mm.plugin.multitalk.b.o.Fne.ux(false);
              AppMethodBeat.o(201810);
              return;
            }
            ad.eYb().Frw.In(true);
            AppMethodBeat.o(201810);
          }
        });
        AppMethodBeat.o(200038);
      }
    };
    this.FsF = new q.6(this);
    this.kLS = new q.7(this);
    EventCenter.instance.addListener(this.kLS);
    EventCenter.instance.addListener(this.FsF);
    this.Fsl = false;
    AppMethodBeat.o(114486);
  }
  
  public static boolean Xx(int paramInt)
  {
    AppMethodBeat.i(203421);
    if (!ad.eYc().eXg())
    {
      boolean bool = ad.eYb().Frw.aAg(paramInt);
      AppMethodBeat.o(203421);
      return bool;
    }
    com.tencent.mm.plugin.multitalk.b.o localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
    localo.am(new o.38(localo, paramInt));
    AppMethodBeat.o(203421);
    return true;
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(114500);
    Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.FzG) && (paramBoolean))
    {
      paramo = new ca();
      paramo.setType(64);
      paramo.setCreateTime(System.currentTimeMillis());
      paramo.setStatus(6);
      paramo.setContent(MMApplicationContext.getContext().getString(a.h.multitalk_system_slave_misscall_exit_msg));
      if (com.tencent.mm.model.v.Pm(paramMultiTalkGroup.FmP))
      {
        paramo.Jm(paramMultiTalkGroup.FmP);
        paramo.setContent(paramo.field_content);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aM(paramo);
      }
    }
    AppMethodBeat.o(114500);
  }
  
  private void a(MultiTalkGroup paramMultiTalkGroup, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(203279);
    String str = v.k(paramMultiTalkGroup);
    p.iZ(paramMultiTalkGroup.FmP, str);
    p.aQh(str);
    if (this.FrX != com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ)
    {
      paramBoolean3 = v.j(this.FrY);
      long l = eXi();
      int i = 0;
      if (paramBoolean3) {
        if (paramBoolean2) {
          i = 4;
        }
      }
      for (;;)
      {
        p.a(paramBoolean3, l, str, i);
        AppMethodBeat.o(203279);
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
    p.Xv(this.Fsd);
    p.G(this.Fsd, str);
    if (paramMultiTalkGroup.ZiG != null) {
      p.Xs(paramMultiTalkGroup.ZiG.size());
    }
    AppMethodBeat.o(203279);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114493);
    if (!eWg())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { v.g(paramMultiTalkGroup) });
      this.FrY = paramMultiTalkGroup;
      this.Fsd = 0;
      this.FrQ = 1;
      this.FrW.clear();
      eXk();
      eXj();
      AppMethodBeat.o(114493);
      return true;
    }
    Object localObject1 = this.FrY;
    int i;
    if ((paramMultiTalkGroup == null) || (localObject1 == null)) {
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { v.g(paramMultiTalkGroup) });
      Object localObject2 = this.FrY;
      localObject1 = new HashMap();
      Object localObject3 = paramMultiTalkGroup.ZiG.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject3).next();
          ((HashMap)localObject1).put(localMultiTalkGroupMember.ZiH, localMultiTalkGroupMember);
          continue;
          if ((!Util.isNullOrNil(paramMultiTalkGroup.FmO)) && (!Util.isNullOrNil(((MultiTalkGroup)localObject1).FmO)) && (paramMultiTalkGroup.FmO.equals(((MultiTalkGroup)localObject1).FmO)))
          {
            i = 1;
            break;
          }
          if ((!Util.isNullOrNil(paramMultiTalkGroup.ZiE)) && (!Util.isNullOrNil(((MultiTalkGroup)localObject1).ZiE)) && (paramMultiTalkGroup.ZiE.equals(((MultiTalkGroup)localObject1).ZiE)))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      localObject2 = ((MultiTalkGroup)localObject2).ZiG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiTalkGroupMember)((Iterator)localObject2).next();
        if ((!com.tencent.mm.model.z.bcZ().equals(((MultiTalkGroupMember)localObject3).ZiH)) && (com.tencent.mm.model.z.bcZ().equals(((MultiTalkGroupMember)localObject3).ZiI)) && (((MultiTalkGroupMember)localObject3).status == 1) && ((!((HashMap)localObject1).containsKey(((MultiTalkGroupMember)localObject3).ZiH)) || (((MultiTalkGroupMember)((HashMap)localObject1).get(((MultiTalkGroupMember)localObject3).ZiH)).status == 20)))
        {
          localObject3 = ((MultiTalkGroupMember)localObject3).ZiH;
          localObject3 = MMApplicationContext.getContext().getString(a.h.multitalk_system_busy_exit_msg, new Object[] { aa.PJ((String)localObject3) });
          localObject3 = l.c(MMApplicationContext.getContext(), (CharSequence)localObject3);
          Toast.makeText(MMApplicationContext.getContext(), (CharSequence)localObject3, 0).show();
        }
      }
      this.FrY = paramMultiTalkGroup;
      eXk();
      eXj();
      AppMethodBeat.o(114493);
      return true;
    }
    Log.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { v.g(this.FrY), v.g(paramMultiTalkGroup) });
    AppMethodBeat.o(114493);
    return false;
  }
  
  private static String aQo(String paramString)
  {
    AppMethodBeat.i(203307);
    String str2 = aa.PJ(paramString);
    String str1 = paramString;
    if (str2 != null) {
      if (!str2.equals("")) {
        break label64;
      }
    }
    label64:
    for (str1 = paramString;; str1 = str2)
    {
      paramString = str1 + MMApplicationContext.getContext().getString(a.h.multitalk_system_master_start_multi_msg);
      AppMethodBeat.o(203307);
      return paramString;
    }
  }
  
  public static void aQq(String paramString)
  {
    AppMethodBeat.i(114499);
    Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    ca localca = new ca();
    localca.setType(64);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(6);
    localca.setContent(MMApplicationContext.getContext().getString(a.h.multitalk_system_slave_misscall_exit_msg));
    if (com.tencent.mm.model.v.Pm(paramString))
    {
      localca.Jm(paramString);
      localca.setContent(localca.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aM(localca);
    }
    AppMethodBeat.o(114499);
  }
  
  private void ak(String arg1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(203241);
    Object localObject1 = Util.stringsToList(???.split(","));
    Object localObject2;
    Object localObject3;
    Object localObject4;
    synchronized (this.Fsu)
    {
      if (this.FrX != com.tencent.mm.plugin.multitalk.ui.widget.o.FzF)
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "already in multitalk! cannot start again, status:%s", new Object[] { this.FrX.toString() });
        AppMethodBeat.o(203241);
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
        localObject4 = new com.tencent.mm.plugin.multitalk.b.i();
        ((com.tencent.mm.plugin.multitalk.b.i)localObject4).iSn = ((String)localObject3);
        ((com.tencent.mm.plugin.multitalk.b.i)localObject4).mStatus = 2;
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    com.tencent.mm.plugin.multitalk.b.o.Fne.F(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().kcw.get(1)), com.tencent.mm.model.z.bcZ());
    com.tencent.mm.plugin.multitalk.b.o.Fne.e((ArrayList)localObject2, paramString2);
    fn(paramString2, 2);
    b(com.tencent.mm.plugin.multitalk.ui.widget.o.FzH);
    boolean bool = true;
    if (bool) {
      p.eWK();
    }
    for (;;)
    {
      paramString2 = com.tencent.mm.plugin.multitalk.d.d.FEN;
      com.tencent.mm.plugin.multitalk.d.d.reset();
      AppMethodBeat.o(203241);
      return;
      label231:
      localObject2 = new MultiTalkGroup();
      ((MultiTalkGroup)localObject2).ZiE = ad.eYb().Frw.ile();
      ((MultiTalkGroup)localObject2).FmP = paramString2;
      localObject3 = ((List)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.ZiH = ((String)localObject4);
        if (((String)localObject4).equals(com.tencent.mm.model.z.bcZ())) {}
        for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
        {
          ((MultiTalkGroup)localObject2).ZiG.add(localMultiTalkGroupMember);
          break;
        }
      }
      ad.eYb().Frw.ds(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().kcw.get(1)), com.tencent.mm.model.z.bcZ());
      bool = ad.eYb().Frw.a(((MultiTalkGroup)localObject2).ZiE, paramString2, (List)localObject1, v2protocal.gBp());
      fn(paramString2, 1);
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.FzH);
      a((MultiTalkGroup)localObject2, Boolean.TRUE);
      break;
      p.eWL();
    }
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.o paramo)
  {
    boolean bool = true;
    AppMethodBeat.i(114525);
    Object localObject = this.FrX;
    this.FrX = paramo;
    if (localObject != paramo) {
      if (paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ)
      {
        localObject = new sh();
        ((sh)localObject).fRP.type = 1;
        EventCenter.instance.publish((IEvent)localObject);
        p.a(v.j(this.FrY), eXi(), v.k(this.FrY));
        ad.eYc().stopRing();
        com.tencent.mm.plugin.audio.c.a.setMode(3);
        if ((com.tencent.mm.plugin.audio.c.a.crh()) || (com.tencent.mm.plugin.audio.c.a.cro())) {
          break label133;
        }
      }
    }
    for (;;)
    {
      uM(bool);
      ad.eYb().uC(bool);
      if (this.Fri != null) {
        this.Fri.a(paramo);
      }
      AppMethodBeat.o(114525);
      return;
      label133:
      bool = false;
    }
  }
  
  private void bzG()
  {
    AppMethodBeat.i(114526);
    Log.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.FpU != null)
    {
      this.FpU.cancel(false);
      AppMethodBeat.o(114526);
      return;
    }
    this.Fsc = System.currentTimeMillis();
    this.Fsd = 0;
    TimerTask local5 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(114478);
        if ((q.this.eXi() >= 45000L) && (q.m(q.this) != com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199539);
              q.this.i(false, true, false);
              AppMethodBeat.o(199539);
            }
          });
        }
        if (q.m(q.this) == com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ)
        {
          q.n(q.this);
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198026);
              if (q.m(q.this) == com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ)
              {
                Object localObject1 = ad.eYd();
                int i = q.this.Fsd;
                localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject1).Fzo;
                if (localObject1 != null)
                {
                  Object localObject2 = kotlin.g.b.af.aaBG;
                  localObject2 = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }, 2));
                  kotlin.g.b.p.j(localObject2, "java.lang.String.format(format, *args)");
                  ((com.tencent.mm.plugin.multitalk.ui.widget.m)localObject1).aQN((String)localObject2);
                }
                localObject1 = com.tencent.mm.plugin.multitalk.b.o.Fne;
                if (com.tencent.mm.plugin.multitalk.b.o.eVt() > 0)
                {
                  localObject1 = com.tencent.mm.plugin.multitalk.b.o.Fne;
                  ((com.tencent.mm.plugin.multitalk.b.o)localObject1).Fno += 1;
                  if (q.k(q.this) != null)
                  {
                    q.o(q.this);
                    q.p(q.this);
                  }
                }
                if (q.k(q.this) != null) {
                  q.k(q.this).eIY();
                }
              }
              AppMethodBeat.o(198026);
            }
          });
        }
        AppMethodBeat.o(114478);
      }
    };
    this.FpU = com.tencent.e.h.ZvG.b(local5, 1000L, 1000L);
    AppMethodBeat.o(114526);
  }
  
  private void chr()
  {
    AppMethodBeat.i(114527);
    if (this.FpU != null)
    {
      this.FpU.cancel(false);
      this.FpU = null;
    }
    AppMethodBeat.o(114527);
  }
  
  private void eXA()
  {
    AppMethodBeat.i(114519);
    try
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.qV(26)) && (this.Fso))
      {
        MMApplicationContext.getContext().unbindService(this);
        this.Fso = false;
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
  
  private static boolean eXG()
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
  
  public static void eXH()
  {
    AppMethodBeat.i(178891);
    com.tencent.mm.plugin.multitalk.ui.widget.n localn = ad.eYd();
    if ((localn.Fzo != null) && (!localn.Fzq))
    {
      com.tencent.e.h.ZvG.bDh("showIcon");
      com.tencent.e.h.ZvG.d((Runnable)new n.f(localn), "showIcon");
    }
    AppMethodBeat.o(178891);
  }
  
  public static boolean eXd()
  {
    AppMethodBeat.i(203196);
    if (ad.eYc().FrW.contains(com.tencent.mm.model.z.bcZ())) {}
    for (int i = 1;; i = 0)
    {
      if (ad.eYc().FrW.size() > i)
      {
        AppMethodBeat.o(203196);
        return true;
      }
      AppMethodBeat.o(203196);
      return false;
    }
  }
  
  private void eXj()
  {
    AppMethodBeat.i(114494);
    Log.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.FrY.ZiG });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.FrY.ZiG.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.ZiH.equals(com.tencent.mm.model.z.bcZ())) {
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
    this.FrY.ZiG = localLinkedList;
    Log.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.FrY.ZiG });
    AppMethodBeat.o(114494);
  }
  
  private void eXk()
  {
    AppMethodBeat.i(114495);
    Iterator localIterator = this.FrY.ZiG.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.FrW.remove(localMultiTalkGroupMember.ZiH))) {
        Log.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.ZiH });
      }
    }
    AppMethodBeat.o(114495);
  }
  
  private h eXl()
  {
    AppMethodBeat.i(203289);
    if (this.Fsq == null) {
      this.Fsq = new t();
    }
    t localt = this.Fsq;
    AppMethodBeat.o(203289);
    return localt;
  }
  
  private void eXo()
  {
    AppMethodBeat.i(203294);
    if (this.Fsr == null)
    {
      AppMethodBeat.o(203294);
      return;
    }
    this.Fsr.close();
    this.Fsr = null;
    AppMethodBeat.o(203294);
  }
  
  private void eXs()
  {
    AppMethodBeat.i(114504);
    if (this.FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzH) {}
    for (;;)
    {
      boolean bool = false;
      for (q localq = this;; localq = this)
      {
        localq.pih = bool;
        this.iYs = false;
        this.Fsk = v.eXO();
        AppMethodBeat.o(114504);
        return;
        if ((com.tencent.mm.plugin.audio.c.a.crh()) || (com.tencent.mm.plugin.audio.c.a.cro())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void eXt()
  {
    AppMethodBeat.i(114508);
    if (v.h(this.FrY)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ);
    }
    while (this.Fri != null)
    {
      this.Fri.eRL();
      localObject = v.eXO();
      if (localObject != this.Fsk) {
        this.Fsk = ((v.a)localObject);
      }
      AppMethodBeat.o(114508);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.FzI);
    }
    Object localObject = new Intent();
    c.b(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(114508);
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
  
  private void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(203270);
    a(this.FrY, paramBoolean1, paramBoolean2, false, paramBoolean3);
    AppMethodBeat.o(203270);
  }
  
  private void uK(boolean paramBoolean)
  {
    AppMethodBeat.i(203300);
    if (this.Fss == null)
    {
      AppMethodBeat.o(203300);
      return;
    }
    this.Fss.G(paramBoolean);
    if (!paramBoolean) {
      this.Fss = null;
    }
    AppMethodBeat.o(203300);
  }
  
  public final void Xr(int paramInt)
  {
    AppMethodBeat.i(203395);
    h localh = eXl();
    if (localh != null) {
      localh.Xr(paramInt);
    }
    AppMethodBeat.o(203395);
  }
  
  public final void Xw(int paramInt)
  {
    AppMethodBeat.i(114515);
    Log.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.Fsl = true;
      AppMethodBeat.o(114515);
      return;
    }
    this.Fsl = false;
    AppMethodBeat.o(114515);
  }
  
  public final void a(e parame)
  {
    this.Fri = parame;
  }
  
  public final void a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(114503);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      eXz();
      this.FrO = false;
      eXs();
      bzG();
      Intent localIntent = new Intent();
      RemoteViews localRemoteViews = null;
      String str = "";
      if (!paramBoolean.booleanValue())
      {
        if ((com.tencent.mm.compatible.util.d.qX(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
          i = 1;
        }
        if (i != 0) {
          this.Fsz = new a(paramMultiTalkGroup, Boolean.FALSE);
        }
        paramBoolean = MMApplicationContext.getResources().getString(a.h.multitalk_invite_wording);
        localIntent.putExtra("Voip_User", v.l(paramMultiTalkGroup));
        paramMultiTalkGroup = aa.PJ(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localIntent.getStringExtra("Voip_User")).field_username);
        localRemoteViews = new RemoteViews(MMApplicationContext.getPackageName(), a.f.multitalk_calling_notification);
        localRemoteViews.setTextViewText(a.e.notification_type, paramBoolean);
        localRemoteViews.setTextViewText(a.e.notification_name, paramMultiTalkGroup);
        localRemoteViews.setImageViewResource(a.e.wechat_icon, a.d.wechat_appicon);
        localRemoteViews.setImageViewResource(a.e.notification_avatar, a.d.voice_call);
        str = paramMultiTalkGroup + paramBoolean;
      }
      com.tencent.mm.util.a.a(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", localIntent, localRemoteViews, str, com.tencent.mm.bx.a.hfu());
    }
    AppMethodBeat.o(114503);
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203420);
    if (paramBoolean)
    {
      if (eXh())
      {
        this.FsC = true;
        this.FrQ = paramInt;
        if (!ad.eYc().eXg())
        {
          paramBoolean = ad.eYb().Frw.aAg(paramInt);
          AppMethodBeat.o(203420);
          return paramBoolean;
        }
        AppMethodBeat.o(203420);
        return true;
      }
      AppMethodBeat.o(203420);
      return false;
    }
    if (eXh())
    {
      this.FsC = false;
      paramBoolean = ad.eYc().eXg();
      Log.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + paramInt + ", isILink:" + paramBoolean);
      if (paramBoolean) {
        break label238;
      }
      paramBoolean = ad.eYb().Frw.aAg(paramInt);
      if (v.XA(this.FrQ)) {
        eXB();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      int i = this.FrQ;
      this.FrQ = paramInt;
      if ((this.Fri != null) && (i != this.FrQ)) {
        this.Fri.im(i, this.FrQ);
      }
      AppMethodBeat.o(203420);
      return paramBoolean;
      eXC();
      continue;
      AppMethodBeat.o(203420);
      return false;
      label238:
      paramBoolean = false;
    }
  }
  
  public final void aQe(String paramString)
  {
    AppMethodBeat.i(203243);
    if (this.Fri != null) {
      this.Fri.aQe(paramString);
    }
    AppMethodBeat.o(203243);
  }
  
  public final boolean aQi(String paramString)
  {
    AppMethodBeat.i(203193);
    if ((this.Fst.eVP()) && (this.Fst.eVQ() == paramString))
    {
      AppMethodBeat.o(203193);
      return true;
    }
    AppMethodBeat.o(203193);
    return false;
  }
  
  public final boolean aQj(String paramString)
  {
    AppMethodBeat.i(203198);
    String str = paramString;
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.FrY.FmO;
      str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = this.FrY.ZiE;
      }
    }
    if (this.Fsw.containsKey(str)) {}
    for (int i = ((Integer)this.Fsw.get(str)).intValue();; i = 0)
    {
      if (i == 2)
      {
        AppMethodBeat.o(203198);
        return true;
      }
      AppMethodBeat.o(203198);
      return false;
    }
  }
  
  public final void aQk(String paramString)
  {
    AppMethodBeat.i(203207);
    Log.i("MicroMsg.MT.MultiTalkManager", "removeCurrentMTSDKMode groupid:%s", new Object[] { paramString });
    if ((this.Fsw != null) && (this.Fsw.containsKey(paramString))) {
      this.Fsw.remove(paramString);
    }
    AppMethodBeat.o(203207);
  }
  
  public final void aQl(String paramString)
  {
    AppMethodBeat.i(203245);
    if (this.Fri != null) {
      this.Fri.aQf(paramString);
    }
    AppMethodBeat.o(203245);
  }
  
  public final boolean aQm(String paramString)
  {
    AppMethodBeat.i(203266);
    ArrayList localArrayList = new ArrayList(this.Fsx);
    if (localArrayList.contains(paramString))
    {
      AppMethodBeat.o(203266);
      return true;
    }
    localArrayList.add(paramString);
    this.Fsx = new CopyOnWriteArrayList(localArrayList);
    AppMethodBeat.o(203266);
    return false;
  }
  
  public final void aQn(String paramString)
  {
    AppMethodBeat.i(203268);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Fsx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.equals(paramString)) {
        localArrayList.add(str);
      }
    }
    this.Fsx = new CopyOnWriteArrayList(localArrayList);
    AppMethodBeat.o(203268);
  }
  
  public final void aQp(String paramString)
  {
    AppMethodBeat.i(203312);
    ca localca = new ca();
    localca.setType(64);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(6);
    localca.setContent(MMApplicationContext.getContext().getString(a.h.multitalk_system_master_multi_finish_msg));
    if (com.tencent.mm.model.v.Pm(paramString))
    {
      localca.Jm(paramString);
      localca.setContent(localca.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aM(localca);
    }
    if ((this.Fsm != null) && (paramString.equals(this.Fsm.FmP)) && (!this.Fsy.stopped()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
      this.Fsm = null;
      this.Fsn = 0L;
      this.Fsy.stopTimer();
    }
    AppMethodBeat.o(203312);
  }
  
  public final void aQr(String paramString)
  {
    AppMethodBeat.i(203378);
    if (this.FsB == null) {
      this.FsB = new r();
    }
    this.FsA = new ac();
    this.FsA.Fum = System.currentTimeMillis();
    this.FsA.md5 = paramString;
    com.tencent.e.h.ZvG.b(new q.2(this), 3000L, "delayChecking");
    this.FsB.L(this.FsA);
    AppMethodBeat.o(203378);
  }
  
  public final boolean aQs(String paramString)
  {
    AppMethodBeat.i(114524);
    if (eXh())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      if (eXg())
      {
        if (paramString.equals(""))
        {
          this.Fri.eWk();
          Log.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe small video of visiable region OK!");
        }
        for (;;)
        {
          AppMethodBeat.o(114524);
          return true;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramString);
          paramString = com.tencent.mm.plugin.multitalk.b.o.Fne;
          paramString.am(new o.29(paramString, localArrayList));
          Log.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe large video OK, mems:".concat(String.valueOf(localArrayList)));
        }
      }
      boolean bool = ad.eYb().Frw.aQs(paramString);
      Log.i("MicroMsg.MT.MultiTalkManager", "result of old subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(114524);
      return bool;
    }
    AppMethodBeat.o(114524);
    return false;
  }
  
  public final boolean aeg()
  {
    return this.iYs;
  }
  
  public final void ay(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(203384);
    Log.i("MicroMsg.MT.MultiTalkManager", "onDoScreenSharingSecurityCheck filemd5:%s ret:%d checkRet:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.e.h.ZvG.bDh("delayChecking");
    ac localac = this.FsA;
    if (paramInt2 == 0) {}
    for (;;)
    {
      localac.Ful = Boolean.valueOf(bool);
      this.FsA.md5 = paramString;
      this.FsB.L(this.FsA);
      AppMethodBeat.o(203384);
      return;
      bool = false;
    }
  }
  
  public final void b(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114502);
    boolean bool2 = this.iYs;
    boolean bool3 = this.pih;
    boolean bool4 = this.FrR;
    Object localObject = this.FrX.toString();
    if (this.FrY == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      p.eWQ();
      if ((g.awi()) || (isAppOnForeground(MMApplicationContext.getContext()))) {
        break;
      }
      Log.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.Fsm == null) && (this.Fsy.stopped()))
      {
        this.Fsm = paramMultiTalkGroup;
        this.Fsy.startTimer(2000L);
        this.Fsn = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(114502);
      return;
    }
    localObject = v.l(paramMultiTalkGroup);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)localObject);
    if ((!com.tencent.mm.bj.e.bpX()) || (localas == null) || (localas.ayc()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(202578);
          String str2 = paramMultiTalkGroup.FmO;
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.ZiE;
          }
          ad.eYb().Frw.aPY(str1);
          AppMethodBeat.o(202578);
        }
      }, 1000L);
      p.bG(3, v.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if ((eWg()) || (com.tencent.mm.plugin.voip.c.m.isVoipStarted()) || (com.tencent.mm.plugin.voip.c.m.gDh()) || (com.tencent.mm.bj.e.bpW()) || (com.tencent.mm.bj.e.isCalling()) || (com.tencent.mm.plugin.voip.c.m.gDi()) || (!com.tencent.mm.contact.d.rk(localas.field_type)))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
      if (!com.tencent.mm.model.v.Pk(paramMultiTalkGroup.FmP))
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.FmP });
        az.a.ltq.a(paramMultiTalkGroup.FmP, "", new az.b.a()
        {
          public final void s(String paramAnonymousString, boolean paramAnonymousBoolean) {}
        });
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114485);
          String str2 = paramMultiTalkGroup.FmO;
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.ZiE;
          }
          ad.eYb().Frw.aPY(str1);
          AppMethodBeat.o(114485);
        }
      }, 1000L);
      p.bG(3, v.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if (!com.tencent.mm.model.v.Pk(paramMultiTalkGroup.FmP))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.FmP });
      az.a.ltq.a(paramMultiTalkGroup.FmP, "", null);
    }
    Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.o.FzG);
    p.bG(1, v.k(paramMultiTalkGroup));
    if ((!com.tencent.mm.contact.d.rk(localas.field_type)) || (com.tencent.mm.q.a.aAl()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { localObject, com.tencent.mm.model.z.bcZ() });
      if (a(paramMultiTalkGroup))
      {
        this.FrO = false;
        eXs();
        bzG();
        AppMethodBeat.o(114502);
      }
    }
    else
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { localObject, com.tencent.mm.model.z.bcZ() });
      localObject = new nl();
      ((nl)localObject).fLP.action = 3;
      EventCenter.instance.publish((IEvent)localObject);
      a(paramMultiTalkGroup, Boolean.FALSE);
    }
    AppMethodBeat.o(114502);
  }
  
  public final void bY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203424);
    if (eXg())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast exit due to ILINK mode!!!");
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString)) {
        localArrayList.add(paramString);
      }
      com.tencent.mm.plugin.multitalk.b.o.Fne.d(localArrayList, paramBoolean);
      AppMethodBeat.o(203424);
      return;
    }
    if (this.FrZ == null) {
      this.FrZ = new z();
    }
    this.FrZ.a(eXp());
    if (TextUtils.isEmpty(paramString))
    {
      this.FrZ.eXV();
      AppMethodBeat.o(203424);
      return;
    }
    Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast ownerUserName : ".concat(String.valueOf(paramString)));
    this.FrZ.aQA(paramString);
    Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast error");
    AppMethodBeat.o(203424);
  }
  
  public final void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114505);
    p.bG(2, v.k(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.o.FzG, true);
    AppMethodBeat.o(114505);
  }
  
  public final void c(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114498);
    if (!com.tencent.mm.model.v.Pk(paramString1))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      az.a.ltq.a(paramString1, "", new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    ca localca = new ca();
    localca.setType(64);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(6);
    localca.pJ(2);
    paramString2 = aQo(paramString2);
    localca.setContent(paramString2);
    if (com.tencent.mm.model.v.Pm(paramString1))
    {
      localca.Jm(paramString1);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aM(localca);
      az localaz = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwx(paramString1);
      if (localaz != null)
      {
        if (paramBoolean1) {
          localaz.pH(localaz.field_unReadCount + 1);
        }
        localaz.setContent(paramString2);
        if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().a(localaz, paramString1) == -1) {
          Log.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
        }
        if (paramBoolean2)
        {
          ((com.tencent.mm.model.bb)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localca);
          AppMethodBeat.o(114498);
        }
      }
      else
      {
        localaz = new az();
        localaz.setUsername(paramString1);
        if (paramBoolean1) {
          localaz.pH(1);
        }
        localaz.setContent(paramString2);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().e(localaz);
        if (paramBoolean2) {
          ((com.tencent.mm.model.bb)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localca);
        }
      }
    }
    AppMethodBeat.o(114498);
  }
  
  public final boolean cNL()
  {
    AppMethodBeat.i(203438);
    if (this.Fsp != null)
    {
      boolean bool = this.Fsp.kHI.adI();
      AppMethodBeat.o(203438);
      return bool;
    }
    AppMethodBeat.o(203438);
    return true;
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114506);
    Log.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
    p.uI(true);
    if (a(paramMultiTalkGroup)) {
      eXt();
    }
    AppMethodBeat.o(114506);
  }
  
  public final void e(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(114496);
    boolean bool2 = this.iYs;
    boolean bool3 = this.pih;
    boolean bool4 = this.FrR;
    Object localObject1 = this.FrX.toString();
    if (this.FrY == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject1, Boolean.valueOf(bool1) });
      p.eWP();
      if (!eXG()) {
        break;
      }
      com.tencent.mm.ui.base.h.p(paramActivity, a.h.in_phone_tip, a.h.app_tip);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.c.m.gDh())
    {
      com.tencent.mm.ui.base.h.p(paramActivity, a.h.in_wechat_out_tip, a.h.app_tip);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.c.m.isVoipStarted())
    {
      com.tencent.mm.ui.base.h.p(paramActivity, a.h.in_voip_tip, a.h.app_tip);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.bj.e.bpW())
    {
      com.tencent.mm.ui.base.h.p(paramActivity, a.h.in_new_share_location_tip, a.h.app_tip);
      AppMethodBeat.o(114496);
      return;
    }
    if (com.tencent.mm.plugin.voip.c.m.gDi())
    {
      com.tencent.mm.ui.base.h.p(paramActivity, a.h.in_voip_cs_tip, a.h.app_tip);
      AppMethodBeat.o(114496);
      return;
    }
    if (eWg())
    {
      com.tencent.mm.bj.e.a(paramActivity, a.h.multitalk_exit_tip, null);
      AppMethodBeat.o(114496);
      return;
    }
    if ((this.Fsh) && (System.currentTimeMillis() - this.Fsi < this.Fsj))
    {
      com.tencent.mm.bj.e.a(paramActivity, a.h.multitalk_overload_fail_tips, null);
      AppMethodBeat.o(114496);
      return;
    }
    this.Fsh = false;
    Object localObject3 = Util.stringsToList(paramString1.split(","));
    int i = com.tencent.mm.plugin.multitalk.d.e.eZQ();
    Log.i("MicroMsg.MT.MultiTalkManager", "getMultiTalkSDKMode sdk mode:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      ak(paramString1, paramString2, 2);
      AppMethodBeat.o(114496);
      return;
    }
    paramActivity = com.tencent.mm.plugin.multitalk.b.o.Fne;
    paramString1 = new q.10(this, paramString1, paramString2);
    Object localObject2 = new d.a();
    ((d.a)localObject2).lBU = new fby();
    ((d.a)localObject2).lBV = new fbz();
    ((d.a)localObject2).funcId = 5949;
    ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/voipmtgetsdkmode";
    ((d.a)localObject2).lBW = 0;
    ((d.a)localObject2).respCmdId = 0;
    localObject1 = new LinkedList();
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      fcn localfcn = new fcn();
      localfcn.username = str;
      ((LinkedList)localObject1).add(localfcn);
    }
    localObject2 = ((d.a)localObject2).bgN();
    localObject3 = (fby)d.b.b(((com.tencent.mm.an.d)localObject2).lBR);
    ((fby)localObject3).UCb = ((LinkedList)localObject1);
    ((fby)localObject3).UBS = paramString2;
    IPCRunCgi.a((com.tencent.mm.an.d)localObject2, new o.5(paramActivity, paramString1));
    AppMethodBeat.o(114496);
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114507);
    Log.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { v.g(paramMultiTalkGroup) });
    sh localsh = new sh();
    localsh.fRP.type = 1;
    EventCenter.instance.publish(localsh);
    p.uJ(true);
    if (this.FrX != com.tencent.mm.plugin.multitalk.ui.widget.o.FzG)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.FzI);
      a(paramMultiTalkGroup, Boolean.TRUE);
    }
    if ((eWg()) && (a(paramMultiTalkGroup))) {
      eXt();
    }
    AppMethodBeat.o(114507);
  }
  
  public final List<String> eVE()
  {
    AppMethodBeat.i(203431);
    if (this.FrY == null)
    {
      AppMethodBeat.o(203431);
      return null;
    }
    String str = this.FrY.FmO;
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = this.FrY.ZiE;
    }
    boolean bool = aQj(this.FrY.FmP);
    Log.d("MicroMsg.MT.MultiTalkManager", "getTalkingMember: %s, groupid:%s, isILink:%b", new Object[] { v.g(this.FrY), this.FrY.FmP, Boolean.valueOf(bool) });
    new ArrayList();
    if (bool) {}
    for (localObject = com.tencent.mm.plugin.multitalk.b.o.Fne.eVE();; localObject = ad.eYb().Frw.bCJ((String)localObject))
    {
      AppMethodBeat.o(203431);
      return localObject;
    }
  }
  
  public final boolean eWf()
  {
    AppMethodBeat.i(114491);
    if (this.FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114491);
      return bool;
    }
  }
  
  public final boolean eWg()
  {
    AppMethodBeat.i(114489);
    if ((this.FrX != com.tencent.mm.plugin.multitalk.ui.widget.o.FzF) && (this.FrY != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114489);
      return bool;
    }
  }
  
  public final void eWl()
  {
    AppMethodBeat.i(203445);
    if ((ad.eYc().eXh()) && (this.Fri != null))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "exitProjectScreen");
      this.Fri.eWl();
    }
    AppMethodBeat.o(203445);
  }
  
  public final void eXB()
  {
    AppMethodBeat.i(114520);
    Log.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (eXg())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver exit due to ILINK mode!!!");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.Fri == null)
    {
      Log.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.FrW.size() == 0)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.FrZ == null)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkDataSource: NetworkDataSource is null %d", new Object[] { Integer.valueOf(this.FrW.size()) });
      this.FrZ = new z();
    }
    this.FrZ.a(eXp());
    this.FrZ.start();
    if (eXq().eVP()) {
      bY(eXq().eVQ(), false);
    }
    AppMethodBeat.o(114520);
  }
  
  public final void eXC()
  {
    AppMethodBeat.i(114521);
    Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
    if (this.FrZ != null)
    {
      this.FrZ.stop();
      this.FrZ = null;
    }
    AppMethodBeat.o(114521);
  }
  
  public final void eXD()
  {
    AppMethodBeat.i(203425);
    if (this.FrZ == null) {
      this.FrZ = new z();
    }
    this.FrZ.a(eXp());
    this.FrZ.start();
    ad.eYc().eXn().uT(true);
    AppMethodBeat.o(203425);
  }
  
  public final boolean eXE()
  {
    return this.Fsl;
  }
  
  public final boolean eXF()
  {
    return this.FrR;
  }
  
  public final boolean eXI()
  {
    return this.FrP;
  }
  
  public final void eXa()
  {
    this.Fri = null;
  }
  
  public final MultiTalkGroup eXb()
  {
    return this.FrY;
  }
  
  public final boolean eXc()
  {
    AppMethodBeat.i(114487);
    boolean bool = v.Xz(this.FrQ);
    AppMethodBeat.o(114487);
    return bool;
  }
  
  public final boolean eXe()
  {
    return this.pih;
  }
  
  public final HashSet<String> eXf()
  {
    return this.FrW;
  }
  
  public final boolean eXg()
  {
    AppMethodBeat.i(203201);
    if (this.FrY != null)
    {
      boolean bool = aQj(this.FrY.FmP);
      AppMethodBeat.o(203201);
      return bool;
    }
    AppMethodBeat.o(203201);
    return false;
  }
  
  public final boolean eXh()
  {
    AppMethodBeat.i(114490);
    if ((this.FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzI) || (this.FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114490);
      return bool;
    }
  }
  
  public final long eXi()
  {
    AppMethodBeat.i(114492);
    long l1 = System.currentTimeMillis();
    long l2 = this.Fsc;
    AppMethodBeat.o(114492);
    return l1 - l2;
  }
  
  public final t eXm()
  {
    AppMethodBeat.i(203290);
    if (this.Fsq == null) {
      this.Fsq = new t();
    }
    t localt = this.Fsq;
    AppMethodBeat.o(203290);
    return localt;
  }
  
  public final ag eXn()
  {
    AppMethodBeat.i(203291);
    if (this.Fsr == null) {
      this.Fsr = new ah(ad.eYb().Frw);
    }
    ah localah = this.Fsr;
    AppMethodBeat.o(203291);
    return localah;
  }
  
  public final af eXp()
  {
    AppMethodBeat.i(203298);
    if (this.Fss == null) {
      this.Fss = new af();
    }
    af localaf = this.Fss;
    AppMethodBeat.o(203298);
    return localaf;
  }
  
  public final a eXq()
  {
    AppMethodBeat.i(203302);
    if (this.Fst == null) {
      this.Fst = new a();
    }
    a locala = this.Fst;
    AppMethodBeat.o(203302);
    return locala;
  }
  
  public final void eXr()
  {
    AppMethodBeat.i(162239);
    this.Fsz = null;
    this.Fsg = false;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162239);
  }
  
  public final void eXu()
  {
    AppMethodBeat.i(114510);
    Log.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(114510);
  }
  
  public final void eXv()
  {
    AppMethodBeat.i(114513);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.FrQ) });
    AppMethodBeat.o(114513);
  }
  
  public final void eXw()
  {
    AppMethodBeat.i(114514);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(114514);
  }
  
  public final void eXx()
  {
    AppMethodBeat.i(178889);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
    AppMethodBeat.o(178889);
  }
  
  public final void eXy()
  {
    AppMethodBeat.i(203390);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeScreenSharingVideoSuss ");
    AppMethodBeat.o(203390);
  }
  
  public final void eXz()
  {
    AppMethodBeat.i(203398);
    if (eXg()) {}
    for (this.Fsp = com.tencent.mm.plugin.multitalk.b.o.Fne.eVx();; this.Fsp = new com.tencent.mm.plugin.multitalk.a.b())
    {
      if (this.pih) {
        this.Fsp.ds(true);
      }
      com.tencent.mm.plugin.multitalk.a.b.eVi();
      AppMethodBeat.o(203398);
      return;
    }
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114509);
    Log.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { v.g(paramMultiTalkGroup) });
    if ((eWg()) && (a(paramMultiTalkGroup)))
    {
      if (!v.i(this.FrY))
      {
        if (this.FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzG)
        {
          i(false, true, false);
          AppMethodBeat.o(114509);
          return;
        }
        i(false, false, false);
        AppMethodBeat.o(114509);
        return;
      }
      if ((this.FrX != com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ) && (v.h(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ);
      }
      if ((this.Fri != null) && (v.c(this.FrX))) {
        this.Fri.eWi();
      }
    }
    AppMethodBeat.o(114509);
  }
  
  public final void fn(String paramString, int paramInt)
  {
    AppMethodBeat.i(203204);
    Log.i("MicroMsg.MT.MultiTalkManager", "setCurrentMTSDKMode groupid:%s, mode:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.Fsw == null)
    {
      AppMethodBeat.o(203204);
      return;
    }
    if ((!this.Fsw.containsKey(paramString)) || (((Integer)this.Fsw.get(paramString)).intValue() != paramInt)) {
      this.Fsw.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(203204);
  }
  
  public final void gb(List<a.ar> paramList)
  {
    AppMethodBeat.i(114516);
    if (eWg())
    {
      this.FrW.clear();
      Log.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.ar localar = (a.ar)((Iterator)localObject).next();
        if ((localar.videoStatus == 2) || (localar.videoStatus == 3)) {
          this.FrW.add(localar.fEC);
        }
      }
      localObject = eXl();
      if (localObject != null) {
        ((h)localObject).gb(paramList);
      }
      Log.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.FrW });
      if (this.Fri != null)
      {
        this.Fri.eWj();
        AppMethodBeat.o(114516);
        return;
      }
      Log.e("MicroMsg.MT.MultiTalkManager", "uiCallback is NULL !!!");
    }
    AppMethodBeat.o(114516);
  }
  
  public final void gc(List<String> paramList)
  {
    AppMethodBeat.i(203228);
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    if (eWg())
    {
      localObject2 = this.FrY.FmO;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = this.FrY.ZiE;
      }
      boolean bool = aQj(this.FrY.FmP);
      Log.i("MicroMsg.MT.MultiTalkManager", "addMemberList: %s, wifigateway:%s, groupid:%s, isILink:%b", new Object[] { v.g(this.FrY), v2protocal.gBp(), this.FrY.FmP, Boolean.valueOf(bool) });
      if (bool)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.b.o.Fne;
        localObject2 = new LinkedList();
        localArrayList = ((com.tencent.mm.plugin.multitalk.b.o)localObject1).FmD.eVq();
        paramList = paramList.iterator();
      }
    }
    label292:
    for (;;)
    {
      String str;
      if (paramList.hasNext())
      {
        str = (String)paramList.next();
        Iterator localIterator = localArrayList.iterator();
        com.tencent.mm.plugin.multitalk.b.i locali;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locali = (com.tencent.mm.plugin.multitalk.b.i)localIterator.next();
        } while ((!str.equals(locali.iSn)) || ((locali.mStatus != 1) && (locali.mStatus != 2) && (locali.mStatus != 3)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label292;
        }
        ((LinkedList)localObject2).add(str);
        break;
        IPCRunCgi.a(com.tencent.mm.plugin.multitalk.b.h.bw((LinkedList)localObject2), new o.21((com.tencent.mm.plugin.multitalk.b.o)localObject1));
        AppMethodBeat.o(203228);
        return;
        ad.eYb().Frw.Q((String)localObject1, paramList);
        AppMethodBeat.o(203228);
        return;
      }
    }
  }
  
  public final boolean gd(List<a.aq> paramList)
  {
    AppMethodBeat.i(203426);
    if (eXh())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(paramList)));
      boolean bool = ad.eYb().Frw.gd(paramList);
      Log.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(203426);
      return bool;
    }
    AppMethodBeat.o(203426);
    return false;
  }
  
  public final void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(114497);
    Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    eXl().close();
    com.tencent.e.h.ZvG.bDh("delayChecking");
    this.FsA = null;
    if (this.FsB != null)
    {
      this.FsB.L(null);
      this.FsB = null;
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    ad.eYc().stopRing();
    Object localObject;
    if (eWg())
    {
      localObject = new sh();
      ((sh)localObject).fRP.type = 2;
      EventCenter.instance.publish((IEvent)localObject);
      j(paramBoolean1, paramBoolean2, paramBoolean3);
      localObject = this.FrX;
      if (this.Fri != null) {
        this.Fri.eWh();
      }
      this.FrV = false;
      this.Fsa = false;
      this.Fsb = false;
      this.FrX = com.tencent.mm.plugin.multitalk.ui.widget.o.FzF;
      eXC();
      eXo();
      uK(false);
      this.Fst = null;
      to(true);
      chr();
      if (this.Fsp != null)
      {
        this.Fsp.eVm();
        com.tencent.mm.plugin.multitalk.a.b.unInit();
      }
      ad.eYa().reset();
      if (this.FrY != null)
      {
        a(this.FrY, (com.tencent.mm.plugin.multitalk.ui.widget.o)localObject, paramBoolean2);
        String str = this.FrY.FmO;
        localObject = str;
        if (Util.isNullOrNil(str)) {
          localObject = this.FrY.ZiE;
        }
        Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isILinkMode %b", new Object[] { Boolean.valueOf(eXg()) });
        com.tencent.mm.plugin.multitalk.b.o.Fne.Xp(1);
        ad.eYb().Frw.aPY((String)localObject);
        this.FrY = null;
        this.FrQ = 0;
        this.pih = true;
        this.iYs = false;
        this.FrR = true;
        this.Fsc = 0L;
        this.Fsd = 0;
        this.FrW.clear();
        localObject = new fu();
        EventCenter.instance.publish((IEvent)localObject);
        this.Fsg = true;
      }
    }
    for (;;)
    {
      this.Fsx.clear();
      localObject = com.tencent.mm.plugin.multitalk.d.d.FEN;
      com.tencent.mm.plugin.multitalk.d.d.report();
      eXA();
      AppMethodBeat.o(114497);
      return;
      Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: currentMultiTalkGroup null");
      break;
      Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: not connecting, isHangupMultitalk %b", new Object[] { Boolean.valueOf(this.Fsg) });
      if (!this.Fsg)
      {
        eXC();
        to(false);
        chr();
        if (this.Fsp != null) {
          this.Fsp.eVm();
        }
        this.FrY = null;
        this.FrQ = 0;
        this.Fsg = false;
        this.Fsc = 0L;
        this.Fsd = 0;
        this.FrW.clear();
        this.FrX = com.tencent.mm.plugin.multitalk.ui.widget.o.FzF;
        this.Fse = 0;
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void r(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(114501);
    Log.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuB, Integer.valueOf(-1));
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuC, Long.valueOf(-1L));
    int i;
    switch (paramInt)
    {
    default: 
      i = a.h.multitalk_error_600;
    }
    for (;;)
    {
      if (this.Fri != null) {
        this.Fri.kv(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(i), 0).show();
        i(false, false, true);
      }
      AppMethodBeat.o(114501);
      return;
      p.uI(false);
      i = a.h.multitalk_error_100;
      continue;
      p.uJ(false);
      i = a.h.multitalk_error_200;
      continue;
      i = a.h.multitalk_error_300;
      continue;
      i = a.h.multitalk_error_400;
      continue;
      i = a.h.multitalk_error_500;
      continue;
      i = a.h.multitalk_error_600;
      continue;
      i = a.h.multitalk_error_700;
      continue;
      i = a.h.multitalk_error_800;
      continue;
      i = a.h.multitalk_error_900;
      continue;
      i = a.h.multitalk_error_1000;
      continue;
      i = a.h.multitalk_error_1100;
      continue;
      i = a.h.multitalk_error_1200;
      continue;
      int j = a.h.multitalk_error_1300;
      this.Fsh = true;
      this.Fsi = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.ab)paramObject;
        i = j;
        if (paramObject != null)
        {
          Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.Zgv);
          i = j;
          if (paramObject.Zgv != 0)
          {
            this.Fsj = (paramObject.Zgv * 1000);
            i = j;
            continue;
            Log.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = a.h.multitalk_error_14256;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.ac)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.iut().IJ(false);
                i = j;
                continue;
                i = a.h.multitalk_error_1400;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.FrY;
                if (this.FrY != null) {}
                for (String str = this.FrY.FmP;; str = "")
                {
                  Log.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.ac)paramObject;
                    if (paramObject != null)
                    {
                      Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.ZeS != null)
                      {
                        ad.eYf().aQa(paramObject.ZeS.Zhv);
                        Log.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.ZeS.Zhv);
                      }
                      if (!ad.eYb().Frw.aPY(paramObject.groupId)) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = a.h.multitalk_system_master_finish_exit_msg;
                  break;
                }
                Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.h.multitalk_disabled), 0).show();
                if (paramObject != null)
                {
                  i = ((Integer)paramObject).intValue();
                  if (i > 0)
                  {
                    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuB, Integer.valueOf(i));
                    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuC, Long.valueOf(Util.currentTicks()));
                  }
                }
                i = a.h.multitalk_disabled;
                continue;
                Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                i = a.h.multitalk_network_failed;
                continue;
                Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
                AppMethodBeat.o(114501);
                return;
                Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
                i = a.h.multitalk_error_14287;
                continue;
                Log.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
                i = a.h.multitalk_error_14287;
              }
            }
          }
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(203381);
    com.tencent.e.h.ZvG.bDh("delayChecking");
    this.FsA = null;
    this.FsB.L(null);
    AppMethodBeat.o(203381);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(114529);
    if ((this.FrO) && (this.Fsp != null))
    {
      this.Fsp.eVk();
      this.FrO = false;
    }
    AppMethodBeat.o(114529);
  }
  
  public final void to(boolean paramBoolean)
  {
    AppMethodBeat.i(178890);
    this.DOp = false;
    if (paramBoolean) {
      ad.eYd().eYE();
    }
    for (;;)
    {
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).cancel(43);
      eXA();
      AppMethodBeat.o(178890);
      return;
      ad.eYd().ic(false);
    }
  }
  
  public final void uA(boolean paramBoolean)
  {
    AppMethodBeat.i(114532);
    if ((ad.eYc().eXh()) && (this.Fri != null))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.Fri.uA(paramBoolean);
    }
    AppMethodBeat.o(114532);
  }
  
  public final void uL(boolean paramBoolean)
  {
    AppMethodBeat.i(114517);
    if (eWg())
    {
      if (this.DOp)
      {
        AppMethodBeat.o(114517);
        return;
      }
      p.j(v.eXM(), v.Xz(ad.eYc().FrQ), paramBoolean);
      Toast.makeText(MMApplicationContext.getContext(), a.h.multitalk_mini_toast, 0).show();
      Object localObject1 = MMApplicationContext.getContext().getString(a.h.multitalk);
      String str = MMApplicationContext.getContext().getString(a.h.multitalk_recover);
      Object localObject2 = new Intent();
      if (this.FrT)
      {
        ((Intent)localObject2).putExtra("enterMainUIScreenProjectOnline", true);
        ((Intent)localObject2).putExtra("enterMainUIScreenProjectParams", this.FrU);
      }
      ((Intent)localObject2).setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, (Intent)localObject2, 134217728);
      int i = a.d.notification_icon_gray;
      if (com.tencent.mm.compatible.util.d.qW(19)) {
        i = a.d.notification_icon;
      }
      localObject1 = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(str).e(System.currentTimeMillis()).k((CharSequence)localObject1).l(str);
      ((e.d)localObject1).Ip = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.c.m.e((e.d)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
      if (this.Fri != null)
      {
        this.Fri.eIX();
        this.DOp = true;
      }
      eXo();
      uK(true);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114476);
          Intent localIntent = new Intent();
          if (q.this.FrT)
          {
            localIntent.putExtra("enterMainUIScreenProjectOnline", true);
            localIntent.putExtra("enterMainUIScreenProjectParams", q.this.FrU);
          }
          localIntent.setFlags(268435456);
          Object localObject;
          if (q.f(q.this) != null)
          {
            localObject = q.f(q.this).FmP;
            localIntent.putExtra("enterMainUiWxGroupId", (String)localObject);
            localIntent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
            localIntent.putExtra("notification", this.FsH);
            localIntent.putExtra("enterMainUiSource", 1);
            localObject = ad.eYd();
            com.tencent.mm.plugin.voip.ui.a local1 = new com.tencent.mm.plugin.voip.ui.a()
            {
              public final void a(Intent paramAnonymous2Intent, BaseSmallView paramAnonymous2BaseSmallView)
              {
                AppMethodBeat.i(203756);
                if (!q.this.eWf())
                {
                  paramAnonymous2BaseSmallView.aQM(MMApplicationContext.getContext().getString(a.h.multitalk_waiting_wording));
                  AppMethodBeat.o(203756);
                  return;
                }
                int i = q.this.Fsd;
                paramAnonymous2BaseSmallView.aQN(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
                AppMethodBeat.o(203756);
              }
              
              public final boolean eIT()
              {
                AppMethodBeat.i(203751);
                if ((q.this.eXh()) || (q.this.eWf()))
                {
                  AppMethodBeat.o(203751);
                  return true;
                }
                AppMethodBeat.o(203751);
                return false;
              }
            };
            ad.eYc();
            boolean bool = q.eXd();
            ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject).intent = localIntent;
            ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject).Fzp = local1;
            if (com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext())) {
              break label214;
            }
            Log.e("MicroMsg.MultiTalkSmallWindow", "mini, permission denied");
            Context localContext = MMApplicationContext.getContext();
            RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(a.h.voip_float_permission_alert_content), (RequestFloatWindowPermissionDialog.a)new n.i((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject, local1, localIntent, bool), com.tencent.mm.bx.a.awc());
          }
          for (;;)
          {
            q.g(q.this);
            AppMethodBeat.o(114476);
            return;
            localObject = "";
            break;
            label214:
            ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject).aK(localIntent);
          }
        }
      });
    }
    AppMethodBeat.o(114517);
  }
  
  public final void uM(boolean paramBoolean)
  {
    AppMethodBeat.i(114512);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (eXg()) {
      if (com.tencent.mm.plugin.multitalk.b.o.Fne.Fnh.FmB != null) {
        ad.eYc().Fsp.uw(paramBoolean);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
      this.pih = paramBoolean;
      if (this.Fri != null) {
        this.Fri.uz(this.pih);
      }
      AppMethodBeat.o(114512);
      return;
      ad.eYb().Frw.uM(paramBoolean);
    }
  }
  
  public final void uN(boolean paramBoolean)
  {
    AppMethodBeat.i(203413);
    if (eXg())
    {
      com.tencent.mm.plugin.multitalk.b.o localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
      Log.i("MicroMsg.Multitalk.ILinkService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localo.am(new o.34(localo, paramBoolean));
    }
    for (;;)
    {
      uy(paramBoolean);
      AppMethodBeat.o(203413);
      return;
      ad.eYb().Frw.uN(paramBoolean);
    }
  }
  
  public final void uO(boolean paramBoolean)
  {
    this.FrR = paramBoolean;
  }
  
  public final void uP(boolean paramBoolean)
  {
    AppMethodBeat.i(114528);
    if (this.FrO)
    {
      AppMethodBeat.o(114528);
      return;
    }
    if (this.Fsp != null)
    {
      this.Fsp.aa(paramBoolean, 0);
      this.FrO = true;
    }
    AppMethodBeat.o(114528);
  }
  
  public final void uQ(boolean paramBoolean)
  {
    AppMethodBeat.i(114533);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.FrP = paramBoolean;
    AppMethodBeat.o(114533);
  }
  
  public final void uy(boolean paramBoolean)
  {
    AppMethodBeat.i(114511);
    this.iYs = paramBoolean;
    if (this.Fri != null) {
      this.Fri.uy(this.iYs);
    }
    AppMethodBeat.o(114511);
  }
  
  final class a
  {
    MultiTalkGroup FsP;
    Boolean FsQ;
    
    a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
    {
      this.FsP = paramMultiTalkGroup;
      this.FsQ = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.q
 * JD-Core Version:    0.7.0.1
 */