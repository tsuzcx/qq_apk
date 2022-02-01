package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(87751);
    String str = "StreamingRequest{uri='" + this.uri + '\'' + ", headers=" + this.headers + '}';
    AppMethodBeat.o(87751);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.StreamingRequest
 * JD-Core Version:    0.7.0.1
 */