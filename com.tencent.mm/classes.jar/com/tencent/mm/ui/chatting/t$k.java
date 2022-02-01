package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;

public final class t$k
  extends t.e
{
  public t$k(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(34603);
    s.a(paramView, parama.Pwc.getContext(), parama.getTalkerUserName());
    AppMethodBeat.o(34603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.k
 * JD-Core Version:    0.7.0.1
 */