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
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.voip.ui.d.6;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.wecall.talkroom.model.TalkRoom;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkMainUI
  extends MMActivity
  implements ServiceConnection, com.tencent.mm.plugin.multitalk.model.b
{
  protected ao gqT;
  private Notification jyo;
  private com.tencent.mm.plugin.voip.a.b tRY;
  private boolean uYO;
  private com.tencent.mm.plugin.multitalk.ui.widget.g uYP;
  private com.tencent.mm.plugin.multitalk.ui.widget.j uYQ;
  private boolean uYR;
  private boolean uYS;
  boolean uYT;
  private MultiTalkMainUI.ScreenActionReceiver uYU;
  private Runnable uYV;
  private boolean uYW;
  private BroadcastReceiver uYX;
  ao uYY;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(114663);
    this.uYR = true;
    this.uYS = false;
    this.uYT = false;
    this.uYV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114652);
        p.dgx().dgf();
        AppMethodBeat.o(114652);
      }
    };
    this.uYW = false;
    this.uYX = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114656);
        if (("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) && (p.dgx().uXj == com.tencent.mm.plugin.multitalk.ui.widget.i.vbk))
        {
          p.dgx().stopRing();
          MultiTalkMainUI.b(MultiTalkMainUI.this);
        }
        AppMethodBeat.o(114656);
      }
    };
    this.uYY = new MultiTalkMainUI.10(this);
    AppMethodBeat.o(114663);
  }
  
  public final void a(com.tencent.mm.plugin.multitalk.model.j.a parama)
  {
    AppMethodBeat.i(114687);
    if (parama == com.tencent.mm.plugin.multitalk.model.j.a.uYb)
    {
      p.dgv().at(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == com.tencent.mm.plugin.multitalk.model.j.a.uYc)
    {
      p.dgv().as(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == com.tencent.mm.plugin.multitalk.model.j.a.uYd) {
      com.tencent.mm.bh.e.a(this, 2131764895, null);
    }
    AppMethodBeat.o(114687);
  }
  
  public final void a(com.tencent.mm.plugin.multitalk.ui.widget.i parami)
  {
    AppMethodBeat.i(114686);
    if (parami == com.tencent.mm.plugin.multitalk.ui.widget.i.vbn)
    {
      parami = this.uYQ;
      if (parami.vbQ > 0L) {
        parami.vbQ = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(114686);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114684);
    this.uYQ.a(paramString, paramBitmap, paramInt1, paramInt2);
    AppMethodBeat.o(114684);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(114683);
    if (p.dgx().dfU()) {
      this.uYQ.a(paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(114683);
  }
  
  public final int amv(String paramString)
  {
    AppMethodBeat.i(114685);
    paramString = this.uYQ.amG(paramString);
    if ((paramString != null) && (paramString.uZv != null))
    {
      int i = paramString.uZv.getPosition();
      AppMethodBeat.o(114685);
      return i;
    }
    AppMethodBeat.o(114685);
    return 0;
  }
  
  public final ViewGroup bFF()
  {
    AppMethodBeat.i(114691);
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131304253);
    AppMethodBeat.o(114691);
    return localViewGroup;
  }
  
  public final void cUc()
  {
    AppMethodBeat.i(114675);
    lt locallt = new lt();
    locallt.dnK.action = 0;
    com.tencent.mm.sdk.b.a.GpY.l(locallt);
    this.uYQ.oC(true);
    p.dgx().uXw = null;
    p.dgx().stopRing();
    finish();
    AppMethodBeat.o(114675);
  }
  
  public final void cUd()
  {
    AppMethodBeat.i(114688);
    com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.uYQ;
    Object localObject1 = localj.fAz;
    long l = p.dgx().uXp;
    ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
    Object localObject3 = p.dgx();
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).uXk.JPR;
    localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).uXk.JPS;
    }
    localObject1 = p.dgw().uWU.aTb((String)localObject1);
    localObject2 = p.dgx().uXi;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject3 = (com.tencent.mm.plugin.multitalk.ui.widget.a)localj.vbp.getAdapter();
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject3).uZl.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = localj.amG(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject3).next()).uWR.JPW);
          if ((localObject4 != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).uZv != null))
          {
            String str = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).uZv.getUsername();
            if (((!u.axw().equals(str)) || (!localj.dfs())) && (((List)localObject1).contains(str)) && (!((HashSet)localObject2).contains(str)))
            {
              ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).uZw.setVisibility(0);
              ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s show", new Object[] { str });
            }
            else
            {
              ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).uZw.setVisibility(8);
              ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s hide", new Object[] { str });
            }
          }
        }
        com.tencent.mm.plugin.multitalk.model.e.Jb(((List)localObject1).size());
      }
    }
    localObject3 = p.dgx();
    localObject2 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).uXk.JPR;
    localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).uXk.JPS;
    }
    if (n.uYB == null) {
      n.uYB = new n();
    }
    localObject3 = n.uYB;
    localObject2 = new ArrayList();
    ((n)localObject3).uYC = com.tencent.wecall.talkroom.model.c.fIe().aUb((String)localObject1);
    if (((n)localObject3).uYC != null)
    {
      localObject1 = ((n)localObject3).uYC.fHY().iterator();
      label565:
      label568:
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (a.ay)((Iterator)localObject1).next();
        int i = ((a.ay)localObject3).osF;
        if (i >= 0)
        {
          localObject4 = new byte[4];
          if (p.dgw().uWU.setAppCmd(10, (byte[])localObject4, i) < 0)
          {
            ac.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[] { Integer.valueOf(i) });
            i = -1;
            label504:
            if ((i == -1) || (i > 3)) {
              break label565;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label568;
            }
            ((List)localObject2).add(((a.ay)localObject3).dhV);
            break;
            i = bs.bv((byte[])localObject4);
            ac.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
            break label504;
          }
        }
      }
    }
    localObject1 = (com.tencent.mm.plugin.multitalk.ui.widget.a)localj.vbp.getAdapter();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).uZl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = localj.amG(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next()).uWR.JPW);
        if ((localObject3 != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).uZv != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).uZx != null))
        {
          localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).uZv.getUsername();
          if (((List)localObject2).contains(localObject4))
          {
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).uZx.setVisibility(0);
            com.tencent.mm.plugin.multitalk.model.e.or(u.axw().equals(localObject4));
            if (u.axw().equals(localObject4))
            {
              localObject3 = com.tencent.mm.plugin.voip.c.ehc();
              if ((((com.tencent.mm.plugin.voip.ui.d)localObject3).AKy != null) && (!((com.tencent.mm.plugin.voip.ui.d)localObject3).AKB))
              {
                com.tencent.e.h.JZN.aTz("showIcon");
                com.tencent.e.h.JZN.f(new d.6((com.tencent.mm.plugin.voip.ui.d)localObject3), "showIcon");
              }
            }
          }
          else
          {
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).uZx.setVisibility(8);
          }
        }
      }
    }
    AppMethodBeat.o(114688);
  }
  
  public final void dbX()
  {
    AppMethodBeat.i(114674);
    this.uYP.dgH();
    this.uYQ.m(p.dgx().uXk);
    AppMethodBeat.o(114674);
  }
  
  public final void dfp()
  {
    AppMethodBeat.i(114676);
    Object localObject = p.dgx();
    if (((com.tencent.mm.plugin.multitalk.model.f)localObject).uXD != null) {
      ((com.tencent.mm.plugin.multitalk.model.f)localObject).uXD.K(false, 1);
    }
    localObject = new lt();
    ((lt)localObject).dnK.action = 0;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    this.gqT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114655);
        MultiTalkMainUI.a(MultiTalkMainUI.this).oC(false);
        AppMethodBeat.o(114655);
      }
    });
    p.dgx().uXw = null;
    p.dgx().stopRing();
    localObject = p.dgx();
    if (((com.tencent.mm.plugin.multitalk.model.f)localObject).uXD != null) {
      ((com.tencent.mm.plugin.multitalk.model.f)localObject).uXD.dfk();
    }
    if (p.dgx().uXD != null) {
      com.tencent.mm.plugin.multitalk.a.a.unInit();
    }
    finish();
    AppMethodBeat.o(114676);
  }
  
  public final void dfq()
  {
    AppMethodBeat.i(114673);
    switch (2.uZa[p.dgx().uXj.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114673);
      return;
      this.uYQ.m(p.dgx().uXk);
      AppMethodBeat.o(114673);
      return;
      this.uYP.l(p.dgx().uXk);
    }
  }
  
  public final void dfr()
  {
    AppMethodBeat.i(114678);
    ac.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + p.dgx().uXi.size());
    if (p.dgx().dfU())
    {
      if (p.dgx().uXi.size() <= 0) {
        break label119;
      }
      p.dgx().dgf();
    }
    for (;;)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.uYQ;
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(p.dgx().uXi);
      if (com.tencent.mm.plugin.multitalk.model.j.Jh(p.dgx().uXg)) {
        localj.e(localHashSet);
      }
      com.tencent.mm.plugin.multitalk.model.e.Jc(localHashSet.size());
      AppMethodBeat.o(114678);
      return;
      label119:
      p.dgx().dgg();
    }
  }
  
  public final boolean dfs()
  {
    AppMethodBeat.i(114689);
    if (this.uYQ != null)
    {
      boolean bool = this.uYQ.dfs();
      AppMethodBeat.o(114689);
      return bool;
    }
    AppMethodBeat.o(114689);
    return false;
  }
  
  public final void dgC()
  {
    AppMethodBeat.i(114671);
    if (!this.uYW)
    {
      this.uYW = true;
      Intent localIntent = new Intent(this, MultiTalkAddMembersUI.class);
      ArrayList localArrayList = new ArrayList();
      if (p.dgx().uXk != null)
      {
        Iterator localIterator = p.dgx().uXk.JPV.iterator();
        while (localIterator.hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
          if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
            localArrayList.add(localMultiTalkGroupMember.JPW);
          }
        }
        localIntent.putExtra("titile", getString(2131761389));
        localIntent.putExtra("chatroomName", p.dgx().uXk.JPT);
        localIntent.putExtra("always_select_contact", bs.n(localArrayList, ","));
        localIntent.putExtra("key_need_gallery", false);
        startActivityForResult(localIntent, 1);
      }
    }
    AppMethodBeat.o(114671);
  }
  
  public void finish()
  {
    AppMethodBeat.i(200696);
    super.finish();
    if (this.uYQ != null) {
      this.uYQ.glL = false;
    }
    AppMethodBeat.o(200696);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494976;
  }
  
  public final void gn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114681);
    if (p.dgx().dfU())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.uYQ;
      Object localObject = localj.amG(u.axw());
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.multitalk.model.j.Jg(paramInt2))
        {
          if (com.tencent.mm.plugin.multitalk.model.j.Jg(paramInt1))
          {
            localj.vbw.setChecked(false);
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).uZv.dgM();
            localj.vbv.setVisibility(8);
            if ((localj.vbJ.equals(u.axw())) && (localj.vbq.getVisibility() == 0))
            {
              localj.vbJ = "";
              localj.vbp.setVisibility(0);
              localj.vbq.setVisibility(8);
            }
          }
          localj.amH(u.axw());
          localj.oB(false);
        }
        for (;;)
        {
          localObject = new HashSet();
          ((HashSet)localObject).addAll(p.dgx().uXi);
          if (com.tencent.mm.plugin.multitalk.model.j.Jh(paramInt2)) {
            break;
          }
          if (!com.tencent.mm.plugin.multitalk.model.j.Jh(paramInt1)) {
            break label266;
          }
          localj.dgJ();
          AppMethodBeat.o(114681);
          return;
          if ((com.tencent.mm.plugin.multitalk.model.j.Jg(paramInt2)) && (!com.tencent.mm.plugin.multitalk.model.j.Jg(paramInt1)))
          {
            localj.vbw.setChecked(true);
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).uZv.dgN();
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).uZy.setVisibility(8);
            ap.n(new com.tencent.mm.plugin.multitalk.ui.widget.j.a(localj, (com.tencent.mm.plugin.multitalk.ui.widget.b)localObject), 1500L);
            localj.vbv.setVisibility(0);
          }
        }
        if ((com.tencent.mm.plugin.multitalk.model.j.Jh(paramInt2)) && (!com.tencent.mm.plugin.multitalk.model.j.Jh(paramInt1))) {
          localj.e((HashSet)localObject);
        }
      }
    }
    label266:
    AppMethodBeat.o(114681);
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(114679);
    Object localObject;
    if (p.dgx().dfU())
    {
      localObject = this.uYQ;
      ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).vbx.setChecked(paramBoolean);
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).amG(u.axw());
      if ((localObject != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).uZz != null)) {
        if (!paramBoolean) {
          break label130;
        }
      }
    }
    label130:
    for (int i = 0;; i = 8)
    {
      ImageView localImageView = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).uZz;
      if (localImageView != null)
      {
        View localView = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).asD;
        k.g(localView, "itemView");
        localImageView.setBackground(am.k(localView.getContext(), 2131690327, -65536));
      }
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).asD.findViewById(2131302584);
      k.g(localObject, "itemView.findViewById<Re…d.multitalk_mute_icon_bg)");
      ((RelativeLayout)localObject).setVisibility(i);
      AppMethodBeat.o(114679);
      return;
    }
  }
  
  public final void on(boolean paramBoolean)
  {
    AppMethodBeat.i(114680);
    if (p.dgx().dfU())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.uYQ;
      ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      localj.vby.setChecked(paramBoolean);
      localj.dgK();
    }
    AppMethodBeat.o(114680);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114672);
    ac.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.uYW = false;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ac.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(paramIntent)));
      ArrayList localArrayList = bs.S(paramIntent.split(","));
      if (localArrayList == null)
      {
        AppMethodBeat.o(114672);
        return;
      }
      com.tencent.mm.plugin.multitalk.model.f localf = p.dgx();
      if (localf.dfo())
      {
        String str = localf.uXk.JPR;
        paramIntent = str;
        if (bs.isNullOrNil(str)) {
          paramIntent = localf.uXk.JPS;
        }
        p.dgw().uWU.G(paramIntent, localArrayList);
      }
    }
    AppMethodBeat.o(114672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114664);
    super.onCreate(paramBundle);
    p.dgx().dgd();
    com.tencent.mm.util.b.fwU();
    p.dgx().dfW();
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
      p.dgx().nf(false);
      if (p.dgx().dfo()) {
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
    p.dgs();
    p.dgr();
    this.uYP = new com.tencent.mm.plugin.multitalk.ui.widget.g(this);
    this.uYQ = new com.tencent.mm.plugin.multitalk.ui.widget.j(this);
    p.dgx().ox(p.dgx().kER);
    p.dgx().uXw = this;
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.uYX, paramBundle);
    this.uYS = true;
    this.gqT = new ao();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
      ac.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.kZ(26))
    {
      ac.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.uYU = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      ai.getContext().registerReceiver(this.uYU, paramBundle);
    }
    this.jyo = ((Notification)getIntent().getParcelableExtra("notification"));
    this.tRY = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
    this.tRY.aa(9, "VOIPFloatBall");
    AppMethodBeat.o(114664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114667);
    if (this.uYW) {
      p.dgx().ow(false);
    }
    if (this.uYS) {
      unregisterReceiver(this.uYX);
    }
    this.uYY.removeCallbacksAndMessages(null);
    this.uYY.sendEmptyMessage(1);
    ac.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.kZ(26)) && (this.uYT))
      {
        ai.getContext().unbindService(this);
        this.uYT = false;
      }
      if (com.tencent.mm.compatible.util.d.kZ(26))
      {
        ac.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.uYU == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        ai.getContext().unregisterReceiver(this.uYU);
        this.uYU = null;
        super.onDestroy();
        if (this.tRY != null) {
          this.tRY.onDestroy();
        }
        AppMethodBeat.o(114667);
        return;
        localException1 = localException1;
        ac.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", localException1, "unbindVoiceServiceIfNeed error: %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(114677);
    if (paramInt == -1700)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.uYQ;
      ac.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localj.oB(false);
      p.dgx().Jf(1);
      localj.vbw.setChecked(false);
    }
    AppMethodBeat.o(114677);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(114669);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      com.tencent.mm.ui.base.h.b(this, 2131761410, 2131761388, 2131755277, 2131755691, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114654);
          p.dgx().h(false, false, false);
          AppMethodBeat.o(114654);
        }
      }, null);
      AppMethodBeat.o(114669);
      return true;
    }
    if (p.dgx().uXj == com.tencent.mm.plugin.multitalk.ui.widget.i.vbk)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        p.dgx().stopRing();
        this.uYR = false;
        AppMethodBeat.o(114669);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        paramKeyEvent = p.dgx();
        if (paramKeyEvent.uXD != null) {
          paramKeyEvent.uXD.wG(com.tencent.mm.plugin.multitalk.a.a.cUO());
        }
        AppMethodBeat.o(114669);
        return true;
      }
      if (paramInt == 24)
      {
        paramKeyEvent = p.dgx();
        if (paramKeyEvent.uXD != null) {
          paramKeyEvent.uXD.wF(com.tencent.mm.plugin.multitalk.a.a.cUO());
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
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)ai.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ai.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.uYO = bool1;
      ac.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.uYO) });
      if (p.dgx().dfU())
      {
        p.dgx().dgg();
        this.uYQ.oB(true);
      }
      if ((!this.uYW) && (this.tRY != null))
      {
        this.tRY.bcY();
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
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
      ac.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(114690);
      return;
    }
    ac.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ac.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new MultiTalkMainUI.6(this), new MultiTalkMainUI.7(this));
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ac.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new MultiTalkMainUI.8(this), new MultiTalkMainUI.9(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(114665);
    ac.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
    super.onResume();
    if (this.tRY != null)
    {
      this.tRY.bGh();
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.backgroundrunning.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.h.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.h)localObject).aZF();
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.h)localObject).aZG();
    }
    localObject = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.ball.c.c)localObject).l(new BallInfo(6, "MusicFloatBall"));
    }
    switch (2.uZa[p.dgx().uXj.ordinal()])
    {
    }
    for (;;)
    {
      if (p.dgx().dfU())
      {
        if (com.tencent.mm.plugin.multitalk.model.j.Jg(p.dgx().uXg)) {
          this.uYQ.oA(true);
        }
        this.gqT.postDelayed(this.uYV, 2000L);
      }
      AppMethodBeat.o(114665);
      return;
      localObject = this.uYQ;
      ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).vbs.setVisibility(8);
      ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).vbu.setVisibility(8);
      this.uYP.l(p.dgx().uXk);
      if (ax.is4G(this)) {
        p.dgv().at(this);
      }
      while (this.uYR)
      {
        p.dgx().oy(false);
        break;
        if ((ax.is2G(this)) || (ax.is3G(this))) {
          p.dgv().as(this);
        }
      }
      this.uYP.dgH();
      this.uYQ.m(p.dgx().uXk);
      if (ax.is4G(this)) {
        p.dgv().at(this);
      }
      for (;;)
      {
        p.dgx().oy(true);
        break;
        if ((ax.is2G(this)) || (ax.is3G(this))) {
          p.dgv().as(this);
        }
      }
      this.uYP.dgH();
      this.uYQ.m(p.dgx().uXk);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(114668);
    if ((!this.uYW) && (this.uYO)) {
      p.dgx().ow(false);
    }
    super.onStop();
    AppMethodBeat.o(114668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(114682);
    if (p.dgx().dfU())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.uYQ;
      if (localj.vby != null) {
        localj.vby.setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(114682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */