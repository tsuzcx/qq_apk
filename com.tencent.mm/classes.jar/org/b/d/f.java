package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
import org.b.b.b;

class f
{
  private j CRK;
  private e CRL;
  private e CRM;
  private byte[] CRN;
  private boolean CRO;
  private Long CRP;
  private Long CRQ;
  private String charset;
  private HttpURLConnection connection;
  private Map<String, String> headers;
  private String url;
  private String xly;
  
  public f(j paramj, String paramString)
  {
    AppMethodBeat.i(77250);
    this.xly = null;
    this.CRN = null;
    this.CRO = false;
    this.CRP = null;
    this.CRQ = null;
    this.CRK = paramj;
    this.url = paramString;
    this.CRL = new e();
    this.CRM = new e();
    this.headers = new HashMap();
    AppMethodBeat.o(77250);
  }
  
  private byte[] erI()
  {
    AppMethodBeat.i(77258);
    if (this.CRN != null)
    {
      localObject = this.CRN;
      AppMethodBeat.o(77258);
      return localObject;
    }
    if (this.xly != null) {}
    for (Object localObject = this.xly;; localObject = this.CRM.erH()) {
      try
      {
        localObject = ((String)localObject).getBytes(erC());
        AppMethodBeat.o(77258);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        b localb = new b("Unsupported Charset: " + erC(), localUnsupportedEncodingException);
        AppMethodBeat.o(77258);
        throw localb;
      }
    }
  }
  
