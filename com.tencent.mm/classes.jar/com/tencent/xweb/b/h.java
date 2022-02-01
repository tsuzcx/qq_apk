package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class h
  implements d
{
  public d KCf;
  
  private h(d paramd)
  {
    this.KCf = paramd;
  }
  
  public h(File paramFile)
  {
    AppMethodBeat.i(183514);
    this.KCf = g.fKf().af(paramFile);
    AppMethodBeat.o(183514);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(183513);
    this.KCf = g.fKf().aVd(paramString);
    AppMethodBeat.o(183513);
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(183521);
    boolean bool = this.KCf.delete();
    AppMethodBeat.o(183521);
    return bool;
  }
  
  public final boolean exists()
  {
    AppMethodBeat.i(183520);
    boolean bool = this.KCf.exists();
    AppMethodBeat.o(183520);
    return bool;
  }
  
  public final h[] fKg()
  {
    int i = 0;
    AppMethodBeat.i(183517);
    d[] arrayOfd = this.KCf.fKd();
    if ((arrayOfd == null) || (arrayOfd.length == 0))
    {
      AppMethodBeat.o(183517);
      return new h[0];
    }
    h[] arrayOfh = new h[arrayOfd.length];
    while (i < arrayOfd.length)
    {
      arrayOfh[i] = new h(arrayOfd[i]);
      i += 1;
    }
    AppMethodBeat.o(183517);
    return arrayOfh;
  }
  
  public final String getAbsolutePath()
  {
    AppMethodBeat.i(183519);
    String str = this.KCf.getPath();
    AppMethodBeat.o(183519);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(183518);
    String str = this.KCf.getPath();
    AppMethodBeat.o(183518);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(183515);
    String str = this.KCf.getPath();
    AppMethodBeat.o(183515);
    return str;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(183516);
    boolean bool = this.KCf.isDirectory();
    AppMethodBeat.o(183516);
    return bool;
  }
  
  public final String[] list()
  {
    AppMethodBeat.i(183522);
    String[] arrayOfString = this.KCf.list();
    AppMethodBeat.o(183522);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.b.h
 * JD-Core Version:    0.7.0.1
 */