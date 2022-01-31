package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class l
  extends FilterInputStream
{
  private long auV = 0L;
  
  public l(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(51984);
    try
    {
      this.auV = ((FileInputStream)this.in).getChannel().position();
      AppMethodBeat.o(51984);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
      AppMethodBeat.o(51984);
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(51985);
    ((FileInputStream)this.in).getChannel().position(this.auV);
    AppMethodBeat.o(51985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.l
 * JD-Core Version:    0.7.0.1
 */