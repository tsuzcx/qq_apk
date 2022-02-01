package com.tencent.mm.plugin.wallet.wecoin.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam$Builder;", "", "()V", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "getCallback", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "setCallback", "(Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;)V", "mScene", "", "getMScene", "()I", "setMScene", "(I)V", "sceneSessionID", "", "getSceneSessionID", "()Ljava/lang/String;", "setSceneSessionID", "(Ljava/lang/String;)V", "showDarkAlways", "getShowDarkAlways", "()Z", "setShowDarkAlways", "(Z)V", "build", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "plugin-wxpay_release"})
public final class e$a
{
  public boolean OEF;
  String OEG = "";
  com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> OEH;
  public int mScene = -1;
  
  public final e gIh()
  {
    AppMethodBeat.i(222845);
    e locale = new e(this.OEF, this.mScene, this.OEG, this.OEH);
    AppMethodBeat.o(222845);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.e.a
 * JD-Core Version:    0.7.0.1
 */