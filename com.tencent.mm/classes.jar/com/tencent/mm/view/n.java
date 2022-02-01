package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;

public final class n
  extends a
{
  public n(Context paramContext)
  {
    super(paramContext);
  }
  
  public final i[] getFeatures()
  {
    if (this.agFV == null) {
      this.agFV = new i[] { i.hdO, i.hdQ, i.hdP, i.hdT };
    }
    return this.agFV;
  }
  
  protected final com.tencent.mm.view.b.a jMg()
  {
    AppMethodBeat.i(9370);
    com.tencent.mm.view.b.d locald = new com.tencent.mm.view.b.d(getContext(), getPresenter());
    AppMethodBeat.o(9370);
    return locald;
  }
  
  protected final com.tencent.mm.view.footer.a jMh()
  {
    AppMethodBeat.i(9371);
    com.tencent.mm.view.footer.d locald = new com.tencent.mm.view.footer.d(getContext(), getPresenter());
    AppMethodBeat.o(9371);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.n
 * JD-Core Version:    0.7.0.1
 */