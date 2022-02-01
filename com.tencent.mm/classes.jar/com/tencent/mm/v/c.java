package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c
{
  public static final c.a gqJ;
  private final HashMap<String, d> dz;
  private final e gqA;
  private final LinkedList<d> gqI;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(114119);
    gqJ = new c.a((byte)0);
    AppMethodBeat.o(114119);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(114118);
    this.gqI = new LinkedList();
    this.dz = new HashMap();
    this.gqA = parame;
    this.lock = new Object();
    AppMethodBeat.o(114118);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(114116);
    p.h(paramd, "task");
    for (;;)
    {
      synchronized (this.lock)
      {
        localObject1 = new y.f();
        ((y.f)localObject1).MLV = null;
        if (this.dz.containsKey(paramd.gqK.KS())) {
          ((y.f)localObject1).MLV = ((d)this.dz.remove(paramd.gqK.KS()));
        }
        if ((d)((y.f)localObject1).MLV != null)
        {
          Object localObject3 = (d)((y.f)localObject1).MLV;
          if (101 == paramd.drZ)
          {
            i = 1;
            if (i != 0)
            {
              ad.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { (d)((y.f)localObject1).MLV });
              this.gqI.remove((d)((y.f)localObject1).MLV);
              localObject3 = new Object[2];
              localObject3[0] = paramd;
              if ((d)((y.f)localObject1).MLV == null) {
                break label371;
              }
              localObject1 = (d)((y.f)localObject1).MLV;
              if (localObject1 != null) {
                break label368;
              }
              break label371;
              localObject3[1] = localObject1;
              ad.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject3);
              this.gqI.add(paramd);
              localObject1 = (Map)this.dz;
              localObject3 = paramd.gqK.KS();
              p.g(localObject3, "task.mItem.functionMsgId");
              ((Map)localObject1).put(localObject3, paramd);
              paramd = z.MKo;
              AppMethodBeat.o(114116);
            }
          }
          else
          {
            if (1 == paramd.drZ)
            {
              if (((d)localObject3).gqK.getVersion() < paramd.gqK.getVersion()) {
                break label377;
              }
              if (paramd.gqK.getVersion() != 0L) {
                break label382;
              }
              break label377;
            }
            if (((d)localObject3).gqK.getVersion() >= paramd.gqK.getVersion()) {
              break label387;
            }
            i = 1;
            continue;
          }
        }
        if ((d)((y.f)localObject1).MLV == null) {
          continue;
        }
        ad.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, (d)((y.f)localObject1).MLV });
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
      ad.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.gqI.size());
      ListIterator localListIterator = this.gqI.listIterator();
      p.g(localListIterator, "mList.listIterator()");
      while (localListIterator.hasNext())
      {
        Object localObject3 = localListIterator.next();
        p.g(localObject3, "iterator.next()");
        localObject3 = (d)localObject3;
        if (((d)localObject3).gqK.KY() <= cf.aCK() / 1000L)
        {
          localListIterator.remove();
          this.dz.remove(((d)localObject3).gqK.KS());
          e locale = this.gqA;
          p.h(localObject3, "task");
          locale.gqM.a(((d)localObject3).drZ, (d)localObject3);
        }
      }
    }
    z localz = z.MKo;
    AppMethodBeat.o(114117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */