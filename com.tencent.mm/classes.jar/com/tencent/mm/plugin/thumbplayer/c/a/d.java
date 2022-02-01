package com.tencent.mm.plugin.thumbplayer.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaInfo;", "", "width", "", "height", "rotate", "(III)V", "getHeight", "()I", "setHeight", "(I)V", "getRotate", "setRotate", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public int hYK;
  public int height;
  public int width;
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.hYK = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
      if (this.height != paramObject.height) {
        return false;
      }
    } while (this.hYK == paramObject.hYK);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.width * 31 + this.height) * 31 + this.hYK;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(272629);
    String str = "MultiMediaInfo(width=" + this.width + ", height=" + this.height + ", rotate=" + this.hYK + ')';
    AppMethodBeat.o(272629);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a.d
 * JD-Core Version:    0.7.0.1
 */