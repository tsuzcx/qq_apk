package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public class FileSeekingInputStream
  extends FilterInputStream
{
  private long mMarkPosition = 0L;
  
  public FileSeekingInputStream(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public void mark(int paramInt)
  {
    AppMethodBeat.i(157537);
    try
    {
      this.mMarkPosition = ((FileInputStream)this.in).getChannel().position();
      AppMethodBeat.o(157537);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
      AppMethodBeat.o(157537);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void reset()
  {
    AppMethodBeat.i(157538);
    ((FileInputStream)this.in).getChannel().position(this.mMarkPosition);
    AppMethodBeat.o(157538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FileSeekingInputStream
 * JD-Core Version:    0.7.0.1
 */