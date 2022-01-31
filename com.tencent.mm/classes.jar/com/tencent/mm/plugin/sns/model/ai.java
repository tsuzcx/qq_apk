package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class ai
  implements g
{
  HashMap<String, l> cache;
  
  public ai()
  {
    AppMethodBeat.i(36529);
    this.cache = new HashMap();
    AppMethodBeat.o(36529);
  }
  
  public final boolean a(final l paraml)
  {
    AppMethodBeat.i(36533);
    if ((paraml == null) || (bo.isNullOrNil(paraml.field_userName)))
    {
      AppMethodBeat.o(36533);
      return false;
    }
    ag.coO().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36528);
        ai.this.cache.put(paraml.field_userName, paraml);
        AppMethodBeat.o(36528);
      }
    });
    AppMethodBeat.o(36533);
    return true;
  }
  
  public final l aaw(String paramString)
  {
    AppMethodBeat.i(36530);
    paramString = (l)this.cache.get(paramString);
    AppMethodBeat.o(36530);
    return paramString;
  }
  
  public final boolean cpu()
  {
    AppMethodBeat.i(36531);
    ag.coO().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36526);
        if (ai.this.cache.size() > 50) {
          ai.a(ai.this, 10);
        }
        AppMethodBeat.o(36526);
      }
    });
    AppMethodBeat.o(36531);
    return true;
  }
  
  public final boolean cpv()
  {
    AppMethodBeat.i(36532);
    ag.coO().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36527);
        ai.a(ai.this, ai.this.cache.size());
        AppMethodBeat.o(36527);
      }
    });
    AppMethodBeat.o(36532);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ai
 * JD-Core Version:    0.7.0.1
 */