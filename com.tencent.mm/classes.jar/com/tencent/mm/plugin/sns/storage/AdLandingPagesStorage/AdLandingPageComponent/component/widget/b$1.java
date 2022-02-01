package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(96872);
    long l = System.currentTimeMillis();
    SightVideoJNI.freeObj(this.val$id);
    Log.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(this.EhD.hashCode()), Integer.valueOf(this.val$id), Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(96872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.1
 * JD-Core Version:    0.7.0.1
 */