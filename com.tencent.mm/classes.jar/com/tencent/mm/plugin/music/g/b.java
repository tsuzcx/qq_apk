package com.tencent.mm.plugin.music.g;

import com.tencent.mm.af.e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;

public final class b
  implements IDataSourceFactory
{
  public e eaV;
  
  public b(e parame)
  {
    this.eaV = parame;
  }
  
  public final IDataSource createDataSource()
  {
    return new a(this.eaV);
  }
  
  public final INativeDataSource createNativeDataSource()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.b
 * JD-Core Version:    0.7.0.1
 */