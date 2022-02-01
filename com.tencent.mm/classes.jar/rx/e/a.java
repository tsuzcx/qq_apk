package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d.a;

public final class a<T>
  extends b<T, T>
{
  private final rx.internal.a.c<T> akaK;
  final c<T> akeB;
  
  public a(d.a<T> parama, c<T> paramc)
  {
    super(parama);
    AppMethodBeat.i(90423);
    this.akaK = rx.internal.a.c.kKn();
    this.akeB = paramc;
    AppMethodBeat.o(90423);
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(90424);
    if (this.akeB.active)
    {
      Object localObject = rx.internal.a.c.kKo();
      c.b[] arrayOfb = this.akeB.jZ(localObject);
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].ka(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(90424);
  }
  
  public final void jV(T paramT)
  {
    AppMethodBeat.i(90426);
    c.b[] arrayOfb = ((c.a)this.akeB.get()).akeJ;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].jV(paramT);
      i += 1;
    }
    AppMethodBeat.o(90426);
  }
  
  /* Error */
  public final void l(java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 35	rx/e/a:akeB	Lrx/e/c;
    //   9: getfield 50	rx/e/c:active	Z
    //   12: ifeq +91 -> 103
    //   15: aload_1
    //   16: invokestatic 85	rx/internal/a/c:ak	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   19: astore 5
    //   21: aconst_null
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 35	rx/e/a:akeB	Lrx/e/c;
    //   27: aload 5
    //   29: invokevirtual 58	rx/e/c:jZ	(Ljava/lang/Object;)[Lrx/e/c$b;
    //   32: astore 6
    //   34: aload 6
    //   36: arraylength
    //   37: istore_3
    //   38: iconst_0
    //   39: istore_2
    //   40: iload_2
    //   41: iload_3
    //   42: if_icmpge +57 -> 99
    //   45: aload 6
    //   47: iload_2
    //   48: aaload
    //   49: astore 4
    //   51: aload 4
    //   53: aload 5
    //   55: invokevirtual 64	rx/e/c$b:ka	(Ljava/lang/Object;)V
    //   58: iload_2
    //   59: iconst_1
    //   60: iadd
    //   61: istore_2
    //   62: goto -22 -> 40
    //   65: astore 7
    //   67: aload_1
    //   68: astore 4
    //   70: aload_1
    //   71: ifnonnull +12 -> 83
    //   74: new 87	java/util/ArrayList
    //   77: dup
    //   78: invokespecial 89	java/util/ArrayList:<init>	()V
    //   81: astore 4
    //   83: aload 4
    //   85: aload 7
    //   87: invokeinterface 95 2 0
    //   92: pop
    //   93: aload 4
    //   95: astore_1
    //   96: goto -38 -> 58
    //   99: aload_1
    //   100: invokestatic 101	rx/a/b:pp	(Ljava/util/List;)V
    //   103: ldc 81
    //   105: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	a
    //   0	109	1	paramThrowable	java.lang.Throwable
    //   39	23	2	i	int
    //   37	6	3	j	int
    //   49	45	4	localObject1	Object
    //   19	35	5	localObject2	Object
    //   32	14	6	arrayOfb	c.b[]
    //   65	21	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   51	58	65	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.e.a
 * JD-Core Version:    0.7.0.1
 */