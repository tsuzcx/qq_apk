package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/MaterialCacheInfo;", "", "width", "", "height", "rotate", "cropLeft", "cropTop", "cropRight", "cropBottom", "(IIIIIII)V", "getCropBottom", "()I", "setCropBottom", "(I)V", "getCropLeft", "setCropLeft", "getCropRight", "setCropRight", "getCropTop", "setCropTop", "getHeight", "setHeight", "getRotate", "setRotate", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  int hYK;
  int height;
  int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.hYK = paramInt3;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
      if (this.height != paramObject.height) {
        return false;
      }
      if (this.hYK != paramObject.hYK) {
        return false;
      }
      if (this.cropLeft != paramObject.cropLeft) {
        return false;
      }
      if (this.cropTop != paramObject.cropTop) {
        return false;
      }
      if (this.cropRight != paramObject.cropRight) {
        return false;
      }
    } while (this.cropBottom == paramObject.cropBottom);
    return false;
  }
  
  public final int hashCode()
  {
    return (((((this.width * 31 + this.height) * 31 + this.hYK) * 31 + this.cropLeft) * 31 + this.cropTop) * 31 + this.cropRight) * 31 + this.cropBottom;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110967);
    String str = "MaterialCacheInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.hYK + ", cropLeft=" + this.cropLeft + ", cropTop=" + this.cropTop + ", cropRight=" + this.cropRight + ", cropBottom=" + this.cropBottom + ')';
    AppMethodBeat.o(110967);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a
 * JD-Core Version:    0.7.0.1
 */