package com.tencent.mm.plugin.thumbplayer.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaInfo;", "", "width", "", "height", "rotate", "(III)V", "getHeight", "()I", "setHeight", "(I)V", "getRotate", "setRotate", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-thumbplayer_release"})
public final class d
{
  public int fSM;
  public int height;
  public int width;
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.fSM = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.fSM != paramObject.fSM)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (this.width * 31 + this.height) * 31 + this.fSM;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190589);
    String str = "MultiMediaInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.fSM + ")";
    AppMethodBeat.o(190589);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.a.d
 * JD-Core Version:    0.7.0.1
 */