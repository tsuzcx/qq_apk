package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class SnsUploadUI$5
  implements View.OnTouchListener
{
  SnsUploadUI$5(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(99574);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$13", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$13", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(99574);
      return false;
      this.joR[0] = true;
      com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_sns_upload", "<SnsUpload>");
      continue;
      com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_sns_upload", paramMotionEvent);
      com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_sns_upload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.5
 * JD-Core Version:    0.7.0.1
 */