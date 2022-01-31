package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPanelFrameLayout
  extends FrameLayout
  implements b.a
{
  private b ACb;
  private b.a ACc;
  
  public InputPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107849);
    this.ACb = new b(this, this);
    AppMethodBeat.o(107849);
  }
  
  public b getInputPanelHelper()
  {
    return this.ACb;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107850);
    this.ACb.QX(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(107850);
  }
  
  public void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(142774);
    if (this.ACc != null) {
      this.ACc.p(paramBoolean, paramInt);
    }
    AppMethodBeat.o(142774);
  }
  
  public void setExternalListener(b.a parama)
  {
    this.ACc = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InputPanelFrameLayout
 * JD-Core Version:    0.7.0.1
 */