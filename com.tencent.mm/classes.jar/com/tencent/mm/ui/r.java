package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class r<T>
  extends BaseAdapter
  implements j.a, m.b
{
  public Context context;
  public int count;
  private ah ntK = new ah(Looper.getMainLooper());
  private Cursor uEq = null;
  public T uMg;
  public Map<Integer, T> uMh = null;
  public r.a uMi;
  private int uMj = 0;
  private int uMk = 0;
  private int uMl = 0;
  private Runnable uMm = new r.1(this);
  
  public r(Context paramContext, T paramT)
  {
    this.uMg = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void czf()
  {
    y.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    bcS();
    yc();
    if (this.uMi != null) {
      this.uMi.Wp();
    }
  }
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      y.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public void a(String paramString, l paraml)
  {
    czf();
  }
  
  public int bam()
  {
    return 0;
  }
  
  public T ban()
  {
    return this.uMg;
  }
  
  public void bcS()
  {
    if (this.uMh != null) {
      this.uMh.clear();
    }
    if (this.uEq != null) {
      this.uEq.close();
    }
    this.count = -1;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count + bam();
  }
  
  public final Cursor getCursor()
  {
    if ((this.uEq == null) || (this.uEq.isClosed()))
    {
      yd();
      Assert.assertNotNull(this.uEq);
    }
    return this.uEq;
  }
  
  public T getItem(int paramInt)
  {
    if (sk(paramInt)) {
      localObject1 = ban();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.uMh == null) {
        break;
      }
      localObject2 = this.uMh.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.uMh == null) {
      return a(this.uMg, getCursor());
    }
    Object localObject1 = a(null, getCursor());
    this.uMh.put(Integer.valueOf(paramInt), localObject1);
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
  
  public final void mR(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.uMh != null)
      {
        this.uMh.clear();
        this.uMh = null;
      }
    }
    while (this.uMh != null) {
      return;
    }
    this.uMh = new HashMap();
  }
  
  public final void setCursor(Cursor paramCursor)
  {
    this.uEq = paramCursor;
    this.count = -1;
  }
  
  public boolean sk(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + bam());
  }
  
  public abstract void yc();
  
  public abstract void yd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */