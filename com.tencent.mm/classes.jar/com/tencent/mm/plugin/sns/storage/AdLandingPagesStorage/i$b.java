package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$b
{
  int xhT;
  int xhU;
  int xhV;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (paramObject.xhT == this.xhT)
      {
        bool1 = bool2;
        if (paramObject.xhU == this.xhU)
        {
          bool1 = bool2;
          if (paramObject.xhV == this.xhV) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.xhT + this.xhU + this.xhV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(97331);
    String str = "[nodeType=" + this.xhT + ",compType=" + this.xhU + ",subCompType=" + this.xhV + "]";
    AppMethodBeat.o(97331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.b
 * JD-Core Version:    0.7.0.1
 */