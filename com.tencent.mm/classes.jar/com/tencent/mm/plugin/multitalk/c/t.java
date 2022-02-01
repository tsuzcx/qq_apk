package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
{
  public int[] Lml;
  public int Lmm;
  public int Lmn;
  public int ret;
  
  public t()
  {
    AppMethodBeat.i(285156);
    this.Lml = new int[0];
    AppMethodBeat.o(285156);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(285169);
    Object localObject = new StringBuilder("ILinkVideoTransInfo [imgRGBdata size=");
    if (this.Lml == null) {}
    for (int i = 0;; i = this.Lml.length)
    {
      localObject = i + ", localImgWidth=" + this.Lmm + ", localImgHeight=" + this.Lmn + ", ret=" + this.ret + "]";
      AppMethodBeat.o(285169);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.t
 * JD-Core Version:    0.7.0.1
 */