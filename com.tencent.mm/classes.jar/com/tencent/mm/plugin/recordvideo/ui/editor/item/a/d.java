package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/CaptionEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;)V", "bitmapPaint", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "hasContent", "", "scale", "", "screenWidth", "", "seekTime", "", "showBitmap", "Landroid/graphics/Bitmap;", "transMatrix", "Landroid/graphics/Matrix;", "destroy", "", "draw", "paint", "getScale", "matrix", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class d
  extends a
{
  private Canvas aTq;
  private Paint aYE;
  private int lxZ;
  private final float scale;
  private final c xZo;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a yfo;
  private Matrix yfp;
  private boolean yfq;
  
  public d(c paramc)
  {
    super(paramc.gR);
    AppMethodBeat.i(207016);
    this.xZo = paramc;
    this.aYE = new Paint();
    paramc = ak.getContext();
    p.g(paramc, "MMApplicationContext.getContext()");
    this.yfo = new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramc);
    this.lxZ = ar.ck(ak.getContext()).x;
    this.yfp = new Matrix();
    paramc = this.gR;
    float[] arrayOfFloat = new float[9];
    paramc.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    this.scale = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    AppMethodBeat.o(207016);
  }
  
  public final long dLx()
  {
    return 9223372036854775807L;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(207014);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.yfq)
    {
      paramCanvas.save();
      this.yfp.reset();
      this.yfp.postTranslate((this.lxZ - this.yfo.getMeasuredWidth() * this.scale) / 2.0F, 0.0F);
      paramCanvas.concat(this.yfp);
      paramCanvas.concat(this.gR);
      this.yfo.draw(paramCanvas);
      paramCanvas.restore();
    }
    AppMethodBeat.o(207014);
  }
  
  public final void init()
  {
    AppMethodBeat.i(207013);
    this.aYE.setAntiAlias(true);
    this.yfo.setCaptionItem(this.xZo);
    this.yfo.setTag(this.xZo);
    AppMethodBeat.o(207013);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(207015);
    super.seekTo(paramLong);
    Object localObject = this.aTq;
    if (localObject != null) {
      ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
    }
    if (this.yfo.zi(paramLong))
    {
      localObject = this.yfo.xZo;
      boolean bool;
      int i;
      if (localObject != null)
      {
        localObject = ((c)localObject).zk(paramLong);
        if (localObject != null)
        {
          bool = ((rv)localObject).Ggs;
          if (bool) {
            break label135;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label145;
        }
        this.yfq = true;
        this.yfo.measure(0, 0);
        this.yfo.layout(0, 0, this.yfo.getMeasuredWidth(), this.yfo.getMeasuredHeight());
        AppMethodBeat.o(207015);
        return;
        bool = true;
        break;
        label135:
        i = 0;
        continue;
        i = 0;
      }
    }
    label145:
    this.yfq = false;
    AppMethodBeat.o(207015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d
 * JD-Core Version:    0.7.0.1
 */