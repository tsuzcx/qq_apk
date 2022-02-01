package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import java.util.HashMap;

public class PluginNewTips
  extends f
  implements com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<String, a> wHK;
  private com.tencent.mm.sdk.b.c<ng> wHL;
  
  static
  {
    AppMethodBeat.i(184027);
    wHK = new HashMap();
    AppMethodBeat.o(184027);
  }
  
  public PluginNewTips()
  {
    AppMethodBeat.i(184022);
    this.wHL = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(184022);
  }
  
  public static void addLocalNewTipsCallback(String paramString, a parama)
  {
    AppMethodBeat.i(184025);
    wHK.put(paramString, parama);
    AppMethodBeat.o(184025);
  }
  
  public static void removeLocalNewTipsCallback(String paramString)
  {
    AppMethodBeat.i(184026);
    wHK.remove(paramString);
    AppMethodBeat.o(184026);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127208);
    if (paramg.akL()) {
      pin(a.dxB());
    }
    AppMethodBeat.o(127208);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(184023);
    this.wHL.alive();
    AppMethodBeat.o(184023);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184024);
    this.wHL.dead();
    AppMethodBeat.o(184024);
  }
  
  public static abstract interface a
  {
    public abstract void dxH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.PluginNewTips
 * JD-Core Version:    0.7.0.1
 */