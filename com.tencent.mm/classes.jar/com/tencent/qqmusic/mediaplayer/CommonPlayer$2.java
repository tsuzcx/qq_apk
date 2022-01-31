package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;

class CommonPlayer$2
  implements IDataSourceFactory
{
  CommonPlayer$2(CommonPlayer paramCommonPlayer, UriLoader paramUriLoader) {}
  
  public IDataSource createDataSource()
  {
    AppMethodBeat.i(104712);
    CacheDataSource localCacheDataSource = CacheDataSource.Factory.createFromUriLoader(this.val$uriLoader);
    AppMethodBeat.o(104712);
    return localCacheDataSource;
  }
  
  public INativeDataSource createNativeDataSource()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.2
 * JD-Core Version:    0.7.0.1
 */