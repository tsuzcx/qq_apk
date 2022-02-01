package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;

public final class o
  extends a
{
  public o(Context paramContext)
  {
    super(paramContext);
  }
  
  public final h[] getFeatures()
  {
    if (this.Riw == null) {
      this.Riw = new h[] { h.diH, h.diJ, h.diI, h.diM };
    }
    return this.Riw;
  }
  
  protected final com.tencent.mm.view.b.a hfv()
  {
    AppMethodBeat.i(9370);
    com.tencent.mm.view.b.d locald = new com.tencent.mm.view.b.d(getContext(), getPresenter());
    AppMethodBeat.o(9370);
    return locald;
  }
  
  protected final com.tencent.mm.view.footer.a hfw()
  {
    AppMethodBeat.i(9371);
    com.tencent.mm.view.footer.d locald = new com.tencent.mm.view.footer.d(getContext(), getPresenter());
    AppMethodBeat.o(9371);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.o
 * JD-Core Version:    0.7.0.1
 */