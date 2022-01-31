package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.multitalk.model.a.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.4;
import com.tencent.mm.ui.base.TalkRoomPopupNav.5;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=af.class)
public class an
  extends a
  implements com.tencent.mm.bg.a, com.tencent.mm.bh.c, a.a, af
{
  private com.tencent.mm.sdk.b.c kSY;
  private final k.a zEy;
  public TalkRoomPopupNav zID;
  public MultiTalkRoomPopupNav zIE;
  private TalkRoomPopupNav.a zIF;
  
  public an()
  {
    AppMethodBeat.i(31760);
    this.zEy = new an.1(this);
    this.kSY = new com.tencent.mm.sdk.b.c() {};
    this.zIF = new an.9(this);
    AppMethodBeat.o(31760);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(31768);
    if (this.zID == null)
    {
      i.a(this.caz.zJz, 2131822445);
      this.zID = ((TalkRoomPopupNav)this.caz.findViewById(2131828489));
      if (this.zID == null)
      {
        AppMethodBeat.o(31768);
        return;
      }
    }
    if (this.zID != null) {
      this.zID.setOnClickListener(parama);
    }
    AppMethodBeat.o(31768);
  }
  
  private void aua(String paramString)
  {
    AppMethodBeat.i(31776);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(31776);
  }
  
  private void dJm()
  {
    AppMethodBeat.i(31769);
    if (this.zIE == null)
    {
      i.a(this.caz.zJz, 2131822446);
      this.zIE = ((MultiTalkRoomPopupNav)this.caz.findViewById(2131826443));
    }
    AppMethodBeat.o(31769);
  }
  
  private void dJn()
  {
    AppMethodBeat.i(31771);
    if (this.zID != null)
    {
      this.zID.setVisibility(8);
      this.zID.setIconAnim(-1);
      this.zID.stop();
      ((com.tencent.mm.ui.chatting.c.b.s)this.caz.ay(com.tencent.mm.ui.chatting.c.b.s.class)).PG(-1);
    }
    if (this.zIE != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Ui(this.caz.getTalkerUserName())) {
        this.zIE.dCZ();
      }
      this.zIE.setVisibility(8);
      ((com.tencent.mm.ui.chatting.c.b.s)this.caz.ay(com.tencent.mm.ui.chatting.c.b.s.class)).PG(-1);
    }
    AppMethodBeat.o(31771);
  }
  
  private void dJo()
  {
    AppMethodBeat.i(31773);
    cn("fromBanner", false);
    AppMethodBeat.o(31773);
  }
  
  private void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(31770);
    if (this.caz == null)
    {
      ab.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(31770);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.c.b.f)this.caz.ay(com.tencent.mm.ui.chatting.c.b.f.class)).dHO()) || (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHB())) {}
    for (boolean bool = true; (t.lA(this.caz.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.zID != null)
      {
        this.zID.setVisibility(8);
        ((com.tencent.mm.ui.chatting.c.b.s)this.caz.ay(com.tencent.mm.ui.chatting.c.b.s.class)).PG(-1);
      }
      if (this.zIE != null)
      {
        this.zIE.setInChatRoom(false);
        this.zIE.setVisibility(8);
      }
      AppMethodBeat.o(31770);
      return;
    }
    dJn();
    Object localObject;
    if ((com.tencent.mm.bh.d.fUO != null) && (com.tencent.mm.bh.d.fUO.uO(this.caz.txj.field_username)))
    {
      a(this.zIF);
      if (this.zID == null)
      {
        AppMethodBeat.o(31770);
        return;
      }
      LinkedList localLinkedList = com.tencent.mm.bh.d.fUO.uN(this.caz.txj.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.caz.dJD())))
      {
        this.zID.setBgViewResource(2130840584);
        localObject = this.caz.zJz.getMMResources().getString(2131304385);
        this.zID.setIconRes(2131232092);
        this.zID.setIconAnim(2131232094);
        this.zID.start();
        this.zID.setVisibility(0);
        this.zID.setNavContent((String)localObject);
        ((com.tencent.mm.ui.chatting.c.b.s)this.caz.ay(com.tencent.mm.ui.chatting.c.b.s.class)).PG(1);
        AppMethodBeat.o(31770);
        return;
      }
      this.zID.setIconAnim(-1);
      this.zID.stop();
      this.zID.setBgViewResource(2130840585);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.caz.zJz.getMMResources().getString(2131304384, new Object[] { com.tencent.mm.model.s.nE((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.zID.setIconRes(2131232091);
        break;
        if (localLinkedList != null) {
          localObject = this.caz.zJz.getMMResources().getString(2131304386, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((com.tencent.mm.bg.g.fUM != null) && (com.tencent.mm.bg.g.fUM.uL(this.caz.getTalkerUserName())))
    {
      a(this.zIF);
      localObject = new tl();
      ((tl)localObject).cJT.cJV = true;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.caz.getTalkerUserName().equals(((tl)localObject).cJU.cJX)) {
        this.zID.setBgViewResource(2130840584);
      }
      for (;;)
      {
        localObject = this.caz.zJz.getMMResources().getString(2131304247, new Object[] { Integer.valueOf(com.tencent.mm.bg.g.fUM.uK(this.caz.getTalkerUserName()).size()) });
        this.zID.setIconRes(2130840531);
        this.zID.setIconAnim(-1);
        this.zID.stop();
        this.zID.setVisibility(0);
        this.zID.setNavContent((String)localObject);
        ((com.tencent.mm.ui.chatting.c.b.s)this.caz.ay(com.tencent.mm.ui.chatting.c.b.s.class)).PG(1);
        AppMethodBeat.o(31770);
        return;
        this.zID.setBgViewResource(2130840585);
      }
    }
    if (t.lA(this.caz.getTalkerUserName()))
    {
      localObject = ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Uj(this.caz.getTalkerUserName());
      if ((localObject != null) && (((com.tencent.mm.bg.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bg.f)localObject).field_wxGroupId.equals(this.caz.getTalkerUserName())))
      {
        dJm();
        if (this.zIE != null)
        {
          ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
          this.zIE.setGroupUserName(this.caz.getTalkerUserName());
          this.zIE.setCurrentSenderUserName(this.caz.dJD());
          this.zIE.setInChatRoom(bool);
          this.zIE.qw(paramBoolean);
          this.zIE.setMultiTalkInfo((com.tencent.mm.bg.f)localObject);
          ((com.tencent.mm.ui.chatting.c.b.s)this.caz.ay(com.tencent.mm.ui.chatting.c.b.s.class)).PG(1);
        }
      }
      AppMethodBeat.o(31770);
      return;
    }
    dJn();
    AppMethodBeat.o(31770);
  }
  
  public final void Us(String paramString)
  {
    AppMethodBeat.i(31767);
    if ((this.caz != null) && (paramString.equals(this.caz.getTalkerUserName()))) {
      qW(false);
    }
    AppMethodBeat.o(31767);
  }
  
  public final void atZ(String paramString)
  {
    AppMethodBeat.i(31775);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.caz.dJD());
    localIntent.putExtra("map_talker_name", this.caz.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(31775);
  }
  
  public final void aw(Runnable paramRunnable)
  {
    AppMethodBeat.i(31764);
    if ((com.tencent.mm.bh.d.fUO != null) && (com.tencent.mm.bh.d.fUO.aY(this.caz.txj.field_username, this.caz.dJD())))
    {
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131304381), this.caz.zJz.getMMResources().getString(2131297087), true, new an.7(this, paramRunnable), new an.8(this));
      AppMethodBeat.o(31764);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(31764);
  }
  
  public final void cn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31774);
    if ((com.tencent.mm.r.a.bO(this.caz.zJz.getContext())) || (com.tencent.mm.r.a.bM(this.caz.zJz.getContext())))
    {
      ab.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(31774);
      return;
    }
    if (((com.tencent.mm.bh.d.fUO != null) && (com.tencent.mm.bh.d.fUO.uO(this.caz.txj.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bh.d.fUO.uN(this.caz.txj.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.caz.dJD())))
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131299300), null, new an.4(this, paramString), new an.5(this));
        AppMethodBeat.o(31774);
        return;
      }
    }
    atZ(paramString);
    AppMethodBeat.o(31774);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31778);
    ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.a(this);
    }
    if (com.tencent.mm.bh.d.fUO != null) {
      com.tencent.mm.bh.d.fUO.a(this);
    }
    if (com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).a(this);
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.kSY);
    qW(true);
    AppMethodBeat.o(31778);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31779);
    ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.b(this);
    }
    if (com.tencent.mm.bh.d.fUO != null) {
      com.tencent.mm.bh.d.fUO.b(this);
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.kSY);
    ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).b(this);
    AppMethodBeat.o(31779);
  }
  
  public final void dCd() {}
  
  public final void dHq()
  {
    AppMethodBeat.i(31777);
    super.dHq();
    if (this.zID != null) {
      this.zID.stop();
    }
    AppMethodBeat.o(31777);
  }
  
  public final boolean dJj()
  {
    AppMethodBeat.i(31761);
    if (this.zID == null)
    {
      AppMethodBeat.o(31761);
      return false;
    }
    if (this.zID.getVisibility() == 0)
    {
      AppMethodBeat.o(31761);
      return true;
    }
    AppMethodBeat.o(31761);
    return false;
  }
  
  public final boolean dJk()
  {
    AppMethodBeat.i(31762);
    if (this.zIE == null)
    {
      AppMethodBeat.o(31762);
      return false;
    }
    if (this.zIE.getVisibility() == 0)
    {
      AppMethodBeat.o(31762);
      return true;
    }
    AppMethodBeat.o(31762);
    return false;
  }
  
  public final int dJl()
  {
    AppMethodBeat.i(31763);
    if (this.zID == null)
    {
      AppMethodBeat.o(31763);
      return 0;
    }
    int i = this.zID.getHeight();
    AppMethodBeat.o(31763);
    return i;
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(31765);
    if ((this.caz != null) && (paramString1.equals(this.caz.getTalkerUserName()))) {
      qW(false);
    }
    AppMethodBeat.o(31765);
  }
  
  public final void qX(final boolean paramBoolean)
  {
    AppMethodBeat.i(31772);
    if ((((com.tencent.mm.ui.chatting.c.b.f)this.caz.ay(com.tencent.mm.ui.chatting.c.b.f.class)).dHO()) || (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHB())) {}
    for (int i = 1; (t.lA(this.caz.getTalkerUserName())) && (i == 0); i = 0)
    {
      com.tencent.mm.ui.base.h.b(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131304238), null, true);
      AppMethodBeat.o(31772);
      return;
    }
    Object localObject1 = new tl();
    ((tl)localObject1).cJT.cJV = true;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bh.d.fUO != null) && (com.tencent.mm.bh.d.fUO.uO(this.caz.txj.field_username)))
      {
        localObject1 = com.tencent.mm.bh.d.fUO.uN(this.caz.txj.field_username);
        if ((localObject1 != null) && (((List)localObject1).contains(this.caz.dJD()))) {
          localObject1 = this.caz.zJz.getMMResources().getString(2131304233);
        }
        for (i = 2131299297;; i = 2131300974)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          localObject2 = new c.a(this.caz.zJz.getContext());
          ((c.a)localObject2).avn((String)localObject1);
          ((c.a)localObject2).Ri(2131296888).a(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(31756);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(31756);
            }
          });
          ((c.a)localObject2).Rj(i).b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(31757);
              an localan = an.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localan.atZ(paramAnonymousDialogInterface);
                AppMethodBeat.o(31757);
                return;
              }
            }
          });
          ((c.a)localObject2).aLZ().show();
          AppMethodBeat.o(31772);
          return;
          localObject1 = this.caz.zJz.getMMResources().getString(2131304234);
        }
      }
      if ((!bo.isNullOrNil(((tl)localObject1).cJU.cJX)) && (!this.caz.getTalkerUserName().equals(((tl)localObject1).cJU.cJX)))
      {
        com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131304228), null, new an.12(this), new an.13(this));
        AppMethodBeat.o(31772);
        return;
      }
      aua(this.caz.getTalkerUserName());
      AppMethodBeat.o(31772);
      return;
    }
    if ((bo.isNullOrNil(((tl)localObject1).cJU.cJX)) || (this.caz.getTalkerUserName().equals(((tl)localObject1).cJU.cJX)))
    {
      aua(this.caz.getTalkerUserName());
      AppMethodBeat.o(31772);
      return;
    }
    if ((this.zID == null) || (this.zID.getVisibility() != 0))
    {
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131304228), null, new an.2(this), new an.3(this));
      AppMethodBeat.o(31772);
      return;
    }
    this.zID.setDialogContent(this.caz.zJz.getMMResources().getString(2131304228));
    localObject1 = this.zID;
    if (((TalkRoomPopupNav)localObject1).zpL == null)
    {
      ((TalkRoomPopupNav)localObject1).zpL = new ScaleAnimation(1.0F, 1.0F, ((TalkRoomPopupNav)localObject1).zpN * 1.0F / ((TalkRoomPopupNav)localObject1).zpO, 1.0F);
      ((TalkRoomPopupNav)localObject1).zpL.setDuration(300L);
      ((TalkRoomPopupNav)localObject1).zpL.setAnimationListener(new TalkRoomPopupNav.4((TalkRoomPopupNav)localObject1));
    }
    if (((TalkRoomPopupNav)localObject1).zpM == null)
    {
      ((TalkRoomPopupNav)localObject1).zpM = AnimationUtils.loadAnimation(((TalkRoomPopupNav)localObject1).getContext(), 2131034182);
      ((TalkRoomPopupNav)localObject1).zpM.setFillAfter(true);
      ((TalkRoomPopupNav)localObject1).zpM.setAnimationListener(new TalkRoomPopupNav.5((TalkRoomPopupNav)localObject1));
    }
    Object localObject2 = ((TalkRoomPopupNav)localObject1).mwU.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = ((TalkRoomPopupNav)localObject1).zpO;
    ((TalkRoomPopupNav)localObject1).mwU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TalkRoomPopupNav)localObject1).mwU.startAnimation(((TalkRoomPopupNav)localObject1).zpL);
    ((TalkRoomPopupNav)localObject1).zdB.startAnimation(((TalkRoomPopupNav)localObject1).zpM);
    ((TalkRoomPopupNav)localObject1).zpH.startAnimation(AnimationUtils.loadAnimation(((TalkRoomPopupNav)localObject1).getContext(), 2131034181));
    ((TalkRoomPopupNav)localObject1).zpH.setVisibility(0);
    AppMethodBeat.o(31772);
  }
  
  public final void uP(String paramString)
  {
    AppMethodBeat.i(31766);
    if ((this.caz != null) && (paramString.equals(this.caz.getTalkerUserName()))) {
      qW(false);
    }
    AppMethodBeat.o(31766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an
 * JD-Core Version:    0.7.0.1
 */