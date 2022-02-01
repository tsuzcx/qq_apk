package io.flutter.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class k
{
  final l Jbm;
  final String name;
  private final c trm;
  
  public k(c paramc, String paramString)
  {
    this(paramc, paramString, o.Jbz);
  }
  
  public k(c paramc, String paramString, l paraml)
  {
    this.trm = paramc;
    this.name = paramString;
    this.Jbm = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9838);
    c localc = this.trm;
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
    c localc = this.trm;
    String str = this.name;
    paramObject = this.Jbm.a(new j(paramString, paramObject));
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
    private final k.c trp;
    
    a(k.c paramc)
    {
      this.trp = paramc;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9867);
      paramByteBuffer = k.this.Jbm.J(paramByteBuffer);
      try
      {
        this.trp.a(paramByteBuffer, new k.d()
        {
          public final void Av()
          {
            AppMethodBeat.i(9841);
            paramb.H(null);
            AppMethodBeat.o(9841);
          }
          
          public final void a(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(9840);
            paramb.H(k.this.Jbm.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousObject));
            AppMethodBeat.o(9840);
          }
          
          public final void ay(Object paramAnonymousObject)
          {
            AppMethodBeat.i(9839);
            paramb.H(k.this.Jbm.eC(paramAnonymousObject));
            AppMethodBeat.o(9839);
          }
        });
        AppMethodBeat.o(9867);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("MethodChannel#").append(k.this.name);
        paramb.H(k.this.Jbm.i("error", paramByteBuffer.getMessage(), null));
        AppMethodBeat.o(9867);
      }
    }
  }
  
  final class b
    implements c.b
  {
    private final k.d sNY;
    
    b(k.d paramd)
    {
      this.sNY = paramd;
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
      //   11: getfield 22	io/flutter/a/a/k$b:sNY	Lio/flutter/a/a/k$d;
      //   14: invokeinterface 40 1 0
      //   19: sipush 9866
      //   22: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: return
      //   26: aload_0
      //   27: getfield 22	io/flutter/a/a/k$b:sNY	Lio/flutter/a/a/k$d;
      //   30: aload_0
      //   31: getfield 17	io/flutter/a/a/k$b:Jbu	Lio/flutter/a/a/k;
      //   34: getfield 47	io/flutter/a/a/k:Jbm	Lio/flutter/a/a/l;
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
      //   66: getfield 17	io/flutter/a/a/k$b:Jbu	Lio/flutter/a/a/k;
      //   69: getfield 68	io/flutter/a/a/k:name	Ljava/lang/String;
      //   72: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: sipush 9866
      //   79: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: return
      //   83: astore_1
      //   84: aload_0
      //   85: getfield 22	io/flutter/a/a/k$b:sNY	Lio/flutter/a/a/k$d;
      //   88: aload_1
      //   89: getfield 75	io/flutter/a/a/e:code	Ljava/lang/String;
      //   92: aload_1
      //   93: invokevirtual 79	io/flutter/a/a/e:getMessage	()Ljava/lang/String;
      //   96: aload_1
      //   97: getfield 83	io/flutter/a/a/e:rec	Ljava/lang/Object;
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
      //   26	48	83	io/flutter/a/a/e
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(j paramj, k.d paramd);
  }
  
  public static abstract interface d
  {
    public abstract void Av();
    
    public abstract void a(String paramString1, String paramString2, Object paramObject);
    
    public abstract void ay(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.a.k
 * JD-Core Version:    0.7.0.1
 */