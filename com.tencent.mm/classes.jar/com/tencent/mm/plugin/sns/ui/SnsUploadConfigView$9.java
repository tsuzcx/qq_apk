package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUploadConfigView$9
  implements View.OnClickListener
{
  SnsUploadConfigView$9(SnsUploadConfigView paramSnsUploadConfigView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39696);
    paramView = this.sbB;
    if (SnsUploadConfigView.f(this.sbB)) {}
    for (boolean bool = false;; bool = true)
    {
      SnsUploadConfigView.c(paramView, bool);
      if (SnsUploadConfigView.f(this.sbB)) {
        SnsUploadConfigView.g(this.sbB);
      }
      SnsUploadConfigView.h(this.sbB);
      AppMethodBeat.o(39696);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.9
 * JD-Core Version:    0.7.0.1
 */