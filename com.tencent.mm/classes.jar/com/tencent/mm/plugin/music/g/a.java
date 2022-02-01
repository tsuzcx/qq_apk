package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.nio.ByteBuffer;

public final class a
  implements IDataSource
{
  private ByteBuffer byteBuffer;
  private long fileLength;
  private Object lock;
  
  public a(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(270830);
    this.lock = new Object();
    this.byteBuffer = paramByteBuffer;
    AppMethodBeat.o(270830);
  }
  
  public final void close()
  {
    synchronized (this.lock)
    {
      this.byteBuffer = null;
      return;
    }
  }
  
  public final AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(270841);
    if (this.byteBuffer == null)
    {
      localAudioType = AudioFormat.AudioType.UNSUPPORT;
      AppMethodBeat.o(270841);
      return localAudioType;
    }
    AudioFormat.AudioType localAudioType = FormatDetector.getAudioFormat(this, false);
    AppMethodBeat.o(270841);
    return localAudioType;
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(270838);
    synchronized (this.lock)
    {
      if (this.byteBuffer != null)
      {
        long l = this.byteBuffer.limit();
        AppMethodBeat.o(270838);
        return l;
      }
      AppMethodBeat.o(270838);
      return -1L;
    }
  }
  
  public final void open()
  {
    AppMethodBeat.i(270831);
    synchronized (this.lock)
    {
      if (this.byteBuffer != null) {
        this.byteBuffer.rewind();
      }
      AppMethodBeat.o(270831);
      return;
    }
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270836);
    if (this.byteBuffer == null)
    {
      Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "buffer is null");
      AppMethodBeat.o(270836);
      return -1;
    }
    if (getSize() <= 0L)
    {
      Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "getSize <= 0");
      AppMethodBeat.o(270836);
      return -1;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "bytes is null");
      AppMethodBeat.o(270836);
      return -1;
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(270836);
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(270836);
      return -1;
    }
    if (paramInt2 + paramLong > getSize()) {
      Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "position:%d, size:%d, getSize():%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Long.valueOf(getSize()) });
    }
    if (this.fileLength == 0L) {
      this.fileLength = getSize();
    }
    if ((this.fileLength > 0L) && (paramLong > this.fileLength) && (paramInt2 > 0))
    {
      AppMethodBeat.o(270836);
      return -1;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.byteBuffer != null)
        {
          this.byteBuffer.position((int)paramLong);
          if (!this.byteBuffer.hasRemaining())
          {
            Log.e("MicroMsg.Audio.InputStreamByteBufferDataSource", "no remaining");
            AppMethodBeat.o(270836);
            return -1;
          }
          paramInt2 = Math.min(paramInt2, this.byteBuffer.remaining());
          this.byteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
          paramInt1 = paramInt2;
          AppMethodBeat.o(270836);
          return paramInt1;
        }
      }
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a
 * JD-Core Version:    0.7.0.1
 */