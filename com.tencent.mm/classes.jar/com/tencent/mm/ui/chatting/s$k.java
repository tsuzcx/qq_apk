package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.e.a;

public final class s$k
  extends s.e
{
  public s$k(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(34603);
    r.a(paramView, parama.JOR.getContext(), parama.getTalkerUserName());
    AppMethodBeat.o(34603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.k
 * JD-Core Version:    0.7.0.1
 */