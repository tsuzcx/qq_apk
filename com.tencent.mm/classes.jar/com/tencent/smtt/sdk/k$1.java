package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class k$1
  implements Runnable
{
  k$1(k paramk) {}
  
  public void run()
  {
    AppMethodBeat.i(188306);
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(k.a(this.a).getContext())) && (TbsDownloader.needDownload(k.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(k.a(this.a).getContext());
    }
    AppMethodBeat.o(188306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.k.1
 * JD-Core Version:    0.7.0.1
 */