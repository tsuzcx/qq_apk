package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.ab;

final class ArtistUI$1
  implements Runnable
{
  ArtistUI$1(ArtistUI paramArtistUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(38114);
    if (ArtistUI.a(this.rEQ) == null)
    {
      AppMethodBeat.o(38114);
      return;
    }
    ab.d("MicroMsg.ArtistUI", "will pause ImageLoader");
    ag.cpc().pause();
    AppMethodBeat.o(38114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI.1
 * JD-Core Version:    0.7.0.1
 */