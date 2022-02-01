package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;

public final class b
  implements IDataSourceFactory
{
  public e gTb;
  
  public b(e parame)
  {
    this.gTb = parame;
  }
  
  public final IDataSource createDataSource()
  {
    AppMethodBeat.i(137426);
    a locala = new a(this.gTb);
    AppMethodBeat.o(137426);
    return locala;
  }
  
  public final INativeDataSource createNativeDataSource()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.b
 * JD-Core Version:    0.7.0.1
 */