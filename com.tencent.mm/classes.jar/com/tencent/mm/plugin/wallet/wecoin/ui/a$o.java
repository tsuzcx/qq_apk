package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.wecoin.b.j;
import com.tencent.mm.plugin.wallet.wecoin.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class a$o
  implements DialogInterface.OnCancelListener
{
  a$o(a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(271808);
    if ((!this.OGh.OGe.isFinishing()) && (!this.OGh.OGe.isDestroyed()))
    {
      paramDialogInterface = a.d(this.OGh);
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelPrepareRecharge, mPrepareCgi: " + paramDialogInterface.OEQ);
      Object localObject = paramDialogInterface.OEQ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.wallet.wecoin.b.l)localObject).cancel();
      }
      paramDialogInterface.e(3, 2, 0, "");
      paramDialogInterface = a.d(this.OGh);
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelGetPriceListRequest, mGetPriceListCgi: " + paramDialogInterface.OER);
      localObject = paramDialogInterface.OER;
      if (localObject != null) {
        ((j)localObject).cancel();
      }
      paramDialogInterface.e(8, 2, 0, "");
      this.OGh.OGe.finish();
    }
    paramDialogInterface = a.i(this.OGh);
    if (paramDialogInterface != null)
    {
      if (paramDialogInterface.isShowing())
      {
        paramDialogInterface.dismiss();
        a.j(this.OGh);
      }
      AppMethodBeat.o(271808);
      return;
    }
    AppMethodBeat.o(271808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.a.o
 * JD-Core Version:    0.7.0.1
 */