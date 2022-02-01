package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
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
      ae.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
      AppMethodBeat.o(34389);
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      ae.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
      AppMethodBeat.o(34389);
      return;
    }
    paramContext.getString(2131755906);
    paramContext = h.b(paramContext, paramContext.getString(2131758041), false, null);
    m.KcB.c(new a(paramSet, paramContext, paramz));
    g.yxI.f(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    AppMethodBeat.o(34389);
  }
  
  static final class a
    implements bf.a
  {
    private Set<Long> JUX;
    private p JUY;
    private z JUZ;
    
    public a(Set<Long> paramSet, p paramp, z paramz)
    {
      this.JUX = paramSet;
      this.JUY = paramp;
      this.JUZ = paramz;
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(34387);
      Object localObject1 = this.JUX;
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject1).next();
        bc.aCg();
        Object localObject2 = c.azI().ys(localLong.longValue());
        if (((ei)localObject2).field_msgId == localLong.longValue())
        {
          if (!((bv)localObject2).cVH()) {
            break label146;
          }
          com.tencent.mm.modelstat.b.iqT.d((bv)localObject2, l.r((bv)localObject2));
        }
        for (;;)
        {
          localLinkedList.add(localLong);
          localObject2 = new qi();
          ((qi)localObject2).dFS.type = 3;
          ((qi)localObject2).dFS.msgId = localLong.longValue();
          a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          break;
          label146:
          com.tencent.mm.modelstat.b.iqT.T((bv)localObject2);
        }
      }
      bl.ai(localLinkedList);
      if (this.JUZ != null) {
        this.JUZ.b(z.a.hGK);
      }
      AppMethodBeat.o(34387);
      return true;
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(34388);
      if (this.JUY != null)
      {
        this.JUY.dismiss();
        if (this.JUZ != null) {
          this.JUZ.c(z.a.hGK);
        }
      }
      AppMethodBeat.o(34388);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */