package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/MaterialCacheInfo;", "", "width", "", "height", "rotate", "cropLeft", "cropTop", "cropRight", "cropBottom", "(IIIIIII)V", "getCropBottom", "()I", "setCropBottom", "(I)V", "getCropLeft", "setCropLeft", "getCropRight", "setCropRight", "getCropTop", "setCropTop", "getHeight", "setHeight", "getRotate", "setRotate", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
public final class a
{
  int cropBottom;
  int cropLeft;
  int cropRight;
  int cropTop;
  int dYT;
  int height;
  int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.dYT = paramInt3;
    this.cropLeft = -1;
    this.cropTop = -1;
    this.cropRight = -1;
    this.cropBottom = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.dYT != paramObject.dYT) || (this.cropLeft != paramObject.cropLeft) || (this.cropTop != paramObject.cropTop) || (this.cropRight != paramObject.cropRight) || (this.cropBottom != paramObject.cropBottom)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (((((this.width * 31 + this.height) * 31 + this.dYT) * 31 + this.cropLeft) * 31 + this.cropTop) * 31 + this.cropRight) * 31 + this.cropBottom;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110967);
    String str = "MaterialCacheInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.dYT + ", cropLeft=" + this.cropLeft + ", cropTop=" + this.cropTop + ", cropRight=" + this.cropRight + ", cropBottom=" + this.cropBottom + ")";
    AppMethodBeat.o(110967);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a
 * JD-Core Version:    0.7.0.1
 */