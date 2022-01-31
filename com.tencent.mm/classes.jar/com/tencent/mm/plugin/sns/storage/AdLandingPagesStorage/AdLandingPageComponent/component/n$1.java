package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomScrollView.a;
import java.util.Iterator;
import java.util.List;

final class n$1
  implements CustomScrollView.a
{
  n$1(n paramn) {}
  
  public final void a(ScrollView paramScrollView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37152);
    paramScrollView = this.rwh.aWy.iterator();
    while (paramScrollView.hasNext())
    {
      h localh = (h)paramScrollView.next();
      if (localh.cqX())
      {
        localh.cqA();
        localh.cqC();
      }
      else
      {
        localh.cqB();
      }
    }
    AppMethodBeat.o(37152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.1
 * JD-Core Version:    0.7.0.1
 */