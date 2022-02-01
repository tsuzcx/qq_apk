package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.sns.j.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aq
  implements com.tencent.mm.al.g
{
  private final String TAG;
  private boolean readyForDisplay;
  public List<Long> wJn;
  public k wJo;
  
  public aq()
  {
    AppMethodBeat.i(187329);
    this.TAG = "MicroMsg.SnsUnreadPreloader";
    this.wJn = new ArrayList();
    this.wJo = null;
    this.readyForDisplay = false;
    AppMethodBeat.o(187329);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(187330);
    if ((af.dtD().wJr) && ((paramn instanceof x)))
    {
      paramString = (cwc)((x)paramn).rr.gUT.gUX;
      boolean bool = ((x)paramn).dsS();
      ad.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((bool) && (paramString != null) && (!bt.gL(paramString.CEH)) && (!bt.gL(this.wJn)))
      {
        paramn = (SnsObject)paramString.CEH.peekLast();
        if (paramn != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramString = paramString.CEH.iterator();
          while (paramString.hasNext()) {
            localArrayList.add(Long.valueOf(((SnsObject)paramString.next()).Id));
          }
          this.wJn.removeAll(localArrayList);
          if ((this.wJn.isEmpty()) || (paramn.Id < ((Long)this.wJn.get(this.wJn.size() - 1)).longValue()))
          {
            ad.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
            this.wJo.state = 1;
            this.wJn.clear();
            AppMethodBeat.o(187330);
            return;
          }
          ad.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s", new Object[] { this.wJn.get(0) });
          com.tencent.mm.kernel.g.afA().gcy.a(new x(((Long)this.wJn.get(0)).longValue() + 1L, 0L, 2), 0);
        }
      }
    }
    AppMethodBeat.o(187330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */