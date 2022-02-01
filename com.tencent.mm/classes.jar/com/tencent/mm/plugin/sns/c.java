package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fw.a;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends com.tencent.mm.sdk.b.c<fw>
{
  public c()
  {
    AppMethodBeat.i(160631);
    this.__eventId = fw.class.getName().hashCode();
    AppMethodBeat.o(160631);
  }
  
  private boolean a(final fw paramfw)
  {
    AppMethodBeat.i(94887);
    if (!(paramfw instanceof fw))
    {
      ac.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(94887);
      return false;
    }
    am.a locala = af.dHH();
    locala.a(paramfw.dfX.type, paramfw.dfX.username, new i.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb)
      {
        AppMethodBeat.i(94886);
        if (paramfw.dfX != null) {
          paramfw.dfX.dgb.a(null);
        }
        AppMethodBeat.o(94886);
      }
      
      public final void b(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
    });
    locala.a(1, paramfw.dfX.username, paramfw.dfX.dfZ, paramfw.dfX.dga);
    AppMethodBeat.o(94887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */