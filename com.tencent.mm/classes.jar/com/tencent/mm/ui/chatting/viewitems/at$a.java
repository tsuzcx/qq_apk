package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;

public final class at$a
  extends ax.a
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37367);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493473);
      ((View)localObject).setTag(new at.c().gI((View)localObject));
    }
    AppMethodBeat.o(37367);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37368);
    this.JBI = parama1;
    parama = (at.c)parama;
    paramString = a.a.EG(parambu.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(37368);
      return;
    }
    String str = paramString.dyU;
    a(parama, parama1, parambu, str);
    a(parama, parama1, str, parambu);
    k.a(parama.KeJ.getContext(), com.tencent.mm.an.a.a(paramString), (int)parama.KeJ.getTextSize(), 1, null, "");
    parama.KeJ.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
    parama.KeJ.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(37368);
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194490);
    if (parambu.frO())
    {
      int i = ((bk)paramView.getTag()).position;
      if (parambu.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(194490);
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean fHg()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.a
 * JD-Core Version:    0.7.0.1
 */