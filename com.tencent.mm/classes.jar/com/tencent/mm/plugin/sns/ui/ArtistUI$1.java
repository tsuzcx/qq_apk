package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.y;

final class ArtistUI$1
  implements Runnable
{
  ArtistUI$1(ArtistUI paramArtistUI) {}
  
  public final void run()
  {
    if (ArtistUI.a(this.oNf) == null) {
      return;
    }
    y.d("MicroMsg.ArtistUI", "will pause ImageLoader");
    af.bDC().pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI.1
 * JD-Core Version:    0.7.0.1
 */