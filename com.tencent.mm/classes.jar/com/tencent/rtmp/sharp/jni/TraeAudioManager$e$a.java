package com.tencent.rtmp.sharp.jni;

public class TraeAudioManager$e$a
{
  String a = "DEVICE_NONE";
  boolean b = false;
  int c = 0;
  
  public TraeAudioManager$e$a(TraeAudioManager.e parame) {}
  
  public String a()
  {
    return this.a;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    while (TraeAudioManager.checkDevName(paramString) != true) {
      return false;
    }
    this.a = paramString;
    this.c = paramInt;
    return true;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.e.a
 * JD-Core Version:    0.7.0.1
 */