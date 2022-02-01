package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "retrieverData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;)V", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "finalBitmap", "finalCanvas", "finalMatrix", "paint", "Landroid/graphics/Paint;", "retrieverTransform", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "blurBgEnable", "", "calcCenterCropScale", "drawingWidth", "drawingHeight", "videoWidth", "", "videoHeight", "calcCenterCropScale2", "calcfinalScale", "drawWidth", "drawHeight", "destroy", "", "requestBlurBgFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "requestNextFrame", "start", "Companion", "plugin-recordvideo_release"})
public final class g
  implements b
{
  public static final g.a xPU;
  private final Canvas aTq;
  private final Bitmap bitmap;
  public Bitmap hnS;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b pRX;
  private final Paint paint;
  private Bitmap xPO;
  private Canvas xPP;
  private final Matrix xPQ;
  private final Matrix xPR;
  private e xPS;
  private final d xPT;
  
  static
  {
    AppMethodBeat.i(200822);
    xPU = new g.a((byte)0);
    AppMethodBeat.o(200822);
  }
  
  public g(d paramd)
  {
    AppMethodBeat.i(200821);
    this.xPT = paramd;
    this.paint = new Paint();
    this.xPQ = new Matrix();
    this.pRX = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.xPT.pRU);
    this.xPR = new Matrix();
    this.xPS = new e();
    ad.i("MicroMsg.StoryFrameRetriever", "create StoryFrameRetriever, " + this.xPT);
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    int m = this.xPT.width;
    int k = this.xPT.height;
    int i;
    Object localObject;
    float[] arrayOfFloat;
    int j;
    label243:
    float f1;
    switch (this.xPT.dGc)
    {
    default: 
      if (this.xPT.videoWidth > this.xPT.videoHeight)
      {
        i = 1;
        paramd = this.xPS;
        localObject = this.xPT.xuU;
        arrayOfFloat = this.xPT.xuV;
        p.h(localObject, "drawingRect");
        paramd.xuU = ((float[])localObject);
        if ((arrayOfFloat != null) && (arrayOfFloat.length == 4)) {
          break label820;
        }
        j = 0;
        if (j != 0)
        {
          if (arrayOfFloat == null) {
            p.gfZ();
          }
          paramd.xuV = arrayOfFloat;
          f1 = arrayOfFloat[1];
          ad.i("MicroMsg.RetrieverTransform", "topOffset :".concat(String.valueOf(f1)));
          paramd.xPL.postTranslate(0.0F, -f1);
        }
        if (!dIh()) {
          break label952;
        }
        paramd = Bitmap.createBitmap(this.xPT.width, this.xPT.height, Bitmap.Config.ARGB_8888);
        p.g(paramd, "Bitmap.createBitmap(retr… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        f1 = a(this.xPT.width, this.xPT.height, this.xPT.xuU[2], this.xPT.xuU[3]);
        ad.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
        this.xPR.postScale(f1, f1);
        if ((this.xPT.xPJ) && (i != 0) && ((this.xPT.dGc == 90) || (this.xPT.dGc == 270) || (this.xPT.dGc == 180)))
        {
          this.xPO = Bitmap.createBitmap(this.xPT.height, this.xPT.width, Bitmap.Config.ARGB_8888);
          this.xPP = new Canvas(this.xPO);
          f1 = 360.0F - this.xPT.dGc;
          this.xPQ.postRotate(f1);
          if (f1 != 90.0F) {
            break label868;
          }
          paramd = this.xPQ;
          localObject = this.xPP;
          if (localObject == null) {
            p.gfZ();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        label543:
        paramd = com.tencent.mm.sdk.platformtools.g.d(this.xPT.xuZ, this.xPT.height, this.xPT.width, true);
        if (paramd != null)
        {
          f1 = this.xPT.width / paramd.getWidth();
          float f2 = this.xPT.height / paramd.getHeight();
          if ((f1 == 1.0F) && (f2 == 1.0F)) {
            break label944;
          }
          float f3 = Math.max(f1, f2);
          paramd = com.tencent.mm.sdk.platformtools.g.b(paramd, 0.0F, f3, f3);
          p.g(paramd, "scaledBitmap");
          k = paramd.getWidth();
          i = paramd.getHeight();
          if (f1 >= f2) {
            break label910;
          }
          m = (paramd.getWidth() - this.xPT.width) / 2;
          k = m + this.xPT.width;
          j = 0;
          label688:
          this.hnS = Bitmap.createBitmap(paramd, m, j, k, i);
          label704:
          if ((this.xPT.xPJ) && (this.xPT.dGc != 0)) {
            this.hnS = com.tencent.mm.sdk.platformtools.g.a(this.hnS, 360.0F - this.xPT.dGc);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.aTq = new Canvas(this.bitmap);
      AppMethodBeat.o(200821);
      return;
      k = this.xPT.width;
      m = this.xPT.height;
      if (this.xPT.videoHeight > this.xPT.videoWidth)
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
      paramd = this.xPQ;
      localObject = this.xPP;
      if (localObject == null) {
        p.gfZ();
      }
      paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
      break label543;
      label910:
      j = (paramd.getHeight() - this.xPT.height) / 2;
      i = this.xPT.height + j;
      m = 0;
      break label688;
      label944:
      this.hnS = paramd;
      break label704;
      label952:
      if (this.xPT.xPJ)
      {
        paramd = Bitmap.createBitmap(m, k, Bitmap.Config.ARGB_8888);
        p.g(paramd, "Bitmap.createBitmap(real… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        if ((this.xPT.dGc == 90) || (this.xPT.dGc == 270) || (this.xPT.dGc == 180))
        {
          this.xPO = Bitmap.createBitmap(this.xPT.width, this.xPT.height, Bitmap.Config.ARGB_8888);
          this.xPP = new Canvas(this.xPO);
          f1 = 360.0F - this.xPT.dGc;
          this.xPQ.postRotate(f1);
          if (f1 != 90.0F) {
            break label1175;
          }
          paramd = this.xPQ;
          localObject = this.xPP;
          if (localObject == null) {
            p.gfZ();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        for (;;)
        {
          f1 = a(m, k, this.xPT.xuU[2], this.xPT.xuU[3]);
          ad.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
          this.xPR.postScale(f1, f1);
          break;
          if (f1 == 270.0F)
          {
            paramd = this.xPQ;
            localObject = this.xPP;
            if (localObject == null) {
              p.gfZ();
            }
            paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
          }
        }
      }
      label1175:
      paramd = Bitmap.createBitmap(Math.min(this.xPT.width, this.xPT.height), Math.max(this.xPT.width, this.xPT.height), Bitmap.Config.ARGB_8888);
      p.g(paramd, "Bitmap.createBitmap(Math… Bitmap.Config.ARGB_8888)");
      this.bitmap = paramd;
      f1 = a(Math.min(this.xPT.width, this.xPT.height), Math.max(this.xPT.width, this.xPT.height), this.xPT.xuU[2], this.xPT.xuU[3]);
      ad.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
      this.xPR.postScale(f1, f1);
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
  
  public final a ckc()
  {
    AppMethodBeat.i(200818);
    if (this.xPT.pRU.size() == 0)
    {
      AppMethodBeat.o(200818);
      return null;
    }
    int i = this.aTq.save();
    this.aTq.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aTq.concat(this.xPR);
    Object localObject = this.xPS;
    Canvas localCanvas = this.aTq;
    p.h(localCanvas, "canvas");
    ((e)localObject).xPK = localCanvas.save();
    localCanvas.concat(((e)localObject).xPL);
    try
    {
      l = this.pRX.a(this.aTq, this.paint);
      localObject = this.xPS;
      localCanvas = this.aTq;
      p.h(localCanvas, "canvas");
      if (((e)localObject).xPK <= 0)
      {
        ad.w("MicroMsg.RetrieverTransform", "canvas restore saveCount: " + ((e)localObject).xPK);
        if (i > 0) {
          break label340;
        }
        ad.w("MicroMsg.StoryFrameRetriever", "canvas restore saveCount: ".concat(String.valueOf(i)));
        if ((this.xPP == null) || (this.xPO == null)) {
          break label351;
        }
        localObject = this.xPP;
        if (localObject != null) {
          ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        localObject = this.xPP;
        if (localObject != null) {
          ((Canvas)localObject).save();
        }
        localObject = this.xPP;
        if (localObject == null) {
          p.gfZ();
        }
        ((Canvas)localObject).drawBitmap(this.bitmap, this.xPQ, null);
        localObject = this.xPP;
        if (localObject != null) {
          ((Canvas)localObject).restore();
        }
        localObject = this.xPO;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = new a((Bitmap)localObject, l);
        AppMethodBeat.o(200818);
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
        localCanvas.restoreToCount(localException.xPK);
        continue;
        label340:
        this.aTq.restoreToCount(i);
      }
      label351:
      a locala = new a(this.bitmap, l);
      AppMethodBeat.o(200818);
      return locala;
    }
  }
  
  public final boolean dIh()
  {
    AppMethodBeat.i(200817);
    if (((CharSequence)this.xPT.xuZ).length() > 0) {}
    for (int i = 1; (i != 0) && (i.fv(this.xPT.xuZ)); i = 0)
    {
      AppMethodBeat.o(200817);
      return true;
    }
    AppMethodBeat.o(200817);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(200820);
    try
    {
      Iterator localIterator = ((Iterable)this.xPT.pRU).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(200820);
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(200820);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(200819);
    try
    {
      Iterator localIterator = ((Iterable)this.xPT.pRU).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).init();
      }
      AppMethodBeat.o(200819);
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(200819);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.g
 * JD-Core Version:    0.7.0.1
 */