  private void i(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(77253);
    Iterator localIterator = this.headers.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        AppMethodBeat.o(77253);
        return;
      }
      String str = (String)localIterator.next();
      paramHttpURLConnection.setRequestProperty(str, (String)this.headers.get(str));
    }
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77254);
    this.headers.put(paramString1, paramString2);
    AppMethodBeat.o(77254);
  }
  
  public j erA()
  {
    return this.CRK;
  }
  
  public String erB()
  {
    AppMethodBeat.i(77252);
    Object localObject2 = this.CRL;
    Object localObject1 = this.url;
    org.b.g.d.s(localObject1, "Cannot append to null URL");
    localObject2 = ((e)localObject2).erH();
    if (((String)localObject2).equals(""))
    {
      AppMethodBeat.o(77252);
      return localObject1;
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1));
    if (((String)localObject1).indexOf('?') != -1) {}
    for (localObject1 = "&";; localObject1 = Character.valueOf('?'))
    {
      localObject1 = localStringBuilder.append(localObject1).toString() + (String)localObject2;
      AppMethodBeat.o(77252);
      return localObject1;
    }
  }
  
  public String erC()
  {
    AppMethodBeat.i(77259);
    if (this.charset == null)
    {
      str = Charset.defaultCharset().name();
      AppMethodBeat.o(77259);
      return str;
    }
    String str = this.charset;
    AppMethodBeat.o(77259);
    return str;
  }
  
  /* Error */
  public g erD()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 199	org/b/d/f:erB	()Ljava/lang/String;
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   14: ifnonnull +38 -> 52
    //   17: aload_0
    //   18: getfield 43	org/b/d/f:CRO	Z
    //   21: ifeq +192 -> 213
    //   24: ldc 203
    //   26: astore_1
    //   27: ldc 205
    //   29: aload_1
    //   30: invokestatic 211	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: pop
    //   34: aload_0
    //   35: new 213	java/net/URL
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 214	java/net/URL:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 218	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   46: checkcast 134	java/net/HttpURLConnection
    //   49: putfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   52: aload_0
    //   53: getfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   56: aload_0
    //   57: getfield 49	org/b/d/f:CRK	Lorg/b/d/j;
    //   60: invokevirtual 221	org/b/d/j:name	()Ljava/lang/String;
    //   63: invokevirtual 224	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: getfield 45	org/b/d/f:CRP	Ljava/lang/Long;
    //   70: ifnull +17 -> 87
    //   73: aload_0
    //   74: getfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   77: aload_0
    //   78: getfield 45	org/b/d/f:CRP	Ljava/lang/Long;
    //   81: invokevirtual 230	java/lang/Long:intValue	()I
    //   84: invokevirtual 233	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   87: aload_0
    //   88: getfield 47	org/b/d/f:CRQ	Ljava/lang/Long;
    //   91: ifnull +17 -> 108
    //   94: aload_0
    //   95: getfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   98: aload_0
    //   99: getfield 47	org/b/d/f:CRQ	Ljava/lang/Long;
    //   102: invokevirtual 230	java/lang/Long:intValue	()I
    //   105: invokevirtual 236	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   113: invokespecial 238	org/b/d/f:i	(Ljava/net/HttpURLConnection;)V
    //   116: aload_0
    //   117: getfield 49	org/b/d/f:CRK	Lorg/b/d/j;
    //   120: getstatic 241	org/b/d/j:CRX	Lorg/b/d/j;
    //   123: invokevirtual 242	org/b/d/j:equals	(Ljava/lang/Object;)Z
    //   126: ifne +16 -> 142
    //   129: aload_0
    //   130: getfield 49	org/b/d/f:CRK	Lorg/b/d/j;
    //   133: getstatic 245	org/b/d/j:CRW	Lorg/b/d/j;
    //   136: invokevirtual 242	org/b/d/j:equals	(Ljava/lang/Object;)Z
    //   139: ifeq +55 -> 194
    //   142: aload_0
    //   143: getfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   146: astore_1
    //   147: aload_0
    //   148: invokespecial 247	org/b/d/f:erI	()[B
    //   151: astore_2
    //   152: aload_1
    //   153: ldc 249
    //   155: aload_2
    //   156: arraylength
    //   157: invokestatic 252	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   160: invokevirtual 138	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_1
    //   164: ldc 254
    //   166: invokevirtual 258	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   169: ifnonnull +12 -> 181
    //   172: aload_1
    //   173: ldc 254
    //   175: ldc_w 260
    //   178: invokevirtual 138	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_1
    //   182: iconst_1
    //   183: invokevirtual 264	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   186: aload_1
    //   187: invokevirtual 268	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   190: aload_2
    //   191: invokevirtual 274	java/io/OutputStream:write	([B)V
    //   194: new 276	org/b/d/g
    //   197: dup
    //   198: aload_0
    //   199: getfield 201	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   202: invokespecial 278	org/b/d/g:<init>	(Ljava/net/HttpURLConnection;)V
    //   205: astore_1
    //   206: ldc 197
    //   208: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_1
    //   212: areturn
    //   213: ldc_w 280
    //   216: astore_1
    //   217: goto -190 -> 27
    //   220: astore_1
    //   221: new 282	org/b/b/a
    //   224: dup
    //   225: aload_1
    //   226: invokespecial 285	org/b/b/a:<init>	(Ljava/lang/Exception;)V
    //   229: astore_1
    //   230: ldc 197
    //   232: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	f
    //   26	191	1	localObject1	Object
    //   220	6	1	localException	java.lang.Exception
    //   229	7	1	locala	org.b.b.a
    //   9	182	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	220	java/lang/Exception
    //   27	52	220	java/lang/Exception
    //   52	87	220	java/lang/Exception
    //   87	108	220	java/lang/Exception
    //   108	142	220	java/lang/Exception
    //   142	181	220	java/lang/Exception
    //   181	194	220	java/lang/Exception
    //   194	206	220	java/lang/Exception
  }
  
  public e erE()
  {
    return this.CRM;
  }
  
  public String erF()
  {
    AppMethodBeat.i(77257);
    String str = this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    AppMethodBeat.o(77257);
    return str;
  }
  
  public e erz()
  {
    AppMethodBeat.i(77256);
    try
    {
      e locale = new e();
      locale.azU(new URL(this.url).getQuery());
      locale.a(this.CRL);
      AppMethodBeat.o(77256);
      return locale;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      b localb = new b("Malformed URL", localMalformedURLException);
      AppMethodBeat.o(77256);
      throw localb;
    }
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void jI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77255);
    this.CRL.CRJ.add(new d(paramString1, paramString2));
    AppMethodBeat.o(77255);
  }
  
  public String toString()
  {
    AppMethodBeat.i(77260);
    String str = String.format("@Request(%s %s)", new Object[] { erA(), getUrl() });
    AppMethodBeat.o(77260);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.d.f
 * JD-Core Version:    0.7.0.1
 */