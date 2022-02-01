package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.y;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "", "getFrameDuration", "()J", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackIndex", "getTrackIndex", "setTrackIndex", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final y LvQ;
  public static final a LvR;
  public final y LqI;
  public long LvL;
  public long LvM;
  public float LvN;
  final LinkedList<a> LvO;
  public boolean LvP;
  public int guK;
  public int height;
  public int trackIndex;
  public int width;
  
  static
  {
    AppMethodBeat.i(201260);
    LvR = new a((byte)0);
    LvQ = new y("", 0);
    AppMethodBeat.o(201260);
  }
  
  public d(y paramy)
  {
    AppMethodBeat.i(201259);
    this.LqI = paramy;
    this.trackIndex = -1;
    this.LvL = this.LqI.Lro;
    this.LvM = this.LqI.Lrp;
    this.LvN = 1.0F;
    this.LvO = new LinkedList();
    AppMethodBeat.o(201259);
  }
  
  public final long fZr()
  {
    return this.LvM - this.LvL;
  }
  
  public final void fZs()
  {
    AppMethodBeat.i(201258);
    long l = ((float)fZr() / this.LvN);
    int j = (int)Math.ceil(this.LvN);
    this.LvO.clear();
    int i = 0;
    while (i < j)
    {
      a locala = new a();
      locala.Lri = ((i * l + this.LvL) / 500L * 500L);
      this.LvO.add(locala);
      i += 1;
    }
    AppMethodBeat.o(201258);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"})
  public static final class a
  {
    public static d fZu()
    {
      AppMethodBeat.i(201257);
      d locald = new d(d.fZt());
      locald.guK = 0;
      AppMethodBeat.o(201257);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.d
 * JD-Core Version:    0.7.0.1
 */