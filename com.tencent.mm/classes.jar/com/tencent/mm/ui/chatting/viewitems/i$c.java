package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$c
  extends c
  implements t.n
{
  private a JWz;
  
  private static String asC(String paramString)
  {
    AppMethodBeat.i(36893);
    try
    {
      paramString = k.b.zb(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36893);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(36893);
    }
    return "";
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36892);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493502);
      ((View)localObject).setTag(new i.a().E((View)localObject, false));
    }
    AppMethodBeat.o(36892);
    return localObject;
  }
  
  public final void a(a parama, bv parambv)
  {
    AppMethodBeat.i(36896);
    if (parambv.cVH())
    {
      m.aF(parambv);
      bl.rW(parambv.field_msgId);
      parama.xY(true);
      AppMethodBeat.o(36896);
      return;
    }
    AppMethodBeat.o(36896);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(36894);
    this.JWz = parama1;
    parama = (i.a)parama;
    if (fLB())
    {
      b(parama, false);
      if ((parambv.field_status == 1) || (parambv.field_status == 5))
      {
        if (parama.KvW != null) {
          parama.KvW.setVisibility(8);
        }
        parama.KxE.setBackgroundResource(2131231726);
        parambv.JgO = true;
      }
      for (;;)
      {
        paramString = asC(parambv.field_content);
        if (bu.isNullOrNil(paramString)) {
          ae.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgSvrId) });
        }
        parama.KxE.setMinWidth(0);
        parama.KxE.setText(paramString);
        paramString = parama.KxE;
        int i = parambv.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          com.tencent.mm.pluginsdk.ui.span.k.a(paramString, str);
        }
        paramString.getText();
        paramString = bk.b(parambv, parama1.fJC(), paramInt);
        parama.KxE.setTag(paramString);
        parama.KxE.setOnLongClickListener(c(parama1));
        parama.KxE.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGv());
        a(paramInt, parama, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        AppMethodBeat.o(36894);
        return;
        parama.KxE.setBackgroundResource(2131231725);
        if (parama.KvW != null) {
          if (b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))
          {
            if (parambv.JgO)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.KxE.startAnimation(paramString);
              parambv.JgO = false;
            }
            parama.KvW.setVisibility(0);
          }
          else
          {
            parama.KvW.setVisibility(8);
          }
        }
      }
    }
    if (parambv.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187733);
    paraml.a(((bk)paramView.getTag()).position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(187733);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */