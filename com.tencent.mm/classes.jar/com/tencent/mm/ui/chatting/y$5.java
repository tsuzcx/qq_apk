package com.tencent.mm.ui.chatting;

import android.widget.ListView;

final class y$5
  implements Runnable
{
  y$5(y paramy) {}
  
  public final void run()
  {
    if ((y.b(this.vmb)) || (y.c(this.vmb) != 0))
    {
      y.d(this.vmb);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[] { Boolean.valueOf(y.b(this.vmb)), Integer.valueOf(y.c(this.vmb)) });
      return;
    }
    int i = y.a(this.vmb).getLastVisiblePosition();
    int j = y.a(this.vmb).getCount() - 1;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[] { Integer.valueOf(y.e(this.vmb)), Integer.valueOf(i), Integer.valueOf(j) });
    if (i < j)
    {
      y.a(this.vmb, true);
      this.vmb.cDc();
      return;
    }
    y.d(this.vmb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y.5
 * JD-Core Version:    0.7.0.1
 */