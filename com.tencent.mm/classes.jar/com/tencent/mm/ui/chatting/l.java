package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.z;
import com.tencent.mm.message.z.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.component.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class l
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
    paramContext = k.a(paramContext, paramContext.getString(R.l.gEh), false, null);
    o.aeqs.add(new a(paramSet, paramContext, paramz));
    h.OAn.b(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(34389);
  }
  
  static final class a
    implements QueueWorkerThread.ThreadObject
  {
    private Set<Long> aegY;
    private w aegZ;
    private z aeha;
    
    public a(Set<Long> paramSet, w paramw, z paramz)
    {
      this.aegY = paramSet;
      this.aegZ = paramw;
      this.aeha = paramz;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(34387);
      Object localObject2 = this.aegY;
      Object localObject1 = null;
      LinkedList localLinkedList2 = new LinkedList();
      LinkedList localLinkedList1 = new LinkedList();
      Iterator localIterator = ((Set)localObject2).iterator();
      if (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        bh.bCz();
        cc localcc = c.bzD().sl(localLong.longValue());
        int i;
        if ((localcc != null) && (localcc.field_msgId == localLong.longValue())) {
          if (localcc.fxR())
          {
            i = com.tencent.mm.message.l.v(localcc);
            com.tencent.mm.modelstat.b.oUZ.g(localcc, i);
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localcc.field_talker;
          }
          localLinkedList2.add(localLong);
          localLinkedList1.add(localcc.field_msgSvrId);
          if (i == 6)
          {
            localObject1 = (com.tencent.mm.message.a.b)k.b.aP(localcc.field_content, localcc.field_reserved).aK(com.tencent.mm.message.a.b.class);
            if ((localObject1 != null) && (((com.tencent.mm.message.a.b)localObject1).nVD != 0L))
            {
              localLinkedList1.add(((com.tencent.mm.message.a.b)localObject1).nVD);
              Log.i("MicroMsg.ChattingEditModeDelMsg", "add file overwritenewmsgid %s", new Object[] { Long.valueOf(((com.tencent.mm.message.a.b)localObject1).nVD) });
            }
          }
          localObject1 = new tr();
          ((tr)localObject1).hXt.type = 3;
          ((tr)localObject1).hXt.msgId = localLong.longValue();
          ((tr)localObject1).publish();
          localObject1 = localObject2;
          break;
          com.tencent.mm.modelstat.b.oUZ.aq(localcc);
          i = -1;
        }
      }
      br.bU(localLinkedList2);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "$deleteMultiMsg$";
      }
      ac.a((String)localObject2, 9, "deleteMessages", Util.listToString(localLinkedList1, ","));
      if (this.aeha != null) {
        this.aeha.b(z.a.nVu);
      }
      AppMethodBeat.o(34387);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(34388);
      if (this.aegZ != null)
      {
        this.aegZ.dismiss();
        if (this.aeha != null) {
          this.aeha.c(z.a.nVu);
        }
      }
      AppMethodBeat.o(34388);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */