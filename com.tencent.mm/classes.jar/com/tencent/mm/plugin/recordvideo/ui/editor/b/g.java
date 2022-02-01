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
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "retrieverData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;)V", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "finalBitmap", "finalCanvas", "finalMatrix", "paint", "Landroid/graphics/Paint;", "retrieverTransform", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "blurBgEnable", "", "calcCenterCropScale", "drawingWidth", "drawingHeight", "videoWidth", "", "videoHeight", "calcCenterCropScale2", "calcfinalScale", "drawWidth", "drawHeight", "destroy", "", "requestBlurBgFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "requestNextFrame", "start", "Companion", "plugin-recordvideo_release"})
public final class g
  implements b
{
  public static final a IdB;
  private final d IdA;
  private Bitmap Idw;
  private Canvas Idx;
  private final Matrix Idy;
  private e Idz;
  private final Canvas aBC;
  private final Bitmap bitmap;
  private final Matrix finalMatrix;
  public Bitmap kYW;
  private final Paint paint;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b uVg;
  
  static
  {
    AppMethodBeat.i(216894);
    IdB = new a((byte)0);
    AppMethodBeat.o(216894);
  }
  
  public g(d paramd)
  {
    AppMethodBeat.i(216893);
    this.IdA = paramd;
    this.paint = new Paint();
    this.finalMatrix = new Matrix();
    this.uVg = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.IdA.uVd);
    this.Idy = new Matrix();
    this.Idz = new e();
    Log.i("MicroMsg.StoryFrameRetriever", "create StoryFrameRetriever, " + this.IdA);
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    int m = this.IdA.width;
    int k = this.IdA.height;
    int i;
    Object localObject;
    float[] arrayOfFloat;
    int j;
    label243:
    float f1;
    switch (this.IdA.fSM)
    {
    default: 
      if (this.IdA.videoWidth > this.IdA.videoHeight)
      {
        i = 1;
        paramd = this.Idz;
        localObject = this.IdA.HHg;
        arrayOfFloat = this.IdA.HHh;
        p.k(localObject, "drawingRect");
        paramd.HHg = ((float[])localObject);
        if ((arrayOfFloat != null) && (arrayOfFloat.length == 4)) {
          break label829;
        }
        j = 0;
        if (j != 0)
        {
          if (arrayOfFloat == null) {
            p.iCn();
          }
          paramd.HHh = arrayOfFloat;
          f1 = arrayOfFloat[1];
          Log.i("MicroMsg.RetrieverTransform", "topOffset :".concat(String.valueOf(f1)));
          paramd.Idt.postTranslate(0.0F, -f1);
        }
        if (!fzh()) {
          break label961;
        }
        paramd = Bitmap.createBitmap(this.IdA.width, this.IdA.height, Bitmap.Config.ARGB_8888);
        p.j(paramd, "Bitmap.createBitmap(retr… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        f1 = a(this.IdA.width, this.IdA.height, this.IdA.HHg[2], this.IdA.HHg[3]);
        Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
        this.Idy.postScale(f1, f1);
        if ((this.IdA.Idr) && (i != 0) && ((this.IdA.fSM == 90) || (this.IdA.fSM == 270) || (this.IdA.fSM == 180)))
        {
          this.Idw = Bitmap.createBitmap(this.IdA.height, this.IdA.width, Bitmap.Config.ARGB_8888);
          paramd = this.Idw;
          if (paramd == null) {
            p.iCn();
          }
          this.Idx = new Canvas(paramd);
          f1 = 360.0F - this.IdA.fSM;
          this.finalMatrix.postRotate(f1);
          if (f1 != 90.0F) {
            break label877;
          }
          paramd = this.finalMatrix;
          localObject = this.Idx;
          if (localObject == null) {
            p.iCn();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        label552:
        paramd = BitmapUtil.extractThumbNail(this.IdA.HHl, this.IdA.height, this.IdA.width, true);
        if (paramd != null)
        {
          f1 = this.IdA.width / paramd.getWidth();
          float f2 = this.IdA.height / paramd.getHeight();
          if ((f1 == 1.0F) && (f2 == 1.0F)) {
            break label953;
          }
          float f3 = Math.max(f1, f2);
          paramd = BitmapUtil.rotateAndScale(paramd, 0.0F, f3, f3);
          p.j(paramd, "scaledBitmap");
          k = paramd.getWidth();
          i = paramd.getHeight();
          if (f1 >= f2) {
            break label919;
          }
          m = (paramd.getWidth() - this.IdA.width) / 2;
          k = m + this.IdA.width;
          j = 0;
          label697:
          this.kYW = Bitmap.createBitmap(paramd, m, j, k, i);
          label713:
          if ((this.IdA.Idr) && (this.IdA.fSM != 0)) {
            this.kYW = BitmapUtil.rotate(this.kYW, 360.0F - this.IdA.fSM);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.aBC = new Canvas(this.bitmap);
      AppMethodBeat.o(216893);
      return;
      k = this.IdA.width;
      m = this.IdA.height;
      if (this.IdA.videoHeight > this.IdA.videoWidth)
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
      localObject = this.Idx;
      if (localObject == null) {
        p.iCn();
      }
      paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
      break label552;
      label919:
      j = (paramd.getHeight() - this.IdA.height) / 2;
      i = this.IdA.height + j;
      m = 0;
      break label697;
      label953:
      this.kYW = paramd;
      break label713;
      label961:
      if (this.IdA.Idr)
      {
        paramd = Bitmap.createBitmap(m, k, Bitmap.Config.ARGB_8888);
        p.j(paramd, "Bitmap.createBitmap(real… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        if ((this.IdA.fSM == 90) || (this.IdA.fSM == 270) || (this.IdA.fSM == 180))
        {
          this.Idw = Bitmap.createBitmap(this.IdA.width, this.IdA.height, Bitmap.Config.ARGB_8888);
          paramd = this.Idw;
          if (paramd == null) {
            p.iCn();
          }
          this.Idx = new Canvas(paramd);
          f1 = 360.0F - this.IdA.fSM;
          this.finalMatrix.postRotate(f1);
          if (f1 != 90.0F) {
            break label1193;
          }
          paramd = this.finalMatrix;
          localObject = this.Idx;
          if (localObject == null) {
            p.iCn();
          }
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        for (;;)
        {
          f1 = a(m, k, this.IdA.HHg[2], this.IdA.HHg[3]);
          Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
          this.Idy.postScale(f1, f1);
          break;
          if (f1 == 270.0F)
          {
            paramd = this.finalMatrix;
            localObject = this.Idx;
            if (localObject == null) {
              p.iCn();
            }
            paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
          }
        }
      }
      label1193:
      paramd = Bitmap.createBitmap(Math.min(this.IdA.width, this.IdA.height), Math.max(this.IdA.width, this.IdA.height), Bitmap.Config.ARGB_8888);
      p.j(paramd, "Bitmap.createBitmap(Math… Bitmap.Config.ARGB_8888)");
      this.bitmap = paramd;
      f1 = a(Math.min(this.IdA.width, this.IdA.height), Math.max(this.IdA.width, this.IdA.height), this.IdA.HHg[2], this.IdA.HHg[3]);
      Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
      this.Idy.postScale(f1, f1);
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
  
  public final a cYc()
  {
    AppMethodBeat.i(216874);
    if (this.IdA.uVd.size() == 0)
    {
      AppMethodBeat.o(216874);
      return null;
    }
    int i = this.aBC.save();
    this.aBC.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aBC.concat(this.Idy);
    Object localObject = this.Idz;
    Canvas localCanvas = this.aBC;
    p.k(localCanvas, "canvas");
    ((e)localObject).Ids = localCanvas.save();
    localCanvas.concat(((e)localObject).Idt);
    try
    {
      l = this.uVg.a(this.aBC, this.paint);
      localObject = this.Idz;
      localCanvas = this.aBC;
      p.k(localCanvas, "canvas");
      if (((e)localObject).Ids <= 0)
      {
        Log.w("MicroMsg.RetrieverTransform", "canvas restore saveCount: " + ((e)localObject).Ids);
        if (i > 0) {
          break label340;
        }
        Log.w("MicroMsg.StoryFrameRetriever", "canvas restore saveCount: ".concat(String.valueOf(i)));
        if ((this.Idx == null) || (this.Idw == null)) {
          break label351;
        }
        localObject = this.Idx;
        if (localObject != null) {
          ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        localObject = this.Idx;
        if (localObject != null) {
          ((Canvas)localObject).save();
        }
        localObject = this.Idx;
        if (localObject == null) {
          p.iCn();
        }
        ((Canvas)localObject).drawBitmap(this.bitmap, this.finalMatrix, null);
        localObject = this.Idx;
        if (localObject != null) {
          ((Canvas)localObject).restore();
        }
        localObject = this.Idw;
        if (localObject == null) {
          p.iCn();
        }
        localObject = new a((Bitmap)localObject, l);
        AppMethodBeat.o(216874);
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
        localCanvas.restoreToCount(localException.Ids);
        continue;
        label340:
        this.aBC.restoreToCount(i);
      }
      label351:
      a locala = new a(this.bitmap, l);
      AppMethodBeat.o(216874);
      return locala;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(216880);
    try
    {
      Iterator localIterator = ((Iterable)this.IdA.uVd).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(216880);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(216880);
      return;
    }
  }
  
  public final boolean fzh()
  {
    AppMethodBeat.i(216870);
    if (((CharSequence)this.IdA.HHl).length() > 0) {}
    for (int i = 1; (i != 0) && (u.agG(this.IdA.HHl)); i = 0)
    {
      AppMethodBeat.o(216870);
      return true;
    }
    AppMethodBeat.o(216870);
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(216877);
    try
    {
      Iterator localIterator = ((Iterable)this.IdA.uVd).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).init();
      }
      AppMethodBeat.o(216877);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(216877);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.g
 * JD-Core Version:    0.7.0.1
 */