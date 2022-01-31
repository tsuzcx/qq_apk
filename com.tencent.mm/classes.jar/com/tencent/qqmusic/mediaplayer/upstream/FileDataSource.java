package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.StreamUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileDataSource
  implements IDataSource
{
  private long currentPosition;
  private File file;
  private FileInputStream fileInputStream;
  private final String filePath;
  private boolean opened = false;
  private BufferedInputStream readingStream;
  
  public FileDataSource(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void close()
  {
    if (!this.opened) {
      return;
    }
    if (this.fileInputStream != null) {
      this.fileInputStream.close();
    }
    if (this.readingStream != null) {
      this.readingStream.close();
    }
    this.opened = false;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return AudioRecognition.recognitionAudioFormatExactly(this.filePath);
  }
  
  public long getSize()
  {
    return this.file.length();
  }
  
  public void open()
  {
    if (this.opened) {
      return;
    }
    this.opened = true;
    this.file = new File(this.filePath);
    this.fileInputStream = new FileInputStream(this.filePath);
    this.readingStream = new BufferedInputStream(this.fileInputStream);
    this.currentPosition = 0L;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l;
    if (this.currentPosition != paramLong) {
      if (this.currentPosition > paramLong)
      {
        this.readingStream.close();
        this.fileInputStream.close();
        this.fileInputStream = new FileInputStream(this.filePath);
        this.readingStream = new BufferedInputStream(this.fileInputStream);
        l = StreamUtils.skipForBufferStream(this.readingStream, paramLong);
        if (l == paramLong) {
          break label108;
        }
        paramInt1 = -1;
      }
    }
    label108:
    do
    {
      return paramInt1;
      l = this.currentPosition + StreamUtils.skipForBufferStream(this.readingStream, paramLong - this.currentPosition);
      break;
      this.currentPosition = paramLong;
      paramInt2 = this.readingStream.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 < 0);
    this.currentPosition += paramInt2;
    return paramInt2;
  }
  
  public String toString()
  {
    return "(fd)" + this.filePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.FileDataSource
 * JD-Core Version:    0.7.0.1
 */