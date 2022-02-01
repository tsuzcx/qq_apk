package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements AutoCloseable
{
  public NativeInterpreterWrapper abMs;
  
  public c(ByteBuffer paramByteBuffer)
  {
    this(paramByteBuffer, (byte)0);
  }
  
  private c(ByteBuffer paramByteBuffer, byte paramByte)
  {
    AppMethodBeat.i(239985);
    this.abMs = new NativeInterpreterWrapper(paramByteBuffer);
    AppMethodBeat.o(239985);
  }
  
  public final void close()
  {
    AppMethodBeat.i(239987);
    if (this.abMs != null)
    {
      this.abMs.close();
      this.abMs = null;
    }
    AppMethodBeat.o(239987);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(239989);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(239989);
    }
  }
  
  public final void isP()
  {
    AppMethodBeat.i(239990);
    if (this.abMs == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Internal error: The Interpreter has already been closed.");
      AppMethodBeat.o(239990);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(239990);
  }
  
  public static final class a
  {
    final List<b> aaLF;
    int abMt;
    Boolean abMu;
    Boolean abMv;
    Boolean abMw;
    Boolean abMx;
    Boolean abMy;
    
    public a()
    {
      AppMethodBeat.i(239126);
      this.abMt = -1;
      this.aaLF = new ArrayList();
      AppMethodBeat.o(239126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.tensorflow.lite.c
 * JD-Core Version:    0.7.0.1
 */