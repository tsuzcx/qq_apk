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
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.s.m;
import com.tencent.mm.ui.chatting.s.n;

public final class ak$b
  extends c
  implements s.n
{
  private a JBI;
  protected ak.d KeD;
  private ak.c KeE;
  protected s.m KeF;
  
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
      ((View)localObject).setTag(new ak.e().z((View)localObject, false));
    }
    AppMethodBeat.o(37285);
    return localObject;
  }
  
  public final void a(a parama, bu parambu)
  {
    AppMethodBeat.i(37289);
    parambu.frY();
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
    ((p)parama.bh(p.class)).bL(parambu);
    AppMethodBeat.o(37289);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37286);
    this.JBI = parama1;
    paramString = (ak.e)parama;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath);
    ImageView localImageView;
    if (localEmojiInfo != null)
    {
      parama = ay.aTS(parambu.field_content);
      localEmojiInfo.talker = parambu.field_talker;
      paramString.Kbz.a(localEmojiInfo, parambu.field_msgId, parama);
      if (paramString.KeG != null)
      {
        if (!parama.IKF) {
          break label693;
        }
        paramString.KeG.setVisibility(0);
        TextView localTextView = (TextView)paramString.tPw.findViewById(2131298163).findViewById(2131298086);
        localTextView.setText(Html.fromHtml(parama1.JOR.getMMResources().getString(2131758237)));
        localImageView = (ImageView)paramString.tPw.findViewById(2131298163).findViewById(2131298085);
        localTextView.setTag(new bk(parambu, false, paramInt, parama1.fFr(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
        localTextView.setOnClickListener(i(parama1));
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cgu())
        {
          localImageView.setVisibility(0);
          localImageView.setTag(new bk(parambu, parama1.fFv(), paramInt, parama1.fFr(), '\000'));
          if (this.KeF == null) {
            this.KeF = new s.m(parama1);
          }
          localImageView.setOnClickListener(this.KeF);
        }
      }
      else
      {
        if ((localEmojiInfo.Eb()) && (!parama.itZ))
        {
          parama.itZ = true;
          parambu.setContent(parama.dRS());
          ba.aBQ();
          parambu.setStatus(com.tencent.mm.model.c.azs().xY(parambu.field_msgId).field_status);
          ba.aBQ();
          com.tencent.mm.model.c.azs().au(parambu);
        }
        if (!fHj()) {
          break label727;
        }
        b(paramString, false);
        if ((parambu.field_status != 2) || (!b((k)parama1.bh(k.class), parambu.field_msgId))) {
          break label706;
        }
        if (paramString.JZD != null) {
          paramString.JZD.setVisibility(0);
        }
        label421:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label774;
        }
        paramString.KeH.setVisibility(0);
        parama = paramString.KeH;
        if (this.KeE == null) {
          this.KeE = new ak.c(this.JBI);
        }
        parama.setOnClickListener(this.KeE);
      }
    }
    else
    {
      label474:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.Eb())) {
        break label894;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label787;
      }
      parama = this.JBI.JOR.getContext().getString(2131758267);
    }
    for (;;)
    {
      paramString.Kbz.setContentDescription(this.JBI.JOR.getContext().getString(2131758379) + parama);
      paramString.Kbz.setTag(new bk(parambu, parama1.fFv(), paramInt, parama1.fFr(), '\000'));
      parama = paramString.Kbz;
      if (this.KeD == null) {
        this.KeD = new ak.d(parama1);
      }
      parama.setOnClickListener(this.KeD);
      paramString.Kbz.setOnLongClickListener(c(parama1));
      paramString.Kbz.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
      a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
      AppMethodBeat.o(37286);
      return;
      localImageView.setVisibility(8);
      break;
      label693:
      paramString.KeG.setVisibility(8);
      break;
      label706:
      if (paramString.JZD == null) {
        break label421;
      }
      paramString.JZD.setVisibility(8);
      break label421;
      label727:
      if (paramString.JZD != null) {
        paramString.JZD.setVisibility(8);
      }
      if (parambu.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
      label774:
      paramString.KeH.setVisibility(8);
      break label474;
      label787:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.JBI.JOR.getContext().getString(2131758268);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.JBI.JOR.getContext().getString(2131758266);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        label894:
        if (localEmojiInfo != null) {
          parama = bt.bI(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(localEmojiInfo.Lb()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(37288);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambu);
    AppMethodBeat.o(37288);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194481);
    int i;
    EmojiInfo localEmojiInfo;
    boolean bool;
    if (parambu.frG())
    {
      ba.aBQ();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((bk)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath);
        if (localEmojiInfo == null)
        {
          ad.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { parambu.field_imgPath });
          AppMethodBeat.o(194481);
          return true;
        }
        bool = localEmojiInfo.fOu();
        if ((localEmojiInfo.field_catalog != EmojiInfo.OeT) && (!localEmojiInfo.fOy()) && (!localEmojiInfo.fUf()))
        {
          if (!bool) {
            break label656;
          }
          paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
        }
        if ((!localEmojiInfo.fOy()) && ((localEmojiInfo.field_catalog == EmojiInfo.OeT) || (bt.isNullOrNil(localEmojiInfo.field_groupId)) || (!bt.isNullOrNil(localEmojiInfo.field_groupId))))
        {
          if (!bool) {
            break label668;
          }
          paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.search.c.b localb = com.tencent.mm.search.c.b.Iiu;
      com.tencent.mm.search.c.b.b(localEmojiInfo, this.JBI.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwY, true);
      if ((!localEmojiInfo.Eb()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        ad.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
        paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cgy()) {
        paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
      }
      if ((com.tencent.mm.plugin.emoji.h.b.acj(localEmojiInfo.field_groupId)) && (!localEmojiInfo.Eb()) && (!localEmojiInfo.fUf())) {
        paraml.a(i, 128, paramView.getContext().getString(2131757237), 2131691582);
      }
      if ((!parambu.fpd()) && (parambu.frG()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
      }
      if (parambu.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Lb(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(194481);
      return true;
      label656:
      ad.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      break;
      label668:
      ad.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
    }
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.b
 * JD-Core Version:    0.7.0.1
 */