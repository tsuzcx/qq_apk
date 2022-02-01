package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.gfr;
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
    int i = ((n)h.ax(n.class)).gaZ().gbl().size();
    gfr localgfr = new gfr();
    localgfr.IMf = a.inG().bhz(z.bAM()).id;
    localgfr.hAP = MMApplicationContext.getContext().getString(R.l.app_name);
    localgfr.nUB = MMApplicationContext.getContext().getString(R.l.gPk, new Object[] { Integer.valueOf(i) });
    try
    {
      a.inM();
      r.a(20005, localgfr.toByteArray(), true);
      AppMethodBeat.o(30125);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.e
 * JD-Core Version:    0.7.0.1
 */