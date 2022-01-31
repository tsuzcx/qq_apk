package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import java.util.concurrent.CountDownLatch;

final class ab$1
  implements Runnable
{
  ab$1(ab paramab) {}
  
  public final void run()
  {
    try
    {
      ab.a(this.oIk).await();
      label10:
      this.oIk.contentView.post(new ab.1.1(this));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.1
 * JD-Core Version:    0.7.0.1
 */