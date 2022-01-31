package com.tencent.rtmp.sharp.jni;

import java.util.HashMap;

class TraeAudioManager$f$1
  implements TraeMediaPlayer.a
{
  TraeAudioManager$f$1(TraeAudioManager.f paramf) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + this.a.p._activeMode + " _preRingMode:" + this.a.k);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(true));
    this.a.a(32783, localHashMap);
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f.1
 * JD-Core Version:    0.7.0.1
 */