package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.c;
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
  private Map<String, g> EEJ;
  private int oMS;
  
  public e()
  {
    AppMethodBeat.i(110678);
    this.EEJ = new HashMap();
    this.oMS = 1;
    AppMethodBeat.o(110678);
  }
  
  public final void aKL(String paramString)
  {
    AppMethodBeat.i(110679);
    if (this.oMS > 3)
    {
      ad.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
      AppMethodBeat.o(110679);
      return;
    }
    String str = d.aKY(paramString);
    if ((!bt.isNullOrNil(str)) && (this.EEJ.get(str) == null))
    {
      this.oMS += 1;
      g localg = c.aKp(str);
      if (localg != null)
      {
        this.EEJ.put(str, localg);
        AppMethodBeat.o(110679);
        return;
      }
      localg = c.cv(paramString, true);
      if ((localg != null) && (localg.EET != null))
      {
        this.EEJ.put(str, localg);
        a.b("EnterWeb", paramString, localg.EET.gsn, localg.EET.version, 1L, 0L, null);
        ad.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", new Object[] { str });
      }
    }
    AppMethodBeat.o(110679);
  }
  
  public final WebResourceResponse aKM(String paramString)
  {
    AppMethodBeat.i(110680);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110680);
      return null;
    }
    Iterator localIterator = this.EEJ.values().iterator();
    while (localIterator.hasNext())
    {
      WebResourceResponse localWebResourceResponse = ((g)localIterator.next()).aKM(paramString);
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