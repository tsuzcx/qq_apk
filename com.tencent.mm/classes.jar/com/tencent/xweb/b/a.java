package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class a
  implements d
{
  File Gsu;
  
  public a(File paramFile)
  {
    this.Gsu = paramFile;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(183503);
    boolean bool = this.Gsu.delete();
    AppMethodBeat.o(183503);
    return bool;
  }
  
  public final boolean exists()
  {
    AppMethodBeat.i(183502);
    boolean bool = this.Gsu.exists();
    AppMethodBeat.o(183502);
    return bool;
  }
  
  public final d[] fKd()
  {
    int i = 0;
    AppMethodBeat.i(183501);
    File[] arrayOfFile = this.Gsu.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      AppMethodBeat.o(183501);
      return new d[0];
    }
    d[] arrayOfd = new d[arrayOfFile.length];
    while (i < arrayOfFile.length)
    {
      arrayOfd[i] = new a(arrayOfFile[i]);
      i += 1;
    }
    AppMethodBeat.o(183501);
    return arrayOfd;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(183499);
    String str = this.Gsu.getPath();
    AppMethodBeat.o(183499);
    return str;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(183500);
    boolean bool = this.Gsu.isDirectory();
    AppMethodBeat.o(183500);
    return bool;
  }
  
  public final String[] list()
  {
    AppMethodBeat.i(183504);
    String[] arrayOfString = this.Gsu.list();
    AppMethodBeat.o(183504);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.b.a
 * JD-Core Version:    0.7.0.1
 */