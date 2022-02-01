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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.t.n;

public final class ak$b
  extends c
  implements t.n
{
  private a JWz;
  protected ak.d KAW;
  private ak.c KAX;
  protected t.m KAY;
  
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
      localObject = new ah(paramLayoutInflater, 2131493496);
      ((View)localObject).setTag(new ak.e().E((View)localObject, false));
    }
    AppMethodBeat.o(37285);
    return localObject;
  }
  
  public final void a(a parama, bv parambv)
  {
    AppMethodBeat.i(37289);
    parambv.fvZ();
    bc.aCg();
    com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
    ((p)parama.bh(p.class)).bK(parambv);
    AppMethodBeat.o(37289);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37286);
    this.JWz = parama1;
    paramString = (ak.e)parama;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath);
    ImageView localImageView;
    if (localEmojiInfo != null)
    {
      parama = az.aVt(parambv.field_content);
      localEmojiInfo.talker = parambv.field_talker;
      paramString.KxR.a(localEmojiInfo, parambv.field_msgId, parama);
      if (paramString.KAZ != null)
      {
        if (!parama.Jfm) {
          break label693;
        }
        paramString.KAZ.setVisibility(0);
        TextView localTextView = (TextView)paramString.uan.findViewById(2131298163).findViewById(2131298086);
        localTextView.setText(Html.fromHtml(parama1.Kkd.getMMResources().getString(2131758237)));
        localImageView = (ImageView)paramString.uan.findViewById(2131298163).findViewById(2131298085);
        localTextView.setTag(new bk(parambv, false, paramInt, parama1.fJy(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
        localTextView.setOnClickListener(i(parama1));
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().chK())
        {
          localImageView.setVisibility(0);
          localImageView.setTag(new bk(parambv, parama1.fJC(), paramInt, parama1.fJy(), '\000'));
          if (this.KAY == null) {
            this.KAY = new t.m(parama1);
          }
          localImageView.setOnClickListener(this.KAY);
        }
      }
      else
      {
        if ((localEmojiInfo.Ee()) && (!parama.iwT))
        {
          parama.iwT = true;
          parambv.setContent(parama.dVq());
          bc.aCg();
          parambv.setStatus(com.tencent.mm.model.c.azI().ys(parambv.field_msgId).field_status);
          bc.aCg();
          com.tencent.mm.model.c.azI().at(parambv);
        }
        if (!fLB()) {
          break label727;
        }
        b(paramString, false);
        if ((parambv.field_status != 2) || (!b((k)parama1.bh(k.class), parambv.field_msgId))) {
          break label706;
        }
        if (paramString.KvW != null) {
          paramString.KvW.setVisibility(0);
        }
        label421:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label774;
        }
        paramString.KBa.setVisibility(0);
        parama = paramString.KBa;
        if (this.KAX == null) {
          this.KAX = new ak.c(this.JWz);
        }
        parama.setOnClickListener(this.KAX);
      }
    }
    else
    {
      label474:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.Ee())) {
        break label894;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label787;
      }
      parama = this.JWz.Kkd.getContext().getString(2131758267);
    }
    for (;;)
    {
      paramString.KxR.setContentDescription(this.JWz.Kkd.getContext().getString(2131758379) + parama);
      paramString.KxR.setTag(new bk(parambv, parama1.fJC(), paramInt, parama1.fJy(), '\000'));
      parama = paramString.KxR;
      if (this.KAW == null) {
        this.KAW = new ak.d(parama1);
      }
      parama.setOnClickListener(this.KAW);
      paramString.KxR.setOnLongClickListener(c(parama1));
      paramString.KxR.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
      a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
      AppMethodBeat.o(37286);
      return;
      localImageView.setVisibility(8);
      break;
      label693:
      paramString.KAZ.setVisibility(8);
      break;
      label706:
      if (paramString.KvW == null) {
        break label421;
      }
      paramString.KvW.setVisibility(8);
      break label421;
      label727:
      if (paramString.KvW != null) {
        paramString.KvW.setVisibility(8);
      }
      if (parambv.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
      label774:
      paramString.KBa.setVisibility(8);
      break label474;
      label787:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.JWz.Kkd.getContext().getString(2131758268);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.JWz.Kkd.getContext().getString(2131758266);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        label894:
        if (localEmojiInfo != null) {
          parama = bu.bI(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(localEmojiInfo.Lj()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    AppMethodBeat.i(37288);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambv);
    AppMethodBeat.o(37288);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187876);
    int i;
    EmojiInfo localEmojiInfo;
    boolean bool;
    if (parambv.fvG())
    {
      bc.aCg();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((bk)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath);
        if (localEmojiInfo == null)
        {
          ae.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { parambv.field_imgPath });
          AppMethodBeat.o(187876);
          return true;
        }
        bool = localEmojiInfo.fxn();
        if ((localEmojiInfo.field_catalog != EmojiInfo.OAa) && (!localEmojiInfo.fxr()) && (!localEmojiInfo.fxs()))
        {
          if (!bool) {
            break label623;
          }
          paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
        }
        if (!localEmojiInfo.fxr())
        {
          if (!bool) {
            break label635;
          }
          paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.search.c.b localb = com.tencent.mm.search.c.b.ICF;
      com.tencent.mm.search.c.b.b(localEmojiInfo, this.JWz.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDY, true);
      if ((!localEmojiInfo.Ee()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        ae.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
        paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().chO()) {
        paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
      }
      if ((com.tencent.mm.plugin.emoji.h.b.ada(localEmojiInfo.field_groupId)) && (!localEmojiInfo.Ee()) && (!localEmojiInfo.fxs())) {
        paraml.a(i, 128, paramView.getContext().getString(2131757237), 2131691582);
      }
      if ((!parambv.fta()) && (parambv.fvG()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
      }
      if (parambv.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Lj(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(187876);
      return true;
      label623:
      ae.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      break;
      label635:
      ae.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
    }
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.b
 * JD-Core Version:    0.7.0.1
 */