package com.tencent.mm.ui.chatting;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.g;

final class y$7$1
  implements Runnable
{
  y$7$1(y.7 param7) {}
  
  public final void run()
  {
    this.vmd.vmb.cyV();
    if ((this.vmd.vmb.isCurrentActivity) || (!this.vmd.vmb.isSupportNavigationSwipeBack())) {
      this.vmd.vmb.cDd();
    }
    SwipeBackLayout localSwipeBackLayout;
    do
    {
      return;
      localSwipeBackLayout = this.vmd.vmb.getSwipeBackLayout();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.wlh), Boolean.valueOf(localSwipeBackLayout.wlf), Boolean.valueOf(localSwipeBackLayout.wlg) });
    } while (localSwipeBackLayout.cKa());
    g.aN(0.0F);
    localSwipeBackLayout.wlh = true;
    localSwipeBackLayout.wlg = false;
    int i = localSwipeBackLayout.QR.getWidth();
    int j = localSwipeBackLayout.wlc.getIntrinsicWidth();
    a locala = localSwipeBackLayout.wla;
    locala.MW = localSwipeBackLayout.QR;
    locala.fC = -1;
    locala.h(i + j + 10, 0, 0, 0);
    localSwipeBackLayout.invalidate();
    if (localSwipeBackLayout.wll != null) {
      localSwipeBackLayout.wll.onDrag();
    }
    g.C(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y.7.1
 * JD-Core Version:    0.7.0.1
 */