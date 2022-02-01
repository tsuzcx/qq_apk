package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsUploadUI$6
  implements View.OnTouchListener
{
  SnsUploadUI$6(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176367);
    Log.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
    if (SnsUploadUI.L(this.LdU))
    {
      AppMethodBeat.o(176367);
      return true;
    }
    AppMethodBeat.o(176367);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.6
 * JD-Core Version:    0.7.0.1
 */