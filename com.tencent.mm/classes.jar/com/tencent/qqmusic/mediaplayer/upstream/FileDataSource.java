package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.StreamUtils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class FileDataSource
  implements IDataSource
{
  private long currentPosition;
  private RandomAccessFile file;
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
    AppMethodBeat.i(114294);
    if (!this.opened)
    {
      AppMethodBeat.o(114294);
      return;
    }
    if (this.fileInputStream != null) {
      this.fileInputStream.close();
    }
    if (this.readingStream != null) {
      this.readingStream.close();
    }
    if (this.file != null) {
      this.file.close();
    }
    this.opened = false;
    AppMethodBeat.o(114294);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(114293);
    AudioFormat.AudioType localAudioType = AudioRecognition.recognitionAudioFormatExactly(this.filePath);
    AppMethodBeat.o(114293);
    return localAudioType;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public long getSize()
  {
    AppMethodBeat.i(114292);
    long l = this.file.length();
    AppMethodBeat.o(114292);
    return l;
  }
  
  public void open()
  {
    AppMethodBeat.i(114290);
    if (this.opened)
    {
      AppMethodBeat.o(114290);
      return;
    }
    this.opened = true;
    this.file = new RandomAccessFile(this.filePath, "r");
    this.fileInputStream = new FileInputStream(this.file.getFD());
    this.readingStream = new BufferedInputStream(this.fileInputStream);
    this.currentPosition = 0L;
    AppMethodBeat.o(114290);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114291);
    if (this.currentPosition != paramLong)
    {
      if (this.currentPosition > paramLong)
      {
        this.file.seek(paramLong);
        this.readingStream = new BufferedInputStream(this.fileInputStream);
      }
      for (long l = paramLong; l != paramLong; l = this.currentPosition + StreamUtils.skipForBufferStream(this.readingStream, paramLong - this.currentPosition))
      {
        AppMethodBeat.o(114291);
        return -1;
      }
      this.currentPosition = paramLong;
    }
    paramInt1 = this.readingStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    AppMethodBeat.o(114291);
    return paramInt1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114295);
    String str = "(fd)" + this.filePath;
    AppMethodBeat.o(114295);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.FileDataSource
 * JD-Core Version:    0.7.0.1
 */