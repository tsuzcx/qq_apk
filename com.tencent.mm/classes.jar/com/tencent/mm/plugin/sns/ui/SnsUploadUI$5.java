package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class SnsUploadUI$5
  implements View.OnTouchListener
{
  SnsUploadUI$5(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(99574);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99574);
      return false;
      this.isK[0] = true;
      b.ufs.hK("ce_sns_upload", "<SnsUpload>");
      continue;
      b.ufs.a("ce_sns_upload", paramMotionEvent);
      b.ufs.ajw("ce_sns_upload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.5
 * JD-Core Version:    0.7.0.1
 */