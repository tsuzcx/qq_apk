package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class OnLayoutChangedLinearLayout
  extends DrawnCallBackLinearLayout
{
  public a JqD;
  
  public OnLayoutChangedLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public OnLayoutChangedLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142450);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.JqD != null) {
      this.JqD.fxA();
    }
    AppMethodBeat.o(142450);
  }
  
  public void setOnChattingLayoutChangedListener(a parama)
  {
    this.JqD = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fxA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.OnLayoutChangedLinearLayout
 * JD-Core Version:    0.7.0.1
 */