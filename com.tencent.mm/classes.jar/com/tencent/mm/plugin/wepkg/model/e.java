package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebResourceResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e
{
  private Map<String, g> BIB;
  private int nGv;
  
  public e()
  {
    AppMethodBeat.i(110678);
    this.BIB = new HashMap();
    this.nGv = 1;
    AppMethodBeat.o(110678);
  }
  
  public final void azU(String paramString)
  {
    AppMethodBeat.i(110679);
    if (this.nGv > 3)
    {
      ad.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
      AppMethodBeat.o(110679);
      return;
    }
    String str = d.aAg(paramString);
    if ((!bt.isNullOrNil(str)) && (this.BIB.get(str) == null))
    {
      this.nGv += 1;
      g localg = b.azy(str);
      if (localg != null)
      {
        this.BIB.put(str, localg);
        AppMethodBeat.o(110679);
        return;
      }
      localg = b.cj(paramString, true);
      if ((localg != null) && (localg.BIL != null))
      {
        this.BIB.put(str, localg);
        a.b("EnterWeb", paramString, localg.BIL.fUW, localg.BIL.version, 1L, 0L, null);
        ad.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", new Object[] { str });
      }
    }
    AppMethodBeat.o(110679);
  }
  
  public final WebResourceResponse azV(String paramString)
  {
    AppMethodBeat.i(110680);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110680);
      return null;
    }
    Iterator localIterator = this.BIB.values().iterator();
    while (localIterator.hasNext())
    {
      WebResourceResponse localWebResourceResponse = ((g)localIterator.next()).azV(paramString);
      if (localWebResourceResponse != null)
      {
        ad.i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", new Object[] { paramString });
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