package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class h
  implements d
{
  public d aadM;
  
  private h(d paramd)
  {
    this.aadM = paramd;
  }
  
  public h(File paramFile)
  {
    AppMethodBeat.i(183514);
    this.aadM = g.ixc().ad(paramFile);
    AppMethodBeat.o(183514);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(183513);
    this.aadM = g.ixc().bFs(paramString);
    AppMethodBeat.o(183513);
  }
  
  public final String bOF()
  {
    AppMethodBeat.i(183519);
    String str = this.aadM.getPath();
    AppMethodBeat.o(183519);
    return str;
  }
  
  public final boolean cFq()
  {
    AppMethodBeat.i(183521);
    boolean bool = this.aadM.cFq();
    AppMethodBeat.o(183521);
    return bool;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(183518);
    String str = this.aadM.getPath();
    AppMethodBeat.o(183518);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(183515);
    String str = this.aadM.getPath();
    AppMethodBeat.o(183515);
    return str;
  }
  
  public final boolean ifE()
  {
    AppMethodBeat.i(183520);
    boolean bool = this.aadM.ifE();
    AppMethodBeat.o(183520);
    return bool;
  }
  
  public final String[] ifI()
  {
    AppMethodBeat.i(183522);
    String[] arrayOfString = this.aadM.ifI();
    AppMethodBeat.o(183522);
    return arrayOfString;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(183516);
    boolean bool = this.aadM.isDirectory();
    AppMethodBeat.o(183516);
    return bool;
  }
  
  public final h[] ixd()
  {
    int i = 0;
    AppMethodBeat.i(183517);
    d[] arrayOfd = this.aadM.ixa();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.b.h
 * JD-Core Version:    0.7.0.1
 */