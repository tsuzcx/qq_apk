package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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

public final class aq$a
  extends c
{
  protected aq.d PND;
  private aq.c PNE;
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493553);
      ((View)localObject).setTag(new aq.e().G((View)localObject, true));
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
    this.PhN = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath);
    aq.e locale = (aq.e)parama;
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
        parama = be.bkr(paramca.field_content);
        locale.PKh.a(localEmojiInfo, paramca.field_msgId, parama);
        if ((localEmojiInfo.NA()) && (!parama.jsi))
        {
          bg.aVF();
          ca localca = com.tencent.mm.model.c.aSQ().Hb(paramca.field_msgId);
          parama.jsi = true;
          paramca.setContent(parama.bie());
          if (localca.getType() == 10000) {
            break label483;
          }
          bg.aVF();
          com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
        }
        label239:
        if (!com.tencent.mm.plugin.emoji.h.b.z(localEmojiInfo)) {
          break label494;
        }
        locale.PNI.setVisibility(0);
        parama = locale.PNI;
        if (this.PNE == null) {
          this.PNE = new aq.c(this.PhN);
        }
        parama.setOnClickListener(this.PNE);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.NA())) {
        break label614;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label507;
      }
      parama = this.PhN.Pwc.getContext().getString(2131758555);
    }
    label483:
    label614:
    for (;;)
    {
      locale.PKh.setContentDescription(this.PhN.Pwc.getContext().getString(2131758673) + parama);
      locale.PKh.setTag(new bq(paramca, parama1.gRM(), paramInt, paramString, '\000'));
      parama = locale.PKh;
      if (this.PND == null) {
        this.PND = new aq.d(parama1);
      }
      parama.setOnClickListener(this.PND);
      locale.PKh.setOnLongClickListener(c(parama1));
      locale.PKh.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      AppMethodBeat.o(37281);
      return;
      bool = false;
      break;
      Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label494:
      locale.PNI.setVisibility(8);
      break label292;
      label507:
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
        if (localEmojiInfo != null) {
          parama = Util.nullAs(((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(localEmojiInfo.getMd5()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37284);
    boolean bool = ((q)parama.bh(q.class)).a(paramMenuItem, parama, paramca);
    AppMethodBeat.o(37284);
    return bool;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233904);
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
          Log.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { paramca.field_imgPath });
          AppMethodBeat.o(233904);
          return true;
        }
        bool = localEmojiInfo.hRx();
        if ((localEmojiInfo.field_catalog != EmojiInfo.Uuv) && (!localEmojiInfo.hRB()) && (!localEmojiInfo.hRC()))
        {
          if (!bool) {
            break label511;
          }
          paramm.a(i, 104, paramView.getContext().getString(2131757447), 2131690478);
        }
        if (!localEmojiInfo.hRB())
        {
          if (!bool) {
            break label522;
          }
          paramm.a(i, 113, paramView.getContext().getString(2131764628), 2131690674);
        }
      }
    }
    for (;;)
    {
      paramca = com.tencent.mm.search.c.b.NJx;
      com.tencent.mm.search.c.b.c(localEmojiInfo, this.PhN.getTalkerUserName());
      bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXd, true);
      if ((!localEmojiInfo.NA()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
      {
        Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
        paramm.a(i, 115, paramView.getContext().getString(2131757450), 2131690630);
      }
      if (((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
        paramm.a(i, 135, paramView.getContext().getString(2131757436), 2131690592);
      }
      if ((com.tencent.mm.plugin.emoji.h.b.ani(localEmojiInfo.field_groupId)) && (!localEmojiInfo.NA()) && (!localEmojiInfo.hRC())) {
        paramm.a(i, 128, paramView.getContext().getString(2131757449), 2131690684);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, paramView.getContext().getString(2131757431), 2131690529);
      }
      h.CyF.a(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.getMd5(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      AppMethodBeat.o(233904);
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
    boolean bool = parama.gRM();
    AppMethodBeat.o(37282);
    return bool;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.a
 * JD-Core Version:    0.7.0.1
 */