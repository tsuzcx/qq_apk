package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bitmap", "Landroid/graphics/Bitmap;", "color", "", "hasSelected", "", "getHasSelected", "()Z", "setHasSelected", "(Z)V", "mDoodlePaint", "Landroid/graphics/Paint;", "padding", "", "type", "getType", "()I", "setType", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBitmap", "setDrawColor", "plugin-recordvideo_release"})
public final class ClickBigImageView
  extends View
{
  private final float bTm;
  private Bitmap bitmap;
  private int color;
  private final Paint eFo;
  private boolean ofv;
  private int type;
  
  public ClickBigImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(150762);
    this.eFo = new Paint(1);
    this.bTm = 4.0F;
    this.eFo.setStyle(Paint.Style.FILL);
    this.eFo.setStrokeCap(Paint.Cap.ROUND);
    this.eFo.setAntiAlias(true);
    this.eFo.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(150762);
  }
  
  public final boolean getHasSelected()
  {
    return this.ofv;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(150760);
    j.q(paramCanvas, "canvas");
    this.eFo.setColor(-1);
    paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, getHeight() / 2.0F, this.eFo);
    if (this.bitmap != null)
    {
      Bitmap localBitmap = this.bitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        float f1 = getWidth();
        float f2 = this.bTm;
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          j.ebi();
        }
        f1 = (f1 - f2 * 2.0F) / localBitmap.getWidth();
        this.bitmap = d.b(this.bitmap, 0.0F, f1, f1);
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          j.ebi();
        }
        paramCanvas.drawBitmap(localBitmap, this.bTm, this.bTm, this.eFo);
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(150760);
      return;
      if (this.color != 0)
      {
        this.eFo.setColor(this.color);
        paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, getHeight() / 2.0F - this.bTm, this.eFo);
      }
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(150761);
    j.q(paramBitmap, "bitmap");
    this.bitmap = paramBitmap;
    AppMethodBeat.o(150761);
  }
  
  public final void setDrawColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setHasSelected(boolean paramBoolean)
  {
    this.ofv = paramBoolean;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView
 * JD-Core Version:    0.7.0.1
 */