package com.tencent.smtt.sdk;

import android.content.Context;

final class l
  implements TbsListener
{
  l(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public final void onDownloadFinish(int paramInt) {}
  
  public final void onDownloadProgress(int paramInt) {}
  
  public final void onInstallFinish(int paramInt)
  {
    QbSdk.preInit(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */