package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends a
{
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final com.tencent.mm.view.b.a fUg()
  {
    AppMethodBeat.i(9370);
    com.tencent.mm.view.b.c localc = new com.tencent.mm.view.b.c(getContext(), getPresenter());
    AppMethodBeat.o(9370);
    return localc;
  }
  
  protected final com.tencent.mm.view.footer.a fUh()
  {
    AppMethodBeat.i(9371);
    com.tencent.mm.view.footer.c localc = new com.tencent.mm.view.footer.c(getContext(), getPresenter());
    AppMethodBeat.o(9371);
    return localc;
  }
  
  public final com.tencent.mm.api.g[] getFeatures()
  {
    if (this.LKC == null) {
      this.LKC = new com.tencent.mm.api.g[] { com.tencent.mm.api.g.cSn, com.tencent.mm.api.g.cSp, com.tencent.mm.api.g.cSo, com.tencent.mm.api.g.cSs };
    }
    return this.LKC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.g
 * JD-Core Version:    0.7.0.1
 */