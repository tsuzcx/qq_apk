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
    AppMethodBeat.i(195684);
    this.origin = new PointF();
    this.size = new CGSize();
    AppMethodBeat.o(195684);
  }
  
  public CGRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new CGSize(paramFloat3, paramFloat4));
    AppMethodBeat.i(195682);
    AppMethodBeat.o(195682);
  }
  
  public CGRect(PointF paramPointF, CGSize paramCGSize)
  {
    AppMethodBeat.i(195683);
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
    AppMethodBeat.o(195683);
  }
  
  public CGRect clone()
  {
    AppMethodBeat.i(195687);
    CGRect localCGRect = new CGRect(this.origin.x, this.origin.y, this.size.width, this.size.height);
    AppMethodBeat.o(195687);
    return localCGRect;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195685);
    if (this == paramObject)
    {
      AppMethodBeat.o(195685);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(195685);
      return false;
    }
    paramObject = (CGRect)paramObject;
    if ((this.origin.equals(paramObject.origin)) && (this.size.equals(paramObject.size)))
    {
      AppMethodBeat.o(195685);
      return true;
    }
    AppMethodBeat.o(195685);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(195686);
    String str = "[" + this.origin + "," + this.size + "]";
    AppMethodBeat.o(195686);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGRect
 * JD-Core Version:    0.7.0.1
 */