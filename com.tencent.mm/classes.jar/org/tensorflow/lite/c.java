package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements AutoCloseable
{
  public NativeInterpreterWrapper ajZm;
  
  public c(ByteBuffer paramByteBuffer)
  {
    this(paramByteBuffer, (byte)0);
  }
  
  private c(ByteBuffer paramByteBuffer, byte paramByte)
  {
    AppMethodBeat.i(187247);
    this.ajZm = new NativeInterpreterWrapper(paramByteBuffer);
    AppMethodBeat.o(187247);
  }
  
  public final void close()
  {
    AppMethodBeat.i(187254);
    if (this.ajZm != null)
    {
      this.ajZm.close();
      this.ajZm = null;
    }
    AppMethodBeat.o(187254);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(187262);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(187262);
    }
  }
  
  public final void kcl()
  {
    AppMethodBeat.i(187267);
    if (this.ajZm == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Internal error: The Interpreter has already been closed.");
      AppMethodBeat.o(187267);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(187267);
  }
  
  public static final class a
  {
    final List<b> aiIp;
    Boolean ajZn;
    Boolean ajZo;
    Boolean ajZp;
    Boolean ajZq;
    Boolean ajZr;
    int numThreads;
    
    public a()
    {
      AppMethodBeat.i(187237);
      this.numThreads = -1;
      this.aiIp = new ArrayList();
      AppMethodBeat.o(187237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.tensorflow.lite.c
 * JD-Core Version:    0.7.0.1
 */