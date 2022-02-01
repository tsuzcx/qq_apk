package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;

public final class v$k
  extends v.e
{
  public v$k(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(34603);
    u.a(paramView, parama.aezO.getContext(), parama.getTalkerUserName());
    AppMethodBeat.o(34603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.k
 * JD-Core Version:    0.7.0.1
 */