package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class l
{
  private final LinkedList<String> riS = new LinkedList();
  
  public final String[] ccS()
  {
    synchronized (this.riS)
    {
      String[] arrayOfString = new String[this.riS.size()];
      Iterator localIterator = this.riS.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        arrayOfString[i] = ((String)localIterator.next());
        i += 1;
      }
      return arrayOfString;
    }
  }
  
  public final void ccT()
  {
    if (!b.cqk()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("routeList: ");
    synchronized (this.riS)
    {
      Iterator localIterator = this.riS.iterator();
      if (localIterator.hasNext()) {
        localStringBuilder.append(URLDecoder.decode((String)localIterator.next())).append("\n");
      }
    }
    y.d("MicroMsg.WebViewURLRouteList", localObject.toString());
  }
  
  public final void qh(String paramString)
  {
    try
    {
      if (!bk.bl(paramString)) {
        synchronized (this.riS)
        {
          String str = (String)this.riS.peekLast();
          paramString = URLEncoder.encode(paramString);
          if ((str == null) || (!str.equals(paramString))) {
            this.riS.addLast(paramString);
          }
          if (this.riS.size() > 10) {
            this.riS.removeFirst();
          }
          return;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[] { bk.j(paramString) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */