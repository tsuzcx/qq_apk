package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.n;

public final class h
  extends a
{
  private b KNF;
  a KNG;
  public String header;
  
  public h(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(102960);
    this.KNF = new b();
    this.KNG = new a();
    AppMethodBeat.o(102960);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b aRR()
  {
    return this.KNF;
  }
  
  public final class a
    extends a.a
  {
    public TextView pbr;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131495362, paramViewGroup, false);
      paramViewGroup = (h.a)h.this.KNG;
      paramViewGroup.pbr = ((TextView)paramContext.findViewById(2131300734));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102958);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102959);
      paramContext = (h.a)parama;
      n.a(((h)parama1).header, paramContext.pbr);
      AppMethodBeat.o(102959);
    }
    
    public final boolean aRS()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.h
 * JD-Core Version:    0.7.0.1
 */