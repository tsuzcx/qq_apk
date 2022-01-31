package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a
{
  int rCm;
  int rCn;
  int rCo;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (paramObject.rCm == this.rCm)
      {
        bool1 = bool2;
        if (paramObject.rCn == this.rCn)
        {
          bool1 = bool2;
          if (paramObject.rCo == this.rCo) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.rCm + this.rCn + this.rCo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(37732);
    String str = "[nodeType=" + this.rCm + ",compType=" + this.rCn + ",subCompType=" + this.rCo + "]";
    AppMethodBeat.o(37732);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a
 * JD-Core Version:    0.7.0.1
 */