package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k$a
  extends a.b
{
  public k$a(k paramk)
  {
    super(paramk);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105303);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970670, paramViewGroup, false);
    paramViewGroup = (k.b)this.AgA.Agz;
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.contentView = paramContext.findViewById(2131826406);
    paramViewGroup.gpN = ((CheckBox)paramContext.findViewById(2131821631));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(105303);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105304);
    paramContext = (k.b)parama;
    paramContext.gpL.setText(2131303048);
    paramContext.gpN.setBackgroundResource(2130839639);
    paramContext.gpN.setChecked(paramBoolean2);
    paramContext.gpN.setEnabled(true);
    paramContext.gpN.setVisibility(0);
    paramContext.contentView.setBackgroundResource(2130838447);
    AppMethodBeat.o(105304);
  }
  
  public final boolean aoZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.k.a
 * JD-Core Version:    0.7.0.1
 */