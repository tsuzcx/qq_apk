package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class ai
  implements g
{
  HashMap<String, n> cache;
  
  public ai()
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
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95847);
        ai.this.cache.put(paramn.field_userName, paramn);
        AppMethodBeat.o(95847);
      }
    });
    AppMethodBeat.o(95852);
    return true;
  }
  
  public final n ayW(String paramString)
  {
    AppMethodBeat.i(95849);
    paramString = (n)this.cache.get(paramString);
    AppMethodBeat.o(95849);
    return paramString;
  }
  
  public final boolean dUy()
  {
    AppMethodBeat.i(95850);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95845);
        if (ai.this.cache.size() > 50) {
          ai.a(ai.this, 10);
        }
        AppMethodBeat.o(95845);
      }
    });
    AppMethodBeat.o(95850);
    return true;
  }
  
  public final boolean dUz()
  {
    AppMethodBeat.i(95851);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95846);
        ai.a(ai.this, ai.this.cache.size());
        AppMethodBeat.o(95846);
      }
    });
    AppMethodBeat.o(95851);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ai
 * JD-Core Version:    0.7.0.1
 */