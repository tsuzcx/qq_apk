package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/nfc_open/logic/NfcDispatchLogic;", "", "()V", "DEFAULT_INITIAL_CAPACITY", "", "TAG", "", "processComparator", "Ljava/util/Comparator;", "Lcom/tencent/mm/plugin/nfc_open/logic/INfcProcessor;", "processorQueue", "Ljava/util/Queue;", "addProcessor", "", "processor", "doDispatch", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "removeProcessor", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Mtt;
  private static final Comparator<c> Mtu;
  private static final Queue<c> Mtv;
  
  static
  {
    AppMethodBeat.i(261807);
    Mtt = new d();
    Mtu = d..ExternalSyntheticLambda0.INSTANCE;
    Mtv = (Queue)new PriorityQueue(11, Mtu);
    Log.i("MicroMsg.Nfc.NfcDispatchLogic", "<init>");
    a((c)new a());
    a((c)new b());
    AppMethodBeat.o(261807);
  }
  
  private static final int a(c paramc1, c paramc2)
  {
    AppMethodBeat.i(261805);
    int i = paramc1.getPriority();
    int j = paramc2.getPriority();
    AppMethodBeat.o(261805);
    return i - j;
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(261799);
    s.u(paramc, "processor");
    Log.i("MicroMsg.Nfc.NfcDispatchLogic", s.X("addProcessor, processor: ", paramc.getName()));
    Mtv.add(paramc);
    AppMethodBeat.o(261799);
  }
  
  public static void aE(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(261803);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    Iterator localIterator = Mtv.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      Log.i("MicroMsg.Nfc.NfcDispatchLogic", s.X("doDispatch, dispatch to processor: ", localc.getName()));
      if (localc.aD(paramContext, paramIntent))
      {
        Log.i("MicroMsg.Nfc.NfcDispatchLogic", "doDispatch, processor: " + localc.getName() + " processed");
        AppMethodBeat.o(261803);
        return;
      }
    }
    AppMethodBeat.o(261803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.d
 * JD-Core Version:    0.7.0.1
 */