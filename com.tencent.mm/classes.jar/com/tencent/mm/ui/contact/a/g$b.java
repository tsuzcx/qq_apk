package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;

public final class g$b
  extends a.b
{
  public g$b(g paramg)
  {
    super(paramg);
  }
  
  public final boolean VB()
  {
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listheaderitem, paramViewGroup, false);
    paramViewGroup = (g.a)this.vOI.vOH;
    paramViewGroup.iCG = ((TextView)paramContext.findViewById(a.e.header_tv));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = (g.a)parama;
    m.a(((g)parama1).kDu, paramContext.iCG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.g.b
 * JD-Core Version:    0.7.0.1
 */