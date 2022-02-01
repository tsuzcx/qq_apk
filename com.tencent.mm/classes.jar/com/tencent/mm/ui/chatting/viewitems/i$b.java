package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$b
  extends c
{
  private a PhN;
  
  private static String aGb(String paramString)
  {
    AppMethodBeat.i(36889);
    try
    {
      paramString = k.b.HD(paramString);
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
      localObject = new an(paramLayoutInflater, 2131493561);
      ((View)localObject).setTag(new i.a().G((View)localObject, true));
    }
    AppMethodBeat.o(36887);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36890);
    this.PhN = parama1;
    i.a locala = (i.a)parama;
    paramString = paramca.field_content;
    parama = parama1.getTalkerUserName();
    Object localObject = (d)parama1.bh(d.class);
    int i;
    if ((parama1.gRM()) && (!((d)localObject).gOP()))
    {
      i = bp.Kp(paramString);
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
      paramString = aGb(paramString);
      a(locala, parama1, paramca, parama);
      a(locala, parama1, parama, paramca);
      locala.PJU.setText(paramString);
      parama = locala.PJU;
      i = paramca.getType();
      paramString = parama1.getTalkerUserName();
      if (i != 301989937) {
        l.a(parama, paramString);
      }
      parama.getText();
      parama = bq.b(paramca, parama1.gRM(), paramInt);
      locala.PJU.setTag(parama);
      locala.PJU.setOnLongClickListener(c(parama1));
      locala.PJU.setOnDoubleClickLitsener(((k)parama1.bh(k.class)).gOB());
      AppMethodBeat.o(36890);
      return;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233622);
    paramm.a(((bq)paramView.getTag()).position, 100, paramView.getContext().getString(2131757433), 2131690529);
    AppMethodBeat.o(233622);
    return false;
  }
  
  protected final boolean b(a parama)
  {
    AppMethodBeat.i(36888);
    boolean bool = parama.gRM();
    AppMethodBeat.o(36888);
    return bool;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.b
 * JD-Core Version:    0.7.0.1
 */