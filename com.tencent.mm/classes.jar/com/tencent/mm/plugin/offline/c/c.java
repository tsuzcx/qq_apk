package com.tencent.mm.plugin.offline.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/util/WalletOfflinePriorBankcardStore;", "", "()V", "TAG", "", "sImpl", "Lcom/tencent/mm/plugin/offline/util/WalletOfflinePriorBankcardStore$IPriorBankcardStore;", "sTokenTypeChangedListeners", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/offline/util/WalletOfflinePriorBankcardStore$OnTokenTypeChangedListener;", "Lkotlin/collections/ArrayList;", "addTokenTypeChangedListener", "", "listener", "getPriorBankcard", "Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;", "needJudgeDefaultCardState", "", "getPriorBindSerial", "initImpl", "isOnlineStoreType", "isOnlineToken", "onTokenTypeChange", "reload", "removeTokenTypeChangedListener", "resetPriorBankcard", "setPriorBindSerial", "bindSerial", "IPriorBankcardStore", "OnTokenTypeChangedListener", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c MDa;
  private static a MDb;
  static final ArrayList<c.b> MDc;
  
  static
  {
    AppMethodBeat.i(269114);
    MDa = new c();
    MDc = new ArrayList();
    gwx();
    AppMethodBeat.o(269114);
  }
  
  public static void a(c.b paramb)
  {
    AppMethodBeat.i(269109);
    s.u(paramb, "listener");
    if (!MDc.contains(paramb)) {
      MDc.add(paramb);
    }
    AppMethodBeat.o(269109);
  }
  
  public static void aQJ(String paramString)
  {
    AppMethodBeat.i(269095);
    s.u(paramString, "bindSerial");
    a locala2 = MDb;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("sImpl");
      locala1 = null;
    }
    locala1.aQJ(paramString);
    AppMethodBeat.o(269095);
  }
  
  public static void b(c.b paramb)
  {
    AppMethodBeat.i(269112);
    s.u(paramb, "listener");
    MDc.remove(paramb);
    AppMethodBeat.o(269112);
  }
  
  public static void gww()
  {
    AppMethodBeat.i(269103);
    a locala2 = MDb;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("sImpl");
      locala1 = null;
    }
    locala1.gww();
    AppMethodBeat.o(269103);
  }
  
  static void gwx()
  {
    AppMethodBeat.i(269092);
    boolean bool;
    if (d.getTokenType() == 2)
    {
      bool = true;
      Log.i("MicroMsg.OfflinePriorBankcardLogic", s.X("isOnlineToken: ", Boolean.valueOf(bool)));
      if (!bool) {
        break label68;
      }
      Log.i("MicroMsg.OfflinePriorBankcardLogic", "create online store");
    }
    for (a locala = (a)new b();; locala = (a)new a())
    {
      MDb = locala;
      reload();
      AppMethodBeat.o(269092);
      return;
      bool = false;
      break;
      label68:
      Log.i("MicroMsg.OfflinePriorBankcardLogic", "create legacy store");
    }
  }
  
  public static Bankcard gwy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(269100);
    Object localObject3 = MDb;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("sImpl");
      localObject1 = null;
    }
    localObject3 = ((a)localObject1).gwv();
    if (localObject3 == null) {}
    for (localObject1 = localObject2;; localObject1 = ((Bankcard)localObject3).field_bankcardType)
    {
      Log.i("MicroMsg.OfflinePriorBankcardLogic", s.X("getPriorBankcard: ", localObject1));
      AppMethodBeat.o(269100);
      return localObject3;
    }
  }
  
  public static boolean gwz()
  {
    AppMethodBeat.i(269107);
    a locala2 = MDb;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("sImpl");
      locala1 = null;
    }
    boolean bool = locala1 instanceof b;
    AppMethodBeat.o(269107);
    return bool;
  }
  
  public static void reload()
  {
    AppMethodBeat.i(269105);
    a locala2 = MDb;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("sImpl");
      locala1 = null;
    }
    locala1.reload();
    AppMethodBeat.o(269105);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/util/WalletOfflinePriorBankcardStore$IPriorBankcardStore;", "", "priorBankcard", "Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;", "needJudgeDefaultCardState", "", "priorBindSerial", "", "reload", "", "resetPriorBankcard", "setPriorBindSerial", "bindSerial", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void aQJ(String paramString);
    
    public abstract Bankcard gwv();
    
    public abstract void gww();
    
    public abstract void reload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.c
 * JD-Core Version:    0.7.0.1
 */