package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.sdk.platformtools.ak;
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
    int i = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().doV().size();
    eee localeee = new eee();
    localeee.uvE = a.eOb().aGH(v.aAC()).id;
    localeee.Title = ak.getContext().getString(2131755822);
    localeee.hFS = ak.getContext().getString(2131761657, new Object[] { Integer.valueOf(i) });
    try
    {
      a.eOh();
      r.a(20005, localeee.toByteArray(), true);
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