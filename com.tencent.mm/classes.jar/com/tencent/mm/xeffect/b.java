package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/xeffect/PAGLayoutInfo;", "", "translateX", "", "translateY", "scale", "", "rotate", "(IIFF)V", "getRotate", "()F", "setRotate", "(F)V", "getScale", "setScale", "getTranslateX", "()I", "setTranslateX", "(I)V", "getTranslateY", "setTranslateY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "renderlib_release"})
public final class b
{
  float kVl;
  float scale;
  int translateX;
  int translateY;
  
  public b()
  {
    this(0, 0, 0.0F, 15);
  }
  
  public b(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.translateX = paramInt1;
    this.translateY = paramInt2;
    this.scale = paramFloat1;
    this.kVl = paramFloat2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(217070);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label101;
      }
      paramObject = (b)paramObject;
      if (this.translateX != paramObject.translateX) {
        break label91;
      }
      i = 1;
      if (i == 0) {
        break label101;
      }
      if (this.translateY != paramObject.translateY) {
        break label96;
      }
    }
    label91:
    label96:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (Float.compare(this.scale, paramObject.scale) != 0) || (Float.compare(this.kVl, paramObject.kVl) != 0)) {
        break label101;
      }
      AppMethodBeat.o(217070);
      return true;
      i = 0;
      break;
    }
    label101:
    AppMethodBeat.o(217070);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(217069);
    int i = this.translateX;
    int j = this.translateY;
    int k = Float.floatToIntBits(this.scale);
    int m = Float.floatToIntBits(this.kVl);
    AppMethodBeat.o(217069);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(217068);
    String str = "PAGLayoutInfo(translateX=" + this.translateX + ", translateY=" + this.translateY + ", scale=" + this.scale + ", rotate=" + this.kVl + ")";
    AppMethodBeat.o(217068);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.b
 * JD-Core Version:    0.7.0.1
 */