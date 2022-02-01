package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ar
  implements com.tencent.mm.ak.g
{
  private final String TAG;
  private boolean readyForDisplay;
  public List<Long> xVT;
  public k xVU;
  
  public ar()
  {
    AppMethodBeat.i(200125);
    this.TAG = "MicroMsg.SnsUnreadPreloader";
    this.xVT = new ArrayList();
    this.xVU = null;
    this.readyForDisplay = false;
    AppMethodBeat.o(200125);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(200126);
    if ((af.dIa().xVW) && ((paramn instanceof x)))
    {
      paramString = (dbo)((x)paramn).rr.hvs.hvw;
      boolean bool = ((x)paramn).dHp();
      ac.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((bool) && (paramString != null) && (!bs.gY(paramString.DXh)) && (!bs.gY(this.xVT)))
      {
        paramn = (SnsObject)paramString.DXh.peekLast();
        if (paramn != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramString = paramString.DXh.iterator();
          while (paramString.hasNext()) {
            localArrayList.add(Long.valueOf(((SnsObject)paramString.next()).Id));
          }
          this.xVT.removeAll(localArrayList);
          if ((this.xVT.isEmpty()) || (paramn.Id < ((Long)this.xVT.get(this.xVT.size() - 1)).longValue()))
          {
            ac.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
            this.xVU.state = 1;
            this.xVT.clear();
            AppMethodBeat.o(200126);
            return;
          }
          ac.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s", new Object[] { this.xVT.get(0) });
          com.tencent.mm.kernel.g.agQ().ghe.a(new x(((Long)this.xVT.get(0)).longValue() + 1L, 0L, 2), 0);
        }
      }
    }
    AppMethodBeat.o(200126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */