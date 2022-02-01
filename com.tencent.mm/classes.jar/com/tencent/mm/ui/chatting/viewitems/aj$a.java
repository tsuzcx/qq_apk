package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.n;
import com.tencent.mm.ui.chatting.d.a;

public final class aj$a
  extends c
{
  private a HNS;
  protected aj.d Iod;
  private aj.c Ioe;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37280);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493452);
      ((View)localObject).setTag(new aj.e().z((View)localObject, true));
    }
    AppMethodBeat.o(37280);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37281);
    if (parambo == null)
    {
      ac.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      AppMethodBeat.o(37281);
      return;
    }
    this.HNS = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath);
    aj.e locale = (aj.e)parama;
    boolean bool;
    if (localEmojiInfo == null)
    {
      parama = parambo.field_imgPath;
      if (localEmojiInfo == null)
      {
        bool = true;
        ac.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", new Object[] { parama, Boolean.valueOf(bool), Long.valueOf(parambo.field_msgId) });
      }
    }
    else
    {
      if (localEmojiInfo != null)
      {
        localEmojiInfo.talker = parambo.field_talker;
        parama = au.aOb(parambo.field_content);
        locale.Ilb.a(localEmojiInfo, parambo.field_msgId, parama);
        if ((localEmojiInfo.CC()) && (!parama.iaD))
        {
          az.ayM();
          bo localbo = com.tencent.mm.model.c.awD().vP(parambo.field_msgId);
          parama.iaD = true;
          parambo.setContent(parama.dFY());
          if (localbo.getType() == 10000) {
            break label483;
          }
          az.ayM();
          com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
        }
        label239:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label494;
        }
        locale.Ioh.setVisibility(0);
        parama = locale.Ioh;
        if (this.Ioe == null) {
          this.Ioe = new aj.c(this.HNS);
        }
        parama.setOnClickListener(this.Ioe);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.CC())) {
        break label614;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label507;
      }
      parama = this.HNS.HZF.getContext().getString(2131758267);
    }
    label483:
    label614:
    for (;;)
    {
      locale.Ilb.setContentDescription(this.HNS.HZF.getContext().getString(2131758379) + parama);
      locale.Ilb.setTag(new bj(parambo, parama1.foQ(), paramInt, paramString, '\000'));
      parama = locale.Ilb;
      if (this.Iod == null) {
        this.Iod = new aj.d(parama1);
      }
      parama.setOnClickListener(this.Iod);
      locale.Ilb.setOnLongClickListener(c(parama1));
      locale.Ilb.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      AppMethodBeat.o(37281);
      return;
      bool = false;
      break;
      ac.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label494:
      locale.Ioh.setVisibility(8);
      break label292;
      label507:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.HNS.HZF.getContext().getString(2131758268);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.HNS.HZF.getContext().getString(2131758266);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        if (localEmojiInfo != null) {
          parama = bs.bG(((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(localEmojiInfo.JC()), "");
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37283);
    int i;
    EmojiInfo localEmojiInfo;
    if (parambo.fbC())
    {
      az.ayM();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((bj)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath);
        if (localEmojiInfo == null)
        {
          ac.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { parambo.field_imgPath });
          AppMethodBeat.o(37283);
          return true;
        }
        boolean bool1 = localEmojiInfo.fdp();
        if ((localEmojiInfo.field_catalog != EmojiInfo.Jsy) && (!localEmojiInfo.fxI()) && (!localEmojiInfo.fxJ()))
        {
          if (!bool1) {
            break label556;
          }
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
        }
        parambo = com.tencent.mm.search.c.b.GwA;
        com.tencent.mm.search.c.b.b(localEmojiInfo, this.HNS.getTalkerUserName());
        boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSx, true);
        if ((!localEmojiInfo.CC()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
        {
          ac.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
          paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
        }
        if ((!localEmojiInfo.fxI()) && ((localEmojiInfo.field_catalog == EmojiInfo.Jsy) || (bs.isNullOrNil(localEmojiInfo.field_groupId)) || ((!bs.isNullOrNil(localEmojiInfo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(localEmojiInfo.field_groupId)))))
        {
          if (!bool1) {
            break label567;
          }
          paramContextMenu.add(i, 113, 0, 2131762559);
        }
      }
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbU()) {
        paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131757224));
      }
      if ((com.tencent.mm.plugin.emoji.h.b.YD(localEmojiInfo.field_groupId)) && (!localEmojiInfo.CC()) && (!localEmojiInfo.fxJ())) {
        paramContextMenu.add(i, 128, 0, 2131757237);
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.JC(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(37283);
      return true;
      label556:
      ac.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label567:
      ac.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    AppMethodBeat.i(37284);
    boolean bool = ((n)parama.bf(n.class)).a(paramMenuItem, parama, parambo);
    AppMethodBeat.o(37284);
    return bool;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(37282);
    boolean bool = parama.foQ();
    AppMethodBeat.o(37282);
    return bool;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.a
 * JD-Core Version:    0.7.0.1
 */