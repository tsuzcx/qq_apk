package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class aj
  implements g
{
  HashMap<String, n> cache;
  
  public aj()
  {
    AppMethodBeat.i(95848);
    this.cache = new HashMap();
    AppMethodBeat.o(95848);
  }
  
  public final boolean a(final n paramn)
  {
    AppMethodBeat.i(95852);
    if ((paramn == null) || (bu.isNullOrNil(paramn.field_userName)))
    {
      AppMethodBeat.o(95852);
      return false;
    }
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95847);
        aj.this.cache.put(paramn.field_userName, paramn);
        AppMethodBeat.o(95847);
      }
    });
    AppMethodBeat.o(95852);
    return true;
  }
  
  public final n aAn(String paramString)
  {
    AppMethodBeat.i(95849);
    paramString = (n)this.cache.get(paramString);
    AppMethodBeat.o(95849);
    return paramString;
  }
  
  public final boolean dXY()
  {
    AppMethodBeat.i(95850);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95845);
        if (aj.this.cache.size() > 50) {
          aj.a(aj.this, 10);
        }
        AppMethodBeat.o(95845);
      }
    });
    AppMethodBeat.o(95850);
    return true;
  }
  
  public final boolean dXZ()
  {
    AppMethodBeat.i(95851);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95846);
        aj.a(aj.this, aj.this.cache.size());
        AppMethodBeat.o(95846);
      }
    });
    AppMethodBeat.o(95851);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */