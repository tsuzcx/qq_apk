package com.tencent.mm.plugin.wallet.wecoin.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "", "showDarkAlways", "", "mScene", "", "sceneSessionID", "", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "(ZILjava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "getMScene", "()I", "getSceneSessionID", "()Ljava/lang/String;", "getShowDarkAlways", "()Z", "Builder", "Companion", "plugin-wxpay_release"})
public final class e
{
  public static final e.b OEI;
  public final boolean OEF;
  public final String OEG;
  public final com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> OEH;
  public final int mScene;
  
  static
  {
    AppMethodBeat.i(228943);
    OEI = new e.b((byte)0);
    AppMethodBeat.o(228943);
  }
  
  public e(boolean paramBoolean, int paramInt, String paramString, com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> parame)
  {
    this.OEF = paramBoolean;
    this.mScene = paramInt;
    this.OEG = paramString;
    this.OEH = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.e
 * JD-Core Version:    0.7.0.1
 */