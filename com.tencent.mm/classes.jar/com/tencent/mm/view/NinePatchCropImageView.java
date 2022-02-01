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
  private RectF ClP;
  private NinePatch LLM;
  private Drawable LLN;
  private int LLO;
  private int LLP;
  private boolean LLQ;
  private Paint paint;
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193814);
    this.paint = new Paint();
    this.LLM = null;
    this.LLN = null;
    this.LLO = 0;
    this.LLP = 0;
    this.ClP = null;
    this.LLQ = true;
    init();
    AppMethodBeat.o(193814);
  }
  
  public NinePatchCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193815);
    this.paint = new Paint();
    this.LLM = null;
    this.LLN = null;
    this.LLO = 0;
    this.LLP = 0;
    this.ClP = null;
    this.LLQ = true;
    init();
    AppMethodBeat.o(193815);
  }
  
  private void init()
  {
    AppMethodBeat.i(193816);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.paint.setAntiAlias(true);
    this.LLN = getResources().getDrawable(2131099678);
    AppMethodBeat.o(193816);
  }
  
  public final void kB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193818);
    this.LLO = paramInt1;
    this.LLP = paramInt2;
    invalidate();
    AppMethodBeat.o(193818);
  }
  
  public final void m(RectF paramRectF)
  {
    AppMethodBeat.i(193819);
    this.ClP = new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
    AppMethodBeat.o(193819);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193820);
    if (this.LLM != null)
    {
      int k = paramCanvas.saveLayer(null, null);
      if (this.LLN != null)
      {
        this.LLN.setBounds(0, 0, getWidth(), getHeight());
        this.LLN.draw(paramCanvas);
      }
      Object localObject;
      if ((this.ClP != null) && (this.LLQ))
      {
        localObject = this.ClP;
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
      if (this.ClP == null)
      {
        f1 = getWidth();
        if (this.ClP != null) {
          break label353;
        }
        f2 = getHeight();
        if (((this.LLP == 0) && (this.LLO == 0)) || (f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label420;
        }
        int j = this.LLO;
        i = this.LLP;
        if (this.LLO != 0) {
          break label364;
        }
        f3 = f2 / this.LLP;
        j = (int)(f1 / f2 * this.LLP);
        f1 = f3;
        f2 = f3;
        label261:
        paramCanvas.save();
        if (this.ClP != null) {
          paramCanvas.translate(this.ClP.left, this.ClP.top);
        }
        paramCanvas.scale(f1, f2);
        localObject = new Rect(0, 0, j, i);
        this.LLM.draw(paramCanvas, (Rect)localObject, this.paint);
        paramCanvas.restore();
      }
      for (;;)
      {
        paramCanvas.restoreToCount(k);
        AppMethodBeat.o(193820);
        return;
        f1 = this.ClP.width();
        break;
        label353:
        f2 = this.ClP.height();
        break label189;
        label364:
        if (this.LLP == 0)
        {
          f3 = f1 / this.LLO;
          i = (int)(f2 / f1 * this.LLO);
          f1 = f3;
          f2 = f3;
          break label261;
        }
        f1 /= this.LLO;
        f2 /= this.LLP;
        break label261;
        label420:
        localObject = new Rect(0, 0, getWidth(), getHeight());
        this.LLM.draw(paramCanvas, (Rect)localObject, this.paint);
      }
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(193820);
  }
  
  public void setEraseEdge(boolean paramBoolean)
  {
    this.LLQ = paramBoolean;
  }
  
  public void setNinePatchId(int paramInt)
  {
    AppMethodBeat.i(193817);
    Bitmap localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt);
    if (localBitmap != null) {
      this.LLM = new NinePatch(localBitmap, localBitmap.getNinePatchChunk(), null);
    }
    AppMethodBeat.o(193817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.NinePatchCropImageView
 * JD-Core Version:    0.7.0.1
 */