package com.tencent.mm.ui.chatting;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.h;

final class ChattingUIFragment$12
  implements Runnable
{
  ChattingUIFragment$12(ChattingUIFragment paramChattingUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(30842);
    this.zBB.onExitBegin();
    if ((this.zBB.isCurrentActivity) || (!this.zBB.isSupportNavigationSwipeBack()))
    {
      this.zBB.dGQ();
      AppMethodBeat.o(30842);
      return;
    }
    SwipeBackLayout localSwipeBackLayout = this.zBB.getSwipeBackLayout();
    ab.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.AEZ), Boolean.valueOf(localSwipeBackLayout.AEX), Boolean.valueOf(localSwipeBackLayout.AEY) });
    if (!localSwipeBackLayout.dOU())
    {
      h.by(0.0F);
      localSwipeBackLayout.AEZ = true;
      localSwipeBackLayout.AEY = false;
      int i = localSwipeBackLayout.Qz.getWidth();
      int j = localSwipeBackLayout.AEU.getIntrinsicWidth();
      a locala = localSwipeBackLayout.AES;
      locala.MM = localSwipeBackLayout.Qz;
      locala.mActivePointerId = -1;
      locala.b(i + j + 10, 0, 0, 0, 320L);
      localSwipeBackLayout.invalidate();
      if (localSwipeBackLayout.AFf != null) {
        localSwipeBackLayout.AFf.onDrag();
      }
      h.K(true, 0);
    }
    AppMethodBeat.o(30842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.12
 * JD-Core Version:    0.7.0.1
 */