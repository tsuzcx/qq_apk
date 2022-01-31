package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TraeAudioManager$f$3
  implements AudioManager.OnAudioFocusChangeListener
{
  TraeAudioManager$f$3(TraeAudioManager.f paramf) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    AppMethodBeat.i(65653);
    a.dUd();
    a.iP("TRAE", "focusChange:" + paramInt + " _focusSteamType:" + this.a.o + " currMode:" + this.a.p._am.getMode() + " _activeMode:" + this.a.p._activeMode);
    AppMethodBeat.o(65653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f.3
 * JD-Core Version:    0.7.0.1
 */