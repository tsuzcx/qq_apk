package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PlatformChannel$SoundType
{
  private final String encodedName;
  
  static
  {
    AppMethodBeat.i(10289);
    CLICK = new SoundType("CLICK", 0, "SystemSoundType.click");
    ALERT = new SoundType("ALERT", 1, "SystemSoundType.alert");
    $VALUES = new SoundType[] { CLICK, ALERT };
    AppMethodBeat.o(10289);
  }
  
  private PlatformChannel$SoundType(String paramString)
  {
    this.encodedName = paramString;
  }
  
  static SoundType fromValue(String paramString)
  {
    AppMethodBeat.i(10288);
    SoundType[] arrayOfSoundType = values();
    int j = arrayOfSoundType.length;
    int i = 0;
    while (i < j)
    {
      SoundType localSoundType = arrayOfSoundType[i];
      if (localSoundType.encodedName.equals(paramString))
      {
        AppMethodBeat.o(10288);
        return localSoundType;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException("No such SoundType: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(10288);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType
 * JD-Core Version:    0.7.0.1
 */