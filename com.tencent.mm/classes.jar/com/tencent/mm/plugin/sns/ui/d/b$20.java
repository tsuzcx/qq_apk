package com.tencent.mm.plugin.sns.ui.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$20
  implements View.OnTouchListener
{
  b$20(b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40269);
    ab.d("MicroMsg.TimelineClickListener", "v " + paramView.getId() + "  ");
    this.skd.dL(paramView);
    AppMethodBeat.o(40269);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.20
 * JD-Core Version:    0.7.0.1
 */