package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.h.a.ew;
import com.tencent.mm.h.a.ng;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.al;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.z;
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

public final class f
  implements com.tencent.pb.talkroom.sdk.a
{
  private Timer bzx;
  public boolean dnJ;
  com.tencent.mm.compatible.util.b eLi;
  private boolean loo;
  public com.tencent.mm.plugin.voip.video.i lpn;
  boolean mtA;
  public boolean mtB;
  public boolean mtC;
  int mtD;
  public boolean mtE = true;
  public HashSet<String> mtF = new HashSet();
  public com.tencent.mm.plugin.multitalk.ui.widget.e mtG = com.tencent.mm.plugin.multitalk.ui.widget.e.mvW;
  public MultiTalkGroup mtH = null;
  private l mtI;
  private long mtJ = 0L;
  public int mtK = 0;
  private int mtL = 0;
  private int mtM = 2;
  private boolean mtN = false;
  private long mtO = 0L;
  private long mtP = 30000L;
  public b mtQ;
  j.a mtR;
  public boolean mtS;
  MultiTalkGroup mtT = null;
  long mtU = 0L;
  am mtV = new am(Looper.getMainLooper(), new f.10(this), true);
  ah mtW = new ah(Looper.getMainLooper());
  BroadcastReceiver mtX = new f.2(this);
  c mtY = new f.4(this);
  
  public f()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.mtY);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE2");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
    localIntentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ae.getContext().registerReceiver(this.mtX, localIntentFilter);
    this.lpn = new com.tencent.mm.plugin.voip.video.i(ae.getContext());
    this.eLi = new com.tencent.mm.compatible.util.b(ae.getContext());
    this.mtS = false;
  }
  
  public static void IG(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    bi localbi = new bi();
    localbi.setType(64);
    localbi.bg(System.currentTimeMillis());
    localbi.setStatus(6);
    localbi.setContent(ae.getContext().getString(a.g.multitalk_system_slave_misscall_exit_msg));
    if (com.tencent.mm.model.m.gE(paramString))
    {
      localbi.ec(paramString);
      localbi.setContent(localbi.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(localbi);
    }
  }
  
  private void XW()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
    if (this.bzx != null)
    {
      this.bzx.cancel();
      return;
    }
    this.mtJ = System.currentTimeMillis();
    this.mtK = 0;
    this.bzx = new Timer();
    f.3 local3 = new f.3(this);
    this.bzx.schedule(local3, 1000L, 1000L);
  }
  
  private static void a(MultiTalkGroup paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e parame, boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
    if ((parame == com.tencent.mm.plugin.multitalk.ui.widget.e.mvX) && (paramBoolean))
    {
      parame = new bi();
      parame.setType(64);
      parame.bg(System.currentTimeMillis());
      parame.setStatus(6);
      parame.setContent(ae.getContext().getString(a.g.multitalk_system_slave_misscall_exit_msg));
      if (com.tencent.mm.model.m.gE(paramMultiTalkGroup.wJN))
      {
        parame.ec(paramMultiTalkGroup.wJN);
        parame.setContent(parame.field_content);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(parame);
      }
    }
  }
  
  private boolean a(MultiTalkGroup paramMultiTalkGroup)
  {
    if (!bkD())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[] { j.h(paramMultiTalkGroup) });
      this.mtH = paramMultiTalkGroup;
      this.mtK = 0;
      this.mtD = 1;
      this.mtF.clear();
      blj();
      sort();
      return true;
    }
    if (j.a(paramMultiTalkGroup, this.mtH))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[] { j.h(paramMultiTalkGroup) });
      Object localObject1 = this.mtH;
      HashMap localHashMap = new HashMap();
      Object localObject2 = paramMultiTalkGroup.wJP.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)((Iterator)localObject2).next();
        localHashMap.put(localMultiTalkGroupMember.wJQ, localMultiTalkGroupMember);
      }
      localObject1 = ((MultiTalkGroup)localObject1).wJP.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MultiTalkGroupMember)((Iterator)localObject1).next();
        if ((!q.Gj().equals(((MultiTalkGroupMember)localObject2).wJQ)) && (q.Gj().equals(((MultiTalkGroupMember)localObject2).wJR)) && (((MultiTalkGroupMember)localObject2).status == 1) && ((!localHashMap.containsKey(((MultiTalkGroupMember)localObject2).wJQ)) || (((MultiTalkGroupMember)localHashMap.get(((MultiTalkGroupMember)localObject2).wJQ)).status == 20)))
        {
          localObject2 = ((MultiTalkGroupMember)localObject2).wJQ;
          localObject2 = ae.getContext().getString(a.g.multitalk_system_busy_exit_msg, new Object[] { r.gV((String)localObject2) });
          localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b(ae.getContext(), (CharSequence)localObject2);
          Toast.makeText(ae.getContext(), (CharSequence)localObject2, 0).show();
        }
      }
      this.mtH = paramMultiTalkGroup;
      blj();
      sort();
      return true;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[] { j.h(this.mtH), j.h(paramMultiTalkGroup) });
    return false;
  }
  
  private void anW()
  {
    if (this.bzx != null)
    {
      this.bzx.cancel();
      this.bzx = null;
    }
  }
  
  private void b(com.tencent.mm.plugin.multitalk.ui.widget.e parame)
  {
    boolean bool = true;
    Object localObject = this.mtG;
    this.mtG = parame;
    if (localObject != parame) {
      if (parame == com.tencent.mm.plugin.multitalk.ui.widget.e.mwa)
      {
        localObject = new ng();
        ((ng)localObject).bWY.type = 1;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        e.a(j.k(this.mtH), bli(), j.l(this.mtH));
        p.blF().stopRing();
        if ((com.tencent.mm.compatible.b.f.yi().yt()) || (com.tencent.mm.compatible.b.f.yi().yn())) {
          break label116;
        }
      }
    }
    for (;;)
    {
      hM(bool);
      if (this.mtQ != null) {
        this.mtQ.a(parame);
      }
      return;
      label116:
      bool = false;
    }
  }
  
  private void blj()
  {
    Iterator localIterator = this.mtH.wJP.iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if ((localMultiTalkGroupMember.status != 10) && (this.mtF.remove(localMultiTalkGroupMember.wJQ))) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[] { localMultiTalkGroupMember.wJQ });
      }
    }
  }
  
  private void blk()
  {
    if (this.mtG == com.tencent.mm.plugin.multitalk.ui.widget.e.mvY) {}
    for (;;)
    {
      boolean bool = false;
      for (f localf = this;; localf = this)
      {
        localf.mtB = bool;
        this.dnJ = false;
        this.mtR = j.blx();
        return;
        if ((com.tencent.mm.compatible.b.f.yi().yt()) || (com.tencent.mm.compatible.b.f.yi().yn())) {
          break;
        }
        bool = true;
      }
    }
  }
  
  private void bll()
  {
    if (j.i(this.mtH)) {
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.mwa);
    }
    while (this.mtQ != null)
    {
      this.mtQ.bhw();
      localObject = j.blx();
      if (localObject != this.mtR) {
        this.mtR = ((j.a)localObject);
      }
      return;
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.mvZ);
    }
    Object localObject = new Intent();
    com.tencent.mm.br.d.b(ae.getContext(), "multitalk", ".ui.MultiTalkMainUI", (Intent)localObject);
  }
  
  private static boolean blr()
  {
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ae.getContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          break label109;
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
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        return bool;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
    label109:
    return false;
  }
  
  private void c(MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.mm.sdk.platformtools.y.l("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
    if (a(paramMultiTalkGroup))
    {
      this.mtA = false;
      blk();
      XW();
      paramMultiTalkGroup = new Intent();
      com.tencent.mm.br.d.b(ae.getContext(), "multitalk", ".ui.MultiTalkMainUI", paramMultiTalkGroup);
    }
  }
  
  static boolean dR(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
        return false;
      }
    }
    if (((KeyguardManager)ae.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      return false;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
    return true;
  }
  
  private void sort()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[] { this.mtH.wJP });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mtH.wJP.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      if (!localMultiTalkGroupMember.wJQ.equals(q.Gj())) {
        localLinkedList.add(localMultiTalkGroupMember);
      } else {
        localObject = localMultiTalkGroupMember;
      }
    }
    Collections.sort(localLinkedList, new f.1(this));
    Collections.sort(localLinkedList, new Comparator() {});
    Collections.sort(localLinkedList, new Comparator() {});
    if (localObject != null) {
      localLinkedList.add(localObject);
    }
    this.mtH.wJP = localLinkedList;
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[] { this.mtH.wJP });
  }
  
  public final boolean IH(String paramString)
  {
    if (blh())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : " + paramString);
      boolean bool = p.blE().mtp.IH(paramString);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: " + bool);
      return bool;
    }
    return false;
  }
  
  public final void b(Activity paramActivity, String paramString1, String paramString2)
  {
    boolean bool2 = this.dnJ;
    boolean bool3 = this.mtB;
    boolean bool4 = this.mtE;
    Object localObject = this.mtG.toString();
    if (this.mtH == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject, Boolean.valueOf(bool1) });
      e.bkT();
      if (!blr()) {
        break;
      }
      com.tencent.mm.ui.base.h.h(paramActivity, a.g.in_phone_tip, a.g.app_tip);
      return;
    }
    if (com.tencent.mm.plugin.voip.a.d.bSl())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, a.g.in_wechat_out_tip, a.g.app_tip);
      return;
    }
    if (com.tencent.mm.plugin.voip.a.d.bSm())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, a.g.in_voip_tip, a.g.app_tip);
      return;
    }
    if (com.tencent.mm.bf.e.RT())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, a.g.in_new_share_location_tip, a.g.app_tip);
      return;
    }
    if (com.tencent.mm.plugin.voip.a.d.bSn())
    {
      com.tencent.mm.ui.base.h.h(paramActivity, a.g.in_voip_cs_tip, a.g.app_tip);
      return;
    }
    if (bkD())
    {
      com.tencent.mm.bf.e.a(paramActivity, a.g.multitalk_exit_tip, null);
      return;
    }
    if ((this.mtN) && (System.currentTimeMillis() - this.mtO < this.mtP))
    {
      com.tencent.mm.bf.e.a(paramActivity, a.g.multitalk_overload_fail_tips, null);
      return;
    }
    this.mtN = false;
    paramActivity = bk.G(paramString1.split(","));
    paramString1 = new MultiTalkGroup();
    paramString1.wJM = p.blE().mtp.cOo();
    paramString1.wJN = paramString2;
    localObject = paramActivity.iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      MultiTalkGroupMember localMultiTalkGroupMember = new MultiTalkGroupMember();
      localMultiTalkGroupMember.wJQ = str;
      if (str.equals(q.Gj())) {}
      for (localMultiTalkGroupMember.status = 10;; localMultiTalkGroupMember.status = 1)
      {
        paramString1.wJP.add(localMultiTalkGroupMember);
        break;
      }
    }
    p.blE().mtp.bk(bk.g((Integer)com.tencent.mm.kernel.g.DP().dKo.get(1)), q.Gj());
    if (p.blE().mtp.f(paramString1.wJM, paramString2, paramActivity)) {
      e.bkR();
    }
    for (;;)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.mvY);
      c(paramString1);
      return;
      e.bkS();
    }
  }
  
  public final void b(MultiTalkGroup paramMultiTalkGroup)
  {
    boolean bool2 = this.dnJ;
    boolean bool3 = this.mtB;
    boolean bool4 = this.mtE;
    String str = this.mtG.toString();
    boolean bool1;
    if (this.mtH == null)
    {
      bool1 = true;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), str, Boolean.valueOf(bool1) });
      e.bkU();
      if ((com.tencent.mm.m.f.zR()) || (dR(ae.getContext()))) {
        break label172;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.mtT == null) && (this.mtV.crl()))
      {
        this.mtT = paramMultiTalkGroup;
        this.mtV.S(2000L, 2000L);
        this.mtU = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 6L, 1L, false);
      }
    }
    label172:
    do
    {
      return;
      bool1 = false;
      break;
      str = j.m(paramMultiTalkGroup);
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
      if (com.tencent.mm.m.g.AA().getInt("MultitalkBlockReceiver", 0) == 0) {}
      for (int i = 1; (i == 0) || (localad.Bg()); i = 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
        ai.l(new f.11(this, paramMultiTalkGroup), 1000L);
        e.av(3, j.l(paramMultiTalkGroup));
        return;
      }
      if ((!bkD()) && (!com.tencent.mm.plugin.voip.a.d.bSm()) && (!com.tencent.mm.plugin.voip.a.d.bSl()) && (!com.tencent.mm.bf.e.RT())) {
        if (((TelephonyManager)ae.getContext().getSystemService("phone")).getCallState() == 0) {
          break label425;
        }
      }
      for (i = 1; (i != 0) || (com.tencent.mm.plugin.voip.a.d.bSn()) || (!com.tencent.mm.n.a.gR(localad.field_type)); i = 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
        if (!com.tencent.mm.model.m.gD(paramMultiTalkGroup.wJN))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.wJN });
          am.a.dVy.a(paramMultiTalkGroup.wJN, "", new f.12(this));
        }
        ai.l(new f.13(this, paramMultiTalkGroup), 1000L);
        e.av(3, j.l(paramMultiTalkGroup));
        return;
      }
      if (!com.tencent.mm.model.m.gD(paramMultiTalkGroup.wJN))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramMultiTalkGroup.wJN });
        am.a.dVy.a(paramMultiTalkGroup.wJN, "", null);
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.mvX);
      e.av(1, j.l(paramMultiTalkGroup));
      if (com.tencent.mm.n.a.gR(localad.field_type)) {
        break label565;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[] { str, q.Gj() });
    } while (!a(paramMultiTalkGroup));
    label425:
    this.mtA = false;
    blk();
    XW();
    return;
    label565:
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[] { str, q.Gj() });
    c(paramMultiTalkGroup);
  }
  
  public final void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!com.tencent.mm.model.m.gD(paramString1))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[] { paramString1 });
      am.a.dVy.a(paramString1, "", new f.9(this));
    }
    bi localbi = new bi();
    localbi.setType(64);
    localbi.bg(System.currentTimeMillis());
    localbi.setStatus(6);
    localbi.fA(2);
    String str = r.gV(paramString2);
    Object localObject = paramString2;
    if (str != null) {
      if (!str.equals("")) {
        break label383;
      }
    }
    label301:
    label383:
    for (localObject = paramString2;; localObject = str)
    {
      paramString2 = (String)localObject + ae.getContext().getString(a.g.multitalk_system_master_start_multi_msg);
      localbi.setContent(paramString2);
      if (com.tencent.mm.model.m.gE(paramString1))
      {
        localbi.ec(paramString1);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(localbi);
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abv(paramString1);
        if (localObject == null) {
          break label301;
        }
        if (paramBoolean1) {
          ((ak)localObject).fy(((as)localObject).field_unReadCount + 1);
        }
        ((ak)localObject).setContent(paramString2);
        if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a((ak)localObject, paramString1) == -1) {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :" + paramString1);
        }
        if (paramBoolean2) {
          ((com.tencent.mm.model.ao)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbi);
        }
      }
      do
      {
        return;
        localObject = new ak();
        ((ak)localObject).setUsername(paramString1);
        if (paramBoolean1) {
          ((ak)localObject).fy(1);
        }
        ((ak)localObject).setContent(paramString2);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().d((ak)localObject);
      } while (!paramBoolean2);
      ((com.tencent.mm.model.ao)((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(localbi);
      return;
    }
  }
  
  public final void bR(List<a.am> paramList)
  {
    if (bkD())
    {
      this.mtF.clear();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[] { paramList });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a.am localam = (a.am)paramList.next();
        if ((localam.wHZ == 2) || (localam.wHZ == 3)) {
          this.mtF.add(localam.wHY);
        }
      }
      this.mtF.remove(q.Gj());
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[] { this.mtF });
      if (this.mtI != null) {
        this.mtI.us(this.mtF.size());
      }
      if (this.mtQ != null) {
        this.mtQ.bkG();
      }
    }
  }
  
  public final void bbJ()
  {
    this.loo = false;
    com.tencent.mm.plugin.voip.b.bPy().dismiss();
    ((NotificationManager)ae.getContext().getSystemService("notification")).cancel(43);
  }
  
  public final boolean bkC()
  {
    if (this.mtG == com.tencent.mm.plugin.multitalk.ui.widget.e.mwa) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public final boolean bkD()
  {
    if ((this.mtG != com.tencent.mm.plugin.multitalk.ui.widget.e.mvW) && (this.mtH != null)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public final boolean blf()
  {
    j.blw();
    return j.uq(this.mtD);
  }
  
  public final boolean blg()
  {
    j.blw();
    return j.ur(this.mtD);
  }
  
  public final boolean blh()
  {
    if ((this.mtG == com.tencent.mm.plugin.multitalk.ui.widget.e.mvZ) || (this.mtG == com.tencent.mm.plugin.multitalk.ui.widget.e.mwa)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public final long bli()
  {
    return System.currentTimeMillis() - this.mtJ;
  }
  
  public final void blm()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
  }
  
  public final void bln()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[] { Integer.valueOf(this.mtD) });
  }
  
  public final void blo()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
  }
  
  public final void blp()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
    if (this.mtQ == null) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
    }
    do
    {
      return;
      if (this.mtF.size() == 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
        return;
      }
      if (this.mtI == null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[] { Integer.valueOf(this.mtF.size()) });
        this.mtI = new l(this.mtQ);
        this.mtI.us(this.mtF.size());
      }
    } while (this.mtI.bDX);
    this.mtI.start();
  }
  
  public final void blq()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
    if (this.mtI != null)
    {
      this.mtI.stop();
      this.mtI = null;
    }
  }
  
  public final void d(MultiTalkGroup paramMultiTalkGroup)
  {
    e.av(2, j.l(paramMultiTalkGroup));
    a(paramMultiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e.mvX, true);
  }
  
  public final void e(MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
    e.hJ(true);
    if (a(paramMultiTalkGroup)) {
      bll();
    }
  }
  
  public final void f(MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[] { j.h(paramMultiTalkGroup) });
    ng localng = new ng();
    localng.bWY.type = 1;
    com.tencent.mm.sdk.b.a.udP.m(localng);
    e.hK(true);
    if (this.mtG != com.tencent.mm.plugin.multitalk.ui.widget.e.mvX)
    {
      b(com.tencent.mm.plugin.multitalk.ui.widget.e.mvZ);
      c(paramMultiTalkGroup);
    }
    if ((bkD()) && (a(paramMultiTalkGroup))) {
      bll();
    }
  }
  
  public final void g(MultiTalkGroup paramMultiTalkGroup)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[] { j.h(paramMultiTalkGroup) });
    if ((bkD()) && (a(paramMultiTalkGroup)))
    {
      if (j.j(this.mtH)) {
        break label70;
      }
      if (this.mtG != com.tencent.mm.plugin.multitalk.ui.widget.e.mvX) {
        break label62;
      }
      h(false, true, false);
    }
    label62:
    label70:
    do
    {
      return;
      h(false, false, false);
      return;
      if ((this.mtG != com.tencent.mm.plugin.multitalk.ui.widget.e.mwa) && (j.i(paramMultiTalkGroup))) {
        b(com.tencent.mm.plugin.multitalk.ui.widget.e.mwa);
      }
    } while ((this.mtQ == null) || (!j.c(this.mtG)));
    this.mtQ.bkF();
  }
  
  public final void h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 4;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(false), Boolean.valueOf(paramBoolean3) });
    p.blF().stopRing();
    Object localObject;
    boolean bool;
    long l;
    if (bkD())
    {
      localObject = new ng();
      ((ng)localObject).bWY.type = 2;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      localObject = j.l(this.mtH);
      e.IF((String)localObject);
      if (this.mtG != com.tencent.mm.plugin.multitalk.ui.widget.e.mwa)
      {
        bool = j.k(this.mtH);
        l = bli();
        if (bool) {
          if (!paramBoolean2) {}
        }
      }
    }
    for (;;)
    {
      e.a(bool, l, (String)localObject, i);
      for (;;)
      {
        localObject = this.mtG;
        if (this.mtQ != null) {
          this.mtQ.bkE();
        }
        this.mtG = com.tencent.mm.plugin.multitalk.ui.widget.e.mvW;
        blq();
        bbJ();
        anW();
        p.blD().reset();
        p.blG().blz();
        if (this.mtH != null)
        {
          a(this.mtH, (com.tencent.mm.plugin.multitalk.ui.widget.e)localObject, paramBoolean2);
          String str = this.mtH.wJL;
          localObject = str;
          if (bk.bl(str)) {
            localObject = this.mtH.wJM;
          }
          p.blE().mtp.Iy((String)localObject);
          this.mtH = null;
        }
        this.mtD = 0;
        this.mtB = true;
        this.dnJ = false;
        this.mtE = true;
        this.mtJ = 0L;
        this.mtK = 0;
        this.mtF.clear();
        this.mtL = 0;
        localObject = new ew();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
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
          break label469;
        }
        i = 10;
        break;
        e.un(this.mtK);
        e.q(this.mtK, (String)localObject);
      }
      blq();
      bbJ();
      anW();
      this.mtH = null;
      this.mtD = 0;
      this.mtJ = 0L;
      this.mtK = 0;
      this.mtF.clear();
      this.mtG = com.tencent.mm.plugin.multitalk.ui.widget.e.mvW;
      this.mtL = 0;
      return;
      label469:
      i = 0;
    }
  }
  
  public final void hE(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
    if (this.mtQ != null) {
      this.mtQ.hE(this.dnJ);
    }
  }
  
  public final void hG(boolean paramBoolean)
  {
    if ((p.blF().blh()) && (this.mtQ != null))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mtQ.hG(paramBoolean);
    }
  }
  
  public final void hL(boolean paramBoolean)
  {
    if ((!bkD()) || (this.loo)) {
      return;
    }
    this.loo = true;
    e.d(j.blu(), p.blF().blf(), paramBoolean);
    Toast.makeText(ae.getContext(), a.g.multitalk_mini_toast, 0).show();
    Object localObject1 = ae.getContext().getString(a.g.multitalk);
    String str = ae.getContext().getString(a.g.multitalk_recover);
    Object localObject2 = new Intent();
    ((Intent)localObject2).setClass(ae.getContext(), MultiTalkMainUI.class);
    localObject2 = PendingIntent.getActivity(ae.getContext(), 43, (Intent)localObject2, 134217728);
    int i = a.c.notification_icon_gray;
    if (com.tencent.mm.compatible.util.d.gG(19)) {
      i = a.c.notification_icon;
    }
    localObject1 = com.tencent.mm.plugin.voip.a.d.a(new Notification.Builder(ae.getContext()).setTicker(str).setWhen(System.currentTimeMillis()).setContentTitle((CharSequence)localObject1).setContentText(str).setContentIntent((PendingIntent)localObject2));
    ((Notification)localObject1).icon = i;
    ((Notification)localObject1).flags |= 0x20;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, (Notification)localObject1, false);
    if (this.mtQ != null) {
      this.mtQ.bbP();
    }
    ai.d(new f.14(this));
  }
  
  public final void hM(boolean paramBoolean)
  {
    p.blE().mtp.hM(paramBoolean);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mtB = paramBoolean;
    if (this.mtQ != null) {
      this.mtQ.hF(this.mtB);
    }
  }
  
  public final void hN(boolean paramBoolean)
  {
    if (this.mtA) {
      return;
    }
    this.lpn.n(a.f.phonering, 0, paramBoolean);
    this.eLi.requestFocus();
    this.mtA = true;
  }
  
  public final void i(int paramInt, Object paramObject)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyZ, Integer.valueOf(-1));
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uza, Long.valueOf(-1L));
    int i;
    switch (paramInt)
    {
    default: 
      i = a.g.multitalk_error_600;
    }
    for (;;)
    {
      if (this.mtQ != null) {
        this.mtQ.onError(paramInt);
      }
      if ((paramInt != -800) && (paramInt != -500) && (paramInt != -1700))
      {
        Toast.makeText(ae.getContext(), ae.getContext().getString(i), 0).show();
        h(false, false, true);
      }
      return;
      e.hJ(false);
      i = a.g.multitalk_error_100;
      continue;
      e.hK(false);
      i = a.g.multitalk_error_200;
      continue;
      i = a.g.multitalk_error_300;
      continue;
      i = a.g.multitalk_error_400;
      continue;
      i = a.g.multitalk_error_500;
      continue;
      i = a.g.multitalk_error_600;
      continue;
      i = a.g.multitalk_error_700;
      continue;
      i = a.g.multitalk_error_800;
      continue;
      i = a.g.multitalk_error_900;
      continue;
      i = a.g.multitalk_error_1000;
      continue;
      i = a.g.multitalk_error_1100;
      continue;
      i = a.g.multitalk_error_1200;
      continue;
      int j = a.g.multitalk_error_1300;
      this.mtN = true;
      this.mtO = System.currentTimeMillis();
      i = j;
      if (paramObject != null)
      {
        paramObject = (a.z)paramObject;
        i = j;
        if (paramObject != null)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + paramObject.wHF);
          i = j;
          if (paramObject.wHF != 0)
          {
            this.mtP = (paramObject.wHF * 1000);
            i = j;
            continue;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
            j = a.g.multitalk_error_14256;
            i = j;
            if (paramObject != null)
            {
              i = j;
              if ((a.aa)paramObject != null)
              {
                com.tencent.wecall.talkroom.model.a.cRq().oo(false);
                i = j;
                continue;
                i = a.g.multitalk_error_1400;
                continue;
                MultiTalkGroup localMultiTalkGroup = this.mtH;
                if (this.mtH != null) {}
                for (String str = this.mtH.wJN;; str = "")
                {
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", new Object[] { Integer.valueOf(paramInt), localMultiTalkGroup, str });
                  if (paramObject != null)
                  {
                    paramObject = (a.aa)paramObject;
                    if (paramObject != null)
                    {
                      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + paramObject.groupId);
                      if (paramObject.wGh != null)
                      {
                        p.blH().IA(paramObject.wGh.wIC);
                        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + paramObject.wGh.wIC);
                      }
                      if (!p.blE().mtp.Iy(paramObject.groupId)) {
                        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + paramObject.groupId);
                      }
                    }
                  }
                  i = a.g.multitalk_system_master_finish_exit_msg;
                  break;
                }
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[] { paramObject });
                Toast.makeText(ae.getContext(), ae.getContext().getString(a.g.multitalk_disabled), 0).show();
                if (paramObject != null)
                {
                  i = ((Integer)paramObject).intValue();
                  if (i > 0)
                  {
                    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyZ, Integer.valueOf(i));
                    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uza, Long.valueOf(bk.UZ()));
                  }
                }
                i = a.g.multitalk_disabled;
                continue;
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                i = a.g.multitalk_network_failed;
              }
            }
          }
        }
      }
    }
  }
  
  public final void stopRing()
  {
    com.tencent.mm.sdk.f.e.post(new f.5(this), "MultiTalkManager_stop_ring");
  }
  
  public final void uo(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: " + paramInt);
    if (paramInt > 0)
    {
      this.mtS = true;
      return;
    }
    this.mtS = false;
  }
  
  public final boolean up(int paramInt)
  {
    if (blh())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + paramInt);
      boolean bool = p.blE().mtp.up(paramInt);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[] { Boolean.valueOf(bool) });
      int i = this.mtD;
      this.mtD = paramInt;
      if (blg()) {
        blp();
      }
      for (;;)
      {
        if ((this.mtQ != null) && (i != this.mtD)) {
          this.mtQ.dk(i, this.mtD);
        }
        return bool;
        blq();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f
 * JD-Core Version:    0.7.0.1
 */