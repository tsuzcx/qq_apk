package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bb;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cm.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  implements ae
{
  private static List<bb> Mwa;
  private boolean Mwb;
  private boolean Mwc;
  private List<cc> Mwd;
  
  static
  {
    AppMethodBeat.i(149387);
    Mwa = new ArrayList();
    AppMethodBeat.o(149387);
  }
  
  public h()
  {
    this(false);
  }
  
  public h(boolean paramBoolean)
  {
    AppMethodBeat.i(149383);
    this.Mwb = false;
    this.Mwc = false;
    this.Mwd = new LinkedList();
    this.Mwb = paramBoolean;
    this.Mwc = false;
    this.Mwd = new LinkedList();
    AppMethodBeat.o(149383);
  }
  
  public static void a(bb parambb)
  {
    AppMethodBeat.i(149381);
    synchronized (Mwa)
    {
      if (!Mwa.contains(parambb)) {
        Mwa.add(parambb);
      }
      AppMethodBeat.o(149381);
      return;
    }
  }
  
  public static void b(bb parambb)
  {
    AppMethodBeat.i(149382);
    synchronized (Mwa)
    {
      Mwa.remove(parambb);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public final void a(final cc paramcc, final dl paramdl)
  {
    AppMethodBeat.i(149385);
    if (this.Mwb)
    {
      Log.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(149385);
      return;
    }
    synchronized (Mwa)
    {
      if (Mwa.isEmpty())
      {
        Log.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        AppMethodBeat.o(149385);
        return;
      }
      if ((paramcc.field_isSend != 0) || (paramcc.field_status == 4))
      {
        Log.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        AppMethodBeat.o(149385);
        return;
      }
    }
    ??? = w.a(paramdl.YFE);
    ??? = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ().aMh(new cm.a((String)???).byJ(""));
    if ((??? != null) && (!((cm)???).jcI()))
    {
      Log.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(149385);
      return;
    }
    if (!this.Mwc)
    {
      this.Mwc = true;
      Object localObject2 = new ArrayList();
      synchronized (Mwa)
      {
        Iterator localIterator = Mwa.iterator();
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
            if (paramdl.IIs == 49)
            {
              k.b localb = k.b.Hf(h.c(paramdl));
              if ((localb.nSz == 1) && (!Util.isNullOrNil(localb.nSA)) && (!Util.isNullOrNil(localb.nSB)))
              {
                this.Mwi.a(39, localb.nSB, "", localb.nSA, null, null);
                AppMethodBeat.o(149380);
                return;
              }
              this.Mwi.a(paramcc);
              AppMethodBeat.o(149380);
              return;
            }
            this.Mwi.a(paramcc);
            AppMethodBeat.o(149380);
          }
        });
      }
      AppMethodBeat.o(149385);
      return;
    }
    this.Mwd.add(paramcc);
    AppMethodBeat.o(149385);
  }
  
  public final void dir()
  {
    AppMethodBeat.i(149384);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.Mwd);
    this.Mwd.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(149384);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (Mwa)
    {
      Iterator localIterator = Mwa.iterator();
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
          this.Mwe.bp(localList);
          AppMethodBeat.o(149379);
        }
      });
    }
    AppMethodBeat.o(149384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.h
 * JD-Core Version:    0.7.0.1
 */