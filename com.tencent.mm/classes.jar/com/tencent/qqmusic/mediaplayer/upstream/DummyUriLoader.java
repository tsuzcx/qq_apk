package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(76496);
    if (this.uri == null)
    {
      paramCallback.onSucceed(null);
      AppMethodBeat.o(76496);
      return;
    }
    paramCallback.onSucceed(new StreamingRequest(this.uri, null));
    AppMethodBeat.o(76496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DummyUriLoader
 * JD-Core Version:    0.7.0.1
 */