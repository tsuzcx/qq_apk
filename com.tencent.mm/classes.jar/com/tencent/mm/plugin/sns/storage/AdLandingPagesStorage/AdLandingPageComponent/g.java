package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;

public final class g
  extends q
{
  public String DXZ;
  public long DYa;
  public String dOD;
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(96315);
    try
    {
      long l = cl.aWB() * 1000;
      if ((this.DYa > 0L) && (this.DYa < l))
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
    ((StringBuffer)localObject).append("[disableWording:").append(this.DXZ).append(", hbCoverId:").append(this.dOD).append(", disableTime:").append(this.DYa).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96314);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g
 * JD-Core Version:    0.7.0.1
 */