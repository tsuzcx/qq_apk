package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.gk;
import com.tencent.mm.f.a.gk.a;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.j.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends IListener<gk>
{
  public c()
  {
    AppMethodBeat.i(160631);
    this.__eventId = gk.class.getName().hashCode();
    AppMethodBeat.o(160631);
  }
  
  private boolean a(final gk paramgk)
  {
    AppMethodBeat.i(94887);
    if (!(paramgk instanceof gk))
    {
      Log.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(94887);
      return false;
    }
    ap.a locala = aj.fOy();
    locala.a(paramgk.fCz.type, paramgk.fCz.username, new j.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb)
      {
        AppMethodBeat.i(94886);
        if (paramgk.fCz != null) {
          paramgk.fCz.fCD.a(null);
        }
        AppMethodBeat.o(94886);
      }
      
      public final void b(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
    });
    locala.a(1, paramgk.fCz.username, paramgk.fCz.fCB, paramgk.fCz.fCC);
    AppMethodBeat.o(94887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */