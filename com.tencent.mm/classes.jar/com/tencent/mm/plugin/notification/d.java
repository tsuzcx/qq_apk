package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements x
{
  private static List<at> vqc;
  private boolean vqd;
  private boolean vqe;
  private List<bo> vqf;
  
  static
  {
    AppMethodBeat.i(149387);
    vqc = new ArrayList();
    AppMethodBeat.o(149387);
  }
  
  public d()
  {
    this(false);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(149383);
    this.vqd = false;
    this.vqe = false;
    this.vqf = new LinkedList();
    this.vqd = paramBoolean;
    this.vqe = false;
    this.vqf = new LinkedList();
    AppMethodBeat.o(149383);
  }
  
  public static void a(at paramat)
  {
    AppMethodBeat.i(149381);
    synchronized (vqc)
    {
      if (!vqc.contains(paramat)) {
        vqc.add(paramat);
      }
      AppMethodBeat.o(149381);
      return;
    }
  }
  
  public static void b(at paramat)
  {
    AppMethodBeat.i(149382);
    synchronized (vqc)
    {
      vqc.remove(paramat);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public final void a(final bo parambo, final cu paramcu)
  {
    AppMethodBeat.i(149385);
    if (this.vqd)
    {
      ac.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(149385);
      return;
    }
    synchronized (vqc)
    {
      if (vqc.isEmpty())
      {
        ac.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        AppMethodBeat.o(149385);
        return;
      }
      if ((parambo.field_isSend != 0) || (parambo.field_status == 4))
      {
        ac.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        AppMethodBeat.o(149385);
        return;
      }
    }
    ??? = z.a(paramcu.DPT);
    ??? = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ(new bu.a((String)???).aOB(""));
    if ((??? != null) && (!((bu)???).fcv()))
    {
      ac.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(149385);
      return;
    }
    if (!this.vqe)
    {
      this.vqe = true;
      Object localObject2 = new ArrayList();
      synchronized (vqc)
      {
        Iterator localIterator = vqc.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((at)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (at)((Iterator)???).next();
        new ao(((at)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149380);
            if (paramcu.tit == 49)
            {
              k.b localb = k.b.vA(d.c(paramcu));
              if ((localb.hjc == 1) && (!bs.isNullOrNil(localb.hjd)) && (!bs.isNullOrNil(localb.hje)))
              {
                this.vqk.a(39, localb.hje, "", localb.hjd, null, null);
                AppMethodBeat.o(149380);
                return;
              }
              this.vqk.a(parambo);
              AppMethodBeat.o(149380);
              return;
            }
            this.vqk.a(parambo);
            AppMethodBeat.o(149380);
          }
        });
      }
      AppMethodBeat.o(149385);
      return;
    }
    this.vqf.add(parambo);
    AppMethodBeat.o(149385);
  }
  
  public final void dcs()
  {
    AppMethodBeat.i(149384);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.vqf);
    this.vqf.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(149384);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (vqc)
    {
      Iterator localIterator = vqc.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((at)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (at)((Iterator)???).next();
      new ao(((at)localObject2).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149379);
          this.vqg.M(localList);
          AppMethodBeat.o(149379);
        }
      });
    }
    AppMethodBeat.o(149384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d
 * JD-Core Version:    0.7.0.1
 */