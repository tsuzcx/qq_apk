package com.unionpay.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.utils.b;
import com.unionpay.utils.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;

public final class c
{
  private HttpURLConnection aisN = null;
  private InputStream aisO = null;
  private d aisP = null;
  private Context aisQ;
  private byte[] b = null;
  public String c = null;
  
  public c(d paramd, Context paramContext)
  {
    this.aisP = paramd;
    this.aisQ = paramContext;
  }
  
  public final int a()
  {
    AppMethodBeat.i(207352);
    j.kkB();
    if (this.aisP == null)
    {
      j.b("uppay", "params==null!!!");
      AppMethodBeat.o(207352);
      return 1;
    }
    try
    {
      localObject1 = this.aisP.kkA();
      if (!"https".equals(((URL)localObject1).getProtocol().toLowerCase())) {
        break label219;
      }
      localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection();
      localObject2 = new a(this.aisQ);
      if (((a)localObject2).aisK == null) {
        ((a)localObject2).aisK = a.pl(((a)localObject2).b);
      }
      localObject2 = ((a)localObject2).aisK;
      ((HttpsURLConnection)localObject1).setSSLSocketFactory(((SSLContext)localObject2).getSocketFactory());
    }
    catch (SSLHandshakeException localSSLHandshakeException)
    {
      Object localObject1;
      Object localObject2;
      Iterator localIterator;
      i = 4;
      for (;;)
      {
        j.kkB();
        AppMethodBeat.o(207352);
        return i;
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)localSSLHandshakeException.openConnection();
        break;
        localObject2 = this.aisP.b();
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        case 70454: 
        case 2461856: 
          for (;;)
          {
            localHttpURLConnection.connect();
            if (localHttpURLConnection.getResponseCode() != 200) {
              break label388;
            }
            this.aisO = localHttpURLConnection.getInputStream();
            if (this.aisO == null) {
              break label429;
            }
            this.c = b.a(this.aisO, "UTF-8");
            i = 0;
            break;
            if (!((String)localObject2).equals("GET")) {
              break label446;
            }
            i = 0;
            break label446;
            if (!((String)localObject2).equals("POST")) {
              break label446;
            }
            i = 1;
            break label446;
            localHttpURLConnection.setDoOutput(true);
            localObject2 = new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8");
            ((OutputStreamWriter)localObject2).write(this.aisP.e);
            ((OutputStreamWriter)localObject2).flush();
            ((OutputStreamWriter)localObject2).close();
          }
          if (localHttpURLConnection.getResponseCode() == 401)
          {
            i = 8;
          }
          else
          {
            j.b("uppay", "http status code:" + localHttpURLConnection.getResponseCode());
            i = 1;
          }
          break;
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        i = 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = 1;
        continue;
        switch (i)
        {
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
    ((HttpURLConnection)localObject1).setRequestMethod(this.aisP.b());
    ((HttpURLConnection)localObject1).setReadTimeout(60000);
    ((HttpURLConnection)localObject1).setConnectTimeout(30000);
    ((HttpURLConnection)localObject1).setInstanceFollowRedirects(true);
    ((HttpURLConnection)localObject1).setUseCaches(false);
    localObject2 = this.aisP.c;
    if (localObject2 != null)
    {
      localIterator = ((HashMap)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((HttpURLConnection)localObject1).setRequestProperty(str, (String)((HashMap)localObject2).get(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.a.c
 * JD-Core Version:    0.7.0.1
 */