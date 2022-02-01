package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a$a
  extends Animation
{
  final int FUG;
  final int targetHeight;
  View view;
  
  public b$a$a(b.a parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(63214);
    this.view = paramView;
    this.targetHeight = paramInt;
    this.FUG = paramView.getHeight();
    AppMethodBeat.o(63214);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(63215);
    int i = (int)(this.FUG + (this.targetHeight - this.FUG) * paramFloat);
    this.view.getLayoutParams().height = i;
    this.view.requestLayout();
    AppMethodBeat.o(63215);
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(63216);
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(63216);
  }
  
  public final boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b.a.a
 * JD-Core Version:    0.7.0.1
 */