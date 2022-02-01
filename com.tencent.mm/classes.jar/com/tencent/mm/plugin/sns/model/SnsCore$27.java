package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qs;
import com.tencent.mm.autogen.a.qs.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;

class SnsCore$27
  extends IListener<qs>
{
  SnsCore$27(al paramal, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309562);
    this.__eventId = qs.class.getName().hashCode();
    AppMethodBeat.o(309562);
  }
  
  private static boolean a(qs paramqs)
  {
    AppMethodBeat.i(309564);
    Object localObject2 = paramqs.hTQ.hMF;
    w localw = al.hgB();
    paramqs = al.hgi();
    long l1 = paramqs.beginTransaction(-1L);
    try
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        long l2 = ((Long)((Iterator)localObject2).next()).longValue();
        SnsInfo localSnsInfo = localw.alB((int)l2);
        if (localSnsInfo != null)
        {
          localSnsInfo.setOmittedFailResend();
          Log.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
          localw.f((int)l2, localSnsInfo);
        }
      }
      paramqs.endTransaction(l1);
    }
    finally
    {
      paramqs.endTransaction(l1);
      AppMethodBeat.o(309564);
    }
    AppMethodBeat.o(309564);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.SnsCore.27
 * JD-Core Version:    0.7.0.1
 */