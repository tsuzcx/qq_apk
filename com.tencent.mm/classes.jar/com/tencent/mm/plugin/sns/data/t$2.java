package com.tencent.mm.plugin.sns.data;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$2
  extends ViewOutlineProvider
{
  t$2(Float paramFloat) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(306408);
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.Qoy.floatValue());
    AppMethodBeat.o(306408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.t.2
 * JD-Core Version:    0.7.0.1
 */