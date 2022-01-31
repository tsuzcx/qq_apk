package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import java.io.IOException;

public class SourceReadException
  extends Exception
{
  private final Uri source;
  
  public SourceReadException(IOException paramIOException, Uri paramUri)
  {
    super(paramIOException);
    this.source = paramUri;
  }
  
  public SourceReadException(String paramString, Uri paramUri)
  {
    super(paramString);
    this.source = paramUri;
  }
  
  public Uri getSource()
  {
    return this.source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.SourceReadException
 * JD-Core Version:    0.7.0.1
 */