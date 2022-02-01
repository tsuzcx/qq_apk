package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c
{
  public static final c.a jQL;
  private final HashMap<String, d> aaP;
  private final e jQB;
  private final LinkedList<d> jQK;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(114119);
    jQL = new c.a((byte)0);
    AppMethodBeat.o(114119);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(114118);
    this.jQK = new LinkedList();
    this.aaP = new HashMap();
    this.jQB = parame;
    this.lock = new Object();
    AppMethodBeat.o(114118);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(114116);
    p.k(paramd, "task");
    for (;;)
    {
      synchronized (this.lock)
      {
        localObject1 = new aa.f();
        ((aa.f)localObject1).aaBC = null;
        if (this.aaP.containsKey(paramd.jQM.ZD())) {
          ((aa.f)localObject1).aaBC = ((d)this.aaP.remove(paramd.jQM.ZD()));
        }
        if ((d)((aa.f)localObject1).aaBC != null)
        {
          Object localObject3 = (d)((aa.f)localObject1).aaBC;
          if (101 == paramd.fDe)
          {
            i = 1;
            if (i != 0)
            {
              Log.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { (d)((aa.f)localObject1).aaBC });
              this.jQK.remove((d)((aa.f)localObject1).aaBC);
              localObject3 = new Object[2];
              localObject3[0] = paramd;
              if ((d)((aa.f)localObject1).aaBC == null) {
                break label371;
              }
              localObject1 = (d)((aa.f)localObject1).aaBC;
              if (localObject1 != null) {
                break label368;
              }
              break label371;
              localObject3[1] = localObject1;
              Log.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject3);
              this.jQK.add(paramd);
              localObject1 = (Map)this.aaP;
              localObject3 = paramd.jQM.ZD();
              p.j(localObject3, "task.mItem.functionMsgId");
              ((Map)localObject1).put(localObject3, paramd);
              paramd = x.aazN;
              AppMethodBeat.o(114116);
            }
          }
          else
          {
            if (1 == paramd.fDe)
            {
              if (((d)localObject3).jQM.getVersion() < paramd.jQM.getVersion()) {
                break label377;
              }
              if (paramd.jQM.getVersion() != 0L) {
                break label382;
              }
              break label377;
            }
            if (((d)localObject3).jQM.getVersion() >= paramd.jQM.getVersion()) {
              break label387;
            }
            i = 1;
            continue;
          }
        }
        if ((d)((aa.f)localObject1).aaBC == null) {
          continue;
        }
        Log.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, (d)((aa.f)localObject1).aaBC });
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
  
  public final void acb()
  {
    AppMethodBeat.i(114117);
    synchronized (this.lock)
    {
      Log.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.jQK.size());
      ListIterator localListIterator = this.jQK.listIterator();
      p.j(localListIterator, "mList.listIterator()");
      while (localListIterator.hasNext())
      {
        Object localObject3 = localListIterator.next();
        p.j(localObject3, "iterator.next()");
        localObject3 = (d)localObject3;
        if (((d)localObject3).jQM.ZJ() <= cm.bfC() / 1000L)
        {
          localListIterator.remove();
          this.aaP.remove(((d)localObject3).jQM.ZD());
          e locale = this.jQB;
          p.k(localObject3, "task");
          locale.jQO.a(((d)localObject3).fDe, (d)localObject3);
        }
      }
    }
    x localx = x.aazN;
    AppMethodBeat.o(114117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.u.c
 * JD-Core Version:    0.7.0.1
 */