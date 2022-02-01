package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.fv.a;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.plugin.sns.c.b;
import com.tencent.mm.plugin.sns.c.i.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.sdk.b.c<fv>
{
  public c()
  {
    AppMethodBeat.i(160631);
    this.__eventId = fv.class.getName().hashCode();
    AppMethodBeat.o(160631);
  }
  
  private boolean a(final fv paramfv)
  {
    AppMethodBeat.i(94887);
    if (!(paramfv instanceof fv))
    {
      ad.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(94887);
      return false;
    }
    am.a locala = af.dtk();
    locala.a(paramfv.diC.type, paramfv.diC.username, new i.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb)
      {
        AppMethodBeat.i(94886);
        if (paramfv.diC != null) {
          paramfv.diC.diG.a(null);
        }
        AppMethodBeat.o(94886);
      }
      
      public final void b(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
    });
    locala.a(1, paramfv.diC.username, paramfv.diC.diE, paramfv.diC.diF);
    AppMethodBeat.o(94887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */