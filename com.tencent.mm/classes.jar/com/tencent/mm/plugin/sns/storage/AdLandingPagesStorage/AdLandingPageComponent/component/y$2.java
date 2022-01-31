package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class y$2
  extends ak
{
  y$2(y paramy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(145305);
    this.rxQ.abj("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
    this.rxQ.rxN = false;
    AppMethodBeat.o(145305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.2
 * JD-Core Version:    0.7.0.1
 */