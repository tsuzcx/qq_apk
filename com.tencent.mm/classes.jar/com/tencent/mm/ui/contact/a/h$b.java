package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.m;

public final class h$b
  extends a.b
{
  public h$b(h paramh)
  {
    super(paramh);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105293);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970667, paramViewGroup, false);
    paramViewGroup = (h.a)this.Ags.Agr;
    paramViewGroup.kHN = ((TextView)paramContext.findViewById(2131822836));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(105293);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105294);
    paramContext = (h.a)parama;
    m.a(((h)parama1).mZq, paramContext.kHN);
    AppMethodBeat.o(105294);
  }
  
  public final boolean aoZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.h.b
 * JD-Core Version:    0.7.0.1
 */