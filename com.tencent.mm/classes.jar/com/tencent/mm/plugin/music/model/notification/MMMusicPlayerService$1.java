package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class MMMusicPlayerService$1
  implements Runnable
{
  MMMusicPlayerService$1(MMMusicPlayerService paramMMMusicPlayerService) {}
  
  public final void run()
  {
    y.i("MicroMsg.Music.MMMusicPlayerService", "quit");
    ai.S(MMMusicPlayerService.a(this.mzV));
    this.mzV.stopSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService.1
 * JD-Core Version:    0.7.0.1
 */