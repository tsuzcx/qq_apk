package com.tencent.rtmp.sharp.jni;

class TraeAudioManager$j
  extends TraeAudioManager.k
{
  TraeAudioManager$j(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag)) {
      e();
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "connect speakerPhone: do nothing");
    }
  }
  
  public String b()
  {
    return "DEVICE_SPEAKERPHONE";
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.j
 * JD-Core Version:    0.7.0.1
 */