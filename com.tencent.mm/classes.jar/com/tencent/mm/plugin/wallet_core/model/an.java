package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "mRequestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/wallet_core/cgi/NetSceneTenpayQueryBoundBankcard;", "Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$Request;", "Lkotlin/collections/HashMap;", "createResult", "Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$Result;", "scene", "", "netScene", "resultType", "Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$ResultType;", "isOk", "", "doBindQueryScene", "", "request", "fetchData", "getBankcardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;", "Lkotlin/collections/ArrayList;", "invokeCallback", "result", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "Request", "Result", "ResultType", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  implements com.tencent.mm.am.h
{
  public static final an VKs;
  public static HashMap<ae, an.a> VKt;
  
  static
  {
    AppMethodBeat.i(301155);
    VKs = new an();
    VKt = new HashMap();
    AppMethodBeat.o(301155);
  }
  
  private static b a(int paramInt, ae paramae, an.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(301145);
    ArrayList localArrayList = asm(paramInt);
    Object localObject2 = new ah.f();
    Object localObject1 = new ah.f();
    d.a(localArrayList, (b)new d((ah.f)localObject2, (ah.f)localObject1));
    al localal = u.iiC().ijK();
    localObject2 = (Bankcard)((ah.f)localObject2).aqH;
    localObject1 = (Bankcard)((ah.f)localObject1).aqH;
    kotlin.g.b.s.s(localal, "userInfo");
    paramae = new b(localArrayList, (Bankcard)localObject2, (Bankcard)localObject1, localal, paramae, paramc, paramBoolean);
    AppMethodBeat.o(301145);
    return paramae;
  }
  
  private static void a(ae paramae, b paramb)
  {
    AppMethodBeat.i(301154);
    Log.d("MicroMsg.WcPayBindQueryDataFetcher", "invoke callback: " + paramae.scene + ", " + VKt.get(paramae));
    an.a locala = (an.a)VKt.get(paramae);
    if (locala != null) {
      locala.callback.invoke(paramb);
    }
    VKt.remove(paramae);
    AppMethodBeat.o(301154);
  }
  
  private static ArrayList<Bankcard> asm(int paramInt)
  {
    AppMethodBeat.i(301150);
    switch (paramInt)
    {
    default: 
      localArrayList = u.iiC().HJ(true);
      kotlin.g.b.s.s(localArrayList, "{\n            SubCoreWal…ardForPay(true)\n        }");
      AppMethodBeat.o(301150);
      return localArrayList;
    }
    ArrayList localArrayList = k.asC(paramInt);
    kotlin.g.b.s.s(localArrayList, "{\n            WalletBank…orScene2(scene)\n        }");
    AppMethodBeat.o(301150);
    return localArrayList;
  }
  
  public final void a(an.a parama)
  {
    AppMethodBeat.i(301157);
    kotlin.g.b.s.u(parama, "request");
    Iterator localIterator = VKt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (kotlin.g.b.s.p(localEntry.getValue(), parama))
      {
        VKt.remove(localEntry.getKey());
        Log.i("MicroMsg.WcPayBindQueryDataFetcher", kotlin.g.b.s.X("remove request ", parama));
      }
    }
    if (VKt.isEmpty()) {
      com.tencent.mm.kernel.h.aZW().b(385, (com.tencent.mm.am.h)this);
    }
    AppMethodBeat.o(301157);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(301160);
    if ((paramp instanceof ae))
    {
      Log.i("MicroMsg.WcPayBindQueryDataFetcher", "on scene end: " + paramInt1 + ", " + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a((ae)paramp, a(((ae)paramp).scene, (ae)paramp, an.c.VKz));
        AppMethodBeat.o(301160);
        return;
      }
      a((ae)paramp, a(((ae)paramp).scene, (ae)paramp, an.c.VKz, false));
    }
    AppMethodBeat.o(301160);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$Result;", "", "bankcardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;", "Lkotlin/collections/ArrayList;", "balance", "lqtInfo", "userInfo", "Lcom/tencent/mm/plugin/wallet_core/model/WalletUserInfo;", "netScene", "Lcom/tencent/mm/plugin/wallet_core/cgi/NetSceneTenpayQueryBoundBankcard;", "resultType", "Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$ResultType;", "isOk", "", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;Lcom/tencent/mm/plugin/wallet_core/model/WalletUserInfo;Lcom/tencent/mm/plugin/wallet_core/cgi/NetSceneTenpayQueryBoundBankcard;Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$ResultType;Z)V", "getBalance", "()Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;", "getBankcardList", "()Ljava/util/ArrayList;", "()Z", "getLqtInfo", "getNetScene", "()Lcom/tencent/mm/plugin/wallet_core/cgi/NetSceneTenpayQueryBoundBankcard;", "getResultType", "()Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$ResultType;", "getUserInfo", "()Lcom/tencent/mm/plugin/wallet_core/model/WalletUserInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private final al VKc;
    public final Bankcard VKi;
    public final ArrayList<Bankcard> VKv;
    private final ae VKw;
    private final an.c VKx;
    public final Bankcard VcF;
    public final boolean hEn;
    
    public b(ArrayList<Bankcard> paramArrayList, Bankcard paramBankcard1, Bankcard paramBankcard2, al paramal, ae paramae, an.c paramc, boolean paramBoolean)
    {
      AppMethodBeat.i(301144);
      this.VKv = paramArrayList;
      this.VcF = paramBankcard1;
      this.VKi = paramBankcard2;
      this.VKc = paramal;
      this.VKw = paramae;
      this.VKx = paramc;
      this.hEn = paramBoolean;
      AppMethodBeat.o(301144);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(301153);
      if (this == paramObject)
      {
        AppMethodBeat.o(301153);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(301153);
        return false;
      }
      paramObject = (b)paramObject;
      if (!kotlin.g.b.s.p(this.VKv, paramObject.VKv))
      {
        AppMethodBeat.o(301153);
        return false;
      }
      if (!kotlin.g.b.s.p(this.VcF, paramObject.VcF))
      {
        AppMethodBeat.o(301153);
        return false;
      }
      if (!kotlin.g.b.s.p(this.VKi, paramObject.VKi))
      {
        AppMethodBeat.o(301153);
        return false;
      }
      if (!kotlin.g.b.s.p(this.VKc, paramObject.VKc))
      {
        AppMethodBeat.o(301153);
        return false;
      }
      if (!kotlin.g.b.s.p(this.VKw, paramObject.VKw))
      {
        AppMethodBeat.o(301153);
        return false;
      }
      if (this.VKx != paramObject.VKx)
      {
        AppMethodBeat.o(301153);
        return false;
      }
      if (this.hEn != paramObject.hEn)
      {
        AppMethodBeat.o(301153);
        return false;
      }
      AppMethodBeat.o(301153);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(301148);
      String str = "Result(bankcardList=" + this.VKv + ", balance=" + this.VcF + ", lqtInfo=" + this.VKi + ", userInfo=" + this.VKc + ", netScene=" + this.VKw + ", resultType=" + this.VKx + ", isOk=" + this.hEn + ')';
      AppMethodBeat.o(301148);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet_core/model/Bankcard;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements b<Bankcard, Boolean>
  {
    d(ah.f<Bankcard> paramf1, ah.f<Bankcard> paramf2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an
 * JD-Core Version:    0.7.0.1
 */