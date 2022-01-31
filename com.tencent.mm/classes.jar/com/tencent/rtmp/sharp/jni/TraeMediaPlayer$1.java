package com.tencent.rtmp.sharp.jni;

import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

class TraeMediaPlayer$1
  extends TimerTask
{
  TraeMediaPlayer$1(TraeMediaPlayer paramTraeMediaPlayer) {}
  
  public void run()
  {
    AppMethodBeat.i(65610);
    if (TraeMediaPlayer.access$000(this.a) != null)
    {
      a.dUd();
      a.iO("TRAE", "TraeMediaPlay | play timeout");
      if (TraeMediaPlayer.access$100(this.a) != null) {
        TraeMediaPlayer.access$100(this.a).a();
      }
    }
    AppMethodBeat.o(65610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */