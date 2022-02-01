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
    AppMethodBeat.i(200179);
    this.origin = new PointF();
    this.size = new CGSize();
    AppMethodBeat.o(200179);
  }
  
  public CGRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new CGSize(paramFloat3, paramFloat4));
    AppMethodBeat.i(200177);
    AppMethodBeat.o(200177);
  }
  
  public CGRect(PointF paramPointF, CGSize paramCGSize)
  {
    AppMethodBeat.i(200178);
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
    AppMethodBeat.o(200178);
  }
  
  public CGRect clone()
  {
    AppMethodBeat.i(200182);
    CGRect localCGRect = new CGRect(this.origin.x, this.origin.y, this.size.width, this.size.height);
    AppMethodBeat.o(200182);
    return localCGRect;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200180);
    if (this == paramObject)
    {
      AppMethodBeat.o(200180);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(200180);
      return false;
    }
    paramObject = (CGRect)paramObject;
    if ((this.origin.equals(paramObject.origin)) && (this.size.equals(paramObject.size)))
    {
      AppMethodBeat.o(200180);
      return true;
    }
    AppMethodBeat.o(200180);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(200181);
    String str = "[" + this.origin + "," + this.size + "]";
    AppMethodBeat.o(200181);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGRect
 * JD-Core Version:    0.7.0.1
 */