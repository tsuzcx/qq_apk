package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$b
{
  int Elu;
  int Elv;
  int Elw;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (paramObject.Elu == this.Elu)
      {
        bool1 = bool2;
        if (paramObject.Elv == this.Elv)
        {
          bool1 = bool2;
          if (paramObject.Elw == this.Elw) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.Elu + this.Elv + this.Elw;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(97331);
    String str = "[nodeType=" + this.Elu + ",compType=" + this.Elv + ",subCompType=" + this.Elw + "]";
    AppMethodBeat.o(97331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.b
 * JD-Core Version:    0.7.0.1
 */