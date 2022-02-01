package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class n
  extends FilterInputStream
{
  private long aQo = 0L;
  
  public n(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(157537);
    try
    {
      this.aQo = ((FileInputStream)this.in).getChannel().position();
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
    ((FileInputStream)this.in).getChannel().position(this.aQo);
    AppMethodBeat.o(157538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.n
 * JD-Core Version:    0.7.0.1
 */