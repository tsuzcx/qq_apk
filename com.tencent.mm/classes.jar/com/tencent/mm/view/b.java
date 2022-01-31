package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.s.a;

public final class b
  extends a
{
  public b(Context paramContext, s.a parama)
  {
    super(paramContext, parama);
  }
  
  protected final com.tencent.mm.view.b.a dQM()
  {
    AppMethodBeat.i(116386);
    com.tencent.mm.view.b.b localb = new com.tencent.mm.view.b.b(getContext(), getPresenter());
    AppMethodBeat.o(116386);
    return localb;
  }
  
  protected final com.tencent.mm.view.footer.a dQN()
  {
    AppMethodBeat.i(116387);
    com.tencent.mm.view.footer.b localb = new com.tencent.mm.view.footer.b(getContext(), getPresenter());
    AppMethodBeat.o(116387);
    return localb;
  }
  
  public final e[] getFeatures()
  {
    if (this.AQv == null) {
      this.AQv = new e[] { e.bVW, e.bVY, e.bVX, e.bVZ, e.bWa };
    }
    return this.AQv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.b
 * JD-Core Version:    0.7.0.1
 */