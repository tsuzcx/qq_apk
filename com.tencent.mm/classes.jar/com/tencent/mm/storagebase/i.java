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
  h FCD;
  private av cOx;
  private BlockingQueue<a> queue;
  private String table;
  
  public i(h paramh, String paramString)
  {
    AppMethodBeat.i(133430);
    this.table = null;
    this.cOx = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(133428);
        if (!i.this.FCD.isOpen())
        {
          AppMethodBeat.o(133428);
          return false;
        }
        i.this.eOi();
        AppMethodBeat.o(133428);
        return false;
      }
    }, false);
    this.queue = new LinkedBlockingQueue();
    this.FCD = paramh;
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
    if ((this.FCD == null) || (!this.FCD.isOpen()))
    {
      ad.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -3;
    }
    if (parama.EWD == 2) {
      this.FCD.a(this.table, parama.EYu, parama.values);
    }
    for (;;)
    {
      AppMethodBeat.o(133431);
      return 0;
      if (parama.EWD == 5)
      {
        this.FCD.delete(this.table, parama.FCP, parama.FCQ);
      }
      else if (parama.EWD == 1)
      {
        this.FCD.execSQL(this.table, parama.sql);
      }
      else if (parama.EWD == 4)
      {
        this.FCD.replace(this.table, parama.EYu, parama.values);
      }
      else
      {
        if (parama.EWD != 3) {
          break;
        }
        this.FCD.update(this.table, parama.values, parama.FCP, parama.FCQ);
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
      eOi();
    }
    if (this.cOx.eFX()) {
      this.cOx.av(60000L, 60000L);
    }
    AppMethodBeat.o(133433);
    return 0;
  }
  
  public final int eOi()
  {
    AppMethodBeat.i(133432);
    ad.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.table, Boolean.valueOf(this.FCD.inTransaction()), Integer.valueOf(this.queue.size()) });
    if (this.queue.isEmpty())
    {
      AppMethodBeat.o(133432);
      return 0;
    }
    long l;
    if (!this.FCD.inTransaction()) {
      l = this.FCD.rb(Thread.currentThread().getId());
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
          this.FCD.mX(l);
        }
        AppMethodBeat.o(133432);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public int EWD;
    public String EYu;
    public String FCP;
    public String[] FCQ;
    public String sql;
    public ContentValues values;
    
    public final void W(String[] paramArrayOfString)
    {
      AppMethodBeat.i(133429);
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
      {
        AppMethodBeat.o(133429);
        return;
      }
      this.FCQ = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.FCQ[i] = new String(paramArrayOfString[i]);
        i += 1;
      }
      AppMethodBeat.o(133429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storagebase.i
 * JD-Core Version:    0.7.0.1
 */