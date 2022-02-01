package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bk;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.c.b.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  protected l.a Ilh;
  
  private l.a m(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36924);
    if (this.Ilh == null) {
      this.Ilh = new l.a(parama);
    }
    parama = this.Ilh;
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
      localObject = new ag(paramLayoutInflater, 2131493435);
      ((View)localObject).setTag(new l.b().z((View)localObject, true));
    }
    AppMethodBeat.o(36925);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36926);
    this.HNS = parama1;
    ((k)parama1.bf(k.class)).bE(parambo);
    l.b localb = (l.b)parama;
    parama = parambo.field_content;
    if (parama != null) {}
    for (Object localObject1 = k.b.az(parama, parambo.field_reserved);; localObject1 = null)
    {
      if ((localObject1 != null) && (((k.b)localObject1).hhH != null)) {}
      for (parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(((k.b)localObject1).hhH);; parama = null)
      {
        long l;
        if ((parama == null) || (!parama.fdp()))
        {
          String str = o.aFx().R(parambo.field_imgPath, true);
          Object localObject2 = o.aFB().Cz(str);
          if (localObject2 != null)
          {
            parama = (c.a)localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            parama = f.decodeFile(str, null);
            o.aFB().h(str, parama);
          }
          localb.Ile.setVisibility(0);
          localb.Ild.setVisibility(8);
          localObject2 = localb.Ilf;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(ae.qz(l));
            localb.Ilf.setVisibility(0);
            localb.Ile.setImageResource(2131232021);
            if ((localObject1 != null) && (!bs.isNullOrNil(((k.b)localObject1).hhH))) {
              l.b.Ilg.put(((k.b)localObject1).hhH, new WeakReference(localb));
            }
            if (parama != null)
            {
              localObject1 = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject1 = f.A(this.HNS.HZF.getMMResources().getDrawable(2131231063));
            }
            localb.Ilb.setImageBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          localb.Ilb.setTag(new bj(parambo, parama1.foQ(), paramInt, paramString, '\000'));
          localb.Ilb.setOnClickListener(m(parama1));
          localb.Ilb.setOnLongClickListener(c(parama1));
          localb.Ilb.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          localb.Ile.setOnClickListener(m(parama1));
          localb.Ile.setOnLongClickListener(c(parama1));
          localb.Ile.setTag(localb.Ilb.getTag());
          AppMethodBeat.o(36926);
          return;
          l = ((k.b)localObject1).hhF;
          break;
          parama.talker = parambo.field_talker;
          localb.Ilb.a(parama, parambo.field_msgId);
          localb.Ile.setVisibility(8);
          localb.Ild.setVisibility(8);
          localb.Ilf.setVisibility(8);
          localb.Ile.setVisibility(8);
          if ((localObject1 != null) && (!bs.isNullOrNil(((k.b)localObject1).hhH))) {
            l.b.Ilg.remove(((k.b)localObject1).hhH);
          }
          a(parambo, parama);
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36928);
    int i = ((bj)paramView.getTag()).position;
    Object localObject2 = au.aOb(parambo.field_content);
    Object localObject1 = k.b.az(parambo.field_content, parambo.field_reserved);
    if (localObject1 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).hhH = ((au)localObject2).md5;
    }
    for (;;)
    {
      if ((!ae.isNullOrNil(((k.b)localObject1).hhH)) && (!((k.b)localObject1).hhH.equals("-1")))
      {
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(((k.b)localObject1).hhH);
        if (localObject1 != null)
        {
          if ((((EmojiInfo)localObject1).field_catalog != EmojiInfo.Jsy) && (!((EmojiInfo)localObject1).fxI())) {
            paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
          }
          localObject2 = com.tencent.mm.search.c.b.GwA;
          com.tencent.mm.search.c.b.b((EmojiInfo)localObject1, this.HNS.getTalkerUserName());
          boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSx, true);
          if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
          {
            ac.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
            paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
          }
          if (localObject1 != null) {
            h.wUl.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject1).JC(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
          }
          bool = ((EmojiInfo)localObject1).fdp();
          if ((((EmojiInfo)localObject1).field_catalog == EmojiInfo.Jsy) || (bs.isNullOrNil(((EmojiInfo)localObject1).field_groupId)) || ((!bs.isNullOrNil(((EmojiInfo)localObject1).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(((EmojiInfo)localObject1).field_groupId))))
          {
            if (!bool) {
              break label536;
            }
            paramContextMenu.add(i, 113, 0, 2131762559);
          }
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbU()) {
          paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131757224));
        }
        if (bk.x(parambo)) {
          paramContextMenu.clear();
        }
        if (!this.HNS.foR()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
        }
        AppMethodBeat.o(36928);
        return true;
        label536:
        ac.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36929);
    boolean bool = ((n)parama.bf(n.class)).a(paramMenuItem, parama, parambo);
    AppMethodBeat.o(36929);
    return bool;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36927);
    boolean bool = parama.foQ();
    AppMethodBeat.o(36927);
    return bool;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */