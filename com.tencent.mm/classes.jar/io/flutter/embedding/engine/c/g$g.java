package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g$g
{
  private final String SQl;
  
  static
  {
    AppMethodBeat.i(10289);
    SQA = new g("CLICK", "SystemSoundType.click");
    SQB = new g[] { SQA };
    AppMethodBeat.o(10289);
  }
  
  private g$g(String paramString)
  {
    Object localObject;
    this.SQl = localObject;
  }
  
  static g btm(String paramString)
  {
    AppMethodBeat.i(10288);
    g[] arrayOfg = values();
    int j = arrayOfg.length;
    int i = 0;
    while (i < j)
    {
      g localg = arrayOfg[i];
      if (localg.SQl.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.embedding.engine.c.g.g
 * JD-Core Version:    0.7.0.1
 */