package com.tencent.xweb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebView;
import org.xwalk.core.Log;

final class WebView$d
  extends MutableContextWrapper
{
  IWebView KAd;
  
  public WebView$d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void setBaseContext(Context paramContext)
  {
    AppMethodBeat.i(156806);
    super.setBaseContext(paramContext);
    if (!y.fJs().KzB) {
      ah.D("BASE_CONTEXT_CHANGED", this.KAd);
    }
    AppMethodBeat.o(156806);
  }
  
  public final void unbindService(ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(156807);
    try
    {
      super.unbindService(paramServiceConnection);
      AppMethodBeat.o(156807);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      Log.e("xweb.WebView", "ContextWrapper unbindService IllegalArgumentException", paramServiceConnection);
      AppMethodBeat.o(156807);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.WebView.d
 * JD-Core Version:    0.7.0.1
 */