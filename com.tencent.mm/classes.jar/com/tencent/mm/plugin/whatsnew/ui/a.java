package com.tencent.mm.plugin.whatsnew.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/Bubble;", "", "x", "", "y", "radius", "radians", "speed", "color", "", "(DDDDDI)V", "getColor", "()I", "setColor", "(I)V", "getRadians", "()D", "setRadians", "(D)V", "getRadius", "setRadius", "getSpeed", "setSpeed", "getX", "setX", "getY", "setY", "canRemove", "", "width", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "isInScreen", "height", "toString", "", "update", "", "deltaTs", "", "app_release"})
public final class a
{
  double JOx;
  int color;
  double dxQ;
  double radius;
  double x;
  double y;
  
  public a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
    this.radius = paramDouble3;
    this.JOx = paramDouble4;
    this.dxQ = paramDouble5;
    this.color = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(230934);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Double.compare(this.x, paramObject.x) != 0) || (Double.compare(this.y, paramObject.y) != 0) || (Double.compare(this.radius, paramObject.radius) != 0) || (Double.compare(this.JOx, paramObject.JOx) != 0) || (Double.compare(this.dxQ, paramObject.dxQ) != 0) || (this.color != paramObject.color)) {}
      }
    }
    else
    {
      AppMethodBeat.o(230934);
      return true;
    }
    AppMethodBeat.o(230934);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(230933);
    long l = Double.doubleToLongBits(this.x);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.y);
    int j = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.radius);
    int k = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.JOx);
    int m = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.dxQ);
    int n = (int)(l ^ l >>> 32);
    int i1 = this.color;
    AppMethodBeat.o(230933);
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(230932);
    String str = "Bubble(x=" + this.x + ", y=" + this.y + ", radius=" + this.radius + ", radians=" + this.JOx + ", speed=" + this.dxQ + ", color=" + this.color + ")";
    AppMethodBeat.o(230932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.a
 * JD-Core Version:    0.7.0.1
 */