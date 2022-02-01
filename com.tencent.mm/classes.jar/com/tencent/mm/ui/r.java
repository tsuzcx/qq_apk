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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class r<T>
  extends BaseAdapter
  implements k.a, n.b
{
  protected T Jvk;
  private Cursor Jvl = null;
  protected Map<Integer, T> Jvm = null;
  protected a Jvn;
  private int Jvo = 0;
  private int Jvp = 0;
  private int Jvq = 0;
  private Runnable Jvr = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141316);
      if (r.a(r.this) != 0)
      {
        ae.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(r.this)), Integer.valueOf(r.b(r.this)) });
        r.d(r.this).removeCallbacks(r.c(r.this));
        if (20 > r.e(r.this))
        {
          r.d(r.this).postDelayed(r.c(r.this), 100L);
          AppMethodBeat.o(141316);
          return;
        }
        ae.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(r.this)), Integer.valueOf(r.e(r.this)) });
      }
      ae.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
      r.f(r.this);
      r.g(r.this);
      AppMethodBeat.o(141316);
    }
  };
  public Context context;
  protected int count;
  private aq tvo = new aq(Looper.getMainLooper());
  
  public r(Context paramContext, T paramT)
  {
    this.Jvk = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void fAR()
  {
    ae.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    dhl();
    ZD();
    if (this.Jvn != null) {
      this.Jvn.aSR();
    }
  }
  
  public boolean Iw(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + dcN());
  }
  
  public abstract void ZD();
  
  protected abstract void ZE();
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(a parama)
  {
    this.Jvn = parama;
  }
  
  public void a(String paramString, m paramm)
  {
    fAR();
  }
  
  protected int dcN()
  {
    return 0;
  }
  
  protected T dcP()
  {
    return this.Jvk;
  }
  
  public void dhl()
  {
    if (this.Jvm != null) {
      this.Jvm.clear();
    }
    if (this.Jvl != null) {
      this.Jvl.close();
    }
    this.count = -1;
  }
  
  public final void fzh()
  {
    this.Jvn = null;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count + dcN();
  }
  
  protected Cursor getCursor()
  {
    if ((this.Jvl == null) || (this.Jvl.isClosed()))
    {
      ZE();
      Assert.assertNotNull(this.Jvl);
    }
    return this.Jvl;
  }
  
  public T getItem(int paramInt)
  {
    if (Iw(paramInt)) {
      localObject1 = dcP();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.Jvm == null) {
        break;
      }
      localObject2 = this.Jvm.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.Jvm == null) {
      return a(this.Jvk, getCursor());
    }
    Object localObject1 = a(null, getCursor());
    this.Jvm.put(Integer.valueOf(paramInt), localObject1);
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
    this.Jvl = paramCursor;
    this.count = -1;
  }
  
  public void xs(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.Jvm != null)
      {
        this.Jvm.clear();
        this.Jvm = null;
      }
    }
    while (this.Jvm != null) {
      return;
    }
    this.Jvm = new HashMap();
  }
  
  public static abstract interface a
  {
    public abstract void aSR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */