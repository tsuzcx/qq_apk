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

public final class n
  extends a
{
  private a afky;
  b afkz;
  
  public n(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(102970);
    this.afky = new a();
    this.afkz = new b();
    AppMethodBeat.o(102970);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bVv()
  {
    return this.afky;
  }
  
  protected final a.a bVw()
  {
    return this.afkz;
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
      paramViewGroup = (n.b)n.this.afkz;
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(a.e.title_tv));
      paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
      paramViewGroup.afkB = ((ImageView)paramContext.findViewById(a.e.select_single_mark_iv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102968);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102969);
      paramContext = (n.b)parama;
      paramContext.pJJ.setText(a.h.select_contact_nonlimit);
      if (paramBoolean2) {
        paramContext.afkB.setVisibility(0);
      }
      for (;;)
      {
        paramContext.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
        AppMethodBeat.o(102969);
        return;
        paramContext.afkB.setVisibility(8);
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
    public ImageView afkB;
    public View contentView;
    public TextView pJJ;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.n
 * JD-Core Version:    0.7.0.1
 */