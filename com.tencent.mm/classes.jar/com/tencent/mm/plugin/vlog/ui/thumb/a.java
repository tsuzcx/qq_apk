package com.tencent.mm.plugin.vlog.ui.thumb;

import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "", "()V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "endTimeMs", "", "getEndTimeMs", "()J", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "getFrameDuration", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frameWidth", "getFrameWidth", "setFrameWidth", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "isDragLeft", "setDragLeft", "isDragRight", "setDragRight", "isSelected", "setSelected", "playRate", "getPlayRate", "segmentStartTimeMs", "getSegmentStartTimeMs", "setSegmentStartTimeMs", "startTimeMs", "getStartTimeMs", "totalDuration", "getTotalDuration", "trackIndex", "getTrackIndex", "setTrackIndex", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "updateFrameInfoForTotalDuration", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public long UoP;
  public long UoQ;
  public float UoR = 1.0F;
  public final LinkedList<e> UoS = new LinkedList();
  public boolean UoT;
  public long UoU;
  boolean UoV;
  boolean UoW;
  public int height;
  public int mWn;
  int qpD = 1;
  public int trackIndex = -1;
  public int width;
  
  public abstract long getEndTimeMs();
  
  public abstract float getPlayRate();
  
  public abstract long getStartTimeMs();
  
  public abstract long getTotalDuration();
  
  public final long hUo()
  {
    return this.UoQ - this.UoP;
  }
  
  public final void hUp()
  {
    long l = ((float)hUo() / this.UoR);
    int m = (int)Math.ceil(this.UoR);
    this.UoS.clear();
    int i;
    int j;
    if (l >= 1000L)
    {
      i = 500;
      j = 0;
      if (m <= 0) {}
    }
    for (;;)
    {
      int k = j + 1;
      e locale = new e();
      locale.GvM = (kotlin.h.a.ai((float)(j * l + this.UoP + l / 2L) * 1.0F / i) * i);
      if (locale.GvM >= this.UoQ) {
        locale.GvM = ((this.UoQ - 1L) / i * i);
      }
      this.UoS.add(locale);
      if (k >= m)
      {
        return;
        i = 200;
        break;
      }
      j = k;
    }
  }
  
  public abstract boolean isEmpty();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.a
 * JD-Core Version:    0.7.0.1
 */