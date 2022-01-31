package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bf.f;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.multitalk.a.a.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.a;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.b;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.4;
import com.tencent.mm.ui.base.TalkRoomPopupNav.5;
import com.tencent.mm.ui.base.TalkRoomPopupNav.8;
import com.tencent.mm.ui.base.TalkRoomPopupNav.9;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.x;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.ae.class)
public class al
  extends a
  implements com.tencent.mm.bf.a, com.tencent.mm.bg.c, a.a, com.tencent.mm.ui.chatting.b.b.ae
{
  private final j.a voW = new al.1(this);
  public TalkRoomPopupNav vsP;
  public MultiTalkRoomPopupNav vsQ;
  private TalkRoomPopupNav.a vsR = new al.7(this);
  
  private void a(TalkRoomPopupNav.a parama)
  {
    if (this.vsP == null)
    {
      i.a(this.byx.vtz, R.h.viewstub_talkroom_popup_nav);
      this.vsP = ((TalkRoomPopupNav)this.byx.findViewById(R.h.talk_room_popup_nav));
      if (this.vsP != null) {}
    }
    while (this.vsP == null) {
      return;
    }
    this.vsP.setOnClickListener(parama);
  }
  
  private void ady(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.br.d.b(this.byx.vtz.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
  }
  
  private void cFq()
  {
    if (this.vsP != null)
    {
      this.vsP.setVisibility(8);
      this.vsP.setIconAnim(-1);
      this.vsP.stop();
      ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).Hc(-1);
    }
    if (this.vsQ != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).It(this.byx.getTalkerUserName())) {
        this.vsQ.czY();
      }
      this.vsQ.setVisibility(8);
      ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).Hc(-1);
    }
  }
  
  private void nm(boolean paramBoolean)
  {
    if (this.byx == null) {
      y.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
    }
    boolean bool;
    label149:
    Object localObject1;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return;
          if ((((com.tencent.mm.ui.chatting.b.b.e)this.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).cDY()) || (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDM())) {}
          for (bool = true;; bool = false)
          {
            if ((!s.fn(this.byx.getTalkerUserName())) || (bool)) {
              break label149;
            }
            if (this.vsP != null)
            {
              this.vsP.setVisibility(8);
              ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).Hc(-1);
            }
            if (this.vsQ == null) {
              break;
            }
            this.vsQ.setInChatRoom(false);
            this.vsQ.setVisibility(8);
            return;
          }
          cFq();
          if ((com.tencent.mm.bg.d.eEX == null) || (!com.tencent.mm.bg.d.eEX.nA(this.byx.pSb.field_username))) {
            break;
          }
          a(this.vsR);
        } while (this.vsP == null);
        localObject2 = com.tencent.mm.bg.d.eEX.nz(this.byx.pSb.field_username);
        localObject1 = "";
        if ((localObject2 != null) && (((List)localObject2).contains(this.byx.cFB())))
        {
          this.vsP.setBgViewResource(R.g.tipsbar_green_bg);
          localObject2 = this.byx.vtz.getMMResources().getString(R.l.track_room_sharing);
          this.vsP.setIconRes(R.k.tipsbar_icon_location_lightgreen);
          this.vsP.setIconAnim(R.k.tipsbar_icon_location_shining);
          localObject3 = this.vsP;
          if (((TalkRoomPopupNav)localObject3).vbB != null)
          {
            localObject1 = localObject2;
            if (((TalkRoomPopupNav)localObject3).vbC != null) {}
          }
          else
          {
            ((TalkRoomPopupNav)localObject3).vbB = new AlphaAnimation(0.0F, 1.0F);
            ((TalkRoomPopupNav)localObject3).vbB.setDuration(1000L);
            ((TalkRoomPopupNav)localObject3).vbB.setStartOffset(0L);
            ((TalkRoomPopupNav)localObject3).vbC = new AlphaAnimation(1.0F, 0.0F);
            ((TalkRoomPopupNav)localObject3).vbC.setDuration(1000L);
            ((TalkRoomPopupNav)localObject3).vbC.setStartOffset(0L);
            ((TalkRoomPopupNav)localObject3).vbB.setAnimationListener(new TalkRoomPopupNav.8((TalkRoomPopupNav)localObject3));
            ((TalkRoomPopupNav)localObject3).vbC.setAnimationListener(new TalkRoomPopupNav.9((TalkRoomPopupNav)localObject3));
            ((TalkRoomPopupNav)localObject3).vbu.startAnimation(((TalkRoomPopupNav)localObject3).vbB);
            localObject1 = localObject2;
          }
          this.vsP.setVisibility(0);
          this.vsP.setNavContent((String)localObject1);
          ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).Hc(1);
          return;
        }
        this.vsP.setIconAnim(-1);
        this.vsP.stop();
        this.vsP.setBgViewResource(R.g.tipsbar_grey_bg);
        if ((localObject2 != null) && (((List)localObject2).size() == 1)) {
          localObject1 = this.byx.vtz.getMMResources().getString(R.l.track_room_one_sharing, new Object[] { com.tencent.mm.model.r.gV((String)((List)localObject2).get(0)) });
        }
        for (;;)
        {
          this.vsP.setIconRes(R.k.tipsbar_icon_location);
          break;
          if (localObject2 != null) {
            localObject1 = this.byx.vtz.getMMResources().getString(R.l.track_room_some_people_in, new Object[] { Integer.valueOf(((List)localObject2).size()) });
          }
        }
        if ((com.tencent.mm.bf.g.eEV != null) && (com.tencent.mm.bf.g.eEV.nx(this.byx.getTalkerUserName())))
        {
          a(this.vsR);
          localObject1 = new ru();
          ((ru)localObject1).cbq.cbs = true;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          if (this.byx.getTalkerUserName().equals(((ru)localObject1).cbr.cbu)) {
            this.vsP.setBgViewResource(R.g.tipsbar_green_bg);
          }
          for (;;)
          {
            localObject1 = this.byx.vtz.getMMResources().getString(R.l.talk_room_some_people_in, new Object[] { Integer.valueOf(com.tencent.mm.bf.g.eEV.nw(this.byx.getTalkerUserName()).size()) });
            this.vsP.setIconRes(R.g.talk_room_mic_in_chat);
            this.vsP.setIconAnim(-1);
            this.vsP.stop();
            this.vsP.setVisibility(0);
            this.vsP.setNavContent((String)localObject1);
            ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).Hc(1);
            return;
            this.vsP.setBgViewResource(R.g.tipsbar_grey_bg);
          }
        }
        if (!s.fn(this.byx.getTalkerUserName())) {
          break;
        }
        localObject1 = ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Iu(this.byx.getTalkerUserName());
      } while ((localObject1 == null) || (((f)localObject1).field_wxGroupId == null) || (!((f)localObject1).field_wxGroupId.equals(this.byx.getTalkerUserName())));
      if (this.vsQ == null)
      {
        i.a(this.byx.vtz, R.h.viewstub_multitalk_popup_nav);
        this.vsQ = ((MultiTalkRoomPopupNav)this.byx.findViewById(R.h.multitalk_talk_room_popup_nav));
      }
    } while (this.vsQ == null);
    y.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
    this.vsQ.setGroupUserName(this.byx.getTalkerUserName());
    this.vsQ.setCurrentSenderUserName(this.byx.cFB());
    this.vsQ.setInChatRoom(bool);
    Object localObject2 = this.vsQ;
    ((MultiTalkRoomPopupNav)localObject2).uPA = false;
    if ((((MultiTalkRoomPopupNav)localObject2).uPt == null) || (((MultiTalkRoomPopupNav)localObject2).uPu == null)) {
      y.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + ((MultiTalkRoomPopupNav)localObject2).uPt + ",currentSenderUserName:" + ((MultiTalkRoomPopupNav)localObject2).uPu);
    }
    List localList;
    int i;
    for (;;)
    {
      this.vsQ.setMultiTalkInfo((f)localObject1);
      ((com.tencent.mm.ui.chatting.b.b.r)this.byx.ac(com.tencent.mm.ui.chatting.b.b.r.class)).Hc(1);
      return;
      localObject3 = ((MultiTalkRoomPopupNav)localObject2).uPt;
      if (!((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).It((String)localObject3))
      {
        ((MultiTalkRoomPopupNav)localObject2).czY();
      }
      else
      {
        localList = ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Iw((String)localObject3);
        if (localList.size() == 0)
        {
          ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).jJ((String)localObject3);
          ((MultiTalkRoomPopupNav)localObject2).czY();
        }
        else
        {
          i = ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).dV((String)localObject3, ((MultiTalkRoomPopupNav)localObject2).uPu);
          if (i != 1) {
            break label1330;
          }
          ((MultiTalkRoomPopupNav)localObject2).setUserTalkingStatus(MultiTalkRoomPopupNav.b.uPE);
          if (!((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Ix((String)localObject3)) {
            break;
          }
          ((MultiTalkRoomPopupNav)localObject2).czY();
        }
      }
    }
    ((MultiTalkRoomPopupNav)localObject2).setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).gV(((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).dW((String)localObject3, ((MultiTalkRoomPopupNav)localObject2).uPu)));
    for (;;)
    {
      ((MultiTalkRoomPopupNav)localObject2).setVisibility(0);
      ((MultiTalkRoomPopupNav)localObject2).uPo.setVisibility(0);
      ((MultiTalkRoomPopupNav)localObject2).uPp.setVisibility(0);
      if ((((MultiTalkRoomPopupNav)localObject2).uPx != null) && ((paramBoolean) || (((MultiTalkRoomPopupNav)localObject2).uPz == null) || (((MultiTalkRoomPopupNav)localObject2).uPz.getVisibility() != 0))) {
        MultiTalkRoomPopupNav.a.a(((MultiTalkRoomPopupNav)localObject2).uPx);
      }
      ((MultiTalkRoomPopupNav)localObject2).dL(MultiTalkRoomPopupNav.k(localList, ""));
      break;
      label1330:
      if (i == 10)
      {
        ((MultiTalkRoomPopupNav)localObject2).setUserTalkingStatus(MultiTalkRoomPopupNav.b.uPF);
        if (((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Ix((String)localObject3))
        {
          ((MultiTalkRoomPopupNav)localObject2).czY();
          break;
        }
        if (((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).bkD())
        {
          ((MultiTalkRoomPopupNav)localObject2).czY();
          break;
        }
        ((MultiTalkRoomPopupNav)localObject2).setUserTalkingStatus(MultiTalkRoomPopupNav.b.uPG);
        ((MultiTalkRoomPopupNav)localObject2).setDefaultBannerStyle(com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[] { Integer.valueOf(localList.size()) }));
        continue;
      }
      ((MultiTalkRoomPopupNav)localObject2).setUserTalkingStatus(MultiTalkRoomPopupNav.b.uPG);
      ((MultiTalkRoomPopupNav)localObject2).setDefaultBannerStyle(com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[] { Integer.valueOf(localList.size()) }));
    }
    cFq();
  }
  
  public final void ID(String paramString)
  {
    if ((this.byx != null) && (paramString.equals(this.byx.getTalkerUserName()))) {
      nm(false);
    }
  }
  
  public final void adx(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.byx.cFB());
    localIntent.putExtra("map_talker_name", this.byx.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.br.d.b(this.byx.vtz.getContext(), "location", ".ui.RedirectUI", localIntent);
  }
  
  public final void ai(Runnable paramRunnable)
  {
    if ((com.tencent.mm.bg.d.eEX != null) && (com.tencent.mm.bg.d.eEX.aF(this.byx.pSb.field_username, this.byx.cFB())))
    {
      com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.track_leave_chattingui), this.byx.vtz.getMMResources().getString(R.l.app_tip), true, new al.5(this, paramRunnable), new al.6(this));
      return;
    }
    paramRunnable.run();
  }
  
  public final void bL(String paramString, boolean paramBoolean)
  {
    if (((com.tencent.mm.bg.d.eEX != null) && (com.tencent.mm.bg.d.eEX.nA(this.byx.pSb.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bg.d.eEX.nz(this.byx.pSb.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.byx.cFB())))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.enter_track_tips), null, new al.3(this, paramString), new al.4(this));
        return;
      }
    }
    adx(paramString);
  }
  
  public final void cDC()
  {
    super.cDC();
    if (this.vsP != null) {
      this.vsP.stop();
    }
  }
  
  public final boolean cFn()
  {
    if (this.vsP == null) {}
    while (this.vsP.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public final boolean cFo()
  {
    if (this.vsQ == null) {}
    while (this.vsQ.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public final int cFp()
  {
    if (this.vsP == null) {
      return 0;
    }
    return this.vsP.getHeight();
  }
  
  public final void cyP()
  {
    y.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.a(this);
    }
    if (com.tencent.mm.bg.d.eEX != null) {
      com.tencent.mm.bg.d.eEX.a(this);
    }
    ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).a(this);
    nm(true);
  }
  
  public final void cyQ()
  {
    y.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.b(this);
    }
    if (com.tencent.mm.bg.d.eEX != null) {
      com.tencent.mm.bg.d.eEX.b(this);
    }
    ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).b(this);
  }
  
  public final void cyR() {}
  
  public final void i(String paramString1, String paramString2, String paramString3)
  {
    if ((this.byx != null) && (paramString1.equals(this.byx.getTalkerUserName()))) {
      nm(false);
    }
  }
  
  public final void nB(String paramString)
  {
    if ((this.byx != null) && (paramString.equals(this.byx.getTalkerUserName()))) {
      nm(false);
    }
  }
  
  public final void nn(boolean paramBoolean)
  {
    if ((((com.tencent.mm.ui.chatting.b.b.e)this.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).cDY()) || (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDM())) {}
    for (int i = 1; (s.fn(this.byx.getTalkerUserName())) && (i == 0); i = 0)
    {
      com.tencent.mm.ui.base.h.b(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.talk_room_kicked_tip), null, true);
      return;
    }
    Object localObject1 = new ru();
    ((ru)localObject1).cbq.cbs = true;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bg.d.eEX != null) && (com.tencent.mm.bg.d.eEX.nA(this.byx.pSb.field_username)))
      {
        localObject1 = com.tencent.mm.bg.d.eEX.nz(this.byx.pSb.field_username);
        if ((localObject1 != null) && (((List)localObject1).contains(this.byx.cFB()))) {
          localObject1 = this.byx.vtz.getMMResources().getString(R.l.talk_room_err_myself_sharing_location);
        }
        for (i = R.l.enter_sharing_location;; i = R.l.join_sharing_location)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          localObject2 = new c.a(this.byx.vtz.getContext());
          ((c.a)localObject2).aeA((String)localObject1);
          ((c.a)localObject2).Is(R.l.app_cancel).a(new al.8(this));
          ((c.a)localObject2).It(i).b(new al.9(this, paramBoolean));
          ((c.a)localObject2).aoP().show();
          return;
          localObject1 = this.byx.vtz.getMMResources().getString(R.l.talk_room_err_other_sharing_location);
        }
      }
      if ((!bk.bl(((ru)localObject1).cbr.cbu)) && (!this.byx.getTalkerUserName().equals(((ru)localObject1).cbr.cbu)))
      {
        com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.talk_room_change_room_tip), null, new al.10(this), new al.11(this));
        return;
      }
      ady(this.byx.getTalkerUserName());
      return;
    }
    if ((bk.bl(((ru)localObject1).cbr.cbu)) || (this.byx.getTalkerUserName().equals(((ru)localObject1).cbr.cbu)))
    {
      ady(this.byx.getTalkerUserName());
      return;
    }
    if ((this.vsP == null) || (this.vsP.getVisibility() != 0))
    {
      com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.talk_room_change_room_tip), null, new al.12(this), new al.2(this));
      return;
    }
    this.vsP.setDialogContent(this.byx.vtz.getMMResources().getString(R.l.talk_room_change_room_tip));
    localObject1 = this.vsP;
    if (((TalkRoomPopupNav)localObject1).vbv == null)
    {
      ((TalkRoomPopupNav)localObject1).vbv = new ScaleAnimation(1.0F, 1.0F, ((TalkRoomPopupNav)localObject1).vbx * 1.0F / ((TalkRoomPopupNav)localObject1).vby, 1.0F);
      ((TalkRoomPopupNav)localObject1).vbv.setDuration(300L);
      ((TalkRoomPopupNav)localObject1).vbv.setAnimationListener(new TalkRoomPopupNav.4((TalkRoomPopupNav)localObject1));
    }
    if (((TalkRoomPopupNav)localObject1).vbw == null)
    {
      ((TalkRoomPopupNav)localObject1).vbw = AnimationUtils.loadAnimation(((TalkRoomPopupNav)localObject1).getContext(), R.a.fast_faded_out);
      ((TalkRoomPopupNav)localObject1).vbw.setFillAfter(true);
      ((TalkRoomPopupNav)localObject1).vbw.setAnimationListener(new TalkRoomPopupNav.5((TalkRoomPopupNav)localObject1));
    }
    Object localObject2 = ((TalkRoomPopupNav)localObject1).kcm.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = ((TalkRoomPopupNav)localObject1).vby;
    ((TalkRoomPopupNav)localObject1).kcm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TalkRoomPopupNav)localObject1).kcm.startAnimation(((TalkRoomPopupNav)localObject1).vbv);
    ((TalkRoomPopupNav)localObject1).uPo.startAnimation(((TalkRoomPopupNav)localObject1).vbw);
    ((TalkRoomPopupNav)localObject1).vbr.startAnimation(AnimationUtils.loadAnimation(((TalkRoomPopupNav)localObject1).getContext(), R.a.fast_faded_in));
    ((TalkRoomPopupNav)localObject1).vbr.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.al
 * JD-Core Version:    0.7.0.1
 */