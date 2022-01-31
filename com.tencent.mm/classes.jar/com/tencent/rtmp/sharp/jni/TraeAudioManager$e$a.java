package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(65824);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(65824);
      return false;
    }
    if (TraeAudioManager.checkDevName(paramString) != true)
    {
      AppMethodBeat.o(65824);
      return false;
    }
    this.a = paramString;
    this.c = paramInt;
    AppMethodBeat.o(65824);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.e.a
 * JD-Core Version:    0.7.0.1
 */