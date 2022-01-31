package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  implements Runnable
{
  h$1(h paramh, int paramInt, h.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(145727);
    ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch, delay=" + this.sit);
    this.siu.siz.setTouchEnabled(true);
    AppMethodBeat.o(145727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h.1
 * JD-Core Version:    0.7.0.1
 */