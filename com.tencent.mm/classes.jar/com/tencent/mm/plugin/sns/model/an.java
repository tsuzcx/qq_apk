package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class an
  implements j
{
  HashMap<String, u> cache;
  
  public an()
  {
    AppMethodBeat.i(95848);
    this.cache = new HashMap();
    AppMethodBeat.o(95848);
  }
  
  public final boolean a(final u paramu)
  {
    AppMethodBeat.i(95852);
    if ((paramu == null) || (Util.isNullOrNil(paramu.field_userName)))
    {
      AppMethodBeat.o(95852);
      return false;
    }
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95847);
        an.this.cache.put(paramu.field_userName, paramu);
        AppMethodBeat.o(95847);
      }
    });
    AppMethodBeat.o(95852);
    return true;
  }
  
  public final u aYu(String paramString)
  {
    AppMethodBeat.i(95849);
    paramString = (u)this.cache.get(paramString);
    AppMethodBeat.o(95849);
    return paramString;
  }
  
  public final boolean hgZ()
  {
    AppMethodBeat.i(95850);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95845);
        if (an.this.cache.size() > 50) {
          an.a(an.this, 10);
        }
        AppMethodBeat.o(95845);
      }
    });
    AppMethodBeat.o(95850);
    return true;
  }
  
  public final boolean hha()
  {
    AppMethodBeat.i(95851);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95846);
        an.a(an.this, an.this.cache.size());
        AppMethodBeat.o(95846);
      }
    });
    AppMethodBeat.o(95851);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an
 * JD-Core Version:    0.7.0.1
 */