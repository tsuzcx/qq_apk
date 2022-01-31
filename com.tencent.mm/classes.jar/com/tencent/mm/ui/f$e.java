package com.tencent.mm.ui;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class f$e
{
  f<K, T>.e.b uIv;
  private f<K, T>.e.c uIw;
  LinkedList<Integer> uIx;
  int uIy;
  
  public f$e(f paramf)
  {
    cyi();
  }
  
  private void cyi()
  {
    this.uIv = new b(Looper.getMainLooper());
    this.uIw = new f.e.c(this, au.DS().mnU.getLooper());
  }
  
  private void cyj()
  {
    Object localObject = this.uIw;
    ((f.e.c)localObject).removeMessages(((f.e.c)localObject).uIF);
    ((f.e.c)localObject).removeMessages(((f.e.c)localObject).uIG);
    localObject = this.uIv;
    ((b)localObject).uIB = true;
    ((b)localObject).removeMessages(1);
    ((b)localObject).removeMessages(2);
    this.uIx.clear();
    this.uIy = 0;
  }
  
  final void FL(int paramInt)
  {
    try
    {
      if (!this.uIx.contains(Integer.valueOf(paramInt))) {
        this.uIx.add(Integer.valueOf(paramInt));
      }
      this.uIy = cyl();
      f.e.c localc = this.uIw;
      localc.sendEmptyMessage(localc.uIG);
      return;
    }
    finally {}
  }
  
  public final void cyk()
  {
    try
    {
      y.i(this.uIr.TAG, "newcursor resetQueue ");
      cyj();
      cyi();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final int cyl()
  {
    int i = 0;
    if (this.uIx.size() > 1) {
      i = 2;
    }
    while (this.uIx.size() != 1) {
      return i;
    }
    return ((Integer)this.uIx.get(0)).intValue();
  }
  
  /* Error */
  public final boolean cym()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 172	com/tencent/mm/ui/f$e:uIy	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	e
    //   6	2	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  final void cyn()
  {
    try
    {
      this.uIw.lastUpdateTime = System.currentTimeMillis();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final int cyo()
  {
    try
    {
      int i = this.uIy;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void quit()
  {
    try
    {
      y.i(this.uIr.TAG, "newcursor quit ");
      cyj();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final class b
    extends ah
  {
    boolean uIB;
    public final int uIC = 1;
    public final int uID = 2;
    
    public b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (this.uIB) {}
      do
      {
        return;
        synchronized (f.e.this)
        {
          f.e.this.uIy = f.e.this.cyl();
          y.i(f.e.this.uIr.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(f.e.this.uIy) });
          if (paramMessage.what == 1)
          {
            f.d(f.e.this.uIr);
            return;
          }
        }
      } while (paramMessage.what != 2);
      f.a(f.e.this.uIr, (f.c)paramMessage.obj, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.f.e
 * JD-Core Version:    0.7.0.1
 */