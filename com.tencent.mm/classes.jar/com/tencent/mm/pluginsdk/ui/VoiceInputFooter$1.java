package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceInputFooter$1
  implements View.OnClickListener
{
  VoiceInputFooter$1(VoiceInputFooter paramVoiceInputFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27554);
    if (this.vSl.getVisibility() == 8) {
      this.vSl.setVisibility(0);
    }
    if (this.vSl.dnq()) {
      VoiceInputFooter.a(this.vSl);
    }
    if (this.vSl.bad()) {
      VoiceInputFooter.b(this.vSl);
    }
    AppMethodBeat.o(27554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter.1
 * JD-Core Version:    0.7.0.1
 */