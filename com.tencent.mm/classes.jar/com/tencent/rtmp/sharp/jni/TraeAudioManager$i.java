package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;

class TraeAudioManager$i
  extends TraeAudioManager.k
{
  TraeAudioManager$i(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag)) {
      this.a._am.setWiredHeadsetOn(true);
    }
    e();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "connect headset: do nothing");
    }
  }
  
  public String b()
  {
    return "DEVICE_WIREDHEADSET";
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.i
 * JD-Core Version:    0.7.0.1
 */