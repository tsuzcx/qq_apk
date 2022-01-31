package com.tencent.mm.v;

import a.d.b.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.w.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static final e.a dBC = new e.a((byte)0);
  final f dBA;
  final c dBB;
  
  public e(f paramf)
  {
    this.dBA = paramf;
    this.dBB = new c(this);
  }
  
  public final void a(int paramInt, com.tencent.mm.api.e parame, b paramb)
  {
    g.k(parame, "item");
    g.k(paramb, "executor");
    long l = System.currentTimeMillis();
    y.i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(parame.rU() - bz.Is() / 1000L), parame.rO() });
    Object localObject = this.dBB;
    paramb = new d(paramInt, parame, paramb);
    g.k(paramb, "task");
    parame = null;
    if (((c)localObject).cJ.containsKey(paramb.dBy.rO())) {
      parame = (d)((c)localObject).cJ.remove(paramb.dBy.rO());
    }
    label166:
    Object[] arrayOfObject;
    if (parame != null) {
      if (101 == paramb.bMU)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label347;
        }
        y.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { parame });
        ((c)localObject).dBw.remove(parame);
        arrayOfObject = new Object[2];
        arrayOfObject[0] = paramb;
        if ((parame != null) && (parame != null)) {
          break label373;
        }
        parame = "@null";
      }
    }
    label347:
    label373:
    for (;;)
    {
      arrayOfObject[1] = parame;
      y.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", arrayOfObject);
      ((c)localObject).dBw.add(paramb);
      parame = (Map)((c)localObject).cJ;
      localObject = paramb.dBy.rO();
      g.j(localObject, "task.mItem.functionMsgId");
      parame.put(localObject, paramb);
      for (;;)
      {
        y.i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        return;
        if (1 == paramb.bMU)
        {
          if ((parame.dBy.rP() < paramb.dBy.rP()) || (paramb.dBy.rP() == 0L))
          {
            paramInt = 1;
            break;
          }
          paramInt = 0;
          break;
        }
        if (parame.dBy.rP() < paramb.dBy.rP())
        {
          paramInt = 1;
          break;
        }
        paramInt = 0;
        break;
        if (parame == null) {
          break label166;
        }
        y.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramb, parame });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.e
 * JD-Core Version:    0.7.0.1
 */