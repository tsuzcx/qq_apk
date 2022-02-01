package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class F2fDynamicCodeItemLayout
  extends LinearLayout
{
  TextView pAE;
  TextView xZN;
  
  public F2fDynamicCodeItemLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(67917);
    init();
    AppMethodBeat.o(67917);
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67918);
    init();
    AppMethodBeat.o(67918);
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67919);
    init();
    AppMethodBeat.o(67919);
  }
  
  private void init()
  {
    AppMethodBeat.i(67920);
    View localView = LayoutInflater.from(getContext()).inflate(2131495254, this);
    this.xZN = ((TextView)localView.findViewById(2131304168));
    this.pAE = ((TextView)localView.findViewById(2131304169));
    AppMethodBeat.o(67920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2fDynamicCodeItemLayout
 * JD-Core Version:    0.7.0.1
 */