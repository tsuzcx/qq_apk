package com.tencent.rtmp.sharp.jni;

import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

class TraeAudioManager$f$1
  implements TraeMediaPlayer.a
{
  TraeAudioManager$f$1(TraeAudioManager.f paramf) {}
  
  public void a()
  {
    AppMethodBeat.i(65660);
    a.dUd();
    a.iP("TRAE", "_ringPlayer onCompletion _activeMode:" + this.a.p._activeMode + " _preRingMode:" + this.a.k);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.TRUE);
    this.a.a(32783, localHashMap);
    this.a.k();
    AppMethodBeat.o(65660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f.1
 * JD-Core Version:    0.7.0.1
 */