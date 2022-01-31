package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class NativeSeekTable
  implements SeekTable
{
  private final BaseDecoder nativeDecoder;
  
  public NativeSeekTable(BaseDecoder paramBaseDecoder)
  {
    this.nativeDecoder = paramBaseDecoder;
  }
  
  public void parse(IDataSource paramIDataSource) {}
  
  public long seek(long paramLong)
  {
    AppMethodBeat.i(128507);
    paramLong = this.nativeDecoder.getBytePositionOfTime(paramLong);
    AppMethodBeat.o(128507);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable
 * JD-Core Version:    0.7.0.1
 */