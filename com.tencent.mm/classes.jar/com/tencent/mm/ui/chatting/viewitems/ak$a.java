package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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

public final class ak$a
  extends c
{
  private a JBI;
  protected ak.d KeD;
  private ak.c KeE;
  
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
      localObject = new ah(paramLayoutInflater, 2131493452);
      ((View)localObject).setTag(new ak.e().z((View)localObject, true));
    }
    AppMethodBeat.o(37280);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37281);
    if (parambu == null)
    {
      ad.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      AppMethodBeat.o(37281);
      return;
    }
    this.JBI = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath);
    ak.e locale = (ak.e)parama;
    boolean bool;
    if (localEmojiInfo == null)
    {
      parama = parambu.field_imgPath;
      if (localEmojiInfo == null)
      {
        bool = true;
        ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", new Object[] { parama, Boolean.valueOf(bool), Long.valueOf(parambu.field_msgId) });
      }
    }
    else
    {
      if (localEmojiInfo != null)
      {
        localEmojiInfo.talker = parambu.field_talker;
        parama = ay.aTS(parambu.field_content);
        locale.Kbz.a(localEmojiInfo, parambu.field_msgId, parama);
        if ((localEmojiInfo.Eb()) && (!parama.itZ))
        {
          ba.aBQ();
          bu localbu = com.tencent.mm.model.c.azs().xY(parambu.field_msgId);
          parama.itZ = true;
          parambu.setContent(parama.dRS());
          if (localbu.getType() == 10000) {
            break label483;
          }
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
        }
        label239:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label494;
        }
        locale.KeH.setVisibility(0);
        parama = locale.KeH;
        if (this.KeE == null) {
          this.KeE = new ak.c(this.JBI);
        }
        parama.setOnClickListener(this.KeE);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.Eb())) {
        break label614;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label507;
      }
      parama = this.JBI.JOR.getContext().getString(2131758267);
    }
    label483:
    label614:
    for (;;)
    {
      locale.Kbz.setContentDescription(this.JBI.JOR.getContext().getString(2131758379) + parama);
      locale.Kbz.setTag(new bk(parambu, parama1.fFv(), paramInt, paramString, '\000'));
      parama = locale.Kbz;
      if (this.KeD == null) {
        this.KeD = new ak.d(parama1);
      }
      parama.setOnClickListener(this.KeD);
      locale.Kbz.setOnLongClickListener(c(parama1));
      locale.Kbz.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
      AppMethodBeat.o(37281);
      return;
      bool = false;
      break;
      ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label494:
      locale.KeH.setVisibility(8);
      break label292;
      label507:
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
        if (localEmojiInfo != null) {
          parama = bt.bI(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(localEmojiInfo.Lb()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(37284);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambu);
    AppMethodBeat.o(37284);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194480);
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
          ad.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { parambu.field_imgPath });
          AppMethodBeat.o(194480);
          return true;
        }
        bool = localEmojiInfo.fOu();
        if ((localEmojiInfo.field_catalog != EmojiInfo.OeT) && (!localEmojiInfo.fOy()) && (!localEmojiInfo.fUf()))
        {
          if (!bool) {
            break label544;
          }
          paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
        }
        if ((!localEmojiInfo.fOy()) && ((localEmojiInfo.field_catalog == EmojiInfo.OeT) || (bt.isNullOrNil(localEmojiInfo.field_groupId)) || (!bt.isNullOrNil(localEmojiInfo.field_groupId))))
        {
          if (!bool) {
            break label555;
          }
          paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
        }
      }
    }
    for (;;)
    {
      parambu = com.tencent.mm.search.c.b.Iiu;
      com.tencent.mm.search.c.b.b(localEmojiInfo, this.JBI.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwY, true);
      if ((!localEmojiInfo.Eb()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
        paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cgy()) {
        paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
      }
      if ((com.tencent.mm.plugin.emoji.h.b.acj(localEmojiInfo.field_groupId)) && (!localEmojiInfo.Eb()) && (!localEmojiInfo.fUf())) {
        paraml.a(i, 128, paramView.getContext().getString(2131757237), 2131691582);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Lb(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(194480);
      return true;
      label544:
      ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label555:
      ad.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(37282);
    boolean bool = parama.fFv();
    AppMethodBeat.o(37282);
    return bool;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.a
 * JD-Core Version:    0.7.0.1
 */