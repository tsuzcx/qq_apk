package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$b
  extends c
{
  private a Gob;
  
  private static String aLd(String paramString)
  {
    AppMethodBeat.i(36889);
    try
    {
      paramString = k.b.rx(paramString);
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
      localObject = new af(paramLayoutInflater, 2131493459);
      ((View)localObject).setTag(new i.a().z((View)localObject, true));
    }
    AppMethodBeat.o(36887);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36890);
    this.Gob = parama1;
    i.a locala = (i.a)parama;
    paramString = parambl.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (d)parama1.be(d.class);
    int i;
    if ((parama1.eZb()) && (!((d)localObject).eWC()))
    {
      i = com.tencent.mm.model.bi.uc(paramString);
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
      paramString = aLd(paramString);
      a(locala, parama1, parambl, parama);
      a(locala, parama1, parama, parambl);
      locala.GKR.setText(paramString);
      parama = locala.GKR;
      i = parambl.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        k.a(parama, paramString);
      }
      parama.getText();
      parama = bi.b(parambl, parama1.eZb(), paramInt);
      locala.GKR.setTag(parama);
      locala.GKR.setOnLongClickListener(c(parama1));
      locala.GKR.setOnDoubleClickLitsener(((i)parama1.be(i.class)).eWo());
      AppMethodBeat.o(36890);
      return;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36891);
    paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(36891);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(36888);
    boolean bool = parama.eZb();
    AppMethodBeat.o(36888);
    return bool;
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.b
 * JD-Core Version:    0.7.0.1
 */