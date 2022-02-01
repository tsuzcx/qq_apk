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
    AppMethodBeat.i(204345);
    this.origin = new PointF();
    this.size = new CGSize();
    AppMethodBeat.o(204345);
  }
  
  public CGRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new CGSize(paramFloat3, paramFloat4));
    AppMethodBeat.i(204343);
    AppMethodBeat.o(204343);
  }
  
  public CGRect(PointF paramPointF, CGSize paramCGSize)
  {
    AppMethodBeat.i(204344);
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
    AppMethodBeat.o(204344);
  }
  
  public CGRect clone()
  {
    AppMethodBeat.i(204348);
    CGRect localCGRect = new CGRect(this.origin.x, this.origin.y, this.size.width, this.size.height);
    AppMethodBeat.o(204348);
    return localCGRect;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204346);
    if (this == paramObject)
    {
      AppMethodBeat.o(204346);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(204346);
      return false;
    }
    paramObject = (CGRect)paramObject;
    if ((this.origin.equals(paramObject.origin)) && (this.size.equals(paramObject.size)))
    {
      AppMethodBeat.o(204346);
      return true;
    }
    AppMethodBeat.o(204346);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(204347);
    String str = "[" + this.origin + "," + this.size + "]";
    AppMethodBeat.o(204347);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGRect
 * JD-Core Version:    0.7.0.1
 */