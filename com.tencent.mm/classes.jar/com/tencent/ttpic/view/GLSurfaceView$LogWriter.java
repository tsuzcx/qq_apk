package com.tencent.ttpic.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

class GLSurfaceView$LogWriter
  extends Writer
{
  private StringBuilder mBuilder;
  
  GLSurfaceView$LogWriter()
  {
    AppMethodBeat.i(84466);
    this.mBuilder = new StringBuilder();
    AppMethodBeat.o(84466);
  }
  
  private void flushBuilder()
  {
    AppMethodBeat.i(84470);
    if (this.mBuilder.length() > 0) {
      this.mBuilder.delete(0, this.mBuilder.length());
    }
    AppMethodBeat.o(84470);
  }
  
  public void close()
  {
    AppMethodBeat.i(84467);
    flushBuilder();
    AppMethodBeat.o(84467);
  }
  
  public void flush()
  {
    AppMethodBeat.i(84468);
    flushBuilder();
    AppMethodBeat.o(84468);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84469);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
      }
      for (;;)
      {
        i += 1;
        break;
        this.mBuilder.append(c);
      }
    }
    AppMethodBeat.o(84469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.view.GLSurfaceView.LogWriter
 * JD-Core Version:    0.7.0.1
 */