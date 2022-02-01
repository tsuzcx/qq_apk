package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;

public final class g
  extends p
{
  public String dwW;
  public String zQb;
  public long zQc;
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(96315);
    try
    {
      long l = ch.aDd() * 1000;
      if ((this.zQc > 0L) && (this.zQc < l))
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
    ((StringBuffer)localObject).append("[disableWording:").append(this.zQb).append(", hbCoverId:").append(this.dwW).append(", disableTime:").append(this.zQc).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96314);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g
 * JD-Core Version:    0.7.0.1
 */