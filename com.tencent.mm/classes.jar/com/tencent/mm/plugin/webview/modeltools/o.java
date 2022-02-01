package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class o
{
  private final LinkedList<String> WOK;
  
  public o()
  {
    AppMethodBeat.i(79225);
    this.WOK = new LinkedList();
    AppMethodBeat.o(79225);
  }
  
  private void bkZ(String paramString)
  {
    AppMethodBeat.i(79227);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79227);
      return;
    }
    synchronized (this.WOK)
    {
      String str = (String)this.WOK.peekLast();
      paramString = URLEncoder.encode(paramString);
      if ((str == null) || (!str.equals(paramString))) {
        this.WOK.addLast(paramString);
      }
      if (this.WOK.size() > 10) {
        this.WOK.removeFirst();
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
      bkZ(paramString);
      AppMethodBeat.o(79226);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(79226);
    }
  }
  
  public final String[] iwj()
  {
    AppMethodBeat.i(79228);
    synchronized (this.WOK)
    {
      String[] arrayOfString = new String[this.WOK.size()];
      Iterator localIterator = this.WOK.iterator();
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
  
  public final void iwk()
  {
    AppMethodBeat.i(79229);
    if (!CrashReportFactory.hasDebuger())
    {
      AppMethodBeat.o(79229);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.WOK)
    {
      Iterator localIterator = this.WOK.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    Log.d("MicroMsg.WebViewURLRouteList", localObject.toString());
    AppMethodBeat.o(79229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.o
 * JD-Core Version:    0.7.0.1
 */