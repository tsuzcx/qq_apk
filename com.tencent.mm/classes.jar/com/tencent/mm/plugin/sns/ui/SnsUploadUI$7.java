package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsUploadUI$7
  implements View.OnTouchListener
{
  SnsUploadUI$7(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(369953);
    Log.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
    if (SnsUploadUI.M(this.REd))
    {
      AppMethodBeat.o(369953);
      return true;
    }
    AppMethodBeat.o(369953);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.7
 * JD-Core Version:    0.7.0.1
 */