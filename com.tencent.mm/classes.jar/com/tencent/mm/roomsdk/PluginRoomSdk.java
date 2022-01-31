package com.tencent.mm.roomsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginRoomSdk
  extends f
  implements c
{
  public void configure(g paramg) {}
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(80236);
    ab.i("MicroMsg.PluginRoomSdk", "onAccountInitialized");
    AppMethodBeat.o(80236);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(80237);
    ab.i("MicroMsg.PluginRoomSdk", "onAccountRelease");
    AppMethodBeat.o(80237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.roomsdk.PluginRoomSdk
 * JD-Core Version:    0.7.0.1
 */