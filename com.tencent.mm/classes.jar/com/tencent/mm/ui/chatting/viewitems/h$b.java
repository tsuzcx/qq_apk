package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class h$b
  extends c
{
  private a vko;
  
  private static String adH(String paramString)
  {
    try
    {
      paramString = g.a.gp(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
    }
    return "";
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_text_c2c);
      ((View)localObject).setTag(new h.a().s((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    h.a locala = (h.a)parama;
    paramString = parambi.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (com.tencent.mm.ui.chatting.b.b.c)parama1.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    int i;
    if ((parama1.cFE()) && (!((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG()))
    {
      i = bd.iH(paramString);
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
      paramString = adH(paramString);
      a(locala, parama1, parambi, parama);
      a(locala, parama1, parama, parambi);
      locala.vCB.setText(paramString);
      parama = locala.vCB;
      i = parambi.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        j.a(parama, paramString);
      }
      parama.getText();
      parama = aw.b(parambi, parama1.cFE(), paramInt);
      locala.vCB.setTag(parama);
      locala.vCB.setOnLongClickListener(c(parama1));
      locala.vCB.setOnDoubleClickLitsener(((g)parama1.ac(g.class)).cDt());
      return;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    paramContextMenu.add(((aw)paramView.getTag()).position, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    return parama.cFE();
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected final boolean cHb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.b
 * JD-Core Version:    0.7.0.1
 */