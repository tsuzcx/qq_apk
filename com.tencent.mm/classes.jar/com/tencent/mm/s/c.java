package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a mpR;
  private final HashMap<String, d> bIx;
  private final Object lock;
  private final e mpJ;
  private final LinkedList<d> mpS;
  
  static
  {
    AppMethodBeat.i(114119);
    mpR = new c.a((byte)0);
    AppMethodBeat.o(114119);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(114118);
    this.mpS = new LinkedList();
    this.bIx = new HashMap();
    this.mpJ = parame;
    this.lock = new Object();
    AppMethodBeat.o(114118);
  }
  
  public final void a(d paramd)
  {
    int j = 0;
    AppMethodBeat.i(114116);
    s.u(paramd, "task");
    for (;;)
    {
      synchronized (this.lock)
      {
        localObject1 = new ah.f();
        if (this.bIx.containsKey(paramd.mpT.field_functionmsgid)) {
          ((ah.f)localObject1).aqH = this.bIx.remove(paramd.mpT.field_functionmsgid);
        }
        if (((ah.f)localObject1).aqH != null)
        {
          Object localObject3 = (d)((ah.f)localObject1).aqH;
          if (101 == paramd.hHT)
          {
            i = 1;
            if (i != 0)
            {
              Log.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", new Object[] { ((ah.f)localObject1).aqH });
              this.mpS.remove(((ah.f)localObject1).aqH);
              localObject3 = new Object[2];
              localObject3[0] = paramd;
              if ((d)((ah.f)localObject1).aqH != null) {
                continue;
              }
              localObject1 = null;
              i = j;
              break label370;
              localObject3[i] = localObject1;
              Log.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", (Object[])localObject3);
              this.mpS.add(paramd);
              localObject1 = (Map)this.bIx;
              localObject3 = paramd.mpT.field_functionmsgid;
              s.s(localObject3, "task.mItem.functionMsgId");
              ((Map)localObject1).put(localObject3, paramd);
              paramd = ah.aiuX;
              AppMethodBeat.o(114116);
            }
          }
          else
          {
            if (1 == paramd.hHT)
            {
              if (((d)localObject3).mpT.field_version < paramd.mpT.field_version) {
                break label384;
              }
              if (paramd.mpT.field_version != 0L) {
                break label389;
              }
              break label384;
            }
            if (((d)localObject3).mpT.field_version >= paramd.mpT.field_version) {
              break label394;
            }
            i = 1;
            continue;
          }
        }
        if (((ah.f)localObject1).aqH == null) {
          continue;
        }
        Log.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", new Object[] { paramd, ((ah.f)localObject1).aqH });
        AppMethodBeat.o(114116);
        return;
        localObject1 = (d)((ah.f)localObject1).aqH;
        i = 1;
      }
      label370:
      while (localObject1 != null) {
        break;
      }
      int i = 1;
      Object localObject1 = "@null";
      continue;
      label384:
      i = 1;
      continue;
      label389:
      i = 0;
      continue;
      label394:
      i = 0;
    }
  }
  
  public final void aEa()
  {
    AppMethodBeat.i(114117);
    synchronized (this.lock)
    {
      Log.i("FunctionMsg.FunctionMsgQueue", s.X("[loop] size:", Integer.valueOf(this.mpS.size())));
      ListIterator localListIterator = this.mpS.listIterator();
      s.s(localListIterator, "mList.listIterator()");
      while (localListIterator.hasNext())
      {
        Object localObject3 = localListIterator.next();
        s.s(localObject3, "iterator.next()");
        localObject3 = (d)localObject3;
        if (((d)localObject3).mpT.field_actionTime <= cn.bDu() / 1000L)
        {
          localListIterator.remove();
          this.bIx.remove(((d)localObject3).mpT.field_functionmsgid);
          e locale = this.mpJ;
          s.u(localObject3, "task");
          locale.mpW.a(((d)localObject3).hHT, (d)localObject3);
        }
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(114117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.s.c
 * JD-Core Version:    0.7.0.1
 */