package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

final class c
  extends p
{
  final int NNL;
  private final int NNM;
  
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
    this.NNL = paramInt1;
    this.NNM = paramInt2;
    AppMethodBeat.o(59365);
  }
  
  public final byte alG(int paramInt)
  {
    AppMethodBeat.i(59366);
    ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException;
    if (paramInt < 0)
    {
      localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(28 + "Index too small: " + paramInt);
      AppMethodBeat.o(59366);
      throw localArrayIndexOutOfBoundsException;
    }
    if (paramInt >= this.NNM)
    {
      int i = this.NNM;
      localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(41 + "Index too large: " + paramInt + ", " + i);
      AppMethodBeat.o(59366);
      throw localArrayIndexOutOfBoundsException;
    }
    byte b = this.zr[(this.NNL + paramInt)];
    AppMethodBeat.o(59366);
    return b;
  }
  
  protected final int gvP()
  {
    return this.NNL;
  }
  
  public final d.a gvQ()
  {
    AppMethodBeat.i(59368);
    a locala = new a((byte)0);
    AppMethodBeat.o(59368);
    return locala;
  }
  
  protected final void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59367);
    System.arraycopy(this.zr, this.NNL + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(59367);
  }
  
  public final int size()
  {
    return this.NNM;
  }
  
  final class a
    implements d.a
  {
    private final int limit;
    private int position;
    
    private a()
    {
      AppMethodBeat.i(59361);
      this.position = c.this.NNL;
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
      Object localObject = c.this.zr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.h.c
 * JD-Core Version:    0.7.0.1
 */