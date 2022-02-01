package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.e.a;

public final class at$a
  extends c
{
  private a WBq;
  protected at.d XjE;
  private at.c XjF;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edk);
      ((View)localObject).setTag(new at.e().J((View)localObject, true));
    }
    AppMethodBeat.o(37280);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37281);
    if (paramca == null)
    {
      Log.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      AppMethodBeat.o(37281);
      return;
    }
    this.WBq = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.field_imgPath);
    at.e locale = (at.e)parama;
    boolean bool;
    if (localEmojiInfo == null)
    {
      parama = paramca.field_imgPath;
      if (localEmojiInfo == null)
      {
        bool = true;
        Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", new Object[] { parama, Boolean.valueOf(bool), Long.valueOf(paramca.field_msgId) });
      }
    }
    else
    {
      if (localEmojiInfo != null)
      {
        localEmojiInfo.talker = paramca.field_talker;
        parama = be.bwQ(paramca.field_content);
        locale.XfH.a(localEmojiInfo, paramca.field_msgId, parama);
        if ((localEmojiInfo.Qv()) && (!parama.mhL))
        {
          bh.beI();
          ca localca = com.tencent.mm.model.c.bbO().Oq(paramca.field_msgId);
          parama.mhL = true;
          paramca.setContent(parama.brC());
          if (localca.getType() == 10000) {
            break label485;
          }
          bh.beI();
          com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
        }
        label239:
        if (!com.tencent.mm.plugin.emoji.i.b.B(localEmojiInfo)) {
          break label496;
        }
        locale.XjI.setVisibility(0);
        parama = locale.XjI;
        if (this.XjF == null) {
          this.XjF = new at.c(this.WBq);
        }
        parama.setOnClickListener(this.XjF);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.Qv())) {
        break label616;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label509;
      }
      parama = this.WBq.WQv.getContext().getString(R.l.emoji_jsb_j);
    }
    label485:
    label616:
    for (;;)
    {
      locale.XfH.setContentDescription(this.WBq.WQv.getContext().getString(R.l.emoji_store_title) + parama);
      locale.XfH.setTag(new by(paramca, parama1.hRi(), paramInt, paramString, '\000'));
      parama = locale.XfH;
      if (this.XjE == null) {
        this.XjE = new at.d(parama1);
      }
      parama.setOnClickListener(this.XjE);
      locale.XfH.setOnLongClickListener(c(parama1));
      locale.XfH.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      AppMethodBeat.o(37281);
      return;
      bool = false;
      break;
      Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label496:
      locale.XjI.setVisibility(8);
      break label292;
      label509:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.WBq.WQv.getContext().getString(R.l.emoji_jsb_s);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.WBq.WQv.getContext().getString(R.l.emoji_jsb_b);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        if (localEmojiInfo != null) {
          parama = Util.nullAs(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(localEmojiInfo.getMd5()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37284);
    boolean bool = ((q)parama.bC(q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(37284);
    return bool;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(290380);
    int i;
    EmojiInfo localEmojiInfo;
    boolean bool;
    if (paramca.hzB())
    {
      bh.beI();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((by)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.field_imgPath);
        if (localEmojiInfo == null)
        {
          Log.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { paramca.field_imgPath });
          AppMethodBeat.o(290380);
          return true;
        }
        bool = localEmojiInfo.hBp();
        if ((localEmojiInfo.field_catalog != EmojiInfo.YCD) && (!localEmojiInfo.hBu()) && (!localEmojiInfo.hBv()))
        {
          if (!bool) {
            break label511;
          }
          paramo.a(i, 104, paramView.getContext().getString(R.l.ewb), R.k.icons_filled_addsticker);
        }
        if (!localEmojiInfo.hBu())
        {
          if (!bool) {
            break label522;
          }
          paramo.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
    }
    for (;;)
    {
      paramca = com.tencent.mm.search.c.b.UWY;
      com.tencent.mm.search.c.b.c(localEmojiInfo, this.WBq.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDU, true);
      if ((!localEmojiInfo.Qv()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
        paramo.a(i, 115, paramView.getContext().getString(R.l.ewd), R.k.icons_filled_othersticker);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUr()) {
        paramo.a(i, 135, paramView.getContext().getString(R.l.evR), R.k.icons_filled_makesticker);
      }
      if ((com.tencent.mm.plugin.emoji.i.b.ave(localEmojiInfo.field_groupId)) && (!localEmojiInfo.Qv()) && (!localEmojiInfo.hBv())) {
        paramo.a(i, 128, paramView.getContext().getString(R.l.ewc), R.k.icons_filled_sticker_album);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, paramView.getContext().getString(R.l.evM), R.k.icons_filled_delete);
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.getMd5(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(290380);
      return true;
      label511:
      Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label522:
      Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(37282);
    boolean bool = parama.hRi();
    AppMethodBeat.o(37282);
    return bool;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.a
 * JD-Core Version:    0.7.0.1
 */