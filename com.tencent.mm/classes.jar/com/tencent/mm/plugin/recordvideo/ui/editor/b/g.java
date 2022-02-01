package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "retrieverData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;)V", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "finalBitmap", "finalCanvas", "finalMatrix", "paint", "Landroid/graphics/Paint;", "retrieverTransform", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "blurBgEnable", "", "calcCenterCropScale", "drawingWidth", "drawingHeight", "videoWidth", "", "videoHeight", "calcCenterCropScale2", "calcfinalScale", "drawWidth", "drawHeight", "destroy", "", "requestBlurBgFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "requestNextFrame", "start", "Companion", "plugin-recordvideo_release"})
public final class g
  implements b
{
  public static final g.a CgL;
  private Bitmap CgG;
  private Canvas CgH;
  private final Matrix CgI;
  private e CgJ;
  private final d CgK;
  private final Canvas aTi;
  private final Bitmap bitmap;
  private final Matrix finalMatrix;
  public Bitmap ikc;
  private final Paint paint;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b rpA;
  
  static
  {
    AppMethodBeat.i(237921);
    CgL = new g.a((byte)0);
    AppMethodBeat.o(237921);
  }
  
  public g(d paramd)
  {
    AppMethodBeat.i(237920);
    this.CgK = paramd;
    this.paint = new Paint();
    this.finalMatrix = new Matrix();
    this.rpA = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.CgK.rpx);
    this.CgI = new Matrix();
    this.CgJ = new e();
    Log.i("MicroMsg.StoryFrameRetriever", "create StoryFrameRetriever, " + this.CgK);
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    int m = this.CgK.width;
    int k = this.CgK.height;
    int i;
    Object localObject;
    float[] arrayOfFloat;
    int j;
    label243:
    float f1;
    switch (this.CgK.dYT)
    {
    default: 
      if (this.CgK.videoWidth > this.CgK.videoHeight)
      {
        i = 1;
        paramd = this.CgJ;
        localObject = this.CgK.BKV;
        arrayOfFloat = this.CgK.BKW;
        p.h(localObject, "drawingRect");
        paramd.BKV = ((float[])localObject);
        if ((arrayOfFloat != null) && (arrayOfFloat.length == 4)) {
          break label829;
        }
        j = 0;
        if (j != 0)
        {
          if (arrayOfFloat == null) {
            p.hyc();
          }
          paramd.BKW = arrayOfFloat;
          f1 = arrayOfFloat[1];
          Log.i("MicroMsg.RetrieverTransform", "topOffset :".concat(String.valueOf(f1)));
          paramd.CgD.postTranslate(0.0F, -f1);
        }
        if (!eMw()) {
          break label961;
        }
        paramd = Bitmap.createBitmap(this.CgK.width, this.CgK.height, Bitmap.Config.ARGB_8888);
        p.g(paramd, "Bitmap.createBitmap(retr… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        f1 = a(this.CgK.width, this.CgK.height, this.CgK.BKV[2], this.CgK.BKV[3]);
        Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
        this.CgI.postScale(f1, f1);
        if ((this.CgK.CgB) && (i != 0) && ((this.CgK.dYT == 90) || (this.CgK.dYT == 270) || (this.CgK.dYT == 180)))
        {
          this.CgG = Bitmap.createBitmap(this.CgK.height, this.CgK.width, Bitmap.Config.ARGB_8888);
          paramd = this.CgG;
          if (paramd == null) {
            p.hyc();
          }
          this.CgH = new Canvas(paramd);
          f1 = 360.0F - this.CgK.dYT;
          this.finalMatrix.postRotate(f1);
          if (f1 != 90.0F) {
            break label877;
          }
          paramd = this.finalMatrix;
          localObject = this.CgH;
          if (localObject == null) {
            p.hyc();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        label552:
        paramd = BitmapUtil.extractThumbNail(this.CgK.BLa, this.CgK.height, this.CgK.width, true);
        if (paramd != null)
        {
          f1 = this.CgK.width / paramd.getWidth();
          float f2 = this.CgK.height / paramd.getHeight();
          if ((f1 == 1.0F) && (f2 == 1.0F)) {
            break label953;
          }
          float f3 = Math.max(f1, f2);
          paramd = BitmapUtil.rotateAndScale(paramd, 0.0F, f3, f3);
          p.g(paramd, "scaledBitmap");
          k = paramd.getWidth();
          i = paramd.getHeight();
          if (f1 >= f2) {
            break label919;
          }
          m = (paramd.getWidth() - this.CgK.width) / 2;
          k = m + this.CgK.width;
          j = 0;
          label697:
          this.ikc = Bitmap.createBitmap(paramd, m, j, k, i);
          label713:
          if ((this.CgK.CgB) && (this.CgK.dYT != 0)) {
            this.ikc = BitmapUtil.rotate(this.ikc, 360.0F - this.CgK.dYT);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.aTi = new Canvas(this.bitmap);
      AppMethodBeat.o(237920);
      return;
      k = this.CgK.width;
      m = this.CgK.height;
      if (this.CgK.videoHeight > this.CgK.videoWidth)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
      break;
      label829:
      if ((arrayOfFloat[0] == 0.0F) && (arrayOfFloat[1] == 0.0F) && (arrayOfFloat[2] == 0.0F) && (arrayOfFloat[3] == 0.0F))
      {
        j = 0;
        break label243;
      }
      j = 1;
      break label243;
      label877:
      if (f1 != 270.0F) {
        break label552;
      }
      paramd = this.finalMatrix;
      localObject = this.CgH;
      if (localObject == null) {
        p.hyc();
      }
      paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
      break label552;
      label919:
      j = (paramd.getHeight() - this.CgK.height) / 2;
      i = this.CgK.height + j;
      m = 0;
      break label697;
      label953:
      this.ikc = paramd;
      break label713;
      label961:
      if (this.CgK.CgB)
      {
        paramd = Bitmap.createBitmap(m, k, Bitmap.Config.ARGB_8888);
        p.g(paramd, "Bitmap.createBitmap(real… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        if ((this.CgK.dYT == 90) || (this.CgK.dYT == 270) || (this.CgK.dYT == 180))
        {
          this.CgG = Bitmap.createBitmap(this.CgK.width, this.CgK.height, Bitmap.Config.ARGB_8888);
          paramd = this.CgG;
          if (paramd == null) {
            p.hyc();
          }
          this.CgH = new Canvas(paramd);
          f1 = 360.0F - this.CgK.dYT;
          this.finalMatrix.postRotate(f1);
          if (f1 != 90.0F) {
            break label1193;
          }
          paramd = this.finalMatrix;
          localObject = this.CgH;
          if (localObject == null) {
            p.hyc();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        for (;;)
        {
          f1 = a(m, k, this.CgK.BKV[2], this.CgK.BKV[3]);
          Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
          this.CgI.postScale(f1, f1);
          break;
          if (f1 == 270.0F)
          {
            paramd = this.finalMatrix;
            localObject = this.CgH;
            if (localObject == null) {
              p.hyc();
            }
            paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
          }
        }
      }
      label1193:
      paramd = Bitmap.createBitmap(Math.min(this.CgK.width, this.CgK.height), Math.max(this.CgK.width, this.CgK.height), Bitmap.Config.ARGB_8888);
      p.g(paramd, "Bitmap.createBitmap(Math… Bitmap.Config.ARGB_8888)");
      this.bitmap = paramd;
      f1 = a(Math.min(this.CgK.width, this.CgK.height), Math.max(this.CgK.width, this.CgK.height), this.CgK.BKV[2], this.CgK.BKV[3]);
      Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
      this.CgI.postScale(f1, f1);
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
  
  public final a cJu()
  {
    AppMethodBeat.i(237917);
    if (this.CgK.rpx.size() == 0)
    {
      AppMethodBeat.o(237917);
      return null;
    }
    int i = this.aTi.save();
    this.aTi.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aTi.concat(this.CgI);
    Object localObject = this.CgJ;
    Canvas localCanvas = this.aTi;
    p.h(localCanvas, "canvas");
    ((e)localObject).CgC = localCanvas.save();
    localCanvas.concat(((e)localObject).CgD);
    try
    {
      l = this.rpA.a(this.aTi, this.paint);
      localObject = this.CgJ;
      localCanvas = this.aTi;
      p.h(localCanvas, "canvas");
      if (((e)localObject).CgC <= 0)
      {
        Log.w("MicroMsg.RetrieverTransform", "canvas restore saveCount: " + ((e)localObject).CgC);
        if (i > 0) {
          break label340;
        }
        Log.w("MicroMsg.StoryFrameRetriever", "canvas restore saveCount: ".concat(String.valueOf(i)));
        if ((this.CgH == null) || (this.CgG == null)) {
          break label351;
        }
        localObject = this.CgH;
        if (localObject != null) {
          ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        localObject = this.CgH;
        if (localObject != null) {
          ((Canvas)localObject).save();
        }
        localObject = this.CgH;
        if (localObject == null) {
          p.hyc();
        }
        ((Canvas)localObject).drawBitmap(this.bitmap, this.finalMatrix, null);
        localObject = this.CgH;
        if (localObject != null) {
          ((Canvas)localObject).restore();
        }
        localObject = this.CgG;
        if (localObject == null) {
          p.hyc();
        }
        localObject = new a((Bitmap)localObject, l);
        AppMethodBeat.o(237917);
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
        localCanvas.restoreToCount(localException.CgC);
        continue;
        label340:
        this.aTi.restoreToCount(i);
      }
      label351:
      a locala = new a(this.bitmap, l);
      AppMethodBeat.o(237917);
      return locala;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(237919);
    try
    {
      Iterator localIterator = ((Iterable)this.CgK.rpx).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(237919);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(237919);
      return;
    }
  }
  
  public final boolean eMw()
  {
    AppMethodBeat.i(237916);
    if (((CharSequence)this.CgK.BLa).length() > 0) {}
    for (int i = 1; (i != 0) && (s.YS(this.CgK.BLa)); i = 0)
    {
      AppMethodBeat.o(237916);
      return true;
    }
    AppMethodBeat.o(237916);
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(237918);
    try
    {
      Iterator localIterator = ((Iterable)this.CgK.rpx).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).init();
      }
      AppMethodBeat.o(237918);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(237918);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.g
 * JD-Core Version:    0.7.0.1
 */