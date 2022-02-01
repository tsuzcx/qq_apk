package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ProductFurtherInfoUI$3
  implements View.OnTouchListener
{
  ProductFurtherInfoUI$3(ProductFurtherInfoUI paramProductFurtherInfoUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(51818);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/scanner/ui/ProductFurtherInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if ((paramView != null) && (paramView.getParent() != null)) {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    a.a(false, this, "com/tencent/mm/plugin/scanner/ui/ProductFurtherInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(51818);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.3
 * JD-Core Version:    0.7.0.1
 */