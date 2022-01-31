package com.tencent.mm.plugin.music.g;

import com.tencent.mm.af.e;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class a
  implements IDataSource
{
  public e eaV;
  
  public a(e parame)
  {
    this.eaV = parame;
  }
  
  public final void close()
  {
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
    if (this.eaV != null) {
      this.eaV.close();
    }
  }
  
  public final AudioFormat.AudioType getAudioType()
  {
    if (this.eaV == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
      return AudioFormat.AudioType.UNSUPPORT;
    }
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.eaV.JP());
    switch (this.eaV.JP())
    {
    default: 
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
      return AudioFormat.AudioType.UNSUPPORT;
    case 0: 
      return AudioFormat.AudioType.UNSUPPORT;
    case 1: 
      return AudioFormat.AudioType.AAC;
    case 2: 
      return AudioFormat.AudioType.MP3;
    case 3: 
      return AudioFormat.AudioType.WAV;
    }
    return AudioFormat.AudioType.OGG;
  }
  
  public final long getSize()
  {
    if (this.eaV != null) {
      return this.eaV.getSize();
    }
    return 0L;
  }
  
  public final void open()
  {
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "open");
    if (this.eaV != null) {
      this.eaV.open();
    }
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eaV == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
      return -1;
    }
    return this.eaV.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a
 * JD-Core Version:    0.7.0.1
 */