package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;

public final class g
  extends p
{
  public String dke;
  public String yiu;
  public long yiv;
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(96315);
    try
    {
      long l = ce.azK() * 1000;
      if ((this.yiv > 0L) && (this.yiv < l))
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
    ((StringBuffer)localObject).append("[disableWording:").append(this.yiu).append(", hbCoverId:").append(this.dke).append(", disableTime:").append(this.yiv).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96314);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g
 * JD-Core Version:    0.7.0.1
 */