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
  private HashMap<String, l> cache;
  
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
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95847);
        al.a(al.this).put(paraml.field_userName, paraml);
        AppMethodBeat.o(95847);
      }
    });
    AppMethodBeat.o(95852);
    return true;
  }
  
  public final l bae(String paramString)
  {
    AppMethodBeat.i(95849);
    paramString = (l)this.cache.get(paramString);
    AppMethodBeat.o(95849);
    return paramString;
  }
  
  public final boolean fPg()
  {
    AppMethodBeat.i(95850);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95845);
        if (al.a(al.this).size() > 50) {
          al.a(al.this, 10);
        }
        AppMethodBeat.o(95845);
      }
    });
    AppMethodBeat.o(95850);
    return true;
  }
  
  public final boolean fPh()
  {
    AppMethodBeat.i(95851);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95846);
        al.a(al.this, al.a(al.this).size());
        AppMethodBeat.o(95846);
      }
    });
    AppMethodBeat.o(95851);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.al
 * JD-Core Version:    0.7.0.1
 */