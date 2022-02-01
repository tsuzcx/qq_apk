package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class k
{
  final l KOQ;
  final String name;
  private final c uzE;
  
  public k(c paramc, String paramString)
  {
    this(paramc, paramString, o.KPd);
  }
  
  public k(c paramc, String paramString, l paraml)
  {
    this.uzE = paramc;
    this.name = paramString;
    this.KOQ = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9838);
    c localc = this.uzE;
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
    c localc = this.uzE;
    String str = this.name;
    paramObject = this.KOQ.b(new j(paramString, paramObject));
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
    private final k.c uzH;
    
    a(k.c paramc)
    {
      this.uzH = paramc;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9867);
      paramByteBuffer = k.this.KOQ.J(paramByteBuffer);
      try
      {
        this.uzH.a(paramByteBuffer, new k.d()
        {
          public final void daE()
          {
            AppMethodBeat.i(9841);
            paramb.H(null);
            AppMethodBeat.o(9841);
          }
          
          public final void db(Object paramAnonymousObject)
          {
            AppMethodBeat.i(9839);
            paramb.H(k.this.KOQ.eE(paramAnonymousObject));
            AppMethodBeat.o(9839);
          }
          
          public final void e(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(9840);
            paramb.H(k.this.KOQ.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousObject));
            AppMethodBeat.o(9840);
          }
        });
        AppMethodBeat.o(9867);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("MethodChannel#").append(k.this.name);
        paramb.H(k.this.KOQ.i("error", paramByteBuffer.getMessage(), null));
        AppMethodBeat.o(9867);
      }
    }
  }
  
  final class b
    implements c.b
  {
    private final k.d uzL;
    
    b(k.d paramd)
    {
      this.uzL = paramd;
    }
    
    /* Error */
    public final void H(ByteBuffer paramByteBuffer)
    {
      // Byte code:
      //   0: sipush 9866
      //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: ifnonnull +19 -> 26
      //   10: aload_0
      //   11: getfield 22	io/flutter/plugin/a/k$b:uzL	Lio/flutter/plugin/a/k$d;
      //   14: invokeinterface 40 1 0
      //   19: sipush 9866
      //   22: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: return
      //   26: aload_0
      //   27: getfield 22	io/flutter/plugin/a/k$b:uzL	Lio/flutter/plugin/a/k$d;
      //   30: aload_0
      //   31: getfield 17	io/flutter/plugin/a/k$b:KOY	Lio/flutter/plugin/a/k;
      //   34: getfield 47	io/flutter/plugin/a/k:KOQ	Lio/flutter/plugin/a/l;
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
      //   66: getfield 17	io/flutter/plugin/a/k$b:KOY	Lio/flutter/plugin/a/k;
      //   69: getfield 68	io/flutter/plugin/a/k:name	Ljava/lang/String;
      //   72: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: sipush 9866
      //   79: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: return
      //   83: astore_1
      //   84: aload_0
      //   85: getfield 22	io/flutter/plugin/a/k$b:uzL	Lio/flutter/plugin/a/k$d;
      //   88: aload_1
      //   89: getfield 75	io/flutter/plugin/a/e:code	Ljava/lang/String;
      //   92: aload_1
      //   93: invokevirtual 79	io/flutter/plugin/a/e:getMessage	()Ljava/lang/String;
      //   96: aload_1
      //   97: getfield 83	io/flutter/plugin/a/e:smX	Ljava/lang/Object;
      //   100: invokeinterface 87 4 0
      //   105: sipush 9866
      //   108: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   111: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	b
      //   0	112	1	paramByteBuffer	ByteBuffer
      // Exception table:
      //   from	to	target	type
      //   10	25	55	java/lang/RuntimeException
      //   26	48	55	java/lang/RuntimeException
      //   48	54	55	java/lang/RuntimeException
      //   84	105	55	java/lang/RuntimeException
      //   26	48	83	io/flutter/plugin/a/e
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(j paramj, k.d paramd);
  }
  
  public static abstract interface d
  {
    public abstract void daE();
    
    public abstract void db(Object paramObject);
    
    public abstract void e(String paramString1, String paramString2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.plugin.a.k
 * JD-Core Version:    0.7.0.1
 */