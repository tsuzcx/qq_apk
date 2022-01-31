package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
{
  private Map<String, f> vFP;
  private int vFQ;
  
  public d()
  {
    AppMethodBeat.i(63520);
    this.vFP = new HashMap();
    this.vFQ = 1;
    AppMethodBeat.o(63520);
  }
  
  public final void akA(String paramString)
  {
    AppMethodBeat.i(63521);
    if (this.vFQ > 3)
    {
      ab.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
      AppMethodBeat.o(63521);
      return;
    }
    String str = com.tencent.mm.plugin.wepkg.utils.d.akM(paramString);
    if ((!bo.isNullOrNil(str)) && (this.vFP.get(str) == null) && (!b.akf(str)))
    {
      this.vFQ += 1;
      f localf = b.bU(paramString, true);
      if ((localf != null) && (localf.vGb != null))
      {
        this.vFP.put(str, localf);
        a.b("EnterWeb", paramString, localf.vGb.ezY, localf.vGb.version, 1L, 0L, null);
        ab.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", new Object[] { str });
      }
    }
    AppMethodBeat.o(63521);
  }
  
  public final s akB(String paramString)
  {
    AppMethodBeat.i(63522);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63522);
      return null;
    }
    Iterator localIterator = this.vFP.values().iterator();
    while (localIterator.hasNext())
    {
      s locals = ((f)localIterator.next()).akB(paramString);
      if (locals != null)
      {
        ab.i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", new Object[] { paramString });
        AppMethodBeat.o(63522);
        return locals;
      }
    }
    AppMethodBeat.o(63522);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.d
 * JD-Core Version:    0.7.0.1
 */