package com.tencent.mm.plugin.sight.encode.ui;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

public final class MainSightForwardContainerView$3
  implements Runnable
{
  public MainSightForwardContainerView$3(MainSightForwardContainerView paramMainSightForwardContainerView) {}
  
  public final void run()
  {
    MainSightSelectContactView localMainSightSelectContactView = MainSightForwardContainerView.a(this.ohP);
    localMainSightSelectContactView.ohF = false;
    localMainSightSelectContactView.Nn.clearAnimation();
    localMainSightSelectContactView.Nn.clearFocus();
    localMainSightSelectContactView.Nn.setAdapter(localMainSightSelectContactView.oim);
    localMainSightSelectContactView.E(false, true);
    localMainSightSelectContactView.setVisibility(0);
    if (localMainSightSelectContactView.oil == null)
    {
      localMainSightSelectContactView.oil = new TranslateAnimation(0.0F, 0.0F, localMainSightSelectContactView.oij, 0.0F);
      localMainSightSelectContactView.oil.setDuration(300L);
    }
    localMainSightSelectContactView.Nn.startAnimation(localMainSightSelectContactView.oil);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.3
 * JD-Core Version:    0.7.0.1
 */