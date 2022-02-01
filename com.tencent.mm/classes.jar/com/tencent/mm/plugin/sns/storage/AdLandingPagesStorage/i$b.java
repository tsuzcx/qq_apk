package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$b
{
  int yuH;
  int yuI;
  int yuJ;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (paramObject.yuH == this.yuH)
      {
        bool1 = bool2;
        if (paramObject.yuI == this.yuI)
        {
          bool1 = bool2;
          if (paramObject.yuJ == this.yuJ) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.yuH + this.yuI + this.yuJ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(97331);
    String str = "[nodeType=" + this.yuH + ",compType=" + this.yuI + ",subCompType=" + this.yuJ + "]";
    AppMethodBeat.o(97331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.b
 * JD-Core Version:    0.7.0.1
 */