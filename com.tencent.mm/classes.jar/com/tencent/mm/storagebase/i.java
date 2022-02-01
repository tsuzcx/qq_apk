package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i
{
  h Otw;
  private BlockingQueue<a> queue;
  private String table;
  private MTimerHandler timer;
  
  public i(h paramh, String paramString)
  {
    AppMethodBeat.i(133430);
    this.table = null;
    this.timer = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(133428);
        if (!i.this.Otw.isOpen())
        {
          AppMethodBeat.o(133428);
          return false;
        }
        i.this.gFI();
        AppMethodBeat.o(133428);
        return false;
      }
    }, false);
    this.queue = new LinkedBlockingQueue();
    this.Otw = paramh;
    this.table = paramString;
    AppMethodBeat.o(133430);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(133431);
    if (parama == null)
    {
      Log.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -2;
    }
    if ((this.Otw == null) || (!this.Otw.isOpen()))
    {
      Log.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -3;
    }
    if (parama.funcType == 2) {
      this.Otw.insert(this.table, parama.primaryKey, parama.values);
    }
    for (;;)
    {
      AppMethodBeat.o(133431);
      return 0;
      if (parama.funcType == 5)
      {
        this.Otw.delete(this.table, parama.OtI, parama.OtJ);
      }
      else if (parama.funcType == 1)
      {
        this.Otw.execSQL(this.table, parama.sql);
      }
      else if (parama.funcType == 4)
      {
        this.Otw.replace(this.table, parama.primaryKey, parama.values);
      }
      else
      {
        if (parama.funcType != 3) {
          break;
        }
        this.Otw.update(this.table, parama.values, parama.OtI, parama.OtJ);
      }
    }
    AppMethodBeat.o(133431);
    return -1;
  }
  
  final int b(a parama)
  {
    AppMethodBeat.i(133433);
    this.queue.add(parama);
    if (this.queue.size() >= 40) {
      gFI();
    }
    if (this.timer.stopped()) {
      this.timer.startTimer(60000L);
    }
    AppMethodBeat.o(133433);
    return 0;
  }
  
  public final int gFI()
  {
    AppMethodBeat.i(133432);
    Log.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.table, Boolean.valueOf(this.Otw.inTransaction()), Integer.valueOf(this.queue.size()) });
    if (this.queue.isEmpty())
    {
      AppMethodBeat.o(133432);
      return 0;
    }
    long l;
    if (!this.Otw.inTransaction()) {
      l = this.Otw.beginTransaction(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (!this.queue.isEmpty())
      {
        a((a)this.queue.poll());
      }
      else
      {
        if (l > 0L) {
          this.Otw.endTransaction(l);
        }
        AppMethodBeat.o(133432);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public String OtI;
    public String[] OtJ;
    public int funcType;
    public String primaryKey;
    public String sql;
    public ContentValues values;
    
    public final void Z(String[] paramArrayOfString)
    {
      AppMethodBeat.i(133429);
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
      {
        AppMethodBeat.o(133429);
        return;
      }
      this.OtJ = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.OtJ[i] = new String(paramArrayOfString[i]);
        i += 1;
      }
      AppMethodBeat.o(133429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storagebase.i
 * JD-Core Version:    0.7.0.1
 */