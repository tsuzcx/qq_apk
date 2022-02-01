package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f
{
  private Map<String, h> JMX;
  private int qhk;
  
  public f()
  {
    AppMethodBeat.i(110678);
    this.JMX = new HashMap();
    this.qhk = 1;
    AppMethodBeat.o(110678);
  }
  
  public final void bcA(String paramString)
  {
    AppMethodBeat.i(110679);
    if (this.qhk > 3)
    {
      Log.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
      AppMethodBeat.o(110679);
      return;
    }
    String str = com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString);
    if ((!Util.isNullOrNil(str)) && (this.JMX.get(str) == null))
    {
      this.qhk += 1;
      h localh = com.tencent.mm.plugin.wepkg.d.bcc(str);
      if (localh != null)
      {
        this.JMX.put(str, localh);
        AppMethodBeat.o(110679);
        return;
      }
      localh = com.tencent.mm.plugin.wepkg.d.cU(paramString, true);
      if ((localh != null) && (localh.JNh != null))
      {
        this.JMX.put(str, localh);
        a.b("EnterWeb", paramString, localh.JNh.hhD, localh.JNh.version, 1L, 0L, null);
        Log.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", new Object[] { str });
      }
    }
    AppMethodBeat.o(110679);
  }
  
  public final WebResourceResponse bcB(String paramString)
  {
    AppMethodBeat.i(110680);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110680);
      return null;
    }
    Iterator localIterator = this.JMX.values().iterator();
    while (localIterator.hasNext())
    {
      WebResourceResponse localWebResourceResponse = ((h)localIterator.next()).bcB(paramString);
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