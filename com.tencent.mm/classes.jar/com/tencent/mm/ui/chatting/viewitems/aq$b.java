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
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.t.n;

public final class aq$b
  extends c
  implements t.n
{
  protected aq.d PND;
  private aq.c PNE;
  protected t.m PNF;
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493604);
      ((View)localObject).setTag(new aq.e().G((View)localObject, false));
    }
    AppMethodBeat.o(37285);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37286);
    this.PhN = parama1;
    paramString = (aq.e)parama;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath);
    ImageView localImageView;
    if (localEmojiInfo != null)
    {
      parama = be.bkr(paramca.field_content);
      localEmojiInfo.talker = paramca.field_talker;
      paramString.PKh.a(localEmojiInfo, paramca.field_msgId, parama);
      if (paramString.PNH != null)
      {
        if (!parama.Opg) {
          break label693;
        }
        paramString.PNH.setVisibility(0);
        TextView localTextView = (TextView)paramString.convertView.findViewById(2131298541).findViewById(2131298430);
        localTextView.setText(Html.fromHtml(parama1.Pwc.getMMResources().getString(2131758525)));
        localImageView = (ImageView)paramString.convertView.findViewById(2131298541).findViewById(2131298429);
        localTextView.setTag(new bq(paramca, false, paramInt, parama1.gRI(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
        localTextView.setOnClickListener(i(parama1));
        if (((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFH())
        {
          localImageView.setVisibility(0);
          localImageView.setTag(new bq(paramca, parama1.gRM(), paramInt, parama1.gRI(), '\000'));
          if (this.PNF == null) {
            this.PNF = new t.m(parama1);
          }
          localImageView.setOnClickListener(this.PNF);
        }
      }
      else
      {
        if ((localEmojiInfo.NA()) && (!parama.jsi))
        {
          parama.jsi = true;
          paramca.setContent(parama.bie());
          bg.aVF();
          paramca.setStatus(com.tencent.mm.model.c.aSQ().Hb(paramca.field_msgId).field_status);
          bg.aVF();
          com.tencent.mm.model.c.aSQ().aE(paramca);
        }
        if (!gTW()) {
          break label727;
        }
        b(paramString, false);
        if ((paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
          break label706;
        }
        if (paramString.PIn != null) {
          paramString.PIn.setVisibility(0);
        }
        label421:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label774;
        }
        paramString.PNI.setVisibility(0);
        parama = paramString.PNI;
        if (this.PNE == null) {
          this.PNE = new aq.c(this.PhN);
        }
        parama.setOnClickListener(this.PNE);
      }
    }
    else
    {
      label474:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.NA())) {
        break label894;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label787;
      }
      parama = this.PhN.Pwc.getContext().getString(2131758555);
    }
    for (;;)
    {
      paramString.PKh.setContentDescription(this.PhN.Pwc.getContext().getString(2131758673) + parama);
      paramString.PKh.setTag(new bq(paramca, parama1.gRM(), paramInt, parama1.gRI(), '\000'));
      parama = paramString.PKh;
      if (this.PND == null) {
        this.PND = new aq.d(parama1);
      }
      parama.setOnClickListener(this.PND);
      paramString.PKh.setOnLongClickListener(c(parama1));
      paramString.PKh.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
      AppMethodBeat.o(37286);
      return;
      localImageView.setVisibility(8);
      break;
      label693:
      paramString.PNH.setVisibility(8);
      break;
      label706:
      if (paramString.PIn == null) {
        break label421;
      }
      paramString.PIn.setVisibility(8);
      break label421;
      label727:
      if (paramString.PIn != null) {
        paramString.PIn.setVisibility(8);
      }
      if (paramca.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
      label774:
      paramString.PNI.setVisibility(8);
      break label474;
      label787:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.PhN.Pwc.getContext().getString(2131758556);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.PhN.Pwc.getContext().getString(2131758554);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        label894:
        if (localEmojiInfo != null) {
          parama = Util.nullAs(((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(localEmojiInfo.getMd5()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37288);
    boolean bool = ((q)parama.bh(q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(37288);
    return bool;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233905);
    int i;
    EmojiInfo localEmojiInfo;
    boolean bool;
    if (paramca.gDn())
    {
      bg.aVF();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((bq)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath);
        if (localEmojiInfo == null)
        {
          Log.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { paramca.field_imgPath });
          AppMethodBeat.o(233905);
          return true;
        }
        bool = localEmojiInfo.hRx();
        if ((localEmojiInfo.field_catalog != EmojiInfo.Uuv) && (!localEmojiInfo.hRB()) && (!localEmojiInfo.hRC()))
        {
          if (!bool) {
            break label623;
          }
          paramm.a(i, 104, paramView.getContext().getString(2131757447), 2131690478);
        }
        if (!localEmojiInfo.hRB())
        {
          if (!bool) {
            break label635;
          }
          paramm.a(i, 113, paramView.getContext().getString(2131764628), 2131690674);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.search.c.b localb = com.tencent.mm.search.c.b.NJx;
      com.tencent.mm.search.c.b.c(localEmojiInfo, this.PhN.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXd, true);
      if ((!localEmojiInfo.NA()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
        paramm.a(i, 115, paramView.getContext().getString(2131757450), 2131690630);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
        paramm.a(i, 135, paramView.getContext().getString(2131757436), 2131690592);
      }
      if ((com.tencent.mm.plugin.emoji.h.b.ani(localEmojiInfo.field_groupId)) && (!localEmojiInfo.NA()) && (!localEmojiInfo.hRC())) {
        paramm.a(i, 128, paramView.getContext().getString(2131757449), 2131690684);
      }
      if ((!paramca.gAt()) && (paramca.gDn()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, paramView.getContext().getString(2131757431), 2131690529);
      }
      if (paramca.field_status == 5) {
        paramm.a(i, 103, paramView.getContext().getString(2131757500), 2131690658);
      }
      h.CyF.a(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.getMd5(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(233905);
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
    AppMethodBeat.i(233906);
    paramca.unsetOmittedFailResend();
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
    ((q)parama.bh(q.class)).ca(paramca);
    AppMethodBeat.o(233906);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 47);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.b
 * JD-Core Version:    0.7.0.1
 */