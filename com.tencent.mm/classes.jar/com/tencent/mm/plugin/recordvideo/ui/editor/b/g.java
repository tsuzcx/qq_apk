package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "retrieverData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;)V", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "finalBitmap", "finalCanvas", "finalMatrix", "paint", "Landroid/graphics/Paint;", "retrieverTransform", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "blurBgEnable", "", "calcCenterCropScale", "drawingWidth", "drawingHeight", "videoWidth", "", "videoHeight", "calcCenterCropScale2", "calcfinalScale", "drawWidth", "drawHeight", "destroy", "", "requestBlurBgFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "requestNextFrame", "start", "Companion", "plugin-recordvideo_release"})
public final class g
  implements b
{
  public static final g.a yfN;
  private final Canvas aTq;
  private final Bitmap bitmap;
  public Bitmap hqG;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b pYC;
  private final Paint paint;
  private Bitmap yfH;
  private Canvas yfI;
  private final Matrix yfJ;
  private final Matrix yfK;
  private e yfL;
  private final d yfM;
  
  static
  {
    AppMethodBeat.i(207080);
    yfN = new g.a((byte)0);
    AppMethodBeat.o(207080);
  }
  
  public g(d paramd)
  {
    AppMethodBeat.i(207079);
    this.yfM = paramd;
    this.paint = new Paint();
    this.yfJ = new Matrix();
    this.pYC = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.yfM.pYz);
    this.yfK = new Matrix();
    this.yfL = new e();
    ae.i("MicroMsg.StoryFrameRetriever", "create StoryFrameRetriever, " + this.yfM);
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    int m = this.yfM.width;
    int k = this.yfM.height;
    int i;
    Object localObject;
    float[] arrayOfFloat;
    int j;
    label243:
    float f1;
    switch (this.yfM.dHi)
    {
    default: 
      if (this.yfM.videoWidth > this.yfM.videoHeight)
      {
        i = 1;
        paramd = this.yfL;
        localObject = this.yfM.xKR;
        arrayOfFloat = this.yfM.xKS;
        p.h(localObject, "drawingRect");
        paramd.xKR = ((float[])localObject);
        if ((arrayOfFloat != null) && (arrayOfFloat.length == 4)) {
          break label820;
        }
        j = 0;
        if (j != 0)
        {
          if (arrayOfFloat == null) {
            p.gkB();
          }
          paramd.xKS = arrayOfFloat;
          f1 = arrayOfFloat[1];
          ae.i("MicroMsg.RetrieverTransform", "topOffset :".concat(String.valueOf(f1)));
          paramd.yfE.postTranslate(0.0F, -f1);
        }
        if (!dLy()) {
          break label952;
        }
        paramd = Bitmap.createBitmap(this.yfM.width, this.yfM.height, Bitmap.Config.ARGB_8888);
        p.g(paramd, "Bitmap.createBitmap(retr… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        f1 = a(this.yfM.width, this.yfM.height, this.yfM.xKR[2], this.yfM.xKR[3]);
        ae.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
        this.yfK.postScale(f1, f1);
        if ((this.yfM.yfC) && (i != 0) && ((this.yfM.dHi == 90) || (this.yfM.dHi == 270) || (this.yfM.dHi == 180)))
        {
          this.yfH = Bitmap.createBitmap(this.yfM.height, this.yfM.width, Bitmap.Config.ARGB_8888);
          this.yfI = new Canvas(this.yfH);
          f1 = 360.0F - this.yfM.dHi;
          this.yfJ.postRotate(f1);
          if (f1 != 90.0F) {
            break label868;
          }
          paramd = this.yfJ;
          localObject = this.yfI;
          if (localObject == null) {
            p.gkB();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        label543:
        paramd = h.d(this.yfM.xKW, this.yfM.height, this.yfM.width, true);
        if (paramd != null)
        {
          f1 = this.yfM.width / paramd.getWidth();
          float f2 = this.yfM.height / paramd.getHeight();
          if ((f1 == 1.0F) && (f2 == 1.0F)) {
            break label944;
          }
          float f3 = Math.max(f1, f2);
          paramd = h.b(paramd, 0.0F, f3, f3);
          p.g(paramd, "scaledBitmap");
          k = paramd.getWidth();
          i = paramd.getHeight();
          if (f1 >= f2) {
            break label910;
          }
          m = (paramd.getWidth() - this.yfM.width) / 2;
          k = m + this.yfM.width;
          j = 0;
          label688:
          this.hqG = Bitmap.createBitmap(paramd, m, j, k, i);
          label704:
          if ((this.yfM.yfC) && (this.yfM.dHi != 0)) {
            this.hqG = h.a(this.hqG, 360.0F - this.yfM.dHi);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.aTq = new Canvas(this.bitmap);
      AppMethodBeat.o(207079);
      return;
      k = this.yfM.width;
      m = this.yfM.height;
      if (this.yfM.videoHeight > this.yfM.videoWidth)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
      break;
      label820:
      if ((arrayOfFloat[0] == 0.0F) && (arrayOfFloat[1] == 0.0F) && (arrayOfFloat[2] == 0.0F) && (arrayOfFloat[3] == 0.0F))
      {
        j = 0;
        break label243;
      }
      j = 1;
      break label243;
      label868:
      if (f1 != 270.0F) {
        break label543;
      }
      paramd = this.yfJ;
      localObject = this.yfI;
      if (localObject == null) {
        p.gkB();
      }
      paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
      break label543;
      label910:
      j = (paramd.getHeight() - this.yfM.height) / 2;
      i = this.yfM.height + j;
      m = 0;
      break label688;
      label944:
      this.hqG = paramd;
      break label704;
      label952:
      if (this.yfM.yfC)
      {
        paramd = Bitmap.createBitmap(m, k, Bitmap.Config.ARGB_8888);
        p.g(paramd, "Bitmap.createBitmap(real… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        if ((this.yfM.dHi == 90) || (this.yfM.dHi == 270) || (this.yfM.dHi == 180))
        {
          this.yfH = Bitmap.createBitmap(this.yfM.width, this.yfM.height, Bitmap.Config.ARGB_8888);
          this.yfI = new Canvas(this.yfH);
          f1 = 360.0F - this.yfM.dHi;
          this.yfJ.postRotate(f1);
          if (f1 != 90.0F) {
            break label1175;
          }
          paramd = this.yfJ;
          localObject = this.yfI;
          if (localObject == null) {
            p.gkB();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        for (;;)
        {
          f1 = a(m, k, this.yfM.xKR[2], this.yfM.xKR[3]);
          ae.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
          this.yfK.postScale(f1, f1);
          break;
          if (f1 == 270.0F)
          {
            paramd = this.yfJ;
            localObject = this.yfI;
            if (localObject == null) {
              p.gkB();
            }
            paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
          }
        }
      }
      label1175:
      paramd = Bitmap.createBitmap(Math.min(this.yfM.width, this.yfM.height), Math.max(this.yfM.width, this.yfM.height), Bitmap.Config.ARGB_8888);
      p.g(paramd, "Bitmap.createBitmap(Math… Bitmap.Config.ARGB_8888)");
      this.bitmap = paramd;
      f1 = a(Math.min(this.yfM.width, this.yfM.height), Math.max(this.yfM.width, this.yfM.height), this.yfM.xKR[2], this.yfM.xKR[3]);
      ae.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
      this.yfK.postScale(f1, f1);
    }
  }
  
  private static float a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    float f = paramInt1 / paramFloat1;
    if (f == paramInt2 / paramFloat2) {
      paramFloat1 = f;
    }
    do
    {
      do
      {
        return paramFloat1;
        f = paramInt1 / paramFloat1;
        paramFloat2 = paramInt2 / paramFloat2;
        paramFloat1 = f;
      } while (paramInt1 > paramInt2);
      if (f < paramFloat2) {
        return paramFloat2;
      }
      paramFloat1 = f;
    } while (f > paramFloat2);
    return 1.0F;
  }
  
  public final a cls()
  {
    AppMethodBeat.i(207076);
    if (this.yfM.pYz.size() == 0)
    {
      AppMethodBeat.o(207076);
      return null;
    }
    int i = this.aTq.save();
    this.aTq.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aTq.concat(this.yfK);
    Object localObject = this.yfL;
    Canvas localCanvas = this.aTq;
    p.h(localCanvas, "canvas");
    ((e)localObject).yfD = localCanvas.save();
    localCanvas.concat(((e)localObject).yfE);
    try
    {
      l = this.pYC.a(this.aTq, this.paint);
      localObject = this.yfL;
      localCanvas = this.aTq;
      p.h(localCanvas, "canvas");
      if (((e)localObject).yfD <= 0)
      {
        ae.w("MicroMsg.RetrieverTransform", "canvas restore saveCount: " + ((e)localObject).yfD);
        if (i > 0) {
          break label340;
        }
        ae.w("MicroMsg.StoryFrameRetriever", "canvas restore saveCount: ".concat(String.valueOf(i)));
        if ((this.yfI == null) || (this.yfH == null)) {
          break label351;
        }
        localObject = this.yfI;
        if (localObject != null) {
          ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        localObject = this.yfI;
        if (localObject != null) {
          ((Canvas)localObject).save();
        }
        localObject = this.yfI;
        if (localObject == null) {
          p.gkB();
        }
        ((Canvas)localObject).drawBitmap(this.bitmap, this.yfJ, null);
        localObject = this.yfI;
        if (localObject != null) {
          ((Canvas)localObject).restore();
        }
        localObject = this.yfH;
        if (localObject == null) {
          p.gkB();
        }
        localObject = new a((Bitmap)localObject, l);
        AppMethodBeat.o(207076);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        l = 9223372036854775807L;
        continue;
        localCanvas.restoreToCount(localException.yfD);
        continue;
        label340:
        this.aTq.restoreToCount(i);
      }
      label351:
      a locala = new a(this.bitmap, l);
      AppMethodBeat.o(207076);
      return locala;
    }
  }
  
  public final boolean dLy()
  {
    AppMethodBeat.i(207075);
    if (((CharSequence)this.yfM.xKW).length() > 0) {}
    for (int i = 1; (i != 0) && (o.fB(this.yfM.xKW)); i = 0)
    {
      AppMethodBeat.o(207075);
      return true;
    }
    AppMethodBeat.o(207075);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(207078);
    try
    {
      Iterator localIterator = ((Iterable)this.yfM.pYz).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(207078);
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(207078);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(207077);
    try
    {
      Iterator localIterator = ((Iterable)this.yfM.pYz).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).init();
      }
      AppMethodBeat.o(207077);
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(207077);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.g
 * JD-Core Version:    0.7.0.1
 */