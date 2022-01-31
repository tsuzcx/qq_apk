package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Handler;
import android.os.Message;
import android.view.View;

final class DynamicGridView$d
  extends Handler
{
  private DynamicGridView$d(DynamicGridView paramDynamicGridView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    View localView;
    do
    {
      return;
      paramMessage = this.pqL;
      localView = paramMessage.getChildAt(paramMessage.pqF);
      new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.pqF).append(",lastTouchX ").append(paramMessage.pqG).append(",lastTouchY ").append(paramMessage.pqH);
    } while ((paramMessage.pqp) || (paramMessage.pqq) || (!f.d(localView, paramMessage.pqG, paramMessage.pqH)));
    paramMessage.ze(paramMessage.pqF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.d
 * JD-Core Version:    0.7.0.1
 */