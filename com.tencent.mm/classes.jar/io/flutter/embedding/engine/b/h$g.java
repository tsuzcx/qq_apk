package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$g
{
  private final String aasG;
  
  static
  {
    AppMethodBeat.i(10289);
    aasV = new g("CLICK", 0, "SystemSoundType.click");
    aasW = new g("ALERT", 1, "SystemSoundType.alert");
    aasX = new g[] { aasV, aasW };
    AppMethodBeat.o(10289);
  }
  
  private h$g(String paramString)
  {
    this.aasG = paramString;
  }
  
  static g bGp(String paramString)
  {
    AppMethodBeat.i(10288);
    g[] arrayOfg = values();
    int j = arrayOfg.length;
    int i = 0;
    while (i < j)
    {
      g localg = arrayOfg[i];
      if (localg.aasG.equals(paramString))
      {
        AppMethodBeat.o(10288);
        return localg;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException("No such SoundType: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(10288);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.b.h.g
 * JD-Core Version:    0.7.0.1
 */