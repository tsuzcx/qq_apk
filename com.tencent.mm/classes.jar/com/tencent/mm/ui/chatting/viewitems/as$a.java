package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public final class as$a
  extends c
{
  protected as.d aeTW;
  private as.c aeTX;
  private a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.gfZ);
      ((View)localObject).setTag(new as.e().P((View)localObject, true));
    }
    AppMethodBeat.o(37280);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37281);
    if (paramcc == null)
    {
      Log.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      AppMethodBeat.o(37281);
      return;
    }
    this.aeiK = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath);
    as.e locale = (as.e)parama;
    boolean bool;
    if (localEmojiInfo == null)
    {
      parama = paramcc.field_imgPath;
      if (localEmojiInfo == null)
      {
        bool = true;
        Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", new Object[] { parama, Boolean.valueOf(bool), Long.valueOf(paramcc.field_msgId) });
      }
    }
    else
    {
      if (localEmojiInfo != null)
      {
        localEmojiInfo.talker = paramcc.field_talker;
        parama = bg.byj(paramcc.field_content);
        locale.aePJ.a(localEmojiInfo, paramcc.field_msgId, parama);
        if ((localEmojiInfo.aqJ()) && (!parama.paW))
        {
          bh.bCz();
          cc localcc = com.tencent.mm.model.c.bzD().sl(paramcc.field_msgId);
          parama.paW = true;
          paramcc.setContent(parama.bPi());
          if (localcc.getType() == 10000) {
            break label485;
          }
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
        }
        label239:
        if (!com.tencent.mm.plugin.emoji.g.d.B(localEmojiInfo)) {
          break label496;
        }
        locale.aeUa.setVisibility(0);
        parama = locale.aeUa;
        if (this.aeTX == null) {
          this.aeTX = new as.c(this.aeiK);
        }
        parama.setOnClickListener(this.aeTX);
      }
      label292:
      parama = "";
      if ((localEmojiInfo == null) || (!localEmojiInfo.aqJ())) {
        break label616;
      }
      if (!localEmojiInfo.field_name.startsWith("jsb_j")) {
        break label509;
      }
      parama = this.aeiK.aezO.getContext().getString(R.l.emoji_jsb_j);
    }
    label485:
    label616:
    for (;;)
    {
      locale.aePJ.setContentDescription(this.aeiK.aezO.getContext().getString(R.l.emoji_store_title) + parama);
      locale.aePJ.setTag(new bz(paramcc, parama1.juG(), paramInt, paramString, '\000'));
      parama = locale.aePJ;
      if (this.aeTW == null) {
        this.aeTW = new as.d(parama1);
      }
      parama.setOnClickListener(this.aeTW);
      locale.aePJ.setOnLongClickListener(c(parama1));
      locale.aePJ.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      AppMethodBeat.o(37281);
      return;
      bool = false;
      break;
      Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
      break label239;
      label496:
      locale.aeUa.setVisibility(8);
      break label292;
      label509:
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
    AppMethodBeat.i(37284);
    boolean bool = ((t)parama.cm(t.class)).a(paramMenuItem, parama, paramcc);
    AppMethodBeat.o(37284);
    return bool;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255368);
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
          Log.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { paramcc.field_imgPath });
          AppMethodBeat.o(255368);
          return true;
        }
        bool1 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        bool2 = paramContextMenuInfo.kLZ();
        if ((paramContextMenuInfo.field_catalog != EmojiInfo.aklM) && (!paramContextMenuInfo.kMe()) && (!paramContextMenuInfo.kMf()))
        {
          if (!bool2) {
            break label525;
          }
          params.a(i, 104, paramView.getContext().getString(R.l.gyB), R.k.icons_filled_addsticker);
        }
        if (!paramContextMenuInfo.kMe())
        {
          if (!bool2) {
            break label536;
          }
          params.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
    }
    for (;;)
    {
      paramcc = b.acsj;
      b.c(paramContextMenuInfo, this.aeiK.getTalkerUserName());
      bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTb, true);
      if ((!bool1) && (!paramContextMenuInfo.aqJ()) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
      {
        Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
        params.a(i, 115, paramView.getContext().getString(R.l.gyD), R.k.icons_filled_othersticker);
      }
      if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzy()) {
        params.a(i, 135, paramView.getContext().getString(R.l.gyr), R.k.icons_filled_makesticker);
      }
      if ((!bool1) && (com.tencent.mm.plugin.emoji.g.d.ape(paramContextMenuInfo.field_groupId)) && (!paramContextMenuInfo.aqJ()) && (!paramContextMenuInfo.kMf())) {
        params.a(i, 128, paramView.getContext().getString(R.l.gyC), R.k.icons_filled_sticker_album);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, paramView.getContext().getString(R.l.gym), R.k.icons_filled_delete);
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(0), paramContextMenuInfo.getMd5(), Integer.valueOf(0), paramContextMenuInfo.field_designerID, paramContextMenuInfo.field_groupId, "", "", "", "", paramContextMenuInfo.field_activityid });
      AppMethodBeat.o(255368);
      return true;
      label525:
      Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label536:
      Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(37282);
    boolean bool = parama.juG();
    AppMethodBeat.o(37282);
    return bool;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.a
 * JD-Core Version:    0.7.0.1
 */