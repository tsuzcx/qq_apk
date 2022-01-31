package com.tencent.mm.ui.chatting.h;

import android.os.HandlerThread;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.d.b.b;
import java.util.ArrayList;
import java.util.Iterator;

final class b$2
  implements b.a
{
  private am dsc = new am(au.DS().mnU.getLooper(), new am.a()
  {
    public final boolean tC()
    {
      if (b.2.this.vyI.vyF == null) {}
      for (boolean bool = true;; bool = false)
      {
        y.i("MicroMsg.BaseHistoryListPresenter", "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bk.bl(b.2.this.vos)) });
        if (!bk.bl(b.2.this.vos)) {
          break label145;
        }
        b.2.this.vyI.vyE.vos = b.2.this.vos;
        if (b.2.this.vyI.vyF != null) {
          break;
        }
        b.2.this.vyI.cFN();
        return false;
      }
      b.2.this.vyI.hka = b.2.this.vyI.vyF;
      ai.d(new Runnable()
      {
        public final void run()
        {
          if (b.2.this.vyI.vyD != null)
          {
            b.2.this.vyI.vyD.bM(b.2.this.vos, false);
            b.2.this.vyI.vyE.agL.notifyChanged();
          }
        }
      });
      return false;
      label145:
      b.2.this.vyI.hka = b.2.this.vyI.vyF;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = b.2.this.vyI.hka.iterator();
      while (localIterator.hasNext())
      {
        c.b localb = (c.b)localIterator.next();
        if (localb.ado(b.2.this.vos)) {
          localArrayList.add(localb);
        }
      }
      b.2.this.vyI.hka = localArrayList;
      b.2.this.vyI.vyE.vos = b.2.this.vos;
      ai.d(new Runnable()
      {
        public final void run()
        {
          if (b.2.this.vyI.vyD != null)
          {
            b.2.this.vyI.vyE.agL.notifyChanged();
            b.2.this.vyI.vyD.bM(b.2.this.vos, b.2.this.vyI.hka.isEmpty());
          }
        }
      });
      return false;
    }
  }, false);
  String vos = "";
  
  b$2(b paramb) {}
  
  public final void TP() {}
  
  public final void Wl()
  {
    y.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
    if (this.vyI.vyD != null) {
      this.vyI.vyD.onFinish();
    }
  }
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo()
  {
    y.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final boolean pB(String paramString)
  {
    return false;
  }
  
  public final void pC(String paramString)
  {
    if (!this.vos.equals(paramString))
    {
      this.vos = paramString;
      this.dsc.stopTimer();
      this.dsc.S(500L, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b.2
 * JD-Core Version:    0.7.0.1
 */