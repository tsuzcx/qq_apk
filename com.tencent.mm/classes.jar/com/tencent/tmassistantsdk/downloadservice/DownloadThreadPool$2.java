package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

class DownloadThreadPool$2
  implements Runnable
{
  DownloadThreadPool$2(DownloadThreadPool paramDownloadThreadPool, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(75759);
    synchronized (this.this$0.mTaskLock)
    {
      Iterator localIterator = this.this$0.mExecList.iterator();
      DownloadTask localDownloadTask;
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getTaskId() == this.val$taskId)
        {
          localDownloadTask.cancel();
          this.this$0.mExecList.remove(localDownloadTask);
          AppMethodBeat.o(75759);
          return;
        }
      }
      localIterator = this.this$0.mWaitingList.iterator();
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getTaskId() == this.val$taskId)
        {
          localDownloadTask.cancel();
          this.this$0.mWaitingList.remove(localDownloadTask);
          AppMethodBeat.o(75759);
          return;
        }
      }
      AppMethodBeat.o(75759);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.2
 * JD-Core Version:    0.7.0.1
 */