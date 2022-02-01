package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.l;
import com.tencent.mm.api.aa;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.c.b.n;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.chatting.viewitems.l.b;
import d.y;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=n.class)
public class q
  extends a
  implements n
{
  private com.tencent.mm.search.d.b GwQ;
  private com.tencent.mm.sdk.b.c HUf;
  
  public q()
  {
    AppMethodBeat.i(35286);
    this.HUf = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35286);
  }
  
  private void a(final bo parambo, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35294);
    if ((!parambo.fbC()) && (!parambo.fbD()))
    {
      AppMethodBeat.o(35294);
      return;
    }
    Object localObject2 = bH(parambo);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35294);
      return;
    }
    parambo = com.tencent.mm.search.c.b.GwA;
    com.tencent.mm.search.c.b.F((EmojiInfo)localObject2);
    parambo = ((com.tencent.mm.ui.chatting.c.b.q)parama.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne();
    final int j = parambo.getCurrentScrollHeight();
    parambo.Xm(aa.bi(parama.HZF.getContext()));
    Object localObject3 = (com.tencent.mm.ui.chatting.c.b.i)parama.bf(com.tencent.mm.ui.chatting.c.b.i.class);
    int i = ((com.tencent.mm.ui.chatting.c.b.i)localObject3).getCount() - 1;
    Object localObject1 = new ccz();
    Object localObject4;
    Object localObject5;
    while ((i >= 0) && (((ccz)localObject1).FrH.size() <= 20))
    {
      localObject4 = new ccy();
      localObject5 = ((com.tencent.mm.ui.chatting.c.b.i)localObject3).aaP(i);
      ((ccy)localObject4).FrB = ((bo)localObject5).getType();
      ((ccy)localObject4).FrC = l.r((bo)localObject5);
      ((ccy)localObject4).FrD = l.s((bo)localObject5);
      ((ccy)localObject4).FrE = ((dy)localObject5).field_createTime;
      ((ccy)localObject4).FrF = ((dy)localObject5).field_isSend;
      if (((bo)localObject5).fbC())
      {
        localObject5 = bH((bo)localObject5);
        if (localObject5 != null)
        {
          ((ccy)localObject4).tlX = ((EmojiInfo)localObject5).field_md5;
          if (((EmojiInfo)localObject5).field_md5.equals(((EmojiInfo)localObject2).field_md5))
          {
            ((ccy)localObject4).FrG = 1;
            ((ccy)localObject4).Ewy = ((EmojiInfo)localObject5).field_lensId;
          }
        }
      }
      i -= 1;
      ((ccz)localObject1).FrH.add(localObject4);
    }
    ac.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", new Object[] { Integer.valueOf(((ccz)localObject1).FrH.size()) });
    localObject3 = new v(parama, parama.AzG, parama.getTalkerUserName());
    for (final boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSy, true);; bool = false) {
      try
      {
        localObject2 = ((EmojiInfo)localObject2).field_md5;
        localObject4 = parama.getTalkerUserName();
        localObject5 = com.tencent.mm.search.c.b.GwA;
        localObject1 = new SimilarEmojiQueryModel((String)localObject2, (String)localObject4, com.tencent.mm.search.c.b.getTimestamp(), 3, parama.getTalkerUserName(), com.tencent.mm.bw.b.cc(((ccz)localObject1).toByteArray()), bool, (j)localObject3);
        if (parambo.DuB == 1)
        {
          bool = true;
          if (bool)
          {
            parambo.setIgnoreScroll(Boolean.TRUE);
            parambo.hideVKB();
          }
          this.GwQ = null;
          this.GwQ = new com.tencent.mm.search.d.b(parama.HZF.getContext(), (SimilarEmojiQueryModel)localObject1, new d.g.a.a() {});
          parambo = this.GwQ.getWindow();
          if (parambo != null)
          {
            parambo.setDimAmount(0.0F);
            parambo.setFlags(131072, 131072);
            parambo.setSoftInputMode(48);
          }
          this.GwQ.show();
          AppMethodBeat.o(35294);
          return;
        }
      }
      catch (IOException parambo)
      {
        ac.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
        AppMethodBeat.o(35294);
        return;
      }
    }
  }
  
  private void bG(bo parambo)
  {
    AppMethodBeat.i(35292);
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.cLy.HZF.getContext(), this.cLy.HZF.getContentView());
      AppMethodBeat.o(35292);
      return;
    }
    ac.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.cLy.getTalkerUserName().equals("medianote"))
    {
      az.ayM();
      com.tencent.mm.model.c.awA().c(new f(parambo.field_talker, parambo.field_msgSvrId));
    }
    aj.bq(parambo);
    AppMethodBeat.o(35292);
  }
  
  private static EmojiInfo bH(bo parambo)
  {
    AppMethodBeat.i(35295);
    if (parambo.fbC())
    {
      parambo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath);
      AppMethodBeat.o(35295);
      return parambo;
    }
    au localau = au.aOb(parambo.field_content);
    parambo = k.b.az(parambo.field_content, parambo.field_reserved);
    if (parambo == null)
    {
      parambo = new k.b();
      parambo.hhH = localau.md5;
    }
    for (;;)
    {
      if ((bs.isNullOrNil(parambo.hhH)) || (parambo.hhH.equals("-1")))
      {
        AppMethodBeat.o(35295);
        return null;
      }
      parambo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.hhH);
      break;
    }
  }
  
  private void br(bo parambo)
  {
    AppMethodBeat.i(35293);
    ac.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.cLy.getTalkerUserName().equals("medianote"))
    {
      az.ayM();
      com.tencent.mm.model.c.awA().c(new f(parambo.field_talker, parambo.field_msgSvrId));
    }
    aj.br(parambo);
    this.cLy.xg(true);
    AppMethodBeat.o(35293);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(35287);
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35287);
      return false;
    case 104: 
      if ((parambo.fbC()) || (parambo.fbD()))
      {
        localObject = bH(parambo);
        if (localObject != null)
        {
          paramMenuItem = parambo.field_talker;
          if (!w.sQ(paramMenuItem)) {
            break label1022;
          }
          paramMenuItem = bi.yl(parambo.field_content);
        }
      }
      break;
    }
    label550:
    label556:
    label874:
    label1022:
    for (;;)
    {
      h.wUl.f(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject).JC(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject).field_activityid });
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.HZF.getContext(), (EmojiInfo)localObject, 0, paramMenuItem);
      AppMethodBeat.o(35287);
      return true;
      boolean bool = bF(parambo);
      AppMethodBeat.o(35287);
      return bool;
      if ((parambo.fbC()) || (parambo.fbD()))
      {
        al.d(parambo, parama.HZF.getContext());
        AppMethodBeat.o(35287);
        return true;
      }
      AppMethodBeat.o(35287);
      return false;
      if ((parambo.fbC()) || (parambo.fbD()))
      {
        paramMenuItem = new LinkedList();
        paramMenuItem.add(parambo);
        if ((!((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp()) && (!parama.foP())) {
          break label550;
        }
        bool = true;
        k.a(parama.HZF.getContext(), paramMenuItem, bool, parama.getTalkerUserName(), null);
        if (!parambo.fbC()) {
          break label556;
        }
      }
      for (paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath);; paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramMenuItem.md5))
      {
        if (paramMenuItem != null)
        {
          localObject = parama.getTalkerUserName();
          parama = (com.tencent.mm.ui.chatting.d.a)localObject;
          if (w.sQ((String)localObject)) {
            parama = bi.yl(parambo.field_content);
          }
          h.wUl.f(12789, new Object[] { Integer.valueOf(1), paramMenuItem.JC(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, parama, "", "", "", paramMenuItem.field_activityid });
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          bool = false;
          break;
          paramMenuItem = au.aOb(parambo.field_content);
        } while ((bs.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
      }
      if (parambo.fbC())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath);
        if (paramMenuItem != null) {
          h.wUl.f(12789, new Object[] { Integer.valueOf(2), paramMenuItem.JC(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label874;
        }
      }
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!bs.isNullOrNil(paramMenuItem))
        {
          parambo = new Intent();
          parambo.putExtra("preceding_scence", 3);
          parambo.putExtra("download_entrance_scene", 16);
          parambo.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "emoji", ".ui.EmojiStoreDetailUI", parambo);
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          paramMenuItem = au.aOb(parambo.field_content);
        } while ((bs.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramMenuItem.md5);
        break;
      }
      paramMenuItem = bH(parambo);
      if (paramMenuItem != null)
      {
        h.wUl.f(12789, new Object[] { Integer.valueOf(5), paramMenuItem.JC(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        com.tencent.mm.plugin.emojicapture.api.b.w(parama.HZF.getContext(), paramMenuItem.JC(), parama.getTalkerUserName());
      }
      AppMethodBeat.o(35287);
      return true;
      a(parambo, parama);
      AppMethodBeat.o(35287);
      return true;
    }
  }
  
  public final boolean bF(bo parambo)
  {
    AppMethodBeat.i(35291);
    ac.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(parambo.field_msgId) });
    if (parambo.fbC())
    {
      bG(parambo);
      AppMethodBeat.o(35291);
      return true;
    }
    if (parambo.fbD())
    {
      br(parambo);
      AppMethodBeat.o(35291);
      return true;
    }
    AppMethodBeat.o(35291);
    return false;
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35288);
    ac.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    com.tencent.mm.sdk.b.a.GpY.c(this.HUf);
    AppMethodBeat.o(35288);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35289);
    ac.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    com.tencent.mm.sdk.b.a.GpY.d(this.HUf);
    AppMethodBeat.o(35289);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35290);
    super.fmj();
    ac.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    com.tencent.mm.sdk.b.a.GpY.d(this.HUf);
    AppMethodBeat.o(35290);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35296);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.GwQ != null) && (this.GwQ.isShowing()))
    {
      this.GwQ.dismiss();
      this.GwQ = null;
    }
    AppMethodBeat.o(35296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.q
 * JD-Core Version:    0.7.0.1
 */