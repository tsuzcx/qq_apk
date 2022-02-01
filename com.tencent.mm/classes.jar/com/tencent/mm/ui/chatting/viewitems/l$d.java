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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.t.n;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$d
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  protected l.a KxX;
  
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
      ((View)localObject).setTag(new l.b().E((View)localObject, false));
    }
    AppMethodBeat.o(36930);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36934);
    if (parambv.cVH())
    {
      com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
      bl.rW(parambv.field_msgId);
      parama.xY(true);
      AppMethodBeat.o(36934);
      return;
    }
    AppMethodBeat.o(36934);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(36931);
    this.JWz = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bJ(parambv);
    l.b localb = (l.b)parama;
    Object localObject;
    if (parambv != null)
    {
      parama = parambv.field_content;
      localObject = az.aVt(parambv.field_content);
      if (((az)localObject).iwT) {
        break label694;
      }
      if (parama == null) {
        break label688;
      }
      paramString = k.b.aB(parama, parambv.field_reserved);
      if (paramString == null) {
        break label683;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramString.hCE);
    }
    for (;;)
    {
      if ((((az)localObject).md5 != null) && (!((az)localObject).md5.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(((az)localObject).md5);
      }
      for (;;)
      {
        int i;
        boolean bool;
        if ((parama != null) && (parama.fxn()))
        {
          parama.talker = parambv.field_talker;
          localb.KxR.a(parama, parambv.field_msgId);
          paramString = localb.KxR;
          if (paramString.FxI != null) {
            paramString.FxI.resume();
          }
          if (parambv.field_status != 1)
          {
            i = 1;
            if (i != 0) {
              break label428;
            }
            bool = true;
            label231:
            b(localb, bool);
            a(parambv, parama);
            if (fLB())
            {
              if ((parambv == null) || (parambv.field_status != 2) || (!b((k)parama1.bh(k.class), parambv.field_msgId))) {
                break label659;
              }
              if (localb.KvW != null) {
                localb.KvW.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localb.KxR.setTag(new bk(parambv, parama1.fJC(), paramInt, parama1.fJy(), '\000'));
          parama = localb.KxR;
          if (this.KxX == null) {
            this.KxX = new l.a(parama1);
          }
          parama.setOnClickListener(this.KxX);
          localb.KxR.setOnLongClickListener(c(parama1));
          localb.KxR.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
          a(paramInt, localb, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
          AppMethodBeat.o(36931);
          return;
          i = 0;
          break;
          label428:
          bool = false;
          break label231;
          String str = q.aIX().R(parambv.field_imgPath, true);
          localObject = q.aJb().Gf(str);
          if (localObject != null)
          {
            parama = (c.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = h.decodeFile(str, null);
            q.aJb().h(str, parama);
          }
          b(localb, false);
          localb.KxU.setVisibility(0);
          localb.KxT.setVisibility(8);
          localObject = localb.KxV;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.hCC)
          {
            ((TextView)localObject).setText(af.sL(l));
            localb.KxV.setVisibility(0);
            localb.KxU.setImageResource(2131232021);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = h.B(this.JWz.Kkd.getMMResources().getDrawable(2131231063));
            }
            localb.KxR.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (bu.isNullOrNil(paramString.hCE))) {
              break;
            }
            l.b.KxW.put(paramString.hCE, new WeakReference(localb));
            break;
          }
          label659:
          if (localb.KvW != null) {
            localb.KvW.setVisibility(8);
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
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36933);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambv);
    AppMethodBeat.o(36933);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187737);
    bc.aCg();
    int i;
    Object localObject2;
    Object localObject1;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      i = ((bk)paramView.getTag()).position;
      localObject2 = az.aVt(parambv.field_content);
      localObject1 = k.b.aB(parambv.field_content, parambv.field_reserved);
      if (localObject1 != null) {
        break label610;
      }
      localObject1 = new k.b();
      ((k.b)localObject1).hCE = ((az)localObject2).md5;
    }
    label574:
    label586:
    label610:
    for (;;)
    {
      if ((!af.isNullOrNil(((k.b)localObject1).hCE)) && (!((k.b)localObject1).hCE.equals("-1")))
      {
        localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(((k.b)localObject1).hCE);
        if (localObject2 == null) {
          break label586;
        }
        if ((((EmojiInfo)localObject2).field_catalog != EmojiInfo.OAa) && (!((EmojiInfo)localObject2).fxr())) {
          paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
        }
        localObject1 = com.tencent.mm.search.c.b.ICF;
        com.tencent.mm.search.c.b.b((EmojiInfo)localObject2, this.JWz.getTalkerUserName());
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDY, true);
        if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
        {
          ae.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
          paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject2).Lj(), Integer.valueOf(0), ((EmojiInfo)localObject2).field_designerID, ((EmojiInfo)localObject2).field_groupId, "", "", "", "", ((EmojiInfo)localObject2).field_activityid });
        if (!((EmojiInfo)localObject2).fxn()) {
          break label574;
        }
        paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().chO()) {
          paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
        }
      }
      for (;;)
      {
        if (parambv.field_status == 5) {
          paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
        }
        if ((!parambv.fta()) && (parambv.fvH()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
          paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JWz.fJD()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
        }
        AppMethodBeat.o(187737);
        return true;
        ae.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        ae.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { ((k.b)localObject1).hCE });
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.d
 * JD-Core Version:    0.7.0.1
 */