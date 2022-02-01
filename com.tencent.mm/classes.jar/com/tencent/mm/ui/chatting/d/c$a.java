package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ap;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;

final class c$a
  extends IListener<ap>
{
  private WeakReference<c> Hgy;
  
  public c$a(c paramc)
  {
    AppMethodBeat.i(292067);
    this.Hgy = new WeakReference(paramc);
    this.__eventId = ap.class.getName().hashCode();
    AppMethodBeat.o(292067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.a
 * JD-Core Version:    0.7.0.1
 */