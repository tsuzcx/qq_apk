package com.tencent.mm.ui.widget;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/ui/widget/MMCollapsibleTextView$measureTruncate$2$1"})
final class MMCollapsibleTextView$h
  implements Runnable
{
  MMCollapsibleTextView$h(View paramView, MMCollapsibleTextView paramMMCollapsibleTextView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(140952);
    Rect localRect = new Rect();
    int i = (int)(this.Ybd * 1.5F);
    MMCollapsibleTextView.a(this.Ybc).getHitRect(localRect);
    localRect.top -= i;
    localRect.left -= i;
    localRect.bottom += i;
    localRect.right = (i + localRect.right);
    this.xkv.setTouchDelegate(new TouchDelegate(localRect, (View)MMCollapsibleTextView.a(this.Ybc)));
    AppMethodBeat.o(140952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMCollapsibleTextView.h
 * JD-Core Version:    0.7.0.1
 */