package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
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
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.t.n;

public final class at$b
  extends c
  implements t.n
{
  private a WBq;
  protected at.d XjE;
  private at.c XjF;
  protected t.m XjG;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37285);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.eek);
      ((View)localObject).setTag(new at.e().J((View)localObject, false));
    }
    AppMethodBeat.o(37285);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37286);
    this.WBq = parama1;
    paramString = (at.e)parama;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.field_imgPath);
    ImageView localImageView;
    if (localEmojiInfo != null)
    {
      parama = be.bwQ(paramca.field_content);
      localEmojiInfo.talker = paramca.field_talker;
      paramString.XfH.a(localEmojiInfo, paramca.field_msgId, parama);
      if (paramString.XjH != null)
      {
        if (!parama.VEZ) {
          break label698;
        }
        paramString.XjH.setVisibility(0);
        TextView localTextView = (TextView)paramString.convertView.findViewById(R.h.dzd).findViewById(R.h.dxr);
        localTextView.setText(Html.fromHtml(parama1.WQv.getMMResources().getString(R.l.emoji_chatting_reward_tips)));
        localImageView = (ImageView)paramString.convertView.findViewById(R.h.dzd).findViewById(R.h.dxq);
        localTextView.setTag(new by(paramca, false, paramInt, parama1.getSelfUserName(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
        localTextView.setOnClickListener(i(parama1));
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUm())
        {
          localImageView.setVisibility(0);
          localImageView.setTag(new by(paramca, parama1.hRi(), paramInt, parama1.getSelfUserName(), '\000'));
          if (this.XjG == null) {
            this.XjG = new t.m(parama1);
          }
          localImageView.setOnClickListener(this.XjG);
        }
      }
      else
      {
        if ((localEmojiInfo.Qv()) && (!parama.mhL))
        {
          parama.mhL = true;
          paramca.setContent(parama.brC());
          bh.beI();
          paramca.setStatus(com.tencent.mm.model.c.bbO().Oq(paramca.field_msgId).field_status);
          bh.beI();
          com.tencent.mm.model.c.bbO().aO(paramca);
        }
        if (!hTG()) {
          break label732;
        }
        b(paramString, false);
        if ((paramca.field_status != 2) || (!b((k)parama1.bC(k.class), paramca.field_msgId))) {
          break label711;
        }
        if (paramString.XdI != null) {
          paramString.XdI.setVisibility(0);
        }
        label426:
        if (!com.tencent.mm.plugin.emoji.i.b.B(localEmojiInfo)) {
          break label779;
        }
        paramString.XjI.setVisibility(0);
        parama = paramString.XjI;
        if (this.XjF == null) {
          this.XjF = new at.c(this.WBq);
        }
        parama.setOnClickListener(this.XjF);
      }
    }
    else
    {
      label479:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.Qv())) {
        break label899;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label792;
      }
      parama = this.WBq.WQv.getContext().getString(R.l.emoji_jsb_j);
    }
    label899:
    for (;;)
    {
      paramString.XfH.setContentDescription(this.WBq.WQv.getContext().getString(R.l.emoji_store_title) + parama);
      paramString.XfH.setTag(new by(paramca, parama1.hRi(), paramInt, parama1.getSelfUserName(), '\000'));
      parama = paramString.XfH;
      if (this.XjE == null) {
        this.XjE = new at.d(parama1);
      }
      parama.setOnClickListener(this.XjE);
      paramString.XfH.setOnLongClickListener(c(parama1));
      paramString.XfH.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      a(paramInt, paramString, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
      AppMethodBeat.o(37286);
      return;
      localImageView.setVisibility(8);
      break;
      label698:
      paramString.XjH.setVisibility(8);
      break;
      label711:
      if (paramString.XdI == null) {
        break label426;
      }
      paramString.XdI.setVisibility(8);
      break label426;
      label732:
      if (paramString.XdI != null) {
        paramString.XdI.setVisibility(8);
      }
      if (paramca.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
      label779:
      paramString.XjI.setVisibility(8);
      break label479;
      label792:
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
    AppMethodBeat.i(37288);
    boolean bool = ((q)parama.bC(q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(37288);
    return bool;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(202117);
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
          Log.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { paramca.field_imgPath });
          AppMethodBeat.o(202117);
          return true;
        }
        bool = localEmojiInfo.hBp();
        if ((localEmojiInfo.field_catalog != EmojiInfo.YCD) && (!localEmojiInfo.hBu()) && (!localEmojiInfo.hBv()))
        {
          if (!bool) {
            break label623;
          }
          paramo.a(i, 104, paramView.getContext().getString(R.l.ewb), R.k.icons_filled_addsticker);
        }
        if (!localEmojiInfo.hBu())
        {
          if (!bool) {
            break label635;
          }
          paramo.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.search.c.b localb = com.tencent.mm.search.c.b.UWY;
      com.tencent.mm.search.c.b.c(localEmojiInfo, this.WBq.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDU, true);
      if ((!localEmojiInfo.Qv()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
        paramo.a(i, 115, paramView.getContext().getString(R.l.ewd), R.k.icons_filled_othersticker);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUr()) {
        paramo.a(i, 135, paramView.getContext().getString(R.l.evR), R.k.icons_filled_makesticker);
      }
      if ((com.tencent.mm.plugin.emoji.i.b.ave(localEmojiInfo.field_groupId)) && (!localEmojiInfo.Qv()) && (!localEmojiInfo.hBv())) {
        paramo.a(i, 128, paramView.getContext().getString(R.l.ewc), R.k.icons_filled_sticker_album);
      }
      if ((!paramca.hwA()) && (paramca.hzB()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
        paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, paramView.getContext().getString(R.l.evM), R.k.icons_filled_delete);
      }
      if (paramca.field_status == 5) {
        paramo.a(i, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.getMd5(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(202117);
      return true;
      label623:
      Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      break;
      label635:
      Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
    }
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(202123);
    paramca.unsetOmittedFailResend();
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
    ((q)parama.bC(q.class)).cu(paramca);
    AppMethodBeat.o(202123);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 47);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.b
 * JD-Core Version:    0.7.0.1
 */