package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements com.tencent.mm.plugin.messenger.foundation.a.z
{
  private static List<au> wvu;
  private boolean wvv;
  private boolean wvw;
  private List<bu> wvx;
  
  static
  {
    AppMethodBeat.i(149387);
    wvu = new ArrayList();
    AppMethodBeat.o(149387);
  }
  
  public d()
  {
    this(false);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(149383);
    this.wvv = false;
    this.wvw = false;
    this.wvx = new LinkedList();
    this.wvv = paramBoolean;
    this.wvw = false;
    this.wvx = new LinkedList();
    AppMethodBeat.o(149383);
  }
  
  public static void a(au paramau)
  {
    AppMethodBeat.i(149381);
    synchronized (wvu)
    {
      if (!wvu.contains(paramau)) {
        wvu.add(paramau);
      }
      AppMethodBeat.o(149381);
      return;
    }
  }
  
  public static void b(au paramau)
  {
    AppMethodBeat.i(149382);
    synchronized (wvu)
    {
      wvu.remove(paramau);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public final void a(final bu parambu, final cv paramcv)
  {
    AppMethodBeat.i(149385);
    if (this.wvv)
    {
      ad.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(149385);
      return;
    }
    synchronized (wvu)
    {
      if (wvu.isEmpty())
      {
        ad.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        AppMethodBeat.o(149385);
        return;
      }
      if ((parambu.field_isSend != 0) || (parambu.field_status == 4))
      {
        ad.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        AppMethodBeat.o(149385);
        return;
      }
    }
    ??? = com.tencent.mm.platformtools.z.a(paramcv.Fvi);
    ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy(new ca.a((String)???).aUs(""));
    if ((??? != null) && (!((ca)???).fsC()))
    {
      ad.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(149385);
      return;
    }
    if (!this.wvw)
    {
      this.wvw = true;
      Object localObject2 = new ArrayList();
      synchronized (wvu)
      {
        Iterator localIterator = wvu.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((au)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (au)((Iterator)???).next();
        new ap(((au)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149380);
            if (paramcv.ugm == 49)
            {
              k.b localb = k.b.yr(d.c(paramcv));
              if ((localb.hBl == 1) && (!bt.isNullOrNil(localb.hBm)) && (!bt.isNullOrNil(localb.hBn)))
              {
                this.wvC.a(39, localb.hBn, "", localb.hBm, null, null);
                AppMethodBeat.o(149380);
                return;
              }
              this.wvC.a(parambu);
              AppMethodBeat.o(149380);
              return;
            }
            this.wvC.a(parambu);
            AppMethodBeat.o(149380);
          }
        });
      }
      AppMethodBeat.o(149385);
      return;
    }
    this.wvx.add(parambu);
    AppMethodBeat.o(149385);
  }
  
  public final void cCF()
  {
    AppMethodBeat.i(149384);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.wvx);
    this.wvx.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(149384);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (wvu)
    {
      Iterator localIterator = wvu.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((au)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (au)((Iterator)???).next();
      new ap(((au)localObject2).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149379);
          this.wvy.M(localList);
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