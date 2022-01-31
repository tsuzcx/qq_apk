package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class a
  implements IDataSource
{
  public e fri;
  
  public a(e parame)
  {
    this.fri = parame;
  }
  
  public final void close()
  {
    AppMethodBeat.i(137673);
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
    if (this.fri != null) {
      this.fri.close();
    }
    AppMethodBeat.o(137673);
  }
  
  public final AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(137672);
    if (this.fri == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
      localAudioType = AudioFormat.AudioType.UNSUPPORT;
      AppMethodBeat.o(137672);
      return localAudioType;
    }
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.fri.acP());
    switch (this.fri.acP())
    {
    default: 
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
      localAudioType = AudioFormat.AudioType.UNSUPPORT;
      AppMethodBeat.o(137672);
      return localAudioType;
    case 0: 
      localAudioType = AudioFormat.AudioType.UNSUPPORT;
      AppMethodBeat.o(137672);
      return localAudioType;
    case 1: 
      localAudioType = AudioFormat.AudioType.AAC;
      AppMethodBeat.o(137672);
      return localAudioType;
    case 2: 
      localAudioType = AudioFormat.AudioType.MP3;
      AppMethodBeat.o(137672);
      return localAudioType;
    case 3: 
      localAudioType = AudioFormat.AudioType.WAV;
      AppMethodBeat.o(137672);
      return localAudioType;
    }
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.OGG;
    AppMethodBeat.o(137672);
    return localAudioType;
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(137671);
    if (this.fri != null)
    {
      long l = this.fri.getSize();
      AppMethodBeat.o(137671);
      return l;
    }
    AppMethodBeat.o(137671);
    return 0L;
  }
  
  public final void open()
  {
    AppMethodBeat.i(137669);
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "open");
    if (this.fri != null) {
      this.fri.open();
    }
    AppMethodBeat.o(137669);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137670);
    if (this.fri == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
      AppMethodBeat.o(137670);
      return -1;
    }
    paramInt1 = this.fri.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(137670);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a
 * JD-Core Version:    0.7.0.1
 */