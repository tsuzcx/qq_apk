package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CGSize
  implements Cloneable
{
  public static final CGSize CGSizeZero;
  public float height;
  public float width;
  
  static
  {
    AppMethodBeat.i(215798);
    CGSizeZero = new CGSize(0.0F, 0.0F);
    AppMethodBeat.o(215798);
  }
  
  public CGSize()
  {
    this(1.0F, 1.0F);
  }
  
  public CGSize(float paramFloat1, float paramFloat2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public CGSize clone()
  {
    AppMethodBeat.i(215825);
    CGSize localCGSize = new CGSize(this.width, this.height);
    AppMethodBeat.o(215825);
    return localCGSize;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CGSize)) {
      return false;
    }
    return (((CGSize)paramObject).width == this.width) && (((CGSize)paramObject).height == this.height);
  }
  
  public String toString()
  {
    AppMethodBeat.i(215805);
    String str = "[" + this.width + "," + this.height + "]";
    AppMethodBeat.o(215805);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CGSize
 * JD-Core Version:    0.7.0.1
 */