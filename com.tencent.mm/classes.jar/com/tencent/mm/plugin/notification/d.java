package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements u
{
  private static List<aq> piB;
  private boolean piC;
  private boolean piD;
  private List<bi> piE;
  
  static
  {
    AppMethodBeat.i(125807);
    piB = new ArrayList();
    AppMethodBeat.o(125807);
  }
  
  public d()
  {
    this(false);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(125803);
    this.piC = false;
    this.piD = false;
    this.piE = new LinkedList();
    this.piC = paramBoolean;
    this.piD = false;
    this.piE = new LinkedList();
    AppMethodBeat.o(125803);
  }
  
  public static void a(aq paramaq)
  {
    AppMethodBeat.i(125801);
    synchronized (piB)
    {
      if (!piB.contains(paramaq)) {
        piB.add(paramaq);
      }
      AppMethodBeat.o(125801);
      return;
    }
  }
  
  public static void b(aq paramaq)
  {
    AppMethodBeat.i(125802);
    synchronized (piB)
    {
      piB.remove(paramaq);
      AppMethodBeat.o(125802);
      return;
    }
  }
  
  public final void a(bi parambi, cm paramcm)
  {
    AppMethodBeat.i(125805);
    if (this.piC)
    {
      ab.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      AppMethodBeat.o(125805);
      return;
    }
    synchronized (piB)
    {
      if (piB.isEmpty())
      {
        ab.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        AppMethodBeat.o(125805);
        return;
      }
      if ((parambi.field_isSend != 0) || (parambi.field_status == 4))
      {
        ab.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        AppMethodBeat.o(125805);
        return;
      }
    }
    ??? = aa.a(paramcm.woP);
    ??? = ((j)g.E(j.class)).YI().TL(new bq.a((String)???).asA(""));
    if ((??? != null) && (!((bq)???).dyH()))
    {
      ab.d("MicroMsg.SyncMessageNotifier", "account no notification");
      AppMethodBeat.o(125805);
      return;
    }
    if (!this.piD)
    {
      this.piD = true;
      Object localObject2 = new ArrayList();
      synchronized (piB)
      {
        Iterator localIterator = piB.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((aq)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (aq)((Iterator)???).next();
        new ak(((aq)localObject2).getLooper()).post(new d.2(this, paramcm, (aq)localObject2, parambi));
      }
      AppMethodBeat.o(125805);
      return;
    }
    this.piE.add(parambi);
    AppMethodBeat.o(125805);
  }
  
  public final void bPR()
  {
    AppMethodBeat.i(125804);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.piE);
    this.piE.clear();
    if (localLinkedList.size() == 0)
    {
      AppMethodBeat.o(125804);
      return;
    }
    Object localObject2 = new ArrayList();
    synchronized (piB)
    {
      Iterator localIterator = piB.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((aq)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (aq)((Iterator)???).next();
      new ak(((aq)localObject2).getLooper()).post(new d.1(this, (aq)localObject2, localList));
    }
    AppMethodBeat.o(125804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d
 * JD-Core Version:    0.7.0.1
 */