package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class b<T>
{
  public final T a(n paramn, Class<T> paramClass)
  {
    AppMethodBeat.i(306736);
    if (paramn == null)
    {
      AppMethodBeat.o(306736);
      return null;
    }
    if (paramClass.isInstance(paramn))
    {
      AppMethodBeat.o(306736);
      return paramn;
    }
    try
    {
      if ((paramn instanceof a))
      {
        paramn = ((a)paramn).hai().iterator();
        while (paramn.hasNext())
        {
          Object localObject = a((n)paramn.next(), paramClass);
          if (localObject != null)
          {
            AppMethodBeat.o(306736);
            return localObject;
          }
        }
      }
    }
    finally
    {
      Log.e("AdLandingPageCompFinder", "findCardComp, exp=" + paramn.toString());
      AppMethodBeat.o(306736);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b
 * JD-Core Version:    0.7.0.1
 */