package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class o
  extends FilterInputStream
{
  private long bbz = 0L;
  
  public o(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(157537);
    try
    {
      this.bbz = ((FileInputStream)this.in).getChannel().position();
      AppMethodBeat.o(157537);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
      AppMethodBeat.o(157537);
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(157538);
    ((FileInputStream)this.in).getChannel().position(this.bbz);
    AppMethodBeat.o(157538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.o
 * JD-Core Version:    0.7.0.1
 */