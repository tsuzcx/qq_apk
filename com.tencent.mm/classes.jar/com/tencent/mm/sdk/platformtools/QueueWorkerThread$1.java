package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class QueueWorkerThread$1
  extends MMHandler
{
  QueueWorkerThread$1(QueueWorkerThread paramQueueWorkerThread, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(157792);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((QueueWorkerThread.ThreadObject)paramMessage.obj).onPostExecute();
    }
    AppMethodBeat.o(157792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread.1
 * JD-Core Version:    0.7.0.1
 */