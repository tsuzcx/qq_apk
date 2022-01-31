package com.tencent.mm.ui.conversation;

import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;

final class BaseConversationUI$7
  implements Runnable
{
  BaseConversationUI$7(BaseConversationUI paramBaseConversationUI, int[] paramArrayOfInt, HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(34056);
    this.AgT.getSupportActionBar().getCustomView().getLocationInWindow(this.zek);
    int i = this.zek[1];
    if (i > 0)
    {
      BaseConversationUI.access$1300(this.AgT, this.zel, i, new Rect(0, i, 0, 0), this.zem);
      AppMethodBeat.o(34056);
      return;
    }
    if (d.fv(20)) {
      this.zel.setOnApplyWindowInsetsListener(new BaseConversationUI.7.1(this));
    }
    AppMethodBeat.o(34056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.7
 * JD-Core Version:    0.7.0.1
 */