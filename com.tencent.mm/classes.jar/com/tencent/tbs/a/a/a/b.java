package com.tencent.tbs.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b
  implements a
{
  private long a = 3145728L;
  
  public final boolean a(File paramFile)
  {
    AppMethodBeat.i(174288);
    if (paramFile != null)
    {
      if (paramFile.length() > this.a)
      {
        AppMethodBeat.o(174288);
        return true;
      }
      AppMethodBeat.o(174288);
      return false;
    }
    AppMethodBeat.o(174288);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */