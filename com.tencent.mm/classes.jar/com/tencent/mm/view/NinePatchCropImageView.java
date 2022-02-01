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
  private RectF BUo;
  private NinePatch Lpb;
  private Drawable Lpc;
  private int Lpd;
  private int Lpe;
  private boolean Lpf;
  private Paint paint;
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(186556);
    this.paint = new Paint();
    this.Lpb = null;
    this.Lpc = null;
    this.Lpd = 0;
    this.Lpe = 0;
    this.BUo = null;
    this.Lpf = true;
    init();
    AppMethodBeat.o(186556);
  }
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186557);
    this.paint = new Paint();
    this.Lpb = null;
    this.Lpc = null;
    this.Lpd = 0;
    this.Lpe = 0;
    this.BUo = null;
    this.Lpf = true;
    init();
    AppMethodBeat.o(186557);
  }
  
  private void init()
  {
    AppMethodBeat.i(186558);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.paint.setAntiAlias(true);
    this.Lpc = getResources().getDrawable(2131099678);
    AppMethodBeat.o(186558);
  }
  
  public final void ku(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186560);
    this.Lpd = paramInt1;
    this.Lpe = paramInt2;
    invalidate();
    AppMethodBeat.o(186560);
  }
  
  public final void m(RectF paramRectF)
  {
    AppMethodBeat.i(186561);
    this.BUo = new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
    AppMethodBeat.o(186561);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(186562);
    if (this.Lpb != null)
    {
      int k = paramCanvas.saveLayer(null, null);
      if (this.Lpc != null)
      {
        this.Lpc.setBounds(0, 0, getWidth(), getHeight());
        this.Lpc.draw(paramCanvas);
      }
      Object localObject;
      if ((this.BUo != null) && (this.Lpf))
      {
        localObject = this.BUo;
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
      if (this.BUo == null)
      {
        f1 = getWidth();
        if (this.BUo != null) {
          break label353;
        }
        f2 = getHeight();
        if (((this.Lpe == 0) && (this.Lpd == 0)) || (f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label420;
        }
        int j = this.Lpd;
        i = this.Lpe;
        if (this.Lpd != 0) {
          break label364;
        }
        f3 = f2 / this.Lpe;
        j = (int)(f1 / f2 * this.Lpe);
        f1 = f3;
        f2 = f3;
        label261:
        paramCanvas.save();
        if (this.BUo != null) {
          paramCanvas.translate(this.BUo.left, this.BUo.top);
        }
        paramCanvas.scale(f1, f2);
        localObject = new Rect(0, 0, j, i);
        this.Lpb.draw(paramCanvas, (Rect)localObject, this.paint);
        paramCanvas.restore();
      }
      for (;;)
      {
        paramCanvas.restoreToCount(k);
        AppMethodBeat.o(186562);
        return;
        f1 = this.BUo.width();
        break;
        label353:
        f2 = this.BUo.height();
        break label189;
        label364:
        if (this.Lpe == 0)
        {
          f3 = f1 / this.Lpd;
          i = (int)(f2 / f1 * this.Lpd);
          f1 = f3;
          f2 = f3;
          break label261;
        }
        f1 /= this.Lpd;
        f2 /= this.Lpe;
        break label261;
        label420:
        localObject = new Rect(0, 0, getWidth(), getHeight());
        this.Lpb.draw(paramCanvas, (Rect)localObject, this.paint);
      }
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(186562);
  }
  
  public void setEraseEdge(boolean paramBoolean)
  {
    this.Lpf = paramBoolean;
  }
  
  public void setNinePatchId(int paramInt)
  {
    AppMethodBeat.i(186559);
    Bitmap localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt);
    if (localBitmap != null) {
      this.Lpb = new NinePatch(localBitmap, localBitmap.getNinePatchChunk(), null);
    }
    AppMethodBeat.o(186559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.NinePatchCropImageView
 * JD-Core Version:    0.7.0.1
 */