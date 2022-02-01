package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c
{
  public static final c.a heT;
  private final e heK;
  private final LinkedList<d> heS;
  private final Object lock;
  private final HashMap<String, d> mMap;
  
  static
  {
    AppMethodBeat.i(114119);
    heT = new c.a((byte)0);
    AppMethodBeat.o(114119);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(114118);
    this.heS = new LinkedList();
    this.mMap = new HashMap();
    this.heK = parame;
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
        localObject1 = new z.f();
        ((z.f)localObject1).SYG = null;
        if (this.mMap.containsKey(paramd.heU.Vk())) {
          ((z.f)localObject1).SYG = ((d)this.mMap.remove(paramd.heU.Vk()));
        }
        if ((d)((z.f)localObject1).SYG != null)
        {
          Object localObject3 = (d)((z.f)localObject1).SYG;
          if (101 == paramd.dKp)
          {
            i = 1;
            if (i != 0)
            {
              Log.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { (d)((z.f)localObject1).SYG });
              this.heS.remove((d)((z.f)localObject1).SYG);
              localObject3 = new Object[2];
              localObject3[0] = paramd;
              if ((d)((z.f)localObject1).SYG == null) {
                break label371;
              }
              localObject1 = (d)((z.f)localObject1).SYG;
              if (localObject1 != null) {
                break label368;
              }
              break label371;
              localObject3[1] = localObject1;
              Log.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject3);
              this.heS.add(paramd);
              localObject1 = (Map)this.mMap;
              localObject3 = paramd.heU.Vk();
              p.g(localObject3, "task.mItem.functionMsgId");
              ((Map)localObject1).put(localObject3, paramd);
              paramd = x.SXb;
              AppMethodBeat.o(114116);
            }
          }
          else
          {
            if (1 == paramd.dKp)
            {
              if (((d)localObject3).heU.getVersion() < paramd.heU.getVersion()) {
                break label377;
              }
              if (paramd.heU.getVersion() != 0L) {
                break label382;
              }
              break label377;
            }
            if (((d)localObject3).heU.getVersion() >= paramd.heU.getVersion()) {
              break label387;
            }
            i = 1;
            continue;
          }
        }
        if ((d)((z.f)localObject1).SYG == null) {
          continue;
        }
        Log.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, (d)((z.f)localObject1).SYG });
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
      Log.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.heS.size());
      ListIterator localListIterator = this.heS.listIterator();
      p.g(localListIterator, "mList.listIterator()");
      while (localListIterator.hasNext())
      {
        Object localObject3 = localListIterator.next();
        p.g(localObject3, "iterator.next()");
        localObject3 = (d)localObject3;
        if (((d)localObject3).heU.Vq() <= cl.aWy() / 1000L)
        {
          localListIterator.remove();
          this.mMap.remove(((d)localObject3).heU.Vk());
          e locale = this.heK;
          p.h(localObject3, "task");
          locale.heW.a(((d)localObject3).dKp, (d)localObject3);
        }
      }
    }
    x localx = x.SXb;
    AppMethodBeat.o(114117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.c
 * JD-Core Version:    0.7.0.1
 */