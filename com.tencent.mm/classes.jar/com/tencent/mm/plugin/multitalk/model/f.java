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
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.s.c;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.an;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public final class f
  implements ServiceConnection, com.tencent.pb.talkroom.sdk.a
{
  public boolean efg;
  private com.tencent.mm.compatible.util.b gaP;
  private boolean nLK;
  public com.tencent.mm.plugin.voip.video.h nMJ;
  private long oTA;
  private boolean oTB;
  public b oTC;
  private Timer oTD;
  private j.a oTE;
  public boolean oTF;
  MultiTalkGroup oTG;
  long oTH;
  private boolean oTI;
  ap oTJ;
  private com.tencent.mm.sdk.platformtools.ak oTK;
  BroadcastReceiver oTL;
  c oTM;
  private boolean oTl;
  public boolean oTm;
  boolean oTn;
  private int oTo;
  public boolean oTp;
  public HashSet<String> oTq;
  public com.tencent.mm.plugin.multitalk.ui.widget.e oTr;
  public MultiTalkGroup oTs;
  private l oTt;
  private long oTu;
  public int oTv;
  private int oTw;
  private int oTx;
  private boolean oTy;
  private long oTz;
  
  public f()
  {
    AppMethodBeat.i(53955);
    this.oTp = true;
    this.oTq = new HashSet();
    this.oTr = com.tencent.mm.plugin.multitalk.ui.widget.e.oVO;
    this.oTs = null;
    this.oTu = 0L;
    this.oTv = 0;
    this.oTw = 0;
    this.oTx = 2;
    this.oTy = false;
    this.oTz = 0L;
    this.oTA = 30000L;
    this.oTB = false;
    this.oTG = null;
    this.oTH = 0L;
    this.oTI = false;
    this.oTJ = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(53949);
        ab.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (f.a(f.this) == null)
        {
          f.b(f.this);
          f.c(f.this).stopTimer();
          AppMethodBeat.o(53949);
          return false;
        }
        if (f.eE(ah.getContext()))
        {
          f.this.b(f.a(f.this));
          f.d(f.this);
          f.b(f.this);
          f.c(f.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 7L, 1L, false);
          AppMethodBeat.o(53949);
          return false;
        }
        if (System.currentTimeMillis() - f.e(f.this) < 60000L)
        {
          AppMethodBeat.o(53949);
          return true;
        }
        f.d(f.this);
        f.b(f.this);
        f.c(f.this).stopTimer();
        AppMethodBeat.o(53949);
        return false;
      }
    }, true);
    this.oTK = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper());
    this.oTL = new f.2(this);
    this.oTM = new f.4(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.oTM);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
    localIntentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ah.getContext().registerReceiver(this.oTL, localIntentFilter);
    this.nMJ = new com.tencent.mm.plugin.voip.video.h(ah.getContext());
    this.gaP = new com.tencent.mm.compatible.util.b(ah.getContext());
    this.oTF = false;
    AppMethodBeat.o(53955);
  }
  
  public static void Uv(String paramString)
  {
    AppMethodBeat.i(53968);
    ab.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    bi localbi = new bi();
    localbi.setType(64);
    localbi.fQ(System.currentTimeMillis());
    localbi.setStatus(6);
    localbi.setContent(ah.getContext().getString(2131301707));
    if (n.nn(paramString))
    {
      localbi.kj(paramString);
      localbi.setContent(localbi.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(localbi);
    }
    AppMethodBeat.o(53968);
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(53969);
    ab.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((parame == com.tencent.mm.plugin.multitalk.ui.widget.e.oVP) && (paramBoolean))
    {
      parame = new bi();
      parame.setType(64);
      parame.fQ(System.currentTimeMillis());
      parame.setStatus(6);
      parame.setContent(ah.getContext().getString(2131301707));
      if (n.nn(paramMultiTalkGroup.Bhn))
      {
        parame.kj(paramMultiTalkGroup.Bhn);
        parame.setContent(parame.field_content);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(parame);
      }
    }
    AppMethodBeat.o(53969);
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(53962);
    if (!bSD())
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { j.h(paramMultiTalkGroup) });
      this.oTs = paramMultiTalkGroup;
      this.oTv = 0;
      this.oTo = 1;
      this.oTq.clear();
      bTi();
      sort();
      AppMethodBeat.o(53962);
      return true;
    }
    if (j.a(paramMultiTalkGroup, this.oTs))
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { j.h(paramMultiTalkGroup) });
      Object localObject1 = this.oTs;
      HashMap localHashMap = new HashMap();
      Object localObject2 = paramMultiTalkGroup.Bhp.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject2).next();
        localHashMap.put(localMultiTalkGroupMember.Bhq, localMultiTalkGroupMember);
      }
      localObject1 = ((MultiTalkGroup)localObject1).Bhp.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MultiTalkGroupMember)((Iterator)localObject1).next();
        if ((!r.Zn().equals(((MultiTalkGroupMember)localObject2).Bhq)) && (r.Zn().equals(((MultiTalkGroupMember)localObject2).Bhr)) && (((MultiTalkGroupMember)localObject2).status == 1) && ((!localHashMap.containsKey(((MultiTalkGroupMember)localObject2).Bhq)) || (((MultiTalkGroupMember)localHashMap.get(((MultiTalkGroupMember)localObject2).Bhq)).status == 20)))
        {
          localObject2 = ((MultiTalkGroupMember)localObject2).Bhq;
          localObject2 = ah.getContext().getString(2131301701, new Object[] { s.nE((String)localObject2) });
          localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b(ah.getContext(), (CharSequence)localObject2);
          Toast.makeText(ah.getContext(), (CharSequence)localObject2, 0).show();
        }
      }
      this.oTs = paramMultiTalkGroup;
      bTi();
      sort();
      AppMethodBeat.o(53962);
      return true;
    }
    ab.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { j.h(this.oTs), j.h(paramMultiTalkGroup) });
    AppMethodBeat.o(53962);
    return false;
  }
  
  private void aKU()
  {
    AppMethodBeat.i(53996);
    if (this.oTD != null)
    {
      this.oTD.cancel();
      this.oTD = null;
    }
    AppMethodBeat.o(53996);
  }
  
  private void arF()
  {
    AppMethodBeat.i(53995);
    ab.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.oTD != null)
    {
      this.oTD.cancel();
      AppMethodBeat.o(53995);
      return;
    }
    this.oTu = System.currentTimeMillis();
    this.oTv = 0;
    this.oTD = new Timer();
    f.3 local3 = new f.3(this);
    this.oTD.schedule(local3, 1000L, 1000L);
    AppMethodBeat.o(53995);
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(53994);
    Object localObject = this.oTr;
    this.oTr = parame;
    if (localObject != parame) {
      if (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.oVS)
      {
        localObject = new od();
        ((od)localObject).cEP.type = 1;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        e.a(j.k(this.oTs), getTotalTime(), j.l(this.oTs));
        p.bTF().stopRing();
        if ((com.tencent.mm.compatible.b.g.KC().KN()) || (com.tencent.mm.compatible.b.g.KC().KH())) {
          break label128;
        }
      }
    }
    for (;;)
    {
      jF(bool);
      if (this.oTC != null) {
        this.oTC.a(parame);
      }
      AppMethodBeat.o(53994);
      return;
      label128:
      bool = false;
    }
  }
  
  private void bTi()
  {
    AppMethodBeat.i(53964);
    Iterator localIterator = this.oTs.Bhp.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.oTq.remove(localMultiTalkGroupMember.Bhq))) {
        ab.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.Bhq });
      }
    }
    AppMethodBeat.o(53964);
  }
  
  private void bTj()
  {
    AppMethodBeat.i(53973);
    if (this.oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVQ) {}
    for (;;)
    {
      boolean bool = false;
      for (f localf = this;; localf = this)
      {
        localf.oTm = bool;
        this.efg = false;
        this.oTE = j.bTx();
        AppMethodBeat.o(53973);
        return;
        if ((com.tencent.mm.compatible.b.g.KC().KN()) || (com.tencent.mm.compatible.b.g.KC().KH())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void bTk()
  {
    AppMethodBeat.i(53977);
    if (j.i(this.oTs)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.oVS);
    }
    while (this.oTC != null)
    {
      this.oTC.bPy();
      localObject = j.bTx();
      if (localObject != this.oTE) {
        this.oTE = ((j.a)localObject);
      }
      AppMethodBeat.o(53977);
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.oVR);
    }
    Object localObject = new Intent();
    com.tencent.mm.bq.d.b(ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
    AppMethodBeat.o(53977);
  }
  
  private void bTo()
  {
    AppMethodBeat.i(53988);
    try
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
      if ((com.tencent.mm.compatible.util.d.fv(26)) && (this.oTI))
      {
        ah.getContext().unbindService(this);
        this.oTI = false;
      }
      AppMethodBeat.o(53988);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MT.MultiTalkManager", localException, "unBind VoipSmallService error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(53988);
    }
  }
  
  private static boolean bTr()
  {
    AppMethodBeat.i(53999);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ah.getContext().getSystemService("phone");
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
        ab.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ab.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(53999);
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
  
  private void c(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(53972);
    ab.b("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      this.oTl = false;
      bTj();
      arF();
      paramMultiTalkGroup = new Intent();
      com.tencent.mm.bq.d.b(ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", paramMultiTalkGroup);
    }
    AppMethodBeat.o(53972);
  }
  
  private static boolean eD(Context paramContext)
  {
    AppMethodBeat.i(54000);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ab.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ab.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
        AppMethodBeat.o(54000);
        return false;
      }
    }
    if (((KeyguardManager)ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(54000);
      return false;
    }
    ab.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
    AppMethodBeat.o(54000);
    return true;
  }
  
  private void jy(boolean paramBoolean)
  {
    AppMethodBeat.i(53981);
    ab.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oTm = paramBoolean;
    if (this.oTC != null) {
      this.oTC.jy(this.oTm);
    }
    AppMethodBeat.o(53981);
  }
  
  private void sort()
  {
    AppMethodBeat.i(53963);
    ab.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.oTs.Bhp });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.oTs.Bhp.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.Bhq.equals(r.Zn())) {
        localLinkedList.add(localMultiTalkGroupMember);
      } else {
        localObject = localMultiTalkGroupMember;
      }
    }
    Collections.sort(localLinkedList, new f.1(this));
    Collections.sort(localLinkedList, new f.7(this));
    Collections.sort(localLinkedList, new f.8(this));
    if (localObject != null) {
      localLinkedList.add(localObject);
    }
    this.oTs.Bhp = localLinkedList;
    ab.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.oTs.Bhp });
    AppMethodBeat.o(53963);
  }
  
  public final boolean Uw(String paramString)
  {
    AppMethodBeat.i(53993);
    if (bTh())
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(paramString)));
      boolean bool = p.bTE().oTa.Uw(paramString);
      ab.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(53993);
      return bool;
    }
    AppMethodBeat.o(53993);
    return false;
  }
  
  public final void b(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(53965);
    boolean bool2 = this.efg;
    boolean bool3 = this.oTm;
    boolean bool4 = this.oTp;
    Object localObject = this.oTr.toString();
    if (this.oTs == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      e.bST();
      if (!bTr()) {
        break;
      }
      com.tencent.mm.ui.base.h.h(paramActivity, 2131300732, 2131297087);
      AppMethodBeat.o(53965);
      return;
    }
    if (com.tencent.mm.plugin.voip.a.d.cPu())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, 2131300736, 2131297087);
      AppMethodBeat.o(53965);
      return;
    }
    if (com.tencent.mm.plugin.voip.a.d.isVoipStarted())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, 2131300735, 2131297087);
      AppMethodBeat.o(53965);
      return;
    }
    if (com.tencent.mm.bg.e.ald())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, 2131300731, 2131297087);
      AppMethodBeat.o(53965);
      return;
    }
    if (com.tencent.mm.plugin.voip.a.d.cPv())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, 2131300734, 2131297087);
      AppMethodBeat.o(53965);
      return;
    }
    if (bSD())
    {
      com.tencent.mm.bg.e.a(paramActivity, 2131301676, null);
      AppMethodBeat.o(53965);
      return;
    }
    if ((this.oTy) && (System.currentTimeMillis() - this.oTz < this.oTA))
    {
      com.tencent.mm.bg.e.a(paramActivity, 2131301693, null);
      AppMethodBeat.o(53965);
      return;
    }
    this.oTy = false;
    paramActivity = bo.P(paramString1.split(","));
    paramString1 = new MultiTalkGroup();
    paramString1.Bhm = p.bTE().oTa.dUb();
    paramString1.Bhn = paramString2;
    localObject = paramActivity.iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
      localMultiTalkGroupMember.Bhq = str;
      if (str.equals(r.Zn())) {}
      for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
      {
        paramString1.Bhp.add(localMultiTalkGroupMember);
        break;
      }
    }
    p.bTE().oTa.bQ(bo.g((Integer)com.tencent.mm.kernel.g.RL().eHM.get(1)), r.Zn());
    if (p.bTE().oTa.g(paramString1.Bhm, paramString2, paramActivity)) {
      e.bSR();
    }
    for (;;)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.oVQ);
      c(paramString1);
      AppMethodBeat.o(53965);
      return;
      e.bSS();
    }
  }
  
  public final void b(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(53971);
    boolean bool2 = this.efg;
    boolean bool3 = this.oTm;
    boolean bool4 = this.oTp;
    String str = this.oTr.toString();
    if (this.oTs == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), str, Boolean.valueOf(bool1) });
      e.bSU();
      if ((com.tencent.mm.m.f.Mz()) || (eD(ah.getContext()))) {
        break;
      }
      ab.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.oTG == null) && (this.oTJ.dtj()))
      {
        this.oTG = paramMultiTalkGroup;
        this.oTJ.ag(2000L, 2000L);
        this.oTH = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 6L, 1L, false);
      }
      AppMethodBeat.o(53971);
      return;
    }
    str = j.m(paramMultiTalkGroup);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str);
    if (com.tencent.mm.m.g.Nq().getInt("MultitalkBlockReceiver", 0) == 0) {}
    for (int i = 1; (i == 0) || (localad == null) || (localad.NW()); i = 0)
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
      al.p(new f.11(this, paramMultiTalkGroup), 1000L);
      e.aR(3, j.l(paramMultiTalkGroup));
      AppMethodBeat.o(53971);
      return;
    }
    if ((!bSD()) && (!com.tencent.mm.plugin.voip.a.d.isVoipStarted()) && (!com.tencent.mm.plugin.voip.a.d.cPu()) && (!com.tencent.mm.bg.e.ald())) {
      if (((TelephonyManager)ah.getContext().getSystemService("phone")).getCallState() == 0) {
        break label455;
      }
    }
    label455:
    for (i = 1; (i != 0) || (com.tencent.mm.plugin.voip.a.d.cPv()) || (!com.tencent.mm.n.a.je(localad.field_type)); i = 0)
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
      if (!n.nl(paramMultiTalkGroup.Bhn))
      {
        ab.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.Bhn });
        ao.a.flI.a(paramMultiTalkGroup.Bhn, "", new f.12(this));
      }
      al.p(new f.13(this, paramMultiTalkGroup), 1000L);
      e.aR(3, j.l(paramMultiTalkGroup));
      AppMethodBeat.o(53971);
      return;
    }
    if (!n.nl(paramMultiTalkGroup.Bhn))
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.Bhn });
      ao.a.flI.a(paramMultiTalkGroup.Bhn, "", null);
    }
    ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
    b(com.tencent.mm.plugin.multitalk.ui.widget.e.oVP);
    e.aR(1, j.l(paramMultiTalkGroup));
    if (!com.tencent.mm.n.a.je(localad.field_type))
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { str, r.Zn() });
      if (a(paramMultiTalkGroup))
      {
        this.oTl = false;
        bTj();
        arF();
        AppMethodBeat.o(53971);
      }
    }
    else
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { str, r.Zn() });
      ab.i("MicroMsg.MT.MultiTalkManager", "start VideoActivity");
      if ((com.tencent.mm.compatible.util.d.iU(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
      for (i = 1; (i != 0) && (!AppForegroundDelegate.bXk.bLR); i = 0)
      {
        if (a(paramMultiTalkGroup))
        {
          this.oTl = false;
          bTj();
          arF();
        }
        this.oTB = true;
        paramMultiTalkGroup = new Intent();
        paramMultiTalkGroup.putExtra("Voip_User", str);
        paramMultiTalkGroup.setClass(ah.getContext(), MultiTalkCallingService.class);
        if (Build.VERSION.SDK_INT >= 26) {
          ah.getContext().startForegroundService(paramMultiTalkGroup);
        }
        AppMethodBeat.o(53971);
        return;
      }
      c(paramMultiTalkGroup);
    }
    AppMethodBeat.o(53971);
  }
  
  public final void bIQ()
  {
    AppMethodBeat.i(53987);
    this.nLK = false;
    com.tencent.mm.plugin.voip.b.cLD().dismiss();
    ((NotificationManager)ah.getContext().getSystemService("notification")).cancel(43);
    bTo();
    AppMethodBeat.o(53987);
  }
  
  public final boolean bSC()
  {
    AppMethodBeat.i(53960);
    if (this.oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVS) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(53960);
      return bool;
    }
  }
  
  public final boolean bSD()
  {
    AppMethodBeat.i(53958);
    if ((this.oTr != com.tencent.mm.plugin.multitalk.ui.widget.e.oVO) && (this.oTs != null)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(53958);
      return bool;
    }
  }
  
  public final boolean bTf()
  {
    AppMethodBeat.i(53956);
    j.bTw();
    boolean bool = j.zG(this.oTo);
    AppMethodBeat.o(53956);
    return bool;
  }
  
  public final boolean bTg()
  {
    AppMethodBeat.i(53957);
    j.bTw();
    boolean bool = j.zH(this.oTo);
    AppMethodBeat.o(53957);
    return bool;
  }
  
  public final boolean bTh()
  {
    AppMethodBeat.i(53959);
    if ((this.oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVR) || (this.oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVS)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(53959);
      return bool;
    }
  }
  
  public final void bTl()
  {
    AppMethodBeat.i(53979);
    ab.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    AppMethodBeat.o(53979);
  }
  
  public final void bTm()
  {
    AppMethodBeat.i(53982);
    ab.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.oTo) });
    AppMethodBeat.o(53982);
  }
  
  public final void bTn()
  {
    AppMethodBeat.i(53983);
    ab.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    AppMethodBeat.o(53983);
  }
  
  public final void bTp()
  {
    AppMethodBeat.i(53989);
    ab.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (this.oTC == null)
    {
      ab.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
      AppMethodBeat.o(53989);
      return;
    }
    if (this.oTq.size() == 0)
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
      AppMethodBeat.o(53989);
      return;
    }
    if (this.oTt == null)
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[] { Integer.valueOf(this.oTq.size()) });
      this.oTt = new l(this.oTC);
      this.oTt.zI(this.oTq.size());
    }
    if (!this.oTt.running) {
      this.oTt.start();
    }
    AppMethodBeat.o(53989);
  }
  
  public final void bTq()
  {
    AppMethodBeat.i(53990);
    ab.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
    if (this.oTt != null)
    {
      this.oTt.stop();
      this.oTt = null;
    }
    AppMethodBeat.o(53990);
  }
  
  public final void c(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(53967);
    if (!n.nl(paramString1))
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      ao.a.flI.a(paramString1, "", new ao.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      });
    }
    bi localbi = new bi();
    localbi.setType(64);
    localbi.fQ(System.currentTimeMillis());
    localbi.setStatus(6);
    localbi.hL(2);
    String str = s.nE(paramString2);
    Object localObject = paramString2;
    if (str != null) {
      if (!str.equals("")) {
        break label398;
      }
    }
    label398:
    for (localObject = paramString2;; localObject = str)
    {
      paramString2 = (String)localObject + ah.getContext().getString(2131301705);
      localbi.setContent(paramString2);
      if (n.nn(paramString1))
      {
        localbi.kj(paramString1);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(localbi);
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arH(paramString1);
        if (localObject != null)
        {
          if (paramBoolean1) {
            ((com.tencent.mm.storage.ak)localObject).hJ(((au)localObject).field_unReadCount + 1);
          }
          ((com.tencent.mm.storage.ak)localObject).setContent(paramString2);
          if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().a((com.tencent.mm.storage.ak)localObject, paramString1) == -1) {
            ab.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(paramString1)));
          }
          if (paramBoolean2)
          {
            ((com.tencent.mm.model.aq)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbi);
            AppMethodBeat.o(53967);
          }
        }
        else
        {
          localObject = new com.tencent.mm.storage.ak();
          ((com.tencent.mm.storage.ak)localObject).setUsername(paramString1);
          if (paramBoolean1) {
            ((com.tencent.mm.storage.ak)localObject).hJ(1);
          }
          ((com.tencent.mm.storage.ak)localObject).setContent(paramString2);
          ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().d((com.tencent.mm.storage.ak)localObject);
          if (paramBoolean2) {
            ((com.tencent.mm.model.aq)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbi);
          }
        }
      }
      AppMethodBeat.o(53967);
      return;
    }
  }
  
  public final void cp(List<a.am> paramList)
  {
    AppMethodBeat.i(53985);
    if (bSD())
    {
      this.oTq.clear();
      ab.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a.am localam = (a.am)paramList.next();
        if ((localam.Bfz == 2) || (localam.Bfz == 3)) {
          this.oTq.add(localam.Bfy);
        }
      }
      this.oTq.remove(r.Zn());
      ab.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.oTq });
      if (this.oTt != null) {
        this.oTt.zI(this.oTq.size());
      }
      if (this.oTC != null) {
        this.oTC.bSG();
      }
    }
    AppMethodBeat.o(53985);
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(53974);
    e.aR(2, j.l(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e.oVP, true);
    AppMethodBeat.o(53974);
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(53975);
    ab.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
    e.jC(true);
    if (a(paramMultiTalkGroup)) {
      bTk();
    }
    AppMethodBeat.o(53975);
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(53976);
    ab.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
    od localod = new od();
    localod.cEP.type = 1;
    com.tencent.mm.sdk.b.a.ymk.l(localod);
    e.jD(true);
    if (this.oTr != com.tencent.mm.plugin.multitalk.ui.widget.e.oVP)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.oVR);
      c(paramMultiTalkGroup);
    }
    if ((bSD()) && (a(paramMultiTalkGroup))) {
      bTk();
    }
    AppMethodBeat.o(53976);
  }
  
  public final void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 4;
    AppMethodBeat.i(53966);
    ab.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.FALSE, Boolean.valueOf(paramBoolean3) });
    this.oTB = false;
    Object localObject = new Intent();
    ((Intent)localObject).setClass(ah.getContext(), MultiTalkCallingService.class);
    ah.getContext().stopService((Intent)localObject);
    p.bTF().stopRing();
    String str;
    boolean bool;
    long l;
    if (bSD())
    {
      localObject = new od();
      ((od)localObject).cEP.type = 2;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = this.oTs;
      str = j.l((MultiTalkGroup)localObject);
      e.fq(((MultiTalkGroup)localObject).Bhn, str);
      e.Uu(str);
      if (this.oTr != com.tencent.mm.plugin.multitalk.ui.widget.e.oVS)
      {
        bool = j.k(this.oTs);
        l = getTotalTime();
        if (bool) {
          if (!paramBoolean2) {}
        }
      }
    }
    for (;;)
    {
      e.a(bool, l, str, i);
      label196:
      localObject = this.oTr;
      if (this.oTC != null) {
        this.oTC.bSE();
      }
      this.oTr = com.tencent.mm.plugin.multitalk.ui.widget.e.oVO;
      bTq();
      bIQ();
      aKU();
      p.bTD().reset();
      p.bTG().bTz();
      if (this.oTs != null)
      {
        a(this.oTs, (com.tencent.mm.plugin.multitalk.ui.widget.e)localObject, paramBoolean2);
        str = this.oTs.Bhl;
        localObject = str;
        if (bo.isNullOrNil(str)) {
          localObject = this.oTs.Bhm;
        }
        p.bTE().oTa.Un((String)localObject);
        this.oTs = null;
      }
      this.oTo = 0;
      this.oTm = true;
      this.efg = false;
      this.oTp = true;
      this.oTu = 0L;
      this.oTv = 0;
      this.oTq.clear();
      this.oTw = 0;
      localObject = new ez();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      for (;;)
      {
        bTo();
        AppMethodBeat.o(53966);
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
          break label535;
        }
        i = 10;
        break;
        e.zD(this.oTv);
        e.q(this.oTv, str);
        break label196;
        bTq();
        bIQ();
        aKU();
        this.oTs = null;
        this.oTo = 0;
        this.oTu = 0L;
        this.oTv = 0;
        this.oTq.clear();
        this.oTr = com.tencent.mm.plugin.multitalk.ui.widget.e.oVO;
        this.oTw = 0;
      }
      label535:
      i = 0;
    }
  }
  
  public final void g(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(53978);
    ab.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { j.h(paramMultiTalkGroup) });
    if ((bSD()) && (a(paramMultiTalkGroup)))
    {
      if (!j.j(this.oTs))
      {
        if (this.oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVP)
        {
          f(false, true, false);
          AppMethodBeat.o(53978);
          return;
        }
        f(false, false, false);
        AppMethodBeat.o(53978);
        return;
      }
      if ((this.oTr != com.tencent.mm.plugin.multitalk.ui.widget.e.oVS) && (j.i(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.e.oVS);
      }
      if ((this.oTC != null) && (j.c(this.oTr))) {
        this.oTC.bSF();
      }
    }
    AppMethodBeat.o(53978);
  }
  
  public final long getTotalTime()
  {
    AppMethodBeat.i(53961);
    long l1 = System.currentTimeMillis();
    long l2 = this.oTu;
    AppMethodBeat.o(53961);
    return l1 - l2;
  }
  
  public final void jE(boolean paramBoolean)
  {
    AppMethodBeat.i(53986);
    if (bSD())
    {
      if (this.nLK)
      {
        AppMethodBeat.o(53986);
        return;
      }
      this.nLK = true;
      e.g(j.bTu(), p.bTF().bTf(), paramBoolean);
      Toast.makeText(ah.getContext(), 2131301689, 0).show();
      Object localObject1 = ah.getContext().getString(2131301655);
      String str = ah.getContext().getString(2131301694);
      Object localObject2 = new Intent();
      ((Intent)localObject2).setClass(ah.getContext(), MultiTalkMainUI.class);
      localObject2 = PendingIntent.getActivity(ah.getContext(), 43, (Intent)localObject2, 134217728);
      int i = 2130839847;
      if (com.tencent.mm.compatible.util.d.fw(19)) {
        i = 2130839845;
      }
      localObject1 = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(str).g(System.currentTimeMillis()).e((CharSequence)localObject1).f(str);
      ((s.c)localObject1).ya = ((PendingIntent)localObject2);
      localObject1 = com.tencent.mm.plugin.voip.a.d.c((s.c)localObject1);
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
      if (this.oTC != null) {
        this.oTC.bIW();
      }
      al.d(new f.14(this, (Notification)localObject1));
    }
    AppMethodBeat.o(53986);
  }
  
  public final void jF(boolean paramBoolean)
  {
    AppMethodBeat.i(53991);
    ab.b("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", new Object[] { Boolean.valueOf(paramBoolean) });
    p.bTE().oTa.jF(paramBoolean);
    jy(paramBoolean);
    AppMethodBeat.o(53991);
  }
  
  public final void jG(boolean paramBoolean)
  {
    AppMethodBeat.i(53997);
    if (this.oTl)
    {
      AppMethodBeat.o(53997);
      return;
    }
    this.nMJ.aq(1, paramBoolean);
    this.gaP.requestFocus();
    this.oTl = true;
    AppMethodBeat.o(53997);
  }
  
  public final void jH(boolean paramBoolean)
  {
    AppMethodBeat.i(54002);
    ab.b("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oTn = paramBoolean;
    AppMethodBeat.o(54002);
  }
  
  public final void jx(boolean paramBoolean)
  {
    AppMethodBeat.i(53980);
    this.efg = paramBoolean;
    if (this.oTC != null) {
      this.oTC.jx(this.efg);
    }
    AppMethodBeat.o(53980);
  }
  
  public final void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(54001);
    if ((p.bTF().bTh()) && (this.oTC != null))
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.oTC.jz(paramBoolean);
    }
    AppMethodBeat.o(54001);
  }
  
  public final void l(int paramInt, Object paramObject)
  {
    int j = 2131301672;
    AppMethodBeat.i(53970);
    ab.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJN, Integer.valueOf(-1));
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJO, Long.valueOf(-1L));
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.oTC != null) {
        this.oTC.onError(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(ah.getContext(), ah.getContext().getString(i), 0).show();
        f(false, false, true);
      }
      AppMethodBeat.o(53970);
      return;
      e.jC(false);
      i = 2131301661;
      continue;
      e.jD(false);
      i = 2131301668;
      continue;
      i = 2131301669;
      continue;
      i = 2131301670;
      continue;
      i = 2131301671;
      continue;
      i = 2131301673;
      continue;
      i = 2131301674;
      continue;
      i = 2131301675;
      continue;
      i = 2131301662;
      continue;
      i = 2131301663;
      continue;
      i = 2131301664;
      continue;
      j = 2131301665;
      this.oTy = true;
      this.oTz = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.z)paramObject;
        i = j;
        if (paramObject != null)
        {
          ab.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.Bff);
          i = j;
          if (paramObject.Bff != 0)
          {
            this.oTA = (paramObject.Bff * 1000);
            i = j;
            continue;
            ab.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = 2131301667;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.aa)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.dXg().sb(false);
                i = j;
                continue;
                i = 2131301666;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.oTs;
                if (this.oTs != null) {}
                for (String str = this.oTs.Bhn;; str = "")
                {
                  ab.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.aa)paramObject;
                    if (paramObject != null)
                    {
                      ab.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.BdI != null)
                      {
                        p.bTH().Up(paramObject.BdI.Bgc);
                        ab.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.BdI.Bgc);
                      }
                      if (!p.bTE().oTa.Un(paramObject.groupId)) {
                        ab.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = 2131301703;
                  break;
                }
                ab.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(ah.getContext(), ah.getContext().getString(2131301658), 0).show();
                if (paramObject != null)
                {
                  i = ((Integer)paramObject).intValue();
                  if (i > 0)
                  {
                    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJN, Integer.valueOf(i));
                    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJO, Long.valueOf(bo.yB()));
                  }
                }
                i = 2131301658;
                continue;
                ab.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                i = 2131301691;
              }
            }
          }
        }
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void stopRing()
  {
    AppMethodBeat.i(53998);
    com.tencent.mm.sdk.g.d.post(new f.5(this), "MultiTalkManager_stop_ring");
    AppMethodBeat.o(53998);
  }
  
  public final void zE(int paramInt)
  {
    AppMethodBeat.i(53984);
    ab.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(paramInt)));
    if (paramInt > 0)
    {
      this.oTF = true;
      AppMethodBeat.o(53984);
      return;
    }
    this.oTF = false;
    AppMethodBeat.o(53984);
  }
  
  public final boolean zF(int paramInt)
  {
    AppMethodBeat.i(53992);
    if (bTh())
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "try switch to action : ".concat(String.valueOf(paramInt)));
      boolean bool = p.bTE().oTa.zF(paramInt);
      ab.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[] { Boolean.valueOf(bool) });
      int i = this.oTo;
      this.oTo = paramInt;
      if (bTg()) {
        bTp();
      }
      for (;;)
      {
        if ((this.oTC != null) && (i != this.oTo)) {
          this.oTC.eK(i, this.oTo);
        }
        AppMethodBeat.o(53992);
        return bool;
        bTq();
      }
    }
    AppMethodBeat.o(53992);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f
 * JD-Core Version:    0.7.0.1
 */