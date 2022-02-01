package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;

public final class m
  extends a
{
  public m(Context paramContext)
  {
    super(paramContext);
  }
  
  public final h[] getFeatures()
  {
    if (this.Riw == null) {
      this.Riw = new h[] { h.diH, h.diJ, h.diI, h.diK, h.diL };
    }
    return this.Riw;
  }
  
  protected final com.tencent.mm.view.b.a hfv()
  {
    AppMethodBeat.i(9363);
    com.tencent.mm.view.b.c localc = new com.tencent.mm.view.b.c(getContext(), getPresenter());
    AppMethodBeat.o(9363);
    return localc;
  }
  
  protected final com.tencent.mm.view.footer.a hfw()
  {
    AppMethodBeat.i(9364);
    com.tencent.mm.view.footer.c localc = new com.tencent.mm.view.footer.c(getContext(), getPresenter());
    AppMethodBeat.o(9364);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.m
 * JD-Core Version:    0.7.0.1
 */