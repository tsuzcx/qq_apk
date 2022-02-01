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

public abstract class r<T>
  extends BaseAdapter
  implements k.a, n.b
{
  protected T JaC;
  private Cursor JaD = null;
  protected Map<Integer, T> JaE = null;
  protected r.a JaF;
  private int JaG = 0;
  private int JaH = 0;
  private int JaI = 0;
  private Runnable JaJ = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141316);
      if (r.a(r.this) != 0)
      {
        ad.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(r.this)), Integer.valueOf(r.b(r.this)) });
        r.d(r.this).removeCallbacks(r.c(r.this));
        if (20 > r.e(r.this))
        {
          r.d(r.this).postDelayed(r.c(r.this), 100L);
          AppMethodBeat.o(141316);
          return;
        }
        ad.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(r.this)), Integer.valueOf(r.e(r.this)) });
      }
      ad.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
      r.f(r.this);
      r.g(r.this);
      AppMethodBeat.o(141316);
    }
  };
  public Context context;
  protected int count;
  private ap tkw = new ap(Looper.getMainLooper());
  
  public r(Context paramContext, T paramT)
  {
    this.JaC = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void fwP()
  {
    ad.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    det();
    Zu();
    if (this.JaF != null) {
      this.JaF.aSs();
    }
  }
  
  public boolean HY(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + dac());
  }
  
  public abstract void Zu();
  
  protected abstract void Zv();
  
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
  
  public final void a(r.a parama)
  {
    this.JaF = parama;
  }
  
  public void a(String paramString, m paramm)
  {
    fwP();
  }
  
  protected int dac()
  {
    return 0;
  }
  
  protected T dae()
  {
    return this.JaC;
  }
  
  public void det()
  {
    if (this.JaE != null) {
      this.JaE.clear();
    }
    if (this.JaD != null) {
      this.JaD.close();
    }
    this.count = -1;
  }
  
  public final void fvg()
  {
    this.JaF = null;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count + dac();
  }
  
  protected Cursor getCursor()
  {
    if ((this.JaD == null) || (this.JaD.isClosed()))
    {
      Zv();
      Assert.assertNotNull(this.JaD);
    }
    return this.JaD;
  }
  
  public T getItem(int paramInt)
  {
    if (HY(paramInt)) {
      localObject1 = dae();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.JaE == null) {
        break;
      }
      localObject2 = this.JaE.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.JaE == null) {
      return a(this.JaC, getCursor());
    }
    Object localObject1 = a(null, getCursor());
    this.JaE.put(Integer.valueOf(paramInt), localObject1);
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
    this.JaD = paramCursor;
    this.count = -1;
  }
  
  public void xk(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.JaE != null)
      {
        this.JaE.clear();
        this.JaE = null;
      }
    }
    while (this.JaE != null) {
      return;
    }
    this.JaE = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */