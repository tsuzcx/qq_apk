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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bj.g;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.c.ax;
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
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.w;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=at.class)
public class bg
  extends a
  implements com.tencent.mm.bj.a, com.tencent.mm.bk.c, com.tencent.mm.plugin.multitalk.model.d.a, at, s.a
{
  public LiveTalkRoomTipsBar VYL;
  private final MStorage.IOnStorageChange WHt;
  public TalkRoomPopupNav WOU;
  public MultiTalkRoomPopupNav WOV;
  private View WOW;
  private TalkRoomPopupNav.a WOX;
  private IListener ubt;
  
  public bg()
  {
    AppMethodBeat.i(35663);
    this.WHt = new bg.1(this);
    this.ubt = new bg.4(this);
    this.WOX = new TalkRoomPopupNav.a()
    {
      public final void byE(String paramAnonymousString)
      {
        AppMethodBeat.i(283093);
        if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
        {
          if ((com.tencent.mm.pluginsdk.permission.b.o(bg.this.fgR.WQv.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(bg.this.fgR.WQv.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label259;
            }
            if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue()) {
              break;
            }
            com.tencent.mm.plugin.account.sdk.b.a.b(bg.this.fgR.WQv.getContext(), bg.this.fgR.WQv.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30762, true);
            AppMethodBeat.o(283093);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.a(bg.this.fgR.WQv.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68);
          AppMethodBeat.o(283093);
          return;
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(bg.this.fgR.WQv.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68, null, null);
        Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(283093);
          return;
        }
        label259:
        bg.this.bzq(paramAnonymousString);
        AppMethodBeat.o(283093);
      }
      
      public final void hKx()
      {
        AppMethodBeat.i(35657);
        if ((com.tencent.mm.q.a.cy(bg.this.fgR.WQv.getContext())) || (com.tencent.mm.q.a.cw(bg.this.fgR.WQv.getContext())) || (com.tencent.mm.q.a.cB(bg.this.fgR.WQv.getContext())))
        {
          Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
          AppMethodBeat.o(35657);
          return;
        }
        Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(com.tencent.mm.bk.d.meV.Xv(bg.this.fgR.NKq.field_username).size()) });
        if (com.tencent.mm.bk.d.meV.Xw(bg.this.fgR.NKq.field_username))
        {
          bg.b(bg.this);
          AppMethodBeat.o(35657);
          return;
        }
        bg.this.Gp(true);
        AppMethodBeat.o(35657);
      }
    };
    AppMethodBeat.o(35663);
  }
  
  private void Go(boolean paramBoolean)
  {
    AppMethodBeat.i(35673);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s, stacks: %s", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack().toString() });
    if (this.fgR == null)
    {
      Log.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(35673);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.f.class)).hOy()) || (((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOk())) {}
    for (boolean bool = true; (com.tencent.mm.model.ab.Lj(this.fgR.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.WOU != null)
      {
        this.WOU.setVisibility(8);
        this.WOU.hKw();
        ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(-1);
      }
      if (this.WOV != null)
      {
        this.WOV.setInChatRoom(false);
        this.WOV.setVisibility(8);
      }
      if (this.VYL != null)
      {
        this.VYL.setInChatRoom(false);
        this.VYL.setVisibility(8);
        if (this.WOW != null) {
          this.WOW.setVisibility(8);
        }
        this.fgR.WQv.getController().showActionbarLine();
        ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Ok(this.fgR.getTalkerUserName());
        ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(-1);
      }
      AppMethodBeat.o(35673);
      return;
    }
    hQK();
    if (((ai)this.fgR.bC(ai.class)).hQk())
    {
      Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "isRecordSelect");
      AppMethodBeat.o(35673);
      return;
    }
    hQL();
    LinkedList localLinkedList;
    Object localObject;
    if ((com.tencent.mm.bk.d.meV != null) && (com.tencent.mm.bk.d.meV.Xw(this.fgR.NKq.field_username)))
    {
      a(this.WOX);
      if (this.WOU == null)
      {
        AppMethodBeat.o(35673);
        return;
      }
      localLinkedList = com.tencent.mm.bk.d.meV.Xv(this.fgR.NKq.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.fgR.getSelfUserName())))
      {
        this.WOU.setBgViewResource(R.g.tipsbar_small_white_bg);
        localObject = this.fgR.WQv.getMMResources().getString(R.l.eUt);
        this.WOU.updateView();
        this.WOU.jU(localLinkedList);
        this.WOU.setVisibility(0);
        this.WOU.setNavContent((String)localObject);
        ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(1);
        AppMethodBeat.o(35673);
        return;
      }
      this.WOU.hKv();
      this.WOU.stop();
      this.WOU.setBgViewResource(R.g.tipsbar_small_white_bg);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.fgR.WQv.getMMResources().getString(R.l.eUs, new Object[] { aa.PJ((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.WOU.ms(R.k.icons_filled_location, this.fgR.WQv.getMMResources().getColor(R.e.Brand));
        break;
        if (localLinkedList != null) {
          localObject = this.fgR.WQv.getMMResources().getString(R.l.eUu, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((g.meT == null) || (!g.meT.Xt(this.fgR.getTalkerUserName())))
    {
      if (com.tencent.mm.model.ab.Lj(this.fgR.getTalkerUserName()))
      {
        localObject = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPU(this.fgR.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.bj.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bj.f)localObject).field_wxGroupId.equals(this.fgR.getTalkerUserName())))
        {
          hQI();
          if (this.WOV != null)
          {
            Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
            this.WOV.setGroupUserName(this.fgR.getTalkerUserName());
            this.WOV.setCurrentSenderUserName(this.fgR.getSelfUserName());
            this.WOV.setInChatRoom(bool);
            this.WOV.FG(paramBoolean);
            this.WOV.setMultiTalkInfo((com.tencent.mm.bj.f)localObject);
            ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(1);
            AppMethodBeat.o(35673);
          }
        }
        else
        {
          localObject = this.fgR.getTalkerUserName();
          localLinkedList = s.byo((String)localObject);
          hQJ();
          if ((localLinkedList != null) && (localLinkedList.size() > 0) && (this.VYL != null))
          {
            Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", new Object[] { localObject, Integer.valueOf(localLinkedList.size()) });
            this.fgR.WQv.getController().hideActionbarLine();
            this.VYL.setInChatRoom(bool);
            this.VYL.setChattingContext(this.fgR);
            this.VYL.hHr();
            this.VYL.hHt();
            ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(1);
          }
        }
        AppMethodBeat.o(35673);
        return;
      }
      hQK();
    }
    AppMethodBeat.o(35673);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(35671);
    if (this.WOU == null)
    {
      m.a(this.fgR.WQv, R.h.dZs);
      this.WOU = ((TalkRoomPopupNav)this.fgR.findViewById(R.h.dWg));
      this.WOW = this.fgR.findViewById(R.h.dXw);
      this.WOU.setRootTipsBarBackground(this.WOW);
      this.WOU.setChattingContext(this.fgR);
      if (this.WOU == null)
      {
        AppMethodBeat.o(35671);
        return;
      }
    }
    if (this.WOU != null) {
      this.WOU.setOnClickListener(parama);
    }
    AppMethodBeat.o(35671);
  }
  
  private void bzr(String paramString)
  {
    AppMethodBeat.i(35679);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(35679);
  }
  
  private void hQI()
  {
    AppMethodBeat.i(35672);
    if (this.WOV == null)
    {
      this.WOW = this.fgR.findViewById(R.h.dXw);
      m.a(this.fgR.WQv, R.h.dZq);
      this.WOV = ((MultiTalkRoomPopupNav)this.fgR.findViewById(R.h.dNa));
      this.WOV.setRootTipsBarBackground(this.WOW);
      this.WOV.setChattingContext(this.fgR);
    }
    AppMethodBeat.o(35672);
  }
  
  private void hQJ()
  {
    AppMethodBeat.i(282236);
    if (this.VYL == null)
    {
      this.WOW = this.fgR.findViewById(R.h.dXw);
      m.a(this.fgR.WQv, R.h.dZp);
      this.VYL = ((LiveTalkRoomTipsBar)this.fgR.findViewById(R.h.dLs));
      LiveTalkRoomTipsBar localLiveTalkRoomTipsBar = this.VYL;
      if (localLiveTalkRoomTipsBar.VYy == null) {
        localLiveTalkRoomTipsBar.VYy = new s(localLiveTalkRoomTipsBar);
      }
      localLiveTalkRoomTipsBar.hHq();
      if (localLiveTalkRoomTipsBar.VYE != null) {
        localLiveTalkRoomTipsBar.VYE.setAdapter(localLiveTalkRoomTipsBar.VYy.VYN);
      }
      this.VYL.setRootTipsBarBackground(this.WOW);
      this.VYL.setChattingUserName(this.fgR.getTalkerUserName());
      AppMethodBeat.o(282236);
      return;
    }
    this.VYL.hHq();
    AppMethodBeat.o(282236);
  }
  
  private void hQK()
  {
    AppMethodBeat.i(35674);
    if (this.WOU != null)
    {
      this.WOU.setVisibility(8);
      this.WOU.hKw();
      this.WOU.hKv();
      this.WOU.stop();
      ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(-1);
    }
    if (this.WOV != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPT(this.fgR.getTalkerUserName())) {
        this.WOV.hIr();
      }
      this.WOV.setVisibility(8);
      ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(-1);
    }
    if (this.VYL != null)
    {
      this.VYL.setVisibility(8);
      this.VYL.hHu();
      if (this.WOW != null) {
        this.WOW.setVisibility(8);
      }
      this.fgR.WQv.getController().showActionbarLine();
      if ((this.WOU == null) && (this.WOV == null)) {
        ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).avD(-1);
      }
    }
    AppMethodBeat.o(35674);
  }
  
  private void hQL()
  {
    AppMethodBeat.i(282238);
    if (this.VYL != null) {
      this.VYL.setChattingUserName(this.fgR.getTalkerUserName());
    }
    AppMethodBeat.o(282238);
  }
  
  private void hQM()
  {
    AppMethodBeat.i(35676);
    dC("fromBanner", false);
    AppMethodBeat.o(35676);
  }
  
  public final void Gp(final boolean paramBoolean)
  {
    AppMethodBeat.i(35675);
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.f.class)).hOy()) || (((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOk())) {}
    for (int i = 1; (com.tencent.mm.model.ab.Lj(this.fgR.getTalkerUserName())) && (i == 0); i = 0)
    {
      com.tencent.mm.ui.base.h.c(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eTV), null, true);
      AppMethodBeat.o(35675);
      return;
    }
    Object localObject = new yx();
    ((yx)localObject).fYg.fYi = true;
    EventCenter.instance.publish((IEvent)localObject);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bk.d.meV != null) && (com.tencent.mm.bk.d.meV.Xw(this.fgR.NKq.field_username)))
      {
        localObject = com.tencent.mm.bk.d.meV.Xv(this.fgR.NKq.field_username);
        if ((localObject != null) && (((List)localObject).contains(this.fgR.getSelfUserName()))) {
          localObject = this.fgR.WQv.getMMResources().getString(R.l.eTQ);
        }
        for (i = R.l.eCh;; i = R.l.eKt)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this.fgR.WQv.getContext());
          locala.bBd((String)localObject);
          locala.ayj(R.l.app_cancel).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35659);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35659);
            }
          });
          locala.ayk(i).d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35660);
              bg localbg = bg.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localbg.bzq(paramAnonymousDialogInterface);
                AppMethodBeat.o(35660);
                return;
              }
            }
          });
          locala.icu().show();
          AppMethodBeat.o(35675);
          return;
          localObject = this.fgR.WQv.getMMResources().getString(R.l.eTR);
        }
      }
      if ((!Util.isNullOrNil(((yx)localObject).fYh.fYk)) && (!this.fgR.getTalkerUserName().equals(((yx)localObject).fYh.fYk)))
      {
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eTM), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35661);
            paramAnonymousDialogInterface = new yx();
            paramAnonymousDialogInterface.fYg.fYj = true;
            EventCenter.instance.publish(paramAnonymousDialogInterface);
            bg.a(bg.this, bg.this.fgR.getTalkerUserName());
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
      bzr(this.fgR.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((Util.isNullOrNil(((yx)localObject).fYh.fYk)) || (this.fgR.getTalkerUserName().equals(((yx)localObject).fYh.fYk)))
    {
      bzr(this.fgR.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((this.WOU == null) || (this.WOU.getVisibility() != 0)) {
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eTM), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35651);
          paramAnonymousDialogInterface = new yx();
          paramAnonymousDialogInterface.fYg.fYj = true;
          EventCenter.instance.publish(paramAnonymousDialogInterface);
          bg.a(bg.this, bg.this.fgR.getTalkerUserName());
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
  
  public final void Xx(String paramString)
  {
    AppMethodBeat.i(35669);
    if ((this.fgR != null) && (paramString.equals(this.fgR.getTalkerUserName()))) {
      Go(false);
    }
    AppMethodBeat.o(35669);
  }
  
  public final void aQd(String paramString)
  {
    AppMethodBeat.i(35670);
    if ((this.fgR != null) && (paramString.equals(this.fgR.getTalkerUserName()))) {
      Go(false);
    }
    AppMethodBeat.o(35670);
  }
  
  public final void aR(final Runnable paramRunnable)
  {
    AppMethodBeat.i(35667);
    if ((com.tencent.mm.bk.d.meV != null) && (com.tencent.mm.bk.d.meV.bE(this.fgR.NKq.field_username, this.fgR.getSelfUserName())))
    {
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.track_leave_chattingui), this.fgR.WQv.getMMResources().getString(R.l.app_tip), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35656);
          paramRunnable.run();
          paramAnonymousDialogInterface = new fv();
          paramAnonymousDialogInterface.fBE.username = bg.this.fgR.getTalkerUserName();
          EventCenter.instance.publish(paramAnonymousDialogInterface);
          AppMethodBeat.o(35656);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35667);
      return;
    }
    Object localObject;
    if (this.WOU != null)
    {
      localObject = this.WOU;
      if (((TalkRoomPopupNav)localObject).WpI.getVisibility() == 0)
      {
        ((TalkRoomPopupNav)localObject).FF(false);
        ((TalkRoomPopupNav)localObject).WpI.setVisibility(8);
      }
    }
    if (this.WOV != null)
    {
      localObject = this.WOV;
      if ((((MultiTalkRoomPopupNav)localObject).WcK != null) && (((MultiTalkRoomPopupNav)localObject).WcK.WcT != null) && (((MultiTalkRoomPopupNav)localObject).WcK.WcT.getVisibility() == 0))
      {
        ((MultiTalkRoomPopupNav)localObject).WcK.close();
        ((MultiTalkRoomPopupNav)localObject).WcK.WcT.setVisibility(8);
      }
    }
    if (this.VYL != null)
    {
      localObject = this.VYL;
      if (((LiveTalkRoomTipsBar)localObject).VYz.getVisibility() == 0)
      {
        ((LiveTalkRoomTipsBar)localObject).bm(true, false);
        ((LiveTalkRoomTipsBar)localObject).VYz.setVisibility(8);
      }
    }
    paramRunnable.run();
    AppMethodBeat.o(35667);
  }
  
  public final void byp(String paramString)
  {
    AppMethodBeat.i(282235);
    if ((this.fgR != null) && (paramString.equals(this.fgR.getTalkerUserName()))) {
      Go(false);
    }
    AppMethodBeat.o(282235);
  }
  
  public final void bzq(String paramString)
  {
    AppMethodBeat.i(35678);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.fgR.getSelfUserName());
    localIntent.putExtra("map_talker_name", this.fgR.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35678);
  }
  
  public final void dC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35677);
    if ((com.tencent.mm.q.a.cy(this.fgR.WQv.getContext())) || (com.tencent.mm.q.a.cw(this.fgR.WQv.getContext())) || (com.tencent.mm.q.a.cB(this.fgR.WQv.getContext())))
    {
      Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(35677);
      return;
    }
    if (((com.tencent.mm.bk.d.meV != null) && (com.tencent.mm.bk.d.meV.Xw(this.fgR.NKq.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bk.d.meV.Xv(this.fgR.NKq.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.fgR.getSelfUserName())))
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.WOU.setDialogContent(this.fgR.WQv.getMMResources().getString(R.l.eCi));
        this.WOU.M(paramString, localLinkedList);
        AppMethodBeat.o(35677);
        return;
      }
    }
    bzq(paramString);
    AppMethodBeat.o(35677);
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35668);
    if ((this.fgR != null) && (paramString1.equals(this.fgR.getTalkerUserName()))) {
      Go(false);
    }
    AppMethodBeat.o(35668);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35681);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (g.meT != null) {
      g.meT.a(this);
    }
    if (com.tencent.mm.bk.d.meV != null) {
      com.tencent.mm.bk.d.meV.a(this);
    }
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).a(this);
    }
    s.a(this);
    EventCenter.instance.addListener(this.ubt);
    Go(true);
    AppMethodBeat.o(35681);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35682);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (g.meT != null) {
      g.meT.b(this);
    }
    if (com.tencent.mm.bk.d.meV != null) {
      com.tencent.mm.bk.d.meV.b(this);
    }
    s.b(this);
    EventCenter.instance.removeListener(this.ubt);
    ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).b(this);
    AppMethodBeat.o(35682);
  }
  
  public final void hGZ() {}
  
  public final void hHa()
  {
    AppMethodBeat.i(282240);
    if (this.VYL != null)
    {
      this.VYL.bm(true, false);
      if (this.VYL.VYy != null) {
        s.hHv();
      }
    }
    hQK();
    AppMethodBeat.o(282240);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35680);
    super.hNZ();
    if (this.WOU != null) {
      this.WOU.stop();
    }
    AppMethodBeat.o(35680);
  }
  
  public final boolean hQE()
  {
    AppMethodBeat.i(35664);
    if (this.WOU == null)
    {
      AppMethodBeat.o(35664);
      return false;
    }
    if (this.WOU.getVisibility() == 0)
    {
      AppMethodBeat.o(35664);
      return true;
    }
    AppMethodBeat.o(35664);
    return false;
  }
  
  public final boolean hQF()
  {
    AppMethodBeat.i(35665);
    if (this.WOV == null)
    {
      AppMethodBeat.o(35665);
      return false;
    }
    if (this.WOV.getVisibility() == 0)
    {
      AppMethodBeat.o(35665);
      return true;
    }
    AppMethodBeat.o(35665);
    return false;
  }
  
  public final boolean hQG()
  {
    AppMethodBeat.i(282233);
    if (this.VYL == null)
    {
      AppMethodBeat.o(282233);
      return false;
    }
    if (this.VYL.getVisibility() == 0)
    {
      AppMethodBeat.o(282233);
      return true;
    }
    AppMethodBeat.o(282233);
    return false;
  }
  
  public final int hQH()
  {
    AppMethodBeat.i(35666);
    if (this.WOU == null)
    {
      AppMethodBeat.o(35666);
      return 0;
    }
    int i = this.WOU.getHeight();
    AppMethodBeat.o(35666);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bg
 * JD-Core Version:    0.7.0.1
 */