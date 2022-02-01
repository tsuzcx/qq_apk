package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import java.util.HashMap;

public class PluginNewTips
  extends f
  implements com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<String, a> wsb;
  private com.tencent.mm.sdk.b.c<nf> wsc;
  
  static
  {
    AppMethodBeat.i(184027);
    wsb = new HashMap();
    AppMethodBeat.o(184027);
  }
  
  public PluginNewTips()
  {
    AppMethodBeat.i(184022);
    this.wsc = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(184022);
  }
  
  public static void addLocalNewTipsCallback(String paramString, a parama)
  {
    AppMethodBeat.i(184025);
    wsb.put(paramString, parama);
    AppMethodBeat.o(184025);
  }
  
  public static void removeLocalNewTipsCallback(String paramString)
  {
    AppMethodBeat.i(184026);
    wsb.remove(paramString);
    AppMethodBeat.o(184026);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127208);
    if (paramg.akw()) {
      pin(a.dul());
    }
    AppMethodBeat.o(127208);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(184023);
    this.wsc.alive();
    AppMethodBeat.o(184023);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184024);
    this.wsc.dead();
    AppMethodBeat.o(184024);
  }
  
  public static abstract interface a
  {
    public abstract void dur();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.PluginNewTips
 * JD-Core Version:    0.7.0.1
 */