package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.u;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "", "getFrameDuration", "()J", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackIndex", "getTrackIndex", "setTrackIndex", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final u AvD;
  public static final a AvE;
  public final u AnN;
  public float AvA;
  final LinkedList<a> AvB;
  public boolean AvC;
  public long Avy;
  public long Avz;
  public int grV;
  public int height;
  public int trackIndex;
  public int width;
  
  static
  {
    AppMethodBeat.i(207948);
    AvE = new a((byte)0);
    AvD = new u("", 0);
    AppMethodBeat.o(207948);
  }
  
  public d(u paramu)
  {
    AppMethodBeat.i(207947);
    this.AnN = paramu;
    this.trackIndex = -1;
    this.Avy = this.AnN.Aox;
    this.Avz = this.AnN.Aoy;
    this.AvA = 1.0F;
    this.AvB = new LinkedList();
    AppMethodBeat.o(207947);
  }
  
  public final long egs()
  {
    return this.Avz - this.Avy;
  }
  
  public final void egt()
  {
    AppMethodBeat.i(207946);
    long l = ((float)egs() / this.AvA);
    int j = (int)Math.ceil(this.AvA);
    this.AvB.clear();
    int i = 0;
    while (i < j)
    {
      a locala = new a();
      locala.Aoq = ((i * l + this.Avy) / 500L * 500L + 250L);
      this.AvB.add(locala);
      i += 1;
    }
    AppMethodBeat.o(207946);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"})
  public static final class a
  {
    public static d egv()
    {
      AppMethodBeat.i(207945);
      d locald = new d(d.egu());
      locald.grV = 0;
      AppMethodBeat.o(207945);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.d
 * JD-Core Version:    0.7.0.1
 */