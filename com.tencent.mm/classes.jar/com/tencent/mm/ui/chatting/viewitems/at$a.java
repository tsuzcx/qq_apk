package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;

public final class at$a
  extends ax.a
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      ((View)localObject).setTag(new at.c().gN((View)localObject));
    }
    AppMethodBeat.o(37367);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37368);
    this.JWz = parama1;
    parama = (at.c)parama;
    paramString = a.a.Fi(parambv.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(37368);
      return;
    }
    String str = paramString.dzZ;
    a(parama, parama1, parambv, str);
    a(parama, parama1, str, parambv);
    k.a(parama.KBc.getContext(), com.tencent.mm.am.a.a(paramString), (int)parama.KBc.getTextSize(), 1, null, "");
    parama.KBc.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
    parama.KBc.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(37368);
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187885);
    if (parambv.fvO())
    {
      int i = ((bk)paramView.getTag()).position;
      if (parambv.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(187885);
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean fLy()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.a
 * JD-Core Version:    0.7.0.1
 */