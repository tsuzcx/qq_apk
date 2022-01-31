package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class SightDraftContainerView$1
  implements View.OnTouchListener
{
  SightDraftContainerView$1(SightDraftContainerView paramSightDraftContainerView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.ogW;
    if (paramView.ogV != null)
    {
      paramView = paramView.ogV;
      paramView.a(null);
      paramView.ogy.bBw();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView.1
 * JD-Core Version:    0.7.0.1
 */