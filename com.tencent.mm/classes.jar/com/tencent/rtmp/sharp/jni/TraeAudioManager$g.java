package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Build.VERSION;

class TraeAudioManager$g
  extends TraeAudioManager.k
{
  TraeAudioManager$g(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "connect bluetoothHeadset: do nothing");
    }
    e();
  }
  
  public String b()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
  
  @TargetApi(8)
  public void c()
  {
    if (this.a._am == null) {
      return;
    }
    d();
  }
  
  @TargetApi(8)
  void d()
  {
    if (Build.VERSION.SDK_INT > 8) {
      this.a._am.stopBluetoothSco();
    }
    this.a._am.setBluetoothScoOn(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.g
 * JD-Core Version:    0.7.0.1
 */