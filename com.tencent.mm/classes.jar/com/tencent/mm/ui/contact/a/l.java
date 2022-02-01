package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class l
  extends a
{
  private CharSequence HBi;
  private b afkt;
  a.a afku;
  
  public l(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(102963);
    this.afkt = new b();
    this.afku = new a();
    AppMethodBeat.o(102963);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102964);
    this.HBi = f.a(paramContext.getString(a.h.search_contact_no_result_pre), paramContext.getString(a.h.search_contact_no_result_post), g.c(this.query, this.query)).HsX;
    AppMethodBeat.o(102964);
  }
  
  public final a.b bVv()
  {
    return this.afkt;
  }
  
  protected final a.a bVw()
  {
    return this.afku;
  }
  
  public final class a
    extends a.a
  {
    public TextView HAL;
    
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
      AppMethodBeat.i(102961);
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listinfoitem, paramViewGroup, false);
      paramViewGroup = (l.a)l.this.afku;
      paramViewGroup.HAL = ((TextView)paramContext.findViewById(a.e.info_tv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102961);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102962);
      paramContext = (l.a)parama;
      o.a(l.a(l.this), paramContext.HAL);
      AppMethodBeat.o(102962);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.l
 * JD-Core Version:    0.7.0.1
 */