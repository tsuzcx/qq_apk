package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.Music.MMMusicNotification", "close");
    ai.S(this.mzP.mzN);
    this.mzP.mzL.stopForeground(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a.1
 * JD-Core Version:    0.7.0.1
 */