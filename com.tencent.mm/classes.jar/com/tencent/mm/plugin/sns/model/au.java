package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ele;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class au
  implements i
{
  public List<Long> Kal;
  public l Kam;
  public int Kan;
  private final String TAG;
  private boolean readyForDisplay;
  
  public au()
  {
    AppMethodBeat.i(269831);
    this.TAG = "MicroMsg.SnsUnreadPreloader";
    this.Kal = new ArrayList();
    this.Kam = null;
    this.readyForDisplay = false;
    this.Kan = 50;
    AppMethodBeat.o(269831);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(269834);
    if ((aj.fOT().Kap) && ((paramq instanceof z)))
    {
      paramString = (ele)d.c.b(((z)paramq).rr.lBS);
      boolean bool = ((z)paramq).fOd();
      Log.i("MicroMsg.SnsUnreadPreloader", "errType:%s, errCode:%s, isForUnreadPreload:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((bool) && (paramString != null) && (!Util.isNullOrNil(paramString.RPF)) && (!Util.isNullOrNil(this.Kal)))
      {
        paramq = (SnsObject)paramString.RPF.peekLast();
        if (paramq != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramString = paramString.RPF.iterator();
          while (paramString.hasNext()) {
            localArrayList.add(Long.valueOf(((SnsObject)paramString.next()).Id));
          }
          this.Kal.removeAll(localArrayList);
          if ((this.Kal.isEmpty()) || (paramq.Id < ((Long)this.Kal.get(this.Kal.size() - 1)).longValue()))
          {
            Log.i("MicroMsg.SnsUnreadPreloader", "finish preload unread fault");
            this.Kam.state = 1;
            this.Kal.clear();
            AppMethodBeat.o(269834);
            return;
          }
          if (this.Kam.Kfk > this.Kan)
          {
            Log.i("MicroMsg.SnsUnreadPreloader", "drop preload unread fault, too many times!!");
            this.Kam.state = 3;
            this.Kal.clear();
            AppMethodBeat.o(269834);
            return;
          }
          paramString = this.Kam;
          paramString.Kfk += 1;
          Log.i("MicroMsg.SnsUnreadPreloader", "continue preload unread fault, maxId:%s, preloadCount:%s, unreadItem:%s", new Object[] { this.Kal.get(0), Integer.valueOf(this.Kam.Kfk), this.Kam });
          h.aHF().kcd.a(new z(((Long)this.Kal.get(0)).longValue() + 1L, 0L, 2), 0);
        }
      }
    }
    AppMethodBeat.o(269834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.au
 * JD-Core Version:    0.7.0.1
 */