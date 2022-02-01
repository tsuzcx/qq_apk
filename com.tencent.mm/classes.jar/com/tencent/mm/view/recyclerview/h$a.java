package com.tencent.mm.view.recyclerview;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class h$a
{
  public static <D extends a> boolean a(h<D> paramh, View paramView, MotionEvent paramMotionEvent, D paramD)
  {
    AppMethodBeat.i(234852);
    s.u(paramh, "this");
    s.u(paramView, "itemView");
    s.u(paramMotionEvent, "event");
    s.u(paramD, "item");
    AppMethodBeat.o(234852);
    return false;
  }
  
  public static <D extends a> boolean a(h<D> paramh, View paramView, D paramD)
  {
    AppMethodBeat.i(234862);
    s.u(paramh, "this");
    s.u(paramView, "itemView");
    s.u(paramD, "data");
    AppMethodBeat.o(234862);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h.a
 * JD-Core Version:    0.7.0.1
 */