package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPanelLinearLayout
  extends LinearLayout
  implements b.a
{
  private b QBN;
  private b.a QBO;
  
  public InputPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143334);
    this.QBN = new b(this, this);
    AppMethodBeat.o(143334);
  }
  
  public void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(182572);
    if (this.QBO != null) {
      this.QBO.f(paramBoolean, paramInt);
    }
    AppMethodBeat.o(182572);
  }
  
  public b getInputPanelHelper()
  {
    return this.QBN;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143335);
    this.QBN.aou(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(143335);
  }
  
  public void setExternalListener(b.a parama)
  {
    this.QBO = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InputPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */