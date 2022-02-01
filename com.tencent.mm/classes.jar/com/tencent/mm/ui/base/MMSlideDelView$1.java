package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class MMSlideDelView$1
  implements MMSlideDelView.d
{
  public final void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean)
  {
    AppMethodBeat.i(142127);
    if (paramBoolean)
    {
      ywx.add(paramMMSlideDelView);
      AppMethodBeat.o(142127);
      return;
    }
    ywx.remove(paramMMSlideDelView);
    AppMethodBeat.o(142127);
  }
  
  public final boolean ebn()
  {
    AppMethodBeat.i(142128);
    if (ywx.size() > 0)
    {
      AppMethodBeat.o(142128);
      return true;
    }
    AppMethodBeat.o(142128);
    return false;
  }
  
  public final void ebo()
  {
    AppMethodBeat.i(142129);
    Iterator localIterator = ywx.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.gLa();
      }
    }
    ywx.clear();
    AppMethodBeat.o(142129);
  }
  
  public final void ebp()
  {
    AppMethodBeat.i(142130);
    Iterator localIterator = ywx.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.gKZ();
      }
    }
    ywx.clear();
    AppMethodBeat.o(142130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.1
 * JD-Core Version:    0.7.0.1
 */