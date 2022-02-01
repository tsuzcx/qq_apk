package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
{
  private final LinkedList<String> CsW;
  
  public n()
  {
    AppMethodBeat.i(79225);
    this.CsW = new LinkedList();
    AppMethodBeat.o(79225);
  }
  
  private void aCz(String paramString)
  {
    AppMethodBeat.i(79227);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79227);
      return;
    }
    synchronized (this.CsW)
    {
      String str = (String)this.CsW.peekLast();
      paramString = URLEncoder.encode(paramString);
      if ((str == null) || (!str.equals(paramString))) {
        this.CsW.addLast(paramString);
      }
      if (this.CsW.size() > 10) {
        this.CsW.removeFirst();
      }
      AppMethodBeat.o(79227);
      return;
    }
  }
  
  public final void Bk(String paramString)
  {
    AppMethodBeat.i(79226);
    try
    {
      aCz(paramString);
      AppMethodBeat.o(79226);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(79226);
    }
  }
  
  public final String[] eCk()
  {
    AppMethodBeat.i(79228);
    synchronized (this.CsW)
    {
      String[] arrayOfString = new String[this.CsW.size()];
      Iterator localIterator = this.CsW.iterator();
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
  
  public final void eCl()
  {
    AppMethodBeat.i(79229);
    if (!b.eUk())
    {
      AppMethodBeat.o(79229);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.CsW)
    {
      Iterator localIterator = this.CsW.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    ac.d("MicroMsg.WebViewURLRouteList", localObject.toString());
    AppMethodBeat.o(79229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.n
 * JD-Core Version:    0.7.0.1
 */