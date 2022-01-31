package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.s.a;

public final class d
  extends a
{
  public d(Context paramContext, s.a parama)
  {
    super(paramContext, parama);
  }
  
  protected final com.tencent.mm.view.b.a dQM()
  {
    AppMethodBeat.i(116393);
    com.tencent.mm.view.b.c localc = new com.tencent.mm.view.b.c(getContext(), getPresenter());
    AppMethodBeat.o(116393);
    return localc;
  }
  
  protected final com.tencent.mm.view.footer.a dQN()
  {
    AppMethodBeat.i(116394);
    com.tencent.mm.view.footer.c localc = new com.tencent.mm.view.footer.c(getContext(), getPresenter());
    AppMethodBeat.o(116394);
    return localc;
  }
  
  public final e[] getFeatures()
  {
    if (this.AQv == null) {
      this.AQv = new e[] { e.bVW, e.bVY, e.bVX, e.bWb };
    }
    return this.AQv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.d
 * JD-Core Version:    0.7.0.1
 */