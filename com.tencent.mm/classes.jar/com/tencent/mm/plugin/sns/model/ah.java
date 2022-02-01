package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class ah
  implements g
{
  HashMap<String, n> cache;
  
  public ah()
  {
    AppMethodBeat.i(95848);
    this.cache = new HashMap();
    AppMethodBeat.o(95848);
  }
  
  public final boolean a(final n paramn)
  {
    AppMethodBeat.i(95852);
    if ((paramn == null) || (bt.isNullOrNil(paramn.field_userName)))
    {
      AppMethodBeat.o(95852);
      return false;
    }
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95847);
        ah.this.cache.put(paramn.field_userName, paramn);
        AppMethodBeat.o(95847);
      }
    });
    AppMethodBeat.o(95852);
    return true;
  }
  
  public final n aoF(String paramString)
  {
    AppMethodBeat.i(95849);
    paramString = (n)this.cache.get(paramString);
    AppMethodBeat.o(95849);
    return paramString;
  }
  
  public final boolean dtN()
  {
    AppMethodBeat.i(95850);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95845);
        if (ah.this.cache.size() > 50) {
          ah.a(ah.this, 10);
        }
        AppMethodBeat.o(95845);
      }
    });
    AppMethodBeat.o(95850);
    return true;
  }
  
  public final boolean dtO()
  {
    AppMethodBeat.i(95851);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95846);
        ah.a(ah.this, ah.this.cache.size());
        AppMethodBeat.o(95846);
      }
    });
    AppMethodBeat.o(95851);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ah
 * JD-Core Version:    0.7.0.1
 */