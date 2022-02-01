package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends a
{
  private a Krt;
  b Kru;
  
  public k(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(102970);
    this.Krt = new a();
    this.Kru = new b();
    AppMethodBeat.o(102970);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b aRs()
  {
    return this.Krt;
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131495365, paramViewGroup, false);
      paramViewGroup = (k.b)k.this.Kru;
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.contentView = paramContext.findViewById(2131304518);
      paramViewGroup.Krw = ((ImageView)paramContext.findViewById(2131304538));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102968);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102969);
      paramContext = (k.b)parama;
      paramContext.iVq.setText(2131762992);
      if (paramBoolean2) {
        paramContext.Krw.setVisibility(0);
      }
      for (;;)
      {
        paramContext.contentView.setBackgroundResource(2131231820);
        AppMethodBeat.o(102969);
        return;
        paramContext.Krw.setVisibility(8);
      }
    }
    
    public final boolean aRt()
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public ImageView Krw;
    public View contentView;
    public TextView iVq;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.k
 * JD-Core Version:    0.7.0.1
 */