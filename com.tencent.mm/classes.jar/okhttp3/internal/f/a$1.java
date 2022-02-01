package okhttp3.internal.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.aa;
import j.p;
import j.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

final class a$1
  implements a
{
  public final aa am(File paramFile)
  {
    AppMethodBeat.i(186773);
    paramFile = p.am(paramFile);
    AppMethodBeat.o(186773);
    return paramFile;
  }
  
  public final y an(File paramFile)
  {
    AppMethodBeat.i(186784);
    try
    {
      y localy = p.at(paramFile);
      AppMethodBeat.o(186784);
      return localy;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramFile.getParentFile().mkdirs();
      paramFile = p.at(paramFile);
      AppMethodBeat.o(186784);
    }
    return paramFile;
  }
  
  public final y ao(File paramFile)
  {
    AppMethodBeat.i(186791);
    try
    {
      y localy = p.ao(paramFile);
      AppMethodBeat.o(186791);
      return localy;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramFile.getParentFile().mkdirs();
      paramFile = p.ao(paramFile);
      AppMethodBeat.o(186791);
    }
    return paramFile;
  }
  
  public final void ap(File paramFile)
  {
    AppMethodBeat.i(186798);
    if ((!paramFile.delete()) && (paramFile.exists()))
    {
      paramFile = new IOException("failed to delete ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(186798);
      throw paramFile;
    }
    AppMethodBeat.o(186798);
  }
  
  public final boolean aq(File paramFile)
  {
    AppMethodBeat.i(186801);
    boolean bool = paramFile.exists();
    AppMethodBeat.o(186801);
    return bool;
  }
  
  public final long ar(File paramFile)
  {
    AppMethodBeat.i(186812);
    long l = paramFile.length();
    AppMethodBeat.o(186812);
    return l;
  }
  
  public final void as(File paramFile)
  {
    AppMethodBeat.i(186831);
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      paramFile = new IOException("not a readable directory: ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(186831);
      throw paramFile;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      paramFile = arrayOfFile[i];
      if (paramFile.isDirectory()) {
        as(paramFile);
      }
      if (!paramFile.delete())
      {
        paramFile = new IOException("failed to delete ".concat(String.valueOf(paramFile)));
        AppMethodBeat.o(186831);
        throw paramFile;
      }
      i += 1;
    }
    AppMethodBeat.o(186831);
  }
  
  public final void g(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(186820);
    ap(paramFile2);
    if (!paramFile1.renameTo(paramFile2))
    {
      paramFile1 = new IOException("failed to rename " + paramFile1 + " to " + paramFile2);
      AppMethodBeat.o(186820);
      throw paramFile1;
    }
    AppMethodBeat.o(186820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.f.a.1
 * JD-Core Version:    0.7.0.1
 */