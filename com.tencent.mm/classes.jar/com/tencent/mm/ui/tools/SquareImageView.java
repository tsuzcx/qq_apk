package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SquareImageView
  extends ImageView
{
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35000);
    paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    setMeasuredDimension(paramInt1, paramInt1);
    AppMethodBeat.o(35000);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(35001);
    super.onSizeChanged(paramInt1, paramInt1, paramInt3, paramInt4);
    AppMethodBeat.o(35001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.SquareImageView
 * JD-Core Version:    0.7.0.1
 */