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
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (this.AQs.AQq != null)
    {
      localObject = this.AQs;
      Bitmap localBitmap = this.val$bmp;
      String str = this.ANT.AOi;
      if (((a)localObject).AQq != null)
      {
        ((a)localObject).AQq.nC(str, str);
        ((a)localObject).AQq.AKT = localBitmap;
        ((a)localObject).AQq.AKU = localBitmap;
        ((a)localObject).AQq.hhQ();
      }
      this.AQs.AQq.aa(paramView, true);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.4
 * JD-Core Version:    0.7.0.1
 */