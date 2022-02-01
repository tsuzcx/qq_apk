package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.WebResourceResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e
{
  private Map<String, g> EXf;
  private int oTu;
  
  public e()
  {
    AppMethodBeat.i(110678);
    this.EXf = new HashMap();
    this.oTu = 1;
    AppMethodBeat.o(110678);
  }
  
  public final void aMh(String paramString)
  {
    AppMethodBeat.i(110679);
    if (this.oTu > 3)
    {
      ae.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
      AppMethodBeat.o(110679);
      return;
    }
    String str = d.aMu(paramString);
    if ((!bu.isNullOrNil(str)) && (this.EXf.get(str) == null))
    {
      this.oTu += 1;
      g localg = c.aLL(str);
      if (localg != null)
      {
        this.EXf.put(str, localg);
        AppMethodBeat.o(110679);
        return;
      }
      localg = c.cz(paramString, true);
      if ((localg != null) && (localg.EXp != null))
      {
        this.EXf.put(str, localg);
        a.b("EnterWeb", paramString, localg.EXp.guO, localg.EXp.version, 1L, 0L, null);
        ae.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", new Object[] { str });
      }
    }
    AppMethodBeat.o(110679);
  }
  
  public final WebResourceResponse aMi(String paramString)
  {
    AppMethodBeat.i(110680);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110680);
      return null;
    }
    Iterator localIterator = this.EXf.values().iterator();
    while (localIterator.hasNext())
    {
      WebResourceResponse localWebResourceResponse = ((g)localIterator.next()).aMi(paramString);
      if (localWebResourceResponse != null)
      {
        ae.i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", new Object[] { paramString });
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