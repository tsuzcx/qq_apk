package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.l;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.d.m;
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
    paramContext = h.b(paramContext, paramContext.getString(2131758041), false, null);
    m.JHH.c(new a(paramSet, paramContext, paramz));
    g.yhR.f(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(34389);
  }
  
  static final class a
    implements be.a
  {
    private Set<Long> JAg;
    private p JAh;
    private z JAi;
    
    public a(Set<Long> paramSet, p paramp, z paramz)
    {
      this.JAg = paramSet;
      this.JAh = paramp;
      this.JAi = paramz;
    }
    
    public final boolean aEm()
    {
      AppMethodBeat.i(34387);
      Object localObject1 = this.JAg;
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject1).next();
        ba.aBQ();
        Object localObject2 = c.azs().xY(localLong.longValue());
        if (((ei)localObject2).field_msgId == localLong.longValue())
        {
          if (!((bu)localObject2).cTc()) {
            break label146;
          }
          com.tencent.mm.modelstat.b.inZ.d((bu)localObject2, l.r((bu)localObject2));
        }
        for (;;)
        {
          localLinkedList.add(localLong);
          localObject2 = new qh();
          ((qh)localObject2).dEN.type = 3;
          ((qh)localObject2).dEN.msgId = localLong.longValue();
          a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          break;
          label146:
          com.tencent.mm.modelstat.b.inZ.T((bu)localObject2);
        }
      }
      bj.ai(localLinkedList);
      if (this.JAi != null) {
        this.JAi.b(z.a.hDS);
      }
      AppMethodBeat.o(34387);
      return true;
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(34388);
      if (this.JAh != null)
      {
        this.JAh.dismiss();
        if (this.JAi != null) {
          this.JAi.c(z.a.hDS);
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