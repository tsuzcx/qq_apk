package com.tencent.smtt.sdk;

class w
  implements Runnable
{
  w(v paramv) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(v.a(this.a).getContext())) && (TbsDownloader.needDownload(v.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(v.a(this.a).getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.w
 * JD-Core Version:    0.7.0.1
 */