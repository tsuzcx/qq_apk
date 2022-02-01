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
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.wecall.talkroom.model.TalkRoom;
import d.g.b.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkMainUI
  extends MMActivity
  implements ServiceConnection, com.tencent.mm.plugin.multitalk.model.e
{
  protected ap gKD;
  private Notification jSl;
  private com.tencent.mm.plugin.voip.a.b uUL;
  private boolean wdM;
  private com.tencent.mm.plugin.multitalk.ui.widget.g wdN;
  private j wdO;
  private boolean wdP;
  private boolean wdQ;
  boolean wdR;
  private MultiTalkMainUI.ScreenActionReceiver wdS;
  private Runnable wdT;
  public boolean wdU;
  private BroadcastReceiver wdV;
  ap wdW;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(114663);
    this.wdP = true;
    this.wdQ = false;
    this.wdR = false;
    this.wdT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114652);
        z.dqx().dqd();
        AppMethodBeat.o(114652);
      }
    };
    this.wdU = false;
    this.wdV = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114656);
        if (("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) && (z.dqx().wbu == i.wgt))
        {
          z.dqx().stopRing();
          MultiTalkMainUI.b(MultiTalkMainUI.this);
        }
        AppMethodBeat.o(114656);
      }
    };
    this.wdW = new MultiTalkMainUI.10(this);
    AppMethodBeat.o(114663);
  }
  
  public final void a(t.a parama)
  {
    AppMethodBeat.i(114687);
    if (parama == t.a.wcy)
    {
      z.dqv().at(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == t.a.wcz)
    {
      z.dqv().as(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == t.a.wcA) {
      com.tencent.mm.bi.e.a(this, 2131764895, null);
    }
    AppMethodBeat.o(114687);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(114686);
    if (parami == i.wgw)
    {
      parami = this.wdO;
      if (parami.wgZ > 0L) {
        parami.wgZ = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(114686);
  }
  
  public final ViewGroup bJP()
  {
    AppMethodBeat.i(114691);
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131304253);
    AppMethodBeat.o(114691);
    return localViewGroup;
  }
  
  public final void ddn()
  {
    AppMethodBeat.i(114675);
    mc localmc = new mc();
    localmc.dzy.action = 0;
    com.tencent.mm.sdk.b.a.IbL.l(localmc);
    this.wdO.pb(true);
    z.dqx().wbH = null;
    z.dqx().stopRing();
    finish();
    AppMethodBeat.o(114675);
  }
  
  public final void ddo()
  {
    AppMethodBeat.i(114688);
    Object localObject4 = this.wdO;
    Object localObject1 = ((j)localObject4).fTP;
    long l = z.dqx().wbA;
    ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
    Object localObject5 = ((j)localObject4).wbR;
    localObject1 = z.dqx();
    p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    HashSet localHashSet = ((o)localObject1).wbt;
    Object localObject3 = z.dqx();
    p.g(localObject3, "SubCoreMultiTalk.getMultiTalkManager()");
    Object localObject2 = ((o)localObject3).wbv.LJC;
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = ((o)localObject3).wbv.LJD;
    }
    List localList = z.dqw().wbf.aZb((String)localObject1);
    localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject5).wah;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).wen;
      if (localObject1 != null)
      {
        Iterator localIterator = ((Iterable)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).vZZ.LJH;
          p.g(localObject1, "it.member.usrName");
          localObject2 = ((com.tencent.mm.plugin.multitalk.model.a)localObject5).aqY((String)localObject1);
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wex != null)
            {
              i = 1;
              label243:
              if (i == 0) {
                break label372;
              }
            }
            for (;;)
            {
              if (localObject2 == null) {
                break label376;
              }
              localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wex;
              if (localObject1 != null)
              {
                localObject3 = ((MultiTalkVideoView)localObject1).getUsername();
                localObject1 = localObject3;
                if (localObject3 != null) {}
              }
              else
              {
                localObject1 = "";
              }
              p.g(localObject1, "it.multiTalkVideoView?.getUsername() ?: \"\"");
              if (!p.i(com.tencent.mm.model.u.aAm(), localObject1)) {
                break label378;
              }
              localObject3 = ((com.tencent.mm.plugin.multitalk.model.a)localObject5).waf;
              if ((localObject3 == null) || (((com.tencent.mm.plugin.multitalk.model.b)localObject3).doW() != true)) {
                break label378;
              }
              localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wey;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(8);
              }
              ad.i("AvatarViewManager", "displayVoiceTalkingIcon, %s hide", new Object[] { localObject1 });
              break;
              i = 0;
              break label243;
              label372:
              localObject2 = null;
            }
            label376:
            continue;
            label378:
            if ((localList != null) && (localList.contains(localObject1) == true) && (localHashSet != null) && (!localHashSet.contains(localObject1)))
            {
              localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wey;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(0);
              }
              ad.i("AvatarViewManager", "displayVoiceTalkingIcon, %s show", new Object[] { localObject1 });
            }
            else
            {
              localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).wey;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(8);
              }
              ad.i("AvatarViewManager", "displayVoiceTalkingIcon, %s hide", new Object[] { localObject1 });
            }
          }
        }
      }
    }
    if (localList != null) {
      n.KA(localList.size());
    }
    localObject3 = ((j)localObject4).wbR;
    localObject4 = z.dqx();
    p.g(localObject4, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject2 = ((o)localObject4).wbv.LJC;
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = ((o)localObject4).wbv.LJD;
    }
    if (com.tencent.mm.plugin.multitalk.model.u.wcC == null) {
      com.tencent.mm.plugin.multitalk.model.u.wcC = new com.tencent.mm.plugin.multitalk.model.u();
    }
    localObject4 = com.tencent.mm.plugin.multitalk.model.u.wcC;
    localObject2 = new ArrayList();
    ((com.tencent.mm.plugin.multitalk.model.u)localObject4).wcD = com.tencent.wecall.talkroom.model.c.fZv().aZZ((String)localObject1);
    if (((com.tencent.mm.plugin.multitalk.model.u)localObject4).wcD != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.u)localObject4).wcD.fZp().iterator();
      label700:
      label761:
      label764:
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (a.ay)((Iterator)localObject1).next();
        i = ((a.ay)localObject4).oWb;
        if (i >= 0)
        {
          localObject5 = new byte[4];
          if (z.dqw().wbf.setAppCmd(10, (byte[])localObject5, i) < 0)
          {
            ad.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[] { Integer.valueOf(i) });
            i = -1;
            if ((i == -1) || (i > 3)) {
              break label761;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label764;
            }
            ((List)localObject2).add(((a.ay)localObject4).dtx);
            break;
            i = bt.bC((byte[])localObject5);
            ad.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
            break label700;
          }
        }
      }
    }
    localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).wah;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).wen;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next();
          if (((List)localObject2).contains(((com.tencent.mm.plugin.multitalk.data.a)localObject4).vZZ.LJH))
          {
            localObject5 = ((com.tencent.mm.plugin.multitalk.data.a)localObject4).vZZ.LJH;
            p.g(localObject5, "it.member.usrName");
            localObject5 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aqY((String)localObject5);
            if (localObject5 != null)
            {
              localObject5 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject5).wez;
              if (localObject5 != null) {
                ((ImageView)localObject5).setVisibility(0);
              }
            }
            boolean bool = p.i(com.tencent.mm.model.u.aAm(), ((com.tencent.mm.plugin.multitalk.data.a)localObject4).vZZ.LJH);
            n.oN(bool);
            if (bool) {
              com.tencent.mm.plugin.voip.c.euN().tv(true);
            }
          }
          else
          {
            localObject4 = ((com.tencent.mm.plugin.multitalk.data.a)localObject4).vZZ.LJH;
            p.g(localObject4, "it.member.usrName");
            localObject4 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aqY((String)localObject4);
            if (localObject4 != null)
            {
              localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).wez;
              if (localObject4 != null) {
                ((ImageView)localObject4).setVisibility(8);
              }
            }
          }
        }
        AppMethodBeat.o(114688);
        return;
      }
    }
    AppMethodBeat.o(114688);
  }
  
  public final void dlr()
  {
    AppMethodBeat.i(114674);
    this.wdN.dqJ();
    this.wdO.m(z.dqx().wbv);
    AppMethodBeat.o(114674);
  }
  
  public final boolean doW()
  {
    AppMethodBeat.i(114689);
    if (this.wdO != null)
    {
      boolean bool = this.wdO.doW();
      AppMethodBeat.o(114689);
      return bool;
    }
    AppMethodBeat.o(114689);
    return false;
  }
  
  public final void dpb()
  {
    AppMethodBeat.i(114676);
    Object localObject = z.dqx();
    if (((o)localObject).wbN != null) {
      ((o)localObject).wbN.K(false, 1);
    }
    localObject = new mc();
    ((mc)localObject).dzy.action = 0;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    this.gKD.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114655);
        MultiTalkMainUI.a(MultiTalkMainUI.this).pb(false);
        AppMethodBeat.o(114655);
      }
    });
    z.dqx().wbH = null;
    z.dqx().stopRing();
    localObject = z.dqx();
    if (((o)localObject).wbN != null) {
      ((o)localObject).wbN.doI();
    }
    if (z.dqx().wbN != null) {
      com.tencent.mm.plugin.multitalk.a.a.unInit();
    }
    finish();
    AppMethodBeat.o(114676);
  }
  
  public final void dpc()
  {
    AppMethodBeat.i(114673);
    switch (2.wdY[z.dqx().wbu.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114673);
      return;
      this.wdO.m(z.dqx().wbv);
      AppMethodBeat.o(114673);
      return;
      this.wdN.l(z.dqx().wbv);
    }
  }
  
  public final void dpd()
  {
    AppMethodBeat.i(114678);
    ad.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + z.dqx().wbt.size());
    Object localObject;
    if (z.dqx().dpM())
    {
      localObject = z.dqx().wbt;
      if (((HashSet)localObject).size() <= 0) {
        break label143;
      }
      if ((((HashSet)localObject).size() != 1) || (!((HashSet)localObject).contains(com.tencent.mm.model.u.aAm()))) {
        break label134;
      }
      z.dqx().dqe();
    }
    for (;;)
    {
      localObject = this.wdO;
      HashSet localHashSet = new HashSet(z.dqx().wbt);
      if (t.KI(z.dqx().wbr)) {
        ((j)localObject).e(localHashSet);
      }
      n.KB(localHashSet.size());
      AppMethodBeat.o(114678);
      return;
      label134:
      z.dqx().dqd();
      continue;
      label143:
      localObject = z.dqx();
      ad.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
      if (((o)localObject).wbw != null) {
        ((o)localObject).wbw.stopVideo();
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(206584);
    super.finish();
    if (this.wdO != null) {
      this.wdO.gFv = false;
    }
    AppMethodBeat.o(206584);
  }
  
  public final void gE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114681);
    if (z.dqx().dpM())
    {
      j localj = this.wdO;
      if (!t.KH(paramInt2))
      {
        if (t.KH(paramInt1))
        {
          localj.wgF.setChecked(false);
          localj.wgE.setVisibility(8);
          localj.wbR.eq(com.tencent.mm.model.u.aAm(), 0);
        }
        localj.pa(false);
      }
      HashSet localHashSet;
      for (;;)
      {
        localHashSet = new HashSet(z.dqx().wbt);
        if (t.KI(paramInt2)) {
          break;
        }
        if (!t.KI(paramInt1)) {
          break label169;
        }
        localj.wbR.o(localHashSet);
        AppMethodBeat.o(114681);
        return;
        if (!t.KH(paramInt1))
        {
          localj.wgF.setChecked(true);
          localj.wbR.eq(com.tencent.mm.model.u.aAm(), 1);
          localj.wgE.setVisibility(0);
        }
      }
      if ((t.KI(paramInt2)) && (!t.KI(paramInt1))) {
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
  
  public final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(114679);
    if (z.dqx().dpM())
    {
      Object localObject1 = this.wdO;
      ((j)localObject1).wgG.setChecked(paramBoolean);
      localObject1 = ((j)localObject1).wbR;
      Object localObject2 = com.tencent.mm.model.u.aAm();
      p.g(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject1).aqY((String)localObject2);
      if (localObject1 != null)
      {
        if (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).wex != null)
        {
          i = 1;
          if (i == 0) {
            break label162;
          }
          label70:
          if (localObject1 == null) {
            break label173;
          }
          if (!paramBoolean) {
            break label167;
          }
        }
        label162:
        label167:
        for (int i = 0;; i = 8)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).weB;
          if (localObject2 != null)
          {
            View localView = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).auu;
            p.g(localView, "itemView");
            ((ImageView)localObject2).setBackground(ao.k(localView.getContext(), 2131690327, -65536));
          }
          localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).auu.findViewById(2131302584);
          p.g(localObject1, "itemView.findViewById<Re…d.multitalk_mute_icon_bg)");
          ((RelativeLayout)localObject1).setVisibility(i);
          AppMethodBeat.o(114679);
          return;
          i = 0;
          break;
          localObject1 = null;
          break label70;
        }
      }
    }
    label173:
    AppMethodBeat.o(114679);
  }
  
  public final void oH(boolean paramBoolean)
  {
    AppMethodBeat.i(114680);
    if (z.dqx().dpM())
    {
      j localj = this.wdO;
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      localj.wgH.setChecked(paramBoolean);
      localj.dqN();
    }
    AppMethodBeat.o(114680);
  }
  
  public final void oI(boolean paramBoolean)
  {
    AppMethodBeat.i(114682);
    if (z.dqx().dpM())
    {
      j localj = this.wdO;
      if (localj.wgH != null) {
        localj.wgH.setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(114682);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114672);
    ad.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.wdU = false;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ad.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(paramIntent)));
      ArrayList localArrayList = bt.U(paramIntent.split(","));
      if (localArrayList == null)
      {
        AppMethodBeat.o(114672);
        return;
      }
      o localo = z.dqx();
      if (localo.dpa())
      {
        String str = localo.wbv.LJC;
        paramIntent = str;
        if (bt.isNullOrNil(str)) {
          paramIntent = localo.wbv.LJD;
        }
        z.dqw().wbf.I(paramIntent, localArrayList);
      }
    }
    AppMethodBeat.o(114672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114664);
    super.onCreate(paramBundle);
    z.dqx().dqb();
    com.tencent.mm.util.d.erL();
    z.dqx().dpU();
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
      z.dqx().nz(false);
      if (z.dqx().dpa()) {
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
    z.dqs();
    z.dqr();
    this.wdN = new com.tencent.mm.plugin.multitalk.ui.widget.g(this);
    this.wdO = new j(this);
    z.dqx().oU(z.dqx().lbb);
    z.dqx().wbH = this;
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.wdV, paramBundle);
    this.wdQ = true;
    this.gKD = new ap();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
      ad.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.ly(26))
    {
      ad.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.wdS = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      aj.getContext().registerReceiver(this.wdS, paramBundle);
    }
    this.jSl = ((Notification)getIntent().getParcelableExtra("notification"));
    this.uUL = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
    this.uUL.ac(9, "VOIPFloatBall");
    AppMethodBeat.o(114664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114667);
    if (this.wdU) {
      z.dqx().oT(false);
    }
    if (this.wdQ) {
      unregisterReceiver(this.wdV);
    }
    this.wdW.removeCallbacksAndMessages(null);
    this.wdW.sendEmptyMessage(1);
    ad.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.ly(26)) && (this.wdR))
      {
        aj.getContext().unbindService(this);
        this.wdR = false;
      }
      if (com.tencent.mm.compatible.util.d.ly(26))
      {
        ad.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.wdS == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        aj.getContext().unregisterReceiver(this.wdS);
        this.wdS = null;
        super.onDestroy();
        if (this.uUL != null) {
          this.uUL.onDestroy();
        }
        AppMethodBeat.o(114667);
        return;
        localException1 = localException1;
        ad.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", localException1, "unbindVoiceServiceIfNeed error: %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(114677);
    if (paramInt == -1700)
    {
      j localj = this.wdO;
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localj.pa(false);
      z.dqx().KE(1);
      localj.wgF.setChecked(false);
    }
    AppMethodBeat.o(114677);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(114669);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.ui.base.h.a(this, 2131761410, 2131761388, 2131755277, 2131755691, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114654);
          z.dqx().h(false, false, false);
          AppMethodBeat.o(114654);
        }
      }, null);
      AppMethodBeat.o(114669);
      return true;
    }
    if (z.dqx().wbu == i.wgt)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        z.dqx().stopRing();
        this.wdP = false;
        AppMethodBeat.o(114669);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        paramKeyEvent = z.dqx();
        if (paramKeyEvent.wbN != null) {
          paramKeyEvent.wbN.xm(com.tencent.mm.plugin.multitalk.a.a.ddZ());
        }
        AppMethodBeat.o(114669);
        return true;
      }
      if (paramInt == 24)
      {
        paramKeyEvent = z.dqx();
        if (paramKeyEvent.wbN != null) {
          paramKeyEvent.wbN.xl(com.tencent.mm.plugin.multitalk.a.a.ddZ());
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
    z.dqx().dqe();
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)aj.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.wdM = bool1;
      ad.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.wdM) });
      if (z.dqx().dpM()) {
        this.wdO.pa(true);
      }
      if ((!this.wdU) && (this.uUL != null))
      {
        this.uUL.bgC();
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
      ad.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(114690);
      return;
    }
    ad.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new MultiTalkMainUI.6(this), new MultiTalkMainUI.7(this));
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new MultiTalkMainUI.8(this), new MultiTalkMainUI.9(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(114665);
    ad.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
    super.onResume();
    if (this.uUL != null)
    {
      this.uUL.bKs();
      f.e(true, false, true);
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.backgroundrunning.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.h.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.h)localObject).bde();
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.h)localObject).bdf();
    }
    localObject = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.ball.c.c)localObject).m(new BallInfo(6, "MusicFloatBall"));
    }
    switch (2.wdY[z.dqx().wbu.ordinal()])
    {
    default: 
      if (z.dqx().dpM())
      {
        localObject = z.dqx();
        if (!((o)localObject).wbU) {
          break label378;
        }
      }
      break;
    }
    label378:
    for (boolean bool = false;; bool = t.KH(((o)localObject).wbr))
    {
      if (bool) {
        this.wdO.oZ(true);
      }
      this.gKD.postDelayed(this.wdT, 2000L);
      AppMethodBeat.o(114665);
      return;
      localObject = this.wdO;
      ((j)localObject).wgB.setVisibility(8);
      ((j)localObject).wgD.setVisibility(8);
      this.wdN.l(z.dqx().wbv);
      if (ay.is4G(this)) {
        z.dqv().at(this);
      }
      while (this.wdP)
      {
        z.dqx().oV(false);
        break;
        if ((ay.is2G(this)) || (ay.is3G(this))) {
          z.dqv().as(this);
        }
      }
      this.wdN.dqJ();
      this.wdO.m(z.dqx().wbv);
      if (ay.is4G(this)) {
        z.dqv().at(this);
      }
      for (;;)
      {
        z.dqx().oV(true);
        break;
        if ((ay.is2G(this)) || (ay.is3G(this))) {
          z.dqv().as(this);
        }
      }
      this.wdN.dqJ();
      this.wdO.m(z.dqx().wbv);
      break;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(114668);
    if ((!this.wdU) && (this.wdM)) {
      z.dqx().oT(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */