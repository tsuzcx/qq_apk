package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class i$b
  extends a.b
{
  public i$b(i parami)
  {
    super(parami);
  }
  
  public final boolean VB()
  {
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listmoreitem, paramViewGroup, false);
    paramViewGroup = (i.a)this.vON.vOK;
    paramViewGroup.kCF = ((TextView)paramContext.findViewById(a.e.more_tv));
    paramViewGroup.kCG = ((ImageView)paramContext.findViewById(a.e.more_arrow));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama = (i.a)parama;
    parama1 = (i)parama1;
    paramContext = paramContext.getResources();
    if (this.vON.kCC)
    {
      m.a(paramContext.getString(a.h.search_more_contact, new Object[] { paramContext.getString(parama1.kCB) }), parama.kCF);
      parama.kCG.setRotation(0.0F);
      return;
    }
    m.a(paramContext.getString(a.h.search_more_contact_collapse), parama.kCF);
    parama.kCG.setRotation(180.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.i.b
 * JD-Core Version:    0.7.0.1
 */