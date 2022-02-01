package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bb;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.cj.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements ae
{
  private static List<bb> GzQ;
  private boolean GzR;
  private boolean GzS;
  private List<ca> GzT;
  
  static
  {
    AppMethodBeat.i(149387);
    GzQ = new ArrayList();
    AppMethodBeat.o(149387);
  }
  
  public f()
  {
    this(false);
  }
  
  public f(boolean paramBoolean)
  {
    AppMethodBeat.i(149383);
    this.GzR = false;
    this.GzS = false;
    this.GzT = new LinkedList();
    this.GzR = paramBoolean;
    this.GzS = false;
    this.GzT = new LinkedList();
    AppMethodBeat.o(149383);
  }
  
  public static void a(bb parambb)
  {
    AppMethodBeat.i(149381);
    synchronized (GzQ)
    {
      if (!GzQ.contains(parambb)) {
        GzQ.add(parambb);
      }
      AppMethodBeat.o(149381);
      return;
    }
  }
  
  public static void b(bb parambb)
  {
    AppMethodBeat.i(149382);
    synchronized (GzQ)
    {
      GzQ.remove(parambb);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public final void a(final ca paramca, final db paramdb)
  {
    AppMethodBeat.i(149385);
    if (this.GzR)
    {
      Log.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(149385);
      return;
    }
    synchronized (GzQ)
    {
      if (GzQ.isEmpty())
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
    ??? = z.a(paramdb.RID);
    ??? = ((n)h.ae(n.class)).bbU().aPi(new cj.a((String)???).bxr(""));
    if ((??? != null) && (!((cj)???).hAF()))
    {
      Log.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(149385);
      return;
    }
    if (!this.GzS)
    {
      this.GzS = true;
      Object localObject2 = new ArrayList();
      synchronized (GzQ)
      {
        Iterator localIterator = GzQ.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((bb)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (bb)((Iterator)???).next();
        new MMHandler(((bb)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149380);
            if (paramdb.COi == 49)
            {
              k.b localb = k.b.OQ(f.c(paramdb));
              if ((localb.lnv == 1) && (!Util.isNullOrNil(localb.lnw)) && (!Util.isNullOrNil(localb.lnx)))
              {
                this.GzY.a(39, localb.lnx, "", localb.lnw, null, null);
                AppMethodBeat.o(149380);
                return;
              }
              this.GzY.a(paramca);
              AppMethodBeat.o(149380);
              return;
            }
            this.GzY.a(paramca);
            AppMethodBeat.o(149380);
          }
        });
      }
      AppMethodBeat.o(149385);
      return;
    }
    this.GzT.add(paramca);
    AppMethodBeat.o(149385);
  }
  
  public final void dKq()
  {
    AppMethodBeat.i(149384);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.GzT);
    this.GzT.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(149384);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (GzQ)
    {
      Iterator localIterator = GzQ.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((bb)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (bb)((Iterator)???).next();
      new MMHandler(((bb)localObject2).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149379);
          this.GzU.P(localList);
          AppMethodBeat.o(149379);
        }
      });
    }
    AppMethodBeat.o(149384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.f
 * JD-Core Version:    0.7.0.1
 */