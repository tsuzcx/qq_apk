package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class SnsUploadUI$6
  implements View.OnTouchListener
{
  SnsUploadUI$6(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176367);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$14", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    ae.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
    if (SnsUploadUI.L(this.AGr))
    {
      a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$14", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(176367);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$14", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(176367);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.6
 * JD-Core Version:    0.7.0.1
 */