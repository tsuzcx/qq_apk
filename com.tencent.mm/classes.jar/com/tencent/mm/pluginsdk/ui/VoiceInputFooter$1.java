package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class VoiceInputFooter$1
  implements View.OnClickListener
{
  VoiceInputFooter$1(VoiceInputFooter paramVoiceInputFooter) {}
  
  public final void onClick(View paramView)
  {
    if (this.sbe.getVisibility() == 8) {
      this.sbe.setVisibility(0);
    }
    if (this.sbe.cmA()) {
      VoiceInputFooter.a(this.sbe);
    }
    if (this.sbe.bJX()) {
      VoiceInputFooter.b(this.sbe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter.1
 * JD-Core Version:    0.7.0.1
 */