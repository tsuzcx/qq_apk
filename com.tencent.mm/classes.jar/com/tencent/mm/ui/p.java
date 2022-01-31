package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class p<T>
  extends BaseAdapter
  implements k.a, n.b
{
  public Context context;
  protected int count;
  private ak mHV = new ak(Looper.getMainLooper());
  protected T zan;
  private Cursor zao = null;
  protected Map<Integer, T> zap = null;
  protected p.a zaq;
  private int zar = 0;
  private int zas = 0;
  private int zat = 0;
  private Runnable zau = new p.1(this);
  
  public p(Context paramContext, T paramT)
  {
    this.zan = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void dCq()
  {
    ab.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    bKb();
    Ku();
    if (this.zaq != null) {
      this.zaq.apT();
    }
  }
  
  public abstract void Ku();
  
  protected abstract void Kv();
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public void a(int paramInt, n paramn, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(p.a parama)
  {
    this.zaq = parama;
  }
  
  public void a(String paramString, m paramm)
  {
    dCq();
  }
  
  protected int bHs()
  {
    return 0;
  }
  
  protected T bHt()
  {
    return this.zan;
  }
  
  public void bKb()
  {
    if (this.zap != null) {
      this.zap.clear();
    }
    if (this.zao != null) {
      this.zao.close();
    }
    this.count = -1;
  }
  
  public final void dAW()
  {
    this.zaq = null;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count + bHs();
  }
  
  protected final Cursor getCursor()
  {
    if ((this.zao == null) || (this.zao.isClosed()))
    {
      Kv();
      Assert.assertNotNull(this.zao);
    }
    return this.zao;
  }
  
  public T getItem(int paramInt)
  {
    if (xj(paramInt)) {
      localObject1 = bHt();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.zap == null) {
        break;
      }
      localObject2 = this.zap.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.zap == null) {
      return a(this.zan, getCursor());
    }
    Object localObject1 = a(null, getCursor());
    this.zap.put(Integer.valueOf(paramInt), localObject1);
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
  
  public final void qp(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.zap != null)
      {
        this.zap.clear();
        this.zap = null;
      }
    }
    while (this.zap != null) {
      return;
    }
    this.zap = new HashMap();
  }
  
  public final void setCursor(Cursor paramCursor)
  {
    this.zao = paramCursor;
    this.count = -1;
  }
  
  public boolean xj(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + bHs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.p
 * JD-Core Version:    0.7.0.1
 */