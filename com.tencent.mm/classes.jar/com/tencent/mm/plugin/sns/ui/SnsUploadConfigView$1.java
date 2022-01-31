package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class SnsUploadConfigView$1
  implements View.OnClickListener
{
  SnsUploadConfigView$1(SnsUploadConfigView paramSnsUploadConfigView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39690);
    if ((!SnsUploadConfigView.a(this.sbB)) && (SnsUploadConfigView.b(this.sbB)))
    {
      h.h(this.val$context, 2131303991, 2131297087);
      AppMethodBeat.o(39690);
      return;
    }
    paramView = this.sbB;
    if (SnsUploadConfigView.a(this.sbB)) {}
    for (boolean bool = false;; bool = true)
    {
      SnsUploadConfigView.a(paramView, bool);
      SnsUploadConfigView.c(this.sbB);
      AppMethodBeat.o(39690);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.1
 * JD-Core Version:    0.7.0.1
 */