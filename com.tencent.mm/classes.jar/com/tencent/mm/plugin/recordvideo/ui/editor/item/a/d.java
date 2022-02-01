package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/CaptionEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;)V", "bitmapPaint", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "hasContent", "", "scale", "", "screenWidth", "", "seekTime", "", "showBitmap", "Landroid/graphics/Bitmap;", "transMatrix", "Landroid/graphics/Matrix;", "destroy", "", "draw", "paint", "getScale", "matrix", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  private final c NTN;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a NZA;
  private Matrix NZB;
  private boolean NZC;
  private Paint bitmapPaint;
  private Canvas cxr;
  private int sJv;
  private final float scale;
  
  public d(c paramc)
  {
    super(paramc.matrix);
    AppMethodBeat.i(280396);
    this.NTN = paramc;
    this.bitmapPaint = new Paint();
    paramc = MMApplicationContext.getContext();
    s.s(paramc, "getContext()");
    this.NZA = new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramc);
    this.sJv = bf.bf(MMApplicationContext.getContext()).x;
    this.NZB = new Matrix();
    paramc = getMatrix();
    float[] arrayOfFloat = new float[9];
    paramc.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    this.scale = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    AppMethodBeat.o(280396);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(280411);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    if (this.NZC)
    {
      paramCanvas.save();
      this.NZB.reset();
      this.NZB.postTranslate((this.sJv - this.NZA.getMeasuredWidth() * this.scale) / 2.0F, 0.0F);
      paramCanvas.concat(this.NZB);
      paramCanvas.concat(getMatrix());
      this.NZA.draw(paramCanvas);
      paramCanvas.restore();
    }
    AppMethodBeat.o(280411);
  }
  
  public final long gKI()
  {
    return 9223372036854775807L;
  }
  
  public final void init()
  {
    AppMethodBeat.i(280403);
    this.bitmapPaint.setAntiAlias(true);
    this.NZA.setCaptionItem(this.NTN);
    this.NZA.setTag(this.NTN);
    AppMethodBeat.o(280403);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(280418);
    super.seekTo(paramLong);
    Object localObject = this.cxr;
    if (localObject != null) {
      ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
    }
    if (this.NZA.tA(paramLong))
    {
      localObject = this.NZA.NTN;
      boolean bool;
      int i;
      if (localObject != null)
      {
        localObject = ((c)localObject).tB(paramLong);
        if (localObject == null)
        {
          bool = true;
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
        this.NZC = true;
        this.NZA.measure(0, 0);
        this.NZA.layout(0, 0, this.NZA.getMeasuredWidth(), this.NZA.getMeasuredHeight());
        AppMethodBeat.o(280418);
        return;
        bool = ((uq)localObject).YZZ;
        break;
        label135:
        i = 0;
        continue;
        i = 0;
      }
    }
    label145:
    this.NZC = false;
    AppMethodBeat.o(280418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d
 * JD-Core Version:    0.7.0.1
 */