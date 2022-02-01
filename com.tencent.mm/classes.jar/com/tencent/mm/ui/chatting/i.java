package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.c.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class i
{
  public static void a(Context paramContext, Set<Long> paramSet, z paramz)
  {
    AppMethodBeat.i(34389);
    if (paramContext == null)
    {
      ac.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
      AppMethodBeat.o(34389);
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      ac.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
      AppMethodBeat.o(34389);
      return;
    }
    paramContext.getString(2131755906);
    paramContext = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131758041), false, null);
    k.HTk.c(new a(paramSet, paramContext, paramz));
    com.tencent.mm.plugin.report.service.h.wUl.f(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(34389);
  }
  
  static final class a
    implements bd.a
  {
    private Set<Long> HMq;
    private p HMr;
    private z HMs;
    
    public a(Set<Long> paramSet, p paramp, z paramz)
    {
      this.HMq = paramSet;
      this.HMr = paramp;
      this.HMs = paramz;
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(34387);
      Object localObject1 = this.HMq;
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject1).next();
        az.ayM();
        Object localObject2 = c.awD().vP(localLong.longValue());
        if (((dy)localObject2).field_msgId == localLong.longValue())
        {
          if (!((bo)localObject2).cKN()) {
            break label146;
          }
          com.tencent.mm.modelstat.b.hUE.d((bo)localObject2, l.r((bo)localObject2));
        }
        for (;;)
        {
          localLinkedList.add(localLong);
          localObject2 = new pw();
          ((pw)localObject2).dsN.type = 3;
          ((pw)localObject2).dsN.msgId = localLong.longValue();
          a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          break;
          label146:
          com.tencent.mm.modelstat.b.hUE.Q((bo)localObject2);
        }
      }
      bi.ah(localLinkedList);
      if (this.HMs != null) {
        this.HMs.b(z.a.hlI);
      }
      AppMethodBeat.o(34387);
      return true;
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(34388);
      if (this.HMr != null)
      {
        this.HMr.dismiss();
        if (this.HMs != null) {
          this.HMs.c(z.a.hlI);
        }
      }
      AppMethodBeat.o(34388);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i
 * JD-Core Version:    0.7.0.1
 */