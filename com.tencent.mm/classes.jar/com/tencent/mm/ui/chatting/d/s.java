package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.l;
import com.tencent.mm.api.aa;
import com.tencent.mm.bb.f;
import com.tencent.mm.g.a.s.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.chatting.viewitems.l.b;
import d.z;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=p.class)
public class s
  extends a
  implements p
{
  private com.tencent.mm.search.d.b IiK;
  private com.tencent.mm.sdk.b.c JID;
  
  public s()
  {
    AppMethodBeat.i(35286);
    this.JID = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35286);
  }
  
  private void a(final bu parambu, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35294);
    if ((!parambu.frG()) && (!parambu.frH()))
    {
      AppMethodBeat.o(35294);
      return;
    }
    Object localObject2 = bN(parambu);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35294);
      return;
    }
    parambu = com.tencent.mm.search.c.b.Iiu;
    com.tencent.mm.search.c.b.E((EmojiInfo)localObject2);
    parambu = ((com.tencent.mm.ui.chatting.d.b.s)parama.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fDC();
    final int j = parambu.getCurrentScrollHeight();
    parambu.Zi(aa.bi(parama.JOR.getContext()));
    Object localObject3 = (com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    int i = ((com.tencent.mm.ui.chatting.d.b.k)localObject3).getCount() - 1;
    Object localObject1 = new chu();
    Object localObject4;
    Object localObject5;
    while ((i >= 0) && (((chu)localObject1).Hbv.size() <= 20))
    {
      localObject4 = new cht();
      localObject5 = ((com.tencent.mm.ui.chatting.d.b.k)localObject3).ada(i);
      ((cht)localObject4).Hbp = ((bu)localObject5).getType();
      ((cht)localObject4).Hbq = l.r((bu)localObject5);
      ((cht)localObject4).Hbr = l.s((bu)localObject5);
      ((cht)localObject4).Hbs = ((ei)localObject5).field_createTime;
      ((cht)localObject4).Hbt = ((ei)localObject5).field_isSend;
      if (((bu)localObject5).frG())
      {
        localObject5 = bN((bu)localObject5);
        if (localObject5 != null)
        {
          ((cht)localObject4).ukw = ((EmojiInfo)localObject5).field_md5;
          if (((EmojiInfo)localObject5).field_md5.equals(((EmojiInfo)localObject2).field_md5))
          {
            ((cht)localObject4).Hbu = 1;
            ((cht)localObject4).Geb = ((EmojiInfo)localObject5).field_lensId;
          }
        }
      }
      i -= 1;
      ((chu)localObject1).Hbv.add(localObject4);
    }
    ad.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", new Object[] { Integer.valueOf(((chu)localObject1).Hbv.size()) });
    localObject3 = new v(parama, parama.BYG, parama.getTalkerUserName());
    for (final boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwZ, true);; bool = false) {
      try
      {
        localObject2 = ((EmojiInfo)localObject2).field_md5;
        localObject4 = parama.getTalkerUserName();
        localObject5 = com.tencent.mm.search.c.b.Iiu;
        localObject1 = new SimilarEmojiQueryModel((String)localObject2, (String)localObject4, com.tencent.mm.search.c.b.getTimestamp(), 3, parama.getTalkerUserName(), com.tencent.mm.bx.b.cj(((chu)localObject1).toByteArray()), bool, (com.tencent.mm.pluginsdk.ui.chat.j)localObject3);
        if (parambu.EZI == 1)
        {
          bool = true;
          if (bool)
          {
            parambu.setIgnoreScroll(Boolean.TRUE);
            parambu.hideVKB();
          }
          this.IiK = null;
          this.IiK = new com.tencent.mm.search.d.b(parama.JOR.getContext(), (SimilarEmojiQueryModel)localObject1, new d.g.a.a() {});
          parambu = this.IiK.getWindow();
          if (parambu != null)
          {
            parambu.setDimAmount(0.0F);
            parambu.setFlags(131072, 131072);
            parambu.setSoftInputMode(48);
          }
          this.IiK.show();
          AppMethodBeat.o(35294);
          return;
        }
      }
      catch (IOException parambu)
      {
        ad.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
        AppMethodBeat.o(35294);
        return;
      }
    }
  }
  
  private void bM(bu parambu)
  {
    AppMethodBeat.i(35292);
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.cWM.JOR.getContext(), this.cWM.JOR.getContentView());
      AppMethodBeat.o(35292);
      return;
    }
    ad.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.cWM.getTalkerUserName().equals("medianote"))
    {
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(new f(parambu.field_talker, parambu.field_msgSvrId));
    }
    aj.bu(parambu);
    AppMethodBeat.o(35292);
  }
  
  private static EmojiInfo bN(bu parambu)
  {
    AppMethodBeat.i(35295);
    if (parambu.frG())
    {
      parambu = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath);
      AppMethodBeat.o(35295);
      return parambu;
    }
    ay localay = ay.aTS(parambu.field_content);
    parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
    if (parambu == null)
    {
      parambu = new k.b();
      parambu.hzQ = localay.md5;
    }
    for (;;)
    {
      if ((bt.isNullOrNil(parambu.hzQ)) || (parambu.hzQ.equals("-1")))
      {
        AppMethodBeat.o(35295);
        return null;
      }
      parambu = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.hzQ);
      break;
    }
  }
  
  private void bv(bu parambu)
  {
    AppMethodBeat.i(35293);
    ad.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.cWM.getTalkerUserName().equals("medianote"))
    {
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(new f(parambu.field_talker, parambu.field_msgSvrId));
    }
    aj.bv(parambu);
    this.cWM.xR(true);
    AppMethodBeat.o(35293);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(35287);
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35287);
      return false;
    case 104: 
      if ((parambu.frG()) || (parambu.frH()))
      {
        localObject = bN(parambu);
        if (localObject != null)
        {
          paramMenuItem = parambu.field_talker;
          if (!w.vF(paramMenuItem)) {
            break label1022;
          }
          paramMenuItem = bj.Bk(parambu.field_content);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject).Lb(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject).field_activityid });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.JOR.getContext(), (EmojiInfo)localObject, 0, paramMenuItem);
      AppMethodBeat.o(35287);
      return true;
      boolean bool = bL(parambu);
      AppMethodBeat.o(35287);
      return bool;
      if ((parambu.frG()) || (parambu.frH()))
      {
        al.d(parambu, parama.JOR.getContext());
        AppMethodBeat.o(35287);
        return true;
      }
      AppMethodBeat.o(35287);
      return false;
      if ((parambu.frG()) || (parambu.frH()))
      {
        paramMenuItem = new LinkedList();
        paramMenuItem.add(parambu);
        if ((!((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI()) && (!parama.fFu())) {
          break label550;
        }
        bool = true;
        com.tencent.mm.ui.chatting.k.a(parama.JOR.getContext(), paramMenuItem, bool, parama.getTalkerUserName(), null);
        if (!parambu.frG()) {
          break label556;
        }
      }
      for (paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath);; paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(paramMenuItem.md5))
      {
        if (paramMenuItem != null)
        {
          localObject = parama.getTalkerUserName();
          parama = (com.tencent.mm.ui.chatting.e.a)localObject;
          if (w.vF((String)localObject)) {
            parama = bj.Bk(parambu.field_content);
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(1), paramMenuItem.Lb(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, parama, "", "", "", paramMenuItem.field_activityid });
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          bool = false;
          break;
          paramMenuItem = ay.aTS(parambu.field_content);
        } while ((bt.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
      }
      if (parambu.frG())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath);
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(2), paramMenuItem.Lb(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label874;
        }
      }
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!bt.isNullOrNil(paramMenuItem))
        {
          parambu = new Intent();
          parambu.putExtra("preceding_scence", 3);
          parambu.putExtra("download_entrance_scene", 16);
          parambu.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "emoji", ".ui.EmojiStoreDetailUI", parambu);
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          paramMenuItem = ay.aTS(parambu.field_content);
        } while ((bt.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(paramMenuItem.md5);
        break;
      }
      paramMenuItem = bN(parambu);
      if (paramMenuItem != null)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(5), paramMenuItem.Lb(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        com.tencent.mm.plugin.emojicapture.api.b.x(parama.JOR.getContext(), paramMenuItem.Lb(), parama.getTalkerUserName());
      }
      AppMethodBeat.o(35287);
      return true;
      a(parambu, parama);
      AppMethodBeat.o(35287);
      return true;
    }
  }
  
  public final boolean bL(bu parambu)
  {
    AppMethodBeat.i(35291);
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(parambu.field_msgId) });
    if (parambu.frG())
    {
      bM(parambu);
      AppMethodBeat.o(35291);
      return true;
    }
    if (parambu.frH())
    {
      bv(parambu);
      AppMethodBeat.o(35291);
      return true;
    }
    AppMethodBeat.o(35291);
    return false;
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35290);
    super.fCC();
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    com.tencent.mm.sdk.b.a.IbL.d(this.JID);
    AppMethodBeat.o(35290);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35288);
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    com.tencent.mm.sdk.b.a.IbL.c(this.JID);
    AppMethodBeat.o(35288);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35289);
    ad.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    com.tencent.mm.sdk.b.a.IbL.d(this.JID);
    AppMethodBeat.o(35289);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35296);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.IiK != null) && (this.IiK.isShowing()))
    {
      this.IiK.dismiss();
      this.IiK = null;
    }
    AppMethodBeat.o(35296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.s
 * JD-Core Version:    0.7.0.1
 */