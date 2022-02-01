package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i
{
  h JjE;
  private aw cYd;
  private BlockingQueue<a> queue;
  private String table;
  
  public i(h paramh, String paramString)
  {
    AppMethodBeat.i(133430);
    this.table = null;
    this.cYd = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(133428);
        if (!i.this.JjE.isOpen())
        {
          AppMethodBeat.o(133428);
          return false;
        }
        i.this.fxV();
        AppMethodBeat.o(133428);
        return false;
      }
    }, false);
    this.queue = new LinkedBlockingQueue();
    this.JjE = paramh;
    this.table = paramString;
    AppMethodBeat.o(133430);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(133431);
    if (parama == null)
    {
      ae.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -2;
    }
    if ((this.JjE == null) || (!this.JjE.isOpen()))
    {
      ae.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", new Object[] { this.table });
      AppMethodBeat.o(133431);
      return -3;
    }
    if (parama.IzP == 2) {
      this.JjE.a(this.table, parama.IBM, parama.values);
    }
    for (;;)
    {
      AppMethodBeat.o(133431);
      return 0;
      if (parama.IzP == 5)
      {
        this.JjE.delete(this.table, parama.JjQ, parama.JjR);
      }
      else if (parama.IzP == 1)
      {
        this.JjE.execSQL(this.table, parama.sql);
      }
      else if (parama.IzP == 4)
      {
        this.JjE.replace(this.table, parama.IBM, parama.values);
      }
      else
      {
        if (parama.IzP != 3) {
          break;
        }
        this.JjE.update(this.table, parama.values, parama.JjQ, parama.JjR);
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
      fxV();
    }
    if (this.cYd.foU()) {
      this.cYd.ay(60000L, 60000L);
    }
    AppMethodBeat.o(133433);
    return 0;
  }
  
  public final int fxV()
  {
    AppMethodBeat.i(133432);
    ae.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", new Object[] { this.table, Boolean.valueOf(this.JjE.inTransaction()), Integer.valueOf(this.queue.size()) });
    if (this.queue.isEmpty())
    {
      AppMethodBeat.o(133432);
      return 0;
    }
    long l;
    if (!this.JjE.inTransaction()) {
      l = this.JjE.yi(Thread.currentThread().getId());
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
          this.JjE.sW(l);
        }
        AppMethodBeat.o(133432);
        return 0;
        l = 0L;
      }
    }
  }
  
  public static final class a
  {
    public String IBM;
    public int IzP;
    public String JjQ;
    public String[] JjR;
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
      this.JjR = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.JjR[i] = new String(paramArrayOfString[i]);
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