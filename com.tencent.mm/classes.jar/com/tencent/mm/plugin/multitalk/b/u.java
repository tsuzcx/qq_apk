package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
{
  public int ret;
  public int[] zKJ;
  public int zKK;
  public int zKL;
  
  public u()
  {
    AppMethodBeat.i(239319);
    this.zKJ = new int[0];
    AppMethodBeat.o(239319);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239320);
    Object localObject = new StringBuilder("ILinkVideoTransInfo [imgRGBdata size=");
    if (this.zKJ == null) {}
    for (int i = 0;; i = this.zKJ.length)
    {
      localObject = i + ", localImgWidth=" + this.zKK + ", localImgHeight=" + this.zKL + ", ret=" + this.ret + "]";
      AppMethodBeat.o(239320);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.u
 * JD-Core Version:    0.7.0.1
 */