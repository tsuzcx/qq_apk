package kotlin.l.b.a.b.h;

import java.io.IOException;
import java.io.InputStream;

public abstract class b<MessageType extends r>
  implements t<MessageType>
{
  private static final g ajeS = ;
  
  private static MessageType a(MessageType paramMessageType)
  {
    if ((paramMessageType != null) && (!paramMessageType.isInitialized()))
    {
      if ((paramMessageType instanceof a)) {}
      for (Object localObject = new x();; localObject = new x())
      {
        localObject = new l(((x)localObject).getMessage());
        ((l)localObject).ajfp = paramMessageType;
        throw ((Throwable)localObject);
      }
    }
    return paramMessageType;
  }
  
  private MessageType g(InputStream paramInputStream, g paramg)
  {
    paramInputStream = new e(paramInputStream);
    paramg = (r)a(paramInputStream, paramg);
    try
    {
      paramInputStream.jM(0);
      return paramg;
    }
    catch (l paramInputStream)
    {
      paramInputStream.ajfp = paramg;
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
          throw l.kyn();
        }
      }
      catch (IOException paramInputStream)
      {
        throw new l(paramInputStream.getMessage());
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
              throw l.kyn();
            }
          }
          else
          {
            throw l.kyp();
          }
        } while ((j & 0x80) != 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.b
 * JD-Core Version:    0.7.0.1
 */