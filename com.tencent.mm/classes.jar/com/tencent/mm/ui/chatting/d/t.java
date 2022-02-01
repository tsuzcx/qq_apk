package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.api.ad;
import com.tencent.mm.ba.f;
import com.tencent.mm.emoji.e.c.a;
import com.tencent.mm.g.a.u.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.viewitems.l.b;
import com.tencent.mm.ui.chatting.w;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=q.class)
public class t
  extends a
  implements q
{
  private com.tencent.mm.search.d.b NJK;
  private IListener Ppc;
  
  public t()
  {
    AppMethodBeat.i(35286);
    this.Ppc = new IListener() {};
    AppMethodBeat.o(35286);
  }
  
  private void a(ca paramca, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35294);
    if ((!paramca.gDn()) && (!paramca.gDo()))
    {
      AppMethodBeat.o(35294);
      return;
    }
    Object localObject2 = cc(paramca);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35294);
      return;
    }
    paramca = com.tencent.mm.search.c.b.NJx;
    com.tencent.mm.search.c.b.E((EmojiInfo)localObject2);
    paramca = ((com.tencent.mm.ui.chatting.d.b.u)parama.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
    int j = paramca.getCurrentScrollHeight();
    paramca.aiA(ad.bD(parama.Pwc.getContext()));
    Object localObject3 = (k)parama.bh(k.class);
    int i = ((k)localObject3).getCount() - 1;
    Object localObject1 = new cyv();
    Object localObject4;
    Object localObject5;
    while ((i >= 0) && (((cyv)localObject1).MDT.size() <= 20))
    {
      localObject4 = new cyu();
      localObject5 = ((k)localObject3).amt(i);
      ((cyu)localObject4).MDN = ((ca)localObject5).getType();
      ((cyu)localObject4).MDO = com.tencent.mm.ag.l.t((ca)localObject5);
      ((cyu)localObject4).MDP = com.tencent.mm.ag.l.u((ca)localObject5);
      ((cyu)localObject4).MDQ = ((eo)localObject5).field_createTime;
      ((cyu)localObject4).MDR = ((eo)localObject5).field_isSend;
      if (((ca)localObject5).gDn())
      {
        localObject5 = cc((ca)localObject5);
        if (localObject5 != null)
        {
          ((cyu)localObject4).xNU = ((EmojiInfo)localObject5).field_md5;
          if (((EmojiInfo)localObject5).field_md5.equals(((EmojiInfo)localObject2).field_md5))
          {
            ((cyu)localObject4).MDS = 1;
            ((cyu)localObject4).Lso = ((EmojiInfo)localObject5).field_lensId;
          }
        }
      }
      i -= 1;
      ((cyv)localObject1).MDT.add(localObject4);
    }
    Log.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", new Object[] { Integer.valueOf(((cyv)localObject1).MDT.size()) });
    localObject3 = new w(parama, parama.GUe, parama.getTalkerUserName());
    for (boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXe, true);; bool = false) {
      try
      {
        localObject2 = ((EmojiInfo)localObject2).field_md5;
        localObject4 = parama.getTalkerUserName();
        localObject5 = com.tencent.mm.search.c.b.NJx;
        localObject1 = new SimilarEmojiQueryModel("", (String)localObject2, (String)localObject4, com.tencent.mm.search.c.b.getTimestamp(), 3, parama.getTalkerUserName(), com.tencent.mm.bw.b.cD(((cyv)localObject1).toByteArray()), bool, (com.tencent.mm.pluginsdk.ui.chat.j)localObject3);
        if (paramca.KiY == 1)
        {
          bool = true;
          if (bool)
          {
            paramca.setIgnoreScroll(Boolean.TRUE);
            paramca.hideVKB();
          }
          this.NJK = null;
          this.NJK = new com.tencent.mm.search.d.b(parama.Pwc.getContext(), (SimilarEmojiQueryModel)localObject1, new t.3(this, bool, paramca, j));
          paramca = this.NJK.getWindow();
          if (paramca != null)
          {
            paramca.setDimAmount(0.0F);
            paramca.setFlags(131072, 131072);
            paramca.setSoftInputMode(48);
          }
          this.NJK.show();
          AppMethodBeat.o(35294);
          return;
        }
      }
      catch (IOException paramca)
      {
        Log.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
        AppMethodBeat.o(35294);
        return;
      }
    }
  }
  
  private void bJ(ca paramca)
  {
    AppMethodBeat.i(35293);
    Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.dom.getTalkerUserName().equals("medianote"))
    {
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new f(paramca.field_talker, paramca.field_msgSvrId));
    }
    ak.bJ(paramca);
    this.dom.BN(true);
    AppMethodBeat.o(35293);
  }
  
  private void cb(ca paramca)
  {
    AppMethodBeat.i(35292);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
      AppMethodBeat.o(35292);
      return;
    }
    Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.dom.getTalkerUserName().equals("medianote"))
    {
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new f(paramca.field_talker, paramca.field_msgSvrId));
    }
    ak.bI(paramca);
    AppMethodBeat.o(35292);
  }
  
  private static EmojiInfo cc(ca paramca)
  {
    AppMethodBeat.i(35295);
    if (paramca.gDn())
    {
      paramca = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath);
      AppMethodBeat.o(35295);
      return paramca;
    }
    be localbe = be.bkr(paramca.field_content);
    paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
    if (paramca == null)
    {
      paramca = new k.b();
      paramca.iwK = localbe.md5;
    }
    for (;;)
    {
      if ((Util.isNullOrNil(paramca.iwK)) || (paramca.iwK.equals("-1")))
      {
        AppMethodBeat.o(35295);
        return null;
      }
      paramca = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.iwK);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(35287);
    Object localObject1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35287);
      return false;
    case 104: 
      if ((paramca.gDn()) || (paramca.gDo()))
      {
        localObject1 = cc(paramca);
        if (localObject1 != null)
        {
          paramMenuItem = paramca.field_talker;
          if (!ab.Eq(paramMenuItem)) {
            break label1130;
          }
          paramMenuItem = bp.Ks(paramca.field_content);
        }
      }
      break;
    }
    label515:
    label580:
    label710:
    label716:
    label987:
    label1130:
    for (;;)
    {
      h.CyF.a(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
      ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.Pwc.getContext(), (EmojiInfo)localObject1, 0, paramMenuItem);
      AppMethodBeat.o(35287);
      return true;
      boolean bool = ca(paramca);
      AppMethodBeat.o(35287);
      return bool;
      if ((paramca.gDn()) || (paramca.gDo()))
      {
        an.d(paramca, parama.Pwc.getContext());
        AppMethodBeat.o(35287);
        return true;
      }
      AppMethodBeat.o(35287);
      return false;
      if ((paramca.gDn()) || (paramca.gDo()))
      {
        localObject1 = null;
        if (!paramca.gDn()) {
          break label515;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath);
        paramMenuItem = new c.a()
        {
          public final void dQ(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(233098);
            LinkedList localLinkedList;
            if (paramAnonymousBoolean)
            {
              localLinkedList = new LinkedList();
              localLinkedList.add(this.iBF);
              if ((!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()) && (!parama.gRL())) {
                break label90;
              }
            }
            label90:
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              com.tencent.mm.ui.chatting.l.a(parama.Pwc.getContext(), localLinkedList, paramAnonymousBoolean, parama.getTalkerUserName(), null);
              AppMethodBeat.o(233098);
              return;
            }
          }
        };
        if (localObject1 == null) {
          break label716;
        }
        new com.tencent.mm.emoji.e.c(parama.Pwc.getContext(), (EmojiInfo)localObject1, true, paramMenuItem);
        parama = parama.getTalkerUserName();
        paramMenuItem = parama;
        if (ab.Eq(parama)) {
          paramMenuItem = bp.Ks(paramca.field_content);
        }
        h.CyF.a(12789, new Object[] { Integer.valueOf(1), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, paramMenuItem, "", "", "", ((EmojiInfo)localObject1).field_activityid });
      }
      for (;;)
      {
        AppMethodBeat.o(35287);
        return true;
        Object localObject2 = paramca.field_content;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject2 != null)
        {
          localObject2 = k.b.aD((String)localObject2, paramca.field_reserved);
          paramMenuItem = (MenuItem)localObject1;
          if (localObject2 != null) {
            paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(((k.b)localObject2).iwK);
          }
        }
        if (paramMenuItem != null)
        {
          bool = true;
          Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from xml %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = paramMenuItem;
          if (paramMenuItem != null) {
            break;
          }
          localObject2 = be.bkr(paramca.field_content);
          localObject1 = paramMenuItem;
          if (!Util.isNullOrNil(((be)localObject2).md5))
          {
            localObject1 = paramMenuItem;
            if (!((be)localObject2).md5.equals("-1")) {
              localObject1 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(((be)localObject2).md5);
            }
          }
          if (localObject1 == null) {
            break label710;
          }
        }
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from content %s", new Object[] { Boolean.valueOf(bool) });
          break;
          bool = false;
          break label580;
        }
        if (paramca.gDo()) {
          paramMenuItem.dQ(true);
        }
      }
      if (paramca.gDn())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath);
        if (paramMenuItem != null) {
          h.CyF.a(12789, new Object[] { Integer.valueOf(2), paramMenuItem.getMd5(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label987;
        }
      }
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!Util.isNullOrNil(paramMenuItem))
        {
          paramca = new Intent();
          paramca.putExtra("preceding_scence", 3);
          paramca.putExtra("download_entrance_scene", 16);
          paramca.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramca);
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          paramMenuItem = be.bkr(paramca.field_content);
        } while ((Util.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramMenuItem.md5);
        break;
      }
      paramMenuItem = cc(paramca);
      if (paramMenuItem != null)
      {
        h.CyF.a(12789, new Object[] { Integer.valueOf(5), paramMenuItem.getMd5(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        com.tencent.mm.plugin.emojicapture.api.b.w(parama.Pwc.getContext(), paramMenuItem.getMd5(), parama.getTalkerUserName());
      }
      AppMethodBeat.o(35287);
      return true;
      a(paramca, parama);
      AppMethodBeat.o(35287);
      return true;
    }
  }
  
  public final boolean ca(ca paramca)
  {
    AppMethodBeat.i(35291);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(paramca.field_msgId) });
    if (paramca.gDn())
    {
      cb(paramca);
      AppMethodBeat.o(35291);
      return true;
    }
    if (paramca.gDo())
    {
      bJ(paramca);
      AppMethodBeat.o(35291);
      return true;
    }
    AppMethodBeat.o(35291);
    return false;
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35288);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    EventCenter.instance.addListener(this.Ppc);
    AppMethodBeat.o(35288);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35289);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    EventCenter.instance.removeListener(this.Ppc);
    AppMethodBeat.o(35289);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35290);
    super.gOK();
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    EventCenter.instance.removeListener(this.Ppc);
    AppMethodBeat.o(35290);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35296);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.NJK != null) && (this.NJK.isShowing()))
    {
      this.NJK.dismiss();
      this.NJK = null;
    }
    AppMethodBeat.o(35296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.t
 * JD-Core Version:    0.7.0.1
 */