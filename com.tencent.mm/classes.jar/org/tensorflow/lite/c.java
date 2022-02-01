package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements AutoCloseable
{
  public NativeInterpreterWrapper UiX;
  
  public c(ByteBuffer paramByteBuffer)
  {
    this(paramByteBuffer, (byte)0);
  }
  
  private c(ByteBuffer paramByteBuffer, byte paramByte)
  {
    AppMethodBeat.i(238965);
    this.UiX = new NativeInterpreterWrapper(paramByteBuffer);
    AppMethodBeat.o(238965);
  }
  
  public final void close()
  {
    AppMethodBeat.i(238966);
    if (this.UiX != null)
    {
      this.UiX.close();
      this.UiX = null;
    }
    AppMethodBeat.o(238966);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(238967);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(238967);
    }
  }
  
  public final void oa()
  {
    AppMethodBeat.i(238968);
    if (this.UiX == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Internal error: The Interpreter has already been closed.");
      AppMethodBeat.o(238968);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(238968);
  }
  
  public static final class a
  {
    final List<b> TiL;
    int UiY;
    Boolean UiZ;
    Boolean Uja;
    Boolean Ujb;
    Boolean Ujc;
    Boolean Ujd;
    
    public a()
    {
      AppMethodBeat.i(238964);
      this.UiY = -1;
      this.TiL = new ArrayList();
      AppMethodBeat.o(238964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.tensorflow.lite.c
 * JD-Core Version:    0.7.0.1
 */