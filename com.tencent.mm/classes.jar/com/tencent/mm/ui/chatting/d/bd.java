package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.LiveTalkRoomTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.a;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.t;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=as.class)
public class bd
  extends a
  implements com.tencent.mm.bh.a, com.tencent.mm.bi.c, com.tencent.mm.plugin.multitalk.model.d.a, as, q.a
{
  public LiveTalkRoomTipsBar OFq;
  private final MStorage.IOnStorageChange Pnh;
  public TalkRoomPopupNav PuB;
  public MultiTalkRoomPopupNav PuC;
  private View PuD;
  private TalkRoomPopupNav.a PuE;
  private IListener qCu;
  
  public bd()
  {
    AppMethodBeat.i(35663);
    this.Pnh = new bd.1(this);
    this.qCu = new bd.4(this);
    this.PuE = new TalkRoomPopupNav.a()
    {
      public final void bme(String paramAnonymousString)
      {
        AppMethodBeat.i(233189);
        if (com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null)))
        {
          if ((com.tencent.mm.pluginsdk.permission.b.n(bd.this.dom.Pwc.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(bd.this.dom.Pwc.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label258;
            }
            if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue()) {
              break;
            }
            com.tencent.mm.plugin.account.a.b.a.b(bd.this.dom.Pwc.getContext(), bd.this.dom.Pwc.getMMResources().getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30762, true);
            AppMethodBeat.o(233189);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.a(bd.this.dom.Pwc.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68);
          AppMethodBeat.o(233189);
          return;
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(bd.this.dom.Pwc.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68, null, null);
        Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(233189);
          return;
        }
        label258:
        bd.this.bmP(paramAnonymousString);
        AppMethodBeat.o(233189);
      }
      
      public final void gLw()
      {
        AppMethodBeat.i(35657);
        if ((com.tencent.mm.q.a.cC(bd.this.dom.Pwc.getContext())) || (com.tencent.mm.q.a.cA(bd.this.dom.Pwc.getContext())) || (com.tencent.mm.q.a.cE(bd.this.dom.Pwc.getContext())))
        {
          Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
          AppMethodBeat.o(35657);
          return;
        }
        Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(com.tencent.mm.bi.d.jpA.PY(bd.this.dom.GUe.field_username).size()) });
        if (com.tencent.mm.bi.d.jpA.PZ(bd.this.dom.GUe.field_username))
        {
          bd.b(bd.this);
          AppMethodBeat.o(35657);
          return;
        }
        bd.this.BU(true);
        AppMethodBeat.o(35657);
      }
    };
    AppMethodBeat.o(35663);
  }
  
  private void BT(boolean paramBoolean)
  {
    AppMethodBeat.i(35673);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s, stacks: %s", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack().toString() });
    if (this.dom == null)
    {
      Log.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(35673);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.dom.bh(com.tencent.mm.ui.chatting.d.b.f.class)).gPi()) || (((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOV())) {}
    for (boolean bool = true; (com.tencent.mm.model.ab.Eq(this.dom.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.PuB != null)
      {
        this.PuB.setVisibility(8);
        this.PuB.gLv();
        ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
      }
      if (this.PuC != null)
      {
        this.PuC.setInChatRoom(false);
        this.PuC.setVisibility(8);
      }
      if (this.OFq != null)
      {
        this.OFq.setInChatRoom(false);
        this.OFq.setVisibility(8);
        if (this.PuD != null) {
          this.PuD.setVisibility(8);
        }
        this.dom.Pwc.getController().showActionbarLine();
        ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().GZ(this.dom.getTalkerUserName());
        ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
      }
      AppMethodBeat.o(35673);
      return;
    }
    gRn();
    if (((ai)this.dom.bh(ai.class)).gQN())
    {
      Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "isRecordSelect");
      AppMethodBeat.o(35673);
      return;
    }
    gRo();
    LinkedList localLinkedList;
    Object localObject;
    if ((com.tencent.mm.bi.d.jpA != null) && (com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username)))
    {
      a(this.PuE);
      if (this.PuB == null)
      {
        AppMethodBeat.o(35673);
        return;
      }
      localLinkedList = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.dom.gRI())))
      {
        this.PuB.setBgViewResource(2131235312);
        localObject = this.dom.Pwc.getMMResources().getString(2131766871);
        this.PuB.updateView();
        this.PuB.jc(localLinkedList);
        this.PuB.setVisibility(0);
        this.PuB.setNavContent((String)localObject);
        ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(1);
        AppMethodBeat.o(35673);
        return;
      }
      this.PuB.gLu();
      this.PuB.stop();
      this.PuB.setBgViewResource(2131235312);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.dom.Pwc.getMMResources().getString(2131766870, new Object[] { aa.getDisplayName((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.PuB.setIconRes$255f295(this.dom.Pwc.getMMResources().getColor(2131099710));
        break;
        if (localLinkedList != null) {
          localObject = this.dom.Pwc.getMMResources().getString(2131766872, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((com.tencent.mm.bh.g.jpy == null) || (!com.tencent.mm.bh.g.jpy.PW(this.dom.getTalkerUserName())))
    {
      if (com.tencent.mm.model.ab.Eq(this.dom.getTalkerUserName()))
      {
        localObject = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFI(this.dom.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.bh.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bh.f)localObject).field_wxGroupId.equals(this.dom.getTalkerUserName())))
        {
          gRl();
          if (this.PuC != null)
          {
            Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
            this.PuC.setGroupUserName(this.dom.getTalkerUserName());
            this.PuC.setCurrentSenderUserName(this.dom.gRI());
            this.PuC.setInChatRoom(bool);
            this.PuC.Bp(paramBoolean);
            this.PuC.setMultiTalkInfo((com.tencent.mm.bh.f)localObject);
            ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(1);
            AppMethodBeat.o(35673);
          }
        }
        else
        {
          localObject = this.dom.getTalkerUserName();
          localLinkedList = q.blP((String)localObject);
          gRm();
          if ((localLinkedList != null) && (localLinkedList.size() > 0) && (this.OFq != null))
          {
            Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", new Object[] { localObject, Integer.valueOf(localLinkedList.size()) });
            this.dom.Pwc.getController().hideActionbarLine();
            this.OFq.setInChatRoom(bool);
            this.OFq.setChattingContext(this.dom);
            this.OFq.gIE();
            ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(1);
          }
        }
        AppMethodBeat.o(35673);
        return;
      }
      gRn();
    }
    AppMethodBeat.o(35673);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(35671);
    if (this.PuB == null)
    {
      l.a(this.dom.Pwc, 2131309888);
      this.PuB = ((TalkRoomPopupNav)this.dom.findViewById(2131308895));
      this.PuD = this.dom.findViewById(2131309190);
      this.PuB.setRootTipsBarBackground(this.PuD);
      this.PuB.setChattingContext(this.dom);
      if (this.PuB == null)
      {
        AppMethodBeat.o(35671);
        return;
      }
    }
    if (this.PuB != null) {
      this.PuB.setOnClickListener(parama);
    }
    AppMethodBeat.o(35671);
  }
  
  private void bmQ(String paramString)
  {
    AppMethodBeat.i(35679);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(35679);
  }
  
  private void gRl()
  {
    AppMethodBeat.i(35672);
    if (this.PuC == null)
    {
      this.PuD = this.dom.findViewById(2131309190);
      l.a(this.dom.Pwc, 2131309883);
      this.PuC = ((MultiTalkRoomPopupNav)this.dom.findViewById(2131305062));
      this.PuC.setRootTipsBarBackground(this.PuD);
      this.PuC.setChattingContext(this.dom);
    }
    AppMethodBeat.o(35672);
  }
  
  private void gRm()
  {
    AppMethodBeat.i(233192);
    if (this.OFq == null)
    {
      this.PuD = this.dom.findViewById(2131309190);
      l.a(this.dom.Pwc, 2131309881);
      this.OFq = ((LiveTalkRoomTipsBar)this.dom.findViewById(2131303574));
      LiveTalkRoomTipsBar localLiveTalkRoomTipsBar = this.OFq;
      if (localLiveTalkRoomTipsBar.OFb == null) {
        localLiveTalkRoomTipsBar.OFb = new q(localLiveTalkRoomTipsBar);
      }
      localLiveTalkRoomTipsBar.gID();
      if (localLiveTalkRoomTipsBar.OFj != null) {
        localLiveTalkRoomTipsBar.OFj.setAdapter(localLiveTalkRoomTipsBar.OFb.OFs);
      }
      this.OFq.setRootTipsBarBackground(this.PuD);
      this.OFq.setChattingUserName(this.dom.getTalkerUserName());
      AppMethodBeat.o(233192);
      return;
    }
    this.OFq.gID();
    AppMethodBeat.o(233192);
  }
  
  private void gRn()
  {
    AppMethodBeat.i(35674);
    if (this.PuB != null)
    {
      this.PuB.setVisibility(8);
      this.PuB.gLv();
      this.PuB.gLu();
      this.PuB.stop();
      ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
    }
    if (this.PuC != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(this.dom.getTalkerUserName())) {
        this.PuC.gJt();
      }
      this.PuC.setVisibility(8);
      ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
    }
    if (this.OFq != null)
    {
      this.OFq.setVisibility(8);
      if (this.PuD != null) {
        this.PuD.setVisibility(8);
      }
      this.dom.Pwc.getController().showActionbarLine();
      if ((this.PuB == null) && (this.PuC == null)) {
        ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
      }
    }
    AppMethodBeat.o(35674);
  }
  
  private void gRo()
  {
    AppMethodBeat.i(233193);
    if (this.OFq != null) {
      this.OFq.setChattingUserName(this.dom.getTalkerUserName());
    }
    AppMethodBeat.o(233193);
  }
  
  private void gRp()
  {
    AppMethodBeat.i(35676);
    dq("fromBanner", false);
    AppMethodBeat.o(35676);
  }
  
  public final void BU(final boolean paramBoolean)
  {
    AppMethodBeat.i(35675);
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.dom.bh(com.tencent.mm.ui.chatting.d.b.f.class)).gPi()) || (((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOV())) {}
    for (int i = 1; (com.tencent.mm.model.ab.Eq(this.dom.getTalkerUserName())) && (i == 0); i = 0)
    {
      com.tencent.mm.ui.base.h.c(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131766617), null, true);
      AppMethodBeat.o(35675);
      return;
    }
    Object localObject = new xq();
    ((xq)localObject).edR.edT = true;
    EventCenter.instance.publish((IEvent)localObject);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bi.d.jpA != null) && (com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username)))
      {
        localObject = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username);
        if ((localObject != null) && (((List)localObject).contains(this.dom.gRI()))) {
          localObject = this.dom.Pwc.getMMResources().getString(2131766612);
        }
        for (i = 2131758721;; i = 2131762021)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this.dom.Pwc.getContext());
          locala.boo((String)localObject);
          locala.aoV(2131755761).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35659);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35659);
            }
          });
          locala.aoW(i).d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35660);
              bd localbd = bd.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localbd.bmP(paramAnonymousDialogInterface);
                AppMethodBeat.o(35660);
                return;
              }
            }
          });
          locala.hbn().show();
          AppMethodBeat.o(35675);
          return;
          localObject = this.dom.Pwc.getMMResources().getString(2131766613);
        }
      }
      if ((!Util.isNullOrNil(((xq)localObject).edS.edV)) && (!this.dom.getTalkerUserName().equals(((xq)localObject).edS.edV)))
      {
        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131766607), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35661);
            paramAnonymousDialogInterface = new xq();
            paramAnonymousDialogInterface.edR.edU = true;
            EventCenter.instance.publish(paramAnonymousDialogInterface);
            bd.a(bd.this, bd.this.dom.getTalkerUserName());
            AppMethodBeat.o(35661);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35662);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(35662);
          }
        });
        AppMethodBeat.o(35675);
        return;
      }
      bmQ(this.dom.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((Util.isNullOrNil(((xq)localObject).edS.edV)) || (this.dom.getTalkerUserName().equals(((xq)localObject).edS.edV)))
    {
      bmQ(this.dom.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((this.PuB == null) || (this.PuB.getVisibility() != 0)) {
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131766607), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35651);
          paramAnonymousDialogInterface = new xq();
          paramAnonymousDialogInterface.edR.edU = true;
          EventCenter.instance.publish(paramAnonymousDialogInterface);
          bd.a(bd.this, bd.this.dom.getTalkerUserName());
          AppMethodBeat.o(35651);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35652);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(35652);
        }
      });
    }
    AppMethodBeat.o(35675);
  }
  
  public final void Qa(String paramString)
  {
    AppMethodBeat.i(35669);
    if ((this.dom != null) && (paramString.equals(this.dom.getTalkerUserName()))) {
      BT(false);
    }
    AppMethodBeat.o(35669);
  }
  
  public final void aFR(String paramString)
  {
    AppMethodBeat.i(35670);
    if ((this.dom != null) && (paramString.equals(this.dom.getTalkerUserName()))) {
      BT(false);
    }
    AppMethodBeat.o(35670);
  }
  
  public final void aL(Runnable paramRunnable)
  {
    AppMethodBeat.i(35667);
    if ((com.tencent.mm.bi.d.jpA != null) && (com.tencent.mm.bi.d.jpA.bB(this.dom.GUe.field_username, this.dom.gRI())))
    {
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131766867), this.dom.Pwc.getMMResources().getString(2131755998), true, new bd.5(this, paramRunnable), new bd.6(this));
      AppMethodBeat.o(35667);
      return;
    }
    Object localObject;
    if (this.PuB != null)
    {
      localObject = this.PuB;
      if (((TalkRoomPopupNav)localObject).OWw.getVisibility() == 0)
      {
        ((TalkRoomPopupNav)localObject).Bo(false);
        ((TalkRoomPopupNav)localObject).OWw.setVisibility(8);
      }
    }
    if (this.PuC != null)
    {
      localObject = this.PuC;
      if ((((MultiTalkRoomPopupNav)localObject).OJp != null) && (((MultiTalkRoomPopupNav)localObject).OJp.OJy != null) && (((MultiTalkRoomPopupNav)localObject).OJp.OJy.getVisibility() == 0))
      {
        ((MultiTalkRoomPopupNav)localObject).OJp.close();
        ((MultiTalkRoomPopupNav)localObject).OJp.OJy.setVisibility(8);
      }
    }
    if (this.OFq != null)
    {
      localObject = this.OFq;
      if (((LiveTalkRoomTipsBar)localObject).OFd.getVisibility() == 0)
      {
        ((LiveTalkRoomTipsBar)localObject).bc(true, false);
        ((LiveTalkRoomTipsBar)localObject).OFd.setVisibility(8);
      }
    }
    paramRunnable.run();
    AppMethodBeat.o(35667);
  }
  
  public final void blQ(String paramString)
  {
    AppMethodBeat.i(233191);
    if ((this.dom != null) && (paramString.equals(this.dom.getTalkerUserName()))) {
      BT(false);
    }
    AppMethodBeat.o(233191);
  }
  
  public final void bmP(String paramString)
  {
    AppMethodBeat.i(35678);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.dom.gRI());
    localIntent.putExtra("map_talker_name", this.dom.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35678);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35681);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.a(this);
    }
    if (com.tencent.mm.bi.d.jpA != null) {
      com.tencent.mm.bi.d.jpA.a(this);
    }
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).a(this);
    }
    q.a(this);
    EventCenter.instance.addListener(this.qCu);
    BT(true);
    AppMethodBeat.o(35681);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35682);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.b(this);
    }
    if (com.tencent.mm.bi.d.jpA != null) {
      com.tencent.mm.bi.d.jpA.b(this);
    }
    q.b(this);
    EventCenter.instance.removeListener(this.qCu);
    ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).b(this);
    AppMethodBeat.o(35682);
  }
  
  public final void dq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35677);
    if ((com.tencent.mm.q.a.cC(this.dom.Pwc.getContext())) || (com.tencent.mm.q.a.cA(this.dom.Pwc.getContext())) || (com.tencent.mm.q.a.cE(this.dom.Pwc.getContext())))
    {
      Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(35677);
      return;
    }
    if (((com.tencent.mm.bi.d.jpA != null) && (com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.dom.gRI())))
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.PuB.setDialogContent(this.dom.Pwc.getMMResources().getString(2131758724));
        this.PuB.N(paramString, localLinkedList);
        AppMethodBeat.o(35677);
        return;
      }
    }
    bmP(paramString);
    AppMethodBeat.o(35677);
  }
  
  public final void gIn() {}
  
  public final void gIo()
  {
    AppMethodBeat.i(233194);
    if (this.OFq != null)
    {
      this.OFq.bc(true, false);
      if (this.OFq.OFb != null) {
        q.gIG();
      }
    }
    gRn();
    AppMethodBeat.o(233194);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35680);
    super.gOK();
    if (this.PuB != null) {
      this.PuB.stop();
    }
    AppMethodBeat.o(35680);
  }
  
  public final boolean gRh()
  {
    AppMethodBeat.i(35664);
    if (this.PuB == null)
    {
      AppMethodBeat.o(35664);
      return false;
    }
    if (this.PuB.getVisibility() == 0)
    {
      AppMethodBeat.o(35664);
      return true;
    }
    AppMethodBeat.o(35664);
    return false;
  }
  
  public final boolean gRi()
  {
    AppMethodBeat.i(35665);
    if (this.PuC == null)
    {
      AppMethodBeat.o(35665);
      return false;
    }
    if (this.PuC.getVisibility() == 0)
    {
      AppMethodBeat.o(35665);
      return true;
    }
    AppMethodBeat.o(35665);
    return false;
  }
  
  public final boolean gRj()
  {
    AppMethodBeat.i(233190);
    if (this.OFq == null)
    {
      AppMethodBeat.o(233190);
      return false;
    }
    if (this.OFq.getVisibility() == 0)
    {
      AppMethodBeat.o(233190);
      return true;
    }
    AppMethodBeat.o(233190);
    return false;
  }
  
  public final int gRk()
  {
    AppMethodBeat.i(35666);
    if (this.PuB == null)
    {
      AppMethodBeat.o(35666);
      return 0;
    }
    int i = this.PuB.getHeight();
    AppMethodBeat.o(35666);
    return i;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35668);
    if ((this.dom != null) && (paramString1.equals(this.dom.getTalkerUserName()))) {
      BT(false);
    }
    AppMethodBeat.o(35668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bd
 * JD-Core Version:    0.7.0.1
 */