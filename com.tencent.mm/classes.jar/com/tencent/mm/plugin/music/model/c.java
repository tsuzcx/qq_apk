package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/GlobalMusicMvFloatBallUtil;", "", "()V", "TAG", "", "hideAllFloatBall", "", "hideFloatBall", "", "markHideAllFloatBall", "hide", "onPause", "resumeFloatBall", "onResume", "plugin-mv_release"})
public final class c
{
  private static boolean FRe;
  public static final c FRf;
  
  static
  {
    AppMethodBeat.i(230291);
    FRf = new c();
    AppMethodBeat.o(230291);
  }
  
  public static void cwB()
  {
    AppMethodBeat.i(230288);
    ((b)h.ae(b.class)).ld(true);
    f.cvI();
    AppMethodBeat.o(230288);
  }
  
  public static void onResume()
  {
    AppMethodBeat.i(230276);
    Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo Mv onResume", new Object[0]);
    cwB();
    vs(false);
    AppMethodBeat.o(230276);
  }
  
  public static void vs(boolean paramBoolean)
  {
    AppMethodBeat.i(230284);
    Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo markHideAllFloatBall hide: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    FRe = paramBoolean;
    AppMethodBeat.o(230284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c
 * JD-Core Version:    0.7.0.1
 */