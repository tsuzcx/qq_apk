package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public class SinkWriteException
  extends Exception
{
  public SinkWriteException(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public SinkWriteException(String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.SinkWriteException
 * JD-Core Version:    0.7.0.1
 */