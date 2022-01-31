package com.tencent.smtt.sdk;

class ae
  implements Runnable
{
  ae(ad paramad) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(ad.a(this.a).getContext())) && (TbsDownloader.needDownload(ad.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(ad.a(this.a).getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.ae
 * JD-Core Version:    0.7.0.1
 */