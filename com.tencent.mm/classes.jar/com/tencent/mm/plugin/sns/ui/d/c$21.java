package com.tencent.mm.plugin.sns.ui.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$21
  implements View.OnTouchListener
{
  c$21(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270401);
    Log.d("MicroMsg.TimelineClickListener", "v " + paramView.getId() + "  ");
    this.LpH.gx(paramView);
    AppMethodBeat.o(270401);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.21
 * JD-Core Version:    0.7.0.1
 */