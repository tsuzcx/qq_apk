package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i
{
  h HbG;
  private au cLS;
  private BlockingQueue<a> queue;
  private String table;
  
  public i(h paramh, String paramString)
  {
    AppMethodBeat.i(133430);
    this.table = null;
    this.cLS = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(133428);
        if (!i.this.HbG.isOpen())
        {
          AppMethodBeat.o(133428);
          return false;
        }
        i.this.fdM();
        AppMethodBeat.o(133428);
        return false;
      }
    }, false);
    this.queue = new LinkedBlockingQueue();
    this.HbG = paramh;
    this.table = paramString;
    AppMethodBeat.o(133430);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(133431);
    if (parama == null)
    {
      ac.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -2;
    }
    if ((this.HbG == null) || (!this.HbG.isOpen()))
    {
      ac.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -3;
    }
    if (parama.GtP == 2) {
      this.HbG.a(this.table, parama.GvG, parama.values);
    }
    for (;;)
    {
      AppMethodBeat.o(133431);
      return 0;
      if (parama.GtP == 5)
      {
        this.HbG.delete(this.table, parama.HbS, parama.HbT);
      }
      else if (parama.GtP == 1)
      {
        this.HbG.execSQL(this.table, parama.sql);
      }
      else if (parama.GtP == 4)
      {
        this.HbG.replace(this.table, parama.GvG, parama.values);
      }
      else
      {
        if (parama.GtP != 3) {
          break;
        }
        this.HbG.update(this.table, parama.values, parama.HbS, parama.HbT);
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
      fdM();
    }
    if (this.cLS.eVs()) {
      this.cLS.au(60000L, 60000L);
    }
    AppMethodBeat.o(133433);
    return 0;
  }
  
  public final int fdM()
  {
    AppMethodBeat.i(133432);
    ac.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.table, Boolean.valueOf(this.HbG.inTransaction()), Integer.valueOf(this.queue.size()) });
    if (this.queue.isEmpty())
    {
      AppMethodBeat.o(133432);
      return 0;
    }
    long l;
    if (!this.HbG.inTransaction()) {
      l = this.HbG.vE(Thread.currentThread().getId());
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
          this.HbG.qL(l);
        }
        AppMethodBeat.o(133432);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public int GtP;
    public String GvG;
    public String HbS;
    public String[] HbT;
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
      this.HbT = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.HbT[i] = new String(paramArrayOfString[i]);
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