package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/GlobalMusicMvFloatBallUtil;", "", "()V", "TAG", "", "hideAllFloatBall", "", "hideFloatBall", "", "markHideAllFloatBall", "hide", "onPause", "resumeFloatBall", "onResume", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c LLZ;
  private static boolean LMa;
  
  static
  {
    AppMethodBeat.i(271130);
    LLZ = new c();
    AppMethodBeat.o(271130);
  }
  
  public static void gnP()
  {
    AppMethodBeat.i(271113);
    Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo Mv onPause hideAllFloatBall: %s, resumeFloatBall: %b", new Object[] { Boolean.valueOf(LMa), Boolean.TRUE });
    if (!LMa)
    {
      ((b)h.ax(b.class)).mq(false);
      f.d(false, true, true);
    }
    AppMethodBeat.o(271113);
  }
  
  public static void gnR()
  {
    AppMethodBeat.i(271123);
    ((b)h.ax(b.class)).mq(true);
    f.d(true, false, true);
    AppMethodBeat.o(271123);
  }
  
  public static void onResume()
  {
    AppMethodBeat.i(271110);
    Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo Mv onResume", new Object[0]);
    gnR();
    zK(false);
    AppMethodBeat.o(271110);
  }
  
  public static void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(271119);
    Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo markHideAllFloatBall hide: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    LMa = paramBoolean;
    AppMethodBeat.o(271119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c
 * JD-Core Version:    0.7.0.1
 */