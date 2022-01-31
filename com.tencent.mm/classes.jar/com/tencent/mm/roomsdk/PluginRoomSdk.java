package com.tencent.mm.roomsdk;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.y;

public class PluginRoomSdk
  extends f
  implements c
{
  public void configure(g paramg) {}
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.PluginRoomSdk", "onAccountInitialized");
  }
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.PluginRoomSdk", "onAccountRelease");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.roomsdk.PluginRoomSdk
 * JD-Core Version:    0.7.0.1
 */