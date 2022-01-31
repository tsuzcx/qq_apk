package com.tencent.mm.ui;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;

final class f$e
{
  f<K, T>.e.b yVO;
  private f<K, T>.e.c yVP;
  LinkedList<Integer> yVQ;
  int yVR;
  
  public f$e(f paramf)
  {
    AppMethodBeat.i(29181);
    dBi();
    AppMethodBeat.o(29181);
  }
  
  private void dBi()
  {
    AppMethodBeat.i(29182);
    this.yVO = new f.e.b(this, Looper.getMainLooper());
    this.yVP = new f.e.c(this, aw.RO().oNc.getLooper());
    AppMethodBeat.o(29182);
  }
  
  private void dBj()
  {
    AppMethodBeat.i(29183);
    Object localObject = this.yVP;
    ((f.e.c)localObject).removeMessages(((f.e.c)localObject).yVY);
    ((f.e.c)localObject).removeMessages(((f.e.c)localObject).yVZ);
    localObject = this.yVO;
    ((f.e.b)localObject).yVU = true;
    ((f.e.b)localObject).removeMessages(1);
    ((f.e.b)localObject).removeMessages(2);
    this.yVQ.clear();
    this.yVR = 0;
    AppMethodBeat.o(29183);
  }
  
  final void NZ(int paramInt)
  {
    try
    {
      AppMethodBeat.i(29188);
      if (!this.yVQ.contains(Integer.valueOf(paramInt))) {
        this.yVQ.add(Integer.valueOf(paramInt));
      }
      this.yVR = dBl();
      f.e.c localc = this.yVP;
      localc.sendEmptyMessage(localc.yVZ);
      AppMethodBeat.o(29188);
      return;
    }
    finally {}
  }
  
  public final void dBk()
  {
    try
    {
      AppMethodBeat.i(29184);
      ab.i(this.yVK.TAG, "newcursor resetQueue ");
      dBj();
      dBi();
      AppMethodBeat.o(29184);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final int dBl()
  {
    int i = 0;
    AppMethodBeat.i(29186);
    if (this.yVQ.size() > 1) {
      i = 2;
    }
    for (;;)
    {
      AppMethodBeat.o(29186);
      return i;
      if (this.yVQ.size() == 1) {
        i = ((Integer)this.yVQ.get(0)).intValue();
      }
    }
  }
  
  /* Error */
  public final boolean dBm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 178	com/tencent/mm/ui/f$e:yVR	I
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
  
  final void dBn()
  {
    try
    {
      AppMethodBeat.i(29187);
      this.yVP.lastUpdateTime = System.currentTimeMillis();
      AppMethodBeat.o(29187);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final int dBo()
  {
    try
    {
      int i = this.yVR;
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
      AppMethodBeat.i(29185);
      ab.i(this.yVK.TAG, "newcursor quit ");
      dBj();
      AppMethodBeat.o(29185);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.f.e
 * JD-Core Version:    0.7.0.1
 */