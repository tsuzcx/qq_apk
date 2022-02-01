package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/MaterialCacheInfo;", "", "width", "", "height", "rotate", "cropLeft", "cropTop", "cropRight", "cropBottom", "(IIIIIII)V", "getCropBottom", "()I", "setCropBottom", "(I)V", "getCropLeft", "setCropLeft", "getCropRight", "setCropRight", "getCropTop", "setCropTop", "getHeight", "setHeight", "getRotate", "setRotate", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
public final class a
{
  int dwp;
  int height;
  int width;
  int yZN;
  int yZO;
  int yZP;
  int yZQ;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.dwp = paramInt3;
    this.yZN = -1;
    this.yZO = -1;
    this.yZP = -1;
    this.yZQ = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.dwp != paramObject.dwp) || (this.yZN != paramObject.yZN) || (this.yZO != paramObject.yZO) || (this.yZP != paramObject.yZP) || (this.yZQ != paramObject.yZQ)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (((((this.width * 31 + this.height) * 31 + this.dwp) * 31 + this.yZN) * 31 + this.yZO) * 31 + this.yZP) * 31 + this.yZQ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110967);
    String str = "MaterialCacheInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.dwp + ", cropLeft=" + this.yZN + ", cropTop=" + this.yZO + ", cropRight=" + this.yZP + ", cropBottom=" + this.yZQ + ")";
    AppMethodBeat.o(110967);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a
 * JD-Core Version:    0.7.0.1
 */