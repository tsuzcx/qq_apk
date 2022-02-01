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
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
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
import com.tencent.mm.ui.chatting.s.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$d
  extends c
  implements s.n
{
  protected l.a GLk;
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493479);
      ((View)localObject).setTag(new l.b().z((View)localObject, false));
    }
    AppMethodBeat.o(36930);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36934);
    if (parambl.cxB())
    {
      m.aB(parambl);
      com.tencent.mm.model.bi.lW(parambl.field_msgId);
      parama.wc(true);
      AppMethodBeat.o(36934);
      return;
    }
    AppMethodBeat.o(36934);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36931);
    this.Gob = parama1;
    ((k)parama1.be(k.class)).bC(parambl);
    l.b localb = (l.b)parama;
    String str1 = null;
    paramString = null;
    String str2;
    if (parambl != null)
    {
      String str3 = parambl.field_content;
      ar localar = ar.aIF(parambl.field_content);
      str2 = null;
      parama = str2;
      if (!localar.hAc)
      {
        if (str3 != null) {
          paramString = k.b.ar(str3, parambl.field_reserved);
        }
        parama = str2;
        str1 = paramString;
        if (paramString != null)
        {
          parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramString.gHg);
          str1 = paramString;
        }
      }
      if ((localar.md5 == null) || (localar.md5.equals("-1")) || (parama != null)) {
        break label716;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(localar.md5);
    }
    label265:
    label695:
    label716:
    for (;;)
    {
      int i;
      if ((parama != null) && (parama.fZM()))
      {
        parama.talker = parambl.field_talker;
        localb.GLe.a(parama, parambl.field_msgId);
        paramString = localb.GLe;
        if (paramString.ChK != null) {
          paramString.ChK.resume();
        }
        if (parambl.field_status != 1)
        {
          i = 1;
          paramString = localb.uPp;
          if (i == 0) {
            break label461;
          }
          i = 8;
          paramString.setVisibility(i);
          a(parambl, parama);
          if (faG())
          {
            if ((parambl == null) || (parambl.field_status != 2) || (!a((i)parama1.be(i.class), parambl.field_msgId))) {
              break label695;
            }
            if (localb.GJi != null) {
              localb.GJi.setVisibility(0);
            }
          }
        }
      }
      for (;;)
      {
        localb.GLe.setTag(new bi(parambl, parama1.eZb(), paramInt, parama1.eYX(), '\000'));
        parama = localb.GLe;
        if (this.GLk == null) {
          this.GLk = new l.a(parama1);
        }
        parama.setOnClickListener(this.GLk);
        localb.GLe.setOnLongClickListener(c(parama1));
        localb.GLe.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        a(paramInt, localb, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
        AppMethodBeat.o(36931);
        return;
        i = 0;
        break;
        label461:
        i = 0;
        break label265;
        str2 = o.ayF().Q(parambl.field_imgPath, true);
        paramString = o.ayJ().yu(str2);
        if (paramString != null)
        {
          parama = paramString;
          if (!paramString.isRecycled()) {}
        }
        else
        {
          parama = f.decodeFile(str2, null);
          o.ayJ().i(str2, parama);
        }
        localb.uPp.setVisibility(8);
        localb.GLh.setVisibility(0);
        localb.GLg.setVisibility(8);
        paramString = localb.GLi;
        if (str1 == null) {}
        for (long l = 0L;; l = str1.gHe)
        {
          paramString.setText(ae.mK(l));
          localb.GLi.setVisibility(0);
          localb.GLh.setImageResource(2131232021);
          if (parama != null)
          {
            paramString = parama;
            if (!parama.isRecycled()) {}
          }
          else
          {
            paramString = f.B(this.Gob.GzJ.getMMResources().getDrawable(2131231063));
          }
          localb.GLe.setImageBitmap(paramString);
          if ((str1 == null) || (bt.isNullOrNil(str1.gHg))) {
            break;
          }
          l.b.GLj.put(str1.gHg, new WeakReference(localb));
          break;
        }
        if (localb.GJi != null) {
          localb.GJi.setVisibility(8);
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36932);
    az.arV();
    int i;
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((bi)paramView.getTag()).position;
      localObject2 = ar.aIF(parambl.field_content);
      localObject1 = k.b.ar(parambl.field_content, parambl.field_reserved);
      if (localObject1 != null) {
        break label659;
      }
      localObject1 = new k.b();
      ((k.b)localObject1).gHg = ((ar)localObject2).md5;
    }
    label659:
    for (;;)
    {
      if ((!ae.isNullOrNil(((k.b)localObject1).gHg)) && (!((k.b)localObject1).gHg.equals("-1")))
      {
        localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(((k.b)localObject1).gHg);
        if (localObject2 == null) {
          break label635;
        }
        if ((((EmojiInfo)localObject2).field_catalog != EmojiInfo.LBW) && (!((EmojiInfo)localObject2).fZQ())) {
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
        }
        localObject1 = com.tencent.mm.search.b.b.EZl;
        com.tencent.mm.search.b.b.E((EmojiInfo)localObject2);
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poM, true);
        if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
        {
          ad.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
          paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
        }
        h.vKh.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject2).JS(), Integer.valueOf(0), ((EmojiInfo)localObject2).field_designerID, ((EmojiInfo)localObject2).field_groupId, "", "", "", "", ((EmojiInfo)localObject2).field_activityid });
        bool = ((EmojiInfo)localObject2).fZM();
        if ((((EmojiInfo)localObject2).field_catalog == EmojiInfo.LBW) || (bt.isNullOrNil(((EmojiInfo)localObject2).field_groupId)) || ((!bt.isNullOrNil(((EmojiInfo)localObject2).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(((EmojiInfo)localObject2).field_groupId))))
        {
          if (!bool) {
            break label623;
          }
          paramContextMenu.add(i, 113, 0, 2131762559);
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUH()) {
          paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131757224));
        }
      }
      for (;;)
      {
        if (parambl.field_status == 5) {
          paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
        }
        if ((!parambl.eJL()) && (parambl.eLZ()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
          paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
        }
        AppMethodBeat.o(36932);
        return true;
        label623:
        ad.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        label635:
        ad.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { ((k.b)localObject1).gHg });
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36933);
    boolean bool = ((n)parama.be(n.class)).a(paramMenuItem, parama, parambl);
    AppMethodBeat.o(36933);
    return bool;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.d
 * JD-Core Version:    0.7.0.1
 */