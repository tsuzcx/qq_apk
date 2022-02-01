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
import android.os.Message;
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
import com.tencent.mm.g.a.lk;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.plugin.voip.ui.d.6;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  private Notification iXX;
  protected ap oFl;
  private com.tencent.mm.plugin.voip.a.b sKs;
  private boolean tQo;
  private com.tencent.mm.plugin.multitalk.ui.widget.g tQp;
  private com.tencent.mm.plugin.multitalk.ui.widget.j tQq;
  private boolean tQr;
  private boolean tQs;
  boolean tQt;
  private MultiTalkMainUI.ScreenActionReceiver tQu;
  private Runnable tQv;
  private boolean tQw;
  private BroadcastReceiver tQx;
  ap tQy;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(114663);
    this.tQr = true;
    this.tQs = false;
    this.tQt = false;
    this.tQv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114652);
        p.cSO().cSv();
        AppMethodBeat.o(114652);
      }
    };
    this.tQw = false;
    this.tQx = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114656);
        if (("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) && (p.cSO().tOH == com.tencent.mm.plugin.multitalk.ui.widget.i.tSD))
        {
          p.cSO().stopRing();
          MultiTalkMainUI.b(MultiTalkMainUI.this);
        }
        AppMethodBeat.o(114656);
      }
    };
    this.tQy = new ap()
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
            ad.i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
            try
            {
              if (com.tencent.mm.compatible.util.d.lf(26))
              {
                paramAnonymousMessage.tQt = true;
                Intent localIntent = new Intent();
                localIntent.setClass(aj.getContext(), MultiTalkingForegroundService.class);
                aj.getContext().bindService(localIntent, paramAnonymousMessage, 1);
              }
              AppMethodBeat.o(114661);
              return;
            }
            catch (Exception paramAnonymousMessage)
            {
              ad.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", paramAnonymousMessage, "bindVoiceServiceIfNeed error: %s", new Object[] { paramAnonymousMessage.getMessage() });
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
  
  public final void a(com.tencent.mm.plugin.multitalk.model.j.a parama)
  {
    AppMethodBeat.i(114687);
    if (parama == com.tencent.mm.plugin.multitalk.model.j.a.tPA)
    {
      p.cSM().ap(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == com.tencent.mm.plugin.multitalk.model.j.a.tPB)
    {
      p.cSM().ao(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == com.tencent.mm.plugin.multitalk.model.j.a.tPC) {
      com.tencent.mm.bi.e.a(this, 2131764895, null);
    }
    AppMethodBeat.o(114687);
  }
  
  public final void a(com.tencent.mm.plugin.multitalk.ui.widget.i parami)
  {
    AppMethodBeat.i(114686);
    if (parami == com.tencent.mm.plugin.multitalk.ui.widget.i.tSG)
    {
      parami = this.tQq;
      if (parami.tTj > 0L) {
        parami.tTj = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(114686);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114684);
    this.tQq.a(paramString, paramBitmap, paramInt1, paramInt2);
    AppMethodBeat.o(114684);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(114683);
    if (p.cSO().cSk()) {
      this.tQq.a(paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(114683);
  }
  
  public final int ahA(String paramString)
  {
    AppMethodBeat.i(114685);
    paramString = this.tQq.ahL(paramString);
    if ((paramString != null) && (paramString.tQS != null))
    {
      int i = paramString.tQS.getPosition();
      AppMethodBeat.o(114685);
      return i;
    }
    AppMethodBeat.o(114685);
    return 0;
  }
  
  public final ViewGroup byJ()
  {
    AppMethodBeat.i(114691);
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131304253);
    AppMethodBeat.o(114691);
    return localViewGroup;
  }
  
  public final void cGR()
  {
    AppMethodBeat.i(114675);
    lk locallk = new lk();
    locallk.dpZ.action = 0;
    com.tencent.mm.sdk.b.a.ESL.l(locallk);
    this.tQq.nI(true);
    p.cSO().tOU = null;
    p.cSO().stopRing();
    finish();
    AppMethodBeat.o(114675);
  }
  
  public final void cGS()
  {
    AppMethodBeat.i(114688);
    com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.tQq;
    Object localObject1 = localj.fwS;
    long l = p.cSO().tON;
    ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
    Object localObject3 = p.cSO();
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).tOI.Iog;
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).tOI.Ioh;
    }
    localObject1 = p.cSN().tOr.aNy((String)localObject1);
    localObject2 = p.cSO().tOG;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject3 = (com.tencent.mm.plugin.multitalk.ui.widget.a)localj.tSI.getAdapter();
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject3).tQL.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = localj.ahL(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject3).next()).tOo.Iol);
          if ((localObject4 != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).tQS != null))
          {
            String str = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).tQS.getUsername();
            if (((!u.aqG().equals(str)) || (!localj.cRI())) && (((List)localObject1).contains(str)) && (!((HashSet)localObject2).contains(str)))
            {
              ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).tQT.setVisibility(0);
              ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s show", new Object[] { str });
            }
            else
            {
              ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).tQT.setVisibility(8);
              ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s hide", new Object[] { str });
            }
          }
        }
        com.tencent.mm.plugin.multitalk.model.e.He(((List)localObject1).size());
      }
    }
    localObject3 = p.cSO();
    localObject2 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).tOI.Iog;
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.f)localObject3).tOI.Ioh;
    }
    if (n.tQb == null) {
      n.tQb = new n();
    }
    localObject3 = n.tQb;
    localObject2 = new ArrayList();
    ((n)localObject3).tQc = com.tencent.wecall.talkroom.model.c.fpJ().aOp((String)localObject1);
    if (((n)localObject3).tQc != null)
    {
      localObject1 = ((n)localObject3).tQc.fpD().iterator();
      label565:
      label568:
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (a.ay)((Iterator)localObject1).next();
        int i = ((a.ay)localObject3).nPB;
        if (i >= 0)
        {
          localObject4 = new byte[4];
          if (p.cSN().tOr.setAppCmd(10, (byte[])localObject4, i) < 0)
          {
            ad.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[] { Integer.valueOf(i) });
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
            ((List)localObject2).add(((a.ay)localObject3).Imu);
            break;
            i = bt.bw((byte[])localObject4);
            ad.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
            break label504;
          }
        }
      }
    }
    localObject1 = (com.tencent.mm.plugin.multitalk.ui.widget.a)localj.tSI.getAdapter();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).tQL.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = localj.ahL(((com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject1).next()).tOo.Iol);
        if ((localObject3 != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).tQS != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).tQU != null))
        {
          localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).tQS.getUsername();
          if (((List)localObject2).contains(localObject4))
          {
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).tQU.setVisibility(0);
            com.tencent.mm.plugin.multitalk.model.e.nx(u.aqG().equals(localObject4));
            if (u.aqG().equals(localObject4))
            {
              localObject3 = com.tencent.mm.plugin.voip.c.dRR();
              if ((((com.tencent.mm.plugin.voip.ui.d)localObject3).zrN != null) && (!((com.tencent.mm.plugin.voip.ui.d)localObject3).zrQ))
              {
                com.tencent.e.h.Iye.aNW("showIcon");
                com.tencent.e.h.Iye.f(new d.6((com.tencent.mm.plugin.voip.ui.d)localObject3), "showIcon");
              }
            }
          }
          else
          {
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject3).tQU.setVisibility(8);
          }
        }
      }
    }
    AppMethodBeat.o(114688);
  }
  
  public final void cOp()
  {
    AppMethodBeat.i(114674);
    this.tQp.cSX();
    this.tQq.m(p.cSO().tOI);
    AppMethodBeat.o(114674);
  }
  
  public final void cRF()
  {
    AppMethodBeat.i(114676);
    Object localObject = p.cSO();
    if (((com.tencent.mm.plugin.multitalk.model.f)localObject).tPb != null) {
      ((com.tencent.mm.plugin.multitalk.model.f)localObject).tPb.I(false, 1);
    }
    localObject = new lk();
    ((lk)localObject).dpZ.action = 0;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    this.oFl.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(114655);
        MultiTalkMainUI.a(MultiTalkMainUI.this).nI(false);
        AppMethodBeat.o(114655);
      }
    });
    p.cSO().tOU = null;
    p.cSO().stopRing();
    localObject = p.cSO();
    if (((com.tencent.mm.plugin.multitalk.model.f)localObject).tPb != null) {
      ((com.tencent.mm.plugin.multitalk.model.f)localObject).tPb.cRA();
    }
    if (p.cSO().tPb != null) {
      com.tencent.mm.plugin.multitalk.a.a.NX();
    }
    finish();
    AppMethodBeat.o(114676);
  }
  
  public final void cRG()
  {
    AppMethodBeat.i(114673);
    switch (2.tQA[p.cSO().tOH.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114673);
      return;
      this.tQq.m(p.cSO().tOI);
      AppMethodBeat.o(114673);
      return;
      this.tQp.l(p.cSO().tOI);
    }
  }
  
  public final void cRH()
  {
    AppMethodBeat.i(114678);
    ad.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + p.cSO().tOG.size());
    if (p.cSO().cSk())
    {
      if (p.cSO().tOG.size() <= 0) {
        break label119;
      }
      p.cSO().cSv();
    }
    for (;;)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.tQq;
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(p.cSO().tOG);
      if (com.tencent.mm.plugin.multitalk.model.j.Hk(p.cSO().tOE)) {
        localj.e(localHashSet);
      }
      com.tencent.mm.plugin.multitalk.model.e.Hf(localHashSet.size());
      AppMethodBeat.o(114678);
      return;
      label119:
      p.cSO().cSw();
    }
  }
  
  public final boolean cRI()
  {
    AppMethodBeat.i(114689);
    if (this.tQq != null)
    {
      boolean bool = this.tQq.cRI();
      AppMethodBeat.o(114689);
      return bool;
    }
    AppMethodBeat.o(114689);
    return false;
  }
  
  public final void cST()
  {
    AppMethodBeat.i(114671);
    if (!this.tQw)
    {
      this.tQw = true;
      Intent localIntent = new Intent(this, MultiTalkAddMembersUI.class);
      ArrayList localArrayList = new ArrayList();
      if (p.cSO().tOI != null)
      {
        Iterator localIterator = p.cSO().tOI.Iok.iterator();
        while (localIterator.hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
          if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
            localArrayList.add(localMultiTalkGroupMember.Iol);
          }
        }
        localIntent.putExtra("titile", getString(2131761389));
        localIntent.putExtra("chatroomName", p.cSO().tOI.Ioi);
        localIntent.putExtra("always_select_contact", bt.n(localArrayList, ","));
        localIntent.putExtra("key_need_gallery", false);
        startActivityForResult(localIntent, 1);
      }
    }
    AppMethodBeat.o(114671);
  }
  
  public void finish()
  {
    AppMethodBeat.i(189962);
    super.finish();
    if (this.tQq != null) {
      this.tQq.ghf = false;
    }
    AppMethodBeat.o(189962);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494976;
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114681);
    if (p.cSO().cSk())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.tQq;
      Object localObject = localj.ahL(u.aqG());
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.multitalk.model.j.Hj(paramInt2))
        {
          if (com.tencent.mm.plugin.multitalk.model.j.Hj(paramInt1))
          {
            localj.tSP.setChecked(false);
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).tQS.cTc();
            localj.tSO.setVisibility(8);
            if ((localj.tTc.equals(u.aqG())) && (localj.tSJ.getVisibility() == 0))
            {
              localj.tTc = "";
              localj.tSI.setVisibility(0);
              localj.tSJ.setVisibility(8);
            }
          }
          localj.ahM(u.aqG());
          localj.nH(false);
        }
        for (;;)
        {
          localObject = new HashSet();
          ((HashSet)localObject).addAll(p.cSO().tOG);
          if (com.tencent.mm.plugin.multitalk.model.j.Hk(paramInt2)) {
            break;
          }
          if (!com.tencent.mm.plugin.multitalk.model.j.Hk(paramInt1)) {
            break label266;
          }
          localj.cSZ();
          AppMethodBeat.o(114681);
          return;
          if ((com.tencent.mm.plugin.multitalk.model.j.Hj(paramInt2)) && (!com.tencent.mm.plugin.multitalk.model.j.Hj(paramInt1)))
          {
            localj.tSP.setChecked(true);
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).tQS.cTd();
            ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).tQV.setVisibility(8);
            com.tencent.mm.sdk.platformtools.aq.n(new com.tencent.mm.plugin.multitalk.ui.widget.j.a(localj, (com.tencent.mm.plugin.multitalk.ui.widget.b)localObject), 1500L);
            localj.tSO.setVisibility(0);
          }
        }
        if ((com.tencent.mm.plugin.multitalk.model.j.Hk(paramInt2)) && (!com.tencent.mm.plugin.multitalk.model.j.Hk(paramInt1))) {
          localj.e((HashSet)localObject);
        }
      }
    }
    label266:
    AppMethodBeat.o(114681);
  }
  
  public final void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(114679);
    Object localObject;
    if (p.cSO().cSk())
    {
      localObject = this.tQq;
      ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).tSQ.setChecked(paramBoolean);
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).ahL(u.aqG());
      if ((localObject != null) && (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).tQW != null)) {
        if (!paramBoolean) {
          break label130;
        }
      }
    }
    label130:
    for (int i = 0;; i = 8)
    {
      ImageView localImageView = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).tQW;
      if (localImageView != null)
      {
        View localView = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).arI;
        k.g(localView, "itemView");
        localImageView.setBackground(am.i(localView.getContext(), 2131690327, -65536));
      }
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject).arI.findViewById(2131302584);
      k.g(localObject, "itemView.findViewById<Re…d.multitalk_mute_icon_bg)");
      ((RelativeLayout)localObject).setVisibility(i);
      AppMethodBeat.o(114679);
      return;
    }
  }
  
  public final void nt(boolean paramBoolean)
  {
    AppMethodBeat.i(114680);
    if (p.cSO().cSk())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.tQq;
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      localj.tSR.setChecked(paramBoolean);
      localj.cTa();
    }
    AppMethodBeat.o(114680);
  }
  
  public final void nu(boolean paramBoolean)
  {
    AppMethodBeat.i(114682);
    if (p.cSO().cSk())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.tQq;
      if (localj.tSR != null) {
        localj.tSR.setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(114682);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114672);
    ad.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.tQw = false;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ad.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(paramIntent)));
      ArrayList localArrayList = bt.S(paramIntent.split(","));
      if (localArrayList == null)
      {
        AppMethodBeat.o(114672);
        return;
      }
      com.tencent.mm.plugin.multitalk.model.f localf = p.cSO();
      if (localf.cRE())
      {
        String str = localf.tOI.Iog;
        paramIntent = str;
        if (bt.isNullOrNil(str)) {
          paramIntent = localf.tOI.Ioh;
        }
        p.cSN().tOr.K(paramIntent, localArrayList);
      }
    }
    AppMethodBeat.o(114672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114664);
    super.onCreate(paramBundle);
    p.cSO().cSt();
    com.tencent.mm.util.b.fgU();
    p.cSO().cSm();
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
      p.cSO().mm(false);
      if (p.cSO().cRE()) {
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
    p.cSJ();
    p.cSI();
    this.tQp = new com.tencent.mm.plugin.multitalk.ui.widget.g(this);
    this.tQq = new com.tencent.mm.plugin.multitalk.ui.widget.j(this);
    p.cSO().nD(p.cSO().tOC);
    p.cSO().tOU = this;
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.tQx, paramBundle);
    this.tQs = true;
    this.oFl = new ap();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
      ad.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.lf(26))
    {
      ad.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.tQu = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      aj.getContext().registerReceiver(this.tQu, paramBundle);
    }
    this.iXX = ((Notification)getIntent().getParcelableExtra("notification"));
    this.sKs = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
    this.sKs.Z(9, "VOIPFloatBall");
    AppMethodBeat.o(114664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114667);
    if (this.tQw) {
      p.cSO().nC(false);
    }
    if (this.tQs) {
      unregisterReceiver(this.tQx);
    }
    this.tQy.removeCallbacksAndMessages(null);
    this.tQy.sendEmptyMessage(1);
    ad.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.lf(26)) && (this.tQt))
      {
        aj.getContext().unbindService(this);
        this.tQt = false;
      }
      if (com.tencent.mm.compatible.util.d.lf(26))
      {
        ad.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.tQu == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        aj.getContext().unregisterReceiver(this.tQu);
        this.tQu = null;
        super.onDestroy();
        if (this.sKs != null) {
          this.sKs.onDestroy();
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
      com.tencent.mm.plugin.multitalk.ui.widget.j localj = this.tQq;
      ad.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localj.nH(false);
      p.cSO().Hi(1);
      localj.tSP.setChecked(false);
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
          p.cSO().g(false, false, false);
          AppMethodBeat.o(114654);
        }
      }, null);
      AppMethodBeat.o(114669);
      return true;
    }
    if (p.cSO().tOH == com.tencent.mm.plugin.multitalk.ui.widget.i.tSD)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        p.cSO().stopRing();
        this.tQr = false;
        AppMethodBeat.o(114669);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        paramKeyEvent = p.cSO();
        if (paramKeyEvent.tPb != null) {
          paramKeyEvent.tPb.vP(com.tencent.mm.plugin.multitalk.a.a.cHD());
        }
        AppMethodBeat.o(114669);
        return true;
      }
      if (paramInt == 24)
      {
        paramKeyEvent = p.cSO();
        if (paramKeyEvent.tPb != null) {
          paramKeyEvent.tPb.vO(com.tencent.mm.plugin.multitalk.a.a.cHD());
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
    KeyguardManager localKeyguardManager = (KeyguardManager)aj.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.tQo = bool1;
      ad.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.tQo) });
      if (p.cSO().cSk())
      {
        p.cSO().cSw();
        this.tQq.nH(true);
      }
      if ((!this.tQw) && (this.sKs != null))
      {
        this.sKs.aWa();
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
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
    if (this.sKs != null)
    {
      this.sKs.bzl();
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.backgroundrunning.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.backgroundrunning.h.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.h)localObject).aSI();
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.h)localObject).aSJ();
    }
    localObject = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.ball.c.c)localObject).k(new BallInfo(6, "MusicFloatBall"));
    }
    switch (2.tQA[p.cSO().tOH.ordinal()])
    {
    }
    for (;;)
    {
      if (p.cSO().cSk())
      {
        if (com.tencent.mm.plugin.multitalk.model.j.Hj(p.cSO().tOE)) {
          this.tQq.nG(true);
        }
        this.oFl.postDelayed(this.tQv, 2000L);
      }
      AppMethodBeat.o(114665);
      return;
      localObject = this.tQq;
      ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).tSL.setVisibility(8);
      ((com.tencent.mm.plugin.multitalk.ui.widget.j)localObject).tSN.setVisibility(8);
      this.tQp.l(p.cSO().tOI);
      if (ay.is4G(this)) {
        p.cSM().ap(this);
      }
      while (this.tQr)
      {
        p.cSO().nE(false);
        break;
        if ((ay.is2G(this)) || (ay.is3G(this))) {
          p.cSM().ao(this);
        }
      }
      this.tQp.cSX();
      this.tQq.m(p.cSO().tOI);
      if (ay.is4G(this)) {
        p.cSM().ap(this);
      }
      for (;;)
      {
        p.cSO().nE(true);
        break;
        if ((ay.is2G(this)) || (ay.is3G(this))) {
          p.cSM().ao(this);
        }
      }
      this.tQp.cSX();
      this.tQq.m(p.cSO().tOI);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(114668);
    if ((!this.tQw) && (this.tQo)) {
      p.cSO().nC(false);
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