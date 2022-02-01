package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;

public class PluginNewTips
  extends f
  implements c
{
  private static HashMap<String, a> ACU;
  private IListener<ny> ACV;
  
  static
  {
    AppMethodBeat.i(184027);
    ACU = new HashMap();
    AppMethodBeat.o(184027);
  }
  
  public PluginNewTips()
  {
    AppMethodBeat.i(184022);
    this.ACV = new IListener() {};
    AppMethodBeat.o(184022);
  }
  
  public static void addLocalNewTipsCallback(String paramString, a parama)
  {
    AppMethodBeat.i(184025);
    ACU.put(paramString, parama);
    AppMethodBeat.o(184025);
  }
  
  public static void removeLocalNewTipsCallback(String paramString)
  {
    AppMethodBeat.i(184026);
    ACU.remove(paramString);
    AppMethodBeat.o(184026);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127208);
    if (paramg.aBb()) {
      pin(a.exj());
    }
    AppMethodBeat.o(127208);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(184023);
    this.ACV.alive();
    AppMethodBeat.o(184023);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184024);
    this.ACV.dead();
    AppMethodBeat.o(184024);
  }
  
  public static abstract interface a
  {
    public abstract void exp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.PluginNewTips
 * JD-Core Version:    0.7.0.1
 */