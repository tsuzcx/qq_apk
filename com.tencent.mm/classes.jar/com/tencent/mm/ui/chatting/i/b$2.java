package com.tencent.mm.ui.chatting.i;

import android.os.HandlerThread;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.e.b.b;
import java.util.ArrayList;
import java.util.Iterator;

final class b$2
  implements b.a
{
  private ap ejK;
  String zDO;
  
  b$2(b paramb)
  {
    AppMethodBeat.i(32530);
    this.zDO = "";
    this.ejK = new ap(aw.RO().oNc.getLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(32529);
        boolean bool;
        if (b.2.this.zPf.zPe == null)
        {
          bool = true;
          ab.i("MicroMsg.BaseHistoryListPresenter", "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bo.isNullOrNil(b.2.this.zDO)) });
          if (!bo.isNullOrNil(b.2.this.zDO)) {
            break label158;
          }
          b.2.this.zPf.zPd.zDO = b.2.this.zDO;
          if (b.2.this.zPf.zPe != null) {
            break label124;
          }
          b.2.this.zPf.dJQ();
        }
        for (;;)
        {
          AppMethodBeat.o(32529);
          return false;
          bool = false;
          break;
          label124:
          b.2.this.zPf.iVH = b.2.this.zPf.zPe;
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(32527);
              if (b.2.this.zPf.zPc != null)
              {
                b.2.this.zPf.zPc.co(b.2.this.zDO, false);
                b.2.this.zPf.zPd.ajb.notifyChanged();
              }
              AppMethodBeat.o(32527);
            }
          });
        }
        label158:
        b.2.this.zPf.iVH = b.2.this.zPf.zPe;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = b.2.this.zPf.iVH.iterator();
        while (localIterator.hasNext())
        {
          c.b localb = (c.b)localIterator.next();
          if (localb.atP(b.2.this.zDO)) {
            localArrayList.add(localb);
          }
        }
        b.2.this.zPf.iVH = localArrayList;
        b.2.this.zPf.zPd.zDO = b.2.this.zDO;
        al.d(new b.2.1.2(this));
        AppMethodBeat.o(32529);
        return false;
      }
    }, false);
    AppMethodBeat.o(32530);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void anc() {}
  
  public final void apN()
  {
    AppMethodBeat.i(32531);
    ab.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
    if (this.zPf.zPc != null) {
      this.zPf.zPc.onFinish();
    }
    AppMethodBeat.o(32531);
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ()
  {
    AppMethodBeat.i(32533);
    ab.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
    AppMethodBeat.o(32533);
  }
  
  public final boolean wR(String paramString)
  {
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(32532);
    if (!this.zDO.equals(paramString))
    {
      this.zDO = paramString;
      this.ejK.stopTimer();
      this.ejK.ag(500L, 500L);
    }
    AppMethodBeat.o(32532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b.2
 * JD-Core Version:    0.7.0.1
 */