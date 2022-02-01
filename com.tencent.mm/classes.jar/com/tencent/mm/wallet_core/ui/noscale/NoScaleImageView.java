package com.tencent.mm.wallet_core.ui.noscale;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoScaleImageView
  extends AppCompatImageView
{
  public NoScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NoScaleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(214346);
    super.onFinishInflate();
    a.hL(this);
    AppMethodBeat.o(214346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.noscale.NoScaleImageView
 * JD-Core Version:    0.7.0.1
 */