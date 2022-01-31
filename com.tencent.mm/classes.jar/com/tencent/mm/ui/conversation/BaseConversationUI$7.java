package com.tencent.mm.ui.conversation;

import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;

final class BaseConversationUI$7
  implements Runnable
{
  BaseConversationUI$7(BaseConversationUI paramBaseConversationUI, int[] paramArrayOfInt, HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    this.vPi.getSupportActionBar().getCustomView().getLocationInWindow(this.uPY);
    int i = this.uPY[1];
    if (i > 0) {
      BaseConversationUI.access$1300(this.vPi, this.uPZ, i, new Rect(0, i, 0, 0), this.uQa);
    }
    while (!d.gF(20)) {
      return;
    }
    this.uPZ.setOnApplyWindowInsetsListener(new BaseConversationUI.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.7
 * JD-Core Version:    0.7.0.1
 */