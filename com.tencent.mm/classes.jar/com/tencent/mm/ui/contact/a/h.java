package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.m;

public final class h
  extends a
{
  private b IAf;
  a IAg;
  public String header;
  
  public h(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(102960);
    this.IAf = new b();
    this.IAg = new a();
    AppMethodBeat.o(102960);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b aOg()
  {
    return this.IAf;
  }
  
  public final class a
    extends a.a
  {
    public TextView ors;
    
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
      paramViewGroup = (h.a)h.this.IAg;
      paramViewGroup.ors = ((TextView)paramContext.findViewById(2131300734));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102958);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102959);
      paramContext = (h.a)parama;
      m.a(((h)parama1).header, paramContext.ors);
      AppMethodBeat.o(102959);
    }
    
    public final boolean aOh()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.h
 * JD-Core Version:    0.7.0.1
 */