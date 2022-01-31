package com.tencent.mm.sdk.platformtools;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class i
  extends FilterInputStream
{
  private long asE = 0L;
  
  public i(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      this.asE = ((FileInputStream)this.in).getChannel().position();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void reset()
  {
    ((FileInputStream)this.in).getChannel().position(this.asE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * JD-Core Version:    0.7.0.1
 */