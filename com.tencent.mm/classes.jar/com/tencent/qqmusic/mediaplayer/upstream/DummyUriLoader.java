package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import java.util.concurrent.TimeUnit;

public class DummyUriLoader
  implements UriLoader
{
  private final Uri uri;
  
  public DummyUriLoader()
  {
    this(null);
  }
  
  public DummyUriLoader(Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public void cancelLoading() {}
  
  public boolean isLoading()
  {
    return false;
  }
  
  public void startLoading(int paramInt, TimeUnit paramTimeUnit, UriLoader.Callback paramCallback)
  {
    if (this.uri == null)
    {
      paramCallback.onSucceed(null);
      return;
    }
    paramCallback.onSucceed(new StreamingRequest(this.uri, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DummyUriLoader
 * JD-Core Version:    0.7.0.1
 */