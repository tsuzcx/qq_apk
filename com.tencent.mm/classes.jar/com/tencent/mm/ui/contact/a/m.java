package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class m
  extends a
{
  private a Xyl;
  b Xym;
  
  public m(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(102970);
    this.Xyl = new a();
    this.Xym = new b();
    AppMethodBeat.o(102970);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bwF()
  {
    return this.Xyl;
  }
  
  protected final a.a bwG()
  {
    return this.Xym;
  }
  
  public final class a
    extends a.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102968);
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listnonlimititem, paramViewGroup, false);
      paramViewGroup = (m.b)m.this.Xym;
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(a.e.title_tv));
      paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
      paramViewGroup.Xyo = ((ImageView)paramContext.findViewById(a.e.select_single_mark_iv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102968);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102969);
      paramContext = (m.b)parama;
      paramContext.mNb.setText(a.h.select_contact_nonlimit);
      if (paramBoolean2) {
        paramContext.Xyo.setVisibility(0);
      }
      for (;;)
      {
        paramContext.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
        AppMethodBeat.o(102969);
        return;
        paramContext.Xyo.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public ImageView Xyo;
    public View contentView;
    public TextView mNb;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.m
 * JD-Core Version:    0.7.0.1
 */