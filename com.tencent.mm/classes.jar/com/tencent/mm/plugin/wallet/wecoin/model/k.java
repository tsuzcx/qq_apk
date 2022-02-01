package com.tencent.mm.plugin.wallet.wecoin.model;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "", "()V", "isMidasAlreadyInit", "", "sdkInfo", "Lcom/tencent/mm/protocal/protobuf/MidasSdkInfo;", "initMidasSDK", "", "activity", "Landroid/content/Context;", "initSDK", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Companion", "SingletonHolder", "plugin-wxpay_release"})
public final class k
{
  private static final k OFG;
  public static final k.a OFH;
  private cxk OFD;
  private boolean OFE;
  
  static
  {
    AppMethodBeat.i(215502);
    OFH = new k.a((byte)0);
    b localb = b.OFJ;
    OFG = b.gIl();
    AppMethodBeat.o(215502);
  }
  
  private final void a(Context paramContext, cxk paramcxk)
  {
    AppMethodBeat.i(215499);
    Log.i("MicroMsg.WeCoinMidasInitializer", "is midas sdk already initialized: " + this.OFE);
    if ((c.gIo()) && (this.OFE))
    {
      AppMethodBeat.o(215499);
      return;
    }
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    localAPMidasGameRequest.offerId = paramcxk.TFS;
    localAPMidasGameRequest.openId = paramcxk.TFT;
    localAPMidasGameRequest.openKey = paramcxk.TFU;
    localAPMidasGameRequest.sessionId = paramcxk.session_id;
    localAPMidasGameRequest.sessionType = paramcxk.TFV;
    localAPMidasGameRequest.pf = paramcxk.pf;
    localAPMidasGameRequest.pfKey = paramcxk.TFW;
    if (c.gIp()) {
      localAPMidasGameRequest.reserv = "enableX5=0";
    }
    APMidasPayAPI.setEnv("release");
    APMidasPayAPI.setLogEnable(false);
    APMidasPayAPI.setLogCallback(MidasPayLogCallbackImpl.class);
    APMidasPayAPI.init(paramContext, (APMidasBaseRequest)localAPMidasGameRequest);
    this.OFE = true;
    AppMethodBeat.o(215499);
  }
  
  public final void b(final Context paramContext, final com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> parame)
  {
    AppMethodBeat.i(215496);
    p.k(paramContext, "activity");
    Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK.");
    cxk localcxk = this.OFD;
    if (localcxk != null)
    {
      Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK already initialized.");
      a(paramContext, localcxk);
      h.ZvG.bc((Runnable)new c(this, paramContext, parame));
      AppMethodBeat.o(215496);
      return;
    }
    new com.tencent.mm.plugin.wallet.wecoin.b.e().bhW().b((a)new d(this, parame, paramContext));
    AppMethodBeat.o(215496);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "getHolder", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "plugin-wxpay_release"})
  static final class b
  {
    private static final k OFI;
    public static final b OFJ;
    
    static
    {
      AppMethodBeat.i(268435);
      OFJ = new b();
      OFI = new k((byte)0);
      AppMethodBeat.o(268435);
    }
    
    public static k gIl()
    {
      return OFI;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$initSDK$1$1"})
  static final class c
    implements Runnable
  {
    c(k paramk, Context paramContext, com.tencent.mm.plugin.wallet.wecoin.a.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(223422);
      com.tencent.mm.plugin.wallet.wecoin.a.e locale = parame;
      if (locale != null)
      {
        locale.onSuccess(Boolean.TRUE);
        AppMethodBeat.o(223422);
        return;
      }
      AppMethodBeat.o(223422);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMidasSdkInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    d(k paramk, com.tencent.mm.plugin.wallet.wecoin.a.e parame, Context paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.k
 * JD-Core Version:    0.7.0.1
 */