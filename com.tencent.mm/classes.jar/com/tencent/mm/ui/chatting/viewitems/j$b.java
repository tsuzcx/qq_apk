package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class j$b
  extends c
{
  private a aeiK;
  
  private static String aNi(String paramString)
  {
    AppMethodBeat.i(36889);
    try
    {
      paramString = k.b.Hf(paramString);
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
      localObject = new ap(paramLayoutInflater, R.i.ggg);
      ((View)localObject).setTag(new j.a().P((View)localObject, true));
    }
    AppMethodBeat.o(36887);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36890);
    this.aeiK = parama1;
    j.a locala = (j.a)parama;
    paramString = paramcc.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (e)parama1.cm(e.class);
    int i;
    if ((parama1.juG()) && (!((e)localObject).jqV()))
    {
      i = br.JG(paramString);
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
      paramString = aNi(paramString);
      a(locala, parama1, paramcc, parama);
      a(locala, parama1, parama, paramcc);
      locala.aePx.setText(paramString);
      parama = locala.aePx;
      i = paramcc.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        p.a(parama, paramString);
      }
      parama.getText();
      parama = bz.b(paramcc, parama1.juG(), paramInt);
      locala.aePx.setTag(parama);
      locala.aePx.setOnLongClickListener(c(parama1));
      locala.aePx.setOnDoubleClickLitsener(((m)parama1.cm(m.class)).jqu());
      AppMethodBeat.o(36890);
      return;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255377);
    params.a(((bz)paramView.getTag()).position, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255377);
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(36888);
    boolean bool = parama.juG();
    AppMethodBeat.o(36888);
    return bool;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.b
 * JD-Core Version:    0.7.0.1
 */