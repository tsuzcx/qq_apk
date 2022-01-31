package com.tencent.mm.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;

final class NewChattingTabUI$6$2
  implements TestTimeForChatting.a
{
  NewChattingTabUI$6$2(NewChattingTabUI.6 param6) {}
  
  public final void dDc()
  {
    AppMethodBeat.i(29801);
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
    this.zeo.start = System.currentTimeMillis();
    if (NewChattingTabUI.c(this.zeo.zei).getSwipeBackLayout() != null)
    {
      NewChattingTabUI.c(this.zeo.zei).getSwipeBackLayout().setNeedChangeWindowBackground(false);
      NewChattingTabUI.c(this.zeo.zei).getSwipeBackLayout().startAnimation(NewChattingTabUI.t(this.zeo.zei));
    }
    for (;;)
    {
      NewChattingTabUI.d(this.zeo.zei).setOndispatchDraw(null);
      AppMethodBeat.o(29801);
      return;
      NewChattingTabUI.c(this.zeo.zei).getView().startAnimation(NewChattingTabUI.t(this.zeo.zei));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.6.2
 * JD-Core Version:    0.7.0.1
 */