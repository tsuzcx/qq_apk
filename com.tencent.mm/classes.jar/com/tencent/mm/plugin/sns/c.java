package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.ga.a;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends com.tencent.mm.sdk.b.c<ga>
{
  public c()
  {
    AppMethodBeat.i(160631);
    this.__eventId = ga.class.getName().hashCode();
    AppMethodBeat.o(160631);
  }
  
  private boolean a(final ga paramga)
  {
    AppMethodBeat.i(94887);
    if (!(paramga instanceof ga))
    {
      ae.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(94887);
      return false;
    }
    ao.a locala = ah.dXu();
    locala.a(paramga.dsz.type, paramga.dsz.username, new i.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb)
      {
        AppMethodBeat.i(94886);
        if (paramga.dsz != null) {
          paramga.dsz.dsD.a(null);
        }
        AppMethodBeat.o(94886);
      }
      
      public final void b(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
    });
    locala.a(1, paramga.dsz.username, paramga.dsz.dsB, paramga.dsz.dsC);
    AppMethodBeat.o(94887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */