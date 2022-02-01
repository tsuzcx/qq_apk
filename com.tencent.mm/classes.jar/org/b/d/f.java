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
  private String DFl;
  private e KnA;
  private e KnB;
  private byte[] KnC;
  private boolean KnD;
  private Long KnE;
  private Long KnF;
  private j Knz;
  private String charset;
  private HttpURLConnection connection;
  private Map<String, String> headers;
  private String url;
  
  public f(j paramj, String paramString)
  {
    AppMethodBeat.i(40519);
    this.DFl = null;
    this.KnC = null;
    this.KnD = false;
    this.KnE = null;
    this.KnF = null;
    this.Knz = paramj;
    this.url = paramString;
    this.KnA = new e();
    this.KnB = new e();
    this.headers = new HashMap();
    AppMethodBeat.o(40519);
  }
  
  private byte[] fNk()
  {
    AppMethodBeat.i(40527);
    if (this.KnC != null)
    {
      localObject = this.KnC;
      AppMethodBeat.o(40527);
      return localObject;
    }
    if (this.DFl != null) {}
    for (Object localObject = this.DFl;; localObject = this.KnB.fNj()) {
      try
      {
        localObject = ((String)localObject).getBytes(fNe());
        AppMethodBeat.o(40527);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        b localb = new b("Unsupported Charset: " + fNe(), localUnsupportedEncodingException);
        AppMethodBeat.o(40527);
        throw localb;
      }
    }
  }
  
  private void g(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(40522);
    Iterator localIterator = this.headers.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        AppMethodBeat.o(40522);
        return;
      }
      String str = (String)localIterator.next();
      paramHttpURLConnection.setRequestProperty(str, (String)this.headers.get(str));
    }
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40523);
    this.headers.put(paramString1, paramString2);
    AppMethodBeat.o(40523);
  }
  
  public e fNb()
  {
    AppMethodBeat.i(40525);
    try
    {
      e locale = new e();
      locale.aRF(new URL(this.url).getQuery());
      locale.a(this.KnA);
      AppMethodBeat.o(40525);
      return locale;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      b localb = new b("Malformed URL", localMalformedURLException);
      AppMethodBeat.o(40525);
      throw localb;
    }
  }
  
  public j fNc()
  {
    return this.Knz;
  }
  
  public String fNd()
  {
    AppMethodBeat.i(40521);
    Object localObject2 = this.KnA;
    Object localObject1 = this.url;
    org.b.g.d.j(localObject1, "Cannot append to null URL");
    localObject2 = ((e)localObject2).fNj();
    if (((String)localObject2).equals(""))
    {
      AppMethodBeat.o(40521);
      return localObject1;
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1));
    if (((String)localObject1).indexOf('?') != -1) {}
    for (localObject1 = "&";; localObject1 = Character.valueOf('?'))
    {
      localObject1 = localStringBuilder.append(localObject1).toString() + (String)localObject2;
      AppMethodBeat.o(40521);
      return localObject1;
    }
  }
  
  public String fNe()
  {
    AppMethodBeat.i(40528);
    if (this.charset == null)
    {
      str = Charset.defaultCharset().name();
      AppMethodBeat.o(40528);
      return str;
    }
    String str = this.charset;
    AppMethodBeat.o(40528);
    return str;
  }
  
  /* Error */
  public g fNf()
  {
    // Byte code:
    //   0: ldc 218
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 220	org/b/d/f:fNd	()Ljava/lang/String;
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   14: ifnonnull +38 -> 52
    //   17: aload_0
    //   18: getfield 43	org/b/d/f:KnD	Z
    //   21: ifeq +195 -> 216
    //   24: ldc 224
    //   26: astore_1
    //   27: ldc 226
    //   29: aload_1
    //   30: invokestatic 232	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: pop
    //   34: aload_0
    //   35: new 152	java/net/URL
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 153	java/net/URL:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 236	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   46: checkcast 135	java/net/HttpURLConnection
    //   49: putfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   52: aload_0
    //   53: getfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   56: aload_0
    //   57: getfield 49	org/b/d/f:Knz	Lorg/b/d/j;
    //   60: invokevirtual 239	org/b/d/j:name	()Ljava/lang/String;
    //   63: invokevirtual 242	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: getfield 45	org/b/d/f:KnE	Ljava/lang/Long;
    //   70: ifnull +17 -> 87
    //   73: aload_0
    //   74: getfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   77: aload_0
    //   78: getfield 45	org/b/d/f:KnE	Ljava/lang/Long;
    //   81: invokevirtual 248	java/lang/Long:intValue	()I
    //   84: invokevirtual 251	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   87: aload_0
    //   88: getfield 47	org/b/d/f:KnF	Ljava/lang/Long;
    //   91: ifnull +17 -> 108
    //   94: aload_0
    //   95: getfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   98: aload_0
    //   99: getfield 47	org/b/d/f:KnF	Ljava/lang/Long;
    //   102: invokevirtual 248	java/lang/Long:intValue	()I
    //   105: invokevirtual 254	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   113: invokespecial 256	org/b/d/f:g	(Ljava/net/HttpURLConnection;)V
    //   116: aload_0
    //   117: getfield 49	org/b/d/f:Knz	Lorg/b/d/j;
    //   120: getstatic 259	org/b/d/j:KnM	Lorg/b/d/j;
    //   123: invokevirtual 260	org/b/d/j:equals	(Ljava/lang/Object;)Z
    //   126: ifne +16 -> 142
    //   129: aload_0
    //   130: getfield 49	org/b/d/f:Knz	Lorg/b/d/j;
    //   133: getstatic 263	org/b/d/j:KnL	Lorg/b/d/j;
    //   136: invokevirtual 260	org/b/d/j:equals	(Ljava/lang/Object;)Z
    //   139: ifeq +58 -> 197
    //   142: aload_0
    //   143: getfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   146: astore_1
    //   147: aload_0
    //   148: invokespecial 265	org/b/d/f:fNk	()[B
    //   151: astore_2
    //   152: aload_1
    //   153: ldc_w 267
    //   156: aload_2
    //   157: arraylength
    //   158: invokestatic 270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   161: invokevirtual 139	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_1
    //   165: ldc_w 272
    //   168: invokevirtual 276	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   171: ifnonnull +13 -> 184
    //   174: aload_1
    //   175: ldc_w 272
    //   178: ldc_w 278
    //   181: invokevirtual 139	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_1
    //   185: iconst_1
    //   186: invokevirtual 282	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   189: aload_1
    //   190: invokevirtual 286	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   193: aload_2
    //   194: invokevirtual 292	java/io/OutputStream:write	([B)V
    //   197: new 294	org/b/d/g
    //   200: dup
    //   201: aload_0
    //   202: getfield 222	org/b/d/f:connection	Ljava/net/HttpURLConnection;
    //   205: invokespecial 296	org/b/d/g:<init>	(Ljava/net/HttpURLConnection;)V
    //   208: astore_1
    //   209: ldc 218
    //   211: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: areturn
    //   216: ldc_w 298
    //   219: astore_1
    //   220: goto -193 -> 27
    //   223: astore_1
    //   224: new 300	org/b/b/a
    //   227: dup
    //   228: aload_1
    //   229: invokespecial 303	org/b/b/a:<init>	(Ljava/lang/Exception;)V
    //   232: astore_1
    //   233: ldc 218
    //   235: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	f
    //   26	194	1	localObject1	Object
    //   223	6	1	localException	java.lang.Exception
    //   232	7	1	locala	org.b.b.a
    //   9	185	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	223	java/lang/Exception
    //   27	52	223	java/lang/Exception
    //   52	87	223	java/lang/Exception
    //   87	108	223	java/lang/Exception
    //   108	142	223	java/lang/Exception
    //   142	184	223	java/lang/Exception
    //   184	197	223	java/lang/Exception
    //   197	209	223	java/lang/Exception
  }
  
  public e fNg()
  {
    return this.KnB;
  }
  
  public String fNh()
  {
    AppMethodBeat.i(40526);
    String str = this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    AppMethodBeat.o(40526);
    return str;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void mO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40524);
    this.KnA.Kny.add(new d(paramString1, paramString2));
    AppMethodBeat.o(40524);
  }
  
  public String toString()
  {
    AppMethodBeat.i(40529);
    String str = String.format("@Request(%s %s)", new Object[] { fNc(), getUrl() });
    AppMethodBeat.o(40529);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.d.f
 * JD-Core Version:    0.7.0.1
 */