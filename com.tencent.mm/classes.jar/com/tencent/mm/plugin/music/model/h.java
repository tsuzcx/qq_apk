package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/MusicFloatBallService;", "Lcom/tencent/mm/modelmusic/api/IMusicFloatBallService;", "()V", "getCurrentMusicWrapperExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "notifyMusicFloatBallCoverChanged", "", "musicId", "", "coverPath", "removeMusicFloatBall", "needStopMusic", "", "resumeMusicFloatBall", "updateMusicInfo", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicWrapperExtend", "Companion", "plugin-music_release"})
public final class h
  implements com.tencent.mm.bb.a.a
{
  public static final h.a FRz;
  
  static
  {
    AppMethodBeat.i(260136);
    FRz = new h.a((byte)0);
    AppMethodBeat.o(260136);
  }
  
  public final void b(f paramf, com.tencent.mm.bb.h paramh)
  {
    AppMethodBeat.i(260128);
    b.b(paramf, paramh);
    AppMethodBeat.o(260128);
  }
  
  public final void bnI()
  {
    AppMethodBeat.i(260131);
    f localf = com.tencent.mm.bb.a.bnA();
    Log.i("MicroMsg.MusicFloatBallService", "alvinluo resumeMusicFloatBall %s", new Object[] { localf });
    if ((localf != null) && (!localf.lVW))
    {
      localf.lVW = true;
      com.tencent.mm.bb.a.b(localf);
    }
    b.x(localf);
    AppMethodBeat.o(260131);
  }
  
  public final void bnJ()
  {
    AppMethodBeat.i(260134);
    b.bnJ();
    AppMethodBeat.o(260134);
  }
  
  public final com.tencent.mm.bb.h bnK()
  {
    AppMethodBeat.i(260132);
    com.tencent.mm.bb.h localh = b.bnK();
    AppMethodBeat.o(260132);
    return localh;
  }
  
  public final void bz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260127);
    b.jh(paramString1, paramString2);
    AppMethodBeat.o(260127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.h
 * JD-Core Version:    0.7.0.1
 */