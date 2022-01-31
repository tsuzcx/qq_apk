package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class ac$1
  implements Runnable
{
  ac$1(ac paramac) {}
  
  public final void run()
  {
    AppMethodBeat.i(37346);
    try
    {
      ac.a(this.ryf).await();
      label15:
      if ((ac.b(this.ryf) != null) && (ac.c(this.ryf) != null)) {
        this.ryf.contentView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37345);
            ac.a(ac.1.this.ryf, ac.b(ac.1.this.ryf), ac.c(ac.1.this.ryf));
            AppMethodBeat.o(37345);
          }
        });
      }
      AppMethodBeat.o(37346);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label15;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.1
 * JD-Core Version:    0.7.0.1
 */