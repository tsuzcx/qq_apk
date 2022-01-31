package com.tencent.mm.plugin.sns.model;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$c
  implements MessageQueue.IdleHandler
{
  b$c(b paramb) {}
  
  public final boolean queueIdle()
  {
    y.d("MicroMsg.DownloadManager", "I run idleHandler ");
    b.a(this.ooN, bk.UX());
    return b.a(this.ooN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.c
 * JD-Core Version:    0.7.0.1
 */