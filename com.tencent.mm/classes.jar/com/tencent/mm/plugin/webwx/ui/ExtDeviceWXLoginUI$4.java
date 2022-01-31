package com.tencent.mm.plugin.webwx.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExtDeviceWXLoginUI$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ExtDeviceWXLoginUI$4(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(153684);
    ExtDeviceWXLoginUI.d(this.vux).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    ExtDeviceWXLoginUI.e(this.vux);
    AppMethodBeat.o(153684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.4
 * JD-Core Version:    0.7.0.1
 */