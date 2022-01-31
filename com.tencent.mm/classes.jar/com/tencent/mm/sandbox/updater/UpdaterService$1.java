package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class UpdaterService$1
  implements ap.a
{
  UpdaterService$1(UpdaterService paramUpdaterService) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(28984);
    if (!UpdaterService.a(this.ylW))
    {
      AppMethodBeat.o(28984);
      return true;
    }
    AppMethodBeat.o(28984);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService.1
 * JD-Core Version:    0.7.0.1
 */