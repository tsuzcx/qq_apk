package com.tencent.mm.plugin.setting.ui.setting;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;

final class SelfQRCodeUI$5
  implements ViewTreeObserver.OnPreDrawListener
{
  SelfQRCodeUI$5(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(154166);
    SelfQRCodeUI.b(this.qGz).getViewTreeObserver().removeOnPreDrawListener(this);
    int i = al.fromDPToPix(this.qGz.getContext(), 500);
    if (SelfQRCodeUI.b(this.qGz).getWidth() > i)
    {
      ViewGroup.LayoutParams localLayoutParams = SelfQRCodeUI.b(this.qGz).getLayoutParams();
      localLayoutParams.width = i;
      SelfQRCodeUI.b(this.qGz).setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(154166);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.5
 * JD-Core Version:    0.7.0.1
 */