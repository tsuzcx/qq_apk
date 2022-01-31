package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad$a
{
  public String label = "";
  public String rtu = "";
  public float value;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(36947);
    if (paramObject == this)
    {
      AppMethodBeat.o(36947);
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((paramObject.label.equals(this.label)) && (paramObject.rtu.equals(this.rtu)) && (paramObject.value == this.value))
      {
        AppMethodBeat.o(36947);
        return true;
      }
      AppMethodBeat.o(36947);
      return false;
    }
    AppMethodBeat.o(36947);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(36948);
    int i = (int)(this.label.hashCode() + this.rtu.hashCode() + this.value);
    AppMethodBeat.o(36948);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad.a
 * JD-Core Version:    0.7.0.1
 */