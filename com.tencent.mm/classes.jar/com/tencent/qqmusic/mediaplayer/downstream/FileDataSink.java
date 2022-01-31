package com.tencent.qqmusic.mediaplayer.downstream;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.RandomAccessFile;

public class FileDataSink
  implements IDataSink
{
  private static final String TAG = "FileDataSink";
  private long currentPosition;
  private String filePath;
  private boolean opened;
  private RandomAccessFile randomAccessFile;
  
  public FileDataSink(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void close()
  {
    if (!this.opened) {
      return;
    }
    this.randomAccessFile.close();
    this.currentPosition = 0L;
  }
  
  public void open()
  {
    if (this.opened) {
      return;
    }
    this.randomAccessFile = new RandomAccessFile(this.filePath, "rw");
    this.currentPosition = 0L;
    this.opened = true;
  }
  
  public int write(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.currentPosition != paramLong)
    {
      Logger.d("FileDataSink", "[write] seek to: " + paramLong);
      this.randomAccessFile.seek(paramLong);
      this.currentPosition = paramLong;
    }
    this.randomAccessFile.write(paramArrayOfByte, paramInt1, paramInt2);
    this.currentPosition += paramInt2;
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.downstream.FileDataSink
 * JD-Core Version:    0.7.0.1
 */