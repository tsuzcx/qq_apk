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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class r<T>
  extends BaseAdapter
  implements k.a, n.b
{
  protected T HmV;
  private Cursor HmW = null;
  protected Map<Integer, T> HmX = null;
  protected r.a HmY;
  private int HmZ = 0;
  private int Hna = 0;
  private int Hnb = 0;
  private Runnable Hnc = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141316);
      if (r.a(r.this) != 0)
      {
        ac.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(r.this)), Integer.valueOf(r.b(r.this)) });
        r.d(r.this).removeCallbacks(r.c(r.this));
        if (20 > r.e(r.this))
        {
          r.d(r.this).postDelayed(r.c(r.this), 100L);
          AppMethodBeat.o(141316);
          return;
        }
        ac.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(r.this)), Integer.valueOf(r.e(r.this)) });
      }
      ac.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
      r.f(r.this);
      r.g(r.this);
      AppMethodBeat.o(141316);
    }
  };
  public Context context;
  protected int count;
  private ao snT = new ao(Looper.getMainLooper());
  
  public r(Context paramContext, T paramT)
  {
    this.HmV = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void fgD()
  {
    ac.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    cVi();
    Xb();
    if (this.HmY != null) {
      this.HmY.aPg();
    }
  }
  
  public boolean GF(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + cRx());
  }
  
  public abstract void Xb();
  
  protected abstract void Xc();
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(r.a parama)
  {
    this.HmY = parama;
  }
  
  public void a(String paramString, m paramm)
  {
    fgD();
  }
  
  protected int cRx()
  {
    return 0;
  }
  
  protected T cRz()
  {
    return this.HmV;
  }
  
  public void cVi()
  {
    if (this.HmX != null) {
      this.HmX.clear();
    }
    if (this.HmW != null) {
      this.HmW.close();
    }
    this.count = -1;
  }
  
  public final void feY()
  {
    this.HmY = null;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count + cRx();
  }
  
  protected Cursor getCursor()
  {
    if ((this.HmW == null) || (this.HmW.isClosed()))
    {
      Xc();
      Assert.assertNotNull(this.HmW);
    }
    return this.HmW;
  }
  
  public T getItem(int paramInt)
  {
    if (GF(paramInt)) {
      localObject1 = cRz();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.HmX == null) {
        break;
      }
      localObject2 = this.HmX.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.HmX == null) {
      return a(this.HmV, getCursor());
    }
    Object localObject1 = a(null, getCursor());
    this.HmX.put(Integer.valueOf(paramInt), localObject1);
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
    this.HmW = paramCursor;
    this.count = -1;
  }
  
  public void wy(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.HmX != null)
      {
        this.HmX.clear();
        this.HmX = null;
      }
    }
    while (this.HmX != null) {
      return;
    }
    this.HmX = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */