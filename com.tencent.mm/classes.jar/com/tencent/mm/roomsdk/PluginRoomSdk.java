package com.tencent.mm.roomsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginRoomSdk
  extends f
  implements c
{
  public void configure(g paramg) {}
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(152753);
    Log.i("MicroMsg.PluginRoomSdk", "onAccountInitialized");
    AppMethodBeat.o(152753);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(152754);
    Log.i("MicroMsg.PluginRoomSdk", "onAccountRelease");
    AppMethodBeat.o(152754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.roomsdk.PluginRoomSdk
 * JD-Core Version:    0.7.0.1
 */