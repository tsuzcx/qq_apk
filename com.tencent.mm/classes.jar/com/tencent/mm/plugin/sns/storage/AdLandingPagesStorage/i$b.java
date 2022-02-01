package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$b
{
  int Adc;
  int Add;
  int Ade;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (paramObject.Adc == this.Adc)
      {
        bool1 = bool2;
        if (paramObject.Add == this.Add)
        {
          bool1 = bool2;
          if (paramObject.Ade == this.Ade) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.Adc + this.Add + this.Ade;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(97331);
    String str = "[nodeType=" + this.Adc + ",compType=" + this.Add + ",subCompType=" + this.Ade + "]";
    AppMethodBeat.o(97331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.b
 * JD-Core Version:    0.7.0.1
 */