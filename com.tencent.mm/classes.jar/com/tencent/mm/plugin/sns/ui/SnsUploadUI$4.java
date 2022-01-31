package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class SnsUploadUI$4
  implements View.OnTouchListener
{
  SnsUploadUI$4(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(145654);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(145654);
      return false;
      this.gFg[0] = true;
      b.pgQ.fD("ce_sns_upload", "<SnsUpload>");
      continue;
      b.pgQ.a("ce_sns_upload", paramMotionEvent);
      b.pgQ.Wa("ce_sns_upload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.4
 * JD-Core Version:    0.7.0.1
 */