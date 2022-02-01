package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "slimWidth", "", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "FIX_PADDING", "", "bitmap", "Landroid/graphics/Bitmap;", "color", "", "hasSelected", "mDoodlePaint", "Landroid/graphics/Paint;", "radius", "getSlimWidth", "()Z", "setSlimWidth", "(Z)V", "type", "getType", "()I", "setType", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBitmap", "setDrawColor", "setHasSelected", "select", "plugin-recordvideo_release"})
public final class a
  extends View
{
  private final float BSN;
  private boolean BSO;
  private Bitmap bitmap;
  private int color;
  private final Paint hog;
  private int radius;
  private int type;
  boolean yLb;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null);
    AppMethodBeat.i(237370);
    this.BSO = paramBoolean;
    this.hog = new Paint(1);
    this.radius = com.tencent.mm.cb.a.fromDPToPix(paramContext, 7);
    this.BSN = com.tencent.mm.cb.a.fromDPToPix(paramContext, 2);
    this.hog.setStyle(Paint.Style.FILL);
    this.hog.setStrokeCap(Paint.Cap.ROUND);
    this.hog.setAntiAlias(true);
    this.hog.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(237370);
  }
  
  public final boolean getSlimWidth()
  {
    return this.BSO;
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
    this.hog.setColor(-1);
    int i = getWidth();
    if (!this.yLb) {
      i = getWidth() - (int)this.BSN * 2;
    }
    paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, i / 2.0F, this.hog);
    if (this.bitmap != null)
    {
      Bitmap localBitmap = this.bitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        float f = this.radius;
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          p.hyc();
        }
        f = f * 2.0F / localBitmap.getWidth();
        this.bitmap = BitmapUtil.rotateAndScale(this.bitmap, 0.0F, f, f);
        i = getWidth();
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          p.hyc();
        }
        f = (i - localBitmap.getWidth()) / 2.0F;
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          p.hyc();
        }
        paramCanvas.drawBitmap(localBitmap, f, f, this.hog);
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(75717);
      return;
      if (this.color != 0)
      {
        this.hog.setColor(this.color);
        if (this.BSO) {
          this.radius = ((getWidth() - com.tencent.mm.cb.a.fromDPToPix(getContext(), 8)) / 2);
        }
        paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, this.radius, this.hog);
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
    if (this.yLb != paramBoolean)
    {
      this.yLb = paramBoolean;
      invalidate();
    }
    AppMethodBeat.o(75719);
  }
  
  public final void setSlimWidth(boolean paramBoolean)
  {
    this.BSO = paramBoolean;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.a
 * JD-Core Version:    0.7.0.1
 */