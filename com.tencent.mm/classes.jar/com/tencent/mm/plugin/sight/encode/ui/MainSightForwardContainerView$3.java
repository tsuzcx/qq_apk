package com.tencent.mm.plugin.sight.encode.ui;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MainSightForwardContainerView$3
  implements Runnable
{
  public MainSightForwardContainerView$3(MainSightForwardContainerView paramMainSightForwardContainerView) {}
  
  public final void run()
  {
    AppMethodBeat.i(25036);
    MainSightSelectContactView localMainSightSelectContactView = MainSightForwardContainerView.a(this.qWc);
    localMainSightSelectContactView.qVT = false;
    localMainSightSelectContactView.mListView.clearAnimation();
    localMainSightSelectContactView.mListView.clearFocus();
    localMainSightSelectContactView.mListView.setAdapter(localMainSightSelectContactView.qWz);
    localMainSightSelectContactView.I(false, true);
    localMainSightSelectContactView.setVisibility(0);
    if (localMainSightSelectContactView.qWy == null)
    {
      localMainSightSelectContactView.qWy = new TranslateAnimation(0.0F, 0.0F, localMainSightSelectContactView.qWw, 0.0F);
      localMainSightSelectContactView.qWy.setDuration(300L);
    }
    localMainSightSelectContactView.mListView.startAnimation(localMainSightSelectContactView.qWy);
    AppMethodBeat.o(25036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.3
 * JD-Core Version:    0.7.0.1
 */