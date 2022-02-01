package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

final class l$2
  implements MStorage.IOnStorageChange
{
  l$2(l paraml) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(37832);
    Log.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
    if (!l.b(this.afdX).stopped()) {
      l.b(this.afdX).stopTimer();
    }
    paramString = l.b(this.afdX);
    if (l.c(this.afdX)) {}
    for (long l = 500L;; l = 1000L)
    {
      paramString.startTimer(l);
      AppMethodBeat.o(37832);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l.2
 * JD-Core Version:    0.7.0.1
 */