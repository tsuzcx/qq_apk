package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;

public final class c
  implements i
{
  public final void a(cc paramcc, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(256829);
    if ((paramBoolean) && (v.Iv(parambb.field_username))) {
      parambb.BH("conversationboxservice");
    }
    AppMethodBeat.o(256829);
  }
  
  public final void b(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(256836);
    if ((paramc != null) && (parambb != null) && (!Util.isNullOrNil(parambb.field_username))) {
      if (("insert".equals(paramc.KRm)) || ("update".equals(paramc.KRm)))
      {
        if (v.Iv(parambb.field_username))
        {
          if (!((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().l(parambb)) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            Log.d("MicroMsg.ConvBoxExtension", "this conversation is a conv box contact! %s", new Object[] { Boolean.valueOf(paramBoolean) });
            ((com.tencent.mm.plugin.appbrand.service.n)h.ax(com.tencent.mm.plugin.appbrand.service.n.class)).a(parambb, true, paramBoolean);
            AppMethodBeat.o(256836);
            return;
          }
        }
      }
      else {
        "delete".equals(paramc.KRm);
      }
    }
    AppMethodBeat.o(256836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */