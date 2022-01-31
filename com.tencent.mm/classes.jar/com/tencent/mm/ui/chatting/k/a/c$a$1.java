package com.tencent.mm.ui.chatting.k.a;

import android.widget.ListView;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;

final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    MMChattingListView localMMChattingListView = (MMChattingListView)this.vAc.vzY.get();
    if (localMMChattingListView != null)
    {
      localMMChattingListView.getListView().setTranscriptMode(1);
      localMMChattingListView.setIsTopShowAll(this.vAa);
      localMMChattingListView.setIsBottomShowAll(this.vAb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */