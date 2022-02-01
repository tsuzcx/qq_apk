package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import d.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c
{
  public static final c.a fTt;
  private final HashMap<String, d> dz;
  private final e fTk;
  private final LinkedList<d> fTs;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(114119);
    fTt = new c.a((byte)0);
    AppMethodBeat.o(114119);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(114118);
    this.fTs = new LinkedList();
    this.dz = new HashMap();
    this.fTk = parame;
    this.lock = new Object();
    AppMethodBeat.o(114118);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(114116);
    k.h(paramd, "task");
    for (;;)
    {
      synchronized (this.lock)
      {
        localObject1 = new v.e();
        ((v.e)localObject1).Jhw = null;
        if (this.dz.containsKey(paramd.fTu.JK())) {
          ((v.e)localObject1).Jhw = ((d)this.dz.remove(paramd.fTu.JK()));
        }
        if ((d)((v.e)localObject1).Jhw != null)
        {
          Object localObject3 = (d)((v.e)localObject1).Jhw;
          if (101 == paramd.dji)
          {
            i = 1;
            if (i != 0)
            {
              ad.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { (d)((v.e)localObject1).Jhw });
              this.fTs.remove((d)((v.e)localObject1).Jhw);
              localObject3 = new Object[2];
              localObject3[0] = paramd;
              if ((d)((v.e)localObject1).Jhw == null) {
                break label371;
              }
              localObject1 = (d)((v.e)localObject1).Jhw;
              if (localObject1 != null) {
                break label368;
              }
              break label371;
              localObject3[1] = localObject1;
              ad.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject3);
              this.fTs.add(paramd);
              localObject1 = (Map)this.dz;
              localObject3 = paramd.fTu.JK();
              k.g(localObject3, "task.mItem.functionMsgId");
              ((Map)localObject1).put(localObject3, paramd);
              paramd = y.JfV;
              AppMethodBeat.o(114116);
            }
          }
          else
          {
            if (1 == paramd.dji)
            {
              if (((d)localObject3).fTu.getVersion() < paramd.fTu.getVersion()) {
                break label377;
              }
              if (paramd.fTu.getVersion() != 0L) {
                break label382;
              }
              break label377;
            }
            if (((d)localObject3).fTu.getVersion() >= paramd.fTu.getVersion()) {
              break label387;
            }
            i = 1;
            continue;
          }
        }
        if ((d)((v.e)localObject1).Jhw == null) {
          continue;
        }
        ad.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, (d)((v.e)localObject1).Jhw });
        AppMethodBeat.o(114116);
        return;
      }
      label368:
      continue;
      label371:
      Object localObject1 = "@null";
      continue;
      label377:
      int i = 1;
      continue;
      label382:
      i = 0;
      continue;
      label387:
      i = 0;
    }
  }
  
  public final void loop()
  {
    AppMethodBeat.i(114117);
    synchronized (this.lock)
    {
      ad.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.fTs.size());
      ListIterator localListIterator = this.fTs.listIterator();
      k.g(localListIterator, "mList.listIterator()");
      while (localListIterator.hasNext())
      {
        Object localObject3 = localListIterator.next();
        k.g(localObject3, "iterator.next()");
        localObject3 = (d)localObject3;
        if (((d)localObject3).fTu.getActionTime() <= ce.asQ() / 1000L)
        {
          localListIterator.remove();
          this.dz.remove(((d)localObject3).fTu.JK());
          e locale = this.fTk;
          k.h(localObject3, "task");
          locale.fTw.a(((d)localObject3).dji, (d)localObject3);
        }
      }
    }
    y localy = y.JfV;
    AppMethodBeat.o(114117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.u.c
 * JD-Core Version:    0.7.0.1
 */