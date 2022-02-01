package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i
{
  h IOW;
  private av cXg;
  private BlockingQueue<a> queue;
  private String table;
  
  public i(h paramh, String paramString)
  {
    AppMethodBeat.i(133430);
    this.table = null;
    this.cXg = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(133428);
        if (!i.this.IOW.isOpen())
        {
          AppMethodBeat.o(133428);
          return false;
        }
        i.this.ftU();
        AppMethodBeat.o(133428);
        return false;
      }
    }, false);
    this.queue = new LinkedBlockingQueue();
    this.IOW = paramh;
    this.table = paramString;
    AppMethodBeat.o(133430);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(133431);
    if (parama == null)
    {
      ad.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -2;
    }
    if ((this.IOW == null) || (!this.IOW.isOpen()))
    {
      ad.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -3;
    }
    if (parama.IfE == 2) {
      this.IOW.a(this.table, parama.IhB, parama.values);
    }
    for (;;)
    {
      AppMethodBeat.o(133431);
      return 0;
      if (parama.IfE == 5)
      {
        this.IOW.delete(this.table, parama.IPi, parama.IPj);
      }
      else if (parama.IfE == 1)
      {
        this.IOW.execSQL(this.table, parama.sql);
      }
      else if (parama.IfE == 4)
      {
        this.IOW.replace(this.table, parama.IhB, parama.values);
      }
      else
      {
        if (parama.IfE != 3) {
          break;
        }
        this.IOW.update(this.table, parama.values, parama.IPi, parama.IPj);
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
      ftU();
    }
    if (this.cXg.fkZ()) {
      this.cXg.az(60000L, 60000L);
    }
    AppMethodBeat.o(133433);
    return 0;
  }
  
  public final int ftU()
  {
    AppMethodBeat.i(133432);
    ad.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.table, Boolean.valueOf(this.IOW.inTransaction()), Integer.valueOf(this.queue.size()) });
    if (this.queue.isEmpty())
    {
      AppMethodBeat.o(133432);
      return 0;
    }
    long l;
    if (!this.IOW.inTransaction()) {
      l = this.IOW.xO(Thread.currentThread().getId());
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
          this.IOW.sJ(l);
        }
        AppMethodBeat.o(133432);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public String IPi;
    public String[] IPj;
    public int IfE;
    public String IhB;
    public String sql;
    public ContentValues values;
    
    public final void Y(String[] paramArrayOfString)
    {
      AppMethodBeat.i(133429);
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
      {
        AppMethodBeat.o(133429);
        return;
      }
      this.IPj = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.IPj[i] = new String(paramArrayOfString[i]);
        i += 1;
      }
      AppMethodBeat.o(133429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storagebase.i
 * JD-Core Version:    0.7.0.1
 */