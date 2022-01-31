package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(128359);
    if (!this.opened)
    {
      AppMethodBeat.o(128359);
      return;
    }
    if (this.fileInputStream != null) {
      this.fileInputStream.close();
    }
    if (this.readingStream != null) {
      this.readingStream.close();
    }
    this.opened = false;
    AppMethodBeat.o(128359);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(128358);
    AudioFormat.AudioType localAudioType = AudioRecognition.recognitionAudioFormatExactly(this.filePath);
    AppMethodBeat.o(128358);
    return localAudioType;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public long getSize()
  {
    AppMethodBeat.i(128357);
    long l = this.file.length();
    AppMethodBeat.o(128357);
    return l;
  }
  
  public void open()
  {
    AppMethodBeat.i(128355);
    if (this.opened)
    {
      AppMethodBeat.o(128355);
      return;
    }
    this.opened = true;
    this.file = new File(this.filePath);
    this.fileInputStream = new FileInputStream(this.filePath);
    this.readingStream = new BufferedInputStream(this.fileInputStream);
    this.currentPosition = 0L;
    AppMethodBeat.o(128355);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(128356);
    if (this.currentPosition != paramLong)
    {
      if (this.currentPosition > paramLong)
      {
        this.readingStream.close();
        this.fileInputStream.close();
        this.fileInputStream = new FileInputStream(this.filePath);
        this.readingStream = new BufferedInputStream(this.fileInputStream);
      }
      for (long l = StreamUtils.skipForBufferStream(this.readingStream, paramLong); l != paramLong; l = this.currentPosition + StreamUtils.skipForBufferStream(this.readingStream, paramLong - this.currentPosition))
      {
        AppMethodBeat.o(128356);
        return -1;
      }
      this.currentPosition = paramLong;
    }
    paramInt1 = this.readingStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    AppMethodBeat.o(128356);
    return paramInt1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(128360);
    String str = "(fd)" + this.filePath;
    AppMethodBeat.o(128360);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.FileDataSource
 * JD-Core Version:    0.7.0.1
 */