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
  private a QaN;
  b QaO;
  
  public k(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(102970);
    this.QaN = new a();
    this.QaO = new b();
    AppMethodBeat.o(102970);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bmx()
  {
    return this.QaN;
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131496226, paramViewGroup, false);
      paramViewGroup = (k.b)k.this.QaO;
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.contentView = paramContext.findViewById(2131307533);
      paramViewGroup.QaQ = ((ImageView)paramContext.findViewById(2131307561));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102968);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102969);
      paramContext = (k.b)parama;
      paramContext.jVO.setText(2131765129);
      if (paramBoolean2) {
        paramContext.QaQ.setVisibility(0);
      }
      for (;;)
      {
        paramContext.contentView.setBackgroundResource(2131231901);
        AppMethodBeat.o(102969);
        return;
        paramContext.QaQ.setVisibility(8);
      }
    }
    
    public final boolean bmy()
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public ImageView QaQ;
    public View contentView;
    public TextView jVO;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.k
 * JD-Core Version:    0.7.0.1
 */