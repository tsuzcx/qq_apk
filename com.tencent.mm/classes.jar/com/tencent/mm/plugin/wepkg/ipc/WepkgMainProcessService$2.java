package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WepkgMainProcessService$2
  extends a.a
{
  WepkgMainProcessService$2(WepkgMainProcessService paramWepkgMainProcessService) {}
  
  public final void C(Bundle paramBundle)
  {
    AppMethodBeat.i(63482);
    WepkgMainProcessService.aB(paramBundle).ata();
    AppMethodBeat.o(63482);
  }
  
  public final void s(Message paramMessage)
  {
    AppMethodBeat.i(63481);
    WepkgMainProcessService.a(this.vFL).send(paramMessage);
    AppMethodBeat.o(63481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService.2
 * JD-Core Version:    0.7.0.1
 */