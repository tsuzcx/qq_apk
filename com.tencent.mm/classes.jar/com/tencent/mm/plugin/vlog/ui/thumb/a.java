package com.tencent.mm.plugin.vlog.ui.thumb;

import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "", "()V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "", "getFrameDuration", "()J", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "isSelected", "setSelected", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "plugin-vlog_release"})
public abstract class a
{
  public long GOD;
  public long GOE;
  public float GOF = 1.0F;
  final LinkedList<e> GOG = new LinkedList();
  public boolean GOH;
  public int hEp;
  public int height;
  public int width;
  
  public final long fEu()
  {
    return this.GOE - this.GOD;
  }
  
  public final void fEv()
  {
    long l = ((float)fEu() / this.GOF);
    int k = (int)Math.ceil(this.GOF);
    this.GOG.clear();
    if (l >= 1000L) {}
    for (int i = 500;; i = 200)
    {
      int j = 0;
      while (j < k)
      {
        e locale = new e();
        locale.Asv = (kotlin.h.a.L((float)(j * l + this.GOD + l / 2L) * 1.0F / i) * i);
        if (locale.Asv >= this.GOE) {
          locale.Asv = ((this.GOE - 1L) / i * i);
        }
        this.GOG.add(locale);
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.a
 * JD-Core Version:    0.7.0.1
 */