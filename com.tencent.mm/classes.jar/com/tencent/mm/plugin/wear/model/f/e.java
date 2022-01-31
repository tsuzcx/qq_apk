package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.protocal.c.cjf;
import com.tencent.mm.sdk.platformtools.ae;
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
    int i = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bhZ().size();
    cjf localcjf = new cjf();
    localcjf.kWl = a.bYL().qRw.Re(q.Gj()).id;
    localcjf.bGw = ae.getContext().getString(R.l.app_name);
    localcjf.kVs = ae.getContext().getString(R.l.notificaiton_notify_fail_msg, new Object[] { Integer.valueOf(i) });
    try
    {
      a.bYL();
      r.b(20005, localcjf.toByteArray(), true);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.e
 * JD-Core Version:    0.7.0.1
 */