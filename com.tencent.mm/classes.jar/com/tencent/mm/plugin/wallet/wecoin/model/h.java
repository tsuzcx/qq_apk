package com.tencent.mm.plugin.wallet.wecoin.model;

import android.content.Context;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.plugin.wallet.wecoin.b.d;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "", "()V", "isMidasAlreadyInit", "", "sdkInfo", "Lcom/tencent/mm/protocal/protobuf/MidasSdkInfo;", "initMidasSDK", "", "activity", "Landroid/content/Context;", "initSDK", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Companion", "SingletonHolder", "plugin-wxpay_release"})
public final class h
{
  private static final h HNK;
  public static final h.a HNL;
  private cov HNI;
  private boolean HNJ;
  
  static
  {
    AppMethodBeat.i(212733);
    HNL = new h.a((byte)0);
    b localb = b.HNN;
    HNK = b.fPH();
    AppMethodBeat.o(212733);
  }
  
  private final void a(Context paramContext, cov paramcov)
  {
    AppMethodBeat.i(212732);
    Log.i("MicroMsg.WeCoinMidasInitializer", "is midas sdk already initialized: " + this.HNJ);
    if ((c.fPK()) && (this.HNJ))
    {
      AppMethodBeat.o(212732);
      return;
    }
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    localAPMidasGameRequest.offerId = paramcov.MuV;
    localAPMidasGameRequest.openId = paramcov.MuW;
    localAPMidasGameRequest.openKey = paramcov.MuX;
    localAPMidasGameRequest.sessionId = paramcov.session_id;
    localAPMidasGameRequest.sessionType = paramcov.MuY;
    localAPMidasGameRequest.pf = paramcov.pf;
    localAPMidasGameRequest.pfKey = paramcov.MuZ;
    APMidasPayAPI.setEnv("release");
    APMidasPayAPI.setLogEnable(false);
    APMidasPayAPI.init(paramContext, (APMidasBaseRequest)localAPMidasGameRequest);
    this.HNJ = true;
    AppMethodBeat.o(212732);
  }
  
  public final void b(final Context paramContext, final e<Boolean> parame)
  {
    AppMethodBeat.i(212731);
    p.h(paramContext, "activity");
    Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK.");
    cov localcov = this.HNI;
    if (localcov != null)
    {
      Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK already initialized.");
      a(paramContext, localcov);
      com.tencent.f.h.RTc.aV((Runnable)new c(this, paramContext, parame));
      AppMethodBeat.o(212731);
      return;
    }
    new d().aYI().b((a)new d(this, parame, paramContext));
    AppMethodBeat.o(212731);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "getHolder", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "plugin-wxpay_release"})
  static final class b
  {
    private static final h HNM;
    public static final b HNN;
    
    static
    {
      AppMethodBeat.i(212728);
      HNN = new b();
      HNM = new h((byte)0);
      AppMethodBeat.o(212728);
    }
    
    public static h fPH()
    {
      return HNM;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$initSDK$1$1"})
  static final class c
    implements Runnable
  {
    c(h paramh, Context paramContext, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(212729);
      e locale = parame;
      if (locale != null)
      {
        locale.onSuccess(Boolean.TRUE);
        AppMethodBeat.o(212729);
        return;
      }
      AppMethodBeat.o(212729);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMidasSdkInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    d(h paramh, e parame, Context paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.h
 * JD-Core Version:    0.7.0.1
 */