package com.tencent.mm.plugin.wallet.wecoin.utils;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$ResultReceiver$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeCoinUtilsKt$ResultReceiver$1
  extends ResultReceiver
{
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(315710);
    this.Vxi.invoke(Integer.valueOf(paramInt), paramBundle);
    AppMethodBeat.o(315710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.utils.WeCoinUtilsKt.ResultReceiver.1
 * JD-Core Version:    0.7.0.1
 */