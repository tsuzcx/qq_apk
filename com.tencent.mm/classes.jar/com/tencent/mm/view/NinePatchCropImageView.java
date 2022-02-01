package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NinePatchCropImageView
  extends AppCompatImageView
{
  private RectF GPe;
  private NinePatch Rkb;
  private Drawable Rkc;
  private int Rkd;
  private int Rke;
  private boolean Rkf;
  private Paint paint;
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206176);
    this.paint = new Paint();
    this.Rkb = null;
    this.Rkc = null;
    this.Rkd = 0;
    this.Rke = 0;
    this.GPe = null;
    this.Rkf = true;
    init();
    AppMethodBeat.o(206176);
  }
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206177);
    this.paint = new Paint();
    this.Rkb = null;
    this.Rkc = null;
    this.Rkd = 0;
    this.Rke = 0;
    this.GPe = null;
    this.Rkf = true;
    init();
    AppMethodBeat.o(206177);
  }
  
  private void init()
  {
    AppMethodBeat.i(206178);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.paint.setAntiAlias(true);
    this.Rkc = getResources().getDrawable(2131099687);
    AppMethodBeat.o(206178);
  }
  
  public final void lZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206180);
    this.Rkd = paramInt1;
    this.Rke = paramInt2;
    invalidate();
    AppMethodBeat.o(206180);
  }
  
  public final void m(RectF paramRectF)
  {
    AppMethodBeat.i(206181);
    this.GPe = new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
    AppMethodBeat.o(206181);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206182);
    if (this.Rkb != null)
    {
      int k = paramCanvas.saveLayer(null, null);
      if (this.Rkc != null)
      {
        this.Rkc.setBounds(0, 0, getWidth(), getHeight());
        this.Rkc.draw(paramCanvas);
      }
      Object localObject;
      if ((this.GPe != null) && (this.Rkf))
      {
        localObject = this.GPe;
        RectF localRectF = new RectF((RectF)localObject);
        if (((RectF)localObject).width() > 1.0F)
        {
          localRectF.left += 1.0F;
          localRectF.right -= 1.0F;
        }
        if (((RectF)localObject).height() > 1.0F)
        {
          localRectF.top += 1.0F;
          localRectF.bottom -= 1.0F;
        }
        paramCanvas.clipRect(localRectF);
      }
      super.onDraw(paramCanvas);
      float f1;
      float f2;
      label189:
      int i;
      float f3;
      if (this.GPe == null)
      {
        f1 = getWidth();
        if (this.GPe != null) {
          break label353;
        }
        f2 = getHeight();
        if (((this.Rke == 0) && (this.Rkd == 0)) || (f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label420;
        }
        int j = this.Rkd;
        i = this.Rke;
        if (this.Rkd != 0) {
          break label364;
        }
        f3 = f2 / this.Rke;
        j = (int)(f1 / f2 * this.Rke);
        f1 = f3;
        f2 = f3;
        label261:
        paramCanvas.save();
        if (this.GPe != null) {
          paramCanvas.translate(this.GPe.left, this.GPe.top);
        }
        paramCanvas.scale(f1, f2);
        localObject = new Rect(0, 0, j, i);
        this.Rkb.draw(paramCanvas, (Rect)localObject, this.paint);
        paramCanvas.restore();
      }
      for (;;)
      {
        paramCanvas.restoreToCount(k);
        AppMethodBeat.o(206182);
        return;
        f1 = this.GPe.width();
        break;
        label353:
        f2 = this.GPe.height();
        break label189;
        label364:
        if (this.Rke == 0)
        {
          f3 = f1 / this.Rkd;
          i = (int)(f2 / f1 * this.Rkd);
          f1 = f3;
          f2 = f3;
          break label261;
        }
        f1 /= this.Rkd;
        f2 /= this.Rke;
        break label261;
        label420:
        localObject = new Rect(0, 0, getWidth(), getHeight());
        this.Rkb.draw(paramCanvas, (Rect)localObject, this.paint);
      }
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(206182);
  }
  
  public void setEraseEdge(boolean paramBoolean)
  {
    this.Rkf = paramBoolean;
  }
  
  public void setNinePatchId(int paramInt)
  {
    AppMethodBeat.i(206179);
    Bitmap localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt);
    if (localBitmap != null) {
      this.Rkb = new NinePatch(localBitmap, localBitmap.getNinePatchChunk(), null);
    }
    AppMethodBeat.o(206179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.NinePatchCropImageView
 * JD-Core Version:    0.7.0.1
 */