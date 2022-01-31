package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;

class TMOpenSDKToMsdkManager$5
  implements View.OnClickListener
{
  TMOpenSDKToMsdkManager$5(TMOpenSDKToMsdkManager paramTMOpenSDKToMsdkManager) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.dialog.isShowing())
    {
      this.this$0.dialog.dismiss();
      this.this$0.mHttpRequest = null;
    }
    paramView = TipsInfoReportManager.getInstance().createTipsInfoLog(this.this$0.mAuthorizedInfo);
    paramView.cancelBtnClickCount += 1;
    TipsInfoReportManager.getInstance().addLogData(paramView);
    try
    {
      if (this.this$0.mClient != null) {
        this.this$0.pauseDownloadTask(this.this$0.mDownloadUrl);
      }
      if (this.this$0.authorizedState == 2)
      {
        this.this$0.notifyAuthorizedFinished(true, this.this$0.mAuthorizedInfo);
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        y.printErrStackTrace("OpensdkToMsdkManager", paramView, "", new Object[0]);
      }
      this.this$0.notifyAuthorizedFinished(false, this.this$0.mAuthorizedInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.5
 * JD-Core Version:    0.7.0.1
 */