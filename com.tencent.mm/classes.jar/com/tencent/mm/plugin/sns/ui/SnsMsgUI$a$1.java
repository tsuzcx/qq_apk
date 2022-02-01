package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import java.util.Iterator;
import java.util.Set;

final class SnsMsgUI$a$1
  implements MMSlideDelView.d
{
  SnsMsgUI$a$1(SnsMsgUI.a parama) {}
  
  public final void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean)
  {
    AppMethodBeat.i(98874);
    if (paramBoolean)
    {
      tPy.add(paramMMSlideDelView);
      AppMethodBeat.o(98874);
      return;
    }
    tPy.remove(paramMMSlideDelView);
    AppMethodBeat.o(98874);
  }
  
  public final boolean cVq()
  {
    AppMethodBeat.i(98875);
    if (tPy.size() > 0)
    {
      AppMethodBeat.o(98875);
      return true;
    }
    AppMethodBeat.o(98875);
    return false;
  }
  
  public final void cVr()
  {
    AppMethodBeat.i(98876);
    Iterator localIterator = tPy.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.fiI();
      }
    }
    tPy.clear();
    AppMethodBeat.o(98876);
  }
  
  public final void cVs()
  {
    AppMethodBeat.i(98877);
    Iterator localIterator = tPy.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.fiH();
      }
    }
    tPy.clear();
    AppMethodBeat.o(98877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */