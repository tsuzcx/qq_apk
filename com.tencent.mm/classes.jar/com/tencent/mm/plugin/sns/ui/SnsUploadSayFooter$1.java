package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUploadSayFooter$1
  implements View.OnClickListener
{
  SnsUploadSayFooter$1(SnsUploadSayFooter paramSnsUploadSayFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39717);
    if (this.sbF.getVisibility() == 8) {
      this.sbF.setVisibility(0);
    }
    if (this.sbF.bad()) {
      SnsUploadSayFooter.a(this.sbF);
    }
    AppMethodBeat.o(39717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.1
 * JD-Core Version:    0.7.0.1
 */