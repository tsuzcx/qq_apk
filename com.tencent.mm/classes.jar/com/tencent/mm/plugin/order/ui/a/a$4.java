package com.tencent.mm.plugin.order.ui.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.wallet_core.ui.c;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, Bitmap paramBitmap, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66795);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    if (this.wEL.wEJ != null)
    {
      localObject = this.wEL;
      Bitmap localBitmap = this.val$bmp;
      String str = this.wCn.wCC;
      if (((a)localObject).wEJ != null)
      {
        ((a)localObject).wEJ.mF(str, str);
        ((a)localObject).wEJ.wzC = localBitmap;
        ((a)localObject).wEJ.wzD = localBitmap;
        ((a)localObject).wEJ.fRW();
      }
      this.wEL.wEJ.N(paramView, true);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.4
 * JD-Core Version:    0.7.0.1
 */