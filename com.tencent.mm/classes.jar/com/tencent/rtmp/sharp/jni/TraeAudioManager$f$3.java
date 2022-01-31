package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

class TraeAudioManager$f$3
  implements AudioManager.OnAudioFocusChangeListener
{
  TraeAudioManager$f$3(TraeAudioManager.f paramf) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "focusChange:" + paramInt + " _focusSteamType:" + this.a.o + " currMode:" + this.a.p._am.getMode() + " _activeMode:" + this.a.p._activeMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f.3
 * JD-Core Version:    0.7.0.1
 */