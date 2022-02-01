package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$b
  extends c
{
  private a HNS;
  
  private static String aQH(String paramString)
  {
    AppMethodBeat.i(36889);
    try
    {
      paramString = k.b.vA(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36889);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
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
      localObject = new ag(paramLayoutInflater, 2131493459);
      ((View)localObject).setTag(new i.a().z((View)localObject, true));
    }
    AppMethodBeat.o(36887);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36890);
    this.HNS = parama1;
    i.a locala = (i.a)parama;
    paramString = parambo.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (d)parama1.bf(d.class);
    int i;
    if ((parama1.foQ()) && (!((d)localObject).fmo()))
    {
      i = bi.yi(paramString);
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
      paramString = aQH(paramString);
      a(locala, parama1, parambo, parama);
      a(locala, parama1, parama, parambo);
      locala.IkO.setText(paramString);
      parama = locala.IkO;
      i = parambo.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        k.a(parama, paramString);
      }
      parama.getText();
      parama = bj.b(parambo, parama1.foQ(), paramInt);
      locala.IkO.setTag(parama);
      locala.IkO.setOnLongClickListener(c(parama1));
      locala.IkO.setOnDoubleClickLitsener(((i)parama1.bf(i.class)).fma());
      AppMethodBeat.o(36890);
      return;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36891);
    paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(36891);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(36888);
    boolean bool = parama.foQ();
    AppMethodBeat.o(36888);
    return bool;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.b
 * JD-Core Version:    0.7.0.1
 */