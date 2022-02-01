package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.nio.ByteBuffer;

public final class c
  implements IDataSourceFactory
{
  public ByteBuffer buffer;
  public e orw;
  
  public c(e parame)
  {
    this.orw = parame;
  }
  
  public c(ByteBuffer paramByteBuffer)
  {
    this.buffer = paramByteBuffer;
  }
  
  public final IDataSource createDataSource()
  {
    AppMethodBeat.i(137426);
    if (this.buffer != null)
    {
      localObject = new a(this.buffer);
      AppMethodBeat.o(137426);
      return localObject;
    }
    Object localObject = new b(this.orw);
    AppMethodBeat.o(137426);
    return localObject;
  }
  
  public final INativeDataSource createNativeDataSource()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.c
 * JD-Core Version:    0.7.0.1
 */