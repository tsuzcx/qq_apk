package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.protocal.protobuf.eym;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
    int i = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().eiK().size();
    eym localeym = new eym();
    localeym.xNF = a.fVK().aWj(z.aTY()).id;
    localeym.Title = MMApplicationContext.getContext().getString(2131755908);
    localeym.iAc = MMApplicationContext.getContext().getString(2131763625, new Object[] { Integer.valueOf(i) });
    try
    {
      a.fVQ();
      r.a(20005, localeym.toByteArray(), true);
      AppMethodBeat.o(30125);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.e
 * JD-Core Version:    0.7.0.1
 */