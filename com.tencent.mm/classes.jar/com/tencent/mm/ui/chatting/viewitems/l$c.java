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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bk;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bl;
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
  protected l.a GLk;
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  private l.a m(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36924);
    if (this.GLk == null) {
      this.GLk = new l.a(parama);
    }
    parama = this.GLk;
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
      localObject = new af(paramLayoutInflater, 2131493435);
      ((View)localObject).setTag(new l.b().z((View)localObject, true));
    }
    AppMethodBeat.o(36925);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36926);
    this.Gob = parama1;
    ((k)parama1.be(k.class)).bC(parambl);
    l.b localb = (l.b)parama;
    parama = parambl.field_content;
    if (parama != null) {}
    for (Object localObject1 = k.b.ar(parama, parambl.field_reserved);; localObject1 = null)
    {
      if ((localObject1 != null) && (((k.b)localObject1).gHg != null)) {}
      for (parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(((k.b)localObject1).gHg);; parama = null)
      {
        long l;
        if ((parama == null) || (!parama.fZM()))
        {
          String str = o.ayF().Q(parambl.field_imgPath, true);
          Object localObject2 = o.ayJ().yu(str);
          if (localObject2 != null)
          {
            parama = (c.a)localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            parama = f.decodeFile(str, null);
            o.ayJ().i(str, parama);
          }
          localb.GLh.setVisibility(0);
          localb.GLg.setVisibility(8);
          localObject2 = localb.GLi;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(ae.mK(l));
            localb.GLi.setVisibility(0);
            localb.GLh.setImageResource(2131232021);
            if ((localObject1 != null) && (!bt.isNullOrNil(((k.b)localObject1).gHg))) {
              l.b.GLj.put(((k.b)localObject1).gHg, new WeakReference(localb));
            }
            if (parama != null)
            {
              localObject1 = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject1 = f.B(this.Gob.GzJ.getMMResources().getDrawable(2131231063));
            }
            localb.GLe.setImageBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          localb.GLe.setTag(new bi(parambl, parama1.eZb(), paramInt, paramString, '\000'));
          localb.GLe.setOnClickListener(m(parama1));
          localb.GLe.setOnLongClickListener(c(parama1));
          localb.GLe.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          localb.GLh.setOnClickListener(m(parama1));
          localb.GLh.setOnLongClickListener(c(parama1));
          localb.GLh.setTag(localb.GLe.getTag());
          AppMethodBeat.o(36926);
          return;
          l = ((k.b)localObject1).gHe;
          break;
          parama.talker = parambl.field_talker;
          localb.GLe.a(parama, parambl.field_msgId);
          localb.GLh.setVisibility(8);
          localb.GLg.setVisibility(8);
          localb.GLi.setVisibility(8);
          localb.GLh.setVisibility(8);
          if ((localObject1 != null) && (!bt.isNullOrNil(((k.b)localObject1).gHg))) {
            l.b.GLj.remove(((k.b)localObject1).gHg);
          }
          a(parambl, parama);
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36928);
    int i = ((bi)paramView.getTag()).position;
    Object localObject2 = ar.aIF(parambl.field_content);
    Object localObject1 = k.b.ar(parambl.field_content, parambl.field_reserved);
    if (localObject1 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).gHg = ((ar)localObject2).md5;
    }
    for (;;)
    {
      if ((!ae.isNullOrNil(((k.b)localObject1).gHg)) && (!((k.b)localObject1).gHg.equals("-1")))
      {
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(((k.b)localObject1).gHg);
        if (localObject1 != null)
        {
          if ((((EmojiInfo)localObject1).field_catalog != EmojiInfo.LBW) && (!((EmojiInfo)localObject1).fZQ())) {
            paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
          }
          localObject2 = com.tencent.mm.search.b.b.EZl;
          com.tencent.mm.search.b.b.E((EmojiInfo)localObject1);
          boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poM, true);
          if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
          {
            ad.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
            paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
          }
          if (localObject1 != null) {
            h.vKh.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject1).JS(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
          }
          bool = ((EmojiInfo)localObject1).fZM();
          if ((((EmojiInfo)localObject1).field_catalog == EmojiInfo.LBW) || (bt.isNullOrNil(((EmojiInfo)localObject1).field_groupId)) || ((!bt.isNullOrNil(((EmojiInfo)localObject1).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(((EmojiInfo)localObject1).field_groupId))))
          {
            if (!bool) {
              break label529;
            }
            paramContextMenu.add(i, 113, 0, 2131762559);
          }
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUH()) {
          paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131757224));
        }
        if (bk.x(parambl)) {
          paramContextMenu.clear();
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
        }
        AppMethodBeat.o(36928);
        return true;
        label529:
        ad.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36929);
    boolean bool = ((n)parama.be(n.class)).a(paramMenuItem, parama, parambl);
    AppMethodBeat.o(36929);
    return bool;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36927);
    boolean bool = parama.eZb();
    AppMethodBeat.o(36927);
    return bool;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */