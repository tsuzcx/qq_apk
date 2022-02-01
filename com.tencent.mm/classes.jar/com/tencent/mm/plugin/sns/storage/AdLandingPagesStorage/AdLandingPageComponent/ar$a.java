package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar$a
{
  public String QLQ = "";
  public String label = "";
  public float value;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(96327);
    if (paramObject == this)
    {
      AppMethodBeat.o(96327);
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((paramObject.label.equals(this.label)) && (paramObject.QLQ.equals(this.QLQ)) && (paramObject.value == this.value))
      {
        AppMethodBeat.o(96327);
        return true;
      }
      AppMethodBeat.o(96327);
      return false;
    }
    AppMethodBeat.o(96327);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(96328);
    int i = (int)(this.label.hashCode() + this.QLQ.hashCode() + this.value);
    AppMethodBeat.o(96328);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar.a
 * JD-Core Version:    0.7.0.1
 */