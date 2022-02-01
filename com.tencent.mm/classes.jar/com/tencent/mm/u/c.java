package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c
{
  public static final c.a gtj;
  private final HashMap<String, d> dz;
  private final e gta;
  private final LinkedList<d> gti;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(114119);
    gtj = new c.a((byte)0);
    AppMethodBeat.o(114119);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(114118);
    this.gti = new LinkedList();
    this.dz = new HashMap();
    this.gta = parame;
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
        ((y.f)localObject1).NiY = null;
        if (this.dz.containsKey(paramd.gtk.La())) {
          ((y.f)localObject1).NiY = ((d)this.dz.remove(paramd.gtk.La()));
        }
        if ((d)((y.f)localObject1).NiY != null)
        {
          Object localObject3 = (d)((y.f)localObject1).NiY;
          if (101 == paramd.dtf)
          {
            i = 1;
            if (i != 0)
            {
              ae.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { (d)((y.f)localObject1).NiY });
              this.gti.remove((d)((y.f)localObject1).NiY);
              localObject3 = new Object[2];
              localObject3[0] = paramd;
              if ((d)((y.f)localObject1).NiY == null) {
                break label371;
              }
              localObject1 = (d)((y.f)localObject1).NiY;
              if (localObject1 != null) {
                break label368;
              }
              break label371;
              localObject3[1] = localObject1;
              ae.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject3);
              this.gti.add(paramd);
              localObject1 = (Map)this.dz;
              localObject3 = paramd.gtk.La();
              p.g(localObject3, "task.mItem.functionMsgId");
              ((Map)localObject1).put(localObject3, paramd);
              paramd = z.Nhr;
              AppMethodBeat.o(114116);
            }
          }
          else
          {
            if (1 == paramd.dtf)
            {
              if (((d)localObject3).gtk.getVersion() < paramd.gtk.getVersion()) {
                break label377;
              }
              if (paramd.gtk.getVersion() != 0L) {
                break label382;
              }
              break label377;
            }
            if (((d)localObject3).gtk.getVersion() >= paramd.gtk.getVersion()) {
              break label387;
            }
            i = 1;
            continue;
          }
        }
        if ((d)((y.f)localObject1).NiY == null) {
          continue;
        }
        ae.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, (d)((y.f)localObject1).NiY });
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
      ae.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.gti.size());
      ListIterator localListIterator = this.gti.listIterator();
      p.g(localListIterator, "mList.listIterator()");
      while (localListIterator.hasNext())
      {
        Object localObject3 = localListIterator.next();
        p.g(localObject3, "iterator.next()");
        localObject3 = (d)localObject3;
        if (((d)localObject3).gtk.Lg() <= ch.aDa() / 1000L)
        {
          localListIterator.remove();
          this.dz.remove(((d)localObject3).gtk.La());
          e locale = this.gta;
          p.h(localObject3, "task");
          locale.gtm.a(((d)localObject3).dtf, (d)localObject3);
        }
      }
    }
    z localz = z.Nhr;
    AppMethodBeat.o(114117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.u.c
 * JD-Core Version:    0.7.0.1
 */