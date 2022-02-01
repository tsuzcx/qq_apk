package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "FIX_PADDING", "", "bitmap", "Landroid/graphics/Bitmap;", "color", "", "hasSelected", "", "mDoodlePaint", "Landroid/graphics/Paint;", "radius", "type", "getType", "()I", "setType", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBitmap", "setDrawColor", "setHasSelected", "select", "plugin-recordvideo_release"})
public final class ClickBigImageView
  extends View
{
  private Bitmap bitmap;
  private int color;
  private final Paint gyK;
  private final int radius;
  private int type;
  boolean vff;
  private final float xCF;
  
  public ClickBigImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75720);
    this.gyK = new Paint(1);
    this.radius = a.fromDPToPix(paramContext, 7);
    this.xCF = a.fromDPToPix(paramContext, 2);
    this.gyK.setStyle(Paint.Style.FILL);
    this.gyK.setStrokeCap(Paint.Cap.ROUND);
    this.gyK.setAntiAlias(true);
    this.gyK.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(75720);
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75717);
    p.h(paramCanvas, "canvas");
    paramCanvas.drawColor(0);
    this.gyK.setColor(-1);
    int i = getWidth();
    if (!this.vff) {
      i = getWidth() - (int)this.xCF * 2;
    }
    paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, i / 2.0F, this.gyK);
    if (this.bitmap != null)
    {
      Bitmap localBitmap = this.bitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        float f = this.radius;
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          p.gfZ();
        }
        f = f * 2.0F / localBitmap.getWidth();
        this.bitmap = g.b(this.bitmap, 0.0F, f, f);
        i = getWidth();
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          p.gfZ();
        }
        f = (i - localBitmap.getWidth()) / 2.0F;
        paramCanvas.drawBitmap(this.bitmap, f, f, this.gyK);
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(75717);
      return;
      if (this.color != 0)
      {
        this.gyK.setColor(this.color);
        paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, this.radius, this.gyK);
      }
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75718);
    p.h(paramBitmap, "bitmap");
    this.bitmap = paramBitmap;
    AppMethodBeat.o(75718);
  }
  
  public final void setDrawColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setHasSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(75719);
    if (this.vff != paramBoolean)
    {
      this.vff = paramBoolean;
      invalidate();
    }
    AppMethodBeat.o(75719);
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView
 * JD-Core Version:    0.7.0.1
 */