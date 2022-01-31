package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.R.g;

final class VoiceInputUI$2
  implements View.OnTouchListener
{
  VoiceInputUI$2(VoiceInputUI paramVoiceInputUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      VoiceInputUI.a(this.sbE);
    }
    do
    {
      do
      {
        return false;
      } while (paramMotionEvent.getAction() != 1);
      if (VoiceInputUI.b(this.sbE).cmA())
      {
        paramView = VoiceInputUI.b(this.sbE);
        paramView.cmB();
        paramView.setVisibility(8);
      }
      if (VoiceInputUI.b(this.sbE).bJX())
      {
        paramView = VoiceInputUI.b(this.sbE);
        paramView.hideSmileyPanel();
        paramView.setVisibility(8);
      }
      paramView = VoiceInputUI.b(this.sbE);
      paramView.setVisibility(0);
    } while (paramView.saX == null);
    paramView.saX.setImageResource(R.g.chatting_setmode_biaoqing_btn);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.2
 * JD-Core Version:    0.7.0.1
 */