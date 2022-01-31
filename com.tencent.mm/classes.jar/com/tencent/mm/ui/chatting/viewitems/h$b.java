package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class h$b
  extends c
{
  private a zzP;
  
  private static String aun(String paramString)
  {
    AppMethodBeat.i(32905);
    try
    {
      paramString = j.b.mY(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(32905);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(32905);
    }
    return "";
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32903);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969086);
      ((View)localObject).setTag(new h.a().A((View)localObject, true));
    }
    AppMethodBeat.o(32903);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32906);
    this.zzP = parama1;
    h.a locala = (h.a)parama;
    paramString = parambi.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (d)parama1.ay(d.class);
    int i;
    if ((parama1.dJG()) && (!((d)localObject).dHv()))
    {
      i = bf.pt(paramString);
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
      paramString = aun(paramString);
      a(locala, parama1, parambi, parama);
      a(locala, parama1, parama, parambi);
      locala.zTF.setText(paramString);
      parama = locala.zTF;
      i = parambi.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        j.a(parama, paramString);
      }
      parama.getText();
      parama = az.b(parambi, parama1.dJG(), paramInt);
      locala.zTF.setTag(parama);
      locala.zTF.setOnLongClickListener(c(parama1));
      locala.zTF.setOnDoubleClickLitsener(((h)parama1.ay(h.class)).dHh());
      AppMethodBeat.o(32906);
      return;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32907);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131298232));
    AppMethodBeat.o(32907);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(32904);
    boolean bool = parama.dJG();
    AppMethodBeat.o(32904);
    return bool;
  }
  
  protected final boolean dLo()
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.b
 * JD-Core Version:    0.7.0.1
 */