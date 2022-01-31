package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsOnlineVideoActivity$1
  implements View.OnClickListener
{
  SnsOnlineVideoActivity$1(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(39142);
    paramView = this.rUf;
    if (SnsOnlineVideoActivity.a(this.rUf)) {}
    for (int i = 8;; i = 0)
    {
      paramView.setTitleVisibility(i);
      paramView = this.rUf;
      if (!SnsOnlineVideoActivity.a(this.rUf)) {
        bool = true;
      }
      SnsOnlineVideoActivity.a(paramView, bool);
      AppMethodBeat.o(39142);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.1
 * JD-Core Version:    0.7.0.1
 */