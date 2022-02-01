package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import java.util.HashMap;

public class PluginNewTips
  extends f
  implements com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<String, a> udK;
  private com.tencent.mm.sdk.b.c<mo> udL;
  
  static
  {
    AppMethodBeat.i(184027);
    udK = new HashMap();
    AppMethodBeat.o(184027);
  }
  
  public PluginNewTips()
  {
    AppMethodBeat.i(184022);
    this.udL = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(184022);
  }
  
  public static void addLocalNewTipsCallback(String paramString, a parama)
  {
    AppMethodBeat.i(184025);
    udK.put(paramString, parama);
    AppMethodBeat.o(184025);
  }
  
  public static void removeLocalNewTipsCallback(String paramString)
  {
    AppMethodBeat.i(184026);
    udK.remove(paramString);
    AppMethodBeat.o(184026);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127208);
    if (paramg.agu()) {
      pin(a.cWr());
    }
    AppMethodBeat.o(127208);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(184023);
    this.udL.alive();
    AppMethodBeat.o(184023);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184024);
    this.udL.dead();
    AppMethodBeat.o(184024);
  }
  
  public static abstract interface a
  {
    public abstract void cWw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.PluginNewTips
 * JD-Core Version:    0.7.0.1
 */