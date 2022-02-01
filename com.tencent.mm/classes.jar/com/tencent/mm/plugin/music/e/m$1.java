package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class m$1
  implements Runnable
{
  m$1(m paramm, String paramString1, String paramString2, String paramString3, String paramString4, com.tencent.mm.plugin.music.model.b.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(220665);
    com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.f.dwu();
    String str1 = this.val$id;
    String str2 = this.wAe;
    String str3 = this.wAf;
    String str4 = this.wAg;
    boolean bool1 = this.wAh.wAO;
    boolean bool2 = this.wAh.wAP;
    a locala = localb.atW(str1);
    if (locala == null)
    {
      ae.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { str1 });
      AppMethodBeat.o(220665);
      return;
    }
    if (!bu.isNullOrNil(str2)) {
      locala.field_songAlbumUrl = str2;
    }
    locala.field_songHAlbumUrl = str3;
    locala.field_songLyric = str4;
    localb.update(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
    localb.wBy.put(str1, locala);
    localb.b(locala, bool1, bool2);
    AppMethodBeat.o(220665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m.1
 * JD-Core Version:    0.7.0.1
 */