package com.tencent.mm.plugin.music.model.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class MMMusicPlayerService$1
  implements Runnable
{
  MMMusicPlayerService$1(MMMusicPlayerService paramMMMusicPlayerService) {}
  
  public final void run()
  {
    AppMethodBeat.i(104991);
    ab.i("MicroMsg.Music.MMMusicPlayerService", "quit");
    al.ae(MMMusicPlayerService.a(this.pab));
    this.pab.stopSelf();
    AppMethodBeat.o(104991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService.1
 * JD-Core Version:    0.7.0.1
 */