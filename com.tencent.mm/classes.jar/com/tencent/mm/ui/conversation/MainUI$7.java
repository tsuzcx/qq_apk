package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class MainUI$7
  implements MMSlideDelView.c
{
  MainUI$7(MainUI paramMainUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(154007);
    int i = MainUI.a(this.Alw).getPositionForView(paramView);
    AppMethodBeat.o(154007);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.7
 * JD-Core Version:    0.7.0.1
 */