package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class SnsSightUploadSayFooter$1
  implements View.OnClickListener
{
  SnsSightUploadSayFooter$1(SnsSightUploadSayFooter paramSnsSightUploadSayFooter) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(39286);
    if (this.rWa.getVisibility() == 8) {
      this.rWa.setVisibility(0);
    }
    if (this.rWa.eys.getVisibility() == 0) {
      i = 1;
    }
    if (i != 0) {
      SnsSightUploadSayFooter.a(this.rWa);
    }
    AppMethodBeat.o(39286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.1
 * JD-Core Version:    0.7.0.1
 */