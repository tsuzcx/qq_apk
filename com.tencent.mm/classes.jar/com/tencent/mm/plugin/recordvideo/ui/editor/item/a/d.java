package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/CaptionEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;)V", "bitmapPaint", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "hasContent", "", "scale", "", "screenWidth", "", "seekTime", "", "showBitmap", "Landroid/graphics/Bitmap;", "transMatrix", "Landroid/graphics/Matrix;", "destroy", "", "draw", "paint", "getScale", "matrix", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class d
  extends a
{
  private final c HXc;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a Ide;
  private Matrix Idf;
  private boolean Idg;
  private Canvas aBC;
  private Paint aHU;
  private int pEj;
  private final float scale;
  
  public d(c paramc)
  {
    super(paramc.aHZ);
    AppMethodBeat.i(218526);
    this.HXc = paramc;
    this.aHU = new Paint();
    paramc = MMApplicationContext.getContext();
    p.j(paramc, "MMApplicationContext.getContext()");
    this.Ide = new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramc);
    this.pEj = ax.au(MMApplicationContext.getContext()).x;
    this.Idf = new Matrix();
    paramc = fyW();
    float[] arrayOfFloat = new float[9];
    paramc.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    this.scale = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    AppMethodBeat.o(218526);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(218524);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    if (this.Idg)
    {
      paramCanvas.save();
      this.Idf.reset();
      this.Idf.postTranslate((this.pEj - this.Ide.getMeasuredWidth() * this.scale) / 2.0F, 0.0F);
      paramCanvas.concat(this.Idf);
      paramCanvas.concat(fyW());
      this.Ide.draw(paramCanvas);
      paramCanvas.restore();
    }
    AppMethodBeat.o(218524);
  }
  
  public final long fyV()
  {
    return 9223372036854775807L;
  }
  
  public final void init()
  {
    AppMethodBeat.i(218523);
    this.aHU.setAntiAlias(true);
    this.Ide.setCaptionItem(this.HXc);
    this.Ide.setTag(this.HXc);
    AppMethodBeat.o(218523);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(218525);
    super.seekTo(paramLong);
    Object localObject = this.aBC;
    if (localObject != null) {
      ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
    }
    if (this.Ide.PA(paramLong))
    {
      localObject = this.Ide.HXc;
      boolean bool;
      int i;
      if (localObject != null)
      {
        localObject = ((c)localObject).PB(paramLong);
        if (localObject != null)
        {
          bool = ((ta)localObject).Sch;
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
        this.Idg = true;
        this.Ide.measure(0, 0);
        this.Ide.layout(0, 0, this.Ide.getMeasuredWidth(), this.Ide.getMeasuredHeight());
        AppMethodBeat.o(218525);
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
    this.Idg = false;
    AppMethodBeat.o(218525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d
 * JD-Core Version:    0.7.0.1
 */