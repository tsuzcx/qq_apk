package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import java.util.Map;

public class StreamingRequest
{
  public final Map<String, String> headers;
  public final Uri uri;
  
  public StreamingRequest(Uri paramUri, Map<String, String> paramMap)
  {
    this.uri = paramUri;
    this.headers = paramMap;
  }
  
  public String toString()
  {
    return "StreamingRequest{uri='" + this.uri + '\'' + ", headers=" + this.headers + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.StreamingRequest
 * JD-Core Version:    0.7.0.1
 */