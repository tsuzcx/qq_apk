package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public final class g
  implements b
{
  private ITPDownloadProxy MaH;
  
  public g(ITPDownloadProxy paramITPDownloadProxy)
  {
    this.MaH = paramITPDownloadProxy;
  }
  
  public final ITPDownloadProxy fXb()
  {
    return this.MaH;
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(191964);
    this.MaH.pushEvent(paramInt);
    AppMethodBeat.o(191964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.g
 * JD-Core Version:    0.7.0.1
 */