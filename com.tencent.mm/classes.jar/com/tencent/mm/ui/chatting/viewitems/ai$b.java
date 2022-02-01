package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.tencent.mm.ui.chatting.s.m;
import com.tencent.mm.ui.chatting.s.n;

public final class ai$b
  extends c
  implements s.n
{
  protected ai.d GOb;
  private ai.c GOc;
  protected s.m GOd;
  private a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493496);
      ((View)localObject).setTag(new ai.e().z((View)localObject, false));
    }
    AppMethodBeat.o(37285);
    return localObject;
  }
  
  public final void a(a parama, bl parambl)
  {
    AppMethodBeat.i(37289);
    parambl.eMq();
    az.arV();
    com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
    ((n)parama.be(n.class)).bD(parambl);
    AppMethodBeat.o(37289);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37286);
    this.Gob = parama1;
    paramString = (ai.e)parama;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath);
    ImageView localImageView;
    if (localEmojiInfo != null)
    {
      parama = ar.aIF(parambl.field_content);
      localEmojiInfo.talker = parambl.field_talker;
      paramString.GLe.a(localEmojiInfo, parambl.field_msgId, parama);
      if (paramString.GOe != null)
      {
        if (!parama.Fyr) {
          break label696;
        }
        paramString.GOe.setVisibility(0);
        TextView localTextView = (TextView)paramString.rLd.findViewById(2131298163).findViewById(2131298086);
        localTextView.setText(Html.fromHtml(parama1.GzJ.getMMResources().getString(2131758237)));
        localImageView = (ImageView)paramString.rLd.findViewById(2131298163).findViewById(2131298085);
        localTextView.setTag(new bi(parambl, false, paramInt, parama1.eYX(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
        localTextView.setOnClickListener(i(parama1));
        if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUD())
        {
          localImageView.setVisibility(0);
          localImageView.setTag(new bi(parambl, parama1.eZb(), paramInt, parama1.eYX(), '\000'));
          if (this.GOd == null) {
            this.GOd = new s.m(parama1);
          }
          localImageView.setOnClickListener(this.GOd);
        }
      }
      else
      {
        if ((localEmojiInfo.CZ()) && (!parama.hAc))
        {
          parama.hAc = true;
          parambl.setContent(parama.eLt());
          az.arV();
          parambl.setStatus(com.tencent.mm.model.c.apO().rm(parambl.field_msgId).field_status);
          az.arV();
          com.tencent.mm.model.c.apO().ap(parambl);
        }
        if (!faG()) {
          break label730;
        }
        paramString.uPp.setVisibility(8);
        if ((parambl.field_status != 2) || (!a((i)parama1.be(i.class), parambl.field_msgId))) {
          break label709;
        }
        if (paramString.GJi != null) {
          paramString.GJi.setVisibility(0);
        }
        label424:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label787;
        }
        paramString.GOf.setVisibility(0);
        parama = paramString.GOf;
        if (this.GOc == null) {
          this.GOc = new ai.c(this.Gob);
        }
        parama.setOnClickListener(this.GOc);
      }
    }
    else
    {
      label477:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.CZ())) {
        break label907;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label800;
      }
      parama = this.Gob.GzJ.getContext().getString(2131758267);
    }
    label907:
    for (;;)
    {
      paramString.GLe.setContentDescription(this.Gob.GzJ.getContext().getString(2131758379) + parama);
      paramString.GLe.setTag(new bi(parambl, parama1.eZb(), paramInt, parama1.eYX(), '\000'));
      parama = paramString.GLe;
      if (this.GOb == null) {
        this.GOb = new ai.d(parama1);
      }
      parama.setOnClickListener(this.GOb);
      paramString.GLe.setOnLongClickListener(c(parama1));
      paramString.GLe.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      a(paramInt, paramString, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
      AppMethodBeat.o(37286);
      return;
      localImageView.setVisibility(8);
      break;
      label696:
      paramString.GOe.setVisibility(8);
      break;
      label709:
      if (paramString.GJi == null) {
        break label424;
      }
      paramString.GJi.setVisibility(8);
      break label424;
      label730:
      if (paramString.GJi != null) {
        paramString.GJi.setVisibility(8);
      }
      if (paramString.uPp == null) {
        break label424;
      }
      paramString.uPp.setVisibility(0);
      if (parambl.field_status < 2) {
        break label424;
      }
      paramString.uPp.setVisibility(8);
      break label424;
      label787:
      paramString.GOf.setVisibility(8);
      break label477;
      label800:
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
    AppMethodBeat.i(37287);
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
          ad.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { parambl.field_imgPath });
          AppMethodBeat.o(37287);
          return true;
        }
        boolean bool1 = localEmojiInfo.fZM();
        if ((localEmojiInfo.field_catalog != EmojiInfo.LBW) && (!localEmojiInfo.fZQ()) && (!localEmojiInfo.fZR()))
        {
          if (!bool1) {
            break label661;
          }
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
        }
        com.tencent.mm.search.b.b localb = com.tencent.mm.search.b.b.EZl;
        com.tencent.mm.search.b.b.E(localEmojiInfo);
        boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poM, true);
        if ((!localEmojiInfo.CZ()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
        {
          ad.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
          paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
        }
        if ((!localEmojiInfo.fZQ()) && ((localEmojiInfo.field_catalog == EmojiInfo.LBW) || (bt.isNullOrNil(localEmojiInfo.field_groupId)) || ((!bt.isNullOrNil(localEmojiInfo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(localEmojiInfo.field_groupId)))))
        {
          if (!bool1) {
            break label673;
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
      if ((!parambl.eJL()) && (parambl.eLY()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
      }
      if (parambl.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.JS(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(37287);
      return true;
      label661:
      ad.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      break;
      label673:
      ad.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    AppMethodBeat.i(37288);
    boolean bool = ((n)parama.be(n.class)).a(paramMenuItem, parama, parambl);
    AppMethodBeat.o(37288);
    return bool;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 47);
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.b
 * JD-Core Version:    0.7.0.1
 */