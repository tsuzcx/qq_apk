package com.tencent.xweb.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class h
  implements d
{
  public d aiiv;
  
  private h(d paramd)
  {
    this.aiiv = paramd;
  }
  
  public h(File paramFile)
  {
    AppMethodBeat.i(183514);
    this.aiiv = g.kgS().ah(paramFile);
    AppMethodBeat.o(183514);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(183513);
    this.aiiv = g.kgS().bHN(paramString);
    AppMethodBeat.o(183513);
  }
  
  public final String coT()
  {
    AppMethodBeat.i(183519);
    String str = this.aiiv.coT();
    AppMethodBeat.o(183519);
    return str;
  }
  
  public final boolean diJ()
  {
    AppMethodBeat.i(183521);
    boolean bool = this.aiiv.diJ();
    AppMethodBeat.o(183521);
    return bool;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(183518);
    String str = this.aiiv.getName();
    AppMethodBeat.o(183518);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(183515);
    String str = this.aiiv.getPath();
    AppMethodBeat.o(183515);
    return str;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(183516);
    boolean bool = this.aiiv.isDirectory();
    AppMethodBeat.o(183516);
    return bool;
  }
  
  public final boolean jKS()
  {
    AppMethodBeat.i(183520);
    boolean bool = this.aiiv.jKS();
    AppMethodBeat.o(183520);
    return bool;
  }
  
  public final String[] jKW()
  {
    AppMethodBeat.i(183522);
    String[] arrayOfString = this.aiiv.jKW();
    AppMethodBeat.o(183522);
    return arrayOfString;
  }
  
  public final h[] kgT()
  {
    int i = 0;
    AppMethodBeat.i(183517);
    d[] arrayOfd = this.aiiv.kgQ();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.a.h
 * JD-Core Version:    0.7.0.1
 */