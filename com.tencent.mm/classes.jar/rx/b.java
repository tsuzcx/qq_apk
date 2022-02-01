package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.e;

public final class b
{
  static final b akaa;
  static final b akab;
  private final a ajZZ;
  
  static
  {
    AppMethodBeat.i(90077);
    akaa = new b(new a() {}, (byte)0);
    akab = new b(new a() {}, (byte)0);
    AppMethodBeat.o(90077);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(90075);
    this.ajZZ = rx.d.c.b(parama);
    AppMethodBeat.o(90075);
  }
  
  private b(a parama, byte paramByte)
  {
    this.ajZZ = parama;
  }
  
  /* Error */
  public static b a(a parama)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 66	rx/b:jU	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: new 2	rx/b
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 68	rx/b:<init>	(Lrx/b$a;)V
    //   18: astore_0
    //   19: ldc 62
    //   21: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: areturn
    //   26: astore_0
    //   27: ldc 62
    //   29: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: athrow
    //   34: astore_0
    //   35: aload_0
    //   36: invokestatic 72	rx/d/c:l	(Ljava/lang/Throwable;)V
    //   39: aload_0
    //   40: invokestatic 76	rx/b:af	(Ljava/lang/Throwable;)Ljava/lang/NullPointerException;
    //   43: astore_0
    //   44: ldc 62
    //   46: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	parama	a
    // Exception table:
    //   from	to	target	type
    //   10	19	26	java/lang/NullPointerException
    //   10	19	34	finally
  }
  
  private static NullPointerException af(Throwable paramThrowable)
  {
    AppMethodBeat.i(90074);
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    AppMethodBeat.o(90074);
    return localNullPointerException;
  }
  
  private static <T> T jU(T paramT)
  {
    AppMethodBeat.i(90073);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(90073);
      throw paramT;
    }
    AppMethodBeat.o(90073);
    return paramT;
  }
  
  /* Error */
  public final j kKe()
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 95	rx/f/c
    //   8: dup
    //   9: invokespecial 96	rx/f/c:<init>	()V
    //   12: astore_1
    //   13: new 10	rx/b$3
    //   16: dup
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 99	rx/b$3:<init>	(Lrx/b;Lrx/f/c;)V
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 66	rx/b:jU	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 58	rx/b:ajZZ	Lrx/b$a;
    //   33: invokestatic 102	rx/d/c:a	(Lrx/b;Lrx/b$a;)Lrx/b$a;
    //   36: aload_2
    //   37: invokeinterface 106 2 0
    //   42: ldc 93
    //   44: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: areturn
    //   49: astore_1
    //   50: ldc 93
    //   52: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: aload_1
    //   59: invokestatic 111	rx/a/b:ai	(Ljava/lang/Throwable;)V
    //   62: aload_1
    //   63: invokestatic 114	rx/d/c:ar	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 72	rx/d/c:l	(Ljava/lang/Throwable;)V
    //   71: aload_1
    //   72: invokestatic 76	rx/b:af	(Ljava/lang/Throwable;)Ljava/lang/NullPointerException;
    //   75: astore_1
    //   76: ldc 93
    //   78: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	b
    //   12	36	1	localc	rx.f.c
    //   49	7	1	localNullPointerException	NullPointerException
    //   57	6	1	localThrowable	Throwable
    //   66	16	1	localObject	Object
    //   22	15	2	local3	3
    // Exception table:
    //   from	to	target	type
    //   28	42	49	java/lang/NullPointerException
    //   28	42	57	finally
  }
  
  public static abstract interface a
    extends rx.b.b<b.c>
  {}
  
  public static abstract interface b
    extends e<b.c, b.c>
  {}
  
  public static abstract interface c
  {
    public abstract void a(j paramj);
    
    public abstract void fvq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.b
 * JD-Core Version:    0.7.0.1
 */