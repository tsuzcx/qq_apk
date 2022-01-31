package com.tencent.mm.ui.chatting;

import android.widget.ListView;
import com.tencent.mm.ui.tools.m;

final class y$3
  implements Runnable
{
  y$3(y paramy, int paramInt) {}
  
  public final void run()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(this.ffJ) });
    m localm = new m(this.vmb.vlR);
    int i = this.ffJ;
    int j = y.a(this.vmb).getHeaderViewsCount() + i;
    localm.mQH.removeCallbacks(localm);
    localm.wee = System.currentTimeMillis();
    localm.wej = 0;
    i = localm.mQH.getFirstVisiblePosition();
    int k = localm.mQH.getChildCount() + i - 1;
    if (j <= i)
    {
      i = i - j + 1;
      localm.mMode = 2;
      if (i <= 0) {
        break label177;
      }
    }
    label177:
    for (localm.weh = (1000 / i);; localm.weh = 1000)
    {
      localm.wef = j;
      localm.weg = -1;
      localm.mQH.post(localm);
      do
      {
        return;
      } while (j < k);
      i = j - k + 1;
      localm.mMode = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y.3
 * JD-Core Version:    0.7.0.1
 */