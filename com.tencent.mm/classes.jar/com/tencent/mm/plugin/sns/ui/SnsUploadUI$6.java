package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;

final class SnsUploadUI$6
  implements View.OnTouchListener
{
  SnsUploadUI$6(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176367);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(176367);
      return false;
      this.qbm[0] = true;
      d.MtP.kI("ce_sns_upload", "<SnsUpload>");
      continue;
      d.MtP.a("ce_sns_upload", paramMotionEvent);
      d.MtP.aQm("ce_sns_upload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.6
 * JD-Core Version:    0.7.0.1
 */