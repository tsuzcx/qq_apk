package com.tencent.mm.plugin.wallet.wecoin.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "", "showDarkAlways", "", "mScene", "", "sceneSessionID", "", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "(ZILjava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "getMScene", "()I", "getSceneSessionID", "()Ljava/lang/String;", "getShowDarkAlways", "()Z", "Builder", "Companion", "plugin-wxpay_release"})
public final class e
{
  public static final e.b HMM;
  public final boolean HMJ;
  public final String HMK;
  public final com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> HML;
  public final int mScene;
  
  static
  {
    AppMethodBeat.i(212699);
    HMM = new e.b((byte)0);
    AppMethodBeat.o(212699);
  }
  
  public e(boolean paramBoolean, int paramInt, String paramString, com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> parame)
  {
    this.HMJ = paramBoolean;
    this.mScene = paramInt;
    this.HMK = paramString;
    this.HML = parame;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam$Builder;", "", "()V", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "getCallback", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "setCallback", "(Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;)V", "mScene", "", "getMScene", "()I", "setMScene", "(I)V", "sceneSessionID", "", "getSceneSessionID", "()Ljava/lang/String;", "setSceneSessionID", "(Ljava/lang/String;)V", "showDarkAlways", "getShowDarkAlways", "()Z", "setShowDarkAlways", "(Z)V", "build", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "plugin-wxpay_release"})
  public static final class a
  {
    public boolean HMJ;
    String HMK = "";
    com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> HML;
    public int mScene = -1;
    
    public final e fPD()
    {
      AppMethodBeat.i(212698);
      e locale = new e(this.HMJ, this.mScene, this.HMK, this.HML);
      AppMethodBeat.o(212698);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.e
 * JD-Core Version:    0.7.0.1
 */