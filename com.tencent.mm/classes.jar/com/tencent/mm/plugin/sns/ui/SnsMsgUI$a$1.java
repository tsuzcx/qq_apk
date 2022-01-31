package com.tencent.mm.plugin.sns.ui;

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
    if (paramBoolean)
    {
      lwK.add(paramMMSlideDelView);
      return;
    }
    lwK.remove(paramMMSlideDelView);
  }
  
  public final boolean bda()
  {
    return lwK.size() > 0;
  }
  
  public final void bdb()
  {
    Iterator localIterator = lwK.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.cAY();
      }
    }
    lwK.clear();
  }
  
  public final void bdc()
  {
    Iterator localIterator = lwK.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.cAX();
      }
    }
    lwK.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */