package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
{
  private final LinkedList<String> uYA;
  
  public n()
  {
    AppMethodBeat.i(7036);
    this.uYA = new LinkedList();
    AppMethodBeat.o(7036);
  }
  
  private void ahD(String paramString)
  {
    AppMethodBeat.i(7038);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7038);
      return;
    }
    synchronized (this.uYA)
    {
      String str = (String)this.uYA.peekLast();
      paramString = URLEncoder.encode(paramString);
      if ((str == null) || (!str.equals(paramString))) {
        this.uYA.addLast(paramString);
      }
      if (this.uYA.size() > 10) {
        this.uYA.removeFirst();
      }
      AppMethodBeat.o(7038);
      return;
    }
  }
  
  public final String[] dcN()
  {
    AppMethodBeat.i(7039);
    synchronized (this.uYA)
    {
      String[] arrayOfString = new String[this.uYA.size()];
      Iterator localIterator = this.uYA.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        arrayOfString[i] = ((String)localIterator.next());
        i += 1;
      }
      AppMethodBeat.o(7039);
      return arrayOfString;
    }
  }
  
  public final void dcO()
  {
    AppMethodBeat.i(7040);
    if (!b.dsf())
    {
      AppMethodBeat.o(7040);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.uYA)
    {
      Iterator localIterator = this.uYA.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    ab.d("MicroMsg.WebViewURLRouteList", localObject.toString());
    AppMethodBeat.o(7040);
  }
  
  public final void xB(String paramString)
  {
    AppMethodBeat.i(7037);
    try
    {
      ahD(paramString);
      AppMethodBeat.o(7037);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(7037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.n
 * JD-Core Version:    0.7.0.1
 */