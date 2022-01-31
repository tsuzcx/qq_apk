package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.lang.ref.WeakReference;

final class b$j
  implements Runnable
{
  private b$j(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(37429);
    if ((b.e(this.ryy) < 0) || (b.j(this.ryy) == null) || (b.j(this.ryy).get() == null))
    {
      AppMethodBeat.o(37429);
      return;
    }
    String str = SightVideoJNI.getVideoInfo(b.e(this.ryy));
    ((TextView)b.j(this.ryy).get()).setText(str);
    AppMethodBeat.o(37429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.j
 * JD-Core Version:    0.7.0.1
 */