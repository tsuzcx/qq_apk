package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceInputUI$2
  implements View.OnTouchListener
{
  VoiceInputUI$2(VoiceInputUI paramVoiceInputUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(27607);
    if (paramMotionEvent.getAction() == 0) {
      VoiceInputUI.a(this.vSL);
    }
    for (;;)
    {
      AppMethodBeat.o(27607);
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        if (VoiceInputUI.b(this.vSL).dnq())
        {
          paramView = VoiceInputUI.b(this.vSL);
          paramView.dnr();
          paramView.setVisibility(8);
        }
        if (VoiceInputUI.b(this.vSL).bad())
        {
          paramView = VoiceInputUI.b(this.vSL);
          paramView.aRm();
          paramView.setVisibility(8);
        }
        paramView = VoiceInputUI.b(this.vSL);
        paramView.setVisibility(0);
        if (paramView.vSe != null) {
          paramView.vSe.setImageResource(2130838345);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.2
 * JD-Core Version:    0.7.0.1
 */