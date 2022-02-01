package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$g
{
  private final String MEk;
  
  static
  {
    AppMethodBeat.i(10289);
    MEz = new g("CLICK", "SystemSoundType.click");
    MEA = new g[] { MEz };
    AppMethodBeat.o(10289);
  }
  
  private f$g(String paramString)
  {
    Object localObject;
    this.MEk = localObject;
  }
  
  static g bbU(String paramString)
  {
    AppMethodBeat.i(10288);
    g[] arrayOfg = values();
    int j = arrayOfg.length;
    int i = 0;
    while (i < j)
    {
      g localg = arrayOfg[i];
      if (localg.MEk.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.embedding.engine.c.f.g
 * JD-Core Version:    0.7.0.1
 */