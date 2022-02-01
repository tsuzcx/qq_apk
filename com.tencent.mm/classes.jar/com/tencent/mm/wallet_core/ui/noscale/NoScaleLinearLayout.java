package com.tencent.mm.wallet_core.ui.noscale;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoScaleLinearLayout
  extends LinearLayout
{
  public NoScaleLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NoScaleLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(214347);
    super.onFinishInflate();
    a.hL(this);
    AppMethodBeat.o(214347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.noscale.NoScaleLinearLayout
 * JD-Core Version:    0.7.0.1
 */