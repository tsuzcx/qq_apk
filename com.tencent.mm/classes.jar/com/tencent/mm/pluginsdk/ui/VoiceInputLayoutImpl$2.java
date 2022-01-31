package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class VoiceInputLayoutImpl$2
  implements View.OnTouchListener
{
  VoiceInputLayoutImpl$2(VoiceInputLayoutImpl paramVoiceInputLayoutImpl) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(27587);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27587);
      return false;
      VoiceInputLayoutImpl.a(this.vSA, false);
      VoiceInputLayoutImpl.a(this.vSA, bo.yB());
      ab.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(this.vSA.currentState), Long.valueOf(VoiceInputLayoutImpl.b(this.vSA)) });
      VoiceInputLayoutImpl.a(this.vSA).dnn();
      this.vSA.B(false, false);
      continue;
      ab.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(this.vSA.currentState), Boolean.valueOf(VoiceInputLayoutImpl.c(this.vSA)) });
      if (VoiceInputLayoutImpl.c(this.vSA))
      {
        this.vSA.B(true, false);
        VoiceInputLayoutImpl.a(this.vSA, false);
        VoiceInputLayoutImpl.a(this.vSA, 0L);
      }
      else
      {
        this.vSA.B(false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.2
 * JD-Core Version:    0.7.0.1
 */