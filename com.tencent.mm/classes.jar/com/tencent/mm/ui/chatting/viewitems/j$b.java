package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class j$b
  extends c
{
  private a WBq;
  
  private static String aQo(String paramString)
  {
    AppMethodBeat.i(36889);
    try
    {
      paramString = k.b.OQ(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36889);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(36889);
    }
    return "";
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36887);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.edq);
      ((View)localObject).setTag(new j.a().J((View)localObject, true));
    }
    AppMethodBeat.o(36887);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36890);
    this.WBq = parama1;
    j.a locala = (j.a)parama;
    paramString = paramca.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (d)parama1.bC(d.class);
    int i;
    if ((parama1.hRi()) && (!((d)localObject).hOe()))
    {
      i = bq.RI(paramString);
      if (i != -1)
      {
        localObject = paramString.substring(0, i).trim();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          parama = (c.a)localObject;
          paramString = paramString.substring(i + 1).trim();
        }
      }
    }
    for (;;)
    {
      paramString = aQo(paramString);
      a(locala, parama1, paramca, parama);
      a(locala, parama1, parama, paramca);
      locala.Xfu.setText(paramString);
      parama = locala.Xfu;
      i = paramca.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        l.a(parama, paramString);
      }
      parama.getText();
      parama = by.b(paramca, parama1.hRi(), paramInt);
      locala.Xfu.setTag(parama);
      locala.Xfu.setOnLongClickListener(c(parama1));
      locala.Xfu.setOnDoubleClickLitsener(((k)parama1.bC(k.class)).hNN());
      AppMethodBeat.o(36890);
      return;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(277315);
    paramo.a(((by)paramView.getTag()).position, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(277315);
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(36888);
    boolean bool = parama.hRi();
    AppMethodBeat.o(36888);
    return bool;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.b
 * JD-Core Version:    0.7.0.1
 */