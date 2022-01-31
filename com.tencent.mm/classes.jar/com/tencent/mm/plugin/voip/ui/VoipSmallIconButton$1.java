package com.tencent.mm.plugin.voip.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipSmallIconButton$1
  implements View.OnTouchListener
{
  VoipSmallIconButton$1(VoipSmallIconButton paramVoipSmallIconButton) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(4866);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4866);
      return false;
      VoipSmallIconButton.b(this.tCW).setImageDrawable(VoipSmallIconButton.a(this.tCW));
      VoipSmallIconButton.c(this.tCW).setTextColor(-855638017);
      continue;
      VoipSmallIconButton.b(this.tCW).setImageDrawable(VoipSmallIconButton.d(this.tCW));
      VoipSmallIconButton.c(this.tCW).setTextColor(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipSmallIconButton.1
 * JD-Core Version:    0.7.0.1
 */