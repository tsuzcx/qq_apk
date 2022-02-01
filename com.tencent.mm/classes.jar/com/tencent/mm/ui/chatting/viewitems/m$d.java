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
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
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
import com.tencent.mm.ui.chatting.v.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class m$d
  extends c
  implements v.n
{
  protected m.a aePP;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36930);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggB);
      ((View)localObject).setTag(new m.b().P((View)localObject, false));
    }
    AppMethodBeat.o(36930);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36931);
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    m.b localb = (m.b)parama;
    Object localObject;
    if (paramcc != null)
    {
      parama = paramcc.field_content;
      localObject = bg.byj(paramcc.field_content);
      if (((bg)localObject).paW) {
        break label694;
      }
      if (parama == null) {
        break label688;
      }
      paramString = k.b.aP(parama, paramcc.field_reserved);
      if (paramString == null) {
        break label683;
      }
      parama = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramString.nRf);
    }
    for (;;)
    {
      if ((((bg)localObject).md5 != null) && (!((bg)localObject).md5.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(((bg)localObject).md5);
      }
      for (;;)
      {
        int i;
        boolean bool;
        if ((parama != null) && (parama.kLZ()))
        {
          parama.talker = paramcc.field_talker;
          localb.aePJ.a(parama, paramcc.field_msgId);
          paramString = localb.aePJ;
          if (paramString.YlG != null) {
            paramString.YlG.resume();
          }
          if (paramcc.field_status != 1)
          {
            i = 1;
            if (i != 0) {
              break label428;
            }
            bool = true;
            label231:
            b(localb, bool);
            a(paramcc, parama);
            if (jxj())
            {
              if ((paramcc == null) || (paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
                break label659;
              }
              if (localb.aeNG != null) {
                localb.aeNG.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.aePJ.setTag(new bz(paramcc, parama1.juG(), paramInt, parama1.getSelfUserName(), '\000'));
          parama = localb.aePJ;
          if (this.aePP == null) {
            this.aePP = new m.a(parama1);
          }
          parama.setOnClickListener(this.aePP);
          localb.aePJ.setOnLongClickListener(c(parama1));
          localb.aePJ.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          a(paramInt, localb, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(36931);
          return;
          i = 0;
          break;
          label428:
          bool = false;
          break label231;
          String str = r.bKa().X(paramcc.field_imgPath, true);
          localObject = r.bKe().Oo(str);
          if (localObject != null)
          {
            parama = (c.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = BitmapUtil.decodeFile(str, null);
            r.bKe().h(str, parama);
          }
          b(localb, false);
          localb.aePM.setVisibility(0);
          localb.aePL.setVisibility(8);
          localObject = localb.aePN;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.nRd)
          {
            ((TextView)localObject).setText(ab.getSizeKB(l));
            localb.aePN.setVisibility(0);
            localb.aePM.setImageResource(R.g.emoji_download_btn);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = BitmapUtil.transformDrawableToBitmap(this.aeiK.aezO.getMMResources().getDrawable(R.g.fmp));
            }
            localb.aePJ.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (Util.isNullOrNil(paramString.nRf))) {
              break;
            }
            m.b.aePO.put(paramString.nRf, new WeakReference(localb));
            break;
          }
          label659:
          if (localb.aeNG != null) {
            localb.aeNG.setVisibility(8);
          }
        }
      }
      label683:
      parama = null;
      continue;
      label688:
      paramString = null;
      break;
      label694:
      parama = null;
      paramString = null;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36933);
    boolean bool = ((t)parama.cm(t.class)).a(paramMenuItem, parama, paramcc);
    AppMethodBeat.o(36933);
    return bool;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254905);
    bh.bCz();
    int i;
    Object localObject;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((bz)paramView.getTag()).position;
      localObject = bg.byj(paramcc.field_content);
      paramContextMenuInfo = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      if (paramContextMenuInfo != null) {
        break label632;
      }
      paramContextMenuInfo = new k.b();
      paramContextMenuInfo.nRf = ((bg)localObject).md5;
    }
    label597:
    label609:
    label632:
    for (;;)
    {
      if ((!ab.isNullOrNil(paramContextMenuInfo.nRf)) && (!paramContextMenuInfo.nRf.equals("-1")))
      {
        localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramContextMenuInfo.nRf);
        if (localObject == null) {
          break label609;
        }
        if ((((EmojiInfo)localObject).field_catalog != EmojiInfo.aklM) && (!((EmojiInfo)localObject).kMe())) {
          params.a(i, 104, paramView.getContext().getString(R.l.gyB), R.k.icons_filled_addsticker);
        }
        boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        paramContextMenuInfo = b.acsj;
        b.c((EmojiInfo)localObject, this.aeiK.getTalkerUserName());
        boolean bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTb, true);
        if ((!bool1) && ((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool2))
        {
          Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
          params.a(i, 115, paramView.getContext().getString(R.l.gyD), R.k.icons_filled_othersticker);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", ((EmojiInfo)localObject).field_activityid });
        if (!((EmojiInfo)localObject).kLZ()) {
          break label597;
        }
        params.a(i, 113, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzy()) {
          params.a(i, 135, paramView.getContext().getString(R.l.gyr), R.k.icons_filled_makesticker);
        }
      }
      for (;;)
      {
        if (paramcc.field_status == 5) {
          params.a(i, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
        }
        if ((!paramcc.iYe()) && (paramcc.jbH()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
          params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
        if (!this.aeiK.juH()) {
          params.a(i, 100, paramView.getContext().getString(R.l.gym), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(254905);
        return true;
        Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { paramContextMenuInfo.nRf });
      }
    }
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(254916);
    if (paramcc.fxR())
    {
      n.bx(paramcc);
      br.iu(paramcc.field_msgId);
      parama.jpK();
      AppMethodBeat.o(254916);
      return;
    }
    AppMethodBeat.o(254916);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.d
 * JD-Core Version:    0.7.0.1
 */