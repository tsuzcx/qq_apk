package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class j$c
  extends c
  implements t.n
{
  private a WBq;
  
  private static String aQo(String paramString)
  {
    AppMethodBeat.i(36893);
    try
    {
      paramString = k.b.OQ(paramString);
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
      localObject = new aq(paramLayoutInflater, R.i.eeo);
      ((View)localObject).setTag(new j.a().J((View)localObject, false));
    }
    AppMethodBeat.o(36892);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36894);
    this.WBq = parama1;
    parama = (j.a)parama;
    if (hTG())
    {
      b(parama, false);
      if ((paramca.field_status == 1) || (paramca.field_status == 5))
      {
        if (parama.XdI != null) {
          parama.XdI.setVisibility(8);
        }
        parama.Xfu.setBackgroundResource(R.g.dnl);
        paramca.VGB = true;
      }
      for (;;)
      {
        paramString = aQo(paramca.field_content);
        if (Util.isNullOrNil(paramString)) {
          Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
        }
        parama.Xfu.setMinWidth(0);
        parama.Xfu.setText(paramString);
        paramString = parama.Xfu;
        int i = paramca.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          l.a(paramString, str);
        }
        paramString.getText();
        paramString = by.b(paramca, parama1.hRi(), paramInt);
        parama.Xfu.setTag(paramString);
        parama.Xfu.setOnLongClickListener(c(parama1));
        parama.Xfu.setOnDoubleClickLitsener(((k)parama1.bC(k.class)).hNN());
        a(paramInt, parama, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
        AppMethodBeat.o(36894);
        return;
        parama.Xfu.setBackgroundResource(R.g.chatto_bg);
        if (parama.XdI != null) {
          if (b((k)parama1.bC(k.class), paramca.field_msgId))
          {
            if (paramca.VGB)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.Xfu.startAnimation(paramString);
              paramca.VGB = false;
            }
            parama.XdI.setVisibility(0);
          }
          else
          {
            parama.XdI.setVisibility(8);
          }
        }
      }
    }
    if (paramca.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(276850);
    paramo.a(((by)paramView.getTag()).position, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(276850);
    return false;
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(276851);
    if (paramca.erk())
    {
      m.bh(paramca);
      bq.Gk(paramca.field_msgId);
      parama.Gi(true);
      AppMethodBeat.o(276851);
      return;
    }
    AppMethodBeat.o(276851);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.c
 * JD-Core Version:    0.7.0.1
 */