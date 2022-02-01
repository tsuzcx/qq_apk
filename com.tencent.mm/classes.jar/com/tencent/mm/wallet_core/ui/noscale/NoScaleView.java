package com.tencent.mm.wallet_core.ui.noscale;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoScaleView
  extends View
{
  public NoScaleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NoScaleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(242202);
    super.onFinishInflate();
    a.mK(this);
    AppMethodBeat.o(242202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.noscale.NoScaleView
 * JD-Core Version:    0.7.0.1
 */