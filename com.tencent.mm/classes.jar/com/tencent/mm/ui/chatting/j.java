package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.l;
import com.tencent.mm.ag.z;
import com.tencent.mm.ag.z.a;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.d.m;
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
    paramContext.getString(2131755998);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758293), false, null);
    m.PnZ.add(new a(paramSet, paramContext, paramz));
    com.tencent.mm.plugin.report.service.h.CyF.a(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(34389);
  }
  
  static final class a
    implements QueueWorkerThread.ThreadObject
  {
    private Set<Long> Pgk;
    private q Pgl;
    private z Pgm;
    
    public a(Set<Long> paramSet, q paramq, z paramz)
    {
      this.Pgk = paramSet;
      this.Pgl = paramq;
      this.Pgm = paramz;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(34387);
      Object localObject1 = this.Pgk;
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject1).next();
        bg.aVF();
        Object localObject2 = c.aSQ().Hb(localLong.longValue());
        if (((eo)localObject2).field_msgId == localLong.longValue())
        {
          if (!((ca)localObject2).dOQ()) {
            break label146;
          }
          b.jmd.d((ca)localObject2, l.t((ca)localObject2));
        }
        for (;;)
        {
          localLinkedList.add(localLong);
          localObject2 = new rc();
          ((rc)localObject2).dXF.type = 3;
          ((rc)localObject2).dXF.msgId = localLong.longValue();
          EventCenter.instance.publish((IEvent)localObject2);
          break;
          label146:
          b.jmd.ad((ca)localObject2);
        }
      }
      bp.ar(localLinkedList);
      if (this.Pgm != null) {
        this.Pgm.b(z.a.iAT);
      }
      AppMethodBeat.o(34387);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(34388);
      if (this.Pgl != null)
      {
        this.Pgl.dismiss();
        if (this.Pgm != null) {
          this.Pgm.c(z.a.iAT);
        }
      }
      AppMethodBeat.o(34388);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */