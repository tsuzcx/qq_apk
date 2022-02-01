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
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.LiveTalkRoomTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.a;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.z;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ao.class)
public class az
  extends a
  implements com.tencent.mm.bi.a, com.tencent.mm.bj.c, com.tencent.mm.plugin.multitalk.model.d.a, ao, p.a
{
  private final k.a JGU;
  public TalkRoomPopupNav JNJ;
  public MultiTalkRoomPopupNav JNK;
  private View JNL;
  private TalkRoomPopupNav.a JNM;
  public LiveTalkRoomTipsBar Jao;
  private com.tencent.mm.sdk.b.c pgq;
  
  public az()
  {
    AppMethodBeat.i(35663);
    this.JGU = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35650);
        ad.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (!bt.isNullOrNil(paramAnonymousString)) {
          az.a(az.this);
        }
        AppMethodBeat.o(35650);
      }
    };
    this.pgq = new com.tencent.mm.sdk.b.c() {};
    this.JNM = new TalkRoomPopupNav.a()
    {
      public final void aVB(String paramAnonymousString)
      {
        AppMethodBeat.i(194096);
        if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
        {
          if ((com.tencent.mm.pluginsdk.permission.b.n(az.this.cWM.JOR.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n(az.this.cWM.JOR.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label258;
            }
            if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEr, Boolean.FALSE)).booleanValue()) {
              break;
            }
            com.tencent.mm.plugin.account.a.b.a.b(az.this.cWM.JOR.getContext(), az.this.cWM.JOR.getMMResources().getString(2131760740, new Object[] { ac.fks() }), 30762, true);
            AppMethodBeat.o(194096);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.a(az.this.cWM.JOR.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
          AppMethodBeat.o(194096);
          return;
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(az.this.cWM.JOR.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68, null, null);
        ad.d("MicroMsg.ChattingUI.TrackRoomComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(194096);
          return;
        }
        label258:
        az.this.aWj(paramAnonymousString);
        AppMethodBeat.o(194096);
      }
      
      public final void fzv()
      {
        AppMethodBeat.i(35657);
        if ((com.tencent.mm.s.a.cf(az.this.cWM.JOR.getContext())) || (com.tencent.mm.s.a.cd(az.this.cWM.JOR.getContext())) || (com.tencent.mm.s.a.ch(az.this.cWM.JOR.getContext())))
        {
          ad.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
          AppMethodBeat.o(35657);
          return;
        }
        ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(com.tencent.mm.bj.d.iru.GJ(az.this.cWM.BYG.field_username).size()) });
        if (com.tencent.mm.bj.d.iru.GK(az.this.cWM.BYG.field_username))
        {
          az.b(az.this);
          AppMethodBeat.o(35657);
          return;
        }
        az.this.xY(true);
        AppMethodBeat.o(35657);
      }
    };
    AppMethodBeat.o(35663);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(35671);
    if (this.JNJ == null)
    {
      l.a(this.cWM.JOR, 2131306446);
      this.JNJ = ((TalkRoomPopupNav)this.cWM.findViewById(2131305650));
      this.JNL = this.cWM.findViewById(2131308033);
      this.JNJ.setRootTipsBarBackground(this.JNL);
      this.JNJ.setChattingContext(this.cWM);
      if (this.JNJ == null)
      {
        AppMethodBeat.o(35671);
        return;
      }
    }
    if (this.JNJ != null) {
      this.JNJ.setOnClickListener(parama);
    }
    AppMethodBeat.o(35671);
  }
  
  private void aWk(String paramString)
  {
    AppMethodBeat.i(35679);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(35679);
  }
  
  private void fEY()
  {
    AppMethodBeat.i(35672);
    if (this.JNK == null)
    {
      this.JNL = this.cWM.findViewById(2131308033);
      l.a(this.cWM.JOR, 2131306444);
      this.JNK = ((MultiTalkRoomPopupNav)this.cWM.findViewById(2131302589));
      this.JNK.setRootTipsBarBackground(this.JNL);
      this.JNK.setChattingContext(this.cWM);
    }
    AppMethodBeat.o(35672);
  }
  
  private void fEZ()
  {
    AppMethodBeat.i(194099);
    if (this.Jao == null)
    {
      this.JNL = this.cWM.findViewById(2131308033);
      l.a(this.cWM.JOR, 2131308062);
      this.Jao = ((LiveTalkRoomTipsBar)this.cWM.findViewById(2131307787));
      LiveTalkRoomTipsBar localLiveTalkRoomTipsBar = this.Jao;
      if (localLiveTalkRoomTipsBar.IZZ == null) {
        localLiveTalkRoomTipsBar.IZZ = new p(localLiveTalkRoomTipsBar);
      }
      if (localLiveTalkRoomTipsBar.Jah != null) {
        localLiveTalkRoomTipsBar.Jah.setAdapter(localLiveTalkRoomTipsBar.IZZ.Jaq);
      }
      this.Jao.setRootTipsBarBackground(this.JNL);
      this.Jao.setChattingUserName(this.cWM.getTalkerUserName());
    }
    AppMethodBeat.o(194099);
  }
  
  private void fFa()
  {
    AppMethodBeat.i(35674);
    if (this.JNJ != null)
    {
      this.JNJ.setVisibility(8);
      this.JNJ.fzu();
      this.JNJ.fzt();
      this.JNJ.stop();
      ((z)this.cWM.bh(z.class)).adk(-1);
    }
    if (this.JNK != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arg(this.cWM.getTalkerUserName())) {
        this.JNK.fxx();
      }
      this.JNK.setVisibility(8);
      ((z)this.cWM.bh(z.class)).adk(-1);
    }
    if (this.Jao != null)
    {
      this.Jao.setVisibility(8);
      if (this.JNL != null) {
        this.JNL.setVisibility(8);
      }
      this.cWM.JOR.getController().showActionbarLine();
      if ((this.JNJ == null) && (this.JNK == null)) {
        ((z)this.cWM.bh(z.class)).adk(-1);
      }
    }
    AppMethodBeat.o(35674);
  }
  
  private void fFb()
  {
    AppMethodBeat.i(194100);
    if (this.Jao != null) {
      this.Jao.setChattingUserName(this.cWM.getTalkerUserName());
    }
    AppMethodBeat.o(194100);
  }
  
  private void fFc()
  {
    AppMethodBeat.i(35676);
    cR("fromBanner", false);
    AppMethodBeat.o(35676);
  }
  
  private void xX(boolean paramBoolean)
  {
    AppMethodBeat.i(35673);
    ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s, stacks: %s", new Object[] { Boolean.valueOf(paramBoolean), bt.flS().toString() });
    if (this.cWM == null)
    {
      ad.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(35673);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.f.class)).fDa()) || (((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCN())) {}
    for (boolean bool = true; (w.vF(this.cWM.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.JNJ != null)
      {
        this.JNJ.setVisibility(8);
        this.JNJ.fzu();
        ((z)this.cWM.bh(z.class)).adk(-1);
      }
      if (this.JNK != null)
      {
        this.JNK.setInChatRoom(false);
        this.JNK.setVisibility(8);
      }
      if (this.Jao != null)
      {
        this.Jao.setInChatRoom(false);
        this.Jao.setVisibility(8);
        if (this.JNL != null) {
          this.JNL.setVisibility(8);
        }
        this.cWM.JOR.getController().showActionbarLine();
        ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().xR(this.cWM.getTalkerUserName());
        ((z)this.cWM.bh(z.class)).adk(-1);
      }
      AppMethodBeat.o(35673);
      return;
    }
    fFa();
    if (((af)this.cWM.bh(af.class)).fEz())
    {
      ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "isRecordSelect");
      AppMethodBeat.o(35673);
      return;
    }
    fFb();
    LinkedList localLinkedList;
    Object localObject;
    if ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.GK(this.cWM.BYG.field_username)))
    {
      a(this.JNM);
      if (this.JNJ == null)
      {
        AppMethodBeat.o(35673);
        return;
      }
      localLinkedList = com.tencent.mm.bj.d.iru.GJ(this.cWM.BYG.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.cWM.fFr())))
      {
        this.JNJ.setBgViewResource(2131234968);
        localObject = this.cWM.JOR.getMMResources().getString(2131764527);
        this.JNJ.updateView();
        this.JNJ.hO(localLinkedList);
        this.JNJ.setVisibility(0);
        this.JNJ.setNavContent((String)localObject);
        ((z)this.cWM.bh(z.class)).adk(1);
        AppMethodBeat.o(35673);
        return;
      }
      this.JNJ.fzt();
      this.JNJ.stop();
      this.JNJ.setBgViewResource(2131234968);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.cWM.JOR.getMMResources().getString(2131764526, new Object[] { v.zf((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.JNJ.setIconRes$255f295(this.cWM.JOR.getMMResources().getColor(2131099699));
        break;
        if (localLinkedList != null) {
          localObject = this.cWM.JOR.getMMResources().getString(2131764528, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((com.tencent.mm.bi.g.irs == null) || (!com.tencent.mm.bi.g.irs.GH(this.cWM.getTalkerUserName())))
    {
      if (w.vF(this.cWM.getTalkerUserName()))
      {
        localObject = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arh(this.cWM.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.bi.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bi.f)localObject).field_wxGroupId.equals(this.cWM.getTalkerUserName())))
        {
          fEY();
          if (this.JNK != null)
          {
            ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
            this.JNK.setGroupUserName(this.cWM.getTalkerUserName());
            this.JNK.setCurrentSenderUserName(this.cWM.fFr());
            this.JNK.setInChatRoom(bool);
            this.JNK.xs(paramBoolean);
            this.JNK.setMultiTalkInfo((com.tencent.mm.bi.f)localObject);
            ((z)this.cWM.bh(z.class)).adk(1);
            AppMethodBeat.o(35673);
          }
        }
        else
        {
          localObject = this.cWM.getTalkerUserName();
          localLinkedList = p.aVp((String)localObject);
          fEZ();
          if ((localLinkedList != null) && (localLinkedList.size() > 0) && (this.Jao != null))
          {
            ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", new Object[] { localObject, Integer.valueOf(localLinkedList.size()) });
            this.cWM.JOR.getController().hideActionbarLine();
            this.Jao.setInChatRoom(bool);
            this.Jao.setChattingContext(this.cWM);
            this.Jao.fwL();
            ((z)this.cWM.bh(z.class)).adk(1);
          }
        }
        AppMethodBeat.o(35673);
        return;
      }
      fFa();
    }
    AppMethodBeat.o(35673);
  }
  
  public final void GL(String paramString)
  {
    AppMethodBeat.i(35669);
    if ((this.cWM != null) && (paramString.equals(this.cWM.getTalkerUserName()))) {
      xX(false);
    }
    AppMethodBeat.o(35669);
  }
  
  public final void aG(final Runnable paramRunnable)
  {
    AppMethodBeat.i(35667);
    if ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.bx(this.cWM.BYG.field_username, this.cWM.fFr())))
    {
      h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131764523), this.cWM.JOR.getMMResources().getString(2131755906), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35656);
          paramRunnable.run();
          paramAnonymousDialogInterface = new fk();
          paramAnonymousDialogInterface.dqw.username = az.this.cWM.getTalkerUserName();
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
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
    if (this.JNJ != null)
    {
      localObject = this.JNJ;
      if (((TalkRoomPopupNav)localObject).JqL.getVisibility() == 0)
      {
        ((TalkRoomPopupNav)localObject).xr(false);
        ((TalkRoomPopupNav)localObject).JqL.setVisibility(8);
      }
    }
    if (this.JNK != null)
    {
      localObject = this.JNK;
      if ((((MultiTalkRoomPopupNav)localObject).Jei != null) && (((MultiTalkRoomPopupNav)localObject).Jei.Jer != null) && (((MultiTalkRoomPopupNav)localObject).Jei.Jer.getVisibility() == 0))
      {
        ((MultiTalkRoomPopupNav)localObject).Jei.close();
        ((MultiTalkRoomPopupNav)localObject).Jei.Jer.setVisibility(8);
      }
    }
    if (this.Jao != null)
    {
      localObject = this.Jao;
      if (((LiveTalkRoomTipsBar)localObject).Jab.getVisibility() == 0)
      {
        ((LiveTalkRoomTipsBar)localObject).aT(true, false);
        ((LiveTalkRoomTipsBar)localObject).Jab.setVisibility(8);
      }
    }
    paramRunnable.run();
    AppMethodBeat.o(35667);
  }
  
  public final void aVq(String paramString)
  {
    AppMethodBeat.i(194098);
    if ((this.cWM != null) && (paramString.equals(this.cWM.getTalkerUserName()))) {
      xX(false);
    }
    AppMethodBeat.o(194098);
  }
  
  public final void aWj(String paramString)
  {
    AppMethodBeat.i(35678);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.cWM.fFr());
    localIntent.putExtra("map_talker_name", this.cWM.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35678);
  }
  
  public final void arq(String paramString)
  {
    AppMethodBeat.i(35670);
    if ((this.cWM != null) && (paramString.equals(this.cWM.getTalkerUserName()))) {
      xX(false);
    }
    AppMethodBeat.o(35670);
  }
  
  public final void cR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35677);
    if ((com.tencent.mm.s.a.cf(this.cWM.JOR.getContext())) || (com.tencent.mm.s.a.cd(this.cWM.JOR.getContext())) || (com.tencent.mm.s.a.ch(this.cWM.JOR.getContext())))
    {
      ad.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(35677);
      return;
    }
    if (((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.GK(this.cWM.BYG.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bj.d.iru.GJ(this.cWM.BYG.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.cWM.fFr())))
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.JNJ.setDialogContent(this.cWM.JOR.getMMResources().getString(2131758427));
        this.JNJ.G(paramString, localLinkedList);
        AppMethodBeat.o(35677);
        return;
      }
    }
    aWj(paramString);
    AppMethodBeat.o(35677);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35680);
    super.fCC();
    if (this.JNJ != null) {
      this.JNJ.stop();
    }
    AppMethodBeat.o(35680);
  }
  
  public final boolean fEU()
  {
    AppMethodBeat.i(35664);
    if (this.JNJ == null)
    {
      AppMethodBeat.o(35664);
      return false;
    }
    if (this.JNJ.getVisibility() == 0)
    {
      AppMethodBeat.o(35664);
      return true;
    }
    AppMethodBeat.o(35664);
    return false;
  }
  
  public final boolean fEV()
  {
    AppMethodBeat.i(35665);
    if (this.JNK == null)
    {
      AppMethodBeat.o(35665);
      return false;
    }
    if (this.JNK.getVisibility() == 0)
    {
      AppMethodBeat.o(35665);
      return true;
    }
    AppMethodBeat.o(35665);
    return false;
  }
  
  public final boolean fEW()
  {
    AppMethodBeat.i(194097);
    if (this.Jao == null)
    {
      AppMethodBeat.o(194097);
      return false;
    }
    if (this.Jao.getVisibility() == 0)
    {
      AppMethodBeat.o(194097);
      return true;
    }
    AppMethodBeat.o(194097);
    return false;
  }
  
  public final int fEX()
  {
    AppMethodBeat.i(35666);
    if (this.JNJ == null)
    {
      AppMethodBeat.o(35666);
      return 0;
    }
    int i = this.JNJ.getHeight();
    AppMethodBeat.o(35666);
    return i;
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35681);
    ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.a(this);
    }
    if (com.tencent.mm.bj.d.iru != null) {
      com.tencent.mm.bj.d.iru.a(this);
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).a(this);
    }
    p.a(this);
    com.tencent.mm.sdk.b.a.IbL.c(this.pgq);
    xX(true);
    AppMethodBeat.o(35681);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35682);
    ad.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.b(this);
    }
    if (com.tencent.mm.bj.d.iru != null) {
      com.tencent.mm.bj.d.iru.b(this);
    }
    p.b(this);
    com.tencent.mm.sdk.b.a.IbL.d(this.pgq);
    ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).b(this);
    AppMethodBeat.o(35682);
  }
  
  public final void fwx() {}
  
  public final void fwy()
  {
    AppMethodBeat.i(194101);
    if (this.Jao != null) {
      this.Jao.aT(true, false);
    }
    fFa();
    AppMethodBeat.o(194101);
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35668);
    if ((this.cWM != null) && (paramString1.equals(this.cWM.getTalkerUserName()))) {
      xX(false);
    }
    AppMethodBeat.o(35668);
  }
  
  public final void xY(final boolean paramBoolean)
  {
    AppMethodBeat.i(35675);
    if ((((com.tencent.mm.ui.chatting.d.b.f)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.f.class)).fDa()) || (((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCN())) {}
    for (int i = 1; (w.vF(this.cWM.getTalkerUserName())) && (i == 0); i = 0)
    {
      h.c(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131764356), null, true);
      AppMethodBeat.o(35675);
      return;
    }
    Object localObject = new wm();
    ((wm)localObject).dKN.dKP = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.GK(this.cWM.BYG.field_username)))
      {
        localObject = com.tencent.mm.bj.d.iru.GJ(this.cWM.BYG.field_username);
        if ((localObject != null) && (((List)localObject).contains(this.cWM.fFr()))) {
          localObject = this.cWM.JOR.getMMResources().getString(2131764351);
        }
        for (i = 2131758424;; i = 2131760576)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this.cWM.JOR.getContext());
          locala.aXG((String)localObject);
          locala.afl(2131755691).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35659);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35659);
            }
          });
          locala.afm(i).d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35660);
              az localaz = az.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localaz.aWj(paramAnonymousDialogInterface);
                AppMethodBeat.o(35660);
                return;
              }
            }
          });
          locala.fMb().show();
          AppMethodBeat.o(35675);
          return;
          localObject = this.cWM.JOR.getMMResources().getString(2131764352);
        }
      }
      if ((!bt.isNullOrNil(((wm)localObject).dKO.dKR)) && (!this.cWM.getTalkerUserName().equals(((wm)localObject).dKO.dKR)))
      {
        h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35661);
            paramAnonymousDialogInterface = new wm();
            paramAnonymousDialogInterface.dKN.dKQ = true;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
            az.a(az.this, az.this.cWM.getTalkerUserName());
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
      aWk(this.cWM.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((bt.isNullOrNil(((wm)localObject).dKO.dKR)) || (this.cWM.getTalkerUserName().equals(((wm)localObject).dKO.dKR)))
    {
      aWk(this.cWM.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((this.JNJ == null) || (this.JNJ.getVisibility() != 0)) {
      h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131764346), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35651);
          paramAnonymousDialogInterface = new wm();
          paramAnonymousDialogInterface.dKN.dKQ = true;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
          az.a(az.this, az.this.cWM.getTalkerUserName());
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.az
 * JD-Core Version:    0.7.0.1
 */