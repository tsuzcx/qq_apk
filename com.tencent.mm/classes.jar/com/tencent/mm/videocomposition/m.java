package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/VideoClipInfo;", "", "width", "", "height", "rotate", "durationMs", "(IIII)V", "getDurationMs", "()I", "getHeight", "getRotate", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "video_composition_release"})
public final class m
{
  private final int dYT;
  final int height;
  private final int jkS;
  final int width;
  
  public m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.dYT = paramInt3;
    this.jkS = paramInt4;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof m)) {
        break label105;
      }
      paramObject = (m)paramObject;
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
      if (this.dYT != paramObject.dYT) {
        break label117;
      }
      i = 1;
      label76:
      bool1 = bool2;
      if (i == 0) {
        break label105;
      }
      if (this.jkS != paramObject.jkS) {
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
    return ((this.width * 31 + this.height) * 31 + this.dYT) * 31 + this.jkS;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216764);
    String str = "VideoClipInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.dYT + ", durationMs=" + this.jkS + ")";
    AppMethodBeat.o(216764);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.m
 * JD-Core Version:    0.7.0.1
 */