package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputPanelLinearLayout
  extends LinearLayout
  implements c.a
{
  private c afSh;
  private c.a afSi;
  
  public InputPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143334);
    this.afSh = new c(this, this);
    AppMethodBeat.o(143334);
  }
  
  public c getInputPanelHelper()
  {
    return this.afSh;
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(182572);
    if (this.afSi != null) {
      this.afSi.onInputPanelChange(paramBoolean, paramInt);
    }
    AppMethodBeat.o(182572);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143335);
    this.afSh.aEm(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(143335);
  }
  
  public void setExternalListener(c.a parama)
  {
    this.afSi = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InputPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */