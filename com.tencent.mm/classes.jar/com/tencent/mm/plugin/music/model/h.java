package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/MusicFloatBallService;", "Lcom/tencent/mm/modelmusic/api/IMusicFloatBallService;", "()V", "checkCurrentFloatIsMusic", "", "getCurrentMusicWrapperExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "notifyMusicFloatBallCoverChanged", "", "musicId", "", "coverPath", "removeMusicFloatBall", "needStopMusic", "resumeMusicFloatBall", "updateMusicInfo", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicWrapperExtend", "Companion", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements com.tencent.mm.aw.a.a
{
  public static final h.a LMt;
  
  static
  {
    AppMethodBeat.i(271117);
    LMt = new h.a((byte)0);
    AppMethodBeat.o(271117);
  }
  
  public final void b(f paramf, com.tencent.mm.aw.h paramh)
  {
    AppMethodBeat.i(271127);
    b.b(paramf, paramh);
    AppMethodBeat.o(271127);
  }
  
  public final void bK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271120);
    b.kw(paramString1, paramString2);
    AppMethodBeat.o(271120);
  }
  
  public final void bLv()
  {
    int j = 0;
    AppMethodBeat.i(271135);
    f localf = com.tencent.mm.aw.a.bLn();
    Log.i("MicroMsg.MusicFloatBallService", "alvinluo resumeMusicFloatBall %s", new Object[] { localf });
    int i = j;
    if (localf != null)
    {
      i = j;
      if (!localf.oOY) {
        i = 1;
      }
    }
    if (i != 0)
    {
      localf.oOY = true;
      com.tencent.mm.aw.a.b(localf);
    }
    b.B(localf);
    AppMethodBeat.o(271135);
  }
  
  public final boolean bLw()
  {
    AppMethodBeat.i(271154);
    Object localObject = d.LMb;
    localObject = d.b.LMj;
    boolean bool = d.b.gnV().cYo();
    AppMethodBeat.o(271154);
    return bool;
  }
  
  public final com.tencent.mm.aw.h bLx()
  {
    AppMethodBeat.i(271143);
    com.tencent.mm.aw.h localh = b.bLx();
    AppMethodBeat.o(271143);
    return localh;
  }
  
  public final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(271148);
    b.hj(paramBoolean);
    AppMethodBeat.o(271148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.h
 * JD-Core Version:    0.7.0.1
 */