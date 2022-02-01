package com.tencent.mm.plugin.vlog.ui.thumb;

import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "", "()V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "endTimeMs", "", "getEndTimeMs", "()J", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "getFrameDuration", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frameWidth", "getFrameWidth", "setFrameWidth", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "isDragLeft", "setDragLeft", "isDragRight", "setDragRight", "isSelected", "setSelected", "playRate", "getPlayRate", "segmentStartTimeMs", "getSegmentStartTimeMs", "setSegmentStartTimeMs", "startTimeMs", "getStartTimeMs", "totalDuration", "getTotalDuration", "trackIndex", "getTrackIndex", "setTrackIndex", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "updateFrameInfoForTotalDuration", "plugin-vlog_release"})
public abstract class a
{
  public long NCj;
  public long NCk;
  public float NCl = 1.0F;
  public final LinkedList<e> NCm = new LinkedList();
  public boolean NCn;
  public long NCo;
  boolean NCp;
  boolean NCq;
  public int height;
  public int ksu;
  int nqW = 1;
  public int trackIndex = -1;
  public int width;
  
  public abstract long getEndTimeMs();
  
  public abstract float getPlayRate();
  
  public abstract long getStartTimeMs();
  
  public abstract long getTotalDuration();
  
  public final long gwv()
  {
    return this.NCk - this.NCj;
  }
  
  public final void gww()
  {
    long l = ((float)gwv() / this.NCl);
    int k = (int)Math.ceil(this.NCl);
    this.NCm.clear();
    if (l >= 1000L) {}
    for (int i = 500;; i = 200)
    {
      int j = 0;
      while (j < k)
      {
        e locale = new e();
        locale.GhA = (kotlin.h.a.N((float)(j * l + this.NCj + l / 2L) * 1.0F / i) * i);
        if (locale.GhA >= this.NCk) {
          locale.GhA = ((this.NCk - 1L) / i * i);
        }
        this.NCm.add(locale);
        j += 1;
      }
    }
  }
  
  public abstract boolean isEmpty();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.a
 * JD-Core Version:    0.7.0.1
 */