package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.md;
import com.tencent.mm.model.at;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.s;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.t.a;
import com.tencent.mm.plugin.multitalk.model.w;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.multitalk.ui.widget.i;
import com.tencent.mm.plugin.multitalk.ui.widget.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkMainUI
  extends MMActivity
  implements ServiceConnection, com.tencent.mm.plugin.multitalk.model.e
{
  protected aq gNm;
  private Notification jVC;
  private com.tencent.mm.plugin.voip.a.b vgy;
  private boolean wtp;
  private com.tencent.mm.plugin.multitalk.ui.widget.g wtq;
  private j wtr;
  private boolean wts;
  private boolean wtt;
  boolean wtu;
  private MultiTalkMainUI.ScreenActionReceiver wtv;
  private Runnable wtw;
  public boolean wtx;
  private BroadcastReceiver wty;
  aq wtz;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(114663);
    this.wts = true;
    this.wtt = false;
    this.wtu = false;
    this.wtw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114652);
        z.dtK().dtp();
        AppMethodBeat.o(114652);
      }
    };
    this.wtx = false;
    this.wty = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114656);
        if (("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) && (z.dtK().wqT == i.wvW))
        {
          z.dtK().stopRing();
          MultiTalkMainUI.b(MultiTalkMainUI.this);
        }
        AppMethodBeat.o(114656);
      }
    };
    this.wtz = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(114661);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(114661);
          return;
          if (!MultiTalkMainUI.c(MultiTalkMainUI.this))
          {
            paramAnonymousMessage = MultiTalkMainUI.this;
            ae.i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
            try
            {
              if (com.tencent.mm.compatible.util.d.lA(26))
              {
                paramAnonymousMessage.wtu = true;
                Intent localIntent = new Intent();
                localIntent.setClass(ak.getContext(), MultiTalkingForegroundService.class);
                ak.getContext().bindService(localIntent, paramAnonymousMessage, 1);
              }
              AppMethodBeat.o(114661);
              return;
            }
            catch (Exception paramAnonymousMessage)
            {
              ae.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", paramAnonymousMessage, "bindVoiceServiceIfNeed error: %s", new Object[] { paramAnonymousMessage.getMessage() });
              AppMethodBeat.o(114661);
              return;
            }
            ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(43);
          }
        }
      }
    };
    AppMethodBeat.o(114663);
  }
  
  public final void a(t.a parama)
  {
    AppMethodBeat.i(114687);
    if (parama == t.a.wsa)
    {
      z.dtI().au(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == t.a.wsb)
    {
      z.dtI().at(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == t.a.wsc) {
      com.tencent.mm.bh.e.a(this, 2131764895, null);
    }
    AppMethodBeat.o(114687);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(114686);
    if (parami == i.wvZ)
    {
      parami = this.wtr;
      if (parami.wwC > 0L) {
        parami.wwC = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(114686);
  }
  
  public final ViewGroup bKN()
  {
    AppMethodBeat.i(114691);
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131304253);
    AppMethodBeat.o(114691);
    return localViewGroup;
  }
  
  public final void dgf()
  {
    AppMethodBeat.i(114675);
    md localmd = new md();
    localmd.dAD.action = 0;
    com.tencent.mm.sdk.b.a.IvT.l(localmd);
    this.wtr.pj(true);
    z.dtK().wps = null;
    z.dtK().stopRing();
    finish();
    AppMethodBeat.o(114675);
  }
  
  public final void dgg()
  {
    AppMethodBeat.i(114688);
    j localj = this.wtr;
    Object localObject1 = localj.fVV;
    long l = z.dtK().wqZ;
    ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
    com.tencent.mm.plugin.multitalk.model.a locala = localj.wrp;
    localObject1 = z.dtK();
    d.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    HashSet localHashSet = ((o)localObject1).wqS;
    Object localObject3 = z.dtK();
    d.g.b.p.g(localObject3, "SubCoreMultiTalk.getMultiTalkManager()");
    Object localObject2 = ((o)localObject3).wqU.wmz;
    localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2)) {
      localObject1 = ((o)localObject3).wqU.MgG;
    }
    boolean bool = ((o)localObject3).asB(((o)localObject3).wqU.wmA);
    ae.d("MicroMsg.MT.MultiTalkManager", "getTalkingMember: %s, groupid:%s, isILink:%b", new Object[] { t.g(((o)localObject3).wqU), ((o)localObject3).wqU.wmA, Boolean.valueOf(bool) });
    new ArrayList();
    Iterator localIterator;
    if (bool)
    {
      localObject1 = com.tencent.mm.plugin.multitalk.b.p.wmO.drP();
      localObject2 = locala.wpG;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject2).wtQ;
        if (localObject2 != null) {
          localIterator = ((Iterable)localObject2).iterator();
        }
      }
    }
    else
    {
      for (;;)
      {
        label247:
        if (!localIterator.hasNext()) {
          break label572;
        }
        localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).wmd.MgJ;
        d.g.b.p.g(localObject2, "it.member.usrName");
        localObject3 = locala.asg((String)localObject2);
        if (localObject3 != null)
        {
          int i;
          if (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua != null)
          {
            i = 1;
            label307:
            if (i == 0) {
              break label454;
            }
          }
          for (;;)
          {
            if (localObject3 == null) {
              break label458;
            }
            localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wua;
            if (localObject2 != null)
            {
              localObject4 = ((MultiTalkVideoView)localObject2).getUsername();
              localObject2 = localObject4;
              if (localObject4 != null) {}
            }
            else
            {
              localObject2 = "";
            }
            d.g.b.p.g(localObject2, "it.multiTalkVideoView?.getUsername() ?: \"\"");
            if (!d.g.b.p.i(v.aAC(), localObject2)) {
              break label460;
            }
            Object localObject4 = locala.wpE;
            if ((localObject4 == null) || (((com.tencent.mm.plugin.multitalk.model.b)localObject4).dsg() != true)) {
              break label460;
            }
            localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wub;
            if (localObject3 != null) {
              ((ImageView)localObject3).setVisibility(8);
            }
            ae.i("AvatarViewManager", "displayVoiceTalkingIcon, %s hide", new Object[] { localObject2 });
            break label247;
            localObject1 = z.dtJ().wqE.baE((String)localObject1);
            break;
            i = 0;
            break label307;
            label454:
            localObject3 = null;
          }
          label458:
          continue;
          label460:
          if ((localObject1 != null) && (((List)localObject1).contains(localObject2) == true) && (localHashSet != null) && (!localHashSet.contains(localObject2)))
          {
            localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wub;
            if (localObject3 != null) {
              ((ImageView)localObject3).setVisibility(0);
            }
            ae.i("AvatarViewManager", "displayVoiceTalkingIcon, %s show", new Object[] { localObject2 });
          }
          else
          {
            localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).wub;
            if (localObject3 != null) {
              ((ImageView)localObject3).setVisibility(8);
            }
            ae.i("AvatarViewManager", "displayVoiceTalkingIcon, %s hide", new Object[] { localObject2 });
          }
        }
      }
    }
    label572:
    if (localObject1 != null) {
      n.Lf(((List)localObject1).size());
    }
    localj.wrp.drU();
    AppMethodBeat.o(114688);
  }
  
  public final void dor()
  {
    AppMethodBeat.i(114674);
    this.wtq.dtW();
    this.wtr.n(z.dtK().wqU);
    AppMethodBeat.o(114674);
  }
  
  public final boolean dsg()
  {
    AppMethodBeat.i(114689);
    if (this.wtr != null)
    {
      boolean bool = this.wtr.dsg();
      AppMethodBeat.o(114689);
      return bool;
    }
    AppMethodBeat.o(114689);
    return false;
  }
  
  public final void dsl()
  {
    AppMethodBeat.i(114676);
    Object localObject = z.dtK();
    if (((o)localObject).wrl != null) {
      ((o)localObject).wrl.M(false, 1);
    }
    localObject = new md();
    ((md)localObject).dAD.action = 0;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    this.gNm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114655);
        MultiTalkMainUI.a(MultiTalkMainUI.this).pj(false);
        AppMethodBeat.o(114655);
      }
    });
    z.dtK().wps = null;
    z.dtK().stopRing();
    localObject = z.dtK();
    if (((o)localObject).wrl != null) {
      ((o)localObject).wrl.drG();
    }
    if (z.dtK().wrl != null) {
      com.tencent.mm.plugin.multitalk.a.a.unInit();
    }
    finish();
    AppMethodBeat.o(114676);
  }
  
  public final void dsm()
  {
    AppMethodBeat.i(114673);
    switch (2.wtB[z.dtK().wqT.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114673);
      return;
      this.wtr.n(z.dtK().wqU);
      AppMethodBeat.o(114673);
      return;
      this.wtq.m(z.dtK().wqU);
    }
  }
  
  public final void dsn()
  {
    AppMethodBeat.i(114678);
    ae.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + z.dtK().wqS.size());
    Object localObject;
    if (z.dtK().dsY())
    {
      localObject = z.dtK().wqS;
      if (((HashSet)localObject).size() <= 0) {
        break label143;
      }
      if ((((HashSet)localObject).size() != 1) || (!((HashSet)localObject).contains(v.aAC()))) {
        break label134;
      }
      z.dtK().dtq();
    }
    for (;;)
    {
      localObject = this.wtr;
      HashSet localHashSet = new HashSet(z.dtK().wqS);
      if (t.Ln(z.dtK().wqQ)) {
        ((j)localObject).e(localHashSet);
      }
      n.Lg(localHashSet.size());
      AppMethodBeat.o(114678);
      return;
      label134:
      z.dtK().dtp();
      continue;
      label143:
      localObject = z.dtK();
      ae.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
      if (((o)localObject).wqV != null) {
        ((o)localObject).wqV.stopVideo();
      }
    }
  }
  
  public final void dso()
  {
    AppMethodBeat.i(190814);
    this.wtr.pg(true);
    AppMethodBeat.o(190814);
  }
  
  public void finish()
  {
    AppMethodBeat.i(190815);
    super.finish();
    if (this.wtr != null) {
      this.wtr.gIc = false;
    }
    AppMethodBeat.o(190815);
  }
  
  public final void gF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114681);
    if (z.dtK().dsY())
    {
      j localj = this.wtr;
      if (!t.Lm(paramInt2))
      {
        if (t.Lm(paramInt1))
        {
          localj.wwi.setChecked(false);
          localj.wwh.setVisibility(8);
          localj.wrp.ex(v.aAC(), 0);
        }
        localj.pi(false);
      }
      HashSet localHashSet;
      for (;;)
      {
        localHashSet = new HashSet(z.dtK().wqS);
        if (t.Ln(paramInt2)) {
          break;
        }
        if (!t.Ln(paramInt1)) {
          break label169;
        }
        localj.wrp.o(localHashSet);
        AppMethodBeat.o(114681);
        return;
        if (!t.Lm(paramInt1))
        {
          localj.wwi.setChecked(true);
          localj.wrp.ex(v.aAC(), 1);
          localj.wwh.setVisibility(0);
        }
      }
      if ((t.Ln(paramInt2)) && (!t.Ln(paramInt1))) {
        localj.e(localHashSet);
      }
    }
    label169:
    AppMethodBeat.o(114681);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494976;
  }
  
  public final void oN(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(114679);
    if (z.dtK().dsY())
    {
      Object localObject = this.wtr;
      ((j)localObject).wwj.setChecked(paramBoolean);
      localObject = ((j)localObject).wrp;
      String str = v.aAC();
      d.g.b.p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localObject = ((com.tencent.mm.plugin.multitalk.model.a)localObject).asg(str);
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).wua != null)
        {
          i = 1;
          if (i == 0) {
            break label109;
          }
          label80:
          if (localObject == null) {
            break label121;
          }
          if (!paramBoolean) {
            break label115;
          }
        }
        label109:
        label115:
        for (int i = j;; i = 8)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).abH(i);
          AppMethodBeat.o(114679);
          return;
          i = 0;
          break;
          localObject = null;
          break label80;
        }
      }
    }
    label121:
    AppMethodBeat.o(114679);
  }
  
  public final void oO(boolean paramBoolean)
  {
    AppMethodBeat.i(114680);
    if (z.dtK().dsY())
    {
      j localj = this.wtr;
      ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      localj.wwk.setChecked(paramBoolean);
      localj.dtZ();
    }
    AppMethodBeat.o(114680);
  }
  
  public final void oP(boolean paramBoolean)
  {
    AppMethodBeat.i(114682);
    if (z.dtK().dsY())
    {
      j localj = this.wtr;
      if (localj.wwk != null) {
        localj.wwk.setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(114682);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114672);
    ae.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.wtx = false;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ae.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(paramIntent)));
      paramIntent = bu.U(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(114672);
        return;
      }
      z.dtK().eF(paramIntent);
    }
    AppMethodBeat.o(114672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114664);
    super.onCreate(paramBundle);
    z.dtK().dtn();
    com.tencent.mm.util.d.evs();
    z.dtK().dtg();
    getWindow().getDecorView().setSystemUiVisibility(1792);
    getWindow().addFlags(-2147483648);
    getWindow().setStatusBarColor(0);
    getWindow().setNavigationBarColor(0);
    int i = getIntent().getIntExtra("enterMainUiSource", 0);
    if ((i == 1) || (i == 2)) {
      overridePendingTransition(2130772095, 2130771986);
    }
    for (;;)
    {
      hideTitleView();
      getWindow().addFlags(6815872);
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().addFlags(67108864);
      }
      z.dtK().nD(false);
      if (z.dtK().dsk()) {
        break;
      }
      finish();
      if (i == 2) {
        getIntent().getStringExtra("enterMainUiWxGroupId");
      }
      AppMethodBeat.o(114664);
      return;
      overridePendingTransition(2130772146, 2130772147);
    }
    this.wtq = new com.tencent.mm.plugin.multitalk.ui.widget.g(this);
    this.wtr = new j(this);
    z.dtK().pb(z.dtK().leL);
    z.dtK().wps = this;
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.wty, paramBundle);
    this.wtt = true;
    this.gNm = new aq();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
      ae.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.lA(26))
    {
      ae.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.wtv = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      ak.getContext().registerReceiver(this.wtv, paramBundle);
    }
    this.jVC = ((Notification)getIntent().getParcelableExtra("notification"));
    this.vgy = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
    this.vgy.ac(9, "VOIPFloatBall");
    AppMethodBeat.o(114664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114667);
    if (this.wtx) {
      z.dtK().pa(false);
    }
    if (this.wtt) {
      unregisterReceiver(this.wty);
    }
    this.wtz.removeCallbacksAndMessages(null);
    this.wtz.sendEmptyMessage(1);
    ae.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.lA(26)) && (this.wtu))
      {
        ak.getContext().unbindService(this);
        this.wtu = false;
      }
      if (com.tencent.mm.compatible.util.d.lA(26))
      {
        ae.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.wtv == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        ak.getContext().unregisterReceiver(this.wtv);
        this.wtv = null;
        super.onDestroy();
        if (this.vgy != null) {
          this.vgy.onDestroy();
        }
        AppMethodBeat.o(114667);
        return;
        localException1 = localException1;
        ae.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", localException1, "unbindVoiceServiceIfNeed error: %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(114677);
    if (paramInt == -1700)
    {
      j localj = this.wtr;
      ae.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localj.pi(false);
      z.dtK().Lj(1);
      localj.wwi.setChecked(false);
    }
    AppMethodBeat.o(114677);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(114669);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      h.a(this, 2131761410, 2131761388, 2131755277, 2131755691, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114654);
          z.dtK().j(false, false, false);
          AppMethodBeat.o(114654);
        }
      }, null);
      AppMethodBeat.o(114669);
      return true;
    }
    if (z.dtK().wqT == i.wvW)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        z.dtK().stopRing();
        this.wts = false;
        AppMethodBeat.o(114669);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        paramKeyEvent = z.dtK();
        if (paramKeyEvent.wrl != null) {
          paramKeyEvent.wrl.xr(com.tencent.mm.plugin.multitalk.a.a.dgR());
        }
        AppMethodBeat.o(114669);
        return true;
      }
      if (paramInt == 24)
      {
        paramKeyEvent = z.dtK();
        if (paramKeyEvent.wrl != null) {
          paramKeyEvent.wrl.xq(com.tencent.mm.plugin.multitalk.a.a.dgR());
        }
        AppMethodBeat.o(114669);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(114669);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(114666);
    z.dtK().dtq();
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)ak.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ak.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.wtp = bool1;
      ae.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.wtp) });
      if (z.dtK().dsY()) {
        this.wtr.pi(true);
      }
      if ((!this.wtx) && (this.vgy != null))
      {
        this.vgy.bhk();
        f.e(false, true, true);
      }
      AppMethodBeat.o(114666);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114690);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      ae.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(114690);
      return;
    }
    ae.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ae.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
        AppMethodBeat.o(114690);
        return;
      }
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new MultiTalkMainUI.6(this), new MultiTalkMainUI.7(this));
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ae.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
        AppMethodBeat.o(114690);
        return;
      }
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new MultiTalkMainUI.8(this), new MultiTalkMainUI.9(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(114665);
    ae.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
    super.onResume();
    if (this.vgy != null)
    {
      this.vgy.bLp();
      f.e(true, false, true);
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject).bdJ();
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject).bdK();
    }
    localObject = (c)com.tencent.mm.kernel.g.ab(c.class);
    if (localObject != null) {
      ((c)localObject).m(new BallInfo(6, "MusicFloatBall"));
    }
    switch (2.wtB[z.dtK().wqT.ordinal()])
    {
    default: 
      if (z.dtK().dsY())
      {
        localObject = z.dtK();
        if (!((o)localObject).wrt) {
          break label378;
        }
      }
      break;
    }
    label378:
    for (boolean bool = false;; bool = t.Lm(((o)localObject).wqQ))
    {
      if (bool) {
        this.wtr.ph(true);
      }
      this.gNm.postDelayed(this.wtw, 2000L);
      AppMethodBeat.o(114665);
      return;
      localObject = this.wtr;
      ((j)localObject).wwe.setVisibility(8);
      ((j)localObject).wwg.setVisibility(8);
      this.wtq.m(z.dtK().wqU);
      if (az.is4G(this)) {
        z.dtI().au(this);
      }
      while (this.wts)
      {
        z.dtK().pc(false);
        break;
        if ((az.is2G(this)) || (az.is3G(this))) {
          z.dtI().at(this);
        }
      }
      this.wtq.dtW();
      this.wtr.n(z.dtK().wqU);
      if (az.is4G(this)) {
        z.dtI().au(this);
      }
      for (;;)
      {
        z.dtK().pc(true);
        break;
        if ((az.is2G(this)) || (az.is3G(this))) {
          z.dtI().at(this);
        }
      }
      this.wtq.dtW();
      this.wtr.n(z.dtK().wqU);
      break;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(114668);
    if ((!this.wtx) && (this.wtp)) {
      z.dtK().pa(false);
    }
    super.onStop();
    AppMethodBeat.o(114668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */