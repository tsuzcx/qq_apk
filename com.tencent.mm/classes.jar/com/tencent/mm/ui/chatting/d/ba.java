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
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.LiveTalkRoomTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.a;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.z;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=ap.class)
public class ba
  extends a
  implements com.tencent.mm.bh.a, com.tencent.mm.bi.c, com.tencent.mm.plugin.multitalk.model.d.a, ap, p.a
{
  public LiveTalkRoomTipsBar JuW;
  private final k.a KbL;
  public TalkRoomPopupNav KiG;
  public MultiTalkRoomPopupNav KiH;
  private View KiI;
  private TalkRoomPopupNav.a KiJ;
  private com.tencent.mm.sdk.b.c pmW;
  
  public ba()
  {
    AppMethodBeat.i(35663);
    this.KbL = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35650);
        ae.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (!bu.isNullOrNil(paramAnonymousString)) {
          ba.a(ba.this);
        }
        AppMethodBeat.o(35650);
      }
    };
    this.pmW = new com.tencent.mm.sdk.b.c() {};
    this.KiJ = new TalkRoomPopupNav.a()
    {
      public final void aXc(String paramAnonymousString)
      {
        AppMethodBeat.i(187408);
        if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
        {
          if ((com.tencent.mm.pluginsdk.permission.b.n(ba.this.cXJ.Kkd.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(ba.this.cXJ.Kkd.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label258;
            }
            if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue()) {
              break;
            }
            com.tencent.mm.plugin.account.a.b.a.b(ba.this.cXJ.Kkd.getContext(), ba.this.cXJ.Kkd.getMMResources().getString(2131760740, new Object[] { ad.fom() }), 30762, true);
            AppMethodBeat.o(187408);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.a(ba.this.cXJ.Kkd.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
          AppMethodBeat.o(187408);
          return;
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ba.this.cXJ.Kkd.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68, null, null);
        ae.d("MicroMsg.ChattingUI.TrackRoomComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(187408);
          return;
        }
        label258:
        ba.this.aXK(paramAnonymousString);
        AppMethodBeat.o(187408);
      }
      
      public final void fDx()
      {
        AppMethodBeat.i(35657);
        if ((com.tencent.mm.r.a.ch(ba.this.cXJ.Kkd.getContext())) || (com.tencent.mm.r.a.cf(ba.this.cXJ.Kkd.getContext())) || (com.tencent.mm.r.a.cj(ba.this.cXJ.Kkd.getContext())))
        {
          ae.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
          AppMethodBeat.o(35657);
          return;
        }
        ae.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(com.tencent.mm.bi.d.iuo.Hl(ba.this.cXJ.Cqh.field_username).size()) });
        if (com.tencent.mm.bi.d.iuo.Hm(ba.this.cXJ.Cqh.field_username))
        {
          ba.b(ba.this);
          AppMethodBeat.o(35657);
          return;
        }
        ba.this.yf(true);
        AppMethodBeat.o(35657);
      }
    };
    AppMethodBeat.o(35663);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(35671);
    if (this.KiG == null)
    {
      l.a(this.cXJ.Kkd, 2131306446);
      this.KiG = ((TalkRoomPopupNav)this.cXJ.findViewById(2131305650));
      this.KiI = this.cXJ.findViewById(2131308033);
      this.KiG.setRootTipsBarBackground(this.KiI);
      this.KiG.setChattingContext(this.cXJ);
      if (this.KiG == null)
      {
        AppMethodBeat.o(35671);
        return;
      }
    }
    if (this.KiG != null) {
      this.KiG.setOnClickListener(parama);
    }
    AppMethodBeat.o(35671);
  }
  
  private void aXL(String paramString)
  {
    AppMethodBeat.i(35679);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(35679);
  }
  
  private void fJb()
  {
    AppMethodBeat.i(35672);
    if (this.KiH == null)
    {
      this.KiI = this.cXJ.findViewById(2131308033);
      l.a(this.cXJ.Kkd, 2131306444);
      this.KiH = ((MultiTalkRoomPopupNav)this.cXJ.findViewById(2131302589));
      this.KiH.setRootTipsBarBackground(this.KiI);
      this.KiH.setChattingContext(this.cXJ);
    }
    AppMethodBeat.o(35672);
  }
  
  private void fJc()
  {
    AppMethodBeat.i(187411);
    if (this.JuW == null)
    {
      this.KiI = this.cXJ.findViewById(2131308033);
      l.a(this.cXJ.Kkd, 2131308062);
      this.JuW = ((LiveTalkRoomTipsBar)this.cXJ.findViewById(2131307787));
      LiveTalkRoomTipsBar localLiveTalkRoomTipsBar = this.JuW;
      if (localLiveTalkRoomTipsBar.JuH == null) {
        localLiveTalkRoomTipsBar.JuH = new p(localLiveTalkRoomTipsBar);
      }
      localLiveTalkRoomTipsBar.fAL();
      if (localLiveTalkRoomTipsBar.JuP != null) {
        localLiveTalkRoomTipsBar.JuP.setAdapter(localLiveTalkRoomTipsBar.JuH.JuY);
      }
      this.JuW.setRootTipsBarBackground(this.KiI);
      this.JuW.setChattingUserName(this.cXJ.getTalkerUserName());
      AppMethodBeat.o(187411);
      return;
    }
    this.JuW.fAL();
    AppMethodBeat.o(187411);
  }
  
  private void fJd()
  {
    AppMethodBeat.i(35674);
    if (this.KiG != null)
    {
      this.KiG.setVisibility(8);
      this.KiG.fDw();
      this.KiG.fDv();
      this.KiG.stop();
      ((z)this.cXJ.bh(z.class)).adR(-1);
    }
    if (this.KiH != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).aso(this.cXJ.getTalkerUserName())) {
        this.KiH.fBz();
      }
      this.KiH.setVisibility(8);
      ((z)this.cXJ.bh(z.class)).adR(-1);
    }
    if (this.JuW != null)
    {
      this.JuW.setVisibility(8);
      if (this.KiI != null) {
        this.KiI.setVisibility(8);
      }
      this.cXJ.Kkd.getController().showActionbarLine();
      if ((this.KiG == null) && (this.KiH == null)) {
        ((z)this.cXJ.bh(z.class)).adR(-1);
      }
    }
    AppMethodBeat.o(35674);
  }
  
  private void fJe()
  {
    AppMethodBeat.i(187412);
    if (this.JuW != null) {
      this.JuW.setChattingUserName(this.cXJ.getTalkerUserName());
    }
    AppMethodBeat.o(187412);
  }
  
  private void fJf()
  {
    AppMethodBeat.i(35676);
    cV("fromBanner", false);
    AppMethodBeat.o(35676);
  }
  
  private void ye(boolean paramBoolean)
  {
    AppMethodBeat.i(35673);
    ae.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s, stacks: %s", new Object[] { Boolean.valueOf(paramBoolean), bu.fpN().toString() });
    if (this.cXJ == null)
    {
      ae.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(35673);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.f.class)).fHc()) || (((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGP())) {}
    for (boolean bool = true; (x.wb(this.cXJ.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.KiG != null)
      {
        this.KiG.setVisibility(8);
        this.KiG.fDw();
        ((z)this.cXJ.bh(z.class)).adR(-1);
      }
      if (this.KiH != null)
      {
        this.KiH.setInChatRoom(false);
        this.KiH.setVisibility(8);
      }
      if (this.JuW != null)
      {
        this.JuW.setInChatRoom(false);
        this.JuW.setVisibility(8);
        if (this.KiI != null) {
          this.KiI.setVisibility(8);
        }
        this.cXJ.Kkd.getController().showActionbarLine();
        ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().yA(this.cXJ.getTalkerUserName());
        ((z)this.cXJ.bh(z.class)).adR(-1);
      }
      AppMethodBeat.o(35673);
      return;
    }
    fJd();
    if (((af)this.cXJ.bh(af.class)).fID())
    {
      ae.i("MicroMsg.ChattingUI.TrackRoomComponent", "isRecordSelect");
      AppMethodBeat.o(35673);
      return;
    }
    fJe();
    LinkedList localLinkedList;
    Object localObject;
    if ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.Hm(this.cXJ.Cqh.field_username)))
    {
      a(this.KiJ);
      if (this.KiG == null)
      {
        AppMethodBeat.o(35673);
        return;
      }
      localLinkedList = com.tencent.mm.bi.d.iuo.Hl(this.cXJ.Cqh.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.cXJ.fJy())))
      {
        this.KiG.setBgViewResource(2131234968);
        localObject = this.cXJ.Kkd.getMMResources().getString(2131764527);
        this.KiG.updateView();
        this.KiG.hY(localLinkedList);
        this.KiG.setVisibility(0);
        this.KiG.setNavContent((String)localObject);
        ((z)this.cXJ.bh(z.class)).adR(1);
        AppMethodBeat.o(35673);
        return;
      }
      this.KiG.fDv();
      this.KiG.stop();
      this.KiG.setBgViewResource(2131234968);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.cXJ.Kkd.getMMResources().getString(2131764526, new Object[] { w.zP((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.KiG.setIconRes$255f295(this.cXJ.Kkd.getMMResources().getColor(2131099699));
        break;
        if (localLinkedList != null) {
          localObject = this.cXJ.Kkd.getMMResources().getString(2131764528, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((com.tencent.mm.bh.g.ium == null) || (!com.tencent.mm.bh.g.ium.Hj(this.cXJ.getTalkerUserName())))
    {
      if (x.wb(this.cXJ.getTalkerUserName()))
      {
        localObject = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asp(this.cXJ.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.bh.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bh.f)localObject).field_wxGroupId.equals(this.cXJ.getTalkerUserName())))
        {
          fJb();
          if (this.KiH != null)
          {
            ae.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
            this.KiH.setGroupUserName(this.cXJ.getTalkerUserName());
            this.KiH.setCurrentSenderUserName(this.cXJ.fJy());
            this.KiH.setInChatRoom(bool);
            this.KiH.xA(paramBoolean);
            this.KiH.setMultiTalkInfo((com.tencent.mm.bh.f)localObject);
            ((z)this.cXJ.bh(z.class)).adR(1);
            AppMethodBeat.o(35673);
          }
        }
        else
        {
          localObject = this.cXJ.getTalkerUserName();
          localLinkedList = p.aWQ((String)localObject);
          fJc();
          if ((localLinkedList != null) && (localLinkedList.size() > 0) && (this.JuW != null))
          {
            ae.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", new Object[] { localObject, Integer.valueOf(localLinkedList.size()) });
            this.cXJ.Kkd.getController().hideActionbarLine();
            this.JuW.setInChatRoom(bool);
            this.JuW.setChattingContext(this.cXJ);
            this.JuW.fAM();
            ((z)this.cXJ.bh(z.class)).adR(1);
          }
        }
        AppMethodBeat.o(35673);
        return;
      }
      fJd();
    }
    AppMethodBeat.o(35673);
  }
  
  public final void Hn(String paramString)
  {
    AppMethodBeat.i(35669);
    if ((this.cXJ != null) && (paramString.equals(this.cXJ.getTalkerUserName()))) {
      ye(false);
    }
    AppMethodBeat.o(35669);
  }
  
  public final void aE(final Runnable paramRunnable)
  {
    AppMethodBeat.i(35667);
    if ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.bx(this.cXJ.Cqh.field_username, this.cXJ.fJy())))
    {
      h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131764523), this.cXJ.Kkd.getMMResources().getString(2131755906), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35656);
          paramRunnable.run();
          paramAnonymousDialogInterface = new fl();
          paramAnonymousDialogInterface.drB.username = ba.this.cXJ.getTalkerUserName();
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
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
    if (this.KiG != null)
    {
      localObject = this.KiG;
      if (((TalkRoomPopupNav)localObject).JLA.getVisibility() == 0)
      {
        ((TalkRoomPopupNav)localObject).xz(false);
        ((TalkRoomPopupNav)localObject).JLA.setVisibility(8);
      }
    }
    if (this.KiH != null)
    {
      localObject = this.KiH;
      if ((((MultiTalkRoomPopupNav)localObject).JyT != null) && (((MultiTalkRoomPopupNav)localObject).JyT.Jzc != null) && (((MultiTalkRoomPopupNav)localObject).JyT.Jzc.getVisibility() == 0))
      {
        ((MultiTalkRoomPopupNav)localObject).JyT.close();
        ((MultiTalkRoomPopupNav)localObject).JyT.Jzc.setVisibility(8);
      }
    }
    if (this.JuW != null)
    {
      localObject = this.JuW;
      if (((LiveTalkRoomTipsBar)localObject).JuJ.getVisibility() == 0)
      {
        ((LiveTalkRoomTipsBar)localObject).aS(true, false);
        ((LiveTalkRoomTipsBar)localObject).JuJ.setVisibility(8);
      }
    }
    paramRunnable.run();
    AppMethodBeat.o(35667);
  }
  
  public final void aWR(String paramString)
  {
    AppMethodBeat.i(187410);
    if ((this.cXJ != null) && (paramString.equals(this.cXJ.getTalkerUserName()))) {
      ye(false);
    }
    AppMethodBeat.o(187410);
  }
  
  public final void aXK(String paramString)
  {
    AppMethodBeat.i(35678);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.cXJ.fJy());
    localIntent.putExtra("map_talker_name", this.cXJ.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35678);
  }
  
  public final void asy(String paramString)
  {
    AppMethodBeat.i(35670);
    if ((this.cXJ != null) && (paramString.equals(this.cXJ.getTalkerUserName()))) {
      ye(false);
    }
    AppMethodBeat.o(35670);
  }
  
  public final void cV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35677);
    if ((com.tencent.mm.r.a.ch(this.cXJ.Kkd.getContext())) || (com.tencent.mm.r.a.cf(this.cXJ.Kkd.getContext())) || (com.tencent.mm.r.a.cj(this.cXJ.Kkd.getContext())))
    {
      ae.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(35677);
      return;
    }
    if (((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.Hm(this.cXJ.Cqh.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bi.d.iuo.Hl(this.cXJ.Cqh.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.cXJ.fJy())))
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.KiG.setDialogContent(this.cXJ.Kkd.getMMResources().getString(2131758427));
        this.KiG.H(paramString, localLinkedList);
        AppMethodBeat.o(35677);
        return;
      }
    }
    aXK(paramString);
    AppMethodBeat.o(35677);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35681);
    ae.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.a(this);
    }
    if (com.tencent.mm.bi.d.iuo != null) {
      com.tencent.mm.bi.d.iuo.a(this);
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).a(this);
    }
    p.a(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.pmW);
    ye(true);
    AppMethodBeat.o(35681);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35682);
    ae.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.b(this);
    }
    if (com.tencent.mm.bi.d.iuo != null) {
      com.tencent.mm.bi.d.iuo.b(this);
    }
    p.b(this);
    com.tencent.mm.sdk.b.a.IvT.d(this.pmW);
    ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).b(this);
    AppMethodBeat.o(35682);
  }
  
  public final void fAx() {}
  
  public final void fAy()
  {
    AppMethodBeat.i(187413);
    if (this.JuW != null)
    {
      this.JuW.aS(true, false);
      if (this.JuW.JuH != null) {
        p.fAO();
      }
    }
    fJd();
    AppMethodBeat.o(187413);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35680);
    super.fGE();
    if (this.KiG != null) {
      this.KiG.stop();
    }
    AppMethodBeat.o(35680);
  }
  
  public final boolean fIX()
  {
    AppMethodBeat.i(35664);
    if (this.KiG == null)
    {
      AppMethodBeat.o(35664);
      return false;
    }
    if (this.KiG.getVisibility() == 0)
    {
      AppMethodBeat.o(35664);
      return true;
    }
    AppMethodBeat.o(35664);
    return false;
  }
  
  public final boolean fIY()
  {
    AppMethodBeat.i(35665);
    if (this.KiH == null)
    {
      AppMethodBeat.o(35665);
      return false;
    }
    if (this.KiH.getVisibility() == 0)
    {
      AppMethodBeat.o(35665);
      return true;
    }
    AppMethodBeat.o(35665);
    return false;
  }
  
  public final boolean fIZ()
  {
    AppMethodBeat.i(187409);
    if (this.JuW == null)
    {
      AppMethodBeat.o(187409);
      return false;
    }
    if (this.JuW.getVisibility() == 0)
    {
      AppMethodBeat.o(187409);
      return true;
    }
    AppMethodBeat.o(187409);
    return false;
  }
  
  public final int fJa()
  {
    AppMethodBeat.i(35666);
    if (this.KiG == null)
    {
      AppMethodBeat.o(35666);
      return 0;
    }
    int i = this.KiG.getHeight();
    AppMethodBeat.o(35666);
    return i;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35668);
    if ((this.cXJ != null) && (paramString1.equals(this.cXJ.getTalkerUserName()))) {
      ye(false);
    }
    AppMethodBeat.o(35668);
  }
  
  public final void yf(final boolean paramBoolean)
  {
    AppMethodBeat.i(35675);
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.f.class)).fHc()) || (((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGP())) {}
    for (int i = 1; (x.wb(this.cXJ.getTalkerUserName())) && (i == 0); i = 0)
    {
      h.c(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131764356), null, true);
      AppMethodBeat.o(35675);
      return;
    }
    Object localObject = new wq();
    ((wq)localObject).dMc.dMe = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.Hm(this.cXJ.Cqh.field_username)))
      {
        localObject = com.tencent.mm.bi.d.iuo.Hl(this.cXJ.Cqh.field_username);
        if ((localObject != null) && (((List)localObject).contains(this.cXJ.fJy()))) {
          localObject = this.cXJ.Kkd.getMMResources().getString(2131764351);
        }
        for (i = 2131758424;; i = 2131760576)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this.cXJ.Kkd.getContext());
          locala.aZi((String)localObject);
          locala.afU(2131755691).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35659);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35659);
            }
          });
          locala.afV(i).d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35660);
              ba localba = ba.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localba.aXK(paramAnonymousDialogInterface);
                AppMethodBeat.o(35660);
                return;
              }
            }
          });
          locala.fQv().show();
          AppMethodBeat.o(35675);
          return;
          localObject = this.cXJ.Kkd.getMMResources().getString(2131764352);
        }
      }
      if ((!bu.isNullOrNil(((wq)localObject).dMd.dMg)) && (!this.cXJ.getTalkerUserName().equals(((wq)localObject).dMd.dMg)))
      {
        h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35661);
            paramAnonymousDialogInterface = new wq();
            paramAnonymousDialogInterface.dMc.dMf = true;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
            ba.a(ba.this, ba.this.cXJ.getTalkerUserName());
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
      aXL(this.cXJ.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((bu.isNullOrNil(((wq)localObject).dMd.dMg)) || (this.cXJ.getTalkerUserName().equals(((wq)localObject).dMd.dMg)))
    {
      aXL(this.cXJ.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((this.KiG == null) || (this.KiG.getVisibility() != 0)) {
      h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35651);
          paramAnonymousDialogInterface = new wq();
          paramAnonymousDialogInterface.dMc.dMf = true;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
          ba.a(ba.this, ba.this.cXJ.getTalkerUserName());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ba
 * JD-Core Version:    0.7.0.1
 */