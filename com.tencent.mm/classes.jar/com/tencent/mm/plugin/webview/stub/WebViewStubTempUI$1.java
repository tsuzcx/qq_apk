package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewStubTempUI$1
  extends ResultReceiver
{
  WebViewStubTempUI$1(Handler paramHandler, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7218);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7218);
      return;
      this.uZJ.onClick(null, 0);
      AppMethodBeat.o(7218);
      return;
      this.uZK.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.1
 * JD-Core Version:    0.7.0.1
 */