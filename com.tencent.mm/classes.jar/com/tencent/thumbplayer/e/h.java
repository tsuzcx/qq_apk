package com.tencent.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public final class h
  implements b
{
  private ITPDownloadProxy ahHc;
  
  public h(ITPDownloadProxy paramITPDownloadProxy)
  {
    this.ahHc = paramITPDownloadProxy;
  }
  
  public final ITPDownloadProxy kau()
  {
    return this.ahHc;
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(226994);
    this.ahHc.pushEvent(paramInt);
    AppMethodBeat.o(226994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.e.h
 * JD-Core Version:    0.7.0.1
 */