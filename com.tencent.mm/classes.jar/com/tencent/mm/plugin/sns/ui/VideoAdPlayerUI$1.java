package com.tencent.mm.plugin.sns.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class VideoAdPlayerUI$1
  implements VideoPlayView.a
{
  VideoAdPlayerUI$1(VideoAdPlayerUI paramVideoAdPlayerUI) {}
  
  public final void Dv(int paramInt)
  {
    AppMethodBeat.i(39911);
    if (VideoAdPlayerUI.i(this.sdl) == 0)
    {
      VideoAdPlayerUI.a(this.sdl, paramInt);
      VideoAdPlayerUI.j(this.sdl).sdf = paramInt;
    }
    AppMethodBeat.o(39911);
  }
  
  public final void cmR()
  {
    AppMethodBeat.i(39908);
    VideoAdPlayerUI.d(this.sdl).cJ(false);
    a locala = VideoAdPlayerUI.a(this.sdl).qZJ;
    locala.raJ += (int)bo.av(VideoAdPlayerUI.a(this.sdl).qZJ.raN);
    VideoAdPlayerUI.a(this.sdl, false);
    AppMethodBeat.o(39908);
  }
  
  public final void cmS()
  {
    AppMethodBeat.i(39909);
    ab.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
    Object localObject = VideoAdPlayerUI.a(this.sdl).qZJ;
    ((a)localObject).raI += 1;
    VideoAdPlayerUI.a(this.sdl, false);
    if (VideoAdPlayerUI.e(this.sdl) != 0)
    {
      localObject = new i(13227, "1,2," + VideoAdPlayerUI.i(this.sdl) + "," + VideoAdPlayerUI.f(this.sdl) + "," + VideoAdPlayerUI.g(this.sdl) + "," + bo.aox() + "," + VideoAdPlayerUI.h(this.sdl) + "," + VideoAdPlayerUI.i(this.sdl), (int)bo.aox());
      g.RM();
      g.RK().eHt.a((m)localObject, 0);
    }
    AppMethodBeat.o(39909);
  }
  
  public final void cmT()
  {
    AppMethodBeat.i(39910);
    ab.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
    VideoAdPlayerUI.a(this.sdl, false);
    VideoAdPlayerUI.c(this.sdl).cmO();
    AppMethodBeat.o(39910);
  }
  
  public final void kU(boolean paramBoolean)
  {
    AppMethodBeat.i(39907);
    Object localObject;
    if (paramBoolean)
    {
      localObject = VideoAdPlayerUI.a(this.sdl).qZJ;
      if (this.sdl.getResources().getConfiguration().orientation != 2) {
        break label301;
      }
    }
    label301:
    for (int i = 2;; i = 1)
    {
      ((a)localObject).raM = i;
      VideoAdPlayerUI.a(this.sdl).qZJ.raN = bo.yB();
      VideoAdPlayerUI.a(this.sdl).qZJ.raL = 2;
      VideoAdPlayerUI.a(this.sdl).qZJ.raJ = 0;
      if ((!VideoAdPlayerUI.b(this.sdl)) && ((int)VideoAdPlayerUI.c(this.sdl).getLastProgresstime() == 0))
      {
        localObject = VideoAdPlayerUI.a(this.sdl).qZJ;
        ((a)localObject).raH += 1;
      }
      VideoAdPlayerUI.a(this.sdl).qZJ.raN = bo.yB();
      VideoAdPlayerUI.d(this.sdl).a(VideoAdPlayerUI.c(this.sdl));
      if (VideoAdPlayerUI.e(this.sdl) != 0)
      {
        localObject = new i(13227, "1,1,0," + VideoAdPlayerUI.f(this.sdl) + "," + VideoAdPlayerUI.g(this.sdl) + "," + bo.aox() + "," + VideoAdPlayerUI.h(this.sdl) + "," + VideoAdPlayerUI.i(this.sdl), (int)bo.aox());
        g.RM();
        g.RK().eHt.a((m)localObject, 0);
      }
      VideoAdPlayerUI.a(this.sdl, true);
      AppMethodBeat.o(39907);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.1
 * JD-Core Version:    0.7.0.1
 */