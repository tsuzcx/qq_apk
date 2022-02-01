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
import com.tencent.mm.model.bn;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.d.b.p;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class l$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  protected l.a KxX;
  
  private l.a m(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36924);
    if (this.KxX == null) {
      this.KxX = new l.a(parama);
    }
    parama = this.KxX;
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
      ((View)localObject).setTag(new l.b().E((View)localObject, true));
    }
    AppMethodBeat.o(36925);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(36926);
    this.JWz = parama1;
    ((m)parama1.bh(m.class)).bJ(parambv);
    l.b localb = (l.b)parama;
    parama = parambv.field_content;
    if (parama != null) {}
    for (Object localObject1 = k.b.aB(parama, parambv.field_reserved);; localObject1 = null)
    {
      if ((localObject1 != null) && (((k.b)localObject1).hCE != null)) {}
      for (parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(((k.b)localObject1).hCE);; parama = null)
      {
        long l;
        if ((parama == null) || (!parama.fxn()))
        {
          String str = q.aIX().R(parambv.field_imgPath, true);
          Object localObject2 = q.aJb().Gf(str);
          if (localObject2 != null)
          {
            parama = (c.a)localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            parama = h.decodeFile(str, null);
            q.aJb().h(str, parama);
          }
          localb.KxU.setVisibility(0);
          localb.KxT.setVisibility(8);
          localObject2 = localb.KxV;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(af.sL(l));
            localb.KxV.setVisibility(0);
            localb.KxU.setImageResource(2131232021);
            if ((localObject1 != null) && (!bu.isNullOrNil(((k.b)localObject1).hCE))) {
              l.b.KxW.put(((k.b)localObject1).hCE, new WeakReference(localb));
            }
            if (parama != null)
            {
              localObject1 = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject1 = h.B(this.JWz.Kkd.getMMResources().getDrawable(2131231063));
            }
            localb.KxR.setImageBitmap((Bitmap)localObject1);
          }
        }
        for (;;)
        {
          localb.KxR.setTag(new bk(parambv, parama1.fJC(), paramInt, paramString, '\000'));
          localb.KxR.setOnClickListener(m(parama1));
          localb.KxR.setOnLongClickListener(c(parama1));
          localb.KxR.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
          localb.KxU.setOnClickListener(m(parama1));
          localb.KxU.setOnLongClickListener(c(parama1));
          localb.KxU.setTag(localb.KxR.getTag());
          AppMethodBeat.o(36926);
          return;
          l = ((k.b)localObject1).hCC;
          break;
          parama.talker = parambv.field_talker;
          localb.KxR.a(parama, parambv.field_msgId);
          localb.KxU.setVisibility(8);
          localb.KxT.setVisibility(8);
          localb.KxV.setVisibility(8);
          localb.KxU.setVisibility(8);
          if ((localObject1 != null) && (!bu.isNullOrNil(((k.b)localObject1).hCE))) {
            l.b.KxW.remove(((k.b)localObject1).hCE);
          }
          a(parambv, parama);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36929);
    boolean bool = ((p)parama.bh(p.class)).a(paramMenuItem, parama, parambv);
    AppMethodBeat.o(36929);
    return bool;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187736);
    int i = ((bk)paramView.getTag()).position;
    Object localObject2 = az.aVt(parambv.field_content);
    Object localObject1 = k.b.aB(parambv.field_content, parambv.field_reserved);
    if (localObject1 == null)
    {
      localObject1 = new k.b();
      ((k.b)localObject1).hCE = ((az)localObject2).md5;
    }
    for (;;)
    {
      if ((!af.isNullOrNil(((k.b)localObject1).hCE)) && (!((k.b)localObject1).hCE.equals("-1")))
      {
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(((k.b)localObject1).hCE);
        if (localObject1 != null)
        {
          if ((((EmojiInfo)localObject1).field_catalog != EmojiInfo.OAa) && (!((EmojiInfo)localObject1).fxr())) {
            paraml.a(i, 104, paramView.getContext().getString(2131757235), 2131691571);
          }
          localObject2 = com.tencent.mm.search.c.b.ICF;
          com.tencent.mm.search.c.b.b((EmojiInfo)localObject1, this.JWz.getTalkerUserName());
          boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDY, true);
          if (((paramView.getContext() instanceof Activity)) && (paramView.getContext().getResources().getConfiguration().orientation == 1) && (bool))
          {
            ae.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
            paraml.a(i, 115, paramView.getContext().getString(2131757238), 2131691579);
          }
          if (localObject1 != null) {
            com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(0), ((EmojiInfo)localObject1).Lj(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
          }
          if (!((EmojiInfo)localObject1).fxn()) {
            break label478;
          }
          paraml.a(i, 113, paramView.getContext().getString(2131762559), 2131690478);
        }
      }
      for (;;)
      {
        if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().chO()) {
          paraml.a(i, 135, paramView.getContext().getString(2131757224), 2131691574);
        }
        if (bn.z(parambv)) {
          paraml.clear();
        }
        if (!this.JWz.fJD()) {
          paraml.a(i, 100, paramView.getContext().getString(2131757219), 2131690384);
        }
        AppMethodBeat.o(187736);
        return true;
        label478:
        ae.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36927);
    boolean bool = parama.fJC();
    AppMethodBeat.o(36927);
    return bool;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1048625);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */