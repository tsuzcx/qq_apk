package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Looper;
import java.io.File;

final class CacheDataSource$Factory$2
  implements Loader.Factory
{
  CacheDataSource$Factory$2(UriLoader paramUriLoader, File paramFile) {}
  
  public final Loader createLoader(Loader.Listener paramListener)
  {
    return new CacheDataSource.Factory.2.1(this, Looper.getMainLooper(), this.val$uriLoader, paramListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.2
 * JD-Core Version:    0.7.0.1
 */