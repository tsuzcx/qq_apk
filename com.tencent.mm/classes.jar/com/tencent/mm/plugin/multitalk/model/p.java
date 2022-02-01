package com.tencent.mm.plugin.multitalk.model;

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
import androidx.core.app.f.d;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.gf;
import com.tencent.mm.autogen.a.os;
import com.tencent.mm.autogen.a.tx;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.c.j;
import com.tencent.mm.plugin.multitalk.c.k;
import com.tencent.mm.plugin.multitalk.c.o.12;
import com.tencent.mm.plugin.multitalk.c.o.22;
import com.tencent.mm.plugin.multitalk.c.o.24;
import com.tencent.mm.plugin.multitalk.c.o.25;
import com.tencent.mm.plugin.multitalk.c.o.26;
import com.tencent.mm.plugin.multitalk.c.o.27;
import com.tencent.mm.plugin.multitalk.c.o.28;
import com.tencent.mm.plugin.multitalk.c.o.35;
import com.tencent.mm.plugin.multitalk.c.o.39;
import com.tencent.mm.plugin.multitalk.c.o.b;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.a.b;
import com.tencent.mm.plugin.multitalk.ui.widget.n.c;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.io.File;
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
import kotlin.g.b.am;

public final class p
  implements ServiceConnection, com.tencent.pb.talkroom.sdk.a
{
  public boolean JFE;
  public e Lnt;
  private MultiTalkGroup LoA;
  private long LoB;
  private boolean LoC;
  public com.tencent.mm.plugin.multitalk.b.b LoD;
  private s LoE;
  private ag LoF;
  private ae LoG;
  private a LoH;
  final com.tencent.mm.plugin.multitalk.ui.a LoI;
  private final a.b LoJ;
  private Object LoK;
  private Object LoL;
  HashMap<String, Integer> LoM;
  private aa LoN;
  public CopyOnWriteArrayList<String> LoO;
  private MTimerHandler LoP;
  a LoQ;
  boolean LoR;
  public ab LoS;
  public x LoT;
  public boolean LoU;
  private MMHandler LoV;
  BroadcastReceiver LoW;
  private IListener LoX;
  private boolean Lob;
  public boolean Loc;
  public int Lod;
  public boolean Loe;
  public boolean Lof;
  public boolean Log;
  public Bundle Loh;
  boolean Loi;
  public HashSet<String> Loj;
  public com.tencent.mm.plugin.multitalk.ui.widget.o Lok;
  public MultiTalkGroup Lol;
  public y Lom;
  public boolean Lon;
  public boolean Loo;
  private long Lop;
  public int Loq;
  private int Lor;
  private int Los;
  private boolean Lot;
  public boolean Lou;
  public long Lov;
  public long Low;
  private com.tencent.threadpool.i.d<?> Lox;
  private u.a Loy;
  public boolean Loz;
  public boolean lAj;
  IListener nnP;
  public boolean snA;
  
  public p()
  {
    AppMethodBeat.i(114486);
    this.Loe = true;
    this.Lof = false;
    this.Log = false;
    this.Loi = false;
    this.Loj = new HashSet();
    this.Lok = com.tencent.mm.plugin.multitalk.ui.widget.o.LvJ;
    this.Lol = null;
    this.Lon = false;
    this.Loo = false;
    this.Lop = 0L;
    this.Loq = 0;
    this.Lor = 0;
    this.Los = 2;
    this.Lot = false;
    this.Lou = false;
    this.Lov = 0L;
    this.Low = 30000L;
    this.Lox = null;
    this.LoA = null;
    this.LoB = 0L;
    this.LoC = false;
    this.LoI = new com.tencent.mm.plugin.multitalk.ui.a();
    this.LoJ = new a.b()
    {
      public final void a(Intent paramAnonymousIntent, MultiTalkGroup paramAnonymousMultiTalkGroup)
      {
        AppMethodBeat.i(284901);
        Object localObject = u.l(paramAnonymousMultiTalkGroup);
        if ((com.tencent.mm.compatible.util.d.rd(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            p.this.LoQ = new p.a(p.this, paramAnonymousMultiTalkGroup, Boolean.FALSE);
          }
          paramAnonymousMultiTalkGroup = MMApplicationContext.getResources().getString(a.h.multitalk_invite_wording);
          paramAnonymousIntent.putExtra("Voip_User", (String)localObject);
          String str = com.tencent.mm.model.aa.getDisplayName(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramAnonymousIntent.getStringExtra("Voip_User")).field_username);
          localObject = new RemoteViews(MMApplicationContext.getPackageName(), a.f.multitalk_calling_notification);
          ((RemoteViews)localObject).setTextViewText(a.e.notification_type, paramAnonymousMultiTalkGroup);
          ((RemoteViews)localObject).setTextViewText(a.e.notification_name, str);
          ((RemoteViews)localObject).setImageViewResource(a.e.wechat_icon, a.d.wechat_appicon);
          ((RemoteViews)localObject).setImageViewResource(a.e.notification_avatar, a.d.voice_call);
          paramAnonymousMultiTalkGroup = str + paramAnonymousMultiTalkGroup;
          com.tencent.mm.util.a.a(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", paramAnonymousIntent, (RemoteViews)localObject, paramAnonymousMultiTalkGroup, com.tencent.mm.bq.a.iGo());
          AppMethodBeat.o(284901);
          return;
        }
      }
      
      public final void ggu()
      {
        AppMethodBeat.i(284882);
        p.this.gga();
        AppMethodBeat.o(284882);
      }
      
      public final void ggv()
      {
        AppMethodBeat.i(284885);
        p.this.j(true, false, false);
        AppMethodBeat.o(284885);
      }
      
      public final void ggw()
      {
        AppMethodBeat.i(284892);
        p.this.stopRing();
        p.this.za(false);
        AppMethodBeat.o(284892);
      }
      
      public final void onBackground()
      {
        AppMethodBeat.i(284878);
        if (p.this.LoD != null) {
          com.tencent.mm.plugin.multitalk.b.b.gdV();
        }
        AppMethodBeat.o(284878);
      }
    };
    this.LoK = new Object();
    this.LoL = new Object();
    this.LoM = new HashMap();
    this.LoN = new aa(MMApplicationContext.getContext());
    this.LoO = new CopyOnWriteArrayList();
    this.LoP = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(284720);
        Log.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (p.b(p.this) == null)
        {
          p.c(p.this);
          p.d(p.this).stopTimer();
          AppMethodBeat.o(284720);
          return false;
        }
        if (p.iX(MMApplicationContext.getContext()))
        {
          p.this.b(p.b(p.this));
          p.e(p.this);
          p.c(p.this);
          p.d(p.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 7L, 1L, false);
          AppMethodBeat.o(284720);
          return false;
        }
        if (System.currentTimeMillis() - p.f(p.this) < 60000L)
        {
          AppMethodBeat.o(284720);
          return true;
        }
        p.e(p.this);
        p.c(p.this);
        p.d(p.this).stopTimer();
        AppMethodBeat.o(284720);
        return false;
      }
    }, true);
    this.LoR = false;
    this.LoT = new x();
    this.LoU = false;
    this.LoV = new MMHandler(Looper.getMainLooper());
    this.LoW = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(284837);
        if (!p.this.geX())
        {
          AppMethodBeat.o(284837);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          p.j(p.this).removeCallbacksAndMessages(null);
          p.j(p.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(284907);
              u.a locala1 = u.ggD();
              if (locala1 != p.k(p.this))
              {
                u.a locala2 = p.k(p.this);
                p.a(p.this, locala1);
                Log.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), p.k(p.this).name() });
                p.this.bl(p.l(p.this), ac.ggS().Lof);
                if (p.h(p.this) != null) {
                  p.h(p.this).a(p.k(p.this));
                }
                AppMethodBeat.o(284907);
                return;
              }
              p.this.bl(p.l(p.this), p.m(p.this));
              Log.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { p.k(p.this).name() });
              AppMethodBeat.o(284907);
            }
          }, 8000L);
          AppMethodBeat.o(284837);
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
          bool = p.this.gfV();
          Log.i("MicroMsg.MT.MultiTalkManager", "phone state %d, isILinkMode:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          if (i != 0) {
            break;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(284899);
              if (bool) {
                com.tencent.mm.plugin.multitalk.c.o.Ljn.yL(true);
              }
              for (;;)
              {
                if (!com.tencent.mm.plugin.audio.c.a.cTX()) {
                  p.this.zb(ac.ggS().snA);
                }
                AppMethodBeat.o(284899);
                return;
                ac.ggR().LnJ.Op(false);
                if (p.this.LoD != null) {
                  p.this.LoD.aER();
                }
              }
            }
          });
          AppMethodBeat.o(284837);
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
            AppMethodBeat.i(284910);
            if (bool)
            {
              com.tencent.mm.plugin.multitalk.c.o.Ljn.yL(false);
              AppMethodBeat.o(284910);
              return;
            }
            ac.ggR().LnJ.Op(true);
            AppMethodBeat.o(284910);
          }
        });
        AppMethodBeat.o(284837);
      }
    };
    this.LoX = new MultiTalkManager.17(this, com.tencent.mm.app.f.hfK);
    this.nnP = new MultiTalkManager.18(this, com.tencent.mm.app.f.hfK);
    this.nnP.alive();
    this.LoX.alive();
    this.Loz = false;
    this.LoI.Lrs = this.LoJ;
    AppMethodBeat.o(114486);
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(114500);
    Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.LvK) && (paramBoolean))
    {
      paramo = new cc();
      paramo.setType(64);
      paramo.setCreateTime(System.currentTimeMillis());
      paramo.setStatus(6);
      paramo.setContent(MMApplicationContext.getContext().getString(a.h.multitalk_system_slave_misscall_exit_msg));
      if (v.If(paramMultiTalkGroup.LiV))
      {
        paramo.BS(paramMultiTalkGroup.LiV);
        paramo.setContent(paramo.field_content);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(paramo);
      }
    }
    AppMethodBeat.o(114500);
  }
  
  private void a(MultiTalkGroup paramMultiTalkGroup, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(284810);
    String str = u.k(paramMultiTalkGroup);
    o.ko(paramMultiTalkGroup.LiV, str);
    o.aNc(str);
    if (this.Lok != com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)
    {
      paramBoolean3 = u.j(this.Lol);
      long l = gfX();
      int i = 0;
      if (paramBoolean3) {
        if (paramBoolean2) {
          i = 4;
        }
      }
      for (;;)
      {
        o.a(paramBoolean3, l, str, i);
        AppMethodBeat.o(284810);
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
    o.abG(this.Loq);
    o.U(this.Loq, str);
    if (paramMultiTalkGroup.ahhh != null) {
      o.abD(paramMultiTalkGroup.ahhh.size());
    }
    AppMethodBeat.o(284810);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114493);
    if (!geX())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { u.g(paramMultiTalkGroup) });
      this.Lol = paramMultiTalkGroup;
      this.Loq = 0;
      this.Lod = 1;
      this.Loj.clear();
      gfZ();
      gfY();
      AppMethodBeat.o(114493);
      return true;
    }
    Object localObject1 = this.Lol;
    int i;
    if ((paramMultiTalkGroup == null) || (localObject1 == null)) {
      i = 0;
    }
    while (i != 0)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { u.g(paramMultiTalkGroup) });
      Object localObject2 = this.Lol;
      localObject1 = new HashMap();
      Object localObject3 = paramMultiTalkGroup.ahhh.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject3).next();
          ((HashMap)localObject1).put(localMultiTalkGroupMember.ahhi, localMultiTalkGroupMember);
          continue;
          if ((!Util.isNullOrNil(paramMultiTalkGroup.LiU)) && (!Util.isNullOrNil(((MultiTalkGroup)localObject1).LiU)) && (paramMultiTalkGroup.LiU.equals(((MultiTalkGroup)localObject1).LiU)))
          {
            i = 1;
            break;
          }
          if ((!Util.isNullOrNil(paramMultiTalkGroup.ahhf)) && (!Util.isNullOrNil(((MultiTalkGroup)localObject1).ahhf)) && (paramMultiTalkGroup.ahhf.equals(((MultiTalkGroup)localObject1).ahhf)))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      localObject2 = ((MultiTalkGroup)localObject2).ahhh.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MultiTalkGroupMember)((Iterator)localObject2).next();
        if ((!z.bAM().equals(((MultiTalkGroupMember)localObject3).ahhi)) && (z.bAM().equals(((MultiTalkGroupMember)localObject3).ahhj)) && (((MultiTalkGroupMember)localObject3).status == 1) && ((!((HashMap)localObject1).containsKey(((MultiTalkGroupMember)localObject3).ahhi)) || (((MultiTalkGroupMember)((HashMap)localObject1).get(((MultiTalkGroupMember)localObject3).ahhi)).status == 20)))
        {
          localObject3 = ((MultiTalkGroupMember)localObject3).ahhi;
          localObject3 = MMApplicationContext.getContext().getString(a.h.multitalk_system_busy_exit_msg, new Object[] { com.tencent.mm.model.aa.getDisplayName((String)localObject3) });
          localObject3 = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)localObject3);
          Toast.makeText(MMApplicationContext.getContext(), (CharSequence)localObject3, 0).show();
        }
      }
      this.Lol = paramMultiTalkGroup;
      gfZ();
      gfY();
      AppMethodBeat.o(114493);
      return true;
    }
    Log.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { u.g(this.Lol), u.g(paramMultiTalkGroup) });
    AppMethodBeat.o(114493);
    return false;
  }
  
  private static String aNi(String paramString)
  {
    AppMethodBeat.i(284819);
    String str2 = com.tencent.mm.model.aa.getDisplayName(paramString);
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
      AppMethodBeat.o(284819);
      return paramString;
    }
  }
  
  public static void aNk(String paramString)
  {
    AppMethodBeat.i(114499);
    Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    cc localcc = new cc();
    localcc.setType(64);
    localcc.setCreateTime(System.currentTimeMillis());
    localcc.setStatus(6);
    localcc.setContent(MMApplicationContext.getContext().getString(a.h.multitalk_system_slave_misscall_exit_msg));
    if (v.If(paramString))
    {
      localcc.BS(paramString);
      localcc.setContent(localcc.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(localcc);
    }
    AppMethodBeat.o(114499);
  }
  
  private boolean abI(int paramInt)
  {
    AppMethodBeat.i(114523);
    boolean bool;
    if (gfW())
    {
      this.LoU = false;
      bool = ac.ggS().gfV();
      Log.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + paramInt + ", isILink:" + bool);
      if (bool) {
        break label171;
      }
      bool = ac.ggR().LnJ.abI(paramInt);
      if (u.abL(this.Lod)) {
        ggr();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo result: %b", new Object[] { Boolean.valueOf(bool) });
      int i = this.Lod;
      this.Lod = paramInt;
      if ((this.Lnt != null) && (i != this.Lod)) {
        this.Lnt.jQ(i, this.Lod);
      }
      AppMethodBeat.o(114523);
      return bool;
      ggs();
      continue;
      AppMethodBeat.o(114523);
      return false;
      label171:
      bool = false;
    }
  }
  
  public static boolean abJ(int paramInt)
  {
    AppMethodBeat.i(284874);
    if (!ac.ggS().gfV())
    {
      boolean bool = ac.ggR().LnJ.abI(paramInt);
      AppMethodBeat.o(284874);
      return bool;
    }
    com.tencent.mm.plugin.multitalk.c.o localo = com.tencent.mm.plugin.multitalk.c.o.Ljn;
    localo.au(new o.39(localo, paramInt));
    AppMethodBeat.o(284874);
    return true;
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.o paramo)
  {
    boolean bool = true;
    AppMethodBeat.i(114525);
    Object localObject = this.Lok;
    this.Lok = paramo;
    if (localObject != paramo) {
      if (paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)
      {
        localObject = new tx();
        ((tx)localObject).hXN.type = 1;
        ((tx)localObject).publish();
        o.a(u.j(this.Lol), gfX(), u.k(this.Lol));
        ac.ggS().stopRing();
        com.tencent.mm.plugin.audio.c.a.setMode(3);
        if ((com.tencent.mm.plugin.audio.c.a.cTQ()) || (com.tencent.mm.plugin.audio.c.a.cTX())) {
          break label130;
        }
      }
    }
    for (;;)
    {
      zb(bool);
      ac.ggR().yR(bool);
      if (this.Lnt != null) {
        this.Lnt.a(paramo);
      }
      AppMethodBeat.o(114525);
      return;
      label130:
      bool = false;
    }
  }
  
  private void bYv()
  {
    AppMethodBeat.i(114526);
    Log.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.Lox != null) {
      this.Lox.cancel(false);
    }
    this.Lop = System.currentTimeMillis();
    this.Loq = 0;
    TimerTask local8 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(284853);
        if ((p.this.gfX() >= 45000L) && (p.n(p.this) != com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(284656);
              p.this.j(false, true, false);
              AppMethodBeat.o(284656);
            }
          });
        }
        if (p.n(p.this) == com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)
        {
          p.o(p.this);
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(284659);
              if (p.n(p.this) == com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)
              {
                Object localObject1 = ac.ggT();
                int i = p.this.Loq;
                localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject1).Lvw;
                if (localObject1 != null)
                {
                  Object localObject2 = am.aixg;
                  localObject2 = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }, 2));
                  kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
                  ((com.tencent.mm.plugin.multitalk.ui.widget.m)localObject1).aNF((String)localObject2);
                }
                localObject1 = com.tencent.mm.plugin.multitalk.c.o.Ljn;
                if (com.tencent.mm.plugin.multitalk.c.o.gek() > 0)
                {
                  localObject1 = com.tencent.mm.plugin.multitalk.c.o.Ljn;
                  ((com.tencent.mm.plugin.multitalk.c.o)localObject1).Ljx += 1;
                  if (p.h(p.this) != null)
                  {
                    p.p(p.this);
                    p.q(p.this);
                  }
                }
                if (p.h(p.this) != null) {
                  p.h(p.this).fQZ();
                }
              }
              AppMethodBeat.o(284659);
            }
          });
        }
        AppMethodBeat.o(284853);
      }
    };
    this.Lox = com.tencent.threadpool.h.ahAA.b(local8, 1000L, 1000L);
    AppMethodBeat.o(114526);
  }
  
  private void cIn()
  {
    AppMethodBeat.i(114527);
    if (this.Lox != null)
    {
      this.Lox.cancel(false);
      this.Lox = null;
    }
    AppMethodBeat.o(114527);
  }
  
  public static boolean fwe()
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
  
  public static void fwi()
  {
    AppMethodBeat.i(178891);
    ac.ggT().fwi();
    AppMethodBeat.o(178891);
  }
  
  public static boolean gfU()
  {
    AppMethodBeat.i(284779);
    if (ac.ggS().Loj.contains(z.bAM())) {}
    for (int i = 1;; i = 0)
    {
      if (ac.ggS().Loj.size() > i)
      {
        AppMethodBeat.o(284779);
        return true;
      }
      AppMethodBeat.o(284779);
      return false;
    }
  }
  
  private void gfY()
  {
    AppMethodBeat.i(114494);
    Log.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.Lol.ahhh });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.Lol.ahhh.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.ahhi.equals(z.bAM())) {
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
    this.Lol.ahhh = localLinkedList;
    Log.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.Lol.ahhh });
    AppMethodBeat.o(114494);
  }
  
  private void gfZ()
  {
    AppMethodBeat.i(114495);
    Iterator localIterator = this.Lol.ahhh.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.Loj.remove(localMultiTalkGroupMember.ahhi))) {
        Log.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.ahhi });
      }
    }
    AppMethodBeat.o(114495);
  }
  
  private h ggb()
  {
    AppMethodBeat.i(284814);
    if (this.LoE == null) {
      this.LoE = new s();
    }
    s locals = this.LoE;
    AppMethodBeat.o(284814);
    return locals;
  }
  
  private void ggi()
  {
    AppMethodBeat.i(114504);
    if (this.Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvL) {}
    for (;;)
    {
      boolean bool = false;
      for (p localp = this;; localp = this)
      {
        localp.snA = bool;
        this.lAj = false;
        this.Loy = u.ggD();
        AppMethodBeat.o(114504);
        return;
        if ((com.tencent.mm.plugin.audio.c.a.cTQ()) || (com.tencent.mm.plugin.audio.c.a.cTX())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void ggj()
  {
    AppMethodBeat.i(114508);
    if (u.h(this.Lol)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.LvN);
    }
    while (this.Lnt != null)
    {
      this.Lnt.gau();
      localObject = u.ggD();
      if (localObject != this.Loy) {
        this.Loy = ((u.a)localObject);
      }
      AppMethodBeat.o(114508);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.LvM);
    }
    Object localObject = new Intent();
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(114508);
  }
  
  private void ggp()
  {
    AppMethodBeat.i(284864);
    if (gfV()) {
      this.LoD = com.tencent.mm.plugin.multitalk.c.o.Ljn.gep();
    }
    for (;;)
    {
      com.tencent.mm.plugin.multitalk.b.b.gdW();
      this.LoD.ee(this.snA);
      AppMethodBeat.o(284864);
      return;
      if (this.LoD == null) {
        this.LoD = new com.tencent.mm.plugin.multitalk.b.b();
      }
    }
  }
  
  private void ggq()
  {
    AppMethodBeat.i(114519);
    try
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.rb(26)) && (this.LoC))
      {
        MMApplicationContext.getContext().unbindService(this);
        this.LoC = false;
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
  
  private static boolean iW(Context paramContext)
  {
    AppMethodBeat.i(284838);
    if ((com.tencent.mm.compatible.e.b.dh(paramContext)) && (androidx.core.content.a.checkSelfPermission(paramContext, "android.permission.RECORD_AUDIO") == 0))
    {
      AppMethodBeat.o(284838);
      return true;
    }
    AppMethodBeat.o(284838);
    return false;
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
    AppMethodBeat.i(284804);
    a(this.Lol, paramBoolean1, paramBoolean2, false, paramBoolean3);
    AppMethodBeat.o(284804);
  }
  
  private void yO(boolean paramBoolean)
  {
    AppMethodBeat.i(114512);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b, status=%s", new Object[] { Boolean.valueOf(paramBoolean), this.Lok.toString() });
    this.snA = paramBoolean;
    if (this.Lnt != null) {
      this.Lnt.yO(this.snA);
    }
    if ((paramBoolean) || (com.tencent.mm.plugin.multitalk.b.b.gdX()))
    {
      this.LoN.disable();
      AppMethodBeat.o(114512);
      return;
    }
    if (this.Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)
    {
      aa localaa = this.LoN;
      localaa.xCV.setSensorCallBack(localaa.LqC);
      Log.i("MicroMsg.ScreenSensorController", "enable()");
    }
    AppMethodBeat.o(114512);
  }
  
  public final void L(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(114501);
    Log.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWk, Integer.valueOf(-1));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWl, Long.valueOf(-1L));
    int i;
    int k;
    switch (paramInt)
    {
    default: 
      i = a.h.multitalk_error_600;
    case -100: 
    case -200: 
    case -300: 
    case -400: 
    case -500: 
    case -600: 
    case -700: 
    case -800: 
    case -900: 
    case -1000: 
    case -1100: 
    case -1200: 
    case -1300: 
    case -14256: 
    case -1400: 
      for (;;)
      {
        if (this.Lnt != null) {
          this.Lnt.oc(paramInt);
        }
        if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
        {
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(i, localLinkedList.toArray()), 0).show();
          j(false, false, true);
        }
        AppMethodBeat.o(114501);
        return;
        o.yX(false);
        i = a.h.multitalk_error_100;
        continue;
        o.yY(false);
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
        j = a.h.multitalk_error_1300;
        this.Lou = true;
        this.Lov = System.currentTimeMillis();
        i = j;
        if (paramObject != null)
        {
          paramObject = (a.ab)paramObject;
          i = j;
          if (paramObject != null)
          {
            Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.aheW);
            i = j;
            if (paramObject.aheW != 0)
            {
              i = a.h.multitalk_error_1301;
              this.Low = (paramObject.aheW * 1000L);
              localLinkedList.add(Integer.valueOf(paramObject.aheW));
              continue;
              Log.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
              j = a.h.multitalk_error_14256;
              i = j;
              if (paramObject != null)
              {
                i = j;
                if ((a.ac)paramObject != null)
                {
                  com.tencent.wecall.talkroom.model.a.kdP().OL(false);
                  i = j;
                  continue;
                  i = a.h.multitalk_error_1400;
                }
              }
            }
          }
        }
      }
    case -14255: 
      MultiTalkGroup localMultiTalkGroup = this.Lol;
      if (this.Lol != null) {}
      for (String str = this.Lol.LiV;; str = "")
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
        if (paramObject != null)
        {
          paramObject = (a.ac)paramObject;
          if (paramObject != null)
          {
            Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
            if (paramObject.ahdv != null)
            {
              ac.ggV().aMV(paramObject.ahdv.ahfW);
              Log.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.ahdv.ahfW);
            }
            if (!ac.ggR().LnJ.aMT(paramObject.groupId)) {
              Log.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
            }
          }
        }
        i = a.h.multitalk_system_master_finish_exit_msg;
        break;
      }
    case -1700: 
      Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
      k = a.h.multitalk_disabled;
      i = k;
      if (paramObject != null) {
        if (!(paramObject instanceof Integer)) {
          break label973;
        }
      }
      break;
    }
    label973:
    for (int j = ((Integer)paramObject).intValue();; j = 0)
    {
      i = k;
      if (j > 0)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWk, Integer.valueOf(j));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWl, Long.valueOf(Util.currentTicks()));
        i = a.h.multitalk_error_1301;
        localLinkedList.add(Integer.valueOf(j));
      }
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(i, localLinkedList.toArray()), 0).show();
      break;
      Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
      i = a.h.multitalk_network_failed;
      break;
      Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
      AppMethodBeat.o(114501);
      return;
      Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
      i = a.h.multitalk_error_14287;
      break;
      Log.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
      i = a.h.multitalk_error_14287;
      break;
    }
  }
  
  public final void a(MultiTalkGroup paramMultiTalkGroup, long paramLong)
  {
    AppMethodBeat.i(285187);
    com.tencent.mm.plugin.multitalk.e.d locald = com.tencent.mm.plugin.multitalk.e.d.LAq;
    com.tencent.mm.plugin.multitalk.e.d.sy(paramLong);
    d(paramMultiTalkGroup);
    AppMethodBeat.o(285187);
  }
  
  public final void a(final MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(114503);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      ggp();
      this.Lob = false;
      ggi();
      bYv();
      final Intent localIntent = new Intent();
      RemoteViews localRemoteViews = null;
      String str1 = "";
      final String str2 = u.l(paramMultiTalkGroup);
      if (!paramBoolean.booleanValue())
      {
        if ((com.tencent.mm.compatible.util.d.rd(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
          i = 1;
        }
        if (i != 0) {
          this.LoQ = new a(paramMultiTalkGroup, Boolean.FALSE);
        }
        str1 = MMApplicationContext.getResources().getString(a.h.multitalk_invite_wording);
        localIntent.putExtra("Voip_User", str2);
        String str3 = com.tencent.mm.model.aa.getDisplayName(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localIntent.getStringExtra("Voip_User")).field_username);
        localRemoteViews = new RemoteViews(MMApplicationContext.getPackageName(), a.f.multitalk_calling_notification);
        localRemoteViews.setTextViewText(a.e.notification_type, str1);
        localRemoteViews.setTextViewText(a.e.notification_name, str3);
        localRemoteViews.setImageViewResource(a.e.wechat_icon, a.d.wechat_appicon);
        localRemoteViews.setImageViewResource(a.e.notification_avatar, a.d.voice_call);
        str1 = str3 + str1;
      }
      if ((!paramBoolean.booleanValue()) && (!this.LoR) && (iW(MMApplicationContext.getContext())) && (AppForegroundDelegate.heY.eLx) && (geX()))
      {
        this.LoR = true;
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(284876);
            p.a(p.this).Liy = paramMultiTalkGroup;
            com.tencent.mm.plugin.multitalk.ui.a locala = p.a(p.this);
            Context localContext = MMApplicationContext.getContext();
            Intent localIntent = localIntent;
            String str = str2;
            kotlin.g.b.s.u(localContext, "context");
            kotlin.g.b.s.u(localIntent, "intent");
            kotlin.g.b.s.u(str, "toUser");
            com.tencent.mm.plugin.voip.floatcard.a.a(locala, localContext, localIntent, str);
            p.this.zd(false);
            AppMethodBeat.o(284876);
          }
        });
        AppMethodBeat.o(114503);
        return;
      }
      localIntent.putExtra("Voip_Outcall", paramBoolean);
      localIntent.addFlags(268435456);
      if ((com.tencent.mm.plugin.ringtone.c.gOj()) && (com.tencent.mm.compatible.util.l.isSamsung()))
      {
        paramMultiTalkGroup = FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), com.tencent.mm.vfs.u.V(new File(com.tencent.mm.plugin.ringtone.d.aUu("").gOC())));
        MMApplicationContext.getContext().grantUriPermission("com.android.systemui", paramMultiTalkGroup, 1);
      }
      com.tencent.mm.util.a.a(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", localIntent, localRemoteViews, str1, com.tencent.mm.plugin.ringtone.d.aUv(""));
    }
    AppMethodBeat.o(114503);
  }
  
  public final void aF(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(285211);
    Log.i("MicroMsg.MT.MultiTalkManager", "onDoScreenSharingSecurityCheck filemd5:%s ret:%d checkRet:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.threadpool.h.ahAA.bFQ("delayChecking");
    ab localab = this.LoS;
    if (localab == null)
    {
      Log.w("MicroMsg.MT.MultiTalkManager", "mFileSecurity is null");
      AppMethodBeat.o(285211);
      return;
    }
    if (paramInt2 == 0) {}
    for (;;)
    {
      localab.LqD = Boolean.valueOf(bool);
      localab.md5 = paramString;
      if (this.LoT != null) {
        this.LoT.t(localab);
      }
      AppMethodBeat.o(285211);
      return;
      bool = false;
    }
  }
  
  public final boolean aNd(String paramString)
  {
    AppMethodBeat.i(284999);
    if ((this.LoH.geG()) && (this.LoH.geH() == paramString))
    {
      AppMethodBeat.o(284999);
      return true;
    }
    AppMethodBeat.o(284999);
    return false;
  }
  
  public final boolean aNe(String paramString)
  {
    AppMethodBeat.i(285003);
    String str = paramString;
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.Lol.LiU;
      str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = this.Lol.ahhf;
      }
    }
    if (this.LoM.containsKey(str)) {}
    for (int i = ((Integer)this.LoM.get(str)).intValue();; i = 0)
    {
      if (i == 2)
      {
        AppMethodBeat.o(285003);
        return true;
      }
      AppMethodBeat.o(285003);
      return false;
    }
  }
  
  public final void aNf(String paramString)
  {
    AppMethodBeat.i(285016);
    Log.i("MicroMsg.MT.MultiTalkManager", "removeCurrentMTSDKMode groupid:%s", new Object[] { paramString });
    if ((this.LoM != null) && (this.LoM.containsKey(paramString))) {
      this.LoM.remove(paramString);
    }
    AppMethodBeat.o(285016);
  }
  
  public final boolean aNg(String paramString)
  {
    AppMethodBeat.i(285074);
    ArrayList localArrayList = new ArrayList(this.LoO);
    if (localArrayList.contains(paramString))
    {
      AppMethodBeat.o(285074);
      return true;
    }
    localArrayList.add(paramString);
    this.LoO = new CopyOnWriteArrayList(localArrayList);
    AppMethodBeat.o(285074);
    return false;
  }
  
  public final void aNh(String paramString)
  {
    AppMethodBeat.i(285076);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.LoO.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.equals(paramString)) {
        localArrayList.add(str);
      }
    }
    this.LoO = new CopyOnWriteArrayList(localArrayList);
    AppMethodBeat.o(285076);
  }
  
  public final void aNj(String paramString)
  {
    AppMethodBeat.i(285115);
    cc localcc = new cc();
    localcc.setType(64);
    localcc.setCreateTime(System.currentTimeMillis());
    localcc.setStatus(6);
    localcc.setContent(MMApplicationContext.getContext().getString(a.h.multitalk_system_master_multi_finish_msg));
    if (v.If(paramString))
    {
      localcc.BS(paramString);
      localcc.setContent(localcc.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(localcc);
    }
    if ((this.LoA != null) && (paramString.equals(this.LoA.LiV)) && (!this.LoP.stopped()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
      this.LoA = null;
      this.LoB = 0L;
      this.LoP.stopTimer();
    }
    AppMethodBeat.o(285115);
  }
  
  public final boolean aNl(String paramString)
  {
    AppMethodBeat.i(114524);
    if (gfW())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      if (gfV())
      {
        if (paramString.equals(""))
        {
          this.Lnt.gfb();
          Log.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe small video of visiable region OK!");
        }
        for (;;)
        {
          AppMethodBeat.o(114524);
          return true;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramString);
          com.tencent.mm.plugin.multitalk.c.o.Ljn.aZ(localArrayList);
          Log.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe large video OK, mems:".concat(String.valueOf(localArrayList)));
        }
      }
      boolean bool = ac.ggR().LnJ.aNl(paramString);
      Log.i("MicroMsg.MT.MultiTalkManager", "result of old subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(114524);
      return bool;
    }
    AppMethodBeat.o(114524);
    return false;
  }
  
  public final void abC(int paramInt)
  {
    AppMethodBeat.i(285253);
    h localh = ggb();
    if (localh != null) {
      localh.abC(paramInt);
    }
    AppMethodBeat.o(285253);
  }
  
  public final void abH(int paramInt)
  {
    AppMethodBeat.i(114515);
    Log.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.Loz = true;
      AppMethodBeat.o(114515);
      return;
    }
    this.Loz = false;
    AppMethodBeat.o(114515);
  }
  
  public final void as(String arg1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(285050);
    Object localObject1 = Util.stringsToList(???.split(","));
    Object localObject2;
    Object localObject3;
    Object localObject4;
    synchronized (this.LoK)
    {
      if (this.Lok != com.tencent.mm.plugin.multitalk.ui.widget.o.LvJ)
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "already in multitalk! cannot start again, status:%s", new Object[] { this.Lok.toString() });
        AppMethodBeat.o(285050);
        return;
      }
      if (paramInt != 2) {
        break label272;
      }
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = new com.tencent.mm.plugin.multitalk.c.i();
        ((com.tencent.mm.plugin.multitalk.c.i)localObject4).luk = ((String)localObject3);
        ((com.tencent.mm.plugin.multitalk.c.i)localObject4).mStatus = 2;
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    com.tencent.mm.plugin.multitalk.c.o.Ljn.T(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1)), z.bAM());
    localObject1 = com.tencent.mm.plugin.multitalk.c.o.Ljn;
    Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkInvite. %s, %s", new Object[] { localObject2, paramString2 });
    ((com.tencent.mm.plugin.multitalk.c.o)localObject1).Lkg = paramString2;
    ((com.tencent.mm.plugin.multitalk.c.o)localObject1).au(new o.12((com.tencent.mm.plugin.multitalk.c.o)localObject1, (ArrayList)localObject2, paramString2));
    gg(paramString2, 2);
    b(com.tencent.mm.plugin.multitalk.ui.widget.o.LvL);
    boolean bool = true;
    if (bool) {
      o.gfD();
    }
    for (;;)
    {
      paramString2 = com.tencent.mm.plugin.multitalk.e.e.LAH;
      com.tencent.mm.plugin.multitalk.e.e.reset();
      AppMethodBeat.o(285050);
      return;
      label272:
      localObject2 = new MultiTalkGroup();
      ((MultiTalkGroup)localObject2).ahhf = ac.ggR().LnJ.jRv();
      ((MultiTalkGroup)localObject2).LiV = paramString2;
      localObject3 = ((List)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
        localMultiTalkGroupMember.ahhi = ((String)localObject4);
        if (((String)localObject4).equals(z.bAM())) {}
        for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
        {
          ((MultiTalkGroup)localObject2).ahhh.add(localMultiTalkGroupMember);
          break;
        }
      }
      ac.ggR().LnJ.em(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1)), z.bAM());
      bool = ac.ggR().LnJ.a(((MultiTalkGroup)localObject2).ahhf, paramString2, (List)localObject1, v2protocal.hZn());
      gg(paramString2, 1);
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.LvL);
      a((MultiTalkGroup)localObject2, Boolean.TRUE);
      break;
      o.gfE();
    }
  }
  
  public final void b(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114502);
    boolean bool2 = this.lAj;
    boolean bool3 = this.snA;
    boolean bool4 = this.Loe;
    Object localObject = this.Lok.toString();
    if (this.Lol == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      o.gfK();
      if ((com.tencent.mm.k.h.aQH()) || (isAppOnForeground(MMApplicationContext.getContext()))) {
        break;
      }
      Log.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.LoA == null) && (this.LoP.stopped()))
      {
        this.LoA = paramMultiTalkGroup;
        this.LoP.startTimer(2000L);
        this.LoB = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(114502);
      return;
    }
    localObject = u.l(paramMultiTalkGroup);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject);
    if ((!com.tencent.mm.bc.e.bND()) || (localau == null) || (localau.aSF()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114485);
          String str2 = paramMultiTalkGroup.LiU;
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.ahhf;
          }
          ac.ggR().LnJ.aMT(str1);
          AppMethodBeat.o(114485);
        }
      }, 1000L);
      o.co(3, u.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if ((geX()) || (com.tencent.mm.plugin.voip.f.m.isVoipStarted()) || (com.tencent.mm.plugin.voip.f.m.icd()) || (com.tencent.mm.bc.e.bNC()) || (com.tencent.mm.bc.e.isCalling()) || (com.tencent.mm.plugin.voip.f.m.ice()) || (!com.tencent.mm.contact.d.rs(localau.field_type)))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { u.g(paramMultiTalkGroup) });
      if (!v.Id(paramMultiTalkGroup.LiV))
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.LiV });
        az.a.okP.a(paramMultiTalkGroup.LiV, "", new az.b.a()
        {
          public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean) {}
        });
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114476);
          String str2 = paramMultiTalkGroup.LiU;
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = paramMultiTalkGroup.ahhf;
          }
          ac.ggR().LnJ.aMT(str1);
          AppMethodBeat.o(114476);
        }
      }, 1000L);
      o.co(3, u.k(paramMultiTalkGroup));
      AppMethodBeat.o(114502);
      return;
    }
    if (!v.Id(paramMultiTalkGroup.LiV))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.LiV });
      az.a.okP.a(paramMultiTalkGroup.LiV, "", null);
    }
    Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { u.g(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.o.LvK);
    o.co(1, u.k(paramMultiTalkGroup));
    if ((!com.tencent.mm.contact.d.rs(localau.field_type)) || (com.tencent.mm.n.a.aTg()))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { localObject, z.bAM() });
      if (a(paramMultiTalkGroup))
      {
        this.Lob = false;
        ggi();
        bYv();
        AppMethodBeat.o(114502);
      }
    }
    else
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { localObject, z.bAM() });
      localObject = new os();
      ((os)localObject).hRy.action = 3;
      ((os)localObject).publish();
      a(paramMultiTalkGroup, Boolean.FALSE);
    }
    AppMethodBeat.o(114502);
  }
  
  public final void b(MultiTalkGroup paramMultiTalkGroup, long paramLong)
  {
    AppMethodBeat.i(285196);
    com.tencent.mm.plugin.multitalk.e.d locald = com.tencent.mm.plugin.multitalk.e.d.LAq;
    com.tencent.mm.plugin.multitalk.e.d.sy(paramLong);
    e(paramMultiTalkGroup);
    AppMethodBeat.o(285196);
  }
  
  public final boolean bl(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(285286);
    if (paramBoolean)
    {
      if (gfW())
      {
        this.LoU = true;
        this.Lod = paramInt;
        if (!ac.ggS().gfV())
        {
          paramBoolean = ac.ggR().LnJ.abI(paramInt);
          AppMethodBeat.o(285286);
          return paramBoolean;
        }
        AppMethodBeat.o(285286);
        return true;
      }
      AppMethodBeat.o(285286);
      return false;
    }
    paramBoolean = abI(paramInt);
    AppMethodBeat.o(285286);
    return paramBoolean;
  }
  
  public final void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114505);
    o.co(2, u.k(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.o.LvK, true);
    AppMethodBeat.o(114505);
  }
  
  public final void c(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114498);
    if (!v.Id(paramString1))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      az.a.okP.a(paramString1, "", new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    cc localcc = new cc();
    localcc.setType(64);
    localcc.setCreateTime(System.currentTimeMillis());
    localcc.setStatus(6);
    localcc.pI(2);
    paramString2 = aNi(paramString2);
    localcc.setContent(paramString2);
    if (v.If(paramString1))
    {
      localcc.BS(paramString1);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(localcc);
      com.tencent.mm.storage.bb localbb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(paramString1);
      if (localbb != null)
      {
        if (paramBoolean1) {
          localbb.pG(localbb.field_unReadCount + 1);
        }
        localbb.setContent(paramString2);
        if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(localbb, paramString1) == -1) {
          Log.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
        }
        if (paramBoolean2)
        {
          ((com.tencent.mm.model.bb)((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification()).a(localcc);
          AppMethodBeat.o(114498);
        }
      }
      else
      {
        localbb = new com.tencent.mm.storage.bb();
        localbb.setUsername(paramString1);
        if (paramBoolean1) {
          localbb.pG(1);
        }
        localbb.setContent(paramString2);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().h(localbb);
        if (paramBoolean2) {
          ((com.tencent.mm.model.bb)((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification()).a(localcc);
        }
      }
    }
    AppMethodBeat.o(114498);
  }
  
  public final void cu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(285294);
    if (gfV())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast exit due to ILINK mode!!!");
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString)) {
        localArrayList.add(paramString);
      }
      com.tencent.mm.plugin.multitalk.c.o.Ljn.e(localArrayList, paramBoolean);
      AppMethodBeat.o(285294);
      return;
    }
    if (this.Lom == null) {
      this.Lom = new y();
    }
    this.Lom.a(ggf());
    if (TextUtils.isEmpty(paramString))
    {
      this.Lom.ggK();
      AppMethodBeat.o(285294);
      return;
    }
    Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast ownerUserName : ".concat(String.valueOf(paramString)));
    this.Lom.aNt(paramString);
    Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast error");
    AppMethodBeat.o(285294);
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114506);
    Log.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { u.g(paramMultiTalkGroup) });
    o.yX(true);
    if (a(paramMultiTalkGroup))
    {
      com.tencent.mm.plugin.multitalk.e.d locald = com.tencent.mm.plugin.multitalk.e.d.LAq;
      com.tencent.mm.plugin.multitalk.e.d.zz(gfV());
      locald = com.tencent.mm.plugin.multitalk.e.d.LAq;
      com.tencent.mm.plugin.multitalk.e.d.aNK(paramMultiTalkGroup.LiU);
      if ((paramMultiTalkGroup != null) && (paramMultiTalkGroup.ahhh != null))
      {
        locald = com.tencent.mm.plugin.multitalk.e.d.LAq;
        com.tencent.mm.plugin.multitalk.e.d.jd(paramMultiTalkGroup.ahhh);
      }
      ggj();
    }
    AppMethodBeat.o(114506);
  }
  
  public final boolean dro()
  {
    AppMethodBeat.i(285331);
    if (this.LoD != null)
    {
      boolean bool = com.tencent.mm.plugin.multitalk.b.b.gea();
      AppMethodBeat.o(285331);
      return bool;
    }
    AppMethodBeat.o(285331);
    return true;
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114507);
    Log.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { u.g(paramMultiTalkGroup) });
    Object localObject = new tx();
    ((tx)localObject).hXN.type = 1;
    ((tx)localObject).publish();
    o.yY(true);
    if (this.Lok != com.tencent.mm.plugin.multitalk.ui.widget.o.LvK)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.o.LvM);
      a(paramMultiTalkGroup, Boolean.TRUE);
    }
    if ((geX()) && (a(paramMultiTalkGroup)))
    {
      localObject = com.tencent.mm.plugin.multitalk.e.d.LAq;
      com.tencent.mm.plugin.multitalk.e.d.zz(gfV());
      localObject = com.tencent.mm.plugin.multitalk.e.d.LAq;
      com.tencent.mm.plugin.multitalk.e.d.aNK(paramMultiTalkGroup.LiU);
      if ((paramMultiTalkGroup != null) && (paramMultiTalkGroup.ahhh != null))
      {
        localObject = com.tencent.mm.plugin.multitalk.e.d.LAq;
        com.tencent.mm.plugin.multitalk.e.d.jd(paramMultiTalkGroup.ahhh);
      }
      ggj();
    }
    AppMethodBeat.o(114507);
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(114509);
    Log.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { u.g(paramMultiTalkGroup) });
    if ((geX()) && (a(paramMultiTalkGroup)))
    {
      if (!u.i(this.Lol))
      {
        if (this.Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvK)
        {
          j(false, true, false);
          AppMethodBeat.o(114509);
          return;
        }
        j(false, false, false);
        AppMethodBeat.o(114509);
        return;
      }
      if ((paramMultiTalkGroup != null) && (paramMultiTalkGroup.ahhh != null))
      {
        com.tencent.mm.plugin.multitalk.e.d locald = com.tencent.mm.plugin.multitalk.e.d.LAq;
        com.tencent.mm.plugin.multitalk.e.d.jd(paramMultiTalkGroup.ahhh);
      }
      if ((this.Lok != com.tencent.mm.plugin.multitalk.ui.widget.o.LvN) && (u.h(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.o.LvN);
      }
      if ((this.Lnt != null) && (u.c(this.Lok))) {
        this.Lnt.geZ();
      }
      if (this.Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvK) {
        this.LoI.m(paramMultiTalkGroup);
      }
    }
    AppMethodBeat.o(114509);
  }
  
  public final boolean geW()
  {
    AppMethodBeat.i(114491);
    if (this.Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvN) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114491);
      return bool;
    }
  }
  
  public final boolean geX()
  {
    AppMethodBeat.i(114489);
    if ((this.Lok != com.tencent.mm.plugin.multitalk.ui.widget.o.LvJ) && (this.Lol != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114489);
      return bool;
    }
  }
  
  public final List<String> gew()
  {
    AppMethodBeat.i(285315);
    if (this.Lol == null)
    {
      AppMethodBeat.o(285315);
      return null;
    }
    String str = this.Lol.LiU;
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = this.Lol.ahhf;
    }
    boolean bool = aNe(this.Lol.LiV);
    Log.d("MicroMsg.MT.MultiTalkManager", "getTalkingMember: %s, groupid:%s, isILink:%b", new Object[] { u.g(this.Lol), this.Lol.LiV, Boolean.valueOf(bool) });
    new ArrayList();
    if (bool) {}
    for (localObject = com.tencent.mm.plugin.multitalk.c.o.Ljn.gew();; localObject = ac.ggR().LnJ.bFm((String)localObject))
    {
      AppMethodBeat.o(285315);
      return localObject;
    }
  }
  
  public final boolean gfV()
  {
    AppMethodBeat.i(285007);
    if (this.Lol != null)
    {
      boolean bool = aNe(this.Lol.LiV);
      AppMethodBeat.o(285007);
      return bool;
    }
    AppMethodBeat.o(285007);
    return false;
  }
  
  public final boolean gfW()
  {
    AppMethodBeat.i(114490);
    if ((this.Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvM) || (this.Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(114490);
      return bool;
    }
  }
  
  public final long gfX()
  {
    AppMethodBeat.i(114492);
    long l1 = System.currentTimeMillis();
    long l2 = this.Lop;
    AppMethodBeat.o(114492);
    return l1 - l2;
  }
  
  public final void gfc()
  {
    AppMethodBeat.i(285343);
    if ((ac.ggS().gfW()) && (this.Lnt != null))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "exitProjectScreen");
      this.Lnt.gfc();
    }
    AppMethodBeat.o(285343);
  }
  
  public final void gg(String paramString, int paramInt)
  {
    AppMethodBeat.i(285012);
    Log.i("MicroMsg.MT.MultiTalkManager", "setCurrentMTSDKMode groupid:%s, mode:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.LoM == null)
    {
      AppMethodBeat.o(285012);
      return;
    }
    if ((!this.LoM.containsKey(paramString)) || (((Integer)this.LoM.get(paramString)).intValue() != paramInt)) {
      this.LoM.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(285012);
  }
  
  public final void gga()
  {
    AppMethodBeat.i(285056);
    if (geX())
    {
      boolean bool = aNe(this.Lol.LiV);
      Log.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s, wifigateway:%s, isILink:%b", new Object[] { u.g(this.Lol), v2protocal.hZn(), Boolean.valueOf(bool) });
      if (bool) {
        for (;;)
        {
          synchronized (this.LoL)
          {
            com.tencent.mm.plugin.multitalk.c.o localo1 = com.tencent.mm.plugin.multitalk.c.o.Ljn;
            if (localo1.wVP)
            {
              Log.i("MicroMsg.Multitalk.ILinkService", "steve: already accept!!!");
              AppMethodBeat.o(285056);
              return;
            }
            localo1.Lkn = o.b.LlX;
            localo1.wVK = false;
            localo1.LjW = new o.24(localo1);
            localo1.LjX = new o.25(localo1);
            localo1.LjK = new o.26(localo1);
            localo1.LjL = new o.27(localo1);
            localo1.Ljp.a(14, localo1.LjW);
            localo1.Ljp.a(15, localo1.LjX);
            localo1.Ljp.a(22, localo1.LjK);
            localo1.Ljp.a(23, localo1.LjL);
            localo1.drk();
            if (SubCoreVoip.hVs()) {
              localo1.geA();
            }
            int i = com.tencent.mm.plugin.multitalk.c.l.gem();
            if (i != 0) {
              localo1.c(null, -10086, -4, "accept room sdk failed: ".concat(String.valueOf(i)));
            }
          }
          localo2.wVP = true;
          localo2.d(new o.28(localo2));
        }
      }
      ac.ggR().LnJ.n(this.Lol.LiU, this.Lol.ahcO, this.Lol.LiV, v2protocal.hZn());
      ??? = com.tencent.mm.plugin.multitalk.e.e.LAH;
      com.tencent.mm.plugin.multitalk.e.e.reset();
      AppMethodBeat.o(285056);
      return;
    }
    Log.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
    AppMethodBeat.o(285056);
  }
  
  public final s ggc()
  {
    AppMethodBeat.i(285090);
    if (this.LoE == null) {
      this.LoE = new s();
    }
    s locals = this.LoE;
    AppMethodBeat.o(285090);
    return locals;
  }
  
  public final af ggd()
  {
    AppMethodBeat.i(285093);
    if (this.LoF == null) {
      this.LoF = new ag(ac.ggR().LnJ);
    }
    ag localag = this.LoF;
    AppMethodBeat.o(285093);
    return localag;
  }
  
  public final void gge()
  {
    AppMethodBeat.i(285095);
    if (this.LoF == null)
    {
      AppMethodBeat.o(285095);
      return;
    }
    this.LoF.close();
    this.LoF = null;
    AppMethodBeat.o(285095);
  }
  
  public final ae ggf()
  {
    AppMethodBeat.i(285101);
    if (this.LoG == null) {
      this.LoG = new ae();
    }
    ae localae = this.LoG;
    AppMethodBeat.o(285101);
    return localae;
  }
  
  public final a ggg()
  {
    AppMethodBeat.i(285111);
    if (this.LoH == null) {
      this.LoH = new a();
    }
    a locala = this.LoH;
    AppMethodBeat.o(285111);
    return locala;
  }
  
  public final void ggh()
  {
    AppMethodBeat.i(162239);
    this.LoQ = null;
    this.Lot = false;
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(41);
    AppMethodBeat.o(162239);
  }
  
  public final void ggk()
  {
    AppMethodBeat.i(114510);
    Log.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(114510);
  }
  
  public final void ggl()
  {
    AppMethodBeat.i(114513);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.Lod) });
    AppMethodBeat.o(114513);
  }
  
  public final void ggm()
  {
    AppMethodBeat.i(114514);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(114514);
  }
  
  public final void ggn()
  {
    AppMethodBeat.i(178889);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
    AppMethodBeat.o(178889);
  }
  
  public final void ggo()
  {
    AppMethodBeat.i(285236);
    Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeScreenSharingVideoSuss ");
    AppMethodBeat.o(285236);
  }
  
  public final void ggr()
  {
    AppMethodBeat.i(114520);
    Log.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (gfV())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver exit due to ILINK mode!!!");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.Lnt == null)
    {
      Log.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.Loj.size() == 0)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(114520);
      return;
    }
    if (this.Lom == null)
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkDataSource: NetworkDataSource is null %d", new Object[] { Integer.valueOf(this.Loj.size()) });
      this.Lom = new y();
    }
    this.Lom.a(ggf());
    this.Lom.start();
    if (ggg().geG()) {
      cu(ggg().geH(), false);
    }
    AppMethodBeat.o(114520);
  }
  
  public final void ggs()
  {
    AppMethodBeat.i(114521);
    Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
    if (this.Lom != null)
    {
      this.Lom.stop();
      this.Lom = null;
    }
    AppMethodBeat.o(114521);
  }
  
  public final void ggt()
  {
    AppMethodBeat.i(285300);
    if (this.Lom == null) {
      this.Lom = new y();
    }
    this.Lom.a(ggf());
    this.Lom.start();
    ac.ggS().ggd().zh(true);
    AppMethodBeat.o(285300);
  }
  
  public final void iY(List<a.ar> paramList)
  {
    AppMethodBeat.i(114516);
    if (geX())
    {
      this.Loj.clear();
      Log.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.ar localar = (a.ar)((Iterator)localObject).next();
        if ((localar.videoStatus == 2) || (localar.videoStatus == 3)) {
          this.Loj.add(localar.hJs);
        }
      }
      localObject = com.tencent.mm.plugin.multitalk.e.d.LAq;
      com.tencent.mm.plugin.multitalk.e.d.acc(this.Loj.size());
      localObject = ggb();
      if (localObject != null) {
        ((h)localObject).iY(paramList);
      }
      Log.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.Loj });
      if (this.Lnt != null)
      {
        this.Lnt.gfa();
        AppMethodBeat.o(114516);
        return;
      }
      Log.e("MicroMsg.MT.MultiTalkManager", "uiCallback is NULL !!!");
    }
    AppMethodBeat.o(114516);
  }
  
  public final void iZ(List<String> paramList)
  {
    AppMethodBeat.i(285038);
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    if (geX())
    {
      localObject2 = this.Lol.LiU;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = this.Lol.ahhf;
      }
      boolean bool = aNe(this.Lol.LiV);
      Log.i("MicroMsg.MT.MultiTalkManager", "addMemberList: %s, wifigateway:%s, groupid:%s, isILink:%b", new Object[] { u.g(this.Lol), v2protocal.hZn(), this.Lol.LiV, Boolean.valueOf(bool) });
      if (bool)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.c.o.Ljn;
        localObject2 = new LinkedList();
        localArrayList = ((com.tencent.mm.plugin.multitalk.c.o)localObject1).LiH.geh();
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
        com.tencent.mm.plugin.multitalk.c.i locali;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locali = (com.tencent.mm.plugin.multitalk.c.i)localIterator.next();
        } while ((!str.equals(locali.luk)) || ((locali.mStatus != 1) && (locali.mStatus != 2) && (locali.mStatus != 3)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label292;
        }
        ((LinkedList)localObject2).add(str);
        break;
        IPCRunCgi.a(com.tencent.mm.plugin.multitalk.c.h.bE((LinkedList)localObject2), new o.22((com.tencent.mm.plugin.multitalk.c.o)localObject1));
        AppMethodBeat.o(285038);
        return;
        ac.ggR().LnJ.X((String)localObject1, paramList);
        AppMethodBeat.o(285038);
        return;
      }
    }
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(114497);
    Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114481);
        com.tencent.mm.plugin.voip.floatcard.a.a(p.a(p.this), false, false, 3);
        AppMethodBeat.o(114481);
      }
    });
    this.LoN.disable();
    this.LoR = false;
    ggb().close();
    com.tencent.threadpool.h.ahAA.bFQ("delayChecking");
    this.LoS = null;
    if (this.LoT != null)
    {
      this.LoT.t(null);
      this.LoT = null;
    }
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(41);
    ac.ggS().stopRing();
    Object localObject;
    if (geX())
    {
      localObject = new tx();
      ((tx)localObject).hXN.type = 2;
      ((tx)localObject).publish();
      k(paramBoolean1, paramBoolean2, paramBoolean3);
      localObject = com.tencent.mm.plugin.multitalk.e.d.LAq;
      com.tencent.mm.plugin.multitalk.e.d.aE(paramBoolean1, paramBoolean2);
      localObject = this.Lok;
      if (this.Lnt != null) {
        this.Lnt.geY();
      }
      this.Loi = false;
      this.Lon = false;
      this.Loo = false;
      this.Lok = com.tencent.mm.plugin.multitalk.ui.widget.o.LvJ;
      ggs();
      gge();
      yZ(false);
      this.LoH = null;
      xz(true);
      cIn();
      if (this.LoD != null)
      {
        this.LoD.ged();
        com.tencent.mm.plugin.multitalk.b.b.unInit();
        this.LoD = null;
      }
      ac.ggQ().reset();
      if (this.Lol != null)
      {
        a(this.Lol, (com.tencent.mm.plugin.multitalk.ui.widget.o)localObject, paramBoolean2);
        String str = this.Lol.LiU;
        localObject = str;
        if (Util.isNullOrNil(str)) {
          localObject = this.Lol.ahhf;
        }
        Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isILinkMode %b", new Object[] { Boolean.valueOf(gfV()) });
        com.tencent.mm.plugin.multitalk.c.o.Ljn.abA(1);
        ac.ggR().LnJ.aMT((String)localObject);
        this.Lol = null;
        this.Lod = 0;
        this.snA = true;
        this.lAj = false;
        this.Loe = true;
        this.Lop = 0L;
        this.Loq = 0;
        this.Loj.clear();
        new gf().publish();
        this.Lot = true;
      }
    }
    for (;;)
    {
      this.LoO.clear();
      localObject = com.tencent.mm.plugin.multitalk.e.e.LAH;
      com.tencent.mm.plugin.multitalk.e.e.report();
      ggq();
      AppMethodBeat.o(114497);
      return;
      Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: currentMultiTalkGroup null");
      break;
      Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: not connecting, isHangupMultitalk %b, isOverLoadFail %b", new Object[] { Boolean.valueOf(this.Lot), Boolean.valueOf(this.Lou) });
      if ((!this.Lot) || (this.Lou))
      {
        ggs();
        xz(false);
        cIn();
        if (this.LoD != null)
        {
          this.LoD.ged();
          this.LoD = null;
        }
        this.Lol = null;
        this.Lod = 0;
        this.Lot = false;
        this.Lop = 0L;
        this.Loq = 0;
        this.Loj.clear();
        this.Lok = com.tencent.mm.plugin.multitalk.ui.widget.o.LvJ;
        this.Lor = 0;
      }
    }
  }
  
  public final boolean ja(List<a.aq> paramList)
  {
    AppMethodBeat.i(285307);
    if (gfW())
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(paramList)));
      boolean bool = ac.ggR().LnJ.ja(paramList);
      Log.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(285307);
      return bool;
    }
    AppMethodBeat.o(285307);
    return false;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void stopRing()
  {
    AppMethodBeat.i(114529);
    if ((this.Lob) && (this.LoD != null))
    {
      this.LoD.geb();
      this.Lob = false;
    }
    AppMethodBeat.o(114529);
  }
  
  public final void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(178890);
    this.JFE = false;
    if (paramBoolean) {
      ac.ggT().ghz();
    }
    for (;;)
    {
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).cancel(43);
      ggq();
      AppMethodBeat.o(178890);
      return;
      ac.ggT().jb(false);
    }
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(114511);
    this.lAj = paramBoolean;
    if (this.Lnt != null) {
      this.Lnt.yN(this.lAj);
    }
    AppMethodBeat.o(114511);
  }
  
  public final void yP(boolean paramBoolean)
  {
    AppMethodBeat.i(114532);
    this.snA = paramBoolean;
    if ((ac.ggS().gfW()) && (this.Lnt != null))
    {
      Log.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.Lnt.yP(paramBoolean);
    }
    AppMethodBeat.o(114532);
  }
  
  public final void yZ(boolean paramBoolean)
  {
    AppMethodBeat.i(285109);
    if (this.LoG == null)
    {
      AppMethodBeat.o(285109);
      return;
    }
    this.LoG.K(paramBoolean);
    if (!paramBoolean) {
      this.LoG = null;
    }
    AppMethodBeat.o(285109);
  }
  
  public final void za(final boolean paramBoolean)
  {
    AppMethodBeat.i(114517);
    if (geX())
    {
      if (this.JFE)
      {
        AppMethodBeat.o(114517);
        return;
      }
      Object localObject1 = MMApplicationContext.getContext().getString(a.h.multitalk);
      String str = MMApplicationContext.getContext().getString(a.h.multitalk_recover);
      Object localObject2 = new Intent();
      if (this.Log)
      {
        ((Intent)localObject2).putExtra("enterMainUIScreenProjectOnline", true);
        ((Intent)localObject2).putExtra("enterMainUIScreenProjectParams", this.Loh);
      }
      ((Intent)localObject2).setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, (Intent)localObject2, 134217728);
      int i = a.d.notification_icon_gray;
      if (com.tencent.mm.compatible.util.d.rc(19)) {
        i = a.d.notification_icon;
      }
      localObject1 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(str).bt(System.currentTimeMillis()).l((CharSequence)localObject1).m(str);
      ((f.d)localObject1).bor = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.f.m.e((f.d)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114479);
          p.this.JFE = true;
          Intent localIntent = new Intent();
          if (p.this.Log)
          {
            localIntent.putExtra("enterMainUIScreenProjectOnline", true);
            localIntent.putExtra("enterMainUIScreenProjectParams", p.this.Loh);
          }
          localIntent.setFlags(268435456);
          if (p.g(p.this) != null) {}
          com.tencent.mm.plugin.voip.ui.a local1;
          for (Object localObject = p.g(p.this).LiV;; localObject = "")
          {
            localIntent.putExtra("enterMainUiWxGroupId", (String)localObject);
            localIntent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
            localIntent.putExtra("notification", this.Lpb);
            localIntent.putExtra("enterMainUiSource", 1);
            localObject = ac.ggT();
            local1 = new com.tencent.mm.plugin.voip.ui.a()
            {
              public final void a(Intent paramAnonymous2Intent, BaseSmallView paramAnonymous2BaseSmallView)
              {
                AppMethodBeat.i(284699);
                if (!p.this.geW())
                {
                  paramAnonymous2BaseSmallView.updateText(MMApplicationContext.getContext().getString(a.h.multitalk_waiting_wording));
                  AppMethodBeat.o(284699);
                  return;
                }
                int i = p.this.Loq;
                paramAnonymous2BaseSmallView.aNF(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
                AppMethodBeat.o(284699);
              }
              
              public final boolean fQS()
              {
                AppMethodBeat.i(284694);
                if ((p.this.gfW()) || (p.this.geW()))
                {
                  AppMethodBeat.o(284694);
                  return true;
                }
                AppMethodBeat.o(284694);
                return false;
              }
              
              public final void fQT()
              {
                AppMethodBeat.i(284707);
                o.l(u.ggB(), u.abK(ac.ggS().Lod), p.6.this.Lpc);
                Toast.makeText(MMApplicationContext.getContext(), a.h.multitalk_mini_toast, 0).show();
                ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(43, p.6.this.Lpb, false);
                if (p.h(p.this) != null) {
                  p.h(p.this).fQY();
                }
                p.this.gge();
                p.this.yZ(true);
                p.i(p.this);
                AppMethodBeat.o(284707);
              }
              
              public final void fQU()
              {
                p.this.JFE = false;
              }
            };
            ac.ggS();
            boolean bool = p.gfU();
            ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject).intent = localIntent;
            ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject).Lvx = local1;
            if (com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext())) {
              break;
            }
            Log.e("MicroMsg.MultiTalkSmallWindow", "mini, permission denied");
            Context localContext = MMApplicationContext.getContext();
            RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(a.h.voip_float_permission_alert_content), (RequestFloatWindowPermissionDialog.a)new n.c(local1, (com.tencent.mm.plugin.multitalk.ui.widget.n)localObject, localIntent, bool), com.tencent.mm.bq.a.aQB());
            AppMethodBeat.o(114479);
            return;
          }
          local1.fQT();
          ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject).bh(localIntent);
          AppMethodBeat.o(114479);
        }
      });
    }
    AppMethodBeat.o(114517);
  }
  
  public final void zb(boolean paramBoolean)
  {
    AppMethodBeat.i(114522);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (gfV()) {
      com.tencent.mm.plugin.multitalk.c.o.Ljn.yM(paramBoolean);
    }
    for (;;)
    {
      yO(paramBoolean);
      AppMethodBeat.o(114522);
      return;
      ac.ggR().LnJ.zb(paramBoolean);
    }
  }
  
  public final void zc(boolean paramBoolean)
  {
    AppMethodBeat.i(285282);
    if (gfV())
    {
      com.tencent.mm.plugin.multitalk.c.o localo = com.tencent.mm.plugin.multitalk.c.o.Ljn;
      Log.i("MicroMsg.Multitalk.ILinkService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localo.au(new o.35(localo, paramBoolean));
    }
    for (;;)
    {
      yN(paramBoolean);
      AppMethodBeat.o(285282);
      return;
      ac.ggR().LnJ.zc(paramBoolean);
    }
  }
  
  public final void zd(boolean paramBoolean)
  {
    AppMethodBeat.i(114528);
    if (this.Lob)
    {
      AppMethodBeat.o(114528);
      return;
    }
    if (this.LoD != null)
    {
      this.LoD.ac(paramBoolean, 0);
      this.Lob = true;
    }
    AppMethodBeat.o(114528);
  }
  
  public final void ze(boolean paramBoolean)
  {
    AppMethodBeat.i(114533);
    Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Loc = paramBoolean;
    AppMethodBeat.o(114533);
  }
  
  final class a
  {
    MultiTalkGroup Lpj;
    Boolean Lpk;
    
    a(MultiTalkGroup paramMultiTalkGroup, Boolean paramBoolean)
    {
      this.Lpj = paramMultiTalkGroup;
      this.Lpk = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p
 * JD-Core Version:    0.7.0.1
 */