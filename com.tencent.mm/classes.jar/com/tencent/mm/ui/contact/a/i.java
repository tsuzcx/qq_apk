package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.m;

public final class i
  extends a
{
  private b Agt;
  a.a Agu;
  private CharSequence mZu;
  
  public i(int paramInt)
  {
    super(6, paramInt);
    AppMethodBeat.i(105298);
    this.Agt = new b();
    this.Agu = new a();
    AppMethodBeat.o(105298);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(105299);
    this.mZu = f.a(paramContext.getString(2131302982), paramContext.getString(2131302981), d.b(this.query, this.query)).mSp;
    AppMethodBeat.o(105299);
  }
  
  public final a.b aoY()
  {
    return this.Agt;
  }
  
  public final class a
    extends a.a
  {
    public TextView mYX;
    
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
      AppMethodBeat.i(105296);
      paramContext = LayoutInflater.from(paramContext).inflate(2130970668, paramViewGroup, false);
      paramViewGroup = (i.a)i.this.Agu;
      paramViewGroup.mYX = ((TextView)paramContext.findViewById(2131824340));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(105296);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(105297);
      paramContext = (i.a)parama;
      m.a(i.a(i.this), paramContext.mYX);
      AppMethodBeat.o(105297);
    }
    
    public final boolean aoZ()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.i
 * JD-Core Version:    0.7.0.1
 */