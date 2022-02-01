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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "slimWidth", "", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "FIX_PADDING", "", "bgPadding", "bitmap", "Landroid/graphics/Bitmap;", "color", "", "hasSelected", "mDoodlePaint", "Landroid/graphics/Paint;", "radius", "getSlimWidth", "()Z", "setSlimWidth", "(Z)V", "type", "getType", "()I", "setType", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBgPadding", "dp", "setBitmap", "setDrawColor", "setHasSelected", "select", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends View
{
  public boolean KhA;
  private boolean NMg;
  private final float NMh;
  private float NMi;
  private Bitmap bitmap;
  private int color;
  private final Paint mAa;
  private int radius;
  private int type;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null);
    AppMethodBeat.i(280594);
    this.NMg = paramBoolean;
    this.mAa = new Paint(1);
    this.radius = com.tencent.mm.cd.a.fromDPToPix(paramContext, 7);
    this.NMh = com.tencent.mm.cd.a.fromDPToPix(paramContext, 2);
    this.mAa.setStyle(Paint.Style.FILL);
    this.mAa.setStrokeCap(Paint.Cap.ROUND);
    this.mAa.setAntiAlias(true);
    this.mAa.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(280594);
  }
  
  public final boolean getSlimWidth()
  {
    return this.NMg;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75717);
    s.u(paramCanvas, "canvas");
    paramCanvas.drawColor(0);
    this.mAa.setColor(-1);
    int j = getWidth() - (int)this.NMi * 2;
    int i = j;
    if (!this.KhA) {
      i = j - (int)this.NMh * 2;
    }
    paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, i / 2.0F, this.mAa);
    if (this.bitmap != null)
    {
      Bitmap localBitmap = this.bitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        i = 1;
        if (i == 0) {
          break label225;
        }
        float f = this.radius;
        localBitmap = this.bitmap;
        s.checkNotNull(localBitmap);
        f = f * 2.0F / localBitmap.getWidth();
        this.bitmap = BitmapUtil.rotateAndScale(this.bitmap, 0.0F, f, f);
        i = getWidth();
        localBitmap = this.bitmap;
        s.checkNotNull(localBitmap);
        f = (i - localBitmap.getWidth()) / 2.0F;
        localBitmap = this.bitmap;
        s.checkNotNull(localBitmap);
        paramCanvas.drawBitmap(localBitmap, f, f, this.mAa);
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(75717);
      return;
      i = 0;
      break;
      label225:
      if (this.color != 0)
      {
        this.mAa.setColor(this.color);
        if (this.NMg) {
          this.radius = ((getWidth() - com.tencent.mm.cd.a.fromDPToPix(getContext(), 8)) / 2);
        }
        paramCanvas.drawCircle(getWidth() / 2.0F, getWidth() / 2.0F, this.radius, this.mAa);
      }
    }
  }
  
  public final void setBgPadding(int paramInt)
  {
    AppMethodBeat.i(280673);
    this.NMi = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(280673);
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75718);
    s.u(paramBitmap, "bitmap");
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
    if (this.KhA != paramBoolean)
    {
      this.KhA = paramBoolean;
      invalidate();
    }
    AppMethodBeat.o(75719);
  }
  
  public final void setSlimWidth(boolean paramBoolean)
  {
    this.NMg = paramBoolean;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.a
 * JD-Core Version:    0.7.0.1
 */