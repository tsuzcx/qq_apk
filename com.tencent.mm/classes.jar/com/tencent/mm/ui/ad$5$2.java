package com.tencent.mm.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;

final class ad$5$2
  implements TestTimeForChatting.a
{
  ad$5$2(ad.5 param5) {}
  
  public final void cAb()
  {
    y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
    this.uQc.start = System.currentTimeMillis();
    if (this.uQc.uPW.uPR.getSwipeBackLayout() != null) {
      this.uQc.uPW.uPR.getSwipeBackLayout().startAnimation(this.uQc.uPW.mChattingInAnim);
    }
    for (;;)
    {
      this.uQc.uPW.uPK.setOndispatchDraw(null);
      return;
      this.uQc.uPW.uPR.getView().startAnimation(this.uQc.uPW.mChattingInAnim);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ad.5.2
 * JD-Core Version:    0.7.0.1
 */