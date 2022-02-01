package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.ui.n;

public final class i
  extends a
{
  private b KNI;
  a.a KNJ;
  private CharSequence tMs;
  
  public i(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(102963);
    this.KNI = new b();
    this.KNJ = new a();
    AppMethodBeat.o(102963);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102964);
    this.tMs = com.tencent.mm.plugin.fts.a.f.a(paramContext.getString(2131762920), paramContext.getString(2131762919), e.c(this.query, this.query)).tFv;
    AppMethodBeat.o(102964);
  }
  
  public final a.b aRR()
  {
    return this.KNI;
  }
  
  public final class a
    extends a.a
  {
    public TextView tLW;
    
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
      paramViewGroup = (i.a)i.this.KNJ;
      paramViewGroup.tLW = ((TextView)paramContext.findViewById(2131301013));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102961);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102962);
      paramContext = (i.a)parama;
      n.a(i.a(i.this), paramContext.tLW);
      AppMethodBeat.o(102962);
    }
    
    public final boolean aRS()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.i
 * JD-Core Version:    0.7.0.1
 */