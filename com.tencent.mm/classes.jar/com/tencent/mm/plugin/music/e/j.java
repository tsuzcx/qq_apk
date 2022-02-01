package com.tencent.mm.plugin.music.e;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
  implements b
{
  public AudioTrack ak(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137283);
    AudioTrack localAudioTrack = new AudioTrack(3, paramInt1, paramInt2, 2, paramInt3, 1);
    AppMethodBeat.o(137283);
    return localAudioTrack;
  }
  
  public MediaPlayer cUU()
  {
    AppMethodBeat.i(137282);
    MediaPlayer localMediaPlayer = new MediaPlayer();
    AppMethodBeat.o(137282);
    return localMediaPlayer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.j
 * JD-Core Version:    0.7.0.1
 */