package com.tencent.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public final class h
  implements b
{
  private ITPDownloadProxy RZp;
  
  public h(ITPDownloadProxy paramITPDownloadProxy)
  {
    this.RZp = paramITPDownloadProxy;
  }
  
  public final ITPDownloadProxy hnx()
  {
    return this.RZp;
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(189240);
    this.RZp.pushEvent(paramInt);
    AppMethodBeat.o(189240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.e.h
 * JD-Core Version:    0.7.0.1
 */