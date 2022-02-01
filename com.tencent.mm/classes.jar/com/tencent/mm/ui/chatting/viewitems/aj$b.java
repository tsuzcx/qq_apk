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
import android.widget.TextView;
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
import com.tencent.mm.ui.chatting.s.m;
import com.tencent.mm.ui.chatting.s.n;

public final class aj$b
  extends c
  implements s.n
{
  private a HNS;
  protected aj.d Iod;
  private aj.c Ioe;
  protected s.m Iof;
  
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
      localObject = new ag(paramLayoutInflater, 2131493496);
      ((View)localObject).setTag(new aj.e().z((View)localObject, false));
    }
    AppMethodBeat.o(37285);
    return localObject;
  }
  
  public final void a(a parama, bo parambo)
  {
    AppMethodBeat.i(37289);
    parambo.fbV();
    az.ayM();
    com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
    ((n)parama.bf(n.class)).bF(parambo);
    AppMethodBeat.o(37289);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37286);
    this.HNS = parama1;
    paramString = (aj.e)parama;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath);
    ImageView localImageView;
    if (localEmojiInfo != null)
    {
      parama = au.aOb(parambo.field_content);
      localEmojiInfo.talker = parambo.field_talker;
      paramString.Ilb.a(localEmojiInfo, parambo.field_msgId, parama);
      if (paramString.Iog != null)
      {
        if (!parama.GXr) {
          break label693;
        }
        paramString.Iog.setVisibility(0);
        TextView localTextView = (TextView)paramString.sSS.findViewById(2131298163).findViewById(2131298086);
        localTextView.setText(Html.fromHtml(parama1.HZF.getMMResources().getString(2131758237)));
        localImageView = (ImageView)paramString.sSS.findViewById(2131298163).findViewById(2131298085);
        localTextView.setTag(new bj(parambo, false, paramInt, parama1.foM(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
        localTextView.setOnClickListener(i(parama1));
        if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbQ())
        {
          localImageView.setVisibility(0);
          localImageView.setTag(new bj(parambo, parama1.foQ(), paramInt, parama1.foM(), '\000'));
          if (this.Iof == null) {
            this.Iof = new s.m(parama1);
          }
          localImageView.setOnClickListener(this.Iof);
        }
      }
      else
      {
        if ((localEmojiInfo.CC()) && (!parama.iaD))
        {
          parama.iaD = true;
          parambo.setContent(parama.dFY());
          az.ayM();
          parambo.setStatus(com.tencent.mm.model.c.awD().vP(parambo.field_msgId).field_status);
          az.ayM();
          com.tencent.mm.model.c.awD().ar(parambo);
        }
        if (!fqw()) {
          break label727;
        }
        b(paramString, false);
        if ((parambo.field_status != 2) || (!a((i)parama1.bf(i.class), parambo.field_msgId))) {
          break label706;
        }
        if (paramString.Ijf != null) {
          paramString.Ijf.setVisibility(0);
        }
        label421:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label774;
        }
        paramString.Ioh.setVisibility(0);
        parama = paramString.Ioh;
        if (this.Ioe == null) {
          this.Ioe = new aj.c(this.HNS);
        }
        parama.setOnClickListener(this.Ioe);
      }
    }
    else
    {
      label474:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.CC())) {
        break label894;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label787;
      }
      parama = this.HNS.HZF.getContext().getString(2131758267);
    }
    for (;;)
    {
      paramString.Ilb.setContentDescription(this.HNS.HZF.getContext().getString(2131758379) + parama);
      paramString.Ilb.setTag(new bj(parambo, parama1.foQ(), paramInt, parama1.foM(), '\000'));
      parama = paramString.Ilb;
      if (this.Iod == null) {
        this.Iod = new aj.d(parama1);
      }
      parama.setOnClickListener(this.Iod);
      paramString.Ilb.setOnLongClickListener(c(parama1));
      paramString.Ilb.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      a(paramInt, paramString, parambo, parama1.foM(), parama1.foQ(), parama1, this);
      AppMethodBeat.o(37286);
      return;
      localImageView.setVisibility(8);
      break;
      label693:
      paramString.Iog.setVisibility(8);
      break;
      label706:
      if (paramString.Ijf == null) {
        break label421;
      }
      paramString.Ijf.setVisibility(8);
      break label421;
      label727:
      if (paramString.Ijf != null) {
        paramString.Ijf.setVisibility(8);
      }
      if (parambo.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
      label774:
      paramString.Ioh.setVisibility(8);
      break label474;
      label787:
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
        label894:
        if (localEmojiInfo != null) {
          parama = bs.bG(((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(localEmojiInfo.JC()), "");
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37287);
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
          ac.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { parambo.field_imgPath });
          AppMethodBeat.o(37287);
          return true;
        }
        boolean bool1 = localEmojiInfo.fdp();
        if ((localEmojiInfo.field_catalog != EmojiInfo.Jsy) && (!localEmojiInfo.fxI()) && (!localEmojiInfo.fxJ()))
        {
          if (!bool1) {
            break label668;
          }
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
        }
        com.tencent.mm.search.c.b localb = com.tencent.mm.search.c.b.GwA;
        com.tencent.mm.search.c.b.b(localEmojiInfo, this.HNS.getTalkerUserName());
        boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSx, true);
        if ((!localEmojiInfo.CC()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
        {
          ac.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
          paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
        }
        if ((!localEmojiInfo.fxI()) && ((localEmojiInfo.field_catalog == EmojiInfo.Jsy) || (bs.isNullOrNil(localEmojiInfo.field_groupId)) || ((!bs.isNullOrNil(localEmojiInfo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(localEmojiInfo.field_groupId)))))
        {
          if (!bool1) {
            break label680;
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
      if ((!parambo.eZj()) && (parambo.fbC()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
      }
      if (parambo.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.JC(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(37287);
      return true;
      label668:
      ac.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      break;
      label680:
      ac.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    AppMethodBeat.i(37288);
    boolean bool = ((n)parama.bf(n.class)).a(paramMenuItem, parama, parambo);
    AppMethodBeat.o(37288);
    return bool;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.b
 * JD-Core Version:    0.7.0.1
 */