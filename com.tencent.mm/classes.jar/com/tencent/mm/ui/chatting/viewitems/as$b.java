package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Html;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.c.b;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.t;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.m;
import com.tencent.mm.ui.chatting.v.n;

public final class as$b
  extends c
  implements v.n
{
  protected as.d aeTW;
  private as.c aeTX;
  protected v.m aeTY;
  private a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.ggZ);
      ((View)localObject).setTag(new as.e().P((View)localObject, false));
    }
    AppMethodBeat.o(37285);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37286);
    this.aeiK = parama1;
    paramString = (as.e)parama;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath);
    ImageView localImageView;
    if (localEmojiInfo != null)
    {
      parama = bg.byj(paramcc.field_content);
      localEmojiInfo.talker = paramcc.field_talker;
      paramString.aePJ.a(localEmojiInfo, paramcc.field_msgId, parama);
      if ((parama != null) && (paramString.aeTZ != null))
      {
        if (!parama.adiM) {
          break label670;
        }
        paramString.aeTZ.setVisibility(0);
        TextView localTextView = (TextView)paramString.convertView.findViewById(R.h.fzU).findViewById(R.h.fxM);
        localTextView.setText(Html.fromHtml(parama1.aezO.getMMResources().getString(R.l.emoji_chatting_reward_tips)));
        localImageView = (ImageView)paramString.convertView.findViewById(R.h.fzU).findViewById(R.h.fxL);
        localTextView.setTag(new bz(paramcc, false, paramInt, parama1.getSelfUserName(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
        localTextView.setOnClickListener(i(parama1));
        if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzt())
        {
          localImageView.setVisibility(0);
          localImageView.setTag(new bz(paramcc, parama1.juG(), paramInt, parama1.getSelfUserName(), '\000'));
          if (this.aeTY == null) {
            this.aeTY = new v.m(parama1);
          }
          localImageView.setOnClickListener(this.aeTY);
        }
      }
      else
      {
        if ((localEmojiInfo.aqJ()) && (!parama.paW))
        {
          parama.paW = true;
          paramcc.setContent(parama.bPi());
          bh.bCz();
          paramcc.setStatus(com.tencent.mm.model.c.bzD().sl(paramcc.field_msgId).field_status);
          bh.bCz();
          com.tencent.mm.model.c.bzD().bc(paramcc);
        }
        if (!jxj()) {
          break label704;
        }
        b(paramString, false);
        if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
          break label683;
        }
        if (paramString.aeNG != null) {
          paramString.aeNG.setVisibility(0);
        }
        label430:
        if (!com.tencent.mm.plugin.emoji.g.d.B(localEmojiInfo)) {
          break label751;
        }
        paramString.aeUa.setVisibility(0);
        parama = paramString.aeUa;
        if (this.aeTX == null) {
          this.aeTX = new as.c(this.aeiK);
        }
        parama.setOnClickListener(this.aeTX);
      }
    }
    else
    {
      label483:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.aqJ())) {
        break label871;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label764;
      }
      parama = this.aeiK.aezO.getContext().getString(R.l.emoji_jsb_j);
    }
    label670:
    label683:
    label704:
    label871:
    for (;;)
    {
      paramString.aePJ.setContentDescription(parama);
      paramString.aePJ.setTag(new bz(paramcc, parama1.juG(), paramInt, parama1.getSelfUserName(), '\000'));
      parama = paramString.aePJ;
      if (this.aeTW == null) {
        this.aeTW = new as.d(parama1);
      }
      parama.setOnClickListener(this.aeTW);
      paramString.aePJ.setOnLongClickListener(c(parama1));
      paramString.aePJ.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
      AppMethodBeat.o(37286);
      return;
      localImageView.setVisibility(8);
      break;
      paramString.aeTZ.setVisibility(8);
      break;
      if (paramString.aeNG == null) {
        break label430;
      }
      paramString.aeNG.setVisibility(8);
      break label430;
      if (paramString.aeNG != null) {
        paramString.aeNG.setVisibility(8);
      }
      if (paramcc.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(paramString, bool);
        break;
      }
      label751:
      paramString.aeUa.setVisibility(8);
      break label483;
      label764:
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.aeiK.aezO.getContext().getString(R.l.emoji_jsb_s);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.aeiK.aezO.getContext().getString(R.l.emoji_jsb_b);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        if (localEmojiInfo != null) {
          parama = Util.nullAs(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(localEmojiInfo.getMd5()), "");
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    AppMethodBeat.i(37288);
    boolean bool = ((t)parama.cm(t.class)).a(paramMenuItem, parama, paramcc);
    AppMethodBeat.o(37288);
    return bool;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255371);
    int i;
    boolean bool1;
    boolean bool2;
    if (paramcc.jbG())
    {
      bh.bCz();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((bz)paramView.getTag()).position;
        paramContextMenuInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath);
        if (paramContextMenuInfo == null)
        {
          Log.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { paramcc.field_imgPath });
          AppMethodBeat.o(255371);
          return true;
        }
        bool1 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        bool2 = paramContextMenuInfo.kLZ();
        if ((paramContextMenuInfo.field_catalog != EmojiInfo.aklM) && (!paramContextMenuInfo.kMe()) && (!paramContextMenuInfo.kMf()))
        {
          if (!bool2) {
            break label643;
          }
          params.a(i, 104, paramView.getContext().getString(R.l.gyB), R.k.icons_filled_addsticker);
        }
        if (!paramContextMenuInfo.kMe())
        {
          if (!bool2) {
            break label655;
          }
          params.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
    }
    for (;;)
    {
      b localb = b.acsj;
      b.c(paramContextMenuInfo, this.aeiK.getTalkerUserName());
      bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTb, true);
      if ((!bool1) && (!paramContextMenuInfo.aqJ()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
      {
        Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
        params.a(i, 115, paramView.getContext().getString(R.l.gyD), R.k.icons_filled_othersticker);
      }
      if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzy()) {
        params.a(i, 135, paramView.getContext().getString(R.l.gyr), R.k.icons_filled_makesticker);
      }
      if ((!bool1) && (com.tencent.mm.plugin.emoji.g.d.ape(paramContextMenuInfo.field_groupId)) && (!paramContextMenuInfo.aqJ()) && (!paramContextMenuInfo.kMf())) {
        params.a(i, 128, paramView.getContext().getString(R.l.gyC), R.k.icons_filled_sticker_album);
      }
      if ((!paramcc.iYe()) && (paramcc.jbG()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
        params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, paramView.getContext().getString(R.l.gym), R.k.icons_filled_delete);
      }
      if (paramcc.field_status == 5) {
        params.a(i, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(0), paramContextMenuInfo.getMd5(), Integer.valueOf(0), paramContextMenuInfo.field_designerID, paramContextMenuInfo.field_groupId, "", "", "", "", "", paramContextMenuInfo.field_activityid });
      AppMethodBeat.o(255371);
      return true;
      label643:
      Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      break;
      label655:
      Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
    }
  }
  
  public final void b(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(255381);
    paramcc.unsetOmittedFailResend();
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    ((t)parama.cm(t.class)).cQ(paramcc);
    AppMethodBeat.o(255381);
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.b
 * JD-Core Version:    0.7.0.1
 */