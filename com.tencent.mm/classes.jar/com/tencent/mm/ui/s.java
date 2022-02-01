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

public abstract class s<T>
  extends BaseAdapter
  implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  protected T OFE;
  private Cursor OFG = null;
  protected Map<Integer, T> OFH = null;
  protected a OFI;
  private int OFJ = 0;
  private int OFK = 0;
  private int OFL = 0;
  private Runnable OFM = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(141316);
      if (s.a(s.this) != 0)
      {
        Log.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(s.a(s.this)), Integer.valueOf(s.b(s.this)) });
        s.d(s.this).removeCallbacks(s.c(s.this));
        if (20 > s.e(s.this))
        {
          s.d(s.this).postDelayed(s.c(s.this), 100L);
          AppMethodBeat.o(141316);
          return;
        }
        Log.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(s.a(s.this)), Integer.valueOf(s.e(s.this)) });
      }
      Log.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
      s.f(s.this);
      s.g(s.this);
      AppMethodBeat.o(141316);
    }
  };
  public Context context;
  protected int count;
  private MMHandler wMu = new MMHandler(Looper.getMainLooper());
  
  public s(Context paramContext, T paramT)
  {
    this.OFE = paramT;
    this.context = paramContext;
    this.count = -1;
  }
  
  private void gIK()
  {
    Log.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    ebf();
    anp();
    if (this.OFI != null) {
      this.OFI.bnE();
    }
  }
  
  public void Bh(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.OFH != null)
      {
        this.OFH.clear();
        this.OFH = null;
      }
    }
    while (this.OFH != null) {
      return;
    }
    this.OFH = new HashMap();
  }
  
  public boolean Ox(int paramInt)
  {
    return (paramInt >= this.count) && (paramInt < this.count + dWu());
  }
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public final void a(a parama)
  {
    this.OFI = parama;
  }
  
  public abstract void anp();
  
  protected abstract void anq();
  
  protected int dWu()
  {
    return 0;
  }
  
  protected T dWw()
  {
    return this.OFE;
  }
  
  public void ebf()
  {
    if (this.OFH != null) {
      this.OFH.clear();
    }
    if (this.OFG != null) {
      this.OFG.close();
    }
    this.count = -1;
  }
  
  public final void gGV()
  {
    this.OFI = null;
  }
  
  public int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    return this.count + dWu();
  }
  
  protected Cursor getCursor()
  {
    if ((this.OFG == null) || (this.OFG.isClosed()))
    {
      anq();
      Assert.assertNotNull(this.OFG);
    }
    return this.OFG;
  }
  
  public T getItem(int paramInt)
  {
    if (Ox(paramInt)) {
      localObject1 = dWw();
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.OFH == null) {
        break;
      }
      localObject2 = this.OFH.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
    } while (localObject2 != null);
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.OFH == null) {
      return a(this.OFE, getCursor());
    }
    Object localObject1 = a(null, getCursor());
    this.OFH.put(Integer.valueOf(paramInt), localObject1);
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
    gIK();
  }
  
  public final void setCursor(Cursor paramCursor)
  {
    this.OFG = paramCursor;
    this.count = -1;
  }
  
  public static abstract interface a
  {
    public abstract void bnE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */