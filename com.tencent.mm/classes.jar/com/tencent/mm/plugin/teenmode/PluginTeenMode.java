package com.tencent.mm.plugin.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginTeenMode
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private static com.tencent.mm.plugin.teenmode.b.d MrX;
  
  static
  {
    AppMethodBeat.i(259506);
    MrX = new com.tencent.mm.plugin.teenmode.b.d();
    AppMethodBeat.o(259506);
  }
  
  public void configure(g paramg) {}
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(259503);
    Log.d("PluginTeenMode", "execute");
    if (paramg.aIE())
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.teenmode.a.b.class, com.tencent.mm.plugin.teenmode.b.b.gkv());
      AppMethodBeat.o(259503);
      return;
    }
    if ((paramg.MY(":tools")) || (paramg.MY(":toolsmp")) || (paramg.MZ(":appbrand"))) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.teenmode.a.b.class, com.tencent.mm.plugin.teenmode.b.c.gkw());
    }
    AppMethodBeat.o(259503);
  }
  
  public void installed()
  {
    AppMethodBeat.i(259502);
    alias(a.class);
    AppMethodBeat.o(259502);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(259504);
    Log.d("PluginTeenMode", "onAccountInitialized");
    MrX.alive();
    AppMethodBeat.o(259504);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(259505);
    Log.v("PluginTeenMode", "onAccountRelease");
    MrX.dead();
    AppMethodBeat.o(259505);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public String toString()
  {
    return "plugin-teenmode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.PluginTeenMode
 * JD-Core Version:    0.7.0.1
 */