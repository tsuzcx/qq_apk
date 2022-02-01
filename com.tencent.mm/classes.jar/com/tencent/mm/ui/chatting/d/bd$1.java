package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

final class bd$1
  implements MStorage.IOnStorageChange
{
  bd$1(bd parambd) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(35650);
    Log.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(paramString)));
    if (!Util.isNullOrNil(paramString)) {
      bd.a(this.PuF);
    }
    AppMethodBeat.o(35650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bd.1
 * JD-Core Version:    0.7.0.1
 */