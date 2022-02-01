package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;

public final class j
  extends a
{
  private b Xyd;
  a Xye;
  public String header;
  
  public j(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(102960);
    this.Xyd = new b();
    this.Xye = new a();
    AppMethodBeat.o(102960);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bwF()
  {
    return this.Xyd;
  }
  
  public final a.a bwG()
  {
    return this.Xye;
  }
  
  public final class a
    extends a.a
  {
    public TextView tOY;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102958);
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listheaderitem, paramViewGroup, false);
      paramViewGroup = (j.a)j.this.Xye;
      paramViewGroup.tOY = ((TextView)paramContext.findViewById(a.e.header_tv));
      paramContext.setTag(paramViewGroup);
      if (j.this.xUe)
      {
        View localView = paramContext.findViewById(a.e.header_tv_root);
        if (localView != null) {
          localView.setBackgroundResource(com.tencent.mm.plugin.selectcontact.a.b.Dark_0);
        }
        paramViewGroup.tOY.setTextColor(paramViewGroup.tOY.getContext().getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_100_Alpha_0_5));
      }
      AppMethodBeat.o(102958);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102959);
      paramContext = (j.a)parama;
      n.a(((j)parama1).header, paramContext.tOY);
      AppMethodBeat.o(102959);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.j
 * JD-Core Version:    0.7.0.1
 */