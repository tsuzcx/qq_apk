package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(14)
public final class ag$a
  implements View.OnHoverListener
{
  private ag.b HQe;
  
  public ag$a(ag.b paramb)
  {
    this.HQe = paramb;
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34838);
    if (this.HQe != null)
    {
      boolean bool = this.HQe.f(paramView, paramMotionEvent);
      AppMethodBeat.o(34838);
      return bool;
    }
    AppMethodBeat.o(34838);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ag.a
 * JD-Core Version:    0.7.0.1
 */