package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;

public final class m
  extends a
{
  public m(Context paramContext)
  {
    super(paramContext);
  }
  
  public final i[] getFeatures()
  {
    if (this.agFV == null) {
      this.agFV = new i[] { i.hdO, i.hdQ, i.hdP, i.hdR, i.hdS };
    }
    return this.agFV;
  }
  
  protected final com.tencent.mm.view.b.a jMg()
  {
    AppMethodBeat.i(9363);
    com.tencent.mm.view.b.c localc = new com.tencent.mm.view.b.c(getContext(), getPresenter());
    AppMethodBeat.o(9363);
    return localc;
  }
  
  protected final com.tencent.mm.view.footer.a jMh()
  {
    AppMethodBeat.i(9364);
    com.tencent.mm.view.footer.c localc = new com.tencent.mm.view.footer.c(getContext(), getPresenter());
    AppMethodBeat.o(9364);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.m
 * JD-Core Version:    0.7.0.1
 */