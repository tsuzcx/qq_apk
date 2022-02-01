package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public final class g
  implements b
{
  private ITPDownloadProxy MxC;
  
  public g(ITPDownloadProxy paramITPDownloadProxy)
  {
    this.MxC = paramITPDownloadProxy;
  }
  
  public final ITPDownloadProxy gbA()
  {
    return this.MxC;
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(194642);
    this.MxC.pushEvent(paramInt);
    AppMethodBeat.o(194642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.g
 * JD-Core Version:    0.7.0.1
 */