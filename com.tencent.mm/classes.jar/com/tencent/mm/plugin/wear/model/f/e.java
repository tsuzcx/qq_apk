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
import com.tencent.mm.protocal.protobuf.fjd;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;
import java.util.List;

public final class e
  extends c
{
  protected final void gOA()
  {
    AppMethodBeat.i(30125);
    int i = ((n)h.ae(n.class)).eSe().eSq().size();
    fjd localfjd = new fjd();
    localfjd.CRP = a.gOr().bhQ(z.bcZ()).id;
    localfjd.fwr = MMApplicationContext.getContext().getString(R.l.app_name);
    localfjd.lpy = MMApplicationContext.getContext().getString(R.l.eMX, new Object[] { Integer.valueOf(i) });
    try
    {
      a.gOx();
      r.a(20005, localfjd.toByteArray(), true);
      AppMethodBeat.o(30125);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30125);
    }
  }
  
  public final String getName()
  {
    return "WearFailMsgCreateTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.e
 * JD-Core Version:    0.7.0.1
 */