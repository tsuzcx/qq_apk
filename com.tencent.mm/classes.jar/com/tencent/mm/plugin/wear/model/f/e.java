package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.protocal.protobuf.cws;
import com.tencent.mm.sdk.platformtools.ah;
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
    AppMethodBeat.i(26443);
    int i = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().bQb().size();
    cws localcws = new cws();
    localcws.nuk = a.cYy().uGE.agb(com.tencent.mm.model.r.Zn()).id;
    localcws.Title = ah.getContext().getString(2131297005);
    localcws.ntu = ah.getContext().getString(2131301895, new Object[] { Integer.valueOf(i) });
    try
    {
      a.cYy();
      com.tencent.mm.plugin.wear.model.e.r.a(20005, localcws.toByteArray(), true);
      AppMethodBeat.o(26443);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(26443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.e
 * JD-Core Version:    0.7.0.1
 */