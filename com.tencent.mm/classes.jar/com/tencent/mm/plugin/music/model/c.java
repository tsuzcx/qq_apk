package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/GlobalMusicMvFloatBallUtil;", "", "()V", "TAG", "", "hideAllFloatBall", "", "hideFloatBall", "", "markHideAllFloatBall", "hide", "onPause", "resumeFloatBall", "onResume", "plugin-mv_release"})
public final class c
{
  private static boolean Akb;
  public static final c Akc;
  
  static
  {
    AppMethodBeat.i(256734);
    Akc = new c();
    AppMethodBeat.o(256734);
  }
  
  public static void cjj()
  {
    AppMethodBeat.i(256733);
    ((b)g.af(b.class)).jS(true);
    f.cjk();
    AppMethodBeat.o(256733);
  }
  
  public static void onResume()
  {
    AppMethodBeat.i(256730);
    Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo Mv onResume", new Object[0]);
    cjj();
    sm(false);
    AppMethodBeat.o(256730);
  }
  
  public static void sm(boolean paramBoolean)
  {
    AppMethodBeat.i(256732);
    Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo markHideAllFloatBall hide: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Akb = paramBoolean;
    AppMethodBeat.o(256732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c
 * JD-Core Version:    0.7.0.1
 */