package com.tencent.tbs.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b
  implements a
{
  private long a = 604800000L;
  
  public final boolean a(File paramFile)
  {
    AppMethodBeat.i(174289);
    if (paramFile != null)
    {
      if (System.currentTimeMillis() - paramFile.lastModified() > this.a)
      {
        AppMethodBeat.o(174289);
        return true;
      }
      AppMethodBeat.o(174289);
      return false;
    }
    AppMethodBeat.o(174289);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tbs.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */