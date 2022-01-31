package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.Proxy;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class dv$a
  extends dv
{
  private Context a;
  
  public dv$a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static dt a(String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    if (paramString1 == null)
    {
      cy.d("no destUrl!", new Object[0]);
      return null;
    }
    HttpClient localHttpClient;
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
        localHttpClient = a(paramString2, paramInt);
        if (localHttpClient == null)
        {
          cy.d("no httpClient!", new Object[0]);
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = null;
      }
    }
    for (;;)
    {
      cy.a(paramString1);
      cy.d("execute error:%s", new Object[] { paramString1.toString() });
      if (paramArrayOfByte != null) {
        paramArrayOfByte.abort();
      }
      throw new Exception(paramString1.toString());
      paramArrayOfByte = new ByteArrayEntity("".getBytes());
      break;
      paramString2 = new HttpPost(paramString1);
      try
      {
        paramString2.setHeader("wup_version", "3.0");
        paramString2.setHeader("TYPE_COMPRESS", "2");
        paramString2.setHeader("encr_type", "rsapost");
        paramString1 = cm.a();
        if (paramString1 != null) {
          paramString2.setHeader("bea_key", paramString1.j());
        }
        paramString2.setEntity(paramArrayOfByte);
        paramString1 = new BasicHttpContext();
        paramArrayOfByte = localHttpClient.execute(paramString2, paramString1);
        cy.h("execute request:\n %s", new Object[] { ((HttpRequest)paramString1.getAttribute("http.request")).getRequestLine().toString() });
        paramString1 = new dt(paramArrayOfByte, paramString2);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        paramArrayOfByte = paramString2;
      }
    }
  }
  
  private static HttpClient a(String paramString, int paramInt)
  {
    try
    {
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
      HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 2000);
      localBasicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
      HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
      localDefaultHttpClient.setHttpRequestRetryHandler(new dv.a.1());
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).contains("wap")) && (paramInt != 2))
      {
        cy.a("use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
        paramString = new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", paramString);
        return localDefaultHttpClient;
      }
      if (paramString != null) {
        cy.a("Don't use proxy: %s, try time: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
      }
      localDefaultHttpClient.getParams().removeParameter("http.route.default-proxy");
      return localDefaultHttpClient;
    }
    catch (Throwable paramString)
    {
      cy.a(paramString);
      cy.d("httpclient error!", new Object[0]);
    }
    return null;
  }
  
  /* Error */
  private byte[] a(HttpResponse paramHttpResponse, HttpPost paramHttpPost)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: ifnonnull +10 -> 14
    //   7: aload 6
    //   9: astore 4
    //   11: aload 4
    //   13: areturn
    //   14: aload_1
    //   15: invokeinterface 235 1 0
    //   20: invokeinterface 240 1 0
    //   25: istore_3
    //   26: iload_3
    //   27: sipush 200
    //   30: if_icmpeq +30 -> 60
    //   33: ldc 242
    //   35: iconst_2
    //   36: anewarray 21	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: iload_3
    //   42: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_1
    //   49: invokeinterface 235 1 0
    //   54: aastore
    //   55: invokestatic 245	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aconst_null
    //   59: areturn
    //   60: aload_1
    //   61: ldc 247
    //   63: invokeinterface 250 2 0
    //   68: ifeq +58 -> 126
    //   71: aload_1
    //   72: ldc 252
    //   74: invokeinterface 250 2 0
    //   79: ifeq +47 -> 126
    //   82: aload_1
    //   83: ldc 247
    //   85: invokeinterface 256 2 0
    //   90: invokeinterface 261 1 0
    //   95: astore 4
    //   97: aload_1
    //   98: ldc 252
    //   100: invokeinterface 256 2 0
    //   105: invokeinterface 261 1 0
    //   110: astore 5
    //   112: invokestatic 86	com/tencent/tencentmap/mapsdk/a/cm:a	()Lcom/tencent/tencentmap/mapsdk/a/cm;
    //   115: aload_0
    //   116: getfield 13	com/tencent/tencentmap/mapsdk/a/dv$a:a	Landroid/content/Context;
    //   119: aload 4
    //   121: aload 5
    //   123: invokevirtual 264	com/tencent/tencentmap/mapsdk/a/cm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: invokeinterface 268 1 0
    //   132: astore_1
    //   133: aload_1
    //   134: ifnonnull +15 -> 149
    //   137: ldc_w 270
    //   140: iconst_0
    //   141: anewarray 21	java/lang/Object
    //   144: invokestatic 27	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aconst_null
    //   148: areturn
    //   149: new 272	java/io/BufferedInputStream
    //   152: dup
    //   153: new 274	java/io/DataInputStream
    //   156: dup
    //   157: aload_1
    //   158: invokeinterface 280 1 0
    //   163: invokespecial 283	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   166: invokespecial 284	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   169: astore 4
    //   171: aload 4
    //   173: astore_1
    //   174: new 286	java/io/ByteArrayOutputStream
    //   177: dup
    //   178: sipush 128
    //   181: invokespecial 289	java/io/ByteArrayOutputStream:<init>	(I)V
    //   184: astore 5
    //   186: aload 4
    //   188: astore_1
    //   189: aload 4
    //   191: invokevirtual 292	java/io/BufferedInputStream:read	()I
    //   194: istore_3
    //   195: iload_3
    //   196: iconst_m1
    //   197: if_icmpeq +70 -> 267
    //   200: aload 4
    //   202: astore_1
    //   203: aload 5
    //   205: iload_3
    //   206: invokevirtual 295	java/io/ByteArrayOutputStream:write	(I)V
    //   209: goto -23 -> 186
    //   212: astore 5
    //   214: aload 4
    //   216: astore_1
    //   217: aload 5
    //   219: invokestatic 40	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   222: aload 4
    //   224: astore_1
    //   225: ldc_w 297
    //   228: iconst_1
    //   229: anewarray 21	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload 5
    //   236: invokevirtual 46	java/lang/Throwable:toString	()Ljava/lang/String;
    //   239: aastore
    //   240: invokestatic 27	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: aload 4
    //   245: ifnull +8 -> 253
    //   248: aload 4
    //   250: invokevirtual 300	java/io/BufferedInputStream:close	()V
    //   253: aload 6
    //   255: astore 4
    //   257: aload_2
    //   258: ifnull -247 -> 11
    //   261: aload_2
    //   262: invokevirtual 51	org/apache/http/client/methods/HttpPost:abort	()V
    //   265: aconst_null
    //   266: areturn
    //   267: aload 4
    //   269: astore_1
    //   270: aload 5
    //   272: invokevirtual 303	java/io/ByteArrayOutputStream:flush	()V
    //   275: aload 4
    //   277: astore_1
    //   278: aload 5
    //   280: invokevirtual 306	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   283: astore 5
    //   285: aload 5
    //   287: astore_1
    //   288: aload 4
    //   290: invokevirtual 300	java/io/BufferedInputStream:close	()V
    //   293: aload_1
    //   294: astore 4
    //   296: aload_2
    //   297: ifnull -286 -> 11
    //   300: aload_2
    //   301: invokevirtual 51	org/apache/http/client/methods/HttpPost:abort	()V
    //   304: aload_1
    //   305: areturn
    //   306: astore 4
    //   308: aload 4
    //   310: invokestatic 40	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   313: goto -20 -> 293
    //   316: astore_1
    //   317: aload_1
    //   318: invokestatic 40	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   321: goto -68 -> 253
    //   324: astore 4
    //   326: aconst_null
    //   327: astore_1
    //   328: aload_1
    //   329: ifnull +7 -> 336
    //   332: aload_1
    //   333: invokevirtual 300	java/io/BufferedInputStream:close	()V
    //   336: aload_2
    //   337: ifnull +7 -> 344
    //   340: aload_2
    //   341: invokevirtual 51	org/apache/http/client/methods/HttpPost:abort	()V
    //   344: aload 4
    //   346: athrow
    //   347: astore_1
    //   348: aload_1
    //   349: invokestatic 40	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   352: goto -16 -> 336
    //   355: astore 4
    //   357: goto -29 -> 328
    //   360: astore 5
    //   362: aconst_null
    //   363: astore 4
    //   365: goto -151 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	a
    //   0	368	1	paramHttpResponse	HttpResponse
    //   0	368	2	paramHttpPost	HttpPost
    //   25	181	3	i	int
    //   9	286	4	localObject1	Object
    //   306	3	4	localThrowable1	Throwable
    //   324	21	4	localObject2	Object
    //   355	1	4	localObject3	Object
    //   363	1	4	localObject4	Object
    //   110	94	5	localObject5	Object
    //   212	67	5	localThrowable2	Throwable
    //   283	3	5	arrayOfByte	byte[]
    //   360	1	5	localThrowable3	Throwable
    //   1	253	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   174	186	212	java/lang/Throwable
    //   189	195	212	java/lang/Throwable
    //   203	209	212	java/lang/Throwable
    //   270	275	212	java/lang/Throwable
    //   278	285	212	java/lang/Throwable
    //   288	293	306	java/lang/Throwable
    //   248	253	316	java/lang/Throwable
    //   149	171	324	finally
    //   332	336	347	java/lang/Throwable
    //   174	186	355	finally
    //   189	195	355	finally
    //   203	209	355	finally
    //   217	222	355	finally
    //   225	243	355	finally
    //   270	275	355	finally
    //   278	285	355	finally
    //   149	171	360	java/lang/Throwable
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfByte, ds paramds)
  {
    if (paramString == null)
    {
      cy.d("no destUrl!", new Object[0]);
      return null;
    }
    Object localObject3 = null;
    int k = 0;
    if (paramArrayOfByte == null) {}
    Object localObject4;
    Object localObject1;
    int j;
    int i;
    int m;
    for (long l1 = 0L;; l1 = paramArrayOfByte.length)
    {
      cy.h("start req: %s sz:%d", new Object[] { paramString, Long.valueOf(l1) });
      localObject4 = "";
      localObject1 = "";
      j = 0;
      i = 0;
      m = k + 1;
      if ((k >= 3) || (i >= 2)) {
        break label702;
      }
      if (j == 0) {
        break;
      }
      throw new Exception("net redirect");
    }
    if (m > 1)
    {
      cy.h("try time:" + m, new Object[0]);
      if ((m == 2) && (paramds.c() == 2)) {
        paramds.b(false);
      }
    }
    int n;
    try
    {
      Thread.sleep(5000L);
      Object localObject5 = e.n(this.a);
      new Date().getTime();
      try
      {
        localObject5 = a(paramString, paramArrayOfByte, (String)localObject5, m);
        localObject3 = localObject5;
        localObject5 = localObject4;
        localObject4 = localObject1;
      }
      catch (Exception localException2)
      {
        HttpEntity localHttpEntity;
        long l2;
        localObject6 = localException2.toString();
        if (!((String)localObject1).equals(localObject6)) {
          break label447;
        }
        for (localObject1 = (String)localObject4 + m + ":same ";; localObject1 = (String)localObject4 + m + ":" + (String)localObject6 + " ")
        {
          localObject4 = localObject6;
          localObject6 = localObject1;
          break;
        }
      }
      new Date().getTime();
      if (localObject3 == null) {
        break label716;
      }
      localObject1 = localObject3.a;
      localHttpEntity = ((HttpResponse)localObject1).getEntity();
      l1 = 0L;
      if (localHttpEntity != null)
      {
        l2 = localHttpEntity.getContentLength();
        l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
      }
      n = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
      cy.h("response code:%d ", new Object[] { Integer.valueOf(n) });
      cy.h("contentLength:%d ", new Object[] { Long.valueOf(l1) });
      if (n != 200) {
        break label501;
      }
      if (((HttpResponse)localObject1).containsHeader("encrypt-status"))
      {
        cy.d("svr encry failed: " + ((HttpResponse)localObject1).getFirstHeader("encrypt-status").getValue(), new Object[0]);
        return null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        cy.a(localInterruptedException);
      }
    }
    Object localObject6;
    label447:
    return a((HttpResponse)localObject1, localObject3.b);
    label501:
    if ((n == 301) || (n == 302) || (n == 303) || (n == 307))
    {
      k = 1;
      if (k == 0) {
        break label716;
      }
      j = 1;
      paramString = ((HttpResponse)localObject1).getFirstHeader("Location");
      if (paramString != null) {
        break label614;
      }
      cy.d("redirect code:" + n + " Location is null! return", new Object[0]);
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          if (localObject3.b != null) {
            localObject3.b.abort();
          }
          return null;
          k = 0;
          break;
          label614:
          i += 1;
          m = 0;
          k = 0;
          paramString = paramString.getValue();
          cy.h("redirect code:%d , to:%s", new Object[] { Integer.valueOf(n), paramString });
          try
          {
            if (localObject3.b != null) {
              localObject3.b.abort();
            }
            j = 1;
            localObject1 = localObject4;
            localObject4 = localObject6;
          }
          catch (Exception localException1)
          {
            k = m;
          }
        }
        Object localObject2 = localObject4;
        localObject4 = localObject6;
        break;
        label702:
        throw new Exception((String)localObject4);
      }
      catch (Exception paramString)
      {
        continue;
      }
      label716:
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dv.a
 * JD-Core Version:    0.7.0.1
 */