package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class av
  implements i
{
  public List<Long> DNj;
  public l DNk;
  public int DNl;
  private final String TAG;
  private boolean readyForDisplay;
  
  public av()
  {
    AppMethodBeat.i(202787);
    this.TAG = "MicroMsg.SnsUnreadPreloader";
    this.DNj = new ArrayList();
    this.DNk = null;
    this.readyForDisplay = false;
    this.DNl = 50;
    AppMethodBeat.o(202787);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(202788);
    if ((aj.faZ().DNn) && ((paramq instanceof z)))
    {
      paramString = (ebe)((z)paramq).rr.iLL.iLR;
      boolean bool = ((z)paramq).fak();
      Log.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((bool) && (paramString != null) && (!Util.isNullOrNil(paramString.KOH)) && (!Util.isNullOrNil(this.DNj)))
      {
        paramq = (SnsObject)paramString.KOH.peekLast();
        if (paramq != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramString = paramString.KOH.iterator();
          while (paramString.hasNext()) {
            localArrayList.add(Long.valueOf(((SnsObject)paramString.next()).Id));
          }
          this.DNj.removeAll(localArrayList);
          if ((this.DNj.isEmpty()) || (paramq.Id < ((Long)this.DNj.get(this.DNj.size() - 1)).longValue()))
          {
            Log.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
            this.DNk.state = 1;
            this.DNj.clear();
            AppMethodBeat.o(202788);
            return;
          }
          if (this.DNk.DSd > this.DNl)
          {
            Log.i("MicroMsg.SnsUnreadPreloader", "drop preload unread fault, too many times!!");
            this.DNk.state = 3;
            this.DNj.clear();
            AppMethodBeat.o(202788);
            return;
          }
          paramString = this.DNk;
          paramString.DSd += 1;
          Log.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s, preloadCount:%s, unreadItem:%s", new Object[] { this.DNj.get(0), Integer.valueOf(this.DNk.DSd), this.DNk });
          g.aAg().hqi.a(new z(((Long)this.DNj.get(0)).longValue() + 1L, 0L, 2), 0);
        }
      }
    }
    AppMethodBeat.o(202788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.av
 * JD-Core Version:    0.7.0.1
 */