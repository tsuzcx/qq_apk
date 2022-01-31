package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsUploadUI$5
  implements View.OnTouchListener
{
  SnsUploadUI$5(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(145655);
    ab.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
    if (SnsUploadUI.E(this.sbR))
    {
      AppMethodBeat.o(145655);
      return true;
    }
    AppMethodBeat.o(145655);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.5
 * JD-Core Version:    0.7.0.1
 */