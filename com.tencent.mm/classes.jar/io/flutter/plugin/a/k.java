package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public final class k
{
  final l aauF;
  private final c aauy;
  final String name;
  
  public k(c paramc, String paramString)
  {
    this(paramc, paramString, o.aauS);
  }
  
  public k(c paramc, String paramString, l paraml)
  {
    this.aauy = paramc;
    this.name = paramString;
    this.aauF = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9838);
    c localc = this.aauy;
    String str = this.name;
    if (paramc == null) {}
    for (paramc = null;; paramc = new a(paramc))
    {
      localc.a(str, paramc);
      AppMethodBeat.o(9838);
      return;
    }
  }
  
  public final void a(String paramString, Object paramObject, d paramd)
  {
    AppMethodBeat.i(9837);
    c localc = this.aauy;
    String str = this.name;
    paramObject = this.aauF.b(new j(paramString, paramObject));
    if (paramd == null) {}
    for (paramString = null;; paramString = new b(paramd))
    {
      localc.a(str, paramObject, paramString);
      AppMethodBeat.o(9837);
      return;
    }
  }
  
  final class a
    implements c.a
  {
    private final k.c aatH;
    
    a(k.c paramc)
    {
      this.aatH = paramc;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9867);
      paramByteBuffer = k.this.aauF.G(paramByteBuffer);
      try
      {
        this.aatH.a(paramByteBuffer, new k.d()
        {
          public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(9840);
            paramb.E(k.this.aauF.h(paramAnonymousString1, paramAnonymousString2, paramAnonymousObject));
            AppMethodBeat.o(9840);
          }
          
          public final void bb(Object paramAnonymousObject)
          {
            AppMethodBeat.i(9839);
            paramb.E(k.this.aauF.eV(paramAnonymousObject));
            AppMethodBeat.o(9839);
          }
          
          public final void epZ()
          {
            AppMethodBeat.i(9841);
            paramb.E(null);
            AppMethodBeat.o(9841);
          }
        });
        AppMethodBeat.o(9867);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("MethodChannel#").append(k.this.name);
        b.iAi();
        l locall = k.this.aauF;
        String str = paramByteBuffer.getMessage();
        StringWriter localStringWriter = new StringWriter();
        paramByteBuffer.printStackTrace(new PrintWriter(localStringWriter));
        paramb.E(locall.bw("error", str, localStringWriter.toString()));
        AppMethodBeat.o(9867);
      }
    }
  }
  
  final class b
    implements c.b
  {
    private final k.d ZZf;
    
    b(k.d paramd)
    {
      this.ZZf = paramd;
    }
    
    /* Error */
    public final void E(ByteBuffer paramByteBuffer)
    {
      // Byte code:
      //   0: sipush 9866
      //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: ifnonnull +19 -> 26
      //   10: aload_0
      //   11: getfield 22	io/flutter/plugin/a/k$b:ZZf	Lio/flutter/plugin/a/k$d;
      //   14: invokeinterface 40 1 0
      //   19: sipush 9866
      //   22: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: return
      //   26: aload_0
      //   27: getfield 22	io/flutter/plugin/a/k$b:ZZf	Lio/flutter/plugin/a/k$d;
      //   30: aload_0
      //   31: getfield 17	io/flutter/plugin/a/k$b:aauN	Lio/flutter/plugin/a/k;
      //   34: getfield 47	io/flutter/plugin/a/k:aauF	Lio/flutter/plugin/a/l;
      //   37: aload_1
      //   38: invokeinterface 53 2 0
      //   43: invokeinterface 57 2 0
      //   48: sipush 9866
      //   51: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: return
      //   55: astore_1
      //   56: new 59	java/lang/StringBuilder
      //   59: dup
      //   60: ldc 61
      //   62: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   65: aload_0
      //   66: getfield 17	io/flutter/plugin/a/k$b:aauN	Lio/flutter/plugin/a/k;
      //   69: getfield 68	io/flutter/plugin/a/k:name	Ljava/lang/String;
      //   72: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: invokestatic 77	io/flutter/b:iAi	()V
      //   79: sipush 9866
      //   82: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: return
      //   86: astore_1
      //   87: aload_0
      //   88: getfield 22	io/flutter/plugin/a/k$b:ZZf	Lio/flutter/plugin/a/k$d;
      //   91: aload_1
      //   92: getfield 80	io/flutter/plugin/a/e:code	Ljava/lang/String;
      //   95: aload_1
      //   96: invokevirtual 84	io/flutter/plugin/a/e:getMessage	()Ljava/lang/String;
      //   99: aload_1
      //   100: getfield 88	io/flutter/plugin/a/e:jSd	Ljava/lang/Object;
      //   103: invokeinterface 91 4 0
      //   108: sipush 9866
      //   111: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   114: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	115	0	this	b
      //   0	115	1	paramByteBuffer	ByteBuffer
      // Exception table:
      //   from	to	target	type
      //   10	25	55	java/lang/RuntimeException
      //   26	48	55	java/lang/RuntimeException
      //   48	54	55	java/lang/RuntimeException
      //   87	108	55	java/lang/RuntimeException
      //   26	48	86	io/flutter/plugin/a/e
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(j paramj, k.d paramd);
  }
  
  public static abstract interface d
  {
    public abstract void b(String paramString1, String paramString2, Object paramObject);
    
    public abstract void bb(Object paramObject);
    
    public abstract void epZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.a.k
 * JD-Core Version:    0.7.0.1
 */