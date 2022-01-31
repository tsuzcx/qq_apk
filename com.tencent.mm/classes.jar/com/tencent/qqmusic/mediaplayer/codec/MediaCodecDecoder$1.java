package com.tencent.qqmusic.mediaplayer.codec;

import android.media.MediaDataSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

class MediaCodecDecoder$1
  extends MediaDataSource
{
  MediaCodecDecoder$1(MediaCodecDecoder paramMediaCodecDecoder, IDataSource paramIDataSource) {}
  
  public void close()
  {
    AppMethodBeat.i(128551);
    this.val$dataSource.close();
    AppMethodBeat.o(128551);
  }
  
  public long getSize()
  {
    AppMethodBeat.i(128550);
    long l = this.val$dataSource.getSize();
    AppMethodBeat.o(128550);
    return l;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(128549);
    paramInt1 = this.val$dataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(128549);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder.1
 * JD-Core Version:    0.7.0.1
 */