package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.l;
import com.tencent.mm.api.aa;
import com.tencent.mm.bb.e;
import com.tencent.mm.g.a.r;
import com.tencent.mm.g.a.r.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bl;
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

@com.tencent.mm.ui.chatting.c.a.a(eYT=n.class)
public class q
  extends a
  implements n
{
  private com.tencent.mm.search.c.b EZz;
  private com.tencent.mm.sdk.b.c Gum;
  
  public q()
  {
    AppMethodBeat.i(35286);
    this.Gum = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35286);
  }
  
  private void a(final bl parambl, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35294);
    if ((!parambl.eLY()) && (!parambl.eLZ()))
    {
      AppMethodBeat.o(35294);
      return;
    }
    Object localObject2 = bF(parambl);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35294);
      return;
    }
    parambl = com.tencent.mm.search.b.b.EZl;
    com.tencent.mm.search.b.b.F((EmojiInfo)localObject2);
    parambl = ((com.tencent.mm.ui.chatting.c.b.q)parama.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs();
    final int j = parambl.getCurrentScrollHeight();
    parambl.Vd(aa.bh(parama.GzJ.getContext()));
    Object localObject3 = (com.tencent.mm.ui.chatting.c.b.i)parama.be(com.tencent.mm.ui.chatting.c.b.i.class);
    int i = ((com.tencent.mm.ui.chatting.c.b.i)localObject3).getCount() - 1;
    Object localObject1 = new byd();
    Object localObject4;
    Object localObject5;
    while ((i >= 0) && (((byd)localObject1).DUT.size() <= 20))
    {
      localObject4 = new byc();
      localObject5 = ((com.tencent.mm.ui.chatting.c.b.i)localObject3).YE(i);
      ((byc)localObject4).DUN = ((bl)localObject5).getType();
      ((byc)localObject4).DUO = l.r((bl)localObject5);
      ((byc)localObject4).DUP = l.s((bl)localObject5);
      ((byc)localObject4).DUQ = ((du)localObject5).field_createTime;
      ((byc)localObject4).DUR = ((du)localObject5).field_isSend;
      if (((bl)localObject5).eLY())
      {
        localObject5 = bF((bl)localObject5);
        if (localObject5 != null)
        {
          ((byc)localObject4).sed = ((EmojiInfo)localObject5).field_md5;
          if (((EmojiInfo)localObject5).field_md5.equals(((EmojiInfo)localObject2).field_md5))
          {
            ((byc)localObject4).DUS = 1;
            ((byc)localObject4).Dds = ((EmojiInfo)localObject5).field_lensId;
          }
        }
      }
      i -= 1;
      ((byd)localObject1).DUT.add(localObject4);
    }
    ad.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", new Object[] { Integer.valueOf(((byd)localObject1).DUT.size()) });
    localObject3 = new v(parama, parama.zgX, parama.getTalkerUserName());
    for (final boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poN, true);; bool = false) {
      try
      {
        localObject2 = ((EmojiInfo)localObject2).field_md5;
        localObject4 = parama.getTalkerUserName();
        localObject5 = com.tencent.mm.search.b.b.EZl;
        localObject1 = new SimilarEmojiQueryModel((String)localObject2, (String)localObject4, com.tencent.mm.search.b.b.getTimestamp(), 3, parama.getTalkerUserName(), com.tencent.mm.bx.b.cd(((byd)localObject1).toByteArray()), bool, (j)localObject3);
        if (parambl.Ccj == 1)
        {
          bool = true;
          if (bool)
          {
            parambl.setIgnoreScroll(Boolean.TRUE);
            parambl.hideVKB();
          }
          this.EZz = null;
          this.EZz = new com.tencent.mm.search.c.b(parama.GzJ.getContext(), (SimilarEmojiQueryModel)localObject1, new d.g.a.a() {});
          parambl = this.EZz.getWindow();
          if (parambl != null)
          {
            parambl.setDimAmount(0.0F);
            parambl.setFlags(131072, 131072);
            parambl.setSoftInputMode(48);
          }
          this.EZz.show();
          AppMethodBeat.o(35294);
          return;
        }
      }
      catch (IOException parambl)
      {
        ad.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
        AppMethodBeat.o(35294);
        return;
      }
    }
  }
  
  private void bE(bl parambl)
  {
    AppMethodBeat.i(35292);
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.cOd.GzJ.getContext(), this.cOd.GzJ.getContentView());
      AppMethodBeat.o(35292);
      return;
    }
    ad.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.cOd.getTalkerUserName().equals("medianote"))
    {
      az.arV();
      com.tencent.mm.model.c.apL().c(new e(parambl.field_talker, parambl.field_msgSvrId));
    }
    aj.bo(parambl);
    AppMethodBeat.o(35292);
  }
  
  private static EmojiInfo bF(bl parambl)
  {
    AppMethodBeat.i(35295);
    if (parambl.eLY())
    {
      parambl = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath);
      AppMethodBeat.o(35295);
      return parambl;
    }
    ar localar = ar.aIF(parambl.field_content);
    parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
    if (parambl == null)
    {
      parambl = new k.b();
      parambl.gHg = localar.md5;
    }
    for (;;)
    {
      if ((bt.isNullOrNil(parambl.gHg)) || (parambl.gHg.equals("-1")))
      {
        AppMethodBeat.o(35295);
        return null;
      }
      parambl = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.gHg);
      break;
    }
  }
  
  private void bp(bl parambl)
  {
    AppMethodBeat.i(35293);
    ad.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.cOd.getTalkerUserName().equals("medianote"))
    {
      az.arV();
      com.tencent.mm.model.c.apL().c(new e(parambl.field_talker, parambl.field_msgSvrId));
    }
    aj.bp(parambl);
    this.cOd.wc(true);
    AppMethodBeat.o(35293);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(35287);
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35287);
      return false;
    case 104: 
      if ((parambl.eLY()) || (parambl.eLZ()))
      {
        localObject = bF(parambl);
        if (localObject != null)
        {
          paramMenuItem = parambl.field_talker;
          if (!w.pF(paramMenuItem)) {
            break label1022;
          }
          paramMenuItem = bi.uf(parambl.field_content);
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
      h.vKh.f(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject).JS(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject).field_activityid });
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.GzJ.getContext(), (EmojiInfo)localObject, 0, paramMenuItem);
      AppMethodBeat.o(35287);
      return true;
      boolean bool = bD(parambl);
      AppMethodBeat.o(35287);
      return bool;
      if ((parambl.eLY()) || (parambl.eLZ()))
      {
        al.d(parambl, parama.GzJ.getContext());
        AppMethodBeat.o(35287);
        return true;
      }
      AppMethodBeat.o(35287);
      return false;
      if ((parambl.eLY()) || (parambl.eLZ()))
      {
        paramMenuItem = new LinkedList();
        paramMenuItem.add(parambl);
        if ((!((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD()) && (!parama.eZa())) {
          break label550;
        }
        bool = true;
        k.a(parama.GzJ.getContext(), paramMenuItem, bool, parama.getTalkerUserName(), null);
        if (!parambl.eLY()) {
          break label556;
        }
      }
      for (paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath);; paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramMenuItem.md5))
      {
        if (paramMenuItem != null)
        {
          localObject = parama.getTalkerUserName();
          parama = (com.tencent.mm.ui.chatting.d.a)localObject;
          if (w.pF((String)localObject)) {
            parama = bi.uf(parambl.field_content);
          }
          h.vKh.f(12789, new Object[] { Integer.valueOf(1), paramMenuItem.JS(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, parama, "", "", "", paramMenuItem.field_activityid });
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          bool = false;
          break;
          paramMenuItem = ar.aIF(parambl.field_content);
        } while ((bt.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
      }
      if (parambl.eLY())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath);
        if (paramMenuItem != null) {
          h.vKh.f(12789, new Object[] { Integer.valueOf(2), paramMenuItem.JS(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label874;
        }
      }
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!bt.isNullOrNil(paramMenuItem))
        {
          parambl = new Intent();
          parambl.putExtra("preceding_scence", 3);
          parambl.putExtra("download_entrance_scene", 16);
          parambl.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "emoji", ".ui.EmojiStoreDetailUI", parambl);
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          paramMenuItem = ar.aIF(parambl.field_content);
        } while ((bt.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramMenuItem.md5);
        break;
      }
      paramMenuItem = bF(parambl);
      if (paramMenuItem != null)
      {
        h.vKh.f(12789, new Object[] { Integer.valueOf(5), paramMenuItem.JS(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        com.tencent.mm.plugin.emojicapture.api.b.x(parama.GzJ.getContext(), paramMenuItem.JS(), parama.getTalkerUserName());
      }
      AppMethodBeat.o(35287);
      return true;
      a(parambl, parama);
      AppMethodBeat.o(35287);
      return true;
    }
  }
  
  public final boolean bD(bl parambl)
  {
    AppMethodBeat.i(35291);
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(parambl.field_msgId) });
    if (parambl.eLY())
    {
      bE(parambl);
      AppMethodBeat.o(35291);
      return true;
    }
    if (parambl.eLZ())
    {
      bp(parambl);
      AppMethodBeat.o(35291);
      return true;
    }
    AppMethodBeat.o(35291);
    return false;
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35288);
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    com.tencent.mm.sdk.b.a.ESL.c(this.Gum);
    AppMethodBeat.o(35288);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35289);
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    com.tencent.mm.sdk.b.a.ESL.d(this.Gum);
    AppMethodBeat.o(35289);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35290);
    super.eWx();
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    com.tencent.mm.sdk.b.a.ESL.d(this.Gum);
    AppMethodBeat.o(35290);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35296);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.EZz != null) && (this.EZz.isShowing()))
    {
      this.EZz.dismiss();
      this.EZz = null;
    }
    AppMethodBeat.o(35296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.q
 * JD-Core Version:    0.7.0.1
 */