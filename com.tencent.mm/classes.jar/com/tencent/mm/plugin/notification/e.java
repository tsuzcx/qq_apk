package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cb.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements aa
{
  private static List<aw> wLf;
  private boolean wLg;
  private boolean wLh;
  private List<bv> wLi;
  
  static
  {
    AppMethodBeat.i(149387);
    wLf = new ArrayList();
    AppMethodBeat.o(149387);
  }
  
  public e()
  {
    this(false);
  }
  
  public e(boolean paramBoolean)
  {
    AppMethodBeat.i(149383);
    this.wLg = false;
    this.wLh = false;
    this.wLi = new LinkedList();
    this.wLg = paramBoolean;
    this.wLh = false;
    this.wLi = new LinkedList();
    AppMethodBeat.o(149383);
  }
  
  public static void a(aw paramaw)
  {
    AppMethodBeat.i(149381);
    synchronized (wLf)
    {
      if (!wLf.contains(paramaw)) {
        wLf.add(paramaw);
      }
      AppMethodBeat.o(149381);
      return;
    }
  }
  
  public static void b(aw paramaw)
  {
    AppMethodBeat.i(149382);
    synchronized (wLf)
    {
      wLf.remove(paramaw);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public final void a(final bv parambv, final cv paramcv)
  {
    AppMethodBeat.i(149385);
    if (this.wLg)
    {
      ae.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(149385);
      return;
    }
    synchronized (wLf)
    {
      if (wLf.isEmpty())
      {
        ae.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        AppMethodBeat.o(149385);
        return;
      }
      if ((parambv.field_isSend != 0) || (parambv.field_status == 4))
      {
        ae.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        AppMethodBeat.o(149385);
        return;
      }
    }
    ??? = z.a(paramcv.FNG);
    ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD(new cb.a((String)???).aVT(""));
    if ((??? != null) && (!((cb)???).fwD()))
    {
      ae.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(149385);
      return;
    }
    if (!this.wLh)
    {
      this.wLh = true;
      Object localObject2 = new ArrayList();
      synchronized (wLf)
      {
        Iterator localIterator = wLf.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((aw)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (aw)((Iterator)???).next();
        new aq(((aw)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149380);
            if (paramcv.urJ == 49)
            {
              k.b localb = k.b.zb(e.c(paramcv));
              if ((localb.hDZ == 1) && (!bu.isNullOrNil(localb.hEa)) && (!bu.isNullOrNil(localb.hEb)))
              {
                this.wLn.a(39, localb.hEb, "", localb.hEa, null, null);
                AppMethodBeat.o(149380);
                return;
              }
              this.wLn.a(parambv);
              AppMethodBeat.o(149380);
              return;
            }
            this.wLn.a(parambv);
            AppMethodBeat.o(149380);
          }
        });
      }
      AppMethodBeat.o(149385);
      return;
    }
    this.wLi.add(parambv);
    AppMethodBeat.o(149385);
  }
  
  public final void cEs()
  {
    AppMethodBeat.i(149384);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.wLi);
    this.wLi.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(149384);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (wLf)
    {
      Iterator localIterator = wLf.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((aw)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (aw)((Iterator)???).next();
      new aq(((aw)localObject2).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149379);
          this.wLj.M(localList);
          AppMethodBeat.o(149379);
        }
      });
    }
    AppMethodBeat.o(149384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.e
 * JD-Core Version:    0.7.0.1
 */