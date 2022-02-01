package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class as
  implements f
{
  private final String TAG;
  private boolean readyForDisplay;
  public List<Long> zlR;
  public k zlS;
  
  public as()
  {
    AppMethodBeat.i(197861);
    this.TAG = "MicroMsg.SnsUnreadPreloader";
    this.zlR = new ArrayList();
    this.zlS = null;
    this.readyForDisplay = false;
    AppMethodBeat.o(197861);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(197862);
    if ((ag.dUn().zlU) && ((paramn instanceof x)))
    {
      paramString = (dhb)((x)paramn).rr.hNL.hNQ;
      boolean bool = ((x)paramn).dTB();
      ad.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((bool) && (paramString != null) && (!bt.hj(paramString.FCD)) && (!bt.hj(this.zlR)))
      {
        paramn = (SnsObject)paramString.FCD.peekLast();
        if (paramn != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramString = paramString.FCD.iterator();
          while (paramString.hasNext()) {
            localArrayList.add(Long.valueOf(((SnsObject)paramString.next()).Id));
          }
          this.zlR.removeAll(localArrayList);
          if ((this.zlR.isEmpty()) || (paramn.Id < ((Long)this.zlR.get(this.zlR.size() - 1)).longValue()))
          {
            ad.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
            this.zlS.state = 1;
            this.zlR.clear();
            AppMethodBeat.o(197862);
            return;
          }
          ad.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s", new Object[] { this.zlR.get(0) });
          g.ajB().gAO.a(new x(((Long)this.zlR.get(0)).longValue() + 1L, 0L, 2), 0);
        }
      }
    }
    AppMethodBeat.o(197862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */