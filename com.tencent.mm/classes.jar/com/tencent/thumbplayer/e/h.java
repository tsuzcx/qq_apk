package com.tencent.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public final class h
  implements b
{
  private ITPDownloadProxy ZBZ;
  
  public h(ITPDownloadProxy paramITPDownloadProxy)
  {
    this.ZBZ = paramITPDownloadProxy;
  }
  
  public final ITPDownloadProxy iqY()
  {
    return this.ZBZ;
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(220575);
    this.ZBZ.pushEvent(paramInt);
    AppMethodBeat.o(220575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.e.h
 * JD-Core Version:    0.7.0.1
 */