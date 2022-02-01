package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/VideoClipInfo;", "", "width", "", "height", "rotate", "durationMs", "(IIII)V", "getDurationMs", "()I", "getHeight", "getRotate", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class i
{
  private final int hYK;
  public final int height;
  public final int oTN;
  public final int width;
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.hYK = paramInt3;
    this.oTN = paramInt4;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof i)) {
        break label105;
      }
      paramObject = (i)paramObject;
      if (this.width != paramObject.width) {
        break label107;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label105;
      }
      if (this.height != paramObject.height) {
        break label112;
      }
      i = 1;
      label56:
      bool1 = bool2;
      if (i == 0) {
        break label105;
      }
      if (this.hYK != paramObject.hYK) {
        break label117;
      }
      i = 1;
      label76:
      bool1 = bool2;
      if (i == 0) {
        break label105;
      }
      if (this.oTN != paramObject.oTN) {
        break label122;
      }
    }
    label105:
    label107:
    label112:
    label117:
    label122:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label56;
      i = 0;
      break label76;
    }
  }
  
  public final int hashCode()
  {
    return ((this.width * 31 + this.height) * 31 + this.hYK) * 31 + this.oTN;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(233481);
    String str = "VideoClipInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.hYK + ", durationMs=" + this.oTN + ")";
    AppMethodBeat.o(233481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.i
 * JD-Core Version:    0.7.0.1
 */