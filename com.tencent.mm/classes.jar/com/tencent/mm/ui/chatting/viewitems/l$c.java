package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.d.b.p;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  protected l.a KbF;
  
  private l.a m(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36924);
    if (this.KbF == null) {
      this.KbF = new l.a(parama);
    }
    parama = this.KbF;
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
      localObject = new ah(paramLayoutInflater, 2131493435);
      ((View)localObject).setTag(new l.b().z((View)localObject, true));
    }
    AppMethodBeat.o(36925);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36926);
    this.JBI = parama1;
    ((m)parama1.bh(m.class)).bK(parambu);
    l.b localb = (l.b)parama;
    parama = parambu.field_content;
    if (parama != null) {}
    for (Object localObject1 = k.b.aA(parama, parambu.field_reserved);; localObject1 = null)
    {
      if ((localObject1 != null) && (((k.b)localObject1).hzQ != null)) {}
      for (parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(((k.b)localObject1).hzQ);; parama = null)
      {
        long l;
        if ((parama == null) || (!parama.fOu()))
        {
          String str = q.aIF().R(parambu.field_imgPath, true);
          Object localObject2 = q.aIJ().FD(str);
          if (localObject2 != null)
          {
            parama = (c.a)localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            parama = com.tencent.mm.sdk.platformtools.g.decodeFile(str, null);
            q.aIJ().h(str, parama);
          }
          localb.KbC.setVisibility(0);
          localb.KbB.setVisibility(8);
          localObject2 = localb.KbD;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(af.sy(l));
            localb.KbD.setVisibility(0);
            localb.KbC.setImageResource(2131232021);
            if ((localObject1 != null) && (!bt.isNullOrNil(((k.b)localObject1).hzQ))) {
              l.b.KbE.put(((k.b)localObject1).hzQ, new WeakReference(localb));
            }
            if (parama != null)
            {
              localObject1 = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject1 = com.tencent.mm.sdk.platformtools.g.A(this.JBI.JOR.getMMResources().getDrawable(2131231063));
            }
            localb.Kbz.setImageBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          localb.Kbz.setTag(new bk(parambu, parama1.fFv(), paramInt, paramString, '\000'));
          localb.Kbz.setOnClickListener(m(parama1));
          localb.Kbz.setOnLongClickListener(c(parama1));
          localb.Kbz.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
          localb.KbC.setOnClickListener(m(parama1));
          localb.KbC.setOnLongClickListener(c(parama1));
          localb.KbC.setTag(localb.Kbz.getTag());
          AppMethodBeat.o(36926);
          return;
          l = ((k.b)localObject1).hzO;
          break;
          parama.talker = parambu.field_talker;
          localb.Kbz.a(parama, parambu.field_msgId);
          localb.KbC.setVisibility(8);
          localb.KbB.setVisibility(8);
          localb.KbD.setVisibility(8);
          localb.KbC.setVisibility(8);
          if ((localObject1 != null) && (!bt.isNullOrNil(((k.b)localObject1).hzQ))) {
            l.b.KbE.remove(((k.b)localObject1).hzQ);
          }
          a(parambu, parama);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(36929);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambu);
    AppMethodBeat.o(36929);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194341);
    int i = ((bk)paramView.getTag()).position;
    Object localObject2 = ay.aTS(parambu.field_content);
    Object localObject1 = k.b.aA(parambu.field_content, parambu.field_reserved);
    if (localObject1 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).hzQ = ((ay)localObject2).md5;
    }
    for (;;)
    {
      if ((!af.isNullOrNil(((k.b)localObject1).hzQ)) && (!((k.b)localObject1).hzQ.equals("-1")))
      {
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(((k.b)localObject1).hzQ);
        if (localObject1 != null)
        {
          if ((((EmojiInfo)localObject1).field_catalog != EmojiInfo.OeT) && (!((EmojiInfo)localObject1).fOy())) {
            paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
          }
          localObject2 = com.tencent.mm.search.c.b.Iiu;
          com.tencent.mm.search.c.b.b((EmojiInfo)localObject1, this.JBI.getTalkerUserName());
          boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwY, true);
          if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
          {
            ad.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
            paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
          }
          if (localObject1 != null) {
            com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject1).Lb(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
          }
          bool = ((EmojiInfo)localObject1).fOu();
          if ((((EmojiInfo)localObject1).field_catalog == EmojiInfo.OeT) || (bt.isNullOrNil(((EmojiInfo)localObject1).field_groupId)) || ((!bt.isNullOrNil(((EmojiInfo)localObject1).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abw(((EmojiInfo)localObject1).field_groupId))))
          {
            if (!bool) {
              break label541;
            }
            paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
          }
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cgy()) {
          paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
        }
        if (bl.z(parambu)) {
          paraml.clear();
        }
        if (!this.JBI.fFw()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
        }
        AppMethodBeat.o(194341);
        return true;
        label541:
        ad.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36927);
    boolean bool = parama.fFv();
    AppMethodBeat.o(36927);
    return bool;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */