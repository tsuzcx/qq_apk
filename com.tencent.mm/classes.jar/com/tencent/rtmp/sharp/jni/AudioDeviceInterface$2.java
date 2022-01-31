package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

class AudioDeviceInterface$2
  implements TraeAudioSession.a
{
  AudioDeviceInterface$2(AudioDeviceInterface paramAudioDeviceInterface) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(65662);
    if (paramInt == 0) {
      AudioDeviceInterface.access$500(this.a, paramString);
    }
    AppMethodBeat.o(65662);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146955);
    AudioDeviceInterface.access$302(paramArrayOfString);
    AppMethodBeat.o(146955);
  }
  
  public void a(String paramString, long paramLong) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65661);
    AudioDeviceInterface.access$302(paramArrayOfString);
    if (AudioDeviceInterface.access$400(this.a)) {
      AudioDeviceInterface.access$500(this.a, paramString1);
    }
    AppMethodBeat.o(65661);
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDeviceInterface.2
 * JD-Core Version:    0.7.0.1
 */