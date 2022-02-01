package com.tencent.mm.plugin.mv.ui.shake;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends ViewOutlineProvider
{
  int radius = 0;
  
  public e(int paramInt)
  {
    this.radius = paramInt;
  }
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(287336);
    paramOutline.setRoundRect(new Rect(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight()), this.radius);
    AppMethodBeat.o(287336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.e
 * JD-Core Version:    0.7.0.1
 */