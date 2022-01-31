package com.tencent.mm.ui.chatting.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMChattingListView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  MMChattingListView$2(MMChattingListView paramMMChattingListView, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(32762);
    this.zQX.getGlobalVisibleRect(MMChattingListView.a(this.zQW));
    MMChattingListView.a(this.zQW).top = this.zQX.getTop();
    MMChattingListView.a(this.zQW).bottom = this.zQX.getBottom();
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    MMChattingListView.c(this.zQW).setAlpha((int)(f * 255.0F));
    MMChattingListView.b(this.zQW).postInvalidate();
    AppMethodBeat.o(32762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView.2
 * JD-Core Version:    0.7.0.1
 */