package com.tencent.mm.view.recyclerview;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class g$a
{
  public static <D extends a> boolean b(View paramView, MotionEvent paramMotionEvent, D paramD)
  {
    AppMethodBeat.i(209933);
    p.k(paramView, "itemView");
    p.k(paramMotionEvent, "event");
    p.k(paramD, "item");
    AppMethodBeat.o(209933);
    return false;
  }
  
  public static <D extends a> boolean b(View paramView, D paramD)
  {
    AppMethodBeat.i(209938);
    p.k(paramView, "itemView");
    p.k(paramD, "data");
    AppMethodBeat.o(209938);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.g.a
 * JD-Core Version:    0.7.0.1
 */