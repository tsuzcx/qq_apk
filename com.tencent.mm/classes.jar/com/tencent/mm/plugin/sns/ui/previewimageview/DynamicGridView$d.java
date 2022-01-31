package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$d
  extends Handler
{
  private DynamicGridView$d(DynamicGridView paramDynamicGridView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40365);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40365);
      return;
      paramMessage = this.slD;
      View localView = paramMessage.getChildAt(paramMessage.slx);
      new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.slx).append(",lastTouchX ").append(paramMessage.sly).append(",lastTouchY ").append(paramMessage.slz);
      if ((!paramMessage.slh) && (!paramMessage.sli) && (f.d(localView, paramMessage.sly, paramMessage.slz))) {
        paramMessage.Fp(paramMessage.slx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.d
 * JD-Core Version:    0.7.0.1
 */