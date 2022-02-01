package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.c.b;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.component.api.t;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class m$c
  extends c
{
  protected m.a aePP;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  private m.a m(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36924);
    if (this.aePP == null) {
      this.aePP = new m.a(parama);
    }
    parama = this.aePP;
    AppMethodBeat.o(36924);
    return parama;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36925);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfB);
      ((View)localObject).setTag(new m.b().P((View)localObject, true));
    }
    AppMethodBeat.o(36925);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36926);
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    m.b localb = (m.b)parama;
    parama = paramcc.field_content;
    if (parama != null) {}
    for (Object localObject1 = k.b.aP(parama, paramcc.field_reserved);; localObject1 = null)
    {
      if ((localObject1 != null) && (((k.b)localObject1).nRf != null)) {}
      for (parama = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(((k.b)localObject1).nRf);; parama = null)
      {
        long l;
        if ((parama == null) || (!parama.kLZ()))
        {
          String str = r.bKa().X(paramcc.field_imgPath, true);
          Object localObject2 = r.bKe().Oo(str);
          if (localObject2 != null)
          {
            parama = (c.a)localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            parama = BitmapUtil.decodeFile(str, null);
            r.bKe().h(str, parama);
          }
          localb.aePM.setVisibility(0);
          localb.aePL.setVisibility(8);
          localObject2 = localb.aePN;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(ab.getSizeKB(l));
            localb.aePN.setVisibility(0);
            localb.aePM.setImageResource(R.g.emoji_download_btn);
            if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).nRf))) {
              m.b.aePO.put(((k.b)localObject1).nRf, new WeakReference(localb));
            }
            if (parama != null)
            {
              localObject1 = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject1 = BitmapUtil.transformDrawableToBitmap(this.aeiK.aezO.getMMResources().getDrawable(R.g.fmp));
            }
            localb.aePJ.setImageBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          localb.aePJ.setTag(new bz(paramcc, parama1.juG(), paramInt, paramString, '\000'));
          localb.aePJ.setOnClickListener(m(parama1));
          localb.aePJ.setOnLongClickListener(c(parama1));
          localb.aePJ.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          localb.aePM.setOnClickListener(m(parama1));
          localb.aePM.setOnLongClickListener(c(parama1));
          localb.aePM.setTag(localb.aePJ.getTag());
          AppMethodBeat.o(36926);
          return;
          l = ((k.b)localObject1).nRd;
          break;
          parama.talker = paramcc.field_talker;
          localb.aePJ.a(parama, paramcc.field_msgId);
          localb.aePM.setVisibility(8);
          localb.aePL.setVisibility(8);
          localb.aePN.setVisibility(8);
          localb.aePM.setVisibility(8);
          if ((localObject1 != null) && (!Util.isNullOrNil(((k.b)localObject1).nRf))) {
            m.b.aePO.remove(((k.b)localObject1).nRf);
          }
          a(paramcc, parama);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36929);
    boolean bool = ((t)parama.cm(t.class)).a(paramMenuItem, parama, paramcc);
    AppMethodBeat.o(36929);
    return bool;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254910);
    int i = ((bz)paramView.getTag()).position;
    Object localObject = bg.byj(paramcc.field_content);
    paramContextMenuInfo = k.b.aP(paramcc.field_content, paramcc.field_reserved);
    if (paramContextMenuInfo == null)
    {
      paramContextMenuInfo = new k.b();
      paramContextMenuInfo.nRf = ((bg)localObject).md5;
    }
    for (;;)
    {
      if ((!ab.isNullOrNil(paramContextMenuInfo.nRf)) && (!paramContextMenuInfo.nRf.equals("-1")))
      {
        paramContextMenuInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramContextMenuInfo.nRf);
        if (paramContextMenuInfo != null)
        {
          if ((paramContextMenuInfo.field_catalog != EmojiInfo.aklM) && (!paramContextMenuInfo.kMe())) {
            params.a(i, 104, paramView.getContext().getString(R.l.gyB), R.k.icons_filled_addsticker);
          }
          boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
          localObject = b.acsj;
          b.c(paramContextMenuInfo, this.aeiK.getTalkerUserName());
          boolean bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTb, true);
          if ((!bool1) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
          {
            Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
            params.a(i, 115, paramView.getContext().getString(R.l.gyD), R.k.icons_filled_othersticker);
          }
          if (paramContextMenuInfo != null) {
            com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(0), paramContextMenuInfo.getMd5(), Integer.valueOf(0), paramContextMenuInfo.field_designerID, paramContextMenuInfo.field_groupId, "", "", "", "", paramContextMenuInfo.field_activityid });
          }
          if ((!paramContextMenuInfo.kLZ()) || (bt.Q(paramcc))) {
            break label493;
          }
          params.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzy()) {
          params.a(i, 135, paramView.getContext().getString(R.l.gyr), R.k.icons_filled_makesticker);
        }
        if (bt.F(paramcc)) {
          params.clear();
        }
        if (!this.aeiK.juH()) {
          params.a(i, 100, paramView.getContext().getString(R.l.gym), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(254910);
        return true;
        label493:
        Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36927);
    boolean bool = parama.juG();
    AppMethodBeat.o(36927);
    return bool;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */