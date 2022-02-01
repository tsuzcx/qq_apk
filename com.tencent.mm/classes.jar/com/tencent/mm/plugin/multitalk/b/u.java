package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
{
  public int ret;
  public int[] wpx;
  public int wpy;
  public int wpz;
  
  public u()
  {
    AppMethodBeat.i(190724);
    this.wpx = new int[0];
    AppMethodBeat.o(190724);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190725);
    Object localObject = new StringBuilder("ILinkVideoTransInfo [imgRGBdata size=");
    if (this.wpx == null) {}
    for (int i = 0;; i = this.wpx.length)
    {
      localObject = i + ", localImgWidth=" + this.wpy + ", localImgHeight=" + this.wpz + ", ret=" + this.ret + "]";
      AppMethodBeat.o(190725);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.u
 * JD-Core Version:    0.7.0.1
 */