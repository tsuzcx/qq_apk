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

public final class ak$a
  extends c
{
  private a JWz;
  protected ak.d KAW;
  private ak.c KAX;
  
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
      ((View)localObject).setTag(new ak.e().E((View)localObject, true));
    }
    AppMethodBeat.o(37280);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37281);
    if (parambv == null)
    {
      ae.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      AppMethodBeat.o(37281);
      return;
    }
    this.JWz = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath);
    ak.e locale = (ak.e)parama;
    boolean bool;
    if (localEmojiInfo == null)
    {
      parama = parambv.field_imgPath;
      if (localEmojiInfo == null)
      {
        bool = true;
        ae.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", new Object[] { parama, Boolean.valueOf(bool), Long.valueOf(parambv.field_msgId) });
      }
    }
    else
    {
      if (localEmojiInfo != null)
      {
        localEmojiInfo.talker = parambv.field_talker;
        parama = az.aVt(parambv.field_content);
        locale.KxR.a(localEmojiInfo, parambv.field_msgId, parama);
        if ((localEmojiInfo.Ee()) && (!parama.iwT))
        {
          bc.aCg();
          bv localbv = com.tencent.mm.model.c.azI().ys(parambv.field_msgId);
          parama.iwT = true;
          parambv.setContent(parama.dVq());
          if (localbv.getType() == 10000) {
            break label483;
          }
          bc.aCg();
          com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
        }
        label239:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label494;
        }
        locale.KBa.setVisibility(0);
        parama = locale.KBa;
        if (this.KAX == null) {
          this.KAX = new ak.c(this.JWz);
        }
        parama.setOnClickListener(this.KAX);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.Ee())) {
        break label614;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label507;
      }
      parama = this.JWz.Kkd.getContext().getString(2131758267);
    }
    label483:
    label614:
    for (;;)
    {
      locale.KxR.setContentDescription(this.JWz.Kkd.getContext().getString(2131758379) + parama);
      locale.KxR.setTag(new bk(parambv, parama1.fJC(), paramInt, paramString, '\000'));
      parama = locale.KxR;
      if (this.KAW == null) {
        this.KAW = new ak.d(parama1);
      }
      parama.setOnClickListener(this.KAW);
      locale.KxR.setOnLongClickListener(c(parama1));
      locale.KxR.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
      AppMethodBeat.o(37281);
      return;
      bool = false;
      break;
      ae.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label494:
      locale.KBa.setVisibility(8);
      break label292;
      label507:
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
        if (localEmojiInfo != null) {
          parama = bu.bI(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(localEmojiInfo.Lj()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    AppMethodBeat.i(37284);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambv);
    AppMethodBeat.o(37284);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187875);
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
          ae.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { parambv.field_imgPath });
          AppMethodBeat.o(187875);
          return true;
        }
        bool = localEmojiInfo.fxn();
        if ((localEmojiInfo.field_catalog != EmojiInfo.OAa) && (!localEmojiInfo.fxr()) && (!localEmojiInfo.fxs()))
        {
          if (!bool) {
            break label511;
          }
          paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
        }
        if (!localEmojiInfo.fxr())
        {
          if (!bool) {
            break label522;
          }
          paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
        }
      }
    }
    for (;;)
    {
      parambv = com.tencent.mm.search.c.b.ICF;
      com.tencent.mm.search.c.b.b(localEmojiInfo, this.JWz.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDY, true);
      if ((!localEmojiInfo.Ee()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        ae.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
        paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().chO()) {
        paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
      }
      if ((com.tencent.mm.plugin.emoji.h.b.ada(localEmojiInfo.field_groupId)) && (!localEmojiInfo.Ee()) && (!localEmojiInfo.fxs())) {
        paraml.a(i, 128, paramView.getContext().getString(2131757237), 2131691582);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Lj(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(187875);
      return true;
      label511:
      ae.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label522:
      ae.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(37282);
    boolean bool = parama.fJC();
    AppMethodBeat.o(37282);
    return bool;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.a
 * JD-Core Version:    0.7.0.1
 */