package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;

public final class e
  extends a
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final com.tencent.mm.view.b.a fio()
  {
    AppMethodBeat.i(9363);
    com.tencent.mm.view.b.b localb = new com.tencent.mm.view.b.b(getContext(), getPresenter());
    AppMethodBeat.o(9363);
    return localb;
  }
  
  protected final com.tencent.mm.view.footer.a fip()
  {
    AppMethodBeat.i(9364);
    com.tencent.mm.view.footer.b localb = new com.tencent.mm.view.footer.b(getContext(), getPresenter());
    AppMethodBeat.o(9364);
    return localb;
  }
  
  public final g[] getFeatures()
  {
    if (this.HUh == null) {
      this.HUh = new g[] { g.cJs, g.cJu, g.cJt, g.cJv, g.cJw };
    }
    return this.HUh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.e
 * JD-Core Version:    0.7.0.1
 */