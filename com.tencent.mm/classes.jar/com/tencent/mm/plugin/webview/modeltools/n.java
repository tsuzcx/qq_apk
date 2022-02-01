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
  private final LinkedList<String> BaJ;
  
  public n()
  {
    AppMethodBeat.i(79225);
    this.BaJ = new LinkedList();
    AppMethodBeat.o(79225);
  }
  
  private void axh(String paramString)
  {
    AppMethodBeat.i(79227);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79227);
      return;
    }
    synchronized (this.BaJ)
    {
      String str = (String)this.BaJ.peekLast();
      paramString = URLEncoder.encode(paramString);
      if ((str == null) || (!str.equals(paramString))) {
        this.BaJ.addLast(paramString);
      }
      if (this.BaJ.size() > 10) {
        this.BaJ.removeFirst();
      }
      AppMethodBeat.o(79227);
      return;
    }
  }
  
  public final String[] emP()
  {
    AppMethodBeat.i(79228);
    synchronized (this.BaJ)
    {
      String[] arrayOfString = new String[this.BaJ.size()];
      Iterator localIterator = this.BaJ.iterator();
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
  
  public final void emQ()
  {
    AppMethodBeat.i(79229);
    if (!b.eEQ())
    {
      AppMethodBeat.o(79229);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.BaJ)
    {
      Iterator localIterator = this.BaJ.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    ad.d("MicroMsg.WebViewURLRouteList", localObject.toString());
    AppMethodBeat.o(79229);
  }
  
  public final void xe(String paramString)
  {
    AppMethodBeat.i(79226);
    try
    {
      axh(paramString);
      AppMethodBeat.o(79226);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(79226);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.n
 * JD-Core Version:    0.7.0.1
 */