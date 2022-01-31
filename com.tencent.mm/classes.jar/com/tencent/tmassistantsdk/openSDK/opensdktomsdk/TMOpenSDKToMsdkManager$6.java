package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;

class TMOpenSDKToMsdkManager$6
  implements View.OnClickListener
{
  TMOpenSDKToMsdkManager$6(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mContext == null) {
      return;
    }
    paramView = (ActionButton)paramView.getTag();
    for (;;)
    {
      try
      {
        int i = this.this$0.mOpenSDK.checkQQDownloaderInstalled(this.this$0.mSupportVersionCode);
        switch (i)
        {
        default: 
          return;
        }
      }
      catch (Exception paramView)
      {
        y.printErrStackTrace("OpensdkToMsdkManager", paramView, "", new Object[0]);
        return;
      }
      try
      {
        this.this$0.startToQQDownloaderAuthorized(paramView.jumpUrl);
        return;
      }
      catch (Exception paramView)
      {
        y.printErrStackTrace("OpensdkToMsdkManager", paramView, "", new Object[0]);
        return;
      }
    }
    this.this$0.startDownloadTask(this.this$0.mDownloadUrl, paramView.jumpUrl);
    return;
    this.this$0.startDownloadTask(this.this$0.mDownloadUrl, paramView.jumpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.6
 * JD-Core Version:    0.7.0.1
 */