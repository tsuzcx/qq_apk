package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class v<T>
  extends BaseAdapter
  implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  protected T Bbi;
  private MMHandler HDS = new MMHandler(Looper.getMainLooper());
  private Cursor VZa = null;
  protected Map<Integer, T> VZb = null;
  protected v.a VZc;
  private int VZd = 0;
  private int VZe = 0;
  private int VZf = 0;
  private Runnable VZg = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141316);
      if (v.a(v.this) != 0)
      {
        Log.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(v.a(v.this)), Integer.valueOf(v.b(v.this)) });
        v.d(v.this).removeCallbacks(v.c(v.this));
        if (20 > v.e(v.this))
        {
          v.d(v.this).postDelayed(v.c(v.this), 100L);
          AppMethodBeat.o(141316);
          return;
        }
        Log.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(v.a(v.this)), Integer.valueOf(v.e(v.this)) });
      }
      Log.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
      v.f(v.this);
      v.g(v.this);
      AppMethodBeat.o(141316);
    }
  };
  public Context context;
  protected int count;
  
  public v(Context paramContext, T paramT)
  {
    this.Bbi = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void hHC()
  {
    Log.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    eKd();
    atr();
    if (this.VZc != null) {
      this.VZc.bxN();
    }
  }
  
  public void Fx(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.VZb != null)
      {
        this.VZb.clear();
        this.VZb = null;
      }
    }
    while (this.VZb != null) {
      return;
    }
    this.VZb = new HashMap();
  }
  
  public boolean TR(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + ezA());
  }
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public final void a(v.a parama)
  {
    this.VZc = parama;
  }
  
  public abstract void atr();
  
  protected abstract void ats();
  
  public void eKd()
  {
    if (this.VZb != null) {
      this.VZb.clear();
    }
    if (this.VZa != null) {
      this.VZa.close();
    }
    this.count = -1;
  }
  
  protected int ezA()
  {
    return 0;
  }
  
  protected T ezC()
  {
    return this.Bbi;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = hK().getCount();
    }
    return this.count + ezA();
  }
  
  public T getItem(int paramInt)
  {
    if (TR(paramInt)) {
      localObject1 = ezC();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.VZb == null) {
        break;
      }
      localObject2 = this.VZb.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!hK().moveToPosition(paramInt))) {
      return null;
    }
    if (this.VZb == null) {
      return a(this.Bbi, hK());
    }
    Object localObject1 = a(null, hK());
    this.VZb.put(Integer.valueOf(paramInt), localObject1);
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getRealCount()
  {
    if (this.count < 0) {
      this.count = hK().getCount();
    }
    return this.count;
  }
  
  public final void hFC()
  {
    this.VZc = null;
  }
  
  protected Cursor hK()
  {
    if ((this.VZa == null) || (this.VZa.isClosed()))
    {
      ats();
      Assert.assertNotNull(this.VZa);
    }
    return this.VZa;
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      return;
    }
    onNotifyChange((String)paramObject, null);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    hHC();
  }
  
  public final void v(Cursor paramCursor)
  {
    this.VZa = paramCursor;
    this.count = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.v
 * JD-Core Version:    0.7.0.1
 */