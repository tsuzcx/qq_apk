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
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.n;
import com.tencent.mm.ui.chatting.d.a;

public final class ai$a
  extends c
{
  protected ai.d GOb;
  private ai.c GOc;
  private a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493452);
      ((View)localObject).setTag(new ai.e().z((View)localObject, true));
    }
    AppMethodBeat.o(37280);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37281);
    if (parambl == null)
    {
      ad.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      AppMethodBeat.o(37281);
      return;
    }
    this.Gob = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath);
    ai.e locale = (ai.e)parama;
    boolean bool;
    if (localEmojiInfo == null)
    {
      parama = parambl.field_imgPath;
      if (localEmojiInfo == null)
      {
        bool = true;
        ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", new Object[] { parama, Boolean.valueOf(bool), Long.valueOf(parambl.field_msgId) });
      }
    }
    else
    {
      if (localEmojiInfo != null)
      {
        localEmojiInfo.talker = parambl.field_talker;
        parama = ar.aIF(parambl.field_content);
        locale.GLe.a(localEmojiInfo, parambl.field_msgId, parama);
        if ((localEmojiInfo.CZ()) && (!parama.hAc))
        {
          az.arV();
          bl localbl = com.tencent.mm.model.c.apO().rm(parambl.field_msgId);
          parama.hAc = true;
          parambl.setContent(parama.eLt());
          if (localbl.getType() == 10000) {
            break label483;
          }
          az.arV();
          com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
        }
        label239:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label494;
        }
        locale.GOf.setVisibility(0);
        parama = locale.GOf;
        if (this.GOc == null) {
          this.GOc = new ai.c(this.Gob);
        }
        parama.setOnClickListener(this.GOc);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.CZ())) {
        break label614;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label507;
      }
      parama = this.Gob.GzJ.getContext().getString(2131758267);
    }
    label483:
    label614:
    for (;;)
    {
      locale.GLe.setContentDescription(this.Gob.GzJ.getContext().getString(2131758379) + parama);
      locale.GLe.setTag(new bi(parambl, parama1.eZb(), paramInt, paramString, '\000'));
      parama = locale.GLe;
      if (this.GOb == null) {
        this.GOb = new ai.d(parama1);
      }
      parama.setOnClickListener(this.GOb);
      locale.GLe.setOnLongClickListener(c(parama1));
      locale.GLe.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      AppMethodBeat.o(37281);
      return;
      bool = false;
      break;
      ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label494:
      locale.GOf.setVisibility(8);
      break label292;
      label507:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.Gob.GzJ.getContext().getString(2131758268);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.Gob.GzJ.getContext().getString(2131758266);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        if (localEmojiInfo != null) {
          parama = bt.by(((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(localEmojiInfo.JS()), "");
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37283);
    int i;
    EmojiInfo localEmojiInfo;
    if (parambl.eLY())
    {
      az.arV();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((bi)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath);
        if (localEmojiInfo == null)
        {
          ad.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { parambl.field_imgPath });
          AppMethodBeat.o(37283);
          return true;
        }
        boolean bool1 = localEmojiInfo.fZM();
        if ((localEmojiInfo.field_catalog != EmojiInfo.LBW) && (!localEmojiInfo.fZQ()) && (!localEmojiInfo.fZR()))
        {
          if (!bool1) {
            break label549;
          }
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
        }
        parambl = com.tencent.mm.search.b.b.EZl;
        com.tencent.mm.search.b.b.E(localEmojiInfo);
        boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poM, true);
        if ((!localEmojiInfo.CZ()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
        {
          ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
          paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
        }
        if ((!localEmojiInfo.fZQ()) && ((localEmojiInfo.field_catalog == EmojiInfo.LBW) || (bt.isNullOrNil(localEmojiInfo.field_groupId)) || ((!bt.isNullOrNil(localEmojiInfo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(localEmojiInfo.field_groupId)))))
        {
          if (!bool1) {
            break label560;
          }
          paramContextMenu.add(i, 113, 0, 2131762559);
        }
      }
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUH()) {
        paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131757224));
      }
      if ((com.tencent.mm.plugin.emoji.h.b.Ur(localEmojiInfo.field_groupId)) && (!localEmojiInfo.CZ()) && (!localEmojiInfo.fZR())) {
        paramContextMenu.add(i, 128, 0, 2131757237);
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.JS(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(37283);
      return true;
      label549:
      ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label560:
      ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    AppMethodBeat.i(37284);
    boolean bool = ((n)parama.be(n.class)).a(paramMenuItem, parama, parambl);
    AppMethodBeat.o(37284);
    return bool;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(37282);
    boolean bool = parama.eZb();
    AppMethodBeat.o(37282);
    return bool;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.a
 * JD-Core Version:    0.7.0.1
 */