package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class q<T>
  extends BaseAdapter
  implements k.a, n.b
{
  protected T FNk;
  private Cursor FNl = null;
  protected Map<Integer, T> FNm = null;
  protected q.a FNn;
  private int FNo = 0;
  private int FNp = 0;
  private int FNq = 0;
  private Runnable FNr = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141316);
      if (q.a(q.this) != 0)
      {
        ad.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(q.a(q.this)), Integer.valueOf(q.b(q.this)) });
        q.d(q.this).removeCallbacks(q.c(q.this));
        if (20 > q.e(q.this))
        {
          q.d(q.this).postDelayed(q.c(q.this), 100L);
          AppMethodBeat.o(141316);
          return;
        }
        ad.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(q.a(q.this)), Integer.valueOf(q.e(q.this)) });
      }
      ad.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
      q.f(q.this);
      q.g(q.this);
      AppMethodBeat.o(141316);
    }
  };
  public Context context;
  protected int count;
  private ap rfb = new ap(Looper.getMainLooper());
  
  public q(Context paramContext, T paramT)
  {
    this.FNk = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void eQU()
  {
    ad.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    cHX();
    Wd();
    if (this.FNn != null) {
      this.FNn.aIp();
    }
  }
  
  public boolean EJ(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + cEn());
  }
  
  public abstract void Wd();
  
  protected abstract void We();
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(q.a parama)
  {
    this.FNn = parama;
  }
  
  public void a(String paramString, m paramm)
  {
    eQU();
  }
  
  protected int cEn()
  {
    return 0;
  }
  
  protected T cEp()
  {
    return this.FNk;
  }
  
  public void cHX()
  {
    if (this.FNm != null) {
      this.FNm.clear();
    }
    if (this.FNl != null) {
      this.FNl.close();
    }
    this.count = -1;
  }
  
  public final void ePu()
  {
    this.FNn = null;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count + cEn();
  }
  
  protected Cursor getCursor()
  {
    if ((this.FNl == null) || (this.FNl.isClosed()))
    {
      We();
      Assert.assertNotNull(this.FNl);
    }
    return this.FNl;
  }
  
  public T getItem(int paramInt)
  {
    if (EJ(paramInt)) {
      localObject1 = cEp();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.FNm == null) {
        break;
      }
      localObject2 = this.FNm.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.FNm == null) {
      return a(this.FNk, getCursor());
    }
    Object localObject1 = a(null, getCursor());
    this.FNm.put(Integer.valueOf(paramInt), localObject1);
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getRealCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count;
  }
  
  public final void setCursor(Cursor paramCursor)
  {
    this.FNl = paramCursor;
    this.count = -1;
  }
  
  public void vw(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.FNm != null)
      {
        this.FNm.clear();
        this.FNm = null;
      }
    }
    while (this.FNm != null) {
      return;
    }
    this.FNm = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.q
 * JD-Core Version:    0.7.0.1
 */