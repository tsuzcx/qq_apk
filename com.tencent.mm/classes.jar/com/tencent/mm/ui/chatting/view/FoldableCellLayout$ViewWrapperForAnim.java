package com.tencent.mm.ui.chatting.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/view/FoldableCellLayout$ViewWrapperForAnim;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "setScaleX", "", "scaleX", "", "setWidthForAnim", "width", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FoldableCellLayout$ViewWrapperForAnim
{
  private final View nmf;
  
  public FoldableCellLayout$ViewWrapperForAnim(View paramView)
  {
    AppMethodBeat.i(254281);
    this.nmf = paramView;
    AppMethodBeat.o(254281);
  }
  
  public final void setScaleX(float paramFloat)
  {
    AppMethodBeat.i(254284);
    this.nmf.setScaleX(paramFloat);
    AppMethodBeat.o(254284);
  }
  
  public final void setWidthForAnim(int paramInt)
  {
    AppMethodBeat.i(254283);
    View localView = this.nmf;
    localView.getLayoutParams().width = paramInt;
    localView.requestLayout();
    AppMethodBeat.o(254283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.FoldableCellLayout.ViewWrapperForAnim
 * JD-Core Version:    0.7.0.1
 */