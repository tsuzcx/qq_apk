package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;

final class CacheDataSource$Factory$1
  extends FileDataSource
{
  CacheDataSource$Factory$1(String paramString, File paramFile)
  {
    super(paramString);
  }
  
  public final void close()
  {
    AppMethodBeat.i(104582);
    try
    {
      super.close();
      label9:
      if (!this.val$bufferFile.delete()) {
        Logger.w("CacheDataSource", "failed to delete buffer file: " + this.val$bufferFile);
      }
      AppMethodBeat.o(104582);
      return;
    }
    catch (IOException localIOException)
    {
      break label9;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.1
 * JD-Core Version:    0.7.0.1
 */