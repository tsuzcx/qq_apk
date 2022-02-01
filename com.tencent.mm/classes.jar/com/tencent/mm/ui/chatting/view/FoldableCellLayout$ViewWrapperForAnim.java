package com.tencent.mm.ui.chatting.view;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/view/FoldableCellLayout$ViewWrapperForAnim;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "setScaleX", "", "scaleX", "", "setWidthForAnim", "width", "", "app_release"})
public final class FoldableCellLayout$ViewWrapperForAnim
{
  private final View kJL;
  
  public FoldableCellLayout$ViewWrapperForAnim(View paramView)
  {
    AppMethodBeat.i(288003);
    this.kJL = paramView;
    AppMethodBeat.o(288003);
  }
  
  @Keep
  public final void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(288002);
    this.kJL.setScaleX(paramFloat);
    AppMethodBeat.o(288002);
  }
  
  @Keep
  public final void setWidthForAnim(int paramInt)
  {
    AppMethodBeat.i(288001);
    View localView = this.kJL;
    localView.getLayoutParams().width = paramInt;
    localView.requestLayout();
    AppMethodBeat.o(288001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.FoldableCellLayout.ViewWrapperForAnim
 * JD-Core Version:    0.7.0.1
 */