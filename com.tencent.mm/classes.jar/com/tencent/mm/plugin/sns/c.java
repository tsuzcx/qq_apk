package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.gd.a;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends IListener<gd>
{
  public c()
  {
    AppMethodBeat.i(160631);
    this.__eventId = gd.class.getName().hashCode();
    AppMethodBeat.o(160631);
  }
  
  private boolean a(final gd paramgd)
  {
    AppMethodBeat.i(94887);
    if (!(paramgd instanceof gd))
    {
      Log.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(94887);
      return false;
    }
    aq.a locala = aj.faE();
    locala.a(paramgd.dJK.type, paramgd.dJK.username, new i.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb)
      {
        AppMethodBeat.i(94886);
        if (paramgd.dJK != null) {
          paramgd.dJK.dJO.a(null);
        }
        AppMethodBeat.o(94886);
      }
      
      public final void b(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
    });
    locala.a(1, paramgd.dJK.username, paramgd.dJK.dJM, paramgd.dJK.dJN);
    AppMethodBeat.o(94887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */