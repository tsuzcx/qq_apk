package com.tencent.mm.plugin.mv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/PluginMv$floatBallEventIListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "onFloatBallInfoAdded", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoClicked", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-mv_release"})
public final class PluginMv$a
  implements e
{
  public final void b(BallInfo paramBallInfo) {}
  
  public final void c(BallInfo paramBallInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(227488);
    paramBallInfo = com.tencent.mm.plugin.mv.model.l.Gcr;
    StringBuilder localStringBuilder = new StringBuilder("onMusicStop, songName:");
    paramBallInfo = com.tencent.mm.plugin.mv.model.l.GaB;
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.HLH;; paramBallInfo = null)
    {
      localStringBuilder = localStringBuilder.append(paramBallInfo).append(", singer:");
      bds localbds = com.tencent.mm.plugin.mv.model.l.GaB;
      paramBallInfo = localObject;
      if (localbds != null) {
        paramBallInfo = localbds.ozs;
      }
      Log.i("MicroMsg.Mv.MvChattingDataManger", paramBallInfo);
      com.tencent.mm.plugin.mv.model.l.Gcp = 2;
      if (!com.tencent.mm.plugin.mv.model.l.Gcq) {
        com.tencent.mm.plugin.mv.model.l.fge();
      }
      AppMethodBeat.o(227488);
      return;
    }
  }
  
  public final void d(BallInfo paramBallInfo) {}
  
  public final void g(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(227490);
    paramBallInfo = com.tencent.mm.plugin.mv.model.l.Gcr;
    com.tencent.mm.plugin.mv.model.l.fgd();
    AppMethodBeat.o(227490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.PluginMv.a
 * JD-Core Version:    0.7.0.1
 */