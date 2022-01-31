package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mm.sdk.platformtools.y;

final class ChattingImageBGView$1
  implements Runnable
{
  ChattingImageBGView$1(ChattingImageBGView paramChattingImageBGView) {}
  
  public final void run()
  {
    if (ChattingImageBGView.a(this.vjZ) == null)
    {
      y.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
      return;
    }
    if (ChattingImageBGView.a(this.vjZ).getWidth() == 0) {
      y.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
    }
    Matrix localMatrix = new Matrix();
    float f2 = this.vjZ.getMeasuredWidth() / ChattingImageBGView.a(this.vjZ).getWidth();
    float f1 = this.vjZ.getMeasuredHeight() / ChattingImageBGView.a(this.vjZ).getHeight();
    y.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.vjZ.getMeasuredWidth()), Integer.valueOf(this.vjZ.getMeasuredHeight()) });
    if (f2 > f1) {
      localMatrix.setScale(f2, f2);
    }
    for (;;)
    {
      this.vjZ.setImageMatrix(localMatrix);
      return;
      localMatrix.setScale(f1, f1);
      f2 = ChattingImageBGView.a(this.vjZ).getWidth();
      localMatrix.postTranslate((this.vjZ.getMeasuredWidth() - f2 * f1) / 2.0F, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingImageBGView.1
 * JD-Core Version:    0.7.0.1
 */