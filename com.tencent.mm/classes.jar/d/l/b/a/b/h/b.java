package d.l.b.a.b.h;

import java.io.IOException;
import java.io.InputStream;

public abstract class b<MessageType extends q>
  implements s<MessageType>
{
  private static final g NqE = ;
  
  /* Error */
  private MessageType a(d paramd, g paramg)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 33	d/l/b/a/b/h/d:grq	()Ld/l/b/a/b/h/e;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 36	d/l/b/a/b/h/b:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/g;)Ljava/lang/Object;
    //   11: checkcast 38	d/l/b/a/b/h/q
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 44	d/l/b/a/b/h/e:fE	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: putfield 48	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	b
    //   0	33	1	paramd	d
    //   0	33	2	paramg	g
    // Exception table:
    //   from	to	target	type
    //   15	20	22	d/l/b/a/b/h/k
    //   0	15	30	d/l/b/a/b/h/k
    //   23	30	30	d/l/b/a/b/h/k
  }
  
  private static MessageType a(MessageType paramMessageType)
  {
    if ((paramMessageType != null) && (!paramMessageType.isInitialized()))
    {
      if ((paramMessageType instanceof a)) {}
      for (Object localObject = new w();; localObject = new w())
      {
        localObject = new k(((w)localObject).getMessage());
        ((k)localObject).Nrq = paramMessageType;
        throw ((Throwable)localObject);
      }
    }
    return paramMessageType;
  }
  
  private MessageType g(InputStream paramInputStream, g paramg)
  {
    paramInputStream = e.Y(paramInputStream);
    paramg = (q)a(paramInputStream, paramg);
    try
    {
      paramInputStream.fE(0);
      return paramg;
    }
    catch (k paramInputStream)
    {
      paramInputStream.Nrq = paramg;
      throw paramInputStream;
    }
  }
  
  private MessageType h(InputStream paramInputStream, g paramg)
  {
    for (;;)
    {
      int j;
      int m;
      try
      {
        i = paramInputStream.read();
        if (i == -1) {
          return null;
        }
        if ((i & 0x80) == 0) {
          return g(new a.a.a(paramInputStream, i), paramg);
        }
        i &= 0x7F;
        j = 7;
        k = j;
        if (j >= 32) {
          break label128;
        }
        m = paramInputStream.read();
        if (m == -1) {
          throw k.grP();
        }
      }
      catch (IOException paramInputStream)
      {
        throw new k(paramInputStream.getMessage());
      }
      int k = i | (m & 0x7F) << j;
      int i = k;
      if ((m & 0x80) != 0)
      {
        j += 7;
        i = k;
        continue;
        label128:
        do
        {
          k += 7;
          if (k < 64)
          {
            j = paramInputStream.read();
            if (j == -1) {
              throw k.grP();
            }
          }
          else
          {
            throw k.grR();
          }
        } while ((j & 0x80) != 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.b
 * JD-Core Version:    0.7.0.1
 */