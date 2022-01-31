package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;

public final class h$b
  extends a.b
{
  public h$b(h paramh)
  {
    super(paramh);
  }
  
  public final boolean VB()
  {
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listinfoitem, paramViewGroup, false);
    paramViewGroup = (h.a)this.vOL.vOK;
    paramViewGroup.kDb = ((TextView)paramContext.findViewById(a.e.info_tv));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = (h.a)parama;
    m.a(h.a(this.vOL), paramContext.kDb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.h.b
 * JD-Core Version:    0.7.0.1
 */