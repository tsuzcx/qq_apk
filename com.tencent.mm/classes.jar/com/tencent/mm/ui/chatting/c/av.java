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
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.model.a.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.LiveTalkRoomTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.as.a;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.4;
import com.tencent.mm.ui.base.TalkRoomPopupNav.5;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=ak.class)
public class av
  extends a
  implements com.tencent.mm.bi.a, com.tencent.mm.bj.c, a.a, as.a, ak
{
  private final k.a GsS;
  public TalkRoomPopupNav GyM;
  public MultiTalkRoomPopupNav GyN;
  private TalkRoomPopupNav.a GyO;
  public LiveTalkRoomTipsBar LCE;
  private com.tencent.mm.sdk.b.c nZA;
  
  public av()
  {
    AppMethodBeat.i(35663);
    this.GsS = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35650);
        ad.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (!bt.isNullOrNil(paramAnonymousString)) {
          av.a(av.this);
        }
        AppMethodBeat.o(35650);
      }
    };
    this.nZA = new com.tencent.mm.sdk.b.c() {};
    this.GyO = new TalkRoomPopupNav.a()
    {
      public final void eTt()
      {
        AppMethodBeat.i(35657);
        if ((com.tencent.mm.r.a.ce(av.this.cOd.GzJ.getContext())) || (com.tencent.mm.r.a.cc(av.this.cOd.GzJ.getContext())))
        {
          ad.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
          AppMethodBeat.o(35657);
          return;
        }
        ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(com.tencent.mm.bj.d.hxx.zz(av.this.cOd.zgX.field_username).size()) });
        if (com.tencent.mm.bj.d.hxx.zA(av.this.cOd.zgX.field_username))
        {
          av.b(av.this);
          AppMethodBeat.o(35657);
          return;
        }
        av.this.wi(true);
        AppMethodBeat.o(35657);
      }
      
      public final void eTu()
      {
        AppMethodBeat.i(35658);
        vj localvj = new vj();
        localvj.dAP.dAS = true;
        com.tencent.mm.sdk.b.a.ESL.l(localvj);
        av.a(av.this, av.this.cOd.getTalkerUserName());
        AppMethodBeat.o(35658);
      }
    };
    AppMethodBeat.o(35663);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(35671);
    if (this.GyM == null)
    {
      j.a(this.cOd.GzJ, 2131306446);
      this.GyM = ((TalkRoomPopupNav)this.cOd.findViewById(2131305650));
      if (this.GyM == null)
      {
        AppMethodBeat.o(35671);
        return;
      }
    }
    if (this.GyM != null) {
      this.GyM.setOnClickListener(parama);
    }
    AppMethodBeat.o(35671);
  }
  
  private void aKO(String paramString)
  {
    AppMethodBeat.i(35679);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(35679);
  }
  
  private void eYH()
  {
    AppMethodBeat.i(35672);
    if (this.GyN == null)
    {
      j.a(this.cOd.GzJ, 2131306444);
      this.GyN = ((MultiTalkRoomPopupNav)this.cOd.findViewById(2131302589));
    }
    AppMethodBeat.o(35672);
  }
  
  private void eYI()
  {
    AppMethodBeat.i(35674);
    if (this.GyM != null)
    {
      this.GyM.setVisibility(8);
      this.GyM.jo(-1, 0);
      this.GyM.stop();
      ((x)this.cOd.be(x.class)).YN(-1);
    }
    if (this.GyN != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahp(this.cOd.getTalkerUserName())) {
        this.GyN.eRC();
      }
      this.GyN.setVisibility(8);
      ((x)this.cOd.be(x.class)).YN(-1);
    }
    if ((this.GyM == null) && (this.GyN == null) && (this.LCE != null))
    {
      this.LCE.setVisibility(8);
      this.cOd.GzJ.getController().showActionbarLine();
      ((x)this.cOd.be(x.class)).YN(-1);
    }
    AppMethodBeat.o(35674);
  }
  
  private void eYJ()
  {
    AppMethodBeat.i(35676);
    cG("fromBanner", false);
    AppMethodBeat.o(35676);
  }
  
  private void gaj()
  {
    AppMethodBeat.i(204967);
    if (this.LCE == null)
    {
      j.a(this.cOd.GzJ, 2131307919);
      this.LCE = ((LiveTalkRoomTipsBar)this.cOd.findViewById(2131307706));
    }
    AppMethodBeat.o(204967);
  }
  
  private void wh(boolean paramBoolean)
  {
    AppMethodBeat.i(35673);
    ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s, stacks: %s", new Object[] { Boolean.valueOf(paramBoolean), bt.eGN().toString() });
    if (this.cOd == null)
    {
      ad.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(35673);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.c.b.f)this.cOd.be(com.tencent.mm.ui.chatting.c.b.f.class)).eWV()) || (((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWI())) {}
    for (boolean bool = true; (w.pF(this.cOd.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.GyM != null)
      {
        this.GyM.setVisibility(8);
        ((x)this.cOd.be(x.class)).YN(-1);
      }
      if (this.GyN != null)
      {
        this.GyN.setInChatRoom(false);
        this.GyN.setVisibility(8);
      }
      if (this.LCE != null)
      {
        this.LCE.setInChatRoom(false);
        this.LCE.setVisibility(8);
        this.cOd.GzJ.getController().showActionbarLine();
        ((x)this.cOd.be(x.class)).YN(-1);
      }
      AppMethodBeat.o(35673);
      return;
    }
    eYI();
    LinkedList localLinkedList;
    Object localObject;
    if ((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.zA(this.cOd.zgX.field_username)))
    {
      a(this.GyO);
      if (this.GyM == null)
      {
        AppMethodBeat.o(35673);
        return;
      }
      localLinkedList = com.tencent.mm.bj.d.hxx.zz(this.cOd.zgX.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.cOd.eYX())))
      {
        this.GyM.setBgViewResource(2131234378);
        localObject = this.cOd.GzJ.getMMResources().getString(2131764527);
        this.GyM.setIconRes$255f295(this.cOd.GzJ.getMMResources().getColor(2131101189));
        this.GyM.jo(2131690422, this.cOd.GzJ.getMMResources().getColor(2131099828));
        this.GyM.start();
        this.GyM.setVisibility(0);
        this.GyM.setNavContent((String)localObject);
        ((x)this.cOd.be(x.class)).YN(1);
        AppMethodBeat.o(35673);
        return;
      }
      this.GyM.jo(-1, 0);
      this.GyM.stop();
      this.GyM.setBgViewResource(2131234389);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.cOd.GzJ.getMMResources().getString(2131764526, new Object[] { v.sh((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.GyM.setIconRes$255f295(this.cOd.GzJ.getMMResources().getColor(2131099699));
        break;
        if (localLinkedList != null) {
          localObject = this.cOd.GzJ.getMMResources().getString(2131764528, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((com.tencent.mm.bi.g.hxv == null) || (!com.tencent.mm.bi.g.hxv.zx(this.cOd.getTalkerUserName())))
    {
      if (w.pF(this.cOd.getTalkerUserName()))
      {
        localObject = ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahq(this.cOd.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.bi.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bi.f)localObject).field_wxGroupId.equals(this.cOd.getTalkerUserName())))
        {
          eYH();
          if (this.GyN != null)
          {
            ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
            this.GyN.setGroupUserName(this.cOd.getTalkerUserName());
            this.GyN.setCurrentSenderUserName(this.cOd.eYX());
            this.GyN.setInChatRoom(bool);
            this.GyN.vD(paramBoolean);
            this.GyN.setMultiTalkInfo((com.tencent.mm.bi.f)localObject);
            ((x)this.cOd.be(x.class)).YN(1);
            AppMethodBeat.o(35673);
          }
        }
        else
        {
          localObject = this.cOd.getTalkerUserName();
          localLinkedList = as.aWi((String)localObject).gag();
          if ((localLinkedList != null) && (localLinkedList.size() > 0))
          {
            gaj();
            if (this.LCE != null)
            {
              ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", new Object[] { localObject, Integer.valueOf(localLinkedList.size()) });
              this.cOd.GzJ.getController().hideActionbarLine();
              as.aWi((String)localObject).c(this.LCE);
              this.LCE.gad();
              ((x)this.cOd.be(x.class)).YN(1);
            }
          }
        }
        AppMethodBeat.o(35673);
        return;
      }
      eYI();
    }
    AppMethodBeat.o(35673);
  }
  
  public final void aG(final Runnable paramRunnable)
  {
    AppMethodBeat.i(35667);
    if ((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.bo(this.cOd.zgX.field_username, this.cOd.eYX())))
    {
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131764523), this.cOd.GzJ.getMMResources().getString(2131755906), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35656);
          paramRunnable.run();
          paramAnonymousDialogInterface = new fg();
          paramAnonymousDialogInterface.dhF.username = av.this.cOd.getTalkerUserName();
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
          AppMethodBeat.o(35656);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35667);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(35667);
  }
  
  public final void aKN(String paramString)
  {
    AppMethodBeat.i(35678);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.cOd.eYX());
    localIntent.putExtra("map_talker_name", this.cOd.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35678);
  }
  
  public final void aWk(String paramString)
  {
    AppMethodBeat.i(204966);
    if ((this.cOd != null) && (paramString.equals(this.cOd.getTalkerUserName()))) {
      wh(false);
    }
    AppMethodBeat.o(204966);
  }
  
  public final void ahz(String paramString)
  {
    AppMethodBeat.i(35670);
    if ((this.cOd != null) && (paramString.equals(this.cOd.getTalkerUserName()))) {
      wh(false);
    }
    AppMethodBeat.o(35670);
  }
  
  public final void cG(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35677);
    if ((com.tencent.mm.r.a.ce(this.cOd.GzJ.getContext())) || (com.tencent.mm.r.a.cc(this.cOd.GzJ.getContext())))
    {
      ad.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(35677);
      return;
    }
    if (((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.zA(this.cOd.zgX.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bj.d.hxx.zz(this.cOd.zgX.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.cOd.eYX())))
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131758427), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35653);
            av.this.aKN(paramString);
            AppMethodBeat.o(35653);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35654);
            com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(35654);
          }
        });
        AppMethodBeat.o(35677);
        return;
      }
    }
    aKN(paramString);
    AppMethodBeat.o(35677);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35681);
    ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.a(this);
    }
    if (com.tencent.mm.bj.d.hxx != null) {
      com.tencent.mm.bj.d.hxx.a(this);
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).a(this);
    }
    as.a(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.nZA);
    wh(true);
    AppMethodBeat.o(35681);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35682);
    ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.b(this);
    }
    if (com.tencent.mm.bj.d.hxx != null) {
      com.tencent.mm.bj.d.hxx.b(this);
    }
    as.b(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.nZA);
    ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).b(this);
    AppMethodBeat.o(35682);
  }
  
  public final void eQF() {}
  
  public final void eQG()
  {
    AppMethodBeat.i(204968);
    if (this.LCE != null) {
      this.LCE.setTipsBarLayout(true);
    }
    eYI();
    AppMethodBeat.o(204968);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35680);
    super.eWx();
    if (this.GyM != null) {
      this.GyM.stop();
    }
    AppMethodBeat.o(35680);
  }
  
  public final boolean eYE()
  {
    AppMethodBeat.i(35664);
    if (this.GyM == null)
    {
      AppMethodBeat.o(35664);
      return false;
    }
    if (this.GyM.getVisibility() == 0)
    {
      AppMethodBeat.o(35664);
      return true;
    }
    AppMethodBeat.o(35664);
    return false;
  }
  
  public final boolean eYF()
  {
    AppMethodBeat.i(35665);
    if (this.GyN == null)
    {
      AppMethodBeat.o(35665);
      return false;
    }
    if (this.GyN.getVisibility() == 0)
    {
      AppMethodBeat.o(35665);
      return true;
    }
    AppMethodBeat.o(35665);
    return false;
  }
  
  public final int eYG()
  {
    AppMethodBeat.i(35666);
    if (this.GyM == null)
    {
      AppMethodBeat.o(35666);
      return 0;
    }
    int i = this.GyM.getHeight();
    AppMethodBeat.o(35666);
    return i;
  }
  
  public final boolean gai()
  {
    AppMethodBeat.i(204965);
    if (this.LCE == null)
    {
      AppMethodBeat.o(204965);
      return false;
    }
    if (this.LCE.getVisibility() == 0)
    {
      AppMethodBeat.o(204965);
      return true;
    }
    AppMethodBeat.o(204965);
    return false;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35668);
    if ((this.cOd != null) && (paramString1.equals(this.cOd.getTalkerUserName()))) {
      wh(false);
    }
    AppMethodBeat.o(35668);
  }
  
  public final void wi(final boolean paramBoolean)
  {
    AppMethodBeat.i(35675);
    if ((((com.tencent.mm.ui.chatting.c.b.f)this.cOd.be(com.tencent.mm.ui.chatting.c.b.f.class)).eWV()) || (((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWI())) {}
    for (int i = 1; (w.pF(this.cOd.getTalkerUserName())) && (i == 0); i = 0)
    {
      com.tencent.mm.ui.base.h.c(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131764356), null, true);
      AppMethodBeat.o(35675);
      return;
    }
    Object localObject1 = new vj();
    ((vj)localObject1).dAP.dAR = true;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.zA(this.cOd.zgX.field_username)))
      {
        localObject1 = com.tencent.mm.bj.d.hxx.zz(this.cOd.zgX.field_username);
        if ((localObject1 != null) && (((List)localObject1).contains(this.cOd.eYX()))) {
          localObject1 = this.cOd.GzJ.getMMResources().getString(2131764351);
        }
        for (i = 2131758424;; i = 2131760576)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          localObject2 = new d.a(this.cOd.GzJ.getContext());
          ((d.a)localObject2).aMg((String)localObject1);
          ((d.a)localObject2).aaB(2131755691).b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35659);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35659);
            }
          });
          ((d.a)localObject2).aaC(i).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35660);
              av localav = av.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localav.aKN(paramAnonymousDialogInterface);
                AppMethodBeat.o(35660);
                return;
              }
            }
          });
          ((d.a)localObject2).fft().show();
          AppMethodBeat.o(35675);
          return;
          localObject1 = this.cOd.GzJ.getMMResources().getString(2131764352);
        }
      }
      if ((!bt.isNullOrNil(((vj)localObject1).dAQ.dAT)) && (!this.cOd.getTalkerUserName().equals(((vj)localObject1).dAQ.dAT)))
      {
        com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35661);
            paramAnonymousDialogInterface = new vj();
            paramAnonymousDialogInterface.dAP.dAS = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
            av.a(av.this, av.this.cOd.getTalkerUserName());
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
      aKO(this.cOd.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((bt.isNullOrNil(((vj)localObject1).dAQ.dAT)) || (this.cOd.getTalkerUserName().equals(((vj)localObject1).dAQ.dAT)))
    {
      aKO(this.cOd.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((this.GyM == null) || (this.GyM.getVisibility() != 0))
    {
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35651);
          paramAnonymousDialogInterface = new vj();
          paramAnonymousDialogInterface.dAP.dAS = true;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
          av.a(av.this, av.this.cOd.getTalkerUserName());
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
      AppMethodBeat.o(35675);
      return;
    }
    this.GyM.setDialogContent(this.cOd.GzJ.getMMResources().getString(2131764346));
    localObject1 = this.GyM;
    if (((TalkRoomPopupNav)localObject1).Gdk == null)
    {
      ((TalkRoomPopupNav)localObject1).Gdk = new ScaleAnimation(1.0F, 1.0F, ((TalkRoomPopupNav)localObject1).Gdm * 1.0F / ((TalkRoomPopupNav)localObject1).Gdn, 1.0F);
      ((TalkRoomPopupNav)localObject1).Gdk.setDuration(300L);
      ((TalkRoomPopupNav)localObject1).Gdk.setAnimationListener(new TalkRoomPopupNav.4((TalkRoomPopupNav)localObject1));
    }
    if (((TalkRoomPopupNav)localObject1).Gdl == null)
    {
      ((TalkRoomPopupNav)localObject1).Gdl = AnimationUtils.loadAnimation(((TalkRoomPopupNav)localObject1).getContext(), 2130772048);
      ((TalkRoomPopupNav)localObject1).Gdl.setFillAfter(true);
      ((TalkRoomPopupNav)localObject1).Gdl.setAnimationListener(new TalkRoomPopupNav.5((TalkRoomPopupNav)localObject1));
    }
    Object localObject2 = ((TalkRoomPopupNav)localObject1).qeH.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = ((TalkRoomPopupNav)localObject1).Gdn;
    ((TalkRoomPopupNav)localObject1).qeH.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TalkRoomPopupNav)localObject1).qeH.startAnimation(((TalkRoomPopupNav)localObject1).Gdk);
    ((TalkRoomPopupNav)localObject1).FQJ.startAnimation(((TalkRoomPopupNav)localObject1).Gdl);
    ((TalkRoomPopupNav)localObject1).Gdg.startAnimation(AnimationUtils.loadAnimation(((TalkRoomPopupNav)localObject1).getContext(), 2130772047));
    ((TalkRoomPopupNav)localObject1).Gdg.setVisibility(0);
    AppMethodBeat.o(35675);
  }
  
  public final void zB(String paramString)
  {
    AppMethodBeat.i(35669);
    if ((this.cOd != null) && (paramString.equals(this.cOd.getTalkerUserName()))) {
      wh(false);
    }
    AppMethodBeat.o(35669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.av
 * JD-Core Version:    0.7.0.1
 */