package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class ChattingImageBGView
  extends ImageView
{
  private int nmb;
  private Bitmap tZb;
  
  public ChattingImageBGView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34559);
    this.nmb = 0;
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    AppMethodBeat.o(34559);
  }
  
  public ChattingImageBGView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(34558);
    this.nmb = 0;
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    AppMethodBeat.o(34558);
  }
  
  private void fFL()
  {
    AppMethodBeat.i(34562);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34557);
        if (ChattingImageBGView.a(ChattingImageBGView.this) == null)
        {
          ae.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
          AppMethodBeat.o(34557);
          return;
        }
        if (ChattingImageBGView.a(ChattingImageBGView.this).getWidth() == 0) {
          ae.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
        }
        Matrix localMatrix = new Matrix();
        float f2 = ChattingImageBGView.this.getMeasuredWidth() / ChattingImageBGView.a(ChattingImageBGView.this).getWidth();
        float f1 = ChattingImageBGView.this.getMeasuredHeight() / ChattingImageBGView.a(ChattingImageBGView.this).getHeight();
        ae.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(ChattingImageBGView.this.getMeasuredWidth()), Integer.valueOf(ChattingImageBGView.this.getMeasuredHeight()) });
        if (f2 > f1) {
          localMatrix.setScale(f2, f2);
        }
        for (;;)
        {
          ChattingImageBGView.this.setImageMatrix(localMatrix);
          AppMethodBeat.o(34557);
          return;
          localMatrix.setScale(f1, f1);
          f2 = ChattingImageBGView.a(ChattingImageBGView.this).getWidth();
          localMatrix.postTranslate((ChattingImageBGView.this.getMeasuredWidth() - f2 * f1) / 2.0F, 0.0F);
        }
      }
    });
    AppMethodBeat.o(34562);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34560);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.nmb != paramInt3 - paramInt1))
    {
      this.nmb = (paramInt3 - paramInt1);
      ae.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      fFL();
    }
    AppMethodBeat.o(34560);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(34561);
    this.tZb = paramBitmap;
    super.setImageBitmap(paramBitmap);
    fFL();
    AppMethodBeat.o(34561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingImageBGView
 * JD-Core Version:    0.7.0.1
 */