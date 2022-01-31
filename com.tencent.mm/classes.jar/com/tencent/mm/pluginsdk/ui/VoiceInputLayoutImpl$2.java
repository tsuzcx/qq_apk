package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceInputLayoutImpl$2
  implements View.OnTouchListener
{
  VoiceInputLayoutImpl$2(VoiceInputLayoutImpl paramVoiceInputLayoutImpl) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      VoiceInputLayoutImpl.a(this.sbt, false);
      VoiceInputLayoutImpl.a(this.sbt, bk.UZ());
      y.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(this.sbt.kFU), Long.valueOf(VoiceInputLayoutImpl.b(this.sbt)) });
      VoiceInputLayoutImpl.a(this.sbt).cmx();
      this.sbt.y(false, false);
      return false;
    }
    y.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(this.sbt.kFU), Boolean.valueOf(VoiceInputLayoutImpl.c(this.sbt)) });
    if (VoiceInputLayoutImpl.c(this.sbt))
    {
      this.sbt.y(true, false);
      VoiceInputLayoutImpl.a(this.sbt, false);
      VoiceInputLayoutImpl.a(this.sbt, 0L);
      return false;
    }
    this.sbt.y(false, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.2
 * JD-Core Version:    0.7.0.1
 */