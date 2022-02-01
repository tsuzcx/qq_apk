package com.tencent.mm.plugin.music.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.sdk.platformtools.ad;

final class f$1
  implements x.a
{
  f$1(f paramf) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(63155);
    ad.i("MicroMsg.Music.MusicWechatReportService", "reportMusicInfo callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(63155);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.f.1
 * JD-Core Version:    0.7.0.1
 */