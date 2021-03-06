package com.tencent.qqmusic.mediaplayer.downstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.RandomAccessFile;

public class FileDataSink
  implements IDataSink
{
  private static final String TAG = "FileDataSink";
  private long currentPosition = 0L;
  private final String filePath;
  private boolean opened = false;
  private RandomAccessFile randomAccessFile = null;
  
  public FileDataSink(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void close()
  {
    AppMethodBeat.i(76590);
    if (!this.opened)
    {
      AppMethodBeat.o(76590);
      return;
    }
    this.randomAccessFile.close();
    this.currentPosition = 0L;
    AppMethodBeat.o(76590);
  }
  
  public void open()
  {
    AppMethodBeat.i(76588);
    if (this.opened)
    {
      AppMethodBeat.o(76588);
      return;
    }
    this.randomAccessFile = new RandomAccessFile(this.filePath, "rw");
    this.currentPosition = 0L;
    this.opened = true;
    AppMethodBeat.o(76588);
  }
  
  public int write(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76589);
    if (this.randomAccessFile != null)
    {
      if (this.currentPosition != paramLong)
      {
        Logger.d("FileDataSink", "[write] seek to: ".concat(String.valueOf(paramLong)));
        this.randomAccessFile.seek(paramLong);
        this.currentPosition = paramLong;
      }
      this.randomAccessFile.write(paramArrayOfByte, paramInt1, paramInt2);
      this.currentPosition += paramInt2;
      AppMethodBeat.o(76589);
      return paramInt2;
    }
    AppMethodBeat.o(76589);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.downstream.FileDataSink
 * JD-Core Version:    0.7.0.1
 */