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
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;

public class NinePatchCropImageView
  extends AppCompatImageView
{
  private RectF GrG;
  private NinePatch YLG;
  private Drawable YLH;
  private int YLI;
  private int YLJ;
  private boolean YLK;
  private Paint paint;
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220108);
    this.paint = new Paint();
    this.YLG = null;
    this.YLH = null;
    this.YLI = 0;
    this.YLJ = 0;
    this.GrG = null;
    this.YLK = true;
    init();
    AppMethodBeat.o(220108);
  }
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220112);
    this.paint = new Paint();
    this.YLG = null;
    this.YLH = null;
    this.YLI = 0;
    this.YLJ = 0;
    this.GrG = null;
    this.YLK = true;
    init();
    AppMethodBeat.o(220112);
  }
  
  private void init()
  {
    AppMethodBeat.i(220114);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.paint.setAntiAlias(true);
    this.YLH = getResources().getDrawable(a.d.BW_90);
    AppMethodBeat.o(220114);
  }
  
  public final void nq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220117);
    this.YLI = paramInt1;
    this.YLJ = paramInt2;
    invalidate();
    AppMethodBeat.o(220117);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(220128);
    if (this.YLG != null)
    {
      int k = paramCanvas.saveLayer(null, null);
      if (this.YLH != null)
      {
        this.YLH.setBounds(0, 0, getWidth(), getHeight());
        this.YLH.draw(paramCanvas);
      }
      Object localObject;
      if ((this.GrG != null) && (this.YLK))
      {
        localObject = this.GrG;
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
      if (this.GrG == null)
      {
        f1 = getWidth();
        if (this.GrG != null) {
          break label353;
        }
        f2 = getHeight();
        if (((this.YLJ == 0) && (this.YLI == 0)) || (f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label420;
        }
        int j = this.YLI;
        i = this.YLJ;
        if (this.YLI != 0) {
          break label364;
        }
        f3 = f2 / this.YLJ;
        j = (int)(f1 / f2 * this.YLJ);
        f1 = f3;
        f2 = f3;
        label261:
        paramCanvas.save();
        if (this.GrG != null) {
          paramCanvas.translate(this.GrG.left, this.GrG.top);
        }
        paramCanvas.scale(f1, f2);
        localObject = new Rect(0, 0, j, i);
        this.YLG.draw(paramCanvas, (Rect)localObject, this.paint);
        paramCanvas.restore();
      }
      for (;;)
      {
        paramCanvas.restoreToCount(k);
        AppMethodBeat.o(220128);
        return;
        f1 = this.GrG.width();
        break;
        label353:
        f2 = this.GrG.height();
        break label189;
        label364:
        if (this.YLJ == 0)
        {
          f3 = f1 / this.YLI;
          i = (int)(f2 / f1 * this.YLI);
          f1 = f3;
          f2 = f3;
          break label261;
        }
        f1 /= this.YLI;
        f2 /= this.YLJ;
        break label261;
        label420:
        localObject = new Rect(0, 0, getWidth(), getHeight());
        this.YLG.draw(paramCanvas, (Rect)localObject, this.paint);
      }
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(220128);
  }
  
  public void setEraseEdge(boolean paramBoolean)
  {
    this.YLK = paramBoolean;
  }
  
  public void setNinePatchId(int paramInt)
  {
    AppMethodBeat.i(220116);
    Bitmap localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt);
    if (localBitmap != null) {
      this.YLG = new NinePatch(localBitmap, localBitmap.getNinePatchChunk(), null);
    }
    AppMethodBeat.o(220116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.NinePatchCropImageView
 * JD-Core Version:    0.7.0.1
 */