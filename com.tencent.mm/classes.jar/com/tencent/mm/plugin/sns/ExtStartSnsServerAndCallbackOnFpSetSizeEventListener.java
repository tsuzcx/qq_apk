package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.gv;
import com.tencent.mm.autogen.a.gv.a;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.plugin.sns.c.b;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class ExtStartSnsServerAndCallbackOnFpSetSizeEventListener
  extends IListener<gv>
{
  public ExtStartSnsServerAndCallbackOnFpSetSizeEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160631);
    this.__eventId = gv.class.getName().hashCode();
    AppMethodBeat.o(160631);
  }
  
  private boolean a(final gv paramgv)
  {
    AppMethodBeat.i(94887);
    if (!(paramgv instanceof gv))
    {
      Log.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(94887);
      return false;
    }
    ar.a locala = al.hgr();
    locala.a(paramgv.hHo.type, paramgv.hHo.username, new k.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean1, int paramAnonymousInt, b paramAnonymousb, boolean paramAnonymousBoolean2) {}
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb)
      {
        AppMethodBeat.i(94886);
        if (paramgv.hHo != null) {
          paramgv.hHo.hHs.b(null);
        }
        AppMethodBeat.o(94886);
      }
      
      public final void b(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, b paramAnonymousb) {}
    });
    locala.a(1, paramgv.hHo.username, paramgv.hHo.hHq, paramgv.hHo.hHr);
    AppMethodBeat.o(94887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener
 * JD-Core Version:    0.7.0.1
 */