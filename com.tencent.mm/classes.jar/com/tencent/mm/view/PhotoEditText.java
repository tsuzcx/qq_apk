package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PhotoEditText
  extends AppCompatEditText
{
  private Xfermode YLL;
  private int mBgColor;
  private Paint mPaint;
  
  public PhotoEditText(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(9365);
    this.mPaint = new Paint(1);
    init();
    AppMethodBeat.o(9365);
  }
  
  public PhotoEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9366);
    this.mPaint = new Paint(1);
    init();
    AppMethodBeat.o(9366);
  }
  
  private void init()
  {
    AppMethodBeat.i(9367);
    new TextView(getContext()).setTextSize(getTextSize());
    this.YLL = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    AppMethodBeat.o(9367);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    AppMethodBeat.i(9369);
    if (this.mBgColor == 0)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(9369);
      return;
    }
    paramCanvas.saveLayerAlpha(null, (int)(getAlpha() * 255.0F), 31);
    this.mPaint.setColor(this.mBgColor);
    this.mPaint.setAntiAlias(true);
    Rect localRect = new Rect();
    getLineBounds(0, localRect);
    float f1;
    if (getLineCount() == 1)
    {
      f1 = localRect.left;
      localRect.right = ((int)(getLayout().getLineWidth(0) + f1));
      localRect.left = ((int)(localRect.left - 18.0F));
      localRect.right = ((int)(localRect.right + 18.0F));
      if (getLineCount() != 1) {
        break label291;
      }
      if (!TextUtils.isEmpty(getText()))
      {
        this.mPaint.setXfermode(null);
        paramCanvas.drawRoundRect(new RectF(localRect), 12.0F, 12.0F, this.mPaint);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      super.onDraw(paramCanvas);
      AppMethodBeat.o(9369);
      return;
      float f2;
      for (f1 = 0.0F; i < getLineCount(); f1 = f2)
      {
        float f3 = getLayout().getLineWidth(i);
        f2 = f1;
        if (f1 < f3) {
          f2 = f3;
        }
        i += 1;
      }
      localRect.right = ((int)(localRect.left + f1));
      localRect.bottom = (localRect.top + getLayout().getLineBottom(getLineCount() - 1));
      break;
      label291:
      this.mPaint.setXfermode(null);
      this.mPaint.setColor(this.mBgColor);
      paramCanvas.drawRoundRect(new RectF(localRect), 12.0F, 12.0F, this.mPaint);
      if (getLayout().getLineWidth(getLineCount() - 1) < getLayout().getLineWidth(getLineCount() - 2))
      {
        this.mPaint.setXfermode(this.YLL);
        RectF localRectF = new RectF();
        localRectF.left = (localRect.left + 36.0F + getLayout().getLineWidth(getLineCount() - 1));
        localRectF.top = (localRect.bottom - getLineHeight());
        localRectF.right = (localRect.right + 18.0F);
        localRectF.bottom = (localRect.bottom + 18.0F);
        paramCanvas.drawRoundRect(localRectF, 12.0F, 12.0F, this.mPaint);
        this.mPaint.setXfermode(this.YLL);
        paramCanvas.drawRect(new Rect((int)(localRectF.left - getTextSize() / 2.0F), (int)(localRectF.bottom - getTextSize() / 2.0F), (int)localRectF.left, (int)localRectF.bottom), this.mPaint);
        paramCanvas.drawRect(new Rect((int)(localRect.right - getTextSize() / 2.0F), (int)(localRect.top + getLayout().getLineBottom(getLineCount() - 2) - getTextSize() / 2.0F), localRect.right, localRect.top + getLayout().getLineBottom(getLineCount() - 2) + 3), this.mPaint);
        this.mPaint.setXfermode(null);
        f2 = localRectF.left - getTextSize();
        f1 = f2;
        if (f2 < localRect.left) {
          f1 = localRect.left;
        }
        paramCanvas.drawRoundRect(new RectF(new Rect((int)f1, (int)(localRect.bottom - getTextSize() / 2.0F), (int)localRectF.left, localRect.bottom)), 12.0F, 12.0F, this.mPaint);
        paramCanvas.drawRoundRect(new RectF(new Rect((int)(localRect.right - getTextSize()), (int)(localRect.bottom - getLineHeight() - getTextSize()), localRect.right, localRect.bottom - getLineHeight())), 12.0F, 12.0F, this.mPaint);
      }
    }
  }
  
  public void setTextBackground(int paramInt)
  {
    AppMethodBeat.i(9368);
    this.mBgColor = paramInt;
    invalidate();
    AppMethodBeat.o(9368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.PhotoEditText
 * JD-Core Version:    0.7.0.1
 */