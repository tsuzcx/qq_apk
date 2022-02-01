package com.tencent.mm.plugin.newtips;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qg;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;

public class PluginNewTips
  extends com.tencent.mm.kernel.b.f
  implements c
{
  private static HashMap<String, a> MrX;
  private IListener<qg> MrY;
  
  static
  {
    AppMethodBeat.i(184027);
    MrX = new HashMap();
    AppMethodBeat.o(184027);
  }
  
  public PluginNewTips()
  {
    AppMethodBeat.i(184022);
    this.MrY = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(184022);
  }
  
  public static void addLocalNewTipsCallback(String paramString, a parama)
  {
    AppMethodBeat.i(184025);
    MrX.put(paramString, parama);
    AppMethodBeat.o(184025);
  }
  
  public static void removeLocalNewTipsCallback(String paramString)
  {
    AppMethodBeat.i(184026);
    MrX.remove(paramString);
    AppMethodBeat.o(184026);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127208);
    if (paramg.bbA()) {
      pin(a.gtd());
    }
    AppMethodBeat.o(127208);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(184023);
    this.MrY.alive();
    AppMethodBeat.o(184023);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184024);
    this.MrY.dead();
    AppMethodBeat.o(184024);
  }
  
  public static abstract interface a
  {
    public abstract void gtj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.PluginNewTips
 * JD-Core Version:    0.7.0.1
 */