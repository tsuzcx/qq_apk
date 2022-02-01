package com.tencent.mm.toolkit.frontia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b$a
{
  public static boolean J(File paramFile)
  {
    int i = 0;
    AppMethodBeat.i(232014);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(232014);
      return false;
    }
    if (paramFile.isFile()) {
      safeDeleteFile(paramFile);
    }
    for (;;)
    {
      AppMethodBeat.o(232014);
      return true;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          while (i < j)
          {
            J(arrayOfFile[i]);
            i += 1;
          }
          safeDeleteFile(paramFile);
        }
      }
    }
  }
  
  public static boolean safeDeleteFile(File paramFile)
  {
    AppMethodBeat.i(232009);
    if (paramFile == null)
    {
      AppMethodBeat.o(232009);
      return true;
    }
    if (paramFile.exists())
    {
      new StringBuilder("safeDeleteFile, try to delete path: ").append(paramFile.getPath());
      boolean bool = paramFile.delete();
      if (!bool)
      {
        new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(paramFile.getPath());
        paramFile.deleteOnExit();
      }
      AppMethodBeat.o(232009);
      return bool;
    }
    AppMethodBeat.o(232009);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.b.a
 * JD-Core Version:    0.7.0.1
 */