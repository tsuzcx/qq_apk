package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RadioBelowSummarytAndIconPreference$1
  implements Runnable
{
  RadioBelowSummarytAndIconPreference$1(RadioBelowSummarytAndIconPreference paramRadioBelowSummarytAndIconPreference, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(142372);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)RadioBelowSummarytAndIconPreference.a(this.tYl).getLayoutParams();
    localLayoutParams.leftMargin = this.val$view.findViewById(16908304).getWidth();
    RadioBelowSummarytAndIconPreference.a(this.tYl).setLayoutParams(localLayoutParams);
    AppMethodBeat.o(142372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.RadioBelowSummarytAndIconPreference.1
 * JD-Core Version:    0.7.0.1
 */