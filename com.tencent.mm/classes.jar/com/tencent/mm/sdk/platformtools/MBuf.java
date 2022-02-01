package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

class MBuf
{
  private ByteBuffer buffer = null;
  
  public ByteBuffer getBuffer()
  {
    return this.buffer;
  }
  
  public int getLen()
  {
    AppMethodBeat.i(243394);
    int i = this.buffer.capacity();
    AppMethodBeat.o(243394);
    return i;
  }
  
  public int getOffset()
  {
    AppMethodBeat.i(243392);
    int i = this.buffer.position();
    AppMethodBeat.o(243392);
    return i;
  }
  
  public void setBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(243390);
    int i = paramArrayOfByte.length;
    this.buffer = ByteBuffer.allocateDirect(i);
    this.buffer.position(0);
    this.buffer.put(paramArrayOfByte, 0, i);
    this.buffer.position(0);
    AppMethodBeat.o(243390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MBuf
 * JD-Core Version:    0.7.0.1
 */