package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class j$c
  extends c
  implements v.n
{
  private a aeiK;
  
  private static String aNi(String paramString)
  {
    AppMethodBeat.i(36893);
    try
    {
      paramString = k.b.Hf(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36893);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
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
      localObject = new ap(paramLayoutInflater, R.i.ghe);
      ((View)localObject).setTag(new j.a().P((View)localObject, false));
    }
    AppMethodBeat.o(36892);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36894);
    this.aeiK = parama1;
    parama = (j.a)parama;
    if (jxj())
    {
      b(parama, false);
      if ((paramcc.field_status == 1) || (paramcc.field_status == 5))
      {
        if (parama.aeNG != null) {
          parama.aeNG.setVisibility(8);
        }
        parama.aePx.setBackgroundResource(R.g.fnx);
        paramcc.adku = true;
      }
      for (;;)
      {
        paramString = aNi(paramcc.field_content);
        if (Util.isNullOrNil(paramString)) {
          Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
        }
        parama.aePx.setMinWidth(0);
        parama.aePx.setText(paramString);
        paramString = parama.aePx;
        int i = paramcc.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          p.a(paramString, str);
        }
        paramString.getText();
        paramString = bz.b(paramcc, parama1.juG(), paramInt);
        parama.aePx.setTag(paramString);
        parama.aePx.setOnLongClickListener(c(parama1));
        parama.aePx.setOnDoubleClickLitsener(((m)parama1.cm(m.class)).jqu());
        a(paramInt, parama, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
        AppMethodBeat.o(36894);
        return;
        parama.aePx.setBackgroundResource(R.g.chatto_bg);
        if (parama.aeNG != null) {
          if (b((m)parama1.cm(m.class), paramcc.field_msgId))
          {
            if (paramcc.adku)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.aePx.startAnimation(paramString);
              paramcc.adku = false;
            }
            parama.aeNG.setVisibility(0);
          }
          else
          {
            parama.aeNG.setVisibility(8);
          }
        }
      }
    }
    if (paramcc.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255367);
    params.a(((bz)paramView.getTag()).position, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255367);
    return false;
  }
  
  public final void b(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(255378);
    if (paramcc.fxR())
    {
      n.bx(paramcc);
      br.iu(paramcc.field_msgId);
      parama.jpK();
      AppMethodBeat.o(255378);
      return;
    }
    AppMethodBeat.o(255378);
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.c
 * JD-Core Version:    0.7.0.1
 */