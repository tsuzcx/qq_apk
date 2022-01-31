package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsNotifyBanner$2
  implements View.OnClickListener
{
  SnsNotifyBanner$2(SnsNotifyBanner paramSnsNotifyBanner) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39137);
    if (SnsNotifyBanner.a(this.rTV) == null)
    {
      AppMethodBeat.o(39137);
      return;
    }
    if (this.rTV.rTT > 0)
    {
      this.rTV.rTT = 0;
      SnsNotifyBanner.a(this.rTV);
    }
    for (;;)
    {
      this.rTV.setVisibility(8);
      AppMethodBeat.o(39137);
      return;
      SnsNotifyBanner.a(this.rTV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotifyBanner.2
 * JD-Core Version:    0.7.0.1
 */