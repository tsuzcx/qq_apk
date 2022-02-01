package com.tencent.mm.plugin.sns.ui.album;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsAlbumUI$3
  implements c.a
{
  SnsAlbumUI$3(SnsAlbumUI paramSnsAlbumUI) {}
  
  public final void dk(int paramInt, String paramString)
  {
    AppMethodBeat.i(99878);
    Log.i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    SnsAlbumUI.a(this.RHX, paramInt, paramString);
    AppMethodBeat.o(99878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.3
 * JD-Core Version:    0.7.0.1
 */