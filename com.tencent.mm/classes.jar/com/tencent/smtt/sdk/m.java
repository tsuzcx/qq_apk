package com.tencent.smtt.sdk;

import android.content.Context;

final class m
  implements TbsDownloader.TbsDownloaderCallback
{
  m(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if ((TbsShareManager.findCoreForThirdPartyApp(this.a) == 0) && (!TbsShareManager.getCoreDisabled()))
    {
      TbsShareManager.forceToLoadX5ForThirdApp(this.a, false);
      if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(this.a))) {
        TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
      }
      return;
    }
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(this.a))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
    }
    QbSdk.preInit(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */