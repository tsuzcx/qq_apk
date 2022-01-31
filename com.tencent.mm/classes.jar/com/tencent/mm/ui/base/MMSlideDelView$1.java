package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class MMSlideDelView$1
  implements MMSlideDelView.d
{
  public final void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean)
  {
    AppMethodBeat.i(106770);
    if (paramBoolean)
    {
      nTX.add(paramMMSlideDelView);
      AppMethodBeat.o(106770);
      return;
    }
    nTX.remove(paramMMSlideDelView);
    AppMethodBeat.o(106770);
  }
  
  public final boolean bKj()
  {
    AppMethodBeat.i(106771);
    if (nTX.size() > 0)
    {
      AppMethodBeat.o(106771);
      return true;
    }
    AppMethodBeat.o(106771);
    return false;
  }
  
  public final void bKk()
  {
    AppMethodBeat.i(106772);
    Iterator localIterator = nTX.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.dEk();
      }
    }
    nTX.clear();
    AppMethodBeat.o(106772);
  }
  
  public final void bKl()
  {
    AppMethodBeat.i(106773);
    Iterator localIterator = nTX.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.dEj();
      }
    }
    nTX.clear();
    AppMethodBeat.o(106773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.1
 * JD-Core Version:    0.7.0.1
 */