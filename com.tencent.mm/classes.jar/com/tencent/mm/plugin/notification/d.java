package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements x
{
  private static List<at> uhe;
  private boolean uhf;
  private boolean uhg;
  private List<bl> uhh;
  
  static
  {
    AppMethodBeat.i(149387);
    uhe = new ArrayList();
    AppMethodBeat.o(149387);
  }
  
  public d()
  {
    this(false);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(149383);
    this.uhf = false;
    this.uhg = false;
    this.uhh = new LinkedList();
    this.uhf = paramBoolean;
    this.uhg = false;
    this.uhh = new LinkedList();
    AppMethodBeat.o(149383);
  }
  
  public static void a(at paramat)
  {
    AppMethodBeat.i(149381);
    synchronized (uhe)
    {
      if (!uhe.contains(paramat)) {
        uhe.add(paramat);
      }
      AppMethodBeat.o(149381);
      return;
    }
  }
  
  public static void b(at paramat)
  {
    AppMethodBeat.i(149382);
    synchronized (uhe)
    {
      uhe.remove(paramat);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public final void a(final bl parambl, final cs paramcs)
  {
    AppMethodBeat.i(149385);
    if (this.uhf)
    {
      ad.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(149385);
      return;
    }
    synchronized (uhe)
    {
      if (uhe.isEmpty())
      {
        ad.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        AppMethodBeat.o(149385);
        return;
      }
      if ((parambl.field_isSend != 0) || (parambl.field_status == 4))
      {
        ad.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        AppMethodBeat.o(149385);
        return;
      }
    }
    ??? = z.a(paramcs.Cxx);
    ??? = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP(new br.a((String)???).aJf(""));
    if ((??? != null) && (!((br)???).eMR()))
    {
      ad.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(149385);
      return;
    }
    if (!this.uhg)
    {
      this.uhg = true;
      Object localObject2 = new ArrayList();
      synchronized (uhe)
      {
        Iterator localIterator = uhe.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((at)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (at)((Iterator)???).next();
        new ap(((at)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149380);
            if (paramcs.saz == 49)
            {
              k.b localb = k.b.rx(d.c(paramcs));
              if ((localb.gIC == 1) && (!bt.isNullOrNil(localb.gID)) && (!bt.isNullOrNil(localb.gIE)))
              {
                this.uhm.a(39, localb.gIE, "", localb.gID, null, null);
                AppMethodBeat.o(149380);
                return;
              }
              this.uhm.a(parambl);
              AppMethodBeat.o(149380);
              return;
            }
            this.uhm.a(parambl);
            AppMethodBeat.o(149380);
          }
        });
      }
      AppMethodBeat.o(149385);
      return;
    }
    this.uhh.add(parambl);
    AppMethodBeat.o(149385);
  }
  
  public final void cOJ()
  {
    AppMethodBeat.i(149384);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.uhh);
    this.uhh.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(149384);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (uhe)
    {
      Iterator localIterator = uhe.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((at)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (at)((Iterator)???).next();
      new ap(((at)localObject2).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149379);
          this.uhi.V(localList);
          AppMethodBeat.o(149379);
        }
      });
    }
    AppMethodBeat.o(149384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d
 * JD-Core Version:    0.7.0.1
 */