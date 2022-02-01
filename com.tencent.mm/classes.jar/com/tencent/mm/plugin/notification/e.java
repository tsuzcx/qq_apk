package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ci;
import com.tencent.mm.storage.ci.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements aa
{
  private static List<ba> AGH;
  private boolean AGI;
  private boolean AGJ;
  private List<ca> AGK;
  
  static
  {
    AppMethodBeat.i(149387);
    AGH = new ArrayList();
    AppMethodBeat.o(149387);
  }
  
  public e()
  {
    this(false);
  }
  
  public e(boolean paramBoolean)
  {
    AppMethodBeat.i(149383);
    this.AGI = false;
    this.AGJ = false;
    this.AGK = new LinkedList();
    this.AGI = paramBoolean;
    this.AGJ = false;
    this.AGK = new LinkedList();
    AppMethodBeat.o(149383);
  }
  
  public static void a(ba paramba)
  {
    AppMethodBeat.i(149381);
    synchronized (AGH)
    {
      if (!AGH.contains(paramba)) {
        AGH.add(paramba);
      }
      AppMethodBeat.o(149381);
      return;
    }
  }
  
  public static void b(ba paramba)
  {
    AppMethodBeat.i(149382);
    synchronized (AGH)
    {
      AGH.remove(paramba);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public final void a(final ca paramca, final de paramde)
  {
    AppMethodBeat.i(149385);
    if (this.AGI)
    {
      Log.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(149385);
      return;
    }
    synchronized (AGH)
    {
      if (AGH.isEmpty())
      {
        Log.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        AppMethodBeat.o(149385);
        return;
      }
      if ((paramca.field_isSend != 0) || (paramca.field_status == 4))
      {
        Log.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        AppMethodBeat.o(149385);
        return;
      }
    }
    ??? = z.a(paramde.KHl);
    ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY(new ci.a((String)???).bkR(""));
    if ((??? != null) && (!((ci)???).gEp()))
    {
      Log.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(149385);
      return;
    }
    if (!this.AGJ)
    {
      this.AGJ = true;
      Object localObject2 = new ArrayList();
      synchronized (AGH)
      {
        Iterator localIterator = AGH.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((ba)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ba)((Iterator)???).next();
        new MMHandler(((ba)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149380);
            if (paramde.xKb == 49)
            {
              k.b localb = k.b.HD(e.c(paramde));
              if ((localb.iyf == 1) && (!Util.isNullOrNil(localb.iyg)) && (!Util.isNullOrNil(localb.iyh)))
              {
                this.AGP.a(39, localb.iyh, "", localb.iyg, null, null);
                AppMethodBeat.o(149380);
                return;
              }
              this.AGP.a(paramca);
              AppMethodBeat.o(149380);
              return;
            }
            this.AGP.a(paramca);
            AppMethodBeat.o(149380);
          }
        });
      }
      AppMethodBeat.o(149385);
      return;
    }
    this.AGK.add(paramca);
    AppMethodBeat.o(149385);
  }
  
  public final void dkt()
  {
    AppMethodBeat.i(149384);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.AGK);
    this.AGK.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(149384);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (AGH)
    {
      Iterator localIterator = AGH.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((ba)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (ba)((Iterator)???).next();
      new MMHandler(((ba)localObject2).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149379);
          this.AGL.S(localList);
          AppMethodBeat.o(149379);
        }
      });
    }
    AppMethodBeat.o(149384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.e
 * JD-Core Version:    0.7.0.1
 */