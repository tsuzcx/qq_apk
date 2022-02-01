package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class a
  implements r
{
  protected int memoizedHashCode = 0;
  
  public final void writeDelimitedTo(OutputStream paramOutputStream)
  {
    int i = 4096;
    int k = getSerializedSize();
    int j = f.kv(k) + k;
    if (j > 4096) {}
    for (;;)
    {
      paramOutputStream = f.i(paramOutputStream, i);
      paramOutputStream.lI(k);
      a(paramOutputStream);
      paramOutputStream.flush();
      return;
      i = j;
    }
  }
  
  public static abstract class a<BuilderType extends a>
    implements r.a
  {
    public abstract BuilderType c(e parame, g paramg);
    
    public abstract BuilderType ktr();
    
    static final class a
      extends FilterInputStream
    {
      private int limit;
      
      a(InputStream paramInputStream, int paramInt)
      {
        super();
        this.limit = paramInt;
      }
      
      public final int available()
      {
        AppMethodBeat.i(59357);
        int i = Math.min(super.available(), this.limit);
        AppMethodBeat.o(59357);
        return i;
      }
      
      public final int read()
      {
        AppMethodBeat.i(59358);
        if (this.limit <= 0)
        {
          AppMethodBeat.o(59358);
          return -1;
        }
        int i = super.read();
        if (i >= 0) {
          this.limit -= 1;
        }
        AppMethodBeat.o(59358);
        return i;
      }
      
      public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(59359);
        if (this.limit <= 0)
        {
          AppMethodBeat.o(59359);
          return -1;
        }
        paramInt1 = super.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.limit));
        if (paramInt1 >= 0) {
          this.limit -= paramInt1;
        }
        AppMethodBeat.o(59359);
        return paramInt1;
      }
      
      public final long skip(long paramLong)
      {
        AppMethodBeat.i(59360);
        paramLong = super.skip(Math.min(paramLong, this.limit));
        if (paramLong >= 0L) {
          this.limit = ((int)(this.limit - paramLong));
        }
        AppMethodBeat.o(59360);
        return paramLong;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.a
 * JD-Core Version:    0.7.0.1
 */