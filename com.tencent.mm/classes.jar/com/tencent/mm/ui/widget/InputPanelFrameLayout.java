package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPanelFrameLayout
  extends FrameLayout
  implements b.a
{
  private b IZb;
  private b.a IZc;
  
  public InputPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143322);
    this.IZb = new b(this, this);
    AppMethodBeat.o(143322);
  }
  
  public void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(143323);
    if (this.IZc != null) {
      this.IZc.g(paramBoolean, paramInt);
    }
    AppMethodBeat.o(143323);
  }
  
  public b getInputPanelHelper()
  {
    return this.IZb;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143324);
    this.IZb.acB(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(143324);
  }
  
  public void setExternalListener(b.a parama)
  {
    this.IZc = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InputPanelFrameLayout
 * JD-Core Version:    0.7.0.1
 */