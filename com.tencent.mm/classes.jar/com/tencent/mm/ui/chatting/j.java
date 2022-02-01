package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.l;
import com.tencent.mm.aj.z;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.d.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class j
{
  public static void a(Context paramContext, Set<Long> paramSet, z paramz)
  {
    AppMethodBeat.i(34389);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
      AppMethodBeat.o(34389);
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
      AppMethodBeat.o(34389);
      return;
    }
    paramContext.getString(R.l.app_tip);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eBe), false, null);
    n.WIm.add(new a(paramSet, paramContext, paramz));
    com.tencent.mm.plugin.report.service.h.IzE.a(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(34389);
  }
  
  static final class a
    implements QueueWorkerThread.ThreadObject
  {
    private Set<Long> WzD;
    private s WzE;
    private z WzF;
    
    public a(Set<Long> paramSet, s params, z paramz)
    {
      this.WzD = paramSet;
      this.WzE = params;
      this.WzF = paramz;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(34387);
      Object localObject1 = this.WzD;
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject1).next();
        bh.beI();
        Object localObject2 = c.bbO().Oq(localLong.longValue());
        if (((et)localObject2).field_msgId == localLong.longValue())
        {
          if (!((ca)localObject2).erk()) {
            break label146;
          }
          b.mcf.g((ca)localObject2, l.v((ca)localObject2));
        }
        for (;;)
        {
          localLinkedList.add(localLong);
          localObject2 = new sc();
          ((sc)localObject2).fRw.type = 3;
          ((sc)localObject2).fRw.msgId = localLong.longValue();
          EventCenter.instance.publish((IEvent)localObject2);
          break;
          label146:
          b.mcf.al((ca)localObject2);
        }
      }
      bq.ap(localLinkedList);
      if (this.WzF != null) {
        this.WzF.b(z.a.lqr);
      }
      AppMethodBeat.o(34387);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(34388);
      if (this.WzE != null)
      {
        this.WzE.dismiss();
        if (this.WzF != null) {
          this.WzF.c(z.a.lqr);
        }
      }
      AppMethodBeat.o(34388);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */