package com.tencent.mm.plugin.voip.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipBigIconButton$1
  implements View.OnTouchListener
{
  VoipBigIconButton$1(VoipBigIconButton paramVoipBigIconButton) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(4852);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4852);
      return false;
      VoipBigIconButton.b(this.tCP).setBackgroundDrawable(VoipBigIconButton.a(this.tCP));
      VoipBigIconButton.b(this.tCP).setImageDrawable(VoipBigIconButton.c(this.tCP));
      VoipBigIconButton.d(this.tCP).setTextColor(-855638017);
      continue;
      VoipBigIconButton.b(this.tCP).setBackgroundDrawable(VoipBigIconButton.e(this.tCP));
      VoipBigIconButton.b(this.tCP).setImageDrawable(VoipBigIconButton.f(this.tCP));
      VoipBigIconButton.d(this.tCP).setTextColor(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton.1
 * JD-Core Version:    0.7.0.1
 */