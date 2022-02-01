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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.s.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$d
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  protected l.a KbF;
  
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
      localObject = new ah(paramLayoutInflater, 2131493479);
      ((View)localObject).setTag(new l.b().z((View)localObject, false));
    }
    AppMethodBeat.o(36930);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(36934);
    if (parambu.cTc())
    {
      com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
      bj.rJ(parambu.field_msgId);
      parama.xR(true);
      AppMethodBeat.o(36934);
      return;
    }
    AppMethodBeat.o(36934);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36931);
    this.JBI = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
    l.b localb = (l.b)parama;
    Object localObject;
    if (parambu != null)
    {
      parama = parambu.field_content;
      localObject = ay.aTS(parambu.field_content);
      if (((ay)localObject).itZ) {
        break label694;
      }
      if (parama == null) {
        break label688;
      }
      paramString = k.b.aA(parama, parambu.field_reserved);
      if (paramString == null) {
        break label683;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(paramString.hzQ);
    }
    for (;;)
    {
      if ((((ay)localObject).md5 != null) && (!((ay)localObject).md5.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(((ay)localObject).md5);
      }
      for (;;)
      {
        int i;
        boolean bool;
        if ((parama != null) && (parama.fOu()))
        {
          parama.talker = parambu.field_talker;
          localb.Kbz.a(parama, parambu.field_msgId);
          paramString = localb.Kbz;
          if (paramString.Ffk != null) {
            paramString.Ffk.resume();
          }
          if (parambu.field_status != 1)
          {
            i = 1;
            if (i != 0) {
              break label428;
            }
            bool = true;
            label231:
            b(localb, bool);
            a(parambu, parama);
            if (fHj())
            {
              if ((parambu == null) || (parambu.field_status != 2) || (!b((k)parama1.bh(k.class), parambu.field_msgId))) {
                break label659;
              }
              if (localb.JZD != null) {
                localb.JZD.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.Kbz.setTag(new bk(parambu, parama1.fFv(), paramInt, parama1.fFr(), '\000'));
          parama = localb.Kbz;
          if (this.KbF == null) {
            this.KbF = new l.a(parama1);
          }
          parama.setOnClickListener(this.KbF);
          localb.Kbz.setOnLongClickListener(c(parama1));
          localb.Kbz.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
          a(paramInt, localb, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
          AppMethodBeat.o(36931);
          return;
          i = 0;
          break;
          label428:
          bool = false;
          break label231;
          String str = q.aIF().R(parambu.field_imgPath, true);
          localObject = q.aIJ().FD(str);
          if (localObject != null)
          {
            parama = (c.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = com.tencent.mm.sdk.platformtools.g.decodeFile(str, null);
            q.aIJ().h(str, parama);
          }
          b(localb, false);
          localb.KbC.setVisibility(0);
          localb.KbB.setVisibility(8);
          localObject = localb.KbD;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.hzO)
          {
            ((TextView)localObject).setText(af.sy(l));
            localb.KbD.setVisibility(0);
            localb.KbC.setImageResource(2131232021);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = com.tencent.mm.sdk.platformtools.g.A(this.JBI.JOR.getMMResources().getDrawable(2131231063));
            }
            localb.Kbz.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (bt.isNullOrNil(paramString.hzQ))) {
              break;
            }
            l.b.KbE.put(paramString.hzQ, new WeakReference(localb));
            break;
          }
          label659:
          if (localb.JZD != null) {
            localb.JZD.setVisibility(8);
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
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(36933);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambu);
    AppMethodBeat.o(36933);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194342);
    ba.aBQ();
    int i;
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((bk)paramView.getTag()).position;
      localObject2 = ay.aTS(parambu.field_content);
      localObject1 = k.b.aA(parambu.field_content, parambu.field_reserved);
      if (localObject1 != null) {
        break label673;
      }
      localObject1 = new k.b();
      ((k.b)localObject1).hzQ = ((ay)localObject2).md5;
    }
    label649:
    label673:
    for (;;)
    {
      if ((!af.isNullOrNil(((k.b)localObject1).hzQ)) && (!((k.b)localObject1).hzQ.equals("-1")))
      {
        localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(((k.b)localObject1).hzQ);
        if (localObject2 == null) {
          break label649;
        }
        if ((((EmojiInfo)localObject2).field_catalog != EmojiInfo.OeT) && (!((EmojiInfo)localObject2).fOy())) {
          paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
        }
        localObject1 = com.tencent.mm.search.c.b.Iiu;
        com.tencent.mm.search.c.b.b((EmojiInfo)localObject2, this.JBI.getTalkerUserName());
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwY, true);
        if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
        {
          ad.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
          paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject2).Lb(), Integer.valueOf(0), ((EmojiInfo)localObject2).field_designerID, ((EmojiInfo)localObject2).field_groupId, "", "", "", "", ((EmojiInfo)localObject2).field_activityid });
        bool = ((EmojiInfo)localObject2).fOu();
        if ((((EmojiInfo)localObject2).field_catalog == EmojiInfo.OeT) || (bt.isNullOrNil(((EmojiInfo)localObject2).field_groupId)) || ((!bt.isNullOrNil(((EmojiInfo)localObject2).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abw(((EmojiInfo)localObject2).field_groupId))))
        {
          if (!bool) {
            break label637;
          }
          paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
        }
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cgy()) {
          paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
        }
      }
      for (;;)
      {
        if (parambu.field_status == 5) {
          paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
        }
        if ((!parambu.fpd()) && (parambu.frH()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
          paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JBI.fFw()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
        }
        AppMethodBeat.o(194342);
        return true;
        label637:
        ad.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        ad.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { ((k.b)localObject1).hzQ });
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.d
 * JD-Core Version:    0.7.0.1
 */