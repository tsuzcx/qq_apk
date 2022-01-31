package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.b;

final class h$5
  implements ValueAnimator.AnimatorUpdateListener
{
  h$5(h paramh, View paramView, b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(34357);
    float f = ((Float)paramValueAnimator.getAnimatedValue("ratio")).floatValue();
    this.Akn.setBackgroundColor(this.Ako.aE(f));
    AppMethodBeat.o(34357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.5
 * JD-Core Version:    0.7.0.1
 */