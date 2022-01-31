package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class WebViewStubTempUI$1
  extends ResultReceiver
{
  WebViewStubTempUI$1(Handler paramHandler, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.rkp.onClick(null, 0);
      return;
    }
    this.rkq.onClick(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.1
 * JD-Core Version:    0.7.0.1
 */