package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c
{
  public static final c.a fXn;
  private final HashMap<String, d> dz;
  private final e fXe;
  private final LinkedList<d> fXm;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(114119);
    fXn = new c.a((byte)0);
    AppMethodBeat.o(114119);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(114118);
    this.fXm = new LinkedList();
    this.dz = new HashMap();
    this.fXe = parame;
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
        localObject1 = new v.f();
        ((v.f)localObject1).KUQ = null;
        if (this.dz.containsKey(paramd.fXo.Jt())) {
          ((v.f)localObject1).KUQ = ((d)this.dz.remove(paramd.fXo.Jt()));
        }
        if ((d)((v.f)localObject1).KUQ != null)
        {
          Object localObject3 = (d)((v.f)localObject1).KUQ;
          if (101 == paramd.dgD)
          {
            i = 1;
            if (i != 0)
            {
              ac.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { (d)((v.f)localObject1).KUQ });
              this.fXm.remove((d)((v.f)localObject1).KUQ);
              localObject3 = new Object[2];
              localObject3[0] = paramd;
              if ((d)((v.f)localObject1).KUQ == null) {
                break label371;
              }
              localObject1 = (d)((v.f)localObject1).KUQ;
              if (localObject1 != null) {
                break label368;
              }
              break label371;
              localObject3[1] = localObject1;
              ac.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject3);
              this.fXm.add(paramd);
              localObject1 = (Map)this.dz;
              localObject3 = paramd.fXo.Jt();
              k.g(localObject3, "task.mItem.functionMsgId");
              ((Map)localObject1).put(localObject3, paramd);
              paramd = y.KTp;
              AppMethodBeat.o(114116);
            }
          }
          else
          {
            if (1 == paramd.dgD)
            {
              if (((d)localObject3).fXo.getVersion() < paramd.fXo.getVersion()) {
                break label377;
              }
              if (paramd.fXo.getVersion() != 0L) {
                break label382;
              }
              break label377;
            }
            if (((d)localObject3).fXo.getVersion() >= paramd.fXo.getVersion()) {
              break label387;
            }
            i = 1;
            continue;
          }
        }
        if ((d)((v.f)localObject1).KUQ == null) {
          continue;
        }
        ac.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, (d)((v.f)localObject1).KUQ });
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
      ac.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.fXm.size());
      ListIterator localListIterator = this.fXm.listIterator();
      k.g(localListIterator, "mList.listIterator()");
      while (localListIterator.hasNext())
      {
        Object localObject3 = localListIterator.next();
        k.g(localObject3, "iterator.next()");
        localObject3 = (d)localObject3;
        if (((d)localObject3).fXo.Jz() <= ce.azH() / 1000L)
        {
          localListIterator.remove();
          this.dz.remove(((d)localObject3).fXo.Jt());
          e locale = this.fXe;
          k.h(localObject3, "task");
          locale.fXq.a(((d)localObject3).dgD, (d)localObject3);
        }
      }
    }
    y localy = y.KTp;
    AppMethodBeat.o(114117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.u.c
 * JD-Core Version:    0.7.0.1
 */