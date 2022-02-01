package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.fz.a;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.sdk.b.c<fz>
{
  public c()
  {
    AppMethodBeat.i(160631);
    this.__eventId = fz.class.getName().hashCode();
    AppMethodBeat.o(160631);
  }
  
  private boolean a(final fz paramfz)
  {
    AppMethodBeat.i(94887);
    if (!(paramfz instanceof fz))
    {
      ad.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(94887);
      return false;
    }
    an.a locala = ag.dTU();
    locala.a(paramfz.drt.type, paramfz.drt.username, new i.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb)
      {
        AppMethodBeat.i(94886);
        if (paramfz.drt != null) {
          paramfz.drt.drx.a(null);
        }
        AppMethodBeat.o(94886);
      }
      
      public final void b(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
    });
    locala.a(1, paramfz.drt.username, paramfz.drt.drv, paramfz.drt.drw);
    AppMethodBeat.o(94887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */