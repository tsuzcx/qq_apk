package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

final class MMSightTopCountdownCoverView$2
  implements Runnable
{
  MMSightTopCountdownCoverView$2(MMSightTopCountdownCoverView paramMMSightTopCountdownCoverView) {}
  
  public final void run()
  {
    AppMethodBeat.i(140579);
    long l2 = MMSightTopCountdownCoverView.b(this.oOy) - 400L - MMSightTopCountdownCoverView.c(this.oOy);
    long l1 = l2 / TimeUnit.MINUTES.toMillis(1L);
    l2 = Math.max(Math.round(l2 % TimeUnit.MINUTES.toMillis(1L) / TimeUnit.SECONDS.toMillis(1L)), 0L);
    String str = String.format(Locale.US, "%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    MMSightTopCountdownCoverView.d(this.oOy).setText(str);
    MMSightTopCountdownCoverView.e(this.oOy).postDelayed(this, 1000L);
    MMSightTopCountdownCoverView.a(this.oOy, MMSightTopCountdownCoverView.c(this.oOy) + 1000L);
    AppMethodBeat.o(140579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView.2
 * JD-Core Version:    0.7.0.1
 */