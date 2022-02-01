package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import java.util.Iterator;
import java.util.Set;

final class SnsMsgUI$b$1
  implements MMSlideDelView.d
{
  SnsMsgUI$b$1(SnsMsgUI.b paramb) {}
  
  public final void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean)
  {
    AppMethodBeat.i(98874);
    if (paramBoolean)
    {
      JNK.add(paramMMSlideDelView);
      AppMethodBeat.o(98874);
      return;
    }
    JNK.remove(paramMMSlideDelView);
    AppMethodBeat.o(98874);
  }
  
  public final boolean fSl()
  {
    AppMethodBeat.i(98875);
    if (JNK.size() > 0)
    {
      AppMethodBeat.o(98875);
      return true;
    }
    AppMethodBeat.o(98875);
    return false;
  }
  
  public final void fSm()
  {
    AppMethodBeat.i(98876);
    Iterator localIterator = JNK.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.jmE();
      }
    }
    JNK.clear();
    AppMethodBeat.o(98876);
  }
  
  public final void fSn()
  {
    AppMethodBeat.i(98877);
    Iterator localIterator = JNK.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.jmD();
      }
    }
    JNK.clear();
    AppMethodBeat.o(98877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.b.1
 * JD-Core Version:    0.7.0.1
 */