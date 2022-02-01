package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/CaptionEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;)V", "bitmapPaint", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "hasContent", "", "scale", "", "screenWidth", "", "seekTime", "", "showBitmap", "Landroid/graphics/Bitmap;", "transMatrix", "Landroid/graphics/Matrix;", "destroy", "", "draw", "paint", "getScale", "matrix", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class d
  extends a
{
  private Canvas aTq;
  private Paint aYE;
  private int ltA;
  private final float scale;
  private final c xJt;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a xPv;
  private Matrix xPw;
  private boolean xPx;
  
  public d(c paramc)
  {
    super(paramc.gR);
    AppMethodBeat.i(200758);
    this.xJt = paramc;
    this.aYE = new Paint();
    paramc = aj.getContext();
    p.g(paramc, "MMApplicationContext.getContext()");
    this.xPv = new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramc);
    this.ltA = ar.ci(aj.getContext()).x;
    this.xPw = new Matrix();
    paramc = this.gR;
    float[] arrayOfFloat = new float[9];
    paramc.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    this.scale = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    AppMethodBeat.o(200758);
  }
  
  public final long dIg()
  {
    return 9223372036854775807L;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(200756);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.xPx)
    {
      paramCanvas.save();
      this.xPw.reset();
      this.xPw.postTranslate((this.ltA - this.xPv.getMeasuredWidth() * this.scale) / 2.0F, 0.0F);
      paramCanvas.concat(this.xPw);
      paramCanvas.concat(this.gR);
      this.xPv.draw(paramCanvas);
      paramCanvas.restore();
    }
    AppMethodBeat.o(200756);
  }
  
  public final void init()
  {
    AppMethodBeat.i(200755);
    this.aYE.setAntiAlias(true);
    this.xPv.setCaptionItem(this.xJt);
    this.xPv.setTag(this.xJt);
    AppMethodBeat.o(200755);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(200757);
    super.seekTo(paramLong);
    Object localObject = this.aTq;
    if (localObject != null) {
      ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
    }
    if (this.xPv.yJ(paramLong))
    {
      localObject = this.xPv.xJt;
      boolean bool;
      int i;
      if (localObject != null)
      {
        localObject = ((c)localObject).yM(paramLong);
        if (localObject != null)
        {
          bool = ((rt)localObject).FNT;
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
        this.xPx = true;
        this.xPv.measure(0, 0);
        this.xPv.layout(0, 0, this.xPv.getMeasuredWidth(), this.xPv.getMeasuredHeight());
        AppMethodBeat.o(200757);
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
    this.xPx = false;
    AppMethodBeat.o(200757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d
 * JD-Core Version:    0.7.0.1
 */