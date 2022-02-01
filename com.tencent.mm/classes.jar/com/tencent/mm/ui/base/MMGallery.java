package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMGallery
  extends Gallery
{
  public MMGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141958);
    setStaticTransformationsEnabled(true);
    AppMethodBeat.o(141958);
  }
  
  public MMGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141959);
    setStaticTransformationsEnabled(true);
    AppMethodBeat.o(141959);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(141960);
    if (paramFloat1 > 0.0F) {
      onKeyDown(21, null);
    }
    for (;;)
    {
      AppMethodBeat.o(141960);
      return true;
      onKeyDown(22, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGallery
 * JD-Core Version:    0.7.0.1
 */