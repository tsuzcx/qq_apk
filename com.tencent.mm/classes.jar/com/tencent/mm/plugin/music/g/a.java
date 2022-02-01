package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class a
  implements IDataSource
{
  public e hOL;
  
  public a(e parame)
  {
    this.hOL = parame;
  }
  
  public final void close()
  {
    AppMethodBeat.i(137425);
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
    if (this.hOL != null) {
      this.hOL.close();
    }
    AppMethodBeat.o(137425);
  }
  
  public final AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(137424);
    if (this.hOL == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
      localAudioType = AudioFormat.AudioType.UNSUPPORT;
      AppMethodBeat.o(137424);
      return localAudioType;
    }
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.hOL.aEz());
    switch (this.hOL.aEz())
    {
    default: 
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
      localAudioType = AudioFormat.AudioType.UNSUPPORT;
      AppMethodBeat.o(137424);
      return localAudioType;
    case 0: 
      localAudioType = AudioFormat.AudioType.UNSUPPORT;
      AppMethodBeat.o(137424);
      return localAudioType;
    case 1: 
      localAudioType = AudioFormat.AudioType.AAC;
      AppMethodBeat.o(137424);
      return localAudioType;
    case 2: 
      localAudioType = AudioFormat.AudioType.MP3;
      AppMethodBeat.o(137424);
      return localAudioType;
    case 3: 
      localAudioType = AudioFormat.AudioType.WAV;
      AppMethodBeat.o(137424);
      return localAudioType;
    }
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.OGG;
    AppMethodBeat.o(137424);
    return localAudioType;
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(137423);
    if (this.hOL != null)
    {
      long l = this.hOL.getSize();
      AppMethodBeat.o(137423);
      return l;
    }
    AppMethodBeat.o(137423);
    return 0L;
  }
  
  public final void open()
  {
    AppMethodBeat.i(137421);
    Logger.i("MicroMsg.Audio.InputStreamDataSource", "open");
    if (this.hOL != null) {
      this.hOL.open();
    }
    AppMethodBeat.o(137421);
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137422);
    if (this.hOL == null)
    {
      Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
      AppMethodBeat.o(137422);
      return -1;
    }
    paramInt1 = this.hOL.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(137422);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.g.a
 * JD-Core Version:    0.7.0.1
 */