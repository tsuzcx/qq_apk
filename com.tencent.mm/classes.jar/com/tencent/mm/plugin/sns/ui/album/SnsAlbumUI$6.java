package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsAlbumUI$6
  implements Runnable
{
  SnsAlbumUI$6(SnsAlbumUI paramSnsAlbumUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39991);
    if (SnsAlbumUI.h(this.seK))
    {
      ab.w("MicroMsg.SnsAlbumUI", "too fast that it finish");
      AppMethodBeat.o(39991);
      return;
    }
    SnsAlbumUI.e(this.seK).a(2, SnsAlbumUI.b(this.seK), this.seK);
    SnsAlbumUI.e(this.seK).a(2, SnsAlbumUI.b(this.seK), true, SnsAlbumUI.d(this.seK));
    AppMethodBeat.o(39991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.6
 * JD-Core Version:    0.7.0.1
 */