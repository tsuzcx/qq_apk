package com.tencent.xweb.x5.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;

final class e$a
  implements TbsListener
{
  h BIz;
  
  public e$a(h paramh)
  {
    this.BIz = paramh;
  }
  
  public final void onDownloadFinish(int paramInt)
  {
    AppMethodBeat.i(85091);
    if (this.BIz != null) {
      this.BIz.onDownloadFinish(paramInt);
    }
    AppMethodBeat.o(85091);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(85093);
    if (this.BIz != null) {
      this.BIz.onDownloadProgress(paramInt);
    }
    AppMethodBeat.o(85093);
  }
  
  public final void onInstallFinish(int paramInt)
  {
    AppMethodBeat.i(85092);
    if (this.BIz != null) {
      this.BIz.onInstallFinish(paramInt);
    }
    AppMethodBeat.o(85092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */