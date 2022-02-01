package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.b;
import d.l;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
public final class c$f
  implements a.a.b
{
  public final void cLW()
  {
    AppMethodBeat.i(196158);
    Object localObject = ((Iterable)c.c(this.BNd)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c.b localb = (c.b)((Iterator)localObject).next();
      if ((localb instanceof c.c)) {
        ((c.c)localb).a(this.BNd.BMF);
      }
    }
    localObject = c.d(this.BNd);
    long l;
    if (localObject != null)
    {
      l = ((VideoCompositionPlayView)localObject).getPosition();
      localObject = this.BNd.BMG;
      if (localObject != null)
      {
        ((c.e)localObject).Br(l + this.BNd.BMU);
        AppMethodBeat.o(196158);
      }
    }
    else
    {
      localObject = c.e(this.BNd);
      if (localObject != null) {}
      for (l = ((com.tencent.mm.plugin.vlog.model.v)localObject).BGk.getPlayStart();; l = 0L)
      {
        l = 0L - l / 1000L;
        break;
      }
    }
    AppMethodBeat.o(196158);
  }
  
  public final void cLX() {}
  
  public final void cLY()
  {
    AppMethodBeat.i(196159);
    Iterator localIterator = ((Iterable)c.c(this.BNd)).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(196159);
  }
  
  public final void cLZ()
  {
    AppMethodBeat.i(196161);
    Object localObject = c.d(this.BNd);
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(196161);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    d.b.a(this.BNd.sQE, d.c.xEX);
    AppMethodBeat.o(196161);
  }
  
  public final void cMa() {}
  
  public final void cMb() {}
  
  public final void xp(long paramLong)
  {
    AppMethodBeat.i(196160);
    ad.d("MicroMsg.EditMultiPreviewPlugin", "onPlayProgress timeMs:".concat(String.valueOf(paramLong)));
    Iterator localIterator = ((Iterable)c.c(this.BNd)).iterator();
    while (localIterator.hasNext())
    {
      c.b localb = (c.b)localIterator.next();
      if ((localb instanceof c.c)) {
        ((c.c)localb).Bq(paramLong);
      }
    }
    AppMethodBeat.o(196160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c.f
 * JD-Core Version:    0.7.0.1
 */