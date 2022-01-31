package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.m;

public final class j$b
  extends a.b
{
  public j$b(j paramj)
  {
    super(paramj);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105300);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970669, paramViewGroup, false);
    paramViewGroup = (j.a)this.Agx.Agu;
    paramViewGroup.mYB = ((TextView)paramContext.findViewById(2131824335));
    paramViewGroup.mYC = ((ImageView)paramContext.findViewById(2131824336));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(105300);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105301);
    parama = (j.a)parama;
    parama1 = (j)parama1;
    paramContext = paramContext.getResources();
    if (this.Agx.mYy)
    {
      m.a(paramContext.getString(2131303016, new Object[] { paramContext.getString(parama1.resId) }), parama.mYB);
      parama.mYC.setRotation(0.0F);
      AppMethodBeat.o(105301);
      return;
    }
    m.a(paramContext.getString(2131303017), parama.mYB);
    parama.mYC.setRotation(180.0F);
    AppMethodBeat.o(105301);
  }
  
  public final boolean aoZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.j.b
 * JD-Core Version:    0.7.0.1
 */