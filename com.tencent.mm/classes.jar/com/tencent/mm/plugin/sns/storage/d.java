package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/storage/FinderSnsLiveStatusSyncSaver;", "", "()V", "SAVE_WHAT", "", "TAG", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "clearTask", "", "save", "snsinfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "plugin-sns_release"})
public final class d
{
  public static final int Kzo = 1;
  public static final d Kzp;
  private static final String TAG = "FinderSnsLiveStatusSyncSaver";
  private static final f ocu;
  
  static
  {
    AppMethodBeat.i(267295);
    Kzp = new d();
    TAG = "FinderSnsLiveStatusSyncSaver";
    Kzo = 1;
    ocu = g.ar((a)a.Kzq);
    AppMethodBeat.o(267295);
  }
  
  public static MMHandler btS()
  {
    AppMethodBeat.i(267294);
    MMHandler localMMHandler = (MMHandler)ocu.getValue();
    AppMethodBeat.o(267294);
    return localMMHandler;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class a
    extends q
    implements a<MMHandler>
  {
    public static final a Kzq;
    
    static
    {
      AppMethodBeat.i(193945);
      Kzq = new a();
      AppMethodBeat.o(193945);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.d
 * JD-Core Version:    0.7.0.1
 */