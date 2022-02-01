package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.videocomposition.b;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "", "getFrameDuration", "()J", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "isSelected", "setSelected", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackIndex", "getTrackIndex", "setTrackIndex", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "Companion", "plugin-vlog_release"})
public final class c
{
  private static final w BUM;
  public static final a BUN;
  public long BUG;
  public long BUH;
  public float BUI;
  final LinkedList<a> BUJ;
  public boolean BUK;
  public final w BUL;
  public int gLD;
  public int height;
  public int trackIndex;
  public int width;
  
  static
  {
    AppMethodBeat.i(196878);
    BUN = new a((byte)0);
    BUM = new w("", 0);
    AppMethodBeat.o(196878);
  }
  
  public c(w paramw)
  {
    AppMethodBeat.i(196877);
    this.BUL = paramw;
    this.trackIndex = -1;
    this.BUG = this.BUL.BGw.HCU;
    this.BUH = this.BUL.BGw.HCV;
    this.BUI = 1.0F;
    this.BUJ = new LinkedList();
    if (this.BUL.BGw.LmC >= 0L) {
      this.BUG = (this.BUL.BGw.HCU + (this.BUL.BGw.LmC - this.BUL.BGw.startTimeMs));
    }
    if (this.BUL.BGw.LmD >= 0L) {
      this.BUH = (this.BUL.BGw.HCV + (this.BUL.BGw.LmD - this.BUL.BGw.hiy));
    }
    AppMethodBeat.o(196877);
  }
  
  public final long euc()
  {
    return this.BUH - this.BUG;
  }
  
  public final void eud()
  {
    AppMethodBeat.i(196875);
    long l = ((float)euc() / this.BUI);
    int k = (int)Math.ceil(this.BUI);
    this.BUJ.clear();
    if (l >= 1000L) {}
    for (int i = 500;; i = 200)
    {
      int j = 0;
      while (j < k)
      {
        a locala = new a();
        locala.BTX = (d.h.a.K((float)(j * l + this.BUG + l / 2L) * 1.0F / i) * i);
        if (locala.BTX >= this.BUH) {
          locala.BTX = ((this.BUH - 1L) / i * i);
        }
        this.BUJ.add(locala);
        j += 1;
      }
    }
    AppMethodBeat.o(196875);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(196876);
    if (!p.i(this.BUL, BUM)) {
      if (((CharSequence)this.BUL.path).length() != 0) {
        break label49;
      }
    }
    label49:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(196876);
      return true;
    }
    AppMethodBeat.o(196876);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"})
  public static final class a
  {
    public static c euf()
    {
      AppMethodBeat.i(196874);
      c localc = new c(c.eue());
      localc.gLD = 0;
      AppMethodBeat.o(196874);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.c
 * JD-Core Version:    0.7.0.1
 */