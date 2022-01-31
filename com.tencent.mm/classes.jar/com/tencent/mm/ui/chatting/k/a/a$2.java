package com.tencent.mm.ui.chatting.k.a;

import android.widget.ListView;
import org.xwalk.core.Log;

final class a$2
  implements Runnable
{
  a$2(a parama, int paramInt) {}
  
  public final void run()
  {
    if ((this.vzS.byx.getFirstVisiblePosition() > this.ffJ) || (this.ffJ > this.vzS.byx.getLastVisiblePosition()))
    {
      Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + this.ffJ + " reTryCount:" + this.vzS.vzQ);
      this.vzS.byx.fx(this.ffJ, 0);
      a locala = this.vzS;
      locala.vzQ -= 1;
      if (this.vzS.vzQ >= 0) {
        this.vzS.byx.getListView().postDelayed(this, 20L);
      }
      return;
    }
    Log.i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + this.ffJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a.2
 * JD-Core Version:    0.7.0.1
 */