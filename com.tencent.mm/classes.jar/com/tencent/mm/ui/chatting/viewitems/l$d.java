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
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
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
import com.tencent.mm.ui.chatting.s.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$d
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  protected l.a Ilh;
  
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
      localObject = new ag(paramLayoutInflater, 2131493479);
      ((View)localObject).setTag(new l.b().z((View)localObject, false));
    }
    AppMethodBeat.o(36930);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36934);
    if (parambo.cKN())
    {
      m.aD(parambo);
      bi.pK(parambo.field_msgId);
      parama.xg(true);
      AppMethodBeat.o(36934);
      return;
    }
    AppMethodBeat.o(36934);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36931);
    this.HNS = parama1;
    ((k)parama1.bf(k.class)).bE(parambo);
    l.b localb = (l.b)parama;
    Object localObject;
    if (parambo != null)
    {
      parama = parambo.field_content;
      localObject = au.aOb(parambo.field_content);
      if (((au)localObject).iaD) {
        break label694;
      }
      if (parama == null) {
        break label688;
      }
      paramString = k.b.az(parama, parambo.field_reserved);
      if (paramString == null) {
        break label683;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramString.hhH);
    }
    for (;;)
    {
      if ((((au)localObject).md5 != null) && (!((au)localObject).md5.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(((au)localObject).md5);
      }
      for (;;)
      {
        int i;
        boolean bool;
        if ((parama != null) && (parama.fdp()))
        {
          parama.talker = parambo.field_talker;
          localb.Ilb.a(parama, parambo.field_msgId);
          paramString = localb.Ilb;
          if (paramString.DAb != null) {
            paramString.DAb.resume();
          }
          if (parambo.field_status != 1)
          {
            i = 1;
            if (i != 0) {
              break label428;
            }
            bool = true;
            label231:
            b(localb, bool);
            a(parambo, parama);
            if (fqw())
            {
              if ((parambo == null) || (parambo.field_status != 2) || (!a((i)parama1.bf(i.class), parambo.field_msgId))) {
                break label659;
              }
              if (localb.Ijf != null) {
                localb.Ijf.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.Ilb.setTag(new bj(parambo, parama1.foQ(), paramInt, parama1.foM(), '\000'));
          parama = localb.Ilb;
          if (this.Ilh == null) {
            this.Ilh = new l.a(parama1);
          }
          parama.setOnClickListener(this.Ilh);
          localb.Ilb.setOnLongClickListener(c(parama1));
          localb.Ilb.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          a(paramInt, localb, parambo, parama1.foM(), parama1.foQ(), parama1, this);
          AppMethodBeat.o(36931);
          return;
          i = 0;
          break;
          label428:
          bool = false;
          break label231;
          String str = o.aFx().R(parambo.field_imgPath, true);
          localObject = o.aFB().Cz(str);
          if (localObject != null)
          {
            parama = (c.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = f.decodeFile(str, null);
            o.aFB().h(str, parama);
          }
          b(localb, false);
          localb.Ile.setVisibility(0);
          localb.Ild.setVisibility(8);
          localObject = localb.Ilf;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.hhF)
          {
            ((TextView)localObject).setText(ae.qz(l));
            localb.Ilf.setVisibility(0);
            localb.Ile.setImageResource(2131232021);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = f.A(this.HNS.HZF.getMMResources().getDrawable(2131231063));
            }
            localb.Ilb.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (bs.isNullOrNil(paramString.hhH))) {
              break;
            }
            l.b.Ilg.put(paramString.hhH, new WeakReference(localb));
            break;
          }
          label659:
          if (localb.Ijf != null) {
            localb.Ijf.setVisibility(8);
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
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36932);
    az.ayM();
    int i;
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((bj)paramView.getTag()).position;
      localObject2 = au.aOb(parambo.field_content);
      localObject1 = k.b.az(parambo.field_content, parambo.field_reserved);
      if (localObject1 != null) {
        break label666;
      }
      localObject1 = new k.b();
      ((k.b)localObject1).hhH = ((au)localObject2).md5;
    }
    label642:
    label666:
    for (;;)
    {
      if ((!ae.isNullOrNil(((k.b)localObject1).hhH)) && (!((k.b)localObject1).hhH.equals("-1")))
      {
        localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(((k.b)localObject1).hhH);
        if (localObject2 == null) {
          break label642;
        }
        if ((((EmojiInfo)localObject2).field_catalog != EmojiInfo.Jsy) && (!((EmojiInfo)localObject2).fxI())) {
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(2131757235));
        }
        localObject1 = com.tencent.mm.search.c.b.GwA;
        com.tencent.mm.search.c.b.b((EmojiInfo)localObject2, this.HNS.getTalkerUserName());
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSx, true);
        if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
        {
          ac.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
          paramContextMenu.add(i, 115, 0, paramView.getContext().getString(2131757238));
        }
        h.wUl.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject2).JC(), Integer.valueOf(0), ((EmojiInfo)localObject2).field_designerID, ((EmojiInfo)localObject2).field_groupId, "", "", "", "", ((EmojiInfo)localObject2).field_activityid });
        bool = ((EmojiInfo)localObject2).fdp();
        if ((((EmojiInfo)localObject2).field_catalog == EmojiInfo.Jsy) || (bs.isNullOrNil(((EmojiInfo)localObject2).field_groupId)) || ((!bs.isNullOrNil(((EmojiInfo)localObject2).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(((EmojiInfo)localObject2).field_groupId))))
        {
          if (!bool) {
            break label630;
          }
          paramContextMenu.add(i, 113, 0, 2131762559);
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbU()) {
          paramContextMenu.add(i, 135, 0, paramView.getContext().getString(2131757224));
        }
      }
      for (;;)
      {
        if (parambo.field_status == 5) {
          paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
        }
        if ((!parambo.eZj()) && (parambo.fbD()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
          paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.HNS.foR()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757219));
        }
        AppMethodBeat.o(36932);
        return true;
        label630:
        ac.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        ac.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { ((k.b)localObject1).hhH });
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36933);
    boolean bool = ((n)parama.bf(n.class)).a(paramMenuItem, parama, parambo);
    AppMethodBeat.o(36933);
    return bool;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.d
 * JD-Core Version:    0.7.0.1
 */