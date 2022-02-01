package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.l;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.storage.bl;
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
      ad.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
      AppMethodBeat.o(34389);
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
      AppMethodBeat.o(34389);
      return;
    }
    paramContext.getString(2131755906);
    paramContext = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131758041), false, null);
    k.Gtr.c(new a(paramSet, paramContext, paramz));
    com.tencent.mm.plugin.report.service.h.vKh.f(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(34389);
  }
  
  static final class a
    implements be.a
  {
    private Set<Long> GmA;
    private p GmB;
    private z GmC;
    
    public a(Set<Long> paramSet, p paramp, z paramz)
    {
      this.GmA = paramSet;
      this.GmB = paramp;
      this.GmC = paramz;
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(34387);
      Object localObject1 = this.GmA;
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject1).next();
        az.arV();
        Object localObject2 = c.apO().rm(localLong.longValue());
        if (((du)localObject2).field_msgId == localLong.longValue())
        {
          if (!((bl)localObject2).cxB()) {
            break label146;
          }
          com.tencent.mm.modelstat.b.huc.d((bl)localObject2, l.r((bl)localObject2));
        }
        for (;;)
        {
          localLinkedList.add(localLong);
          localObject2 = new pn();
          ((pn)localObject2).dvb.type = 3;
          ((pn)localObject2).dvb.msgId = localLong.longValue();
          a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          break;
          label146:
          com.tencent.mm.modelstat.b.huc.Q((bl)localObject2);
        }
      }
      bi.ak(localLinkedList);
      if (this.GmC != null) {
        this.GmC.b(z.a.gLi);
      }
      AppMethodBeat.o(34387);
      return true;
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(34388);
      if (this.GmB != null)
      {
        this.GmB.dismiss();
        if (this.GmC != null) {
          this.GmC.c(z.a.gLi);
        }
      }
      AppMethodBeat.o(34388);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i
 * JD-Core Version:    0.7.0.1
 */