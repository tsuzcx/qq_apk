package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$b
{
  int zLV;
  int zLW;
  int zLX;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (paramObject.zLV == this.zLV)
      {
        bool1 = bool2;
        if (paramObject.zLW == this.zLW)
        {
          bool1 = bool2;
          if (paramObject.zLX == this.zLX) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.zLV + this.zLW + this.zLX;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(97331);
    String str = "[nodeType=" + this.zLV + ",compType=" + this.zLW + ",subCompType=" + this.zLX + "]";
    AppMethodBeat.o(97331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.b
 * JD-Core Version:    0.7.0.1
 */