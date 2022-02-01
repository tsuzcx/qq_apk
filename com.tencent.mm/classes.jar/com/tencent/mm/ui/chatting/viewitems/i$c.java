package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$c
  extends c
  implements s.n
{
  private a JBI;
  
  private static String aWB(String paramString)
  {
    AppMethodBeat.i(36893);
    try
    {
      paramString = k.b.yr(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36893);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
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
      ((View)localObject).setTag(new i.a().z((View)localObject, false));
    }
    AppMethodBeat.o(36892);
    return localObject;
  }
  
  public final void a(a parama, bu parambu)
  {
    AppMethodBeat.i(36896);
    if (parambu.cTc())
    {
      m.aG(parambu);
      bj.rJ(parambu.field_msgId);
      parama.xR(true);
      AppMethodBeat.o(36896);
      return;
    }
    AppMethodBeat.o(36896);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36894);
    this.JBI = parama1;
    parama = (i.a)parama;
    if (fHj())
    {
      b(parama, false);
      if ((parambu.field_status == 1) || (parambu.field_status == 5))
      {
        if (parama.JZD != null) {
          parama.JZD.setVisibility(8);
        }
        parama.Kbm.setBackgroundResource(2131231726);
        parambu.IMh = true;
      }
      for (;;)
      {
        paramString = aWB(parambu.field_content);
        if (bt.isNullOrNil(paramString)) {
          ad.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambu.field_msgId), Long.valueOf(parambu.field_msgSvrId) });
        }
        parama.Kbm.setMinWidth(0);
        parama.Kbm.setText(paramString);
        paramString = parama.Kbm;
        int i = parambu.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          com.tencent.mm.pluginsdk.ui.span.k.a(paramString, str);
        }
        paramString.getText();
        paramString = bk.b(parambu, parama1.fFv(), paramInt);
        parama.Kbm.setTag(paramString);
        parama.Kbm.setOnLongClickListener(c(parama1));
        parama.Kbm.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCt());
        a(paramInt, parama, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
        AppMethodBeat.o(36894);
        return;
        parama.Kbm.setBackgroundResource(2131231725);
        if (parama.JZD != null) {
          if (b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))
          {
            if (parambu.IMh)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.Kbm.startAnimation(paramString);
              parambu.IMh = false;
            }
            parama.JZD.setVisibility(0);
          }
          else
          {
            parama.JZD.setVisibility(8);
          }
        }
      }
    }
    if (parambu.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194338);
    paraml.a(((bk)paramView.getTag()).position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(194338);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */