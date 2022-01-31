package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class go
  implements gn
{
  private final go.a a;
  private final SSLSocketFactory b;
  
  public go()
  {
    this(null);
  }
  
  public go(go.a parama)
  {
    this(parama, null);
  }
  
  public go(go.a parama, SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = parama;
    this.b = paramSSLSocketFactory;
  }
  
  private HttpURLConnection a(URL paramURL, gb<?> paramgb)
  {
    AppMethodBeat.i(148012);
    HttpURLConnection localHttpURLConnection = a(paramURL);
    int i = paramgb.p();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(paramURL.getProtocol())) && (this.b != null)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.b);
    }
    AppMethodBeat.o(148012);
    return localHttpURLConnection;
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, gb<?> paramgb)
  {
    AppMethodBeat.i(148013);
    switch (paramgb.a())
    {
    default: 
      paramHttpURLConnection = new IllegalStateException("Unknown method type.");
      AppMethodBeat.o(148013);
      throw paramHttpURLConnection;
    case -1: 
      byte[] arrayOfByte = paramgb.i();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.addRequestProperty("Content-Type", paramgb.h());
        paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
        paramHttpURLConnection.write(arrayOfByte);
        paramHttpURLConnection.close();
        AppMethodBeat.o(148013);
        return;
      }
      break;
    case 0: 
      paramHttpURLConnection.setRequestMethod("GET");
      AppMethodBeat.o(148013);
      return;
    case 3: 
      paramHttpURLConnection.setRequestMethod("DELETE");
      AppMethodBeat.o(148013);
      return;
    case 1: 
      paramHttpURLConnection.setRequestMethod("POST");
      b(paramHttpURLConnection, paramgb);
      AppMethodBeat.o(148013);
      return;
    case 2: 
      paramHttpURLConnection.setRequestMethod("PUT");
      b(paramHttpURLConnection, paramgb);
      AppMethodBeat.o(148013);
      return;
    case 4: 
      paramHttpURLConnection.setRequestMethod("HEAD");
      AppMethodBeat.o(148013);
      return;
    case 5: 
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      AppMethodBeat.o(148013);
      return;
    case 6: 
      paramHttpURLConnection.setRequestMethod("TRACE");
      AppMethodBeat.o(148013);
      return;
    case 7: 
      paramHttpURLConnection.setRequestMethod("PATCH");
      b(paramHttpURLConnection, paramgb);
      AppMethodBeat.o(148013);
      return;
    }
    AppMethodBeat.o(148013);
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, gb<?> paramgb)
  {
    AppMethodBeat.i(148014);
    byte[] arrayOfByte = paramgb.m();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", paramgb.l());
      paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      paramHttpURLConnection.write(arrayOfByte);
      paramHttpURLConnection.close();
    }
    AppMethodBeat.o(148014);
  }
  
  public HttpURLConnection a(gb<?> paramgb, Map<String, String> paramMap)
  {
    AppMethodBeat.i(148010);
    Object localObject = paramgb.c();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramgb.e());
    localHashMap.putAll(paramMap);
    String str;
    if (this.a != null)
    {
      str = this.a.a((String)localObject);
      paramMap = str;
      if (str == null)
      {
        paramgb = new IOException("URL blocked by rewriter: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(148010);
        throw paramgb;
      }
    }
    else
    {
      paramMap = (Map<String, String>)localObject;
    }
    paramMap = a(new URL(paramMap), paramgb);
    localObject = localHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      paramMap.addRequestProperty(str, (String)localHashMap.get(str));
    }
    a(paramMap, paramgb);
    AppMethodBeat.o(148010);
    return paramMap;
  }
  
  protected HttpURLConnection a(URL paramURL)
  {
    AppMethodBeat.i(148011);
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    AppMethodBeat.o(148011);
    return paramURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.go
 * JD-Core Version:    0.7.0.1
 */