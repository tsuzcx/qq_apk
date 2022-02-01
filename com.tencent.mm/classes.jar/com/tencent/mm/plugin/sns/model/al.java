package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class al
  implements e
{
  HashMap<String, l> cache;
  
  public al()
  {
    AppMethodBeat.i(95848);
    this.cache = new HashMap();
    AppMethodBeat.o(95848);
  }
  
  public final boolean a(final l paraml)
  {
    AppMethodBeat.i(95852);
    if ((paraml == null) || (Util.isNullOrNil(paraml.field_userName)))
    {
      AppMethodBeat.o(95852);
      return false;
    }
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95847);
        al.this.cache.put(paraml.field_userName, paraml);
        AppMethodBeat.o(95847);
      }
    });
    AppMethodBeat.o(95852);
    return true;
  }
  
  public final l aPj(String paramString)
  {
    AppMethodBeat.i(95849);
    paramString = (l)this.cache.get(paramString);
    AppMethodBeat.o(95849);
    return paramString;
  }
  
  public final boolean fbm()
  {
    AppMethodBeat.i(95850);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95845);
        if (al.this.cache.size() > 50) {
          al.a(al.this, 10);
        }
        AppMethodBeat.o(95845);
      }
    });
    AppMethodBeat.o(95850);
    return true;
  }
  
  public final boolean fbn()
  {
    AppMethodBeat.i(95851);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95846);
        al.a(al.this, al.this.cache.size());
        AppMethodBeat.o(95846);
      }
    });
    AppMethodBeat.o(95851);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.al
 * JD-Core Version:    0.7.0.1
 */