package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$b
{
  int QXE;
  int QXF;
  int QXG;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (paramObject.QXE == this.QXE)
      {
        bool1 = bool2;
        if (paramObject.QXF == this.QXF)
        {
          bool1 = bool2;
          if (paramObject.QXG == this.QXG) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.QXE + this.QXF + this.QXG;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(97331);
    String str = "[nodeType=" + this.QXE + ",compType=" + this.QXF + ",subCompType=" + this.QXG + "]";
    AppMethodBeat.o(97331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.b
 * JD-Core Version:    0.7.0.1
 */