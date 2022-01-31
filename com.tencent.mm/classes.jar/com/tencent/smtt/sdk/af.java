package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class af
  implements Runnable
{
  af(ae paramae) {}
  
  public void run()
  {
    AppMethodBeat.i(139138);
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(ae.a(this.a).getContext())) && (TbsDownloader.needDownload(ae.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(ae.a(this.a).getContext());
    }
    AppMethodBeat.o(139138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.af
 * JD-Core Version:    0.7.0.1
 */