package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class SnsAlbumUI$5
  extends d
{
  SnsAlbumUI$5(SnsAlbumUI paramSnsAlbumUI) {}
  
  public final void Kt()
  {
    AppMethodBeat.i(39990);
    ab.d("MicroMsg.SnsAlbumUI", "onLoadMore");
    if (SnsAlbumUI.c(this.seK) == 0)
    {
      SnsAlbumUI.e(this.seK).b(2, SnsAlbumUI.b(this.seK), true, SnsAlbumUI.d(this.seK));
      ag.bEf().postDelayed(SnsAlbumUI.f(this.seK), 3000L);
      SnsAlbumUI.g(this.seK);
    }
    AppMethodBeat.o(39990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.5
 * JD-Core Version:    0.7.0.1
 */