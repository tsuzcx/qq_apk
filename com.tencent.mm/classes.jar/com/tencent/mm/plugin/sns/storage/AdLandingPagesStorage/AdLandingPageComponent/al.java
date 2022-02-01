package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
{
  public float height;
  public String iconUrl;
  public float paddingBottom;
  public float width;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(96332);
    if (paramObject == this)
    {
      AppMethodBeat.o(96332);
      return true;
    }
    if ((paramObject instanceof al))
    {
      paramObject = (al)paramObject;
      if ((paramObject.iconUrl.equals(this.iconUrl)) && (paramObject.width == this.width) && (paramObject.height == this.height) && (paramObject.paddingBottom == this.paddingBottom))
      {
        AppMethodBeat.o(96332);
        return true;
      }
      AppMethodBeat.o(96332);
      return false;
    }
    AppMethodBeat.o(96332);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(96333);
    int i = super.hashCode();
    AppMethodBeat.o(96333);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al
 * JD-Core Version:    0.7.0.1
 */