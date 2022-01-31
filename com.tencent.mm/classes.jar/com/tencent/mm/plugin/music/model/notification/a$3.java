package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements com.tencent.mm.as.a.c.c
{
  a$3(a parama, com.tencent.mm.plugin.music.model.e.a parama1, String paramString) {}
  
  public final void a(boolean paramBoolean, Object... paramVarArgs)
  {
    y.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[] { this.mzv.field_songAlbumUrl, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      paramVarArgs = com.tencent.mm.sdk.platformtools.c.decodeFile(this.mzQ, null);
      if (paramVarArgs == null) {
        y.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
      }
    }
    else
    {
      return;
    }
    o.ON().i(this.mzv.field_songAlbumUrl, paramVarArgs);
    this.mzP.mzL.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a.3
 * JD-Core Version:    0.7.0.1
 */