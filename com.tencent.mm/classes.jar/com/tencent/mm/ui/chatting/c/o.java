package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.az.e;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.k;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=m.class)
public class o
  extends a
  implements m
{
  private com.tencent.mm.sdk.b.c zFE;
  
  public o()
  {
    AppMethodBeat.i(31396);
    this.zFE = new o.1(this);
    AppMethodBeat.o(31396);
  }
  
  private void aU(bi parambi)
  {
    AppMethodBeat.i(31403);
    ab.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.caz.getTalkerUserName().equals("medianote"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new e(parambi.field_talker, parambi.field_msgSvrId));
    }
    aj.aU(parambi);
    this.caz.qT(true);
    AppMethodBeat.o(31403);
  }
  
  private void bj(bi parambi)
  {
    AppMethodBeat.i(31402);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(this.caz.zJz.getContext());
      AppMethodBeat.o(31402);
      return;
    }
    ab.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.caz.getTalkerUserName().equals("medianote"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new e(parambi.field_talker, parambi.field_msgSvrId));
    }
    aj.aT(parambi);
    AppMethodBeat.o(31402);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(31397);
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(31397);
      return false;
    case 104: 
      if ((parambi.dxS()) || (parambi.dxT()))
      {
        if (parambi.dxS())
        {
          paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);
          localObject = parambi.field_talker;
          if (!com.tencent.mm.model.t.lA((String)localObject)) {
            break;
          }
          parambi = bf.pu(parambi.field_content);
          label146:
          h.qsU.e(12789, new Object[] { Integer.valueOf(3), paramMenuItem.Al(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
          ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.zJz.getContext(), paramMenuItem, 0, parambi);
        }
      }
      else
      {
        label261:
        AppMethodBeat.o(31397);
        return true;
      }
      localObject = ap.arZ(parambi.field_content);
      paramMenuItem = j.b.ab(parambi.field_content, parambi.field_reserved);
      if (paramMenuItem == null)
      {
        paramMenuItem = new j.b();
        paramMenuItem.fgy = ((ap)localObject).cqq;
      }
      break;
    }
    for (;;)
    {
      if ((bo.isNullOrNil(paramMenuItem.fgy)) || (paramMenuItem.fgy.equals("-1"))) {
        break label261;
      }
      paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramMenuItem.fgy);
      break;
      boolean bool = bi(parambi);
      AppMethodBeat.o(31397);
      return bool;
      if ((parambi.dxS()) || (parambi.dxT()))
      {
        al.d(parambi, parama.zJz.getContext());
        AppMethodBeat.o(31397);
        return true;
      }
      AppMethodBeat.o(31397);
      return false;
      if ((parambi.dxS()) || (parambi.dxT()))
      {
        paramMenuItem = new LinkedList();
        paramMenuItem.add(parambi);
        if ((!((com.tencent.mm.ui.chatting.c.b.d)parama.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw()) && (!parama.dJF())) {
          break label638;
        }
        bool = true;
        k.a(parama.zJz.getContext(), paramMenuItem, bool, parama.getTalkerUserName(), null);
        if (!parambi.dxS()) {
          break label644;
        }
      }
      label644:
      for (paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);; paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramMenuItem.cqq))
      {
        if (paramMenuItem != null)
        {
          localObject = parama.getTalkerUserName();
          parama = (com.tencent.mm.ui.chatting.d.a)localObject;
          if (com.tencent.mm.model.t.lA((String)localObject)) {
            parama = bf.pu(parambi.field_content);
          }
          h.qsU.e(12789, new Object[] { Integer.valueOf(1), paramMenuItem.Al(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, parama, "", "", "", paramMenuItem.field_activityid });
        }
        label638:
        do
        {
          AppMethodBeat.o(31397);
          return true;
          bool = false;
          break;
          paramMenuItem = ap.arZ(parambi.field_content);
        } while ((bo.isNullOrNil(paramMenuItem.cqq)) || (paramMenuItem.cqq.equals("-1")));
      }
      if (parambi.dxS())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);
        if (paramMenuItem != null) {
          h.qsU.e(12789, new Object[] { Integer.valueOf(2), paramMenuItem.Al(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label951;
        }
      }
      label951:
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!bo.isNullOrNil(paramMenuItem))
        {
          parambi = new Intent();
          parambi.putExtra("preceding_scence", 3);
          parambi.putExtra("download_entrance_scene", 16);
          parambi.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "emoji", ".ui.EmojiStoreDetailUI", parambi);
        }
        do
        {
          AppMethodBeat.o(31397);
          return true;
          paramMenuItem = ap.arZ(parambi.field_content);
        } while ((bo.isNullOrNil(paramMenuItem.cqq)) || (paramMenuItem.cqq.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramMenuItem.cqq);
        break;
      }
      if (parambi.dxS())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);
        h.qsU.e(12789, new Object[] { Integer.valueOf(5), paramMenuItem.Al(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        com.tencent.mm.plugin.emojicapture.api.c.am(parama.zJz.getContext(), paramMenuItem.Al());
      }
      label1188:
      for (;;)
      {
        AppMethodBeat.o(31397);
        return true;
        localObject = ap.arZ(parambi.field_content);
        paramMenuItem = j.b.ab(parambi.field_content, parambi.field_reserved);
        if (paramMenuItem == null)
        {
          paramMenuItem = new j.b();
          paramMenuItem.fgy = ((ap)localObject).cqq;
        }
        for (;;)
        {
          if ((bo.isNullOrNil(paramMenuItem.fgy)) || (paramMenuItem.fgy.equals("-1"))) {
            break label1188;
          }
          paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramMenuItem.fgy);
          break;
        }
      }
      parambi = (bi)localObject;
      break label146;
    }
  }
  
  public final boolean bi(bi parambi)
  {
    AppMethodBeat.i(31401);
    ab.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(parambi.field_msgId) });
    if (parambi.dxS())
    {
      bj(parambi);
      AppMethodBeat.o(31401);
      return true;
    }
    if (parambi.dxT())
    {
      aU(parambi);
      AppMethodBeat.o(31401);
      return true;
    }
    AppMethodBeat.o(31401);
    return false;
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31398);
    ab.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    com.tencent.mm.sdk.b.a.ymk.c(this.zFE);
    AppMethodBeat.o(31398);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31399);
    ab.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    com.tencent.mm.sdk.b.a.ymk.d(this.zFE);
    AppMethodBeat.o(31399);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31400);
    super.dHq();
    ab.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    com.tencent.mm.sdk.b.a.ymk.d(this.zFE);
    AppMethodBeat.o(31400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.o
 * JD-Core Version:    0.7.0.1
 */