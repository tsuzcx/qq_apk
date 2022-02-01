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
    AppMethodBeat.i(230331);
    int i = this.buffer.capacity();
    AppMethodBeat.o(230331);
    return i;
  }
  
  public int getOffset()
  {
    AppMethodBeat.i(230330);
    int i = this.buffer.position();
    AppMethodBeat.o(230330);
    return i;
  }
  
  public void setBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230329);
    int i = paramArrayOfByte.length;
    this.buffer = ByteBuffer.allocateDirect(i);
    this.buffer.position(0);
    this.buffer.put(paramArrayOfByte, 0, i);
    this.buffer.position(0);
    AppMethodBeat.o(230329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MBuf
 * JD-Core Version:    0.7.0.1
 */