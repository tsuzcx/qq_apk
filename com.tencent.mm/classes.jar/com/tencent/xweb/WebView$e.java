package com.tencent.xweb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.i;
import org.xwalk.core.Log;

final class WebView$e
  extends MutableContextWrapper
{
  i BEu;
  
  public WebView$e(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void setBaseContext(Context paramContext)
  {
    AppMethodBeat.i(151428);
    super.setBaseContext(paramContext);
    if (!q.dYn().BDM) {
      ab.v("BASE_CONTEXT_CHANGED", this.BEu);
    }
    AppMethodBeat.o(151428);
  }
  
  public final void unbindService(ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(156672);
    try
    {
      super.unbindService(paramServiceConnection);
      AppMethodBeat.o(156672);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      Log.e("xweb.WebView", "ContextWrapper unbindService IllegalArgumentException", paramServiceConnection);
      AppMethodBeat.o(156672);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.WebView.e
 * JD-Core Version:    0.7.0.1
 */