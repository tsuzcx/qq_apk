package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelfQRCodeUI$1
  implements Runnable
{
  SelfQRCodeUI$1(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(127014);
    int i = SelfQRCodeUI.a(this.qGz).getWidth();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)SelfQRCodeUI.a(this.qGz).getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    SelfQRCodeUI.a(this.qGz).setLayoutParams(localLayoutParams);
    AppMethodBeat.o(127014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.1
 * JD-Core Version:    0.7.0.1
 */