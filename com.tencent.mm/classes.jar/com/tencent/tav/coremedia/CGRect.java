package com.tencent.tav.coremedia;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CGRect
  implements Cloneable
{
  public final PointF origin;
  public final CGSize size;
  
  public CGRect()
  {
    AppMethodBeat.i(219386);
    this.origin = new PointF();
    this.size = new CGSize();
    AppMethodBeat.o(219386);
  }
  
  public CGRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new CGSize(paramFloat3, paramFloat4));
    AppMethodBeat.i(219384);
    AppMethodBeat.o(219384);
  }
  
  public CGRect(PointF paramPointF, CGSize paramCGSize)
  {
    AppMethodBeat.i(219385);
    PointF localPointF = paramPointF;
    if (paramPointF == null) {
      localPointF = new PointF();
    }
    paramPointF = paramCGSize;
    if (paramCGSize == null) {
      paramPointF = new CGSize();
    }
    this.origin = localPointF;
    this.size = paramPointF;
    AppMethodBeat.o(219385);
  }
  
  public CGRect clone()
  {
    AppMethodBeat.i(219389);
    CGRect localCGRect = new CGRect(this.origin.x, this.origin.y, this.size.width, this.size.height);
    AppMethodBeat.o(219389);
    return localCGRect;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(219387);
    if (this == paramObject)
    {
      AppMethodBeat.o(219387);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(219387);
      return false;
    }
    paramObject = (CGRect)paramObject;
    if ((this.origin.equals(paramObject.origin)) && (this.size.equals(paramObject.size)))
    {
      AppMethodBeat.o(219387);
      return true;
    }
    AppMethodBeat.o(219387);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(219388);
    String str = "[" + this.origin + "," + this.size + "]";
    AppMethodBeat.o(219388);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGRect
 * JD-Core Version:    0.7.0.1
 */