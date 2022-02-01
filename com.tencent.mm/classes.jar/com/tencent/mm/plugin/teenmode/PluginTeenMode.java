package com.tencent.mm.plugin.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

public class PluginTeenMode
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private static com.tencent.mm.plugin.teenmode.b.d FWi;
  
  static
  {
    AppMethodBeat.i(187359);
    FWi = new com.tencent.mm.plugin.teenmode.b.d();
    AppMethodBeat.o(187359);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(187356);
    Log.d("PluginTeenMode", "execute");
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.teenmode.a.b.class, com.tencent.mm.plugin.teenmode.b.b.fvs());
    }
    if (paramg.FZ(":appbrand")) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.teenmode.a.b.class, com.tencent.mm.plugin.teenmode.b.c.fvt());
    }
    AppMethodBeat.o(187356);
  }
  
  public void installed()
  {
    AppMethodBeat.i(187355);
    alias(a.class);
    AppMethodBeat.o(187355);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(187357);
    Log.d("PluginTeenMode", "onAccountInitialized");
    FWi.alive();
    AppMethodBeat.o(187357);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(187358);
    Log.v("PluginTeenMode", "onAccountRelease");
    FWi.dead();
    AppMethodBeat.o(187358);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2) {}
  
  public String toString()
  {
    return "plugin-teenmode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.PluginTeenMode
 * JD-Core Version:    0.7.0.1
 */