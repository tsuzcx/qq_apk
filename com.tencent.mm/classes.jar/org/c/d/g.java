package org.c.d;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.c.b.b;
import org.c.g.e;

public final class g
{
  public int code;
  private Map<String, String> headers;
  private String xuF;
  private InputStream xuG;
  
  g(HttpURLConnection paramHttpURLConnection)
  {
    for (;;)
    {
      try
      {
        paramHttpURLConnection.connect();
        this.code = paramHttpURLConnection.getResponseCode();
        this.headers = h(paramHttpURLConnection);
        if ((this.code >= 200) && (this.code < 400))
        {
          i = 1;
          if (i != 0)
          {
            paramHttpURLConnection = paramHttpURLConnection.getInputStream();
            this.xuG = paramHttpURLConnection;
            return;
          }
          paramHttpURLConnection = paramHttpURLConnection.getErrorStream();
          continue;
        }
        int i = 0;
      }
      catch (UnknownHostException paramHttpURLConnection)
      {
        throw new b("The IP address of a host could not be determined.", paramHttpURLConnection);
      }
    }
  }
  
  private static Map<String, String> h(HttpURLConnection paramHttpURLConnection)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHttpURLConnection.getHeaderFields().keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      String str = (String)localIterator.next();
      localHashMap.put(str, (String)((List)paramHttpURLConnection.getHeaderFields().get(str)).get(0));
    }
  }
  
  public final String getBody()
  {
    if (this.xuF != null) {
      return this.xuF;
    }
    this.xuF = e.K(this.xuG);
    return this.xuF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.c.d.g
 * JD-Core Version:    0.7.0.1
 */