package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$b
  extends c
{
  private a JBI;
  
  private static String aWB(String paramString)
  {
    AppMethodBeat.i(36889);
    try
    {
      paramString = k.b.yr(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36889);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
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
      localObject = new ah(paramLayoutInflater, 2131493459);
      ((View)localObject).setTag(new i.a().z((View)localObject, true));
    }
    AppMethodBeat.o(36887);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36890);
    this.JBI = parama1;
    i.a locala = (i.a)parama;
    paramString = parambu.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (d)parama1.bh(d.class);
    int i;
    if ((parama1.fFv()) && (!((d)localObject).fCH()))
    {
      i = bj.Bh(paramString);
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
      paramString = aWB(paramString);
      a(locala, parama1, parambu, parama);
      a(locala, parama1, parama, parambu);
      locala.Kbm.setText(paramString);
      parama = locala.Kbm;
      i = parambu.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        com.tencent.mm.pluginsdk.ui.span.k.a(parama, paramString);
      }
      parama.getText();
      parama = bk.b(parambu, parama1.fFv(), paramInt);
      locala.Kbm.setTag(parama);
      locala.Kbm.setOnLongClickListener(c(parama1));
      locala.Kbm.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCt());
      AppMethodBeat.o(36890);
      return;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194337);
    paraml.a(((bk)paramView.getTag()).position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(194337);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(36888);
    boolean bool = parama.fFv();
    AppMethodBeat.o(36888);
    return bool;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.b
 * JD-Core Version:    0.7.0.1
 */