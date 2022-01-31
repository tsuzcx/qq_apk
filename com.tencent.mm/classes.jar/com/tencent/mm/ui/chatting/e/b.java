package com.tencent.mm.ui.chatting.e;

import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.b.b.p;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.x;

public final class b
  implements f<bi>
{
  private a byx;
  private MMChattingListView vxZ;
  public b.a vya;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.vxZ = paramMMChattingListView;
    this.byx = parama;
  }
  
  public final void a(d.d paramd)
  {
    if (!this.byx.euf) {
      y.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
    }
    do
    {
      return;
      y.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      if (this.byx.vtz.keyboardState() == 1)
      {
        y.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
        this.byx.cCW();
      }
      if (paramd.vyj != d.a.vyd)
      {
        MMChattingListView localMMChattingListView = this.vxZ;
        MMPullDownView.e((ViewGroup)localMMChattingListView.uXe, 4);
        MMPullDownView.e((ViewGroup)localMMChattingListView.uIY, 4);
      }
      ((p)this.byx.ac(p.class)).startTimer();
    } while (this.vya == null);
    this.vya.a(this.vxZ, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.b
 * JD-Core Version:    0.7.0.1
 */