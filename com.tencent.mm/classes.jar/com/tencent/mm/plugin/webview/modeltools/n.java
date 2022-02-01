package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
{
  private final LinkedList<String> DWB;
  
  public n()
  {
    AppMethodBeat.i(79225);
    this.DWB = new LinkedList();
    AppMethodBeat.o(79225);
  }
  
  private void aIb(String paramString)
  {
    AppMethodBeat.i(79227);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79227);
      return;
    }
    synchronized (this.DWB)
    {
      String str = (String)this.DWB.peekLast();
      paramString = URLEncoder.encode(paramString);
      if ((str == null) || (!str.equals(paramString))) {
        this.DWB.addLast(paramString);
      }
      if (this.DWB.size() > 10) {
        this.DWB.removeFirst();
      }
      AppMethodBeat.o(79227);
      return;
    }
  }
  
  public final void Ej(String paramString)
  {
    AppMethodBeat.i(79226);
    try
    {
      aIb(paramString);
      AppMethodBeat.o(79226);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(79226);
    }
  }
  
  public final String[] eRe()
  {
    AppMethodBeat.i(79228);
    synchronized (this.DWB)
    {
      String[] arrayOfString = new String[this.DWB.size()];
      Iterator localIterator = this.DWB.iterator();
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
  
  public final void eRf()
  {
    AppMethodBeat.i(79229);
    if (!b.fjN())
    {
      AppMethodBeat.o(79229);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.DWB)
    {
      Iterator localIterator = this.DWB.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    ad.d("MicroMsg.WebViewURLRouteList", localObject.toString());
    AppMethodBeat.o(79229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.n
 * JD-Core Version:    0.7.0.1
 */