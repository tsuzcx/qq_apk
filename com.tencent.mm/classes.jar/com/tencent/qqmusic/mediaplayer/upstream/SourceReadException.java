package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public class SourceReadException
  extends Exception
{
  private final String source;
  
  public SourceReadException(IOException paramIOException, String paramString)
  {
    super(paramIOException);
    this.source = paramString;
  }
  
  public SourceReadException(String paramString1, String paramString2)
  {
    super(paramString1);
    this.source = paramString2;
  }
  
  public String getSource()
  {
    return this.source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.SourceReadException
 * JD-Core Version:    0.7.0.1
 */