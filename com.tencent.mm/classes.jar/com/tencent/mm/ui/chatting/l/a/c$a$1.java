package com.tencent.mm.ui.chatting.l.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;

final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(32722);
    MMChattingListView localMMChattingListView = (MMChattingListView)this.zQz.zQv.get();
    if (localMMChattingListView != null)
    {
      localMMChattingListView.getListView().setTranscriptMode(1);
      localMMChattingListView.setIsTopShowAll(this.zQx);
      localMMChattingListView.setIsBottomShowAll(this.zQy);
    }
    AppMethodBeat.o(32722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */