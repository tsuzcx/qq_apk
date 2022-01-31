package com.tencent.mm.u;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c
{
  public static final c.a eyO;
  private final HashMap<String, d> dw;
  private final e eyF;
  private final LinkedList<d> eyN;
  
  static
  {
    AppMethodBeat.i(35467);
    eyO = new c.a((byte)0);
    AppMethodBeat.o(35467);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(35466);
    this.eyN = new LinkedList();
    this.dw = new HashMap();
    this.eyF = parame;
    AppMethodBeat.o(35466);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(35464);
    j.q(paramd, "task");
    Object localObject1 = null;
    if (this.dw.containsKey(paramd.eyP.Ad())) {
      localObject1 = (d)this.dw.remove(paramd.eyP.Ad());
    }
    int i;
    label91:
    Object localObject2;
    if (localObject1 != null) {
      if (101 == paramd.cuo)
      {
        i = 1;
        if (i == 0) {
          break label252;
        }
        ab.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { localObject1 });
        this.eyN.remove(localObject1);
        localObject2 = new Object[2];
        localObject2[0] = paramd;
        if ((localObject1 != null) && (localObject1 != null)) {
          break label281;
        }
        localObject1 = "@null";
      }
    }
    label281:
    for (;;)
    {
      localObject2[1] = localObject1;
      ab.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject2);
      this.eyN.add(paramd);
      localObject1 = (Map)this.dw;
      localObject2 = paramd.eyP.Ad();
      j.p(localObject2, "task.mItem.functionMsgId");
      ((Map)localObject1).put(localObject2, paramd);
      AppMethodBeat.o(35464);
      return;
      if (1 == paramd.cuo)
      {
        if ((((d)localObject1).eyP.getVersion() < paramd.eyP.getVersion()) || (paramd.eyP.getVersion() == 0L))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
      if (((d)localObject1).eyP.getVersion() < paramd.eyP.getVersion())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label252:
      if (localObject1 == null) {
        break label91;
      }
      ab.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, localObject1 });
      AppMethodBeat.o(35464);
      return;
    }
  }
  
  public final void loop()
  {
    AppMethodBeat.i(35465);
    ab.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.eyN.size());
    ListIterator localListIterator = this.eyN.listIterator();
    j.p(localListIterator, "mList.listIterator()");
    while (localListIterator.hasNext())
    {
      Object localObject = localListIterator.next();
      j.p(localObject, "iterator.next()");
      localObject = (d)localObject;
      if (((d)localObject).eyP.Ai() <= cb.abp() / 1000L)
      {
        localListIterator.remove();
        this.dw.remove(((d)localObject).eyP.Ad());
        e locale = this.eyF;
        j.q(localObject, "task");
        locale.eyR.a(((d)localObject).cuo, (d)localObject);
      }
    }
    AppMethodBeat.o(35465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.c
 * JD-Core Version:    0.7.0.1
 */