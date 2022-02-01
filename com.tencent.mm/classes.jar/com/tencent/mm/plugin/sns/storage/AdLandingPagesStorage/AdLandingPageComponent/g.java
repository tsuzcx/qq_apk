package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;

public final class g
  extends p
{
  public String dvR;
  public String zyC;
  public long zyD;
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(96315);
    try
    {
      long l = cf.aCN() * 1000;
      if ((this.zyD > 0L) && (this.zyD < l))
      {
        AppMethodBeat.o(96315);
        return true;
      }
      AppMethodBeat.o(96315);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(96315);
    }
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(96314);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[disableWording:").append(this.zyC).append(", hbCoverId:").append(this.dvR).append(", disableTime:").append(this.zyD).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96314);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g
 * JD-Core Version:    0.7.0.1
 */