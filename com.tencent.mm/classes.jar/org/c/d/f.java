package org.c.d;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.c.b.b;

class f
{
  private HttpURLConnection aRG;
  private String charset;
  private Map<String, String> headers;
  private String tmf = null;
  private String url;
  private e xuA;
  private byte[] xuB = null;
  private boolean xuC = false;
  private Long xuD = null;
  private Long xuE = null;
  private j xuy;
  private e xuz;
  
  public f(j paramj, String paramString)
  {
    this.xuy = paramj;
    this.url = paramString;
    this.xuz = new e();
    this.xuA = new e();
    this.headers = new HashMap();
  }
  
  private byte[] cVc()
  {
    if (this.xuB != null) {
      return this.xuB;
    }
    if (this.tmf != null) {}
    for (Object localObject = this.tmf;; localObject = this.xuA.cVb()) {
      try
      {
        localObject = ((String)localObject).getBytes(cUX());
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new b("Unsupported Charset: " + cUX(), localUnsupportedEncodingException);
      }
    }
  }
  
  private void g(HttpURLConnection paramHttpURLConnection)
  {
    Iterator localIterator = this.headers.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      paramHttpURLConnection.setRequestProperty(str, (String)this.headers.get(str));
    }
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
  }
  
  public e cUU()
  {
    try
    {
      e locale = new e();
      locale.ahA(new URL(this.url).getQuery());
      locale.a(this.xuz);
      return locale;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new b("Malformed URL", localMalformedURLException);
    }
  }
  
  public j cUV()
  {
    return this.xuy;
  }
  
  public String cUW()
  {
    Object localObject2 = this.xuz;
    Object localObject1 = this.url;
    org.c.g.d.l(localObject1, "Cannot append to null URL");
    localObject2 = ((e)localObject2).cVb();
    if (((String)localObject2).equals("")) {
      return localObject1;
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1));
    if (((String)localObject1).indexOf('?') != -1) {}
    for (localObject1 = "&";; localObject1 = Character.valueOf('?')) {
      return localStringBuilder.append(localObject1).toString() + (String)localObject2;
    }
  }
  
  public String cUX()
  {
    if (this.charset == null) {
      return Charset.defaultCharset().name();
    }
    return this.charset;
  }
  
  /* Error */
  public g cUY()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 203	org/c/d/f:cUW	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   9: ifnonnull +38 -> 47
    //   12: aload_0
    //   13: getfield 36	org/c/d/f:xuC	Z
    //   16: ifeq +187 -> 203
    //   19: ldc 207
    //   21: astore_1
    //   22: ldc 209
    //   24: aload_1
    //   25: invokestatic 215	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: pop
    //   29: aload_0
    //   30: new 138	java/net/URL
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 139	java/net/URL:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 219	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   41: checkcast 123	java/net/HttpURLConnection
    //   44: putfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   47: aload_0
    //   48: getfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   51: aload_0
    //   52: getfield 42	org/c/d/f:xuy	Lorg/c/d/j;
    //   55: invokevirtual 222	org/c/d/j:name	()Ljava/lang/String;
    //   58: invokevirtual 225	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield 38	org/c/d/f:xuD	Ljava/lang/Long;
    //   65: ifnull +17 -> 82
    //   68: aload_0
    //   69: getfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   72: aload_0
    //   73: getfield 38	org/c/d/f:xuD	Ljava/lang/Long;
    //   76: invokevirtual 231	java/lang/Long:intValue	()I
    //   79: invokevirtual 235	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   82: aload_0
    //   83: getfield 40	org/c/d/f:xuE	Ljava/lang/Long;
    //   86: ifnull +17 -> 103
    //   89: aload_0
    //   90: getfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   93: aload_0
    //   94: getfield 40	org/c/d/f:xuE	Ljava/lang/Long;
    //   97: invokevirtual 231	java/lang/Long:intValue	()I
    //   100: invokevirtual 238	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   108: invokespecial 240	org/c/d/f:g	(Ljava/net/HttpURLConnection;)V
    //   111: aload_0
    //   112: getfield 42	org/c/d/f:xuy	Lorg/c/d/j;
    //   115: getstatic 243	org/c/d/j:xuN	Lorg/c/d/j;
    //   118: invokevirtual 244	org/c/d/j:equals	(Ljava/lang/Object;)Z
    //   121: ifne +16 -> 137
    //   124: aload_0
    //   125: getfield 42	org/c/d/f:xuy	Lorg/c/d/j;
    //   128: getstatic 247	org/c/d/j:xuM	Lorg/c/d/j;
    //   131: invokevirtual 244	org/c/d/j:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +57 -> 191
    //   137: aload_0
    //   138: getfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   141: astore_1
    //   142: aload_0
    //   143: invokespecial 249	org/c/d/f:cVc	()[B
    //   146: astore_2
    //   147: aload_1
    //   148: ldc 251
    //   150: aload_2
    //   151: arraylength
    //   152: invokestatic 254	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   155: invokevirtual 127	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_1
    //   159: ldc_w 256
    //   162: invokevirtual 260	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   165: ifnonnull +13 -> 178
    //   168: aload_1
    //   169: ldc_w 256
    //   172: ldc_w 262
    //   175: invokevirtual 127	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_1
    //   179: iconst_1
    //   180: invokevirtual 266	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   183: aload_1
    //   184: invokevirtual 270	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   187: aload_2
    //   188: invokevirtual 276	java/io/OutputStream:write	([B)V
    //   191: new 278	org/c/d/g
    //   194: dup
    //   195: aload_0
    //   196: getfield 205	org/c/d/f:aRG	Ljava/net/HttpURLConnection;
    //   199: invokespecial 280	org/c/d/g:<init>	(Ljava/net/HttpURLConnection;)V
    //   202: areturn
    //   203: ldc_w 282
    //   206: astore_1
    //   207: goto -185 -> 22
    //   210: astore_1
    //   211: new 284	org/c/b/a
    //   214: dup
    //   215: aload_1
    //   216: invokespecial 287	org/c/b/a:<init>	(Ljava/lang/Exception;)V
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	f
    //   21	186	1	localObject1	Object
    //   210	6	1	localException	java.lang.Exception
    //   4	184	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	19	210	java/lang/Exception
    //   22	47	210	java/lang/Exception
    //   47	82	210	java/lang/Exception
    //   82	103	210	java/lang/Exception
    //   103	137	210	java/lang/Exception
    //   137	178	210	java/lang/Exception
    //   178	191	210	java/lang/Exception
    //   191	203	210	java/lang/Exception
  }
  
  public e cUZ()
  {
    return this.xuA;
  }
  
  public String cVa()
  {
    return this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void hb(String paramString1, String paramString2)
  {
    this.xuz.xux.add(new d(paramString1, paramString2));
  }
  
  public String toString()
  {
    return String.format("@Request(%s %s)", new Object[] { cUV(), getUrl() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.c.d.f
 * JD-Core Version:    0.7.0.1
 */