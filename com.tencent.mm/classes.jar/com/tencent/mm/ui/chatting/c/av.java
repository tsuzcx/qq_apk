package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.model.a.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.LiveTalkRoomTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.a;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ak.class)
public class av
  extends a
  implements com.tencent.mm.bh.a, com.tencent.mm.bi.c, a.a, ak, p.a
{
  private final k.a HSK;
  public TalkRoomPopupNav HYD;
  public MultiTalkRoomPopupNav HYE;
  private View HYF;
  private TalkRoomPopupNav.a HYG;
  public LiveTalkRoomTipsBar HmH;
  private com.tencent.mm.sdk.b.c oCV;
  
  public av()
  {
    AppMethodBeat.i(35663);
    this.HSK = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35650);
        ac.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (!bs.isNullOrNil(paramAnonymousString)) {
          av.a(av.this);
        }
        AppMethodBeat.o(35650);
      }
    };
    this.oCV = new com.tencent.mm.sdk.b.c() {};
    this.HYG = new TalkRoomPopupNav.a()
    {
      public final void aPL(String paramAnonymousString)
      {
        AppMethodBeat.i(196510);
        av.this.aQq(paramAnonymousString);
        AppMethodBeat.o(196510);
      }
      
      public final void fjg()
      {
        AppMethodBeat.i(35657);
        if ((com.tencent.mm.r.a.ci(av.this.cLy.HZF.getContext())) || (com.tencent.mm.r.a.cf(av.this.cLy.HZF.getContext())) || (com.tencent.mm.r.a.ck(av.this.cLy.HZF.getContext())))
        {
          ac.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
          AppMethodBeat.o(35657);
          return;
        }
        ac.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(com.tencent.mm.bi.d.hXY.DE(av.this.cLy.AzG.field_username).size()) });
        if (com.tencent.mm.bi.d.hXY.DF(av.this.cLy.AzG.field_username))
        {
          av.b(av.this);
          AppMethodBeat.o(35657);
          return;
        }
        av.this.xm(true);
        AppMethodBeat.o(35657);
      }
    };
    AppMethodBeat.o(35663);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(35671);
    if (this.HYD == null)
    {
      j.a(this.cLy.HZF, 2131306446);
      this.HYD = ((TalkRoomPopupNav)this.cLy.findViewById(2131305650));
      this.HYF = this.cLy.findViewById(2131308033);
      this.HYD.setRootTipsBarBackground(this.HYF);
      this.HYD.setChattingContext(this.cLy);
      if (this.HYD == null)
      {
        AppMethodBeat.o(35671);
        return;
      }
    }
    if (this.HYD != null) {
      this.HYD.setOnClickListener(parama);
    }
    AppMethodBeat.o(35671);
  }
  
  private void aQr(String paramString)
  {
    AppMethodBeat.i(35679);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(35679);
  }
  
  private void fou()
  {
    AppMethodBeat.i(35672);
    if (this.HYE == null)
    {
      this.HYF = this.cLy.findViewById(2131308033);
      j.a(this.cLy.HZF, 2131306444);
      this.HYE = ((MultiTalkRoomPopupNav)this.cLy.findViewById(2131302589));
      this.HYE.setRootTipsBarBackground(this.HYF);
      this.HYE.setChattingContext(this.cLy);
    }
    AppMethodBeat.o(35672);
  }
  
  private void fov()
  {
    AppMethodBeat.i(196513);
    if (this.HmH == null)
    {
      this.HYF = this.cLy.findViewById(2131308033);
      j.a(this.cLy.HZF, 2131308062);
      this.HmH = ((LiveTalkRoomTipsBar)this.cLy.findViewById(2131307787));
      LiveTalkRoomTipsBar localLiveTalkRoomTipsBar = this.HmH;
      if (localLiveTalkRoomTipsBar.Hms == null) {
        localLiveTalkRoomTipsBar.Hms = new p(localLiveTalkRoomTipsBar);
      }
      if (localLiveTalkRoomTipsBar.HmB != null) {
        localLiveTalkRoomTipsBar.HmB.setAdapter(localLiveTalkRoomTipsBar.Hms.HmJ);
      }
      this.HmH.setRootTipsBarBackground(this.HYF);
      this.HmH.setChattingUserName(this.cLy.getTalkerUserName());
    }
    AppMethodBeat.o(196513);
  }
  
  private void fow()
  {
    AppMethodBeat.i(35674);
    if (this.HYD != null)
    {
      this.HYD.setVisibility(8);
      this.HYD.fjf();
      this.HYD.fje();
      this.HYD.stop();
      ((x)this.cLy.bf(x.class)).aaY(-1);
    }
    if (this.HYE != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amk(this.cLy.getTalkerUserName())) {
        this.HYE.fhl();
      }
      this.HYE.setVisibility(8);
      ((x)this.cLy.bf(x.class)).aaY(-1);
    }
    if (this.HmH != null)
    {
      this.HmH.setVisibility(8);
      if (this.HYF != null) {
        this.HYF.setVisibility(8);
      }
      this.cLy.HZF.getController().showActionbarLine();
      if ((this.HYD == null) && (this.HYE == null)) {
        ((x)this.cLy.bf(x.class)).aaY(-1);
      }
    }
    AppMethodBeat.o(35674);
  }
  
  private void fox()
  {
    AppMethodBeat.i(196514);
    if (this.HmH != null) {
      this.HmH.setChattingUserName(this.cLy.getTalkerUserName());
    }
    AppMethodBeat.o(196514);
  }
  
  private void foy()
  {
    AppMethodBeat.i(35676);
    cM("fromBanner", false);
    AppMethodBeat.o(35676);
  }
  
  private void xl(boolean paramBoolean)
  {
    AppMethodBeat.i(35673);
    ac.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s, stacks: %s", new Object[] { Boolean.valueOf(paramBoolean), bs.eWi().toString() });
    if (this.cLy == null)
    {
      ac.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(35673);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.c.b.f)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.f.class)).fmH()) || (((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmu())) {}
    for (boolean bool = true; (w.sQ(this.cLy.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.HYD != null)
      {
        this.HYD.setVisibility(8);
        this.HYD.fjf();
        ((x)this.cLy.bf(x.class)).aaY(-1);
      }
      if (this.HYE != null)
      {
        this.HYE.setInChatRoom(false);
        this.HYE.setVisibility(8);
      }
      if (this.HmH != null)
      {
        this.HmH.setInChatRoom(false);
        this.HmH.setVisibility(8);
        if (this.HYF != null) {
          this.HYF.setVisibility(8);
        }
        this.cLy.HZF.getController().showActionbarLine();
        ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().vb(this.cLy.getTalkerUserName());
        ((x)this.cLy.bf(x.class)).aaY(-1);
      }
      AppMethodBeat.o(35673);
      return;
    }
    fow();
    fox();
    LinkedList localLinkedList;
    Object localObject;
    if ((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.DF(this.cLy.AzG.field_username)))
    {
      a(this.HYG);
      if (this.HYD == null)
      {
        AppMethodBeat.o(35673);
        return;
      }
      localLinkedList = com.tencent.mm.bi.d.hXY.DE(this.cLy.AzG.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.cLy.foM())))
      {
        this.HYD.setBgViewResource(2131234968);
        localObject = this.cLy.HZF.getMMResources().getString(2131764527);
        this.HYD.cL();
        this.HYD.hC(localLinkedList);
        this.HYD.setVisibility(0);
        this.HYD.setNavContent((String)localObject);
        ((x)this.cLy.bf(x.class)).aaY(1);
        AppMethodBeat.o(35673);
        return;
      }
      this.HYD.fje();
      this.HYD.stop();
      this.HYD.setBgViewResource(2131234968);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.cLy.HZF.getMMResources().getString(2131764526, new Object[] { v.wk((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.HYD.setIconRes$255f295(this.cLy.HZF.getMMResources().getColor(2131099699));
        break;
        if (localLinkedList != null) {
          localObject = this.cLy.HZF.getMMResources().getString(2131764528, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((com.tencent.mm.bh.g.hXW == null) || (!com.tencent.mm.bh.g.hXW.DC(this.cLy.getTalkerUserName())))
    {
      if (w.sQ(this.cLy.getTalkerUserName()))
      {
        localObject = ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).aml(this.cLy.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.bh.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bh.f)localObject).field_wxGroupId.equals(this.cLy.getTalkerUserName())))
        {
          fou();
          if (this.HYE != null)
          {
            ac.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
            this.HYE.setGroupUserName(this.cLy.getTalkerUserName());
            this.HYE.setCurrentSenderUserName(this.cLy.foM());
            this.HYE.setInChatRoom(bool);
            this.HYE.wG(paramBoolean);
            this.HYE.setMultiTalkInfo((com.tencent.mm.bh.f)localObject);
            ((x)this.cLy.bf(x.class)).aaY(1);
            AppMethodBeat.o(35673);
          }
        }
        else
        {
          localObject = this.cLy.getTalkerUserName();
          localLinkedList = p.aPz((String)localObject);
          if ((localLinkedList != null) && (localLinkedList.size() > 0))
          {
            fov();
            if (this.HmH != null)
            {
              ac.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", new Object[] { localObject, Integer.valueOf(localLinkedList.size()) });
              this.cLy.HZF.getController().hideActionbarLine();
              this.HmH.setInChatRoom(bool);
              this.HmH.setChattingContext(this.cLy);
              this.HmH.fgz();
              ((x)this.cLy.bf(x.class)).aaY(1);
            }
          }
        }
        AppMethodBeat.o(35673);
        return;
      }
      fow();
    }
    AppMethodBeat.o(35673);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(35669);
    if ((this.cLy != null) && (paramString.equals(this.cLy.getTalkerUserName()))) {
      xl(false);
    }
    AppMethodBeat.o(35669);
  }
  
  public final void aI(final Runnable paramRunnable)
  {
    AppMethodBeat.i(35667);
    if ((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.bw(this.cLy.AzG.field_username, this.cLy.foM())))
    {
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131764523), this.cLy.HZF.getMMResources().getString(2131755906), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35656);
          paramRunnable.run();
          paramAnonymousDialogInterface = new fh();
          paramAnonymousDialogInterface.dfa.username = av.this.cLy.getTalkerUserName();
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
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
    if (this.HYD != null)
    {
      localObject = this.HYD;
      if (((TalkRoomPopupNav)localObject).HCW.getVisibility() == 0)
      {
        ((TalkRoomPopupNav)localObject).wF(false);
        ((TalkRoomPopupNav)localObject).HCW.setVisibility(8);
      }
    }
    if (this.HYE != null)
    {
      localObject = this.HYE;
      if ((((MultiTalkRoomPopupNav)localObject).HqC != null) && (((MultiTalkRoomPopupNav)localObject).HqC.HqL != null) && (((MultiTalkRoomPopupNav)localObject).HqC.HqL.getVisibility() == 0))
      {
        ((MultiTalkRoomPopupNav)localObject).HqC.close();
        ((MultiTalkRoomPopupNav)localObject).HqC.HqL.setVisibility(8);
      }
    }
    paramRunnable.run();
    AppMethodBeat.o(35667);
  }
  
  public final void aPA(String paramString)
  {
    AppMethodBeat.i(196512);
    if ((this.cLy != null) && (paramString.equals(this.cLy.getTalkerUserName()))) {
      xl(false);
    }
    AppMethodBeat.o(196512);
  }
  
  public final void aQq(String paramString)
  {
    AppMethodBeat.i(35678);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.cLy.foM());
    localIntent.putExtra("map_talker_name", this.cLy.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35678);
  }
  
  public final void amu(String paramString)
  {
    AppMethodBeat.i(35670);
    if ((this.cLy != null) && (paramString.equals(this.cLy.getTalkerUserName()))) {
      xl(false);
    }
    AppMethodBeat.o(35670);
  }
  
  public final void cM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35677);
    if ((com.tencent.mm.r.a.ci(this.cLy.HZF.getContext())) || (com.tencent.mm.r.a.cf(this.cLy.HZF.getContext())) || (com.tencent.mm.r.a.ck(this.cLy.HZF.getContext())))
    {
      ac.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(35677);
      return;
    }
    if (((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.DF(this.cLy.AzG.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bi.d.hXY.DE(this.cLy.AzG.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.cLy.foM())))
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.HYD.setDialogContent(this.cLy.HZF.getMMResources().getString(2131758427));
        this.HYD.E(paramString, localLinkedList);
        AppMethodBeat.o(35677);
        return;
      }
    }
    aQq(paramString);
    AppMethodBeat.o(35677);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35681);
    ac.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.a(this);
    }
    if (com.tencent.mm.bi.d.hXY != null) {
      com.tencent.mm.bi.d.hXY.a(this);
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).a(this);
    }
    p.a(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.oCV);
    xl(true);
    AppMethodBeat.o(35681);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35682);
    ac.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.b(this);
    }
    if (com.tencent.mm.bi.d.hXY != null) {
      com.tencent.mm.bi.d.hXY.b(this);
    }
    p.b(this);
    com.tencent.mm.sdk.b.a.GpY.d(this.oCV);
    ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).b(this);
    AppMethodBeat.o(35682);
  }
  
  public final void fgl() {}
  
  public final void fgm()
  {
    AppMethodBeat.i(196515);
    if (this.HmH != null) {
      this.HmH.setTipsBarLayout(true);
    }
    fow();
    AppMethodBeat.o(196515);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35680);
    super.fmj();
    if (this.HYD != null) {
      this.HYD.stop();
    }
    AppMethodBeat.o(35680);
  }
  
  public final boolean foq()
  {
    AppMethodBeat.i(35664);
    if (this.HYD == null)
    {
      AppMethodBeat.o(35664);
      return false;
    }
    if (this.HYD.getVisibility() == 0)
    {
      AppMethodBeat.o(35664);
      return true;
    }
    AppMethodBeat.o(35664);
    return false;
  }
  
  public final boolean jdMethod_for()
  {
    AppMethodBeat.i(35665);
    if (this.HYE == null)
    {
      AppMethodBeat.o(35665);
      return false;
    }
    if (this.HYE.getVisibility() == 0)
    {
      AppMethodBeat.o(35665);
      return true;
    }
    AppMethodBeat.o(35665);
    return false;
  }
  
  public final boolean fos()
  {
    AppMethodBeat.i(196511);
    if (this.HmH == null)
    {
      AppMethodBeat.o(196511);
      return false;
    }
    if (this.HmH.getVisibility() == 0)
    {
      AppMethodBeat.o(196511);
      return true;
    }
    AppMethodBeat.o(196511);
    return false;
  }
  
  public final int fot()
  {
    AppMethodBeat.i(35666);
    if (this.HYD == null)
    {
      AppMethodBeat.o(35666);
      return 0;
    }
    int i = this.HYD.getHeight();
    AppMethodBeat.o(35666);
    return i;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35668);
    if ((this.cLy != null) && (paramString1.equals(this.cLy.getTalkerUserName()))) {
      xl(false);
    }
    AppMethodBeat.o(35668);
  }
  
  public final void xm(final boolean paramBoolean)
  {
    AppMethodBeat.i(35675);
    if ((((com.tencent.mm.ui.chatting.c.b.f)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.f.class)).fmH()) || (((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmu())) {}
    for (int i = 1; (w.sQ(this.cLy.getTalkerUserName())) && (i == 0); i = 0)
    {
      com.tencent.mm.ui.base.h.c(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131764356), null, true);
      AppMethodBeat.o(35675);
      return;
    }
    Object localObject = new vt();
    ((vt)localObject).dyB.dyD = true;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.DF(this.cLy.AzG.field_username)))
      {
        localObject = com.tencent.mm.bi.d.hXY.DE(this.cLy.AzG.field_username);
        if ((localObject != null) && (((List)localObject).contains(this.cLy.foM()))) {
          localObject = this.cLy.HZF.getMMResources().getString(2131764351);
        }
        for (i = 2131758424;; i = 2131760576)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          d.a locala = new d.a(this.cLy.HZF.getContext());
          locala.aRI((String)localObject);
          locala.acM(2131755691).b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35659);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35659);
            }
          });
          locala.acN(i).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35660);
              av localav = av.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localav.aQq(paramAnonymousDialogInterface);
                AppMethodBeat.o(35660);
                return;
              }
            }
          });
          locala.fvp().show();
          AppMethodBeat.o(35675);
          return;
          localObject = this.cLy.HZF.getMMResources().getString(2131764352);
        }
      }
      if ((!bs.isNullOrNil(((vt)localObject).dyC.dyF)) && (!this.cLy.getTalkerUserName().equals(((vt)localObject).dyC.dyF)))
      {
        com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35661);
            paramAnonymousDialogInterface = new vt();
            paramAnonymousDialogInterface.dyB.dyE = true;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
            av.a(av.this, av.this.cLy.getTalkerUserName());
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
      aQr(this.cLy.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((bs.isNullOrNil(((vt)localObject).dyC.dyF)) || (this.cLy.getTalkerUserName().equals(((vt)localObject).dyC.dyF)))
    {
      aQr(this.cLy.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((this.HYD == null) || (this.HYD.getVisibility() != 0)) {
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35651);
          paramAnonymousDialogInterface = new vt();
          paramAnonymousDialogInterface.dyB.dyE = true;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
          av.a(av.this, av.this.cLy.getTalkerUserName());
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
 * Qualified Name:     com.tencent.mm.ui.chatting.c.av
 * JD-Core Version:    0.7.0.1
 */