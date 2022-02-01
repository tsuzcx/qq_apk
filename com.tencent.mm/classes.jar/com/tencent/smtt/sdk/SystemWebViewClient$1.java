package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebViewClient$1
  implements Runnable
{
  SystemWebViewClient$1(SystemWebViewClient paramSystemWebViewClient) {}
  
  public void run()
  {
    AppMethodBeat.i(55114);
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.a(this.a).getContext())) && (TbsDownloader.needDownload(SystemWebViewClient.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(SystemWebViewClient.a(this.a).getContext());
    }
    AppMethodBeat.o(55114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.1
 * JD-Core Version:    0.7.0.1
 */