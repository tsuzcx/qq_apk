package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/sns/storage/FinderSnsLiveStatusSyncSaver;", "", "()V", "SAVE_WHAT", "", "TAG", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "clearTask", "", "save", "snsinfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "plugin-sns_release"})
public final class d
{
  public static final int Emg = 1;
  public static final d Emh;
  private static final String TAG = "FinderSnsLiveStatusSyncSaver";
  private static final f lhN;
  
  static
  {
    AppMethodBeat.i(201811);
    Emh = new d();
    TAG = "FinderSnsLiveStatusSyncSaver";
    Emg = 1;
    lhN = g.ah((a)a.Emi);
    AppMethodBeat.o(201811);
  }
  
  public static MMHandler bkj()
  {
    AppMethodBeat.i(201810);
    MMHandler localMMHandler = (MMHandler)lhN.getValue();
    AppMethodBeat.o(201810);
    return localMMHandler;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class a
    extends q
    implements a<MMHandler>
  {
    public static final a Emi;
    
    static
    {
      AppMethodBeat.i(201809);
      Emi = new a();
      AppMethodBeat.o(201809);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.d
 * JD-Core Version:    0.7.0.1
 */