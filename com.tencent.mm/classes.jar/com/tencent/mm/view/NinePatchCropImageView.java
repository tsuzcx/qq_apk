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
  private RectF MlJ;
  private NinePatch agHs;
  private Drawable agHt;
  private int agHu;
  private int agHv;
  private boolean agHw;
  private Paint paint;
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(234729);
    this.paint = new Paint();
    this.agHs = null;
    this.agHt = null;
    this.agHu = 0;
    this.agHv = 0;
    this.MlJ = null;
    this.agHw = true;
    init();
    AppMethodBeat.o(234729);
  }
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234732);
    this.paint = new Paint();
    this.agHs = null;
    this.agHt = null;
    this.agHu = 0;
    this.agHv = 0;
    this.MlJ = null;
    this.agHw = true;
    init();
    AppMethodBeat.o(234732);
  }
  
  private void init()
  {
    AppMethodBeat.i(234735);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.paint.setAntiAlias(true);
    this.agHt = getResources().getDrawable(a.d.BW_90);
    AppMethodBeat.o(234735);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(234750);
    if (this.agHs != null)
    {
      int k = paramCanvas.saveLayer(null, null);
      if (this.agHt != null)
      {
        this.agHt.setBounds(0, 0, getWidth(), getHeight());
        this.agHt.draw(paramCanvas);
      }
      Object localObject;
      if ((this.MlJ != null) && (this.agHw))
      {
        localObject = this.MlJ;
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
      if (this.MlJ == null)
      {
        f1 = getWidth();
        if (this.MlJ != null) {
          break label353;
        }
        f2 = getHeight();
        if (((this.agHv == 0) && (this.agHu == 0)) || (f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label420;
        }
        int j = this.agHu;
        i = this.agHv;
        if (this.agHu != 0) {
          break label364;
        }
        f3 = f2 / this.agHv;
        j = (int)(f1 / f2 * this.agHv);
        f1 = f3;
        f2 = f3;
        label261:
        paramCanvas.save();
        if (this.MlJ != null) {
          paramCanvas.translate(this.MlJ.left, this.MlJ.top);
        }
        paramCanvas.scale(f1, f2);
        localObject = new Rect(0, 0, j, i);
        this.agHs.draw(paramCanvas, (Rect)localObject, this.paint);
        paramCanvas.restore();
      }
      for (;;)
      {
        paramCanvas.restoreToCount(k);
        AppMethodBeat.o(234750);
        return;
        f1 = this.MlJ.width();
        break;
        label353:
        f2 = this.MlJ.height();
        break label189;
        label364:
        if (this.agHv == 0)
        {
          f3 = f1 / this.agHu;
          i = (int)(f2 / f1 * this.agHu);
          f1 = f3;
          f2 = f3;
          break label261;
        }
        f1 /= this.agHu;
        f2 /= this.agHv;
        break label261;
        label420:
        localObject = new Rect(0, 0, getWidth(), getHeight());
        this.agHs.draw(paramCanvas, (Rect)localObject, this.paint);
      }
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(234750);
  }
  
  public void setEraseEdge(boolean paramBoolean)
  {
    this.agHw = paramBoolean;
  }
  
  public void setNinePatchId(int paramInt)
  {
    AppMethodBeat.i(234739);
    Bitmap localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt);
    if (localBitmap != null) {
      this.agHs = new NinePatch(localBitmap, localBitmap.getNinePatchChunk(), null);
    }
    AppMethodBeat.o(234739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.NinePatchCropImageView
 * JD-Core Version:    0.7.0.1
 */