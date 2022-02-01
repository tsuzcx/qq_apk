package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebResourceResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e
{
  private Map<String, g> DaK;
  private int ojw;
  
  public e()
  {
    AppMethodBeat.i(110678);
    this.DaK = new HashMap();
    this.ojw = 1;
    AppMethodBeat.o(110678);
  }
  
  public final void aFm(String paramString)
  {
    AppMethodBeat.i(110679);
    if (this.ojw > 3)
    {
      ac.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
      AppMethodBeat.o(110679);
      return;
    }
    String str = d.aFy(paramString);
    if ((!bs.isNullOrNil(str)) && (this.DaK.get(str) == null))
    {
      this.ojw += 1;
      g localg = b.aEP(str);
      if (localg != null)
      {
        this.DaK.put(str, localg);
        AppMethodBeat.o(110679);
        return;
      }
      localg = b.cp(paramString, true);
      if ((localg != null) && (localg.DaU != null))
      {
        this.DaK.put(str, localg);
        a.b("EnterWeb", paramString, localg.DaU.fYR, localg.DaU.version, 1L, 0L, null);
        ac.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", new Object[] { str });
      }
    }
    AppMethodBeat.o(110679);
  }
  
  public final WebResourceResponse aFn(String paramString)
  {
    AppMethodBeat.i(110680);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110680);
      return null;
    }
    Iterator localIterator = this.DaK.values().iterator();
    while (localIterator.hasNext())
    {
      WebResourceResponse localWebResourceResponse = ((g)localIterator.next()).aFn(paramString);
      if (localWebResourceResponse != null)
      {
        ac.i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", new Object[] { paramString });
        AppMethodBeat.o(110680);
        return localWebResourceResponse;
      }
    }
    AppMethodBeat.o(110680);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e
 * JD-Core Version:    0.7.0.1
 */