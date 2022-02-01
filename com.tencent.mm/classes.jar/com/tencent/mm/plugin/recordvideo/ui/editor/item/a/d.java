package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/CaptionEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;)V", "bitmapPaint", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "captionItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "hasContent", "", "scale", "", "screenWidth", "", "seekTime", "", "showBitmap", "Landroid/graphics/Bitmap;", "transMatrix", "Landroid/graphics/Matrix;", "destroy", "", "draw", "paint", "getScale", "matrix", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class d
  extends a
{
  private final c Can;
  private com.tencent.mm.plugin.recordvideo.ui.editor.a Cgo;
  private Matrix Cgp;
  private boolean Cgq;
  private Canvas aTi;
  private Paint aYz;
  private int mEX;
  private final float scale;
  
  public d(c paramc)
  {
    super(paramc.gT);
    AppMethodBeat.i(237857);
    this.Can = paramc;
    this.aYz = new Paint();
    paramc = MMApplicationContext.getContext();
    p.g(paramc, "MMApplicationContext.getContext()");
    this.Cgo = new com.tencent.mm.plugin.recordvideo.ui.editor.a(paramc);
    this.mEX = au.az(MMApplicationContext.getContext()).x;
    this.Cgp = new Matrix();
    paramc = this.gT;
    float[] arrayOfFloat = new float[9];
    paramc.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    this.scale = ((float)Math.sqrt(d2 * d2 + d1 * d1));
    AppMethodBeat.o(237857);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(237855);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.Cgq)
    {
      paramCanvas.save();
      this.Cgp.reset();
      this.Cgp.postTranslate((this.mEX - this.Cgo.getMeasuredWidth() * this.scale) / 2.0F, 0.0F);
      paramCanvas.concat(this.Cgp);
      paramCanvas.concat(this.gT);
      this.Cgo.draw(paramCanvas);
      paramCanvas.restore();
    }
    AppMethodBeat.o(237855);
  }
  
  public final long eMv()
  {
    return 9223372036854775807L;
  }
  
  public final void init()
  {
    AppMethodBeat.i(237854);
    this.aYz.setAntiAlias(true);
    this.Cgo.setCaptionItem(this.Can);
    this.Cgo.setTag(this.Can);
    AppMethodBeat.o(237854);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(237856);
    super.seekTo(paramLong);
    Object localObject = this.aTi;
    if (localObject != null) {
      ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
    }
    if (this.Cgo.Ig(paramLong))
    {
      localObject = this.Cgo.Can;
      boolean bool;
      int i;
      if (localObject != null)
      {
        localObject = ((c)localObject).Ii(paramLong);
        if (localObject != null)
        {
          bool = ((sy)localObject).LaV;
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
        this.Cgq = true;
        this.Cgo.measure(0, 0);
        this.Cgo.layout(0, 0, this.Cgo.getMeasuredWidth(), this.Cgo.getMeasuredHeight());
        AppMethodBeat.o(237856);
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
    this.Cgq = false;
    AppMethodBeat.o(237856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.d
 * JD-Core Version:    0.7.0.1
 */