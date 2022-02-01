package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class at
  implements f
{
  private final String TAG;
  private boolean readyForDisplay;
  public List<Long> zDg;
  public k zDh;
  
  public at()
  {
    AppMethodBeat.i(219354);
    this.TAG = "MicroMsg.SnsUnreadPreloader";
    this.zDg = new ArrayList();
    this.zDh = null;
    this.readyForDisplay = false;
    AppMethodBeat.o(219354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(219355);
    if ((ah.dXN().zDj) && ((paramn instanceof y)))
    {
      paramString = (dhv)((y)paramn).rr.hQE.hQJ;
      boolean bool = ((y)paramn).dXb();
      ae.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((bool) && (paramString != null) && (!bu.ht(paramString.FUY)) && (!bu.ht(this.zDg)))
      {
        paramn = (SnsObject)paramString.FUY.peekLast();
        if (paramn != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramString = paramString.FUY.iterator();
          while (paramString.hasNext()) {
            localArrayList.add(Long.valueOf(((SnsObject)paramString.next()).Id));
          }
          this.zDg.removeAll(localArrayList);
          if ((this.zDg.isEmpty()) || (paramn.Id < ((Long)this.zDg.get(this.zDg.size() - 1)).longValue()))
          {
            ae.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
            this.zDh.state = 1;
            this.zDg.clear();
            AppMethodBeat.o(219355);
            return;
          }
          ae.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s", new Object[] { this.zDg.get(0) });
          g.ajQ().gDv.a(new y(((Long)this.zDg.get(0)).longValue() + 1L, 0L, 2), 0);
        }
      }
    }
    AppMethodBeat.o(219355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.at
 * JD-Core Version:    0.7.0.1
 */