package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

final class c
  extends q
{
  final int dIO;
  private final int dIP;
  
  c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    AppMethodBeat.i(59365);
    if (paramInt1 < 0)
    {
      paramArrayOfByte = new IllegalArgumentException(29 + "Offset too small: " + paramInt1);
      AppMethodBeat.o(59365);
      throw paramArrayOfByte;
    }
    if (paramInt2 < 0)
    {
      paramArrayOfByte = new IllegalArgumentException(29 + "Length too small: " + paramInt1);
      AppMethodBeat.o(59365);
      throw paramArrayOfByte;
    }
    if (paramInt1 + paramInt2 > paramArrayOfByte.length)
    {
      paramArrayOfByte = new IllegalArgumentException(48 + "Offset+Length too large: " + paramInt1 + "+" + paramInt2);
      AppMethodBeat.o(59365);
      throw paramArrayOfByte;
    }
    this.dIO = paramInt1;
    this.dIP = paramInt2;
    AppMethodBeat.o(59365);
  }
  
  protected final int aaa()
  {
    return this.dIO;
  }
  
  protected final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59367);
    System.arraycopy(this.Op, this.dIO + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(59367);
  }
  
  public final d.a kxZ()
  {
    AppMethodBeat.i(59368);
    a locala = new a((byte)0);
    AppMethodBeat.o(59368);
    return locala;
  }
  
  public final int size()
  {
    return this.dIP;
  }
  
  final class a
    implements d.a
  {
    private final int limit;
    private int position;
    
    private a()
    {
      AppMethodBeat.i(59361);
      this.position = c.this.dIO;
      this.limit = (this.position + c.this.size());
      AppMethodBeat.o(59361);
    }
    
    public final boolean hasNext()
    {
      return this.position < this.limit;
    }
    
    public final byte nextByte()
    {
      AppMethodBeat.i(59362);
      if (this.position >= this.limit)
      {
        localObject = new NoSuchElementException();
        AppMethodBeat.o(59362);
        throw ((Throwable)localObject);
      }
      Object localObject = c.this.Op;
      int i = this.position;
      this.position = (i + 1);
      byte b = localObject[i];
      AppMethodBeat.o(59362);
      return b;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(59363);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(59363);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.c
 * JD-Core Version:    0.7.0.1
 */