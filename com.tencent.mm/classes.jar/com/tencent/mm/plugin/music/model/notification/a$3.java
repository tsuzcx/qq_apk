package com.tencent.mm.plugin.music.model.notification;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.c;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;

final class a$3
  implements c
{
  a$3(a parama, com.tencent.mm.plugin.music.model.e.a parama1, String paramString) {}
  
  public final void cZ(boolean paramVarArgs)
  {
    AppMethodBeat.i(151913);
    ab.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[] { this.oZB.field_songAlbumUrl, Boolean.valueOf(paramVarArgs) });
    if (paramVarArgs)
    {
      Bitmap localBitmap = d.decodeFile(this.oZW, null);
      if (localBitmap == null)
      {
        ab.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
        AppMethodBeat.o(151913);
        return;
      }
      o.ahG().j(this.oZB.field_songAlbumUrl, localBitmap);
      this.oZV.oZR.refresh();
    }
    AppMethodBeat.o(151913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a.3
 * JD-Core Version:    0.7.0.1
 */