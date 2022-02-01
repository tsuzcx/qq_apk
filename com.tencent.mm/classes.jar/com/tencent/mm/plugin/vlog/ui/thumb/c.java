package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.videocomposition.b;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "", "getFrameDuration", "()J", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "isSelected", "setSelected", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackIndex", "getTrackIndex", "setTrackIndex", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "Companion", "plugin-vlog_release"})
public final class c
{
  private static final w Cmn;
  public static final a Cmo;
  public long Cmh;
  public long Cmi;
  public float Cmj;
  final LinkedList<a> Cmk;
  public boolean Cml;
  public final w Cmm;
  public int gOm;
  public int height;
  public int trackIndex;
  public int width;
  
  static
  {
    AppMethodBeat.i(192341);
    Cmo = new a((byte)0);
    Cmn = new w("", 0);
    AppMethodBeat.o(192341);
  }
  
  public c(w paramw)
  {
    AppMethodBeat.i(192340);
    this.Cmm = paramw;
    this.trackIndex = -1;
    this.Cmh = this.Cmm.BXV.HWH;
    this.Cmi = this.Cmm.BXV.HWI;
    this.Cmj = 1.0F;
    this.Cmk = new LinkedList();
    if (this.Cmm.BXV.LJm >= 0L) {
      this.Cmh = (this.Cmm.BXV.HWH + (this.Cmm.BXV.LJm - this.Cmm.BXV.startTimeMs));
    }
    if (this.Cmm.BXV.LJn >= 0L) {
      this.Cmi = (this.Cmm.BXV.HWI + (this.Cmm.BXV.LJn - this.Cmm.BXV.hlm));
    }
    AppMethodBeat.o(192340);
  }
  
  public final long exI()
  {
    return this.Cmi - this.Cmh;
  }
  
  public final void exJ()
  {
    AppMethodBeat.i(192338);
    long l = ((float)exI() / this.Cmj);
    int k = (int)Math.ceil(this.Cmj);
    this.Cmk.clear();
    if (l >= 1000L) {}
    for (int i = 500;; i = 200)
    {
      int j = 0;
      while (j < k)
      {
        a locala = new a();
        locala.Cly = (d.h.a.K((float)(j * l + this.Cmh + l / 2L) * 1.0F / i) * i);
        if (locala.Cly >= this.Cmi) {
          locala.Cly = ((this.Cmi - 1L) / i * i);
        }
        this.Cmk.add(locala);
        j += 1;
      }
    }
    AppMethodBeat.o(192338);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(192339);
    if (!p.i(this.Cmm, Cmn)) {
      if (((CharSequence)this.Cmm.path).length() != 0) {
        break label49;
      }
    }
    label49:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(192339);
      return true;
    }
    AppMethodBeat.o(192339);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"})
  public static final class a
  {
    public static c exL()
    {
      AppMethodBeat.i(192337);
      c localc = new c(c.exK());
      localc.gOm = 0;
      AppMethodBeat.o(192337);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.c
 * JD-Core Version:    0.7.0.1
 */