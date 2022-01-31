package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
{
  public float height;
  public String iconUrl;
  public float paddingBottom;
  public float width;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(36952);
    if (paramObject == this)
    {
      AppMethodBeat.o(36952);
      return true;
    }
    if ((paramObject instanceof ae))
    {
      paramObject = (ae)paramObject;
      if ((paramObject.iconUrl.equals(this.iconUrl)) && (paramObject.width == this.width) && (paramObject.height == this.height) && (paramObject.paddingBottom == this.paddingBottom))
      {
        AppMethodBeat.o(36952);
        return true;
      }
      AppMethodBeat.o(36952);
      return false;
    }
    AppMethodBeat.o(36952);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(36953);
    int i = super.hashCode();
    AppMethodBeat.o(36953);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae
 * JD-Core Version:    0.7.0.1
 */