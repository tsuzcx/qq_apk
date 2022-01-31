package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseVoicePrintUI$2
  implements View.OnClickListener
{
  BaseVoicePrintUI$2(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26131);
    this.trX.finish();
    AppMethodBeat.o(26131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.2
 * JD-Core Version:    0.7.0.1
 */