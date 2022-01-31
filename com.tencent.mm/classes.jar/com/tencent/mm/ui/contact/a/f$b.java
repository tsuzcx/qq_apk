package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;

public final class f$b
  extends a.b
{
  public f$b(f paramf)
  {
    super(paramf);
  }
  
  public final boolean VB()
  {
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcreatechatroomitem, paramViewGroup, false);
    paramViewGroup = (f.a)this.vOF.vOE;
    paramViewGroup.eXP = ((TextView)paramContext.findViewById(a.e.desc_tv));
    paramViewGroup.qXz = paramContext.findViewById(a.e.header_diviver_view);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = (f.a)parama;
    m.a(f.a((f)parama1), paramContext.eXP);
    if (this.vOF.position == 0)
    {
      paramContext.qXz.setVisibility(8);
      return;
    }
    paramContext.qXz.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f.b
 * JD-Core Version:    0.7.0.1
 */