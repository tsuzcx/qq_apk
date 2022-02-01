package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.ui.aw;

final class au
{
  ImageView Aov;
  TextView aejX;
  SendDataToDeviceProgressBar aemr;
  TextView pUL;
  View rIY;
  ImageView ttT;
  
  public final void jqh()
  {
    AppMethodBeat.i(253739);
    if (aw.isDarkMode())
    {
      this.Aov.setImageResource(R.k.send_data_round_rect_shadow_dm);
      AppMethodBeat.o(253739);
      return;
    }
    this.Aov.setImageResource(R.k.send_data_round_rect_shadow);
    AppMethodBeat.o(253739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.au
 * JD-Core Version:    0.7.0.1
 */