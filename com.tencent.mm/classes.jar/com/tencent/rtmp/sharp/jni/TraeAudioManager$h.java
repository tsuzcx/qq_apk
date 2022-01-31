package com.tencent.rtmp.sharp.jni;

class TraeAudioManager$h
  extends TraeAudioManager.k
{
  TraeAudioManager$h(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    if (TraeAudioManager.IsUpdateSceneFlag) {
      e();
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "connect earphone: do nothing");
    }
  }
  
  public String b()
  {
    return "DEVICE_EARPHONE";
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.h
 * JD-Core Version:    0.7.0.1
 */