package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class x
  implements Runnable
{
  x(w paramw) {}
  
  public void run()
  {
    AppMethodBeat.i(139092);
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(w.a(this.a).getContext())) && (TbsDownloader.needDownload(w.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(w.a(this.a).getContext());
    }
    AppMethodBeat.o(139092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.x
 * JD-Core Version:    0.7.0.1
 */