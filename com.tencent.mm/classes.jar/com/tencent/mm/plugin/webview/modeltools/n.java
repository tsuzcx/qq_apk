package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
{
  private final LinkedList<String> EoA;
  
  public n()
  {
    AppMethodBeat.i(79225);
    this.EoA = new LinkedList();
    AppMethodBeat.o(79225);
  }
  
  private void aJu(String paramString)
  {
    AppMethodBeat.i(79227);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79227);
      return;
    }
    synchronized (this.EoA)
    {
      String str = (String)this.EoA.peekLast();
      paramString = URLEncoder.encode(paramString);
      if ((str == null) || (!str.equals(paramString))) {
        this.EoA.addLast(paramString);
      }
      if (this.EoA.size() > 10) {
        this.EoA.removeFirst();
      }
      AppMethodBeat.o(79227);
      return;
    }
  }
  
  public final void EL(String paramString)
  {
    AppMethodBeat.i(79226);
    try
    {
      aJu(paramString);
      AppMethodBeat.o(79226);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(79226);
    }
  }
  
  public final String[] eUQ()
  {
    AppMethodBeat.i(79228);
    synchronized (this.EoA)
    {
      String[] arrayOfString = new String[this.EoA.size()];
      Iterator localIterator = this.EoA.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        arrayOfString[i] = ((String)localIterator.next());
        i += 1;
      }
      AppMethodBeat.o(79228);
      return arrayOfString;
    }
  }
  
  public final void eUR()
  {
    AppMethodBeat.i(79229);
    if (!b.fnF())
    {
      AppMethodBeat.o(79229);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.EoA)
    {
      Iterator localIterator = this.EoA.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    ae.d("MicroMsg.WebViewURLRouteList", localObject.toString());
    AppMethodBeat.o(79229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.n
 * JD-Core Version:    0.7.0.1
 */