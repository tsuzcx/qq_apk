package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.b.g.e;

public final class g
{
  private String Otw;
  private InputStream aFw;
  public int code;
  private Map<String, String> headers;
  
  /* Error */
  g(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 20	java/lang/Object:<init>	()V
    //   4: ldc 21
    //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokevirtual 32	java/net/HttpURLConnection:connect	()V
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 36	java/net/HttpURLConnection:getResponseCode	()I
    //   18: putfield 38	org/b/d/g:code	I
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 42	org/b/d/g:h	(Ljava/net/HttpURLConnection;)Ljava/util/Map;
    //   26: putfield 44	org/b/d/g:headers	Ljava/util/Map;
    //   29: aload_0
    //   30: getfield 38	org/b/d/g:code	I
    //   33: sipush 200
    //   36: if_icmplt +35 -> 71
    //   39: aload_0
    //   40: getfield 38	org/b/d/g:code	I
    //   43: sipush 400
    //   46: if_icmpge +25 -> 71
    //   49: iconst_1
    //   50: istore_2
    //   51: iload_2
    //   52: ifeq +24 -> 76
    //   55: aload_1
    //   56: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 50	org/b/d/g:aFw	Ljava/io/InputStream;
    //   65: ldc 21
    //   67: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: iconst_0
    //   72: istore_2
    //   73: goto -22 -> 51
    //   76: aload_1
    //   77: invokevirtual 56	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   80: astore_1
    //   81: goto -21 -> 60
    //   84: astore_1
    //   85: new 58	org/b/b/b
    //   88: dup
    //   89: ldc 60
    //   91: aload_1
    //   92: invokespecial 63	org/b/b/b:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   95: astore_1
    //   96: ldc 21
    //   98: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	g
    //   0	103	1	paramHttpURLConnection	HttpURLConnection
    //   50	23	2	i	int
    // Exception table:
    //   from	to	target	type
    //   9	49	84	java/net/UnknownHostException
    //   55	60	84	java/net/UnknownHostException
    //   60	65	84	java/net/UnknownHostException
    //   76	81	84	java/net/UnknownHostException
  }
  
  private static Map<String, String> h(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(40512);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHttpURLConnection.getHeaderFields().keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        AppMethodBeat.o(40512);
        return localHashMap;
      }
      String str = (String)localIterator.next();
      localHashMap.put(str, (String)((List)paramHttpURLConnection.getHeaderFields().get(str)).get(0));
    }
  }
  
  public final String getBody()
  {
    AppMethodBeat.i(40513);
    if (this.Otw != null)
    {
      str = this.Otw;
      AppMethodBeat.o(40513);
      return str;
    }
    this.Otw = e.aa(this.aFw);
    String str = this.Otw;
    AppMethodBeat.o(40513);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.d.g
 * JD-Core Version:    0.7.0.1
 */