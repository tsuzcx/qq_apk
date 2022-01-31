package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChattingImageBGView$1
  implements Runnable
{
  ChattingImageBGView$1(ChattingImageBGView paramChattingImageBGView) {}
  
  public final void run()
  {
    AppMethodBeat.i(30688);
    if (ChattingImageBGView.a(this.zzB) == null)
    {
      ab.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
      AppMethodBeat.o(30688);
      return;
    }
    if (ChattingImageBGView.a(this.zzB).getWidth() == 0) {
      ab.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
    }
    Matrix localMatrix = new Matrix();
    float f2 = this.zzB.getMeasuredWidth() / ChattingImageBGView.a(this.zzB).getWidth();
    float f1 = this.zzB.getMeasuredHeight() / ChattingImageBGView.a(this.zzB).getHeight();
    ab.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.zzB.getMeasuredWidth()), Integer.valueOf(this.zzB.getMeasuredHeight()) });
    if (f2 > f1) {
      localMatrix.setScale(f2, f2);
    }
    for (;;)
    {
      this.zzB.setImageMatrix(localMatrix);
      AppMethodBeat.o(30688);
      return;
      localMatrix.setScale(f1, f1);
      f2 = ChattingImageBGView.a(this.zzB).getWidth();
      localMatrix.postTranslate((this.zzB.getMeasuredWidth() - f2 * f1) / 2.0F, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingImageBGView.1
 * JD-Core Version:    0.7.0.1
 */