package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public final class g
  implements b
{
  private ITPDownloadProxy Khr;
  
  public g(ITPDownloadProxy paramITPDownloadProxy)
  {
    this.Khr = paramITPDownloadProxy;
  }
  
  public final ITPDownloadProxy fFM()
  {
    return this.Khr;
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(187943);
    this.Khr.pushEvent(paramInt);
    AppMethodBeat.o(187943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.g
 * JD-Core Version:    0.7.0.1
 */