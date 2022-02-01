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
import com.tencent.mm.sdk.platformtools.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "FIX_PADDING", "", "bitmap", "Landroid/graphics/Bitmap;", "color", "", "hasSelected", "", "mDoodlePaint", "Landroid/graphics/Paint;", "radius", "type", "getType", "()I", "setType", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBitmap", "setDrawColor", "setHasSelected", "select", "plugin-recordvideo_release"})
public final class ClickBigImageView
  extends View
{
  private Bitmap bitmap;
  private int color;
  private final Paint gfa;
  private final int radius;
  private int type;
  boolean ucv;
  private final float wuJ;
  
  public ClickBigImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75720);
    this.gfa = new Paint(1);
    this.radius = a.fromDPToPix(paramContext, 7);
    this.wuJ = a.fromDPToPix(paramContext, 2);
    this.gfa.setStyle(Paint.Style.FILL);
    this.gfa.setStrokeCap(Paint.Cap.ROUND);
    this.gfa.setAntiAlias(true);
    this.gfa.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(75720);
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75717);
    k.h(paramCanvas, "canvas");
    paramCanvas.drawColor(0);
    this.gfa.setColor(-1);
    int i = getWidth();
    if (!this.ucv) {
      i = getWidth() - (int)this.wuJ * 2;
    }
    paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, i / 2.0F, this.gfa);
    if (this.bitmap != null)
    {
      Bitmap localBitmap = this.bitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        float f = this.radius;
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          k.fOy();
        }
        f = f * 2.0F / localBitmap.getWidth();
        this.bitmap = f.b(this.bitmap, 0.0F, f, f);
        i = getWidth();
        localBitmap = this.bitmap;
        if (localBitmap == null) {
          k.fOy();
        }
        f = (i - localBitmap.getWidth()) / 2.0F;
        paramCanvas.drawBitmap(this.bitmap, f, f, this.gfa);
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(75717);
      return;
      if (this.color != 0)
      {
        this.gfa.setColor(this.color);
        paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, this.radius, this.gfa);
      }
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75718);
    k.h(paramBitmap, "bitmap");
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
    if (this.ucv != paramBoolean)
    {
      this.ucv = paramBoolean;
      invalidate();
    }
    AppMethodBeat.o(75719);
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView
 * JD-Core Version:    0.7.0.1
 */