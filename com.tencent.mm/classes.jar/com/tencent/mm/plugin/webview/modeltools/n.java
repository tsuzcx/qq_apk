package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
{
  private final LinkedList<String> JbE;
  
  public n()
  {
    AppMethodBeat.i(79225);
    this.JbE = new LinkedList();
    AppMethodBeat.o(79225);
  }
  
  private void aZz(String paramString)
  {
    AppMethodBeat.i(79227);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79227);
      return;
    }
    synchronized (this.JbE)
    {
      String str = (String)this.JbE.peekLast();
      paramString = URLEncoder.encode(paramString);
      if ((str == null) || (!str.equals(paramString))) {
        this.JbE.addLast(paramString);
      }
      if (this.JbE.size() > 10) {
        this.JbE.removeFirst();
      }
      AppMethodBeat.o(79227);
      return;
    }
  }
  
  public final void add(String paramString)
  {
    AppMethodBeat.i(79226);
    try
    {
      aZz(paramString);
      AppMethodBeat.o(79226);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(79226);
    }
  }
  
  public final String[] gdF()
  {
    AppMethodBeat.i(79228);
    synchronized (this.JbE)
    {
      String[] arrayOfString = new String[this.JbE.size()];
      Iterator localIterator = this.JbE.iterator();
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
  
  public final void gdG()
  {
    AppMethodBeat.i(79229);
    if (!CrashReportFactory.hasDebuger())
    {
      AppMethodBeat.o(79229);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.JbE)
    {
      Iterator localIterator = this.JbE.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    Log.d("MicroMsg.WebViewURLRouteList", localObject.toString());
    AppMethodBeat.o(79229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.n
 * JD-Core Version:    0.7.0.1
 */