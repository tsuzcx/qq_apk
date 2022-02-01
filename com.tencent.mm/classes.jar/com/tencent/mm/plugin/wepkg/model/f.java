package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f
{
  private Map<String, h> XFO;
  private int wHj;
  
  public f()
  {
    AppMethodBeat.i(110678);
    this.XFO = new HashMap();
    this.wHj = 1;
    AppMethodBeat.o(110678);
  }
  
  public final void boo(String paramString)
  {
    AppMethodBeat.i(110679);
    if (this.wHj > 3)
    {
      Log.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
      AppMethodBeat.o(110679);
      return;
    }
    String str = d.boB(paramString);
    if ((!Util.isNullOrNil(str)) && (this.XFO.get(str) == null))
    {
      this.wHj += 1;
      h localh = e.bnQ(str);
      if (localh != null)
      {
        this.XFO.put(str, localh);
        AppMethodBeat.o(110679);
        return;
      }
      localh = e.dS(paramString, true);
      if ((localh != null) && (localh.XFY != null))
      {
        this.XFO.put(str, localh);
        a.b("EnterWeb", paramString, localh.XFY.mtT, localh.XFY.version, 1L, 0L, null);
        Log.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", new Object[] { str });
      }
    }
    AppMethodBeat.o(110679);
  }
  
  public final WebResourceResponse bop(String paramString)
  {
    AppMethodBeat.i(110680);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110680);
      return null;
    }
    Iterator localIterator = this.XFO.values().iterator();
    while (localIterator.hasNext())
    {
      WebResourceResponse localWebResourceResponse = ((h)localIterator.next()).bop(paramString);
      if (localWebResourceResponse != null)
      {
        Log.i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", new Object[] { paramString });
        AppMethodBeat.o(110680);
        return localWebResourceResponse;
      }
    }
    AppMethodBeat.o(110680);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f
 * JD-Core Version:    0.7.0.1
 */