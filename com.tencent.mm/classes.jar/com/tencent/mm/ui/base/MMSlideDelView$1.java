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
      JNK.add(paramMMSlideDelView);
      AppMethodBeat.o(142127);
      return;
    }
    JNK.remove(paramMMSlideDelView);
    AppMethodBeat.o(142127);
  }
  
  public final boolean fSl()
  {
    AppMethodBeat.i(142128);
    if (JNK.size() > 0)
    {
      AppMethodBeat.o(142128);
      return true;
    }
    AppMethodBeat.o(142128);
    return false;
  }
  
  public final void fSm()
  {
    AppMethodBeat.i(142129);
    Iterator localIterator = JNK.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.jmE();
      }
    }
    JNK.clear();
    AppMethodBeat.o(142129);
  }
  
  public final void fSn()
  {
    AppMethodBeat.i(142130);
    Iterator localIterator = JNK.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.jmD();
      }
    }
    JNK.clear();
    AppMethodBeat.o(142130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.1
 * JD-Core Version:    0.7.0.1
 */