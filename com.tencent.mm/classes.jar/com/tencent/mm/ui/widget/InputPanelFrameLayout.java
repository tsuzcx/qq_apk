package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPanelFrameLayout
  extends FrameLayout
  implements b.a
{
  private b LmF;
  private b.a LmG;
  
  public InputPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143322);
    this.LmF = new b(this, this);
    AppMethodBeat.o(143322);
  }
  
  public void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(143323);
    if (this.LmG != null) {
      this.LmG.g(paramBoolean, paramInt);
    }
    AppMethodBeat.o(143323);
  }
  
  public b getInputPanelHelper()
  {
    return this.LmF;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143324);
    this.LmF.afH(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(143324);
  }
  
  public void setExternalListener(b.a parama)
  {
    this.LmG = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InputPanelFrameLayout
 * JD-Core Version:    0.7.0.1
 */