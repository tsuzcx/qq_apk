package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;

public final class b
  implements IDataSourceFactory
{
  public e fri;
  
  public b(e parame)
  {
    this.fri = parame;
  }
  
  public final IDataSource createDataSource()
  {
    AppMethodBeat.i(137674);
    a locala = new a(this.fri);
    AppMethodBeat.o(137674);
    return locala;
  }
  
  public final INativeDataSource createNativeDataSource()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.b
 * JD-Core Version:    0.7.0.1
 */