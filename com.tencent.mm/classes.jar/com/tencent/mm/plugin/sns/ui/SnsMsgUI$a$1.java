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
    AppMethodBeat.i(39084);
    if (paramBoolean)
    {
      nTX.add(paramMMSlideDelView);
      AppMethodBeat.o(39084);
      return;
    }
    nTX.remove(paramMMSlideDelView);
    AppMethodBeat.o(39084);
  }
  
  public final boolean bKj()
  {
    AppMethodBeat.i(39085);
    if (nTX.size() > 0)
    {
      AppMethodBeat.o(39085);
      return true;
    }
    AppMethodBeat.o(39085);
    return false;
  }
  
  public final void bKk()
  {
    AppMethodBeat.i(39086);
    Iterator localIterator = nTX.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.dEk();
      }
    }
    nTX.clear();
    AppMethodBeat.o(39086);
  }
  
  public final void bKl()
  {
    AppMethodBeat.i(39087);
    Iterator localIterator = nTX.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.dEj();
      }
    }
    nTX.clear();
    AppMethodBeat.o(39087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */