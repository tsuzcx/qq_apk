package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.api.aa;
import com.tencent.mm.ba.f;
import com.tencent.mm.emoji.d.c.a;
import com.tencent.mm.g.a.s.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.viewitems.l.b;
import com.tencent.mm.ui.chatting.w;
import d.z;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=p.class)
public class s
  extends a
  implements p
{
  private com.tencent.mm.search.d.b ICV;
  private com.tencent.mm.sdk.b.c Kdz;
  
  public s()
  {
    AppMethodBeat.i(35286);
    this.Kdz = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35286);
  }
  
  private void a(final bv parambv, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35294);
    if ((!parambv.fvG()) && (!parambv.fvH()))
    {
      AppMethodBeat.o(35294);
      return;
    }
    Object localObject2 = bM(parambv);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35294);
      return;
    }
    parambv = com.tencent.mm.search.c.b.ICF;
    com.tencent.mm.search.c.b.E((EmojiInfo)localObject2);
    parambv = ((com.tencent.mm.ui.chatting.d.b.s)parama.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fHF();
    final int j = parambv.getCurrentScrollHeight();
    parambv.ZO(aa.bj(parama.Kkd.getContext()));
    Object localObject3 = (k)parama.bh(k.class);
    int i = ((k)localObject3).getCount() - 1;
    Object localObject1 = new cio();
    Object localObject4;
    Object localObject5;
    while ((i >= 0) && (((cio)localObject1).HuV.size() <= 20))
    {
      localObject4 = new cin();
      localObject5 = ((k)localObject3).adI(i);
      ((cin)localObject4).HuP = ((bv)localObject5).getType();
      ((cin)localObject4).HuQ = com.tencent.mm.ah.l.r((bv)localObject5);
      ((cin)localObject4).HuR = com.tencent.mm.ah.l.s((bv)localObject5);
      ((cin)localObject4).HuS = ((ei)localObject5).field_createTime;
      ((cin)localObject4).HuT = ((ei)localObject5).field_isSend;
      if (((bv)localObject5).fvG())
      {
        localObject5 = bM((bv)localObject5);
        if (localObject5 != null)
        {
          ((cin)localObject4).uvT = ((EmojiInfo)localObject5).field_md5;
          if (((EmojiInfo)localObject5).field_md5.equals(((EmojiInfo)localObject2).field_md5))
          {
            ((cin)localObject4).HuU = 1;
            ((cin)localObject4).GwI = ((EmojiInfo)localObject5).field_lensId;
          }
        }
      }
      i -= 1;
      ((cio)localObject1).HuV.add(localObject4);
    }
    ae.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", new Object[] { Integer.valueOf(((cio)localObject1).HuV.size()) });
    localObject3 = new w(parama, parama.Cqh, parama.getTalkerUserName());
    for (final boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDZ, true);; bool = false) {
      try
      {
        localObject2 = ((EmojiInfo)localObject2).field_md5;
        localObject4 = parama.getTalkerUserName();
        localObject5 = com.tencent.mm.search.c.b.ICF;
        localObject1 = new SimilarEmojiQueryModel((String)localObject2, (String)localObject4, com.tencent.mm.search.c.b.getTimestamp(), 3, parama.getTalkerUserName(), com.tencent.mm.bw.b.cm(((cio)localObject1).toByteArray()), bool, (com.tencent.mm.pluginsdk.ui.chat.j)localObject3);
        if (parambv.Fsg == 1)
        {
          bool = true;
          if (bool)
          {
            parambv.setIgnoreScroll(Boolean.TRUE);
            parambv.hideVKB();
          }
          this.ICV = null;
          this.ICV = new com.tencent.mm.search.d.b(parama.Kkd.getContext(), (SimilarEmojiQueryModel)localObject1, new d.g.a.a() {});
          parambv = this.ICV.getWindow();
          if (parambv != null)
          {
            parambv.setDimAmount(0.0F);
            parambv.setFlags(131072, 131072);
            parambv.setSoftInputMode(48);
          }
          this.ICV.show();
          AppMethodBeat.o(35294);
          return;
        }
      }
      catch (IOException parambv)
      {
        ae.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
        AppMethodBeat.o(35294);
        return;
      }
    }
  }
  
  private void bL(bv parambv)
  {
    AppMethodBeat.i(35292);
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContentView());
      AppMethodBeat.o(35292);
      return;
    }
    ae.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.cXJ.getTalkerUserName().equals("medianote"))
    {
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new f(parambv.field_talker, parambv.field_msgSvrId));
    }
    ak.bt(parambv);
    AppMethodBeat.o(35292);
  }
  
  private static EmojiInfo bM(bv parambv)
  {
    AppMethodBeat.i(35295);
    if (parambv.fvG())
    {
      parambv = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath);
      AppMethodBeat.o(35295);
      return parambv;
    }
    az localaz = az.aVt(parambv.field_content);
    parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
    if (parambv == null)
    {
      parambv = new k.b();
      parambv.hCE = localaz.md5;
    }
    for (;;)
    {
      if ((bu.isNullOrNil(parambv.hCE)) || (parambv.hCE.equals("-1")))
      {
        AppMethodBeat.o(35295);
        return null;
      }
      parambv = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.hCE);
      break;
    }
  }
  
  private void bu(bv parambv)
  {
    AppMethodBeat.i(35293);
    ae.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.cXJ.getTalkerUserName().equals("medianote"))
    {
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new f(parambv.field_talker, parambv.field_msgSvrId));
    }
    ak.bu(parambv);
    this.cXJ.xY(true);
    AppMethodBeat.o(35293);
  }
  
  public final boolean a(MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(35287);
    Object localObject1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35287);
      return false;
    case 104: 
      if ((parambv.fvG()) || (parambv.fvH()))
      {
        localObject1 = bM(parambv);
        if (localObject1 != null)
        {
          paramMenuItem = parambv.field_talker;
          if (!x.wb(paramMenuItem)) {
            break label1149;
          }
          paramMenuItem = bl.BM(parambv.field_content);
        }
      }
      break;
    }
    label523:
    label588:
    label718:
    label724:
    label1001:
    label1149:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject1).Lj(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.Kkd.getContext(), (EmojiInfo)localObject1, 0, paramMenuItem);
      AppMethodBeat.o(35287);
      return true;
      boolean bool = bK(parambv);
      AppMethodBeat.o(35287);
      return bool;
      if ((parambv.fvG()) || (parambv.fvH()))
      {
        am.d(parambv, parama.Kkd.getContext());
        AppMethodBeat.o(35287);
        return true;
      }
      AppMethodBeat.o(35287);
      return false;
      if ((parambv.fvG()) || (parambv.fvH()))
      {
        localObject1 = null;
        if (!parambv.fvG()) {
          break label523;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath);
        paramMenuItem = new c.a()
        {
          public final void dg(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(187329);
            LinkedList localLinkedList;
            if (paramAnonymousBoolean)
            {
              localLinkedList = new LinkedList();
              localLinkedList.add(this.hHv);
              if ((!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK()) && (!parama.fJB())) {
                break label90;
              }
            }
            label90:
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              com.tencent.mm.ui.chatting.l.a(parama.Kkd.getContext(), localLinkedList, paramAnonymousBoolean, parama.getTalkerUserName(), null);
              AppMethodBeat.o(187329);
              return;
            }
          }
        };
        if (localObject1 == null) {
          break label724;
        }
        new com.tencent.mm.emoji.d.c(parama.Kkd.getContext(), (EmojiInfo)localObject1, true, paramMenuItem);
        parama = parama.getTalkerUserName();
        paramMenuItem = parama;
        if (x.wb(parama)) {
          paramMenuItem = bl.BM(parambv.field_content);
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(1), ((EmojiInfo)localObject1).Lj(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, paramMenuItem, "", "", "", ((EmojiInfo)localObject1).field_activityid });
      }
      for (;;)
      {
        AppMethodBeat.o(35287);
        return true;
        Object localObject2 = parambv.field_content;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject2 != null)
        {
          localObject2 = k.b.aB((String)localObject2, parambv.field_reserved);
          paramMenuItem = (MenuItem)localObject1;
          if (localObject2 != null) {
            paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(((k.b)localObject2).hCE);
          }
        }
        if (paramMenuItem != null)
        {
          bool = true;
          ae.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from xml %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = paramMenuItem;
          if (paramMenuItem != null) {
            break;
          }
          localObject2 = az.aVt(parambv.field_content);
          localObject1 = paramMenuItem;
          if (!bu.isNullOrNil(((az)localObject2).md5))
          {
            localObject1 = paramMenuItem;
            if (!((az)localObject2).md5.equals("-1")) {
              localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(((az)localObject2).md5);
            }
          }
          if (localObject1 == null) {
            break label718;
          }
        }
        for (bool = true;; bool = false)
        {
          ae.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from content %s", new Object[] { Boolean.valueOf(bool) });
          break;
          bool = false;
          break label588;
        }
        if (parambv.fvH()) {
          paramMenuItem.dg(true);
        }
      }
      if (parambv.fvG())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath);
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(2), paramMenuItem.Lj(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label1001;
        }
      }
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!bu.isNullOrNil(paramMenuItem))
        {
          parambv = new Intent();
          parambv.putExtra("preceding_scence", 3);
          parambv.putExtra("download_entrance_scene", 16);
          parambv.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "emoji", ".ui.EmojiStoreDetailUI", parambv);
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          paramMenuItem = az.aVt(parambv.field_content);
        } while ((bu.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramMenuItem.md5);
        break;
      }
      paramMenuItem = bM(parambv);
      if (paramMenuItem != null)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(5), paramMenuItem.Lj(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        com.tencent.mm.plugin.emojicapture.api.b.x(parama.Kkd.getContext(), paramMenuItem.Lj(), parama.getTalkerUserName());
      }
      AppMethodBeat.o(35287);
      return true;
      a(parambv, parama);
      AppMethodBeat.o(35287);
      return true;
    }
  }
  
  public final boolean bK(bv parambv)
  {
    AppMethodBeat.i(35291);
    ae.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(parambv.field_msgId) });
    if (parambv.fvG())
    {
      bL(parambv);
      AppMethodBeat.o(35291);
      return true;
    }
    if (parambv.fvH())
    {
      bu(parambv);
      AppMethodBeat.o(35291);
      return true;
    }
    AppMethodBeat.o(35291);
    return false;
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35288);
    ae.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    com.tencent.mm.sdk.b.a.IvT.c(this.Kdz);
    AppMethodBeat.o(35288);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35289);
    ae.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    com.tencent.mm.sdk.b.a.IvT.d(this.Kdz);
    AppMethodBeat.o(35289);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35290);
    super.fGE();
    ae.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    com.tencent.mm.sdk.b.a.IvT.d(this.Kdz);
    AppMethodBeat.o(35290);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35296);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.ICV != null) && (this.ICV.isShowing()))
    {
      this.ICV.dismiss();
      this.ICV = null;
    }
    AppMethodBeat.o(35296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.s
 * JD-Core Version:    0.7.0.1
 */