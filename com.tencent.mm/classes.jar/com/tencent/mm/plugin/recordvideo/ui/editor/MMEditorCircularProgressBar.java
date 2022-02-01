package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public class MMEditorCircularProgressBar
  extends View
{
  private int duration;
  private boolean gEz;
  private boolean isStart;
  private float knu;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  private boolean vUA;
  private boolean vUB;
  private boolean vUC;
  private int vUm;
  private int vUn;
  private int vUo;
  private RectF vUp;
  private Paint vUq;
  private Paint vUr;
  private int vUs;
  private float vUt;
  private int vUu;
  private ArrayList<Float> vUy;
  private ArrayList<Float> vUz;
  private a xMJ;
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200238);
    this.vUm = Color.parseColor("#1AAD19");
    this.vUn = Color.parseColor("#FFFFFF");
    this.vUo = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.vUs = 153;
    this.vUt = 0.0F;
    this.vUu = 0;
    this.knu = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.vUy = new ArrayList();
    this.vUz = new ArrayList();
    this.vUA = false;
    this.vUB = false;
    this.vUC = false;
    this.gEz = false;
    this.mContext = paramContext;
    AppMethodBeat.o(200238);
  }
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200239);
    this.vUm = Color.parseColor("#1AAD19");
    this.vUn = Color.parseColor("#FFFFFF");
    this.vUo = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.vUs = 153;
    this.vUt = 0.0F;
    this.vUu = 0;
    this.knu = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.vUy = new ArrayList();
    this.vUz = new ArrayList();
    this.vUA = false;
    this.vUB = false;
    this.vUC = false;
    this.gEz = false;
    this.mContext = paramContext;
    AppMethodBeat.o(200239);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(200241);
    int i = (int)this.vUp.width();
    AppMethodBeat.o(200241);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.vUy;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200248);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.vUp.right / 2.0F, this.vUp.bottom / 2.0F);
    if (this.vUA)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.vUy.size())
      {
        if ((this.vUC) && (i == this.vUy.size() - 1)) {
          paramCanvas.drawArc(this.vUp, 90.0F + f / this.knu * 360.0F, (((Float)this.vUy.get(i)).floatValue() - f) / this.knu * 360.0F, false, this.vUr);
        }
        for (;;)
        {
          f = ((Float)this.vUy.get(i)).floatValue();
          paramCanvas.drawArc(this.vUp, 90.0F + (f - 0.85F) / this.knu * 360.0F, 0.85F / this.knu * 360.0F, false, this.vUq);
          i += 1;
          break;
          paramCanvas.drawArc(this.vUp, 90.0F + f / this.knu * 360.0F, (((Float)this.vUy.get(i)).floatValue() - f) / this.knu * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.vUp, 90.0F + f / this.knu * 360.0F, (this.vUt - f) / this.knu * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(200248);
      return;
      paramCanvas.drawArc(this.vUp, 90.0F, this.vUt / this.knu * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200240);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.gEz)
    {
      this.gEz = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(2131166581);
      this.offset = (this.strokeWidth / 2.0F);
      this.vUp = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.vUm);
      this.paint.setAlpha(this.vUs);
      this.paint.setAntiAlias(true);
      this.vUq = new Paint();
      this.vUq.setStyle(Paint.Style.STROKE);
      this.vUq.setStrokeWidth(this.strokeWidth);
      this.vUq.setColor(this.vUn);
      this.vUq.setAlpha(this.vUs);
      this.vUq.setAntiAlias(true);
      this.vUr = new Paint();
      this.vUr.setStyle(Paint.Style.STROKE);
      this.vUr.setStrokeWidth(this.strokeWidth);
      this.vUr.setColor(this.vUo);
      this.vUr.setAntiAlias(true);
    }
    AppMethodBeat.o(200240);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(200247);
    this.vUm = paramInt;
    this.vUs = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(200247);
  }
  
  public void setCurrentProgress(float paramFloat)
  {
    AppMethodBeat.i(200246);
    this.vUt = paramFloat;
    invalidate();
    AppMethodBeat.o(200246);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(200244);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(200244);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(200242);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vUA = paramBoolean;
    AppMethodBeat.o(200242);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(200245);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.vUu = paramInt;
    }
    AppMethodBeat.o(200245);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(200243);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Float.valueOf(paramFloat) });
    this.knu = paramFloat;
    AppMethodBeat.o(200243);
  }
  
  public void setProgressCallback(a parama)
  {
    this.xMJ = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */