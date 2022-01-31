package com.tencent.mm.ui.chatting;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.p;

final class ChattingUIFragment$7
  implements Runnable
{
  ChattingUIFragment$7(ChattingUIFragment paramChattingUIFragment, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(30837);
    ab.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(this.gxr) });
    p localp = new p(this.zBB.zBr);
    int i = this.gxr;
    int j = ChattingUIFragment.b(this.zBB).getHeaderViewsCount() + i;
    localp.xx.removeCallbacks(localp);
    localp.AwU = System.currentTimeMillis();
    localp.AwZ = 0;
    i = localp.xx.getFirstVisiblePosition();
    int k = localp.xx.getChildCount() + i - 1;
    if (j <= i)
    {
      i = i - j + 1;
      localp.mMode = 2;
      if (i <= 0) {
        break label196;
      }
    }
    label196:
    for (localp.AwX = (1000 / i);; localp.AwX = 1000)
    {
      localp.AwV = j;
      localp.AwW = -1;
      localp.xx.post(localp);
      AppMethodBeat.o(30837);
      return;
      if (j >= k)
      {
        i = j - k + 1;
        localp.mMode = 1;
        break;
      }
      AppMethodBeat.o(30837);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.7
 * JD-Core Version:    0.7.0.1
 */