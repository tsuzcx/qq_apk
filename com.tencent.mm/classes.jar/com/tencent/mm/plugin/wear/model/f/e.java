package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.IOException;
import java.util.List;

public final class e
  extends c
{
  public final String getName()
  {
    return "WearFailMsgCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30125);
    int i = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().dlW().size();
    ecn localecn = new ecn();
    localecn.ukh = a.eKt().aFn(u.aAm()).id;
    localecn.Title = aj.getContext().getString(2131755822);
    localecn.hDa = aj.getContext().getString(2131761657, new Object[] { Integer.valueOf(i) });
    try
    {
      a.eKz();
      r.a(20005, localecn.toByteArray(), true);
      AppMethodBeat.o(30125);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.e
 * JD-Core Version:    0.7.0.1
 */