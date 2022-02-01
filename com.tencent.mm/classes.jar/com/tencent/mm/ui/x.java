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

public abstract class x<T>
  extends BaseAdapter
  implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private MMHandler NBu = new MMHandler(Looper.getMainLooper());
  protected T aYG;
  private int adDA = 0;
  private Runnable adDB = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141316);
      if (x.a(x.this) != 0)
      {
        Log.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(x.a(x.this)), Integer.valueOf(x.b(x.this)) });
        x.d(x.this).removeCallbacks(x.c(x.this));
        if (20 > x.e(x.this))
        {
          x.d(x.this).postDelayed(x.c(x.this), 100L);
          AppMethodBeat.o(141316);
          return;
        }
        Log.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(x.a(x.this)), Integer.valueOf(x.e(x.this)) });
      }
      Log.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
      x.f(x.this);
      x.g(x.this);
      AppMethodBeat.o(141316);
    }
  };
  private Cursor adDv = null;
  protected Map<Integer, T> adDw = null;
  protected a adDx;
  private int adDy = 0;
  private int adDz = 0;
  public Context context;
  protected int count;
  
  public x(Context paramContext, T paramT)
  {
    this.aYG = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void jjM()
  {
    Log.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    fSd();
    aNy();
    if (this.adDx != null) {
      this.adDx.bWC();
    }
  }
  
  protected Cursor Fv()
  {
    if ((this.adDv == null) || (this.adDv.isClosed()))
    {
      aNz();
      Assert.assertNotNull(this.adDv);
    }
    return this.adDv;
  }
  
  public void Lh(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.adDw != null)
      {
        this.adDw.clear();
        this.adDw = null;
      }
    }
    while (this.adDw != null) {
      return;
    }
    this.adDw = new HashMap();
  }
  
  public boolean XL(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + fHy());
  }
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public final void a(a parama)
  {
    this.adDx = parama;
  }
  
  public abstract void aNy();
  
  protected abstract void aNz();
  
  protected T fHA()
  {
    return this.aYG;
  }
  
  protected int fHy()
  {
    return 0;
  }
  
  public void fSd()
  {
    if (this.adDw != null) {
      this.adDw.clear();
    }
    if (this.adDv != null) {
      this.adDv.close();
    }
    this.count = -1;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = Fv().getCount();
    }
    return this.count + fHy();
  }
  
  public T getItem(int paramInt)
  {
    if (XL(paramInt)) {
      localObject1 = fHA();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.adDw == null) {
        break;
      }
      localObject2 = this.adDw.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!Fv().moveToPosition(paramInt))) {
      return null;
    }
    if (this.adDw == null) {
      return a(this.aYG, Fv());
    }
    Object localObject1 = a(null, Fv());
    this.adDw.put(Integer.valueOf(paramInt), localObject1);
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getRealCount()
  {
    if (this.count < 0) {
      this.count = Fv().getCount();
    }
    return this.count;
  }
  
  public final void jhO()
  {
    this.adDx = null;
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
    jjM();
  }
  
  public final void w(Cursor paramCursor)
  {
    this.adDv = paramCursor;
    this.count = -1;
  }
  
  public static abstract interface a
  {
    public abstract void bWC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */