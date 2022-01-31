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
  TextView ldI;
  TextView qkT;
  
  public F2fDynamicCodeItemLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(44804);
    init();
    AppMethodBeat.o(44804);
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(44805);
    init();
    AppMethodBeat.o(44805);
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(44806);
    init();
    AppMethodBeat.o(44806);
  }
  
  private void init()
  {
    AppMethodBeat.i(44807);
    View localView = LayoutInflater.from(getContext()).inflate(2130970571, this);
    this.qkT = ((TextView)localView.findViewById(2131827285));
    this.ldI = ((TextView)localView.findViewById(2131827286));
    AppMethodBeat.o(44807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2fDynamicCodeItemLayout
 * JD-Core Version:    0.7.0.1
 */