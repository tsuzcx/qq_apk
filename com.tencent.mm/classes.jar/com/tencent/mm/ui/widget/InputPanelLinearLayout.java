package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPanelLinearLayout
  extends LinearLayout
  implements b.a
{
  private b ACb;
  
  public InputPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107859);
    this.ACb = new b(this, this);
    AppMethodBeat.o(107859);
  }
  
  public b getInputPanelHelper()
  {
    return this.ACb;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107860);
    this.ACb.QX(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(107860);
  }
  
  public void p(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InputPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */