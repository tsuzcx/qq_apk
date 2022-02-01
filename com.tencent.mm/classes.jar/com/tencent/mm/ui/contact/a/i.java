package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.ui.m;

public final class i
  extends a
{
  private b GZQ;
  a.a GZR;
  private CharSequence rvR;
  
  public i(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(102963);
    this.GZQ = new b();
    this.GZR = new a();
    AppMethodBeat.o(102963);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102964);
    this.rvR = com.tencent.mm.plugin.fts.a.f.a(paramContext.getString(2131762920), paramContext.getString(2131762919), e.b(this.query, this.query)).rpj;
    AppMethodBeat.o(102964);
  }
  
  public final a.b aHr()
  {
    return this.GZQ;
  }
  
  public final class a
    extends a.a
  {
    public TextView rvw;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131495363, paramViewGroup, false);
      paramViewGroup = (i.a)i.this.GZR;
      paramViewGroup.rvw = ((TextView)paramContext.findViewById(2131301013));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102961);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102962);
      paramContext = (i.a)parama;
      m.a(i.a(i.this), paramContext.rvw);
      AppMethodBeat.o(102962);
    }
    
    public final boolean aHs()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.i
 * JD-Core Version:    0.7.0.1
 */