package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class i<T>
{
  public final T a(aa paramaa, Class<T> paramClass)
  {
    AppMethodBeat.i(306739);
    if (paramaa == null)
    {
      AppMethodBeat.o(306739);
      return null;
    }
    if (paramClass.isInstance(paramaa))
    {
      AppMethodBeat.o(306739);
      return paramaa;
    }
    try
    {
      if (l.als(paramaa.type))
      {
        paramaa = paramaa.haE();
        if (paramaa != null)
        {
          paramaa = paramaa.iterator();
          while (paramaa.hasNext())
          {
            Object localObject = a((aa)paramaa.next(), paramClass);
            if (localObject != null)
            {
              AppMethodBeat.o(306739);
              return localObject;
            }
          }
        }
      }
    }
    finally
    {
      Log.e("AdLandingPageInfoFinder", "findCardInfo, exp=" + paramaa.toString());
      AppMethodBeat.o(306739);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */